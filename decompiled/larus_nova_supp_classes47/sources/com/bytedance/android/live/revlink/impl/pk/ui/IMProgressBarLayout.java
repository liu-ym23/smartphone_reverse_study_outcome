package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/IMProgressBarLayout;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMProgressBarLayout extends View {
    public final RectF a;
    public final RectF b;
    public final RectF c;
    public int d;
    public int e;
    public final int f;
    public final Paint g;
    public float h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    public IMProgressBarLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.d = s1.h(2131108004);
        this.e = s1.h(2131108005);
        this.f = s1.h(2131108006);
        Paint r5 = new Paint();
        this.g = r5;
        this.h = 0.5f;
        r5.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        float r0 = (this.h * (getWidth() - 30)) + 15;
        RectF r1 = this.a;
        r1.top = 0.0f;
        r1.bottom = getHeight();
        RectF r2 = this.a;
        r2.left = 0.0f;
        r2.right = r0;
        RectF r3 = this.b;
        r3.top = 0.0f;
        r3.bottom = getHeight();
        RectF r4 = this.b;
        r4.left = r0;
        r4.right = getWidth();
        if (this.i == false) goto L5;
        this.g.setColor(this.f);
        r5.drawRect(this.c, this.g);
    L5:
        this.g.setColor(this.d);
        r5.drawRect(this.a, this.g);
        this.g.setColor(this.e);
        r5.drawRect(this.b, this.g);
    }

    public IMProgressBarLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.d = s1.h(2131108004);
        this.e = s1.h(2131108005);
        this.f = s1.h(2131108006);
        Paint r5 = new Paint();
        this.g = r5;
        this.h = 0.5f;
        r5.setStyle(Paint.Style.FILL);
    }

    public IMProgressBarLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.d = s1.h(2131108004);
        this.e = s1.h(2131108005);
        this.f = s1.h(2131108006);
        Paint r5 = new Paint();
        this.g = r5;
        this.h = 0.5f;
        r5.setStyle(Paint.Style.FILL);
    }

    public final void a(boolean r3, long r4, long r6) {
        this.i = r3;
        if (r3 == false) goto L5;
        this.d = s1.h(2131108007);
        this.e = s1.h(2131108008);
    L6:
        long r7 = r6 + r4;
        if (r7 == 0) goto L9;
        this.h = (r4 * 1.0f) / (r7 * 1.0f);
    L10:
        invalidate();
        return;
    L9:
        this.h = 0.5f;
        goto L10
    L5:
        this.d = s1.h(2131108004);
        this.e = s1.h(2131108005);
        goto L6
    }
}
