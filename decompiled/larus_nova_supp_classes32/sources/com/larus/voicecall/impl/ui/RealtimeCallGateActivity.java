package com.larus.voicecall.impl.ui;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.ixigua.lib.track.FrozenTrackNode;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.IAudioService;
import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.bean.BotRecommendMobInfo;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z1;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeMobUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import t19.s;
import tx9.a1;
import v19.e6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0015J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u0011J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\f\u0010#\u001a\u00020\u0006*\u00020\fH\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020\u0006H\u0014J\u000e\u0010'\u001a\u0004\u0018\u00010(*\u00020\bH\u0002J\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\bH\u0002J\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\bH\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\u001c*\u00020\bH\u0002J\f\u0010*\u001a\u00020\u0006*\u00020\bH\u0002¨\u0006-"}, d2 = {"Lcom/larus/voicecall/impl/ui/RealtimeCallGateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "reportClickCallEvent", "Lkotlin/Result;", "launchRealtimeCallParams", "Lcom/larus/voicecall/impl/ui/RealtimeCallGateActivity$LaunchRealtimeCallParams;", "reportClickCallEvent-IoAF18A", "(Lcom/larus/voicecall/impl/ui/RealtimeCallGateActivity$LaunchRealtimeCallParams;)Ljava/lang/Object;", "launchRealTimeCall", LynxResourceModule.PARAMS_KEY, "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchVoiceConfig", "buildLaunchRealtimeCallParams", "tryBuildRealTimeCallParamsByBotId", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "checkNeedContinueTalk", NameKeys.UnloadStrategy_No_Strategy, "conversationId", NameKeys.UnloadStrategy_No_Strategy, "botId", "findOrCreateLocalConversationByBot", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openBotChatPage", "mobEnterChatPage", "jumpToRealtimeCall", "performStart", "logEAndExit", "msg", "onDestroy", "recommendFromAndFillIfNeed", "Lcom/larus/platform/model/RecommendFrom;", "previousPage", "fillSearchMobParamToTrack", "Companion", "LaunchRealtimeCallParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallGateActivity extends AppCompatActivity implements by7.e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b {
        public final Bundle a;
        public final wc9.e b;
        public final BotModel c;
        public final String d;
        public final String e;
        public final boolean f;
        public final String g;
        public final String h;
        public final int i;
        public final String j;
        public final boolean k;
        public final String l;
        public final boolean m;
        public final String n;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            int r2 = 1231;
            if (this.f == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((((((((r0 + r1) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j.hashCode()) * 31;
            if (this.k == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (((r3 + r4) * 31) + this.l.hashCode()) * 31;
            if (this.m == true) goto L15;
            r2 = 1237;
        L15:
            return ((r5 + r2) * 31) + this.n.hashCode();
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "LaunchRealtimeCallParams(sourceBundle=" + this.a + ", conversation=" + this.b + ", botModel=" + this.c + ", enterFrom=" + this.d + ", enterMethod=" + this.e + ", isRedDotVisible=" + this.f + ", currentPage=" + this.g + ", previousPage=" + this.h + ", targetScene=" + this.i + ", isCallBot=" + this.j + ", backToChat=" + this.k + ", openMethod=" + this.l + ", needStartContinueTalk=" + this.m + ", openVlm=" + this.n + ')';
        }

        public b(Bundle r3, wc9.e r4, BotModel r5, String r6, String r7, boolean r8, String r9, int r10, String r11, boolean r12, String r13, boolean r14, String r15) {
            Intrinsics.checkNotNullParameter(r3, "sourceBundle");
            Intrinsics.checkNotNullParameter(r4, "conversation");
            Intrinsics.checkNotNullParameter(r5, "botModel");
            Intrinsics.checkNotNullParameter(r6, "enterFrom");
            Intrinsics.checkNotNullParameter(r7, "enterMethod");
            Intrinsics.checkNotNullParameter("chat", "currentPage");
            Intrinsics.checkNotNullParameter(r9, "previousPage");
            Intrinsics.checkNotNullParameter(r11, "isCallBot");
            Intrinsics.checkNotNullParameter(r13, "openMethod");
            Intrinsics.checkNotNullParameter(r15, "openVlm");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = "chat";
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r15;
        }
    }

    public static final class c implements p0 {
        public final /* synthetic */ RealtimeCallGateActivity a;
        public final /* synthetic */ BotModel b;
        public final /* synthetic */ String c;

        public final void confirm() {
            com.bytedance.router.i r0 = SmartRouter.buildRoute(this.a, "//flow/single_tts_speaker_setting");
            Pair[] r1 = new Pair[5];
            r1[0] = TuplesKt.to("select_speaker_argument", this.b);
            r1[1] = TuplesKt.to("enter_from", "chat_realtime_call");
            String r3 = this.b.getName();
            if (r3 != null) goto L5;
            String r5 = NameKeys.UnloadStrategy_No_Strategy;
        L6:
            String r4 = this.b.getDescriptionForHuman();
            if (r4 != null) goto L9;
            String r6 = NameKeys.UnloadStrategy_No_Strategy;
        L10:
            SpeakerVoice r7 = this.b.getVoiceType();
            if (r7 == null) goto L16;
            String r8 = r7.getId();
            if (r8 == null) goto L16;
            String r9 = r8;
        L17:
            String r10 = this.b.getBotId();
            if (r10 != null) goto L20;
            String r11 = NameKeys.UnloadStrategy_No_Strategy;
        L21:
            ModelItem r12 = this.b.getModel();
            if (r12 == null) goto L24;
            long r13 = r12.getModelType();
        L25:
            SpeakerVoice r14 = this.b.getVoiceType();
            if (r14 == null) goto L31;
            String r15 = r14.getLanguageCode();
            if (r15 == null) goto L31;
            String r16 = r15;
        L32:
            r1[2] = TuplesKt.to("key_voice_recommend_param", new GetMatchVoiceRequest(r5, r6, r9, r11, r13, r16, null, 64));
            r1[3] = TuplesKt.to("conversation_id", this.c);
            r1[4] = TuplesKt.to("key_enter_method", "tts_disabled");
            Bundle r2 = BundleKt.bundleOf(r1);
            r0.c.putExtras(r2);
            r0.d = 2130772401;
            r0.e = 2130772399;
            r0.e(100);
            return;
        L31:
            r16 = NameKeys.UnloadStrategy_No_Strategy;
            goto L32
        L24:
            r13 = 0;
            goto L25
        L20:
            r11 = r10;
        L16:
            r9 = NameKeys.UnloadStrategy_No_Strategy;
            goto L17
        L9:
            r6 = r4;
            goto L10
        L5:
            r5 = r3;
            goto L6
        }

        public c(RealtimeCallGateActivity r1, BotModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.ui.RealtimeCallGateActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallGateActivity$onCreate$1", f = "RealtimeCallGateActivity.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RealtimeCallGateActivity this$0;

        public AnonymousClass1(RealtimeCallGateActivity r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r10v3, types: [android.app.Activity, com.larus.voicecall.impl.ui.RealtimeCallGateActivity] */
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L53:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            Intent r4 = this.this$0.getIntent();
            if (r4 == null) goto L15;
            Bundle r5 = r4.getExtras();
            if (r5 == null) goto L15;
            RealtimeCallGateActivity r6 = this.this$0;
            this.L$0 = r11;
            this.label = 1;
            if (RealtimeCallGateActivity.y1(r6, r5, this) != r0) goto L53;
            return r0;
        L15:
            ?? r12 = this.this$0;
            Intent r7 = r12.getIntent();
            if (r7 == null) goto L22;
            Bundle r8 = r7.getExtras();
            if (r8 == null) goto L22;
            if (r8.getInt("slardar_router_event_mob_start", 0) != 1) goto L22;
        L23:
            String r9 = null;
            if (r2 == false) goto L48;
            int r13 = RealtimeMobUtil.a;
            Intent r14 = r12.getIntent();
            if (r14 == null) goto L28;
            String r15 = r14.getStringExtra("origin_url");
        L29:
            Intent r16 = r12.getIntent();
            if (r16 == null) goto L34;
            Bundle r17 = r16.getExtras();
            if (r17 == null) goto L34;
            String r18 = r17.getString("enter_method");
        L35:
            Intent r19 = r12.getIntent();
            if (r19 == null) goto L40;
            Bundle r20 = r19.getExtras();
            if (r20 == null) goto L40;
            String r21 = r20.getString("bot_id");
        L41:
            Intent r22 = r12.getIntent();
            if (r22 == null) goto L46;
            Bundle r23 = r22.getExtras();
            if (r23 == null) goto L46;
            String r24 = r23.getString("track_params");
        L47:
            RealtimeMobUtil.a(r15, r18, r21, r24, false, "build_params_invalid");
        L46:
            r24 = null;
        L40:
            r21 = null;
        L34:
            r18 = null;
            goto L35
        L28:
            r15 = null;
        L48:
            FLogger r25 = FLogger.a;
            StringBuilder r26 = new StringBuilder("[onCreate] intent?.extras is null, origin_url=");
            Intent r27 = r12.getIntent();
            if (r27 == null) goto L51;
            r9 = r27.getStringExtra("origin_url");
        L51:
            r26.append(r9);
            r25.e("RealtimeCallGateActivity", r26.toString());
            r12.finish();
        L22:
            r2 = false;
            goto L23
        }
    }

    static {
    }

    public final void fillTrackParams(TrackParams r1) {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(RealtimeCallGateActivity.class.getName()));
    L5:
        super.onDestroy();
        FLogger.a.i("RealtimeCallGateActivity", "[onDestroy]");
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(RealtimeCallGateActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public RealtimeCallGateActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1(b r8) {
        s.a.g(AppHost.a.getApplication().getApplicationContext(), 2131898479, false);
        BotModel r0 = r8.c;
        String r1 = r8.b.a;
        String r9 = r8.e;
        String r4 = r0.getBotId();
        SpeakerVoice r5 = r0.getVoiceType();
        if (r5 == null) goto L5;
        String r6 = r5.getStyleId();
    L6:
        RealtimeCallHelperKt.g(r4, r1, r9, r6);
        CommonDialog.a r10 = new CommonDialog.a();
        r10.g(getString(2131898479));
        CommonDialog.a.f(r10, new c(this, r0, r1), getString(2131898465), false, 12);
        CommonDialog r11 = r10.b(ContextCompat.getColor(this, v19.c.b(2130972123, this, 2131103203)));
        FragmentManager r2 = getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, null, r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r11, r3) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r11.show(r2, null);
        return;
    L15:
        return;
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1(b r14) {
        Intent r0 = getIntent();
        if (r0 == null) goto L9;
        Bundle r1 = r0.getExtras();
        if (r1 == null) goto L9;
        if (r1.getInt("slardar_router_event_mob_start", 0) != 1) goto L9;
        boolean r2 = true;
    L10:
        String r5 = null;
        if (r2 == false) goto L25;
        int r3 = RealtimeMobUtil.a;
        String r7 = getIntent().getStringExtra("origin_url");
        Bundle r4 = getIntent().getExtras();
        if (r4 == null) goto L15;
        String r8 = r4.getString("enter_method");
    L16:
        Bundle r6 = getIntent().getExtras();
        if (r6 == null) goto L19;
        String r9 = r6.getString("bot_id");
    L20:
        Bundle r10 = getIntent().getExtras();
        if (r10 == null) goto L23;
        String r11 = r10.getString("track_params");
    L24:
        RealtimeMobUtil.a(r7, r8, r9, r11, true, null);
        goto L25
    L23:
        r11 = null;
        goto L24
    L19:
        r9 = null;
        goto L20
    L15:
        r8 = null;
    L25:
        com.bytedance.router.i r12 = SmartRouter.buildRoute(this, "//flow/realtime_chat");
        Bundle r13 = r14.a;
        Pair[] r15 = new Pair[24];
        r15[0] = TuplesKt.to("conversation_id", r14.b.a);
        r15[1] = TuplesKt.to("conversation_project_id", r14.b.I);
        r15[2] = TuplesKt.to("conv_last_section_id", r14.b.B);
        r15[3] = TuplesKt.to("conv_last_message_index", r14.b.q);
        r15[4] = TuplesKt.to("is_new_conversation", Boolean.FALSE);
        SpeakerVoice r16 = r14.c.getVoiceType();
        if (r16 == null) goto L28;
        String r17 = RealtimeCallHelperKt.a(r16);
    L29:
        r15[5] = TuplesKt.to("style_name", r17);
        SpeakerVoice r18 = r14.c.getVoiceType();
        if (r18 == null) goto L32;
        String r19 = r18.getName();
    L33:
        r15[6] = TuplesKt.to("speaker_name", r19);
        SpeakerVoice r20 = r14.c.getVoiceType();
        if (r20 == null) goto L36;
        String r21 = r20.getId();
    L37:
        r15[7] = TuplesKt.to("voice_id", r21);
        r15[8] = TuplesKt.to("bot_id", r14.c.getBotId());
        r15[9] = TuplesKt.to("bot_type", r14.c.getBotType());
        r15[10] = TuplesKt.to("bot_name", r14.c.getName());
        BotIconImage r22 = r14.c.getIconImage();
        if (r22 == null) goto L40;
        String r23 = r22.getImg720();
    L42:
        if (o0.d(r23) == true) goto L45;
        r23 = null;
    L45:
        if (r23 != null) goto L50;
        BotIconImage r24 = r14.c.getIconImage();
        if (r24 == null) goto L49;
        r23 = r24.getOriginUrl();
        goto L50
    L49:
        r23 = null;
    L50:
        r15[11] = TuplesKt.to("bot_avatar", r23);
        ModelItem r25 = r14.c.getModel();
        if (r25 == null) goto L53;
        String r26 = r25.getModelName();
    L54:
        r15[12] = TuplesKt.to("bot_llm_model", r26);
        r15[13] = TuplesKt.to("previous_page", r14.h);
        r15[14] = TuplesKt.to("enter_from", r14.d);
        r15[15] = TuplesKt.to("current_page", r14.g);
        r15[16] = TuplesKt.to("chat_type", ic8.n.f(r14.b));
        r15[17] = TuplesKt.to("scene_model_list", r14.c.getSceneModelList());
        SpeakerVoice r27 = r14.c.getVoiceType();
        if (r27 == null) goto L57;
        r5 = r27.getExtra();
    L57:
        r15[18] = TuplesKt.to("tts_extra", r5);
        r15[19] = TuplesKt.to("enter_method", r14.e);
        r15[20] = TuplesKt.to("target_scene", Integer.valueOf(r14.i));
        r15[21] = TuplesKt.to("pass_gate", "1");
        r15[22] = TuplesKt.to("from_check_gate", 1);
        r15[23] = TuplesKt.to("bot_model", r14.c);
        r13.putAll(BundleKt.bundleOf(r15));
        r12.c.putExtras(r13);
        r12.e(100);
        return;
    L53:
        r26 = null;
        goto L54
    L40:
        r23 = null;
        goto L42
    L36:
        r21 = null;
        goto L37
    L32:
        r19 = null;
        goto L33
    L28:
        r17 = null;
    L9:
        r2 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r7);
        FLogger.a.i("RealtimeCallGateActivity", "[onCreate]");
        com.larus.utils.i0.a.getClass();
        com.larus.utils.i0.d(true);
        com.larus.utils.i0.i(new WeakReference(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final Object A1(String r81, Continuation<? super String> r82) {
        if ((r82 instanceof RealtimeCallGateActivity$findOrCreateLocalConversationByBot$1) == false) goto L7;
        RealtimeCallGateActivity$findOrCreateLocalConversationByBot$1 r1 = (RealtimeCallGateActivity$findOrCreateLocalConversationByBot$1) r82;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L37:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
    L19:
        BotModel r12 = (BotModel) r0;
        r0 = null;
        if (r12 == null) goto L24;
        FirstMet r4 = r12.getFirstMet();
        if (r4 == null) goto L24;
        String r14 = r4.getPrologue();
    L25:
        if (r12 == null) goto L29;
        FirstMet r5 = r12.getFirstMet();
        if (r5 == null) goto L29;
        List r15 = r5.getSuggests();
    L30:
        BotOnBoarding r52 = new BotOnBoarding(r14, r15, null, 2, null, 20, null);
        if (r12 == null) goto L37;
        BotModel r6 = BotModel.copy$default(r12, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, r52, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2147483583, null);
        if (r6 == null) goto L37;
        IConversationRepoService r7 = RepoDispatcherDelegate.b.f();
        r1.label = 2;
        r0 = IConversationRepoService.a.b(r7, r6, null, r1, 6);
        if (r0 != r10) goto L37;
        return r10;
    L29:
        r15 = null;
    L24:
        r14 = null;
        goto L25
    L16:
        ResultKt.throwOnFailure(r0);
        IBotRepoService r8 = RepoDispatcherDelegate.b.b();
        r1.label = 1;
        r0 = IBotRepoService.b.a(r8, r81, false, null, false, r1, 30);
        if (r0 != r10) goto L19;
        return r10;
    L7:
        r1 = new RealtimeCallGateActivity$findOrCreateLocalConversationByBot$1(this, r82);
        goto L8
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x00ba: MOVE (r7 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]) (LINE:33554618), block:B:36:0x00ba */
    public final Object F1(Bundle r20, Continuation<? super b> r21) {
        Bundle r0 = r20;
        if ((r21 instanceof RealtimeCallGateActivity$tryBuildRealTimeCallParamsByBotId$1) == false) goto L7;
        RealtimeCallGateActivity$tryBuildRealTimeCallParamsByBotId$1 r3 = (RealtimeCallGateActivity$tryBuildRealTimeCallParamsByBotId$1) r21;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        boolean r6 = true;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
        if (r5 == 0) goto L42;
        if (r5 == 1) goto L37;
        if (r5 == 2) goto L32;
        if (r5 == 3) goto L27;
        if (r5 == 4) goto L22;
        if (r5 != 5) goto L21;
        String r1 = (String) r3.L$4;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r3.L$3;
        RealtimeCallGateActivity r9 = (RealtimeCallGateActivity) r3.L$2;
        String r11 = (String) r3.L$1;
        Bundle r12 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L18
    L121:
        BotModel r13 = (BotModel) r2;     // Catch: Throwable -> L18
        if (r13 != null) goto L125;
        r9.getClass();     // Catch: Throwable -> L18
        FLogger.a.e("RealtimeCallGateActivity", "botModel is invalid, cvsId=" + r1);     // Catch: Throwable -> L18
        r9.finish();     // Catch: Throwable -> L18
        return null;
    L125:
        wc9.e r14 = (wc9.e) r8.element;     // Catch: Throwable -> L18
        r9.getClass();     // Catch: Throwable -> L18
        return B1(r12, r13, r14);
    L18:
        th = th;
        String r15 = r11;
    L130:
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
        String r18 = r15;
    L131:
        Throwable r19 = Result.exceptionOrNull-impl(r17);
        if (r19 == null) goto L135;
        FLogger.a.i("RealtimeCallGateActivity", "tryBuildRealTimeCallParamsByBotId error, botId:" + r18 + ", it:" + r19);
    L135:
        return null;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        Ref.ObjectRef r22 = (Ref.ObjectRef) r3.L$5;
        String r23 = (String) r3.L$4;
        Ref.ObjectRef r24 = (Ref.ObjectRef) r3.L$3;
        RealtimeCallGateActivity r25 = (RealtimeCallGateActivity) r3.L$2;
        r15 = (String) r3.L$1;
        Bundle r26 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L25
    L111:
        wc9.e r27 = (wc9.e) r2;     // Catch: Throwable -> L25
        if (r27 != null) goto L115;
        r25.getClass();     // Catch: Throwable -> L25
        FLogger.a.e("RealtimeCallGateActivity", "localCvsId conversation is invalid, cvsId=" + r23);     // Catch: Throwable -> L25
        r25.finish();     // Catch: Throwable -> L25
        return null;
    L115:
        String r110 = r23;
        wc9.e r28 = r27;
        String r29 = r110;
    L117:
        r22.element = r28;     // Catch: Throwable -> L25
        IBotRepoService r30 = RepoDispatcherDelegate.b.b();     // Catch: Throwable -> L25
        r3.L$0 = r26;     // Catch: Throwable -> L25
        r3.L$1 = r15;     // Catch: Throwable -> L25
        r3.L$2 = r25;     // Catch: Throwable -> L25
        r3.L$3 = r24;     // Catch: Throwable -> L25
        r3.L$4 = r29;     // Catch: Throwable -> L25
        r3.L$5 = null;     // Catch: Throwable -> L25
        r3.label = 5;     // Catch: Throwable -> L25
        Object r31 = r30.j1(r29, false, r3);     // Catch: Throwable -> L25
        if (r31 != r10) goto L120;
        return r10;
    L120:
        r8 = r24;
        r9 = r25;
        r12 = r26;
        String r111 = r29;
        r2 = r31;
        r1 = r111;
    L25:
        th = th;
        goto L130
    L27:
        r22 = (Ref.ObjectRef) r3.L$3;
        RealtimeCallGateActivity r32 = (RealtimeCallGateActivity) r3.L$2;
        String r33 = (String) r3.L$1;
        Bundle r34 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L30
    L101:
        r29 = (String) r2;     // Catch: Throwable -> L30
        RealtimeCallGateActivity r112 = r32;
        r18 = r33;
        Bundle r35 = r34;
    L104:
        if (r29 == null) goto L128;
        r28 = (wc9.e) r22.element;     // Catch: Throwable -> L35
        if (r28 != null) goto L116;
        IConversationRepoService r36 = RepoDispatcherDelegate.b.f();     // Catch: Throwable -> L35
        r3.L$0 = r35;     // Catch: Throwable -> L35
        r3.L$1 = r18;     // Catch: Throwable -> L35
        r3.L$2 = r112;     // Catch: Throwable -> L35
        r3.L$3 = r22;     // Catch: Throwable -> L35
        r3.L$4 = r29;     // Catch: Throwable -> L35
        r3.L$5 = r22;     // Catch: Throwable -> L35
        r3.label = 4;     // Catch: Throwable -> L35
        Bundle r113 = r35;
        Object r37 = IConversationRepoService.a.c(r36, r29, false, null, r3, 6);     // Catch: Throwable -> L35
        if (r37 != r10) goto L110;
        return r10;
    L110:
        r24 = r22;
        r25 = r112;
        r15 = r18;
        r26 = r113;
        r23 = r29;
        r2 = r37;
        goto L111
    L116:
        r24 = r22;
        r25 = r112;
        r15 = r18;
        r26 = r35;
        goto L117
    L128:
        r17 = Result.constructor-impl(null);     // Catch: Throwable -> L35
    L30:
        th = th;
        r15 = r33;
        goto L130
    L32:
        Ref.ObjectRef r38 = (Ref.ObjectRef) r3.L$4;
        Ref.ObjectRef r39 = (Ref.ObjectRef) r3.L$3;
        RealtimeCallGateActivity r40 = (RealtimeCallGateActivity) r3.L$2;
        String r114 = (String) r3.L$1;
        Bundle r115 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L35
        Ref.ObjectRef r41 = r38;
        r0 = r115;
        RealtimeCallGateActivity r116 = r40;
        Ref.ObjectRef r42 = r39;
    L73:
        Iterator r43 = ((Iterable) r2).iterator();     // Catch: Throwable -> L35
    L75:
        if (r43.hasNext() == false) goto L83;
        Object r117 = r43.next();     // Catch: Throwable -> L35
        if ((!ic8.n.r((wc9.e) r117)) == false) goto L75;
        wc9.e r44 = (wc9.e) r117;     // Catch: Throwable -> L35
        String r118 = r114;
        Bundle r119 = r0;
        Ref.ObjectRef r45 = r41;
        r41 = r42;
        RealtimeCallGateActivity r46 = r116;
        String r120 = r118;
    L80:
        r45.element = r44;     // Catch: Throwable -> L40
        r22 = r41;
        r32 = r46;
    L85:
        wc9.e r47 = (wc9.e) r22.element;     // Catch: Throwable -> L40
        if (r47 == null) goto L88;
        String r48 = r47.a;     // Catch: Throwable -> L40
    L89:
        if (r48 == null) goto L93;
        r7 = r48;
    L93:
        if (r7.length() == 0) goto L96;
        r6 = false;
    L96:
        if (r6 == false) goto L103;
        r3.L$0 = r119;     // Catch: Throwable -> L40
        r3.L$1 = r120;     // Catch: Throwable -> L40
        r3.L$2 = r32;     // Catch: Throwable -> L40
        r3.L$3 = r22;     // Catch: Throwable -> L40
        r3.L$4 = null;     // Catch: Throwable -> L40
        r3.label = 3;     // Catch: Throwable -> L40
        r2 = r32.A1(r120, r3);     // Catch: Throwable -> L40
        if (r2 != r10) goto L100;
        return r10;
    L100:
        r33 = r120;
        r34 = r119;
    L40:
        th = th;
        r15 = r120;
        goto L130
    L103:
        r29 = r7;
        r35 = r119;
        r18 = r120;
        r112 = r32;
        goto L104
    L88:
        r48 = null;
        goto L89
    L83:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");     // Catch: Throwable -> L35
    L37:
        r45 = (Ref.ObjectRef) r3.L$4;
        r41 = (Ref.ObjectRef) r3.L$3;
        r46 = (RealtimeCallGateActivity) r3.L$2;
        r120 = (String) r3.L$1;
        r119 = (Bundle) r3.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L40
    L60:
        Iterator r49 = ((Iterable) r2).iterator();     // Catch: Throwable -> L40
    L62:
        if (r49.hasNext() == false) goto L66;
        Object r121 = r49.next();     // Catch: Throwable -> L40
        if ((!ic8.n.r((wc9.e) r121)) == false) goto L62;
    L68:
        r44 = (wc9.e) r121;     // Catch: Throwable -> L40
        goto L80
    L66:
        r121 = null;
        goto L68
    L42:
        ResultKt.throwOnFailure(r2);
        String r50 = r0.getString("bot_id");
        if (r50 == null) goto L45;
    L44:
        r114 = r50;
    L49:
        if (r114 != null) goto L52;
        FLogger.a.e("RealtimeCallGateActivity", "bot id is null");
        finish();
        return null;
    L52:
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L35
        String r52 = r0.getString("remote_conversation_first", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L35
        r41 = new Ref.ObjectRef();     // Catch: Throwable -> L35
        if (Intrinsics.areEqual(r52, "true") == true) goto L55;
        r120 = r114;
        r119 = r0;
        r22 = r41;
        r32 = this;
        goto L85
    L55:
        if (z2.a.i1() == false) goto L69;
        IConversationRepoService r53 = RepoDispatcherDelegate.b.f();     // Catch: Throwable -> L35
        r3.L$0 = r0;     // Catch: Throwable -> L35
        r3.L$1 = r114;     // Catch: Throwable -> L35
        r3.L$2 = this;     // Catch: Throwable -> L35
        r3.L$3 = r41;     // Catch: Throwable -> L35
        r3.L$4 = r41;     // Catch: Throwable -> L35
        r3.label = 1;     // Catch: Throwable -> L35
        r2 = r53.d(r114, r3);     // Catch: Throwable -> L35
        if (r2 != r10) goto L59;
        return r10;
    L59:
        r46 = this;
        r120 = r114;
        r119 = r0;
        r45 = r41;
        goto L60
    L69:
        IConversationRepoService r54 = RepoDispatcherDelegate.b.f();     // Catch: Throwable -> L35
        r3.L$0 = r0;     // Catch: Throwable -> L35
        r3.L$1 = r114;     // Catch: Throwable -> L35
        r3.L$2 = this;     // Catch: Throwable -> L35
        r3.L$3 = r41;     // Catch: Throwable -> L35
        r3.L$4 = r41;     // Catch: Throwable -> L35
        r3.label = 2;     // Catch: Throwable -> L35
        r2 = r54.d(r114, r3);     // Catch: Throwable -> L35
        if (r2 != r10) goto L72;
        return r10;
    L72:
        r116 = this;
        r42 = r41;
        goto L73
    L45:
        r50 = r0.getString("argBotId");
        if (r50 == null) goto L48;
        r0.putString("conversation_id", r50);
        goto L44
    L48:
        r114 = null;
    L35:
        th = th;
        r15 = r15;
    L7:
        r3 = new RealtimeCallGateActivity$tryBuildRealTimeCallParamsByBotId$1(this, r21);
        goto L8
    }

    public final Object z1(Bundle r14, Continuation<? super b> r15) {
        if ((r15 instanceof RealtimeCallGateActivity$buildLaunchRealtimeCallParams$1) == false) goto L7;
        RealtimeCallGateActivity$buildLaunchRealtimeCallParams$1 r0 = (RealtimeCallGateActivity$buildLaunchRealtimeCallParams$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ResultKt.throwOnFailure(r16);
    L51:
        return r16;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        wc9.e r17 = (wc9.e) r0.L$2;
        String r3 = (String) r0.L$1;
        Bundle r4 = (Bundle) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L42:
        BotModel r18 = (BotModel) r16;
        if (r18 != null) goto L47;
        FLogger.a.e("RealtimeCallGateActivity", "botModel is invalid, cvsId=" + r3);
        finish();
        return null;
    L47:
        return B1(r4, r18, r17);
    L18:
        ResultKt.throwOnFailure(r16);
    L37:
        return r16;
    L19:
        String r19 = (String) r0.L$1;
        Bundle r5 = (Bundle) r0.L$0;
        ResultKt.throwOnFailure(r16);
        r3 = r19;
        r14 = r5;
    L32:
        wc9.e r110 = (wc9.e) r16;
        if (r110 != null) goto L38;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r16 = F1(r14, r0);
        if (r16 != r7) goto L37;
        return r7;
    L38:
        IBotRepoService r6 = RepoDispatcherDelegate.b.b();
        r0.L$0 = r14;
        r0.L$1 = r3;
        r0.L$2 = r110;
        r0.label = 3;
        Object r8 = r6.j1(r3, true, r0);
        if (r8 != r7) goto L41;
        return r7;
    L41:
        r4 = r14;
        r17 = r110;
        r16 = r8;
        goto L42
    L20:
        ResultKt.throwOnFailure(r16);
        String r9 = r14.getString("conversation_id");
        if (r9 == null) goto L23;
    L22:
        String r111 = r9;
    L27:
        if (r111 == null) goto L48;
        IConversationRepoService r10 = RepoDispatcherDelegate.b.f();
        r0.L$0 = r14;
        r0.L$1 = r111;
        r0.label = 1;
        Object r11 = IConversationRepoService.a.c(r10, r111, false, null, r0, 6);
        if (r11 != r7) goto L31;
        return r7;
    L31:
        r3 = r111;
        r16 = r11;
        goto L32
    L48:
        r0.label = 4;
        r16 = F1(r14, r0);
        if (r16 != r7) goto L51;
        return r7;
    L23:
        r9 = r14.getString("argConversationId");
        if (r9 == null) goto L26;
        r14.putString("conversation_id", r9);
        goto L22
    L26:
        r111 = null;
    L7:
        r0 = new RealtimeCallGateActivity$buildLaunchRealtimeCallParams$1(this, r15);
        goto L8
    }

    public static b B1(Bundle r18, BotModel r19, wc9.e r20) {
        RecommendFrom r3 = r18.getParcelable("recommend_from");
        if (r3 != null) goto L10;
        r3 = (RecommendFrom) r18.getParcelable("argBotRecommendFrom");
        if (r3 == null) goto L8;
        r18.putParcelable("recommend_from", r3);
        goto L10
    L8:
        r3 = null;
    L10:
        if (r3 != null) goto L12;
        FLogger.a.e("RealtimeCallGateActivity", "recommendFrom is null");
        Unit r0 = Unit.INSTANCE;
    L12:
        String r7 = r18.getString("enter_from", NameKeys.UnloadStrategy_No_Strategy);
        String r8 = r18.getString("enter_method", NameKeys.UnloadStrategy_No_Strategy);
        IAudioService r1 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L29;
        IAudioService r4 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r4 != null) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == true) goto L29;
        if (AccountService.a.isLogin().booleanValue() == false) goto L29;
        boolean r11 = true;
    L30:
        String r12 = r18.getString("previous_page");
        if (r12 != null) goto L37;
        String r13 = r18.getString("argPreviousPage");
        if (r13 == null) goto L36;
        r18.putString("previous_page", "argPreviousPage");
        r12 = r13;
        goto L37
    L36:
        r12 = null;
    L37:
        if (r12 != null) goto L39;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L39:
        boolean r14 = !Intrinsics.areEqual(r18.getString("without_chat", NameKeys.UnloadStrategy_No_Strategy), "1");
        String r15 = r18.getString("open_method", NameKeys.UnloadStrategy_No_Strategy);
        SearchMobParam r6 = r18.getParcelable("argSearchMobParam");
        String r9 = r18.getString("lib_track_rtn_id", null);
        ConcurrentHashMap r10 = ey7.d.a;
        if (r9 == null) goto L42;
        FrozenTrackNode r16 = (FrozenTrackNode) r10.get(r9);
    L43:
        if (r16 == null) goto L109;
        TrackParams r17 = r16.getTrackParams();
        if (r17 == null) goto L109;
        if (r6 == null) goto L48;
        String r21 = r6.a;
    L49:
        r17.putIfNull("query", r21);
        if (r6 == null) goto L52;
        String r22 = r6.b;
    L53:
        r17.putIfNull("query_id", r22);
        if (r6 == null) goto L56;
        String r23 = r6.c;
    L57:
        r17.putIfNull("search_id", r23);
        if (r6 == null) goto L60;
        String r24 = r6.d;
    L61:
        r17.putIfNull("search_request_id", r24);
        if (r6 == null) goto L64;
        String r25 = r6.e;
    L65:
        r17.putIfNull("search_result_id", r25);
        if (r6 == null) goto L68;
        String r26 = r6.f;
    L69:
        r17.putIfNull("rank", r26);
        goto L109
    L68:
        r26 = null;
        goto L69
    L64:
        r25 = null;
        goto L65
    L60:
        r24 = null;
        goto L61
    L56:
        r23 = null;
        goto L57
    L52:
        r22 = null;
        goto L53
    L48:
        r21 = null;
    L109:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L78
        String r28 = r18.getString("target_scene");     // Catch: Throwable -> L78
        if (r28 == null) goto L75;
        String r29 = StringsKt.trimEnd(r28).toString();     // Catch: Throwable -> L78
        if (r29 == null) goto L75;
        Integer r30 = Integer.valueOf(CastIntegerProtector.parseInt(r29));     // Catch: Throwable -> L78
    L76:
        Object r31 = Result.constructor-impl(r30);     // Catch: Throwable -> L78
    L80:
        Throwable r32 = Result.exceptionOrNull-impl(r31);
        if (r32 == null) goto L85;
        FLogger.a.e("RealtimeCallGateActivity", "[buildLaunchRealtimeCallParams] bundle value:" + r18.getString("target_scene") + ", it:" + r32);
    L85:
        if (Result.isFailure-impl(r31) == false) goto L87;
        Object r33 = null;
    L88:
        Integer r34 = (Integer) r33;
        if (r34 == null) goto L91;
        int r35 = r34.intValue();
    L92:
        IAudioService r36 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r36 != null) goto L95;
    L97:
        boolean r110 = false;
    L98:
        if (r110 == false) goto L100;
        String r111 = "1";
    L101:
        boolean r37 = r18.getBoolean("need_start_continue_talk", false);
        if (r37 == true) goto L107;
        String r38 = r20.a;
        String r39 = r19.getBotId();
        if (r39 != null) goto L106;
        r39 = NameKeys.UnloadStrategy_No_Strategy;
    L106:
        r37 = com.larus.voicecall.impl.utils.f.b(r38, r39, r19);
    L107:
        boolean r112 = r37;
        String r40 = r18.getString("open_vlm", NameKeys.UnloadStrategy_No_Strategy);
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNull(r40);
        return new b(r18, r20, r19, r7, r8, r11, r12, r35, r111, r14, r15, r112, r40);
    L100:
        r111 = "0";
        goto L101
    L95:
        if (r36.n(r19) != true) goto L97;
        r110 = true;
        goto L98
    L91:
        r35 = -1;
        goto L92
    L87:
        r33 = r31;
    L75:
        r30 = null;
    L78:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L42:
        r16 = null;
        goto L43
    L22:
        if (r4.u() != true) goto L24;
        r5 = true;
    L29:
        r11 = false;
        goto L30
    L15:
        if (r1.m() != true) goto L17;
        r2 = true;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object y1(final RealtimeCallGateActivity r82, Bundle r83, Continuation r84) {
        r82.getClass();
        if ((r84 instanceof RealtimeCallGateActivity$launchRealTimeCall$1) == false) goto L7;
        RealtimeCallGateActivity$launchRealTimeCall$1 r1 = (RealtimeCallGateActivity$launchRealTimeCall$1) r84;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        final b r13 = (b) r0;
        if (r13 == null) goto L247;
        FLogger.a.i("RealtimeCallGateActivity", "[launchRealTimeCall] params=" + r13);
        String r5 = r13.a.getString("track_params");
        if (r5 == null) goto L22;
        JSONObject r10 = new JSONObject(r5);
    L23:
        String r6 = r13.c.getBotId();
        String r7 = r13.b.a;
        String r8 = r13.g;
        String r9 = r13.d;
        String r11 = r13.e;
        int r12 = c4a.g.a;
        if (c4a.g.a(r13.c) == false) goto L26;
        String r14 = "1";
    L28:
        if (r13.f == false) goto L30;
        String r15 = "1";
    L31:
        String r16 = ic8.n.f(r13.b);
        e6 r17 = e6.a;
        tx9.c0.e(r6, r7, r8, r9, r11, r16, r15, r14, null, r17.c(), r17.b(), r10, r82, 30472);
        String r18 = null;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L38
        IAudioEventCommonParams r20 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);     // Catch: Throwable -> L38
        if (r20 == null) goto L35;
        r20.b(AppHost.a.getApplication());     // Catch: Throwable -> L38
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L36:
        Result.constructor-impl(r21);     // Catch: Throwable -> L38
    L248:
        IAudioDeviceMonitorReporter r22 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);     // Catch: Throwable -> L46
        if (r22 == null) goto L43;
        r22.a(AudioDeviceMonitorScenes.ENTER_CALL);     // Catch: Throwable -> L46
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        Result.constructor-impl(r23);     // Catch: Throwable -> L46
    L48:
        SpeakerVoice r24 = r13.c.getVoiceType();
        if (r24 == null) goto L51;
        String r25 = r24.getStyleId();
    L53:
        if (r25 != null) goto L55;
    L58:
        boolean r26 = true;
    L59:
        if (r26 == false) goto L61;
    L250:
        r82.C1(r13);     // Catch: Throwable -> L242
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L242
    L244:
        Result.box-impl(r27);
    L245:
        r82.finish();
    L242:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L244
    L61:
        if (r13.c.getMuted() == true) goto L250;
        if (r13.k == false) goto L235;
        z1.a.c(r82);
        Bundle r29 = r13.a;
        r29.putAll(BundleKt.bundleOf(new Pair[]{TuplesKt.to("landing_channel", ChatLandingChannel.CHAT_LIST.getChannel()), TuplesKt.to("argPreviousPage", r13.h), TuplesKt.to("argConversationId", r13.b.a), TuplesKt.to("argBotId", r13.c.getBotId()), TuplesKt.to("argBotType", r13.c.getBotType()), TuplesKt.to("argCvsBgImgUrl", r13.c.getBgImgUrl()), TuplesKt.to("argCvsBgImgColor", r13.c.getBgImgColor()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r13.c.getBgImgOpen())), TuplesKt.to("enter_method", r13.e), TuplesKt.to("enter_from", r13.d), TuplesKt.to("navigate_up_from", "chat_list"), TuplesKt.to("open_method", r13.l), TuplesKt.to("need_start_continue_talk", Boolean.valueOf(r13.m)), TuplesKt.to("open_vlm", r13.n), TuplesKt.to("is_call_bot", r13.j)}));
        RealtimeCallUtil r30 = RealtimeCallUtil.a;
        wc9.e r31 = r13.b;
        String r32 = r31.a;
        Integer r33 = r31.v;
        r30.getClass();
        boolean r34 = RealtimeCallUtil.v(r32, r33);
        FLogger r110 = FLogger.a;
        r110.i("RealtimeCallGateActivity", "[openBotChatPage] isMainBot=" + r34);
        if (r34 == false) goto L85;
        MainBotServiceDelegate r35 = MainBotServiceDelegate.b;
        ConversationPage r36 = r13.b.g;
        if (r36 == null) goto L72;
        Integer r37 = r36.getDefaultStatus();
        if (r37 == null) goto L72;
        int r38 = r37.intValue();
    L73:
        int r39 = r38;
        ConversationPage r40 = r13.b.g;
        if (r40 == null) goto L77;
        List r41 = r40.getPageList();
        if (r41 == null) goto L77;
    L78:
        List r42 = r41;
        ConversationPage r43 = r13.b.g;
        if (r43 == null) goto L83;
        Integer r44 = r43.getPagePosition();
        if (r44 == null) goto L83;
        int r45 = r44.intValue();
    L84:
        r35.c(r82, new IMainBotService.a(r29, r39, r42, r45, 2130772401, 2130772399, null, 64));
    L86:
        Bundle r46 = r13.a;
        RecommendFrom r47 = r46.getParcelable("recommend_from");
        if (r47 != null) goto L93;
        r47 = (RecommendFrom) r46.getParcelable("argBotRecommendFrom");
        if (r47 == null) goto L92;
        r46.putParcelable("recommend_from", r47);
        goto L93
    L92:
        r47 = null;
    L93:
        BotRecommendMobInfo r48 = r13.a.getParcelable("recommend_bot_mob_segment");
        JSONObject r49 = new JSONObject();
        if (r47 == null) goto L98;
        String r50 = r47.a;
        if (r50 == null) goto L98;
        r49.put("recommend_from", r50);
    L98:
        if (r47 == null) goto L103;
        String r51 = r47.b;
        if (r51 == null) goto L103;
        r49.put("req_id", r51);
    L103:
        if (ic8.n.d(r13.b) == false) goto L105;
        String r52 = "temporary";
    L106:
        r49.put("current_page_status", r52);
        if (r48 == null) goto L109;
        r48.a(r49);
    L109:
        boolean r53 = r13.a.getBoolean("is_from_ug", false);
        z2 r54 = z2.a;
        if (r54.chatImmerseEnable() == true) goto L112;
    L118:
        boolean r55 = false;
    L120:
        if (r54.chatImmerseEnable() == true) goto L122;
    L124:
        boolean r56 = false;
    L125:
        wc9.e r57 = r13.b;
        String r58 = r57.a;
        if (r47 == null) goto L128;
        String r410 = r47.b;
    L129:
        if (r47 == null) goto L131;
        String r411 = r47.a;
    L132:
        String r310 = ic8.n.f(r57);
        String r210 = r13.c.getBotId();
        String r211 = r13.a.getString("argBotPosition");
        String r59 = r13.e;
        String r60 = r13.d;
        if (r13.b.i == false) goto L135;
        long r61 = 1;
    L136:
        if (r53 == false) goto L138;
        String r311 = "1";
    L139:
        if (r55 == false) goto L141;
        String r312 = "1";
    L142:
        String r313 = ve8.c.b(r56);
        String r62 = r13.g;
        String r63 = r13.h;
        String r314 = r13.a.getString("argCurrentTab");
        String r412 = r13.a.getString("from_activity_name");
        String r413 = r13.a.getString("from_activity_module");
        String r510 = r13.c.getBotId();
        String r64 = r13.j;
        String r111 = r13.l;
        String r112 = r13.a.getString("lib_track_rtn_id", null);
        ConcurrentHashMap r113 = ey7.d.a;
        if (r112 == null) goto L145;
        by7.e r71 = (FrozenTrackNode) r113.get(r112);
    L146:
        a1.c(r210, null, r211, r310, r58, r62, r314, r60, r59, "private", r311, r312, r313, Long.valueOf(r61), null, "chat", r63, r411, r410, null, null, r412, r413, r111, r510, r64, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r49, r71, null, null, null, null, null, null, null, -52154355, -25165856, 7);
        if (RealtimeCallHelperKt.b(r13.c.getBotType()) == false) goto L184;
        Intent r65 = r82.getIntent();
        if (r65 == null) goto L155;
        Bundle r66 = r65.getExtras();
        if (r66 == null) goto L155;
        if (r66.getInt("slardar_router_event_mob_start", 0) != 1) goto L155;
        boolean r114 = true;
    L156:
        if (r114 == false) goto L180;
        int r67 = RealtimeMobUtil.a;
        Intent r68 = r82.getIntent();
        if (r68 == null) goto L160;
        String r212 = r68.getStringExtra("origin_url");
    L161:
        Intent r69 = r82.getIntent();
        if (r69 == null) goto L166;
        Bundle r70 = r69.getExtras();
        if (r70 == null) goto L166;
        String r213 = r70.getString("enter_method");
    L167:
        Intent r72 = r82.getIntent();
        if (r72 == null) goto L172;
        Bundle r73 = r72.getExtras();
        if (r73 == null) goto L172;
        String r214 = r73.getString("bot_id");
    L173:
        Intent r74 = r82.getIntent();
        if (r74 == null) goto L178;
        Bundle r75 = r74.getExtras();
        if (r75 == null) goto L178;
        String r215 = r75.getString("track_params");
    L179:
        RealtimeMobUtil.a(r212, r213, r214, r215, false, "voice_call_downgrade_error");
    L178:
        r215 = null;
    L172:
        r214 = null;
    L166:
        r213 = null;
        goto L167
    L160:
        r212 = null;
    L180:
        StringBuilder r76 = new StringBuilder("jumpToRealtimeCall, realtime call downgrade, openMethod=");
        r76.append(r13.l);
        r76.append(", origin_url=");
        Intent r77 = r82.getIntent();
        if (r77 == null) goto L183;
        r18 = r77.getStringExtra("origin_url");
    L183:
        r76.append(r18);
        r110.e("RealtimeCallGateActivity", r76.toString());
    L155:
        r114 = false;
        goto L156
    L184:
        String r115 = r9;
        boolean r78 = TextUtils.equals(r13.a.getString("open_vlm"), "1");
        String r116 = r13.l;
        Intrinsics.checkNotNullParameter(r116, "entrance");
        if (r78 == false) goto L187;
        String r79 = "video_call";
    L189:
        if (TextUtils.equals("shortcuts", r116) == false) goto L194;
        if (VoiceCallServiceDelegate.a.o(r79, "other", true) == false) goto L194;
    L197:
        boolean r117 = true;
    L199:
        if (r117 == false) goto L229;
        Intent r80 = r82.getIntent();
        if (r80 == null) goto L208;
        Bundle r81 = r80.getExtras();
        if (r81 == null) goto L208;
        if (r81.getInt("slardar_router_event_mob_start", 0) != 1) goto L208;
        boolean r118 = true;
    L209:
        if (r118 == false) goto L223;
        int r85 = RealtimeMobUtil.a;
        String r119 = r82.getIntent().getStringExtra("origin_url");
        Bundle r86 = r82.getIntent().getExtras();
        if (r86 == null) goto L213;
        String r120 = r86.getString("enter_method");
    L214:
        Bundle r87 = r82.getIntent().getExtras();
        if (r87 == null) goto L217;
        String r121 = r87.getString("bot_id");
    L218:
        Bundle r88 = r82.getIntent().getExtras();
        if (r88 == null) goto L221;
        String r122 = r88.getString("track_params");
    L222:
        RealtimeMobUtil.a(r119, r120, r121, r122, false, "voice_call_downgrade_error");
        goto L223
    L221:
        r122 = null;
        goto L222
    L217:
        r121 = null;
        goto L218
    L213:
        r120 = null;
    L223:
        StringBuilder r89 = new StringBuilder("jumpToRealtimeCall, realtime call downgrade, openMethod=");
        r89.append(r13.l);
        r89.append(", origin_url=");
        Intent r90 = r82.getIntent();
        if (r90 == null) goto L226;
        String r91 = r90.getStringExtra("origin_url");
    L227:
        r89.append(r91);
        r110.e(r115, r89.toString());
        goto L245
    L226:
        r91 = null;
    L208:
        r118 = false;
        goto L209
    L229:
        if (r13.m == false) goto L236;
        StringBuilder r92 = new StringBuilder("jumpToRealtimeCall, needStartContinueTalk is true, openMethod=");
        r92.append(r13.l);
        r92.append(", origin_url=");
        Intent r93 = r82.getIntent();
        if (r93 == null) goto L233;
        String r94 = r93.getStringExtra("origin_url");
    L234:
        r92.append(r94);
        r110.e(r115, r92.toString());
        goto L245
    L233:
        r94 = null;
    L236:
        boolean r95 = z2.a.R3();
        FLogger.a.i(r115, "jumpToRealtimeCall, backToChat:" + r13.k + ",postStartRealtime:" + r95);
        if (r95 == false) goto L239;
        t0.c(new q(r82, r13));
        goto L245
    L239:
        r82.D1(r13);
    L194:
        if (TextUtils.equals("long_press_icon_call", r116) == true) goto L196;
    L198:
        r117 = false;
        goto L199
    L196:
        if (VoiceCallServiceDelegate.a.o(r79, "other", true) == false) goto L198;
    L187:
        r79 = "voice_call";
        goto L189
    L145:
        r71 = null;
        goto L146
    L141:
        r312 = "0";
        goto L142
    L138:
        r311 = "0";
        goto L139
    L135:
        r61 = 0;
        goto L136
    L131:
        r411 = null;
        goto L132
    L128:
        r410 = null;
        goto L129
    L122:
        if (o0.d(r13.c.getBgVideoModel()) == false) goto L124;
        r56 = true;
        goto L125
    L112:
        if (r13.c.getBgImgOpen() == false) goto L118;
        if (o0.d(r13.c.getBgImgUrl()) == false) goto L118;
        if (o0.d(r13.c.getBgImgColor()) == false) goto L118;
        r55 = true;
        goto L120
    L105:
        r52 = "normal";
    L83:
        r45 = 0;
    L77:
        r41 = CollectionsKt.emptyList();
    L72:
        r38 = PageType.Chat.getType();
        goto L73
    L85:
        com.bytedance.router.i r96 = SmartRouter.buildRoute(r82, "//flow/chat_page");
        r96.c.putExtras(r29);
        r96.d = 2130772401;
        r96.e = 2130772399;
        r96.d();
        goto L86
    L235:
        r115 = "RealtimeCallGateActivity";
        goto L236
    L55:
        if (r25.length() == 0) goto L58;
        r26 = false;
        goto L59
    L51:
        r25 = null;
        goto L53
    L43:
        r23 = null;
    L46:
        th = move-exception;
        Result.Companion r97 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L35:
        r21 = null;
    L38:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L248
    L30:
        r15 = "0";
        goto L31
    L26:
        r14 = "0";
        goto L28
    L22:
        r10 = new JSONObject();
    L247:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r1.label = 1;
        r0 = r82.z1(r83, r1);
        if (r0 != r3) goto L17;
        return r3;
    L7:
        r1 = new RealtimeCallGateActivity$launchRealTimeCall$1(r82, r84);
        goto L8
    }
}
