package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXLifecycleConfigService;
import com.bytedance.android.anniex.container.holder.AnnieXSLFragmentHolder;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final a c = null;
    public static boolean d;
    public ja.b a;
    public FragmentActivity b;

    public static final class a {
        public a() {
        }

        public static boolean a(Context r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "bid");
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
            if (e.d == false) goto L5;
        L54:
            return true;
        L5:
            if (r10 != null) goto L8;
            HybridLogger.m(r12, "BulletSdk.ensureDefaultBidReady failed, message = context is null", null, null, 12);
            return false;
        L8:
            com.bytedance.android.anniex.assemble.a.a.c(r10);
            e.d = true;
            if (com.bytedance.ies.bullet.base.settings.c.a().c() != 1) goto L12;
            boolean r13 = com.bytedance.ies.bullet.service.base.h.O();
        L17:
            if (r13 == false) goto L59;
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L23
            IAnnieXContextProvider r15 = (IAnnieXContextProvider) com.bytedance.android.anniex.assemble.a.g(r11, IAnnieXContextProvider.class);     // Catch: Throwable -> L23
            if (r15 != null) goto L21;
            s26.d r16 = s26.d.c;     // Catch: Throwable -> L23
            r15 = (IAnnieXContextProvider) s26.d.c.d(r11, IAnnieXContextProvider.class);     // Catch: Throwable -> L23
        L21:
            Object r17 = Result.constructor-impl(r15);     // Catch: Throwable -> L23
        L25:
            Throwable r18 = Result.exceptionOrNull-impl(r17);
            if (r18 == null) goto L29;
            HybridLogger r19 = HybridLogger.a;
            HybridLogger.i(r12, "get IAnnieXContextProvider failed, bid = " + r11 + ", message = " + r18.getMessage(), null, 12);
        L29:
            if (Result.isFailure-impl(r17) == false) goto L31;
            r17 = null;
        L31:
            IAnnieXContextProvider r20 = (IAnnieXContextProvider) r17;
            if (r20 != null) goto L57;
            HybridLogger r21 = HybridLogger.a;
            HybridLogger.m(r12, "initAnnieXCardBizEnv skipped, provider not found, bid = " + r11, null, null, 12);
            goto L59
        L57:
            Object r22 = Result.constructor-impl(Boolean.valueOf(r20.m0()));     // Catch: Throwable -> L35
        L37:
            Throwable r23 = Result.exceptionOrNull-impl(r22);
            if (r23 == null) goto L40;
            HybridLogger r24 = HybridLogger.a;
            HybridLogger.i(r12, "initAnnieXCardBizEnv error, bid = " + r11 + ", message = " + r23.getMessage(), null, 12);
        L40:
            Boolean r25 = Boolean.FALSE;
            if (Result.isFailure-impl(r22) == false) goto L44;
            r22 = r25;
        L44:
            if (((Boolean) r22).booleanValue() == true) goto L47;
            HybridLogger r26 = HybridLogger.a;
            HybridLogger.i(r12, "initAnnieXCardBizEnv failed, bid = " + r11, null, 12);
            return false;
        L47:
            HybridLogger r27 = HybridLogger.a;
            HybridLogger.m(r12, "initAnnieXCardBizEnv success, bid = " + r11, null, null, 12);
        L35:
            th = move-exception;
            Result.Companion r28 = Result.Companion;
            r22 = Result.constructor-impl(ResultKt.createFailure(th));
        L23:
            th = move-exception;
            Result.Companion r29 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
        L59:
            boolean r110 = BulletSdk.a;     // Catch: Throwable -> L51
            BulletSdk.c(r10);     // Catch: Throwable -> L51
            HybridLogger.m(r12, "BulletSdk.ensureDefaultBidReady success", null, null, 12);     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            HybridLogger r111 = HybridLogger.a;
            HybridLogger.m(r12, "BulletSdk.ensureDefaultBidReady failed, message = " + th.getMessage(), null, null, 12);
            return false;
        L12:
            if (com.bytedance.ies.bullet.service.base.h.O() == false) goto L16;
            Intrinsics.checkNotNullParameter(r11, "<this>");
            Intrinsics.checkNotNullParameter(r11, "<this>");
            if (Intrinsics.areEqual(r11.toLowerCase(Locale.ROOT), "webcast") == false) goto L16;
            r13 = true;
        L16:
            r13 = false;
            goto L17
        }
    }

    public e() {
    }

    static {
        c = new a();
    }

    public static void a(e r10) {
        ja.b r0 = r10.a;
        FragmentActivity r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r0 = null;
    L6:
        if (r0.canBackPress() == false) goto L12;
        FragmentActivity r11 = r10.b;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("annieXActivity");
    L11:
        r1.finish();
        return;
    L10:
        r1 = r11;
        goto L11
    L12:
        FragmentActivity r12 = r10.a;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
    L16:
        boolean r13 = r1 instanceof AnnieXSLFragmentHolder;
        return;
    L15:
        r1 = r12;
        goto L16
    }

    public final void b(final FragmentActivity r10, final Intent r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "intent");
        String r0 = r11.getStringExtra("bundle_annie_x_bid");
        if (r0 != null) goto L5;
        r0 = "default_bid";
    L5:
        final String r12 = r0;
        String r1 = r11.getStringExtra(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID);
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        c.getClass();
        ja.b r13 = null;
        if (a.a(r10, r12, "bullet_bid_AnnieXPageHelper") == false) goto L11;
    L14:
        com.bytedance.android.anniex.assemble.a r14 = com.bytedance.android.anniex.assemble.a.a;
        com.bytedance.android.anniex.base.service.e r15 = com.bytedance.android.anniex.assemble.a.g(r12, IAnnieXLifecycleConfigService.class);
        IAnnieXLifecycleConfigService r16 = (IAnnieXLifecycleConfigService) r15;
        if (com.bytedance.ies.bullet.service.base.h.u0() == true) goto L18;
        r15 = null;
    L18:
        IAnnieXLifecycleConfigService r17 = (IAnnieXLifecycleConfigService) r15;
        if (r17 == null) goto L21;
        r17.z();
    L21:
        final ka.b r18 = null;
        if (r17 == null) goto L24;
        r11.getData();
        r17.U();
    L24:
        com.bytedance.android.anniex.lite.a r19 = com.bytedance.android.anniex.lite.a.a;
        monitor-enter(r19);
        Intrinsics.checkNotNullParameter(r1, "sessionId");     // Catch: Throwable -> L45
        LruCache<String, com.bytedance.android.anniex.base.lifecycle.a> r20 = com.bytedance.android.anniex.lite.a.b;     // Catch: Throwable -> L45
        final com.bytedance.android.anniex.base.lifecycle.a r21 = r20.get(r1);     // Catch: Throwable -> L45
        if (r21 == null) goto L29;
        r20.remove(r1);     // Catch: Throwable -> L45
    L29:
        monitor-exit(r19);
        this.b = r10;
        this.a = com.bytedance.android.anniex.assemble.a.b(new AnnieXPageHelper$onCreate$1(r10, r18, r21, r12, r11));
        FragmentTransaction r22 = r10.getSupportFragmentManager().beginTransaction();
        ja.b r23 = this.a;
        if (r23 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
        r23 = null;
    L33:
        Fragment r24 = r23.getFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r22, r24, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131362998) == true) goto L37;
        r22 = r22.replace(2131362998, r24);
    L37:
        r22.commit();
        Uri r25 = r11.getData();
        if (r25 == null) goto L50;
        ja.b r110 = this.a;
        if (r110 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
    L43:
        r13.loadSchema(r25.toString());
        return;
    L42:
        r13 = r110;
        goto L43
    L50:
        return;
    L45:
        th = move-exception;
        throw th;
    L11:
        if (com.bytedance.ies.bullet.service.base.h.p() == false) goto L14;
        HybridLogger r111 = HybridLogger.a;
        HybridLogger.m("bullet_bid_AnnieXPageHelper", "tryInitAnnieXIfNeed failed, bid = ".concat(r12), null, null, 12);
        r10.finish();
    }
}
