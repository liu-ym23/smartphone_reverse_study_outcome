package com.obric.clockwidgets.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import com.obric.clockwidgets.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/clockwidgets/ui/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "value", "a", "F", "getRoundRadius", "()F", "setRoundRadius", "(F)V", "roundRadius", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RemoteViews.RemoteView
public final class RoundLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11278a;

    @JvmOverloads
    public RoundLinearLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final float getRoundRadius() {
        return this.f11278a;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        invalidateOutline();
    }

    public final void setRoundRadius(float r5) {
        if (r5 >= 0.0f) goto L6;
        r5 = 0.0f;
    L6:
        if (this.f11278a == r5) goto L10;
        this.f11278a = r5;
        invalidateOutline();
        invalidate();
        return;
    }

    @JvmOverloads
    public RoundLinearLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        br.c r11 = new br.c(this, 2);
        setClipToOutline(true);
        setOutlineProvider(r11);
        if (r10 == null) goto L6;
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.RoundLinearLayout);
        setRoundRadius(r12.getDimension(R$styleable.RoundLinearLayout_roundRadius, 0.0f));
        r12.recycle();
        return;
    }
}
