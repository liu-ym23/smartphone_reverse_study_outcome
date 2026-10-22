package com.lynx.tasm.base;

import ai.j0;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Path;
import android.net.Uri;
import b3.k;
import b3.o;
import com.bytedance.crash.n;
import com.bytedance.ies.bullet.base.core.common.PadAdapterStyle;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.keva.KevaImpl;
import com.lynx.tasm.p;
import com.squareup.kotlinpoet.KModifier;
import com.squareup.kotlinpoet.e0;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import m.A;
import m.f0;
import m.t;
import mt.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f10116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f10117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Integer f10118c;

    public static final b3.i a(String r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        b3.i r11 = (b3.i) r10.get(r5);
        if (r11 != null) goto L6;
        b3.i r12 = new b3.i();
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }

    public static PadAdapterStyle b(rd.b r10) {
        if (r10 == null) goto L4;
        Lazy r5 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r5.getValue()).getClass();
    L4:
        String r11 = null;
        if (r10 == null) goto L8;
        r11 = (String) new vd.a(r10, "pad_adapter", null).f22372b;
    L8:
        if (r11 == null) goto L57;
        int r12 = r11.hashCode();
        if (r12 == (-2126048564)) goto L47;
        boolean r13 = true;
        if (r12 == 1779691381) goto L32;
        if (r12 != 1911047014) goto L57;
        if (r11.equals("uniform_style") == false) goto L57;
        ConcurrentHashMap r14 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r15 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r15 == null) goto L26;
        xc.d r16 = (xc.d) r15.a(xc.d.class);
        if (r16 == null) goto L26;
        Boolean r17 = r16.y0();
        if (r17 == null) goto L26;
        r13 = r17.booleanValue();
    L26:
        if (r13 == false) goto L29;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadAdapterStyle：UNIFORM_STYLE");
        return PadAdapterStyle.f5187b;
    L29:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadAdapterStyle：disable UNIFORM_STYLE，replace to WIDTH_PERCENT");
        return PadAdapterStyle.f5186a;
    L32:
        if (r11.equals("channel_style") == false) goto L57;
        ConcurrentHashMap r18 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r19 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r19 == null) goto L41;
        xc.d r20 = (xc.d) r19.a(xc.d.class);
        if (r20 == null) goto L41;
        Boolean r21 = r20.w0();
        if (r21 == null) goto L41;
        r13 = r21.booleanValue();
    L41:
        if (r13 == false) goto L44;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadAdapterStyle：CHANNEL_STYLE");
        return PadAdapterStyle.f5188c;
    L44:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadAdapterStyle：disable CHANNEL_STYLE，replace to WIDTH_PERCENT");
        return PadAdapterStyle.d;
    L47:
        if (r11.equals("width_percent") == false) goto L57;
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        tc.c r22 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r23 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r23 == null) goto L52;
        com.bytedance.ies.bullet.service.base.d r24 = (com.bytedance.ies.bullet.service.base.d) r23.f6163b.getValue();
    L52:
        ((com.bytedance.ies.bullet.service.sdk.b) r10).c().toString();
        com.bytedance.ies.bullet.settings.b r25 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r25 == null) goto L55;
        com.bytedance.ies.bullet.service.base.d r26 = (com.bytedance.ies.bullet.service.base.d) r25.f6163b.getValue();
    L55:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadAdapterStyle：WIDTH_PERCENT");
        return PadAdapterStyle.f5186a;
    L57:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadAdapterStyle：NONE");
        return PadAdapterStyle.d;
    }

    public static com.bytedance.pia.nsr.i c(String r5) {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(Uri.parse(r5));     // Catch: Throwable -> L5
    L7:
        List r12 = null;
        if (Result.m127exceptionOrNullimpl(r11) != null) goto L17;
        Uri r13 = (Uri) r11;
        StringBuffer r14 = new StringBuffer();
        r14.append(r13.getScheme());
        r14.append("://");
        r14.append(r13.getAuthority());
        r14.append(r13.getPath());
        String r15 = r14.toString();
        String r16 = r13.getQuery();
        if (r16 == null) goto L12;
        r12 = StringsKt.J(r16, new char[]{Typography.amp}, 0, 6);
    L12:
        if (r12 != null) goto L14;
        TreeSet r17 = new TreeSet();
    L16:
        return new com.bytedance.pia.nsr.i(r15, r17);
    L14:
        r17 = new TreeSet(r12);
        goto L16
    L17:
        return null;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static Integer d(Context r5, int r10, Double r11, Integer r12, Double r13, Integer r14) {
        if (r12 != null) goto L4;
    L7:
        if (r11 == null) goto L10;
        List r15 = nb.a.f20224a;
        float r16 = (float) r11.doubleValue();
        Intrinsics.checkNotNullParameter(r5, "context");
        return Integer.valueOf((int) ((nb.a.a(r5) * r16) + 0.5f));
    L10:
        if (r13 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf((int) (r13.doubleValue() * ((double) r14.intValue())));
    L4:
        if (r12.intValue() == 0) goto L7;
        return Integer.valueOf((r12.intValue() * r10) / 100);
    }

    public static StringBuilder e(String r5, String r10, String r11, String r12, String r13) {
        return androidx.constraintlayout.motion.widget.a.y(r5, r10, r11, r12, r13);
    }

    public static ArrayList f(String r13) {
        if (io.reactivex.internal.observers.h.e(r13) == true) goto L186;
        int r5 = 0;
        Matcher r14 = f0.f(0, A.f19817r0.c()).matcher(r13.trim());
        StringBuffer r10 = new StringBuffer();
        boolean r11 = r14.find();
    L7:
        if (r11 == false) goto L9;
        r14.appendReplacement(r10, "");
        r11 = r14.find();
        goto L7
    L9:
        r14.appendTail(r10);
        String r15 = r10.toString();
        Matcher r12 = A.B0.b().matcher(r15);
        HashSet r16 = new HashSet();
    L11:
        if (r12.find() == false) goto L13;
        r16.add(Integer.valueOf(r12.start()));
        goto L11
    L13:
        Matcher r17 = A.C0.b().matcher(r15);
        StringBuffer r18 = new StringBuffer();
        boolean r19 = r17.find();
    L14:
        if (r19 == false) goto L19;
        if (r16.contains(Integer.valueOf(r17.end())) == true) goto L18;
        r17.appendReplacement(r18, "");
    L18:
        r19 = r17.find();
        goto L14
    L19:
        r17.appendTail(r18);
        Matcher r110 = A.f19818s0.b().matcher(r18.toString());
        StringBuffer r20 = new StringBuffer();
        boolean r21 = r110.find();
    L21:
        if (r21 == false) goto L27;
        String[] r22 = r110.group().split("万");
        if (r22.length != 2) goto L25;
        int r23 = (p.h(r22[1]) * 1000) + (p.h(r22[0]) * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
    L26:
        r110.appendReplacement(r20, Integer.toString(r23));
        r21 = r110.find();
        goto L21
    L25:
        r23 = 0;
        goto L26
    L27:
        r110.appendTail(r20);
        Matcher r111 = A.f19820t0.b().matcher(r20.toString());
        StringBuffer r24 = new StringBuffer();
        boolean r25 = r111.find();
    L29:
        if (r25 == false) goto L35;
        String[] r26 = r111.group().split("千");
        if (r26.length != 2) goto L33;
        int r27 = (p.h(r26[1]) * 100) + (p.h(r26[0]) * 1000);
    L34:
        r111.appendReplacement(r24, Integer.toString(r27));
        r25 = r111.find();
        goto L29
    L33:
        r27 = 0;
        goto L34
    L35:
        r111.appendTail(r24);
        Matcher r112 = A.f19822u0.b().matcher(r24.toString());
        StringBuffer r28 = new StringBuffer();
        boolean r29 = r112.find();
    L37:
        if (r29 == false) goto L43;
        String[] r30 = r112.group().split("百");
        if (r30.length != 2) goto L41;
        int r31 = (p.h(r30[1]) * 10) + (p.h(r30[0]) * 100);
    L42:
        r112.appendReplacement(r28, Integer.toString(r31));
        r29 = r112.find();
        goto L37
    L41:
        r31 = 0;
        goto L42
    L43:
        r112.appendTail(r28);
        Matcher r113 = A.f19824v0.b().matcher(r28.toString());
        StringBuffer r32 = new StringBuffer();
        boolean r33 = r113.find();
    L44:
        if (r33 == false) goto L46;
        r113.appendReplacement(r32, Integer.toString(p.h(r113.group())));
        r33 = r113.find();
        goto L44
    L46:
        r113.appendTail(r32);
        Matcher r114 = A.f19826w0.b().matcher(r32.toString());
        StringBuffer r34 = new StringBuffer();
        boolean r35 = r114.find();
    L47:
        if (r35 == false) goto L49;
        r114.appendReplacement(r34, Integer.toString(p.h(r114.group())));
        r35 = r114.find();
        goto L47
    L49:
        r114.appendTail(r34);
        Matcher r115 = A.f19828x0.b().matcher(r34.toString());
        StringBuffer r36 = new StringBuffer();
        boolean r37 = r115.find();
    L50:
        if (r37 == false) goto L72;
        String[] r38 = r115.group().split("十");
        if (r38.length != 0) goto L55;
    L53:
        int r39 = 10;
    L71:
        r115.appendReplacement(r36, Integer.toString(r39));
        r37 = r115.find();
        goto L50
    L55:
        if (r38.length != 1) goto L61;
        int r40 = Integer.parseInt(r38[0]);
        if (r40 == 0) goto L53;
        r39 = r40 * 10;
        goto L71
    L61:
        if (r38.length == 2) goto L63;
        r39 = 0;
        goto L71
    L63:
        if (r38[0].equals("") == true) goto L67;
        int r116 = Integer.parseInt(r38[0]);
        if (r116 == 0) goto L67;
        int r117 = r116 * 10;
    L69:
        r39 = Integer.parseInt(r38[1]) + r117;
    L67:
        r117 = 10;
        goto L69
    L72:
        r115.appendTail(r36);
        Matcher r118 = A.f19830y0.b().matcher(r36.toString());
        StringBuffer r41 = new StringBuffer();
        boolean r42 = r118.find();
    L73:
        if (r42 == false) goto L82;
        String[] r43 = r118.group().split("百");
        if (r43.length != 1) goto L78;
        int r44 = Integer.parseInt(r43[0]) * 100;
    L81:
        r118.appendReplacement(r41, Integer.toString(r44));
        r42 = r118.find();
        goto L73
    L78:
        if (r43.length != 2) goto L80;
        r44 = Integer.parseInt(r43[1]) + (Integer.parseInt(r43[0]) * 100);
        goto L81
    L80:
        r44 = 0;
        goto L81
    L82:
        r118.appendTail(r41);
        Matcher r119 = A.f19832z0.b().matcher(r41.toString());
        StringBuffer r45 = new StringBuffer();
        boolean r46 = r119.find();
    L83:
        if (r46 == false) goto L92;
        String[] r47 = r119.group().split("千");
        if (r47.length != 1) goto L88;
        int r48 = Integer.parseInt(r47[0]) * 1000;
    L91:
        r119.appendReplacement(r45, Integer.toString(r48));
        r46 = r119.find();
        goto L83
    L88:
        if (r47.length != 2) goto L90;
        r48 = Integer.parseInt(r47[1]) + (Integer.parseInt(r47[0]) * 1000);
        goto L91
    L90:
        r48 = 0;
        goto L91
    L92:
        r119.appendTail(r45);
        Matcher r120 = A.A0.b().matcher(r45.toString());
        StringBuffer r49 = new StringBuffer();
        boolean r50 = r120.find();
    L93:
        if (r50 == false) goto L102;
        String[] r51 = r120.group().split("万");
        if (r51.length != 1) goto L98;
        int r52 = Integer.parseInt(r51[0]) * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L101:
        r120.appendReplacement(r49, Integer.toString(r52));
        r50 = r120.find();
        goto L93
    L98:
        if (r51.length != 2) goto L100;
        r52 = Integer.parseInt(r51[1]) + (Integer.parseInt(r51[0]) * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        goto L101
    L100:
        r52 = 0;
        goto L101
    L102:
        r120.appendTail(r49);
        String r121 = r49.toString();
        if (io.reactivex.internal.observers.h.e(r121) == true) goto L187;
        m.b.e().getClass();
        ArrayList r53 = new ArrayList();
        r53.add("");
        Matcher r122 = m.b.f19859c.matcher(r121);
        int r54 = -1;
        int r55 = 0;
    L107:
        if (r122.find() == false) goto L116;
        if (r54 != r122.start()) goto L111;
        r55 = r55 - 1;
        r53.set(r55, ((String) r53.get(r55)) + r122.group());
    L112:
        r54 = r122.end();
        r55 = r55 + 1;
        if ((r53.size() - 1) >= r55) goto L107;
        r53.add("");
        goto L107
    L111:
        r53.set(r55, r122.group());
        goto L112
    L116:
        if (r53.isEmpty() == true) goto L188;
        ArrayList r123 = new ArrayList(r53.size());
        i4.a r56 = new i4.a(12);
        String r57 = t.a(new Date(), "yyyy-MM-dd-HH-mm-ss");
        r56.f17503c = r57;
        r56.d = r57;
    L120:
        if (r5 >= r53.size()) goto L125;
        if (io.reactivex.internal.observers.h.e((String) r53.get(r5)) == true) goto L125;
        m.c r58 = new m.c((String) r53.get(r5), m.b.e(), r56);
        r123.add(r58);
        r56 = r58.g;
        r5 = r5 + 1;
    L125:
        HashMap r59 = m.c.f19861i;
        if (r123.isEmpty() == true) goto L185;
        ArrayList r60 = new ArrayList();
        Iterator r124 = r123.iterator();
    L130:
        if (r124.hasNext() == false) goto L137;
        m.c r61 = (m.c) r124.next();
        if (r61 == null) goto L130;
        if (r61.d.getTime() == (-28800000)) goto L130;
        r60.add(r61);
        goto L130
    L137:
        return r60;
    L185:
        return r123;
    L188:
        return null;
    L187:
        return null;
    L186:
        return null;
    }

    public static HashMap g() {
        Context r5 = n.f4057a;
        if (f10116a != null) goto L11;
        f10116a = new HashMap();
        Properties r10 = new Properties();     // Catch: Throwable -> L12
        r10.load(r5.getAssets().open("slardar.properties"));     // Catch: Throwable -> L12
        Iterator r11 = r10.entrySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r11.hasNext() == false) goto L11;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L12
        f10116a.put(String.valueOf(r12.getKey()), r12.getValue());     // Catch: Throwable -> L12
    L11:
        return f10116a;
    }

    public static Pair h(String r32, Context r33, rd.e r34, Scenes r35, Configuration r36) {
        Intrinsics.checkNotNullParameter(r36, "configuration");
        if (r34 == null) goto L5;
        rd.b r10 = r34.f21723a;
    L6:
        int r28 = -1;
        int r30 = 0;
        if (b(r10) != PadAdapterStyle.f5187b) goto L92;
        if (r35 == Scenes.f5283c) goto L92;
        if (r33 != null) goto L13;
        com.bytedance.ies.bullet.base.utils.logger.a.d("BulletPadAdapterUtil", "getPadKitViewInfoUniform：context is null", null, 12);
        f10117b = null;
        f10118c = null;
        return new Pair(null, null);
    L13:
        if (r34 == null) goto L15;
        Double r11 = (Double) new vd.a(r34.f21723a, "width", 1).f22372b;
    L16:
        if (r34 == null) goto L18;
        Integer r12 = (Integer) new vd.a(r34.f21723a, "width_percent", 5).f22372b;
    L19:
        if (r34 == null) goto L21;
        Double r13 = (Double) new vd.a(r34.f21723a, "height", 1).f22372b;
    L22:
        if (r34 == null) goto L24;
        Integer r14 = (Integer) new vd.a(r34.f21723a, "height_percent", 5).f22372b;
    L25:
        if (r34 == null) goto L27;
        Double r5 = (Double) new vd.a(r34.f21723a, "aspect_ratio", 1).f22372b;
    L28:
        if (r34 == null) goto L36;
        rd.b r15 = r34.f21723a;
        if (r35 == Scenes.f5282b) goto L32;
        boolean r21 = true;
    L33:
        Boolean r16 = (Boolean) new vd.a(r15, "hide_nav_bar", Boolean.valueOf(r21)).f22372b;
        if (r16 == null) goto L36;
        boolean r17 = r16.booleanValue();
    L37:
        if (r34 == null) goto L41;
        Boolean r18 = (Boolean) new vd.a(r34.f21723a, "hide_status_bar", Boolean.FALSE).f22372b;
        if (r18 == null) goto L41;
        boolean r19 = r18.booleanValue();
    L42:
        if (r34 == null) goto L46;
        Boolean r20 = (Boolean) new vd.a(r34.f21723a, "should_full_screen", Boolean.FALSE).f22372b;
        if (r20 == null) goto L46;
        boolean r22 = r20.booleanValue();
    L47:
        int r23 = r36.screenWidthDp;
        int r24 = r36.screenHeightDp;
        if (r19 == true) goto L52;
        if (r22 == true) goto L52;
        int r25 = 0;
    L53:
        if (r17 == true) goto L55;
        int r110 = 52;
    L56:
        int r111 = com.lynx.tasm.utils.g.b(r24 - r110, r33) + r25;
        int r26 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：statusBarHeight=" + com.lynx.tasm.utils.g.h(r25, r33) + ",titleBarHeight=" + r110 + ",containerHeight=" + com.lynx.tasm.utils.g.h(r111, r33));
        if (r23 > 480) goto L60;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：窗口尺寸(" + r23 + ',' + r24 + ")，小于480dp全屏展示");
        f10117b = Integer.valueOf(com.lynx.tasm.utils.g.b(r23, r33));
        f10118c = Integer.valueOf(r111);
        return new Pair(-1, -1);
    L60:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：窗口尺寸(" + r23 + ',' + r24 + "), 容器高度=" + com.lynx.tasm.utils.g.h(r111, r33) + "，schema参数（width=" + r11 + "，width_percent=" + r12 + "，height=" + r13 + "，height_percent=" + r14 + "，aspect_ratio=" + r5 + 65289);
        if (r12 != null) goto L63;
    L65:
        if (r11 == null) goto L67;
        List r27 = nb.a.f20224a;
        float r29 = (float) r11.doubleValue();
        Intrinsics.checkNotNullParameter(r33, "context");
        Integer r31 = Integer.valueOf((int) ((nb.a.a(r33) * r29) + 0.5f));
    L68:
        if (r31 == null) goto L70;
        int r37 = r31.intValue();
    L71:
        if (r37 <= 0) goto L75;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：使用自定义宽度，width=" + com.lynx.tasm.utils.g.h(r37, r33));
    L73:
        int r38 = r37;
        Integer r39 = d(r33, r111, r13, r14, r5, Integer.valueOf(r38));
        if (r39 == null) goto L81;
        r30 = r39.intValue();
    L81:
        int r40 = r30;
        if (r40 <= 0) goto L84;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：使用自定义高度，height=" + com.lynx.tasm.utils.g.h(r40, r33));
    L85:
        f10117b = Integer.valueOf(r38);
        f10118c = Integer.valueOf(r40);
        Integer r41 = Integer.valueOf(r38);
        if (r40 == r111) goto L90;
        r28 = r40;
    L90:
        return new Pair(r41, Integer.valueOf(r28));
    L84:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：高度全屏展示，height=" + com.lynx.tasm.utils.g.h(r111, r33));
        r40 = r111;
        goto L85
    L75:
        if (r23 > 704) goto L77;
        int r42 = (int) (((double) r23) * 0.8d);
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：小于704断点，使用窗口宽度80%，width=" + r42);
        r37 = com.lynx.tasm.utils.g.b(r42, r33);
        goto L73
    L77:
        int r43 = (int) (((double) r23) * 0.65d);
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoUniform：大于704断点，使用窗口宽度65%，width=" + r43);
        r37 = com.lynx.tasm.utils.g.b(r43, r33);
        goto L73
    L70:
        r37 = 0;
        goto L71
    L67:
        r31 = null;
        goto L68
    L63:
        if (r12.intValue() == 0) goto L65;
        r31 = Integer.valueOf((com.lynx.tasm.utils.g.b(r23, r33) * r12.intValue()) / 100);
        goto L68
    L55:
        r110 = 0;
    L52:
        r25 = nb.a.k(r33);
    L46:
        r22 = false;
    L41:
        r19 = false;
        goto L42
    L32:
        r21 = false;
    L36:
        r17 = false;
        goto L37
    L27:
        r5 = null;
        goto L28
    L24:
        r14 = null;
        goto L25
    L21:
        r13 = null;
        goto L22
    L18:
        r12 = null;
        goto L19
    L15:
        r11 = null;
    L92:
        if (r34 == null) goto L94;
        rd.b r44 = r34.f21723a;
    L96:
        if (b(r44) == PadAdapterStyle.f5188c) goto L98;
    L176:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfo：start");
        if (r33 == null) goto L179;
        Pair r45 = nb.a.i(r33);
    L180:
        if (r34 == null) goto L182;
        Double r46 = (Double) new vd.a(r34.f21723a, "width", 1).f22372b;
    L183:
        if (r34 == null) goto L185;
        Integer r47 = (Integer) new vd.a(r34.f21723a, "width_percent", 5).f22372b;
    L186:
        if (r34 == null) goto L188;
        Double r112 = (Double) new vd.a(r34.f21723a, "height", 1).f22372b;
    L189:
        if (r34 == null) goto L191;
        Integer r113 = (Integer) new vd.a(r34.f21723a, "height_percent", 5).f22372b;
    L192:
        if (r34 == null) goto L194;
        int r114 = 1;
        Double r48 = (Double) new vd.a(r34.f21723a, "aspect_ratio", 1).f22372b;
    L195:
        if (r34 == null) goto L197;
        Double r49 = (Double) new vd.a(r34.f21723a, "pad_ratio", r114).f22372b;
    L198:
        if (r34 == null) goto L200;
        String r50 = (String) new vd.a(r34.f21723a, "pad_adapter", null).f22372b;
    L201:
        if (r34 == null) goto L207;
        rd.b r115 = r34.f21723a;
        if (r35 != Scenes.f5282b) goto L205;
        boolean r210 = false;
    L206:
        Boolean r51 = (Boolean) new vd.a(r115, "hide_nav_bar", Boolean.valueOf(r210)).f22372b;
    L208:
        if (r34 == null) goto L210;
        Boolean r52 = (Boolean) new vd.a(r34.f21723a, "hide_status_bar", Boolean.FALSE).f22372b;
    L211:
        if (r34 == null) goto L213;
        Boolean r53 = (Boolean) new vd.a(r34.f21723a, "trans_status_bar", Boolean.FALSE).f22372b;
    L214:
        if (r34 == null) goto L216;
        Boolean r54 = (Boolean) new vd.a(r34.f21723a, "should_full_screen", Boolean.FALSE).f22372b;
    L217:
        if (r33 == null) goto L225;
        Intrinsics.checkNotNullParameter(r33, "context");
        if (r47 != null) goto L221;
    L223:
        if (r46 == null) goto L225;
        List r116 = nb.a.f20224a;
        float r117 = (float) r46.doubleValue();
        Intrinsics.checkNotNullParameter(r33, "context");
        Integer r118 = Integer.valueOf((int) ((nb.a.a(r33) * r117) + 0.5f));
    L226:
        if (r33 == null) goto L238;
        Intrinsics.checkNotNullParameter(r33, "context");
        if (r113 != null) goto L230;
    L233:
        if (r112 == null) goto L235;
        List r119 = nb.a.f20224a;
        float r120 = (float) r112.doubleValue();
        Intrinsics.checkNotNullParameter(r33, "context");
        Integer r55 = Integer.valueOf((int) ((nb.a.a(r33) * r120) + 0.5f));
    L239:
        if (r49 != 0) goto L243;
        if (r50 != null) goto L243;
    L242:
        Double r121 = r46;
        Integer r310 = r47;
        Integer r56 = null;
        Integer r57 = null;
    L325:
        boolean r58 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "getPadKitViewInfo: screenInfo=" + r45 + ",padRatio=" + r49 + ",width=" + r56 + ",height=" + r57 + ",schemeHeight=" + r112 + ",aspectRatio=" + r48 + ",percentHeight=" + r113 + ",calculatedSchemeHeight=" + r55 + ",schemeWidth=" + r121 + ",percentWidth=" + r310 + ",calculatedSchemeWidth=" + r118, null);
        f10117b = r56;
        f10118c = r57;
        return new Pair(r56, r57);
    L243:
        if (r45 == 0) goto L242;
        int r122 = ((Number) r45.component1()).intValue();
        int r123 = ((Number) r45.component2()).intValue();
        if (r50 != null) goto L247;
        r121 = r46;
        if (r49 != 0) goto L285;
    L282:
        r310 = r47;
        Integer r59 = null;
        Integer r60 = null;
    L308:
        if (r60 == null) goto L315;
        int r61 = r60.intValue();
        boolean r62 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "calculateSize: calculatedSchemeSize=" + r55 + ",padRatioSize=" + r61, null);
        if (r55 != null) goto L312;
    L314:
        r57 = Integer.valueOf(r61);
    L316:
        if (r59 == null) goto L323;
        int r63 = r59.intValue();
        boolean r64 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "calculateSize: calculatedSchemeSize=" + r118 + ",padRatioSize=" + r63, null);
        if (r118 != null) goto L320;
    L322:
        r56 = Integer.valueOf(r63);
        goto L325
    L320:
        if (r118.intValue() == 0) goto L322;
        r63 = Math.min(r118.intValue(), r63);
        goto L322
    L323:
        r56 = Integer.valueOf(r122);
        goto L325
    L312:
        if (r55.intValue() == 0) goto L314;
        r61 = Math.min(r55.intValue(), r61);
        goto L314
    L315:
        r57 = Integer.valueOf(r123);
        goto L316
    L285:
        double r65 = r122;
        r310 = r47;
        double r124 = r123;
        double r125 = r65 / r124;
        if (Intrinsics.areEqual(r32, "webcast") == false) goto L303;
        if (r33 == null) goto L299;
        Boolean r66 = Boolean.FALSE;
        if (Intrinsics.areEqual(r51, r66) == false) goto L291;
        int r67 = (int) ((44 * kn.e.b().density) + 0.5f);
    L293:
        if (Intrinsics.areEqual(r52, r66) == true) goto L295;
    L297:
        r123 = ((r123 - r67) - r30) - com.lynx.tasm.utils.g.i(r33);
        goto L299
    L295:
        if (Intrinsics.areEqual(r53, r66) == false) goto L297;
        r30 = nb.a.k(r33);
        goto L297
    L291:
        r67 = 0;
    L299:
        if (r125 <= r49.doubleValue()) goto L301;
        r59 = Integer.valueOf((int) (r49.doubleValue() * ((double) r123)));
        r60 = Integer.valueOf(r123);
        goto L308
    L301:
        r59 = Integer.valueOf(r122);
        r60 = Integer.valueOf(r123);
        goto L308
    L303:
        if (r125 <= r49.doubleValue()) goto L305;
        r59 = Integer.valueOf((int) (r49.doubleValue() * r124));
        r60 = Integer.valueOf(r123);
        goto L308
    L305:
        r59 = Integer.valueOf(r122);
        r60 = Integer.valueOf((int) (r65 / r49.doubleValue()));
        goto L308
    L247:
        if (Intrinsics.areEqual(r50, "width_percent") == false) goto L281;
        if (r33 == null) goto L263;
        Activity r68 = ug.a.a(r33);
        int r69 = r33.getResources().getConfiguration().screenWidthDp;
        int r126 = r33.getResources().getConfiguration().screenHeightDp;
        if (r68 == null) goto L252;
        boolean r70 = r68.isInMultiWindowMode();
    L254:
        if (Intrinsics.areEqual(r51, Boolean.FALSE) == false) goto L256;
        int r71 = com.lynx.tasm.utils.g.b(52, r33);
    L257:
        Boolean r72 = Boolean.TRUE;
        if (Intrinsics.areEqual(r52, r72) == false) goto L260;
    L261:
        r30 = nb.a.k(r33);
    L262:
        Integer r73 = Integer.valueOf((com.lynx.tasm.utils.g.b(r126, r33) - r71) + r30);
        int r74 = r30;
    L264:
        if (r70 == false) goto L278;
        if (r33 == null) goto L277;
        ((com.bytedance.android.anniex.base.depend.c) com.bytedance.android.anniex.base.depend.a.f3114c.getValue()).getClass();
        Integer r311 = r73;
        if (320 > r69) goto L271;
        if (r69 >= 516) goto L271;
        r59 = Integer.valueOf(com.lynx.tasm.utils.g.b(r69, r33));
        r121 = r46;
    L280:
        StringBuilder r75 = j0.v("contentWidthDp: ", r69, r126, "; contentHeightDp:", "; navigationBarHeight: ");
        r75.append(r71);
        r75.append(";isInMultiWindowMode:");
        r75.append(r70);
        r75.append("; statusBarHeight:");
        r75.append(r74);
        com.bytedance.ies.bullet.base.utils.logger.a.g("BulletPadAdapterUtil", r75.toString(), null, 12);
        r60 = r311;
        r310 = r47;
    L271:
        if (516 > r69) goto L274;
        if (r69 >= 768) goto L274;
        r121 = r46;
        r59 = Integer.valueOf((int) (((double) com.lynx.tasm.utils.g.b(r69, r33)) * 0.8d));
    L274:
        r121 = r46;
        if (r69 < 768) goto L279;
        r59 = Integer.valueOf((int) (((double) com.lynx.tasm.utils.g.b(r69, r33)) * 0.6d));
    L279:
        r59 = null;
        goto L280
    L277:
        r311 = r73;
        r121 = r46;
        goto L279
    L278:
        r311 = r73;
        r121 = r46;
        Lazy r76 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r76.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r76.getValue()).getClass();
        goto L279
    L260:
        if (Intrinsics.areEqual(r54, r72) == false) goto L262;
    L256:
        r71 = 0;
        goto L257
    L252:
        r70 = false;
        goto L254
    L263:
        r71 = 0;
        r74 = 0;
        r70 = false;
        r69 = 0;
        r126 = 0;
        r73 = null;
        goto L264
    L281:
        r121 = r46;
        goto L282
    L235:
        if (r48 == null) goto L238;
        if (r118 == null) goto L238;
        r55 = Integer.valueOf((int) (r48.doubleValue() * ((double) r118.intValue())));
        goto L239
    L230:
        if (r113.intValue() == 0) goto L233;
        r55 = Integer.valueOf((nb.a.h(r33) * r113.intValue()) / 100);
    L238:
        r55 = null;
        goto L239
    L221:
        if (r47.intValue() == 0) goto L223;
        r118 = Integer.valueOf((nb.a.j(r33) * r47.intValue()) / 100);
    L225:
        r118 = null;
        goto L226
    L216:
        r54 = null;
        goto L217
    L213:
        r53 = null;
        goto L214
    L210:
        r52 = null;
        goto L211
    L205:
        r210 = true;
        goto L206
    L207:
        r51 = null;
        goto L208
    L200:
        r50 = null;
        goto L201
    L197:
        r49 = null;
        goto L198
    L194:
        r114 = 1;
        r48 = null;
        goto L195
    L191:
        r113 = null;
        goto L192
    L188:
        r112 = null;
        goto L189
    L185:
        r47 = null;
        goto L186
    L182:
        r46 = null;
        goto L183
    L179:
        r45 = null;
        goto L180
    L98:
        if (r35 == Scenes.f5283c) goto L176;
        if (r33 != null) goto L102;
        com.bytedance.ies.bullet.base.utils.logger.a.d("BulletPadAdapterUtil", "getPadKitViewInfoChannel：context is null", null, 12);
        f10117b = null;
        f10118c = null;
        return new Pair(null, null);
    L102:
        if (r34 == null) goto L104;
        Double r77 = (Double) new vd.a(r34.f21723a, "width", 1).f22372b;
    L105:
        if (r34 == null) goto L107;
        Integer r78 = (Integer) new vd.a(r34.f21723a, "width_percent", 5).f22372b;
    L108:
        if (r34 == null) goto L110;
        Double r127 = (Double) new vd.a(r34.f21723a, "height", 1).f22372b;
    L111:
        if (r34 == null) goto L113;
        Integer r128 = (Integer) new vd.a(r34.f21723a, "height_percent", 5).f22372b;
    L114:
        if (r34 == null) goto L116;
        Double r79 = (Double) new vd.a(r34.f21723a, "aspect_ratio", 1).f22372b;
    L117:
        if (r34 == null) goto L125;
        rd.b r129 = r34.f21723a;
        if (r35 == Scenes.f5282b) goto L121;
        boolean r211 = true;
    L122:
        Boolean r80 = (Boolean) new vd.a(r129, "hide_nav_bar", Boolean.valueOf(r211)).f22372b;
        if (r80 == null) goto L125;
        boolean r81 = r80.booleanValue();
    L126:
        if (r34 == null) goto L130;
        Boolean r82 = (Boolean) new vd.a(r34.f21723a, "hide_status_bar", Boolean.FALSE).f22372b;
        if (r82 == null) goto L130;
        boolean r83 = r82.booleanValue();
    L131:
        if (r34 == null) goto L135;
        Boolean r84 = (Boolean) new vd.a(r34.f21723a, "should_full_screen", Boolean.FALSE).f22372b;
        if (r84 == null) goto L135;
        boolean r85 = r84.booleanValue();
    L136:
        int r86 = r36.screenWidthDp;
        int r87 = r36.screenHeightDp;
        if (r83 == true) goto L141;
        if (r85 == true) goto L141;
        int r88 = 0;
    L142:
        if (r81 == true) goto L144;
        int r130 = 52;
    L145:
        int r131 = com.lynx.tasm.utils.g.b(r87 - r130, r33) + r88;
        int r89 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoChannel：窗口尺寸(" + r86 + ',' + r87 + "), 容器高度=" + com.lynx.tasm.utils.g.h(r131, r33) + "，schema参数（width=" + r77 + "，width_percent=" + r78 + "，height=" + r127 + "，height_percent=" + r128 + "，aspect_ratio=" + r79 + 65289);
        if (r86 > 480) goto L149;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoChannel：窗口宽度小于480dp全屏展示");
        f10117b = Integer.valueOf(com.lynx.tasm.utils.g.b(r86, r33));
        f10118c = Integer.valueOf(r131);
        return new Pair(-1, -1);
    L149:
        if (r78 != null) goto L151;
    L153:
        if (r77 == null) goto L155;
        List r90 = nb.a.f20224a;
        float r91 = (float) r77.doubleValue();
        Intrinsics.checkNotNullParameter(r33, "context");
        Integer r92 = Integer.valueOf((int) ((nb.a.a(r33) * r91) + 0.5f));
    L156:
        if (r92 == null) goto L158;
        int r93 = r92.intValue();
    L159:
        if (r93 <= 0) goto L162;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoChannel：使用自定义宽度，width=" + com.lynx.tasm.utils.g.h(r93, r33));
    L161:
        int r94 = r93;
        Integer r95 = d(r33, r131, r127, r128, r79, Integer.valueOf(r94));
        if (r95 == null) goto L166;
        r30 = r95.intValue();
    L166:
        int r96 = r30;
        if (r96 <= 0) goto L169;
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoChannel：使用自定义高度，height=" + com.lynx.tasm.utils.g.h(r96, r33));
    L170:
        f10117b = Integer.valueOf(r94);
        f10118c = Integer.valueOf(r96);
        Integer r97 = Integer.valueOf(r94);
        if (r96 == r131) goto L175;
        r28 = r96;
    L175:
        return new Pair(r97, Integer.valueOf(r28));
    L169:
        com.bytedance.ies.bullet.base.utils.logger.a.c("BulletPadAdapterUtil", "getPadKitViewInfoChannel：高度全屏展示");
        r96 = r131;
        goto L170
    L162:
        Lazy r98 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r98.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r98.getValue()).getClass();
        r93 = com.lynx.tasm.utils.g.b(r86, r33);
        goto L161
    L158:
        r93 = 0;
        goto L159
    L155:
        r92 = null;
        goto L156
    L151:
        if (r78.intValue() == 0) goto L153;
        r92 = Integer.valueOf((com.lynx.tasm.utils.g.b(r86, r33) * r78.intValue()) / 100);
        goto L156
    L144:
        r130 = 0;
    L141:
        r88 = nb.a.k(r33);
    L135:
        r85 = false;
    L130:
        r83 = false;
        goto L131
    L121:
        r211 = false;
    L125:
        r81 = false;
        goto L126
    L116:
        r79 = null;
        goto L117
    L113:
        r128 = null;
        goto L114
    L110:
        r127 = null;
        goto L111
    L107:
        r78 = null;
        goto L108
    L104:
        r77 = null;
        goto L105
    L94:
        r44 = null;
        goto L96
    L5:
        r10 = null;
        goto L6
    }

    public static void i(rd.e r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaModelUnion");
        Lazy r10 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r10.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r10.getValue()).getClass();
    }

    public static void j(Path r10, qp.d r11, float r12, float r13, float r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$arcTo");
        Intrinsics.checkNotNullParameter(r11, "arcCenter");
        float r5 = r11.f21555a;
        float r15 = r11.f21556b;
        r10.arcTo(r5 - r12, r15 - r12, r5 + r12, r15 + r12, r13, r14 - r13, false);
    }

    public static final k k(String r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        k r11 = (k) r10.get(r5);
        if (r11 != null) goto L6;
        k r12 = new k(0);
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }

    public static final o l(String r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        o r11 = (o) r10.get(r5);
        if (r11 != null) goto L6;
        o r12 = new o(0);
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }

    public static e0 m(String r10, List r11, KModifier r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "bounds");
        if (r12 == null) goto L10;
        if (com.squareup.kotlinpoet.f0.g(r12, KModifier.IN, KModifier.OUT, null, null, 60) == true) goto L10;
        throw new IllegalArgumentException((r12 + " is an invalid variance modifier, the only allowed values are in and out!").toString());
    L10:
        if (r11.isEmpty() == true) goto L14;
        return new e0(r10, r11, r12, 120);
    L14:
        throw new IllegalArgumentException(j0.j(r10, " has no bounds").toString());
    }

    public static void n(mt.n r5, u r10) {
        LinkedBlockingQueue r11 = new LinkedBlockingQueue();
        BlockingObserver r12 = new BlockingObserver(r11);
        r10.onSubscribe(r12);
        r5.subscribe(r12);
    L4:
        if (r12.isDisposed() == true) goto L28;
        Object r13 = r11.poll();
        if (r13 != null) goto L14;
        r13 = r11.take();     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        r12.dispose();
        r10.onError(e);
        return;
    L14:
        if (r12.isDisposed() == true) goto L29;
        if (r5 == BlockingObserver.TERMINATED) goto L19;
        if (NotificationLite.acceptFull(r13, r10) == false) goto L4;
        return;
    L19:
        return;
    L29:
        return;
    }

    public static void o(mt.n r5, pt.g r10, pt.g r11, pt.a r12) {
        io.reactivex.internal.functions.e.d(r10, "onNext is null");
        io.reactivex.internal.functions.e.d(r11, "onError is null");
        io.reactivex.internal.functions.e.d(r12, "onComplete is null");
        n(r5, new LambdaObserver(r10, r11, r12, io.reactivex.internal.functions.e.d));
    }
}
