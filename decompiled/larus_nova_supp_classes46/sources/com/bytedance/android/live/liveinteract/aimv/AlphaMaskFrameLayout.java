package com.bytedance.android.live.liveinteract.aimv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012RR\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\u001a\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/aimv/AlphaMaskFrameLayout;", "Landroid/widget/FrameLayout;", "", "Lkotlin/Pair;", "", "value", "f", "Ljava/util/List;", "getAlphaMask", "()Ljava/util/List;", "setAlphaMask", "(Ljava/util/List;)V", "alphaMask", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AlphaMaskFrameLayout extends FrameLayout {
    public final long a;
    public final Paint b;
    public float[] c;
    public int[] d;
    public LinearGradient e;
    public List<Pair<Float, Float>> f;

    public final List<Pair<Float, Float>> getAlphaMask() {
        return this.f;
    }

    public AlphaMaskFrameLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        List<Pair<Float, Float>> r0 = this.f;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        int r4 = r13.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    L12:
        super.dispatchDraw(r13);
        if (r0 != null) goto L15;
    L18:
        if (r1 == true) goto L28;
        int[] r9 = this.d;
        float[] r10 = this.c;
        if (r9 == null) goto L26;
        if (r10 == null) goto L26;
        if (this.e != null) goto L25;
        this.e = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), r9, r10, Shader.TileMode.CLAMP);
    L25:
        this.b.setShader(this.e);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    L26:
        r13.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.b);
        r13.restoreToCount(r4);
        return;
    L28:
        return;
    L15:
        if (r0.isEmpty() == true) goto L18;
        r1 = false;
        goto L18
    L11:
        r4 = 0;
        goto L12
    L5:
        if (r0.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void setAlphaMask(List<Pair<Float, Float>> r11) {
        this.f = r11;
        int r0 = 0;
        if (r11 == null) goto L5;
        int r1 = r11.size();
    L7:
        if (r11 == null) goto L18;
        float[] r3 = new float[r1];
        int r4 = 0;
    L10:
        if (r4 >= r1) goto L12;
        r3[r4] = 0.0f;
        r4 = r4 + 1;
        goto L10
    L12:
        this.c = r3;
        int[] r5 = new int[r1];
        int r6 = 0;
    L13:
        if (r6 >= r1) goto L15;
        r5[r6] = 0;
        r6 = r6 + 1;
        goto L13
    L15:
        this.d = r5;
    L16:
        if (r0 >= r1) goto L19;
        float[] r7 = this.c;
        Intrinsics.checkNotNull(r7);
        r7[r0] = ((Number) ((Pair) ListProtector.get(r11, r0)).getFirst()).floatValue();
        int[] r8 = this.d;
        Intrinsics.checkNotNull(r8);
        r8[r0] = (((int) (RangesKt.coerceIn(((Number) ((Pair) ListProtector.get(r11, r0)).getSecond()).floatValue(), 0.0f, 1.0f) * 255)) << 24) | ((int) (this.a & 16777215));
        r0 = r0 + 1;
    L19:
        this.e = null;
        invalidate();
        return;
    L18:
        this.c = null;
        this.d = null;
        goto L19
    L5:
        r1 = 0;
        goto L7
    }

    public AlphaMaskFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = 4278190080L;
        Paint r4 = new Paint(1);
        r4.setDither(true);
        Unit r5 = Unit.INSTANCE;
        this.b = r4;
    }
}
