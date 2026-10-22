package com.bytedance.android.live.ktv.common.ordersong.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvPullLoadingAnimView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "visibility", "", "setVisibility", "", "text", "setText", "color", "setTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvPullLoadingAnimView extends ConstraintLayout {
    public Map<Integer, View> a;

    public static final class a {
    }

    static {
    }

    public KtvPullLoadingAnimView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvPullLoadingAnimView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        LiveDoubleColorBallAnimationView r0 = _$_findCachedViewById(2131370133);
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        TextView r1 = (TextView) _$_findCachedViewById(2131379090);
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        return;
    }

    public final void S5() {
        LiveDoubleColorBallAnimationView r0 = _$_findCachedViewById(2131370133);
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        TextView r1 = (TextView) _$_findCachedViewById(2131379090);
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = (TextView) _$_findCachedViewById(2131379090);
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setTextColor(int r2) {
        TextView r0 = (TextView) _$_findCachedViewById(2131379090);
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r3) {
        super/*android.view.ViewGroup*/.setVisibility(r3);
        LiveDoubleColorBallAnimationView r0 = _$_findCachedViewById(2131370133);
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        TextView r1 = (TextView) _$_findCachedViewById(2131379090);
        if (r1 == null) goto L9;
        r1.setVisibility(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvPullLoadingAnimView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        View.inflate(r2, 2131566669, this);
        LiveDoubleColorBallAnimationView r5 = _$_findCachedViewById(2131370133);
        if (r5 == null) goto L5;
        r5.setVisibility(0);
    L5:
        LottieAnimationView r6 = _$_findCachedViewById(2131374556);
        if (r6 == null) goto L9;
        r6.setVisibility(8);
        return;
    }

    public /* synthetic */ KtvPullLoadingAnimView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
