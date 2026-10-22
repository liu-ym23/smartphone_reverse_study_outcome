package com.larus.voicecall.impl.component.feedback;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.im.service.audio.z0;
import com.larus.platform.api.d3;
import com.larus.platform.model.NotificationType;
import com.larus.platform.model.audio.AudioFeedbackFrequencyConfig;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.tracer.RealtimeCallTracer;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.n3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pf9.f0;
import pf9.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020'H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010-J\u001a\u0010.\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010-J<\u0010/\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010%2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u000104H\u0096@¢\u0006\u0002\u00105J\u001a\u00106\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+H\u0096@¢\u0006\u0002\u0010-J\u0018\u00107\u001a\u0004\u0018\u00010+2\u0006\u00108\u001a\u000209H\u0082@¢\u0006\u0002\u0010:J4\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\b\u0010>\u001a\u0004\u0018\u00010%2\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010@H\u0096@¢\u0006\u0002\u0010AJN\u0010B\u001a\b\u0012\u0004\u0012\u00020=0<2\b\u0010>\u001a\u0004\u0018\u00010%2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001042\b\u00102\u001a\u0004\u0018\u00010%2\u0014\u0010?\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010@H\u0096@¢\u0006\u0002\u0010DJ\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020FH\u0002J\b\u0010H\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020'H\u0002J\b\u0010J\u001a\u00020'H\u0002J\b\u0010K\u001a\u00020'H\u0002J\u0010\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020QH\u0016J\u001a\u0010R\u001a\u00020'2\u0006\u0010P\u001a\u00020%2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u000e\u0010U\u001a\u00020'H\u0082@¢\u0006\u0002\u0010VJ\b\u0010W\u001a\u00020'H\u0002J*\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/larus/voicecall/impl/component/feedback/RealtimeCallFeedbackComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "vlmAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVlmAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "vlmAbility$delegate", "feedbackExtraInfoHolder", "Lcom/larus/voicecall/impl/component/feedback/FeedbackExtraInfoHolder;", "getFeedbackExtraInfoHolder", "()Lcom/larus/voicecall/impl/component/feedback/FeedbackExtraInfoHolder;", "feedbackExtraInfoHolder$delegate", "msgId", NameKeys.UnloadStrategy_No_Strategy, "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onVContextReady", "checkIfNeedShowFeedbackCall", "likeMessage", "Lcom/larus/im/bean/message/Message;", "message", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelLikeMessage", "dislikeMessage", "feedbackDislikeDetailType", NameKeys.UnloadStrategy_No_Strategy, "feedbackDetailContent", "feedbackDislikeDetailTypes", NameKeys.UnloadStrategy_No_Strategy, "(Lcom/larus/im/bean/message/Message;ILjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelDislikeMessage", "submitMessageFeedback", "request", "Lcom/larus/im/bean/message/FeedbackMessageRequest;", "(Lcom/larus/im/bean/message/FeedbackMessageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "likeCall", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/voicecall/impl/component/feedback/api/RealtimeCallFeedbackSubmitResponse;", "callId", "extra", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dislikeCall", "feedbackDetailTypes", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canShowFeedbackNotification", NameKeys.UnloadStrategy_No_Strategy, "canShowGlobalFeedbackNotification", "queryAndShowRealtimeFeedbackNotification", "showRealtimeFeedbackNotification", "onFeedbackLikeCall", "onFeedbackDislikeCall", "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "otherEvent", LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "appendLogIdFromTraceMsgId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendTaskIdFromRuntimeData", "showDislikeDetailDialog", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", LynxResourceModule.PARAMS_KEY, "Lcom/larus/voicecall/impl/component/feedback/DislikeDetailDialogParams;", "callback", "Lcom/larus/voicecall/impl/component/feedback/IDislikeFeedbackDialogCallback;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallFeedbackComponent extends RealtimeComponent implements e {
    public static final /* synthetic */ int u = 0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public String t;

    public static final class a {
    }

    public static final class b implements o99.a {
        public final /* synthetic */ kotlinx.coroutines.i<Message> a;

        public static final class a implements Function1<Throwable, Unit> {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object invoke(Object r2) {
                Intrinsics.checkNotNullParameter((Throwable) r2, "<unused var>");
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.larus.voicecall.impl.component.feedback.RealtimeCallFeedbackComponent$b$b, reason: collision with other inner class name */
        public static final class C0015b implements Function1<Throwable, Unit> {
            public static final C0015b a = null;

            static {
                a = new C0015b();
            }

            public C0015b() {
            }

            public final Object invoke(Object r2) {
                Intrinsics.checkNotNullParameter((Throwable) r2, "<unused var>");
                return Unit.INSTANCE;
            }
        }

        public final void d() {
        }

        public final void e(q99.d r1) {
        }

        public final void h() {
        }

        public final void i() {
        }

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Bundle b(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "bundle");
            Intrinsics.checkNotNullParameter(r2, "bundle");
            return r2;
        }

        public final n3 f(n3 r2) {
            Intrinsics.checkNotNullParameter(r2, "originalRequest");
            Intrinsics.checkNotNullParameter(r2, "originalRequest");
            return r2;
        }

        public final void a(q99.m r2, q99.l r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "error");
            this.a.h(null, a.a);
        }

        public final void c(q99.e r1, q99.a r2) {
            o99.a.a.a(r1, r2);
        }

        public final void g(q99.m r2, q99.n r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.h(r3.a, C0015b.a);
        }

        public final void j(q99.e r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "delivery");
            Intrinsics.checkNotNullParameter(r1, "delivery");
        }
    }

    static {
    }

    public final void A0() {
        e3a.a r0 = (e3a.a) this.n.getValue();
        z3();
        m3();
        RealtimeCallService r1 = (RealtimeCallService) this.q.getValue();
    }

    @Override // com.larus.voicecall.impl.component.feedback.e
    public final void j60() {
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCallFeedbackComponent", "[canShowGlobalFeedbackNotification");
        if (((h88.b) z3()).d == true) goto L5;
        r0.i("RealtimeCallFeedbackComponent", "[canShowGlobalFeedbackNotification]: not main bot");
    L18:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L22;
        FlowFeedbackServiceDelegate.a.a(new q99.c(3), new q99.i("chat", "phone_call", null, m3().e, null, null, null, new n(), new o(), CollectionsKt.listOf(new String[]{"chat", "immersive"}), "realtime", new p(this), null, null, new g(this), new q(this), 28788));
        return;
    L22:
        r0.i("RealtimeCallFeedbackComponent", "[canShowFeedbackNotification]: invoke");
        if (((h88.b) z3()).d == true) goto L25;
        r0.i("RealtimeCallFeedbackComponent", "[canShowFeedbackNotification]: not main bot");
    L28:
        String r21 = "immersive";
        String r14 = "consecutive_shown_count";
        String r22 = "shown_ts_list";
    L82:
        boolean r1 = false;
    L83:
        if (r1 == false) goto L122;
        String r2 = ((h88.a) ((e3a.a) this.n.getValue())).e;
        if (r2.length() != 0) goto L87;
        boolean r4 = true;
    L88:
        if (r4 == false) goto L91;
        r2 = "res://" + AppHost.a.getApplication().getPackageName() + "/2131240119";
    L91:
        if (d3.a.c(new n3(null, r2, AppHost.a.getApplication().getString(2131900050), null, NotificationType.FEEDBACK, 0, "realtime", CollectionsKt.listOf(new String[]{"chat", r21}), new r(this), null, null, null, null, null, false, null, false, null, 1047637)) == false) goto L123;
        FLogger r5 = FLogger.a;
        r5.i("RealtimeCallFeedbackComponent", "[showRealtimeFeedbackNotification]: pushInnerNotification success, callId = " + m3().e);
        v.b(m3().e);
        int r6 = s.a;
        AudioFeedbackFrequencyConfig r7 = z2.a.audioFeedbackFrequencyConfig();
        long r8 = System.currentTimeMillis();
        String r9 = r22;
        Set r10 = u.a().getStringSet(r9, new LinkedHashSet());
        if (r10 != null) goto L95;
        r10 = SetsKt.emptySet();
    L95:
        Set r11 = CollectionsKt.toMutableSet(r10);
        r11.add(String.valueOf(r8));
        if (r11.isEmpty() == false) goto L98;
        u.a().erase(r9);
    L99:
        int r12 = 0;
        int r13 = u.a().getInt(r14, 0);
        long r15 = u.a().getLong("last_consecutive_shown_ts", 0);
        if (r13 >= r7.getRealtimeNoFeedbackTimes()) goto L102;
    L106:
        r12 = r13;
    L107:
        int r16 = r12 + 1;
        u.a().storeInt(r14, r16);
        u.a().storeLong("last_consecutive_shown_ts", r8);
        r5.i("RealtimeFeedbackNotificationFrequencyManager", "[recordShown] newCount=" + r16 + ", threshold=" + r7.getRealtimeNoFeedbackTimes() + ", newTimestamps=" + r11);
        return;
    L102:
        if (r15 <= 0) goto L106;
        if (r8 < (r15 + (((long) r7.getRealtimeNoPopupDays()) * 86400000))) goto L106;
        r5.i("RealtimeFeedbackNotificationFrequencyManager", "[recordShown] Cooldown ended. Resetting consecutive count.");
        goto L107
    L98:
        u.a().storeStringSet(r9, r11);
        goto L99
    L123:
        return;
    L87:
        r4 = false;
        goto L88
    L122:
        return;
    L25:
        z2 r17 = z2.a;
        if (r17.audioFeedbackSwitch().getRealtimeCallEnable() == true) goto L29;
        r0.i("RealtimeCallFeedbackComponent", "[canShowFeedbackNotification]: realtimeCallEnable is false");
        goto L28
    L29:
        RealtimeCallTracer r18 = ((RealtimeCallService) this.q.getValue()).u.y;
        r21 = "immersive";
        if (r18.n == (-1)) goto L32;
        int r19 = (int) ((System.currentTimeMillis() - r18.n) / ((long) 1000));
    L33:
        if (r19 > 0) goto L35;
    L81:
        r14 = "consecutive_shown_count";
        r22 = "shown_ts_list";
        r0.i("RealtimeCallFeedbackComponent", "[canShowFeedbackNotification]: duration is " + r19);
        goto L82
    L35:
        if (r19 < r17.audioFeedbackFrequencyConfig().getRealtimeCallDurationThreshold()) goto L81;
        int r20 = s.a;
        AudioFeedbackFrequencyConfig r23 = r17.audioFeedbackFrequencyConfig();
        long r24 = System.currentTimeMillis();
        Set r25 = u.a().getStringSet("shown_ts_list", new LinkedHashSet());
        if (r25 != null) goto L40;
        r25 = SetsKt.emptySet();
    L40:
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L42:
        if (r27.hasNext() == false) goto L54;
        String r28 = (String) r27.next();
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L46
        Object r30 = Result.constructor-impl(Long.valueOf(CastLongProtector.parseLong(r28)));     // Catch: Throwable -> L46
    L49:
        if (Result.isFailure-impl(r30) == false) goto L51;
        r30 = null;
    L51:
        Long r31 = (Long) r30;
        if (r31 == null) goto L42;
        r26.add(r31);
    L46:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L54:
        long r33 = r24 - (((long) r23.getRealtimeCallIntervalDays()) * 86400000);
        ArrayList r34 = new ArrayList();
        Iterator r35 = r26.iterator();
    L56:
        if (r35.hasNext() == false) goto L64;
        Object r110 = r35.next();
        if (((Number) r110).longValue() < r33) goto L60;
        boolean r210 = true;
    L61:
        if (r210 == false) goto L56;
        r34.add(r110);
        goto L56
    L60:
        r210 = false;
        goto L61
    L64:
        if (r34.size() < r23.getRealtimeMaxDisplayTimes()) goto L66;
        FLogger.a.i("RealtimeFeedbackNotificationFrequencyManager", "[canShow] capStartTime=" + r33 + ", recentShows.size=" + r34.size() + ", max=" + r23.getRealtimeMaxDisplayTimes());
        r14 = "consecutive_shown_count";
        r22 = "shown_ts_list";
    L73:
        boolean r36 = false;
    L78:
        if (r36 == true) goto L80;
        FLogger.a.i("RealtimeCallFeedbackComponent", "[canShowFeedbackNotification]: frequency check is false");
        goto L82
    L80:
        r1 = true;
        goto L83
    L66:
        int r37 = u.a().getInt("consecutive_shown_count", 0);
        if (r37 < r23.getRealtimeNoFeedbackTimes()) goto L76;
        r14 = "consecutive_shown_count";
        r22 = "shown_ts_list";
        long r38 = u.a().getLong("last_consecutive_shown_ts", 0);
        if (r38 <= 0) goto L75;
        long r111 = (((long) r23.getRealtimeNoPopupDays()) * 86400000) + r38;
        if (r111 <= r24) goto L74;
        FLogger.a.i("RealtimeFeedbackNotificationFrequencyManager", "[canShow] in cooldown. lastConsecutiveShownTs=" + r38 + ", cooldownEndTs=" + r111 + ", currentTs=" + r24 + ", realtimeNoPopupDays=" + r23.getRealtimeNoPopupDays());
        goto L73
    L74:
        FLogger.a.i("RealtimeFeedbackNotificationFrequencyManager", "[canShow] Cooldown ended. Resetting consecutive count.");
    L77:
        FLogger.a.d("RealtimeFeedbackNotificationFrequencyManager", "[canShow] consecutiveShownCount=" + r37 + ", recentShows=" + r34 + ", max=" + r23.getRealtimeMaxDisplayTimes());
        r36 = true;
        goto L78
    L75:
        FLogger.a.i("RealtimeFeedbackNotificationFrequencyManager", "[canShow] lastConsecutiveShownTs less than 0.");
        goto L77
    L76:
        r14 = "consecutive_shown_count";
        r22 = "shown_ts_list";
        goto L77
    L32:
        r19 = 0;
        goto L33
    L5:
        z2 r39 = z2.a;
        if (r39.getGlobalFeedbackConfig().getFeedbackEnable() == true) goto L8;
        r0.i("RealtimeCallFeedbackComponent", "[canShowGlobalFeedbackNotification]: feedbackEnable is false");
        goto L18
    L8:
        RealtimeCallTracer r40 = ((RealtimeCallService) this.q.getValue()).u.y;
        if (r40.n == (-1)) goto L11;
        int r41 = (int) ((System.currentTimeMillis() - r40.n) / ((long) 1000));
    L12:
        if (r41 > 0) goto L14;
    L17:
        r0.i("RealtimeCallFeedbackComponent", "[canShowGlobalFeedbackNotification]: duration is " + r41);
        goto L18
    L14:
        if (r41 < r39.audioFeedbackFrequencyConfig().getRealtimeCallDurationThreshold()) goto L17;
        r3 = true;
        goto L20
    L11:
        r41 = 0;
        goto L12
    }

    public final RealtimeCallParam m3() {
        return (RealtimeCallParam) this.p.getValue();
    }

    public final c p3() {
        return (c) this.s.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, e.class);
    }

    public final e3a.b z3() {
        return (e3a.b) this.o.getValue();
    }

    public RealtimeCallFeedbackComponent() {
        this.n = LazyKt.lazy(new f(this));
        this.o = LazyKt.lazy(new h(this));
        this.p = LazyKt.lazy(new i(this));
        this.q = LazyKt.lazy(new j(this));
        this.r = LazyKt.lazy(new k(this));
        this.s = LazyKt.lazy(new l());
    }

    public final void D9(z0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        FLogger.a.i("RealtimeCallFeedbackComponent", "onReceiveEvent: " + g2a.d.b(r5.toString()));
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r1 = false;
        if ((r5 instanceof o0) == false) goto L20;
        com.larus.voicecall.impl.component.vlm.b r0 = (com.larus.voicecall.impl.component.vlm.b) this.r.getValue();
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L14;
        if (((o0) r5).a == false) goto L14;
        p3().a(CallTypeTrace.Video);
        return;
    L14:
        if (((h88.b) z3()).t == true) goto L16;
    L18:
        p3().a(CallTypeTrace.Audio);
        return;
    L16:
        if (((o0) r5).a == false) goto L18;
        p3().a(CallTypeTrace.Screen);
        return;
    L7:
        if (r0.D5() != true) goto L9;
        r1 = true;
        goto L9
    L20:
        if ((r5 instanceof pf9.o) == false) goto L31;
        com.larus.voicecall.impl.component.vlm.b r6 = (com.larus.voicecall.impl.component.vlm.b) this.r.getValue();
        if (r6 != null) goto L24;
    L26:
        if (r1 == false) goto L28;
        return;
    L28:
        if (((h88.b) z3()).t == true) goto L45;
        p3().a(CallTypeTrace.Audio);
        return;
    L45:
        return;
    L24:
        if (r6.D5() != true) goto L26;
        r1 = true;
        goto L26
    L31:
        if ((r5 instanceof f0) == false) goto L47;
        String r7 = pf9.i.f((f0) r5);
        if (r7.length() <= 0) goto L35;
        r1 = true;
    L35:
        if (r1 == true) goto L38;
        r7 = null;
    L38:
        if (r7 == null) goto L48;
        this.t = r7;
        return;
    L48:
        return;
    }

    public final void I6(jd9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        if ((r3 instanceof jd9.c.d) == false) goto L6;
        c r0 = p3();
        String r4 = String.valueOf(((jd9.c.d) r3).c);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "callErrorDetail");
        ((ArrayList) r0.a).add(r4);
        return;
    }

    public static final Object h3(RealtimeCallFeedbackComponent r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof RealtimeCallFeedbackComponent$appendLogIdFromTraceMsgId$1) == false) goto L7;
        RealtimeCallFeedbackComponent$appendLogIdFromTraceMsgId$1 r0 = (RealtimeCallFeedbackComponent$appendLogIdFromTraceMsgId$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L31:
        Message r8 = (Message) r7;
    L33:
        if (r8 == null) goto L40;
        c r9 = r5.p3();
        String r10 = com.larus.im.bean.message.a.x(r8);
        if (r10 == null) goto L38;
        r4 = r10;
    L38:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r4, "logId");
        r9.d = r4;
    L40:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        String r11 = r5.t;
        if (r11 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == true) goto L41;
        IChatRepoService r13 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
        if (r13 == null) goto L32;
        String r14 = r5.t;
        if (r14 != null) goto L28;
        r14 = NameKeys.UnloadStrategy_No_Strategy;
    L28:
        r0.label = 1;
        r7 = r13.E1(r14, r0);
        if (r7 != r2) goto L31;
        return r2;
    L32:
        r8 = null;
        goto L33
    L41:
        return Unit.INSTANCE;
    L17:
        if (r11.length() == 0) goto L20;
        r12 = false;
    L7:
        r0 = new RealtimeCallFeedbackComponent$appendLogIdFromTraceMsgId$1(r5, r6);
        goto L8
    }

    public final Object B3(yc9.m r13, Continuation<? super Message> r14) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r14), 1);
        r0.C();
        FlowFeedbackServiceDelegate r1 = FlowFeedbackServiceDelegate.a;
        List r2 = r13.e;
        if (r2 != null) goto L5;
        r2 = CollectionsKt.listOf(Boxing.boxInt(r13.d));
    L5:
        yc9.m r4 = yc9.m.a(r13, r2);
        Integer r5 = Boxing.boxInt(8);
        String r9 = m3().e;
        Map r15 = MapsKt.createMapBuilder();
        r15.put("click_module", "call_subtitle");
        Unit r3 = Unit.INSTANCE;
        r1.g(new q99.m(r4, r5, null, null, "call_end_feedback", r9, MapsKt.build(r15), 12), new b(r0));
        Object r16 = r0.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L8:
        return r16;
    }

    @Override // com.larus.voicecall.impl.component.feedback.e
    public final Object R90(Message r17, Continuation<? super Message> r18) {
        if (r17 != null) goto L5;
        return null;
    L5:
        String r1 = r17.getMessageId();
        if (r1 != null) goto L9;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return B3(new yc9.m(null, r1, MsgFeedbackType.MsgFeedbackTypeLike, 0, null, null, null, null, null, null, null, false, null, 8185), r18);
    }

    @Override // com.larus.voicecall.impl.component.feedback.e
    public final Object eE(Message r17, Continuation<? super Message> r18) {
        if (r17 != null) goto L5;
        return null;
    L5:
        String r1 = r17.getMessageId();
        if (r1 != null) goto L9;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return B3(new yc9.m(null, r1, MsgFeedbackType.MsgFeedbackTypeDefault, 0, null, null, null, null, null, null, null, false, null, 8185), r18);
    }

    @Override // com.larus.voicecall.impl.component.feedback.e
    public final Object fL(Message r17, Continuation<? super Message> r18) {
        if (r17 != null) goto L5;
        return null;
    L5:
        String r1 = r17.getMessageId();
        if (r1 != null) goto L9;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return B3(new yc9.m(null, r1, MsgFeedbackType.MsgFeedbackTypeDefault, 0, null, null, null, null, null, null, null, false, null, 8185), r18);
    }

    public final void z2(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
        if (Intrinsics.areEqual(r2, "OTHER_EVENT_RTC_ROOM_ID_GET") == false) goto L12;
        if (r3 != null) goto L6;
        return;
    L6:
        if ((r3 instanceof String) == false) goto L8;
        String r4 = (String) r3;
    L9:
        if (r4 == null) goto L14;
        c r5 = p3();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "roomId");
        ((ArrayList) r5.c).add(r4);
        return;
    L14:
        return;
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.larus.voicecall.impl.component.feedback.e
    public final void no(FragmentActivity r8, final FragmentManager r9, final com.larus.voicecall.impl.component.feedback.a r10, final d r11) {
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r9, "fragmentManager");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        DialogFragment r1 = r9.findFragmentByTag("realtime_feedback_dislike_dialog");
        String r3 = null;
        if ((r1 instanceof DialogFragment) == false) goto L5;
        DialogFragment r2 = r1;
    L6:
        if (r2 == null) goto L15;
        r2.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L49;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L49:
        return;
    L15:
        if (r10.a.isEmpty() == false) goto L21;
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("[showDislikeDetailDialog]: metaList is empty, callId = ");
        Message r15 = r10.c;
        if (r15 == null) goto L19;
        r3 = r15.getMessageId();
    L19:
        r14.append(r3);
        r13.i("RealtimeCallFeedbackComponent", r14.toString());
        r11.a(new com.larus.voicecall.impl.component.feedback.b(6));
        return;
    L21:
        r9.setFragmentResultListener("realtime_feedback_dislike_dialog", r8, new m(r10, r11, r9));
        IAIChatService.Companion r16 = IAIChatService.a;
        ArrayList<FeedbackMeta> r17 = r10.a;
        String r4 = r10.b;
        Bundle r5 = new Bundle();
        r5.putString("feedback_request_key", "realtime_feedback_dislike_dialog");
        Message r18 = r10.c;
        if (r18 == null) goto L31;
        r5.putString("message_id", r18.getMessageId());
        Map r6 = r18.getExt();
        if (r6 == null) goto L26;
        r3 = (String) r6.get("inner_log_id");
    L26:
        r5.putString("message_log_id", r3);
        Integer r19 = r18.getFeedback();
        if (r19 == null) goto L29;
        int r110 = r19.intValue();
    L30:
        r5.putInt("last_feedback", r110);
        r5.putBoolean("is_multiple_selection", true);
        goto L31
    L29:
        r110 = MsgFeedbackType.MsgFeedbackTypeDefault.value;
    L31:
        Unit r111 = Unit.INSTANCE;
        DialogFragment r20 = r16.k7(r17, r4, r5);
        if (r20.isAdded() == true) goto L51;
        LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L39
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r20, "realtime_feedback_dislike_dialog", r112);     // Catch: Exception -> L39
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r20, r112) == true) goto L52;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L37:
        r20.show(r9, "realtime_feedback_dislike_dialog");     // Catch: Exception -> L39
        return;
    L52:
        return;
    L39:
        e = move-exception;
        FLogger.a.e("RealtimeCallFeedbackComponent", "showDislikeDialog: show dialog error", e);
        return;
    L51:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.voicecall.impl.component.feedback.e
    public final Object rH(Message r17, int r18, String r19, List<Integer> r20, Continuation<? super Message> r21) {
        if (r17 != null) goto L5;
        return null;
    L5:
        String r0 = r17.getMessageId();
        if (r0 != null) goto L9;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        return B3(new yc9.m(null, r0, MsgFeedbackType.MsgFeedbackTypeDislike, r18, r20, r19, null, null, null, null, null, false, null, 8129), r21);
    }
}
