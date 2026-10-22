package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0014¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmLottieView;", "Lcom/airbnb/lottie/LottieAnimationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initView", "", "onVisibilityAggregated", "isVisible", "", "setVisibility", "visibility", "onWindowVisibilityChanged", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmLottieView extends LottieAnimationView {
    public MmLottieView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmLottieView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityAggregated(boolean r1) {
        super/*android.widget.ImageView*/.onVisibilityAggregated(r1);
        if (r1 == false) goto L5;
        playAnimation();
        return;
    L5:
        pauseAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowVisibilityChanged(int r3) {
        super/*android.widget.ImageView*/.onWindowVisibilityChanged(r3);
        if (Build.VERSION.SDK_INT >= 24) goto L10;
        if (r3 == 0) goto L6;
    L8:
        pauseAnimation();
        return;
    L6:
        if (getVisibility() != 0) goto L8;
        playAnimation();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r3) {
        super/*android.widget.ImageView*/.setVisibility(r3);
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        if (r3 != 0) goto L6;
        playAnimation();
        return;
    L6:
        pauseAnimation();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmLottieView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setClickable(false);
        setEnabled(false);
        setRepeatCount(-1);
    }

    public /* synthetic */ MmLottieView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
