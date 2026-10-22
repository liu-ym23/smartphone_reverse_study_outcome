package com.larus.uaigc.instruction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u001a\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u001a\u0010-\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0016J\u000f\u00103\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0002\u00105J\n\u00106\u001a\u0004\u0018\u00010\"H\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bRW\u0010\u001c\u001aK\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/larus/uaigc/instruction/DropFeatureSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;", "binding", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;", "dropFeatureSelectorFragment", "Lcom/larus/uaigc/instruction/DropFeatureSelectorFragment;", "controller", "Lcom/larus/uaigc/instruction/DropFeatureSelectorController;", "getController", "()Lcom/larus/uaigc/instruction/DropFeatureSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "collectStarted", "", "showCover", "dropFeatureItemSelectorCallback", "com/larus/uaigc/instruction/DropFeatureSelectorWidget$dropFeatureItemSelectorCallback$1", "Lcom/larus/uaigc/instruction/DropFeatureSelectorWidget$dropFeatureItemSelectorCallback$1;", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "", "selectImageTemplateInternal", "item", "getSendMessageTrackExtMap", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "init", "attrs", "Landroid/util/AttributeSet;", "showDropFeatureSelectorFragment", "bindObservers", "onBindView", "getImageEditFunctionId", "", "()Ljava/lang/Integer;", "getButtonName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DropFeatureSelectorWidget extends AbsInstructionWidget implements com.larus.uaigc.creation.e {
    public static final /* synthetic */ int k = 0;
    public LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding f;
    public DropFeatureSelectorFragment g;
    public boolean h;
    public final b i;
    public final t j;

    public static final class a {
    }

    public static final class b implements p {
        public final /* synthetic */ DropFeatureSelectorWidget a;

        public b(DropFeatureSelectorWidget r1) {
            this.a = r1;
        }

        @Override // com.larus.uaigc.instruction.p
        public final void a(com.larus.bmhome.actionbar.model.w r7) {
            Intrinsics.checkNotNullParameter(r7, "item");
            com.larus.bmhome.actionbar.model.h r0 = this.a.getCurrentBindData();
            com.larus.bmhome.actionbar.model.w r1 = null;
            Object r2 = null;
            r1 = null;
            boolean r3 = false;
            if (r0 == null) goto L19;
            List r4 = r0.e;
            if (r4 == null) goto L19;
            Iterator r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L18;
            Object r6 = r5.next();
            Integer r8 = ((com.larus.bmhome.actionbar.model.w) r6).s;
            if (r8 != null) goto L13;
        L15:
            boolean r9 = false;
        L16:
            if (r9 == false) goto L8;
            r2 = r6;
            goto L18
        L13:
            if (r8.intValue() != 1) goto L15;
            r9 = true;
        L18:
            r1 = (com.larus.bmhome.actionbar.model.w) r2;
        L19:
            com.larus.bmhome.actionbar.model.u r10 = this.a.getInstructionItem();
            if (r10 == null) goto L27;
            Integer r11 = r10.a;
            if (r11 == null) goto L27;
            if (r11.intValue() != 1) goto L27;
            boolean r12 = true;
        L28:
            if (r12 == false) goto L35;
            com.larus.bmhome.view.actionbar.edit.c r13 = this.a.getViewModel();
            if (r13 == null) goto L35;
            if (r1 == null) goto L33;
            boolean r14 = true;
        L34:
            r13.setImageStyleRadioSelected(r14);
            goto L35
        L33:
            r14 = false;
        L35:
            q r15 = DropFeatureSelectorWidget.i6(this.a);
            if (r15 == null) goto L43;
            Integer r16 = ((up8.b) r15).g;
            if (r16 == null) goto L43;
            if (r16.intValue() != 18) goto L43;
            r3 = true;
        L43:
            if (r3 == false) goto L57;
            Integer r17 = r7.s;
            if (r17 != null) goto L48;
        L50:
            Long r18 = r7.a;
            if (r18 == null) goto L53;
            long r19 = r18.longValue();
        L54:
            com.larus.bmhome.view.actionbar.edit.c r20 = this.a.getViewModel();
            if (r20 == null) goto L57;
            r20.selectedVideoStyleItem(r19);
        L53:
            r19 = 0;
            goto L54
        L48:
            if (r17.intValue() != 1) goto L50;
        L57:
            if (r1 == null) goto L59;
            e1.x(this.a.getBinding().f);
            this.a.getBinding().f.setText(r1.b);
            return;
        L59:
            e1.o(this.a.getBinding().f);
            return;
        L27:
            r12 = false;
            goto L28
        }

        @Override // com.larus.uaigc.instruction.p
        public final void b(com.larus.bmhome.actionbar.model.w r46, int r47) {
            Intrinsics.checkNotNullParameter(r46, "item");
            DropFeatureSelectorWidget r3 = this.a;
            int r4 = DropFeatureSelectorWidget.k;
            com.larus.bmhome.view.actionbar.edit.c r5 = r3.getViewModel();
            Object r6 = null;
            if (r5 == null) goto L7;
            ChatParam r7 = r5.getChatParam();
            if (r7 == null) goto L7;
            String r8 = r7.b;
        L8:
            com.larus.bmhome.view.actionbar.edit.c r9 = this.a.getViewModel();
            if (r9 == null) goto L13;
            ChatParam r10 = r9.getChatParam();
            if (r10 == null) goto L13;
            String r11 = r10.e;
        L14:
            com.larus.bmhome.view.actionbar.edit.c r12 = this.a.getViewModel();
            if (r12 == null) goto L17;
            String r13 = r12.getTemplateType();
        L18:
            com.larus.bmhome.view.actionbar.edit.c r14 = this.a.getViewModel();
            if (r14 == null) goto L21;
            String r15 = r14.getActionBarType();
        L22:
            com.larus.bmhome.view.actionbar.edit.c r16 = this.a.getViewModel();
            if (r16 == null) goto L27;
            z0 r17 = r16.getCurrentCustomActionBarItem();
            if (r17 == null) goto L27;
            String r18 = r17.b;
        L28:
            com.larus.bmhome.actionbar.model.u r19 = this.a.getInstructionItem();
            if (r19 == null) goto L31;
            String r110 = r19.c;
        L32:
            com.larus.bmhome.actionbar.model.h r20 = this.a.getCurrentBindData();
            if (r20 == null) goto L35;
            String r111 = r20.c;
        L36:
            String r112 = r46.b;
            String r113 = String.valueOf(r46.a);
            com.larus.bmhome.actionbar.model.h r21 = this.a.getCurrentBindData();
            if (r21 == null) goto L44;
            Integer r22 = r21.f;
            if (r22 == null) goto L44;
            if (r47 != r22.intValue()) goto L44;
            int r23 = 1;
        L45:
            Integer r114 = Integer.valueOf(r23);
            Integer r115 = Integer.valueOf(r47 + 1);
            Integer r1 = r46.s;
            if (r1 != null) goto L49;
        L51:
            String r2 = "cancel";
        L52:
            String r116 = r2;
            com.larus.bmhome.view.actionbar.edit.c r24 = this.a.getViewModel();
            if (r24 == null) goto L57;
            ChatParam r25 = r24.getChatParam();
            if (r25 == null) goto L57;
            String r28 = r25.c;
        L58:
            com.larus.bmhome.view.actionbar.edit.c r26 = this.a.getViewModel();
            if (r26 == null) goto L61;
            Boolean r29 = r26.isCreationActionBar();
        L62:
            boolean r27 = true;
            tx9.b.e(r8, r11, r13, r15, r18, r110, r111, r112, r113, r114, 1, r115, r116, null, null, null, null, "original", null, null, null, null, null, r28, r29, null, null, null, null, null, null, null, null, null, null, null, null, -50601984, 127);
            com.larus.bmhome.actionbar.model.h r30 = this.a.getCurrentBindData();
            if (r30 == null) goto L79;
            List r31 = r30.e;
            if (r31 == null) goto L79;
            Iterator r32 = r31.iterator();
        L68:
            if (r32.hasNext() == false) goto L78;
            Object r33 = r32.next();
            Integer r34 = ((com.larus.bmhome.actionbar.model.w) r33).s;
            if (r34 != null) goto L73;
        L75:
            boolean r117 = false;
        L76:
            if (r117 == false) goto L68;
            r6 = r33;
            goto L78
        L73:
            if (r34.intValue() != 1) goto L75;
            r117 = true;
        L78:
            r6 = (com.larus.bmhome.actionbar.model.w) r6;
        L79:
            com.larus.bmhome.view.actionbar.edit.c r35 = this.a.getViewModel();
            if (r35 == null) goto L91;
            if (r6 != null) goto L84;
            r27 = false;
        L84:
            r35.setImageStyleRadioSelected(r27);
            return;
        L91:
            return;
        L61:
            r29 = null;
        L57:
            r28 = null;
            goto L58
        L49:
            if (r1.intValue() != 1) goto L51;
            r2 = "select";
        L44:
            r23 = 0;
            goto L45
        L35:
            r111 = null;
            goto L36
        L31:
            r110 = null;
        L27:
            r18 = null;
            goto L28
        L21:
            r15 = null;
            goto L22
        L17:
            r13 = null;
        L13:
            r11 = null;
        L7:
            r8 = null;
            goto L8
        }

        @Override // com.larus.uaigc.instruction.p
        public final void c(com.larus.bmhome.actionbar.model.w r29, int r30) {
            Intrinsics.checkNotNullParameter(r29, "item");
            DropFeatureSelectorWidget r3 = this.a;
            int r4 = DropFeatureSelectorWidget.k;
            com.larus.bmhome.view.actionbar.edit.c r5 = r3.getViewModel();
            Boolean r6 = null;
            if (r5 == null) goto L7;
            ChatParam r7 = r5.getChatParam();
            if (r7 == null) goto L7;
            String r8 = r7.b;
        L8:
            com.larus.bmhome.view.actionbar.edit.c r9 = this.a.getViewModel();
            if (r9 == null) goto L13;
            ChatParam r10 = r9.getChatParam();
            if (r10 == null) goto L13;
            String r11 = r10.e;
        L14:
            com.larus.bmhome.view.actionbar.edit.c r12 = this.a.getViewModel();
            if (r12 == null) goto L17;
            String r13 = r12.getTemplateType();
        L18:
            com.larus.bmhome.view.actionbar.edit.c r14 = this.a.getViewModel();
            if (r14 == null) goto L21;
            String r15 = r14.getActionBarType();
        L22:
            com.larus.bmhome.view.actionbar.edit.c r16 = this.a.getViewModel();
            if (r16 == null) goto L27;
            z0 r17 = r16.getCurrentCustomActionBarItem();
            if (r17 == null) goto L27;
            String r18 = r17.b;
        L28:
            com.larus.bmhome.actionbar.model.u r19 = this.a.getInstructionItem();
            if (r19 == null) goto L31;
            String r110 = r19.c;
        L32:
            com.larus.bmhome.actionbar.model.h r20 = this.a.getCurrentBindData();
            if (r20 == null) goto L35;
            String r111 = r20.c;
        L36:
            String r112 = r29.b;
            String r113 = String.valueOf(r29.a);
            com.larus.bmhome.actionbar.model.h r1 = this.a.getCurrentBindData();
            if (r1 == null) goto L44;
            Integer r2 = r1.f;
            if (r2 == null) goto L44;
            if (r30 != r2.intValue()) goto L44;
            int r21 = 1;
        L45:
            Integer r114 = Integer.valueOf(r21);
            Integer r115 = Integer.valueOf(r30 + 1);
            com.larus.bmhome.view.actionbar.edit.c r22 = this.a.getViewModel();
            if (r22 == null) goto L50;
            ChatParam r23 = r22.getChatParam();
            if (r23 == null) goto L50;
            String r25 = r23.c;
        L51:
            com.larus.bmhome.view.actionbar.edit.c r24 = this.a.getViewModel();
            if (r24 == null) goto L54;
            r6 = r24.isCreationActionBar();
        L54:
            tx9.b.f(r8, r11, r13, r15, r18, r110, r111, r112, r113, r114, 1, r115, null, null, null, null, null, null, null, null, r25, r6, 2093056);
            return;
        L50:
            r25 = null;
        L44:
            r21 = 0;
            goto L45
        L35:
            r111 = null;
            goto L36
        L31:
            r110 = null;
        L27:
            r18 = null;
            goto L28
        L21:
            r15 = null;
            goto L22
        L17:
            r13 = null;
        L13:
            r11 = null;
        L7:
            r8 = null;
            goto L8
        }
    }

    static {
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        return 0;
    }

    public final void Y5() {
        com.larus.bmhome.actionbar.model.w r2 = null;
        Object r3 = null;
        r2 = null;
        if (this.h == true) goto L17;
        this.h = true;
        CoroutineScope r4 = getComponentScope();
        if (r4 == null) goto L8;
        BuildersKt.launch$default(r4, null, null, new DropFeatureSelectorWidget$bindObservers$1(this, null), 3, null);
    L8:
        CoroutineScope r9 = getComponentScope();
        if (r9 == null) goto L11;
        BuildersKt.launch$default(r9, null, null, new DropFeatureSelectorWidget$bindObservers$2(this, null), 3, null);
    L11:
        CoroutineScope r5 = getComponentScope();
        if (r5 == null) goto L14;
        BuildersKt.launch$default(r5, null, null, new DropFeatureSelectorWidget$bindObservers$3(this, null), 3, null);
    L14:
        CoroutineScope r10 = getComponentScope();
        if (r10 == null) goto L17;
        BuildersKt.launch$default(r10, null, null, new DropFeatureSelectorWidget$bindObservers$4(this, null), 3, null);
    L17:
        com.larus.bmhome.actionbar.model.u r0 = getInstructionItem();
        if (r0 == null) goto L20;
        String r1 = r0.c;
    L22:
        if (o0.d(r1) == false) goto L28;
        AppCompatTextView r6 = getBinding().d;
        com.larus.bmhome.actionbar.model.u r7 = getInstructionItem();
        if (r7 == null) goto L26;
        String r8 = r7.c;
    L27:
        r6.setText(r8);
        e1.x(getBinding().d);
        goto L28
    L26:
        r8 = null;
    L28:
        com.larus.bmhome.actionbar.model.h r11 = getCurrentBindData();
        if (r11 == null) goto L31;
        getBinding().e.setText(r11.c);
        e1.x(getBinding().e);
    L31:
        e1.d(getBinding().c, new s(this));
        DropFeatureSelectorFragment r12 = new DropFeatureSelectorFragment();
        com.larus.bmhome.actionbar.model.h r13 = getCurrentBindData();
        if (r13 == null) goto L34;
        b r14 = this.i;
        Intrinsics.checkNotNullParameter(r13, "currentBindData");
        Intrinsics.checkNotNullParameter(r14, "dropFeatureSelectorCallback");
        r12.g = r13;
        r12.h = r14;
    L34:
        this.g = r12;
        com.larus.bmhome.actionbar.model.h r15 = getCurrentBindData();
        if (r15 == null) goto L51;
        List r16 = r15.e;
        if (r16 == null) goto L51;
        Iterator r17 = r16.iterator();
    L40:
        if (r17.hasNext() == false) goto L50;
        Object r18 = r17.next();
        Integer r19 = ((com.larus.bmhome.actionbar.model.w) r18).s;
        if (r19 != null) goto L45;
    L47:
        boolean r20 = false;
    L48:
        if (r20 == false) goto L40;
        r3 = r18;
        goto L50
    L45:
        if (r19.intValue() != 1) goto L47;
        r20 = true;
    L50:
        r2 = (com.larus.bmhome.actionbar.model.w) r3;
    L51:
        if (r2 == null) goto L53;
        e1.x(getBinding().f);
        getBinding().f.setText(r2.b);
    L54:
        com.larus.bmhome.view.actionbar.edit.c r21 = getViewModel();
        if (r21 == null) goto L63;
        r21.onComponentVisibilityChanged(this, true);
        return;
    L63:
        return;
    L53:
        e1.o(getBinding().f);
        goto L54
    L20:
        r1 = null;
        goto L22
    }

    public final LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding getBinding() {
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final q getController() {
        return (q) getController();
    }

    @Override // com.larus.uaigc.creation.e
    public String getButtonName() {
        com.larus.bmhome.actionbar.model.h r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final com.larus.bmhome.actionbar.model.h getCurrentBindData() {
        q r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    @Override // com.larus.uaigc.creation.e
    public Integer getImageEditFunctionId() {
        com.larus.bmhome.actionbar.model.h r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public DropFeatureSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.i = new b(this);
        this.j = new t(this);
    }

    public static final /* synthetic */ q i6(DropFeatureSelectorWidget r0) {
        return r0.getController();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding.a(LayoutInflater.from(r1), this);
    }
}
