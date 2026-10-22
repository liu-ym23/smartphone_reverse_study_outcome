package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.WrapStaggeredGridLayoutManager;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTextSelectorBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020 H\u0016J\u0012\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020&H\u0002J\u001c\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010%\u001a\u00020&H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/TextListSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTextSelectorBinding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTextSelectorBinding;", "adapter", "Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorWidgetAdapter;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarTextSelectorTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarTextSelectorTemplate;", "lastSelectedIndex", "", "itemClickCallback", "Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;", "getItemClickCallback", "()Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;", "setItemClickCallback", "(Lcom/larus/bmhome/view/actionbar/edit/component/TextSelectorHolderCallback;)V", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "resetDefaultSelection", "isInit", "", "onItemSelected", "item", "Lcom/larus/bmhome/actionbar/model/SingleSelectorInstructionOption;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TextListSelectorWidget extends AbsInstructionWidget {
    public static final int k = 0;
    public static final int l = 0;
    public String f;
    public LarusLayoutActionBarEditorWidgetTextSelectorBinding g;
    public TextSelectorWidgetAdapter h;
    public int i;
    public r2 j;

    public static final class a {
    }

    public static final class b implements r2 {
        public final /* synthetic */ TextListSelectorWidget a;

        public b(TextListSelectorWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11, types: [int] */
        /* JADX WARN: Type inference failed for: r4v25 */
        @Override // com.larus.bmhome.view.actionbar.edit.component.r2
        public final void a(com.larus.bmhome.actionbar.model.y1 r52, int r53) {
            Intrinsics.checkNotNullParameter(r52, "item");
            FLogger.a.i(this.a.getTAG(), "itemClickCallback, id: " + r52.a + ", status=" + r52.g + ", position: " + r53);
            xs8.o r3 = (xs8.o) this.a.getController();
            boolean r4 = false;
            if (r3 == null) goto L5;
            r3.n = false;
        L5:
            ArrayList r5 = new ArrayList();
            ObricActionBarSendServiceDelegate.b.s(r52.g, r52.b);
            com.larus.bmhome.actionbar.model.k0 r6 = TextListSelectorWidget.k6(this.a);
            if (r6 == null) goto L86;
            List r7 = r6.c;
            if (r7 == null) goto L86;
            TextListSelectorWidget r8 = this.a;
            Iterator r9 = r7.iterator();
        L11:
            if (r9.hasNext() == false) goto L86;
            com.larus.bmhome.actionbar.model.y1 r10 = (com.larus.bmhome.actionbar.model.y1) r9.next();
            if (Intrinsics.areEqual(r10.a, r52.a) == false) goto L84;
            com.larus.bmhome.actionbar.model.k0 r11 = TextListSelectorWidget.k6(r8);
            if (r11 == null) goto L17;
            boolean r12 = Intrinsics.areEqual(r11.e, Boolean.FALSE);
        L18:
            if (r12 == false) goto L25;
            Integer r13 = r10.g;
            if (r13 == null) goto L25;
            if (r13.intValue() != 1) goto L25;
            r10.g = 0;
            r8.o6(r4);
            FLogger.a.i(r8.getTAG(), "itemClickCallback, cancel select id: " + r52.a);
        L26:
            com.larus.bmhome.view.actionbar.edit.c r14 = r8.getViewModel();
            if (r14 == null) goto L31;
            ChatParam r15 = r14.getChatParam();
            if (r15 == null) goto L31;
            String r16 = r15.b;
        L32:
            com.larus.bmhome.view.actionbar.edit.c r17 = r8.getViewModel();
            if (r17 == null) goto L37;
            ChatParam r18 = r17.getChatParam();
            if (r18 == null) goto L37;
            String r19 = r18.e;
        L38:
            com.larus.bmhome.view.actionbar.edit.c r110 = r8.getViewModel();
            if (r110 == null) goto L41;
            String r111 = r110.getTemplateType();
        L42:
            com.larus.bmhome.view.actionbar.edit.c r112 = r8.getViewModel();
            if (r112 == null) goto L45;
            String r113 = r112.getActionBarType();
        L46:
            com.larus.bmhome.view.actionbar.edit.c r114 = r8.getViewModel();
            if (r114 == null) goto L51;
            com.larus.bmhome.actionbar.model.z0 r115 = r114.getCurrentCustomActionBarItem();
            if (r115 == null) goto L51;
            String r116 = r115.b;
        L52:
            com.larus.bmhome.actionbar.model.u r117 = r8.getInstructionItem();
            if (r117 == null) goto L55;
            String r118 = r117.c;
        L56:
            String r119 = r52.b;
            String r20 = String.valueOf(r52.a);
            Integer r21 = r52.a;
            com.larus.bmhome.actionbar.model.k0 r120 = TextListSelectorWidget.k6(r8);
            if (r120 == null) goto L61;
            com.larus.bmhome.actionbar.model.y1 r121 = r120.b;
            if (r121 == null) goto L61;
            Integer r122 = r121.a;
        L62:
            Integer r22 = Integer.valueOf(Intrinsics.areEqual(r21, r122) ? 1 : 0);
            com.larus.bmhome.actionbar.model.k0 r23 = TextListSelectorWidget.k6(r8);
            if (r23 == null) goto L65;
            ?? r24 = Intrinsics.areEqual(r23.e, Boolean.TRUE);
        L66:
            Integer r25 = Integer.valueOf(r24);
            Integer r26 = Integer.valueOf(r53 + 1);
            Integer r27 = r10.g;
            if (r27 != null) goto L70;
        L72:
            String r28 = "cancel";
        L73:
            String r29 = r28;
            com.larus.bmhome.view.actionbar.edit.c r30 = r8.getViewModel();
            if (r30 == null) goto L78;
            ChatParam r31 = r30.getChatParam();
            if (r31 == null) goto L78;
            String r35 = r31.c;
        L79:
            com.larus.bmhome.view.actionbar.edit.c r32 = r8.getViewModel();
            if (r32 == null) goto L82;
            Boolean r36 = r32.isCreationActionBar();
        L83:
            tx9.b.e(r16, r19, r111, r113, r116, r118, null, r119, r20, r22, r25, r26, r29, null, null, null, null, "original", null, null, null, null, null, r35, r36, null, null, null, null, null, null, null, null, null, null, null, null, -50601920, 127);
        L85:
            r5.add(r10);
            r4 = false;
            goto L11
        L82:
            r36 = null;
        L78:
            r35 = null;
            goto L79
        L70:
            if (r27.intValue() != 1) goto L72;
            r28 = "select";
            goto L73
        L65:
            r24 = 0;
        L61:
            r122 = null;
            goto L62
        L55:
            r118 = null;
        L51:
            r116 = null;
            goto L52
        L45:
            r113 = null;
            goto L46
        L41:
            r111 = null;
        L37:
            r19 = null;
        L31:
            r16 = null;
        L25:
            r10.g = 1;
            r8.n6(r52, r4);
            FLogger.a.i(r8.getTAG(), "itemClickCallback, select id: " + r52.a);
            goto L26
        L17:
            r12 = false;
            goto L18
        L84:
            r10.g = 0;
        L86:
            TextSelectorWidgetAdapter r1 = this.a.h;
            if (r1 == null) goto L100;
            ArrayList r33 = new ArrayList();
            Iterator r34 = r5.iterator();
        L90:
            if (r34.hasNext() == false) goto L99;
            Object r37 = r34.next();
            String r38 = ((com.larus.bmhome.actionbar.model.y1) r37).b;
            if (r38 != null) goto L94;
        L96:
            boolean r39 = false;
        L97:
            if (r39 == false) goto L90;
            r33.add(r37);
            goto L90
        L94:
            if ((!StringsKt.isBlank(r38)) != true) goto L96;
            r39 = true;
            goto L97
        L99:
            r1.submitList(r33);
        L100:
            TextListSelectorWidget r2 = this.a;
            int r40 = r2.i;
            if (r40 < 0) goto L105;
            TextSelectorWidgetAdapter r41 = r2.h;
            if (r41 == null) goto L105;
            r41.notifyItemChanged(r40);
        L105:
            TextSelectorWidgetAdapter r42 = this.a.h;
            if (r42 == null) goto L108;
            r42.notifyItemChanged(r53);
        L108:
            this.a.i = r53;
        }
    }

    static {
        k = i5.j0();
        l = i5.r0();
    }

    public final LarusLayoutActionBarEditorWidgetTextSelectorBinding getBinding() {
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final com.larus.bmhome.actionbar.model.k0 getCurrentBindData() {
        xs8.o r0 = (xs8.o) getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        ArrayList r3 = null;
        if (r2 == null) goto L11;
        String r4 = r2.c;
    L13:
        if (com.larus.utils.o0.d(r4) == false) goto L19;
        AppCompatTextView r5 = getBinding().d;
        com.larus.bmhome.actionbar.model.u r6 = getInstructionItem();
        if (r6 == null) goto L17;
        String r7 = r6.c;
    L18:
        r5.setText(r7);
        com.larus.utils.e1.x(getBinding().d);
        goto L19
    L17:
        r7 = null;
    L19:
        y6.d(getBinding().c, null, null, null, new p2(this), 15);
        com.larus.bmhome.actionbar.model.k0 r8 = getCurrentBindData();
        if (r8 == null) goto L24;
        Integer r9 = r8.a;
        if (r9 == null) goto L24;
        int r10 = r9.intValue();
    L25:
        FLogger.a.i(this.f, "parseTemplate, colNums=" + r10);
        if (r10 <= 1) goto L36;
        final WrapStaggeredGridLayoutManager r11 = new WrapStaggeredGridLayoutManager(r10, 0);
        r11.setGapStrategy(0);
        RecyclerView r12 = getBinding().c;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L35;
        r13.height = r10 * (i5.W() + l);
        r12.setLayoutParams(r13);
        RecyclerView r14 = getBinding().c;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L33;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.bottomMargin = i5.r0();
        r14.setLayoutParams(r16);
        getBinding().c.setLayoutManager(r11);
        getBinding().c.addItemDecoration(new TextListSelectorWidget$onBindView$4());
        getBinding().c.addOnScrollListener(new TextListSelectorWidget$onBindView$5(r11));
    L37:
        com.larus.bmhome.actionbar.model.k0 r17 = getCurrentBindData();
        if (r17 == null) goto L50;
        Integer r18 = r17.d;
        if (r18 == null) goto L50;
        if (r18.intValue() < 0) goto L44;
        boolean r19 = true;
    L45:
        if (r19 == true) goto L48;
        r18 = null;
    L48:
        if (r18 == null) goto L50;
        int r20 = r18.intValue();
    L68:
        if (r20 < 0) goto L78;
        com.larus.bmhome.actionbar.model.k0 r21 = getCurrentBindData();
        if (r21 == null) goto L74;
        List r22 = r21.c;
        if (r22 == null) goto L74;
        com.larus.bmhome.actionbar.model.y1 r23 = (com.larus.bmhome.actionbar.model.y1) CollectionsKt.getOrNull(r22, r20);
    L75:
        if (r23 == null) goto L77;
        r23.g = 1;
    L77:
        n6(r23, true);
        this.i = r20;
    L79:
        this.h = new TextSelectorWidgetAdapter(this.j);
        getBinding().c.setAdapter(this.h);
        getBinding().c.setItemAnimator(null);
        TextSelectorWidgetAdapter r24 = this.h;
        if (r24 == null) goto L105;
        com.larus.bmhome.actionbar.model.k0 r25 = getCurrentBindData();
        if (r25 == null) goto L96;
        List r26 = r25.c;
        if (r26 == null) goto L96;
        r3 = new ArrayList();
        Iterator r27 = r26.iterator();
    L87:
        if (r27.hasNext() == false) goto L96;
        Object r28 = r27.next();
        String r29 = ((com.larus.bmhome.actionbar.model.y1) r28).b;
        if (r29 != null) goto L91;
    L93:
        boolean r30 = false;
    L94:
        if (r30 == false) goto L87;
        r3.add(r28);
        goto L87
    L91:
        if ((!StringsKt.isBlank(r29)) != true) goto L93;
        r30 = true;
    L96:
        r24.submitList(r3);
        return;
    L105:
        return;
    L74:
        r23 = null;
        goto L75
    L78:
        o6(true);
        goto L79
    L44:
        r19 = false;
    L50:
        com.larus.bmhome.actionbar.model.k0 r31 = getCurrentBindData();
        if (r31 == null) goto L67;
        List r32 = r31.c;
        if (r32 == null) goto L67;
        Iterator r33 = r32.iterator();
        int r34 = 0;
    L56:
        if (r33.hasNext() == false) goto L67;
        Integer r35 = ((com.larus.bmhome.actionbar.model.y1) r33.next()).g;
        if (r35 != null) goto L61;
    L63:
        boolean r36 = false;
    L64:
        if (r36 == true) goto L65;
        r34 = r34 + 1;
        goto L56
    L65:
        r20 = r34;
        goto L68
    L61:
        if (r35.intValue() != 1) goto L63;
        r36 = true;
    L67:
        r20 = -1;
        goto L68
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L36:
        getBinding().c.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        getBinding().c.addItemDecoration(new TextListSelectorWidget$onBindView$6());
    L24:
        r10 = 1;
        goto L25
    L11:
        r4 = null;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public final r2 getItemClickCallback() {
        return this.j;
    }

    public final String getTAG() {
        return this.f;
    }

    public TextListSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.f = "TextListSelectorWidget";
        this.i = -1;
        this.j = new b(this);
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.k0 k6(TextListSelectorWidget r0) {
        return r0.getCurrentBindData();
    }

    public final void o6(boolean r6) {
        com.larus.bmhome.actionbar.model.k0 r0 = getCurrentBindData();
        if (r0 == null) goto L10;
        com.larus.bmhome.actionbar.model.y1 r1 = r0.b;
        if (r1 == null) goto L10;
        com.larus.bmhome.actionbar.model.q1 r2 = r1.d;
        if (r2 == null) goto L10;
        String r3 = r2.a;
        if (r3 == null) goto L10;
    L12:
        if (com.larus.utils.o0.d(r3) == false) goto L16;
        com.larus.bmhome.view.actionbar.edit.c r4 = getViewModel();
        if (r4 == null) goto L16;
        r4.onInputHintChanged(r3, "resetDefaultSelection");
    L16:
        com.larus.bmhome.actionbar.model.k0 r5 = getCurrentBindData();
        if (r5 == null) goto L21;
        com.larus.bmhome.actionbar.model.y1 r7 = r5.b;
        if (r7 == null) goto L21;
        com.larus.bmhome.actionbar.model.t1 r8 = r7.e;
    L22:
        if (r8 == null) goto L30;
        if (r6 == false) goto L27;
        com.larus.bmhome.view.actionbar.edit.c r9 = getViewModel();
        if (r9 == null) goto L30;
        r9.setOptionParamFilterConf(r8);
        goto L30
    L27:
        com.larus.bmhome.view.actionbar.edit.c r10 = getViewModel();
        if (r10 == null) goto L30;
        r10.onParamFilterConfChanged(r8);
    L30:
        FLogger.a.i(this.f, "resetDefaultSelection, targetInputHint=" + r3 + ", paramFilterConf=" + r8);
        return;
    L21:
        r8 = null;
    L10:
        r3 = "";
        goto L12
    }

    public final void setItemClickCallback(r2 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setTAG(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.g = LarusLayoutActionBarEditorWidgetTextSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    public final void n6(com.larus.bmhome.actionbar.model.y1 r5, boolean r6) {
        if (r5 == null) goto L7;
        com.larus.bmhome.actionbar.model.q1 r0 = r5.d;
        if (r0 == null) goto L7;
        String r1 = r0.a;
        if (r1 == null) goto L7;
    L9:
        if (com.larus.utils.o0.d(r1) == false) goto L13;
        com.larus.bmhome.view.actionbar.edit.c r2 = getViewModel();
        if (r2 == null) goto L13;
        r2.onInputHintChanged(r1, "onItemSelected");
    L13:
        if (r5 == null) goto L15;
        com.larus.bmhome.actionbar.model.t1 r7 = r5.e;
    L16:
        if (r7 == null) goto L24;
        if (r6 == false) goto L21;
        com.larus.bmhome.view.actionbar.edit.c r8 = getViewModel();
        if (r8 == null) goto L24;
        r8.setOptionParamFilterConf(r7);
        goto L24
    L21:
        com.larus.bmhome.view.actionbar.edit.c r9 = getViewModel();
        if (r9 == null) goto L24;
        r9.onParamFilterConfChanged(r7);
    L24:
        FLogger.a.i(this.f, "onItemSelected, targetInputHint=" + r1 + ", paramFilterConf=" + r7);
        return;
    L15:
        r7 = null;
    L7:
        r1 = "";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public static void i6(TextListSelectorWidget r28, int r29, RecyclerView.ViewHolder r30) {
        Intrinsics.checkNotNullParameter(r30, "<unused var>");
        TextSelectorWidgetAdapter r2 = r28.h;
        Boolean r3 = null;
        if (r2 == null) goto L7;
        List r4 = r2.getCurrentList();
        if (r4 == null) goto L7;
        com.larus.bmhome.actionbar.model.y1 r5 = (com.larus.bmhome.actionbar.model.y1) CollectionsKt.getOrNull(r4, r29);
    L8:
        if (r5 == null) goto L60;
        com.larus.bmhome.view.actionbar.edit.c r6 = r28.getViewModel();
        if (r6 == null) goto L14;
        ChatParam r7 = r6.getChatParam();
        if (r7 == null) goto L14;
        String r8 = r7.b;
    L15:
        com.larus.bmhome.view.actionbar.edit.c r9 = r28.getViewModel();
        if (r9 == null) goto L20;
        ChatParam r10 = r9.getChatParam();
        if (r10 == null) goto L20;
        String r11 = r10.e;
    L21:
        com.larus.bmhome.view.actionbar.edit.c r12 = r28.getViewModel();
        if (r12 == null) goto L24;
        String r13 = r12.getTemplateType();
    L25:
        com.larus.bmhome.view.actionbar.edit.c r14 = r28.getViewModel();
        if (r14 == null) goto L28;
        String r15 = r14.getActionBarType();
    L29:
        com.larus.bmhome.view.actionbar.edit.c r16 = r28.getViewModel();
        if (r16 == null) goto L34;
        com.larus.bmhome.actionbar.model.z0 r17 = r16.getCurrentCustomActionBarItem();
        if (r17 == null) goto L34;
        String r18 = r17.b;
    L35:
        com.larus.bmhome.actionbar.model.u r19 = r28.getInstructionItem();
        if (r19 == null) goto L38;
        String r110 = r19.c;
    L39:
        String r111 = r5.b;
        String r112 = String.valueOf(r5.a);
        Integer r20 = r5.a;
        com.larus.bmhome.actionbar.model.k0 r21 = r28.getCurrentBindData();
        if (r21 == null) goto L44;
        com.larus.bmhome.actionbar.model.y1 r22 = r21.b;
        if (r22 == null) goto L44;
        Integer r23 = r22.a;
    L45:
        Integer r113 = Integer.valueOf(Intrinsics.areEqual(r20, r23) ? 1 : 0);
        com.larus.bmhome.actionbar.model.k0 r24 = r28.getCurrentBindData();
        if (r24 == null) goto L48;
        ?? r25 = Intrinsics.areEqual(r24.e, Boolean.TRUE);
    L49:
        Integer r114 = Integer.valueOf(r25);
        Integer r115 = Integer.valueOf(r29 + 1);
        com.larus.bmhome.view.actionbar.edit.c r0 = r28.getViewModel();
        if (r0 == null) goto L54;
        ChatParam r1 = r0.getChatParam();
        if (r1 == null) goto L54;
        String r26 = r1.c;
    L55:
        com.larus.bmhome.view.actionbar.edit.c r27 = r28.getViewModel();
        if (r27 == null) goto L58;
        r3 = r27.isCreationActionBar();
    L58:
        tx9.b.f(r8, r11, r13, r15, r18, r110, null, r111, r112, r113, r114, r115, null, null, null, null, null, null, null, null, r26, r3, 2093120);
        return;
    L54:
        r26 = null;
        goto L55
    L48:
        r25 = 0;
    L44:
        r23 = null;
        goto L45
    L38:
        r110 = null;
    L34:
        r18 = null;
        goto L35
    L28:
        r15 = null;
        goto L29
    L24:
        r13 = null;
    L20:
        r11 = null;
    L14:
        r8 = null;
        goto L15
    L60:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
