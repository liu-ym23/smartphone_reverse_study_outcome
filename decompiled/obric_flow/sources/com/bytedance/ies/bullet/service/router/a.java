package com.bytedance.ies.bullet.service.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.android.anniex.utils.d;
import com.bytedance.ies.bullet.base.utils.logger.c;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.f;
import com.bytedance.ies.bullet.core.s;
import com.bytedance.ies.bullet.prefetchv2.o;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.j;
import com.bytedance.ies.bullet.service.base.l;
import com.bytedance.ies.bullet.service.base.n;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback$ErrStage;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m.b;
import org.json.JSONObject;
import ym.m;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6128a;

    public a(String r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r10, "interceptor");
        this.f6128a = r5;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public final void a(e r37, String r38, String r39, n r40) {
        n r5 = r40;
        Intrinsics.checkNotNullParameter(r5, "self");
        com.bytedance.ies.bullet.base.utils.logger.b r10 = new com.bytedance.ies.bullet.base.utils.logger.b();
        if (r37 == null) goto L6;
        String r11 = r37.getSessionId();
        if (r11 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("session_id", r11, r10.f5260a);
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.f6128a), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to("url", String.valueOf(r40.getSchema())), TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r38), TuplesKt.to("bundle", r39)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("start try close Affinity", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "start try close Affinity", r13, r10);
        Uri r14 = r40.getSchema();
        String r15 = this.f6128a;
        Intrinsics.checkNotNullParameter(r15, "bid");
        Intrinsics.checkNotNullParameter(r5, "self");
        if (r37 == null) goto L10;
        vd.a r16 = new vd.a(r37.g.f21723a, LaunchMode.f6147b);
    L11:
        com.bytedance.ies.bullet.base.utils.logger.b r17 = new com.bytedance.ies.bullet.base.utils.logger.b();
        if (r37 == null) goto L15;
        String r18 = r37.getSessionId();
        if (r18 == null) goto L15;
    L16:
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        r17.f5260a.add(new c("session_id", r18));
        Object r19 = "url";
        String r20 = "launchMode";
        Map r21 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", r15), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to(r19, String.valueOf(r40.getSchema())), TuplesKt.to("launchMode", String.valueOf(r16))});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("start shouldCloseAffinityV2 call", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.e(true, "XRouter", "start shouldCloseAffinityV2 call", r21, r17);
        String r110 = "XPage";
        String r111 = "XPopup";
        String r22 = "getActivityList:";
        Object r23 = "result";
        boolean r24 = false;
        if (r16 == null) goto L49;
        LaunchMode r25 = (LaunchMode) r16.f22372b;
        if (r25 == null) goto L49;
        Class r26 = j.class;
        if (LaunchMode.f6148c != r25) goto L50;
        if (r37 == null) goto L24;
        String r27 = (String) new vd.a(r37.g.f21723a, "bdx_tag", null).f22372b;
    L25:
        Map r28 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", r15), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to(r19, String.valueOf(r40.getSchema())), TuplesKt.to("launchMode", r16.i()), TuplesKt.to("launchModeTag", r27)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("shouldCloseAffinityV2 getLaunchModeTag", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.e(true, "XRouter", "shouldCloseAffinityV2 getLaunchModeTag", r28, r17);
        if (r27 != null) goto L28;
    L29:
        r5 = r40;
        r22 = r22;
        r19 = r19;
        Map r29 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", r15), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to(r19, String.valueOf(r40.getSchema())), TuplesKt.to("launchMode", r16.toString()), TuplesKt.to(r23, Boolean.FALSE)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("close affinity fail", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XRouter", "close affinity fail", r29, r17);
        String r210 = r111;
        r23 = r23;
        boolean r30 = false;
    L52:
        if (r30 == false) goto L55;
        Map r31 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.f6128a), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to(r19, String.valueOf(r14)), TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r38), TuplesKt.to("bundle", r39)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("Use shouldCloseAffinityV2 to close the view of affinity", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "Use shouldCloseAffinityV2 to close the view of affinity", r31, r10);
        return;
    L55:
        Object r112 = r19;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L71
        if (r14 != null) goto L59;
        Object r113 = r23;
        Uri r33 = r14;
        String r34 = null;
    L137:
        Object r35 = Result.m124constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r34, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST)));     // Catch: Throwable -> L69
    L75:
        if (Result.m130isFailureimpl(r35) == false) goto L77;
        r35 = null;
    L77:
        Boolean r36 = (Boolean) r35;
        if (r36 == null) goto L80;
        boolean r41 = r36.booleanValue();
    L81:
        String r42 = "IRouterAbilityProvider";
        if (r41 == true) goto L84;
        int r43 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r44 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.f6128a), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to(r112, String.valueOf(r33)), TuplesKt.to("IRouterAbilityProvider", r5), TuplesKt.to(LynxMonitorService.KEY_CHANNEL, r38), TuplesKt.to("bundle", r39)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("this RouterAbilityProvider never need to close the view of affinity", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.e(true, "XRouter", "this RouterAbilityProvider never need to close the view of affinity", r44, r10);
        return;
    L84:
        com.bytedance.ies.bullet.service.base.b.d(com.lynx.tasm.utils.b.j("close affinity, curChannel:", r38, ", curBundle:", r39), LogLevel.f5954b, "XRouter");
        if (r38.length() != 0) goto L87;
        boolean r45 = true;
    L88:
        if (r45 == false) goto L90;
        return;
    L90:
        if (r39.length() != 0) goto L92;
        boolean r46 = true;
    L93:
        if (r46 == false) goto L96;
        return;
    L96:
        if ((r5 instanceof Activity) == false) goto L114;
        com.bytedance.ies.bullet.service.base.router.config.b r47 = (com.bytedance.ies.bullet.service.base.router.config.b) com.bytedance.ies.bullet.service.base.router.config.b.f6000c.getValue();
        r47.getClass();
        String r114 = "moduleTag";
        Object r211 = "bundle";
        String r48 = r22 + r47.f6001a;
        String r115 = r110;
        Object r212 = LynxMonitorService.KEY_CHANNEL;
        com.bytedance.ies.bullet.service.base.b.a(2, r48, r115);
        Iterator r49 = CollectionsKt.reversed(r47.f6001a).iterator();
    L99:
        if (r49.hasNext() == false) goto L113;
        n r50 = (n) r49.next();
        String r51 = r50.getBid();
        String r116 = r50.getChannel();
        r49 = r49;
        String r52 = r50.d();
        r42 = r42;
        StringBuilder r53 = com.lynx.tasm.base.a.e("closeAffinityPage, channel:", r116, ", bundle:", r52, ", bid:");
        r53.append(r51);
        String r54 = r53.toString();
        r112 = r112;
        LogLevel r117 = LogLevel.f5954b;
        com.bytedance.ies.bullet.service.base.b.d(r54, r117, "XRouter");
        if (Intrinsics.areEqual(r50, r5) == false) goto L103;
    L109:
        r50 = null;
    L110:
        if (r50 == null) goto L99;
        com.bytedance.ies.bullet.service.base.b.d("do closeAffinityPage", r117, "XRouter");
        r50.close();
        r24 = true;
        goto L99
    L103:
        if (Intrinsics.areEqual(r51, this.f6128a) == false) goto L109;
        if (Intrinsics.areEqual(r116, r38) == false) goto L109;
        if (Intrinsics.areEqual(r52, r39) == false) goto L109;
    L113:
        String r213 = r42;
        Object r214 = r112;
    L135:
        int r55 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r56 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", this.f6128a), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to(r214, String.valueOf(r33)), TuplesKt.to(r213, r5), TuplesKt.to(r212, r38), TuplesKt.to(r211, r39), TuplesKt.to(r113, Boolean.valueOf(r24))});
        Intrinsics.checkNotNullParameter("XRouter", r114);
        Intrinsics.checkNotNullParameter("try close affinity result", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "try close affinity result", r56, r10);
        return;
    L114:
        r212 = LynxMonitorService.KEY_CHANNEL;
        r211 = "bundle";
        r213 = "IRouterAbilityProvider";
        r114 = "moduleTag";
        r214 = r112;
        tc.c r57 = tc.c.f22119c;
        if (((j) tc.c.f22119c.a(r26, this.f6128a)) == null) goto L135;
        StringBuilder r58 = new StringBuilder("getPopupsStack:");
        ArrayList r59 = md.b.f;
        r58.append(r59);
        com.bytedance.ies.bullet.service.base.b.a(2, r58.toString(), r210);
        List r60 = CollectionsKt.reversed(r59);
        if (r60 == null) goto L135;
        Iterator r61 = r60.iterator();
        boolean r62 = false;
    L120:
        if (r61.hasNext() == false) goto L134;
        n r63 = (n) r61.next();
        String r64 = r63.getBid();
        String r118 = r63.getChannel();
        String r119 = r63.d();
        r61 = r61;
        StringBuilder r65 = com.lynx.tasm.base.a.e("closeAffinityPopup, channel:", r118, ", bundle:", r119, ", bid:");
        r65.append(r64);
        String r66 = r65.toString();
        boolean r120 = r62;
        LogLevel r67 = LogLevel.f5954b;
        com.bytedance.ies.bullet.service.base.b.d(r66, r67, "XRouter");
        if (Intrinsics.areEqual(r63, r5) == false) goto L124;
    L130:
        r63 = null;
    L131:
        if (r63 != null) goto L132;
        r62 = r120;
        goto L120
    L132:
        com.bytedance.ies.bullet.service.base.b.d("do closeAffinityPopup", r67, "XRouter");
        r63.close();
        r62 = true;
        goto L120
    L124:
        if (Intrinsics.areEqual(r64, this.f6128a) == false) goto L130;
        if (Intrinsics.areEqual(r118, r38) == false) goto L130;
        if (Intrinsics.areEqual(r119, r39) == false) goto L130;
    L134:
        r24 = r62;
        goto L135
    L92:
        r46 = false;
        goto L93
    L87:
        r45 = false;
        goto L88
    L80:
        r41 = false;
    L69:
        th = th;
    L73:
        Result.Companion r68 = Result.Companion;
        r35 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L75
    L59:
        r113 = r23;
        r33 = r14;
        r34 = r33.getQueryParameter("launch_mode");     // Catch: Throwable -> L62
    L62:
        th = th;
        r22 = r22;
    L71:
        th = th;
        r113 = r23;
        r22 = r22;
        r33 = r14;
        goto L73
    L28:
        if (r27.length() == 0) goto L29;
        com.bytedance.android.anniex.container.util.b.a(r27, r25, null);
        r5 = r40;
        if ((r5 instanceof Activity) == false) goto L37;
        if (r37 == null) goto L34;
        String r69 = r37.getSessionId();
    L35:
        com.bytedance.ies.bullet.service.base.router.config.b r70 = (com.bytedance.ies.bullet.service.base.router.config.b) com.bytedance.ies.bullet.service.base.router.config.b.f6000c.getValue();
        r70.getClass();
        boolean r71 = com.bytedance.ies.bullet.service.base.b.f5956a;
        r22 = "getActivityList:";
        com.bytedance.ies.bullet.service.base.b.a(2, r22 + r70.f6001a, "XPage");
        r30 = p.k(r69, r5, r27, CollectionsKt.reversed(r70.f6001a));
        r111 = r111;
    L36:
        r19 = r19;
        r20 = "launchMode";
    L51:
        r210 = r111;
        Map r72 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bid", r15), TuplesKt.to("bulletTag", r40.e()), TuplesKt.to(r19, String.valueOf(r40.getSchema())), TuplesKt.to(r20, String.valueOf(r16)), TuplesKt.to(r23, Boolean.valueOf(r30))});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("close affinity result", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.e(true, "XRouter", "close affinity result", r72, r17);
        goto L52
    L34:
        r69 = null;
        goto L35
    L37:
        r110 = r110;
        r22 = r22;
        if (r37 == null) goto L40;
        String r73 = r37.getSessionId();
    L41:
        tc.c r74 = tc.c.f22119c;
        r26 = r26;
        if (((j) tc.c.f22119c.a(r26, r15)) == null) goto L44;
        boolean r75 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r76 = new StringBuilder("getPopupsStack:");
        ArrayList r77 = md.b.f;
        r76.append(r77);
        r111 = r111;
        com.bytedance.ies.bullet.service.base.b.a(2, r76.toString(), r111);
        List r78 = CollectionsKt.reversed(r77);
    L45:
        r30 = p.k(r73, r5, r27, r78);
        goto L36
    L44:
        r111 = r111;
        r78 = null;
        goto L45
    L40:
        r73 = null;
        goto L41
    L24:
        r27 = null;
    L50:
        r30 = false;
    L49:
        r26 = j.class;
    L15:
        r18 = "";
        goto L16
    L10:
        r16 = null;
    L6:
        r11 = "";
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v9, types: [rc.d] */
    /* JADX WARN: Type inference failed for: r2v119, types: [tc.c] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v68, types: [tc.a] */
    /* JADX WARN: Type inference failed for: r3v75 */
    /* JADX WARN: Type inference failed for: r3v76 */
    /* JADX WARN: Type inference failed for: r3v77 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean b(Context r44, final Uri r45, final com.bytedance.ies.bullet.service.base.router.config.a r46) {
        Intrinsics.checkNotNullParameter(r44, "context");
        Intrinsics.checkNotNullParameter(r45, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r46, "config");
        long r12 = System.currentTimeMillis();
        d r5 = new d();
        if (xq.b.c() == false) goto L5;
        Bundle r10 = new Bundle(r46.f5997a);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r46.f5997a = r10;
    L5:
        String r15 = com.bytedance.android.anniex.utils.e.b(r45);
        int r16 = 0;
        if (Intrinsics.areEqual(r15, "_popup") == false) goto L8;
        String r11 = m.f(r45, "popup_type_opt");
        Triple r13 = new Triple(Boolean.TRUE, r11, Boolean.valueOf(com.bytedance.android.anniex.utils.e.h(r11)));
    L16:
        ((Boolean) r13.component1()).getClass();
        String r14 = (String) r13.component2();
        if (((Boolean) r13.component3()).booleanValue() == false) goto L22;
        m.f(r45, "__bullet_trident_call_id");
        String r17 = com.lynx.tasm.behavior.utils.d.b(r45, r46.f5997a);
        LinkedHashMap r19 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.j(r17, Long.valueOf(r12));
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        Intrinsics.checkNotNullParameter(r45, "schema");
        Intrinsics.checkNotNullParameter("page", "viewType");
        com.bytedance.android.anniex.assemble.a.b(x3.e.class, this.f6128a);
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L22;
        throw null;
    L22:
        Lazy r18 = f.f5312b;
        f r20 = td.b.b();
        String r110 = this.f6128a;
        Bundle r21 = r46.f5997a;
        com.bytedance.ies.bullet.service.sdk.a r22 = new com.bytedance.ies.bullet.service.sdk.a();
        o4.a r23 = new o4.a(r46.f5997a);
        Intrinsics.checkNotNullParameter(r23, "interceptor");
        r22.f6132a.add(r23);
        o4.a r24 = new o4.a(r46.f5998b);
        Intrinsics.checkNotNullParameter(r24, "interceptor");
        r22.f6132a.add(r24);
        com.bytedance.ies.bullet.forest.n r25 = new com.bytedance.ies.bullet.forest.n(4);
        Intrinsics.checkNotNullParameter(r25, "interceptor");
        r22.f6132a.add(r25);
        Intrinsics.checkNotNullParameter(this.f6128a, "bid");
        com.bytedance.ies.bullet.forest.n r26 = new com.bytedance.ies.bullet.forest.n(3);
        Intrinsics.checkNotNullParameter(r26, "interceptor");
        r22.f6132a.add(r26);
        Unit r27 = Unit.INSTANCE;
        e r28 = r20.b(r110, r45, r21, true, r22);
        Intrinsics.checkNotNullParameter(r44, "caller");
        String r29 = r28.getSessionId();
        r28.f5311z.getClass();
        Intrinsics.checkNotNullParameter(r44, "caller");
        Intrinsics.checkNotNullParameter(r29, "sessionId");
        h.f.b(new com.airbnb.lottie.j(r44, r29, 1), h.f.g);
        String r30 = m.f(r45, "__bullet_trident_call_id");
        if (r30 != null) goto L25;
        String r111 = "";
    L26:
        com.bytedance.ies.bullet.base.utils.logger.b r31 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r32 = r28.getSessionId();
        Intrinsics.checkNotNullParameter("session_id", "name");
        Intrinsics.checkNotNullParameter(r32, "sessionId");
        r31.f5260a.add(new c("session_id", r32));
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r111, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("callId", r111, r31.f5260a);
        int r33 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        String r210 = r111;
        Map r34 = MapsKt.mapOf(new Pair[]{TuplesKt.to("schema", r45.toString()), TuplesKt.to("bid", this.f6128a)});
        String r35 = "moduleTag";
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        String r36 = "msg";
        Intrinsics.checkNotNullParameter("start create container", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "start create container", r34, r31);
        String r37 = r28.getSessionId();
        if (Intrinsics.areEqual(com.bytedance.android.anniex.utils.e.b(r45), "_popup") == false) goto L29;
        String r38 = OpenPageMethod.APP_POPUP;
    L30:
        Intrinsics.checkNotNullParameter(r37, "sessionId");
        Intrinsics.checkNotNullParameter(r45, "schema");
        Intrinsics.checkNotNullParameter(r38, "viewType");
        r28.f5293c.c(r12, true);
        Intrinsics.checkNotNullParameter(r45, LynxResourceModule.URI_KEY);
        if (r45.isHierarchical() == true) goto L33;
    L217:
        Map r39 = MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "cancelled by interceptor.onPrepare"), TuplesKt.to("schema", r45.toString()), TuplesKt.to("bid", this.f6128a)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("RouterService create container failed", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XRouter", "RouterService create container failed", r39, r31);
        r28.f5293c.f(AbsBulletMonitorCallback$ErrStage.f6029b, "invalid_url");
        return false;
    L33:
        if (TextUtils.isEmpty(r45.getScheme()) == true) goto L217;
        if (TextUtils.isEmpty(r45.getHost()) == true) goto L217;
        if (Intrinsics.areEqual(r15, "_popup") == false) goto L40;
        tc.c r40 = tc.c.f22119c;
        ?? r41 = (rc.d) tc.c.f22119c.a(j.class, this.f6128a);
    L43:
        if (r41 == 0) goto L45;
        boolean r112 = true;
    L46:
        Map r113 = MapsKt.mapOf(new Pair[]{TuplesKt.to("getServiceSuccess", Boolean.valueOf(r112)), TuplesKt.to("uiType", r15)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("get bullet ui service", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "get bullet ui service", r113, r31);
        ConcurrentHashMap r114 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        String r115 = "default_bid";
        xc.e r116 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        String r211 = "cls";
        if (r116 == null) goto L53;
        xc.d r117 = (xc.d) r116.a(xc.d.class);
        if (r117 == null) goto L53;
        Boolean r118 = r117.X();
        if (r118 == null) goto L53;
        boolean r119 = r118.booleanValue();
    L54:
        if (r119 == false) goto L61;
        if (r41 != 0) goto L61;
        if (Intrinsics.areEqual(r15, "_popup") == false) goto L61;
        if (Intrinsics.areEqual(this.f6128a, "default_bid") == false) goto L61;
        r41 = new md.b();
        tc.c.f22119c.c("default_bid", j.class, r41);
        com.bytedance.ies.bullet.base.utils.logger.a.g("XRouter", Log.getStackTraceString(new RuntimeException("===match bullet force bind default_bid PopUpService trace===")), null, 12);
    L61:
        ?? r120 = r41;
        if (r120 != 0) goto L65;
        Map r42 = MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "page/popup service empty"), TuplesKt.to(LynxResourceModule.URI_KEY, r45.toString())});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("bulletUiService is null,create container failed", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XRouter", "bulletUiService is null,create container failed", r42, r31);
        r28.f5293c.f(AbsBulletMonitorCallback$ErrStage.f6029b, "unregister_service");
        return false;
    L65:
        String r121 = "bid";
        r28.f5293c.j("router_pre_open", new RouterService$open$1(r46, r45));
        r28.f5306u.f5321c = null;
        r28.f5308w.f5277h = null;
        r28.f = this.f6128a;
        Map r43 = MapsKt.mapOf(new Pair[]{TuplesKt.to("initData", ""), TuplesKt.to(LynxResourceModule.URI_KEY, r45.toString())});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("create bulletContext with schema", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "create bulletContext with schema", r43, r31);
        Uri r47 = r28.f5297k;
        Intrinsics.checkNotNull(r47);
        Intrinsics.checkNotNullParameter(r47, "bulletUri");
        com.bytedance.ies.bullet.base.utils.logger.b r48 = new com.bytedance.ies.bullet.base.utils.logger.b();
        String r49 = r28.getSessionId();
        Uri r212 = r47;
        Intrinsics.checkNotNullParameter("session_id", "name");
        String r122 = "sessionId";
        Intrinsics.checkNotNullParameter(r49, r122);
        r48.f5260a.add(new c("session_id", r49));
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r210, r122);
        r48.f5260a.add(new c("callId", r210));
        Intrinsics.checkNotNullParameter(r48, "logContext");
        vd.a r50 = new vd.a(r28.g.f21723a, LaunchMode.f6147b);
        Map r51 = MapsKt.mapOf(TuplesKt.to("launchMode", r50.i()));
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("clearTopActivity launch mode", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "clearTopActivity launch mode", r51, r48);
        if (LaunchMode.d == ((LaunchMode) r50.f22372b)) goto L69;
        com.bytedance.ies.bullet.base.utils.logger.b r213 = r31;
        Object r52 = "result";
        String r310 = r121;
        String r311 = "default_bid";
    L68:
        boolean r53 = true;
    L158:
        if (r16 == 0) goto L161;
        Map r54 = MapsKt.mapOf(TuplesKt.to(r52, "true"));
        Intrinsics.checkNotNullParameter("XRouter", r35);
        Intrinsics.checkNotNullParameter("RouterService clearTopActivity result", r36);
        com.bytedance.ies.bullet.base.utils.logger.a.h(r53, "XRouter", "RouterService clearTopActivity result", r54, r213);
        return r53;
    L161:
        com.bytedance.ies.bullet.base.utils.logger.b r55 = r213;
        rd.b r56 = r28.g.f21723a;
        Boolean r57 = Boolean.FALSE;
        vd.a r58 = new vd.a(r56, "disable_prefetch", r57);
        vd.a r59 = new vd.a(r28.g.f21723a, "enable_prefetch", r57);
        boolean r60 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(6, "RouterService.doOptimiseTask, disablePrefetch=" + r58.f22372b, null);
        if (Intrinsics.areEqual(r58.f22372b, r57) == true) goto L164;
    L170:
        a r61 = this;
    L171:
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.prefetchv2.p.class, r211);
        if (((com.bytedance.ies.bullet.prefetchv2.p) yc.a.a(com.bytedance.ies.bullet.prefetchv2.p.class, r311)) == null) goto L184;
        String r62 = r61.f6128a;
        Uri r123 = r45;
        Intrinsics.checkNotNullParameter(r123, "schemaUri");
        Intrinsics.checkNotNullParameter(r62, r310);
        Intrinsics.checkNotNullParameter(r28, "bulletContext");
        rd.b r63 = r28.e;
        if (r63 == null) goto L178;
        LinkedHashMap r64 = ((com.bytedance.ies.bullet.service.sdk.b) r63).f6143o;
        if (r64 == null) goto L178;
        String r65 = (String) r64.get("enable_prefetch");
    L180:
        if (Intrinsics.areEqual(r65, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L183;
        ExecutorService r66 = o.f5870a;
        o.b(r45, r62, r28.e, r28.f5303q, r28.getSessionId(), 2);
    L183:
        r28.A = r123;
    L185:
        ug.d r67 = new ug.d(10);
        String r68 = r28.getSessionId();
        Result.Companion r69 = Result.Companion;     // Catch: Throwable -> L193
        String r70 = r123.getQueryParameter("flags");     // Catch: Throwable -> L193
        if (Intrinsics.areEqual(r70, "clear_top") == false) goto L189;
        r16 = 67108864;
    L195:
        e r71 = td.b.b().a(r68);     // Catch: Throwable -> L193
        if (r71 == null) goto L198;
        vd.a r72 = new vd.a(r71.g.f21723a, LaunchMode.f6147b);     // Catch: Throwable -> L193
    L199:
        LaunchMode r73 = LaunchMode.e;     // Catch: Throwable -> L193
        if (r72 == null) goto L202;
        LaunchMode r74 = (LaunchMode) r72.f22372b;     // Catch: Throwable -> L193
    L203:
        if (r73 != r74) goto L205;
        r16 = r16 | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;     // Catch: Throwable -> L193
    L205:
        Object r75 = Result.m124constructorimpl(Integer.valueOf(r16));     // Catch: Throwable -> L193
    L209:
        if (Result.m130isFailureimpl(r75) == false) goto L211;
        r75 = null;
    L211:
        r67.f22357b = (Integer) r75;
        String r76 = r28.getSessionId();
        Intrinsics.checkNotNullParameter(r76, "<set-?>");
        r67.f22358c = r76;
        Bundle r77 = r46.f5997a;
        r77.putString("__x_session_id", r28.getSessionId());
        Intrinsics.checkNotNullParameter(r77, "<set-?>");
        r67.e = r77;
        t9.a r78 = r46.d;
        Intrinsics.checkNotNullParameter(r78, "<set-?>");
        r67.g = r78;
        Intrinsics.checkNotNullParameter(r210, "<set-?>");
        r67.d = r210;
        Object r79 = r46.f5997a.get("bdx_act_request_code");
        if ((r79 instanceof Integer) == false) goto L214;
        Integer r80 = (Integer) r79;
    L215:
        r67.f = r80;
        Unit r81 = Unit.INSTANCE;
        boolean r82 = r120.b(r44, r212, r67);
        int r83 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r84 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r52, Boolean.valueOf(r82)), TuplesKt.to("scheme", r45.toString())});
        Intrinsics.checkNotNullParameter("XRouter", r35);
        Intrinsics.checkNotNullParameter("BulletUIService show result", r36);
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "BulletUIService show result", r84, r55);
        r46.f5999c.getClass();
        Intrinsics.checkNotNullParameter(r123, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r212, "convertedUri");
        return r82;
    L214:
        r80 = null;
        goto L215
    L202:
        r74 = null;
        goto L203
    L198:
        r72 = null;
        goto L199
    L189:
        if (r70 == null) goto L195;
        Integer r85 = StringsKt.toIntOrNull(r70);     // Catch: Throwable -> L193
        if (r85 == null) goto L195;
        r16 = r85.intValue();     // Catch: Throwable -> L193
    L193:
        th = move-exception;
        Result.Companion r86 = Result.Companion;
        r75 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L178:
        r65 = null;
        goto L180
    L184:
        r123 = r45;
        r36 = r36;
        r55 = r55;
        r28 = r28;
        r212 = r212;
        goto L185
    L164:
        if (Intrinsics.areEqual(r59.f22372b, Boolean.TRUE) == true) goto L170;
        r61 = this;
        if (tc.c.f22119c.a(l.class, r61.f6128a) == null) goto L171;
        throw new ClassCastException();
    L69:
        r213 = r31;
        String r87 = (String) new vd.a(r28.g.f21723a, "bdx_tag", null).f22372b;
        Map r88 = MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", r50.i()), TuplesKt.to("tag", r87)});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("clearTopActivity show tag", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "clearTopActivity show tag", r88, r48);
        com.bytedance.ies.bullet.service.base.router.config.b r89 = (com.bytedance.ies.bullet.service.base.router.config.b) com.bytedance.ies.bullet.service.base.router.config.b.f6000c.getValue();
        r89.getClass();
        boolean r90 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "getActivityList:" + r89.f6001a, "XPage");
        Iterator r91 = CollectionsKt.reversed(r89.f6001a).iterator();
        String r124 = "";
        n r92 = null;
    L70:
        String r312 = r124;
        if (r91.hasNext() == false) goto L76;
        n r125 = (n) r91.next();
        r91 = r91;
        if (Intrinsics.areEqual(r125.e(), r87) == true) goto L74;
        r124 = r312;
        goto L70
    L74:
        int r93 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r94 = MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", r50.i()), TuplesKt.to("tag", r87), TuplesKt.to("targetUrl", String.valueOf(r125.getSchema())), TuplesKt.to(r121, r125.getBid()), TuplesKt.to("containerId", r125.getContainerId())});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("clearTopActivity match target tag", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "clearTopActivity match target tag", r94, r48);
        r124 = String.valueOf(r125.getSchema());
        r92 = r125;
        r115 = r115;
        r121 = r121;
        r122 = r122;
        goto L70
    L76:
        String r313 = r122;
        r310 = r121;
        r311 = r115;
        if (r92 != null) goto L80;
    L85:
        Object r95 = null;
    L86:
        int r126 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r127 = MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", r50.i()), TuplesKt.to("tag", r87), TuplesKt.to("targetActivity", String.valueOf(r95))});
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("clearTopActivity getTarget Activity", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "clearTopActivity getTarget Activity", r127, r48);
        if (r95 != null) goto L89;
        r52 = "result";
        goto L68
    L89:
        LinkedList r128 = new LinkedList();
        LinkedList r129 = s.f5354c;
        Activity[] r130 = (Activity[]) r129.toArray(new Activity[r129.size()]);
        if (r130 != null) goto L92;
    L93:
        com.bytedance.ies.bullet.base.utils.logger.b r314 = r48;
    L104:
        Iterator r96 = r128.iterator();
        int r131 = 0;
    L106:
        if (r96.hasNext() == false) goto L109;
        r131 = r131 + 1;
        ((Activity) r96.next()).finish();
        goto L106
    L109:
        if (Intrinsics.areEqual((Boolean) new vd.a(r28.g.f21723a, "disable_clear_popup", null).f22372b, Boolean.TRUE) == false) goto L111;
    L124:
        Boolean r97 = (Boolean) new vd.a(r28.g.f21723a, "send_clear_top_event", Boolean.FALSE).f22372b;
        Boolean r98 = Boolean.TRUE;
        if (Intrinsics.areEqual(r97, r98) == false) goto L156;
        if (r92 == null) goto L156;
        String r99 = r92.getContainerId();
        if (r99 == null) goto L156;
        Lazy r100 = f.f5312b;
        f r101 = td.b.b();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r99, r313);
        e r102 = (e) r101.f5313a.get(r99);
        if (r102 == null) goto L156;
        h r103 = r102.f5298l;
        if (r103 == null) goto L156;
        JSONObject r132 = new JSONObject();
        ConcurrentHashMap r133 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, r211);
        r211 = r211;
        xc.e r134 = (xc.e) yc.a.a(xc.e.class, r311);
        if (r134 == null) goto L140;
        xc.d r104 = (xc.d) r134.a(xc.d.class);
        if (r104 == null) goto L140;
        Boolean r105 = r104.I();
        if (r105 == null) goto L140;
        boolean r106 = r105.booleanValue();
    L142:
        if (r106 == false) goto L149;
        ad.a r107 = r28.f5303q;
        if (r107 == null) goto L147;
        String r108 = r107.f157a.toString();
        if (r108 == null) goto L147;
    L148:
        r132.put("new_url", r108);
    L155:
        Unit r109 = Unit.INSTANCE;
        r103.a("clearTopEvent", r132);
    L157:
        int r135 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        r52 = "result";
        Map r136 = MapsKt.mapOf(new Pair[]{TuplesKt.to("launchMode", r50.i()), TuplesKt.to("tag", r87), TuplesKt.to("targetActivity", r95.toString()), TuplesKt.to("targetUrl", r312), TuplesKt.to(r52, r98), TuplesKt.to("closeActivityCount", Integer.valueOf(r131))});
        r35 = "moduleTag";
        Intrinsics.checkNotNullParameter("XRouter", r35);
        r36 = "msg";
        Intrinsics.checkNotNullParameter("clearTopActivity result", r36);
        r53 = true;
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "clearTopActivity result", r136, r314);
        r16 = 1;
    L147:
        r108 = "";
        goto L148
    L149:
        ad.a r137 = r102.f5303q;
        if (r137 == null) goto L153;
        String r138 = r137.f157a.toString();
        if (r138 == null) goto L153;
    L154:
        r132.put("new_url", r138);
    L153:
        r138 = "";
    L140:
        r106 = true;
    L156:
        r211 = r211;
        goto L157
    L111:
        if ((r95 instanceof FragmentActivity) == false) goto L113;
        FragmentActivity r139 = (FragmentActivity) r95;
    L114:
        if (r139 == null) goto L124;
        FragmentManager r140 = r139.getSupportFragmentManager();
        if (r140 == null) goto L124;
        FragmentTransaction r141 = r140.beginTransaction();
        Iterator<Fragment> r142 = r140.getFragments().iterator();
    L119:
        if (r142.hasNext() == false) goto L123;
        Fragment r143 = r142.next();
        if (r143.isAdded() == false) goto L119;
        r141.remove(r143);
        goto L119
    L123:
        r141.commitAllowingStateLoss();
        goto L124
    L113:
        r139 = null;
        goto L114
    L92:
        if (r130.length == 0) goto L93;
        r314 = r48;
        Activity[] r144 = (Activity[]) r129.toArray(new Activity[r129.size()]);
        if (r144 == null) goto L97;
        List r145 = ArraysKt.reversed(r144);
    L98:
        LinkedList r146 = new LinkedList(r145);
        Activity r147 = (Activity) r146.pop();
    L99:
        if (r147 == null) goto L104;
        if (Intrinsics.areEqual(r147, r95) == true) goto L104;
        r128.add(r147);
        r147 = (Activity) r146.pop();
        goto L99
    L97:
        r145 = null;
        goto L98
    L80:
        if ((r92 instanceof Activity) == false) goto L83;
        r95 = (Activity) r92;
        goto L86
    L83:
        if ((r92 instanceof Fragment) == false) goto L85;
        r95 = ((Fragment) r92).getActivity();
    L53:
        r119 = true;
        goto L54
    L45:
        r112 = false;
        goto L46
    L40:
        if (Intrinsics.areEqual(r15, "_page") == false) goto L42;
        tc.c r148 = tc.c.f22119c;
        r41 = (rc.d) tc.c.f22119c.a(ld.b.class, this.f6128a);
        goto L43
    L42:
        tc.c r149 = tc.c.f22119c;
        r41 = (rc.d) tc.c.f22119c.a(ld.b.class, this.f6128a);
        goto L43
    L29:
        r38 = "page";
        goto L30
    L25:
        r111 = r30;
        goto L26
    L8:
        String r150 = m.f(r45, "page_type_opt");
        r5.f3502a = r150;
        Boolean r151 = Boolean.FALSE;
        if (com.bytedance.android.anniex.utils.e.f(r5, r45) == false) goto L11;
    L14:
        boolean r152 = true;
    L15:
        r13 = new Triple(r151, r150, Boolean.valueOf(r152));
        goto L16
    L11:
        if (com.bytedance.android.anniex.utils.e.k(r5, r45) == true) goto L14;
        r152 = false;
        goto L15
    }
}
