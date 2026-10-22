package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"com/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingFragment$setupBackPressedHandler$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "dispatchBackToHost", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingFragment$setupBackPressedHandler$1 extends OnBackPressedCallback {
    public final /* synthetic */ MmRecordingFragment a;

    public final void a() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = bwb.b.a;
        MmUiLogScene r2 = MmUiLogScene.RECORDING;
        MmRecordingFragment r3 = this.a;
        int r4 = MmRecordingFragment.J;
        bwb.b.f(r2, "handleOnBackPressed", "not handled by recording page, dispatch to host", r3.U90());
        setEnabled(false);
        r0.getOnBackPressedDispatcher().onBackPressed();     // Catch: Throwable -> L9
        setEnabled(true);
        return;
    L9:
        th = move-exception;
        setEnabled(true);
        throw th;
    }

    public final void handleOnBackPressed() {
        MmRecordingFragment r0 = this.a;
        int r1 = MmRecordingFragment.J;
        if (r0.ga0().a(false, new MmRecordingFragment$setupBackPressedHandler$1$handleOnBackPressed$1(this)) == false) goto L5;
        return;
    L5:
        a();
    }

    public MmRecordingFragment$setupBackPressedHandler$1(MmRecordingFragment r1) {
        this.a = r1;
        super(true);
    }
}
