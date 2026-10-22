package com.larus.av_call.component;

import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.service.DefaultRealtimeCallService;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.im.service.audio.z0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import g88.c;
import g88.d;
import g88.e;
import g88.f;
import g88.g;
import h88.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pf9.a0;
import pf9.o;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J(\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/av_call/component/BaseRealtimeBottomComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/ui/arch/context/external/VAbility;", "viewBinding", "Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "<init>", "(Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;)V", "argumentData", "Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "getArgumentData", "()Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/av_call/service/DefaultRealtimeCallService;", "getCallService", "()Lcom/larus/av_call/service/DefaultRealtimeCallService;", "callService$delegate", "voiceCallBottomLayout", "Lcom/larus/av_call/view/VoiceCallBottomLayout;", "onVContextReady", "", "onViewCreated", "view", "Landroid/view/View;", "setListeners", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "", "newMajorState", "newState", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "Companion", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class BaseRealtimeBottomComponent extends RealtimeComponent implements t1a.a {
    public static final /* synthetic */ int s = 0;
    public final LarusFragmentInstantCallBaseBinding n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public VoiceCallBottomLayout r;

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

    public BaseRealtimeBottomComponent(LarusFragmentInstantCallBaseBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        this.n = r2;
        this.o = LazyKt.lazy(new e(this));
        this.p = LazyKt.lazy(new f(this));
        this.q = LazyKt.lazy(new g(this));
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public void D9(z0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        boolean r1 = false;
        if ((r4 instanceof o) == false) goto L14;
        VoiceCallBottomLayout r5 = this.r;
        if (r5 == null) goto L24;
        b r0 = r5.f;
        if (r0 != null) goto L9;
    L11:
        if (r1 == false) goto L25;
        r5.H6(true);
        return;
    L25:
        return;
    L9:
        if (r0.m == true) goto L11;
        r1 = true;
        goto L11
    L24:
        return;
    L14:
        if ((r4 instanceof z) == false) goto L19;
        VoiceCallBottomLayout r6 = this.r;
        if (r6 == null) goto L27;
        r6.H7();
        return;
    L27:
        return;
    L19:
        if ((r4 instanceof a0) == false) goto L29;
        VoiceCallBottomLayout r7 = this.r;
        if (r7 == null) goto L30;
        int r2 = VoiceCallBottomLayout.D;
        r7.J7(false);
        return;
    L30:
        return;
    }

    @Override // com.larus.av_call.component.RealtimeComponent
    public void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.n.b.inflate();
        VoiceCallBottomLayout r4 = (VoiceCallBottomLayout) this.n.a.findViewById(2131392657);
        this.r = r4;
        if (r4 == null) goto L5;
        r4.o7((h88.a) this.o.getValue(), (b) this.p.getValue());
    L5:
        VoiceCallBottomLayout r5 = this.r;
        View r0 = null;
        if (r5 == null) goto L8;
        View r6 = r5.getVoiceCallHangup();
    L9:
        e1.d(r6, new g88.a(this));
        VoiceCallBottomLayout r7 = this.r;
        if (r7 == null) goto L12;
        r7.setTakePhotoBtnClickListener(new g88.b());
    L12:
        VoiceCallBottomLayout r8 = this.r;
        if (r8 == null) goto L15;
        View r9 = r8.getRealtimeCallMute();
    L16:
        e1.d(r9, new c(this));
        VoiceCallBottomLayout r10 = this.r;
        if (r10 == null) goto L19;
        r0 = r10.getRealtimeCallHotArea();
    L19:
        e1.d(r0, new d());
        return;
    L15:
        r9 = null;
        goto L16
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public void o1(MajorState r3, int r4, MajorState r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "currentMajorState");
        Intrinsics.checkNotNullParameter(r5, "newMajorState");
        FLogger.a.i("BaseBottomComponent", "new state: " + r6 + " current:" + r4);
        VoiceCallBottomLayout r7 = this.r;
        if (r7 == null) goto L5;
        r7.l9(r6, r5 instanceof MajorState.i.a);
    L5:
        com.larus.av_call.view.c r8 = null;
        boolean r9 = true;
        switch(r6) {
            case 1: goto L52;
            case 2: goto L49;
            case 3: goto L31;
            case 4: goto L28;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L20;
            case 8: goto L17;
            case 9: goto L28;
            case 10: goto L75;
            case 11: goto L75;
            case 12: goto L14;
            case 13: goto L75;
            case 14: goto L11;
            case 15: goto L8;
            default: goto L75;
        };
    L8:
        VoiceCallBottomLayout r10 = this.r;
        if (r10 == null) goto L56;
        r10.R7();
        return;
    L56:
        return;
    L11:
        VoiceCallBottomLayout r11 = this.r;
        if (r11 == null) goto L58;
        r11.E7();
        return;
    L58:
        return;
    L14:
        VoiceCallBottomLayout r12 = this.r;
        if (r12 == null) goto L60;
        r12.L7();
        return;
    L60:
        return;
    L17:
        VoiceCallBottomLayout r13 = this.r;
        if (r13 == null) goto L62;
        r13.E8();
        return;
    L62:
        return;
    L20:
        VoiceCallBottomLayout r14 = this.r;
        if (r14 == null) goto L64;
        r14.g8();
        r14.E8();
        return;
    L64:
        return;
    L23:
        ((DefaultRealtimeCallService) this.q.getValue()).getClass();
        LLMCallController.w(null, Reflection.getOrCreateKotlinClass(com.larus.audio.call.mgr.f.class));
        throw null;
    L25:
        VoiceCallBottomLayout r15 = this.r;
        if (r15 == null) goto L66;
        r15.E8();
        r15.V8(false, false, false);
        return;
    L66:
        return;
    L28:
        VoiceCallBottomLayout r16 = this.r;
        if (r16 == null) goto L68;
        r16.V8(false, r5 instanceof MajorState.i.a, true);
        r16.E8();
        return;
    L68:
        return;
    L31:
        VoiceCallBottomLayout r17 = this.r;
        if (r17 == null) goto L43;
        com.larus.av_call.view.c r19 = r17.a;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L38:
        if (r8.i().getVisibility() != 0) goto L40;
        boolean r20 = true;
    L41:
        if (r20 != true) goto L43;
    L44:
        if (r9 == false) goto L46;
        return;
    L46:
        VoiceCallBottomLayout r21 = this.r;
        if (r21 == null) goto L70;
        r21.e8();
        r21.E8();
        return;
    L70:
        return;
    L40:
        r20 = false;
        goto L41
    L36:
        r8 = r19;
    L43:
        r9 = false;
        goto L44
    L49:
        VoiceCallBottomLayout r22 = this.r;
        if (r22 == null) goto L72;
        r22.n8();
        r22.E8();
        return;
    L72:
        return;
    L52:
        VoiceCallBottomLayout r23 = this.r;
        if (r23 == null) goto L74;
        r23.A8();
        return;
    L74:
        return;
    }
}
