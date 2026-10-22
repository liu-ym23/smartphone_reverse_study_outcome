package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import bt8.j0;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTabSelectorBinding;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import cq8.r0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00060\u0001j\u0002`\u0002:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0014J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTabSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTabSelectorBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/TabSelectorDescriptor;", "tabListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "bind", "renderSubTitle", "renderBottomDivider", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpTabSelectorWidget extends AbsKmpInstructionWidget {
    public LarusLayoutActionBarEditorWidgetTabSelectorBinding f;
    public r0 g;
    public j0 h;

    public static final class a {
    }

    static {
    }

    public KmpTabSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpTabSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r9) {
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        FLogger.a.i("KmpTabSelectorWidget", "[onDescriptorChanged] descriptor:" + r9);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r2 = null;
        if ((r9 instanceof r0) == true) goto L5;
        r9 = null;
    L5:
        r0 r10 = (r0) r9;
        if (r10 == null) goto L99;
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        this.g = r10;
        i0 r0 = r10.f;
        if (r0 == null) goto L11;
        List r1 = r0.a;
    L12:
        if (r1 != null) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        j0 r3 = this.h;
        if (r3 == null) goto L20;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r4 = this.f;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L19:
        r4.d.removeOnTabSelectedListener(r3);
    L20:
        String r5 = r10.g;
        if (r5 != null) goto L23;
    L25:
        r5 = null;
    L26:
        int r6 = 8;
        if (r5 != null) goto L32;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r7 = this.f;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L31:
        r7.c.setVisibility(8);
    L39:
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r8 = this.f;
        if (r8 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L42:
        View r11 = r8.b;
        if (r10.h == false) goto L45;
        r6 = 0;
    L45:
        r11.setVisibility(r6);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r12 = this.f;
        if (r12 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L48:
        r12.d.removeAllTabs();
        Iterator r13 = r1.iterator();
    L50:
        if (r13.hasNext() == false) goto L58;
        w r14 = (w) r13.next();
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r15 = this.f;
        if (r15 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L54:
        TabLayout.Tab r16 = r15.d.newTab();
        r16.setText(r14.b);
        r16.setTag(r14.a);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r17 = this.f;
        if (r17 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L57:
        r17.d.addTab(r16, false);
        goto L50
    L58:
        j0 r18 = new j0(this);
        this.h = r18;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r19 = this.f;
        if (r19 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L61:
        r19.d.addOnTabSelectedListener(r18);
        Iterator r20 = r1.iterator();
        int r21 = 0;
    L63:
        if (r20.hasNext() == false) goto L74;
        Integer r22 = ((w) r20.next()).s;
        if (r22 != null) goto L68;
    L70:
        boolean r23 = false;
    L71:
        if (r23 == true) goto L75;
        r21 = r21 + 1;
    L75:
        if (r21 < 0) goto L83;
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r24 = this.f;
        if (r24 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L80:
        TabLayout.Tab r25 = r2.d.getTabAt(r21);
        if (r25 == null) goto L96;
        r25.select();
        return;
    L96:
        return;
    L79:
        r2 = r24;
        goto L80
    L83:
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r26 = this.f;
        if (r26 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L87:
        TabLayout.Tab r27 = r2.d.getTabAt(0);
        if (r27 == null) goto L98;
        r27.select();
        return;
    L98:
        return;
    L86:
        r2 = r26;
        goto L87
    L68:
        if (r22.intValue() != 1) goto L70;
        r23 = true;
        goto L71
    L74:
        r21 = -1;
        goto L75
    L32:
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r28 = this.f;
        if (r28 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L35:
        r28.c.setText(r5);
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r29 = this.f;
        if (r29 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L38:
        r29.c.setVisibility(0);
        goto L39
    L23:
        if ((!StringsKt.isBlank(r5)) == false) goto L25;
    L11:
        r1 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r3 = LarusLayoutActionBarEditorWidgetTabSelectorBinding.a(LayoutInflater.from(r1), this);
        this.f = r3;
        r3.d.setElevation(1.0f);
    }

    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(i5.h0(), 1073741824));
    }

    public KmpTabSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ KmpTabSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
