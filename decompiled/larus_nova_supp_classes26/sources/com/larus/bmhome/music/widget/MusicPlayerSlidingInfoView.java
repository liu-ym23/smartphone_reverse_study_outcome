package com.larus.bmhome.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.music.databinding.LarusViewMusicPlayerSlidingInfoBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010(\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicPlayerSlidingInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "dismissOffset", "", "startX", "startY", "dispatchToViewPager", "", "banInnerDismiss", "binding", "Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerSlidingInfoBinding;", "getBinding", "()Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerSlidingInfoBinding;", "binding$delegate", "Lkotlin/Lazy;", "dismissCallback", "Lkotlin/Function0;", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "parentSlideDirection", "getParentSlideDirection", "()I", "setParentSlideDirection", "(I)V", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "disallowInnerDismiss", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicPlayerSlidingInfoView extends ConstraintLayout {
    public static final /* synthetic */ int i = 0;
    public final int a;
    public final float b;
    public float c;
    public float d;
    public boolean e;
    public final Lazy f;
    public Function0<Unit> g;
    public int h;

    public MusicPlayerSlidingInfoView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MusicPlayerSlidingInfoView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final LarusViewMusicPlayerSlidingInfoBinding getBinding() {
        return (LarusViewMusicPlayerSlidingInfoBinding) this.f.getValue();
    }

    public final Function0<Unit> getDismissCallback() {
        return this.g;
    }

    public final int getParentSlideDirection() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (this.e == true) goto L5;
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L9;
        this.c = r8.getX();
        this.d = r8.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L40:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r8);
    L9:
        if (r0 != 1) goto L11;
    L37:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L11:
        if (r0 != 2) goto L13;
        float r1 = r8.getX() - this.c;
        float r3 = r8.getY() - this.d;
        if (Math.abs(r3) > this.a) goto L18;
    L22:
        boolean r4 = false;
    L24:
        if (Math.abs(r1) > this.a) goto L26;
    L30:
        boolean r2 = false;
    L31:
        if (r4 == true) goto L35;
        if (r2 == true) goto L35;
        getParent().requestDisallowInterceptTouchEvent(false);
    L35:
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L26:
        if (Math.abs(r1) <= Math.abs(r3)) goto L30;
        if (this.h != 1) goto L30;
        r2 = true;
        goto L31
    L18:
        if (Math.abs(r3) <= Math.abs(r1)) goto L22;
        if (this.h != 0) goto L22;
        r4 = true;
        goto L24
    L13:
        if (r0 == 3) goto L37;
    L5:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (this.e == false) goto L7;
        return super/*android.view.ViewGroup*/.onTouchEvent(r8);
    L7:
        if (r8.getActionMasked() != 2) goto L46;
        float r0 = r8.getX() - this.c;
        float r1 = r8.getY() - this.d;
        boolean r4 = false;
        if (Math.abs(r1) > this.a) goto L11;
    L15:
        boolean r2 = false;
    L17:
        if (Math.abs(r0) > this.a) goto L19;
    L23:
        boolean r3 = false;
    L24:
        if (r2 == true) goto L28;
        if (r3 == true) goto L28;
        getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r9 = this.b;
        if (r1 > r9) goto L31;
    L33:
        boolean r5 = false;
    L35:
        if (r0 > r9) goto L37;
    L39:
        if (r5 == true) goto L41;
        if (r4 == true) goto L41;
    L44:
        return true;
    L41:
        Function0<Unit> r10 = this.g;
        if (r10 == null) goto L44;
        r10.invoke();
        goto L44
    L37:
        if (this.h != 1) goto L39;
        r4 = true;
        goto L39
    L31:
        if (this.h != 0) goto L33;
        r5 = true;
        goto L35
    L19:
        if (Math.abs(r0) <= Math.abs(r1)) goto L23;
        if (this.h != 1) goto L23;
        r3 = true;
        goto L24
    L11:
        if (Math.abs(r1) <= Math.abs(r0)) goto L15;
        if (this.h != 0) goto L15;
        r2 = true;
    L46:
        return super/*android.view.ViewGroup*/.onTouchEvent(r8);
    }

    public final void setDismissCallback(Function0<Unit> r1) {
        this.g = r1;
    }

    public final void setParentSlideDirection(int r1) {
        this.h = r1;
    }

    public MusicPlayerSlidingInfoView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.b = 150.0f;
        this.f = LazyKt.lazy(new l2(r2, this));
        this.h = 1;
    }

    public /* synthetic */ MusicPlayerSlidingInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
