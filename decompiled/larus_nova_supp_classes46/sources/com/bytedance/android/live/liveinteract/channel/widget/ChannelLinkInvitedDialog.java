package com.bytedance.android.live.liveinteract.channel.widget;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/channel/widget/ChannelLinkInvitedDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChannelLinkInvitedDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int D = 0;
    public Animation B;
    public Animation C;

    public static final class a {
    }

    static {
    }

    public final boolean V0() {
        return true;
    }

    public final int getLayoutId() {
        return 2131567387;
    }

    public final void dismiss() {
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        Intrinsics.throwUninitializedPropertyAccessException("inviterUser");
        throw null;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.B = AnimationUtils.loadAnimation(getContext(), 2130772759);
        this.C = AnimationUtils.loadAnimation(getContext(), 2130772760);
        AnimationUtils.loadAnimation(getContext(), 2130772761);
        Animation r4 = this.C;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mUserAnimation");
    L5:
        r4.setRepeatCount(-1);
        Animation r5 = this.B;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("animation");
    L8:
        r5.setInterpolator(new LinearInterpolator());
        Animation r6 = this.C;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mUserAnimation");
    L11:
        r6.setInterpolator(new LinearInterpolator());
        ImageView r7 = (ImageView) findViewById(2131375626);
        Intrinsics.throwUninitializedPropertyAccessException("inviterUser");
        throw null;
    }
}
