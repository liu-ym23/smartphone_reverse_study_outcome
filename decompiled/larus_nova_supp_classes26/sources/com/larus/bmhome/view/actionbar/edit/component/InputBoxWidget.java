package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetInputboxBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/InputBoxWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetInputboxBinding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetInputboxBinding;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/InputBoxController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/InputBoxController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarInputBoxTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarInputBoxTemplate;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "refreshUI", "inputBoxTemplate", "requestInputBoxFocus", "clearInputFocus", "onViewShow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputBoxWidget extends AbsInstructionWidget {
    public LarusLayoutActionBarEditorWidgetInputboxBinding f;
    public com.larus.bmhome.utils.x1 g;

    public static final class a implements TextWatcher {
        public final /* synthetic */ InputBoxWidget a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(InputBoxWidget r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            String r5 = StringsKt.trim(String.valueOf(r4)).toString();
            FLogger.a.i("InputBoxWidget", "input content: " + r5);
            xs8.i r0 = InputBoxWidget.i6(this.a);
            if (r0 == null) goto L5;
            r0.m = r5;
        L5:
            com.larus.bmhome.actionbar.model.p r1 = InputBoxWidget.k6(this.a);
            if (r1 == null) goto L10;
            com.larus.bmhome.actionbar.model.h1 r2 = r1.a;
            if (r2 == null) goto L10;
            r2.b = r5;
        L10:
            com.larus.bmhome.view.actionbar.edit.c r3 = this.a.getViewModel();
            if (r3 == null) goto L14;
            r3.onInputBoxTextChanged(r5);
            return;
        }
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Z5() {
        com.larus.bmhome.utils.x1 r0 = this.g;
        if (r0 == null) goto L5;
        com.larus.bmhome.utils.x1.d(r0, 3);
    L5:
        getBinding().c.requestFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void c6() {
        post(new o1(this));
    }

    public final LarusLayoutActionBarEditorWidgetInputboxBinding getBinding() {
        LarusLayoutActionBarEditorWidgetInputboxBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final xs8.i getController() {
        return (xs8.i) getController();
    }

    private final com.larus.bmhome.actionbar.model.p getCurrentBindData() {
        xs8.i r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void U5() {
        if (getBinding().c.isFocused() == false) goto L6;
        getBinding().c.clearFocus();
        return;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        com.larus.bmhome.actionbar.model.p r0 = getCurrentBindData();
        if (r0 == null) goto L34;
        com.larus.bmhome.actionbar.model.u r1 = getInstructionItem();
        if (r1 == null) goto L7;
        boolean r2 = Intrinsics.areEqual(r1.f, Boolean.TRUE);
    L8:
        if (r2 == false) goto L10;
        com.larus.utils.e1.x(getBinding().b);
    L10:
        com.larus.bmhome.actionbar.model.u r3 = getInstructionItem();
        String r4 = null;
        if (r3 == null) goto L13;
        String r5 = r3.c;
    L15:
        if (com.larus.utils.o0.d(r5) == false) goto L20;
        AppCompatTextView r6 = getBinding().d;
        com.larus.bmhome.actionbar.model.u r7 = getInstructionItem();
        if (r7 == null) goto L19;
        r4 = r7.c;
    L19:
        r6.setText(r4);
        com.larus.utils.e1.x(getBinding().d);
    L20:
        AppCompatEditText r8 = getBinding().c;
        com.larus.bmhome.actionbar.model.h1 r9 = r0.a;
        String r10 = "";
        if (r9 == null) goto L25;
        String r11 = r9.a;
        if (r11 == null) goto L25;
    L26:
        r8.setHint(r11);
        AppCompatEditText r12 = getBinding().c;
        com.larus.bmhome.actionbar.model.h1 r13 = r0.a;
        if (r13 == null) goto L32;
        String r14 = r13.b;
        if (r14 == null) goto L32;
        r10 = r14;
    L32:
        r12.setText(r10);
        return;
    L25:
        r11 = "";
        goto L26
    L13:
        r5 = null;
        goto L15
    L7:
        r2 = false;
        goto L8
    }

    public InputBoxWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    public static final /* synthetic */ xs8.i i6(InputBoxWidget r0) {
        return r0.getController();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.p k6(InputBoxWidget r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        LayoutInflater.from(r3).inflate(2131562720, this);
        int r5 = 2131364451;
        View r6 = ViewBindings.findChildViewById(this, 2131364451);
        if (r6 == null) goto L11;
        r5 = 2131375344;
        AppCompatEditText r0 = ViewBindings.findChildViewById(this, 2131375344);
        if (r0 == null) goto L11;
        r5 = 2131375345;
        AppCompatTextView r1 = ViewBindings.findChildViewById(this, 2131375345);
        if (r1 == null) goto L11;
        this.f = new LarusLayoutActionBarEditorWidgetInputboxBinding(this, r6, r0, r1);
        getBinding().c.addTextChangedListener(new a(this));
        this.g = new com.larus.bmhome.utils.x1(getBinding().c);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }
}
