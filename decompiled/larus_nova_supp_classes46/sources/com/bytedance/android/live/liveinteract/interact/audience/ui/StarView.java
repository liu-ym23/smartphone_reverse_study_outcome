package com.bytedance.android.live.liveinteract.interact.audience.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0016\u0010\u001aB#\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0016\u0010\u001dR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/ui/StarView;", "Landroid/view/View;", "", "value", "a", "F", "getPercent", "()F", "setPercent", "(F)V", "percent", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "getStarImageBg", "()Landroid/graphics/drawable/Drawable;", "starImageBg", "c", "getStarImageCover", "starImageCover", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StarView extends View {
    public float a;
    public final Drawable b;
    public final Drawable c;

    public final float getPercent() {
        return this.a;
    }

    public final Drawable getStarImageBg() {
        return this.b;
    }

    public final Drawable getStarImageCover() {
        return this.c;
    }

    public StarView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = getContext().getResources().getDrawable(2131251992);
        this.c = getContext().getResources().getDrawable(2131251993);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        this.b.setBounds(0, 0, getWidth(), getHeight());
        this.b.draw(r6);
        int r0 = r6.save();
        r6.clipRect(0, 0, (int) (getWidth() * this.a), getHeight());
        this.c.setBounds(0, 0, getWidth(), getHeight());
        this.c.draw(r6);
        r6.restoreToCount(r0);
    }

    public final void setPercent(float r2) {
        if (r2 >= 0.0f) goto L5;
        return;
    L5:
        if (r2 > 1.0f) goto L10;
        this.a = r2;
        return;
    }

    public StarView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = getContext().getResources().getDrawable(2131251992);
        this.c = getContext().getResources().getDrawable(2131251993);
    }

    public StarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = getContext().getResources().getDrawable(2131251992);
        this.c = getContext().getResources().getDrawable(2131251993);
    }
}
