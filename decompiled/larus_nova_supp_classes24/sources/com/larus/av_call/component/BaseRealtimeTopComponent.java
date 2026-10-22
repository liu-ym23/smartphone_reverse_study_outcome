package com.larus.av_call.component;

import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.f;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.service.DefaultRealtimeCallService;
import com.larus.av_call.view.VoiceCallTopLayout;
import g88.o;
import g88.p;
import g88.q;
import h88.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J(\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/av_call/component/BaseRealtimeTopComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/ui/arch/context/external/VAbility;", "viewBinding", "Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "<init>", "(Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;)V", "argumentData", "Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "getArgumentData", "()Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/av_call/service/DefaultRealtimeCallService;", "getCallService", "()Lcom/larus/av_call/service/DefaultRealtimeCallService;", "callService$delegate", "voiceCallTopLayout", "Lcom/larus/av_call/view/VoiceCallTopLayout;", "onVContextReady", "", "onViewCreated", "view", "Landroid/view/View;", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "", "newMajorState", "newState", "Companion", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class BaseRealtimeTopComponent extends RealtimeComponent implements t1a.a {
    public static final /* synthetic */ int r = 0;
    public final LarusFragmentInstantCallBaseBinding n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public void A0() {
        h88.a r0 = (h88.a) this.o.getValue();
        b r1 = (b) this.p.getValue();
        DefaultRealtimeCallService r2 = (DefaultRealtimeCallService) this.q.getValue();
    }

    public BaseRealtimeTopComponent(LarusFragmentInstantCallBaseBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        this.n = r2;
        this.o = LazyKt.lazy(new o(this));
        this.p = LazyKt.lazy(new p(this));
        this.q = LazyKt.lazy(new q(this));
    }

    @Override // com.larus.av_call.component.RealtimeComponent
    public void onViewCreated(View r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        this.n.d.inflate();
        VoiceCallTopLayout r0 = (VoiceCallTopLayout) this.n.a.findViewById(2131392674);
        if (r0 == null) goto L6;
        ThemeType r1 = ((b) this.p.getValue()).i;
        String r2 = ((h88.a) this.o.getValue()).c;
        boolean r3 = ((b) this.p.getValue()).h;
        ImageView r4 = new ImageView(getContext());
        b r9 = (b) this.p.getValue();
        int r13 = VoiceCallTopLayout.o;
        r0.S5(r1, r2, r3, r4, true, true, true, true, r9, false);
        return;
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public void o1(MajorState r1, int r2, MajorState r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "currentMajorState");
        Intrinsics.checkNotNullParameter(r3, "newMajorState");
        ((DefaultRealtimeCallService) this.q.getValue()).getClass();
        LLMCallController.w(null, Reflection.getOrCreateKotlinClass(f.class));
        throw null;
    }
}
