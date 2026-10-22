package com.larus.camera.impl.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/camera/impl/widget/SurfaceBaselineView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initView", "", "view", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SurfaceBaselineView extends ConstraintLayout {
    public static final int[] a = null;

    public static final class a {
    }

    public SurfaceBaselineView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SurfaceBaselineView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        a = new int[]{0, ColorProtector.parseColor("#B2FFFFFF"), 0};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SurfaceBaselineView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = ViewGroup.inflate(r2, 2131562906, this);
        Intrinsics.checkNotNull(r5);
        GradientDrawable.Orientation r6 = GradientDrawable.Orientation.LEFT_RIGHT;
        int[] r0 = a;
        GradientDrawable r7 = new GradientDrawable(r6, r0);
        r5.findViewById(2131377917).setBackground(r7);
        r5.findViewById(2131377918).setBackground(r7);
        GradientDrawable r8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, r0);
        r5.findViewById(2131377930).setBackground(r8);
        r5.findViewById(2131377931).setBackground(r8);
    }

    public /* synthetic */ SurfaceBaselineView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
