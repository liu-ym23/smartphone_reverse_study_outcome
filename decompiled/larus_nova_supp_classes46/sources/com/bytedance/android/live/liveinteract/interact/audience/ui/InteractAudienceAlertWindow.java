package com.bytedance.android.live.liveinteract.interact.audience.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.e;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b$\u0010(B#\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b$\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/ui/InteractAudienceAlertWindow;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setAcceptClickListener", "setCloseListener", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "b", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "", "c", "Z", "getHasAnim", "()Z", "setHasAnim", "(Z)V", "hasAnim", "d", "isLoading", "setLoading", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "compositeDisposable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceAlertWindow extends FrameLayout {
    public Map<Integer, View> a;
    public IBaseUser b;
    public boolean c;
    public boolean d;
    public final String e;
    public CompositeDisposable f;
    public View.OnClickListener g;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ InteractAudienceAlertWindow a;

        public a(InteractAudienceAlertWindow r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L14;
            float r4 = ((Float) r3).floatValue();
            this.a.setAlpha(r4);
            if (r4 != 0.0f) goto L15;
            ViewParent r5 = this.a.getParent();
            if ((r5 instanceof ViewGroup) == true) goto L9;
            r5 = null;
        L9:
            ViewGroup r6 = (ViewGroup) r5;
            if (r6 == null) goto L16;
            r6.removeView(this.a);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ InteractAudienceAlertWindow a;

        public b(InteractAudienceAlertWindow r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
            if (r0 == null) goto L11;
            FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L9;
            r1.bottomMargin = ((Integer) r3).intValue();
            this.a.setLayoutParams(r1);
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void b() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(300);
        r0.addUpdateListener(new a(this));
        r0.setInterpolator(new e(0.0f, 0.0f, 0.58f, 1.0f));
        r0.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageUtil.loadGifImage((ImageView) a(2131364341), this.e, 2131106784);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f.clear();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.f;
    }

    public final boolean getHasAnim() {
        return this.c;
    }

    public final IBaseUser getUser() {
        return this.b;
    }

    public InteractAudienceAlertWindow(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        this.e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/interact_alert_bg.webp";
        this.f = new CompositeDisposable();
        LayoutInflater.from(getContext()).inflate(2131567721, this);
    }

    public final View a(int r3) {
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

    public final void c(int r4) {
        if (getLayoutParams() != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L10;
        int r1 = ((FrameLayout.LayoutParams) r0).bottomMargin;
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{r1, r1 + r4}).setDuration(300);
        r5.addUpdateListener(new b(this));
        r5.setInterpolator(new e(0.25f, 0.1f, 0.25f, 0.1f));
        r5.start();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void setAcceptClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g = r2;
    }

    public final void setCloseListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ImageView) a(2131366972)).setOnClickListener(r2);
    }

    public final void setCompositeDisposable(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setHasAnim(boolean r1) {
        this.c = r1;
    }

    public final void setLoading(boolean r1) {
        this.d = r1;
    }

    public final void setUser(IBaseUser r1) {
        this.b = r1;
    }

    public InteractAudienceAlertWindow(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        this.e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/interact_alert_bg.webp";
        this.f = new CompositeDisposable();
        LayoutInflater.from(getContext()).inflate(2131567721, this);
    }

    public InteractAudienceAlertWindow(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/interact_alert_bg.webp";
        this.f = new CompositeDisposable();
        LayoutInflater.from(getContext()).inflate(2131567721, this);
    }
}
