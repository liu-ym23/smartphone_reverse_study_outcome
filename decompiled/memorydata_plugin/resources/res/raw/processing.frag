#version 300 es
precision highp float;

uniform float uTime;
uniform vec2 uResolution;
uniform float uAlpha;
uniform float uRadius;

uniform bool uTextureEnabled;
uniform sampler2D uTexture;

uniform bool uDotsEnabled;
uniform float uDotsAlpha;
uniform float uDotsGridSize;
uniform float uDotsSize;
uniform float uDotsSpeed;
uniform float uDotsMovement;

uniform float uNoiseSize;
uniform float uNoiseSpeed;
uniform bool uSurfaceEffectEnabled;
uniform float uSurfaceEffectAlpha;
uniform bool uEdgeEffectEnabled;
uniform float uEdgeEffectAlpha;
uniform float uEdgeWidth;

uniform vec2 uMaskCenter;
uniform float uMaskEdge;
uniform float uMaskEnterSize;
uniform float uMaskExitSize;

// utils
float blendAdd(in float base, in float blend) {
    return min(base + blend, 1.);
}

vec4 blendAdd(in vec4 base, in vec4 blend) {
    return vec4(blendAdd(base.r, blend.r), blendAdd(base.g, blend.g), blendAdd(base.b, blend.b), blendAdd(base.a, blend.a));
}

vec3 mod289(vec3 x) {
    return x - floor(x * (1.0 / 289.0)) * 289.0;
}

vec4 mod289(vec4 x) {
    return x - floor(x * (1.0 / 289.0)) * 289.0;
}

vec4 permute(vec4 x) {
    return mod289(((x * 34.0) + 10.0) * x);
}

vec4 taylorInvSqrt(vec4 r) {
    return 1.79284291400159 - 0.85373472095314 * r;
}

float snoise(vec3 v) {
    const vec2 C = vec2(1.0 / 6.0, 1.0 / 3.0);
    const vec4 D = vec4(0.0, 0.5, 1.0, 2.0);

    vec3 i = floor(v + dot(v, C.yyy));
    vec3 x0 = v - i + dot(i, C.xxx);

    vec3 g = step(x0.yzx, x0.xyz);
    vec3 l = 1.0 - g;
    vec3 i1 = min(g.xyz, l.zxy);
    vec3 i2 = max(g.xyz, l.zxy);

    vec3 x1 = x0 - i1 + C.xxx;
    vec3 x2 = x0 - i2 + C.yyy; // 2.0*C.x = 1/3 = C.y
    vec3 x3 = x0 - D.yyy;      // -1.0+3.0*C.x = -0.5 = -D.y

    i = mod289(i);
    vec4 p = permute(permute(permute(i.z + vec4(0.0, i1.z, i2.z, 1.0)) + i.y + vec4(0.0, i1.y, i2.y, 1.0)) + i.x + vec4(0.0, i1.x, i2.x, 1.0));

    float n_ = 0.142857142857; // 1.0/7.0
    vec3 ns = n_ * D.wyz - D.xzx;

    vec4 j = p - 49.0 * floor(p * ns.z * ns.z);  //  mod(p,7*7)

    vec4 x_ = floor(j * ns.z);
    vec4 y_ = floor(j - 7.0 * x_);    // mod(j,N)

    vec4 x = x_ * ns.x + ns.yyyy;
    vec4 y = y_ * ns.x + ns.yyyy;
    vec4 h = 1.0 - abs(x) - abs(y);

    vec4 b0 = vec4(x.xy, y.xy);
    vec4 b1 = vec4(x.zw, y.zw);

    vec4 s0 = floor(b0) * 2.0 + 1.0;
    vec4 s1 = floor(b1) * 2.0 + 1.0;
    vec4 sh = -step(h, vec4(0.0));

    vec4 a0 = b0.xzyw + s0.xzyw * sh.xxyy;
    vec4 a1 = b1.xzyw + s1.xzyw * sh.zzww;

    vec3 p0 = vec3(a0.xy, h.x);
    vec3 p1 = vec3(a0.zw, h.y);
    vec3 p2 = vec3(a1.xy, h.z);
    vec3 p3 = vec3(a1.zw, h.w);

    vec4 norm = taylorInvSqrt(vec4(dot(p0, p0), dot(p1, p1), dot(p2, p2), dot(p3, p3)));
    p0 *= norm.x;
    p1 *= norm.y;
    p2 *= norm.z;
    p3 *= norm.w;

    vec4 m = max(0.5 - vec4(dot(x0, x0), dot(x1, x1), dot(x2, x2), dot(x3, x3)), 0.0);
    m = m * m;
    return 105.0 * dot(m * m, vec4(dot(p0, x0), dot(p1, x1), dot(p2, x2), dot(p3, x3)));
}

