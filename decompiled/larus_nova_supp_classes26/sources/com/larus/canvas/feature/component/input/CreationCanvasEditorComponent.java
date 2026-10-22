package com.larus.canvas.feature.component.input;

import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.canvas.feature.component.instruction.model.UIInstructionTab;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J9\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020+H\u0016J\u0018\u0010.\u001a\u00020\u00182\u0006\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020'H\u0016J\u0018\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020$H\u0016J\b\u00107\u001a\u00020\u0018H\u0002J\b\u00108\u001a\u000209H\u0016J\n\u0010:\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u000209H\u0016J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>H\u0016J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010/\u001a\u00020+H\u0016J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020'H\u0016J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020?0>2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0>H\u0016J\b\u0010E\u001a\u00020'H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006F"}, d2 = {"Lcom/larus/canvas/feature/component/input/CreationCanvasEditorComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "<init>", "()V", "canvasInputAbility", "Lcom/larus/canvas/feature/ability/CanvasInputAbility;", "getCanvasInputAbility", "()Lcom/larus/canvas/feature/ability/CanvasInputAbility;", "canvasInputAbility$delegate", "Lkotlin/Lazy;", "instructionAbility", "Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "getInstructionAbility", "()Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "instructionAbility$delegate", "_canvasEditorEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/canvas/feature/ability/CanvasEditorEvent;", "canvasEditorEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getCanvasEditorEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "onAttach", "", "onViewCreated", "view", "Landroid/view/View;", "observeInputAndInstructionEvent", "configChatConstraintLayout", "observeBottomInsetUpdate", "initCanvasEditor", "config", "Lcom/larus/canvas/feature/ability/EditorInitConfig;", "changeImeStatus", "show", "", "updateInputContentText", ShareType.TEXT, "", "requestFocus", "showIme", "selectionStartIndex", "", "selectionEndIndex", "(Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/Integer;)V", "setInputTextSelection", "index", "startIndex", "endIndex", "updateInputHintText", "hint", "setEditorVisible", "inputVisible", "instructionVisible", "attachComponent", "getCurrentCanvasEditorUIData", "Lcom/larus/canvas/feature/ability/CanvasEditorUIData;", "getCurrentPrompt", "updateCanvasEditorUIData", "canvasEditorUIData", "getCanvasInstructionTabList", "", "Lcom/larus/canvas/service/bean/InstructionTab;", "selectInstructionTab", "tabLabel", "getInstructionTabListByUITabList", "uiInstructionTabList", "Lcom/larus/canvas/feature/component/instruction/model/UIInstructionTab;", "getInstructionTraceContent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationCanvasEditorComponent extends BaseContentWidget implements fy8.i {
    public static final /* synthetic */ int q = 0;
    public final Lazy m;
    public final Lazy n;
    public final MutableSharedFlow<fy8.d> o;
    public final a1 p;

    @Override // fy8.i
    public final fy8.e BZ() {
        fy8.f r1 = Y2();
        if (r1 == null) goto L5;
        String r2 = r1.getPrompt();
    L6:
        fy8.h r3 = h3();
        if (r3 == null) goto L10;
        List<UIInstructionTab> r4 = r3.cW();
        if (r4 == null) goto L10;
    L12:
        return new fy8.e(r2, r4, 2);
    L10:
        r4 = CollectionsKt.emptyList();
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final fy8.f Y2() {
        return (fy8.f) this.m.getValue();
    }

    public final fy8.h h3() {
        return (fy8.h) this.n.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, fy8.i.class);
        k1a.b.b(this, new w(this));
    }

    public CreationCanvasEditorComponent() {
        this.m = LazyKt.lazy(new x(this));
        this.n = LazyKt.lazy(new y(this));
        MutableSharedFlow<fy8.d> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.o = r0;
        this.p = kotlinx.coroutines.flow.e.a(r0);
    }

    @Override // fy8.i
    public final void J3() {
        fy8.f r0 = Y2();
        if (r0 == null) goto L6;
        r0.J3();
        return;
    }

    @Override // fy8.i
    public final String K5() {
        fy8.h r0 = h3();
        if (r0 == null) goto L6;
        String r1 = r0.K5();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // fy8.i
    public final String xs() {
        fy8.f r0 = Y2();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPrompt();
    }

    @Override // fy8.i
    public final a1 jY() {
        return this.p;
    }

    @Override // fy8.i
    public final List<InstructionTab> Qp(List<UIInstructionTab> r2) {
        Intrinsics.checkNotNullParameter(r2, "uiInstructionTabList");
        fy8.h r0 = h3();
        if (r0 == null) goto L7;
        List<InstructionTab> r3 = r0.rb(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // fy8.i
    public final void XX(fy8.j r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        fy8.f r0 = Y2();
        if (r0 == null) goto L5;
        r0.qi(new fy8.k(r10.a, r10.b, r10.c, r10.d, r10.e, r10.g));
    L5:
        fy8.h r1 = h3();
        if (r1 == null) goto L9;
        r1.jU(new fy8.l(r10.f, r10.g));
        return;
    }

    @Override // fy8.i
    public final void fC(boolean r2) {
        fy8.f r0 = Y2();
        if (r0 == null) goto L5;
        r0.KK();
    L5:
        fy8.h r1 = h3();
        if (r1 == null) goto L9;
        r1.wN(r2);
        return;
    }

    public final void onViewCreated(View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        Intrinsics.checkNotNullParameter(r15, "view");
        if ((r15 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r16 = (ChatConstraintLayout) r15;
    L6:
        if (r16 == null) goto L12;
        r16.setDisableBottomPadding(true);
        if (ObricChatUIDelegate.b.m() == false) goto L11;
        r16.setDisableBottomPadding(false);
    L11:
        r16.setDisableTopPadding(true);
        r16.k6(getContext());
    L12:
        ChatConstraintLayout r17 = F2();
        if ((r17 instanceof ChatConstraintLayout) == false) goto L15;
        ChatConstraintLayout r18 = r17;
    L16:
        if (r18 == null) goto L18;
        r18.setOnBottomInsetUpdateListener(new CreationCanvasEditorComponent$observeBottomInsetUpdate$1(this));
    L18:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationCanvasEditorComponent$observeInputAndInstructionEvent$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationCanvasEditorComponent$observeInputAndInstructionEvent$2(this, null), 3, null);
        return;
    L15:
        r18 = null;
        goto L16
    L5:
        r16 = null;
        goto L6
    }

    @Override // fy8.i
    public final void p2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tabLabel");
        fy8.h r0 = h3();
        if (r0 == null) goto L6;
        r0.p2(r2);
        return;
    }

    @Override // fy8.i
    public final void t4(String r8, boolean r9, boolean r10, Integer r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r8, ShareType.TEXT);
        fy8.f r1 = Y2();
        if (r1 == null) goto L6;
        r1.t4(r8, r9, r10, r11, r12);
        return;
    }
}
