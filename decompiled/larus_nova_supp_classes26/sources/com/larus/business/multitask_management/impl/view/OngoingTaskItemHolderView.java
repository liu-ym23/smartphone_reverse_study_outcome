package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.multitask_management.impl.databinding.LarusMtmItemTaskOngoingBinding;
import com.larus.multitask_management.api.customize.ITaskUIFactory;
import com.larus.utils.v0;
import com.larus.utils.w0;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0093\u0001\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00152\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122_\b\u0002\u0010\u001d\u001aY\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012#\u0012!\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010#¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001eR\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/OngoingTaskItemHolderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "uiTemplate", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemTaskOngoingBinding;", "taskView", "Lcom/larus/multitask_management/api/customize/ITaskView;", "contentView", "Landroid/view/View;", "onCardClick", "Lkotlin/Function0;", "", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "bind", "bindingAdapterPosition", "item", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "isFoldTriggerCard", "onItemClick", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "clickFrom", "", "extra", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskItemHolderView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public final int a;
    public final LarusMtmItemTaskOngoingBinding b;
    public final jl9.a c;
    public final View d;
    public Function0<Unit> e;

    public OngoingTaskItemHolderView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 0, 14);
    }

    public OngoingTaskItemHolderView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 0, 12);
    }

    public OngoingTaskItemHolderView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 0, 8);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.e == null) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public OngoingTaskItemHolderView(Context r17, AttributeSet r18, int r19, int r20, int r21) {
        ViewGroup r3 = null;
        if ((r21 & 2) == 0) goto L5;
        AttributeSet r2 = null;
    L7:
        if ((r21 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r21 & 8) == 0) goto L13;
        int r7 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r2, r4);
        this.a = r7;
        View r5 = LayoutInflater.from(r17).inflate(2131562971, this, false);
        addView(r5);
        int r6 = 2131380397;
        SimpleDraweeView r9 = ViewBindings.findChildViewById(r5, 2131380397);
        if (r9 == null) goto L45;
        r6 = 2131380398;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131380398);
        if (r10 == null) goto L45;
        r6 = 2131380400;
        View r11 = ViewBindings.findChildViewById(r5, 2131380400);
        if (r11 == null) goto L45;
        r6 = 2131380401;
        SimpleDraweeView r12 = ViewBindings.findChildViewById(r5, 2131380401);
        if (r12 == null) goto L45;
        r6 = 2131380402;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131380402);
        if (r13 == null) goto L45;
        r6 = 2131380403;
        LottieAdapterView r14 = ViewBindings.findChildViewById(r5, 2131380403);
        if (r14 == null) goto L45;
        FrameLayout r15 = (FrameLayout) r5;
        r6 = 2131380406;
        if (ViewBindings.findChildViewById(r5, 2131380406) == null) goto L45;
        this.b = new LarusMtmItemTaskOngoingBinding(r15, r9, r10, r11, r12, r13, r14, r15);
        jl9.b r8 = new jl9.b(r17, null);
        Iterator r1 = CollectionsKt.sortedWith(ServiceManager.get().getServices(ITaskUIFactory.class), new x()).iterator();
    L30:
        if (r1.hasNext() == false) goto L34;
        jl9.a r16 = ((ITaskUIFactory) r1.next()).P2(r8, this.a);
        if (r16 == null) goto L30;
        this.c = r16;
        this.d = r16.a(r8);
    L34:
        View r22 = this.d;
        if (r22 == null) goto L42;
        ViewParent r23 = r22.getParent();
        if ((r23 instanceof ViewGroup) == false) goto L39;
        r3 = (ViewGroup) r23;
    L39:
        if (r3 == null) goto L41;
        r3.removeView(r22);
    L41:
        this.b.c.addView(r22, new FrameLayout.LayoutParams(-1, -1));
    L42:
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        int r24 = v0.a;
        SimpleDraweeView r25 = this.b.b;
        Intrinsics.checkNotNullParameter(r25, "target");
        v0.a(r25, 8, 8, 8, 8);
        w0.e(this.b.f, c7.b(8));
        return;
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    L13:
        r7 = r20;
        goto L14
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
