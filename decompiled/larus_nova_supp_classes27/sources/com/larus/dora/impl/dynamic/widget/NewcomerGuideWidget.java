package com.larus.dora.impl.dynamic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraWidgetNewcomerGuideBinding;
import com.larus.platform.model.NewcomerGuideItem;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001b\u001a\u00020\u001aH\u0002J \u0010\u001c\u001a\u00020\u001a2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\u001aJ\u0010\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u0019J\u000e\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0016J\b\u00104\u001a\u00020\u001aH\u0014J\b\u00105\u001a\u00020\u001aH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraWidgetNewcomerGuideBinding;", "autoScrollJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "adapter", "Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter;", "currentGuides", "", "Lcom/larus/platform/model/NewcomerGuideItem;", "isUserInteracting", "", "onItemClickListener", "Lkotlin/Function2;", "", "", "setupInitialAvatar", "setOnItemClickListener", "listener", "setupRecyclerView", "calculateScrollProgress", "", "view", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setData", "guides", "refreshFocusState", "isAnyItemLoading", "smoothScrollToTop", "position", "startAutoScroll", "itemCount", "delayMs", "", "stopAutoScroll", "bindAvatar", "url", "setThinkingMode", "isThinking", "onAttachedToWindow", "onDetachedFromWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewcomerGuideWidget extends ConstraintLayout {
    public static final /* synthetic */ int h = 0;
    public final LarusDoraWidgetNewcomerGuideBinding a;
    public Job b;
    public final CoroutineScope c;
    public NewcomerGuideAdapter d;
    public List<NewcomerGuideItem> e;
    public boolean f;
    public Function2<? super NewcomerGuideItem, ? super String, Unit> g;

    public NewcomerGuideWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NewcomerGuideWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void R5(NewcomerGuideWidget r0) {
        setData$lambda$1(r0);
    }

    public final void S5() {
        Iterator r0 = ViewGroupKt.getChildren(this.a.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L30;
        View r1 = (View) r0.next();
        RecyclerView r2 = this.a.e;
        float r3 = Math.abs(r1.getTop());
        float r4 = r1.getHeight();
        boolean r5 = true;
        float r6 = 0.0f;
        if (r4 != 0.0f) goto L8;
        boolean r7 = true;
    L9:
        float r8 = 1.0f;
        if (r7 == true) goto L13;
        r6 = Math.max(0.0f, Math.min(1.0f, 1.0f - (r3 / r4)));
    L13:
        RecyclerView.ViewHolder r9 = this.a.e.getChildViewHolder(r1);
        if ((r9 instanceof NewcomerGuideAdapter.ViewHolder) == false) goto L16;
        NewcomerGuideAdapter.ViewHolder r10 = (NewcomerGuideAdapter.ViewHolder) r9;
    L17:
        if (r10 == null) goto L23;
        NewcomerGuideItem r11 = r10.b;
        if (r11 == null) goto L23;
        if (r11.isLoading() != true) goto L23;
    L24:
        if (r5 == true) goto L27;
        r8 = r6;
    L27:
        float r12 = (0.15f * r8) + 0.85f;
        r1.setScaleX(r12);
        r1.setScaleY(r12);
        r1.setAlpha((0.3f * r8) + 0.7f);
        if (r10 == null) goto L4;
        r10.T3(r8);
    L23:
        r5 = false;
        goto L24
    L16:
        r10 = null;
        goto L17
    L8:
        r7 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        boolean r1 = true;
        if ((!this.e.isEmpty()) == false) goto L13;
        Job r0 = this.b;
        if (r0 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == true) goto L14;
        U5(this.e.size(), 3000);
        return;
    L14:
        return;
    L7:
        if (r0.isActive() != true) goto L9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        Job r0 = this.b;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    private static final void setData$lambda$1(NewcomerGuideWidget r0) {
        r0.S5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(int r4) {
        LinearLayoutManager r0 = this.a.e.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
    L6:
        final Context r2 = getContext();
        LinearSmoothScroller r3 = new NewcomerGuideWidget$smoothScrollToTop$scroller$1(r2);
        r3.setTargetPosition(r4);
        if (r1 == null) goto L10;
        r1.startSmoothScroll(r3);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.dora.impl.dynamic.widget.l] */
    public final void setData(List<NewcomerGuideItem> r6) {
        Intrinsics.checkNotNullParameter(r6, "guides");
        boolean r1 = true;
        boolean r0 = !Intrinsics.areEqual(this.e, r6);
        this.e = r6;
        if (this.d != null) goto L11;
        NewcomerGuideAdapter r2 = new NewcomerGuideAdapter(new l(this));
        this.d = r2;
        this.a.e.setAdapter(r2);
        if (r6.size() < 2) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        this.a.e.scrollToPosition(r6.size() * 100);
        goto L11
    L10:
        this.a.e.scrollToPosition(0);
        goto L11
    L7:
        r3 = false;
    L11:
        NewcomerGuideAdapter r4 = this.d;
        if (r4 == null) goto L14;
        r4.submitList(r6, new m(this));
    L14:
        if (r0 == true) goto L22;
        Job r5 = this.b;
        if (r5 != null) goto L18;
    L20:
        r1 = false;
    L21:
        if (r1 == false) goto L22;
        return;
    L18:
        if (r5.isActive() != true) goto L20;
    L22:
        U5(r6.size(), 3000);
    }

    public final void setOnItemClickListener(Function2<? super NewcomerGuideItem, ? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.g = r2;
    }

    public final void setThinkingMode(boolean r5) {
        g49.d.a("NewcomerGuideWidget", "setThinkingMode: " + r5);
        LottieAdapterView r0 = this.a.d;
        int r1 = 0;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        ImageView r2 = this.a.c;
        if (r5 == true) goto L10;
        r1 = 8;
    L10:
        r2.setVisibility(r1);
        if (r5 == false) goto L14;
        this.a.d.setAnimation(2131820620);
        this.a.d.playAnimation();
        return;
    L14:
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void U5(int r9, long r10) {
        if (r9 >= 2) goto L5;
        return;
    L5:
        if (this.f == true) goto L13;
        g49.d.a("NewcomerGuideWidget", "startAutoScroll: itemCount=" + r9 + ", delayMs=" + r10);
        Job r11 = this.b;
        if (r11 == null) goto L10;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L10:
        this.b = BuildersKt.launch$default(this.c, null, null, new NewcomerGuideWidget$startAutoScroll$1(r10, this, null), 3, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewcomerGuideWidget(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        LayoutInflater.from(r7).inflate(2131562310, this);
        int r10 = 2131369398;
        CircleSimpleDraweeView r2 = (CircleSimpleDraweeView) ViewBindings.findChildViewById(this, 2131369398);
        if (r2 == null) goto L13;
        r10 = 2131369399;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(this, 2131369399);
        if (r3 == null) goto L13;
        r10 = 2131369400;
        LottieAdapterView r4 = ViewBindings.findChildViewById(this, 2131369400);
        if (r4 == null) goto L13;
        r10 = 2131374090;
        RecyclerView r11 = ViewBindings.findChildViewById(this, 2131374090);
        if (r11 == null) goto L13;
        this.a = new LarusDoraWidgetNewcomerGuideBinding(this, r2, r3, r4, r11);
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.e = CollectionsKt.emptyList();
        setBackgroundResource(2131103038);
        r11.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r11.setNestedScrollingEnabled(false);
        r11.addOnItemTouchListener(new NewcomerGuideWidget$setupRecyclerView$1());
        new NewcomerGuideWidget$setupRecyclerView$snapHelper$1(this).attachToRecyclerView(r11);
        r11.addOnScrollListener(new NewcomerGuideWidget$setupRecyclerView$2(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public /* synthetic */ NewcomerGuideWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
