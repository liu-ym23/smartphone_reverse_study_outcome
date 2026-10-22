package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetDropdownSelectorBinding;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\"H\u0016J\b\u0010*\u001a\u00020\"H\u0002J?\u0010+\u001a\u00020\"2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020&H\u0002¢\u0006\u0002\u00104J&\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\n\u00106\u001a\u000607j\u0002`82\b\b\u0002\u00109\u001a\u00020)H\u0002J(\u0010:\u001a\u00020\"2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/DropdownListSelectorWidgetV2;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetDropdownSelectorBinding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetDropdownSelectorBinding;", "adapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidgetAdapterV2;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/DropdownListSelectorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/DropdownListSelectorController;", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBoxSelectorTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBoxSelectorTemplate;", "allDropdownBoxList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "getAllDropdownBoxList", "()Ljava/util/List;", "itemSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/DropdownListSelectorWidgetV2$itemSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownListSelectorWidgetV2$itemSelectedCallback$1;", "init", "", "attrs", "Landroid/util/AttributeSet;", "resolveCreationSubscriptionEnterMethod", "", "onBindView", "collectStarted", "", "observeDataChange", "selectItemInternal", "selectedDropdownId", "", "option", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "dropdownBox", "optionIndex", "bindingAdapterPosition", "optionSource", "(Ljava/lang/Integer;Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;IILjava/lang/String;)V", "filterOptionsWithFilterConf", "filterConf", "Lcom/larus/bmhome/actionbar/model/ParamFilterConf;", "Lcom/larus/bmhome/view/actionbar/custom/bean/ParamFilterConf;", "isDefault", "syncStatus", "allDropdownBox", "currentShowDropdownBox", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownListSelectorWidgetV2 extends AbsInstructionWidget {
    public static final /* synthetic */ int j = 0;
    public LarusLayoutActionBarEditorWidgetDropdownSelectorBinding f;
    public DropdownSelectorWidgetAdapterV2 g;
    public final a h;
    public boolean i;

    public static final class a implements b1 {
        public final /* synthetic */ DropdownListSelectorWidgetV2 a;
        public final /* synthetic */ Context b;

        public a(DropdownListSelectorWidgetV2 r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r2, com.larus.bmhome.actionbar.model.w r3) {
            Intrinsics.checkNotNullParameter(r3, "selectedSpinnerItem");
            k0 r4 = j0.a(r3, r2, DropdownListSelectorWidgetV2.n6(this.a));
            if (r4 == null) goto L8;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            ICommerceMembershipService.a.getClass();
            ICommerceMembershipService r5 = ICommerceMembershipService.a.a();
            if (r5 == null) goto L9;
            r5.s(r4.c, null);
            return;
        L9:
            return;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r19, com.larus.bmhome.actionbar.model.w r20, int r21) {
            Intrinsics.checkNotNullParameter(r20, "selectedSpinnerItem");
            xs8.f r2 = DropdownListSelectorWidgetV2.i6(this.a);
            int r3 = 0;
            if (r2 == null) goto L5;
            r2.o = false;
        L5:
            com.larus.bmhome.actionbar.model.i r4 = DropdownListSelectorWidgetV2.k6(this.a);
            if (r4 == null) goto L36;
            List r5 = r4.a;
            if (r5 == null) goto L36;
            DropdownListSelectorWidgetV2 r11 = this.a;
            Iterator r6 = r5.iterator();
            int r7 = 0;
            int r12 = 0;
        L11:
            if (r6.hasNext() == false) goto L35;
            Object r8 = r6.next();
            int r13 = r12 + 1;
            if (r12 >= 0) goto L15;
            CollectionsKt.throwIndexOverflow();
        L15:
            com.larus.bmhome.actionbar.model.h r14 = (com.larus.bmhome.actionbar.model.h) r8;
            Integer r9 = r14.b;
            if (r9 != null) goto L19;
        L34:
            r12 = r13;
            goto L11
        L19:
            if (r9.intValue() != r19) goto L34;
            List r10 = r14.e;
            if (r10 == null) goto L33;
            Iterator r16 = r10.iterator();
            int r15 = 0;
        L24:
            if (r16.hasNext() == false) goto L33;
            Object r17 = r16.next();
            int r18 = r15 + 1;
            if (r15 >= 0) goto L28;
            CollectionsKt.throwIndexOverflow();
        L28:
            com.larus.bmhome.actionbar.model.w r22 = (com.larus.bmhome.actionbar.model.w) r17;
            if (Intrinsics.areEqual(r22.a, r20.a) == false) goto L31;
            DropdownListSelectorWidgetV2.o6(r11, Integer.valueOf(r19), r22, r14, r15, r21, "original");
        L32:
            r15 = r18;
            goto L24
        L31:
            r22.s = 0;
        L33:
            r7 = r12;
            goto L34
        L35:
            r3 = r7;
        L36:
            xs8.f r1 = DropdownListSelectorWidgetV2.i6(this.a);
            List r23 = null;
            if (r1 == null) goto L41;
            com.larus.bmhome.actionbar.model.i r24 = r1.l;
            if (r24 == null) goto L41;
            com.larus.bmhome.actionbar.model.i r25 = new com.larus.bmhome.actionbar.model.i(r24.a);
        L42:
            DropdownSelectorWidgetAdapterV2 r26 = this.a.g;
            if (r26 == null) goto L47;
            if (r25 == null) goto L46;
            r23 = r25.a;
        L46:
            r26.submitList(r23);
        L47:
            DropdownSelectorWidgetAdapterV2 r27 = this.a.g;
            if (r27 == null) goto L58;
            r27.notifyItemChanged(r3);
            return;
        L58:
            return;
        L41:
            r25 = null;
            goto L42
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            String r4 = DropdownListSelectorWidgetV2.n6(this.a);
            k0 r5 = j0.a(r2, r1, r4);
            if (r5 != null) goto L6;
            return false;
        L6:
            y0.a(this.b, r5, r4);
            return true;
        }
    }

    public final LarusLayoutActionBarEditorWidgetDropdownSelectorBinding getBinding() {
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final List<com.larus.bmhome.actionbar.model.h> getAllDropdownBoxList() {
        xs8.f r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.n;
    }

    private final xs8.f getController() {
        return (xs8.f) getController();
    }

    private final com.larus.bmhome.actionbar.model.i getCurrentBindData() {
        xs8.f r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    private final Keva getKeva() {
        xs8.f r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m;
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
        AppCompatTextView r4 = getBinding().d;
        com.larus.bmhome.actionbar.model.u r5 = getInstructionItem();
        if (r5 == null) goto L17;
        String r6 = r5.c;
    L18:
        r4.setText(r6);
        com.larus.utils.e1.x(getBinding().d);
        goto L19
    L17:
        r6 = null;
    L19:
        this.g = new DropdownSelectorWidgetAdapterV2(this.h, getViewModel(), getInstructionItem());
        getBinding().c.setAdapter(this.g);
        getBinding().c.setItemAnimator(null);
        getBinding().c.addItemDecoration(new DropdownListSelectorWidgetV2$onBindView$1());
        com.larus.bmhome.view.actionbar.edit.c r7 = getViewModel();
        if (r7 == null) goto L22;
        com.larus.bmhome.actionbar.model.t1 r8 = r7.getOptionParamFilterConf();
    L24:
        if (r8 == null) goto L31;
        List<com.larus.bmhome.actionbar.model.h> r9 = s6(r8, true);
        DropdownSelectorWidgetAdapterV2 r10 = this.g;
        if (r10 == null) goto L28;
        r10.submitList(r9);
    L28:
        com.larus.bmhome.actionbar.model.i r11 = getCurrentBindData();
        if (r11 == null) goto L39;
        r11.a = r9;
    L39:
        if (this.i == true) goto L51;
        this.i = true;
        com.larus.bmhome.view.actionbar.edit.c r12 = getViewModel();
        if (r12 == null) goto L46;
        CoroutineScope r13 = r12.getCurrentViewModelScope();
        if (r13 == null) goto L46;
        BuildersKt.launch$default(r13, null, null, new DropdownListSelectorWidgetV2$observeDataChange$1(this, null), 3, null);
    L46:
        CoroutineScope r14 = getComponentScope();
        if (r14 == null) goto L50;
        BuildersKt.launch$default(r14, null, null, new DropdownListSelectorWidgetV2$observeDataChange$2(this, null), 3, null);
        return;
    L50:
        return;
    L51:
        return;
    L31:
        DropdownSelectorWidgetAdapterV2 r15 = this.g;
        if (r15 == null) goto L39;
        com.larus.bmhome.actionbar.model.i r16 = getCurrentBindData();
        if (r16 == null) goto L36;
        List r17 = r16.a;
    L37:
        r15.submitList(r17);
        goto L39
    L36:
        r17 = null;
        goto L37
    L22:
        r8 = null;
        goto L24
    L11:
        r3 = null;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public DropdownListSelectorWidgetV2(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.h = new a(this, r4);
    }

    public static final /* synthetic */ xs8.f i6(DropdownListSelectorWidgetV2 r0) {
        return r0.getController();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.i k6(DropdownListSelectorWidgetV2 r0) {
        return r0.getCurrentBindData();
    }

    public static final String n6(DropdownListSelectorWidgetV2 r4) {
        Fragment r0 = r4.getFragment();
        String r1 = null;
        if (r0 != null) goto L42;
    L29:
        Fragment r5 = r4.getFragment();
        if (r5 == null) goto L35;
        Bundle r6 = r5.getArguments();
        if (r6 == null) goto L35;
        r1 = r6.getString("enter_method");
    L35:
        if (Intrinsics.areEqual(r1, "click_navigation_cell") == false) goto L37;
    L40:
        return "creation_nevigation_cell";
    L37:
        if (Intrinsics.areEqual(r1, "create_button_panel") == true) goto L40;
        return "creation_chat_action_bar";
    L42:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        ny9.u r3 = s1a.a.g(r0).a(ny9.u.class);     // Catch: Throwable -> L20
        if (r3 == null) goto L12;
        String r7 = r3.getEnterMethod();     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank(r7)) == true) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L12;
    L18:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r8) == false) goto L25;
        r8 = null;
    L25:
        String r9 = (String) r8;
        if (r9 == null) goto L29;
        r1 = r9;
    L12:
        ny9.s r10 = s1a.a.g(r0).a(ny9.s.class);     // Catch: Throwable -> L20
        if (r10 == null) goto L17;
        r7 = r10.i();     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank(r7)) == true) goto L18;
    L17:
        r7 = null;
    L20:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetDropdownSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    public final List<com.larus.bmhome.actionbar.model.h> s6(com.larus.bmhome.actionbar.model.t1 r16, boolean r17) {
        FLogger.a.i("DropdownListSelectorWidgetV2", "filterOptionsWithFilterConf, filterConf=" + r16);
        ArrayList r1 = new ArrayList();
        List r0 = r16.a;
        if (r0 == null) goto L57;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L55;
        com.larus.bmhome.actionbar.model.f1 r4 = (com.larus.bmhome.actionbar.model.f1) r2.next();
        List<com.larus.bmhome.actionbar.model.h> r5 = getAllDropdownBoxList();
        if (r5 == null) goto L19;
        Iterator<T> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r7).a, r4.a) == false) goto L11;
    L16:
        com.larus.bmhome.actionbar.model.h r8 = (com.larus.bmhome.actionbar.model.h) r7;
        if (r8 == null) goto L19;
        com.larus.bmhome.actionbar.model.h r9 = com.larus.bmhome.actionbar.model.h.a(r8, null, null, null, null, null, null, 4095);
    L20:
        ArrayList r10 = new ArrayList();
        List r11 = r4.b;
        if (r11 == null) goto L51;
        Iterator r12 = r11.iterator();
    L24:
        if (r12.hasNext() == false) goto L51;
        Long r13 = (Long) r12.next();
        if (r9 == null) goto L37;
        List r14 = r9.e;
        if (r14 == null) goto L37;
        Iterator r15 = r14.iterator();
    L31:
        if (r15.hasNext() == false) goto L35;
        Object r18 = r15.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r18).a, r13) == false) goto L31;
    L36:
        com.larus.bmhome.actionbar.model.w r19 = (com.larus.bmhome.actionbar.model.w) r18;
    L38:
        if (r19 == null) goto L24;
        if (Intrinsics.areEqual(r19.a, r4.c) == true) goto L49;
        if (r17 == false) goto L48;
        Integer r20 = r19.s;
        if (r20 == null) goto L48;
        if (r20.intValue() == 1) goto L49;
    L48:
        r19.s = 0;
    L50:
        r10.add(r19);
    L49:
        r19.s = 1;
        goto L50
    L35:
        r18 = null;
    L37:
        r19 = null;
    L51:
        if (r9 == null) goto L53;
        r9.e = r10;
    L53:
        if (r9 == null) goto L6;
        r1.add(r9);
        goto L6
    L15:
        r7 = null;
    L19:
        r9 = null;
        goto L20
    L55:
        FLogger.a.i("DropdownListSelectorWidgetV2", "filterOptionsWithFilterConf, result=" + CollectionsKt.joinToString$default(r1, null, null, null, 0, null, null, 63, null));
        return r1;
    L57:
        com.larus.bmhome.actionbar.model.i r3 = getCurrentBindData();
        if (r3 != null) goto L60;
        return null;
    L60:
        return r3.a;
    }

    public static final void o6(DropdownListSelectorWidgetV2 r46, Integer r47, com.larus.bmhome.actionbar.model.w r48, com.larus.bmhome.actionbar.model.h r49, int r50, int r51, String r52) {
        r46.getClass();
        r48.s = 1;
        Boolean r4 = r49.i;
        Boolean r5 = Boolean.TRUE;
        Boolean r6 = null;
        if (Intrinsics.areEqual(r4, r5) == false) goto L20;
        if (r47 == null) goto L20;
        Keva r7 = r46.getKeva();
        if (r7 == null) goto L20;
        StringBuilder r8 = new StringBuilder("dropbox_");
        com.larus.bmhome.view.actionbar.edit.c r9 = r46.getViewModel();
        if (r9 == null) goto L10;
        String r10 = r9.getActionBarType();
    L11:
        r8.append(r10);
        r8.append('_');
        com.larus.bmhome.actionbar.model.u r11 = r46.getInstructionItem();
        if (r11 == null) goto L14;
        Integer r12 = r11.a;
    L15:
        r8.append(r12);
        r8.append('_');
        r8.append(r47);
        String r13 = r8.toString();
        Long r14 = r48.a;
        if (r14 == null) goto L18;
        long r15 = r14.longValue();
    L19:
        r7.storeLong(r13, r15);
        goto L20
    L18:
        r15 = -1;
        goto L19
    L14:
        r12 = null;
        goto L15
    L10:
        r10 = null;
    L20:
        if (r47 != null) goto L23;
    L28:
        com.larus.bmhome.view.actionbar.edit.c r0 = r46.getViewModel();
        if (r0 == null) goto L33;
        ChatParam r1 = r0.getChatParam();
        if (r1 == null) goto L33;
        String r16 = r1.b;
    L34:
        com.larus.bmhome.view.actionbar.edit.c r2 = r46.getViewModel();
        if (r2 == null) goto L39;
        ChatParam r3 = r2.getChatParam();
        if (r3 == null) goto L39;
        String r17 = r3.e;
    L40:
        com.larus.bmhome.view.actionbar.edit.c r18 = r46.getViewModel();
        if (r18 == null) goto L43;
        String r19 = r18.getTemplateType();
    L44:
        com.larus.bmhome.view.actionbar.edit.c r20 = r46.getViewModel();
        if (r20 == null) goto L47;
        String r110 = r20.getActionBarType();
    L48:
        com.larus.bmhome.view.actionbar.edit.c r21 = r46.getViewModel();
        if (r21 == null) goto L53;
        com.larus.bmhome.actionbar.model.z0 r22 = r21.getCurrentCustomActionBarItem();
        if (r22 == null) goto L53;
        String r111 = r22.b;
    L54:
        com.larus.bmhome.actionbar.model.u r23 = r46.getInstructionItem();
        if (r23 == null) goto L57;
        String r112 = r23.c;
    L58:
        String r113 = r49.c;
        String r114 = r48.b;
        String r115 = String.valueOf(r48.a);
        if (Intrinsics.areEqual(r49.h, r5) == true) goto L66;
        Integer r24 = r49.f;
        if (r24 == null) goto L66;
        if (r24.intValue() != r50) goto L66;
        int r25 = 1;
    L67:
        Integer r116 = Integer.valueOf(r25);
        Integer r117 = Integer.valueOf(!Intrinsics.areEqual(r49.h, r5) ? 1 : 0);
        Integer r118 = Integer.valueOf(r51 + 1);
        com.larus.bmhome.view.actionbar.edit.c r26 = r46.getViewModel();
        if (r26 == null) goto L72;
        ChatParam r27 = r26.getChatParam();
        if (r27 == null) goto L72;
        String r30 = r27.c;
    L73:
        com.larus.bmhome.view.actionbar.edit.c r28 = r46.getViewModel();
        if (r28 == null) goto L76;
        r6 = r28.isCreationActionBar();
    L76:
        tx9.b.e(r16, r17, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, "select", null, null, null, null, r52, null, null, null, null, null, r30, r6, null, null, null, null, null, null, null, null, null, null, null, null, -50601984, 127);
        return;
    L72:
        r30 = null;
    L66:
        r25 = 0;
        goto L67
    L57:
        r112 = null;
    L53:
        r111 = null;
        goto L54
    L47:
        r110 = null;
        goto L48
    L43:
        r19 = null;
    L39:
        r17 = null;
    L33:
        r16 = null;
        goto L34
    L23:
        if (r47.intValue() != 5) goto L28;
        LruCache<String, wc9.e> r29 = ko8.a.a;
        String r31 = r48.b;
        if (r31 != null) goto L27;
        r31 = "";
    L27:
        Intrinsics.checkNotNullParameter(r31, "value");
        IAIChatControlTraceService.a.wb(r31);
        goto L28
    }
}
