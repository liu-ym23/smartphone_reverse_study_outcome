package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/ClipImageView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", BuildConfig.FLAVOR, "a", "F", "getClipOffset", "()F", "setClipOffset", "(F)V", "clipOffset", BuildConfig.FLAVOR, "b", "Z", "getRound", "()Z", "setRound", "(Z)V", "round", "c", "getRadius", "setRadius", "radius", "Landroid/graphics/drawable/Drawable;", "g", "Landroid/graphics/drawable/Drawable;", "getBorderDrawable", "()Landroid/graphics/drawable/Drawable;", "setBorderDrawable", "(Landroid/graphics/drawable/Drawable;)V", "borderDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClipImageView extends HSImageView {
    public float a;
    public boolean b;
    public float c;
    public final Path d;
    public final Path e;
    public final Path f;
    public Drawable g;

    public ClipImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ClipImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final Drawable getBorderDrawable() {
        return this.g;
    }

    public final float getClipOffset() {
        return this.a;
    }

    public final float getRadius() {
        return this.c;
    }

    public final boolean getRound() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
    L14:
        e = move-exception;
        ALogger.i("ClipImageView", String.valueOf(e.getMessage()));
        return;
    L4:
        if (this.b == false) goto L7;
        r3.save();     // Catch: Exception -> L14
        r3.clipPath(this.e);     // Catch: Exception -> L14
        super/*android.widget.ImageView*/.onDraw(r3);     // Catch: Exception -> L14
        r3.restore();     // Catch: Exception -> L14
    L10:
        Drawable r0 = this.g;     // Catch: Exception -> L14
        if (r0 == null) goto L19;
        r0.draw(r3);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L7:
        if (this.c <= 0.0f) goto L9;
        r3.save();     // Catch: Exception -> L14
        r3.clipPath(this.f);     // Catch: Exception -> L14
        super/*android.widget.ImageView*/.onDraw(r3);     // Catch: Exception -> L14
        r3.restore();     // Catch: Exception -> L14
        goto L10
    L9:
        super/*android.widget.ImageView*/.onDraw(r3);     // Catch: Exception -> L14
        goto L10
    }

    public final void setBorderDrawable(Drawable r1) {
        this.g = r1;
    }

    public final void setClipOffset(float r1) {
        this.a = r1;
    }

    public final void setRadius(float r1) {
        this.c = r1;
    }

    public final void setRound(boolean r1) {
        this.b = r1;
    }

    public ClipImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new Path();
        this.e = new Path();
        this.f = new Path();
    }

    public /* synthetic */ ClipImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r9, int r10, int r11, int r13) {
        super/*android.widget.ImageView*/.onSizeChanged(r9, r10, r11, r13);
        this.d.reset();
        Path r14 = this.d;
        float r3 = r9;
        float r0 = 2;
        float r15 = ((-r3) / r0) + this.a;
        float r4 = r10;
        float r1 = r4 / r0;
        float r2 = r3 / r0;
        r14.addCircle(r15, r1, r2, Path.Direction.CCW);
        this.e.reset();
        this.e.addCircle(r2, r1, r2, Path.Direction.CCW);
        if (this.c <= 0.0f) goto L5;
        this.f.reset();
        Path r5 = this.f;
        float r6 = this.c;
        r5.addRoundRect(0.0f, 0.0f, r3, r4, r6, r6, Path.Direction.CCW);
    L5:
        Drawable r16 = this.g;
        if (r16 == null) goto L9;
        if (r16 == null) goto L9;
        r16.setBounds(0, 0, r9, r10);
    L9:
        this.e.op(this.d, Path.Op.DIFFERENCE);
    }
}