#define FBM_OCTAVES 2
#define FBM_VALUE_INITIAL 0.0
#define FBM_FREQUENCY_INITIAL 1.0
#define FBM_AMPLITUD_INITIAL 1.0
#define FBM_LACUNARITY 0.2
#define FBM_GAIN 0.2

float fbm(vec3 pos) {
    float value = FBM_VALUE_INITIAL;
    float frequency = FBM_FREQUENCY_INITIAL;
    float amplitud = FBM_AMPLITUD_INITIAL;

    for(int i = 0; i < FBM_OCTAVES; i++) {
        value += amplitud * snoise(pos * frequency);
        frequency *= FBM_LACUNARITY;
        amplitud *= FBM_GAIN;
    }

    return value;
}

#define clamp01(V) clamp(V, 0.0, 1.0)

float aastep(float threshold, float value) {
    float afwidth = 0.7 * length(vec2(dFdx(value), dFdy(value)));
    return smoothstep(threshold - afwidth, threshold + afwidth, value);
}

float fill(float x) {
    return 1.0 - aastep(0.0, x);
}

float ease(float t) {
    return t * t * t;
}

float stroke(float x, float size, float w, float edge) {
    float t1 = smoothstep(size - edge, size + edge, x + w * 0.5);
    float t2 = smoothstep(size - edge, size + edge, x - w * 0.5);
    t1 = ease(t1);
    t2 = ease(t2);
    float d = t1 - t2;
    return clamp01(d);
}

float coordRect(float r) {
    vec2 d = abs(gl_FragCoord.xy - uResolution * 0.5) - uResolution * 0.5 + r;
    return min(max(d.x, d.y), 0.0) + length(max(d, 0.0)) - r;
}

float circle(vec2 uv, vec2 center, float size, float edge) {
    float x = length(uv - center) * 2.0;
    float d = 1.0 - smoothstep(size - edge, size + edge, x);
    return clamp01(d);
}

vec4 dotsMatrix() {
    vec2 gridPosition = gl_FragCoord.xy / uDotsGridSize;

    vec2 cellUV = fract(gridPosition);

    vec2 cellIndex = floor(gridPosition);
    vec3 noiseInput = vec3(cellIndex, uTime * uDotsSpeed);
    vec2 movement = vec2(snoise(noiseInput), snoise(noiseInput + vec3(1000.0)));
    vec2 dotCenter = vec2(0.5) + movement * uDotsMovement;

    float dotSize = (uDotsSize / uDotsGridSize) * (0.5 + movement.x * 0.5);
    float dot = circle(cellUV, dotCenter, dotSize, 0.1);
    return vec4(dot) * uDotsAlpha;
}

#define NOISE_COLOR_0 vec3(1.0, 0.863, 1.0)  
#define NOISE_COLOR_1 vec3(0.953, 0.741, 1.0)
#define NOISE_COLOR_2 vec3(1.0, 0.784, 0.847)

vec3 gradientMap(float value) {
    if(value < 0.5) {
        float t = smoothstep(0.0, 0.5, value);
        return mix(NOISE_COLOR_0, NOISE_COLOR_1, t);
    } else {
        float t = smoothstep(0.5, 1.0, value);
        return mix(NOISE_COLOR_1, NOISE_COLOR_2, t);
    }
}

out vec4 fragColor;

void main() {
    float shape = coordRect(uRadius);

    vec4 color = vec4(0.0);

    float enterMask = circle(gl_FragCoord.xy, uMaskCenter, uMaskEnterSize, uMaskEdge);

    if(uDotsEnabled) {
        color = blendAdd(color, dotsMatrix());
        color *= enterMask;
    }

    if(uSurfaceEffectEnabled || uEdgeEffectEnabled) {
        float noiseShape = fbm(vec3(gl_FragCoord.xy / uNoiseSize, uTime * uNoiseSpeed));
        vec3 noiseGradient = gradientMap(noiseShape);

        if(uSurfaceEffectEnabled) {
            vec4 surfaceEffect = vec4(noiseGradient, 1.0) * uSurfaceEffectAlpha;
            color = blendAdd(color, surfaceEffect);
            float exitMask = circle(gl_FragCoord.xy, uMaskCenter, uMaskExitSize, uMaskEdge);
            color *= (enterMask - exitMask);
        }

        if(uEdgeEffectEnabled) {
            float edgeShape = stroke(shape, 0.0, uEdgeWidth, uEdgeWidth);
            edgeShape += stroke(shape, 0.0, uEdgeWidth * 0.4, uEdgeWidth);
            edgeShape += stroke(shape, 0.0, uEdgeWidth * 0.1, uEdgeWidth);
            vec4 edgeEffect = vec4(noiseGradient * edgeShape, edgeShape) * uEdgeEffectAlpha;
            color = blendAdd(color, edgeEffect) * enterMask;
        }
    }



    color = color * fill(shape) * uAlpha;

    fragColor = color;
}