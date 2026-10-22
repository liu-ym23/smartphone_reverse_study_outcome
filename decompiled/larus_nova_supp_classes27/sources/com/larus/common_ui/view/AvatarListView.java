package com.larus.common_ui.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/view/AvatarListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarSize", "overlapping", "avatar1", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatar2", "getAvatarList", "", "createAvatarViewWithBorder", "index", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarListView extends RelativeLayout {
    public final int a;
    public final int b;
    public final SimpleDraweeView c;
    public final SimpleDraweeView d;

    public final List<SimpleDraweeView> getAvatarList() {
        return CollectionsKt.listOf(new SimpleDraweeView[]{this.c, this.d});
    }

    public AvatarListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final SimpleDraweeView a(int r9) {
        SimpleDraweeView r0 = new SimpleDraweeView(getContext());
        GenericDraweeHierarchyBuilder r1 = new GenericDraweeHierarchyBuilder(r0.getContext().getResources()).setRoundingParams(RoundingParams.fromCornersRadius(0.0f).setRoundAsCircle(true)).setPlaceholderImage(2131240119);
        ScalingUtils.ScaleType r3 = ScalingUtils.ScaleType.CENTER_CROP;
        r0.setHierarchy(r1.setPlaceholderImageScaleType(r3).setActualImageScaleType(r3).build());
        if (r9 == 0) goto L5;
        FrameLayout r10 = new FrameLayout(getContext());
        int r2 = v19.c.b(2130970529, r10.getContext(), 2131102529);
        int r4 = v19.c.b(2130972118, r10.getContext(), 2131103188);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r5 = ContextCompat.getColor(r10.getContext(), r2);
        int r6 = ContextCompat.getColor(r10.getContext(), r4);
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(1);
        r7.setColor(r5);
        GradientDrawable r8 = new GradientDrawable();
        r8.setShape(1);
        r8.setColor(r6);
        StateListDrawable r11 = new StateListDrawable();
        r11.addState(new int[]{R.attr.state_pressed}, r8);
        r11.addState(new int[0], r7);
        r10.setBackground(r11);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
        int r13 = this.b;
        r12.setMargins(r13, r13, r13, r13);
        r12.gravity = 17;
        r10.addView(r0, r12);
        int r14 = this.a + (this.b * 2);
        RelativeLayout.LayoutParams r15 = new RelativeLayout.LayoutParams(r14, r14);
        r15.addRule(21, 1);
        r15.addRule(12, 1);
        int r16 = this.b;
        r15.setMargins(0, 0, -r16, -r16);
        addView(r10, r15);
    L6:
        return r0;
    L5:
        int r17 = this.a;
        addView(r0, new RelativeLayout.LayoutParams(r17, r17));
        goto L6
    }

    public AvatarListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public AvatarListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130970516, 2130972100});
        this.a = (int) r5.getDimension(0, c7.c(46));
        this.b = (int) r5.getDimension(1, c7.c(3));
        r5.recycle();
        this.c = a(0);
        this.d = a(1);
    }
}
