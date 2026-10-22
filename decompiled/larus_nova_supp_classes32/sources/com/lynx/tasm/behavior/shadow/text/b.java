package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z6a.j;
import z6a.p;
import z6a.q;
import z6a.r;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final DecimalFormat a = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            a = r0;
            r0[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[ReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[ReadableType.Long.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[ReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[ReadableType.Boolean.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[ReadableType.Null.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        a = new DecimalFormat("###################.###########");
    }

    public static String b(f6a.a r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ReadableType r1 = r3.getType();
        switch(a.a[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L14;
        };
    L14:
        return null;
    L15:
        return String.valueOf(r3.asBoolean());
    L16:
        return h(r3.asDouble());
    L17:
        return String.valueOf(r3.asLong());
    L18:
        return String.valueOf(r3.asInt());
    L13:
        return r3.asString();
    }

    public static String h(double r5) {
        if (r5 >= 9.223372036854776E18d) goto L11;
        if (r5 <= (-9.223372036854776E18d)) goto L11;
        long r0 = (long) Math.floor(r5);
        if (r5 != r0) goto L11;
        return String.valueOf(r0);
    L11:
        return a.format(r5);
    }

    public static void e(Canvas r22, Layout r23) {
        Spanned r0 = (Spanned) r23.getText();
        q[] r1 = (q[]) r0.getSpans(0, r0.length(), q.class);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.length == 0) goto L51;
        int r10 = r0.getSpanStart(r1[0]);
        int r2 = r0.getSpanEnd(r1[0]);
        int r9 = (int) r23.getPaint().getTextSize();
        if (r10 != 0) goto L34;
        int r5 = 1;
    L11:
        if (r5 >= r1.length) goto L33;
        int r6 = r0.getSpanStart(r1[r5]);
        int r7 = r0.getSpanEnd(r1[r5]);
        AbsoluteSizeSpan[] r8 = (AbsoluteSizeSpan[]) r0.getSpans(r6, r7, AbsoluteSizeSpan.class);
        if (r8.length == 0) goto L15;
        int r11 = r8[0].getSize();
    L16:
        q r12 = r1[r5];
        d(r22, r23, r12.c, r12.d, r12.a, r12.b, r6, r7, r11);
        if (r6 < r10) goto L32;
        if (r7 > r2) goto L32;
        q r13 = r1[0];
        d(r22, r23, r13.c, r13.d, r13.a, r13.b, r7 + 1, r2, r9);
        q r3 = r1[0];
        if (r3.a == true) goto L22;
    L24:
        boolean r15 = false;
    L26:
        if (r3.b == true) goto L28;
    L30:
        boolean r16 = false;
    L31:
        d(r22, r23, r3.c, r3.d, r15, r16, r6, r7, r11);
        r2 = r6;
        goto L32
    L28:
        if (r1[r5].b == true) goto L30;
        r16 = true;
        goto L31
    L22:
        if (r1[r5].a == true) goto L24;
        r15 = true;
    L32:
        r5 = r5 + 1;
        goto L11
    L15:
        r11 = r9;
        goto L16
    L33:
        q r4 = r1[0];
        d(r22, r23, r4.c, r4.d, r4.a, r4.b, r10, r2, r9);
        return;
    L34:
        int r14 = 0;
    L36:
        if (r14 >= r1.length) goto L52;
        int r17 = r0.getSpanStart(r1[r14]);
        int r18 = r0.getSpanEnd(r1[r14]);
        AbsoluteSizeSpan[] r19 = (AbsoluteSizeSpan[]) r0.getSpans(r17, r18, AbsoluteSizeSpan.class);
        if (r19.length == 0) goto L40;
        int r21 = r19[0].getSize();
    L41:
        q r20 = r1[r14];
        d(r22, r23, r20.c, r20.d, r20.a, r20.b, r17, r18, r21);
        r14 = r14 + 1;
        goto L36
    L40:
        r21 = r9;
        goto L41
    L52:
        return;
    }

    public static void g(Layout r6, Canvas r7) {
        Spanned r0 = (Spanned) r6.getText();
        j[] r1 = (j[]) r0.getSpans(0, r0.length(), j.class);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.length <= 0) goto L15;
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r1[r3].d = true;
        r3 = r3 + 1;
        goto L7
    L9:
        r6.draw(r7);
        int r8 = r1.length;
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L16;
        r1[r9].d = false;
        r9 = r9 + 1;
        goto L10
    L16:
        return;
    }

    public static TextPaint k(float r2, String r3) {
        TextPaint r0 = new TextPaint(1);
        r0.setTextSize(r2);
        if (TextUtils.isEmpty(r3) == true) goto L5;
        Typeface r4 = g.c(r3, 0);
    L6:
        if (r4 == null) goto L8;
        r0.setTypeface(r4);
    L9:
        return r0;
    L8:
        r0.setTypeface(DeviceUtils.b());
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public static TextPaint l(com.lynx.tasm.behavior.shadow.text.a r8, Typeface r9) {
        TextPaint r7 = new TextPaint(1);
        r7.setTextSize(r8.n);
        if (TextUtils.isEmpty(r8.u) == true) goto L6;
        if (r9 == null) goto L6;
        r7.setTypeface(r9);
    L7:
        String r4 = r8.c();
        String r5 = r8.E;
        int r2 = r8.h;
        if (r2 == 0) goto L10;
    L13:
        n(r7, r8.u, r2, r8.g, r4, r5, r8.B);
    L14:
        Integer r10 = r8.c;
        if (r10 == null) goto L17;
        r7.setColor(r10.intValue());
    L17:
        float r11 = r8.l;
        if (r11 == 1.0E21f) goto L20;
        r7.setLetterSpacing(r11 / r7.getTextSize());
    L20:
        com.lynx.tasm.behavior.ui.g r12 = r8.I;
        if (r12 == null) goto L23;
        r7.setShadowLayer(r12.d, r12.b, r12.c, r12.a);
    L23:
        return r7;
    L10:
        if (r8.g != 0) goto L13;
        if (r4 != null) goto L13;
        if (r5 == null) goto L14;
    L6:
        r7.setTypeface(DeviceUtils.b());
        goto L7
    }

    public static ArrayList<CharSequence> m(CharSequence r6, boolean r7) {
        ArrayList<CharSequence> r0 = new ArrayList();
        boolean r1 = false;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r6.length()) goto L30;
        char r4 = r6.charAt(r2);
        if (r4 < 19968) goto L11;
        if (r4 > 40869) goto L11;
        Pattern r5 = PatternProtector.compile("[一-龥][\\u3002\\uff1f\\uff01\\uff0c\\u3001\\uff1b\\uff1a\\u2018\\u2019\\u201c\\u201d\\uff08\\uff09\\u3014\\u3015\\u3010\\u3011\\u2026\\u2014\\p{Punct}]*");
    L20:
        if (r5 != null) goto L21;
        if (Character.isHighSurrogate(r4) == true) goto L27;
        r2 = r2 + 1;
        goto L4
    L27:
        r3 = r2 + 2;
        r0.add(r6.subSequence(r2, r3));
    L28:
        r2 = r3;
        goto L4
    L21:
        Matcher r8 = r5.matcher(r6.subSequence(r2, r6.length()));
        if (r8.find() == false) goto L24;
        int r9 = r2 + r8.end();
        r0.add(r6.subSequence(r3, r9));
        r3 = r9;
        goto L28
    L24:
        r3 = r2 + 1;
        r0.add(r6.subSequence(r2, r3));
    L11:
        if (Character.isLetter(r4) == false) goto L14;
        r5 = PatternProtector.compile("\\w+\\p{Punct}*");
        goto L20
    L14:
        if (Character.isDigit(r4) == false) goto L17;
        r5 = PatternProtector.compile("\\d+\\.\\d+");
        goto L20
    L17:
        if (Character.isSpaceChar(r4) == false) goto L19;
        r5 = PatternProtector.compile("\\s*");
        goto L20
    L19:
        r5 = null;
        goto L20
    L30:
        if (r3 == r2) goto L33;
        r0.add(r6.subSequence(r3, r2));
    L33:
        if (r7 == false) goto L35;
        int r10 = 0;
    L36:
        CharSequence r11 = (CharSequence) ListProtector.get(r0, r10);
        int r12 = 0;
    L38:
        if (r12 >= r11.length()) goto L43;
        if (Character.isWhitespace(r11.charAt(r12)) == false) goto L44;
        r12 = r12 + 1;
    L44:
        if (r1 == false) goto L46;
        ListProtector.remove(r0, r10);
    L46:
        return r0;
    L43:
        r1 = true;
        goto L44
    L35:
        r10 = r0.size() - 1;
        goto L36
    }

    public static int a(int r8, Paint.FontMetricsInt r9, boolean r10) {
        int r0 = r9.top;
        int r1 = r9.ascent;
        int r2 = r9.descent;
        int r3 = r2 - r1;
        int r4 = (r8 - r3) / 2;
        int r5 = (r8 - r4) - r3;
        int r6 = r9.bottom;
        int r7 = r6 - r0;
        int r11 = (r8 - r7) / 2;
        int r12 = r1 - r4;
        r9.ascent = r12;
        int r13 = r2 + r5;
        r9.descent = r13;
        int r14 = r0 - r11;
        r9.top = r14;
        int r15 = r6 + ((r8 - r11) - r7);
        r9.bottom = r15;
        if (r13 >= 0) goto L5;
        r9.ascent = r12 - r13;
        r9.descent = 0;
    L5:
        int r16 = r9.ascent;
        if (r16 <= 0) goto L8;
        r9.descent -= r16;
        r9.ascent = 0;
    L8:
        if (r15 >= 0) goto L10;
        r9.top = r14 - r15;
        r9.bottom = 0;
    L10:
        int r17 = r9.top;
        if (r17 <= 0) goto L13;
        r9.bottom -= r17;
        r9.top = 0;
    L13:
        if (r10 == false) goto L17;
        return r0 - r9.top;
    L17:
        return r1 - r9.ascent;
    }

    public static void c(final LynxContext r9, int r10, w r11) {
        if (r9 == null) goto L17;
        if (r11 == null) goto L18;
        Layout r1 = r11.c;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r11.n == true) goto L20;
        int r3 = r11.h;
        if (r3 <= 0) goto L12;
        if (r1 == null) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L21;
        final m7a.a r12 = j(r10, r1, r11.j, r3, r11.i, r11.k, r11.l, r11.m);
        r11.n = true;
        UIThreadUtils.runOnUiThread(new r(r9, r12));
        return;
    L21:
        return;
    L12:
        r0 = false;
        goto L13
    L20:
        return;
    L18:
        return;
    }

    public static void f(Canvas r17, Layout r18, float r19) {
        int r3 = r18.getLineCount();
        ArrayList[] r4 = new ArrayList[r3];
        ArrayList[] r5 = new ArrayList[r3];
        int r6 = 1;
        CharSequence r0 = r18.getText();     // Catch: Exception -> L35
        int r8 = 0;
    L4:
        if (r8 >= r3) goto L34;
        CharSequence r9 = r0.subSequence(r18.getLineStart(r8), r18.getLineEnd(r8));     // Catch: Exception -> L35
        float r12 = 0.0f;
        if (r8 != (r3 - 1)) goto L8;
        float r7 = Layout.getDesiredWidth(r9, r18.getPaint());     // Catch: Exception -> L35
        ArrayList r10 = new ArrayList();     // Catch: Exception -> L35
        r10.add(r9);     // Catch: Exception -> L35
        r4[r8] = r10;     // Catch: Exception -> L35
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L35
        if (r18.getParagraphDirection(r8) != (-1)) goto L32;
        r12 = r19 - r7;     // Catch: Exception -> L35
    L32:
        r11.add(Float.valueOf(r12));     // Catch: Exception -> L35
        r5[r8] = r11;     // Catch: Exception -> L35
    L33:
        r8 = r8 + 1;
        r6 = 1;
        goto L4
    L8:
        if (r18.getParagraphDirection(r8) != (-1)) goto L10;
        boolean r13 = true;
    L11:
        ArrayList<CharSequence> r14 = m(r9, r13);     // Catch: Exception -> L35
        r4[r8] = r14;     // Catch: Exception -> L35
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L35
        int r16 = r14.size() - r6;     // Catch: Exception -> L35
        float[] r110 = new float[r14.size()];     // Catch: Exception -> L35
        int r111 = 0;
        float r112 = 0.0f;
    L13:
        if (r111 >= r14.size()) goto L15;
        float r20 = Layout.getDesiredWidth((CharSequence) ListProtector.get(r14, r111), r18.getPaint());     // Catch: Exception -> L35
        r110[r111] = r20;     // Catch: Exception -> L35
        r112 = r112 + r20;     // Catch: Exception -> L35
        r111 = r111 + 1;     // Catch: Exception -> L35
        goto L13
    L15:
        float r21 = r19 - r112;     // Catch: Exception -> L35
        if (r16 == 0) goto L19;
        r21 = r21 / r16;     // Catch: Exception -> L35
    L19:
        if (r16 == 0) goto L21;
    L23:
        r15.add(Float.valueOf(0.0f));     // Catch: Exception -> L35
    L24:
        int r22 = 1;
    L26:
        if (r22 >= r14.size()) goto L28;
        r12 = (r12 + r110[r22 - 1]) + r21;     // Catch: Exception -> L35
        r15.add(Float.valueOf(r12));     // Catch: Exception -> L35
        r22 = r22 + 1;     // Catch: Exception -> L35
        goto L26
    L28:
        r5[r8] = r15;     // Catch: Exception -> L35
        goto L33
    L21:
        if (r18.getParagraphDirection(r8) != (-1)) goto L23;
        r15.add(Float.valueOf(r19 - r112));     // Catch: Exception -> L35
        goto L24
    L10:
        r13 = false;
        goto L11
    L34:
        boolean r23 = false;
    L37:
        if (r23 == true) goto L45;
        int r1 = 0;
    L39:
        if (r1 >= r3) goto L55;
        float r24 = r18.getLineBaseline(r1);
        ArrayList r25 = r4[r1];
        ArrayList r26 = r5[r1];
        int r27 = 0;
    L42:
        if (r27 >= r25.size()) goto L44;
        r17.drawText(((CharSequence) ListProtector.get(r25, r27)).toString(), ((Float) ListProtector.get(r26, r27)).floatValue(), r24, r18.getPaint());
        r27 = r27 + 1;
        goto L42
    L44:
        r1 = r1 + 1;
        goto L39
    L55:
        return;
    L45:
        return;
    L35:
        e = move-exception;
        LLog.e("TextHelper", "draw justify text error:" + e.toString());
        r18.draw(r17);
        r23 = true;
        goto L37
    }

    public static JavaOnlyMap i(String r18, String r19, String r20, String r21, int r22) {
        float r0 = n.a(r19, i.b(14.0f, 0.0f));
        if (TextUtils.isEmpty(r21) == false) goto L5;
        float r2 = 0.0f;
    L6:
        JavaOnlyMap r12 = new JavaOnlyMap();
        if (r18.isEmpty() == false) goto L9;
    L38:
        r12.putDouble("width", 0.0f);
        return r12;
    L9:
        if (r0 <= 0.0f) goto L38;
        if (r22 > 1) goto L13;
    L15:
        if (r22 == 1) goto L17;
    L19:
        TextPaint r3 = k(r0, r20);
        JavaOnlyArray r14 = new JavaOnlyArray();
        float r15 = -1.0f;
        int r10 = 0;
        if (Build.VERSION.SDK_INT < 23) goto L28;
        StaticLayout.Builder r1 = StaticLayout.Builder.obtain(r18, 0, r18.length(), r3, (int) Math.floor(r2));
        r1.setMaxLines(r22);
        StaticLayout r4 = r1.build();
        int r5 = 0;
    L23:
        if (r5 >= r4.getLineCount()) goto L25;
        r15 = Math.max(r15, r4.getLineMax(r5));
        r5 = r5 + 1;
        goto L23
    L25:
        float r6 = i.c(r15);
        int r7 = r4.getLineCount();
    L26:
        if (r10 >= r7) goto L36;
        r14.add(r18.substring(r4.getLineStart(r10), r4.getLineEnd(r10)));
        r10 = r10 + 1;
    L36:
        r12.putDouble("width", r6);
        r12.putArray(LynxAccessibilityModule.MSG_CONTENT, r14);
        return r12;
    L28:
        StaticLayout r8 = p.a(r18, r18.length(), r3, (int) Math.floor(r2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, r22, TextDirectionHeuristics.FIRSTSTRONG_LTR);
        int r9 = r8.getLineCount();
        int r11 = 0;
    L29:
        if (r11 >= r9) goto L31;
        r14.add(r18.substring(r8.getLineStart(r11), r8.getLineEnd(r11)));
        r11 = r11 + 1;
        goto L29
    L31:
        int r13 = 0;
    L33:
        if (r13 >= r8.getLineCount()) goto L35;
        r15 = Math.max(r15, r8.getLineMax(r13));
        r13 = r13 + 1;
        goto L33
    L35:
        r6 = i.c(r15);
        goto L36
    L17:
        if (r2 >= 1.0f) goto L19;
        r2 = 32767.0f;
        goto L19
    L13:
        if (r2 >= 1.0f) goto L15;
    L5:
        r2 = n.a(r21, i.b(0.0f, 0.0f));
        goto L6
    }

    public static void n(TextPaint r7, String r8, int r9, int r10, String r11, String r12, boolean r13) {
        Typeface r0 = r7.getTypeface();
        int r1 = Build.VERSION.SDK_INT;
        boolean r4 = false;
        if (r1 < 28) goto L13;
        if (r10 != 1) goto L6;
        int r2 = 700;
    L9:
        if (r9 != 2) goto L11;
        boolean r6 = true;
    L12:
        Typeface r3 = Typeface.create(r0, r2, r6);
    L20:
        r7.setTypeface(r3);
        if (r9 > 0) goto L23;
    L35:
        if (r11 != null) goto L37;
        if (r12 != null) goto L37;
        return;
    L37:
        com.lynx.tasm.fontface.g r14 = new com.lynx.tasm.fontface.g(r11, r7.getTextSize(), r8);
        FontFaceManager r15 = FontFaceManager.g.a;
        Typeface r16 = r15.d.get(r14);
        if (r16 == null) goto L40;
        r7.setTypeface(r16);
    L62:
        if (r12 == null) goto L66;
        r7.setFontFeatureSettings(r12);
        return;
    L66:
        return;
    L40:
        if (r11 != null) goto L42;
    L57:
        if (r13 == false) goto L62;
        Typeface r17 = r7.getTypeface();
        if (r17 == null) goto L61;
        r15.d.put(r14, r17);
        goto L62
    L61:
        r15.getClass();
        goto L62
    L42:
        if (r1 >= 26) goto L45;
    L55:
        if (r4 == false) goto L57;
        r7.setFontVariationSettings(r11);
        goto L57
    L45:
        if (r1 != 35) goto L54;
        String r18 = Build.BRAND;
        if (r18 != null) goto L50;
    L52:
        boolean r19 = false;
    L53:
        if (r19 == true) goto L55;
    L50:
        if (r18.toLowerCase(Locale.ENGLISH).indexOf("honor") <= (-1)) goto L52;
        r19 = true;
    L54:
        r4 = true;
        goto L55
    L23:
        if (TextUtils.isEmpty(r8) == false) goto L35;
        if (r3 == null) goto L26;
        int r5 = r3.getStyle();
    L27:
        int r20 = r9 & (~r5);
        if ((r20 & 1) == 0) goto L31;
        if (r10 != 1) goto L31;
        boolean r110 = true;
    L32:
        r7.setFakeBoldText(r110);
        if ((r20 & 2) == 0) goto L35;
        r7.setTextSkewX(-0.25f);
    L31:
        r110 = false;
        goto L32
    L26:
        r5 = 0;
        goto L27
    L11:
        r6 = false;
        goto L12
    L6:
        if (r10 != 0) goto L8;
        r2 = 400;
        goto L9
    L8:
        r2 = (r10 - 1) * 100;
        goto L9
    L13:
        if (r0 != null) goto L15;
        int r21 = 0;
    L16:
        int r22 = r21 | r9;
        if (r0 != null) goto L19;
        r3 = Typeface.defaultFromStyle(r22);
        goto L20
    L19:
        r3 = Typeface.create(r0, r22);
        goto L20
    L15:
        r21 = r0.getStyle();
        goto L16
    }

    public static m7a.a j(int r7, Layout r8, int r9, int r10, int r11, int r12, float r13, boolean r14) {
        m7a.a r0 = new m7a.a(r7, "layout");
        r0.a("lineCount", Integer.valueOf(r10));
        int r2 = 0;
        if (r10 > r8.getLineCount()) goto L23;
        if (r10 == 0) goto L23;
        ArrayList r15 = new ArrayList();
    L8:
        if (r2 >= r10) goto L10;
        HashMap r4 = new HashMap();
        r4.put("start", Integer.valueOf(r8.getLineStart(r2)));
        r4.put("end", Integer.valueOf(r8.getLineEnd(r2)));
        r4.put("ellipsisCount", Integer.valueOf(r8.getEllipsisCount(r2)));
        r15.add(r4);
        r2 = r2 + 1;
        goto L8
    L10:
        int r3 = r10 - 1;
        HashMap r5 = (HashMap) ListProtector.get(r15, r3);
        int r6 = ((Integer) r5.get("ellipsisCount")).intValue();
        int r16 = ((Integer) r5.get("end")).intValue();
        if (r11 <= 0) goto L14;
    L19:
        r5.put("ellipsisCount", Integer.valueOf(r11));
        r5.put("end", Integer.valueOf(r12));
        r0.a("lines", r15);
        if (r14 == false) goto L22;
        HashMap r17 = new HashMap();
        r17.put("width", Float.valueOf(i.c(r13)));
        r17.put("height", Float.valueOf(i.c(r8.getLineBottom(r3))));
        r0.a("size", r17);
    L22:
        return r0;
    L14:
        if (r10 < r8.getLineCount()) goto L18;
        if (r9 == 0) goto L18;
        r11 = r6;
    L18:
        r11 = r12 - r16;
    L23:
        LLog.e("TextHelper", "getTextLayoutEvent: get lineCount error");
        r0.a("lineCount", 0);
        return r0;
    }

    public static void d(Canvas r26, Layout r27, int r28, int r29, boolean r30, boolean r31, int r32, int r33, int r34) {
        Layout r7 = r27;
        int r9 = r33;
        if (r32 >= r9) goto L108;
        if (r30 == true) goto L8;
        if (r31 == true) goto L8;
        return;
    L8:
        if (r28 != 4) goto L10;
        float r8 = r34;
        Paint r10 = new Paint();
        r10.setColor(r29);
        float r12 = r8 / 3.0f;
        r10.setStrokeWidth(r12 / 5.0f);
        int r13 = r7.getLineForOffset(r32);
        int r14 = r7.getLineForOffset(r9);
        int r15 = r13;
    L92:
        if (r15 > r14) goto L135;
        float r0 = r7.getLineLeft(r15);
        float r5 = r7.getLineBaseline(r15);
        float r1 = r7.getLineMax(r15);
        if (r15 != r13) goto L96;
        r1 = (r0 + r1) - r7.getPrimaryHorizontal(r32);
        r0 = r7.getPrimaryHorizontal(r32);
    L96:
        float r16 = r0;
        if (r15 != r14) goto L99;
        r1 = r7.getPrimaryHorizontal(r9) - r16;
    L99:
        float r17 = r1;
        if (r30 == false) goto L104;
        float r4 = r5 + (r12 / 3.0f);
        r26.drawLine(r16, r4, r16 + r17, r4, r10);
    L104:
        if (r31 == false) goto L107;
        float r6 = r5 - ((r8 / 15.0f) * 4.0f);
        r26.drawLine(r16, r6, r16 + r17, r6, r10);
    L107:
        r15 = r15 + 1;
        goto L92
    L135:
        return;
    L10:
        if (r28 != 8) goto L12;
        float r11 = r34;
        Paint r18 = new Paint();
        r18.setColor(r29);
        float r19 = r11 / 3.0f;
        int r110 = r7.getLineForOffset(r32);
        int r111 = r7.getLineForOffset(r9);
        float r112 = r19 / 5.0f;
        r18.setStrokeWidth(r112);
        int r20 = r110;
    L77:
        if (r20 > r111) goto L134;
        float r2 = r7.getLineLeft(r20);
        float r21 = r7.getLineBaseline(r20);
        float r3 = r7.getLineMax(r20);
        if (r20 != r110) goto L81;
        r3 = (r2 + r3) - r7.getPrimaryHorizontal(r32);
        r2 = r7.getPrimaryHorizontal(r32);
    L81:
        float r113 = r2;
        if (r20 != r111) goto L84;
        r3 = r7.getPrimaryHorizontal(r9) - r113;
    L84:
        float r114 = r3;
        if (r30 == false) goto L87;
        float r22 = r21 + (r19 / 3.0f);
        float r23 = r113 + r114;
        float r24 = r21;
        r26.drawLine(r113, r22, r23, r22, r18);
        float r25 = r24 + (r112 * 3.0f);
        r26.drawLine(r113, r25, r23, r25, r18);
    L88:
        if (r31 == false) goto L90;
        float r210 = r24 - ((r11 / 15.0f) * 4.0f);
        float r115 = r113 + r114;
        r26.drawLine(r113, r210, r115, r210, r18);
        float r35 = r210 + ((r19 / 15.0f) * 4.0f);
        r26.drawLine(r113, r35, r115, r35, r18);
    L90:
        r20 = r20 + 1;
        goto L77
    L87:
        r24 = r21;
        goto L88
    L134:
        return;
    L12:
        if (r28 != 16) goto L14;
        float r36 = r34;
        Paint r37 = new Paint();
        r37.setColor(r29);
        float r38 = r36 / 3.0f;
        float r116 = r36 / 4.0f;
        int r39 = r7.getLineForOffset(r32);
        int r117 = r7.getLineForOffset(r9);
        r37.setStrokeWidth(r38 / 5.0f);
        int r40 = r39;
    L55:
        if (r40 > r117) goto L132;
        float r118 = r7.getLineLeft(r40);
        float r119 = r7.getLineBaseline(r40);
        float r120 = r7.getLineMax(r40);
        if (r40 != r39) goto L59;
        r120 = (r118 + r120) - r7.getPrimaryHorizontal(r32);
        r118 = r7.getPrimaryHorizontal(r32);
    L59:
        if (r40 != r117) goto L61;
        r120 = r7.getPrimaryHorizontal(r9) - r118;
    L61:
        int r211 = r39;
        int r41 = (int) Math.floor(r120 / r116);
        if (r41 == 0) goto L133;
        if (r30 == false) goto L69;
        int r42 = 0;
        float r121 = 0.0f;
    L67:
        if (r42 >= (r41 + 1)) goto L69;
        r26.drawPoint(r118 + r121, r119 + (r38 / 3.0f), r37);
        r121 = r121 + r116;
        r42 = r42 + 1;
        r38 = r38;
    L69:
        float r212 = r38;
        if (r31 == false) goto L75;
        float r122 = r119 - ((r36 / 15.0f) * 4.0f);
        int r43 = 0;
        float r44 = 0.0f;
    L73:
        if (r43 >= (r41 + 1)) goto L75;
        r26.drawPoint(r118 + r44, r122, r37);
        r44 = r44 + r116;
        r43 = r43 + 1;
    L75:
        r40 = r40 + 1;
        r39 = r211;
        r38 = r212;
        goto L55
    L133:
        return;
    L132:
        return;
    L14:
        if (r28 != 32) goto L16;
        float r45 = r34;
        int r123 = r27.getLineForOffset(r32);
        int r124 = r27.getLineForOffset(r33);
        Paint r125 = new Paint();
        r125.setColor(r29);
        float r126 = r45 / 3.0f;
        r125.setStrokeWidth(r126 / 5.0f);
        r125.setPathEffect(new DashPathEffect(new float[]{r45 / 7.0f, r45 / 20.0f}, 0.0f));
        int r127 = r123;
    L40:
        if (r127 > r124) goto L131;
        float r46 = r27.getLineLeft(r127);
        float r47 = r27.getLineBaseline(r127);
        float r48 = r27.getLineMax(r127);
        if (r127 != r123) goto L44;
        r48 = (r46 + r48) - r27.getPrimaryHorizontal(r32);
        r46 = r27.getPrimaryHorizontal(r32);
    L44:
        float r128 = r46;
        if (r127 != r124) goto L47;
        r48 = r27.getPrimaryHorizontal(r33) - r128;
    L47:
        float r129 = r48;
        if (r30 == false) goto L51;
        float r49 = r47 + (r126 / 3.0f);
        r26.drawLine(r128, r49, r128 + r129, r49, r125);
    L51:
        if (r31 == false) goto L53;
        float r50 = r47 - ((r45 / 15.0f) * 4.0f);
        r26.drawLine(r128, r50, r128 + r129, r50, r125);
    L53:
        r127 = r127 + 1;
        goto L40
    L131:
        return;
    L16:
        if (r28 != 64) goto L129;
        float r51 = r34;
        float r52 = 2.0f;
        float r53 = r51 / 2.0f;
        float r130 = r51 / 3.0f;
        int r131 = r7.getLineForOffset(r32);
        int r132 = r7.getLineForOffset(r9);
        Paint r54 = new Paint();
        r54.setStyle(Paint.Style.STROKE);
        r54.setColor(r29);
        r54.setStrokeWidth(r130 / 5.0f);
        int r55 = r131;
    L19:
        if (r55 > r132) goto L130;
        float r56 = r7.getLineLeft(r55);
        float r133 = r7.getLineBaseline(r55);
        float r134 = r7.getLineMax(r55);
        if (r55 != r131) goto L23;
        r134 = (r56 + r134) - r7.getPrimaryHorizontal(r32);
        r56 = r7.getPrimaryHorizontal(r32);
    L23:
        if (r55 != r132) goto L25;
        r134 = r7.getPrimaryHorizontal(r9) - r56;
    L25:
        int r135 = Math.round(r134 / r53);
        if (r30 == false) goto L31;
        Path r136 = new Path();
        float r57 = r133 + (r130 / r52);
        r136.moveTo(r56, r57);
        int r137 = 0;
        float r213 = 0.0f;
    L28:
        if (r137 >= r135) goto L30;
        float r214 = r53 / 4.0f;
        r136.quadTo((r56 + r214) + r213, r133, (r56 + (r53 / 2.0f)) + r213, r57);
        r136.quadTo((r56 + (r214 * 3.0f)) + r213, r133 + r130, (r56 + r53) + r213, r57);
        r213 = r213 + r53;
        r137 = r137 + 1;
        r131 = r131;
        goto L28
    L30:
        int r215 = r131;
        r26.drawPath(r136, r54);
    L32:
        if (r31 == false) goto L37;
        Path r58 = new Path();
        float r59 = 4.0f;
        float r138 = r133 - ((r51 / 15.0f) * 4.0f);
        r58.moveTo(r56, r138);
        int r60 = 0;
        float r139 = 0.0f;
    L34:
        if (r60 >= r135) goto L36;
        float r140 = r53 / r59;
        float r216 = r130 / 2.0f;
        r58.quadTo((r56 + r140) + r139, r138 - r216, (r56 + (r53 / 2.0f)) + r139, r138);
        r58.quadTo(((r140 * 3.0f) + r56) + r139, r216 + r138, (r56 + r53) + r139, r138);
        r139 = r139 + r53;
        r60 = r60 + 1;
        r51 = r51;
        r59 = 4.0f;
        goto L34
    L36:
        float r217 = r51;
        r26.drawPath(r58, r54);
    L38:
        r55 = r55 + 1;
        r7 = r27;
        r9 = r33;
        r132 = r132;
        r51 = r217;
        r131 = r215;
        r52 = 2.0f;
        goto L19
    L37:
        r217 = r51;
        goto L38
    L31:
        r215 = r131;
        goto L32
    L130:
        return;
    L129:
        return;
    }
}
