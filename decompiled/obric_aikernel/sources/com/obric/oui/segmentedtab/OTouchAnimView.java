package com.obric.oui.segmentedtab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000 \n2\u00020\u0001:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OTouchAnimView extends RelativeLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f7342i = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7343c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ValueAnimator f7344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ValueAnimator f7345h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final float a(float r10) {
            return 1 - (r10 * 0.5f);
        }
    }

    static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OTouchAnimView f7346c;

        b(OTouchAnimView r10) {
            this.f7346c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animator");
            OTouchAnimView r11 = this.f7346c;
            Object r12 = r10.getAnimatedValue();
            Objects.requireNonNull(r12, "null cannot be cast to non-null type kotlin.Float");
            OTouchAnimView.b(r11, ((Float) r12).floatValue());
            OTouchAnimView r13 = this.f7346c;
            r13.f(OTouchAnimView.a(r13), "press_anim");
        }
    }

    static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OTouchAnimView f7347c;

        c(OTouchAnimView r10) {
            this.f7347c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animator");
            OTouchAnimView r11 = this.f7347c;
            Object r12 = r10.getAnimatedValue();
            Objects.requireNonNull(r12, "null cannot be cast to non-null type kotlin.Float");
            OTouchAnimView.b(r11, ((Float) r12).floatValue());
            OTouchAnimView r13 = this.f7347c;
            r13.f(OTouchAnimView.a(r13), "release_anim");
        }
    }

    static {
        f7342i = new a(null);
    }

    @JvmOverloads
    public OTouchAnimView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OTouchAnimView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OTouchAnimView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ OTouchAnimView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ float a(OTouchAnimView r10) {
        return r10.f7343c;
    }

    public static final /* synthetic */ void b(OTouchAnimView r10, float r11) {
        r10.f7343c = r11;
    }

    private final void g() {
        if (c() == true) goto L5;
        return;
    L5:
        ValueAnimator r10 = this.f7345h;
        if (r10 == null) goto L8;
        r10.removeAllUpdateListeners();
    L8:
        ValueAnimator r11 = this.f7345h;
        if (r11 == null) goto L11;
        r11.cancel();
    L11:
        ValueAnimator r12 = this.f7344g;
        if (r12 == null) goto L14;
        r12.cancel();
    L14:
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{this.f7343c, 1.0f});
        r13.setDuration(50);
        r13.setInterpolator(new DecelerateInterpolator());
        r13.addUpdateListener(new b(this));
        Unit r14 = Unit.INSTANCE;
        r13.start();
        this.f7344g = r13;
    }

    private final void h() {
        if (c() == true) goto L5;
        return;
    L5:
        ValueAnimator r10 = this.f7344g;
        if (r10 == null) goto L8;
        r10.removeAllUpdateListeners();
    L8:
        ValueAnimator r11 = this.f7344g;
        if (r11 == null) goto L11;
        r11.cancel();
    L11:
        ValueAnimator r12 = this.f7345h;
        if (r12 == null) goto L14;
        r12.cancel();
    L14:
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{this.f7343c, 0.0f});
        r13.setDuration(200);
        r13.setInterpolator(new DecelerateInterpolator());
        r13.addUpdateListener(new c(this));
        Unit r14 = Unit.INSTANCE;
        r13.start();
        this.f7345h = r13;
    }

    public abstract boolean c();

    public final void d() {
        ValueAnimator r10 = this.f7344g;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        ValueAnimator r11 = this.f7345h;
        if (r11 == null) goto L9;
        r11.cancel();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        g();
    L12:
        return super.dispatchTouchEvent(r10);
    L5:
        if (r11 != 1) goto L7;
    L9:
        h();
        goto L12
    L7:
        if (r11 == 3) goto L9;
        goto L9
    }

    public final boolean e() {
        ValueAnimator r10 = this.f7344g;
        if (r10 != null) goto L5;
    L6:
        ValueAnimator r11 = this.f7345h;
        if (r11 != null) goto L9;
    L11:
        return false;
    L9:
        if (r11.isRunning() != true) goto L11;
        return true;
    L5:
        if (r10.isRunning() != true) goto L6;
        return true;
    }

    public abstract void f(float r10, String r11);
}
