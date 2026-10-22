package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.content.MmRecordingContentController;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class MmRecordingFragment$initViews$5 extends FunctionReferenceImpl implements Function0<Unit> {
    public MmRecordingFragment$initViews$5(Object r8) {
        super(0, r8, MmRecordingFragment.class, "bindDefaultMiddleIfNeeded", "bindDefaultMiddleIfNeeded()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m460invoke() {
        MmRecordingFragment r0 = (MmRecordingFragment) ((CallableReference) this).receiver;
        if (r0.r == true) goto L12;
        MmRecordingContentController r1 = new MmRecordingContentController(r0.ia0());
        r0.p = r1;
        MmRecordingViewModel r3 = r0.ja0();
        if (((Boolean) r0.z.getValue()).booleanValue() == false) goto L7;
    L10:
        boolean r4 = true;
    L11:
        r1.b(r3, r0, r0, r4);
        r0.r = true;
    L16:
        if (r0.s == true) goto L23;
        MmRecordingUILaunchMode r2 = r0.A;
        if (r2.shouldHandleUI() == true) goto L20;
        int r5 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "bindRecordingNotification", "skip bindRecordingNotification", r0.U90());
    L21:
        r0.s = true;
        return;
    L20:
        int r6 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "bindRecordingNotification", "", r0.U90());
        r0.ja0().bindRecordingNotification(new ewb.c(r0.requireContext(), r0.ia0().a, r0.ia0().c().f), r2);
        goto L21
    L23:
        return;
    L7:
        if (r0.v.e.a == true) goto L10;
        r4 = false;
        goto L11
    L12:
        MmRecordingContentController r7 = r0.p;
        if (r7 == null) goto L16;
        Intrinsics.checkNotNullParameter(r0, "fragment");
        int r8 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "onDefaultMiddleAttached", "delayedSetupComplete=" + r7.n, r7.c());
        r7.d(r0, "default_middle_attached");
        r7.a.b().post(new com.ss.android.lark.officesdk.minutes.ui.record.recording.content.c(r7));
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m460invoke();
        return Unit.INSTANCE;
    }
}
