package kfb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.ss.android.lark.filedetail.impl.folder.manage.drawable.property.ExtraVideoProperty;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends a {
    public final mfb.a h;
    public final BorderProperty i;
    public final ExtraVideoProperty j;
    public final lfb.b k;
    public final RectF l;
    public final Paint m;
    public final Rect n;

    @Override // kfb.a, android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.draw(r10);
        if (this.h.d == false) goto L6;
        this.k.a(r10, this.a, this.b, this.i, this.j, this.l, this.m);
        this.k.b(r10, this.a, this.b, this.j, this.n);
        return;
    }

    public b(mfb.a r2, BorderProperty r3, ExtraVideoProperty r4, lfb.a r5) {
        Intrinsics.checkNotNullParameter(r2, "drawableParams");
        Intrinsics.checkNotNullParameter(r3, "borderParams");
        Intrinsics.checkNotNullParameter(r4, "videoParams");
        Intrinsics.checkNotNullParameter(r5, "extraAction");
        super(r2, r3);
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = new RectF();
        this.m = new Paint();
        this.n = new Rect();
    }
}
