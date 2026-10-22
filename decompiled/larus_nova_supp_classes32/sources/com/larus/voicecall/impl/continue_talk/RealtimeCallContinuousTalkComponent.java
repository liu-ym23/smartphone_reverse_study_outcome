package com.larus.voicecall.impl.continue_talk;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.video.VideoPreviewState;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import w3a.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001Q\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001lB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020TH\u0016J\u0010\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020EH\u0016J\u0010\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020T2\u0006\u0010\\\u001a\u00020]H\u0016J(\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020`2\u0006\u0010c\u001a\u00020\fH\u0016J\b\u0010d\u001a\u00020TH\u0002J%\u0010e\u001a\u00020T*\u00020Z2\u0017\u0010f\u001a\u0013\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020T0g¢\u0006\u0002\biH\u0002J\b\u0010j\u001a\u00020TH\u0016J\b\u0010k\u001a\u00020EH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\n\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\n\u001a\u0004\bM\u0010NR\u0010\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R¨\u0006m"}, d2 = {"Lcom/larus/voicecall/impl/continue_talk/RealtimeCallContinuousTalkComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/continue_talk/IRealtimeCallContinuousTalkAbility;", "<init>", "()V", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "Lkotlin/Lazy;", "curUIState", NameKeys.UnloadStrategy_No_Strategy, "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "denoiseAbility", "Lcom/larus/voicecall/impl/component/denoise/IRealtimeDenoiseAbility;", "getDenoiseAbility", "()Lcom/larus/voicecall/impl/component/denoise/IRealtimeDenoiseAbility;", "denoiseAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "screenShareAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeScreenShareAbility;", "getScreenShareAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeScreenShareAbility;", "screenShareAbility$delegate", "dynamicMoreBtn", "Lcom/larus/av_call/util/RealtimeBottomMoreBtn;", "getDynamicMoreBtn", "()Lcom/larus/av_call/util/RealtimeBottomMoreBtn;", "dynamicMoreBtn$delegate", "moreAction", "Lcom/larus/voicecall/impl/component/bottom/more_btn/BottomMoreAction;", "getMoreAction", "()Lcom/larus/voicecall/impl/component/bottom/more_btn/BottomMoreAction;", "moreAction$delegate", "isStreaming", NameKeys.UnloadStrategy_No_Strategy, "chatContinuousTalkAbility", "Lcom/larus/bmhome/audio/IChatContinuousTalkAbility;", "getChatContinuousTalkAbility", "()Lcom/larus/bmhome/audio/IChatContinuousTalkAbility;", "chatContinuousTalkAbility$delegate", "vlmAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVlmAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "vlmAbility$delegate", "streamObserver", "com/larus/voicecall/impl/continue_talk/RealtimeCallContinuousTalkComponent$streamObserver$1", "Lcom/larus/voicecall/impl/continue_talk/RealtimeCallContinuousTalkComponent$streamObserver$1;", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onCreate", "onMuteStateChanged", "openTtsContinuousTalk", "onViewCreated", "view", "Landroid/view/View;", "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "registerStreamListener", "safelyUpdateLayoutParams", "block", "Lkotlin/Function1;", "Landroid/view/ViewGroup$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "onDestroy", "isMoreBtnNormalState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallContinuousTalkComponent extends RealtimeComponent implements n1 {
    public static final /* synthetic */ int E = 0;
    public boolean A;
    public final Lazy B;
    public final Lazy C;
    public final e D;
    public final Lazy n;
    public int o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ RealtimeCallContinuousTalkComponent b;

        public b(View r1, RealtimeCallContinuousTalkComponent r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RealtimeCallContinuousTalkComponent r0 = this.b;     // Catch: Throwable -> L6
            int r1 = RealtimeCallContinuousTalkComponent.E;     // Catch: Throwable -> L6
            w3a.k r2 = (w3a.k) r0.n.getValue();     // Catch: Throwable -> L6
            if (r2 == null) goto L9;
            RealtimePageMode r3 = RealtimePageMode.HALF_SCREEN;     // Catch: Throwable -> L6
            int r4 = w3a.k.g;     // Catch: Throwable -> L6
            r2.b(r3, 0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements com.larus.voicecall.impl.component.window.a {
        public final /* synthetic */ RealtimeCallContinuousTalkComponent a;

        @Override // com.larus.voicecall.impl.component.window.a
        public final boolean a() {
            RealtimeCallContinuousTalkComponent r0 = this.a;
            int r1 = RealtimeCallContinuousTalkComponent.E;
            e3a.a r2 = r0.m3();
            if (r2 != null) goto L5;
            return false;
        L5:
            if (((h88.a) r2).k0 != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.larus.voicecall.impl.component.window.a
        public final void b() {
            FLogger r0 = FLogger.a;
            r0.i("RealtimeCallContinuousTalkComponent", "intercept back");
            final Fragment r1 = s1a.a.c(this.a);
            r0.i("RealtimeCallContinuousTalkComponent", "exit half screen mode");
            View r2 = r1.getView();
            if (r2 == null) goto L6;
            r2.post(new e2(r1));
            return;
        }

        public c(RealtimeCallContinuousTalkComponent r1) {
            this.a = r1;
        }
    }

    public static final class d implements w3a.i {
        public final /* synthetic */ RealtimeCallContinuousTalkComponent a;

        public d(RealtimeCallContinuousTalkComponent r1) {
            this.a = r1;
        }

        @Override // w3a.i
        public final void a(w3a.h r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            if ((r8 instanceof w3a.a) == false) goto L57;
            w3a.a r9 = (w3a.a) r8;
            String r2 = null;
            View r3 = null;
            r2 = null;
            r2 = null;
            r2 = null;
            if (r9.a != RealtimePageMode.HALF_SCREEN) goto L36;
            xa8.b r0 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r0 == null) goto L9;
            r0.PS();
        L9:
            com.larus.voicecall.impl.component.bottom.b r1 = (com.larus.voicecall.impl.component.bottom.b) this.a.p.getValue();
            if (r1 == null) goto L14;
            VoiceCallBottomLayout r4 = r1.BT();
            if (r4 == null) goto L14;
            Object r5 = r4.getParent();
        L16:
            if ((r5 instanceof View) == false) goto L19;
            r3 = (View) r5;
        L19:
            if (r3 == null) goto L34;
            int r6 = r3.getHeight();
            View r7 = s1a.a.c(this.a).getView();
            if (r7 == null) goto L32;
            int r10 = r7.getHeight();
            i0.a.getClass();
            int r11 = i0.e();
            FLogger.a.i("RealtimeCallContinuousTalkComponent", "change call size, isSmall=" + r9.a + " . fmHeight=" + r10 + " navBarHeight=" + r11 + " voiceCallBottomLayout height is " + r6);
            int r12 = r9.b;
            if (r12 > 0) goto L26;
            r12 = (r10 - r6) - r11;
        L26:
            View r13 = s1a.a.c(this.a).getView();
            if (r13 == null) goto L29;
            r13.setPadding(r13.getPaddingLeft(), r12, r13.getPaddingRight(), r13.getPaddingBottom());
        L29:
            xa8.b r14 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r14 == null) goto L77;
            r14.ym(r12);
            return;
        L77:
            return;
        L32:
            FLogger.a.e("RealtimeCallContinuousTalkComponent", "fragment view height is null");
            return;
        L34:
            FLogger.a.e("RealtimeCallContinuousTalkComponent", "voiceCallBottomLayout height is null");
            return;
        L14:
            r5 = null;
            goto L16
        L36:
            com.larus.voicecall.impl.component.scene.a r15 = (com.larus.voicecall.impl.component.scene.a) this.a.w.getValue();
            if (r15 == null) goto L45;
            LiveData<com.larus.voicecall.impl.scene.m> r16 = r15.getCurrentScene();
            if (r16 == null) goto L45;
            com.larus.voicecall.impl.scene.m r17 = (com.larus.voicecall.impl.scene.m) r16.getValue();
            if (r17 == null) goto L45;
            SceneModel r18 = r17.a;
            if (r18 == null) goto L45;
            r2 = r18.getKey();
        L45:
            String r19 = u3a.f.a;
            if (Intrinsics.areEqual(r2, "interpret_v2") == false) goto L50;
            xa8.b r20 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r20 == null) goto L50;
            r20.AF();
        L50:
            View r21 = s1a.a.c(this.a).getView();
            if (r21 == null) goto L53;
            r21.setPadding(r21.getPaddingLeft(), 0, r21.getPaddingRight(), r21.getPaddingBottom());
        L53:
            xa8.b r22 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r22 == null) goto L79;
            r22.ym(0);
            return;
        L79:
            return;
        L57:
            if ((r8 instanceof l) == false) goto L67;
            if (((l) r8).a == false) goto L63;
            xa8.b r23 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r23 == null) goto L81;
            r23.PS();
            return;
        L81:
            return;
        L63:
            xa8.b r24 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r24 == null) goto L83;
            r24.AF();
            return;
        L83:
            return;
        L67:
            if ((r8 instanceof w3a.o) == true) goto L69;
            return;
        L69:
            if (((w3a.o) r8).a != VideoPreviewState.full) goto L73;
            xa8.b r25 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r25 == null) goto L86;
            r25.AF();
            return;
        L86:
            return;
        L73:
            xa8.b r26 = RealtimeCallContinuousTalkComponent.h3(this.a);
            if (r26 == null) goto L88;
            r26.PS();
            return;
        }
    }

    public static final class e implements nf9.c {
        public final /* synthetic */ RealtimeCallContinuousTalkComponent a;

        public e(RealtimeCallContinuousTalkComponent r1) {
            this.a = r1;
        }

        public final void A(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "message");
            boolean r1 = false;
            this.a.A = false;
            FLogger r0 = FLogger.a;
            StringBuilder r2 = new StringBuilder("onStreamEnd message_id=");
            r2.append(r5.getMessageId());
            r2.append(" local_msg_id=");
            r2.append(r5.getLocalMessageId());
            r2.append(" isSilentPlay=");
            e3a.b r6 = this.a.z3();
            if (r6 == null) goto L5;
            Boolean r7 = Boolean.valueOf(((h88.b) r6).v);
        L6:
            r2.append(r7);
            r0.i("RealtimeCallContinuousTalkComponent", r2.toString());
            e3a.a r8 = this.a.m3();
            if (r8 != null) goto L9;
        L11:
            boolean r9 = false;
        L12:
            if (r9 == false) goto L25;
            e3a.b r10 = this.a.z3();
            if (r10 != null) goto L16;
        L18:
            if (r1 == false) goto L26;
            e3a.b r11 = this.a.z3();
            if (r11 == null) goto L27;
            RealtimeCallParam r12 = r11.a();
            if (r12 == null) goto L28;
            ((RealtimeCallService) this.a.t.getValue()).t(r12, true);
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L16:
            if (((h88.b) r10).v != true) goto L18;
            r1 = true;
            goto L18
        L25:
            return;
        L9:
            if (((h88.a) r8).k0 != true) goto L11;
            r9 = true;
            goto L12
        L5:
            r7 = null;
            goto L6
        }

        public final void B(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a.A = true;
        }

        public final void C(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "message");
            this.a.A = true;
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("onStreamBegin message_id=");
            r1.append(r4.getMessageId());
            r1.append(" local_msg_id=");
            r1.append(r4.getLocalMessageId());
            r1.append(" isSilentPlay=");
            e3a.b r5 = this.a.z3();
            if (r5 == null) goto L5;
            Boolean r6 = Boolean.valueOf(((h88.b) r5).v);
        L6:
            r1.append(r6);
            r0.i("RealtimeCallContinuousTalkComponent", r1.toString());
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
    }

    public final e3a.a m3() {
        return (e3a.a) this.r.getValue();
    }

    public final com.larus.voicecall.impl.component.bottom.more_btn.b p3() {
        return (com.larus.voicecall.impl.component.bottom.more_btn.b) this.z.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, n1.class);
    }

    public final e3a.b z3() {
        return (e3a.b) this.s.getValue();
    }

    public RealtimeCallContinuousTalkComponent() {
        this.n = LazyKt.lazy(new v1(this));
        this.o = -1;
        this.p = LazyKt.lazy(new a2(this));
        this.q = LazyKt.lazy(new b2(this));
        this.r = LazyKt.lazy(new c2(this));
        this.s = LazyKt.lazy(new d2(this));
        this.t = LazyKt.lazy(new p1(this));
        this.u = LazyKt.lazy(new q1(this));
        this.v = LazyKt.lazy(new r1(this));
        this.w = LazyKt.lazy(new s1(this));
        this.x = LazyKt.lazy(new t1(this));
        this.y = LazyKt.lazy(new w1(this));
        this.z = LazyKt.lazy(new x1(this));
        this.B = LazyKt.lazy(new y1(this));
        this.C = LazyKt.lazy(new z1(this));
        this.D = new e(this);
    }

    @Override // com.larus.voicecall.impl.continue_talk.n1
    public final boolean GF() {
        return p3().g instanceof com.larus.voicecall.impl.component.bottom.more_btn.k;
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        IAIChatAudioService.a.cancel();
    }

    public final void onDestroy() {
        p3().g.d();
        int r0 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r1 = com.larus.im.internal.stream.b.a;
        e3a.a r2 = m3();
        if (r2 == null) goto L5;
        String r3 = ((h88.a) r2).f;
    L6:
        if (r3 != null) goto L8;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r1.e(r3, this.D);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final xa8.b h3(RealtimeCallContinuousTalkComponent r0) {
        return (xa8.b) r0.B.getValue();
    }

    public final void I6(jd9.c r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r5, "state");
        com.larus.voicecall.impl.component.bottom.more_btn.b r1 = p3();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "state");
        FLogger.a.i("BottomMoreAction", "onConnectionStateChanged state=[" + r5 + ']');
        r1.e = r5;
        r1.a();
    }

    @Override // com.larus.voicecall.impl.continue_talk.n1
    public final void onMuteStateChanged(boolean r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onMuteStateChanged change. isSilentPlay=");
        boolean r2 = !r6;
        r1.append(r2);
        r1.append(" isStreaming=");
        r1.append(this.A);
        r1.append(" curUIState=");
        InstanceCallState.a r3 = InstanceCallState.Companion;
        int r4 = this.o;
        r3.getClass();
        r1.append(InstanceCallState.a.a(r4));
        r0.w("RealtimeCallContinuousTalkComponent", r1.toString());
        e3a.b r5 = z3();
        if (r5 == null) goto L5;
        ((h88.b) r5).v = r2;
    L5:
        if (r6 == false) goto L10;
        com.larus.voicecall.impl.plugins.p r7 = (com.larus.voicecall.impl.plugins.p) LLMCallController.y(((RealtimeCallService) this.t.getValue()).u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.p.class));
        if (r7 == null) goto L23;
        r7.b0();
        return;
    L23:
        return;
    L10:
        if (this.A == false) goto L12;
    L19:
        com.larus.voicecall.impl.plugins.p r8 = (com.larus.voicecall.impl.plugins.p) LLMCallController.y(((RealtimeCallService) this.t.getValue()).u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.p.class));
        if (r8 == null) goto L25;
        r8.f0();
        return;
    L25:
        return;
    L12:
        if (this.o != 5) goto L19;
        e3a.b r9 = z3();
        if (r9 == null) goto L18;
        RealtimeCallParam r10 = r9.a();
        if (r10 == null) goto L18;
        r0.i("RealtimeCallContinuousTalkComponent", "onMuteStateChanged call interrupt");
        ((RealtimeCallService) this.t.getValue()).t(r10, true);
    L18:
        r0.w("RealtimeCallContinuousTalkComponent", "onMuteStateChanged interrupt callParam is null");
        goto L19
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        p3().g.e();
        if (r5.getLayoutParams() != null) goto L5;
        FLogger.a.e("RealtimeCallContinuousTalkComponent", "layoutParams is null");
    L8:
        RealtimeBottomMoreBtn r6 = (RealtimeBottomMoreBtn) this.y.getValue();
        if (r6 == null) goto L11;
        r6.setOnClickListener(new o1(this));
    L11:
        com.larus.voicecall.impl.component.window.b r7 = (com.larus.voicecall.impl.component.window.b) this.q.getValue();
        if (r7 == null) goto L14;
        r7.gS(new c(this));
    L14:
        w3a.k r8 = (w3a.k) this.n.getValue();
        if (r8 == null) goto L17;
        r8.c(new d(this));
    L17:
        e3a.a r9 = m3();
        boolean r0 = true;
        if (r9 != null) goto L20;
    L22:
        boolean r10 = false;
    L23:
        if (r10 == false) goto L37;
        e3a.a r11 = m3();
        if (r11 != null) goto L27;
    L29:
        r0 = false;
    L30:
        if (r0 == false) goto L34;
        w3a.k r12 = (w3a.k) this.n.getValue();
        if (r12 == null) goto L37;
        RealtimePageMode r1 = RealtimePageMode.FULL_SCREEN;
        int r3 = w3a.k.g;
        r12.b(r1, 0);
        goto L37
    L34:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r13 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r13 == null) goto L37;
        OneShotPreDrawListener.add(r13, new b(r13, this));
        goto L37
    L27:
        if (((h88.a) r11).m != true) goto L29;
    L37:
        e3a.a r14 = m3();
        if (r14 == null) goto L43;
        String r15 = ((h88.a) r14).f;
        if (r15 == null) goto L43;
        int r2 = com.larus.im.d.a;
        com.larus.im.internal.stream.b.a.b(r15, this.D);
        return;
    L43:
        FLogger.a.w("RealtimeCallContinuousTalkComponent", "conversationId is null");
        return;
    L20:
        if (((h88.a) r9).k0 != true) goto L22;
        r10 = true;
        goto L23
    L5:
        ViewGroup.LayoutParams r4 = r5.getLayoutParams();
        if (r4 == null) goto L46;
        Intrinsics.checkNotNullParameter(r4, "$this$safelyUpdateLayoutParams");
        r4.height = -1;
        Unit r16 = Unit.INSTANCE;
        r5.setLayoutParams(r4);
        goto L8
    L46:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void o1(MajorState r5, int r6, MajorState r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "currentMajorState");
        Intrinsics.checkNotNullParameter(r7, "newMajorState");
        super.o1(r5, r6, r7, r8);
        com.larus.voicecall.impl.component.bottom.more_btn.b r2 = p3();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "currentMajorState");
        Intrinsics.checkNotNullParameter(r7, "newMajorState");
        r2.d = r8;
        if (r8 != 7) goto L5;
    L7:
        FLogger.a.i("BottomMoreAction", "onUpdateUIState currentMajorState=" + r5 + " currentState=" + r6 + " newMajorState=" + r7 + " newState=" + r8);
        r2.a();
    L9:
        if (r8 != 14) goto L11;
        return;
    L11:
        if (r8 == 15) goto L15;
        this.o = r8;
        return;
    L15:
        return;
    L5:
        if (r8 == 8) goto L7;
        goto L7
    }
}
