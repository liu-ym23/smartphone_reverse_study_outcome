package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.ic;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements c0.b {
    public boolean a;
    public View b;
    public LottieAnimationView c;
    public int d;
    public final b e;
    public final LifecycleOwner f;

    public static final class a {
    }

    public interface b {
        void Vp();
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a(int r4) {
        if (this.a == true) goto L5;
        return;
    L5:
        this.d = r4;
        LottieAnimationView r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r4 != 1) goto L10;
        ImageUtil.loadGifImage(r0, "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/anchor_waiting.webp");
        return;
    L10:
        if (r4 == 2) goto L14;
        r0.clearAnimation();
        LottieAnimationView r5 = this.c;
        if (r5 == null) goto L18;
        r5.setVisibility(0);
        r5.setImageResource(2131252956);
        return;
    L18:
        return;
    L14:
        ImageUtil.loadGifImage(r0, "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/anchor_online.webp");
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        b r3 = this.e;
        if (r3 == null) goto L6;
        r3.Vp();
        return;
    }

    public final void setAlpha(float r2) {
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    public g(b r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "mLifecycleOwner");
        this.e = r2;
        this.f = r3;
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r3;
        if (r3 == null) goto L9;
        r3.getContext();
        this.c = r3.findViewById(2131376468);
        if (((Boolean) ic.a.getValue()).booleanValue() == false) goto L9;
        TextView r5 = (TextView) r3.findViewById(2131389066);
        if (r5 == null) goto L9;
        r5.setText(s1.B(2131914883));
    L9:
        LottieAnimationView r6 = this.c;
        boolean r0 = false;
        if (r6 == null) goto L12;
        r6.setVisibility(0);
        r6.setImageResource(2131250846);
    L12:
        Boolean r7 = (Boolean) r4.get("data_is_anchor");
        if (r7 == null) goto L15;
        r0 = r7.booleanValue();
    L15:
        this.a = r0;
    }
}
