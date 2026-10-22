package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import b02.v;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/RoundWaveAnimationView;", "Landroid/widget/FrameLayout;", "Lio/reactivex/disposables/Disposable;", "a", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "disposable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoundWaveAnimationView extends FrameLayout {
    public Disposable a;

    public RoundWaveAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RoundWaveAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        View r0 = new View(getContext());
        r0.setBackgroundResource(2131250703);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(s1.f(80.0f), s1.f(80.0f));
        r1.gravity = 17;
        Unit r2 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        r0.setAlpha(0.6f);
        addView(r0);
        r0.animate().alpha(0.0f).scaleX(1.7f).scaleY(1.7f).setDuration(1000).setListener(new v(this, r0)).start();
    }

    public final Disposable getDisposable() {
        return this.a;
    }

    public final void setDisposable(Disposable r1) {
        this.a = r1;
    }

    public RoundWaveAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ RoundWaveAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
