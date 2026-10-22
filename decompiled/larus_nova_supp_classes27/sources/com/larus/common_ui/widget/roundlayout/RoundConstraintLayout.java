package com.larus.common_ui.widget.roundlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import c29.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0014J0\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0014J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\nR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/common_ui/widget/roundlayout/RoundConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "delegate", "Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "getDelegate", "()Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "isUseMaterial", "", "()Z", "setUseMaterial", "(Z)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "setDeleteBackgroundColor", "color", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RoundConstraintLayout extends ConstraintLayout {
    public final a a;
    public boolean b;

    public final a getDelegate() {
        return this.a;
    }

    public RoundConstraintLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setDeleteBackgroundColor(int r2) {
        this.a.a(r2);
    }

    public final void setUseMaterial(boolean r1) {
        this.b = r1;
    }

    public RoundConstraintLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r2, int r3) {
        if (this.a.r == true) goto L5;
    L10:
        super.onMeasure(r2, r3);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r4 = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
        super.onMeasure(r4, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RoundConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new a(this, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.b == false) goto L5;
        return;
    L5:
        a r6 = this.a;
        if (r6.q == false) goto L8;
        r6.d(getHeight() / 2);
        return;
    L8:
        r6.c();
    }
}
