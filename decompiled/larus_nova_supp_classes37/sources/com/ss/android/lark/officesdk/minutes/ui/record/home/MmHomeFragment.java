package com.ss.android.lark.officesdk.minutes.ui.record.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/home/MmHomeFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MmBaseFragment;", "<init>", "()V", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmHomeFragment extends MmBaseFragment {
    public static final /* synthetic */ int l = 0;
    public MmRecordingUILaunchMode k;

    public static final class a {
    }

    static {
    }

    public MmHomeFragment() {
        this.k = MmRecordingUILaunchMode.UNKNOWN;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        MmRecordingUILaunchMode r0 = null;
        if (r4 == null) goto L5;
        Serializable r5 = r4.getSerializable("key_ui_launch_mode");
    L7:
        if ((r5 instanceof MmRecordingUILaunchMode) == false) goto L9;
        r0 = (MmRecordingUILaunchMode) r5;
    L9:
        if (r0 != null) goto L11;
        r0 = MmRecordingUILaunchMode.UNKNOWN;
    L11:
        this.k = r0;
        return;
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        super.onCreateView(r2, r3, r4);
        e r5 = e.a;
        MmRecordingUILaunchMode r0 = this.k;
        r5.getClass();
        return e.b(r0).getLayout().z(LayoutInflater.from(c.c(r2.getContext(), this.k)), r3);
    }
}
