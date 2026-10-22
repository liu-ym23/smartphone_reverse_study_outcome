package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.m;
import com.bytedance.android.btm.api.model.o;
import com.bytedance.android.btm.impl.ShowIdUpdateReason;
import com.bytedance.android.btm.impl.c;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FilterDispatcher;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.setting.n;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmManualLifecycleCallbackV2 implements BtmPageLifecycle {
    public static final BtmManualLifecycleCallbackV2 a = null;

    public BtmManualLifecycleCallbackV2() {
    }

    static {
        a = new BtmManualLifecycleCallbackV2();
    }

    @Override // com.bytedance.android.btm.api.BtmPageLifecycle
    public final void a(Object r10) {
        if (BtmSetting.d.c().e() == 1) goto L6;
        return;
    L6:
        if (r10 != null) goto L9;
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_onPageDestroy", BtmManualLifecycleCallbackV2$onPageDestroy$1.INSTANCE);
        return;
    L9:
        final String r1 = r10.getClass().getName();
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_onPageDestroy", new BtmManualLifecycleCallbackV2$onPageDestroy$2(r1));
        FilterDispatcher.c(r10);
    }

    @Override // com.bytedance.android.btm.api.BtmPageLifecycle
    public final BtmPageLifecycle.State f(Object r10) {
        if (BtmSetting.d.c().e() == 1) goto L6;
        return null;
    L6:
        if (r10 != null) goto L9;
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_getNativeState", BtmManualLifecycleCallbackV2$getNativeState$1.INSTANCE);
        return null;
    L9:
        final String r1 = r10.getClass().getName();
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_getNativeState", new BtmManualLifecycleCallbackV2$getNativeState$2(r1));
        String r0 = BtmPageRecorder.a;
        PageInfoStack r11 = BtmPageRecorder.k(r10);
        if (r11 != null) goto L12;
        return null;
    L12:
        return r11.getNativeState();
    }

    @Override // com.bytedance.android.btm.api.BtmPageLifecycle
    public final void b(Object r10, final boolean r11) {
        BtmSetting r0 = BtmSetting.d;
        if (r0.c().e() == 1) goto L6;
        return;
    L6:
        if (r0.c().b().u() == 1) goto L8;
    L15:
        final String r1 = r10.getClass().getName();
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_setUserVisibleHint", new BtmManualLifecycleCallbackV2$setUserVisibleHint$1(r1, r11));
        String r12 = BtmPageRecorder.a;
        PageInfoStack r13 = BtmPageRecorder.k(r10);
        if (r13 == null) goto L20;
        r13.setUserVisibleHint(Boolean.valueOf(r11));
        return;
    L20:
        return;
    L8:
        if ((r10 instanceof dd.b) == false) goto L15;
        if (Intrinsics.areEqual(((dd.b) r10).a(), Boolean.TRUE) == false) goto L15;
        String r14 = BtmPageRecorder.a;
        PageInfoStack r15 = BtmPageRecorder.k(r10);
        if (r15 == null) goto L19;
        r15.setUserVisibleHint(null);
        return;
    }

    @Override // com.bytedance.android.btm.api.BtmPageLifecycle
    public final void c(Object r10, BtmPageLifecycle.State r11) {
        if (BtmSetting.d.c().e() == 1) goto L6;
        return;
    L6:
        if (r10 != null) goto L9;
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_setNativeState", BtmManualLifecycleCallbackV2$setNativeState$1.INSTANCE);
        return;
    L9:
        final String r1 = r10.getClass().getName();
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_setNativeState", new BtmManualLifecycleCallbackV2$setNativeState$2(r1));
        String r0 = BtmPageRecorder.a;
        PageInfoStack r12 = BtmPageRecorder.k(r10);
        if (r12 == null) goto L13;
        r12.setNativeState(r11);
        return;
    }

    @Override // com.bytedance.android.btm.api.BtmPageLifecycle
    public final boolean d(Object r10, final boolean r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        final boolean r12 = false;
        ALogger.m(r1, "BtmManualLifecycleCallbackV2_setUserVisibleHintCore", new BtmManualLifecycleCallbackV2$setUserVisibleHintCore$1(r0, r11, r12));
        if (BtmSetting.d.c().b().Q() != 1) goto L6;
        if (r11 == false) goto L6;
        h(r10, null, null, true);
    L16:
        return false;
    L6:
        if (r11 == false) goto L16;
        if (BtmSDK.INSTANCE.getPageLifecycle().f(r10) != BtmPageLifecycle.State.RESUMED) goto L16;
        if ((r10 instanceof dd.b) == true) goto L12;
    L15:
        h(r10, null, null, true);
        goto L16
    L12:
        if (Intrinsics.areEqual(((dd.b) r10).a(), Boolean.TRUE) == false) goto L15;
        ALogger.m(r1, "BtmManualLifecycleCallbackV2_setUserVisibleHintCore", new BtmManualLifecycleCallbackV2$setUserVisibleHintCore$2(r0));
        return true;
    }

    @Override // com.bytedance.android.btm.api.BtmPageLifecycle
    public final void e(Object r10, final Boolean r11, m r12) {
        if (BtmSetting.d.c().e() == 1) goto L6;
        return;
    L6:
        if (r10 != null) goto L9;
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_onPageHide", BtmManualLifecycleCallbackV2$onPageHide$1.INSTANCE);
        return;
    L9:
        final String r1 = r10.getClass().getName();
        if (r12 == null) goto L12;
        final boolean r13 = r12.a;
    L13:
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_onPageHide", new BtmManualLifecycleCallbackV2$onPageHide$2(r1, r11, r13));
        String r0 = BtmPageRecorder.a;
        PageInfoStack r14 = BtmPageRecorder.k(r10);
        if (r14 == null) goto L24;
        r14.current().setReuse(r13);
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L19;
        PauseFuncOrigin r15 = PauseFuncOrigin.ManualForward;
    L22:
        FilterDispatcher.d(r10, r15);
        return;
    L19:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L21;
        r15 = PauseFuncOrigin.ManualBack;
        goto L22
    L21:
        r15 = PauseFuncOrigin.ManualNotSure;
        goto L22
    L24:
        return;
    L12:
        r13 = false;
        goto L13
    }

    @Override // com.bytedance.android.btm.api.BtmPageLifecycle
    public final void g(Object r10, Boolean r11, o r12) {
        h(r10, r11, r12, false);
    }

    public static void h(Object r10, final Boolean r11, o r12, final boolean r13) {
        BtmSetting r0 = BtmSetting.d;
        if (r0.c().e() == 1) goto L6;
        return;
    L6:
        if (r10 != null) goto L9;
        ALogger.e(ALogger.d, "BtmManualLifecycleCallbackV2_onPageShow", BtmManualLifecycleCallbackV2$onPageShowCore$1.INSTANCE);
        return;
    L9:
        final String r14 = r10.getClass().getName();
        if (r12 == null) goto L12;
        final boolean r15 = r12.a;
    L13:
        ALogger r16 = ALogger.d;
        ALogger.e(r16, "BtmManualLifecycleCallbackV2_onPageShow", new BtmManualLifecycleCallbackV2$onPageShowCore$2(r14, r11, r15, r13));
        String r17 = BtmPageRecorder.a;
        PageInfoStack r18 = BtmPageRecorder.k(r10);
        if (r18 != null) goto L16;
        return;
    L16:
        if (c.a == false) goto L19;
        r18.current().updateShowIdIfNeed(ShowIdUpdateReason.ManualPageShow);
    L19:
        r18.current().setReuse(r15);
        if (r13 == false) goto L23;
        ResumeFuncOrigin r19 = ResumeFuncOrigin.UserVisibleHint;
    L29:
        Object r110 = com.bytedance.android.btm.impl.page.b.b;
        if (r110 == null) goto L38;
        PageInfo r111 = BtmPageRecorder.j(r110);
        if (r111 == null) goto L38;
        Map r20 = r0.c().b().W();
        Lazy r21 = BtmFormatUtils.a;
        n r112 = (n) r20.get(BtmFormatUtils.b(r111.getPageBtm()));
        if (r112 == null) goto L38;
        if (r112.a().contains(BtmFormatUtils.b(r18.current().getPageBtm())) == false) goto L38;
        ALogger.e(r16, "BtmManualLifecycleCallbackV2_onPageShow", BtmManualLifecycleCallbackV2$onPageShowCore$3$1$1$1.INSTANCE);
        r19 = ResumeFuncOrigin.ManualBack;
    L38:
        ResumeFilterReason r22 = FilterDispatcher.e(r10, r19);
        if (r0.c().b().P() != 1) goto L43;
        if (r22 != ResumeFilterReason.PageStateDuplicate) goto L43;
    L45:
        if (r15 == false) goto L51;
        r18.current().setReuse(false);
        ALogger.e(r16, "BtmManualLifecycleCallbackV2_onPageShow", BtmManualLifecycleCallbackV2$onPageShowCore$4.INSTANCE);
        return;
    L51:
        return;
    L43:
        if (r0.c().b().P() != 2) goto L49;
        if (r22 != null) goto L45;
        return;
    L49:
        return;
    L23:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L26;
        r19 = ResumeFuncOrigin.ManualForward;
        goto L29
    L26:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L28;
        r19 = ResumeFuncOrigin.ManualBack;
        goto L29
    L28:
        r19 = ResumeFuncOrigin.ManualNotSure;
        goto L29
    L12:
        r15 = false;
        goto L13
    }
}
