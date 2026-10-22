package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lyr/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelPickerMulti extends ConstraintLayout implements yr.b {
    public final LinearLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f14039h;

    @JvmOverloads
    public OReelPickerMulti(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // yr.b
    public final WheelView a(int r5) {
        return (WheelView) CollectionsKt.getOrNull(this.f14039h, r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout r5 = this.g;
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if (r10 == null) goto L7;
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) r10;
        r11.startToStart = 0;
        r11.endToEnd = 0;
        r11.topToTop = 0;
        r11.bottomToBottom = 0;
        r5.setLayoutParams(r11);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @JvmOverloads
    public OReelPickerMulti(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OReelPickerMulti(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OReelPickerMulti(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        LinearLayout r12 = new LinearLayout(r5);
        r12.setId(View.generateViewId());
        r12.setOrientation(0);
        r12.setGravity(17);
        r12.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.g = r12;
        this.f14039h = new ArrayList();
        addView(r12);
    }
}
