package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.fragment.FeatureSelectorFragment;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetFeatureSelectorBinding;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0002\u001b\u001e\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0019H\u0002J\u000f\u0010$\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0002\u0010&J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006*"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/FeatureSelectorWidgetV2;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetFeatureSelectorBinding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetFeatureSelectorBinding;", "adapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidgetAdapterV2;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/FeatureSelectorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/FeatureSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarFeatureSelectorTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarFeatureSelectorTemplate;", "featureSelectorFragment", "Lcom/larus/bmhome/view/actionbar/edit/fragment/FeatureSelectorFragment;", "onBindView", "", "itemSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/FeatureSelectorWidgetV2$itemSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/FeatureSelectorWidgetV2$itemSelectedCallback$1;", "featureItemSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/FeatureSelectorWidgetV2$featureItemSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/FeatureSelectorWidgetV2$featureItemSelectedCallback$1;", "init", "attrs", "Landroid/util/AttributeSet;", "showFeatureSelectorFragment", "getImageEditFunctionId", "", "()Ljava/lang/Integer;", "getButtonName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorWidgetV2 extends AbsInstructionWidget implements com.larus.uaigc.creation.e {
    public static final /* synthetic */ int k = 0;
    public LarusLayoutActionBarEditorWidgetFeatureSelectorBinding f;
    public DropdownSelectorWidgetAdapterV2 g;
    public FeatureSelectorFragment h;
    public final c i;
    public final b j;

    public static final class a {
    }

    public static final class b implements m1 {
        public final /* synthetic */ FeatureSelectorWidgetV2 a;

        @Override // com.larus.bmhome.view.actionbar.edit.component.m1
        public final void a() {
            FeatureSelectorWidgetV2 r0 = this.a;
            int r1 = FeatureSelectorWidgetV2.k;
            com.larus.bmhome.view.actionbar.edit.c r2 = r0.getViewModel();
            if (r2 == null) goto L6;
            r2.onFeatureOptionDialogDismiss();
            return;
        }

        public b(FeatureSelectorWidgetV2 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.m1
        public final void b(Integer r51, com.larus.bmhome.actionbar.model.w r52) {
            FeatureSelectorWidgetV2 r2 = this.a;
            int r3 = FeatureSelectorWidgetV2.k;
            com.larus.bmhome.view.actionbar.edit.c r4 = r2.getViewModel();
            if (r4 == null) goto L5;
            r4.onFeatureOptionUnSelected(r52);
        L5:
            com.larus.bmhome.actionbar.model.k r5 = this.a.getCurrentBindData();
            if (r5 == null) goto L76;
            List r6 = r5.b;
            if (r6 == null) goto L86;
            FeatureSelectorWidgetV2 r7 = this.a;
            Iterator r8 = r6.iterator();
        L11:
            if (r8.hasNext() == false) goto L87;
            com.larus.bmhome.actionbar.model.t r9 = (com.larus.bmhome.actionbar.model.t) r8.next();
            if (Intrinsics.areEqual(r9.a, r51) == false) goto L11;
            List r10 = r9.c;
            if (r10 == null) goto L11;
            Iterator r11 = r10.iterator();
            int r12 = 0;
        L18:
            if (r11.hasNext() == false) goto L11;
            Object r13 = r11.next();
            int r14 = r12 + 1;
            if (r12 >= 0) goto L22;
            CollectionsKt.throwIndexOverflow();
        L22:
            com.larus.bmhome.actionbar.model.w r15 = (com.larus.bmhome.actionbar.model.w) r13;
            Long r16 = r15.a;
            Boolean r17 = null;
            if (r52 == null) goto L25;
            Long r18 = r52.a;
        L27:
            if (Intrinsics.areEqual(r16, r18) == false) goto L74;
            r15.s = 0;
            com.larus.bmhome.view.actionbar.edit.c r19 = r7.getViewModel();
            if (r19 == null) goto L33;
            ChatParam r20 = r19.getChatParam();
            if (r20 == null) goto L33;
            String r110 = r20.b;
        L34:
            com.larus.bmhome.view.actionbar.edit.c r21 = r7.getViewModel();
            if (r21 == null) goto L39;
            ChatParam r22 = r21.getChatParam();
            if (r22 == null) goto L39;
            String r111 = r22.e;
        L40:
            com.larus.bmhome.view.actionbar.edit.c r23 = r7.getViewModel();
            if (r23 == null) goto L43;
            String r112 = r23.getTemplateType();
        L44:
            com.larus.bmhome.view.actionbar.edit.c r24 = r7.getViewModel();
            if (r24 == null) goto L47;
            String r113 = r24.getActionBarType();
        L48:
            com.larus.bmhome.view.actionbar.edit.c r25 = r7.getViewModel();
            if (r25 == null) goto L53;
            com.larus.bmhome.actionbar.model.z0 r26 = r25.getCurrentCustomActionBarItem();
            if (r26 == null) goto L53;
            String r114 = r26.b;
        L54:
            com.larus.bmhome.actionbar.model.u r27 = r7.getInstructionItem();
            if (r27 == null) goto L57;
            String r115 = r27.c;
        L58:
            com.larus.bmhome.actionbar.model.k r28 = r7.getCurrentBindData();
            if (r28 == null) goto L63;
            com.larus.bmhome.actionbar.model.q r29 = r28.a;
            if (r29 == null) goto L63;
            String r116 = r29.b;
        L64:
            String r30 = r15.b;
            String r117 = String.valueOf(r15.a);
            com.larus.bmhome.view.actionbar.edit.c r31 = r7.getViewModel();
            if (r31 == null) goto L69;
            ChatParam r32 = r31.getChatParam();
            if (r32 == null) goto L69;
            String r34 = r32.c;
        L70:
            com.larus.bmhome.view.actionbar.edit.c r33 = r7.getViewModel();
            if (r33 == null) goto L73;
            r17 = r33.isCreationActionBar();
        L73:
            tx9.b.e(r110, r111, r112, r113, r114, r115, r116, r30, r117, 0, 0, Integer.valueOf(r14), "cancel", null, null, null, null, "original", null, null, null, null, null, r34, r17, null, null, null, null, null, null, null, null, null, null, null, null, -50601984, 127);
        L75:
            r12 = r14;
        L69:
            r34 = null;
        L63:
            r116 = null;
            goto L64
        L57:
            r115 = null;
        L53:
            r114 = null;
            goto L54
        L47:
            r113 = null;
            goto L48
        L43:
            r112 = null;
        L39:
            r111 = null;
        L33:
            r110 = null;
            goto L34
        L74:
            r15.s = 1;
            goto L75
        L25:
            r18 = null;
            goto L27
        L87:
            return;
        L86:
            return;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.m1
        public final void c(int r28, com.larus.bmhome.actionbar.model.w r29) {
            FeatureSelectorWidgetV2 r2 = this.a;
            int r3 = FeatureSelectorWidgetV2.k;
            com.larus.bmhome.view.actionbar.edit.c r4 = r2.getViewModel();
            Boolean r5 = null;
            if (r4 == null) goto L7;
            ChatParam r6 = r4.getChatParam();
            if (r6 == null) goto L7;
            String r7 = r6.b;
        L8:
            com.larus.bmhome.view.actionbar.edit.c r8 = this.a.getViewModel();
            if (r8 == null) goto L13;
            ChatParam r9 = r8.getChatParam();
            if (r9 == null) goto L13;
            String r10 = r9.e;
        L14:
            com.larus.bmhome.view.actionbar.edit.c r11 = this.a.getViewModel();
            if (r11 == null) goto L17;
            String r12 = r11.getTemplateType();
        L18:
            com.larus.bmhome.view.actionbar.edit.c r13 = this.a.getViewModel();
            if (r13 == null) goto L21;
            String r14 = r13.getActionBarType();
        L22:
            com.larus.bmhome.view.actionbar.edit.c r15 = this.a.getViewModel();
            if (r15 == null) goto L27;
            com.larus.bmhome.actionbar.model.z0 r16 = r15.getCurrentCustomActionBarItem();
            if (r16 == null) goto L27;
            String r17 = r16.b;
        L28:
            com.larus.bmhome.actionbar.model.u r18 = this.a.getInstructionItem();
            if (r18 == null) goto L31;
            String r19 = r18.c;
        L32:
            com.larus.bmhome.actionbar.model.k r20 = this.a.getCurrentBindData();
            if (r20 == null) goto L37;
            com.larus.bmhome.actionbar.model.q r21 = r20.a;
            if (r21 == null) goto L37;
            String r110 = r21.b;
        L38:
            String r111 = r29.b;
            String r112 = String.valueOf(r29.a);
            Integer r113 = Integer.valueOf(r28 + 1);
            com.larus.bmhome.view.actionbar.edit.c r1 = this.a.getViewModel();
            if (r1 == null) goto L43;
            ChatParam r22 = r1.getChatParam();
            if (r22 == null) goto L43;
            String r24 = r22.c;
        L44:
            com.larus.bmhome.view.actionbar.edit.c r23 = this.a.getViewModel();
            if (r23 == null) goto L47;
            r5 = r23.isCreationActionBar();
        L47:
            tx9.b.f(r7, r10, r12, r14, r17, r19, r110, r111, r112, 0, 0, r113, null, null, null, null, null, null, null, null, r24, r5, 2093056);
            return;
        L43:
            r24 = null;
        L37:
            r110 = null;
            goto L38
        L31:
            r19 = null;
        L27:
            r17 = null;
            goto L28
        L21:
            r14 = null;
            goto L22
        L17:
            r12 = null;
        L13:
            r10 = null;
        L7:
            r7 = null;
            goto L8
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.m1
        public final void d(Integer r51, com.larus.bmhome.actionbar.model.w r52) {
            FeatureSelectorWidgetV2 r2 = this.a;
            int r3 = FeatureSelectorWidgetV2.k;
            com.larus.bmhome.view.actionbar.edit.c r4 = r2.getViewModel();
            if (r4 == null) goto L5;
            r4.onFeatureOptionSelected(r52);
        L5:
            com.larus.bmhome.actionbar.model.k r5 = this.a.getCurrentBindData();
            if (r5 == null) goto L76;
            List r6 = r5.b;
            if (r6 == null) goto L86;
            FeatureSelectorWidgetV2 r7 = this.a;
            Iterator r8 = r6.iterator();
        L11:
            if (r8.hasNext() == false) goto L87;
            com.larus.bmhome.actionbar.model.t r9 = (com.larus.bmhome.actionbar.model.t) r8.next();
            if (Intrinsics.areEqual(r9.a, r51) == false) goto L11;
            List r10 = r9.c;
            if (r10 == null) goto L11;
            Iterator r11 = r10.iterator();
            int r12 = 0;
        L18:
            if (r11.hasNext() == false) goto L11;
            Object r13 = r11.next();
            int r14 = r12 + 1;
            if (r12 >= 0) goto L22;
            CollectionsKt.throwIndexOverflow();
        L22:
            com.larus.bmhome.actionbar.model.w r15 = (com.larus.bmhome.actionbar.model.w) r13;
            Long r16 = r15.a;
            Boolean r17 = null;
            if (r52 == null) goto L25;
            Long r18 = r52.a;
        L27:
            if (Intrinsics.areEqual(r16, r18) == false) goto L74;
            r15.s = 1;
            com.larus.bmhome.view.actionbar.edit.c r19 = r7.getViewModel();
            if (r19 == null) goto L33;
            ChatParam r20 = r19.getChatParam();
            if (r20 == null) goto L33;
            String r110 = r20.b;
        L34:
            com.larus.bmhome.view.actionbar.edit.c r21 = r7.getViewModel();
            if (r21 == null) goto L39;
            ChatParam r22 = r21.getChatParam();
            if (r22 == null) goto L39;
            String r111 = r22.e;
        L40:
            com.larus.bmhome.view.actionbar.edit.c r23 = r7.getViewModel();
            if (r23 == null) goto L43;
            String r112 = r23.getTemplateType();
        L44:
            com.larus.bmhome.view.actionbar.edit.c r24 = r7.getViewModel();
            if (r24 == null) goto L47;
            String r113 = r24.getActionBarType();
        L48:
            com.larus.bmhome.view.actionbar.edit.c r25 = r7.getViewModel();
            if (r25 == null) goto L53;
            com.larus.bmhome.actionbar.model.z0 r26 = r25.getCurrentCustomActionBarItem();
            if (r26 == null) goto L53;
            String r114 = r26.b;
        L54:
            com.larus.bmhome.actionbar.model.u r27 = r7.getInstructionItem();
            if (r27 == null) goto L57;
            String r115 = r27.c;
        L58:
            com.larus.bmhome.actionbar.model.k r28 = r7.getCurrentBindData();
            if (r28 == null) goto L63;
            com.larus.bmhome.actionbar.model.q r29 = r28.a;
            if (r29 == null) goto L63;
            String r116 = r29.b;
        L64:
            String r30 = r15.b;
            String r117 = String.valueOf(r15.a);
            com.larus.bmhome.view.actionbar.edit.c r31 = r7.getViewModel();
            if (r31 == null) goto L69;
            ChatParam r32 = r31.getChatParam();
            if (r32 == null) goto L69;
            String r34 = r32.c;
        L70:
            com.larus.bmhome.view.actionbar.edit.c r33 = r7.getViewModel();
            if (r33 == null) goto L73;
            r17 = r33.isCreationActionBar();
        L73:
            tx9.b.e(r110, r111, r112, r113, r114, r115, r116, r30, r117, 0, 0, Integer.valueOf(r14), "select", null, null, null, null, "original", null, null, null, null, null, r34, r17, null, null, null, null, null, null, null, null, null, null, null, null, -50601984, 127);
        L75:
            r12 = r14;
        L69:
            r34 = null;
        L63:
            r116 = null;
            goto L64
        L57:
            r115 = null;
        L53:
            r114 = null;
            goto L54
        L47:
            r113 = null;
            goto L48
        L43:
            r112 = null;
        L39:
            r111 = null;
        L33:
            r110 = null;
            goto L34
        L74:
            r15.s = 0;
            goto L75
        L25:
            r18 = null;
            goto L27
        L87:
            return;
        L86:
            return;
        }
    }

    public static final class c implements b1 {
        public final /* synthetic */ FeatureSelectorWidgetV2 a;

        public c(FeatureSelectorWidgetV2 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r53, com.larus.bmhome.actionbar.model.w r54, int r55) {
            Intrinsics.checkNotNullParameter(r54, "selectedSpinnerItem");
            com.larus.bmhome.actionbar.model.k r3 = this.a.getCurrentBindData();
            if (r3 == null) goto L77;
            List r4 = r3.c;
            if (r4 == null) goto L77;
            FeatureSelectorWidgetV2 r6 = this.a;
            Iterator r5 = r4.iterator();
            int r7 = 0;
            int r8 = 0;
        L8:
            if (r5.hasNext() == false) goto L76;
            Object r9 = r5.next();
            int r10 = r8 + 1;
            if (r8 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            com.larus.bmhome.actionbar.model.h r11 = (com.larus.bmhome.actionbar.model.h) r9;
            Integer r12 = r11.b;
            if (r12 == null) goto L75;
            if (r12.intValue() != r53) goto L75;
            List r13 = r11.e;
            if (r13 == null) goto L73;
            Iterator r14 = r13.iterator();
        L21:
            if (r14.hasNext() == false) goto L73;
            com.larus.bmhome.actionbar.model.w r15 = (com.larus.bmhome.actionbar.model.w) r14.next();
            if (Intrinsics.areEqual(r15.a, r54.a) == true) goto L24;
            r15.s = 0;
            goto L21
        L24:
            r15.s = 1;
            com.larus.bmhome.view.actionbar.edit.c r16 = r6.getViewModel();
            if (r16 == null) goto L29;
            ChatParam r17 = r16.getChatParam();
            if (r17 == null) goto L29;
            String r18 = r17.b;
        L30:
            com.larus.bmhome.view.actionbar.edit.c r19 = r6.getViewModel();
            if (r19 == null) goto L35;
            ChatParam r110 = r19.getChatParam();
            if (r110 == null) goto L35;
            String r111 = r110.e;
        L36:
            com.larus.bmhome.view.actionbar.edit.c r112 = r6.getViewModel();
            if (r112 == null) goto L39;
            String r113 = r112.getTemplateType();
        L40:
            com.larus.bmhome.view.actionbar.edit.c r114 = r6.getViewModel();
            if (r114 == null) goto L43;
            String r115 = r114.getActionBarType();
        L44:
            com.larus.bmhome.view.actionbar.edit.c r116 = r6.getViewModel();
            if (r116 == null) goto L49;
            com.larus.bmhome.actionbar.model.z0 r117 = r116.getCurrentCustomActionBarItem();
            if (r117 == null) goto L49;
            String r118 = r117.b;
        L50:
            com.larus.bmhome.actionbar.model.u r119 = r6.getInstructionItem();
            if (r119 == null) goto L53;
            String r120 = r119.c;
        L54:
            String r121 = r54.b;
            String r21 = String.valueOf(r54.a);
            Integer r20 = r11.f;
            if (r20 != null) goto L58;
        L60:
            int r22 = 0;
        L61:
            Integer r23 = Integer.valueOf(r22);
            Integer r24 = Integer.valueOf(!Intrinsics.areEqual(r11.h, Boolean.TRUE) ? 1 : 0);
            Integer r25 = Integer.valueOf(r55 + 1);
            com.larus.bmhome.view.actionbar.edit.c r26 = r6.getViewModel();
            if (r26 == null) goto L66;
            ChatParam r27 = r26.getChatParam();
            if (r27 == null) goto L66;
            String r36 = r27.c;
        L67:
            com.larus.bmhome.view.actionbar.edit.c r28 = r6.getViewModel();
            if (r28 == null) goto L70;
            Boolean r37 = r28.isCreationActionBar();
        L71:
            tx9.b.e(r18, r111, r113, r115, r118, r120, null, r121, r21, r23, r24, r25, "select", null, null, null, null, "original", null, null, null, null, null, r36, r37, null, null, null, null, null, null, null, null, null, null, null, null, -50601920, 127);
            goto L21
        L70:
            r37 = null;
        L66:
            r36 = null;
            goto L67
        L58:
            if (r20.intValue() != r53) goto L60;
            r22 = 1;
            goto L61
        L53:
            r120 = null;
        L49:
            r118 = null;
            goto L50
        L43:
            r115 = null;
            goto L44
        L39:
            r113 = null;
        L35:
            r111 = null;
        L29:
            r18 = null;
        L73:
            r7 = r8;
        L75:
            r8 = r10;
            goto L8
        L76:
            int r29 = r7;
        L78:
            com.larus.bmhome.actionbar.model.k r1 = this.a.getCurrentBindData();
            if (r1 == null) goto L81;
            List r30 = null;
            com.larus.bmhome.actionbar.model.k r2 = com.larus.bmhome.actionbar.model.k.d(r1, null, null, 7);
        L82:
            DropdownSelectorWidgetAdapterV2 r31 = this.a.g;
            if (r31 == null) goto L88;
            if (r2 == null) goto L86;
            List r32 = r2.c;
        L87:
            r31.submitList(r32);
            goto L88
        L86:
            r32 = r30;
        L88:
            DropdownSelectorWidgetAdapterV2 r33 = this.a.g;
            if (r33 == null) goto L101;
            r33.notifyItemChanged(r29);
            return;
        L101:
            return;
        L81:
            r30 = null;
            r2 = null;
        L77:
            r29 = 0;
            goto L78
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, com.larus.bmhome.actionbar.model.w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    static {
    }

    public Integer getImageEditFunctionId() {
        return 0;
    }

    public int getMultiItemType() {
        return 0;
    }

    public final LarusLayoutActionBarEditorWidgetFeatureSelectorBinding getBinding() {
        LarusLayoutActionBarEditorWidgetFeatureSelectorBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final xs8.h getController() {
        return (xs8.h) getController();
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        com.larus.bmhome.actionbar.model.u r0 = getInstructionItem();
        List r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.c;
    L7:
        if (com.larus.utils.o0.d(r2) == false) goto L13;
        AppCompatTextView r3 = getBinding().e;
        com.larus.bmhome.actionbar.model.u r4 = getInstructionItem();
        if (r4 == null) goto L11;
        String r5 = r4.c;
    L12:
        r3.setText(r5);
        com.larus.utils.e1.x(getBinding().e);
        goto L13
    L11:
        r5 = null;
    L13:
        AppCompatTextView r6 = getBinding().f;
        com.larus.bmhome.actionbar.model.k r7 = getCurrentBindData();
        if (r7 == null) goto L18;
        com.larus.bmhome.actionbar.model.q r8 = r7.a;
        if (r8 == null) goto L18;
        String r9 = r8.b;
    L19:
        r6.setText(r9);
        com.larus.utils.e1.d(getBinding().d, new n1(this));
        this.g = new DropdownSelectorWidgetAdapterV2(this.i, getViewModel(), getInstructionItem());
        getBinding().c.setAdapter(this.g);
        getBinding().c.addItemDecoration(new FeatureSelectorWidgetV2$onBindView$2());
        DropdownSelectorWidgetAdapterV2 r10 = this.g;
        if (r10 == null) goto L25;
        com.larus.bmhome.actionbar.model.k r11 = getCurrentBindData();
        if (r11 == null) goto L24;
        r1 = r11.c;
    L24:
        r10.submitList(r1);
    L25:
        FeatureSelectorFragment r12 = new FeatureSelectorFragment();
        com.larus.bmhome.actionbar.model.k r13 = getCurrentBindData();
        if (r13 == null) goto L30;
        List<com.larus.bmhome.actionbar.model.t> r14 = r13.b;
        if (r14 == null) goto L30;
        b r15 = this.j;
        Intrinsics.checkNotNullParameter(r14, "featureData");
        Intrinsics.checkNotNullParameter(r15, "callback");
        FLogger.a.i("FeatureSelectorFragment", "featureData Size = " + r14.size());
        r12.g = r14;
        r12.h = r15;
    L30:
        this.h = r12;
        com.larus.bmhome.view.actionbar.edit.c r16 = getViewModel();
        if (r16 == null) goto L34;
        r16.onComponentVisibilityChanged(this, true);
        return;
    L34:
        return;
    L18:
        r9 = null;
        goto L19
    L5:
        r2 = null;
        goto L7
    }

    public String getButtonName() {
        com.larus.bmhome.actionbar.model.k r0 = getCurrentBindData();
        if (r0 == null) goto L7;
        com.larus.bmhome.actionbar.model.q r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return null;
    }

    public final com.larus.bmhome.actionbar.model.k getCurrentBindData() {
        xs8.h r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    public FeatureSelectorWidgetV2(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.i = new c(this);
        this.j = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        LayoutInflater.from(r8).inflate(2131562717, this);
        int r10 = 2131364451;
        View r2 = ViewBindings.findChildViewById(this, 2131364451);
        if (r2 == null) goto L15;
        r10 = 2131370355;
        RecyclerView r3 = ViewBindings.findChildViewById(this, 2131370355);
        if (r3 == null) goto L15;
        r10 = 2131372187;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(this, 2131372187);
        if (r4 == null) goto L15;
        r10 = 2131372188;
        AppCompatTextView r5 = ViewBindings.findChildViewById(this, 2131372188);
        if (r5 == null) goto L15;
        r10 = 2131390606;
        AppCompatTextView r6 = ViewBindings.findChildViewById(this, 2131390606);
        if (r6 == null) goto L15;
        this.f = new LarusLayoutActionBarEditorWidgetFeatureSelectorBinding(this, r2, r3, r4, r5, r6);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }
}
