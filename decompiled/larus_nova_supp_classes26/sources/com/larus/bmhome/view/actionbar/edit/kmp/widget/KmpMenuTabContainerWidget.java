package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import bt8.b0;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.b;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.kmp.o;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import cq8.f0;
import cq8.g0;
import cq8.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001$B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u001dH\u0014J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010 \u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpMenuTabContainerWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "childContainer", "Landroid/widget/LinearLayout;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/MenuTabContainerDescriptor;", "tabListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "widgetList", "", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "bindInstructionViewModel", "", "viewModel", "init", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "renderTabs", "renderChildren", "childWidgetEntry", "", "Lcom/larus/bmhome/instruction/core/model/widget/WidgetEntry;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMenuTabContainerWidget extends AbsKmpInstructionWidget implements b {
    public TabLayout f;
    public LinearLayout g;
    public f0 h;
    public b0 i;
    public final List<AbsKmpInstructionWidget> j;
    public c k;

    public static final class a {
    }

    static {
    }

    public KmpMenuTabContainerWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpMenuTabContainerWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(c r4) {
        this.k = r4;
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ConstraintLayout r1 = (AbsKmpInstructionWidget) r0.next();
        if ((r1 instanceof b) == false) goto L8;
        b r2 = (b) r1;
    L9:
        if (r2 == null) goto L4;
        r2.L4(r4);
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if ((r2 instanceof f0) == true) goto L5;
        r2 = null;
    L5:
        f0 r3 = (f0) r2;
        if (r3 == null) goto L10;
        V5(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View, com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget, java.lang.Object] */
    public final void V5(f0 r9) {
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        this.h = r9;
        FLogger.a.i("KmpMenuTabContainerWidget", "[bind] tabs:" + r9.f.size() + ", childWidgetEntry:" + r9.i.size());
        b0 r0 = this.i;
        LinearLayout r1 = null;
        if (r0 == null) goto L8;
        TabLayout r3 = this.f;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r3 = null;
    L7:
        r3.removeOnTabSelectedListener(r0);
    L8:
        TabLayout r2 = this.f;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r2 = null;
    L11:
        r2.removeAllTabs();
        Iterator<T> r4 = r9.f.iterator();
    L13:
        if (r4.hasNext() == false) goto L21;
        g0 r5 = (g0) r4.next();
        TabLayout r6 = this.f;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r6 = null;
    L17:
        TabLayout.Tab r7 = r6.newTab();
        r7.setText(r5.b);
        r7.setTag(Long.valueOf(r5.a));
        TabLayout r8 = this.f;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r8 = null;
    L20:
        r8.addTab(r7);
        goto L13
    L21:
        b0 r10 = new b0(this);
        this.i = r10;
        TabLayout r11 = this.f;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r11 = null;
    L24:
        r11.addOnTabSelectedListener(r10);
        Iterator<g0> r12 = r9.f.iterator();
        int r13 = 0;
    L26:
        if (r12.hasNext() == false) goto L31;
        if (r12.next().c == true) goto L32;
        r13 = r13 + 1;
    L32:
        if (r13 < 0) goto L39;
        TabLayout r14 = this.f;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r14 = null;
    L36:
        TabLayout.Tab r15 = r14.getTabAt(r13);
        if (r15 == null) goto L39;
        r15.select();
    L39:
        List r16 = CollectionsKt.filterNotNull(r9.i);
        LinearLayout r17 = this.g;
        if (r17 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
        r17 = null;
    L42:
        r17.removeAllViews();
        Iterator r18 = ((ArrayList) this.j).iterator();
    L44:
        if (r18.hasNext() == false) goto L49;
        AbsKmpInstructionWidget r19 = (AbsKmpInstructionWidget) r18.next();
        Job r20 = r19.a;
        if (r20 == null) goto L48;
        Job.DefaultImpls.cancel$default(r20, null, 1, null);
    L48:
        r19.a = null;
        r19.b = null;
        goto L44
    L49:
        ((ArrayList) this.j).clear();
        if (r16.isEmpty() == false) goto L56;
        LinearLayout r21 = this.g;
        if (r21 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
    L55:
        r1.setVisibility(8);
        return;
    L54:
        r1 = r21;
        goto L55
    L56:
        LinearLayout r22 = this.g;
        if (r22 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
        r22 = null;
    L59:
        r22.setVisibility(0);
        t1a.b r23 = getVContext();
        if (r23 == null) goto L92;
        Iterator r24 = r16.iterator();
    L64:
        if (r24.hasNext() == false) goto L93;
        y0 r25 = (y0) r24.next();
        a0 r26 = (a0) r25.c.getValue();
        if (r26 == null) goto L64;
        o r27 = o.a;
        Context r28 = getContext();
        r27.getClass();
        ?? r29 = o.a(r28, r26);
        if ((r29 instanceof b) == false) goto L71;
        b r30 = (b) r29;
    L72:
        if (r30 == null) goto L74;
        r30.L4(this.k);
    L74:
        r29.U5(r23, getFragment(), r25.c, r25.b);
        ((ArrayList) this.j).add(r29);
        LinearLayout r31 = this.g;
        LinearLayout r32 = r31;
        if (r31 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
        r32 = 0;
    L77:
        r32.addView(r29, new LinearLayout.LayoutParams(-1, -2));
        goto L64
    L71:
        r30 = null;
        goto L72
    L93:
        return;
    L92:
        return;
    L31:
        r13 = -1;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        LinearLayout r8 = new LinearLayout(r6);
        r8.setOrientation(1);
        r8.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        TabLayout r1 = new TabLayout(r6);
        r1.setTabMode(0);
        r1.setElevation(1.0f);
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f = r1;
        LinearLayout r2 = new LinearLayout(r6);
        r2.setOrientation(1);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.g = r2;
        View r9 = this.f;
        LinearLayout r0 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r9 = null;
    L5:
        r8.addView(r9);
        LinearLayout r10 = this.g;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("childContainer");
    L9:
        r8.addView(r0);
        addView(r8);
        return;
    L8:
        r0 = r10;
        goto L9
    }

    public KmpMenuTabContainerWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = new ArrayList();
    }

    public /* synthetic */ KmpMenuTabContainerWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
