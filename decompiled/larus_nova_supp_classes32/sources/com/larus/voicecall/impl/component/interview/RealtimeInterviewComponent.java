package com.larus.voicecall.impl.component.interview;

import android.view.View;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.plugins.e1;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.z0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.scene.m;
import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import j3a.e;
import j3a.f;
import j3a.g;
import j3a.h;
import j3a.i;
import j3a.j;
import j3a.k;
import j3a.l;
import j3a.n;
import j3a.o;
import j3a.p;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import pf9.d0;
import pf9.j0;
import pf9.s;
import pf9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020DH\u0016J\u0010\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020:H\u0016J\b\u0010K\u001a\u00020DH\u0002J\u0010\u0010L\u001a\u00020D2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020DH\u0016J\b\u0010P\u001a\u000208H\u0016J\b\u0010Q\u001a\u000208H\u0016J\b\u0010R\u001a\u000208H\u0002J\b\u0010S\u001a\u00020DH\u0016J\b\u0010T\u001a\u00020DH\u0016J\b\u0010>\u001a\u000208H\u0016J\b\u0010U\u001a\u00020DH\u0002J\b\u0010V\u001a\u00020DH\u0002J\u0012\u0010W\u001a\u00020D2\b\u0010X\u001a\u0004\u0018\u00010YH\u0002J\b\u0010Z\u001a\u00020DH\u0002J\u0012\u0010[\u001a\u00020D2\b\b\u0002\u0010\\\u001a\u000208H\u0002J\b\u0010]\u001a\u00020DH\u0002J\b\u0010^\u001a\u00020DH\u0002J\b\u0010_\u001a\u00020DH\u0002J\b\u0010`\u001a\u00020DH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\n\u001a\u0004\b0\u00101R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u000108080<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u000108080<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u0002080@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/voicecall/impl/component/interview/RealtimeInterviewComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "subtitleAbility", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "getSubtitleAbility", "()Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "subtitleAbility$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "currentPhase", "Lcom/larus/voicecall/impl/component/interview/RealtimeInterviewPhase;", "restoreStatus", "Lcom/larus/voicecall/impl/component/interview/RealtimeInterviewStatus;", "sendImage", NameKeys.UnloadStrategy_No_Strategy, "currentSessionState", "Lcom/larus/im/internal/audio/context/SessionState;", "isTTSPlaying", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "hasPendingHangUpEvent", "triggerHangUp", "Landroidx/lifecycle/MediatorLiveData;", "sceneChangeListener", "Lcom/larus/voicecall/impl/component/scene/RealtimeSceneChangeListener;", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onVContextReady", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "onConnectionStateChanged", "state", "triggerHelloWhenReconnect", "onViewCreated", "view", "Landroid/view/View;", "onDestroy", "isRealtimeInterviewPhase", "isRealtimeInterviewScene", "isRealtimeInterviewError", "onInterviewUploadPicStart", "onInterviewUploadPicEnd", "initHangUpObserver", "hangUpInterview", "onSceneChange", "selected", "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "onEnterInterviewScene", "onExitInterviewScene", "needRestoreSubtitleStatus", "restoreSubtitle", "restoreContentAvatar", "openSubtitle", "showAndDisableChangeToAvatar", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeInterviewComponent extends RealtimeComponent implements j3a.a {
    public static final /* synthetic */ int E = 0;
    public final MutableLiveData<Boolean> A;
    public final MutableLiveData<Boolean> B;
    public final MediatorLiveData<Boolean> C;
    public final d D;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public RealtimeInterviewPhase w;
    public p x;
    public boolean y;
    public jd9.c z;

    public static final class a {
    }

    public static final class b implements e1 {
        public final /* synthetic */ RealtimeInterviewComponent a;

        public final void a() {
            this.a.A.postValue(Boolean.FALSE);
        }

        public final void b() {
            this.a.A.postValue(Boolean.TRUE);
        }

        public b(RealtimeInterviewComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class d implements l3a.c {
        public final /* synthetic */ RealtimeInterviewComponent a;

        public d(RealtimeInterviewComponent r1) {
            this.a = r1;
        }

        @Override // l3a.c
        public final void a(m r7) {
            FLogger.a.i("RealtimeInterviewComponent", "[onSceneSelected] selected: " + r7);
            RealtimeInterviewComponent r0 = this.a;
            int r1 = RealtimeInterviewComponent.E;
            r0.getClass();
            String r2 = null;
            if (r7 == null) goto L7;
            SceneModel r3 = r7.a;
            if (r3 == null) goto L7;
            String r4 = r3.getKey();
        L9:
            if (Intrinsics.areEqual(r4, "interview_v2") == false) goto L21;
            p r8 = r0.x;
            RealtimeCallUtil.a.getClass();
            boolean r5 = RealtimeCallUtil.z;
            NewThemeSwitchAvatar.AvatarType r6 = NewThemeSwitchAvatar.b;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r6, "showAvatarType");
            r0.x = new p(r5, r6);
            if (NewThemeSwitchAvatar.b != NewThemeSwitchAvatar.AvatarType.NORMAL_AVATAR) goto L16;
            g3a.a r9 = (g3a.a) r0.q.getValue();
            if (r9 == null) goto L16;
            r9.dD(((e3a.a) r0.n.getValue()).H0);
        L16:
            if (RealtimeCallUtil.z == true) goto L20;
            com.larus.voicecall.impl.component.subtitle.a r10 = (com.larus.voicecall.impl.component.subtitle.a) r0.u.getValue();
            if (r10 == null) goto L20;
            r10.nV(true, "auto_open");
        L20:
            r0.w = RealtimeInterviewPhase.Preparing;
            return;
        L21:
            if (r7 == null) goto L26;
            SceneModel r11 = r7.a;
            if (r11 == null) goto L26;
            r2 = r11.getKey();
        L26:
            if (Intrinsics.areEqual(r2, "interview_v2") == false) goto L28;
        L52:
            r0.w = RealtimeInterviewPhase.Ended;
            return;
        L28:
            if (r0.su() == false) goto L52;
            if (r7 == null) goto L35;
            SceneModel r12 = r7.a;
            if (r12 == null) goto L35;
            if (r12.getEnableSubtitle() != true) goto L35;
            boolean r13 = true;
        L37:
            if ((!r13) == false) goto L44;
            if (r0.x.a == true) goto L44;
            com.larus.voicecall.impl.component.subtitle.a r14 = (com.larus.voicecall.impl.component.subtitle.a) r0.u.getValue();
            if (r14 == null) goto L44;
            r14.Zk("auto_open");
        L44:
            if (r0.x.b != NewThemeSwitchAvatar.AvatarType.NORMAL_AVATAR) goto L49;
            g3a.a r15 = (g3a.a) r0.q.getValue();
            if (r15 == null) goto L49;
            r15.dD(((e3a.a) r0.n.getValue()).H0);
        L49:
            if (r0.w != RealtimeInterviewPhase.Planning) goto L51;
            RealtimeCallService r16 = r0.h3();
            RealtimeCallParam r17 = r0.m3().a();
            r16.getClass();
            Intrinsics.checkNotNullParameter(r17, LynxResourceModule.PARAMS_KEY);
            r16.n().n1(r17);
        L51:
            r0.w = RealtimeInterviewPhase.Ended;
            return;
        L35:
            r13 = false;
        L7:
            r4 = null;
            goto L9
        }
    }

    static {
    }

    public final void A0() {
        e3a.a r0 = (e3a.a) this.n.getValue();
        m3();
        com.larus.voicecall.impl.component.scene.a r1 = (com.larus.voicecall.impl.component.scene.a) this.p.getValue();
        g3a.a r2 = (g3a.a) this.q.getValue();
        m3a.a r3 = (m3a.a) this.r.getValue();
        com.larus.voicecall.impl.component.bottom.b r4 = (com.larus.voicecall.impl.component.bottom.b) this.s.getValue();
    }

    @Override // j3a.a
    public final void W80() {
        FLogger.a.i("RealtimeInterviewComponent", "[onInterviewUploadPicEnd]: sendImage=" + this.y);
        if (su() == true) goto L5;
        return;
    L5:
        if (this.y == false) goto L9;
        RealtimeCallService r0 = h3();
        RealtimeCallParam r1 = m3().a();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        r0.n().A2(r1);
        this.y = false;
        return;
    }

    @Override // j3a.a
    public final boolean YR() {
        Boolean r0 = (Boolean) this.B.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // j3a.a
    public final boolean eZ() {
        if (this.w != RealtimeInterviewPhase.Interviewing) goto L5;
        return true;
    L5:
        return false;
    }

    public final RealtimeCallService h3() {
        return (RealtimeCallService) this.v.getValue();
    }

    public final e3a.b m3() {
        return (e3a.b) this.o.getValue();
    }

    public final void onDestroy() {
        FLogger.a.i("RealtimeInterviewComponent", "[onDestroy] currentPhase: " + this.w);
        com.larus.voicecall.impl.component.scene.a r0 = (com.larus.voicecall.impl.component.scene.a) this.p.getValue();
        if (r0 == null) goto L5;
        r0.Fk(this.D);
    L5:
        this.w = RealtimeInterviewPhase.Ended;
    }

    @Override // j3a.a
    public final boolean su() {
        RealtimeInterviewPhase r0 = this.w;
        if (r0 != RealtimeInterviewPhase.Initialized) goto L5;
    L7:
        return false;
    L5:
        if (r0 == RealtimeInterviewPhase.Ended) goto L7;
        return true;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, j3a.a.class);
    }

    public RealtimeInterviewComponent() {
        this.n = LazyKt.lazy(new j3a.b(this));
        this.o = LazyKt.lazy(new g(this));
        this.p = LazyKt.lazy(new h(this));
        this.q = LazyKt.lazy(new i(this));
        this.r = LazyKt.lazy(new j(this));
        this.s = LazyKt.lazy(new k(this));
        this.t = LazyKt.lazy(new l(this));
        this.u = LazyKt.lazy(new j3a.m(this));
        this.v = LazyKt.lazy(new n(this));
        this.w = RealtimeInterviewPhase.Initialized;
        this.x = new p(0);
        this.z = jd9.c.f.c;
        Boolean r1 = Boolean.FALSE;
        this.A = new MutableLiveData(r1);
        this.B = new MutableLiveData(r1);
        this.C = new MediatorLiveData();
        this.D = new d(this);
    }

    @Override // j3a.a
    public final void F90() {
        if (su() == false) goto L6;
        FLogger.a.i("RealtimeInterviewComponent", "[onInterviewUploadPicStart]: sendImage=" + this.y);
        this.y = true;
        RealtimeCallService r0 = h3();
        RealtimeCallParam r1 = m3().a();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        r0.n().z2(r1);
        return;
    }

    public final void D9(z0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof j0) == false) goto L11;
        FLogger.a.i("RealtimeInterviewComponent", "[onReceiveEvent] FlowLLMStartLoadingEvent, currentPhase = " + this.w);
        RealtimeCallService r6 = h3();
        RealtimeCallParam r0 = m3().a();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, LynxResourceModule.PARAMS_KEY);
        r6.n().v0(r0);
        com.larus.voicecall.impl.component.bottom.b r7 = (com.larus.voicecall.impl.component.bottom.b) this.s.getValue();
        if (r7 == null) goto L9;
        VoiceCallBottomLayout r8 = r7.BT();
        if (r8 == null) goto L9;
        r8.post(new f(this));
    L9:
        this.w = RealtimeInterviewPhase.Planning;
        return;
    L11:
        if ((r5 instanceof u) == false) goto L14;
        FLogger.a.i("RealtimeInterviewComponent", "[onReceiveEvent] FlowLLMFinishLoadingEvent, currentPhase = " + this.w);
        RealtimeCallService r9 = h3();
        RealtimeCallParam r1 = m3().a();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        r9.n().n1(r1);
        this.w = RealtimeInterviewPhase.Interviewing;
        return;
    L14:
        if ((r5 instanceof s) == false) goto L17;
        FLogger.a.i("RealtimeInterviewComponent", "[onReceiveEvent] FlowLLMDownlinkHangUpEvent, currentPhase = " + this.w);
        RealtimeCallService r10 = h3();
        RealtimeCallParam r2 = m3().a();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        r10.n().e1(r2);
        this.B.postValue(Boolean.TRUE);
        return;
    L17:
        if ((r5 instanceof d0) == false) goto L19;
        FLogger.a.i("RealtimeInterviewComponent", "[onReceiveEvent] FlowLLMReplyBeginEvent, currentPhase = " + this.w);
        W80();
        return;
    L19:
        FLogger.a.d("RealtimeInterviewComponent", "[onReceiveEvent] not handle event: " + r5 + ", currentPhase = " + this.w);
    }

    public final void I6(jd9.c r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r7, "state");
        FLogger r0 = FLogger.a;
        r0.d("RealtimeInterviewComponent", "[onConnectionStateChanged] currentSessionState: " + r7 + ", lastSessionState = " + this.z + ", currentPhase = " + this.w);
        this.z = r7;
        if (su() == true) goto L5;
        return;
    L5:
        RealtimeInterviewPhase r1 = this.w;
        RealtimeInterviewPhase r3 = RealtimeInterviewPhase.Error;
        if (r1 != r3) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L14;
        if ((this.z instanceof jd9.c.a) == false) goto L14;
        r0.i("RealtimeInterviewComponent", "[beforeUpdateCurrentSessionState] triggerInterviewHello");
        RealtimeCallService r4 = h3();
        RealtimeCallParam r5 = m3().a();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        r4.n().o1(r5);
        this.w = RealtimeInterviewPhase.Preparing;
    L14:
        if ((r7 instanceof jd9.c.d) == false) goto L17;
        r0.w("RealtimeInterviewComponent", "[onConnectionStateChanged] DISCONNECT, currentPhase = " + this.w);
        this.w = r3;
        return;
    L17:
        return;
    L8:
        r2 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [j3a.o] */
    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r5, "view");
        com.larus.voicecall.impl.component.scene.a r6 = (com.larus.voicecall.impl.component.scene.a) this.p.getValue();
        if (r6 == null) goto L5;
        r6.yM(this.D);
    L5:
        RealtimeCallService r7 = h3();
        b r0 = new b(this);
        r7.n().B1(r0);
        final ?? r8 = new o(this);
        this.C.addSource(this.B, new c(new j3a.c(r8)));
        this.C.addSource(this.A, new c(new j3a.d(r8)));
        MediatorLiveData<Boolean> r9 = this.C;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r9.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new c(new e(this)));
    }
}
