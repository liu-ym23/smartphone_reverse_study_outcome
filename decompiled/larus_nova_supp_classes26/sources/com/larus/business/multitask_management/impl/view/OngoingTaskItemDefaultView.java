package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.viewbinding.ViewBindings;
import com.larus.business.multitask_management.impl.databinding.LarusMtmItemDefaultTemplateBinding;
import com.larus.common_ui.widget.CircleProgressBar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/business/multitask_management/impl/view/OngoingTaskItemDefaultView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmItemDefaultTemplateBinding;", "progressListener", "Lcom/larus/business/multitask_management/impl/view/TaskProgressListener;", "currentTaskId", "", "currentStrategy", "Lcom/larus/business/multitask_management/impl/view/TaskProgressBarUpdateStrategy;", "currentItem", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "cacheLoadedJob", "Lkotlinx/coroutines/Job;", "waitRefresh", "", "bind", "", "item", "onAttachedToWindow", "onDetachedFromWindow", "ensureListener", "taskId", "ensureCacheLoadedObserver", "refreshProgressFromCache", "detachListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OngoingTaskItemDefaultView extends ConstraintLayout {
    public final LarusMtmItemDefaultTemplateBinding a;
    public final t b;
    public String c;
    public c d;
    public kl9.u e;
    public Job f;
    public boolean g;

    public OngoingTaskItemDefaultView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OngoingTaskItemDefaultView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        if (((Boolean) TaskProgressMockCache.e.getValue()).booleanValue() == true) goto L5;
    L6:
        Job r0 = this.f;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L22;
        this.g = true;
        LifecycleOwner r2 = ViewTreeLifecycleOwner.get(this);
        if (r2 != null) goto L17;
        return;
    L17:
        Job r3 = this.f;
        if (r3 == null) goto L20;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L20:
        this.f = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), null, null, new OngoingTaskItemDefaultView$ensureCacheLoadedObserver$1(this, null), 3, null);
        return;
    L22:
        return;
    L9:
        if (r0.isActive() != true) goto L11;
        r1 = true;
        goto L12
    L5:
        if (this.g == true) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        Job r0 = this.f;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.f = null;
        c r1 = this.d;
        if (r1 == null) goto L8;
        r1.d(this.b);
    L8:
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        c r0 = this.d;
        if (r0 == null) goto L5;
        r0.a(this.b);
    L5:
        R5();
    }

    public final void S5(String r3) {
        if (Intrinsics.areEqual(this.c, r3) == false) goto L8;
        c r0 = this.d;
        if (r0 == null) goto L8;
        r0.a(this.b);
        return;
    L8:
        this.c = r3;
        Lazy r1 = TaskProgressMockCache.a;
        if (r3 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        c r4 = null;
    L27:
        this.d = r4;
        if (r4 == null) goto L36;
        r4.a(this.b);
        return;
    L36:
        return;
    L17:
        TaskProgressMockCache$map$1 r5 = TaskProgressMockCache.f;
        monitor-enter(r5);
        a0 r6 = (a0) r5.get(r3);     // Catch: Throwable -> L31
        if (r6 == null) goto L25;
        c r7 = r6.b;     // Catch: Throwable -> L31
        if (r7 == null) goto L25;
        r4 = r7;
    L26:
        monitor-exit(r5);
    L25:
        a0 r8 = new a0();     // Catch: Throwable -> L31
        r5.put(r3, r8);     // Catch: Throwable -> L31
        r4 = r8.b;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L11:
        if (r3.length() == 0) goto L14;
        r2 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.larus.business.multitask_management.impl.view.t] */
    public OngoingTaskItemDefaultView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        ConstraintLayout r11 = LayoutInflater.from(r8).inflate(2131562966, this, false);
        addView(r11);
        int r12 = 2131380399;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131380399);
        if (r2 == null) goto L15;
        ConstraintLayout r1 = r11;
        r12 = 2131380407;
        CircleProgressBar r3 = ViewBindings.findChildViewById(r11, 2131380407);
        if (r3 == null) goto L15;
        r12 = 2131380408;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, 2131380408);
        if (r4 == null) goto L15;
        r12 = 2131380409;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131380409);
        if (r5 == null) goto L15;
        r12 = 2131380411;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131380411);
        if (r6 == null) goto L15;
        this.a = new LarusMtmItemDefaultTemplateBinding(r1, r2, r3, r4, r5, r6);
        this.b = new t(this);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public /* synthetic */ OngoingTaskItemDefaultView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
