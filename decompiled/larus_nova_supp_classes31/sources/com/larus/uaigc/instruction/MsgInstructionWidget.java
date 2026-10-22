package com.larus.uaigc.instruction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.impl.databinding.LarusItemActionBarMsgInstructionV2Binding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u000f\u0010 \u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010\"J\n\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/larus/uaigc/instruction/MsgInstructionWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionBarMsgInstructionV2Binding;", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusItemActionBarMsgInstructionV2Binding;", "binding$delegate", "Lkotlin/Lazy;", "isBeautyDowngrade", "", "isBeautyDowngrade$impl_mainlandRelease", "()Z", "controller", "Lcom/larus/uaigc/instruction/MsgInstructionController;", "getController", "()Lcom/larus/uaigc/instruction/MsgInstructionController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "refreshUI", "data", "getImageEditFunctionId", "", "()Ljava/lang/Integer;", "getButtonName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MsgInstructionWidget extends AbsInstructionWidget implements com.larus.uaigc.creation.e {
    public static final /* synthetic */ int g = 0;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        return 0;
    }

    private final LarusItemActionBarMsgInstructionV2Binding getBinding() {
        return (LarusItemActionBarMsgInstructionV2Binding) this.f.getValue();
    }

    private final u getController() {
        return (u) getController();
    }

    private final p1 getCurrentBindData() {
        u r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    public final void Y5() {
        e1.d(getBinding().a, new w(this));
        p1 r0 = getCurrentBindData();
        if (r0 == null) goto L5;
        o6(r0);
    L5:
        CoroutineScope r1 = getComponentScope();
        if (r1 == null) goto L8;
        BuildersKt.launch$default(r1, null, null, new MsgInstructionWidget$onBindView$3(this, null), 3, null);
    L8:
        CoroutineScope r7 = getComponentScope();
        if (r7 == null) goto L12;
        BuildersKt.launch$default(r7, null, null, new MsgInstructionWidget$onBindView$4(this, null), 3, null);
        return;
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

    public MsgInstructionWidget(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.f = LazyKt.lazy(new v(r4, this));
    }

    public static final /* synthetic */ u k6(MsgInstructionWidget r0) {
        return r0.getController();
    }

    public static final /* synthetic */ p1 n6(MsgInstructionWidget r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o6(p1 r8) {
        boolean r1 = true;
        int r2 = 0;
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (Intrinsics.areEqual(r8.f, Boolean.TRUE) == false) goto L18;
        com.larus.bmhome.view.actionbar.edit.c r3 = getViewModel();
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
        com.larus.bmhome.view.actionbar.edit.c r7 = getViewModel();
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

    public static Unit i6(MsgInstructionWidget r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r2.getClass();
        if (Intrinsics.areEqual(PollingConfigService.a.f("cre_bty_dg"), "1") == false) goto L5;
        x.a(r3.getContext());
        return Unit.INSTANCE;
    L5:
        p1 r4 = r2.getCurrentBindData();
        if (r4 == null) goto L11;
        com.larus.bmhome.view.actionbar.edit.c r5 = r2.getViewModel();
        if (r5 == null) goto L11;
        r5.onMsgInstructionClicked(r4);
    L11:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        setVisibility(8);
    }
}
