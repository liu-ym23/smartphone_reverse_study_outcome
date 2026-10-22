package com.obric.assistant.component;

import com.larus.bmhome.a0;
import com.larus.bmhome.b0;
import com.larus.bmhome.c0;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.audio.continuous_talk.ObricContinuousTalkEndType;
import com.obric.audio.continuous_talk.c;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import laa.f;
import laa.m;
import maa.e;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/component/ObricSideBarRecordingStopComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "sideBarFragment", "Lcom/larus/bmhome/ISideBarFragment;", "sideBarLayoutListener", "com/obric/assistant/component/ObricSideBarRecordingStopComponent$sideBarLayoutListener$1", "Lcom/obric/assistant/component/ObricSideBarRecordingStopComponent$sideBarLayoutListener$1;", "onParentViewCreated", "", "onDestroy", "stopRecording", "context", "Lcom/larus/ui/arch/context/external/VContext;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSideBarRecordingStopComponent extends ComponentFeature {
    public static final /* synthetic */ int j = 0;
    public a0 h;
    public final b i;

    public static final class b implements c0 {
        public final /* synthetic */ ObricSideBarRecordingStopComponent a;

        public b(ObricSideBarRecordingStopComponent r1) {
            this.a = r1;
        }

        public final void G(boolean r10) {
            FLogger.a.i("SideBarRecordingStop", "side bar opened, stop recording, isClick=" + r10);
            ObricSideBarRecordingStopComponent r11 = this.a;
            int r0 = ObricSideBarRecordingStopComponent.j;
            r11.getClass();
            t1a.b r12 = d.a(r11);
            f r1 = r12.getAbility(f.class);
            e r2 = r12.getAbility(e.class);
            c r3 = r12.getAbility(c.class);
            if (r1 == null) goto L5;
            r1.qm();
        L5:
            if (r2 == null) goto L7;
            e.a.a(r2, ExitClickSpeakerType.INTERRUPT, null, false, 6);
        L7:
            if (r3 == null) goto L9;
            c.a.a(r3, ObricContinuousTalkEndType.INTERRUPT, null, false, true, 6);
        L9:
            m r13 = r12.getAbility(m.class);
            if (r13 == null) goto L12;
            r13.Rb();
        L12:
            IObricContinuousTalkService r14 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
            if (r14 == null) goto L16;
            r14.c();
            return;
        }

        public final void H0(int r4) {
            FLogger.a.i("SideBarRecordingStop", "onSideBarStateChanged: newState = " + r4);
        }

        public final void n0(boolean r4) {
            FLogger.a.i("SideBarRecordingStop", "onSideBarClose, isClick=" + r4);
        }
    }

    static {
    }

    public final void B2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        a0 r0 = b0.a(a.b(this, this));
        if (r0 == null) goto L6;
        FLogger.a.i("SideBarRecordingStop", "onParentViewCreated, sideBar=" + r0);
        this.h = r0;
        r0.If(this.i);
        return;
    }

    public final void onDestroy() {
        FLogger.a.i("SideBarRecordingStop", "onDestroy");
        a0 r0 = this.h;
        if (r0 == null) goto L5;
        r0.OB(this.i);
    L5:
        this.h = null;
    }

    public ObricSideBarRecordingStopComponent() {
        this.i = new b(this);
    }
}
