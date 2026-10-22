package com.obric.oui.oswitch;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0017J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/oui/oswitch/CustomTransitionDrawable;", "Landroid/graphics/drawable/Drawable;", "startDrawable", "endDrawable", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "crossFadeEnabled", "", "currentAlpha", "", "currentState", "duration", "fromAlpha", "interpolator", "Landroid/view/animation/Interpolator;", "isReverse", "startTime", "", "toAlpha", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawWithAlpha", "alpha", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "isCrossFadeEnabled", "resetTransition", "reverseTransition", "durationMillis", "setAlpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setCrossFadeEnabled", "enabled", "setInterpolator", "showSecondLayer", "startTransition", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0760a f14247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drawable f14248b;
    private final Drawable c;
    private int d;
    private long e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private Interpolator l;

    /* JADX INFO: renamed from: com.obric.oui.oswitch.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/oswitch/CustomTransitionDrawable$Companion;", "", "()V", "STATE_IDLE", "", "STATE_RUNNING", "STATE_STARTING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0760a {
        private C0760a() {
        }

        public /* synthetic */ C0760a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14247a = new C0760a(null);
    }

    public a(Drawable r2, Drawable r3) {
        Intrinsics.checkNotNullParameter(r2, "startDrawable");
        Intrinsics.checkNotNullParameter(r3, "endDrawable");
        this.f14248b = r2;
        this.c = r3;
        this.k = true;
        this.l = (Interpolator) ZeusTransformUtils.preCheckCast(new AccelerateInterpolator(), Interpolator.class, "com.obric.memorydata.plugin");
    }

    private final void a(Canvas r3, int r4) {
        this.f14248b.setBounds(getBounds());
        this.c.setBounds(getBounds());
        if (this.k == false) goto L5;
        this.f14248b.setAlpha(255 - r4);
    L5:
        this.f14248b.draw(r3);
        if (this.k == false) goto L8;
        this.f14248b.setAlpha(255);
    L8:
        if (r4 <= 0) goto L11;
        this.c.setAlpha(r4);
        this.c.draw(r3);
        this.c.setAlpha(255);
        return;
    }

    public final void a() {
        this.i = 0;
        this.d = 0;
        invalidateSelf();
    }

    public final void a(int r3) {
        this.g = 0;
        this.h = 255;
        this.i = 0;
        this.f = r3;
        this.j = false;
        this.d = 1;
        invalidateSelf();
    }

    public final void b() {
        this.i = 255;
        this.d = 0;
        invalidateSelf();
    }

    public final void b(int r13) {
        long r0 = SystemClock.uptimeMillis();
        int r3 = 0;
        if (this.d != 2) goto L18;
        long r6 = this.e;
        long r8 = r0 - r6;
        int r2 = this.f;
        if (r8 > r2) goto L18;
        boolean r14 = !this.j;
        this.j = r14;
        this.g = this.i;
        if (r14 == true) goto L11;
        r3 = 255;
    L11:
        this.h = r3;
        long r1 = r0 - r6;
        if (r14 == false) goto L14;
        int r15 = (int) r1;
    L15:
        this.f = r15;
    L16:
        this.d = 1;
        invalidateSelf();
        return;
    L14:
        r15 = r2 - ((int) r1);
    L18:
        this.g = 255;
        this.h = 0;
        this.i = 255;
        this.f = r13;
        this.j = true;
        goto L16
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        int r0 = this.d;
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L11;
        long r1 = SystemClock.uptimeMillis() - this.e;
        int r3 = this.f;
        if (r1 < r3) goto L9;
        this.i = this.h;
        this.d = 0;
        goto L11
    L9:
        float r2 = this.l.getInterpolation(r1 / r3);
        int r4 = this.g;
        this.i = r4 + ((int) ((this.h - r4) * r2));
    L11:
        int r5 = this.i;
        if (this.d != 0) goto L21;
        if (r5 != 0) goto L15;
        this.f14248b.setBounds(getBounds());
        Drawable r6 = this.f14248b;
    L19:
        r6.draw(r7);
        return;
    L15:
        if (r5 == 255) goto L17;
        a(r7, r5);
        return;
    L17:
        this.c.setBounds(getBounds());
        r6 = this.c;
        goto L19
    L21:
        a(r7, r5);
        if (this.d != 2) goto L26;
        invalidateSelf();
        return;
    L26:
        return;
    L10:
        this.e = SystemClock.uptimeMillis();
        this.d = 2;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.f14248b.getIntrinsicHeight(), this.c.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.f14248b.getIntrinsicWidth(), this.c.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.f14248b.setAlpha(r2);
        this.c.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.f14248b.setColorFilter(r2);
        this.c.setColorFilter(r2);
    }
}
