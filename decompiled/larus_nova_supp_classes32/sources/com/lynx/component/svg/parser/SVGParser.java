package com.lynx.component.svg.parser;

import android.graphics.Matrix;
import android.util.Xml;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.n;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SVGParser {
    public SVG a;
    public SVG.c0 b;
    public boolean c;
    public int d;

    public static final enum SVGAttr extends Enum<SVGAttr> {
        public static final SVGAttr UNSUPPORTED = null;
        public static final Map<String, SVGAttr> a = null;
        public static final /* synthetic */ SVGAttr[] b = null;
        public static final SVGAttr clip = null;
        public static final SVGAttr clipPathUnits = null;
        public static final SVGAttr clip_path = null;
        public static final SVGAttr clip_rule = null;
        public static final SVGAttr color = null;
        public static final SVGAttr cx = null;
        public static final SVGAttr cy = null;
        public static final SVGAttr d = null;
        public static final SVGAttr direction = null;
        public static final SVGAttr display = null;
        public static final SVGAttr dx = null;
        public static final SVGAttr dy = null;
        public static final SVGAttr fill = null;
        public static final SVGAttr fill_opacity = null;
        public static final SVGAttr fill_rule = null;
        public static final SVGAttr fx = null;
        public static final SVGAttr fy = null;
        public static final SVGAttr gradientTransform = null;
        public static final SVGAttr gradientUnits = null;
        public static final SVGAttr height = null;
        public static final SVGAttr href = null;
        public static final SVGAttr image_rendering = null;
        public static final SVGAttr offset = null;
        public static final SVGAttr opacity = null;
        public static final SVGAttr orient = null;
        public static final SVGAttr overflow = null;
        public static final SVGAttr pathLength = null;
        public static final SVGAttr patternContentUnits = null;
        public static final SVGAttr patternTransform = null;
        public static final SVGAttr patternUnits = null;
        public static final SVGAttr points = null;
        public static final SVGAttr preserveAspectRatio = null;
        public static final SVGAttr r = null;
        public static final SVGAttr refX = null;
        public static final SVGAttr refY = null;
        public static final SVGAttr rx = null;
        public static final SVGAttr ry = null;
        public static final SVGAttr solid_color = null;
        public static final SVGAttr solid_opacity = null;
        public static final SVGAttr spreadMethod = null;
        public static final SVGAttr startOffset = null;
        public static final SVGAttr stop_color = null;
        public static final SVGAttr stop_opacity = null;
        public static final SVGAttr stroke = null;
        public static final SVGAttr stroke_dasharray = null;
        public static final SVGAttr stroke_dashoffset = null;
        public static final SVGAttr stroke_linecap = null;
        public static final SVGAttr stroke_linejoin = null;
        public static final SVGAttr stroke_miterlimit = null;
        public static final SVGAttr stroke_opacity = null;
        public static final SVGAttr stroke_width = null;
        public static final SVGAttr style = null;
        public static final SVGAttr transform = null;
        public static final SVGAttr type = null;
        public static final SVGAttr vector_effect = null;
        public static final SVGAttr version = null;
        public static final SVGAttr viewBox = null;
        public static final SVGAttr viewport_fill = null;
        public static final SVGAttr viewport_fill_opacity = null;
        public static final SVGAttr visibility = null;
        public static final SVGAttr width = null;
        public static final SVGAttr x = null;
        public static final SVGAttr x1 = null;
        public static final SVGAttr x2 = null;
        public static final SVGAttr y = null;
        public static final SVGAttr y1 = null;
        public static final SVGAttr y2 = null;

        static {
            SVGAttr r0 = new SVGAttr("clip", 0);
            clip = r0;
            SVGAttr r1 = new SVGAttr("clip_path", 1);
            clip_path = r1;
            SVGAttr r3 = new SVGAttr("clipPathUnits", 2);
            clipPathUnits = r3;
            SVGAttr r5 = new SVGAttr("clip_rule", 3);
            clip_rule = r5;
            SVGAttr r7 = new SVGAttr("color", 4);
            color = r7;
            SVGAttr r9 = new SVGAttr("cx", 5);
            cx = r9;
            SVGAttr r11 = new SVGAttr("cy", 6);
            cy = r11;
            SVGAttr r13 = new SVGAttr("direction", 7);
            direction = r13;
            SVGAttr r15 = new SVGAttr("dx", 8);
            dx = r15;
            SVGAttr r14 = new SVGAttr("dy", 9);
            dy = r14;
            SVGAttr r12 = new SVGAttr("fx", 10);
            fx = r12;
            SVGAttr r10 = new SVGAttr("fy", 11);
            fy = r10;
            SVGAttr r8 = new SVGAttr("d", 12);
            d = r8;
            SVGAttr r6 = new SVGAttr("display", 13);
            display = r6;
            SVGAttr r4 = new SVGAttr("fill", 14);
            fill = r4;
            SVGAttr r2 = new SVGAttr("fill_rule", 15);
            fill_rule = r2;
            SVGAttr r16 = new SVGAttr("fill_opacity", 16);
            fill_opacity = r16;
            SVGAttr r17 = new SVGAttr("gradientTransform", 17);
            gradientTransform = r17;
            SVGAttr r18 = new SVGAttr("gradientUnits", 18);
            gradientUnits = r18;
            SVGAttr r19 = new SVGAttr("height", 19);
            height = r19;
            SVGAttr r20 = new SVGAttr("href", 20);
            href = r20;
            SVGAttr r21 = new SVGAttr("image_rendering", 21);
            image_rendering = r21;
            SVGAttr r22 = new SVGAttr("offset", 22);
            offset = r22;
            SVGAttr r23 = new SVGAttr("opacity", 23);
            opacity = r23;
            SVGAttr r24 = new SVGAttr("orient", 24);
            orient = r24;
            SVGAttr r25 = new SVGAttr("overflow", 25);
            overflow = r25;
            SVGAttr r26 = new SVGAttr("pathLength", 26);
            pathLength = r26;
            SVGAttr r27 = new SVGAttr("patternContentUnits", 27);
            patternContentUnits = r27;
            SVGAttr r28 = new SVGAttr("patternTransform", 28);
            patternTransform = r28;
            SVGAttr r29 = new SVGAttr("patternUnits", 29);
            patternUnits = r29;
            SVGAttr r30 = new SVGAttr("points", 30);
            points = r30;
            SVGAttr r31 = new SVGAttr("preserveAspectRatio", 31);
            preserveAspectRatio = r31;
            SVGAttr r32 = new SVGAttr("r", 32);
            r = r32;
            SVGAttr r33 = new SVGAttr("refX", 33);
            refX = r33;
            SVGAttr r34 = new SVGAttr("refY", 34);
            refY = r34;
            SVGAttr r35 = new SVGAttr("rx", 35);
            rx = r35;
            SVGAttr r36 = new SVGAttr("ry", 36);
            ry = r36;
            SVGAttr r37 = new SVGAttr("solid_color", 37);
            solid_color = r37;
            SVGAttr r38 = new SVGAttr("solid_opacity", 38);
            solid_opacity = r38;
            SVGAttr r39 = new SVGAttr("spreadMethod", 39);
            spreadMethod = r39;
            SVGAttr r40 = new SVGAttr("startOffset", 40);
            startOffset = r40;
            SVGAttr r41 = new SVGAttr("stop_color", 41);
            stop_color = r41;
            SVGAttr r42 = new SVGAttr("stop_opacity", 42);
            stop_opacity = r42;
            SVGAttr r43 = new SVGAttr("stroke", 43);
            stroke = r43;
            SVGAttr r44 = new SVGAttr("stroke_dasharray", 44);
            stroke_dasharray = r44;
            SVGAttr r45 = new SVGAttr("stroke_dashoffset", 45);
            stroke_dashoffset = r45;
            SVGAttr r46 = new SVGAttr("stroke_linecap", 46);
            stroke_linecap = r46;
            SVGAttr r47 = new SVGAttr("stroke_linejoin", 47);
            stroke_linejoin = r47;
            SVGAttr r48 = new SVGAttr("stroke_miterlimit", 48);
            stroke_miterlimit = r48;
            SVGAttr r49 = new SVGAttr("stroke_opacity", 49);
            stroke_opacity = r49;
            SVGAttr r50 = new SVGAttr("stroke_width", 50);
            stroke_width = r50;
            SVGAttr r51 = new SVGAttr("style", 51);
            style = r51;
            SVGAttr r52 = new SVGAttr("transform", 52);
            transform = r52;
            SVGAttr r53 = new SVGAttr("type", 53);
            type = r53;
            SVGAttr r54 = new SVGAttr("vector_effect", 54);
            vector_effect = r54;
            SVGAttr r55 = new SVGAttr("version", 55);
            version = r55;
            SVGAttr r56 = new SVGAttr("viewBox", 56);
            viewBox = r56;
            SVGAttr r57 = new SVGAttr("width", 57);
            width = r57;
            SVGAttr r58 = new SVGAttr("x", 58);
            x = r58;
            SVGAttr r59 = new SVGAttr("y", 59);
            y = r59;
            SVGAttr r60 = new SVGAttr("x1", 60);
            x1 = r60;
            SVGAttr r61 = new SVGAttr("y1", 61);
            y1 = r61;
            SVGAttr r62 = new SVGAttr("x2", 62);
            x2 = r62;
            SVGAttr r63 = new SVGAttr("y2", 63);
            y2 = r63;
            SVGAttr r64 = new SVGAttr("viewport_fill", 64);
            viewport_fill = r64;
            SVGAttr r65 = new SVGAttr("viewport_fill_opacity", 65);
            viewport_fill_opacity = r65;
            SVGAttr r66 = new SVGAttr("visibility", 66);
            visibility = r66;
            SVGAttr r67 = new SVGAttr("UNSUPPORTED", 67);
            UNSUPPORTED = r67;
            b = new SVGAttr[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67};
            a = new HashMap();
            SVGAttr[] r68 = values();
            int r69 = r68.length;
            int r70 = 0;
        L3:
            if (r70 >= r69) goto L9;
            SVGAttr r71 = r68[r70];
            if (r71 == UNSUPPORTED) goto L8;
            a.put(r71.name().replace('_', '-'), r71);
        L8:
            r70 = r70 + 1;
            goto L3
        }

        public static SVGAttr[] values() {
            return (SVGAttr[]) b.clone();
        }

        public static SVGAttr fromString(String r1) {
            SVGAttr r2 = (SVGAttr) ((HashMap) a).get(r1);
            if (r2 == null) goto L6;
            return r2;
        L6:
            return UNSUPPORTED;
        }

        public static SVGAttr valueOf(String r1) {
            return (SVGAttr) r27.a.a(SVGAttr.class, r1);
        }

        public SVGAttr(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum SVGElem extends Enum<SVGElem> {
        public static final SVGElem UNSUPPORTED = null;
        public static final Map<String, SVGElem> a = null;
        public static final /* synthetic */ SVGElem[] b = null;
        public static final SVGElem circle = null;
        public static final SVGElem clipPath = null;
        public static final SVGElem defs = null;
        public static final SVGElem ellipse = null;
        public static final SVGElem g = null;
        public static final SVGElem image = null;
        public static final SVGElem line = null;
        public static final SVGElem linearGradient = null;
        public static final SVGElem path = null;
        public static final SVGElem pattern = null;
        public static final SVGElem polygon = null;
        public static final SVGElem polyline = null;
        public static final SVGElem radialGradient = null;
        public static final SVGElem rect = null;
        public static final SVGElem solidColor = null;
        public static final SVGElem stop = null;
        public static final SVGElem svg = null;
        public static final SVGElem use = null;

        static {
            SVGElem r0 = new SVGElem(SVGRenderEngine.SVG, 0);
            svg = r0;
            SVGElem r1 = new SVGElem(SVGRenderEngine.CIRCLE, 1);
            circle = r1;
            SVGElem r3 = new SVGElem(SVGRenderEngine.CLIP_PATH, 2);
            clipPath = r3;
            SVGElem r5 = new SVGElem("defs", 3);
            defs = r5;
            SVGElem r7 = new SVGElem(SVGRenderEngine.ELLIPSE, 4);
            ellipse = r7;
            SVGElem r9 = new SVGElem("g", 5);
            g = r9;
            SVGElem r11 = new SVGElem("image", 6);
            image = r11;
            SVGElem r13 = new SVGElem(SVGRenderEngine.LINE, 7);
            line = r13;
            SVGElem r15 = new SVGElem(SVGRenderEngine.LINEAR_GRADIENT, 8);
            linearGradient = r15;
            SVGElem r14 = new SVGElem(SVGRenderEngine.PATH, 9);
            path = r14;
            SVGElem r12 = new SVGElem("pattern", 10);
            pattern = r12;
            SVGElem r10 = new SVGElem(SVGRenderEngine.POLYGON, 11);
            polygon = r10;
            SVGElem r8 = new SVGElem(SVGRenderEngine.POLYLINE, 12);
            polyline = r8;
            SVGElem r6 = new SVGElem(SVGRenderEngine.RADIAL_GRADIENT, 13);
            radialGradient = r6;
            SVGElem r4 = new SVGElem(SVGRenderEngine.RECT, 14);
            rect = r4;
            SVGElem r2 = new SVGElem("solidColor", 15);
            solidColor = r2;
            SVGElem r16 = new SVGElem("stop", 16);
            stop = r16;
            SVGElem r17 = new SVGElem(NameKeys.LoadStrategy_Use, 17);
            use = r17;
            SVGElem r18 = new SVGElem("UNSUPPORTED", 18);
            UNSUPPORTED = r18;
            b = new SVGElem[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
            a = new HashMap();
            SVGElem[] r19 = values();
            int r20 = r19.length;
            int r21 = 0;
        L3:
            if (r21 >= r20) goto L8;
            SVGElem r22 = r19[r21];
            if (r22 == UNSUPPORTED) goto L7;
            a.put(r22.name(), r22);
        L7:
            r21 = r21 + 1;
            goto L3
        }

        public static SVGElem[] values() {
            return (SVGElem[]) b.clone();
        }

        public static SVGElem fromString(String r1) {
            SVGElem r2 = (SVGElem) ((HashMap) a).get(r1);
            if (r2 == null) goto L6;
            return r2;
        L6:
            return UNSUPPORTED;
        }

        public static SVGElem valueOf(String r1) {
            return (SVGElem) r27.a.a(SVGElem.class, r1);
        }

        public SVGElem(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SVGAttr.values().length];
            b = r0;
            r0[SVGAttr.x.ordinal()] = 1;     // Catch: NoSuchFieldError -> L97
        L196:
            b[SVGAttr.y.ordinal()] = 2;     // Catch: NoSuchFieldError -> L98
        L216:
            b[SVGAttr.width.ordinal()] = 3;     // Catch: NoSuchFieldError -> L99
        L228:
            b[SVGAttr.height.ordinal()] = 4;     // Catch: NoSuchFieldError -> L100
        L234:
            b[SVGAttr.version.ordinal()] = 5;     // Catch: NoSuchFieldError -> L101
        L256:
            b[SVGAttr.href.ordinal()] = 6;     // Catch: NoSuchFieldError -> L102
        L260:
            b[SVGAttr.preserveAspectRatio.ordinal()] = 7;     // Catch: NoSuchFieldError -> L103
        L286:
            b[SVGAttr.d.ordinal()] = 8;     // Catch: NoSuchFieldError -> L104
        L290:
            b[SVGAttr.pathLength.ordinal()] = 9;     // Catch: NoSuchFieldError -> L105
        L310:
            b[SVGAttr.rx.ordinal()] = 10;     // Catch: NoSuchFieldError -> L106
        L316:
            b[SVGAttr.ry.ordinal()] = 11;     // Catch: NoSuchFieldError -> L107
        L188:
            b[SVGAttr.cx.ordinal()] = 12;     // Catch: NoSuchFieldError -> L108
        L194:
            b[SVGAttr.cy.ordinal()] = 13;     // Catch: NoSuchFieldError -> L109
        L214:
            b[SVGAttr.r.ordinal()] = 14;     // Catch: NoSuchFieldError -> L110
        L222:
            b[SVGAttr.x1.ordinal()] = 15;     // Catch: NoSuchFieldError -> L111
        L246:
            b[SVGAttr.y1.ordinal()] = 16;     // Catch: NoSuchFieldError -> L112
        L250:
            b[SVGAttr.x2.ordinal()] = 17;     // Catch: NoSuchFieldError -> L113
        L274:
            b[SVGAttr.y2.ordinal()] = 18;     // Catch: NoSuchFieldError -> L114
        L280:
            b[SVGAttr.gradientUnits.ordinal()] = 19;     // Catch: NoSuchFieldError -> L115
        L302:
            b[SVGAttr.gradientTransform.ordinal()] = 20;     // Catch: NoSuchFieldError -> L116
        L306:
            b[SVGAttr.spreadMethod.ordinal()] = 21;     // Catch: NoSuchFieldError -> L117
        L178:
            b[SVGAttr.fx.ordinal()] = 22;     // Catch: NoSuchFieldError -> L118
        L182:
            b[SVGAttr.fy.ordinal()] = 23;     // Catch: NoSuchFieldError -> L119
        L204:
            b[SVGAttr.offset.ordinal()] = 24;     // Catch: NoSuchFieldError -> L120
        L210:
            b[SVGAttr.clipPathUnits.ordinal()] = 25;     // Catch: NoSuchFieldError -> L121
        L238:
            b[SVGAttr.patternUnits.ordinal()] = 26;     // Catch: NoSuchFieldError -> L122
        L240:
            b[SVGAttr.patternContentUnits.ordinal()] = 27;     // Catch: NoSuchFieldError -> L123
        L264:
            b[SVGAttr.patternTransform.ordinal()] = 28;     // Catch: NoSuchFieldError -> L124
        L268:
            b[SVGAttr.style.ordinal()] = 29;     // Catch: NoSuchFieldError -> L125
        L294:
            b[SVGAttr.fill.ordinal()] = 30;     // Catch: NoSuchFieldError -> L126
        L298:
            b[SVGAttr.fill_rule.ordinal()] = 31;     // Catch: NoSuchFieldError -> L127
        L318:
            b[SVGAttr.fill_opacity.ordinal()] = 32;     // Catch: NoSuchFieldError -> L128
        L172:
            b[SVGAttr.stroke.ordinal()] = 33;     // Catch: NoSuchFieldError -> L129
        L198:
            b[SVGAttr.stroke_opacity.ordinal()] = 34;     // Catch: NoSuchFieldError -> L130
        L200:
            b[SVGAttr.stroke_width.ordinal()] = 35;     // Catch: NoSuchFieldError -> L131
        L226:
            b[SVGAttr.stroke_linecap.ordinal()] = 36;     // Catch: NoSuchFieldError -> L132
        L230:
            b[SVGAttr.stroke_linejoin.ordinal()] = 37;     // Catch: NoSuchFieldError -> L133
        L252:
            b[SVGAttr.stroke_miterlimit.ordinal()] = 38;     // Catch: NoSuchFieldError -> L134
        L258:
            b[SVGAttr.stroke_dasharray.ordinal()] = 39;     // Catch: NoSuchFieldError -> L135
        L284:
            b[SVGAttr.stroke_dashoffset.ordinal()] = 40;     // Catch: NoSuchFieldError -> L136
        L288:
            b[SVGAttr.opacity.ordinal()] = 41;     // Catch: NoSuchFieldError -> L137
        L308:
            b[SVGAttr.color.ordinal()] = 42;     // Catch: NoSuchFieldError -> L138
        L314:
            b[SVGAttr.overflow.ordinal()] = 43;     // Catch: NoSuchFieldError -> L139
        L186:
            b[SVGAttr.display.ordinal()] = 44;     // Catch: NoSuchFieldError -> L140
        L192:
            b[SVGAttr.visibility.ordinal()] = 45;     // Catch: NoSuchFieldError -> L141
        L212:
            b[SVGAttr.stop_color.ordinal()] = 46;     // Catch: NoSuchFieldError -> L142
        L220:
            b[SVGAttr.stop_opacity.ordinal()] = 47;     // Catch: NoSuchFieldError -> L143
        L244:
            b[SVGAttr.clip.ordinal()] = 48;     // Catch: NoSuchFieldError -> L144
        L248:
            b[SVGAttr.clip_path.ordinal()] = 49;     // Catch: NoSuchFieldError -> L145
        L272:
            b[SVGAttr.clip_rule.ordinal()] = 50;     // Catch: NoSuchFieldError -> L146
        L278:
            b[SVGAttr.solid_color.ordinal()] = 51;     // Catch: NoSuchFieldError -> L147
        L300:
            b[SVGAttr.solid_opacity.ordinal()] = 52;     // Catch: NoSuchFieldError -> L148
        L304:
            b[SVGAttr.viewport_fill.ordinal()] = 53;     // Catch: NoSuchFieldError -> L149
        L176:
            b[SVGAttr.viewport_fill_opacity.ordinal()] = 54;     // Catch: NoSuchFieldError -> L150
        L180:
            b[SVGAttr.vector_effect.ordinal()] = 55;     // Catch: NoSuchFieldError -> L151
        L202:
            b[SVGAttr.image_rendering.ordinal()] = 56;     // Catch: NoSuchFieldError -> L152
        L208:
            b[SVGAttr.viewBox.ordinal()] = 57;     // Catch: NoSuchFieldError -> L153
        L77:
            int[] r15 = new int[SVGElem.values().length];
            a = r15;
            r15[SVGElem.svg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L154
        L242:
            a[SVGElem.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L155
        L266:
            a[SVGElem.defs.ordinal()] = 3;     // Catch: NoSuchFieldError -> L156
        L276:
            a[SVGElem.use.ordinal()] = 4;     // Catch: NoSuchFieldError -> L157
        L282:
            a[SVGElem.path.ordinal()] = 5;     // Catch: NoSuchFieldError -> L158
        L292:
            a[SVGElem.rect.ordinal()] = 6;     // Catch: NoSuchFieldError -> L159
        L312:
            a[SVGElem.circle.ordinal()] = 7;     // Catch: NoSuchFieldError -> L160
        L320:
            a[SVGElem.ellipse.ordinal()] = 8;     // Catch: NoSuchFieldError -> L161
        L174:
            a[SVGElem.line.ordinal()] = 9;     // Catch: NoSuchFieldError -> L162
        L184:
            a[SVGElem.polyline.ordinal()] = 10;     // Catch: NoSuchFieldError -> L163
        L206:
            a[SVGElem.polygon.ordinal()] = 11;     // Catch: NoSuchFieldError -> L164
        L218:
            a[SVGElem.linearGradient.ordinal()] = 12;     // Catch: NoSuchFieldError -> L165
        L224:
            a[SVGElem.radialGradient.ordinal()] = 13;     // Catch: NoSuchFieldError -> L166
        L236:
            a[SVGElem.stop.ordinal()] = 14;     // Catch: NoSuchFieldError -> L167
        L254:
            a[SVGElem.clipPath.ordinal()] = 15;     // Catch: NoSuchFieldError -> L168
        L262:
            a[SVGElem.pattern.ordinal()] = 16;     // Catch: NoSuchFieldError -> L169
        L270:
            a[SVGElem.image.ordinal()] = 17;     // Catch: NoSuchFieldError -> L170
        L296:
            a[SVGElem.solidColor.ordinal()] = 18;     // Catch: NoSuchFieldError -> L171
            return;
        }
    }

    public static class b {
        public static final Map<String, PreserveAspectRatio.Alignment> a = null;

        static {
            HashMap r0 = new HashMap(10);
            a = r0;
            r0.put(VoiceDisplayScene.NONE, PreserveAspectRatio.Alignment.none);
            r0.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            r0.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            r0.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            r0.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            r0.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            r0.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            r0.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            r0.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            r0.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }
    }

    public static class c {
        public final String a;
        public int b;
        public final int c;
        public final com.lynx.component.svg.parser.b d;

        public static boolean f(int r1) {
            if (r1 != 32) goto L5;
        L12:
            return true;
        L5:
            if (r1 == 10) goto L12;
            if (r1 == 13) goto L12;
            if (r1 == 9) goto L12;
            return false;
        }

        public final int a() {
            int r0 = this.b;
            int r1 = this.c;
            if (r0 != r1) goto L5;
            return -1;
        L5:
            int r2 = r0 + 1;
            this.b = r2;
            if (r2 < r1) goto L8;
            return -1;
        L8:
            return this.a.charAt(r2);
        }

        public final boolean e() {
            if (this.b != this.c) goto L5;
            return true;
        L5:
            return false;
        }

        public final float g() {
            float r0 = this.d.a(this.a, this.b, this.c);
            if (Float.isNaN(r0) == true) goto L5;
            this.b = this.d.a;
        L5:
            return r0;
        }

        public final void l() {
        L2:
            int r0 = this.b;
            if (r0 >= this.c) goto L8;
            if (f(this.a.charAt(r0)) == false) goto L11;
            this.b++;
            goto L2
        L11:
            return;
        }

        public final SVG.o h() {
            float r0 = g();
            SVG.Unit r2 = null;
            if (Float.isNaN(r0) == false) goto L6;
            return null;
        L6:
            if (e() == false) goto L9;
        L24:
            if (r2 != null) goto L28;
            return new SVG.o(r0, SVG.Unit.px);
        L28:
            return new SVG.o(r0, r2);
        L9:
            if (this.a.charAt(this.b) != '%') goto L11;
            this.b++;
            r2 = SVG.Unit.percent;
            goto L24
        L11:
            int r1 = this.b;
            int r3 = this.c;
            if (r1 > (r3 - 2)) goto L24;
            if (r1 <= (r3 - 3)) goto L31;
        L22:
            String r4 = this.a;     // Catch: IllegalArgumentException -> L29
            int r5 = this.b;     // Catch: IllegalArgumentException -> L29
            SVG.Unit r6 = SVG.Unit.valueOf(r4.substring(r5, r5 + 2).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L29
            this.b += 2;     // Catch: IllegalArgumentException -> L29
            r2 = r6;
        L30:
            goto L24
        L31:
            String r7 = this.a.substring(r1, r1 + 3);     // Catch: IllegalArgumentException -> L29
            if ("rem".equals(r7) == false) goto L20;
            this.b += 3;     // Catch: IllegalArgumentException -> L29
            r2 = SVG.Unit.rem;     // Catch: IllegalArgumentException -> L29
            goto L30
        L20:
            if ("rpx".equals(r7) == false) goto L22;
            this.b += 3;     // Catch: IllegalArgumentException -> L29
            r2 = SVG.Unit.rpx;     // Catch: IllegalArgumentException -> L29
            goto L30
        }

        public final String i() {
            if (e() == true) goto L20;
            char r0 = this.a.charAt(this.b);
            if (f(r0) == true) goto L20;
            if (r0 == ' ') goto L20;
            int r1 = this.b;
            int r2 = a();
        L12:
            if (r2 == (-1)) goto L25;
            if (r2 == 32) goto L25;
            if (f(r2) == true) goto L25;
            r2 = a();
        L25:
            return this.a.substring(r1, this.b);
        L20:
            return null;
        }

        public final float j() {
            k();
            float r0 = this.d.a(this.a, this.b, this.c);
            if (Float.isNaN(r0) == true) goto L5;
            this.b = this.d.a;
        L5:
            return r0;
        }

        public final void k() {
            l();
            int r0 = this.b;
            if (r0 != this.c) goto L6;
            return;
        L6:
            if (this.a.charAt(r0) == ',') goto L8;
            return;
        L8:
            this.b++;
            l();
        }

        public c(String r2) {
            this.b = 0;
            this.c = 0;
            this.d = new com.lynx.component.svg.parser.b();
            String r3 = r2.trim();
            this.a = r3;
            this.c = r3.length();
        }

        public final Boolean b(Object r4) {
            if (r4 != null) goto L5;
            return null;
        L5:
            k();
            int r5 = this.b;
            if (r5 == this.c) goto L18;
            char r6 = this.a.charAt(r5);
            if (r6 == '0') goto L11;
            if (r6 == '1') goto L11;
            return null;
        L11:
            boolean r1 = true;
            this.b++;
            if (r6 == '1') goto L16;
            r1 = false;
        L16:
            return Boolean.valueOf(r1);
        L18:
            return null;
        }

        public final float c(float r1) {
            if (Float.isNaN(r1) == false) goto L6;
            return Float.NaN;
        L6:
            k();
            return g();
        }

        public final boolean d(char r4) {
            int r0 = this.b;
            if (r0 < this.c) goto L5;
        L7:
            boolean r5 = false;
        L8:
            if (r5 == false) goto L10;
            this.b++;
        L10:
            return r5;
        L5:
            if (this.a.charAt(r0) != r4) goto L7;
            r5 = true;
            goto L8
        }
    }

    public class d implements Attributes {
        public final XmlPullParser a;

        @Override // org.xml.sax.Attributes
        public final int getIndex(String r1) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public final int getIndex(String r1, String r2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int r1) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String r1) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String r1, String r2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(String r1) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(String r1, String r2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public final int getLength() {
            return this.a.getAttributeCount();
        }

        public d(XmlPullParser r1) {
            this.a = r1;
        }

        @Override // org.xml.sax.Attributes
        public final String getLocalName(int r2) {
            return this.a.getAttributeName(r2);
        }

        @Override // org.xml.sax.Attributes
        public final String getQName(int r4) {
            String r0 = this.a.getAttributeName(r4);
            if (this.a.getAttributePrefix(r4) != null) goto L5;
            return r0;
        L5:
            return this.a.getAttributePrefix(r4) + ':' + r0;
        }

        @Override // org.xml.sax.Attributes
        public final String getURI(int r2) {
            return this.a.getAttributeNamespace(r2);
        }

        @Override // org.xml.sax.Attributes
        public final String getValue(int r2) {
            return this.a.getAttributeValue(r2);
        }
    }

    public SVGParser() {
        this.a = null;
        this.b = null;
        this.c = false;
    }

    public static SVG.f i(String r1) throws SVGParseException {
        return new SVG.f(ColorUtils.b(r1));
    L4:
        e = move-exception;
        throw new SVGParseException(e.toString());
    }

    public static SVG.h0 j(String r1) {
        r1.getClass();
        if (r1.equals(VoiceDisplayScene.NONE) == true) goto L13;
        if (r1.equals("currentColor") == true) goto L11;
        return i(r1);
    L8:
        return null;
    L11:
        return SVG.g.a;
    L13:
        return SVG.f.c;
    }

    public static float k(String r1) throws SVGParseException {
        int r0 = r1.length();
        if (r0 == 0) goto L7;
        return l(r1, r0);
    L7:
        throw new SVGParseException("Invalid float value (empty string)");
    }

    public static SVG.o m(String r5) throws SVGParseException {
        if (r5.length() == 0) goto L35;
        int r0 = r5.length();
        SVG.Unit r1 = SVG.Unit.px;
        int r2 = r0 - 1;
        char r3 = r5.charAt(r2);
        if (r3 != '%') goto L9;
        r1 = SVG.Unit.percent;
    L7:
        r0 = r2;
    L38:
        return new SVG.o(l(r5, r0), r1);
    L31:
        e = move-exception;
        throw new SVGParseException("Invalid length value: ".concat(r5), e);
    L9:
        if (r5.endsWith("rpx") == false) goto L12;
        r1 = SVG.Unit.rpx;
    L14:
        r0 = r0 - 3;
        goto L38
    L12:
        if (r5.endsWith("rem") == false) goto L16;
        r1 = SVG.Unit.rem;
        goto L14
    L16:
        if (r5.endsWith("em") == false) goto L19;
        r1 = SVG.Unit.em;
        r0 = r0 - 2;
        goto L38
    L19:
        if (r0 <= 2) goto L38;
        if (Character.isLetter(r3) == false) goto L38;
        r2 = r0 - 2;
        if (Character.isLetter(r5.charAt(r2)) == false) goto L38;
        r1 = SVG.Unit.valueOf(r5.substring(r2).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L27
    L28:
        throw new SVGParseException("Invalid length unit specifier: ".concat(r5));
    L35:
        throw new SVGParseException("Invalid length value (empty string)");
    }

    public static SVG.o n(c r3) {
        int r0 = r3.b;
        if (r0 <= (r3.c - 4)) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        r3.b += 4;
    L10:
        if (r1 == false) goto L14;
        return new SVG.o();
    L14:
        return r3.h();
    L5:
        if (r3.a.substring(r0, r0 + 4).equals("auto") == false) goto L7;
        r1 = true;
        goto L8
    }

    public static Float o(String r2) {
        float r3 = k(r2);     // Catch: SVGParseException -> L10
        if (r3 >= 0.0f) goto L6;
        r3 = 0.0f;
    L8:
        return Float.valueOf(r3);
    L6:
        if (r3 <= 1.0f) goto L8;
        r3 = 1.0f;
    L10:
        return null;
    }

    public static SVG.h0 p(String r4) {
        if (r4.startsWith("url(") == false) goto L14;
        int r0 = r4.indexOf(")");
        SVG.h0 r2 = null;
        if (r0 == (-1)) goto L12;
        String r1 = r4.substring(4, r0).trim();
        String r5 = r4.substring(r0 + 1).trim();
        if (r5.length() <= 0) goto L10;
        r2 = j(r5);
    L10:
        return new SVG.r(r1, r2);
    L12:
        return new SVG.r(r4.substring(4).trim(), null);
    L14:
        return j(r4);
    }

    public static Matrix r(String r19) throws SVGParseException {
        Matrix r1 = new Matrix();
        c r2 = new c(r19);
        r2.l();
    L4:
        if (r2.e() == true) goto L126;
        if (r2.e() == true) goto L26;
        int r3 = r2.b;
        int r5 = r2.a.charAt(r3);
    L10:
        if (r5 < 97) goto L14;
        if (r5 > 122) goto L14;
    L17:
        r5 = r2.a();
    L14:
        if (r5 < 65) goto L18;
        if (r5 <= 90) goto L17;
    L18:
        int r6 = r2.b;
    L20:
        if (c.f(r5) == false) goto L23;
        r5 = r2.a();
        goto L20
    L23:
        if (r5 != 40) goto L25;
        r2.b++;
        String r4 = r2.a.substring(r3, r6);
    L27:
        if (r4 == null) goto L125;
        switch(r4.hashCode()) {
            case -1081239615: goto L52;
            case -925180581: goto L48;
            case 109250890: goto L44;
            case 109493390: goto L40;
            case 109493391: goto L36;
            case 1052832078: goto L32;
            default: goto L55;
        };
    L55:
        byte r7 = -1;
    L57:
        if (r7 == 0) goto L113;
        if (r7 == 1) goto L99;
        if (r7 == 2) goto L89;
        if (r7 == 3) goto L82;
        if (r7 == 4) goto L75;
        if (r7 != 5) goto L74;
        r2.l();
        float r8 = r2.g();
        float r9 = r2.j();
        r2.l();
        if (Float.isNaN(r8) == true) goto L72;
        if (r2.d(')') == false) goto L72;
        if (Float.isNaN(r9) == false) goto L70;
        r1.preTranslate(r8, 0.0f);
    L119:
        if (r2.e() == true) goto L126;
        r2.k();
        goto L4
    L70:
        r1.preTranslate(r8, r9);
    L72:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L74:
        throw new SVGParseException("Invalid transform list fn: " + r4 + ")");
    L75:
        r2.l();
        float r10 = r2.g();
        r2.l();
        if (Float.isNaN(r10) == true) goto L81;
        if (r2.d(')') == false) goto L81;
        r1.preSkew(0.0f, (float) Math.tan(Math.toRadians(r10)));
    L81:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L82:
        r2.l();
        float r11 = r2.g();
        r2.l();
        if (Float.isNaN(r11) == true) goto L88;
        if (r2.d(')') == false) goto L88;
        r1.preSkew((float) Math.tan(Math.toRadians(r11)), 0.0f);
    L88:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L89:
        r2.l();
        float r12 = r2.g();
        float r13 = r2.j();
        r2.l();
        if (Float.isNaN(r12) == true) goto L98;
        if (r2.d(')') == false) goto L98;
        if (Float.isNaN(r13) == false) goto L96;
        r1.preScale(r12, r12);
        goto L119
    L96:
        r1.preScale(r12, r13);
    L98:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L99:
        r2.l();
        float r14 = r2.g();
        float r15 = r2.j();
        float r16 = r2.j();
        r2.l();
        if (Float.isNaN(r14) == true) goto L112;
        if (r2.d(')') == false) goto L112;
        if (Float.isNaN(r15) == false) goto L107;
        r1.preRotate(r14);
        goto L119
    L107:
        if (Float.isNaN(r16) == true) goto L110;
        r1.preRotate(r14, r15, r16);
        goto L119
    L110:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L112:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L113:
        r2.l();
        float r17 = r2.g();
        r2.k();
        float r18 = r2.g();
        r2.k();
        float r110 = r2.g();
        r2.k();
        float r111 = r2.g();
        r2.k();
        float r112 = r2.g();
        r2.k();
        float r113 = r2.g();
        r2.l();
        if (Float.isNaN(r113) == true) goto L123;
        if (r2.d(')') == false) goto L123;
        Matrix r114 = new Matrix();
        r114.setValues(new float[]{r17, r110, r112, r18, r111, r113, 0.0f, 0.0f, 1.0f});
        r1.preConcat(r114);
    L123:
        throw new SVGParseException("Invalid transform list: ".concat(r19));
    L32:
        if (r4.equals(SVGRenderEngine.TRANSLATE) == false) goto L55;
        r7 = 5;
        goto L57
    L36:
        if (r4.equals("skewY") == false) goto L55;
        r7 = 4;
        goto L57
    L40:
        if (r4.equals("skewX") == false) goto L55;
        r7 = 3;
        goto L57
    L44:
        if (r4.equals("scale") == false) goto L55;
        r7 = 2;
        goto L57
    L48:
        if (r4.equals("rotate") == false) goto L55;
        r7 = 1;
        goto L57
    L52:
        if (r4.equals("matrix") == false) goto L55;
        r7 = 0;
        goto L57
    L125:
        throw new SVGParseException("Bad transform function encountered in transform list: ".concat(r19));
    L25:
        r2.b = r3;
    L26:
        r4 = null;
    L126:
        return r1;
    }

    public final void s(InputStream r7) throws SVGParseException {
        XmlPullParser r0 = Xml.newPullParser();     // Catch: Exception -> L22 XmlPullParserException -> L25
        d r1 = new d(r0);     // Catch: Exception -> L22 XmlPullParserException -> L25
        r0.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", true);     // Catch: Exception -> L22 XmlPullParserException -> L25
        r0.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);     // Catch: Exception -> L22 XmlPullParserException -> L25
        r0.setInput(r7, "utf-8");     // Catch: Exception -> L22 XmlPullParserException -> L25
        int r8 = r0.getEventType();     // Catch: Exception -> L22 XmlPullParserException -> L25
    L3:
        if (r8 == 1) goto L21;
        if (r8 != 0) goto L6;
        this.a = new SVG();     // Catch: Exception -> L22 XmlPullParserException -> L25
    L19:
        r8 = r0.nextToken();     // Catch: Exception -> L22 XmlPullParserException -> L25
    L6:
        if (r8 != 2) goto L8;
        String r9 = r0.getName();     // Catch: Exception -> L22 XmlPullParserException -> L25
        if (r0.getPrefix() == null) goto L17;
        r9 = r0.getPrefix() + ':' + r9;     // Catch: Exception -> L22 XmlPullParserException -> L25
    L17:
        u(r0.getNamespace(), r0.getName(), r9, r1);     // Catch: Exception -> L22 XmlPullParserException -> L25
        goto L19
    L8:
        if (r8 != 3) goto L19;
        String r10 = r0.getName();     // Catch: Exception -> L22 XmlPullParserException -> L25
        if (r0.getPrefix() == null) goto L13;
        r10 = r0.getPrefix() + ':' + r10;     // Catch: Exception -> L22 XmlPullParserException -> L25
    L13:
        b(r0.getNamespace(), r0.getName(), r10);     // Catch: Exception -> L22 XmlPullParserException -> L25
        goto L19
    L21:
        return;
    L25:
        e = move-exception;
        throw new SVGParseException("XML parser problem", e);
    L22:
        e = move-exception;
        throw new SVGParseException("unexpected error", e);
    }

    public static void a(String r1, Object... r2) {
        LLog.d("SVGParser", String.format(r1, r2));
    }

    public static void c(SVG.e0 r3, Attributes r4) throws SVGParseException {
        int r0 = 0;
    L4:
        if (r0 >= r4.getLength()) goto L29;
        String r1 = r4.getQName(r0);
        if (r1.equals("id") == true) goto L21;
        if (r1.equals("xml:id") == true) goto L21;
        if (r1.equals("xml:space") == true) goto L12;
        r0 = r0 + 1;
        goto L4
    L12:
        String r5 = r4.getValue(r0).trim();
        if (LynxUIWebView.DEFAULT.equals(r5) == false) goto L16;
        r3.d = Boolean.FALSE;
        return;
    L16:
        if ("preserve".equals(r5) == false) goto L19;
        r3.d = Boolean.TRUE;
        return;
    L19:
        throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + r5);
    L21:
        r3.c = r4.getValue(r0).trim();
        return;
    }

    public static void d(SVG.j r4, d r5) throws SVGParseException {
        int r0 = 0;
    L4:
        if (r0 >= r5.getLength()) goto L28;
        String r1 = r5.getValue(r0).trim();
        int r2 = a.b[SVGAttr.fromString(r5.getLocalName(r0)).ordinal()];
        if (r2 == 6) goto L23;
        switch(r2) {
            case 19: goto L15;
            case 20: goto L13;
            case 21: goto L29;
            default: goto L27;
        };
    L13:
        r4.i = r(r1);
        goto L27
    L29:
        r4.j = SVG.GradientSpread.valueOf(r1);     // Catch: IllegalArgumentException -> L11
    L12:
        throw new SVGParseException("Invalid spreadMethod attribute. \"" + r1 + "\" is not a valid value.");
    L15:
        if ("objectBoundingBox".equals(r1) == false) goto L18;
        r4.h = Boolean.FALSE;
        goto L27
    L18:
        if ("userSpaceOnUse".equals(r1) == false) goto L21;
        r4.h = Boolean.TRUE;
        goto L27
    L21:
        throw new SVGParseException("Invalid value for attribute gradientUnits");
    L27:
        r0 = r0 + 1;
        goto L4
    L23:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r5.getURI(r0)) == false) goto L25;
    L26:
        r4.k = r1;
        goto L27
    L25:
        if ("http://www.w3.org/1999/xlink".equals(r5.getURI(r0)) == false) goto L27;
    }

    public static void f(SVG.e0 r12, Attributes r13) throws SVGParseException {
        int r1 = 0;
    L4:
        if (r1 >= r13.getLength()) goto L93;
        String r2 = r13.getValue(r1).trim();
        if (r2.length() == 0) goto L92;
        if (a.b[SVGAttr.fromString(r13.getLocalName(r1)).ordinal()] != 29) goto L11;
        com.lynx.component.svg.parser.a r3 = new com.lynx.component.svg.parser.a(r2.replaceAll("/\\*.*?\\*/", NameKeys.UnloadStrategy_No_Strategy));
    L16:
        if (r3.e() == true) goto L92;
        r3.l();
        if (r3.e() == false) goto L20;
        int r4 = r3.b;
    L45:
        int r5 = r3.b;
        String r6 = null;
        if (r4 != r5) goto L48;
        String r7 = null;
    L49:
        r3.l();
        if (r3.d(';') == true) goto L16;
        if (r3.d(':') == false) goto L92;
        r3.l();
        if (r3.e() == true) goto L82;
        int r8 = r3.b;
        int r9 = r3.a.charAt(r8);
        int r10 = r8;
    L60:
        if (r9 == (-1)) goto L79;
        if (r9 == 59) goto L79;
        if (r9 == 125) goto L79;
        if (r9 == 33) goto L79;
        if (r9 != 10) goto L69;
    L72:
        boolean r11 = true;
    L73:
        if (r11 == true) goto L79;
        if (c.f(r9) == true) goto L77;
        r10 = r3.b + 1;
    L77:
        r9 = r3.a();
        goto L60
    L69:
        if (r9 == 13) goto L72;
        r11 = false;
    L79:
        if (r3.b <= r8) goto L81;
        r6 = r3.a.substring(r8, r10);
        goto L82
    L81:
        r3.b = r8;
    L82:
        if (r6 == null) goto L16;
        r3.l();
        if (r3.e() == true) goto L89;
        if (r3.d(';') == false) goto L16;
    L89:
        if (r12.f != null) goto L91;
        r12.f = new SVG.Style();
    L91:
        t(r12.f, r7, r6);
        r3.l();
        goto L16
    L48:
        r7 = r3.a.substring(r5, r4);
        r3.b = r4;
        goto L49
    L20:
        int r14 = r3.b;
        int r15 = r3.a.charAt(r14);
        if (r15 != 45) goto L24;
        r15 = r3.a();
    L24:
        if (r15 < 65) goto L26;
        if (r15 > 90) goto L26;
    L29:
        int r16 = r3.a();
    L30:
        if (r16 < 65) goto L32;
        if (r16 > 90) goto L32;
    L42:
        r16 = r3.a();
    L32:
        if (r16 < 97) goto L35;
        if (r16 <= 122) goto L42;
    L35:
        if (r16 >= 48) goto L37;
    L38:
        if (r16 == 45) goto L42;
        if (r16 == 95) goto L42;
        int r17 = r3.b;
    L44:
        r3.b = r14;
        r4 = r17;
        goto L45
    L37:
        if (r16 <= 57) goto L42;
    L26:
        if (r15 < 97) goto L28;
        if (r15 <= 122) goto L29;
    L28:
        if (r15 == 95) goto L29;
        r17 = r14;
        goto L44
    L11:
        if (r12.e != null) goto L13;
        r12.e = new SVG.Style();
    L13:
        t(r12.e, r13.getLocalName(r1), r13.getValue(r1).trim());
    L92:
        r1 = r1 + 1;
        goto L4
    }

    public static void g(SVG.m r3, Attributes r4) throws SVGParseException {
        int r0 = 0;
    L4:
        if (r0 >= r4.getLength()) goto L9;
        if (SVGAttr.fromString(r4.getLocalName(r0)) != SVGAttr.transform) goto L8;
        r3.a(r(r4.getValue(r0)));
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public static void h(SVG.k0 r7, d r8) throws SVGParseException {
        int r0 = 0;
    L4:
        if (r0 >= r8.getLength()) goto L31;
        String r1 = r8.getValue(r0).trim();
        int r2 = a.b[SVGAttr.fromString(r8.getLocalName(r0)).ordinal()];
        if (r2 != 7) goto L8;
        q(r7, r1);
    L30:
        r0 = r0 + 1;
        goto L4
    L8:
        if (r2 != 57) goto L30;
        c r3 = new c(r1);
        r3.l();
        float r4 = n.a(r3.i(), 0.0f);
        r3.k();
        float r5 = n.a(r3.i(), 0.0f);
        r3.k();
        float r6 = n.a(r3.i(), 0.0f);
        r3.k();
        float r9 = n.a(r3.i(), 0.0f);
        if (Float.isNaN(r4) == true) goto L28;
        if (Float.isNaN(r5) == true) goto L28;
        if (Float.isNaN(r6) == true) goto L28;
        if (Float.isNaN(r9) == true) goto L28;
        if (r6 < 0.0f) goto L26;
        if (r9 < 0.0f) goto L24;
        r7.j = new SVG.b(r4, r5, r6, r9);
        goto L30
    L24:
        throw new SVGParseException("Invalid viewBox. height cannot be negative");
    L26:
        throw new SVGParseException("Invalid viewBox. width cannot be negative");
    L28:
        throw new SVGParseException("Invalid viewBox definition - should have four numbers");
    }

    public static float l(String r2, int r3) throws SVGParseException {
        float r4 = new com.lynx.component.svg.parser.b().a(r2, 0, r3);
        if (Float.isNaN(r4) == true) goto L6;
        return r4;
    L6:
        throw new SVGParseException("Invalid float value: " + r2);
    }

    public static void q(SVG.i0 r3, String r4) throws SVGParseException {
        c r0 = new c(r4);
        r0.l();
        String r1 = r0.i();
        if ("defer".equals(r1) == false) goto L5;
        r0.l();
        r1 = r0.i();
    L5:
        PreserveAspectRatio.Alignment r2 = (PreserveAspectRatio.Alignment) ((HashMap) b.a).get(r1);
        r0.l();
        if (r0.e() == true) goto L15;
        String r5 = r0.i();
        r5.getClass();
        if (r5.equals("meet") == false) goto L10;
        PreserveAspectRatio.Scale r6 = PreserveAspectRatio.Scale.meet;
    L16:
        r3.i = new PreserveAspectRatio(r2, r6);
        return;
    L10:
        if (r5.equals("slice") == false) goto L13;
        r6 = PreserveAspectRatio.Scale.slice;
        goto L16
    L13:
        throw new SVGParseException("Invalid preserveAspectRatio definition: ".concat(r4));
    L15:
        r6 = null;
        goto L16
    }

    public static void e(SVG.v r8, d r9, String r10) throws SVGParseException {
        int r1 = 0;
    L4:
        if (r1 >= r9.getLength()) goto L24;
        if (SVGAttr.fromString(r9.getLocalName(r1)) != SVGAttr.points) goto L23;
        c r2 = new c(r9.getValue(r1));
        ArrayList r3 = new ArrayList();
        r2.l();
    L9:
        if (r2.e() == true) goto L19;
        float r4 = r2.g();
        if (Float.isNaN(r4) == true) goto L18;
        r2.k();
        float r5 = r2.g();
        if (Float.isNaN(r5) == true) goto L16;
        r2.k();
        r3.add(Float.valueOf(r4));
        r3.add(Float.valueOf(r5));
        goto L9
    L16:
        throw new SVGParseException("Invalid <" + r10 + "> points attribute. There should be an even number of coordinates.");
    L18:
        throw new SVGParseException("Invalid <" + r10 + "> points attribute. Non-coordinate content found in list.");
    L19:
        r8.i = new float[r3.size()];
        Iterator r6 = r3.iterator();
        int r7 = 0;
    L21:
        if (r6.hasNext() == false) goto L23;
        r8.i[r7] = ((Float) r6.next()).floatValue();
        r7 = r7 + 1;
    L23:
        r1 = r1 + 1;
        goto L4
    }

    public static void t(SVG.Style r16, String r17, String r18) {
        if (r18.length() != 0) goto L6;
        return;
    L6:
        if (r18.equals("inherit") == false) goto L8;
        return;
    L8:
        SVG.Style.FillRule r6 = null;
        SVG.Style.RenderQuality r7 = null;
        SVG.Style.VectorEffect r8 = null;
        SVG.Style.FillRule r9 = null;
        String r10 = null;
        r10 = null;
        SVG.c r11 = null;
        r11 = null;
        r11 = null;
        Boolean r12 = null;
        SVG.o[] r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        r13 = null;
        SVG.Style.LineJoin r14 = null;
        SVG.Style.LineCap r15 = null;
        byte r19 = -1;
        switch(a.b[SVGAttr.fromString(r17).ordinal()]) {
            case 30: goto L228;
            case 31: goto L220;
            case 32: goto L216;
            case 33: goto L213;
            case 34: goto L210;
            case 35: goto L208;
            case 36: goto L197;
            case 37: goto L185;
            case 38: goto L182;
            case 39: goto L154;
            case 40: goto L151;
            case 41: goto L150;
            case 42: goto L148;
            case 43: goto L120;
            case 44: goto L114;
            case 45: goto L108;
            case 46: goto L101;
            case 47: goto L99;
            case 48: goto L85;
            case 49: goto L74;
            case 50: goto L67;
            case 51: goto L60;
            case 52: goto L58;
            case 53: goto L52;
            case 54: goto L50;
            case 55: goto L41;
            case 56: goto L11;
            default: goto L286;
        };
    L11:
        int r2 = r18.hashCode();
        if (r2 == (-933002398)) goto L27;
        if (r2 == 3005871) goto L23;
        if (r2 == 362741610) goto L19;
    L28:
        byte r3 = -1;
    L30:
        if (r3 == 0) goto L36;
        if (r3 == 1) goto L35;
        if (r3 != 2) goto L37;
        r7 = SVG.Style.RenderQuality.optimizeSpeed;
    L37:
        r16.B = r7;
        if (r7 == null) goto L246;
        r16.a |= 137438953472L;
        return;
    L246:
        return;
    L35:
        r7 = SVG.Style.RenderQuality.auto;
        goto L37
    L36:
        r7 = SVG.Style.RenderQuality.optimizeQuality;
        goto L37
    L19:
        if (r18.equals("optimizeSpeed") == false) goto L28;
        r3 = 2;
        goto L30
    L23:
        if (r18.equals("auto") == false) goto L28;
        r3 = 1;
        goto L30
    L27:
        if (r18.equals("optimizeQuality") == false) goto L28;
        r3 = 0;
        goto L30
    L50:
        r16.z = o(r18);
        r16.a |= 17179869184L;
        return;
    L58:
        r16.x = o(r18);
        r16.a |= 4294967296L;
        return;
    L99:
        r16.t = o(r18);
        r16.a |= 134217728;
        return;
    L148:
        r16.n = i(r18);     // Catch: SVGParseException -> L232
        r16.a |= 4096;     // Catch: SVGParseException -> L232
    L235:
        return;
    L150:
        r16.m = o(r18);
        r16.a |= 2048;
        return;
    L151:
        r16.l = m(r18);     // Catch: SVGParseException -> L232
        r16.a |= 1024;     // Catch: SVGParseException -> L232
        goto L235
    L182:
        r16.j = Float.valueOf(k(r18));     // Catch: SVGParseException -> L232
        r16.a |= 256;     // Catch: SVGParseException -> L232
        goto L235
    L208:
        r16.g = m(r18);     // Catch: SVGParseException -> L232
        r16.a |= 32;     // Catch: SVGParseException -> L232
        goto L235
    L210:
        Float r1 = o(r18);
        r16.f = r1;
        if (r1 == null) goto L277;
        r16.a |= 16;
        return;
    L277:
        return;
    L213:
        SVG.h0 r4 = p(r18);
        r16.e = r4;
        if (r4 == null) goto L279;
        r16.a |= 8;
        return;
    L279:
        return;
    L216:
        Float r5 = o(r18);
        r16.d = r5;
        if (r5 == null) goto L281;
        r16.a |= 4;
        return;
    L281:
        return;
    L228:
        SVG.h0 r20 = p(r18);
        r16.b = r20;
        if (r20 == null) goto L285;
        r16.a |= 1;
        return;
    L285:
        return;
    L286:
        return;
    L41:
        if (r18.equals(VoiceDisplayScene.NONE) == false) goto L43;
        r8 = SVG.Style.VectorEffect.None;
    L47:
        r16.A = r8;
        if (r8 == null) goto L248;
        r16.a |= 34359738368L;
        return;
    L248:
        return;
    L43:
        if (r18.equals("non-scaling-stroke") == false) goto L47;
        r8 = SVG.Style.VectorEffect.NonScalingStroke;
        goto L47
    L52:
        if (r18.equals("currentColor") == false) goto L233;
        r16.y = SVG.g.a;
    L55:
        r16.a |= 8589934592L;
        return;
    L233:
        r16.y = i(r18);     // Catch: SVGParseException -> L56
    L56:
        e = move-exception;
        e.getMessage();
        return;
    L60:
        if (r18.equals("currentColor") == false) goto L240;
        r16.w = SVG.g.a;
    L63:
        r16.a |= 2147483648L;
        return;
    L240:
        r16.w = i(r18);     // Catch: SVGParseException -> L64
    L64:
        e = move-exception;
        e.getMessage();
        return;
    L67:
        if ("nonzero".equals(r18) == false) goto L70;
        r9 = SVG.Style.FillRule.NonZero;
    L72:
        r16.v = r9;
        r16.a |= 536870912;
        return;
    L70:
        if ("evenodd".equals(r18) == false) goto L72;
        r9 = SVG.Style.FillRule.EvenOdd;
        goto L72
    L74:
        if (r18.equals(VoiceDisplayScene.NONE) == false) goto L77;
    L83:
        r16.u = r10;
        r16.a |= 268435456;
        return;
    L77:
        if (r18.startsWith("url(") == false) goto L83;
        if (r18.endsWith(")") == false) goto L82;
        r10 = r18.substring(4, r18.length() - 1).trim();
        goto L83
    L82:
        r10 = r18.substring(4).trim();
        goto L83
    L85:
        if ("auto".equals(r18) == false) goto L88;
    L96:
        r16.p = r11;
        if (r11 == null) goto L258;
        r16.a |= 1048576;
        return;
    L258:
        return;
    L88:
        if (r18.startsWith("rect(") == false) goto L96;
        c r21 = new c(r18.substring(5));
        r21.l();
        SVG.o r22 = n(r21);
        r21.k();
        SVG.o r23 = n(r21);
        r21.k();
        SVG.o r24 = n(r21);
        r21.k();
        SVG.o r25 = n(r21);
        r21.l();
        if (r21.d(')') == false) goto L93;
    L95:
        r11 = new SVG.c(r22, r23, r24, r25);
        goto L96
    L93:
        if (r21.e() == true) goto L95;
    L101:
        if (r18.equals("currentColor") == false) goto L238;
        r16.s = SVG.g.a;
    L104:
        r16.a |= 67108864;
        return;
    L238:
        r16.s = i(r18);     // Catch: SVGParseException -> L105
    L105:
        e = move-exception;
        e.getMessage();
        return;
    L108:
        if (r18.indexOf(124) < 0) goto L110;
        return;
    L110:
        if ("|visible|hidden|collapse|".contains("|" + r18 + '|') == false) goto L287;
        r16.r = Boolean.valueOf(r18.equals(LynxUIOverlay.PROP_VISIBLE));
        r16.a |= 33554432;
        return;
    L287:
        return;
    L114:
        if (r18.indexOf(124) < 0) goto L116;
        return;
    L116:
        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains("|" + r18 + '|') == false) goto L288;
        r16.q = Boolean.valueOf(!r18.equals(VoiceDisplayScene.NONE));
        r16.a |= 16777216;
        return;
    L288:
        return;
    L120:
        switch(r18.hashCode()) {
            case -1217487446: goto L135;
            case -907680051: goto L131;
            case 3005871: goto L127;
            case 466743410: goto L123;
            default: goto L138;
        };
    L138:
        if (r19 == 0) goto L144;
        if (r19 == 1) goto L144;
        if (r19 == 2) goto L143;
        if (r19 == 3) goto L143;
    L145:
        r16.o = r12;
        if (r12 == null) goto L267;
        r16.a |= 524288;
        return;
    L267:
        return;
    L143:
        r12 = Boolean.TRUE;
    L144:
        r12 = Boolean.FALSE;
        goto L145
    L123:
        if (r18.equals(LynxUIOverlay.PROP_VISIBLE) == false) goto L138;
        r19 = 3;
        goto L138
    L127:
        if (r18.equals("auto") == false) goto L138;
        r19 = 2;
        goto L138
    L131:
        if (r18.equals("scroll") == false) goto L138;
        r19 = 1;
        goto L138
    L135:
        if (r18.equals("hidden") == false) goto L138;
        r19 = 0;
        goto L138
    L154:
        if (VoiceDisplayScene.NONE.equals(r18) == false) goto L156;
        r16.k = null;
        r16.a |= 512;
        return;
    L156:
        c r26 = new c(r18);
        r26.l();
        if (r26.e() == true) goto L179;
        SVG.o r27 = r26.h();
        if (r27 == null) goto L179;
        if (r27.f() == true) goto L179;
        float r28 = r27.a;
        ArrayList r29 = new ArrayList();
        r29.add(r27);
    L167:
        if (r26.e() == true) goto L176;
        r26.k();
        SVG.o r30 = r26.h();
        if (r30 == null) goto L179;
        if (r30.f() == true) goto L179;
        r29.add(r30);
        r28 = r28 + r30.a;
        goto L167
    L176:
        if (r28 == 0.0f) goto L179;
        r13 = (SVG.o[]) r29.toArray(new SVG.o[r29.size()]);
    L179:
        r16.k = r13;
        if (r13 == null) goto L271;
        r16.a |= 512;
        return;
    L271:
        return;
    L185:
        if ("miter".equals(r18) == false) goto L188;
        r14 = SVG.Style.LineJoin.Miter;
    L193:
        r16.i = r14;
        if (r14 == null) goto L273;
        r16.a |= 128;
        return;
    L273:
        return;
    L188:
        if ("round".equals(r18) == false) goto L191;
        r14 = SVG.Style.LineJoin.Round;
        goto L193
    L191:
        if ("bevel".equals(r18) == false) goto L193;
        r14 = SVG.Style.LineJoin.Bevel;
        goto L193
    L197:
        if ("butt".equals(r18) == false) goto L200;
        r15 = SVG.Style.LineCap.Butt;
    L205:
        r16.h = r15;
        if (r15 == null) goto L275;
        r16.a |= 64;
        return;
    L275:
        return;
    L200:
        if ("round".equals(r18) == false) goto L203;
        r15 = SVG.Style.LineCap.Round;
        goto L205
    L203:
        if ("square".equals(r18) == false) goto L205;
        r15 = SVG.Style.LineCap.Square;
        goto L205
    L220:
        if ("nonzero".equals(r18) == false) goto L223;
        r6 = SVG.Style.FillRule.NonZero;
    L225:
        r16.c = r6;
        if (r6 == null) goto L283;
        r16.a |= 2;
        return;
    L283:
        return;
    L223:
        if ("evenodd".equals(r18) == false) goto L225;
        r6 = SVG.Style.FillRule.EvenOdd;
    }

    public final void b(String r4, String r5, String r6) throws SVGParseException {
        if (this.c == false) goto L9;
        int r7 = this.d - 1;
        this.d = r7;
        if (r7 != 0) goto L33;
        this.c = false;
        return;
    L33:
        return;
    L9:
        if ("http://www.w3.org/2000/svg".equals(r4) == true) goto L14;
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r4) == true) goto L14;
        return;
    L14:
        if (r5.length() > 0) goto L17;
        r5 = r6;
    L17:
        int r8 = a.a[SVGElem.fromString(r5).ordinal()];
        if (r8 != 1) goto L20;
    L27:
        Object r9 = this.b;
        if (r9 == null) goto L32;
        this.b = ((SVG.g0) r9).b;
        return;
    L32:
        throw new SVGParseException(String.format("Unbalanced end element </%s> found", new Object[]{r5}));
    L20:
        if (r8 == 2) goto L27;
        if (r8 == 3) goto L27;
        if (r8 == 4) goto L27;
        switch(r8) {
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L27;
            default: goto L34;
        };
    }

    public final void u(String r25, String r26, String r27, d r28) throws SVGParseException {
        if (this.c == false) goto L7;
        this.d++;
        return;
    L7:
        if ("http://www.w3.org/2000/svg".equals(r25) == true) goto L12;
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r25) == true) goto L12;
        return;
    L12:
        if (r26.length() <= 0) goto L14;
        String r0 = r26;
    L15:
        byte r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        switch(a.a[SVGElem.fromString(r0).ordinal()]) {
            case 1: goto L506;
            case 2: goto L501;
            case 3: goto L496;
            case 4: goto L461;
            case 5: goto L314;
            case 6: goto L273;
            case 7: goto L254;
            case 8: goto L230;
            case 9: goto L214;
            case 10: goto L209;
            case 11: goto L204;
            case 12: goto L188;
            case 13: goto L164;
            case 14: goto L126;
            case 15: goto L106;
            case 16: goto L59;
            case 17: goto L23;
            case 18: goto L18;
            default: goto L17;
        };
    L17:
        this.c = true;
        this.d = 1;
        return;
    L18:
        a("<solidColor>", new Object[0]);
        if (this.b == null) goto L22;
        SVG.y r1 = new SVG.y();
        r1.a = this.a;
        r1.b = this.b;
        c(r1, r28);
        f(r1, r28);
        this.b.b(r1);
        this.b = r1;
        return;
    L22:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L23:
        a("<image>", new Object[0]);
        if (this.b == null) goto L58;
        SVG.n r2 = new SVG.n();
        r2.a = this.a;
        r2.b = this.b;
        c(r2, r28);
        f(r2, r28);
        g(r2, r28);
    L27:
        if (r9 >= r28.getLength()) goto L56;
        String r7 = r28.getValue(r9).trim();
        int r18 = a.b[SVGAttr.fromString(r28.getLocalName(r9)).ordinal()];
        if (r18 == 1) goto L54;
        if (r18 == 2) goto L53;
        if (r18 == 3) goto L48;
        if (r18 == 4) goto L43;
        if (r18 == 6) goto L39;
        if (r18 != 7) goto L55;
        q(r2, r7);
    L55:
        r9 = r9 + 1;
        goto L27
    L39:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r28.getURI(r9)) == false) goto L41;
    L42:
        r2.j = r7;
        goto L55
    L41:
        if ("http://www.w3.org/1999/xlink".equals(r28.getURI(r9)) == false) goto L55;
    L43:
        SVG.o r19 = m(r7);
        r2.n = r19;
        if (r19.f() == false) goto L55;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L48:
        SVG.o r20 = m(r7);
        r2.m = r20;
        if (r20.f() == false) goto L55;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L53:
        r2.l = m(r7);
        goto L55
    L54:
        r2.k = m(r7);
        goto L55
    L56:
        this.b.b(r2);
        this.b = r2;
        return;
    L58:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L59:
        a("<pattern>", new Object[0]);
        if (this.b == null) goto L105;
        SVG.u r3 = new SVG.u();
        r3.a = this.a;
        r3.b = this.b;
        c(r3, r28);
        f(r3, r28);
        h(r3, r28);
    L63:
        if (r10 >= r28.getLength()) goto L103;
        String r21 = r28.getValue(r10).trim();
        int r110 = a.b[SVGAttr.fromString(r28.getLocalName(r10)).ordinal()];
        if (r110 == 1) goto L101;
        if (r110 == 2) goto L100;
        if (r110 == 3) goto L95;
        if (r110 == 4) goto L90;
        if (r110 == 6) goto L86;
        switch(r110) {
            case 26: goto L80;
            case 27: goto L74;
            case 28: goto L72;
            default: goto L102;
        };
    L72:
        r3.m = r(r21);
        goto L102
    L74:
        if ("objectBoundingBox".equals(r21) == false) goto L77;
        r3.l = Boolean.FALSE;
        goto L102
    L77:
        if ("userSpaceOnUse".equals(r21) == false) goto L102;
        r3.l = Boolean.TRUE;
        goto L102
    L80:
        if ("objectBoundingBox".equals(r21) == false) goto L83;
        r3.k = Boolean.FALSE;
        goto L102
    L83:
        if ("userSpaceOnUse".equals(r21) == false) goto L102;
        r3.k = Boolean.TRUE;
    L102:
        r10 = r10 + 1;
        goto L63
    L86:
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r28.getURI(r10)) == false) goto L88;
    L89:
        r3.r = r21;
        goto L102
    L88:
        if ("http://www.w3.org/1999/xlink".equals(r28.getURI(r10)) == false) goto L102;
    L90:
        SVG.o r22 = m(r21);
        r3.q = r22;
        if (r22.f() == false) goto L102;
        throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
    L95:
        SVG.o r23 = m(r21);
        r3.p = r23;
        if (r23.f() == false) goto L102;
        throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
    L100:
        r3.o = m(r21);
        goto L102
    L101:
        r3.n = m(r21);
        goto L102
    L103:
        this.b.b(r3);
        this.b = r3;
        return;
    L105:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L106:
        a("<clipPath>", new Object[0]);
        if (this.b == null) goto L125;
        SVG.e r4 = new SVG.e();
        r4.a = this.a;
        r4.b = this.b;
        c(r4, r28);
        f(r4, r28);
        g(r4, r28);
    L110:
        if (r11 >= r28.getLength()) goto L123;
        String r5 = r28.getValue(r11).trim();
        if (a.b[SVGAttr.fromString(r28.getLocalName(r11)).ordinal()] != 25) goto L120;
        if ("objectBoundingBox".equals(r5) == false) goto L118;
        r4.j = Boolean.FALSE;
        goto L120
    L118:
        if ("userSpaceOnUse".equals(r5) == false) goto L122;
        r4.j = Boolean.TRUE;
        goto L120
    L122:
        throw new SVGParseException("Invalid value for attribute clipPathUnits");
    L120:
        r11 = r11 + 1;
        goto L110
    L123:
        this.b.b(r4);
        this.b = r4;
        return;
    L125:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L126:
        a("<stop>", new Object[0]);
        SVG.c0 r6 = this.b;
        if (r6 == null) goto L163;
        if ((r6 instanceof SVG.j) == false) goto L161;
        SVG.z r24 = new SVG.z();
        r24.a = this.a;
        r24.b = this.b;
        c(r24, r28);
        f(r24, r28);
        int r29 = 0;
    L132:
        if (r29 >= r28.getLength()) goto L159;
        String r30 = r28.getValue(r29).trim();
        if (a.b[SVGAttr.fromString(r28.getLocalName(r29)).ordinal()] != 24) goto L153;
        if (r30.length() == 0) goto L158;
        int r31 = r30.length();
        if (r30.charAt(r30.length() - 1) != '%') goto L141;
        r31 = r31 - 1;
        boolean r32 = true;
    L536:
        float r33 = l(r30, r31);     // Catch: NumberFormatException -> L154
        if (r32 == false) goto L146;
        r33 = r33 / 100.0f;     // Catch: NumberFormatException -> L154
    L146:
        if (r33 >= 0.0f) goto L149;
        r33 = 0.0f;
    L152:
        r24.g = Float.valueOf(r33);
        goto L153
    L149:
        if (r33 <= 100.0f) goto L152;
        r33 = 100.0f;
    L154:
        e = move-exception;
        throw new SVGParseException("Invalid offset value in <stop>: ".concat(r30), e);
    L141:
        r32 = false;
        goto L536
    L158:
        throw new SVGParseException("Invalid offset value in <stop> (empty string)");
    L153:
        r29 = r29 + 1;
        goto L132
    L159:
        this.b.b(r24);
        this.b = r24;
        return;
    L161:
        throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
    L163:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L164:
        a("<radialGradient>", new Object[0]);
        if (this.b == null) goto L187;
        SVG.j0 r34 = new SVG.j0();
        r34.a = this.a;
        r34.b = this.b;
        c(r34, r28);
        f(r34, r28);
        d(r34, r28);
    L168:
        if (r12 >= r28.getLength()) goto L185;
        String r35 = r28.getValue(r12).trim();
        int r36 = a.b[SVGAttr.fromString(r28.getLocalName(r12)).ordinal()];
        if (r36 != 22) goto L172;
        r34.o = m(r35);
    L184:
        r12 = r12 + 1;
        goto L168
    L172:
        if (r36 == 23) goto L182;
        switch(r36) {
            case 12: goto L181;
            case 13: goto L180;
            case 14: goto L175;
            default: goto L184;
        };
    L175:
        SVG.o r37 = m(r35);
        r34.n = r37;
        if (r37.f() == false) goto L184;
        throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
    L180:
        r34.m = m(r35);
        goto L184
    L181:
        r34.l = m(r35);
        goto L184
    L182:
        r34.p = m(r35);
        goto L184
    L185:
        this.b.b(r34);
        this.b = r34;
        return;
    L187:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L188:
        a("<linearGradient>", new Object[0]);
        if (this.b == null) goto L203;
        SVG.f0 r38 = new SVG.f0();
        r38.a = this.a;
        r38.b = this.b;
        c(r38, r28);
        f(r38, r28);
        d(r38, r28);
    L192:
        if (r13 >= r28.getLength()) goto L201;
        String r39 = r28.getValue(r13).trim();
        switch(a.b[SVGAttr.fromString(r28.getLocalName(r13)).ordinal()]) {
            case 15: goto L199;
            case 16: goto L198;
            case 17: goto L197;
            case 18: goto L196;
            default: goto L200;
        };
    L196:
        r38.o = m(r39);
        goto L200
    L197:
        r38.n = m(r39);
        goto L200
    L198:
        r38.m = m(r39);
        goto L200
    L199:
        r38.l = m(r39);
    L200:
        r13 = r13 + 1;
        goto L192
    L201:
        this.b.b(r38);
        this.b = r38;
        return;
    L203:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L204:
        a("<polygon>", new Object[0]);
        if (this.b == null) goto L208;
        SVG.w r40 = new SVG.w();
        r40.a = this.a;
        r40.b = this.b;
        c(r40, r28);
        f(r40, r28);
        g(r40, r28);
        e(r40, r28, SVGRenderEngine.POLYGON);
        this.b.b(r40);
        return;
    L208:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L209:
        a("<polyline>", new Object[0]);
        if (this.b == null) goto L213;
        SVG.v r41 = new SVG.v();
        r41.a = this.a;
        r41.b = this.b;
        c(r41, r28);
        f(r41, r28);
        g(r41, r28);
        e(r41, r28, SVGRenderEngine.POLYLINE);
        this.b.b(r41);
        return;
    L213:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L214:
        a("<line>", new Object[0]);
        if (this.b == null) goto L229;
        SVG.p r42 = new SVG.p();
        r42.a = this.a;
        r42.b = this.b;
        c(r42, r28);
        f(r42, r28);
        g(r42, r28);
    L218:
        if (r14 >= r28.getLength()) goto L227;
        String r43 = r28.getValue(r14).trim();
        switch(a.b[SVGAttr.fromString(r28.getLocalName(r14)).ordinal()]) {
            case 15: goto L225;
            case 16: goto L224;
            case 17: goto L223;
            case 18: goto L222;
            default: goto L226;
        };
    L222:
        r42.l = m(r43);
        goto L226
    L223:
        r42.k = m(r43);
        goto L226
    L224:
        r42.j = m(r43);
        goto L226
    L225:
        r42.i = m(r43);
    L226:
        r14 = r14 + 1;
        goto L218
    L227:
        this.b.b(r42);
        return;
    L229:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L230:
        a("<ellipse>", new Object[0]);
        if (this.b == null) goto L253;
        SVG.i r44 = new SVG.i();
        r44.a = this.a;
        r44.b = this.b;
        c(r44, r28);
        f(r44, r28);
        g(r44, r28);
    L234:
        if (r15 >= r28.getLength()) goto L251;
        String r45 = r28.getValue(r15).trim();
        switch(a.b[SVGAttr.fromString(r28.getLocalName(r15)).ordinal()]) {
            case 10: goto L245;
            case 11: goto L240;
            case 12: goto L239;
            case 13: goto L238;
            default: goto L250;
        };
    L238:
        r44.j = m(r45);
        goto L250
    L239:
        r44.i = m(r45);
        goto L250
    L240:
        SVG.o r46 = m(r45);
        r44.l = r46;
        if (r46.f() == false) goto L250;
        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
    L245:
        SVG.o r47 = m(r45);
        r44.k = r47;
        if (r47.f() == false) goto L250;
        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
    L250:
        r15 = r15 + 1;
        goto L234
    L251:
        this.b.b(r44);
        return;
    L253:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L254:
        a("<circle>", new Object[0]);
        if (this.b == null) goto L272;
        SVG.d r48 = new SVG.d();
        r48.a = this.a;
        r48.b = this.b;
        c(r48, r28);
        f(r48, r28);
        g(r48, r28);
    L258:
        if (r16 >= r28.getLength()) goto L270;
        String r49 = r28.getValue(r16).trim();
        switch(a.b[SVGAttr.fromString(r28.getLocalName(r16)).ordinal()]) {
            case 12: goto L268;
            case 13: goto L267;
            case 14: goto L262;
            default: goto L269;
        };
    L262:
        SVG.o r50 = m(r49);
        r48.k = r50;
        if (r50.f() == false) goto L269;
        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
    L267:
        r48.j = m(r49);
        goto L269
    L268:
        r48.i = m(r49);
    L269:
        r16 = r16 + 1;
        goto L258
    L270:
        this.b.b(r48);
        return;
    L272:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L273:
        a("<rect>", new Object[0]);
        if (this.b == null) goto L313;
        SVG.x r51 = new SVG.x();
        r51.a = this.a;
        r51.b = this.b;
        c(r51, r28);
        f(r51, r28);
        g(r51, r28);
    L277:
        if (r17 >= r28.getLength()) goto L311;
        String r52 = r28.getValue(r17).trim();
        int r53 = a.b[SVGAttr.fromString(r28.getLocalName(r17)).ordinal()];
        if (r53 == 1) goto L309;
        if (r53 == 2) goto L308;
        if (r53 == 3) goto L303;
        if (r53 != 4) goto L284;
        SVG.o r54 = m(r52);
        r51.l = r54;
        if (r54.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. height cannot be negative");
    L310:
        r17 = r17 + 1;
        goto L277
    L284:
        if (r53 != 10) goto L286;
        SVG.o r55 = m(r52);
        r51.m = r55;
        if (r55.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
    L286:
        if (r53 != 11) goto L310;
        SVG.o r56 = m(r52);
        r51.n = r56;
        if (r56.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
    L303:
        SVG.o r57 = m(r52);
        r51.k = r57;
        if (r57.f() == false) goto L310;
        throw new SVGParseException("Invalid <rect> element. width cannot be negative");
    L308:
        r51.j = m(r52);
        goto L310
    L309:
        r51.i = m(r52);
        goto L310
    L311:
        this.b.b(r51);
        return;
    L313:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L314:
        a("<path>", new Object[0]);
        if (this.b == null) goto L460;
        SVG.s r58 = new SVG.s();
        r58.a = this.a;
        r58.b = this.b;
        c(r58, r28);
        f(r58, r28);
        g(r58, r28);
        int r59 = 0;
    L318:
        if (r59 >= r28.getLength()) goto L458;
        String r60 = r28.getValue(r59).trim();
        int r61 = a.b[SVGAttr.fromString(r28.getLocalName(r59)).ordinal()];
        byte r111 = 8;
        if (r61 != 8) goto L322;
        c r62 = new c(r60);
        SVG.t r63 = new SVG.t();
        if (r62.e() == true) goto L456;
        int r112 = r62.b;
        if (r112 != r62.c) goto L335;
        Integer r113 = null;
    L336:
        int r114 = r113.intValue();
        if (r114 == 77) goto L340;
        if (r114 != 109) goto L456;
    L340:
        int r64 = r114;
        float r115 = 0.0f;
        float r116 = 0.0f;
        float r117 = 0.0f;
        float r118 = 0.0f;
        float r119 = 0.0f;
        float r210 = 0.0f;
    L341:
        r62.l();
        switch(r64) {
            case 65: goto L411;
            case 67: goto L403;
            case 72: goto L395;
            case 76: goto L389;
            case 77: goto L374;
            case 81: goto L367;
            case 83: goto L360;
            case 84: goto L353;
            case 86: goto L345;
            case 90: goto L344;
            case 97: goto L411;
            case 99: goto L403;
            case 104: goto L395;
            case 108: goto L389;
            case 109: goto L374;
            case 113: goto L367;
            case 115: goto L360;
            case 116: goto L353;
            case 118: goto L345;
            case 122: goto L344;
            default: goto L456;
        };
    L344:
        r63.a(r111);
        r115 = r119;
        r116 = r115;
        r118 = r210;
    L430:
        r117 = r118;
    L431:
        r62.k();
        if (r62.e() == true) goto L456;
        int r65 = r62.b;
        if (r65 == r62.c) goto L446;
        char r66 = r62.a.charAt(r65);
        if (r66 < 'a') goto L442;
        if (r66 > 'z') goto L442;
    L445:
        boolean r67 = true;
    L447:
        if (r67 == false) goto L453;
        int r68 = r62.b;
        if (r68 != r62.c) goto L451;
        Integer r69 = null;
    L452:
        r64 = r69.intValue();
        goto L453
    L451:
        String r70 = r62.a;
        r62.b = r68 + 1;
        r69 = Integer.valueOf(r70.charAt(r68));
    L453:
        r8 = 0;
        r111 = 8;
    L442:
        if (r66 < 'A') goto L446;
        if (r66 <= 'Z') goto L445;
    L446:
        r67 = false;
        goto L447
    L345:
        r118 = r62.g();
        if (Float.isNaN(r118) == true) goto L456;
        if (r64 != 118) goto L351;
        r118 = r118 + r117;
    L351:
        r63.d(r115, r118);
        goto L430
    L353:
        float r120 = (r115 * 2.0f) - r116;
        float r121 = (2.0f * r117) - r118;
        float r122 = r62.g();
        float r123 = r62.c(r122);
        if (Float.isNaN(r123) == true) goto L456;
        if (r64 != 116) goto L359;
        r122 = r122 + r115;
        r123 = r123 + r117;
    L359:
        float r124 = r123;
        r63.e(r120, r121, r122, r124);
    L410:
        r117 = r124;
        r115 = r122;
        r118 = r121;
        r116 = r120;
        goto L431
    L360:
        float r125 = (r115 * 2.0f) - r116;
        float r126 = (2.0f * r117) - r118;
        float r127 = r62.g();
        float r128 = r62.c(r127);
        float r71 = r62.c(r128);
        float r129 = r62.c(r71);
        if (Float.isNaN(r129) == true) goto L456;
        if (r64 != 115) goto L366;
        r71 = r71 + r115;
        r129 = r129 + r117;
        r127 = r127 + r115;
        r128 = r128 + r117;
    L366:
        float r72 = r127;
        float r211 = r128;
        float r212 = r129;
        r63.c(r125, r126, r72, r211, r71, r212);
        r122 = r71;
        r120 = r72;
        r121 = r211;
        r124 = r212;
        goto L410
    L367:
        float r73 = r62.g();
        float r74 = r62.c(r73);
        float r130 = r62.c(r74);
        float r131 = r62.c(r130);
        if (Float.isNaN(r131) == true) goto L456;
        if (r64 != 113) goto L373;
        r130 = r130 + r115;
        r131 = r131 + r117;
        r73 = r73 + r115;
        r74 = r74 + r117;
    L373:
        r117 = r131;
        float r132 = r74;
        r63.e(r73, r132, r130, r117);
        r120 = r73;
        float r75 = r132;
        r122 = r130;
    L402:
        r121 = r75;
        r124 = r117;
        goto L410
    L374:
        float r76 = r62.g();
        float r77 = r62.c(r76);
        if (Float.isNaN(r77) == true) goto L456;
        if (r64 == 109) goto L379;
    L384:
        r119 = r76;
        r210 = r77;
        r63.a(r8);
        r63.b(2);
        float[] r78 = r63.c;
        int r79 = r63.d;
        int r133 = r79 + 1;
        r78[r79] = r119;
        r63.d = r133 + 1;
        r78[r133] = r210;
        if (r64 != 109) goto L387;
        r64 = 108;
    L388:
        r122 = r119;
        r120 = r122;
        r124 = r210;
        r121 = r124;
        goto L410
    L387:
        r64 = 76;
        goto L388
    L379:
        if (r63.b != 0) goto L381;
        boolean r134 = true;
    L382:
        if (r134 == true) goto L384;
        r76 = r76 + r115;
        r77 = r77 + r117;
        goto L384
    L381:
        r134 = false;
        goto L382
    L389:
        float r80 = r62.g();
        float r81 = r62.c(r80);
        if (Float.isNaN(r81) == true) goto L456;
        if (r64 != 108) goto L394;
        r80 = r80 + r115;
        r81 = r81 + r117;
    L394:
        r115 = r80;
        r118 = r81;
        r63.d(r115, r118);
        r116 = r115;
        goto L430
    L395:
        float r82 = r62.g();
        if (Float.isNaN(r82) == true) goto L456;
        if (r64 != 104) goto L401;
        r82 = r82 + r115;
    L401:
        r63.d(r82, r117);
        r120 = r82;
        r75 = r118;
        r122 = r120;
        goto L402
    L403:
        float r83 = r62.g();
        float r84 = r62.c(r83);
        float r135 = r62.c(r84);
        float r136 = r62.c(r135);
        float r137 = r62.c(r136);
        float r138 = r62.c(r137);
        if (Float.isNaN(r138) == true) goto L456;
        if (r64 != 99) goto L409;
        r137 = r137 + r115;
        r138 = r138 + r117;
        r83 = r83 + r115;
        r84 = r84 + r117;
        r135 = r135 + r115;
        r136 = r136 + r117;
    L409:
        float r139 = r84;
        float r85 = r136;
        float r140 = r137;
        float r213 = r138;
        float r214 = r135;
        r63.c(r83, r139, r214, r85, r140, r213);
        r120 = r214;
        r121 = r85;
        r122 = r140;
        r124 = r213;
        goto L410
    L411:
        float r86 = r62.g();
        float r87 = r62.c(r86);
        float r141 = r62.c(r87);
        Boolean r142 = r62.b(Float.valueOf(r141));
        Boolean r143 = r62.b(r142);
        if (r143 != null) goto L414;
        float r144 = Float.NaN;
    L415:
        float r145 = r62.c(r144);
        if (Float.isNaN(r145) == true) goto L456;
        if (r86 < 0.0f) goto L456;
        if (r87 < 0.0f) goto L456;
        if (r64 != 97) goto L425;
        r144 = r144 + r115;
        r145 = r145 + r117;
    L425:
        r115 = r144;
        boolean r88 = r142.booleanValue();
        boolean r146 = r143.booleanValue();
        if (r88 == false) goto L428;
        int r89 = 2;
    L429:
        r63.a(((r89 | 4) | (r146 ? 1 : 0)) == true ? 1 : 0);
        r63.b(5);
        float[] r90 = r63.c;
        int r147 = r63.d;
        int r148 = r147 + 1;
        r90[r147] = r86;
        int r91 = r148 + 1;
        r90[r148] = r87;
        int r92 = r91 + 1;
        r90[r91] = r141;
        int r93 = r92 + 1;
        r90[r92] = r115;
        r63.d = r93 + 1;
        r90[r93] = r145;
        r116 = r115;
        r118 = r145;
        goto L430
    L428:
        r89 = 0;
        goto L429
    L414:
        r62.k();
        r144 = r62.g();
        goto L415
    L335:
        String r149 = r62.a;
        r62.b = r112 + 1;
        r113 = Integer.valueOf(r149.charAt(r112));
    L456:
        r58.i = r63;
    L457:
        r59 = r59 + 1;
        r8 = 0;
        goto L318
    L322:
        if (r61 != 9) goto L457;
        if (Float.valueOf(k(r60)).floatValue() >= 0.0f) goto L457;
        throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
    L458:
        this.b.b(r58);
        return;
    L460:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L461:
        a("<use>", new Object[0]);
        if (this.b == null) goto L495;
        SVG.l0 r94 = new SVG.l0();
        r94.a = this.a;
        r94.b = this.b;
        c(r94, r28);
        f(r94, r28);
        g(r94, r28);
        int r95 = 0;
    L465:
        if (r95 >= r28.getLength()) goto L493;
        String r96 = r28.getValue(r95).trim();
        int r97 = a.b[SVGAttr.fromString(r28.getLocalName(r95)).ordinal()];
        if (r97 != 1) goto L469;
        r94.k = m(r96);
    L492:
        r95 = r95 + 1;
        goto L465
    L469:
        if (r97 == 2) goto L490;
        if (r97 != 3) goto L472;
        SVG.o r98 = m(r96);
        r94.m = r98;
        if (r98.f() == false) goto L492;
        throw new SVGParseException("Invalid <use> element. width cannot be negative");
    L472:
        if (r97 == 4) goto L480;
        if (r97 != 6) goto L492;
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r28.getURI(r95)) == false) goto L478;
    L479:
        r94.j = r96;
        goto L492
    L478:
        if ("http://www.w3.org/1999/xlink".equals(r28.getURI(r95)) == false) goto L492;
    L480:
        SVG.o r99 = m(r96);
        r94.n = r99;
        if (r99.f() == false) goto L492;
        throw new SVGParseException("Invalid <use> element. height cannot be negative");
    L490:
        r94.l = m(r96);
        goto L492
    L493:
        this.b.b(r94);
        this.b = r94;
        return;
    L495:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L496:
        a("<defs>", new Object[0]);
        if (this.b == null) goto L500;
        SVG.h r100 = new SVG.h();
        r100.a = this.a;
        r100.b = this.b;
        c(r100, r28);
        f(r100, r28);
        g(r100, r28);
        this.b.b(r100);
        this.b = r100;
        return;
    L500:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L501:
        a("<g>", new Object[0]);
        if (this.b == null) goto L505;
        SVG.l r101 = new SVG.l();
        r101.a = this.a;
        r101.b = this.b;
        c(r101, r28);
        f(r101, r28);
        g(r101, r28);
        this.b.b(r101);
        this.b = r101;
        return;
    L505:
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    L506:
        a("<svg>", new Object[0]);
        SVG.a0 r102 = new SVG.a0();
        r102.a = this.a;
        r102.b = this.b;
        c(r102, r28);
        f(r102, r28);
        h(r102, r28);
        int r103 = 0;
    L508:
        if (r103 >= r28.getLength()) goto L530;
        String r104 = r28.getValue(r103).trim();
        int r105 = a.b[SVGAttr.fromString(r28.getLocalName(r103)).ordinal()];
        if (r105 != 1) goto L512;
        r102.k = m(r104);
    L529:
        r103 = r103 + 1;
        goto L508
    L512:
        if (r105 == 2) goto L527;
        if (r105 != 3) goto L515;
        SVG.o r106 = m(r104);
        r102.m = r106;
        if (r106.f() == false) goto L529;
        throw new SVGParseException("Invalid <svg> element. width cannot be negative");
    L515:
        if (r105 != 4) goto L529;
        SVG.o r107 = m(r104);
        r102.n = r107;
        if (r107.f() == false) goto L529;
        throw new SVGParseException("Invalid <svg> element. height cannot be negative");
    L527:
        r102.l = m(r104);
        goto L529
    L530:
        SVG.c0 r108 = this.b;
        if (r108 != null) goto L533;
        this.a.a = r102;
    L534:
        this.b = r102;
        return;
    L533:
        r108.b(r102);
        goto L534
    L14:
        r0 = r27;
        goto L15
    }
}
