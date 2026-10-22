package com.obric.assistant.component.task;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.impl.databinding.ObricMtmItemSingleIconTemplateBinding;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJZ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2H\u0010\u0010\u001aD\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012#\u0012!\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/component/task/OngoingTaskItemSingleIconView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/impl/databinding/ObricMtmItemSingleIconTemplateBinding;", "bind", "", "item", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "onItemClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "clickFrom", "", "extra", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskItemSingleIconView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final ObricMtmItemSingleIconTemplateBinding a;

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
        ConstraintLayout r10 = LayoutInflater.from(r7).inflate(2131564036, this, false);
        addView(r10);
        int r11 = 2131380396;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r10, 2131380396);
        if (r2 == null) goto L16;
        r11 = 2131380399;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131380399);
        if (r3 == null) goto L16;
        ConstraintLayout r1 = r10;
        r11 = 2131380410;
        SimpleDraweeView r12 = ViewBindings.findChildViewById(r10, 2131380410);
        if (r12 == null) goto L16;
        r11 = 2131380411;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131380411);
        if (r5 == null) goto L16;
        this.a = new ObricMtmItemSingleIconTemplateBinding(r1, r2, r3, r12, r5);
        int r13 = g0.a;
        Intrinsics.checkNotNullParameter(r12, "target");
        Intrinsics.checkNotNullParameter(r12, "target");
        Object r14 = r12.getParent();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.View");
        View r15 = (View) r14;
        Rect r16 = new Rect();
        r16.left = c7.b(8);
        r16.top = c7.b(8);
        r16.right = c7.b(8);
        r16.bottom = c7.b(8);
        TouchDelegate r0 = r15.getTouchDelegate();
        if ((r0 instanceof g0.b) == false) goto L13;
        g0.b r4 = (g0.b) r0;
        g0.a r17 = new g0.a(r12, r16);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r17, "touchDelegate");
        ((LinkedList) r4.a).add(r17);
        return;
    L13:
        g0.b r6 = new g0.b(r12);
        r15.setTouchDelegate(r6);
        g0.a r18 = new g0.a(r12, r16);
        Intrinsics.checkNotNullParameter(r18, "touchDelegate");
        ((LinkedList) r6.a).add(r18);
        return;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public /* synthetic */ OngoingTaskItemSingleIconView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
