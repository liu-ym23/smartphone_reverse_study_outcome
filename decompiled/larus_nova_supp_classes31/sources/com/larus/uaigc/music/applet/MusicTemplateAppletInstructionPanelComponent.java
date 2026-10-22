package com.larus.uaigc.music.applet;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "<init>", "()V", "hideInstructionPanelState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "instructionPanelHiddenFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInstructionPanelHiddenFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "onAttach", "", "showInstructionPanel", "hideInstructionPanel", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicTemplateAppletInstructionPanelComponent extends ComponentFeature implements u1 {
    public final StateFlowImpl h;
    public final kotlinx.coroutines.flow.b1 i;

    @Override // com.larus.uaigc.music.applet.u1
    public final void Ub() {
        this.h.setValue(Boolean.TRUE);
    }

    public final void onDestroy() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.f(com.larus.ui.arch.component.internal.attach.a.b(this, this), u1.class);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, u1.class);
    }

    @Override // com.larus.uaigc.music.applet.u1
    public final void yD() {
        this.h.setValue(Boolean.FALSE);
    }

    public MusicTemplateAppletInstructionPanelComponent() {
        StateFlowImpl r0 = kotlinx.coroutines.flow.j1.a(Boolean.TRUE);
        this.h = r0;
        this.i = kotlinx.coroutines.flow.e.b(r0);
    }

    @Override // com.larus.uaigc.music.applet.u1
    public final kotlinx.coroutines.flow.b1 h30() {
        return this.i;
    }
}
