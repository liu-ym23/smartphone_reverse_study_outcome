package com.bytedance.android.live.effect.avadjust;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.LiveDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveAVAdjustFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAVAdjustFragment extends LiveDialogFragment {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
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

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        throw null;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565838, r3, false);
    }
}
