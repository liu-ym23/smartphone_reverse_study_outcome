package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.impl.databinding.LarusItemActionBarMsgInstructionV2Binding;
import com.larus.uaigc.instruction.MsgInstructionWidget;
import com.larus.uaigc.instruction.x;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import cq8.a0;
import cq8.j0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.i1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010 \u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\"\u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010#\u001a\u00020!H\u0014J\u0010\u0010$\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001dH\u0002J\u000f\u0010)\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpMsgInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionBarMsgInstructionV2Binding;", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusItemActionBarMsgInstructionV2Binding;", "binding$delegate", "Lkotlin/Lazy;", "isBeautyDowngrade", "", "()Z", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/MsgInstructionDescriptor;", "isBound", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "init", "", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onBindView", "refreshUI", "data", "getImageEditFunctionId", "()Ljava/lang/Integer;", "getButtonName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpMsgInstructionWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b, com.larus.uaigc.creation.e {
    public static final /* synthetic */ int k = 0;
    public final Lazy f;
    public j0 g;
    public boolean h;
    public com.larus.bmhome.view.actionbar.edit.c i;
    public final CoroutineScope j;

    public static final class a {
    }

    static {
    }

    public KmpMsgInstructionWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpMsgInstructionWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        return 0;
    }

    private final LarusItemActionBarMsgInstructionV2Binding getBinding() {
        return (LarusItemActionBarMsgInstructionV2Binding) this.f.getValue();
    }

    private final p1 getCurrentBindData() {
        j0 r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    @Override // com.larus.uaigc.creation.e
    public String getButtonName() {
        p1 r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.larus.uaigc.creation.e
    public Integer getImageEditFunctionId() {
        p1 r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.j, null, 1, null);
    }

    public static final /* synthetic */ p1 Y5(KmpMsgInstructionWidget r0) {
        return r0.getCurrentBindData();
    }

    public final void L4(com.larus.bmhome.view.actionbar.edit.c r1) {
        this.i = r1;
    }

    public final void T5(a0 r19) {
        Intrinsics.checkNotNullParameter(r19, "descriptor");
        if ((r19 instanceof j0) == false) goto L5;
        j0 r1 = (j0) r19;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        this.g = r1;
        if (this.h == true) goto L14;
        this.h = true;
        e1.d(getBinding().a, new k(this));
        p1 r2 = getCurrentBindData();
        if (r2 == null) goto L13;
        Z5(r2);
    L13:
        BuildersKt.launch$default(this.j, null, null, new KmpMsgInstructionWidget$onBindView$3(this, null), 3, null);
        BuildersKt.launch$default(this.j, null, null, new KmpMsgInstructionWidget$onBindView$4(this, null), 3, null);
        BuildersKt.launch$default(this.j, null, null, new KmpMsgInstructionWidget$onBindView$5(this, null), 3, null);
        return;
    L14:
        p1 r3 = getCurrentBindData();
        if (r3 == null) goto L19;
        Z5(r3);
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5(p1 r8) {
        boolean r1 = true;
        int r2 = 0;
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (Intrinsics.areEqual(r8.f, Boolean.TRUE) == false) goto L18;
        com.larus.bmhome.view.actionbar.edit.c r3 = this.i;
        if (r3 == null) goto L15;
        i1 r4 = r3.getMediaSelectedFlow();
        if (r4 == null) goto L15;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        e1.o(this);
    L20:
        if (getVisibility() != 0) goto L22;
        boolean r6 = true;
    L23:
        if (r0 == r6) goto L31;
        com.larus.bmhome.view.actionbar.edit.c r7 = this.i;
        if (r7 == null) goto L31;
        if (getVisibility() == 0) goto L30;
        r1 = false;
    L30:
        r7.onComponentVisibilityChanged(this, r1);
    L31:
        getBinding().b.setText(r8.b);
        boolean r9 = v19.h.a;
        boolean r10 = v19.h.b(getContext());
        e1.x(getBinding().c);
        int r11 = 16;
        String r12 = null;
        if (r10 == false) goto L71;
        g1 r13 = r8.e;
        if (r13 == null) goto L36;
        String r14 = r13.b;
    L38:
        if (o0.d(r14) == false) goto L71;
        SimpleDraweeView r15 = getBinding().c;
        g1 r16 = r8.e;
        if (r16 == null) goto L42;
        r12 = r16.b;
    L42:
        ImageLoaderKt.u(r15, r12, "msg_instruction");
        g1 r17 = r8.e;
        if (r17 == null) goto L47;
        Integer r18 = r17.c;
        if (r18 == null) goto L47;
        int r19 = r18.intValue();
    L48:
        if (r19 <= 0) goto L112;
        g1 r20 = r8.e;
        if (r20 == null) goto L54;
        Integer r21 = r20.d;
        if (r21 == null) goto L54;
        r2 = r21.intValue();
    L54:
        if (r2 <= 0) goto L113;
        SimpleDraweeView r22 = getBinding().c;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L70;
        g1 r24 = r8.e;
        if (r24 == null) goto L62;
        Integer r25 = r24.c;
        if (r25 == null) goto L62;
        int r26 = r25.intValue();
    L63:
        r23.width = c7.b(Integer.valueOf(r26));
        g1 r27 = r8.e;
        if (r27 == null) goto L68;
        Integer r28 = r27.d;
        if (r28 == null) goto L68;
        r11 = r28.intValue();
    L68:
        r23.height = c7.b(Integer.valueOf(r11));
        r22.setLayoutParams(r23);
        return;
    L62:
        r26 = 16;
        goto L63
    L70:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L113:
        return;
    L112:
        return;
    L47:
        r19 = 0;
        goto L48
    L36:
        r14 = null;
    L71:
        if (r10 == true) goto L110;
        g1 r29 = r8.d;
        if (r29 == null) goto L75;
        String r30 = r29.b;
    L77:
        if (o0.d(r30) == false) goto L110;
        SimpleDraweeView r31 = getBinding().c;
        g1 r32 = r8.d;
        if (r32 == null) goto L81;
        r12 = r32.b;
    L81:
        ImageLoaderKt.u(r31, r12, "msg_instruction");
        g1 r33 = r8.d;
        if (r33 == null) goto L86;
        Integer r34 = r33.c;
        if (r34 == null) goto L86;
        int r35 = r34.intValue();
    L87:
        if (r35 <= 0) goto L115;
        g1 r36 = r8.d;
        if (r36 == null) goto L93;
        Integer r37 = r36.d;
        if (r37 == null) goto L93;
        r2 = r37.intValue();
    L93:
        if (r2 <= 0) goto L116;
        SimpleDraweeView r38 = getBinding().c;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if (r39 == null) goto L109;
        g1 r40 = r8.d;
        if (r40 == null) goto L101;
        Integer r41 = r40.c;
        if (r41 == null) goto L101;
        int r42 = r41.intValue();
    L102:
        r39.width = c7.b(Integer.valueOf(r42));
        g1 r43 = r8.d;
        if (r43 == null) goto L107;
        Integer r44 = r43.d;
        if (r44 == null) goto L107;
        r11 = r44.intValue();
    L107:
        r39.height = c7.b(Integer.valueOf(r11));
        r38.setLayoutParams(r39);
        return;
    L101:
        r42 = 16;
        goto L102
    L109:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L116:
        return;
    L115:
        return;
    L86:
        r35 = 0;
        goto L87
    L75:
        r30 = null;
    L110:
        e1.o(getBinding().c);
        return;
    L22:
        r6 = false;
    L15:
        r5 = false;
    L18:
        e1.x(this);
        goto L20
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit V5(KmpMsgInstructionWidget r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getClass();
        new MsgInstructionWidget(r2.getContext());
        if (Intrinsics.areEqual(PollingConfigService.a.f("cre_bty_dg"), "1") == false) goto L5;
        x.a(r3.getContext());
        return Unit.INSTANCE;
    L5:
        p1 r4 = r2.getCurrentBindData();
        if (r4 == null) goto L11;
        com.larus.bmhome.view.actionbar.edit.c r5 = r2.i;
        if (r5 == null) goto L11;
        r5.onMsgInstructionClicked(r4);
    L11:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        setVisibility(8);
    }

    public KmpMsgInstructionWidget(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = LazyKt.lazy(new l(r2, this));
        this.j = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    public /* synthetic */ KmpMsgInstructionWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
