package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jg.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f5444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f5445b = null;

    static {
        f5444a = new ConcurrentHashMap();
        f5445b = new ConcurrentHashMap();
    }

    public static fc.a a(String r16, wc.e r17, String r18, boolean r19, wc.g r20) {
        String r5 = "";
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r17, "config");
        Intrinsics.checkNotNullParameter(r18, "bid");
        Intrinsics.checkNotNullParameter(r20, "taskConfig");
        com.bytedance.ies.bullet.base.utils.logger.b r10 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r11 = r20.f22848q;
        Intrinsics.checkNotNullParameter("resourceSession", "name");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        r10.f5260a.add(new com.bytedance.ies.bullet.base.utils.logger.c("resourceSession", r11));
        Uri r12 = Uri.parse(r16);
        wc.c r13 = r17.f.getLoaderDepender();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L18
        String r15 = i.c(r12);     // Catch: Throwable -> L18
        if (r15 != null) goto L6;
        r15 = "";
    L6:
        String r21 = r12.getQueryParameter("res_url");     // Catch: Throwable -> L18
        if (r21 != null) goto L10;
        r21 = "";
    L10:
        if (r15.length() <= 0) goto L13;
    L16:
        Object r22 = Result.m124constructorimpl(r15);     // Catch: Throwable -> L18
    L21:
        if (Result.m130isFailureimpl(r22) == false) goto L23;
        r22 = "";
    L23:
        String r23 = (String) r22;
        ConcurrentHashMap r24 = f5445b;
        if (r24.get(r23) == null) goto L35;
        int r25 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        fc.a r26 = (fc.a) r24.get(r23);
        if (r26 == null) goto L28;
        String r27 = r26.f16888a;
    L29:
        Pair r28 = TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r27);
        fc.a r29 = (fc.a) r24.get(r23);
        if (r29 == null) goto L32;
        String r30 = r29.f16889b;
    L33:
        Map r31 = MapsKt.mapOf(new Pair[]{r28, TuplesKt.to("bundle", r30)});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("get RLChannelBundleModel from ResultMap", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "get RLChannelBundleModel from ResultMap", r31, r10);
        return (fc.a) r24.get(r23);
    L32:
        r30 = null;
        goto L33
    L28:
        r27 = null;
        goto L29
    L35:
        if (r19 == false) goto L43;
        Uri r32 = Uri.parse(r16);
        wc.g r33 = new wc.g("");
        r33.a(r20);
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r33.f22839h = r23;
        Unit r110 = Unit.INSTANCE;
        wc.g r34 = ((c) r13).c(r32, r33);
        if (r34.f.length() <= 0) goto L43;
        if (r34.g.length() <= 0) goto L43;
        int r35 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r36 = MapsKt.mapOf(new Pair[]{TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r34.f), TuplesKt.to("bundle", r34.g)});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("get RLChannelBundleModel from loaderDepender", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "get RLChannelBundleModel from loaderDepender", r36, r10);
        return new fc.a(r34.f, r34.g, true);
    L43:
        if (Intrinsics.areEqual(r20.f22840i, "web") == false) goto L164;
        String r37 = "";
    L56:
        String r38 = r5;
        if (Intrinsics.areEqual(r20.f22840i, "web") == true) goto L72;
        String r39 = r12.getQueryParameter("bundle");     // Catch: Throwable -> L64
        if (r39 != null) goto L62;
        r39 = "";
    L62:
        Object r40 = Result.m124constructorimpl(r39);     // Catch: Throwable -> L64
    L66:
        Object r41 = r5;
        if (Result.m130isFailureimpl(r40) == true) goto L70;
        r41 = r40;
    L70:
        r38 = (String) r41;
    L64:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r40 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L72:
        if (r37.length() > 0) goto L74;
    L77:
        ArrayList r43 = new ArrayList();
        if (r20.f22847p.isEmpty() == true) goto L80;
        r43.addAll(r20.f22847p);
    L81:
        String r44 = r12.getQueryParameter("prefix");
        boolean r45 = false;
        if (r44 != null) goto L84;
    L94:
        k r46 = r20.f22846o;
        if (r46 == null) goto L99;
        wc.b r47 = (wc.b) r46.b(wc.b.class);
        if (r47 == null) goto L99;
        String r48 = r47.f22824a;
        r43.add(r48);
        dc.b.a("ChannelBundleParser get url prefix: ".concat(r48));
    L99:
        ArrayList r49 = new ArrayList();
        ArrayList r50 = new ArrayList(CollectionsKt.h(r43));
        Iterator r51 = r43.iterator();
    L101:
        if (r51.hasNext() == false) goto L122;
        String r52 = (String) r51.next();
        if (r52 == null) goto L120;
        if (TextUtils.isEmpty(StringsKt.trim(r52).toString()) == false) goto L108;
        r52 = null;
    L108:
        if (r52 != null) goto L110;
        boolean r53 = r45;
        Boolean r54 = null;
    L118:
        r50.add(r54);
        r45 = r53;
        goto L101
    L110:
        if (r52.length() > 0) goto L112;
        r53 = r45;
    L116:
        r54 = Boolean.valueOf(r49.add(r52));
        goto L118
    L112:
        if (StringsKt.u(r52, "/") != (r52.length() - 1)) goto L114;
        r53 = false;
        r52 = androidx.constraintlayout.motion.widget.a.n(r52, 1, 0);
        goto L116
    L114:
        r53 = false;
        goto L116
    L120:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L122:
        if (r23.length() != 0) goto L166;
    L149:
        fc.a r55 = null;
    L150:
        int r56 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        if (r55 == null) goto L153;
        String r57 = r55.f16888a;
    L154:
        Pair r58 = TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r57);
        if (r55 == null) goto L157;
        String r111 = r55.f16889b;
    L158:
        Map r59 = MapsKt.mapOf(new Pair[]{r58, TuplesKt.to("bundle", r111)});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("get RLChannelBundleModel from parse prefix", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "get RLChannelBundleModel from parse prefix", r59, r10);
        return r55;
    L157:
        r111 = null;
        goto L158
    L153:
        r57 = null;
        goto L154
    L166:
        Iterator r60 = r49.iterator();     // Catch: Exception -> L133
    L126:
        if (r60.hasNext() == false) goto L149;
        String r61 = (String) r60.next();     // Catch: Exception -> L133
        if (r61.length() == 0) goto L126;
        ConcurrentHashMap r62 = f5444a;     // Catch: Exception -> L133
        Pattern r63 = (Pattern) r62.get(r61);     // Catch: Exception -> L133
        if (r63 != null) goto L135;
        r63 = Pattern.compile(r61 + "/(([^/]+)/([^?]*))");     // Catch: Exception -> L133
        r62.put(r61, r63);     // Catch: Exception -> L133
    L135:
        Intrinsics.checkNotNull(r63);     // Catch: Exception -> L133
        Matcher r64 = r63.matcher(r23);     // Catch: Exception -> L133
        if (r64.find() == false) goto L126;
        if (r64.groupCount() != 3) goto L126;
        String r65 = r64.group(2);     // Catch: Exception -> L133
        String r66 = r64.group(3);     // Catch: Exception -> L133
        if (r65 == null) goto L126;
        if (r65.length() <= 0) goto L126;
        if (r66 == null) goto L126;
        if (r66.length() <= 0) goto L126;
        Intrinsics.checkNotNull(r65);     // Catch: Exception -> L133
        Intrinsics.checkNotNull(r66);     // Catch: Exception -> L133
        r55 = new fc.a(r65, r66, true);     // Catch: Exception -> L133
        r24.put(r23, r55);     // Catch: Exception -> L133
    L133:
        e = move-exception;
        Log.w("ChannelBundleParser", "ChannelBundleModel parse error: " + e.getMessage());
        goto L149
    L84:
        if (TextUtils.isEmpty(StringsKt.trim(r44).toString()) == false) goto L87;
        r44 = null;
    L87:
        if (r44 == null) goto L94;
        if (r44.length() > 0) goto L91;
    L93:
        r43.add(r44);
        goto L94
    L91:
        if (StringsKt.u(r44, "/") != (r44.length() - 1)) goto L93;
        r44 = androidx.constraintlayout.motion.widget.a.n(r44, 1, 0);
        goto L93
    L80:
        r43.addAll(r17.f22827b);
        goto L81
    L74:
        if (r38.length() <= 0) goto L77;
        int r67 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r68 = MapsKt.mapOf(new Pair[]{TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r37), TuplesKt.to("bundle", r38)});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("get RLChannelBundleModel from uri", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "get RLChannelBundleModel from uri", r68, r10);
        return new fc.a(r37, r38, true);
    L164:
        String r69 = r12.getQueryParameter(LynxMonitorService.KEY_CHANNEL);     // Catch: Throwable -> L50
        if (r69 != null) goto L48;
        r69 = "";
    L48:
        Object r70 = Result.m124constructorimpl(r69);     // Catch: Throwable -> L50
    L53:
        if (Result.m130isFailureimpl(r70) == false) goto L55;
        r70 = "";
    L55:
        r37 = (String) r70;
    L50:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        r70 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L53
    L13:
        if (r21.length() > 0) goto L16;
        r15 = r16;
    L18:
        th = move-exception;
        Result.Companion r72 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
