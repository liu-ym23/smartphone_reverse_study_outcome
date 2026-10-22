package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.floating.b;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.c;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import gwb.e;
import hwb.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmRecordingFloatWindowCoordinator$showOnUserLeave$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ e $callback;
    final /* synthetic */ f $request;

    public MmRecordingFloatWindowCoordinator$showOnUserLeave$1(Activity r1, f r2, e r3) {
        this.$activity = r1;
        this.$request = r2;
        this.$callback = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m528invoke() {
        d r0 = a.a;
        FragmentActivity r1 = this.$activity;
        final f r3 = this.$request;
        final e r4 = this.$callback;
        Function0<Unit> r2 = new AnonymousClass1(r3, r4);
        final Activity r5 = this.$activity;
        final f r6 = this.$request;
        final e r7 = this.$callback;
        Function0<Unit> r8 = new AnonymousClass2(r5, r6, r7);
        final Activity r9 = this.$activity;
        final f r10 = this.$request;
        final e r11 = this.$callback;
        Function0<Unit> r12 = new AnonymousClass3(r9, r10, r11);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "onGranted");
        Intrinsics.checkNotNullParameter(r8, "onDenied");
        Intrinsics.checkNotNullParameter(r12, "onUnavailable");
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        b.b(r1, new c(r2, r8));
        return;
    L5:
        int r13 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FLOAT, "permissionResult", "context is not FragmentActivity", null);
        r12.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m528invoke();
        return Unit.INSTANCE;
    }
}
