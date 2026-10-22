package r4;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ies.web.jsbridge2.p;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint.Cap f21674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint.Join f21675c;
    public Paint.Align d;
    public float e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f21676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f21677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f21678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f21679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f21680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Shader f21682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PorterDuffXfermode f21683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f21684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f21685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Typeface f21686r;
    public boolean s;

    @Override // r4.a
    public final String d() {
        return "ps";
    }

    @Override // r4.a
    public final void e(HashMap r20, q4.c r21) {
        Intrinsics.checkNotNullParameter(r20, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r21, "dataManager");
        Object r5 = r20.get("st");
        if (r5 == null) goto L262;
        String r10 = (String) r5;
        this.f21684p = r10;
        String r11 = "";
        switch(r10.hashCode()) {
            case 3104: goto L253;
            case 3146: goto L244;
            case 3277: goto L235;
            case 3278: goto L215;
            case 3290: goto L210;
            case 3447: goto L184;
            case 3454: goto L157;
            case 3467: goto L152;
            case 3487: goto L147;
            case 3664: goto L138;
            case 3679: goto L133;
            case 3680: goto L124;
            case 3685: goto L119;
            case 3686: goto L114;
            case 3693: goto L82;
            case 102163: goto L18;
            case 113963: goto L13;
            case 114149: goto L8;
            default: goto L263;
        };
    L263:
        return;
    L8:
        if (r10.equals("srd") == false) goto L264;
        float r12 = a.b("x0", r20);
        float r13 = a.b("y0", r20);
        float r14 = a.b("r0", r20);
        a.b("x1", r20);
        a.b("y1", r20);
        a.b("r1", r20);
        this.f21682n = new RadialGradient(r12, r13, r14, a.h(r20), a.g(r20), Shader.TileMode.MIRROR);
        return;
    L264:
        return;
    L13:
        if (r10.equals("sld") == false) goto L265;
        this.f21682n = new LinearGradient(a.b("x0", r20), a.b("y0", r20), a.b("x1", r20), a.b("y1", r20), a.h(r20), a.g(r20), Shader.TileMode.MIRROR);
        return;
    L265:
        return;
    L18:
        if (r10.equals("gco") == false) goto L266;
        String r15 = (String) r20.get("v");
        if (r15 == null) goto L25;
        r11 = r15;
    L25:
        if (r11.length() != 0) goto L28;
        return;
    L28:
        switch(r11.hashCode()) {
            case -1763725041: goto L76;
            case -1698458601: goto L72;
            case -1112602980: goto L68;
            case -131372090: goto L64;
            case -130953402: goto L60;
            case 118875: goto L56;
            case 3059573: goto L52;
            case 3392903: goto L50;
            case 94746189: goto L47;
            case 170546243: goto L43;
            case 912936772: goto L39;
            case 1158680499: goto L35;
            case 1159099187: goto L31;
            default: goto L77;
        };
    L50:
        r11.equals("null");
    L77:
        PorterDuffXfermode r16 = null;
    L79:
        this.f21683o = r16;
        return;
    L31:
        if (r11.equals("destination-over") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
        goto L79
    L35:
        if (r11.equals("destination-atop") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
        goto L79
    L39:
        if (r11.equals("destination-in") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        goto L79
    L43:
        if (r11.equals("lighter") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN);
        goto L79
    L47:
        if (r11.equals("clear") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        goto L79
    L52:
        if (r11.equals("copy") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.ADD);
        goto L79
    L56:
        if (r11.equals("xor") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        goto L79
    L60:
        if (r11.equals("source-over") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        goto L79
    L64:
        if (r11.equals("source-atop") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        goto L79
    L68:
        if (r11.equals("source-out") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        goto L79
    L72:
        if (r11.equals("source-in") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        goto L79
    L76:
        if (r11.equals("destination-out") == false) goto L77;
        r16 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        goto L79
    L266:
        return;
    L82:
        if (r10.equals("ta") == false) goto L268;
        String r17 = (String) r20.get("v");
        if (r17 == null) goto L89;
        r11 = r17;
    L89:
        switch(r11.hashCode()) {
            case -1364013995: goto L108;
            case 100571: goto L104;
            case 3317767: goto L100;
            case 108511772: goto L96;
            case 109757538: goto L92;
            default: goto L109;
        };
    L109:
        Paint.Align r18 = Paint.Align.RIGHT;
    L111:
        this.d = r18;
        return;
    L92:
        if (r11.equals("start") == false) goto L109;
        r18 = Paint.Align.LEFT;
        goto L111
    L96:
        if (r11.equals("right") == false) goto L109;
        r18 = Paint.Align.RIGHT;
        goto L111
    L100:
        if (r11.equals(OpenPageMethod.ALIGN_LEFT) == false) goto L109;
        r18 = Paint.Align.LEFT;
        goto L111
    L104:
        if (r11.equals("end") == false) goto L109;
        r18 = Paint.Align.RIGHT;
        goto L111
    L108:
        if (r11.equals("center") == false) goto L109;
        r18 = Paint.Align.CENTER;
        goto L111
    L268:
        return;
    L114:
        if (r10.equals("sy") == false) goto L269;
        this.f21679k = a.b("v", r20);
        return;
    L269:
        return;
    L119:
        if (r10.equals("sx") == false) goto L270;
        this.f21678j = a.b("v", r20);
        return;
    L270:
        return;
    L124:
        if (r10.equals("ss") == false) goto L271;
        String r19 = (String) r20.get("v");
        if (r19 == null) goto L130;
        r11 = r19;
    L130:
        HashMap r22 = s4.a.f21814a;
        this.g = com.lynx.tasm.utils.k.h(r11);
        return;
    L271:
        return;
    L133:
        if (r10.equals("sr") == false) goto L272;
        this.f21680l = a.b("v", r20);
        return;
    L272:
        return;
    L138:
        if (r10.equals("sc") == false) goto L273;
        String r23 = (String) r20.get("v");
        if (r23 == null) goto L144;
        r11 = r23;
    L144:
        HashMap r24 = s4.a.f21814a;
        this.f21681m = com.lynx.tasm.utils.k.h(r11);
        return;
    L273:
        return;
    L147:
        if (r10.equals("ml") == false) goto L274;
        this.f21677i = a.b("v", r20);
        return;
    L274:
        return;
    L152:
        if (r10.equals("lw") == false) goto L275;
        this.e = a.b("v", r20);
        return;
    L275:
        return;
    L157:
        if (r10.equals("lj") == false) goto L276;
        String r25 = (String) r20.get("v");
        if (r25 == null) goto L163;
        r11 = r25;
    L163:
        int r26 = r11.hashCode();
        if (r26 == 93630586) goto L178;
        if (r26 == 103906565) goto L174;
        if (r26 == 108704142) goto L170;
    L180:
        Paint.Join r27 = Paint.Join.BEVEL;
    L181:
        this.f21675c = r27;
        return;
    L170:
        if (r11.equals("round") == false) goto L180;
        r27 = Paint.Join.ROUND;
        goto L181
    L174:
        if (r11.equals("miter") == false) goto L180;
        r27 = Paint.Join.MITER;
        goto L181
    L178:
        if (r11.equals("bevel") == false) goto L180;
        r27 = Paint.Join.BEVEL;
        goto L181
    L276:
        return;
    L184:
        if (r10.equals("lc") == false) goto L277;
        String r28 = (String) r20.get("v");
        if (r28 == null) goto L190;
        r11 = r28;
    L190:
        int r29 = r11.hashCode();
        if (r29 == (-894674659)) goto L204;
        if (r29 == 3035667) goto L201;
        if (r29 == 108704142) goto L197;
    L205:
        Paint.Cap r30 = Paint.Cap.BUTT;
    L207:
        this.f21674b = r30;
        return;
    L197:
        if (r11.equals("round") == false) goto L205;
        r30 = Paint.Cap.ROUND;
        goto L207
    L201:
        if (r11.equals("butt") == false) goto L205;
        r30 = Paint.Cap.BUTT;
        goto L207
    L204:
        if (r11.equals("square") == false) goto L205;
        r30 = Paint.Cap.SQUARE;
        goto L207
    L277:
        return;
    L210:
        if (r10.equals("ga") == false) goto L278;
        r21.f21481c = (int) (255 * a.b("v", r20));
        return;
    L278:
        return;
    L215:
        if (r10.equals("ft") == false) goto L279;
        String r31 = (String) r20.get("v");
        if (r31 == null) goto L222;
        r11 = r31;
    L222:
        if (r11.length() == 0) goto L280;
        HashMap r32 = s4.b.f21815a;
        p r33 = dn.a.H(r11);
        Float r34 = (Float) r33.e;
        if (r34 == null) goto L227;
        float r35 = r34.floatValue();
    L228:
        this.f21676h = r35;
        String r36 = (String) r33.f6304c;
        String r37 = (String) r33.f6303b;
        Integer r38 = (Integer) r33.d;
        if (r38 == null) goto L231;
        int r39 = r38.intValue();
    L232:
        this.f21686r = dn.a.G(r39, r36, r37);
        return;
    L231:
        r39 = 400;
        goto L232
    L227:
        r35 = 20.0f;
        goto L228
    L280:
        return;
    L279:
        return;
    L235:
        if (r10.equals("fs") == false) goto L281;
        String r40 = (String) r20.get("v");
        if (r40 == null) goto L241;
        r11 = r40;
    L241:
        HashMap r41 = s4.a.f21814a;
        this.f = com.lynx.tasm.utils.k.h(r11);
        return;
    L281:
        return;
    L244:
        if (r10.equals("bl") == false) goto L282;
        String r42 = (String) r20.get("v");
        if (r42 == null) goto L250;
        r11 = r42;
    L250:
        this.f21685q = r11;
        return;
    L282:
        return;
    L253:
        if (r10.equals("aa") == true) goto L255;
        return;
    L255:
        Boolean r43 = (Boolean) r20.get("v");
        if (r43 == null) goto L258;
        boolean r44 = r43.booleanValue();
    L259:
        this.s = r44;
        return;
    L258:
        r44 = false;
        goto L259
    L262:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        String r10 = this.f21684p;
        switch(r10.hashCode()) {
            case 3104: goto L90;
            case 3146: goto L85;
            case 3277: goto L80;
            case 3278: goto L75;
            case 3447: goto L70;
            case 3454: goto L65;
            case 3467: goto L60;
            case 3487: goto L55;
            case 3664: goto L50;
            case 3679: goto L45;
            case 3680: goto L40;
            case 3685: goto L35;
            case 3686: goto L30;
            case 3693: goto L25;
            case 102163: goto L20;
            case 113963: goto L13;
            case 114149: goto L6;
            default: goto L96;
        };
    L96:
        return;
    L6:
        if (r10.equals("srd") == false) goto L97;
        Shader r11 = this.f21682n;
        if (r11 == null) goto L91;
        r5.f21477b.setShader(r11);
        return;
    L91:
        return;
    L97:
        return;
    L13:
        if (r10.equals("sld") == false) goto L98;
        Shader r12 = this.f21682n;
        if (r12 == null) goto L94;
        r5.f21477b.setShader(r12);
        return;
    L94:
        return;
    L98:
        return;
    L20:
        if (r10.equals("gco") == false) goto L99;
        r5.f21477b.setXfermode(this.f21683o);
        return;
    L99:
        return;
    L25:
        if (r10.equals("ta") == false) goto L100;
        r5.f21477b.setTextAlign(this.d);
        return;
    L100:
        return;
    L30:
        if (r10.equals("sy") == false) goto L101;
        q4.c r13 = r5.d;
        float r14 = this.f21679k;
        r13.f = r14;
        r5.f21477b.setShadowLayer(r13.g, r13.e, r14, r13.f21482h);
        return;
    L101:
        return;
    L35:
        if (r10.equals("sx") == false) goto L102;
        q4.c r15 = r5.d;
        float r16 = this.f21678j;
        r15.e = r16;
        r5.f21477b.setShadowLayer(r15.g, r16, r15.f, r15.f21482h);
        return;
    L102:
        return;
    L40:
        if (r10.equals("ss") == false) goto L103;
        r5.f21477b.setShader(null);
        q4.c r17 = r5.d;
        r17.f21479a = this.g;
        return;
    L103:
        return;
    L45:
        if (r10.equals("sr") == false) goto L104;
        q4.c r18 = r5.d;
        float r19 = this.f21680l;
        r18.g = r19;
        r5.f21477b.setShadowLayer(r19, r18.e, r18.f, r18.f21482h);
        return;
    L104:
        return;
    L50:
        if (r10.equals("sc") == false) goto L105;
        q4.c r20 = r5.d;
        int r21 = this.f21681m;
        r20.f21482h = r21;
        r5.f21477b.setShadowLayer(r20.g, r20.e, r20.f, r21);
        return;
    L105:
        return;
    L55:
        if (r10.equals("ml") == false) goto L106;
        r5.f21477b.setStrokeMiter(this.f21677i);
        return;
    L106:
        return;
    L60:
        if (r10.equals("lw") == false) goto L107;
        r5.f21477b.setStrokeWidth(this.e);
        return;
    L107:
        return;
    L65:
        if (r10.equals("lj") == false) goto L108;
        r5.f21477b.setStrokeJoin(this.f21675c);
        return;
    L108:
        return;
    L70:
        if (r10.equals("lc") == false) goto L109;
        r5.f21477b.setStrokeCap(this.f21674b);
        return;
    L109:
        return;
    L75:
        if (r10.equals("ft") == false) goto L110;
        Paint r22 = r5.f21477b;
        r22.setTypeface(this.f21686r);
        r22.setTextSize(this.f21676h);
        return;
    L110:
        return;
    L80:
        if (r10.equals("fs") == false) goto L111;
        r5.f21477b.setShader(null);
        q4.c r23 = r5.d;
        r23.f21480b = this.f;
        return;
    L111:
        return;
    L85:
        if (r10.equals("bl") == false) goto L112;
        q4.c r24 = r5.d;
        String r25 = this.f21685q;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r24.d = r25;
        return;
    L112:
        return;
    L90:
        if (r10.equals("aa") == false) goto L95;
        r5.f21477b.setAntiAlias(this.s);
        return;
    }
}
