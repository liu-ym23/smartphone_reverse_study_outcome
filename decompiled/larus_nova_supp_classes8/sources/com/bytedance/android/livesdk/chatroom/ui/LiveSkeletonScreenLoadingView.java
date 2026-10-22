package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LiveSkeletonScreenLoadingView;", "Landroid/widget/FrameLayout;", "", "visibility", "", "setVisibility", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSkeletonScreenLoadingView extends FrameLayout {
    public LottieAnimationView a;
    public LottieTask<LottieComposition> b;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b == null) goto L5;
        this.b = null;
    L5:
        LottieAnimationView r0 = this.a;
        if (r0 == null) goto L9;
        r0.cancelAnimation();
        return;
    }

    public LiveSkeletonScreenLoadingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 != 0) goto L17;
        LottieAnimationView r3 = this.a;
        if (r3 == null) goto L7;
        LottieComposition r4 = r3.getComposition();
    L8:
        if (r4 != null) goto L10;
        this.b = LottieCompositionFactory.fromAsset(getContext(), "loading_data.json").addListener(new v7(this)).addFailureListener(w7.a);
        return;
    L10:
        LottieAnimationView r5 = this.a;
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.isAnimating() == true) goto L23;
        LottieAnimationView r6 = this.a;
        if (r6 == null) goto L24;
        r6.playAnimation();
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r4 = null;
        goto L8
    L17:
        LottieAnimationView r7 = this.a;
        if (r7 == null) goto L26;
        r7.cancelAnimation();
        return;
    }

    public LiveSkeletonScreenLoadingView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public LiveSkeletonScreenLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Intrinsics.checkNotNullParameter(r2, "context");
        LottieAnimationView r5 = LayoutInflater.from(r2).inflate(2131566782, this, true).findViewById(2131392547);
        this.a = r5;
        if (r5 == null) goto L6;
        r5.loop(true);
        return;
    }
}
