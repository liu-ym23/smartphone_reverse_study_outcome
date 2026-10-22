package com.larus.common_ui.widget.input.audiowave;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0001'BA\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00128\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/larus/common_ui/widget/input/audiowave/AudioWaveGroup;", "Landroid/graphics/drawable/Drawable;", "barDrawable", "barCount", "", "barWidth", "barGap", "inset", "Landroid/graphics/Rect;", "maxBarHeight", "minBarHeight", "<init>", "(Landroid/graphics/drawable/Drawable;IIILandroid/graphics/Rect;II)V", "getBarCount", "()I", "getMaxBarHeight", "getMinBarHeight", "defaultWaveBarHeights", "", "getDefaultWaveBarHeights", "()[I", "value", "waveBarHeights", "getWaveBarHeights", "setWaveBarHeights", "([I)V", "reset", "", "getIntrinsicWidth", "getIntrinsicHeight", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioWaveGroup extends Drawable {
    public final Drawable a;
    public final int b;
    public final int c;
    public final int d;
    public final Rect e;
    public final int f;
    public final int g;
    public final int[] h;
    private int[] waveBarHeights;

    public static final class a {
    }

    static {
    }

    public final void b() {
        int[] r0 = this.h;
        Intrinsics.checkNotNullParameter(r0, "value");
        this.waveBarHeights = r0;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Rect r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.top + r0.bottom;
    L7:
        return this.f + r1;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Rect r0 = this.e;
        if (r0 == null) goto L5;
        int r1 = r0.left + r0.right;
    L6:
        int r2 = this.b;
        int r3 = this.c;
        int r4 = this.d;
        return ((r2 * (r3 + r4)) - r4) + r1;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return Drawable.resolveOpacity(-2, this.a.getOpacity());
    }

    public final int[] a() {
        return this.waveBarHeights;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        if (this.a.getAlpha() != 0) goto L5;
        return;
    L5:
        Rect r0 = this.e;
        int r1 = 0;
        if (r0 == null) goto L8;
        int r2 = r0.left;
    L9:
        if (r0 == null) goto L11;
        int r3 = r0.top;
    L12:
        if (r0 == null) goto L14;
        int r4 = r0.bottom;
    L15:
        int r5 = this.b;
    L16:
        if (r1 >= r5) goto L18;
        int r6 = this.waveBarHeights[r1];
        int r7 = (getBounds().left + r2) + ((this.c + this.d) * r1);
        int r8 = (getBounds().top + r3) + ((((getBounds().height() - r3) - r4) - r6) / 2);
        Drawable r9 = this.a;
        r9.setBounds(r7, r8, this.c + r7, r6 + r8);
        this.a.draw(r11);
        r1 = r1 + 1;
        goto L16
    L18:
        return;
    L14:
        r4 = 0;
        goto L15
    L11:
        r3 = 0;
        goto L12
    L8:
        r2 = 0;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }

    public AudioWaveGroup(Drawable r2, int r3, int r4, int r5, Rect r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "barDrawable");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        int[] r9 = new int[r3];
        int r10 = 0;
    L3:
        if (r10 >= r3) goto L5;
        r9[r10] = this.g;
        r10 = r10 + 1;
        goto L3
    L5:
        this.h = r9;
        this.waveBarHeights = r9;
    }
}
