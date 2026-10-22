package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetMultiSelectorBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0016J&\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0017H\u0002J0\u0010#\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020%H\u0002J&\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u001e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010)\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\u0012H\u0014J\b\u00100\u001a\u00020\u0012H\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/MultiSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/MultiSelectorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/MultiSelectorController;", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetMultiSelectorBinding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetMultiSelectorBinding;", "widgetList", "", "bindPickPictureResult", "", "uri", "Landroid/net/Uri;", "adjustMargin", "widgetIndex", "", "init", "attrs", "Landroid/util/AttributeSet;", "onBindView", "bindMultiRowsView", "verticalLayout", "Landroid/widget/LinearLayout;", "controllers", "", "Lcom/larus/bmhome/instruction/base/AbsInstructionController;", "numRows", "bindMultiRowsViewInner", "report", "", "bindRowView", "rowLayout", "rowControllers", "isReportShowOnCreate", "onScrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "checkChildrenVisibilityRunnable", "Ljava/lang/Runnable;", "delayCheckChildrenVisibility", "onDetachedFromWindow", "checkChildrenVisibility", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiSelectorWidget extends AbsInstructionWidget {
    public static final /* synthetic */ int j = 0;
    public LarusLayoutActionBarEditorWidgetMultiSelectorBinding f;
    public final List<AbsInstructionWidget> g;
    public final r1 h;
    public final s1 i;

    public static final class a {
    }

    static {
    }

    public final LarusLayoutActionBarEditorWidgetMultiSelectorBinding getBinding() {
        LarusLayoutActionBarEditorWidgetMultiSelectorBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final void n6() {
        Iterator r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        AbsInstructionWidget r1 = (AbsInstructionWidget) r0.next();
        if ((r1 instanceof View) == false) goto L8;
        ?? r2 = r1;
    L9:
        if (r2 == 0) goto L4;
        Rect r3 = new Rect();
        if (r2.getGlobalVisibleRect(r3) == true) goto L14;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L4;
        r1.b6();
        goto L4
    L14:
        if (r3.width() != r2.getWidth()) goto L18;
        if (r3.height() != r2.getHeight()) goto L18;
        r4 = true;
        goto L19
    L8:
        r2 = 0;
        goto L9
    }

    private final xs8.j getController() {
        return (xs8.j) getController();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        com.larus.bmhome.actionbar.model.u r0 = getInstructionItem();
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L6:
        final List<up8.b> r2 = null;
        if (r1 == true) goto L9;
    L20:
        com.larus.bmhome.actionbar.model.u r3 = getInstructionItem();
        if (r3 == null) goto L23;
        boolean r4 = Intrinsics.areEqual(r3.g, Boolean.TRUE);
    L24:
        if (r4 == false) goto L31;
        ViewGroup.LayoutParams r5 = getBinding().d.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
    L29:
        if (r6 == null) goto L31;
        r6.topMargin = 0;
        getBinding().d.setLayoutParams(r6);
        goto L31
    L28:
        r6 = null;
    L31:
        com.larus.bmhome.actionbar.model.u r7 = getInstructionItem();
        if (r7 == null) goto L34;
        String r8 = r7.c;
    L36:
        if (com.larus.utils.o0.d(r8) == false) goto L42;
        AppCompatTextView r9 = getBinding().e;
        com.larus.bmhome.actionbar.model.u r10 = getInstructionItem();
        if (r10 == null) goto L40;
        String r11 = r10.c;
    L41:
        r9.setText(r11);
        com.larus.utils.e1.x(getBinding().e);
        goto L42
    L40:
        r11 = null;
    L42:
        final LinearLayout r12 = getBinding().c;
        xs8.j r13 = getController();
        if (r13 == null) goto L71;
        com.larus.bmhome.actionbar.model.b0 r14 = r13.l;
        if (r14 == null) goto L71;
        r12.removeAllViews();
        ((ArrayList) this.g).clear();
        Integer r15 = r14.b;
        if (r15 != null) goto L49;
    L65:
        r12.setOrientation(0);
        xs8.j r16 = getController();
        if (r16 == null) goto L68;
        r2 = r16.f();
    L68:
        if (r2 != null) goto L70;
        r2 = CollectionsKt.emptyList();
    L70:
        k6(r12, r2, true);
        goto L71
    L49:
        if (r15.intValue() <= 1) goto L65;
        r12.setOrientation(1);
        xs8.j r17 = getController();
        if (r17 == null) goto L53;
        r2 = r17.f();
    L53:
        if (r2 != null) goto L55;
        r2 = CollectionsKt.emptyList();
    L55:
        final int r18 = r15.intValue();
        if (r2.isEmpty() == true) goto L71;
        if (r18 <= 0) goto L71;
        int r19 = r18 * 2;
        if (com.larus.platform.service.e2.a.isPad() == false) goto L62;
    L64:
        i6(r12, r2, r18, true);
        goto L71
    L62:
        if (r2.size() <= r19) goto L64;
        i6(r12, r2.subList(0, r19), r18, false);
        postDelayed(new q1(r12, this, r2, r18), 30);
    L71:
        com.larus.bmhome.view.actionbar.edit.c r20 = getViewModel();
        if (r20 == null) goto L75;
        r20.onComponentVisibilityChanged(this, true);
        return;
    L75:
        return;
    L34:
        r8 = null;
        goto L36
    L23:
        r4 = false;
        goto L24
    L9:
        if (com.larus.platform.service.z2.a.getImageInspireConfig().a() == true) goto L11;
    L19:
        com.larus.utils.e1.x(getBinding().b);
        goto L20
    L11:
        if ((getFragment() instanceof ny9.g) == false) goto L19;
        List r21 = CollectionsKt.listOf(new Integer[]{4, 16});
        com.larus.bmhome.view.actionbar.edit.c r22 = getViewModel();
        if (r22 == null) goto L15;
        Integer r23 = r22.getInstructionType();
    L17:
        if (CollectionsKt.contains(r21, r23) == false) goto L19;
        com.larus.utils.e1.o(getBinding().b);
        goto L20
    L15:
        r23 = null;
        goto L17
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getBinding().d.getViewTreeObserver().removeOnScrollChangedListener(this.h);
        removeCallbacks(this.i);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.bmhome.view.actionbar.edit.component.r1] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.bmhome.view.actionbar.edit.component.s1] */
    public MultiSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.g = new ArrayList();
        this.h = new r1(this);
        this.i = new s1(this);
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void S5(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AbsInstructionWidget) r0.next()).S5(r3);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetMultiSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k6(LinearLayout r9, List<? extends up8.b> r10, boolean r11) {
        Iterator<T> r0 = r10.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L29;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        up8.b r4 = (up8.b) r2;
        r4.p(r11);
        ConstraintLayout r5 = r4.d(getContext(), getFragment());
        if (r1 != 0) goto L17;
        int r6 = r4.i();
        if (r6 != 2) goto L13;
    L15:
        r9.addView(r5);
    L28:
        ((ArrayList) this.g).add(r5);
        r1 = r3;
        goto L4
    L13:
        if (r6 == 7) goto L15;
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.setMarginStart(i5.h());
        Unit r8 = Unit.INSTANCE;
        r9.addView(r5, r7);
        goto L28
    L17:
        if (r1 != (r10.size() - 1)) goto L23;
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-2, -2);
        if (r4.i() != 2) goto L21;
        int r13 = -i5.N();
    L22:
        r12.setMarginStart(r13);
        r12.setMarginEnd(i5.h());
        Unit r14 = Unit.INSTANCE;
        r9.addView(r5, r12);
        goto L28
    L21:
        r13 = i5.r0();
        goto L22
    L23:
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -2);
        if (r4.i() != 2) goto L26;
        int r16 = -i5.N();
    L27:
        r15.setMarginStart(r16);
        Unit r17 = Unit.INSTANCE;
        r9.addView(r5, r15);
        goto L28
    L26:
        r16 = i5.r0();
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i6(LinearLayout r7, List<? extends up8.b> r8, int r9, boolean r10) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
        int r2 = 0;
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r3 = r11.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        up8.b r5 = (up8.b) r3;
        int r6 = r2 % r9;
        if (r0.size() > r6) goto L11;
        r0.add(new ArrayList());
    L11:
        ((ArrayList) ListProtector.get(r0, r6)).add(r5);
        r2 = r4;
        goto L4
    L12:
        Iterator r12 = r0.iterator();
        int r13 = 0;
    L14:
        if (r12.hasNext() == false) goto L29;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        ArrayList r16 = (ArrayList) r14;
        if ((!r16.isEmpty()) == false) goto L28;
        LinearLayout r17 = new LinearLayout(getContext());
        r17.setOrientation(0);
        r7.addView(r17);
        if (r13 >= (r0.size() - 1)) goto L27;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L26;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r19.bottomMargin = i5.h();
        r17.setLayoutParams(r19);
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L27:
        k6(r17, r16, false);
    L28:
        r13 = r15;
        goto L14
    L29:
        if (r10 == false) goto L39;
        getBinding().d.getViewTreeObserver().addOnScrollChangedListener(this.h);
        postDelayed(this.i, 100);
        return;
    }
}
