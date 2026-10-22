package com.obric.assistant.session.endpoint;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.permission.api.IPermissionX;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.h1;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IChatRelatedPage;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.ISystemKeySettings;
import com.obric.assistant.interaction.api.IWindowEffectsKt;
import com.obric.assistant.interaction.api.WeakUpState;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.interact.CustomBarAction;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IApplicationActivityOperation;
import com.obric.assistant.session.model.IAssistActivateOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.IOAutoOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.spi.chat.ObricInteractionServiceDelegate;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.wakeup.ObricOneshotDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.utils.WakeupKeyLinkManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001fH\u0016J\u001a\u0010$\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J2\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000100H\u0016J2\u00101\u001a\u00020\n2\u0006\u00102\u001a\u0002032\b\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u00104\u001a\u00020\n2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000100H\u0016J\b\u00105\u001a\u00020\nH\u0016J\b\u00106\u001a\u00020\nH\u0002J\u0012\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\f\u00107\u001a\u00020\n*\u00020:H\u0002J\b\u0010;\u001a\u00020\u0018H\u0016J\u0018\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020 H\u0002J\u001a\u0010A\u001a\u00020\n2\u0006\u00102\u001a\u00020B2\b\u0010,\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010C\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u00020 H\u0016J\u0012\u0010I\u001a\u00020\u00182\b\u0010J\u001a\u0004\u0018\u00010 H\u0002J\u001c\u0010K\u001a\u00020\u00182\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010J\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010N\u001a\u0004\u0018\u00010\u001c*\u0004\u0018\u00010 H\u0002J\b\u0010O\u001a\u00020\u0018H\u0016J\b\u0010P\u001a\u00020\nH\u0016J\b\u0010Q\u001a\u00020\nH\u0016J\u0016\u0010R\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020T\u0018\u00010SH\u0002J\b\u0010U\u001a\u00020\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010<\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006V"}, d2 = {"Lcom/obric/assistant/session/endpoint/AssistActivateEndPoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IAssistActivateOperation;", "<init>", "()V", "intercomConditionCheckResult", "", "activateStartTime", "", "showOnLauncherOrKeyguard", "", "showOnLauncher", "activeAiKeyInputContext", "Lcom/obric/assistant/session/common/SessionUtils$AiKeyInputContext;", "systemKeySettings", "Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "getSystemKeySettings", "()Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "systemKeySettings$delegate", "Lkotlin/Lazy;", "asrListener", "com/obric/assistant/session/endpoint/AssistActivateEndPoint$asrListener$1", "Lcom/obric/assistant/session/endpoint/AssistActivateEndPoint$asrListener$1;", "onSessionPrepared", "", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionCompleted", "code", "prepareActivation", "backtrackDurationMs", "resetOnLauncherOrKeyguard", "checkIntercomConditionPass", "updateIntercomConditionStatus", "status", "getIntercomConditionStatus", "showListeningUI", "extra", "isAudioWeakUp", "tryInterruptConversation", "onHapticAndSoundFeedback", "Lkotlin/Function0;", "activate", "activation", "Lcom/obric/assistant/session/model/Activation;", "handleIntercomConditionFail", "onTouchSpeakStop", "isReleasedAiKeyLongPress", "hasVisiblePermissionDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/Fragment;", "onTouchSpeakFailed", "isBackgroundInOAuto", "()Z", "shouldClearCustomBarActions", "foreGroundAppPackageName", "foreGroundActivityName", "activateClickTalk", "Lcom/obric/assistant/session/model/Activation$ClickTalk;", "activateTouchSpeak", "activateChatWindow", "state", "Lcom/obric/assistant/session/model/Activation$ChatWindow;", "tryFinishExistChatActivity", "getTagName", "finishStartupAttemptOnDismissFailed", "attemptId", "bindStartupAttempt", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "toStartupBundle", "handleConditionUnPass", "isShowOnLauncherOrKeyguard", "isShowOnLauncher", "closeHapticArgsForIntercomSwitch", "", "", "checkAddCustomBarAction", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistActivateEndPoint implements ISessionEndPoint, IAssistActivateOperation {
    public volatile int a;
    public volatile long b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile aga.j.a e;
    public final Lazy f;
    public final a g;

    public static final class a implements com.larus.bmhome.chat.component.bottom.core.speaker.b {
        public final /* synthetic */ AssistActivateEndPoint a;

        public a(AssistActivateEndPoint r1) {
            this.a = r1;
        }

        public final void a(y58.b r2) {
            Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
        }

        public final void q(AsrLifeState r3, String r4, Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r3, "lifeState");
            FLogger r6 = FLogger.a;
            AssistActivateEndPoint r7 = this.a;
            r7.getClass();
            r6.i(ISessionEndPoint.a.b(r7), "onLifeStateChange: " + r3);
            if (r3 != AsrLifeState.ASR_ERROR) goto L8;
            aga.j.k();
            ISessionMaintaining r8 = bga.j.b();
            if (r8 == null) goto L9;
            r8.y();
            return;
        L9:
            return;
        }
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "AssistActivateEndPoint";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 0;
    }

    public static boolean w() {
        if (Intrinsics.areEqual(ObricInteractDelegate.b.isAiKeyLongPress(), Boolean.TRUE) == false) goto L13;
        IAiKeyOperation r0 = bga.b.a();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.isAiKeyPressing() == true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final void a() {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "handleConditionUnPass");
        if (j() == false) goto L5;
        r0.i(ISessionEndPoint.a.b(this), "intercomConditionCheckResult pass, no need show tip");
        return;
    L5:
        switch(this.a) {
            case -16: goto L23;
            case -15: goto L20;
            case -14: goto L19;
            case -13: goto L24;
            case -12: goto L18;
            case -11: goto L17;
            case -10: goto L16;
            case -9: goto L15;
            case -8: goto L14;
            case -7: goto L13;
            case -6: goto L24;
            case -5: goto L24;
            case -4: goto L10;
            case -3: goto L8;
            case -2: goto L7;
            default: goto L24;
        };
    L7:
        aga.j.l(2131911950);
        return;
    L8:
        r0.w(ISessionEndPoint.a.b(this), "user not login");
        com.obric.assistant.spi.keyguard.a.a(new q0(this), new r0(), null, false, 28);
        return;
    L13:
        aga.j.l(2131911950);
        return;
    L14:
        aga.j.l(2131908080);
        return;
    L15:
        aga.j.l(2131912641);
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_WARNING);
        return;
    L16:
        aga.j.l(2131907356);
        return;
    L17:
        aga.j.l(2131911966);
        return;
    L18:
        r0.i(ISessionEndPoint.a.b(this), "ai key disabled when screen off");
        return;
    L19:
        r0.i(ISessionEndPoint.a.b(this), "ai key fingerprint enrolling");
        return;
    L20:
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r1 == null) goto L38;
        r1.onWakeupBlockedBySystemAlertWindowPermission();
        return;
    L38:
        return;
    L23:
        r0.i(ISessionEndPoint.a.b(this), "current chat input disabled");
        return;
    L24:
        r0.w(ISessionEndPoint.a.b(this), "can not activate ListeningUI: intercomConditionCheckResult = " + this.a);
        return;
    L10:
        if (com.obric.assistant.common.utils.p.c() == false) goto L12;
        aga.j.l(2131911951);
        return;
    L12:
        aga.j.l(2131911950);
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final boolean j() {
        if (this.a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final boolean k() {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onTouchSpeakStop");
        aga.j.a r1 = this.e;
        this.e = null;
        boolean r4 = false;
        if (j() == false) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AssistActivateEndPoint$onTouchSpeakStop$1(this, null), 3, null);
    L11:
        Lazy r2 = aga.j.a;
        if (Build.VERSION.SDK_INT < 29) goto L53;
        long r6 = System.currentTimeMillis();
        AppHost.Companion r3 = AppHost.a;
        Object r5 = r3.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.app.ActivityManager");
        String r7 = r3.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r8 = ((ActivityManager) r5).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r8);
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L15:
        if (r10.hasNext() == false) goto L23;
        Object r11 = r10.next();
        ComponentName r12 = ((ActivityManager.RecentTaskInfo) r11).baseActivity;
        if (r12 == null) goto L19;
        String r13 = r12.getPackageName();
    L21:
        if (Intrinsics.areEqual(r13, r7) == false) goto L15;
        r9.add(r11);
        goto L15
    L19:
        r13 = null;
        goto L21
    L23:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r15 = r9.iterator();
    L25:
        if (r15.hasNext() == false) goto L27;
        r14.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r15.next()).taskId));
        goto L25
    L27:
        List r16 = AppHost.a.a().m();
        ListIterator r17 = r16.listIterator(r16.size());
    L29:
        if (r17.hasPrevious() == false) goto L40;
        Object r18 = r17.previous();
        Activity r19 = (Activity) r18;
        if ((r19 instanceof FragmentActivity) == true) goto L33;
    L37:
        boolean r20 = false;
    L38:
        if (r20 == false) goto L29;
    L41:
        Activity r21 = (FragmentActivity) r18;
        Activity r22 = AppHost.a.a().getCurrentActivity();
        FLogger r23 = FLogger.a;
        StringBuilder r110 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r110.append(r14);
        r110.append(",result=");
        r110.append(r21);
        r110.append(':');
        if ((r21 instanceof Activity) == false) goto L44;
        Activity r111 = r21;
    L45:
        if (r111 == null) goto L47;
        Integer r112 = Integer.valueOf(r111.getTaskId());
    L48:
        r110.append(r112);
        r110.append(", cur=");
        r110.append(r22);
        r110.append(':');
        if (r22 == null) goto L51;
        Integer r24 = Integer.valueOf(r22.getTaskId());
    L52:
        r110.append(r24);
        r110.append(",cost:");
        r110.append(System.currentTimeMillis() - r6);
        r23.d("AiIsland-SessionUtils", r110.toString());
    L57:
        if (r1 == null) goto L60;
        t1a.b r25 = r1.a;
        if (r25 == null) goto L60;
    L63:
        if (r25 == null) goto L65;
        laa.d r26 = (laa.d) r25.getAbility(laa.d.class);
    L66:
        if (r25 == null) goto L68;
        laa.f r27 = (laa.f) r25.getAbility(laa.f.class);
    L69:
        if (r25 == null) goto L71;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r28 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r25.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
    L72:
        if (r27 != null) goto L74;
    L76:
        boolean r29 = false;
    L77:
        if (r29 == true) goto L79;
    L87:
        if (r28 == null) goto L89;
    L92:
        if (r28 == null) goto L94;
        r28.K8(this.g);
    L94:
        ISessionMaintaining r30 = bga.j.b();
        if (r30 == null) goto L97;
        r30.c();
    L97:
        if (r21 == null) goto L114;
        FragmentManager r31 = r21.getSupportFragmentManager();
        if (r31 == null) goto L114;
        List r32 = r31.getFragments();
        if (r32 == null) goto L114;
        List r33 = r32;
        if ((r33 instanceof Collection) == true) goto L106;
    L108:
        Iterator r34 = r33.iterator();
    L110:
        if (r34.hasNext() == false) goto L114;
        Fragment r35 = (Fragment) r34.next();
        Intrinsics.checkNotNull(r35);
        if (u(r35) == false) goto L110;
        boolean r36 = true;
    L115:
        if (r26 == null) goto L117;
        r26.Hd(r36);
    L117:
        if (r36 == false) goto L131;
        if (r28 != null) goto L120;
    L122:
        boolean r37 = false;
    L123:
        if (r37 == true) goto L131;
        FLogger.a.i(ISessionEndPoint.a.b(this), "onTouchSpeakStop: permission dialog showing, skip empty asr dismiss");
        if (r27 == null) goto L127;
        r27.qm();
    L127:
        if (r27 == null) goto L199;
        return true;
    L199:
        return false;
    L120:
        if (r28.m0() != true) goto L122;
        r37 = true;
    L131:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L140;
        FLogger.a.i(ISessionEndPoint.a.b(this), "onTouchSpeakStop: network unavailable");
        ISessionMaintaining r38 = bga.j.b();
        if (r38 == null) goto L135;
        r38.y();
    L135:
        if (r27 == null) goto L137;
        r27.qm();
    L137:
        if (r27 == null) goto L200;
        return true;
    L200:
        return false;
    L140:
        FLogger r39 = FLogger.a;
        String r40 = ISessionEndPoint.a.b(this);
        StringBuilder r41 = new StringBuilder("onTouchSpeakStop: aiKeyInputContext=");
        r41.append(r1);
        r41.append(", current is speaking, ");
        if (r28 == null) goto L143;
        Boolean r42 = Boolean.valueOf(r28.m0());
    L144:
        r41.append(r42);
        r41.append(", chatWindow : ");
        if (r26 == null) goto L147;
        Boolean r43 = Boolean.valueOf(r26.aF());
    L148:
        r41.append(r43);
        r41.append(' ');
        if (r26 == null) goto L151;
        String r44 = r26.bl();
    L152:
        r41.append(r44);
        r41.append(", isMockViewVisible: ");
        if (r27 == null) goto L155;
        Boolean r45 = Boolean.valueOf(r27.kT());
    L156:
        r41.append(r45);
        r39.i(r40, r41.toString());
        if (r28 != null) goto L159;
    L161:
        boolean r46 = false;
    L162:
        if (r46 == false) goto L175;
        if (r26 != null) goto L165;
    L167:
        boolean r47 = false;
    L168:
        if (r47 == false) goto L180;
        ISessionMaintaining r48 = bga.j.b();
        if (r48 == null) goto L172;
        r48.x();
    L172:
        ISessionMaintaining r49 = bga.j.b();
        if (r49 == null) goto L180;
        r49.i();
    L180:
        if (r27 == null) goto L182;
        r27.qm();
    L182:
        if (r27 == null) goto L201;
        return true;
    L201:
        return false;
    L165:
        if (r26.aF() != true) goto L167;
        r47 = true;
        goto L168
    L175:
        if (r27 == null) goto L177;
        r27.tH(null);
    L177:
        aga.j.k();
        ISessionMaintaining r50 = bga.j.b();
        if (r50 == null) goto L180;
        r50.y();
        goto L180
    L159:
        if (r28.m0() != true) goto L161;
        r46 = true;
        goto L162
    L155:
        r45 = null;
        goto L156
    L151:
        r44 = null;
        goto L152
    L147:
        r43 = null;
        goto L148
    L143:
        r42 = null;
        goto L144
    L106:
        if (r33.isEmpty() == false) goto L108;
    L114:
        r36 = false;
        goto L115
    L89:
        if (w() == false) goto L92;
        FLogger.a.i(ISessionEndPoint.a.b(this), "onTouchSpeakStop: speaker not ready, retain released long");
        return false;
    L79:
        if (w() == false) goto L87;
        FLogger r51 = FLogger.a;
        String r52 = ISessionEndPoint.a.b(this);
        StringBuilder r53 = new StringBuilder("onTouchSpeakStop: cancel pending TouchSpeak after key release, speakerReady=");
        if (r28 == null) goto L83;
        r4 = true;
    L83:
        r53.append(r4);
        r51.i(r52, r53.toString());
        if (r27 == null) goto L86;
        r27.qm();
    L86:
        return true;
    L74:
        if (r27.H90() != true) goto L76;
        r29 = true;
        goto L77
    L71:
        r28 = null;
        goto L72
    L68:
        r27 = null;
        goto L69
    L65:
        r26 = null;
    L60:
        if (r21 == null) goto L62;
        r25 = aga.j.g(r21);
        goto L63
    L62:
        r25 = null;
        goto L63
    L51:
        r24 = null;
        goto L52
    L47:
        r112 = null;
        goto L48
    L44:
        r111 = null;
        goto L45
    L33:
        if (r14.contains(Integer.valueOf(r19.getTaskId())) == false) goto L35;
    L36:
        r20 = true;
        goto L38
    L35:
        if (r19.getTaskId() != 0) goto L37;
    L40:
        r18 = null;
        goto L41
    L53:
        Activity r54 = AppHost.a.a().getCurrentActivity();
        if ((r54 instanceof FragmentActivity) == true) goto L56;
        r54 = null;
    L56:
        r21 = (FragmentActivity) r54;
        goto L57
    L5:
        ObricInteractDelegate r55 = ObricInteractDelegate.b;
        Boolean r56 = r55.isAiKeyLongPress();
        Boolean r57 = Boolean.FALSE;
        if (Intrinsics.areEqual(r56, r57) == false) goto L11;
        if (Intrinsics.areEqual(r55.isAiKeyShortPress(), r57) == false) goto L11;
        r0.i(ISessionEndPoint.a.b(this), "onTouchSpeakStop: current is not pass " + this.a + ", and is not long press or short press");
        return false;
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final int m() {
        int r0 = this.a;
        FLogger.a.i(ISessionEndPoint.a.b(this), "getIntercomConditionStatus: " + r0);
        return r0;
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final void q() {
        FLogger.a.i(ISessionEndPoint.a.b(this), "onTouchSpeakFailed");
        this.e = null;
    }

    public final void s() {
        if (this.c == true) goto L6;
        FLogger.a.i(ISessionEndPoint.a.b(this), "checkAddCustomBarAction: addCustomBarAction");
        IAssistantInteractionServiceKt.getInteractionStateService().addCustomBarAction(new CustomBarAction("obric_screen_qa", null, null, null, 14, null));
        return;
    }

    public AssistActivateEndPoint() {
        this.f = LazyKt.lazy(new k0());
        this.g = new a(this);
    }

    public static Map t() {
        IAiKeyOperation r0 = bga.b.a();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L12;
        return null;
    L12:
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("suppress_close_haptic_for_intercom_switch", Boolean.TRUE)});
    L5:
        if (r0.isAiKeyPressing() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final void i() {
        IApplicationActivityOperation r0 = bga.c.a();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.c();
        if (r2 == null) goto L6;
    L7:
        IApplicationActivityOperation r3 = bga.c.a();
        if (r3 == null) goto L13;
        String r4 = r3.a();
        if (r4 == null) goto L13;
        r1 = r4;
    L13:
        boolean r5 = true;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L24;
        ILaunchMethodOperation r6 = bga.g.a();
        if (r6 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == true) goto L24;
        r5 = false;
        goto L24
    L18:
        if (r6.l(r2, r1) != true) goto L20;
        r7 = true;
    L24:
        this.c = r5;
        this.d = x(r2, r1);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public final boolean v() {
        IOAutoOperation r0 = bga.h.a();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final boolean l() {
        return this.c;
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final boolean o() {
        return this.d;
    }

    public static boolean u(Fragment r3) {
        if (r3.isAdded() == true) goto L5;
    L11:
        List r4 = r3.getChildFragmentManager().getFragments();
        if ((r4 instanceof Collection) == true) goto L14;
    L16:
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        Fragment r0 = (Fragment) r5.next();
        Intrinsics.checkNotNull(r0);
        if (u(r0) == false) goto L18;
        return true;
    L22:
        return false;
    L14:
        if (r4.isEmpty() == false) goto L16;
    L5:
        if (r3.isRemoving() == true) goto L11;
        if (IPermissionX.a.k(r3) != true) goto L9;
    L10:
        return true;
    L9:
        if (Intrinsics.areEqual(r3.getTag(), "PermissionXGoSettingDialog") == false) goto L11;
        goto L10
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final void b(int r1) {
        this.a = r1;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r5) {
        Intrinsics.checkNotNullParameter(r5, "code");
        FLogger.a.i(ISessionEndPoint.a.b(this), "onSessionCompleted, code: " + r5);
        ISessionEndPoint.a.c(this, r5);
    }

    public static void r(t1a.b r2, String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r3)) == true) goto L7;
        r3 = null;
    L7:
        if (r3 == null) goto L23;
        if (r2 == null) goto L21;
        de8.c r4 = r2.a(de8.c.class);
        if (r4 == null) goto L24;
        Bundle r0 = r4.b;
        if (r0 == null) goto L16;
        r0.putString("obric_startup_attempt_id", r3);
    L16:
        Bundle r5 = r4.a;
        if (r5 == null) goto L22;
        r5.putString("obric_startup_attempt_id", r3);
        return;
    L22:
        return;
    L24:
        return;
    L21:
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r2, Continuation<? super Pair<? extends ErrorCode, String>> r3) {
        FLogger.a.i(ISessionEndPoint.a.b(this), "onSessionProcess");
        return ISessionEndPoint.a.e(this);
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final boolean e(Bundle r9, long r10) {
        boolean r0 = com.obric.assistant.common.utils.a0.a();
        if (r9 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        long r11 = RangesKt.coerceAtLeast(r10, 0);
        FLogger r4 = FLogger.a;
        r4.i(ISessionEndPoint.a.b(this), "prepareActivation: isScreenOn=" + r0 + ", isFromDora=" + r3 + ", backtrackDurationMs=" + r11);
        com.obric.assistant.session.singleton.u.b();
        if (r0 == true) goto L19;
        if (r3 == true) goto L18;
        ISystemKeySettings r5 = (ISystemKeySettings) this.f.getValue();
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L19;
    L14:
        if (r5.isAiKeyEnabledWhenScreenOff() != true) goto L16;
        r6 = true;
    L18:
        com.obric.assistant.common.utils.a0.b();
    L19:
        IApplicationActivityOperation r7 = bga.c.a();
        String r8 = "";
        if (r7 == null) goto L23;
        String r12 = r7.c();
        if (r12 == null) goto L23;
    L24:
        IApplicationActivityOperation r13 = bga.c.a();
        if (r13 == null) goto L31;
        String r14 = r13.a();
        if (r14 == null) goto L31;
        r8 = r14;
    L31:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L41;
        ILaunchMethodOperation r15 = bga.g.a();
        if (r15 != null) goto L35;
    L37:
        boolean r16 = false;
    L38:
        if (r16 == true) goto L41;
        boolean r17 = false;
    L42:
        this.c = r17;
        this.d = x(r12, r8);
        IAssistantInteractionServiceKt.getInteractionStateService().clearCustomBarActions(this.d);
        IAgentVoiceInteractionIDL r18 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r18 == null) goto L45;
        r18.onShow(r9);
    L45:
        IApplicationActivityOperation r19 = bga.c.a();
        if (r19 == null) goto L48;
        r19.b(r9);
    L48:
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(r12, "prepareActivation");
        this.a = aga.j.a(r0, r3);
        r4.i(ISessionEndPoint.a.b(this), "prepareActivation: intercomConditionCheckResult is " + this.a);
        if (this.a != 0) goto L51;
        this.b = System.currentTimeMillis() - r11;
    L51:
        IOAutoOperation r20 = bga.h.a();
        if (r20 == null) goto L55;
        r20.a();
    L55:
        if (this.a != 0) goto L58;
        return true;
    L58:
        return false;
    L35:
        if (r15.l(r12, r8) != true) goto L37;
        r16 = true;
    L41:
        r17 = true;
    L23:
        r12 = "";
        goto L24
    L5:
        if (r9.getInt("invocation_type", -1) != 23) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "args");
        FLogger.a.i(ISessionEndPoint.a.b(this), "onSessionPrepared");
        ISessionEndPoint.a.d(this, r4, r5);
    }

    public final boolean x(String r5, String r6) {
        ILaunchMethodOperation r0 = bga.g.a();
        if (r0 == null) goto L5;
        String r1 = r0.b(getContext());
    L7:
        if (Intrinsics.areEqual(r5, r1) == false) goto L9;
    L16:
        return true;
    L9:
        if (StringsKt.contains$default(r6, "ObricChatActivity", false, 2, null) == false) goto L11;
        return false;
    L11:
        if (StringsKt.contains$default(r6, "ChatActivity", false, 2, null) == false) goto L13;
        return false;
    L13:
        if (StringsKt.contains$default(r6, "com.obric.miniapp", false, 2, null) == false) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r5, getContext().getPackageName()) == true) goto L16;
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final boolean c(final Bundle r31, boolean r32, boolean r33, Function0<Unit> r34) {
        FLogger r4 = FLogger.a;
        r4.i(ISessionEndPoint.a.b(this), "showListeningUI: isAudioWeakUp = " + r32 + ", tryInterruptConversation = " + r33);
        if (j() == true) goto L6;
        r4.i(ISessionEndPoint.a.b(this), "showListeningUI: checkIntercomConditionPass is false");
        return false;
    L6:
        if (r34 == null) goto L8;
        r34.invoke();
    L8:
        Lazy r5 = aga.j.a;
        if (Build.VERSION.SDK_INT < 29) goto L51;
        long r18 = System.currentTimeMillis();
        AppHost.Companion r6 = AppHost.a;
        Object r8 = r6.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.ActivityManager");
        String r7 = r6.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r9 = ((ActivityManager) r8).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r9);
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L12:
        if (r11.hasNext() == false) goto L21;
        Object r12 = r11.next();
        ComponentName r13 = ((ActivityManager.RecentTaskInfo) r12).baseActivity;
        if (r13 == null) goto L16;
        String r14 = r13.getPackageName();
    L18:
        if (Intrinsics.areEqual(r14, r7) == false) goto L12;
        r10.add(r12);
        goto L12
    L16:
        r14 = null;
        goto L18
    L21:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r16 = r10.iterator();
    L23:
        if (r16.hasNext() == false) goto L25;
        r15.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r16.next()).taskId));
        goto L23
    L25:
        List r17 = AppHost.a.a().m();
        ListIterator r19 = r17.listIterator(r17.size());
    L27:
        if (r19.hasPrevious() == false) goto L38;
        Object r20 = r19.previous();
        Activity r21 = (Activity) r20;
        if ((r21 instanceof FragmentActivity) == true) goto L31;
    L35:
        boolean r22 = false;
    L36:
        if (r22 == false) goto L27;
    L39:
        Activity r23 = (FragmentActivity) r20;
        Activity r24 = AppHost.a.a().getCurrentActivity();
        FLogger r25 = FLogger.a;
        StringBuilder r110 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r110.append(r15);
        r110.append(",result=");
        r110.append(r23);
        r110.append(':');
        if ((r23 instanceof Activity) == false) goto L42;
        Activity r26 = r23;
    L43:
        if (r26 == null) goto L45;
        Integer r27 = Integer.valueOf(r26.getTaskId());
    L46:
        r110.append(r27);
        r110.append(", cur=");
        r110.append(r24);
        r110.append(':');
        if (r24 == null) goto L49;
        Integer r28 = Integer.valueOf(r24.getTaskId());
    L50:
        r110.append(r28);
        r110.append(",cost:");
        r110.append(System.currentTimeMillis() - r18);
        r25.d("AiIsland-SessionUtils", r110.toString());
        Activity r29 = r23;
    L56:
        if ((r29 instanceof FragmentActivity) == true) goto L59;
        r29 = null;
    L59:
        ObricInteractionServiceDelegate.b.b(r29);
        if (r31 != null) goto L62;
    L64:
        boolean r30 = false;
    L65:
        if (r30 == false) goto L69;
        IObricTraceParam r35 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r35 == null) goto L69;
        r35.j();
    L69:
        if (r30 == false) goto L75;
        this.e = null;
        if (r29 == null) goto L75;
        Lazy r36 = aga.j.a;
        Intrinsics.checkNotNullParameter(r29, "<this>");
        aga.j.a r37 = aga.j.c(r29);
        if (r37 == null) goto L75;
        this.e = r37;
    L76:
        if (r37 == null) goto L79;
        t1a.b r38 = r37.a;
        if (r38 == null) goto L79;
    L83:
        if (r31 == null) goto L85;
        String r0 = r31.getString("obric_startup_attempt_id");
    L86:
        r(r38, r0);
        if (r38 == null) goto L89;
        laa.d r1 = (laa.d) r38.getAbility(laa.d.class);
    L90:
        if (r38 == null) goto L92;
        final laa.f r111 = (laa.f) r38.getAbility(laa.f.class);
    L93:
        if (r1 == null) goto L95;
        r1.Hd(true);
    L95:
        if (r1 == null) goto L100;
        ObricFloatChatPageState r2 = r1.getPageState();
        String r112 = "AiIsland-SessionUtils";
        FLogger r39 = FLogger.a;
        String r210 = ",cost:";
        String r211 = ", cur=";
        String r212 = ",result=";
        r39.i(ISessionEndPoint.a.b(this), "pageState = " + r2);
        ObricFloatChatPageData.Companion.getClass();
        if (ObricFloatChatPageData.a.d(r2) == true) goto L99;
        r39.i(ISessionEndPoint.a.b(this), "state is not visible, change to chat window");
        laa.d.a.a(r1, 0.0f, false, 3);
    L101:
        if (r33 == false) goto L117;
        IObricChatService r3 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r3 == null) goto L107;
        wc9.e r40 = r3.h();
        if (r40 == null) goto L107;
        String r41 = r40.a;
    L108:
        if (r41 != null) goto L111;
        r41 = "";
    L111:
        if (r41.length() <= 0) goto L113;
        boolean r42 = true;
    L114:
        if (r42 == false) goto L116;
        FLogger.a.i(ISessionEndPoint.a.b(this), "showListeningUI: mainCvsId is " + r41 + ", will tryInterrupt");
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r41, false, false, OmniBreakReason.OmniBreakReason_CLICK_ASR, 6);
        goto L117
    L116:
        FLogger.a.i(ISessionEndPoint.a.b(this), "showListeningUI: mainCvsId is empty, cannot tryInterrupt");
        goto L117
    L113:
        r42 = false;
    L107:
        r41 = null;
    L117:
        if (r29 == null) goto L129;
        if (r1 != null) goto L120;
    L122:
        boolean r43 = false;
    L123:
        if (r43 == false) goto L129;
        if (r1.isVisible() == false) goto L129;
        if (v() == true) goto L129;
        boolean r44 = true;
    L130:
        if (r29 == null) goto L142;
        if (r111 != null) goto L133;
    L135:
        boolean r45 = false;
    L136:
        if (r45 == false) goto L142;
        if (v() == true) goto L142;
        if (r30 == false) goto L141;
        if (r37 == null) goto L142;
    L141:
        boolean r46 = true;
    L143:
        if (r37 != null) goto L145;
    L147:
        boolean r213 = false;
    L148:
        boolean r47 = !r213;
        if (r1 == null) goto L151;
        ObricFloatChatPageState r48 = r1.getPageState();
    L152:
        FLogger r113 = FLogger.a;
        String r114 = ISessionEndPoint.a.b(this);
        StringBuilder r115 = new StringBuilder("showListeningUI: currentActivity = ");
        r115.append(r29);
        r115.append(", vContext = ");
        r115.append(r38);
        r115.append(", pageStateAbility = ");
        r115.append(r1);
        r115.append(", isChatMainBotVisible = ");
        r115.append(r44);
        r115.append(", canHandleInPlaceByIntercom = ");
        r115.append(r46);
        r115.append(", aiKeyInputContext = ");
        r115.append(r37);
        r115.append(", pageState = ");
        r115.append(r48);
        r115.append(", pageState.isDismiss() = ");
        ObricFloatChatPageData.Companion.getClass();
        r115.append(r48 instanceof vda.b);
        r113.i(r114, r115.toString());
        if (r44 == true) goto L266;
        if (r46 == true) goto L266;
        r113.i(ISessionEndPoint.a.b(this), "showListeningUI: open new ui");
        s();
        IWindowEffectsKt.getWindowEffects().setWakeupState(new WeakUpState(r32, sha.b.b()));
        Lazy r49 = aga.j.a;
        if (Build.VERSION.SDK_INT < 29) goto L198;
        long r50 = System.currentTimeMillis();
        AppHost.Companion r51 = AppHost.a;
        Object r52 = r51.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r52, "null cannot be cast to non-null type android.app.ActivityManager");
        String r53 = r51.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r54 = ((ActivityManager) r52).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r54);
        ArrayList r55 = new ArrayList();
        Iterator<T> r56 = r54.iterator();
    L160:
        if (r56.hasNext() == false) goto L168;
        Object r57 = r56.next();
        ComponentName r58 = ((ActivityManager.RecentTaskInfo) r57).baseActivity;
        if (r58 == null) goto L164;
        String r59 = r58.getPackageName();
    L166:
        if (Intrinsics.areEqual(r59, r53) == false) goto L160;
        r55.add(r57);
        goto L160
    L164:
        r59 = null;
        goto L166
    L168:
        ArrayList r60 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r55, 10));
        Iterator r61 = r55.iterator();
    L170:
        if (r61.hasNext() == false) goto L172;
        r60.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r61.next()).taskId));
        goto L170
    L172:
        List r62 = AppHost.a.a().m();
        ListIterator r63 = r62.listIterator(r62.size());
    L174:
        if (r63.hasPrevious() == false) goto L185;
        Object r64 = r63.previous();
        Activity r65 = (Activity) r64;
        if ((r65 instanceof FragmentActivity) == true) goto L178;
    L182:
        boolean r66 = false;
    L183:
        if (r66 == false) goto L174;
    L186:
        Activity r67 = (FragmentActivity) r64;
        Activity r68 = AppHost.a.a().getCurrentActivity();
        FLogger r69 = FLogger.a;
        StringBuilder r70 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r70.append(r60);
        r70.append(r212);
        r70.append(r67);
        r70.append(':');
        if ((r67 instanceof Activity) == false) goto L189;
        Activity r71 = r67;
    L190:
        if (r71 == null) goto L192;
        Integer r72 = Integer.valueOf(r71.getTaskId());
    L193:
        r70.append(r72);
        r70.append(r211);
        r70.append(r68);
        r70.append(':');
        if (r68 == null) goto L196;
        Integer r73 = Integer.valueOf(r68.getTaskId());
    L197:
        r70.append(r73);
        r70.append(r210);
        r70.append(System.currentTimeMillis() - r50);
        r69.d(r112, r70.toString());
        Activity r74 = r67;
    L203:
        if ((r74 instanceof FragmentActivity) == true) goto L206;
        r74 = null;
    L206:
        if (r74 == null) goto L210;
        t1a.b r75 = aga.j.g(r74);
        if (r75 == null) goto L210;
        laa.d r76 = (laa.d) r75.getAbility(laa.d.class);
    L211:
        if (r76 != null) goto L213;
    L215:
        boolean r77 = false;
    L216:
        if (r77 == false) goto L239;
        FLogger.a.i(ISessionEndPoint.a.b(this), "tryFinishExistChatActivity " + r74);
        if (r74 == null) goto L220;
        r74.finish();
    L220:
        Lazy r78 = aga.j.a;
        List r79 = AppHost.a.a().g();
        ArrayList r80 = new ArrayList();
        Iterator r81 = r79.iterator();
    L222:
        if (r81.hasNext() == false) goto L226;
        Object r82 = r81.next();
        if ((((Activity) r82) instanceof IChatRelatedPage) == false) goto L222;
        r80.add(r82);
        goto L222
    L226:
        ArrayList r83 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r80, 10));
        Iterator r84 = r80.iterator();
    L228:
        if (r84.hasNext() == false) goto L234;
        ComponentCallbacks2 r85 = (Activity) r84.next();
        if (r85 == null) goto L233;
        r83.add((IChatRelatedPage) r85);
        goto L228
    L233:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.assistant.interaction.api.IChatRelatedPage");
    L234:
        Iterator r86 = r83.iterator();
    L236:
        if (r86.hasNext() == false) goto L239;
        ((IChatRelatedPage) r86.next()).closeWithChat();
    L239:
        if (t1.a.i() == true) goto L255;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L255;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L255;
        FLogger.a.i(ISessionEndPoint.a.b(this), "requestDismissKeyguard");
        if (r31 == null) goto L251;
        final String r87 = r31.getString("obric_startup_attempt_id");
        if (r87 == null) goto L251;
        if ((!StringsKt.isBlank(r87)) == false) goto L251;
    L252:
        com.obric.assistant.spi.keyguard.a.a(new o0(this, r111, r31), new p0(this, r87), null, false, 28);
        return true;
    L251:
        r87 = null;
    L255:
        if (r111 == null) goto L257;
        r111.LL(r31);
    L257:
        ISessionMaintaining r88 = bga.j.b();
        if (r88 == null) goto L263;
        Bundle r89 = new Bundle();
        if (r31 == null) goto L262;
        r89.putAll(r31);
    L262:
        Unit r90 = Unit.INSTANCE;
        laa.n r91 = null;
        ISessionMaintaining.a.a(r88, r89, null, false, 29);
    L264:
        if (r111 == null) goto L348;
        r111.tH(r91);
        return true;
    L348:
        return true;
    L263:
        r91 = null;
        goto L264
    L213:
        if (r76.Da() != true) goto L215;
        r77 = true;
    L210:
        r76 = null;
        goto L211
    L196:
        r73 = null;
        goto L197
    L192:
        r72 = null;
        goto L193
    L189:
        r71 = null;
        goto L190
    L178:
        if (r60.contains(Integer.valueOf(r65.getTaskId())) == false) goto L180;
    L181:
        r66 = true;
        goto L183
    L180:
        if (r65.getTaskId() != 0) goto L182;
    L185:
        r64 = null;
        goto L186
    L198:
        Activity r92 = AppHost.a.a().getCurrentActivity();
        if ((r92 instanceof FragmentActivity) == true) goto L201;
        r92 = null;
    L201:
        r74 = (FragmentActivity) r92;
    L266:
        r113.i(ISessionEndPoint.a.b(this), "showListeningUI: use existing ui");
        if (r38 == null) goto L272;
        laa.l r93 = r38.getAbility(laa.l.class);
        if (r93 == null) goto L272;
        r93.qw(false, false);
    L272:
        ISessionMaintaining r94 = bga.j.b();
        if (r94 == null) goto L275;
        r94.k(r38, true);
    L275:
        if (r38 == null) goto L277;
        maa.e r95 = (maa.e) r38.getAbility(maa.e.class);
    L278:
        r113.i(ISessionEndPoint.a.b(this), "clickTalkAbility = " + r95);
        Map r116 = t();
        if (r95 != null) goto L281;
    L283:
        boolean r96 = false;
    L284:
        if (r96 == false) goto L296;
        IDoraOperation r97 = bga.f.a();
        if (r97 == null) goto L288;
        Integer r98 = r97.g();
    L289:
        if (r98 != null) goto L291;
    L294:
        boolean r99 = true;
    L295:
        r113.w(ISessionEndPoint.a.b(this), "showListeningUI, close click talk, endDoraSession = " + r99);
        boolean r100 = true;
        com.obric.audio.continuous_talk.c r101 = null;
        maa.e.a.a(r95, null, r116, r99, 1);
    L297:
        if (r38 == null) goto L299;
        com.obric.audio.continuous_talk.c r117 = (com.obric.audio.continuous_talk.c) r38.getAbility(com.obric.audio.continuous_talk.c.class);
    L300:
        if (r117 != null) goto L302;
    L304:
        boolean r102 = false;
    L305:
        if (r102 == false) goto L307;
        com.obric.audio.continuous_talk.c.a.a(r117, null, r116, false, true, 5);
    L307:
        if (r111 == null) goto L309;
        r111.LL(r31);
    L309:
        ISessionMaintaining r103 = bga.j.b();
        if (r103 == null) goto L350;
        if (r44 == false) goto L317;
        if (r47 == false) goto L317;
        IAssistantChatWindow r104 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r104 == null) goto L316;
        r104.dismissAllChildDialogs();
    L316:
        r103.n(r29);
        r103.f(r29);
    L317:
        r103.interruptMovingBackground();
        r103.c();
        return true;
    L350:
        return true;
    L302:
        if (r117.m0() != r100) goto L304;
        r102 = true;
        goto L305
    L299:
        r117 = r101;
        goto L300
    L291:
        if (r98.intValue() == 0) goto L294;
        r99 = false;
        goto L295
    L288:
        r98 = null;
        goto L289
    L296:
        r100 = true;
        r101 = null;
        goto L297
    L281:
        if (r95.x3() != true) goto L283;
        r96 = true;
        goto L284
    L277:
        r95 = null;
        goto L278
    L151:
        r48 = null;
        goto L152
    L145:
        if (r37.b == true) goto L147;
        r213 = true;
        goto L148
    L133:
        if (r111.xA() != true) goto L135;
        r45 = true;
    L142:
        r46 = false;
        goto L143
    L120:
        if (r1.Da() != true) goto L122;
        r43 = true;
    L129:
        r44 = false;
        goto L130
    L99:
        r39.i(ISessionEndPoint.a.b(this), "state is visible, keep current page");
        goto L101
    L100:
        r112 = "AiIsland-SessionUtils";
        r210 = ",cost:";
        r211 = ", cur=";
        r212 = ",result=";
        FLogger.a.i(ISessionEndPoint.a.b(this), "pageStateAbility is null, cannot check state");
        goto L101
    L92:
        r111 = null;
        goto L93
    L89:
        r1 = null;
        goto L90
    L85:
        r0 = null;
    L79:
        if (r29 == null) goto L81;
        r38 = aga.j.g(r29);
        goto L83
    L81:
        r38 = null;
    L75:
        r37 = null;
        goto L76
    L62:
        if (r31.getBoolean("arg_long_press_ai") != true) goto L64;
        r30 = true;
        goto L65
    L49:
        r28 = null;
        goto L50
    L45:
        r27 = null;
        goto L46
    L42:
        r26 = null;
        goto L43
    L31:
        if (r15.contains(Integer.valueOf(r21.getTaskId())) == false) goto L33;
    L34:
        r22 = true;
        goto L36
    L33:
        if (r21.getTaskId() != 0) goto L35;
    L38:
        r20 = null;
        goto L39
    L51:
        Activity r105 = AppHost.a.a().getCurrentActivity();
        if ((r105 instanceof FragmentActivity) == true) goto L54;
        r105 = null;
    L54:
        r29 = (FragmentActivity) r105;
        goto L56
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.session.model.IAssistActivateOperation
    public final boolean g(bga.a r20, Bundle r21, boolean r22, Function0<Unit> r23) {
        Intrinsics.checkNotNullParameter(r20, "activation");
        FLogger r4 = FLogger.a;
        r4.i(ISessionEndPoint.a.b(this), "activate: activation = " + r20 + ", handleIntercomConditionFail = " + r22);
        boolean r5 = j();
        if (r22 == false) goto L6;
        if (r5 == true) goto L6;
        a();
    L6:
        if (r5 == false) goto L13;
        if (r23 == null) goto L9;
        r23.invoke();
    L9:
        ISessionMaintaining r3 = bga.j.b();
        if (r3 == null) goto L13;
        r3.m();
    L13:
        if ((r20 instanceof bga.a.b) == false) goto L222;
        WakeupKeyLinkManager.b();
        bga.a.b r1 = (bga.a.b) r20;
        r4.i(ISessionEndPoint.a.b(this), "activateClickTalk: activation = " + r1);
        if (j() == true) goto L18;
        r4.i(ISessionEndPoint.a.b(this), "activateClickTalk: checkIntercomConditionPass is false");
    L388:
        return false;
    L18:
        Lazy r6 = aga.j.a;
        if (Build.VERSION.SDK_INT < 29) goto L62;
        long r7 = System.currentTimeMillis();
        AppHost.Companion r8 = AppHost.a;
        Object r9 = r8.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.ActivityManager");
        String r10 = r8.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r11 = ((ActivityManager) r9).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r11);
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L22:
        if (r13.hasNext() == false) goto L31;
        Object r14 = r13.next();
        Iterator r24 = r13;
        ComponentName r15 = ((ActivityManager.RecentTaskInfo) r14).baseActivity;
        if (r15 == null) goto L26;
        String r16 = r15.getPackageName();
    L28:
        if (Intrinsics.areEqual(r16, r10) == false) goto L30;
        r12.add(r14);
    L30:
        r13 = r24;
        goto L22
    L26:
        r16 = null;
        goto L28
    L31:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r18 = r12.iterator();
    L33:
        if (r18.hasNext() == false) goto L35;
        r17.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r18.next()).taskId));
        goto L33
    L35:
        List r19 = AppHost.a.a().m();
        ListIterator r25 = r19.listIterator(r19.size());
    L37:
        if (r25.hasPrevious() == false) goto L49;
        Object r26 = r25.previous();
        Activity r110 = (Activity) r26;
        ListIterator r27 = r25;
        if ((r110 instanceof FragmentActivity) == true) goto L41;
    L45:
        boolean r28 = false;
    L46:
        if (r28 == true) goto L50;
        r25 = r27;
    L50:
        Activity r29 = (FragmentActivity) r26;
        Activity r30 = AppHost.a.a().getCurrentActivity();
        FLogger r111 = FLogger.a;
        StringBuilder r2 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r2.append(r17);
        r2.append(",result=");
        r2.append(r29);
        r2.append(':');
        if ((r29 instanceof Activity) == false) goto L53;
        Activity r31 = r29;
    L54:
        if (r31 == null) goto L56;
        Integer r32 = Integer.valueOf(r31.getTaskId());
    L57:
        r2.append(r32);
        r2.append(", cur=");
        r2.append(r30);
        r2.append(':');
        if (r30 == null) goto L60;
        Integer r33 = Integer.valueOf(r30.getTaskId());
    L61:
        r2.append(r33);
        r2.append(",cost:");
        r2.append(System.currentTimeMillis() - r7);
        r111.d("AiIsland-SessionUtils", r2.toString());
        Activity r34 = r29;
    L67:
        if ((r34 instanceof FragmentActivity) == true) goto L70;
        r34 = null;
    L70:
        ObricInteractionServiceDelegate.b.b(r34);
        if (r34 == null) goto L73;
        Lazy r35 = aga.j.a;
        Intrinsics.checkNotNullParameter(r34, "<this>");
        aga.j.a r36 = aga.j.c(r34);
    L74:
        if (r36 == null) goto L77;
        t1a.b r37 = r36.a;
        if (r37 == null) goto L77;
    L80:
        if (r21 == null) goto L86;
        final String r38 = r21.getString("obric_startup_attempt_id");
        if (r38 == null) goto L86;
        if ((!StringsKt.isBlank(r38)) == false) goto L86;
    L87:
        r(r37, r38);
        if (r37 == null) goto L90;
        qaa.a r39 = (qaa.a) r37.getAbility(qaa.a.class);
    L91:
        if (r39 == null) goto L93;
        r39.Pp(null, true);
    L93:
        if (r37 == null) goto L95;
        laa.d r40 = (laa.d) r37.getAbility(laa.d.class);
    L96:
        if (r40 == null) goto L98;
        ObricFloatChatPageState r41 = r40.getPageState();
    L99:
        FLogger r42 = FLogger.a;
        String r43 = ISessionEndPoint.a.b(this);
        StringBuilder r112 = new StringBuilder("activateClickTalk: pageStateAbility is ");
        r112.append(r40);
        r112.append(", main bot is ");
        if (r40 == null) goto L102;
        Boolean r113 = Boolean.valueOf(r40.Da());
    L103:
        r112.append(r113);
        r112.append(", isVisible is ");
        if (r40 == null) goto L106;
        Boolean r114 = Boolean.valueOf(r40.isVisible());
    L107:
        r112.append(r114);
        r112.append(", curActivityLifecycleState = ");
        if (r34 == null) goto L112;
        Lifecycle r115 = r34.getLifecycle();
        if (r115 == null) goto L112;
        Lifecycle.State r116 = r115.getCurrentState();
    L113:
        r112.append(r116);
        r112.append(", currentActivity = ");
        r112.append(r34);
        r112.append(", pageState = ");
        r112.append(r41);
        r42.i(r43, r112.toString());
        if (r37 == null) goto L116;
        laa.f r44 = (laa.f) r37.getAbility(laa.f.class);
    L117:
        if (r40 != null) goto L119;
    L121:
        boolean r45 = false;
    L122:
        if (r45 == true) goto L124;
    L126:
        boolean r46 = false;
    L127:
        if (r44 != null) goto L129;
    L131:
        boolean r117 = false;
    L132:
        if (r36 != null) goto L134;
    L136:
        boolean r118 = false;
    L137:
        boolean r119 = !r118;
        int r47 = h1.a;
        int r48 = h1.a(bga.j.a(), -1);
        if (r117 == false) goto L141;
        if (r44 == null) goto L141;
        r44.p90();
    L141:
        ObricOneshotDelegate.b.b(0, this.b);
        if (r34 == null) goto L201;
        if (r46 == true) goto L145;
        if (r117 == false) goto L201;
    L145:
        r42.i(ISessionEndPoint.a.b(this), "use existing activity show click talk");
        if (r40 == null) goto L148;
        r40.Hd(false);
    L148:
        if (r37 == null) goto L154;
        de8.c r49 = r37.a(de8.c.class);
        if (r49 == null) goto L154;
        Bundle r50 = r49.b;
        if (r50 == null) goto L154;
        r50.remove("arg_long_press_ai");
    L154:
        if (r37 == null) goto L156;
        maa.e r51 = (maa.e) r37.getAbility(maa.e.class);
    L157:
        if (r37 == null) goto L159;
        com.obric.audio.continuous_talk.c r52 = (com.obric.audio.continuous_talk.c) r37.getAbility(com.obric.audio.continuous_talk.c.class);
    L160:
        if (r37 == null) goto L162;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r53 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r37.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
    L163:
        if (r53 != null) goto L165;
    L167:
        boolean r54 = false;
    L168:
        if (r54 == false) goto L183;
        r42.i(ISessionEndPoint.a.b(this), "activateClickTalk: is speaking now");
        r53.A9();
        if (r37 == null) goto L172;
        laa.f r55 = (laa.f) r37.getAbility(laa.f.class);
    L173:
        if (r55 != null) goto L175;
    L177:
        boolean r120 = false;
    L178:
        if (r120 == false) goto L183;
        r42.i(ISessionEndPoint.a.b(this), "activateClickTalk: show speaking loading");
        if (r55 == null) goto L183;
        r55.LL(null);
        goto L183
    L175:
        if (r55.kT() == true) goto L177;
        r120 = true;
        goto L178
    L172:
        r55 = null;
    L183:
        if (r46 == false) goto L189;
        if (r52 == null) goto L189;
        if (r52.qO(r48) == true) goto L189;
        com.obric.audio.continuous_talk.c.a.b(r52, r48, null, 6);
    L191:
        ISessionMaintaining r56 = bga.j.b();
        if (r56 == null) goto L376;
        if (r46 == false) goto L199;
        if (r119 == false) goto L199;
        IAssistantChatWindow r57 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r57 == null) goto L198;
        r57.dismissAllChildDialogs();
    L198:
        r56.n(r34);
        r56.f(r34);
    L199:
        r56.interruptMovingBackground();
        r56.c();
    L376:
        return true;
    L189:
        if (r51 == null) goto L191;
        maa.e.a.b(r51, r48, null, 6);
        goto L191
    L165:
        if (r53.m0() != true) goto L167;
        r54 = true;
        goto L168
    L162:
        r53 = null;
        goto L163
    L159:
        r52 = null;
        goto L160
    L156:
        r51 = null;
    L201:
        if (r1.a == true) goto L203;
        r42.i(ISessionEndPoint.a.b(this), "activateClickTalk: skip creating new activity");
        goto L388
    L203:
        r42.i(ISessionEndPoint.a.b(this), "create new activity show click talk");
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L206;
    L208:
        s();
        ISessionMaintaining r58 = bga.j.b();
        if (r58 == null) goto L376;
        if (r38 != null) goto L212;
    L218:
        Bundle r121 = null;
    L219:
        ISessionMaintaining.a.a(r58, r121, Boolean.TRUE, false, 21);
        goto L376
    L212:
        if ((!StringsKt.isBlank(r38)) == true) goto L215;
        r38 = null;
    L215:
        if (r38 == null) goto L218;
        r121 = new Bundle();
        r121.putString("obric_startup_attempt_id", r38);
        goto L219
    L206:
        if (t1.a.i() == true) goto L208;
        com.obric.assistant.spi.keyguard.a.a(new l0(this, r38), new m0(this, r38), null, false, 28);
        goto L376
    L134:
        if (r36.b == true) goto L136;
        r118 = true;
        goto L137
    L129:
        if (r44.xA() != true) goto L131;
        r117 = true;
        goto L132
    L124:
        if (r40.isVisible() == false) goto L126;
        r46 = true;
        goto L127
    L119:
        if (r40.Da() != true) goto L121;
        r45 = true;
        goto L122
    L116:
        r44 = null;
    L112:
        r116 = null;
        goto L113
    L106:
        r114 = null;
        goto L107
    L102:
        r113 = null;
        goto L103
    L98:
        r41 = null;
        goto L99
    L95:
        r40 = null;
        goto L96
    L90:
        r39 = null;
    L86:
        r38 = null;
    L77:
        if (r34 == null) goto L79;
        r37 = aga.j.g(r34);
        goto L80
    L79:
        r37 = null;
        goto L80
    L73:
        r36 = null;
        goto L74
    L60:
        r33 = null;
        goto L61
    L56:
        r32 = null;
        goto L57
    L53:
        r31 = null;
        goto L54
    L41:
        if (r17.contains(Integer.valueOf(r110.getTaskId())) == false) goto L43;
    L44:
        r28 = true;
        goto L46
    L43:
        if (r110.getTaskId() != 0) goto L45;
    L49:
        r26 = null;
        goto L50
    L62:
        Activity r59 = AppHost.a.a().getCurrentActivity();
        if ((r59 instanceof FragmentActivity) == true) goto L65;
        r59 = null;
    L65:
        r34 = (FragmentActivity) r59;
        goto L67
    L222:
        if ((r20 instanceof bga.a.c) == false) goto L378;
        r4.i(ISessionEndPoint.a.b(this), "activateTouchSpeak");
        if (j() == true) goto L226;
        r4.i(ISessionEndPoint.a.b(this), "activateTouchSpeak: checkIntercomConditionPass is false");
        goto L388
    L226:
        Lazy r60 = aga.j.a;
        if (Build.VERSION.SDK_INT < 29) goto L268;
        long r61 = System.currentTimeMillis();
        AppHost.Companion r62 = AppHost.a;
        Object r63 = r62.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r63, "null cannot be cast to non-null type android.app.ActivityManager");
        String r64 = r62.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r65 = ((ActivityManager) r63).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r65);
        ArrayList r66 = new ArrayList();
        Iterator<T> r67 = r65.iterator();
    L230:
        if (r67.hasNext() == false) goto L238;
        Object r68 = r67.next();
        ComponentName r122 = ((ActivityManager.RecentTaskInfo) r68).baseActivity;
        if (r122 == null) goto L234;
        String r123 = r122.getPackageName();
    L236:
        if (Intrinsics.areEqual(r123, r64) == false) goto L230;
        r66.add(r68);
        goto L230
    L234:
        r123 = null;
        goto L236
    L238:
        ArrayList r69 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r66, 10));
        Iterator r70 = r66.iterator();
    L240:
        if (r70.hasNext() == false) goto L242;
        r69.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r70.next()).taskId));
        goto L240
    L242:
        List r71 = AppHost.a.a().m();
        ListIterator r72 = r71.listIterator(r71.size());
    L244:
        if (r72.hasPrevious() == false) goto L255;
        Object r73 = r72.previous();
        Activity r74 = (Activity) r73;
        if ((r74 instanceof FragmentActivity) == true) goto L248;
    L252:
        boolean r75 = false;
    L253:
        if (r75 == false) goto L244;
    L256:
        Activity r76 = (FragmentActivity) r73;
        Activity r77 = AppHost.a.a().getCurrentActivity();
        FLogger r78 = FLogger.a;
        StringBuilder r124 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r124.append(r69);
        r124.append(",result=");
        r124.append(r76);
        r124.append(':');
        if ((r76 instanceof Activity) == false) goto L259;
        Activity r79 = r76;
    L260:
        if (r79 == null) goto L262;
        Integer r80 = Integer.valueOf(r79.getTaskId());
    L263:
        r124.append(r80);
        r124.append(", cur=");
        r124.append(r77);
        r124.append(':');
        if (r77 == null) goto L266;
        Integer r81 = Integer.valueOf(r77.getTaskId());
    L267:
        r124.append(r81);
        r124.append(",cost:");
        r124.append(System.currentTimeMillis() - r61);
        r78.d("AiIsland-SessionUtils", r124.toString());
    L273:
        if ((r76 instanceof FragmentActivity) == true) goto L276;
        r76 = null;
    L276:
        ObricInteractionServiceDelegate.b.b(r76);
        aga.j.a r82 = this.e;
        if (r82 == null) goto L280;
        t1a.b r83 = r82.a;
        if (r83 == null) goto L280;
    L283:
        if (r21 == null) goto L289;
        String r84 = r21.getString("obric_startup_attempt_id");
        if (r84 == null) goto L289;
        if ((!StringsKt.isBlank(r84)) == false) goto L289;
    L290:
        r(r83, r84);
        if (r83 == null) goto L293;
        laa.d r85 = (laa.d) r83.getAbility(laa.d.class);
    L294:
        if (r83 == null) goto L296;
        laa.f r86 = (laa.f) r83.getAbility(laa.f.class);
    L297:
        if (r85 == null) goto L299;
        ObricFloatChatPageState r87 = r85.getPageState();
    L300:
        if (r76 == null) goto L310;
        if (r85 != null) goto L303;
    L305:
        boolean r88 = false;
    L306:
        if (r88 == false) goto L310;
        if (v() == true) goto L310;
        boolean r125 = true;
    L311:
        if (r76 == null) goto L321;
        if (r86 != null) goto L314;
    L316:
        boolean r89 = false;
    L317:
        if (r89 == false) goto L321;
        if (v() == true) goto L321;
        boolean r90 = true;
    L322:
        if (r82 != null) goto L324;
    L326:
        boolean r126 = false;
    L327:
        boolean r91 = !r126;
        FLogger r92 = FLogger.a;
        r92.i(ISessionEndPoint.a.b(this), "activateTouchSpeak: currentActivity = " + r76 + ", isChatMainBot = " + r125 + ", canHandleInPlaceByIntercom = " + r90 + ", aiKeyInputContext = " + r82 + ", pageState = " + r87);
        if (r125 == true) goto L330;
        if (r90 == false) goto L388;
    L330:
        if (r83 == null) goto L334;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r93 = r83.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r93 == null) goto L334;
        r93.A4(this.g);
    L334:
        if (r83 == null) goto L336;
        maa.e r94 = (maa.e) r83.getAbility(maa.e.class);
    L337:
        Map r127 = t();
        if (r94 != null) goto L340;
    L342:
        boolean r95 = false;
    L343:
        if (r95 == false) goto L345;
        com.obric.audio.continuous_talk.c r96 = null;
        maa.e.a.a(r94, null, r127, false, 5);
    L346:
        if (r83 == null) goto L348;
        com.obric.audio.continuous_talk.c r128 = (com.obric.audio.continuous_talk.c) r83.getAbility(com.obric.audio.continuous_talk.c.class);
    L349:
        if (r128 == null) goto L354;
        if (r128.m0() != true) goto L354;
        boolean r97 = true;
    L355:
        if (r97 == false) goto L357;
        com.obric.audio.continuous_talk.c.a.a(r128, null, r127, false, true, 5);
    L357:
        IDoraOperation r98 = bga.f.a();
        if (r98 == null) goto L360;
        Integer r129 = r98.g();
    L361:
        if (r86 == null) goto L363;
        r86.B6(r84);
    L363:
        if (r86 == null) goto L365;
        r86.B20(false, r129, Long.valueOf(this.b));
    L365:
        ISessionMaintaining r99 = bga.j.b();
        if (r99 == null) goto L376;
        if (r91 == true) goto L369;
        r92.i(ISessionEndPoint.a.b(this), "activateTouchSpeak: keep current in-place input page");
    L375:
        r99.interruptMovingBackground();
        r99.c();
        goto L376
    L369:
        if (r125 == false) goto L374;
        IAssistantChatWindow r100 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r100 == null) goto L373;
        r100.dismissAllChildDialogs();
    L373:
        r99.n(r76);
        goto L375
    L374:
        r99.f(r76);
        goto L375
    L360:
        r129 = r96;
    L354:
        r97 = false;
        goto L355
    L348:
        r128 = r96;
        goto L349
    L345:
        r96 = null;
        goto L346
    L340:
        if (r94.x3() != true) goto L342;
        r95 = true;
        goto L343
    L336:
        r94 = null;
        goto L337
    L324:
        if (r82.b == true) goto L326;
        r126 = true;
        goto L327
    L314:
        if (r86.xA() != true) goto L316;
        r89 = true;
    L321:
        r90 = false;
        goto L322
    L303:
        if (r85.Da() != true) goto L305;
        r88 = true;
    L310:
        r125 = false;
        goto L311
    L299:
        r87 = null;
        goto L300
    L296:
        r86 = null;
        goto L297
    L293:
        r85 = null;
    L289:
        r84 = null;
    L280:
        if (r76 == null) goto L282;
        r83 = aga.j.g(r76);
        goto L283
    L282:
        r83 = null;
        goto L283
    L266:
        r81 = null;
        goto L267
    L262:
        r80 = null;
        goto L263
    L259:
        r79 = null;
        goto L260
    L248:
        if (r69.contains(Integer.valueOf(r74.getTaskId())) == false) goto L250;
    L251:
        r75 = true;
        goto L253
    L250:
        if (r74.getTaskId() != 0) goto L252;
    L255:
        r73 = null;
        goto L256
    L268:
        Activity r101 = AppHost.a.a().getCurrentActivity();
        if ((r101 instanceof FragmentActivity) == true) goto L271;
        r101 = null;
    L271:
        r76 = (FragmentActivity) r101;
        goto L273
    L378:
        if ((r20 instanceof bga.a.C0002a) == false) goto L391;
        r4.i(ISessionEndPoint.a.b(this), "activateChatWindow: startClickTalk = " + ((bga.a.C0002a) r20).a);
        if (j() == true) goto L382;
        r4.i(ISessionEndPoint.a.b(this), "activateTouchSpeak: checkIntercomConditionPass is false");
        goto L388
    L382:
        AppHost.Companion r102 = AppHost.a;
        if (r102.isTestChannel() == false) goto L385;
    L386:
        com.larus.utils.t0.e(new n0());
    L387:
        r4.w(ISessionEndPoint.a.b(this), "activateChatWindow: not support now");
        goto L388
    L385:
        if (r102.isDebugChannel() == false) goto L387;
    L391:
        throw new NoWhenBranchMatchedException();
    }
}
