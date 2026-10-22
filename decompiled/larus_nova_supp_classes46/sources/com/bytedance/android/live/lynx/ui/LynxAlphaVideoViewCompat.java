package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006="}, d2 = {"Lcom/bytedance/android/live/lynx/ui/LynxAlphaVideoViewCompat;", "Lcom/lynx/tasm/behavior/ui/view/a;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "a", "Z", "getMAutoPlay", "()Z", "setMAutoPlay", "(Z)V", "mAutoPlay", "Landroidx/lifecycle/LifecycleRegistry;", "b", "Landroidx/lifecycle/LifecycleRegistry;", "getMLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "setMLifecycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "mLifecycleRegistry", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "getMPoster", "()Landroid/graphics/Bitmap;", "setMPoster", "(Landroid/graphics/Bitmap;)V", "mPoster", "d", "getMLastFrame", "setMLastFrame", "mLastFrame", "e", "getMIsShowLastFrame", "setMIsShowLastFrame", "mIsShowLastFrame", "f", "getMIsShowPoster", "setMIsShowPoster", "mIsShowPoster", "Landroid/graphics/Paint;", "g", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "mPaint", "Landroid/graphics/RectF;", "h", "Landroid/graphics/RectF;", "getMRectF", "()Landroid/graphics/RectF;", "setMRectF", "(Landroid/graphics/RectF;)V", "mRectF", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxAlphaVideoViewCompat extends com.lynx.tasm.behavior.ui.view.a implements LifecycleOwnerCompat {
    public boolean a;
    public LifecycleRegistry b;
    public Bitmap c;
    public Bitmap d;
    public boolean e;
    public boolean f;
    public Paint g;
    public RectF h;

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a == false) goto L6;
        this.b.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        return;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public Lifecycle getLifecycleCompat() {
        return this.b;
    }

    public final boolean getMAutoPlay() {
        return this.a;
    }

    public final boolean getMIsShowLastFrame() {
        return this.e;
    }

    public final boolean getMIsShowPoster() {
        return this.f;
    }

    public final Bitmap getMLastFrame() {
        return this.d;
    }

    public final LifecycleRegistry getMLifecycleRegistry() {
        return this.b;
    }

    public final Paint getMPaint() {
        return this.g;
    }

    public final Bitmap getMPoster() {
        return this.c;
    }

    public final RectF getMRectF() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LynxAlphaVideoViewCompat(Context r4) {
        super(r4);
        setWillNotDraw(false);
        this.b = new LifecycleRegistry(this);
        this.g = new Paint();
        this.h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (this.c == null) goto L12;
        if (this.d == null) goto L12;
        if (this.f == false) goto L12;
        this.h.set(0.0f, 0.0f, getWidth(), getHeight());
        Bitmap r0 = this.d;
        if (r0 == null) goto L19;
        r6.drawBitmap(r0, null, this.h, this.g);
        return;
    L19:
        return;
    L12:
        if (this.d != null) goto L14;
        return;
    L14:
        if (this.e == false) goto L22;
        this.h.set(0.0f, 0.0f, getWidth(), getHeight());
        Bitmap r1 = this.d;
        if (r1 == null) goto L23;
        r6.drawBitmap(r1, null, this.h, this.g);
        return;
    L23:
        return;
    }

    public final void setMAutoPlay(boolean r1) {
        this.a = r1;
    }

    public final void setMIsShowLastFrame(boolean r1) {
        this.e = r1;
    }

    public final void setMIsShowPoster(boolean r1) {
        this.f = r1;
    }

    public final void setMLastFrame(Bitmap r1) {
        this.d = r1;
    }

    public final void setMLifecycleRegistry(LifecycleRegistry r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMPaint(Paint r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setMPoster(Bitmap r1) {
        this.c = r1;
    }

    public final void setMRectF(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        Iterator r0 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) r0.next()).measure(r3, r4);
        goto L4
    }
}
