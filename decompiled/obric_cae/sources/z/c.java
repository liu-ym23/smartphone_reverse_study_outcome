package z;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Shader f14131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f14132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14133c;

    public c(Shader r8, ColorStateList r10, int r11) {
        this.f14131a = r8;
        this.f14132b = r10;
        this.f14133c = r11;
    }

    public static c a(Resources r29, int r30, Resources.Theme r31) {
        XmlResourceParser r8 = r29.getXml(r30);
        AttributeSet r10 = Xml.asAttributeSet(r8);
    L3:
        int r11 = r8.next();
        if (r11 == 2) goto L7;
        if (r11 != 1) goto L3;
    L7:
        if (r11 != 2) goto L91;
        String r12 = r8.getName();
        r12.getClass();
        if (r12.equals("gradient") == false) goto L11;
        String r13 = r8.getName();
        if (r13.equals("gradient") == false) goto L89;
        TypedArray r14 = i.e(r29, r31, r10, y.a.f13902d);
        float r15 = i.b(r14, r8, "startX", 8, 0.0f);
        float r16 = i.b(r14, r8, "startY", 9, 0.0f);
        float r17 = i.b(r14, r8, "endX", 10, 0.0f);
        float r18 = i.b(r14, r8, "endY", 11, 0.0f);
        float r19 = i.b(r14, r8, "centerX", 3, 0.0f);
        float r20 = i.b(r14, r8, "centerY", 4, 0.0f);
        int r110 = i.c(r14, r8, "type", 2, 0);
        if (i.d(r8, "startColor") == true) goto L21;
        int r21 = 0;
    L22:
        boolean r111 = i.d(r8, "centerColor");
        if (i.d(r8, "centerColor") == true) goto L25;
        int r112 = 0;
    L27:
        if (i.d(r8, "endColor") == true) goto L29;
        int r22 = 0;
    L30:
        int r23 = i.c(r14, r8, "tileMode", 6, 0);
        float r24 = i.b(r14, r8, "gradientRadius", 5, 0.0f);
        r14.recycle();
        int r25 = r8.getDepth() + 1;
        ArrayList r113 = new ArrayList(20);
        ArrayList r26 = new ArrayList(20);
    L31:
        int r27 = r8.next();
        float r28 = r17;
        if (r27 == 1) goto L51;
        int r114 = r8.getDepth();
        float r210 = r16;
        if (r114 >= r25) goto L38;
        if (r27 != 3) goto L38;
    L53:
        if (r26.size() <= 0) goto L55;
        e r32 = new e(r26, r113);
    L56:
        if (r32 != null) goto L63;
        if (r111 == false) goto L61;
        r32 = new e(r21, r112, r22);
        goto L63
    L61:
        r32 = new e(r21, r22);
    L63:
        if (r110 == 1) goto L75;
        if (r110 == 2) goto L73;
        int[] r33 = r32.f14144a;
        float[] r34 = r32.f14145b;
        if (r23 == 1) goto L71;
        if (r23 == 2) goto L70;
        Shader.TileMode r35 = Shader.TileMode.CLAMP;
    L72:
        Shader r36 = new LinearGradient(r15, r210, r28, r18, r33, r34, r35);
    L85:
        return new c(r36, null, 0);
    L70:
        r35 = Shader.TileMode.MIRROR;
        goto L72
    L71:
        r35 = Shader.TileMode.REPEAT;
        goto L72
    L73:
        r36 = new SweepGradient(r19, r20, r32.f14144a, r32.f14145b);
        goto L85
    L75:
        if (r24 <= 0.0f) goto L87;
        int[] r37 = r32.f14144a;
        float[] r38 = r32.f14145b;
        if (r23 != 1) goto L79;
        Shader.TileMode r39 = Shader.TileMode.REPEAT;
    L83:
        r36 = new RadialGradient(r19, r20, r24, r37, r38, r39);
        goto L85
    L79:
        if (r23 == 2) goto L81;
        r39 = Shader.TileMode.CLAMP;
        goto L83
    L81:
        r39 = Shader.TileMode.MIRROR;
        goto L83
    L87:
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    L55:
        r32 = null;
    L38:
        if (r27 != 2) goto L50;
        if (r114 > r25) goto L50;
        if (r8.getName().equals("item") == false) goto L50;
        TypedArray r40 = i.e(r29, r31, r10, y.a.f13903e);
        boolean r115 = r40.hasValue(0);
        boolean r211 = r40.hasValue(1);
        if (r115 == false) goto L49;
        if (r211 == false) goto L49;
        int r212 = r40.getColor(0, 0);
        float r213 = r40.getFloat(1, 0.0f);
        r40.recycle();
        r26.add(Integer.valueOf(r212));
        r113.add(Float.valueOf(r213));
    L49:
        throw new XmlPullParserException(r8.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    L50:
        r17 = r28;
        r16 = r210;
        goto L31
    L51:
        r210 = r16;
        goto L53
    L29:
        r22 = r14.getColor(1, 0);
        goto L30
    L25:
        r112 = r14.getColor(7, 0);
        goto L27
    L21:
        r21 = r14.getColor(0, 0);
        goto L22
    L89:
        throw new XmlPullParserException(r8.getPositionDescription() + ": invalid gradient color tag " + r13);
    L11:
        if (r12.equals("selector") == false) goto L15;
        ColorStateList r41 = b.b(r29, r8, r10, r31);
        return new c(null, r41, r41.getDefaultColor());
    L15:
        throw new XmlPullParserException(r8.getPositionDescription() + ": unsupported complex color tag " + r12);
    L91:
        throw new XmlPullParserException("No start tag found");
    }

    public final boolean b() {
        if (this.f14131a != null) goto L9;
        ColorStateList r8 = this.f14132b;
        if (r8 == null) goto L9;
        if (r8.isStateful() == false) goto L9;
        return true;
    L9:
        return false;
    }
}
