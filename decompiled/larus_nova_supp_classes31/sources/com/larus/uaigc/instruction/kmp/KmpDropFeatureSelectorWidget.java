package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;
import com.larus.uaigc.instruction.DropFeatureSelectorFragment;
import com.larus.uaigc.instruction.p;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import cq8.a0;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001e\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\"2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001a\u00101\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u00102\u001a\u00020*2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u00103\u001a\u00020*H\u0014J\u0010\u00104\u001a\u00020*2\u0006\u0010\u0010\u001a\u000205H\u0014J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\u000f\u0010:\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010;J\n\u0010<\u001a\u0004\u0018\u00010&H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fRW\u0010 \u001aK\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpDropFeatureSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;", "dropFeatureSelectorFragment", "Lcom/larus/uaigc/instruction/DropFeatureSelectorFragment;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/DropFeatureSelectorDescriptor;", "isBound", "", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "localBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "currentBindData", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "dropFeatureItemSelectorCallback", "com/larus/uaigc/instruction/kmp/KmpDropFeatureSelectorWidget$dropFeatureItemSelectorCallback$1", "Lcom/larus/uaigc/instruction/kmp/KmpDropFeatureSelectorWidget$dropFeatureItemSelectorCallback$1;", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "", "selectImageTemplateInternal", "item", "getSendMessageTrackExtMap", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "init", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "syncToCore", "showDropFeatureSelectorFragment", "bindObservers", "onBindView", "getImageEditFunctionId", "()Ljava/lang/Integer;", "getButtonName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpDropFeatureSelectorWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b, com.larus.uaigc.creation.e {
    public static final /* synthetic */ int o = 0;
    public LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding f;
    public DropFeatureSelectorFragment g;
    public cq8.k h;
    public boolean i;
    public com.larus.bmhome.view.actionbar.edit.c j;
    public final CoroutineScope k;
    public com.larus.bmhome.actionbar.model.h l;
    public final b m;
    public final com.larus.uaigc.instruction.kmp.b n;

    public static final class a {
    }

    public static final class b implements p {
        public final /* synthetic */ KmpDropFeatureSelectorWidget a;

        public b(KmpDropFeatureSelectorWidget r1) {
            this.a = r1;
        }

        @Override // com.larus.uaigc.instruction.p
        public final void a(w r7) {
            Intrinsics.checkNotNullParameter(r7, "item");
            com.larus.bmhome.actionbar.model.h r0 = KmpDropFeatureSelectorWidget.Y5(this.a);
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r1 = null;
            boolean r2 = false;
            if (r0 == null) goto L20;
            List r3 = r0.e;
            if (r3 == null) goto L20;
            Iterator r4 = r3.iterator();
        L8:
            if (r4.hasNext() == false) goto L18;
            Object r5 = r4.next();
            Integer r6 = ((w) r5).s;
            if (r6 != null) goto L13;
        L15:
            boolean r8 = false;
        L16:
            if (r8 == false) goto L8;
        L19:
            w r9 = (w) r5;
        L21:
            KmpDropFeatureSelectorWidget r10 = this.a;
            cq8.k r11 = r10.h;
            if (r11 != null) goto L24;
        L26:
            boolean r12 = false;
        L27:
            if (r12 == false) goto L34;
            com.larus.bmhome.view.actionbar.edit.c r13 = r10.j;
            if (r13 == null) goto L34;
            if (r9 == null) goto L32;
            boolean r14 = true;
        L33:
            r13.setImageStyleRadioSelected(r14);
            goto L34
        L32:
            r14 = false;
        L34:
            cq8.k r15 = this.a.h;
            if (r15 == null) goto L42;
            Integer r16 = r15.i;
            if (r16 == null) goto L42;
            if (r16.intValue() != 18) goto L42;
            r2 = true;
        L42:
            if (r2 == false) goto L57;
            Integer r17 = r7.s;
            if (r17 != null) goto L47;
        L49:
            Long r18 = r7.a;
            if (r18 == null) goto L52;
            long r19 = r18.longValue();
        L53:
            com.larus.bmhome.view.actionbar.edit.c r20 = this.a.j;
            if (r20 == null) goto L57;
            r20.selectedVideoStyleItem(r19);
        L52:
            r19 = 0;
            goto L53
        L47:
            if (r17.intValue() != 1) goto L49;
        L57:
            if (r9 == null) goto L66;
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r21 = this.a.f;
            if (r21 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r21 = null;
        L61:
            e1.x(r21.f);
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r22 = this.a.f;
            if (r22 != null) goto L64;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L65:
            r1.f.setText(r9.b);
        L71:
            this.a.Z5();
            return;
        L64:
            r1 = r22;
            goto L65
        L66:
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r23 = this.a.f;
            if (r23 != null) goto L69;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L70:
            e1.o(r1.f);
            goto L71
        L69:
            r1 = r23;
            goto L70
        L24:
            if (r11.h != true) goto L26;
            r12 = true;
            goto L27
        L13:
            if (r6.intValue() != 1) goto L15;
            r8 = true;
            goto L16
        L18:
            r5 = null;
        L20:
            r9 = null;
            goto L21
        }

        @Override // com.larus.uaigc.instruction.p
        public final void b(w r48, int r49) {
            Intrinsics.checkNotNullParameter(r48, "item");
            KmpDropFeatureSelectorWidget r3 = this.a;
            cq8.k r4 = r3.h;
            if (r4 == null) goto L5;
            z0 r5 = r4.j;
        L6:
            if (r5 == null) goto L8;
            String r7 = r5.a;
        L9:
            if (r5 == null) goto L11;
            String r8 = r5.c;
        L12:
            if (r5 == null) goto L14;
            String r9 = r5.d;
        L15:
            if (r5 == null) goto L17;
            String r10 = r5.f;
        L18:
            if (r5 == null) goto L20;
            String r11 = r5.g;
        L21:
            if (r5 == null) goto L23;
            String r12 = r5.j;
        L24:
            com.larus.bmhome.actionbar.model.h r6 = KmpDropFeatureSelectorWidget.Y5(r3);
            if (r6 == null) goto L27;
            String r13 = r6.c;
        L28:
            String r14 = r48.b;
            String r15 = String.valueOf(r48.a);
            com.larus.bmhome.actionbar.model.h r16 = KmpDropFeatureSelectorWidget.Y5(this.a);
            boolean r17 = false;
            if (r16 == null) goto L36;
            Integer r18 = r16.f;
            if (r18 == null) goto L36;
            if (r49 != r18.intValue()) goto L36;
            int r19 = 1;
        L37:
            Integer r110 = Integer.valueOf(r19);
            Integer r111 = Integer.valueOf(r49 + 1);
            Integer r1 = r48.s;
            if (r1 != null) goto L41;
        L43:
            String r2 = "cancel";
        L44:
            String r112 = r2;
            if (r5 == null) goto L47;
            String r30 = r5.h;
        L48:
            if (r5 == null) goto L50;
            Boolean r31 = r5.i;
        L51:
            tx9.b.e(r7, r8, r9, r10, r11, r12, r13, r14, r15, r110, 1, r111, r112, null, null, null, null, "original", null, null, null, null, null, r30, r31, null, null, null, null, null, null, null, null, null, null, null, null, -50601984, 127);
            com.larus.bmhome.actionbar.model.h r20 = KmpDropFeatureSelectorWidget.Y5(this.a);
            if (r20 == null) goto L69;
            List r21 = r20.e;
            if (r21 == null) goto L69;
            Iterator r22 = r21.iterator();
        L57:
            if (r22.hasNext() == false) goto L67;
            Object r23 = r22.next();
            Integer r24 = ((w) r23).s;
            if (r24 != null) goto L62;
        L64:
            boolean r25 = false;
        L65:
            if (r25 == false) goto L57;
            Object r46 = r23;
        L68:
            w r47 = (w) r46;
        L70:
            com.larus.bmhome.view.actionbar.edit.c r26 = this.a.j;
            if (r26 == null) goto L75;
            if (r47 == null) goto L74;
            r17 = true;
        L74:
            r26.setImageStyleRadioSelected(r17);
        L75:
            this.a.Z5();
            return;
        L62:
            if (r24.intValue() != 1) goto L64;
            r25 = true;
            goto L65
        L67:
            r46 = null;
        L69:
            r47 = null;
            goto L70
        L50:
            r31 = null;
            goto L51
        L47:
            r30 = null;
            goto L48
        L41:
            if (r1.intValue() != 1) goto L43;
            r2 = "select";
        L36:
            r19 = 0;
            goto L37
        L27:
            r13 = null;
            goto L28
        L23:
            r12 = null;
            goto L24
        L20:
            r11 = null;
            goto L21
        L17:
            r10 = null;
            goto L18
        L14:
            r9 = null;
            goto L15
        L11:
            r8 = null;
            goto L12
        L8:
            r7 = null;
            goto L9
        L5:
            r5 = null;
            goto L6
        }

        @Override // com.larus.uaigc.instruction.p
        public final void c(w r31, int r32) {
            Intrinsics.checkNotNullParameter(r31, "item");
            KmpDropFeatureSelectorWidget r3 = this.a;
            cq8.k r4 = r3.h;
            Boolean r5 = null;
            if (r4 == null) goto L5;
            z0 r6 = r4.j;
        L6:
            if (r6 == null) goto L8;
            String r7 = r6.a;
        L9:
            if (r6 == null) goto L11;
            String r8 = r6.c;
        L12:
            if (r6 == null) goto L14;
            String r9 = r6.d;
        L15:
            if (r6 == null) goto L17;
            String r10 = r6.f;
        L18:
            if (r6 == null) goto L20;
            String r11 = r6.g;
        L21:
            if (r6 == null) goto L23;
            String r12 = r6.j;
        L24:
            com.larus.bmhome.actionbar.model.h r13 = KmpDropFeatureSelectorWidget.Y5(r3);
            if (r13 == null) goto L27;
            String r14 = r13.c;
        L28:
            String r15 = r31.b;
            String r16 = String.valueOf(r31.a);
            com.larus.bmhome.actionbar.model.h r1 = KmpDropFeatureSelectorWidget.Y5(this.a);
            if (r1 == null) goto L36;
            Integer r2 = r1.f;
            if (r2 == null) goto L36;
            if (r32 != r2.intValue()) goto L36;
            int r17 = 1;
        L37:
            Integer r18 = Integer.valueOf(r17);
            Integer r19 = Integer.valueOf(r32 + 1);
            if (r6 == null) goto L40;
            String r27 = r6.h;
        L41:
            if (r6 == null) goto L43;
            r5 = r6.i;
        L43:
            tx9.b.f(r7, r8, r9, r10, r11, r12, r14, r15, r16, r18, 1, r19, null, null, null, null, null, null, null, null, r27, r5, 2093056);
            return;
        L40:
            r27 = null;
        L36:
            r17 = 0;
            goto L37
        L27:
            r14 = null;
            goto L28
        L23:
            r12 = null;
            goto L24
        L20:
            r11 = null;
            goto L21
        L17:
            r10 = null;
            goto L18
        L14:
            r9 = null;
            goto L15
        L11:
            r8 = null;
            goto L12
        L8:
            r7 = null;
            goto L9
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
    }

    public KmpDropFeatureSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpDropFeatureSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        return 0;
    }

    public final void Z5() {
        cq8.k r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.actionbar.model.h r1 = this.l;
        if (r1 == null) goto L16;
        List r2 = r1.e;
        if (r2 == null) goto L17;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        r4.add(w.a((w) r5.next(), null, null, null, null, null, null, 8388607));
        goto L11
    L13:
        r0.d.a(new cq8.j(r0.c, r4));
        return;
    L17:
        return;
    }

    @Override // com.larus.uaigc.creation.e
    public String getButtonName() {
        com.larus.bmhome.actionbar.model.h r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    @Override // com.larus.uaigc.creation.e
    public Integer getImageEditFunctionId() {
        com.larus.bmhome.actionbar.model.h r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.k, null, 1, null);
    }

    private final com.larus.bmhome.actionbar.model.h getCurrentBindData() {
        return this.l;
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.h Y5(KmpDropFeatureSelectorWidget r0) {
        return r0.getCurrentBindData();
    }

    public final void L4(com.larus.bmhome.view.actionbar.edit.c r1) {
        this.j = r1;
    }

    public final void T5(a0 r24) {
        Intrinsics.checkNotNullParameter(r24, "descriptor");
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r3 = null;
        if ((r24 instanceof cq8.k) == false) goto L5;
        cq8.k r1 = (cq8.k) r24;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        this.h = r1;
        if (this.i == true) goto L92;
        this.i = true;
        com.larus.bmhome.actionbar.model.h r4 = r1.f;
        if (r4 == null) goto L20;
        List r2 = r4.e;
        if (r2 == null) goto L18;
        List r5 = r2;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L19;
        r8.add(w.a((w) r6.next(), null, null, null, null, null, null, 8388607));
    L19:
        com.larus.bmhome.actionbar.model.h r7 = com.larus.bmhome.actionbar.model.h.a(r4, null, null, null, r8, null, null, 4079);
    L21:
        this.l = r7;
        BuildersKt.launch$default(this.k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(this.k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(this.k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$3(this, null), 3, null);
        BuildersKt.launch$default(this.k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$4(this, null), 3, null);
        cq8.k r9 = this.h;
        if (r9 == null) goto L24;
        String r10 = r9.g;
    L26:
        if (o0.d(r10) == false) goto L34;
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r11 = this.f;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L30:
        r11.d.setText(r10);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r12 = this.f;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L33:
        e1.x(r12.d);
    L34:
        com.larus.bmhome.actionbar.model.h r13 = getCurrentBindData();
        if (r13 == null) goto L43;
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r14 = this.f;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L39:
        r14.e.setText(r13.c);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r15 = this.f;
        if (r15 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L42:
        e1.x(r15.e);
    L43:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r16 = this.f;
        if (r16 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L46:
        e1.d(r16.c, new com.larus.uaigc.instruction.kmp.a(this));
        DropFeatureSelectorFragment r17 = new DropFeatureSelectorFragment();
        com.larus.bmhome.actionbar.model.h r18 = getCurrentBindData();
        if (r18 == null) goto L49;
        b r19 = this.m;
        Intrinsics.checkNotNullParameter(r18, "currentBindData");
        Intrinsics.checkNotNullParameter(r19, "dropFeatureSelectorCallback");
        r17.g = r18;
        r17.h = r19;
    L49:
        this.g = r17;
        com.larus.bmhome.actionbar.model.h r20 = getCurrentBindData();
        if (r20 == null) goto L67;
        List r21 = r20.e;
        if (r21 == null) goto L67;
        Iterator r22 = r21.iterator();
    L55:
        if (r22.hasNext() == false) goto L65;
        Object r23 = r22.next();
        Integer r25 = ((w) r23).s;
        if (r25 != null) goto L60;
    L62:
        boolean r26 = false;
    L63:
        if (r26 == false) goto L55;
    L66:
        w r27 = (w) r23;
    L68:
        if (r27 == null) goto L77;
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r28 = this.f;
        if (r28 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L72:
        e1.x(r28.f);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r29 = this.f;
        if (r29 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L76:
        r3.f.setText(r27.b);
    L82:
        com.larus.bmhome.view.actionbar.edit.c r30 = this.j;
        if (r30 == null) goto L93;
        r30.onComponentVisibilityChanged(this, true);
        return;
    L93:
        return;
    L75:
        r3 = r29;
        goto L76
    L77:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r31 = this.f;
        if (r31 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L81:
        e1.o(r3.f);
        goto L82
    L80:
        r3 = r31;
        goto L81
    L60:
        if (r25.intValue() != 1) goto L62;
        r26 = true;
        goto L63
    L65:
        r23 = null;
    L67:
        r27 = null;
        goto L68
    L24:
        r10 = null;
        goto L26
    L18:
        r8 = null;
        goto L19
    L20:
        r7 = null;
        goto L21
    L92:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    public KmpDropFeatureSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.m = new b(this);
        this.n = new com.larus.uaigc.instruction.kmp.b(this);
    }

    public static Unit V5(KmpDropFeatureSelectorWidget r11, TemplateInfo$TemplateInfo r12, Uri r13) {
        Intrinsics.checkNotNullParameter(r12, "templateInfo");
        com.larus.bmhome.actionbar.model.h r0 = r11.getCurrentBindData();
        String r3 = null;
        if (r0 == null) goto L20;
        List r1 = r0.e;
        if (r1 == null) goto L20;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        Object r4 = r2.next();
        Long r5 = ((w) r4).a;
        long r6 = r12.h;
        if (r5 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L8;
    L19:
        w r8 = (w) r4;
    L21:
        if (r8 == null) goto L43;
        com.larus.bmhome.actionbar.model.h r9 = r11.getCurrentBindData();
        if (r9 == null) goto L36;
        List r10 = r9.e;
        if (r10 == null) goto L36;
        Iterator r14 = r10.iterator();
    L28:
        if (r14.hasNext() == false) goto L36;
        w r15 = (w) r14.next();
        Long r16 = r15.a;
        long r17 = r12.h;
        if (r16 == null) goto L35;
        if (r16.longValue() != r17) goto L35;
        r15.s = 1;
    L35:
        r15.s = 0;
    L36:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r18 = r11.f;
        if (r18 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L39:
        e1.x(r18.f);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r19 = r11.f;
        if (r19 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L42:
        r19.f.setText(r8.b);
    L43:
        Fragment r20 = r11.getFragment();
        if (r20 == null) goto L69;
        Bundle r21 = r20.getArguments();
        if (r21 == null) goto L69;
        UserCreation r22 = r12.j;
        Pair[] r23 = new Pair[6];
        if (r22 == null) goto L50;
        String r24 = r22.a;
    L51:
        r23[0] = TuplesKt.to("from_template_id", r24);
        if (r22 == null) goto L54;
        String r25 = zp9.d.d(r22);
    L55:
        r23[1] = TuplesKt.to("from_template_type", r25);
        if (r22 == null) goto L60;
        UserCreationTrackParams r26 = r22.n;
        if (r26 == null) goto L60;
        String r27 = r26.a;
    L61:
        r23[2] = TuplesKt.to("template_rec_req_id", r27);
        if (r22 == null) goto L64;
        String r28 = zp9.d.b(r22);
    L65:
        r23[3] = TuplesKt.to("from_template_source", r28);
        r23[4] = TuplesKt.to("is_from_template", "1");
        if (r22 == null) goto L68;
        r3 = r22.i;
    L68:
        r23[5] = TuplesKt.to("template_rec_extra", r3);
        r21.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(r23)));
        goto L69
    L64:
        r28 = null;
    L60:
        r27 = null;
        goto L61
    L54:
        r25 = null;
        goto L55
    L50:
        r24 = null;
    L69:
        com.larus.bmhome.actionbar.model.h r29 = r11.getCurrentBindData();
        if (r29 == null) goto L76;
        List<w> r30 = r29.e;
        if (r30 == null) goto L76;
        DropFeatureSelectorFragment r31 = r11.g;
        if (r31 == null) goto L76;
        int r32 = DropFeatureSelectorFragment.l;
        r31.S90(r30, true);
    L76:
        r11.Z5();
        com.larus.bmhome.view.actionbar.edit.c r110 = r11.j;
        if (r110 == null) goto L80;
        r110.onInstructionImageTemplateSelected(r12, r13);
    L80:
        return Unit.INSTANCE;
    L13:
        if (r5.longValue() != r6) goto L15;
        r7 = true;
        goto L16
    L18:
        r4 = null;
    L20:
        r8 = null;
        goto L21
    }

    public /* synthetic */ KmpDropFeatureSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
