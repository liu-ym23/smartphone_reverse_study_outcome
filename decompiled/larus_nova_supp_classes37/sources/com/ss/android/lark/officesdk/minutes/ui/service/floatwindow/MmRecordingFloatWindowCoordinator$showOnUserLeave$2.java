package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow;

import android.app.Activity;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import gwb.e;
import hwb.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmRecordingFloatWindowCoordinator$showOnUserLeave$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ e $callback;
    final /* synthetic */ f $request;

    public MmRecordingFloatWindowCoordinator$showOnUserLeave$2(Activity r1, f r2, e r3) {
        this.$activity = r1;
        this.$request = r2;
        this.$callback = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m532invoke() {
        d r0 = a.a;
        a.d(this.$activity, this.$request, this.$callback);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m532invoke();
        return Unit.INSTANCE;
    }
}
