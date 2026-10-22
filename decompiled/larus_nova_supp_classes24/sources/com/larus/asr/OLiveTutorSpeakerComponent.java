package com.larus.asr;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.session.ComponentAsrSession;
import com.larus.asr.session.SamiCallAsrSession;
import com.larus.asr.session.SendMessageAsrSession;
import com.larus.asr.view.ChatSpeaker;
import com.larus.asr.view.OChatSpeaker;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.asr.c0;
import com.larus.bmhome.chat.component.bottom.core.speaker.SessionType;
import com.larus.bmhome.chat.component.bottom.core.speaker.h;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import com.obric.assistant.common.spi.IObricSamiService;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001fH\u0014J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016JB\u0010&\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160'2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0016H\u0014J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010-H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u0016H\u0016J\b\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020\u0017H\u0016J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0013H\u0016J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0013H\u0016J\u0018\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020DH\u0016J0\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010?\u001a\u00020-H\u0016J0\u0010I\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u00162\u0006\u0010H\u001a\u00020-2\u0006\u0010G\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010?\u001a\u00020-H\u0002J\u0010\u0010J\u001a\u00020\u00172\u0006\u0010?\u001a\u00020-H\u0002J\n\u0010K\u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u0016H\u0016J\u0010\u0010P\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0016J\u001e\u0010Q\u001a\u00020\u00172\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0016J\b\u0010S\u001a\u00020TH\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001c¨\u0006V"}, d2 = {"Lcom/larus/asr/OLiveTutorSpeakerComponent;", "Lcom/larus/asr/LiveTutorSpeakerComponent;", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IOChatBottomSpeakerExtraAbility;", "Lcom/obric/assistant/ability/audio/IClickTalkSamiAsrSessionAbility;", "<init>", "()V", "chatSpeakerExtraAbility", "Lcom/obric/assistant/ability/audio/IChatSpeakerExtraAbility;", "getChatSpeakerExtraAbility", "()Lcom/obric/assistant/ability/audio/IChatSpeakerExtraAbility;", "chatSpeakerExtraAbility$delegate", "Lkotlin/Lazy;", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "speakerStateListenerProxyMap", "", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerStateListener;", "visibilityChangeCallback", "Lkotlin/Function1;", "", "", "useChatSpeakerBuilder", "speakerSpecController", "Lcom/larus/asr/OChatSpeakerSpecController;", "getSpeakerSpecController", "()Lcom/larus/asr/OChatSpeakerSpecController;", "speakerSpecController$delegate", "initSpeaker", "Lcom/larus/asr/view/ChatSpeaker;", "applySpeakerConfig", "target", "onViewCreated", "view", "Landroid/view/View;", "onStart", "createAsrSession", "Lkotlin/Triple;", "Lcom/larus/asr/session/IFlowAsrSession;", "fromTextArea", "traceInfo", "Lcom/larus/audio/asr/AsrTraceInfo;", "asrTaskId", "", "voiceInputType", "Lcom/larus/asr/VoiceInputType;", "asrOnly", "closeClickTalk", "exitClickSpeakerType", "Lcom/obric/assistant/ability/audio/ExitClickSpeakerType;", "updateScreenshotForAsr", "tosKey", "getClickTalkState", "Lcom/obric/assistant/ability/audio/ClickTalkState;", "isClickTalking", "isClickTalkClosing", "updateClosingState", "registerSpeakerStateListener", "listener", "unregisterSpeakerStateListener", "onAsrAudioData", "taskId", "data", "", "setAudioVolume", "volume", "", "setSpeakerViewVisible", "visible", "needVibrate", "reason", "updateSpeakerVisibilityAdapter", "onCanceled", "getChatSpeaker", "getCurChatSpeakerState", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerState;", "changeChatStyle", "chatWindowStyle", "hideSpeakerAndSubmit", "setVisibilityChangeCallback", "callback", "getSessionType", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/SessionType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OLiveTutorSpeakerComponent extends LiveTutorSpeakerComponent implements com.larus.bmhome.chat.component.bottom.core.speaker.m, maa.g {
    public static final /* synthetic */ int M2 = 0;
    public final Lazy G2;
    public final Lazy H2;
    public final Map<h, h> I2;
    public Function1<? super Boolean, Unit> J2;
    public final boolean K2;
    public final Lazy L2;

    public static final class a {
    }

    public static final class b implements h {
        public final /* synthetic */ OLiveTutorSpeakerComponent a;
        public final /* synthetic */ h b;

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (r2 == com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) goto L5;
        L7:
            this.b.a(r2);
            return;
        L5:
            if ((((ChatBottomSpeakerComponent) this.a).s instanceof SamiCallAsrSession) == false) goto L7;
        }

        public b(OLiveTutorSpeakerComponent r1, h r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements Function0<maa.f> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.f.class));
        }
    }

    public static final class d implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    static {
    }

    public final maa.f F4() {
        return (maa.f) this.G2.getValue();
    }

    public final maa.e G4() {
        return (maa.e) this.H2.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        com.larus.asr.session.o r0 = ((ChatBottomSpeakerComponent) this).s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.J5();
    }

    public final void JN() {
        com.larus.asr.session.o r0 = ((ChatBottomSpeakerComponent) this).s;
        if ((r0 instanceof SamiCallAsrSession) == false) goto L5;
        SamiCallAsrSession r1 = (SamiCallAsrSession) r0;
    L6:
        if (r1 == null) goto L9;
        r1.n = true;
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean L4() {
        com.larus.asr.session.o r0 = ((ChatBottomSpeakerComponent) this).s;
        if ((r0 instanceof SamiCallAsrSession) == false) goto L5;
        SamiCallAsrSession r1 = (SamiCallAsrSession) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.n != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final ChatSpeaker e4() {
        if (this.K2 == false) goto L5;
        int r0 = 2131562783;
    L6:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[SpeakerBuilder] initSpeaker route=");
        if (this.K2 == false) goto L9;
        String r3 = "builder";
    L10:
        r2.append(r3);
        r2.append(" layoutRes=");
        r2.append(r0);
        r1.i("OLiveTutorSpeakerComponent", r2.toString());
        ViewStub r4 = ((ChatBottomSpeakerComponent) this).p;
        if (r4 == null) goto L13;
        r4.setLayoutResource(r0);
        View r5 = r4.inflate();
    L15:
        if ((r5 instanceof ChatSpeaker) == true) goto L17;
        return null;
    L17:
        return (ChatSpeaker) r5;
    L13:
        r5 = null;
        goto L15
    L9:
        r3 = "legacy";
        goto L10
    L5:
        r0 = 2131562779;
        goto L6
    }

    public final SessionType getSessionType() {
        FLogger.a.i("OLiveTutorSpeakerComponent", "getSessionType, flowAsrSession: " + ((ChatBottomSpeakerComponent) this).s);
        if ((((ChatBottomSpeakerComponent) this).s instanceof SendMessageAsrSession) == false) goto L6;
        return SessionType.INTERCOM;
    L6:
        return SessionType.CLICK_TALK;
    }

    public final maa.d vD() {
        com.larus.asr.session.o r0 = ((ChatBottomSpeakerComponent) this).s;
        if ((r0 instanceof SamiCallAsrSession) == false) goto L5;
        SamiCallAsrSession r1 = (SamiCallAsrSession) r0;
    L6:
        if (r1 == null) goto L15;
        if (r1.n == false) goto L11;
        return maa.d.a.a;
    L11:
        if (r1.m == false) goto L18;
        return maa.d.c.a;
    L18:
        return maa.d.b.a;
    L15:
        return maa.d.b.a;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean x3() {
        com.larus.asr.session.o r0 = ((ChatBottomSpeakerComponent) this).s;
        if ((r0 instanceof SamiCallAsrSession) == false) goto L5;
        SamiCallAsrSession r1 = (SamiCallAsrSession) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.m != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public OLiveTutorSpeakerComponent() {
        this.G2 = LazyKt.lazy(new c(this));
        this.H2 = LazyKt.lazy(new d(this));
        this.I2 = new LinkedHashMap();
        this.K2 = y48.h.a();
        this.L2 = LazyKt.lazy(new b4(this));
    }

    public final ChatSpeaker lM() {
        return a4();
    }

    public final void onStart() {
        ChatSpeaker r0 = a4();
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getParent();
    L7:
        if ((r2 instanceof View) == false) goto L9;
        View r3 = (View) r2;
    L10:
        if (r3 == null) goto L12;
        View r4 = r3.findViewById(2131375324);
    L13:
        ChatSpeaker r5 = a4();
        if (r5 == null) goto L27;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L26;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        int r8 = 0;
        if (r4 == null) goto L24;
        ViewGroup.LayoutParams r9 = r4.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        r1 = (ViewGroup.MarginLayoutParams) r9;
    L22:
        if (r1 == null) goto L24;
        r8 = r1.bottomMargin;
    L24:
        r7.bottomMargin = r8 + i5.h();
        r5.setLayoutParams(r7);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L27:
        return;
    L12:
        r4 = null;
        goto L13
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void B9(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        h r0 = this.I2.remove(r2);
        if (r0 == null) goto L6;
        r2 = r0;
    L6:
        super.B9(r2);
    }

    public final void H3(ChatSpeaker r6) {
        Intrinsics.checkNotNullParameter(r6, "target");
        if (this.K2 == false) goto L5;
        y48.v r0 = k4();
        y48.v r1 = ((a4) this.L2.getValue()).a(r0);
        FLogger.a.i("OLiveTutorSpeakerComponent", "[SpeakerBuilder] applySpeakerConfig target=" + r6.getClass().getSimpleName() + ':' + r6.hashCode() + " route=builder baseScene=" + r0.a + " resultScene=" + r1.a);
        r6.setSpec(r1);
        return;
    L5:
        super.H3(r6);
        maa.b r2 = null;
        if ((r6 instanceof OChatSpeaker) == false) goto L8;
        OChatSpeaker r7 = (OChatSpeaker) r6;
    L9:
        if (r7 == null) goto L16;
        maa.f r3 = F4();
        if (r3 == null) goto L13;
        r2 = r3.nc();
    L13:
        r7.setResCallback(r2);
        r7.setShouldCancelCallback(new c4(this));
        return;
    L16:
        return;
    L8:
        r7 = null;
        goto L9
    }

    public final void MC(boolean r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[SpeakerBuilder] changeChatStyle route=");
        if (this.K2 == false) goto L5;
        String r2 = "builder";
    L6:
        r1.append(r2);
        r1.append(" chatWindowStyle=");
        r1.append(r5);
        r1.append(" speaker=");
        ChatSpeaker r3 = a4();
        OChatSpeaker r4 = null;
        if (r3 == null) goto L9;
        Integer r6 = Integer.valueOf(r3.hashCode());
    L10:
        r1.append(r6);
        r0.i("OLiveTutorSpeakerComponent", r1.toString());
        if (this.K2 == false) goto L13;
        ((a4) this.L2.getValue()).b(a4(), r5);
        return;
    L13:
        ChatSpeaker r7 = a4();
        if ((r7 instanceof OChatSpeaker) == false) goto L16;
        r4 = (OChatSpeaker) r7;
    L16:
        if (r4 == null) goto L20;
        r4.c9(r5);
        return;
    L20:
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = "legacy";
        goto L6
    }

    public final void T3(Function1<? super Boolean, Unit> r3) {
        this.J2 = r3;
        if (this.K2 == true) goto L11;
        ChatSpeaker r0 = a4();
        if ((r0 instanceof OChatSpeaker) == false) goto L7;
        OChatSpeaker r1 = (OChatSpeaker) r0;
    L8:
        if (r1 == null) goto L12;
        r1.setOnVisibilityChangeCallback(r3);
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void Uh(ExitClickSpeakerType r3) {
        Intrinsics.checkNotNullParameter(r3, "exitClickSpeakerType");
        com.larus.asr.session.o r0 = ((ChatBottomSpeakerComponent) this).s;
        if ((r0 instanceof SamiCallAsrSession) == false) goto L5;
        SamiCallAsrSession r1 = (SamiCallAsrSession) r0;
    L6:
        if (r1 == null) goto L9;
        r1.c(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void W9(VoiceInputType r2) {
        Intrinsics.checkNotNullParameter(r2, "voiceInputType");
        ChatSpeaker r0 = a4();
        if (r0 == null) goto L6;
        r0.V6(r2);
        return;
    }

    public final void e8(h r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        b r0 = new b(this, r3);
        this.I2.put(r3, r0);
        super.e8(r0);
    }

    @Override // com.larus.asr.LiveTutorSpeakerComponent
    public final void ea(float r4) {
        super.ea(r4);
        maa.f r0 = F4();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        maa.e r2 = G4();
        if (r2 == null) goto L13;
        r2.ea(r4);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.iC() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5);
        if (this.K2 == false) goto L6;
        return;
    L6:
        if ((a4() instanceof OChatSpeaker) == true) goto L9;
        ((ChatBottomSpeakerComponent) this).q = null;
        ViewParent r0 = r5.getParent();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) r0;
        r1.removeView(r5);
        ViewStub r6 = new ViewStub(getContext());
        r6.setId(2131387057);
        ((ChatBottomSpeakerComponent) this).p = r6;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        r2.gravity = 80;
        Unit r3 = Unit.INSTANCE;
        r1.addView(r6, r2);
        a4();
        return;
    }

    public final void updateScreenshotForAsr(String r11) {
        maa.e r0 = G4();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.x3() != true) goto L7;
    L8:
        SamiCallAsrSession r2 = null;
        if (r1 == false) goto L25;
        com.larus.asr.session.o r3 = ((ChatBottomSpeakerComponent) this).s;
        if ((r3 instanceof SamiCallAsrSession) == false) goto L13;
        r2 = (SamiCallAsrSession) r3;
    L13:
        if (r2 != null) goto L15;
        return;
    L15:
        if (ObricAsrDelegate.b.q() == true) goto L18;
        return;
    L18:
        if (r2.j == null) goto L42;
        com.larus.asr.session.clicktalk.l r4 = r2.v;
        if (r4 == null) goto L43;
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        r4.updateScreenshotForAsr(r11);
        return;
    L43:
        return;
    L42:
        return;
    L25:
        if (ObricAsrDelegate.b.q() == true) goto L27;
        return;
    L27:
        IObricSamiService r5 = (IObricSamiService) ServiceManager.get().getService(IObricSamiService.class);
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService r6 = IFlowAsrClientService.a.a();
        String r7 = ((ChatBottomSpeakerComponent) this).I;
        if (r11 != null) goto L30;
        String r8 = "";
    L31:
        if (r5 == null) goto L33;
        SAMICorePropertyId r9 = r5.b();
    L34:
        if (r5 == null) goto L36;
        SAMICoreDataType r10 = r5.c();
    L37:
        if (r5 == null) goto L39;
        r2 = r5.a(r11, ((ChatBottomSpeakerComponent) this).I);
    L39:
        r6.q(r7, r8, r9, r10, r2);
        return;
    L36:
        r10 = null;
        goto L37
    L33:
        r9 = null;
        goto L34
    L30:
        r8 = r11;
    L7:
        r1 = false;
        goto L8
    }

    public static final void B4(OLiveTutorSpeakerComponent r2, String r3) {
        com.larus.asr.session.o r4 = ((ChatBottomSpeakerComponent) r2).s;
        if ((r4 instanceof SamiCallAsrSession) == false) goto L5;
        SamiCallAsrSession r5 = (SamiCallAsrSession) r4;
    L6:
        if (r5 == null) goto L9;
        r5.qa(r3, null);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void Ma(String r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "data");
        ChatSpeaker r4 = a4();
        if (r4 == null) goto L5;
        r4.d8(LifecycleOwnerKt.getLifecycleScope(this), r3);
    L5:
        maa.e r5 = G4();
        if (r5 == null) goto L9;
        r5.setAudioData(r3);
        return;
    }

    public final void L8(boolean r9, boolean r10, String r11, VoiceInputType r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "reason");
        Intrinsics.checkNotNullParameter(r12, "voiceInputType");
        Intrinsics.checkNotNullParameter(r13, "taskId");
        boolean r0 = false;
        boolean r1 = true;
        if (r9 == false) goto L18;
        VoiceInputType.Companion.getClass();
        if (VoiceInputType.a.a(r12) == false) goto L9;
        maa.e r14 = G4();
        if (r14 == null) goto L34;
        r14.TE(true, r13, new OLiveTutorSpeakerComponent$updateSpeakerVisibilityAdapter$1(this));
        return;
    L34:
        return;
    L9:
        super.L8(true, r10, r11, VoiceInputType.TouchSpeaker, r13);
        maa.f r15 = F4();
        if (r15 != null) goto L12;
    L14:
        if (r0 == false) goto L36;
        maa.e r16 = G4();
        if (r16 == null) goto L37;
        r16.TE(true, r13, new OLiveTutorSpeakerComponent$updateSpeakerVisibilityAdapter$2(this));
        return;
    L37:
        return;
    L36:
        return;
    L12:
        if (r15.iC() != true) goto L14;
        r0 = true;
        goto L14
    L18:
        VoiceInputType.Companion.getClass();
        if (VoiceInputType.a.a(r12) == false) goto L23;
        maa.e r17 = G4();
        if (r17 == null) goto L39;
        r17.TE(false, r13, new OLiveTutorSpeakerComponent$updateSpeakerVisibilityAdapter$3(this));
        return;
    L39:
        return;
    L23:
        super.L8(false, true, r11, VoiceInputType.TouchSpeaker, r13);
        maa.f r19 = F4();
        if (r19 != null) goto L26;
    L28:
        r1 = false;
    L29:
        if (r1 == false) goto L41;
        maa.e r20 = G4();
        if (r20 == null) goto L42;
        r20.TE(false, r13, new OLiveTutorSpeakerComponent$updateSpeakerVisibilityAdapter$4(this));
        return;
    L42:
        return;
    L41:
        return;
    L26:
        if (r19.iC() != true) goto L28;
        goto L28
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.asr.d4, java.lang.Object, kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.asr.session.c] */
    @Override // com.larus.asr.LiveTutorSpeakerComponent
    public final Triple<com.larus.asr.session.o, Boolean, Boolean> V3(boolean r7, c0 r8, String r9, VoiceInputType r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "traceInfo");
        Intrinsics.checkNotNullParameter(r9, "asrTaskId");
        Intrinsics.checkNotNullParameter(r10, "voiceInputType");
        final com.larus.asr.session.g r12 = (com.larus.asr.session.g) ((ChatBottomSpeakerComponent) this).t.getValue();
        ?? r4 = new d4(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r9, "taskId");
        Intrinsics.checkNotNullParameter(r10, "voiceInputType");
        Intrinsics.checkNotNullParameter(r4, "clickTalkAbilityGetter");
        VoiceInputType.Companion.getClass();
        if (VoiceInputType.a.a(r10) == false) goto L6;
        Object r13 = new SamiCallAsrSession(r12.a, r9, r11, r4, r10);
    L10:
        if ((r13 instanceof ComponentAsrSession) == false) goto L12;
        ComponentAsrSession r14 = (ComponentAsrSession) r13;
    L13:
        r12.b = r14;
        return new Triple(r13, Boolean.TRUE, Boolean.FALSE);
    L12:
        r14 = null;
        goto L13
    L6:
        if (com.larus.platform.service.z2.a.asrSessionComponentSplit() == false) goto L8;
        maa.e r5 = (maa.e) r4.invoke();
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        com.larus.asr.session.z0 r16 = new com.larus.asr.session.z0(r12.a, r9, r10, new com.larus.asr.session.c(r12, r15), r5);
        r15.element = r16;
        r13 = r16;
        goto L10
    L8:
        r13 = new com.larus.asr.session.y0(r12.a, r9, r10, (maa.e) r4.invoke());
        goto L10
    }
}
