package lfb;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.ss.android.lark.filedetail.impl.folder.manage.drawable.property.ExtraVideoProperty;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements b {
    public a() {
    }

    @Override // lfb.b
    public final void b(Canvas r4, Path r5, RectF r6, ExtraVideoProperty r7, Rect r8) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "viewRectF");
        Intrinsics.checkNotNullParameter(r7, "videoParams");
        Intrinsics.checkNotNullParameter(r8, "playRect");
        if (r7.f != 1) goto L5;
        float r9 = r6.right;
        float r0 = r7.h;
        float r10 = r9 - r0;
        float r11 = r6.bottom - r0;
        float r1 = r7.g;
        r8.set((int) (r10 - r1), (int) (r11 - r1), (int) r10, (int) r11);
    L6:
        r7.i.setBounds(r8);
        r7.i.draw(r4);
        return;
    L5:
        float r2 = 2;
        int r12 = (int) (r6.width() / r2);
        int r13 = (int) (r6.height() / r2);
        int r3 = (int) (r7.g / r2);
        r8.set(r12 - r3, r13 - r3, r12 + r3, r13 + r3);
        goto L6
    }

    @Override // lfb.b
    public final void a(Canvas r27, Path r28, RectF r29, BorderProperty r30, ExtraVideoProperty r31, RectF r32, Paint r33) {
        Intrinsics.checkNotNullParameter(r27, "canvas");
        Intrinsics.checkNotNullParameter(r28, "path");
        Intrinsics.checkNotNullParameter(r29, "viewRectF");
        Intrinsics.checkNotNullParameter(r30, "borderParams");
        Intrinsics.checkNotNullParameter(r31, "videoParams");
        Intrinsics.checkNotNullParameter(r32, "videoBgRectF");
        Intrinsics.checkNotNullParameter(r33, "videoBgPaint");
        float r6 = r31.b;
        if (r6 != 0.0f) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        return;
    L8:
        float r9 = r29.left;
        float r10 = r29.bottom;
        r32.set(r9, r10 - r6, r29.right, r10);
        if (r31.c != 1) goto L11;
        float r13 = r32.left;
        LinearGradient r2 = new LinearGradient(r13, r32.top, r13, r32.bottom, r31.d, r31.e, Shader.TileMode.CLAMP);
    L12:
        r33.setShader(r2);
        r28.reset();
        r28.addRoundRect(r32, r30.getBorderRadiusPx(), r30.getBorderRadiusPx(), Path.Direction.CW);
        r27.drawPath(r28, r33);
        return;
    L11:
        r2 = new LinearGradient(r32.left, r32.top, r32.right, r29.top, r31.d, r31.e, Shader.TileMode.CLAMP);
        goto L12
    L5:
        r8 = false;
        goto L6
    }
}
