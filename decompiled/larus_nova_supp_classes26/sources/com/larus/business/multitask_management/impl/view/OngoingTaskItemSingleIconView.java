package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.multitask_management.impl.databinding.LarusMtmItemSingleIconTemplateBinding;
import com.larus.utils.v0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJX\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2H\u0010\u0010\u001aD\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012#\u0012!\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/OngoingTaskItemSingleIconView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemSingleIconTemplateBinding;", "bind", "", "item", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "clickFrom", "", "extra", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskItemSingleIconView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusMtmItemSingleIconTemplateBinding a;

    public OngoingTaskItemSingleIconView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OngoingTaskItemSingleIconView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OngoingTaskItemSingleIconView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        ConstraintLayout r10 = LayoutInflater.from(r7).inflate(2131562970, this, false);
        addView(r10);
        int r11 = 2131380396;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131380396);
        if (r2 == null) goto L13;
        r11 = 2131380399;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131380399);
        if (r3 == null) goto L13;
        ConstraintLayout r1 = r10;
        r11 = 2131380410;
        SimpleDraweeView r12 = ViewBindings.findChildViewById(r10, 2131380410);
        if (r12 == null) goto L13;
        r11 = 2131380411;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131380411);
        if (r5 == null) goto L13;
        this.a = new LarusMtmItemSingleIconTemplateBinding(r1, r2, r3, r12, r5);
        int r13 = v0.a;
        Intrinsics.checkNotNullParameter(r12, "target");
        v0.a(r12, 8, 8, 8, 8);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public /* synthetic */ OngoingTaskItemSingleIconView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
