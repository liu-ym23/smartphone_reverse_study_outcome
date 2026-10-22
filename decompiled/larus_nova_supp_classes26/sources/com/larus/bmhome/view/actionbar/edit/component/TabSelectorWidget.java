package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTabSelectorBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010!\u001a\u00020\u0018H\u0016R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/TabSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTabSelectorBinding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTabSelectorBinding;", "tabList", "Ljava/util/ArrayList;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lkotlin/collections/ArrayList;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/TabSelectorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/TabSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarSwitchTabSelectorTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarSwitchTabSelectorTemplate;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "collectStarted", "", "onBindView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabSelectorWidget extends AbsInstructionWidget {
    public static final /* synthetic */ int i = 0;
    public LarusLayoutActionBarEditorWidgetTabSelectorBinding f;
    public final ArrayList<TabLayout.Tab> g;
    public boolean h;

    public final LarusLayoutActionBarEditorWidgetTabSelectorBinding getBinding() {
        LarusLayoutActionBarEditorWidgetTabSelectorBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final xs8.n getController() {
        return (xs8.n) getController();
    }

    private final com.larus.bmhome.actionbar.model.i0 getCurrentBindData() {
        xs8.n r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        com.larus.bmhome.actionbar.model.u r0 = getInstructionItem();
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L6:
        if (r1 == false) goto L8;
        com.larus.utils.e1.x(getBinding().b);
    L8:
        com.larus.bmhome.actionbar.model.u r2 = getInstructionItem();
        if (r2 == null) goto L11;
        String r3 = r2.c;
    L13:
        if (com.larus.utils.o0.d(r3) == false) goto L19;
        AppCompatTextView r4 = getBinding().c;
        com.larus.bmhome.actionbar.model.u r5 = getInstructionItem();
        if (r5 == null) goto L17;
        String r6 = r5.c;
    L18:
        r4.setText(r6);
        com.larus.utils.e1.x(getBinding().c);
        goto L19
    L17:
        r6 = null;
    L19:
        getBinding().d.addOnTabSelectedListener(new o2(this));
        this.g.clear();
        com.larus.bmhome.actionbar.model.i0 r7 = getCurrentBindData();
        if (r7 == null) goto L33;
        List r8 = r7.a;
        if (r8 == null) goto L33;
        Iterator r9 = r8.iterator();
    L25:
        if (r9.hasNext() == false) goto L33;
        com.larus.bmhome.actionbar.model.w r10 = (com.larus.bmhome.actionbar.model.w) r9.next();
        TabLayout.Tab r11 = getBinding().d.newTab();
        r11.setText(r10.b);
        r11.setTag(r10.a);
        this.g.add(r11);
        getBinding().d.addTab(r11);
        getBinding().d.setElevation(1.0f);
        Integer r12 = r10.s;
        if (r12 == null) goto L25;
        if (r12.intValue() != 1) goto L25;
        r11.select();
    L33:
        if (this.h == true) goto L46;
        CoroutineScope r13 = getComponentScope();
        if (r13 == null) goto L37;
        BuildersKt.launch$default(r13, null, null, new TabSelectorWidget$onBindView$3(this, null), 3, null);
    L37:
        this.h = true;
        return;
    L46:
        return;
    L11:
        r3 = null;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public TabSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.g = new ArrayList();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.i0 i6(TabSelectorWidget r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetTabSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(i5.h0(), 1073741824));
    }
}
