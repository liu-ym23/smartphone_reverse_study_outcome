package com.obric.oui.segmentedtab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OTouchAnimView extends RelativeLayout {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f14358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f14359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f14360c;

    @JvmOverloads
    public OTouchAnimView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public abstract boolean a();

    public abstract void b(float r5, String r10);

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        final int r5 = 0;
        final int r11 = 1;
        Intrinsics.checkNotNullParameter(r10, "event");
        int r12 = r10.getAction();
        if (r12 == 0) goto L25;
        if (r12 == 1) goto L9;
        if (r12 == 3) goto L9;
    L41:
        return super.dispatchTouchEvent(r10);
    L9:
        if (a() == false) goto L41;
        ValueAnimator r13 = this.f14359b;
        if (r13 == null) goto L15;
        r13.removeAllUpdateListeners();
    L15:
        ValueAnimator r14 = this.f14359b;
        if (r14 == null) goto L19;
        r14.cancel();
    L19:
        ValueAnimator r15 = this.f14360c;
        if (r15 == null) goto L23;
        r15.cancel();
    L23:
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{this.f14358a, 0.0f});
        r16.setDuration(200);
        r16.setInterpolator(new DecelerateInterpolator());
        r16.addUpdateListener(new j(this, r5));
        r16.start();
        this.f14360c = r16;
        goto L41
    L25:
        if (a() == false) goto L41;
        ValueAnimator r17 = this.f14360c;
        if (r17 == null) goto L31;
        r17.removeAllUpdateListeners();
    L31:
        ValueAnimator r18 = this.f14360c;
        if (r18 == null) goto L35;
        r18.cancel();
    L35:
        ValueAnimator r19 = this.f14359b;
        if (r19 == null) goto L39;
        r19.cancel();
    L39:
        ValueAnimator r20 = ValueAnimator.ofFloat(new float[]{this.f14358a, 1.0f});
        r20.setDuration(50);
        r20.setInterpolator(new DecelerateInterpolator());
        r20.addUpdateListener(new j(this, r11));
        r20.start();
        this.f14359b = r20;
        goto L41
    }

    @JvmOverloads
    public OTouchAnimView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OTouchAnimView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OTouchAnimView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
    }
}
