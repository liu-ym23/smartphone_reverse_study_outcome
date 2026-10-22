package io.noties.markwon.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001dB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u001e"}, d2 = {"Lio/noties/markwon/image/AsyncGridDrawable;", "Lio/noties/markwon/image/AsyncDrawable;", "destination", "", "loader", "Lio/noties/markwon/image/AsyncDrawableLoader;", "spanCount", "", "index", "margin", "maxWidth", "(Ljava/lang/String;Lio/noties/markwon/image/AsyncDrawableLoader;IIII)V", "getIndex", "()I", "getMargin", "marginLeft", "getMarginLeft", "marginTop", "getMarginTop", "getMaxWidth", "getSpanCount", "draw", "", "canvas", "Landroid/graphics/Canvas;", "initBounds", "setPlaceholderResult", "placeholder", "Landroid/graphics/drawable/Drawable;", "GridImageSizeResolver", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public class e extends io.noties.markwon.a.a {
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/image/AsyncGridDrawable$GridImageSizeResolver;", "Lio/noties/markwon/image/ImageSizeResolver;", "spanCount", "", "margin", "maxWidth", "(III)V", "getMargin", "()I", "getMaxWidth", "getSpanCount", "resolveImageSize", "Landroid/graphics/Rect;", "drawable", "Lio/noties/markwon/image/AsyncDrawable;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    private static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f16396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f16397b;
        private final int c;

        public a(int r1, int r2, int r3) {
            this.f16396a = r1;
            this.f16397b = r2;
            this.c = r3;
        }

        @Override // io.noties.markwon.a.i
        public Rect a(io.noties.markwon.a.a r3) {
            Intrinsics.checkParameterIsNotNull(r3, "drawable");
            int r0 = this.c;
            if (r0 > 0) goto L6;
            r0 = r3.d();
        L6:
            int r4 = this.f16396a;
            int r1 = (r0 - ((r4 - 1) * this.f16397b)) / r4;
            return new Rect(0, 0, r1, r1);
        }
    }

    public e(String r4, b r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkParameterIsNotNull(r4, "destination");
        Intrinsics.checkParameterIsNotNull(r5, "loader");
        super(r4, r5, (i) ZeusTransformUtils.preCheckCast(new a(r6, r8, r9), i.class, "com.obric.memorydata.plugin"), null);
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        if ((r7 % r6) == 0) goto L5;
        int r10 = r8;
    L6:
        this.g = r10;
        if ((r7 / r6) != 0) goto L10;
        r8 = 0;
    L10:
        this.h = r8;
        return;
    L5:
        r10 = 0;
        goto L6
    }

    @Override // io.noties.markwon.a.a
    public void a(Drawable r2) {
        Intrinsics.checkParameterIsNotNull(r2, "placeholder");
        this.d = true;
        super.setResult(r2);
        this.d = true;
    }

    @Override // io.noties.markwon.a.a, android.graphics.drawable.Drawable
    public void draw(Canvas r4) {
        Intrinsics.checkParameterIsNotNull(r4, "canvas");
        if (g() == false) goto L10;
        int r0 = r4.save();
        r4.translate(this.g, this.h);     // Catch: Throwable -> L7
        super.draw(r4);     // Catch: Throwable -> L7
        r4.restoreToCount(r0);
        return;
    L7:
        th = move-exception;
        r4.restoreToCount(r0);
        throw th;
    L10:
        super.draw(r4);
    }

    @Override // io.noties.markwon.a.a
    public void k() {
        if (this.l <= 0) goto L5;
    L7:
        this.c = false;
        Rect r0 = l();
        Intrinsics.checkExpressionValueIsNotNull(r0, "resolveBounds()");
        Drawable r1 = f();
        Intrinsics.checkExpressionValueIsNotNull(r1, "result");
        r1.setBounds(r0);
        Drawable r2 = f();
        Intrinsics.checkExpressionValueIsNotNull(r2, "result");
        r2.setCallback(this.f16390a);
        setBounds(r0.left, r0.top, r0.right + this.g, r0.bottom + this.h);
        invalidateSelf();
        return;
    L5:
        if (this.f16391b != 0) goto L7;
        super.k();
    }

    public final int m() {
        return this.i;
    }

    public final int n() {
        return this.j;
    }
}
