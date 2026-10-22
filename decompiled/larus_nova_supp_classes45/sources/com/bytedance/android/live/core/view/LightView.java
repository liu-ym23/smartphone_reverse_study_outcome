package com.bytedance.android.live.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/core/view/LightView;", "Landroid/view/View;", "", "a", "Z", "getNeedDraw", "()Z", "setNeedDraw", "(Z)V", "needDraw", "Landroid/graphics/Paint;", "b", "Lkotlin/Lazy;", "getShadowBorderPaint", "()Landroid/graphics/Paint;", "shadowBorderPaint", "", "d", "getShadowContentLineHeight", "()F", "shadowContentLineHeight", "e", "getShadowContentPaint", "shadowContentPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LightView extends View {
    public boolean a;
    public final Lazy b;
    public final int c;
    public final Lazy d;
    public final Lazy e;

    public LightView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LightView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getShadowBorderPaint() {
        return (Paint) this.b.getValue();
    }

    private final float getShadowContentLineHeight() {
        return ((Number) this.d.getValue()).floatValue();
    }

    private final Paint getShadowContentPaint() {
        return (Paint) this.e.getValue();
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
    }

    public final boolean getNeedDraw() {
        return this.a;
    }

    @Override // android.view.View
    public final void draw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        if (this.a == false) goto L19;
        int r0 = this.c;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L13;
        if ((r2 % 2) != 0) goto L9;
        getShadowContentPaint().setColor(0);
    L10:
        if (r12 == null) goto L12;
        r12.drawRect(0.0f, r2 * getShadowContentLineHeight(), getWidth(), (r2 + 1) * getShadowContentLineHeight(), getShadowContentPaint());
    L12:
        r2 = r2 + 1;
        goto L5
    L9:
        getShadowContentPaint().setColor(ColorProtector.parseColor("#80F5D9DA"));
        goto L10
    L13:
        if (r12 == null) goto L20;
        r12.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getShadowBorderPaint());
        return;
    L20:
        return;
    }

    public final void setNeedDraw(boolean r1) {
        this.a = r1;
    }

    public LightView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(LightView$shadowBorderPaint$2.INSTANCE);
        this.c = 10;
        this.d = LazyKt.lazy(new LightView$shadowContentLineHeight$2(this));
        this.e = LazyKt.lazy(LightView$shadowContentPaint$2.INSTANCE);
    }

    public /* synthetic */ LightView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
