package ib0;

import android.opengl.GLES20;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends a {
    public float a;
    public float b;

    @Override // ib0.a, ib0.d
    public final String a() {
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\n  uniform highp float left;\n  uniform highp float top;\n  uniform highp float right;\n  uniform highp float bottom;\nvoid main() {\nif( vTextureCoord.x > left &&  vTextureCoord.x < right &&  vTextureCoord.y > top &&  vTextureCoord.y < bottom) { gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n} else { gl_FragColor = vec4(0, 0, 0, 0);\n}}\n";
    }

    public b() {
        this.a = 0.0f;
        this.b = 1.0f;
    }

    @Override // ib0.a, ib0.d
    public final void c(fb0.a r2) {
        float r3 = r2.c() / r2.e;
        this.b *= r3;
        this.a *= r3;
    }

    @Override // ib0.a, ib0.d
    public final void e(int r3) {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r3, "left"), this.a);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r3, "top"), 0.0f);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r3, "right"), this.b);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(r3, "bottom"), 1.0f);
    }
}
