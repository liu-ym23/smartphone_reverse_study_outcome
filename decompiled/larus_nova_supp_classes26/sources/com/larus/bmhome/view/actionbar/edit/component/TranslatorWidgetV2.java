package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTranslatorV2Binding;
import com.larus.platform.service.AccountService;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002),\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020/H\u0002J\u0012\u00104\u001a\u00020/2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0012\u00107\u001a\u00020/2\b\u00105\u001a\u0004\u0018\u000106H\u0002R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR#\u0010 \u001a\n \u000f*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020'X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0004\n\u0002\u0010-¨\u00069"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV2;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTranslatorV2Binding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTranslatorV2Binding;", "sourceLanguageBalloon", "Lcom/skydoves/balloon/Balloon;", "sourceLanguagePopupView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "sourceLanguageRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sourceLanguageItemAdapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "targetLanguageBalloon", "targetLanguagePopupView", "targetLanguageRecyclerView", "targetLanguageItemAdapter", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/TranslatorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/TranslatorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "cache", "Lcom/bytedance/keva/Keva;", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "Lkotlin/Lazy;", "targetOptionIdDefaultValue", "", "sourceLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV2$sourceLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV2$sourceLanguageSelectedCallback$1;", "targetLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV2$targetLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/TranslatorWidgetV2$targetLanguageSelectedCallback$1;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "restoreTargetLanguageOptionId", "initSourceLanguageSelector", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "initTargetLanguageSelector", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TranslatorWidgetV2 extends AbsInstructionWidget {
    public static final String s = null;
    public LarusLayoutActionBarEditorWidgetTranslatorV2Binding f;
    public Balloon g;
    public final View h;
    public final RecyclerView i;
    public DropdownItemAdapter j;
    public Balloon k;
    public final View l;
    public final RecyclerView m;
    public DropdownItemAdapter n;
    public final Lazy o;
    public final long p;
    public final b q;
    public final c r;

    public static final class a {
    }

    public static final class b implements b1 {
        public final /* synthetic */ TranslatorWidgetV2 a;

        public b(TranslatorWidgetV2 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r51, com.larus.bmhome.actionbar.model.w r52, int r53) {
            Intrinsics.checkNotNullParameter(r52, "selectedSpinnerItem");
            Balloon r2 = this.a.g;
            if (r2 == null) goto L5;
            r2.h();
        L5:
            this.a.getBinding().c.d.setText(r52.b());
            com.larus.bmhome.actionbar.model.l0 r3 = TranslatorWidgetV2.k6(this.a);
            List r4 = null;
            if (r3 == null) goto L79;
            com.larus.bmhome.actionbar.model.h r5 = r3.a;
            if (r5 == null) goto L79;
            List r6 = r5.e;
            if (r6 == null) goto L79;
            TranslatorWidgetV2 r7 = this.a;
            Iterator r8 = r6.iterator();
            int r9 = 0;
        L13:
            if (r8.hasNext() == false) goto L79;
            Object r10 = r8.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) r10;
            if (Intrinsics.areEqual(r12.a, r52.a) == false) goto L77;
            r12.s = 1;
            com.larus.bmhome.view.actionbar.edit.c r13 = r7.getViewModel();
            if (r13 == null) goto L24;
            ChatParam r14 = r13.getChatParam();
            if (r14 == null) goto L24;
            String r15 = r14.b;
        L25:
            com.larus.bmhome.view.actionbar.edit.c r16 = r7.getViewModel();
            if (r16 == null) goto L30;
            ChatParam r17 = r16.getChatParam();
            if (r17 == null) goto L30;
            String r18 = r17.e;
        L31:
            com.larus.bmhome.view.actionbar.edit.c r19 = r7.getViewModel();
            if (r19 == null) goto L34;
            String r110 = r19.getTemplateType();
        L35:
            com.larus.bmhome.view.actionbar.edit.c r111 = r7.getViewModel();
            if (r111 == null) goto L38;
            String r112 = r111.getActionBarType();
        L39:
            com.larus.bmhome.view.actionbar.edit.c r113 = r7.getViewModel();
            if (r113 == null) goto L44;
            com.larus.bmhome.actionbar.model.z0 r114 = r113.getCurrentCustomActionBarItem();
            if (r114 == null) goto L44;
            String r115 = r114.b;
        L45:
            com.larus.bmhome.actionbar.model.u r116 = r7.getInstructionItem();
            if (r116 == null) goto L48;
            String r117 = r116.c;
        L49:
            com.larus.bmhome.actionbar.model.l0 r118 = TranslatorWidgetV2.k6(r7);
            if (r118 == null) goto L54;
            com.larus.bmhome.actionbar.model.h r119 = r118.a;
            if (r119 == null) goto L54;
            String r120 = r119.c;
        L55:
            String r121 = r12.b;
            String r122 = String.valueOf(r12.a);
            com.larus.bmhome.actionbar.model.l0 r20 = TranslatorWidgetV2.k6(r7);
            if (r20 == null) goto L65;
            com.larus.bmhome.actionbar.model.h r21 = r20.a;
            if (r21 == null) goto L65;
            Integer r22 = r21.f;
            if (r22 == null) goto L65;
            if (r22.intValue() != r9) goto L65;
            int r23 = 1;
        L66:
            Integer r24 = Integer.valueOf(r23);
            com.larus.bmhome.actionbar.model.l0 r25 = TranslatorWidgetV2.k6(r7);
            if (r25 == null) goto L71;
            com.larus.bmhome.actionbar.model.h r26 = r25.a;
            if (r26 == null) goto L71;
            boolean r27 = Intrinsics.areEqual(r26.h, Boolean.TRUE);
        L72:
            Integer r28 = Integer.valueOf(!r27);
            Integer r29 = Integer.valueOf(r53 + 1);
            com.larus.bmhome.view.actionbar.edit.c r30 = r7.getViewModel();
            if (r30 == null) goto L75;
            Boolean r35 = r30.isCreationActionBar();
        L76:
            tx9.b.e(r15, r18, r110, r112, r115, r117, r120, r121, r122, r24, r28, r29, "select", null, null, null, null, "original", null, null, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, null, null, null, -33824768, 127);
        L78:
            r9 = r11;
            goto L13
        L75:
            r35 = null;
        L71:
            r27 = 0;
        L65:
            r23 = 0;
        L54:
            r120 = null;
            goto L55
        L48:
            r117 = null;
        L44:
            r115 = null;
            goto L45
        L38:
            r112 = null;
            goto L39
        L34:
            r110 = null;
        L30:
            r18 = null;
        L24:
            r15 = null;
            goto L25
        L77:
            r12.s = 0;
        L79:
            com.larus.bmhome.actionbar.model.l0 r1 = TranslatorWidgetV2.k6(this.a);
            if (r1 == null) goto L84;
            com.larus.bmhome.actionbar.model.h r31 = r1.a;
            if (r31 == null) goto L84;
            com.larus.bmhome.actionbar.model.h r32 = com.larus.bmhome.actionbar.model.h.a(r31, null, null, null, null, null, null, 4095);
        L85:
            DropdownItemAdapter r33 = this.a.j;
            if (r33 == null) goto L94;
            if (r32 == null) goto L89;
            r4 = r32.e;
        L89:
            r33.submitList(r4);
            return;
        L94:
            return;
        L84:
            r32 = null;
            goto L85
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    public static final class c implements b1 {
        public final /* synthetic */ TranslatorWidgetV2 a;

        public c(TranslatorWidgetV2 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r51, com.larus.bmhome.actionbar.model.w r52, int r53) {
            Intrinsics.checkNotNullParameter(r52, "selectedSpinnerItem");
            Balloon r2 = this.a.k;
            if (r2 == null) goto L5;
            r2.h();
        L5:
            this.a.getBinding().d.d.setText(r52.b());
            com.larus.bmhome.actionbar.model.l0 r3 = TranslatorWidgetV2.k6(this.a);
            if (r3 == null) goto L83;
            com.larus.bmhome.actionbar.model.h r4 = r3.b;
            if (r4 == null) goto L83;
            List r5 = r4.e;
            if (r5 == null) goto L83;
            TranslatorWidgetV2 r6 = this.a;
            Iterator r7 = r5.iterator();
            int r8 = 0;
        L13:
            if (r7.hasNext() == false) goto L83;
            Object r9 = r7.next();
            int r10 = r8 + 1;
            if (r8 >= 0) goto L17;
            CollectionsKt.throwIndexOverflow();
        L17:
            com.larus.bmhome.actionbar.model.w r11 = (com.larus.bmhome.actionbar.model.w) r9;
            if (Intrinsics.areEqual(r11.a, r52.a) == false) goto L81;
            r11.s = 1;
            com.larus.bmhome.view.actionbar.edit.c r12 = r6.getViewModel();
            if (r12 == null) goto L24;
            ChatParam r13 = r12.getChatParam();
            if (r13 == null) goto L24;
            String r14 = r13.b;
        L25:
            com.larus.bmhome.view.actionbar.edit.c r15 = r6.getViewModel();
            if (r15 == null) goto L30;
            ChatParam r16 = r15.getChatParam();
            if (r16 == null) goto L30;
            String r17 = r16.e;
        L31:
            com.larus.bmhome.view.actionbar.edit.c r18 = r6.getViewModel();
            if (r18 == null) goto L34;
            String r19 = r18.getTemplateType();
        L35:
            com.larus.bmhome.view.actionbar.edit.c r110 = r6.getViewModel();
            if (r110 == null) goto L38;
            String r111 = r110.getActionBarType();
        L39:
            com.larus.bmhome.view.actionbar.edit.c r112 = r6.getViewModel();
            if (r112 == null) goto L44;
            com.larus.bmhome.actionbar.model.z0 r113 = r112.getCurrentCustomActionBarItem();
            if (r113 == null) goto L44;
            String r114 = r113.b;
        L45:
            com.larus.bmhome.actionbar.model.u r115 = r6.getInstructionItem();
            if (r115 == null) goto L48;
            String r116 = r115.c;
        L49:
            com.larus.bmhome.actionbar.model.l0 r117 = TranslatorWidgetV2.k6(r6);
            if (r117 == null) goto L54;
            com.larus.bmhome.actionbar.model.h r118 = r117.b;
            if (r118 == null) goto L54;
            String r119 = r118.c;
        L55:
            String r120 = r11.b;
            String r121 = String.valueOf(r11.a);
            com.larus.bmhome.actionbar.model.l0 r20 = TranslatorWidgetV2.k6(r6);
            if (r20 == null) goto L65;
            com.larus.bmhome.actionbar.model.h r21 = r20.b;
            if (r21 == null) goto L65;
            Integer r22 = r21.f;
            if (r22 == null) goto L65;
            if (r22.intValue() != r8) goto L65;
            int r23 = 1;
        L66:
            Integer r24 = Integer.valueOf(r23);
            com.larus.bmhome.actionbar.model.l0 r25 = TranslatorWidgetV2.k6(r6);
            if (r25 == null) goto L71;
            com.larus.bmhome.actionbar.model.h r26 = r25.b;
            if (r26 == null) goto L71;
            boolean r27 = Intrinsics.areEqual(r26.h, Boolean.TRUE);
        L72:
            Integer r28 = Integer.valueOf(!r27);
            Integer r29 = Integer.valueOf(r53 + 1);
            com.larus.bmhome.view.actionbar.edit.c r30 = r6.getViewModel();
            if (r30 == null) goto L75;
            Boolean r35 = r30.isCreationActionBar();
        L76:
            tx9.b.e(r14, r17, r19, r111, r114, r116, r119, r120, r121, r24, r28, r29, "select", null, null, null, null, "original", null, null, null, null, null, null, r35, null, null, null, null, null, null, null, null, null, null, null, null, -33824768, 127);
            Keva r31 = TranslatorWidgetV2.i6(r6);
            String r32 = TranslatorWidgetV2.s;
            Long r33 = r11.a;
            if (r33 == null) goto L79;
            long r34 = r33.longValue();
        L80:
            r31.storeLong(r32, r34);
        L82:
            r8 = r10;
            goto L13
        L79:
            r34 = r6.p;
            goto L80
        L75:
            r35 = null;
        L71:
            r27 = 0;
        L65:
            r23 = 0;
        L54:
            r119 = null;
            goto L55
        L48:
            r116 = null;
        L44:
            r114 = null;
            goto L45
        L38:
            r111 = null;
            goto L39
        L34:
            r19 = null;
        L30:
            r17 = null;
        L24:
            r14 = null;
            goto L25
        L81:
            r11.s = 0;
        L83:
            com.larus.bmhome.actionbar.model.l0 r1 = TranslatorWidgetV2.k6(this.a);
            if (r1 == null) goto L88;
            com.larus.bmhome.actionbar.model.h r36 = r1.b;
            if (r36 == null) goto L88;
            com.larus.bmhome.actionbar.model.h r37 = com.larus.bmhome.actionbar.model.h.a(r36, null, null, null, null, null, null, 4095);
        L89:
            DropdownItemAdapter r38 = this.a.n;
            if (r38 == null) goto L99;
            if (r37 == null) goto L93;
            List r39 = r37.e;
        L94:
            r38.submitList(r39);
            return;
        L93:
            r39 = null;
            goto L94
        L99:
            return;
        L88:
            r37 = null;
            goto L89
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    static {
        s = AccountService.a.getUserId().concat("-selected_target_language");
    }

    private final Keva getCache() {
        return (Keva) this.o.getValue();
    }

    public final LarusLayoutActionBarEditorWidgetTranslatorV2Binding getBinding() {
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final xs8.p getController() {
        return (xs8.p) getController();
    }

    private final com.larus.bmhome.actionbar.model.l0 getCurrentBindData() {
        xs8.p r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        com.larus.bmhome.actionbar.model.u r0 = getInstructionItem();
        final int r1 = 0;
        if (r0 == null) goto L5;
        boolean r2 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L6:
        if (r2 == false) goto L8;
        com.larus.utils.e1.x(getBinding().b);
    L8:
        com.larus.bmhome.actionbar.model.u r3 = getInstructionItem();
        List r4 = null;
        if (r3 == null) goto L11;
        String r5 = r3.c;
    L13:
        if (com.larus.utils.o0.d(r5) == false) goto L19;
        AppCompatTextView r6 = getBinding().e;
        com.larus.bmhome.actionbar.model.u r7 = getInstructionItem();
        if (r7 == null) goto L17;
        String r8 = r7.c;
    L18:
        r6.setText(r8);
        com.larus.utils.e1.x(getBinding().e);
        goto L19
    L17:
        r8 = null;
    L19:
        long r9 = getCache().getLong(s, this.p);
        if (r9 == this.p) goto L39;
        com.larus.bmhome.actionbar.model.l0 r10 = getCurrentBindData();
        if (r10 == null) goto L39;
        com.larus.bmhome.actionbar.model.h r11 = r10.b;
        if (r11 == null) goto L39;
        List r12 = r11.e;
        if (r12 == null) goto L39;
        Iterator r13 = r12.iterator();
    L30:
        if (r13.hasNext() == false) goto L39;
        com.larus.bmhome.actionbar.model.w r14 = (com.larus.bmhome.actionbar.model.w) r13.next();
        Long r15 = r14.a;
        if (r15 != null) goto L35;
    L37:
        int r16 = 0;
    L38:
        r14.s = r16;
        goto L30
    L35:
        if (r15.longValue() != r9) goto L37;
        r16 = 1;
    L39:
        com.larus.bmhome.actionbar.model.l0 r17 = getCurrentBindData();
        if (r17 == null) goto L42;
        final com.larus.bmhome.actionbar.model.h r18 = r17.a;
    L43:
        int r19 = -1;
        if (r18 == null) goto L48;
        Integer r20 = r18.f;
        if (r20 == null) goto L48;
        int r21 = r20.intValue();
    L49:
        if (r18 == null) goto L62;
        List r22 = r18.e;
        if (r22 == null) goto L62;
        Iterator r23 = r22.iterator();
    L54:
        if (r23.hasNext() == false) goto L58;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r24).a, r18.g) == false) goto L54;
    L59:
        com.larus.bmhome.actionbar.model.w r25 = (com.larus.bmhome.actionbar.model.w) r24;
        if (r25 == null) goto L62;
        r25.s = 1;
    L63:
        if (r25 != null) goto L72;
        if (r21 < 0) goto L72;
        if (r18 == null) goto L69;
        List r26 = r18.e;
        if (r26 == null) goto L69;
        com.larus.bmhome.actionbar.model.w r27 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r26, r21);
    L70:
        if (r27 == null) goto L72;
        r27.s = 1;
    L69:
        r27 = null;
    L72:
        com.larus.utils.e1.o(getBinding().c.c);
        AppCompatTextView r28 = getBinding().c.d;
        if (r18 == null) goto L92;
        List r29 = r18.e;
        if (r29 == null) goto L92;
        Iterator r30 = r29.iterator();
    L78:
        if (r30.hasNext() == false) goto L88;
        Object r31 = r30.next();
        Integer r32 = ((com.larus.bmhome.actionbar.model.w) r31).s;
        if (r32 != null) goto L83;
    L85:
        boolean r33 = false;
    L86:
        if (r33 == false) goto L78;
    L89:
        com.larus.bmhome.actionbar.model.w r34 = (com.larus.bmhome.actionbar.model.w) r31;
        if (r34 == null) goto L92;
        String r35 = r34.b();
    L93:
        r28.setText(r35);
        if (r18 == null) goto L96;
        Integer r36 = r18.b;
    L97:
        this.j = new DropdownItemAdapter(r36, this.q, null);
        y6.d(this.i, null, null, null, new t2(this, r18), 15);
        DropdownItemAdapter r37 = this.j;
        if (r37 == null) goto L103;
        if (r18 == null) goto L101;
        List r38 = r18.e;
    L102:
        r37.submitList(r38);
        goto L103
    L101:
        r38 = null;
    L103:
        if (r18 == null) goto L107;
        List r39 = r18.e;
        if (r39 == null) goto L107;
        final int r40 = r39.size();
    L108:
        final Ref.LongRef r41 = new Ref.LongRef();
        com.larus.utils.e1.d(getBinding().c.a, new u2(r40, this, r41));
        com.larus.bmhome.actionbar.model.l0 r42 = getCurrentBindData();
        if (r42 == null) goto L111;
        final com.larus.bmhome.actionbar.model.h r43 = r42.b;
    L112:
        if (r43 == null) goto L116;
        Integer r44 = r43.f;
        if (r44 == null) goto L116;
        r19 = r44.intValue();
    L116:
        if (r43 == null) goto L132;
        List r45 = r43.e;
        if (r45 == null) goto L132;
        ArrayList r46 = new ArrayList();
        Iterator r47 = r45.iterator();
    L121:
        if (r47.hasNext() == false) goto L131;
        Object r48 = r47.next();
        Integer r49 = ((com.larus.bmhome.actionbar.model.w) r48).s;
        if (r49 != null) goto L126;
    L128:
        boolean r50 = false;
    L129:
        if (r50 == false) goto L121;
        r46.add(r48);
        goto L121
    L126:
        if (r49.intValue() != 1) goto L128;
        r50 = true;
        goto L129
    L131:
        int r51 = r46.size();
    L133:
        if (r51 <= 0) goto L135;
        boolean r52 = true;
    L136:
        if (r43 == null) goto L149;
        List r53 = r43.e;
        if (r53 == null) goto L149;
        Iterator r54 = r53.iterator();
    L141:
        if (r54.hasNext() == false) goto L145;
        Object r55 = r54.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r55).a, r43.g) == false) goto L141;
    L146:
        com.larus.bmhome.actionbar.model.w r56 = (com.larus.bmhome.actionbar.model.w) r55;
        if (r56 == null) goto L149;
        r56.s = 1;
    L150:
        if (r56 != null) goto L160;
        if (r19 < 0) goto L160;
        if (r52 == true) goto L160;
        if (r43 == null) goto L157;
        List r57 = r43.e;
        if (r57 == null) goto L157;
        com.larus.bmhome.actionbar.model.w r58 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r57, r19);
    L158:
        if (r58 == null) goto L160;
        r58.s = 1;
    L157:
        r58 = null;
    L160:
        com.larus.utils.e1.o(getBinding().d.c);
        AppCompatTextView r59 = getBinding().d.d;
        if (r43 == null) goto L180;
        List r60 = r43.e;
        if (r60 == null) goto L180;
        Iterator r61 = r60.iterator();
    L166:
        if (r61.hasNext() == false) goto L176;
        Object r62 = r61.next();
        Integer r63 = ((com.larus.bmhome.actionbar.model.w) r62).s;
        if (r63 != null) goto L171;
    L173:
        boolean r64 = false;
    L174:
        if (r64 == false) goto L166;
    L177:
        com.larus.bmhome.actionbar.model.w r65 = (com.larus.bmhome.actionbar.model.w) r62;
        if (r65 == null) goto L180;
        String r66 = r65.b();
    L181:
        r59.setText(r66);
        if (r43 == null) goto L184;
        Integer r67 = r43.b;
    L185:
        this.n = new DropdownItemAdapter(r67, this.r, null);
        y6.d(this.m, null, null, null, new v2(this, r43), 15);
        DropdownItemAdapter r68 = this.n;
        if (r68 == null) goto L190;
        if (r43 == null) goto L189;
        r4 = r43.e;
    L189:
        r68.submitList(r4);
    L190:
        if (r43 == null) goto L194;
        List r69 = r43.e;
        if (r69 == null) goto L194;
        r1 = r69.size();
    L194:
        final Ref.LongRef r70 = new Ref.LongRef();
        com.larus.utils.e1.d(getBinding().d.a, new w2(this, r1, r70));
        return;
    L184:
        r67 = null;
        goto L185
    L171:
        if (r63.intValue() != 1) goto L173;
        r64 = true;
        goto L174
    L176:
        r62 = null;
    L180:
        r66 = null;
        goto L181
    L145:
        r55 = null;
    L149:
        r56 = null;
        goto L150
    L135:
        r52 = false;
    L132:
        r51 = 0;
        goto L133
    L111:
        r43 = null;
    L107:
        r40 = 0;
        goto L108
    L96:
        r36 = null;
        goto L97
    L83:
        if (r32.intValue() != 1) goto L85;
        r33 = true;
        goto L86
    L88:
        r31 = null;
    L92:
        r35 = null;
        goto L93
    L58:
        r24 = null;
    L62:
        r25 = null;
    L48:
        r21 = -1;
        goto L49
    L42:
        r18 = null;
        goto L43
    L11:
        r5 = null;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public TranslatorWidgetV2(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 6, 0);
        View r0 = LayoutInflater.from(r5).inflate(2131562465, null);
        this.h = r0;
        this.i = r0.findViewById(2131382753);
        View r6 = LayoutInflater.from(r5).inflate(2131562465, null);
        this.l = r6;
        this.m = r6.findViewById(2131382753);
        this.o = LazyKt.lazy(new s2());
        this.p = -1;
        this.q = new b(this);
        this.r = new c(this);
    }

    public static final /* synthetic */ Keva i6(TranslatorWidgetV2 r0) {
        return r0.getCache();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.l0 k6(TranslatorWidgetV2 r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetTranslatorV2Binding.a(LayoutInflater.from(r1), this);
    }
}
