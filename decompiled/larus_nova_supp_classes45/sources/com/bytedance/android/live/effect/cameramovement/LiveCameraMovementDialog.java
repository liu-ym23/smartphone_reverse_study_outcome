package com.bytedance.android.live.effect.cameramovement;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import com.bytedance.android.live.effect.common.LiveCommonStickerAdjustBarView;
import com.bytedance.android.live.effect.common.LiveCommonStickerDataViewModel;
import com.bytedance.android.live.effect.common.LiveCommonStickerListView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.live.datacontext.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/cameramovement/LiveCameraMovementDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCameraMovementDialog extends LiveDialogFragment {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Intrinsics.throwUninitializedPropertyAccessException("stickerUIViewModel");
        throw null;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L7;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L7;
        r4.setLayout(-1, -1);
    L7:
        Dialog r5 = getDialog();
        if (r5 == null) goto L12;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L12;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r6.addFlags(Integer.MIN_VALUE);
    L12:
        Dialog r7 = getDialog();
        if (r7 == null) goto L17;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L17;
        r8.setStatusBarColor(0);
    L17:
        Dialog r9 = getDialog();
        if (r9 == null) goto L23;
        Window r11 = r9.getWindow();
        if (r11 == null) goto L24;
        r11.setNavigationBarColor(-16777216);
        return;
    L24:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954665);
        setCancelable(true);
        LiveCommonStickerDataViewModel r3 = (LiveCommonStickerDataViewModel) d.b(this, new LiveCameraMovementDialog$initViewModel$1(this)).a(LiveCommonStickerDataViewModel.class);
        throw null;
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        r5.setCanceledOnTouchOutside(true);
        r5.requestWindowFeature(1);
        Window r0 = r5.getWindow();
        if (r0 == null) goto L5;
        r0.setGravity(80);
        r0.setLayout(-1, -1);
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.setSoftInputMode(3);
    L5:
        return r5;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        Context r5 = getContext();
        if (r5 == null) goto L14;
        View r6 = getView();
        if (r6 == null) goto L9;
        FrameLayout r7 = (FrameLayout) r6.findViewById(2131362281);
        if (r7 == null) goto L9;
        r7.addView(new LiveCommonStickerAdjustBarView(r5, new WeakReference(this)));
    L9:
        View r8 = getView();
        if (r8 == null) goto L14;
        FrameLayout r9 = (FrameLayout) r8.findViewById(2131367833);
        if (r9 == null) goto L14;
        r9.addView(new LiveCommonStickerListView(r5, new WeakReference(this)));
    L14:
        View r11 = getView();
        if (r11 == null) goto L19;
        Button r12 = (Button) r11.findViewById(2131364595);
        if (r12 == null) goto L19;
        r12.setOnClickListener(new b(this));
    L19:
        Intrinsics.throwUninitializedPropertyAccessException("stickerUIViewModel");
        throw null;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565852, r3, false);
    }
}
