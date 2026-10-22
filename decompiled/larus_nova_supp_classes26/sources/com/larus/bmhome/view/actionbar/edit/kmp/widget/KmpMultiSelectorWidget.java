package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.b;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.bmhome.view.actionbar.edit.kmp.o;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetMultiSelectorBinding;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import cq8.l0;
import cq8.p;
import cq8.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ny9.g;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 ,2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001,B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u001aJ&\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\tH\u0002J\u001e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J \u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpMultiSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetMultiSelectorBinding;", "widgetList", "", "hostViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "bindInstructionViewModel", "", "viewModel", "init", "onDescriptorChanged", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "Lcom/larus/bmhome/instruction/core/model/widget/MultiSelectorDescriptor;", "bindMultiRowsView", "verticalLayout", "Landroid/widget/LinearLayout;", "childDescriptors", "", "Lcom/larus/bmhome/instruction/core/model/widget/WidgetEntry;", "rowCount", "bindRowView", "rowLayout", "rowDescriptors", "buildLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "index", "rowSize", "isFlushStartDescriptor", "", "getMiddleMarginStart", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMultiSelectorWidget extends AbsKmpInstructionWidget implements b {
    public LarusLayoutActionBarEditorWidgetMultiSelectorBinding f;
    public final List<AbsKmpInstructionWidget> g;
    public c h;

    public static final class a {
    }

    static {
    }

    public KmpMultiSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpMultiSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(c r4) {
        this.h = r4;
        Iterator<T> r0 = this.g.iterator();
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r11) {
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r2 = null;
        if ((r11 instanceof l0) == true) goto L5;
        r11 = null;
    L5:
        l0 r12 = (l0) r11;
        if (r12 == null) goto L92;
        Intrinsics.checkNotNullParameter(r12, "descriptor");
        List r0 = CollectionsKt.filterNotNull(r12.k);
        b0 r1 = r12.i;
        if (r1 == null) goto L13;
        Integer r3 = r1.b;
        if (r3 == null) goto L13;
        int r4 = r3.intValue();
    L14:
        FLogger.a.i("KmpMultiSelectorWidget", "[bind] childWidgetEntry.size:" + r0.size() + ", rowCount:" + r4);
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r5 = this.f;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        r5.c.removeAllViews();
        ((ArrayList) this.g).clear();
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r6 = this.f;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L20:
        int r7 = 8;
        r6.e.setVisibility(8);
        if (r12.h == false) goto L35;
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r8 = this.f;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L25:
        View r9 = r8.b;
        if (z2.a.getImageInspireConfig().a() == true) goto L28;
    L32:
        r7 = 0;
    L33:
        r9.setVisibility(r7);
        goto L35
    L28:
        if ((getFragment() instanceof g) == false) goto L32;
        if (CollectionsKt.listOf(new Integer[]{4, 16}).contains(Integer.valueOf(r12.j)) == false) goto L32;
    L35:
        if (r0.isEmpty() == true) goto L93;
        if (r4 <= 1) goto L75;
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r13 = this.f;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L41:
        r13.c.setOrientation(1);
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r14 = this.f;
        if (r14 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L45:
        LinearLayout r15 = r2.c;
        if (r4 <= 0) goto L94;
        ArrayList r10 = new ArrayList(r4);
        int r16 = 0;
    L49:
        if (r16 >= r4) goto L51;
        r10.add(new ArrayList());
        r16 = r16 + 1;
        goto L49
    L51:
        Iterator r17 = r0.iterator();
        int r18 = 0;
    L53:
        if (r17.hasNext() == false) goto L58;
        Object r19 = r17.next();
        int r20 = r18 + 1;
        if (r18 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        ((List) ListProtector.get(r10, r18 % r4)).add((y0) r19);
        r18 = r20;
        goto L53
    L58:
        Iterator r21 = r10.iterator();
        int r22 = 0;
    L60:
        if (r21.hasNext() == false) goto L95;
        Object r23 = r21.next();
        int r24 = r22 + 1;
        if (r22 >= 0) goto L64;
        CollectionsKt.throwIndexOverflow();
    L64:
        List r25 = (List) r23;
        if (r25.isEmpty() == true) goto L74;
        LinearLayout r26 = new LinearLayout(getContext());
        r26.setOrientation(0);
        r15.addView(r26);
        if (r22 >= CollectionsKt.getLastIndex(r10)) goto L73;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L72;
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        r28.bottomMargin = i5.h();
        r26.setLayoutParams(r28);
        goto L73
    L72:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L73:
        V5(r26, r25);
    L74:
        r22 = r24;
        goto L60
    L95:
        return;
    L94:
        return;
    L44:
        r2 = r14;
        goto L45
    L75:
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r110 = this.f;
        if (r110 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L78:
        r110.c.setOrientation(0);
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r111 = this.f;
        if (r111 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L82:
        V5(r2.c, r0);
        return;
    L81:
        r2 = r111;
        goto L82
    L93:
        return;
    L13:
        r4 = 1;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetMultiSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget, java.lang.Object] */
    public final void V5(LinearLayout r10, List<y0> r11) {
        Iterator<T> r0 = r11.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L39;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        y0 r4 = (y0) r2;
        a0 r5 = (a0) r4.c.getValue();
        if (r5 == null) goto L38;
        FLogger.a.i("KmpMultiSelectorWidget", "[bindRowView] index:" + r1 + ", descriptor:" + Reflection.getOrCreateKotlinClass(r5.getClass()).getSimpleName());
        o r6 = o.a;
        Context r7 = getContext();
        r6.getClass();
        ?? r8 = o.a(r7, r5);
        t1a.b r9 = getVContext();
        if (r9 == null) goto L38;
        if ((r8 instanceof b) == false) goto L17;
        b r12 = (b) r8;
    L18:
        if (r12 == null) goto L20;
        r12.L4(this.h);
    L20:
        r8.U5(r9, getFragment(), r4.c, r4.b);
        ((ArrayList) this.g).add(r8);
        int r13 = r11.size();
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        if (r1 != 0) goto L26;
        if ((r5 instanceof p) == true) goto L37;
        r14.setMarginStart(i5.h());
    L37:
        r10.addView(r8, r14);
        goto L38
    L26:
        if (r1 != (r13 - 1)) goto L33;
        if ((r5 instanceof p) == false) goto L30;
        int r15 = -i5.N();
    L31:
        r14.setMarginStart(r15);
        r14.setMarginEnd(i5.h());
        goto L37
    L30:
        r15 = i5.r0();
        goto L31
    L33:
        if ((r5 instanceof p) == false) goto L35;
        int r16 = -i5.N();
    L36:
        r14.setMarginStart(r16);
        goto L37
    L35:
        r16 = i5.r0();
        goto L36
    L17:
        r12 = null;
    L38:
        r1 = r3;
        goto L4
    }

    public KmpMultiSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = new ArrayList();
    }

    public /* synthetic */ KmpMultiSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
