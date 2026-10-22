package com.larus.uaigc.createpage.component.digitalavatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/createpage/component/digitalavatar/GradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "colors", "", "positions", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GradientTextView extends AppCompatTextView {
    public final int[] a;
    public final float[] b;

    public GradientTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GradientTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.a, this.b, Shader.TileMode.CLAMP));
        super/*android.widget.TextView*/.onDraw(r10);
    }

    public GradientTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        int[] r6 = new int[4];
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#FF9851")));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r8) == null) goto L11;
        r8 = -16777216;
    L11:
        r6[0] = ((Number) r8).intValue();
        Object r9 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#FF6C55")));     // Catch: Throwable -> L14
    L17:
        if (Result.exceptionOrNull-impl(r9) == null) goto L20;
        r9 = -16777216;
    L20:
        r6[1] = ((Number) r9).intValue();
        Object r10 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#BC72FF")));     // Catch: Throwable -> L23
    L26:
        if (Result.exceptionOrNull-impl(r10) == null) goto L29;
        r10 = -16777216;
    L29:
        r6[2] = ((Number) r10).intValue();
        Object r11 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#5083E5")));     // Catch: Throwable -> L32
    L35:
        if (Result.exceptionOrNull-impl(r11) == null) goto L38;
        r11 = -16777216;
    L38:
        r6[3] = ((Number) r11).intValue();
        this.a = r6;
        this.b = new float[]{0.0f, 0.3f, 0.66f, 0.9f};
        return;
    L32:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public /* synthetic */ GradientTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
