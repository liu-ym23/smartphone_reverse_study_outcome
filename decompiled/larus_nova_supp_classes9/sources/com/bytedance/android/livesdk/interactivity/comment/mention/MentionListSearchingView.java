package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/mention/MentionListSearchingView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "Landroid/animation/ObjectAnimator;", "b", "getLoadingAnimator", "()Landroid/animation/ObjectAnimator;", "loadingAnimator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MentionListSearchingView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public MentionListSearchingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MentionListSearchingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ObjectAnimator getLoadingAnimator() {
        return (ObjectAnimator) this.b.getValue();
    }

    private final View getView() {
        return (View) this.a.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLoadingAnimator().cancel();
    }

    public static final /* synthetic */ View a(MentionListSearchingView r0) {
        return r0.getView();
    }

    public final void b(boolean r3) {
        if (r3 == getLoadingAnimator().isRunning()) goto L8;
        if (r3 == false) goto L6;
        getLoadingAnimator().setDuration(1000);
        getLoadingAnimator().setRepeatCount(-1);
        getLoadingAnimator().setInterpolator(new LinearInterpolator());
        getLoadingAnimator().start();
        return;
    L6:
        getLoadingAnimator().cancel();
        return;
    }

    public MentionListSearchingView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new MentionListSearchingView$view$2(this, r2));
        this.b = LazyKt.lazy(new MentionListSearchingView$loadingAnimator$2(this));
    }

    public /* synthetic */ MentionListSearchingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
