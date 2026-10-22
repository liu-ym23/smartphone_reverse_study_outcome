package com.obric.assistant.live.api;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.aiagent.assistant.idl.f;
import com.obric.assistant.audio.service.IObricAssistantForAudio;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.OnKeyguardLockStateChangedListener;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.live.island.ComplexTaskQueueingAndCompletionIslandMonitor;
import com.obric.assistant.live.island.k;
import com.obric.assistant.live.island.p;
import com.obric.assistant.live.island.q;
import com.obric.assistant.live.island.r;
import com.obric.assistant.live.island.t;
import com.obric.assistant.live.island.u;
import com.obric.assistant.live.receiver.ObricLiveReceiver;
import com.obric.assistant.live.template.IObricTemplate;
import com.obric.assistant.live.template.ObricAINotificationTemplateIcon;
import com.obric.assistant.live.template.ObricAINotificationTemplateText;
import com.obric.assistant.live.template.ObricComplexTaskExpandedTemplate;
import com.obric.assistant.live.template.ObricExpandedDialogueActionButton;
import com.obric.assistant.live.template.ObricExpandedDialogueTemplate;
import com.obric.assistant.live.util.ObricIslandType;
import com.obric.assistant.live.util.ObricUpdateBtnEvent;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.system.ITaskStackService;
import com.obric.assistant.t1;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.RuntimeState;
import com.obric.livecard.api.entity.SceneType;
import com.obric.livecard.api.entity.TaskSceneEntity;
import com.obric.livecard.api.entity.Text;
import com.obric.livecard.api.island.IslandApi;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import sea.a0;
import sea.b0;
import sea.g;
import sea.g0;
import sea.h0;
import sea.i0;
import sea.j0;
import sea.w;
import sea.x;
import sea.y;
import waa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricLiveCardStrategy implements a {
    public static final ObricLiveCardStrategy a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<String, Job> c = null;
    public static boolean d;
    public static final AtomicLong e = null;
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, AtomicReference<IslandSession>>> f = null;
    public static final ConcurrentHashMap<String, String> g = null;
    public static final ConcurrentHashMap<String, ObricIslandCreateScene> h = null;
    public static final e i = null;
    public static final AtomicBoolean j = null;
    public static final AtomicBoolean k = null;
    public static final AtomicBoolean l = null;
    public static final AtomicBoolean m = null;
    public static final AtomicBoolean n = null;
    public static final c o = null;
    public static boolean p;
    public static final AtomicBoolean q = null;
    public static boolean r;

    /* JADX INFO: renamed from: com.obric.assistant.live.api.ObricLiveCardStrategy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.live.api.ObricLiveCardStrategy$1", f = "ObricLiveApi.kt", i = {}, l = {695}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.live.api.ObricLiveCardStrategy$1$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r3, Continuation r4) {
                if (((Boolean) r3).booleanValue() == false) goto L11;
                ObricLiveCardStrategy r5 = ObricLiveCardStrategy.a;
                r5.getClass();
                FLogger.a.i("ObricLiveDelegate", "refreshQuitDialogueModeFlagsOnDismissingKeyguard");
                if (r5.e() == false) goto L11;
                if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L11;
                r5.j();
            L11:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            i1<Boolean> r5 = KeyguardService.a.isDismissingKeyguard();
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r5.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class b implements oga.b {
        public b() {
        }

        @Override // oga.b
        public final void onRequestDismissKeyguard() {
        }

        @Override // oga.b
        public final void onDismissFailed(boolean r10) {
            FLogger r11 = FLogger.a;
            r11.i("ObricLiveDelegate", "dismissKeyguardStatusListener onDismissFailed");
            ObricLiveCardStrategy r1 = ObricLiveCardStrategy.a;
            r1.getClass();
            AtomicBoolean r2 = ObricLiveCardStrategy.m;
            if (r2.get() == false) goto L22;
            ObricState r3 = ObricLiveServiceDelegate.b.k();
            if (r3 != null) goto L8;
            r11.i("ObricLiveDelegate", "restoreDialogueModeOnDismissFailed skipped, currentState is null");
            goto L22
        L8:
            ObricIslandStateType r5 = r3.getCurrentIslandState();
            ObricIslandStateType r6 = ObricIslandStateType.COMPLEX_TASK_ASK_USER;
            if (r5 != r6) goto L11;
        L13:
            if (r5 == r6) goto L15;
        L17:
            IslandSession r7 = ObricLiveCardStrategy.A("complex_task", r3.getConversationId());
            StringBuilder r8 = new StringBuilder("restoreDialogueModeOnDismissFailed rebuild complex task session directly, state = ");
            r8.append(r5);
            r8.append(", hasOldSession = ");
            if (r7 == null) goto L20;
            boolean r9 = true;
        L21:
            r8.append(r9);
            r11.i("ObricLiveDelegate", r8.toString());
            r1.D(r7, r3, AppHost.a.getApplication().getApplicationContext());
            goto L22
        L20:
            r9 = false;
            goto L21
        L15:
            if (ObricLiveCardStrategy.n.get() == false) goto L17;
            r11.i("ObricLiveDelegate", "restoreDialogueModeOnDismissFailed restore by enterDialogue");
            g.a.getClass();
            g.c("dynamic_island");
            goto L22
        L11:
            if (r5 == ObricIslandStateType.COMPLEX_TASK_CALL_USER) goto L13;
            r11.i("ObricLiveDelegate", "restoreDialogueModeOnDismissFailed skipped, currentIslandState = " + r5);
        L22:
            r2.set(false);
            ObricLiveCardStrategy.n.set(false);
            sea.e.a(null);
        }

        @Override // oga.b
        public final void onDismissSucceeded(boolean r3) {
            FLogger.a.i("ObricLiveDelegate", "dismissKeyguardStatusListener onDismissSucceeded");
            ObricLiveCardStrategy.a.getClass();
            ObricLiveCardStrategy.m.set(false);
            ObricLiveCardStrategy.n.set(false);
        }
    }

    public static final class c implements IslandCardCallback {
        public c() {
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public final void onSessionActive(IslandSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public final void onSessionDestroy(IslandSession r1, Integer r2) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public final void onSessionDisplayStatusChanged(IslandSession r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public final void onSessionInactive(IslandSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public final Bundle onWidgetShow(IslandWidget r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            return null;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public final void onSessionCreate(IslandSession r5) {
            Intrinsics.checkNotNullParameter(r5, "session");
            JsonObject r0 = r5.getExt();
            ObricIslandStateType r1 = null;
            if (r0 == null) goto L7;
            JsonElement r2 = r0.get("obric_island_type");
            if (r2 == null) goto L7;
            String r3 = r2.getAsString();
        L9:
            if (Intrinsics.areEqual(r3, "complex_task") == false) goto L26;
            String r6 = ObricLiveCardStrategy.t(ObricLiveCardStrategy.a, r5);
            boolean r4 = false;
            if (r6 == null) goto L21;
            ObricState r7 = ObricLiveServiceDelegate.b.h("complex_task", r6);
            if (r7 == null) goto L16;
            r1 = r7.getCurrentIslandState();
        L16:
            if (r1 != ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L18;
            boolean r8 = true;
        L19:
            if (r8 != true) goto L21;
            r4 = true;
            goto L21
        L18:
            r8 = false;
        L21:
            if (r4 == false) goto L27;
            FLogger.a.i("ObricLiveDelegate", "onSessionCreate in ask user, register task stack listener");
            ITaskStackService r9 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
            if (r9 == null) goto L28;
            r9.d(ObricLiveCardStrategy.i);
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L7:
            r3 = null;
            goto L9
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public final void onSessionStatusChanged(IslandSession r25, int r26) {
            Intrinsics.checkNotNullParameter(r25, "session");
            FLogger r2 = FLogger.a;
            r2.i("ObricLiveDelegate", "onSessionStatusChanged session: " + r25 + ", status: " + r26);
            JsonObject r3 = r25.getExt();
            ObricIslandStateType r5 = null;
            if (r3 == null) goto L7;
            JsonElement r4 = r3.get("obric_island_type");
            if (r4 == null) goto L7;
            String r6 = r4.getAsString();
        L9:
            if (Intrinsics.areEqual(r6, "complex_task") == false) goto L39;
            ObricLiveCardStrategy r7 = ObricLiveCardStrategy.a;
            if (ObricLiveCardStrategy.t(r7, r25) == null) goto L40;
            boolean r8 = false;
            if (r26 != (-1)) goto L34;
            r2.i("ObricLiveDelegate", "onSessionStatusChanged notifyAssistantState enter");
            String r1 = ObricLiveCardStrategy.t(r7, r25);
            if (r1 == null) goto L25;
            ObricState r9 = ObricLiveServiceDelegate.b.h("complex_task", r1);
            if (r9 == null) goto L20;
            r5 = r9.getCurrentIslandState();
        L20:
            if (r5 != ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L22;
            boolean r10 = true;
        L23:
            if (r10 != true) goto L25;
            r8 = true;
            goto L25
        L22:
            r10 = false;
        L25:
            if (r8 == true) goto L27;
        L33:
            ObricLiveCardStrategy.k.set(true);
            return;
        L27:
            if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L33;
            ISpecialInputTask r11 = com.obric.assistant.special_input.c.a();
            if (r11 == null) goto L33;
            String r12 = ObricIslandType.COMPLEX_TASK.getValue();
            Boolean r13 = Boolean.TRUE;
            r11.b(r12, r13, StateInfo.copy$default(com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, null, null, null, 30), 0, null, null, null, 0, true, false, null, 223, null));
            if (Intrinsics.areEqual(r25.getCanFrontShow(), Boolean.FALSE) == false) goto L33;
            r25.setCanFrontShow(r13);
            r25.setFlags((i0.p(ObricInteractionScene.COMPLEX_TASK_SCENE) | 72) | 4096);
            r25.updateFlags();
            goto L33
        L34:
            ObricLiveCardStrategy.q.set(false);
            AtomicBoolean r0 = ObricLiveCardStrategy.k;
            if (r0.get() == false) goto L37;
            r7.f(ObricLiveCardStrategy.p);
        L37:
            r0.set(false);
            ObricLiveCardStrategy.p = false;
            ObricLiveCardStrategy.r = false;
            return;
        L40:
            return;
        L39:
            return;
        L7:
            r6 = null;
            goto L9
        }
    }

    public static final class d implements OnKeyguardLockStateChangedListener {
        public d() {
        }

        public final void onKeyguardLockStateChanged(boolean r4) {
            ObricLiveCardStrategy.a.K("complex_task");
            if (r4 == true) goto L11;
            Iterator<T> r5 = ObricLiveCardStrategy.h.keySet().iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            String r0 = (String) r5.next();
            ObricLiveCardStrategy.h.put(r0, ObricIslandCreateScene.KEYGUARD_UNLOCKED);
            ObricLiveCardStrategy r1 = ObricLiveCardStrategy.a;
            Intrinsics.checkNotNull(r0);
            r1.K(r0);
            goto L6
        L8:
            ObricLiveServiceDelegate.b.m();
            return;
        }
    }

    public static final class e implements lha.g {
        public e() {
        }

        @Override // lha.g
        public final void onTaskCreated(int r1, ComponentName r2) {
        }

        @Override // lha.g
        public final void onChange(ComponentName r8, ComponentName r9) {
            FLogger.a.i("ObricLiveDelegate", "on task stack changed to " + r9);
            ConcurrentHashMap<String, AtomicReference<IslandSession>> r10 = ObricLiveCardStrategy.f.get("complex_task");
            if (r10 == null) goto L32;
            Collection<AtomicReference<IslandSession>> r11 = r10.values();
            if (r11 == null) goto L47;
            ArrayList r0 = new ArrayList();
            Iterator<T> r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L12;
            IslandSession r2 = (IslandSession) ((AtomicReference) r12.next()).get();
            if (r2 == null) goto L8;
            r0.add(r2);
            goto L8
        L12:
            Iterator r13 = r0.iterator();
        L14:
            if (r13.hasNext() == false) goto L48;
            IslandSession r1 = (IslandSession) r13.next();
            if (Intrinsics.areEqual(r1.getCanFrontShow(), Boolean.TRUE) == false) goto L14;
            if (r9 == null) goto L20;
            String r3 = r9.getPackageName();
        L22:
            if (Intrinsics.areEqual(r3, AppHost.a.getApplication().getPackageName()) == false) goto L14;
            boolean r4 = false;
            if (r9 == null) goto L30;
            String r5 = r9.getClassName();
            if (r5 == null) goto L30;
            if (StringsKt.startsWith$default(r5, "com.obric.autoaction", false, 2, null) != true) goto L30;
            r4 = true;
        L30:
            if (r4 == false) goto L14;
            FLogger.a.i("ObricLiveDelegate", "cancel front show");
            r1.setCanFrontShow(Boolean.FALSE);
            r1.setFlags(r1.getFlags() | 64);
            r1.updateFlags();
            goto L14
        L20:
            r3 = null;
            goto L22
        L48:
            return;
        L47:
            return;
        }
    }

    public ObricLiveCardStrategy() {
    }

    public final void k() {
        x(false);
    }

    static {
        a = new ObricLiveCardStrategy();
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        b = r3;
        c = new ConcurrentHashMap();
        e = new AtomicLong(0);
        ConcurrentHashMap<String, ConcurrentHashMap<String, AtomicReference<IslandSession>>> r0 = new ConcurrentHashMap();
        r0.put("simple_task", new ConcurrentHashMap());
        r0.put("aigc_generation", new ConcurrentHashMap());
        r0.put("complex_task", new ConcurrentHashMap());
        r0.put("directly_answer", new ConcurrentHashMap());
        f = r0;
        g = new ConcurrentHashMap();
        ObricIslandCreateScene r8 = ObricIslandCreateScene.KEYGUARD_UNLOCKED;
        h = new ConcurrentHashMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("simple_task", r8), TuplesKt.to("aigc_generation", r8), TuplesKt.to("complex_task", r8)}));
        i = new e();
        j = new AtomicBoolean(true);
        k = new AtomicBoolean(false);
        l = new AtomicBoolean(false);
        m = new AtomicBoolean(false);
        n = new AtomicBoolean(false);
        b r1 = new b();
        d r2 = new d();
        o = new c();
        q = new AtomicBoolean(false);
        ILiveCard.Companion.getInst().init(AppHost.a.getApplication());
        if (Build.VERSION.SDK_INT < 33) goto L5;
        IKeyguardStateKt.getKeyguardState().registerKeyguardLockStateChangedListener(r2);
    L5:
        KeyguardService.a.registerDismissKeyguardChangedListener(r1);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass1(null), 3, null);
    }

    public static boolean C() {
        if (ILiveCard.Companion.getInst().getVersion(AppHost.a.getApplication().getApplicationContext()) < 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final void J() {
        IslandSession r0 = y("complex_task");
        if (r0 == null) goto L21;
        IslandWidget r1 = r0.getExpandWidget();
        if (r1 == null) goto L22;
        Object r2 = r1.getTemplateData();
        ObricExpandedDialogueActionButton r4 = null;
        if ((r2 instanceof ObricComplexTaskExpandedTemplate) == false) goto L9;
        ObricComplexTaskExpandedTemplate r5 = (ObricComplexTaskExpandedTemplate) r2;
    L10:
        if (r5 == null) goto L23;
        ObricExpandedDialogueTemplate r6 = r5.getDialogue();
        if (r6 == null) goto L19;
        ObricExpandedDialogueTemplate r3 = r5.getDialogue();
        if (r3 == null) goto L18;
        ObricExpandedDialogueActionButton r8 = r3.getActionBtn();
        if (r8 == null) goto L18;
        r4 = ObricExpandedDialogueActionButton.copy$default(r8, null, null, null, null, null, null, 55, null);
    L18:
        r4 = ObricExpandedDialogueTemplate.copy$default(r6, null, r4, null, null, null, null, 61, null);
    L19:
        r1.setTemplateData(ObricComplexTaskExpandedTemplate.copy$default(r5, r4, null, null, 6, null));
        FLogger.a.i("ObricLiveDelegate", "update dismissKeyguard finished");
        r0.update(r1);
        return;
    L23:
        return;
    L9:
        r5 = null;
        goto L10
    L22:
        return;
    }

    public final boolean a() {
        if (ILiveCard.Companion.getInst().getVersion(AppHost.a.getApplication().getApplicationContext()) < 4) goto L5;
        return true;
    L5:
        return false;
    }

    public final void collapseNotificationPanel() {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.collapseNotificationPanel();
        return;
    }

    public final boolean e() {
        return k.get();
    }

    public final void init() {
        ComplexTaskQueueingAndCompletionIslandMonitor.a.getClass();
        ILiveCard.Companion.getInst().init(AppHost.a.getApplication());
        a.getClass();
        boolean r0 = C();
        FLogger.a.i("ComplexTaskQueueingAndCompletionIslandMonitor", "sceneFeatureEnabled: " + r0);
        if (r0 == false) goto L7;
        f.b(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class), new k());
        return;
    }

    public final void p() {
        FLogger.a.i("ObricLiveDelegate", "setClickFromIsland isFromIsland: true");
        p = true;
    }

    public final void b() {
        if (e() == false) goto L6;
        J();
        return;
    }

    public final void i() {
        boolean r1 = false;
        if (e() == true) goto L6;
        m.set(false);
        n.set(false);
        FLogger.a.i("ObricLiveDelegate", "prepareRestoreDialogueModeOnDismissFailed skipped, not in dialogue mode");
        return;
    L6:
        ObricState r0 = ObricLiveServiceDelegate.b.k();
        if (r0 == null) goto L9;
        ObricIslandStateType r2 = r0.getCurrentIslandState();
    L10:
        ObricIslandStateType r3 = ObricIslandStateType.COMPLEX_TASK_ASK_USER;
        if (r2 != r3) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r2 != r3) goto L26;
        IObricAssistantForAudio r4 = (IObricAssistantForAudio) ServiceManager.get().getService(IObricAssistantForAudio.class);
        if (r4 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L26;
        r1 = true;
        goto L26
    L21:
        if (r4.O4() != true) goto L23;
        r6 = true;
    L26:
        m.set(r5);
        n.set(r1);
        FLogger.a.i("ObricLiveDelegate", "prepareRestoreDialogueModeOnDismissFailed state=" + r2 + ", shouldRestoreDialogue=" + r5 + ", shouldRestoreInput=" + r1);
        return;
    L13:
        if (r2 == ObricIslandStateType.COMPLEX_TASK_CALL_USER) goto L16;
        r5 = false;
        goto L17
    L9:
        r2 = null;
        goto L10
    }

    public final void j() {
        if (e() == true) goto L8;
        FLogger.a.i("ObricLiveDelegate", "quitDialogueModeAndCollapse not in dialog mode, collapse island");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L12;
        r0.collapseIsland();
        return;
    L12:
        return;
    L8:
        IslandSession r1 = y("complex_task");
        FLogger r2 = FLogger.a;
        r2.i("ObricLiveDelegate", "quitDialogueModeAndCollapse session: " + r1);
        if (r1 == null) goto L13;
        r2.i("ObricLiveDelegate", "quitDialogueModeAndCollapse set session flags to FLAG_QUIT_DIALOGUE_MODE_AND_COLLAPSE");
        p = true;
        q.set(false);
        r1.setCanFrontShow(Boolean.FALSE);
        r1.setFlags((i0.p(ObricInteractionScene.COMPLEX_TASK_SCENE) | 16) | 4096);
        r1.updateFlags();
        return;
    }

    public static List E(String r5) {
        ConcurrentHashMap<String, AtomicReference<IslandSession>> r0 = f.get(r5);
        if (r0 == null) goto L5;
        Collection<AtomicReference<IslandSession>> r1 = r0.values();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        IslandSession r4 = (IslandSession) ((AtomicReference) r3.next()).getAndSet(null);
        if (r4 == null) goto L8;
        r2.add(r4);
        goto L8
    L12:
        r0.clear();
        g.remove(r5);
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    public static IslandSession y(String r1) {
        String r0 = g.get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return A(r1, r0);
    }

    public final void K(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        FLogger r0 = FLogger.a;
        r0.i("ObricLiveDelegate", "updateSessionFlags, scene: " + r5 + ", isRealtimeCallScene: " + d);
        if (d == true) goto L5;
        return;
    L5:
        int r1 = r5.hashCode();
        if (r1 == (-1418855438)) goto L21;
        if (r1 == (-300091468)) goto L17;
        if (r1 == (-207846093)) goto L13;
    L22:
        IslandSession r6 = null;
    L26:
        if (r6 != null) goto L29;
        return;
    L29:
        if (t1.a.i() == false) goto L32;
        r0.i("ObricLiveDelegate", "is locked screen use enabled, add dismiss keyguard flags");
        r6.setFlags(r6.getFlags() | 256);
        r6.updateFlags();
        return;
    L32:
        r6.setFlags(r6.getFlags() & (-257));
        r6.updateFlags();
        return;
    L13:
        if (r5.equals("aigc_generation") == false) goto L22;
        r6 = y("aigc_generation");
        goto L26
    L17:
        if (r5.equals("complex_task") == false) goto L22;
        r6 = y("complex_task");
        goto L26
    L21:
        if (r5.equals("simple_task") == false) goto L22;
        r6 = y("simple_task");
        if (r6 != null) goto L26;
        r6 = y("directly_answer");
        goto L26
    }

    public final boolean c(ObricInteractionScene r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        int r0 = a.b[r6.ordinal()];
        if (r0 != 1) goto L5;
        ObricIslandCreateScene r7 = h.get("complex_task");
        if (r7 != null) goto L41;
        return false;
    L41:
        if (r7.isKeyguardLockedScene() != true) goto L49;
    L42:
        return true;
    L49:
        return false;
    L5:
        if (r0 != 2) goto L7;
    L18:
        ConcurrentHashMap<String, ObricIslandCreateScene> r1 = h;
        ObricInteractionScene r3 = ObricInteractionScene.AIGC_GENERATION_SCENE;
        if (r6 != r3) goto L21;
        String r4 = "aigc_generation";
    L22:
        ObricIslandCreateScene r5 = r1.get(r4);
        if (r5 != null) goto L25;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == true) goto L42;
        if (r6 == r3) goto L46;
        ObricIslandCreateScene r9 = r1.get("directly_answer");
        if (r9 != null) goto L33;
    L35:
        boolean r10 = false;
    L36:
        if (r10 == true) goto L42;
        return false;
    L33:
        if (r9.isKeyguardLockedScene() != true) goto L35;
        r10 = true;
        goto L36
    L46:
        return false;
    L25:
        if (r5.isKeyguardLockedScene() != true) goto L27;
        r8 = true;
        goto L28
    L21:
        r4 = "simple_task";
        goto L22
    L7:
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L11;
        ObricIslandCreateScene r11 = h.get("realtime_call");
        if (r11 != null) goto L16;
        return false;
    L16:
        if (r11.isKeyguardLockedScene() == true) goto L42;
        return false;
    L11:
        if (r0 == 5) goto L18;
        return false;
    }

    public final void f(boolean r6) {
        ISpecialInputTask r0 = com.obric.assistant.special_input.c.a();
        if (r0 == null) goto L9;
        FLogger.a.i("ObricLiveDelegate", "onSessionStatusChanged notifyAssistantState quit");
        ObricIslandType r1 = ObricIslandType.COMPLEX_TASK;
        r0.b(r1.getValue(), Boolean.FALSE, null);
        if (r6 == true) goto L9;
        ISpecialInputTask r7 = com.obric.assistant.special_input.c.a();
        if (r7 == null) goto L9;
        r7.closeAssistantInputPanel(r1.getValue());
    L9:
        ObricFloatChatPageData.a r8 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r2 = (ObricFloatChatPageState) a.b.getValue();
        r8.getClass();
        if (ObricFloatChatPageData.a.d(r2) == false) goto L13;
        a.a.a(this, false, 3);
    L15:
        k.set(false);
        p = false;
        r = false;
        return;
    L13:
        if (e() == true) goto L15;
        l(false);
        goto L15
    }

    public final void g(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (com.larus.bmhome.chat.bean.d.T(r5) == false) goto L5;
        return;
    L5:
        Map r6 = r5.getExt();
        if (r6 == null) goto L8;
        String r7 = (String) r6.get("o_task_type");
    L9:
        String r0 = "complex_task";
        if (Intrinsics.areEqual(r7, "complex_task") == true) goto L13;
        r0 = "simple_task";
    L13:
        ConcurrentHashMap<String, ObricIslandCreateScene> r8 = h;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L16;
        ObricIslandCreateScene r1 = ObricIslandCreateScene.KEYGUARD_LOCKED;
    L17:
        r8.put(r0, r1);
        FLogger.a.i("ObricLiveDelegate", "setCreateSceneByTag tag: " + r0 + ", createScene: " + r8.get(r0));
        return;
    L16:
        r1 = ObricIslandCreateScene.KEYGUARD_UNLOCKED;
        goto L17
    L8:
        r7 = null;
        goto L9
    }

    public final void l(boolean r2) {
        if (q.get() == false) goto L5;
        return;
    L5:
        r(r2);
    }

    public final void m(boolean r10) {
        if (r != r10) goto L5;
        return;
    L5:
        r = r10;
        IslandSession r0 = y("complex_task");
        if (r0 == null) goto L15;
        IslandWidget r1 = r0.getExpandWidget();
        if (r1 == null) goto L16;
        FLogger.a.i("ObricLiveDelegate", "sendUpdateEvent, disabled: " + r10);
        Gson r2 = z.a;
        ObricTaskStatusManager.a.getClass();
        String r11 = z.c(new ObricUpdateBtnEvent(ObricTaskStatusManager.a(), Boolean.valueOf(r10), null, 4, null));
        if (r11 == null) goto L12;
        JsonObject r12 = JsonParser.parseString(r11).getAsJsonObject();
    L13:
        r0.sendEvent(r1, "update_button", r12);
        return;
    L12:
        r12 = null;
        goto L13
    L16:
        return;
    }

    public final void q(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        FLogger.a.i("ObricLiveDelegate", "destroyAllLiveCard");
        u("aigc_end_state_showing_task");
        sea.e.c(false);
        ObricLiveServiceDelegate.b.e();
        List r0 = E("complex_task");
        List r1 = E("simple_task");
        List r2 = E("aigc_generation");
        List r3 = E("directly_answer");
        Iterator r4 = r0.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        IslandSession r5 = (IslandSession) r4.next();
        IslandApi r6 = ILiveCard.Companion.getInst().getIslandService();
        if (r6 == null) goto L8;
        r6.destroySession(r5);
    L8:
        ObricLiveCardStrategy r8 = a;
        if (r8.e() == false) goto L4;
        r8.f(false);
        goto L4
    L11:
        Iterator r9 = r1.iterator();
    L13:
        if (r9.hasNext() == false) goto L17;
        IslandSession r10 = (IslandSession) r9.next();
        IslandApi r11 = ILiveCard.Companion.getInst().getIslandService();
        if (r11 == null) goto L13;
        r11.destroySession(r10);
        goto L13
    L17:
        Iterator r12 = r2.iterator();
    L19:
        if (r12.hasNext() == false) goto L23;
        IslandSession r13 = (IslandSession) r12.next();
        IslandApi r14 = ILiveCard.Companion.getInst().getIslandService();
        if (r14 == null) goto L19;
        r14.destroySession(r13);
        goto L19
    L23:
        Iterator r15 = r3.iterator();
    L25:
        if (r15.hasNext() == false) goto L29;
        IslandSession r16 = (IslandSession) r15.next();
        IslandApi r17 = ILiveCard.Companion.getInst().getIslandService();
        if (r17 == null) goto L25;
        r17.destroySession(r16);
        goto L25
    L29:
        d = false;
        q.set(false);
        k.set(false);
        p = false;
        r = false;
        if (C() == false) goto L47;
        ComplexTaskQueueingAndCompletionIslandMonitor.a.getClass();
        FLogger.a.i("ComplexTaskQueueingAndCompletionIslandMonitor", "destroyAllLiveCard");
        p r18 = ComplexTaskQueueingAndCompletionIslandMonitor.b;
        r18.d.clear();
        q r19 = r18.c;
        List r20 = CollectionsKt.toList(r19.a.values());
        r19.a.clear();
        int r21 = com.obric.assistant.live.island.j.a;
        Iterator r22 = r20.iterator();
    L33:
        if (r22.hasNext() == false) goto L35;
        com.obric.assistant.live.island.j.f((IslandSession) r22.next());
        goto L33
    L35:
        com.obric.assistant.live.island.g r23 = ComplexTaskQueueingAndCompletionIslandMonitor.c;
        r23.getClass();
        FLogger.a.i("ComplexTaskCompletedIslandModule", "destroyAllLiveCard");
        List r24 = r23.d.b();
        int r25 = com.obric.assistant.live.island.j.a;
        Iterator r26 = r24.iterator();
    L37:
        if (r26.hasNext() == false) goto L39;
        com.obric.assistant.live.island.j.f((IslandSession) r26.next());
        goto L37
    L39:
        Object r27 = r23.c;
        monitor-enter(r27);
        r23.b.evictAll();     // Catch: Throwable -> L44
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r27);
        return;
    L44:
        th = move-exception;
        throw th;
    }

    public final void r(boolean r6) {
        IslandSession r0 = y("complex_task");
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.getCanFrontShow(), Boolean.TRUE);
    L6:
        if (r1 == false) goto L9;
        r0.setCanFrontShow(Boolean.valueOf(r6));
        r0.setFlags((i0.p(ObricInteractionScene.COMPLEX_TASK_SCENE) | 64) | 4096);
        r0.updateFlags();
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean s(ObricInteractionScene r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        FLogger.a.i("ObricLiveDelegate", "isCreateSceneDeviceLocked, scene: " + r4);
        if (a.b[r4.ordinal()] == 4) goto L5;
        return false;
    L5:
        if (t1.a.i() == true) goto L7;
    L8:
        return true;
    L7:
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == false) goto L8;
        return false;
    }

    public final void u(String r4) {
        FLogger.a.i("ObricLiveDelegate", "cancelTimer");
        Job r5 = c.remove(r4);
        if (r5 == null) goto L6;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
        return;
    }

    public final void x(boolean r9) {
        IslandSession r0 = y("complex_task");
        if (r0 == null) goto L15;
        FLogger r1 = FLogger.a;
        r1.i("ObricLiveDelegate", "enterDialogType session: " + r0);
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L10;
        if (r9 == true) goto L10;
        r1.i("ObricLiveDelegate", "enterDialogType skipped because keyguard is locked");
        return;
    L10:
        if ((r0.getFlags() & 8) == 0) goto L13;
        r1.i("ObricLiveDelegate", "current session is in dialog mode");
        return;
    L13:
        r1.i("ObricLiveDelegate", "enterDialogType set session flags to dialog mode");
        q.set(true);
        r0.setCanFrontShow(Boolean.TRUE);
        r0.setFlags((i0.p(ObricInteractionScene.COMPLEX_TASK_SCENE) | 72) | 4096);
        r0.updateFlags();
        a.J();
        return;
    }

    public static IslandSession A(String r1, String r2) {
        ConcurrentHashMap<String, AtomicReference<IslandSession>> r3 = f.get(r1);
        if (r3 == null) goto L7;
        AtomicReference<IslandSession> r4 = r3.get(r2);
        if (r4 == null) goto L7;
        return r4.get();
    L7:
        return null;
    }

    public static AtomicReference B(String r2, String r3) {
        ConcurrentHashMap<String, AtomicReference<IslandSession>> r4 = f.get(r2);
        if (r4 != null) goto L5;
        return null;
    L5:
        AtomicReference<IslandSession> r1 = r4.get(r3);
        if (r1 == null) goto L8;
        return r1;
    L8:
        AtomicReference<IslandSession> r5 = new AtomicReference(null);
        AtomicReference<IslandSession> r6 = r4.putIfAbsent(r3, r5);
        if (r6 != null) goto L12;
        return r5;
    L12:
        return r6;
    }

    public static IslandSession F(String r4, String r5) {
        ConcurrentHashMap<String, AtomicReference<IslandSession>> r0 = f.get(r4);
        IslandSession r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r5 != null) goto L9;
        r5 = g.get(r4);
        if (r5 != null) goto L9;
        return null;
    L9:
        AtomicReference<IslandSession> r2 = r0.remove(r5);
        if (r2 == null) goto L12;
        r1 = r2.getAndSet(null);
    L12:
        ConcurrentHashMap<String, String> r3 = g;
        if (Intrinsics.areEqual(r3.get(r4), r5) == false) goto L18;
        String r6 = (String) CollectionsKt.firstOrNull(r0.keySet());
        if (r6 == null) goto L17;
        r3.put(r4, r6);
        goto L18
    L17:
        r3.remove(r4);
    L18:
        return r1;
    }

    public static final String t(ObricLiveCardStrategy r3, IslandSession r4) {
        r3.getClass();
        ConcurrentHashMap<String, AtomicReference<IslandSession>> r5 = f.get("complex_task");
        if (r5 == null) goto L25;
        Set<Map.Entry<String, AtomicReference<IslandSession>>> r6 = r5.entrySet();
        if (r6 == null) goto L26;
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L15;
        Object r1 = r7.next();
        if (((AtomicReference) ((Map.Entry) r1).getValue()).get() != r4) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L8;
    L16:
        Map.Entry r8 = (Map.Entry) r1;
        if (r8 != null) goto L19;
        return null;
    L19:
        return (String) r8.getKey();
    L12:
        r2 = false;
        goto L13
    L15:
        r1 = null;
        goto L16
    L26:
        return null;
    L25:
        return null;
    }

    public final void I(ObricState r17, Context r18) {
        IslandSession r3 = A("complex_task", r17.getConversationId());
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("updateComplexTaskSession, state=");
        r6.append(r17.getCurrentIslandState());
        r6.append(", sourceMessageId=");
        r6.append(r17.getSourceMessageId());
        r6.append(", currentSession=");
        boolean r8 = true;
        if (r3 == null) goto L5;
        boolean r9 = true;
    L6:
        r6.append(r9);
        r6.append(", shouldUpdateIsland=");
        r6.append(j.get());
        r5.i("ObricLiveDelegate", r6.toString());
        if (r3 != null) goto L10;
        r5.i("ObricLiveDelegate", "updateComplexTaskSession create new complex task session because currentSession is null");
        G("complex_task", r17, r18);
        return;
    L10:
        IslandWidget r4 = r3.getCollapseWidget();
        if (r4 == null) goto L13;
        String r7 = r4.getTemplateId();
    L14:
        String r10 = IObricTemplate.a.a(i0.d(r17)).getTemplateId();
        boolean r11 = !Intrinsics.areEqual(r7, r10);
        IslandWidget r12 = r3.getExpandWidget();
        if (r12 == null) goto L17;
        String r13 = r12.getTemplateId();
    L18:
        String r14 = IObricTemplate.a.a(i0.f(r17)).getTemplateId();
        boolean r15 = !Intrinsics.areEqual(r13, r14);
        r5.i("ObricLiveDelegate", "needRecreateForComplexTask currentCollapseTemplateId: " + r7 + ", targetCollapseTemplateId: " + r10 + ",currentExpandTemplateId:" + r13 + ", targetExpandTemplateId:" + r14);
        if (C() == false) goto L29;
        IslandWidget r16 = r3.getNotificationWidget();
        if (r16 == null) goto L23;
        String r19 = r16.getTemplateId();
    L24:
        String r20 = IObricTemplate.a.a(i0.g(r17)).getTemplateId();
        boolean r110 = !Intrinsics.areEqual(r19, r20);
        r5.i("ObricLiveDelegate", "needRecreateForComplexTask currentNotificationTemplateId: " + r19 + ", targetNotificationTemplateId:" + r20);
        if (r110 == true) goto L33;
        if (r11 == true) goto L33;
        if (r15 == true) goto L33;
    L32:
        r8 = false;
    L33:
        r5.i("ObricLiveDelegate", "needRecreateForComplexTask state=" + r17.getCurrentIslandState() + ", needRecreate=" + r8);
        if (r8 == false) goto L37;
        r5.i("ObricLiveDelegate", "updateComplexTaskSession recreate session for template switch");
        D(r3, r17, r18);
        return;
    L37:
        AtomicBoolean r21 = l;
        if (r21.get() == false) goto L41;
        D(r3, r17, r18);
        r21.set(false);
        return;
    L41:
        r5.i("ObricLiveDelegate", "updateComplexTaskSession update existing session");
        L(r3, r17, r18);
        return;
    L23:
        r19 = null;
        goto L24
    L29:
        if (r11 == true) goto L33;
        if (r15 == false) goto L32;
    L17:
        r13 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L5:
        r9 = false;
        goto L6
    }

    public final void h(Context r60, ObricState r61) {
        ObricLiveCardStrategy r7 = this;
        Intrinsics.checkNotNullParameter(r60, "context");
        Intrinsics.checkNotNullParameter(r61, "obricState");
        FLogger r1 = FLogger.a;
        r1.i("ObricLiveDelegate", "showLiveCard newObricState: " + r61);
        ConcurrentHashMap<String, String> r2 = g;
        ObricInteractionScene r3 = r61.getScene();
        ObricInteractionScene r4 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        if (r3 != r4) goto L6;
        String r5 = "complex_task";
    L12:
        r2.put(r5, r61.getConversationId());
        ObricInteractionScene r6 = r61.getScene();
        if (r6 != null) goto L15;
        int r8 = -1;
    L17:
        if (r8 != 1) goto L145;
        AtomicBoolean r9 = j;
        if (r9.get() == false) goto L143;
        IslandSession r10 = A("complex_task", r61.getConversationId());
        switch(a.a[r61.getCurrentIslandState().ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L29;
            case 7: goto L23;
            default: goto L42;
        };
    L23:
        r9.set(false);
        if (C() == false) goto L26;
        r7.I(r61, r60);
    L27:
        H("receive_state_showing_task", 3000, "complex_task", new showLiveCard.1(ObricLiveServiceDelegate.b));
        goto L143
    L26:
        r7.D(r10, r61, r60);
        goto L27
    L32:
        l.set(true);
        r7.D(r10, r61, r60);
        goto L143
    L33:
        r7.o(r60, r4, false, r61.getConversationId());
        goto L143
    L34:
        r7.u("complex_end_state_showing_task");
        if (r10 == null) goto L37;
        IslandWidget r11 = r10.getNotificationWidget();
    L38:
        if (r11 == null) goto L40;
        r7.D(r10, r61, r60);
        goto L143
    L40:
        r7.I(r61, r60);
        goto L143
    L37:
        r11 = null;
        goto L38
    L29:
        if (C() == false) goto L31;
        r7.I(r61, r60);
        goto L143
    L31:
        r7.D(r10, r61, r60);
        goto L143
    L42:
        if (r61.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_COMPLETED) goto L44;
        boolean r12 = false;
        Context r13 = r60;
        ObricState r0 = r61;
    L140:
        if (r12 == false) goto L142;
        return;
    L142:
        r7.I(r0, r13);
    L179:
        if (r61.getCurrentIslandState() != ObricIslandStateType.DEEP_THINK_END) goto L184;
        if (Build.VERSION.SDK_INT < 30) goto L184;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_CONFIRM);
    L184:
        if (r61.getCurrentIslandState() != ObricIslandStateType.TTS_END) goto L186;
    L189:
        boolean r14 = true;
    L190:
        if (r14 == false) goto L198;
        ObricInteractionScene r15 = r61.getScene();
        if (r15 == null) goto L199;
        a.o(r13, r15, false, r61.getConversationId());
        return;
    L199:
        return;
    L198:
        return;
    L186:
        if (r61.getCurrentIslandState() == ObricIslandStateType.REALTIME_CALL_END) goto L189;
        r14 = false;
        goto L190
    L44:
        ComplexTaskQueueingAndCompletionIslandMonitor.a.getClass();
        boolean r16 = !CollectionsKt.toSet(ComplexTaskQueueingAndCompletionIslandMonitor.b.c.a.keySet()).isEmpty();
        StringBuilder r17 = new StringBuilder("checkComplexTaskCreatedTime, taskCreatedTime: ");
        r17.append(r61.getTaskCreatedTime());
        r17.append(",latestComplexTaskCreatedTime: ");
        AtomicLong r18 = e;
        r17.append(r18.get());
        r1.i("ObricLiveDelegate", r17.toString());
        Long r19 = r61.getTaskCreatedTime();
        if (r19 == null) goto L50;
        long r110 = r19.longValue();
        if (r110 < r18.get()) goto L49;
        r18.set(r110);
        goto L50
    L49:
        boolean r20 = false;
    L52:
        if (C() == false) goto L131;
        Intrinsics.checkNotNullParameter(r61, "obricState");
        com.obric.assistant.live.island.g r21 = ComplexTaskQueueingAndCompletionIslandMonitor.c;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r61, "obricState");
        Object r22 = r61.getExt().get("o_omni_task_id");
        if (r22 == null) goto L130;
        String r23 = r22.toString();
        if (r23 == null) goto L130;
        if ((!StringsKt.isBlank(r23)) == true) goto L61;
        r23 = null;
    L61:
        if (r23 == null) goto L130;
        com.obric.assistant.live.island.i r111 = r21.d;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r23, DBDefinition.TASK_ID);
        Object r112 = r111.b;
        monitor-enter(r112);
        Object r113 = r111.d.get(r23);     // Catch: Throwable -> L127
        Boolean r114 = Boolean.TRUE;     // Catch: Throwable -> L127
        if (Intrinsics.areEqual(r113, r114) == false) goto L68;
        boolean r115 = false;
    L70:
        monitor-exit(r112);
        if (r115 == true) goto L73;
        r1.i("ComplexTaskCompletedIslandModule", "showCompletedCard skipped due to duplicated taskId=".concat(r23));
        goto L131
    L73:
        Context r116 = r21.a;
        Object r117 = r61.getExt().get("origin_query");
        if (r117 == null) goto L76;
        String r118 = r117.toString();
    L77:
        Object r119 = r61.getExt().get("o_last_reply_message_id");
        if (r119 == null) goto L80;
        String r120 = r119.toString();
    L81:
        Object r121 = r61.getExt().get("o_complete_result");
        if (r121 == null) goto L84;
        String r122 = r121.toString();
    L85:
        if (r122 != null) goto L87;
    L90:
        boolean r123 = true;
    L91:
        if (r123 == false) goto L93;
    L96:
        boolean r124 = true;
    L98:
        if (r124 == false) goto L100;
        int r125 = 2131912042;
    L101:
        String r126 = r116.getString(r125);
        if (r118 != null) goto L104;
    L110:
        String r24 = r126;
    L111:
        sea.b.a.getClass();
        com.obric.assistant.live.island.a r25 = r21.a(new com.obric.assistant.live.island.a(r23, r118, r120, r124, r24, r126, r126, r24, sea.b.b(r61)), r23);
        r r127 = com.obric.assistant.live.island.g.e(r25);
        JsonObject r128 = new JsonObject();
        r128.addProperty("ext_task_id", r25.a);
        String r129 = r25.c;
        if (r129 != null) goto L114;
    L119:
        com.obric.assistant.live.island.h r130 = new com.obric.assistant.live.island.h(r25, r21);
        Intrinsics.checkNotNullParameter(r127, "openChatParams");
        Intrinsics.checkNotNullParameter(r128, "ext");
        int r131 = com.obric.assistant.live.island.j.a;
        t r132 = new t(com.obric.assistant.live.island.j.d(r127), r128, r130);
        Context r133 = r21.a;
        Icon r134 = sea.h.t();
        if (r25.d == false) goto L122;
        String r26 = r133.getString(2131912209);
        Intrinsics.checkNotNull(r26);
    L123:
        IslandWidget r135 = com.obric.assistant.live.island.j.a(r134, new Text(r26, 14, "#FFFFFFFF", null, null, null, null, sea.d.d(), 120, null));
        r135.setOnCardClickCallback(new com.obric.assistant.live.island.b(r21, r25));
        r r136 = com.obric.assistant.live.island.g.e(r25);
        List r137 = CollectionsKt.listOf(new Button(40, 40, "svg:right_arrow", "svg:right_arrow", r114, null, null, null, null, 480, null));
        List r27 = CollectionsKt.listOf(new ButtonV2("svg:right_arrow", null, 40, 40, "svg:right_arrow", r114, null, null, null, null, null, 1986, null));
        IslandWidget r28 = com.obric.assistant.live.island.j.b(sea.h.o(), new Text(r25.e, 16, "#FFFFFFFF", "#E6000000", null, null, null, sea.d.d(), 112, null), new Text(r25.f, 13, "#E0FFFFFF", "#E6000000", null, null, null, sea.d.a(), 112, null), r137, r27);
        r28.addOnViewClickCallback("svg:right_arrow", new com.obric.assistant.live.island.c(r21, r136));
        r28.setOnCardClickCallback(new com.obric.assistant.live.island.d(r21, r136));
        r r29 = com.obric.assistant.live.island.g.e(r25);
        ObricAINotificationTemplateIcon r138 = sea.h.s(null);
        IslandWidget r30 = com.obric.assistant.live.island.j.c(new ObricAINotificationTemplateText(r25.e, r21.a.getString(2131912038), 14, "#FFFFFFFF", "#FF000000", "500", 1, sea.d.c()), r21.d(r25.g), r138, sea.h.r(), 24);
        r30.addOnViewClickCallback("svg:right_arrow", new com.obric.assistant.live.island.e(r21, r29));
        r30.setOnCardClickCallback(new com.obric.assistant.live.island.f(r21, r29));
        IslandSession r31 = com.obric.assistant.live.island.j.e(new u(r135, r28, r30, r132, 2304));
        r31.setSceneEntity(new TaskSceneEntity(SceneType.AI_TASK, RuntimeState.FINISHED, r25.h, sea.h.v(r31), 0, "omni", 16, null));
        com.obric.assistant.live.island.j.g(r31);
        r1.i("ComplexTaskCompletedIslandModule", "createAndPublishCompletedSession, taskId=" + r25.a + ", targetMessageId=" + r25.c + ", completeSuccess=" + r25.d);
        Iterator r32 = ((ArrayList) r21.d.a(r31)).iterator();
    L125:
        if (r32.hasNext() == false) goto L131;
        com.obric.assistant.live.island.j.f((IslandSession) r32.next());
        goto L125
    L122:
        r26 = r133.getString(2131912043);
        Intrinsics.checkNotNull(r26);
        goto L123
    L114:
        if ((!StringsKt.isBlank(r129)) == true) goto L117;
        r129 = null;
    L117:
        if (r129 == null) goto L119;
        r128.addProperty("ext_target_message_id", r129);
        goto L119
    L104:
        if ((!StringsKt.isBlank(r118)) == false) goto L106;
        String r139 = r118;
    L107:
        if (r139 == null) goto L110;
        r24 = r139;
        goto L111
    L106:
        r139 = null;
        goto L107
    L100:
        r125 = 2131912043;
        goto L101
    L93:
        if (Intrinsics.areEqual(r122, "success") == true) goto L96;
        r124 = false;
        goto L98
    L87:
        if (r122.length() == 0) goto L90;
        r123 = false;
        goto L91
    L84:
        r122 = null;
        goto L85
    L80:
        r120 = null;
        goto L81
    L76:
        r118 = null;
        goto L77
    L68:
        r111.d.put(r23, r114);     // Catch: Throwable -> L127
        r115 = true;
    L127:
        th = move-exception;
        throw th;
    L130:
        r1.i("ComplexTaskCompletedIslandModule", "showCompletedCard skipped, taskId is empty");
    L131:
        if (r16 == false) goto L133;
        FLogger.a.i("ObricLiveDelegate", "skip main complex completed card because queueing island still exists");
    L134:
        r7 = this;
        r13 = r60;
        r0 = r61;
        r12 = true;
        goto L140
    L133:
        if (r20 == false) goto L134;
        if (C() == false) goto L138;
        r7 = this;
        r13 = r60;
        r7.o(r13, ObricInteractionScene.COMPLEX_TASK_SCENE, false, r61.getConversationId());
        r0 = r61;
    L139:
        e.set(0);
        r12 = C();
        goto L140
    L138:
        r7 = this;
        r13 = r60;
        r0 = r61;
        H("complex_end_state_showing_task", 6000, "complex_task", new g(r0));
    L50:
        r20 = true;
    L143:
        r13 = r60;
        goto L179
    L145:
        r13 = r60;
        if (r61.getScene() != ObricInteractionScene.AIGC_GENERATION_SCENE) goto L149;
        String r33 = "aigc_generation";
    L153:
        if (Intrinsics.areEqual(r33, "aigc_generation") == false) goto L155;
        r7.u("aigc_end_state_showing_task");
    L155:
        IslandSession r34 = A(r33, r61.getConversationId());
        if (Intrinsics.areEqual(r33, "directly_answer") == true) goto L158;
    L161:
        if (r34 != null) goto L167;
        if (r61.getCurrentIslandState() != ObricIslandStateType.TTS_END) goto L167;
        r1.i("ObricLiveDelegate", "skip creating live card for terminal state: " + r61);
        return;
    L167:
        if (r61.getScene() != ObricInteractionScene.REALTIME_CALL_SCENE) goto L170;
        r1.i("ObricLiveDelegate", "realtime call scene");
        d = true;
    L170:
        if (r34 == null) goto L172;
        r7.L(r34, r61, r13);
    L174:
        if (Intrinsics.areEqual(r33, "aigc_generation") == false) goto L179;
        if (r61.getCurrentIslandState() != ObricIslandStateType.DEEP_THINK_END) goto L179;
        H("aigc_end_state_showing_task", 6000, "aigc_generation", new com.obric.assistant.live.api.c(r61));
        goto L179
    L172:
        r7.G(r33, r61, r13);
        goto L174
    L158:
        if (r61.getCurrentIslandState() != ObricIslandStateType.TTS_END) goto L161;
        r7.o(r13, ObricInteractionScene.DEFAULT, true, r61.getConversationId());
        return;
    L149:
        if (com.obric.assistant.live.api.b.a(r61) == false) goto L151;
        r33 = "directly_answer";
        goto L153
    L151:
        r33 = "simple_task";
        goto L153
    L15:
        r8 = a.b[r6.ordinal()];
        goto L17
    L6:
        if (r61.getScene() != ObricInteractionScene.AIGC_GENERATION_SCENE) goto L9;
        r5 = "aigc_generation";
        goto L12
    L9:
        if (com.obric.assistant.live.api.b.a(r61) == false) goto L11;
        r5 = "directly_answer";
        goto L12
    L11:
        r5 = "simple_task";
        goto L12
    }

    public final void n(boolean r2, boolean r3) {
        p = r3;
        if (r3 == false) goto L7;
        r(r2);
        return;
    L7:
        if (e() == true) goto L9;
        l(r2);
        return;
    L9:
        if (r3 == true) goto L16;
        AppHost.Companion r4 = AppHost.a;
        if (r4.a().isAppBackground() == true) goto L16;
        if (r4.a().isAppBackground() == true) goto L19;
        ObricFloatChatPageData.a r5 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r0 = (ObricFloatChatPageState) a.b.getValue();
        r5.getClass();
        if ((r0 instanceof vda.d) == true) goto L16;
        return;
    L19:
        return;
    L16:
        l(r2);
    }

    public final IslandSession v(ObricState r30, Context r31) {
        Intrinsics.checkNotNullParameter(r30, "<this>");
        IslandWidget r4 = IObricTemplate.a.a(i0.d(r30));
        Intrinsics.checkNotNullParameter(r30, "<this>");
        if (com.obric.assistant.live.api.b.a(r30) == false) goto L6;
        IslandWidget r2 = IObricTemplate.a.a(i0.h(r30));
        r2.addOnViewClickCallback("svg:stop_play", new a0());
        r2.addOnViewClickCallback("svg:right_arrow", new b0(r30));
    L5:
        IslandWidget r5 = r2;
    L30:
        PendingIntent r8 = z(r30, r31);
        LiveCardType r3 = LiveCardType.ASSISTANT;
        long r17 = i0.q(r30);
        Intrinsics.checkNotNullParameter(r30, "<this>");
        ObricInteractionScene r6 = r30.getScene();
        ObricInteractionScene r15 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        if (r6 == r15) goto L33;
        JsonObject r16 = null;
    L41:
        if (r30.getScene() != r15) goto L43;
        c r26 = o;
    L44:
        IslandSession r14 = new IslandSession(r4, r5, null, null, r8, r26, null, 0, r3, null, null, r16, r17, null, null, null, 0, 124620, null);
        if (r30.getScene() != r15) goto L70;
        if (C() == false) goto L70;
        if (r30.getCurrentIslandState() != ObricIslandStateType.TTS_PLAYING) goto L51;
    L68:
        r14.setNotificationWidget(null);
        r14.setSceneEntity(null);
        return r14;
    L51:
        if (r30.getCurrentIslandState() == ObricIslandStateType.TTS_END) goto L68;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        if (com.obric.assistant.live.api.b.a(r30) == true) goto L66;
        a.getClass();
        if (C() == false) goto L66;
        ObricInteractionScene r1 = r30.getScene();
        if (r1 != null) goto L62;
        int r7 = -1;
    L64:
        if (r7 != 5) goto L66;
        FLogger.a.i("ObricStateIslandUtils", "createNotificationLiveCard called createComplexTaskNotificationLiveCard");
        IslandWidget r13 = IObricTemplate.a.a(i0.g(r30));
        i0.b(r30, r13);
    L67:
        r27.setNotificationWidget(r13);
        r27.setSceneEntity(new TaskSceneEntity(SceneType.AI_TASK, i0.l(r30), j0.h(r30).getText(), sea.h.v(r27), 0, "omni", 16, null));
        return r14;
    L62:
        r7 = i0.a.a[r1.ordinal()];
    L66:
        r13 = null;
    L70:
        return r14;
    L43:
        r26 = null;
        goto L44
    L33:
        Gson r9 = z.a;
        String r10 = z.c(new sea.c(ObricIslandType.COMPLEX_TASK.getValue()));
        if (r10 == null) goto L38;
        JsonObject r11 = JsonParser.parseString(r10).getAsJsonObject();
        if (r11 == null) goto L38;
    L39:
        r16 = r11;
    L38:
        r11 = new JsonObject();
        goto L39
    L6:
        ObricInteractionScene r12 = r30.getScene();
        if (r12 != null) goto L9;
        int r18 = -1;
    L11:
        if (r18 != 1) goto L13;
        r2 = IObricTemplate.a.a(i0.h(r30));
        r2.addOnViewClickCallback("svg:stop_play", new sea.i());
        r2.addOnViewClickCallback("svg:right_arrow", new sea.t(r30));
        goto L5
    L13:
        if (r18 != 2) goto L15;
    L28:
        r2 = IObricTemplate.a.a(i0.h(r30));
        r2.addOnViewClickCallback("svg:right_arrow", new g0(r30));
        r2.addOnViewClickCallback("svg:stop_play", new h0());
        goto L5
    L15:
        if (r18 == 3) goto L28;
        if (r18 == 4) goto L21;
        if (r18 == 5) goto L20;
        r5 = null;
        goto L30
    L20:
        r2 = IObricTemplate.a.a(i0.f(r30));
        i0.a(r30, r2);
        goto L5
    L21:
        r2 = IObricTemplate.a.a(i0.h(r30));
        r2.addOnViewClickCallback("svg:close_red", new w());
        switch(i0.a.b[r30.getCurrentIslandState().ordinal()]) {
            case 10: goto L25;
            case 11: goto L25;
            case 12: goto L25;
            case 13: goto L25;
            case 14: goto L25;
            default: goto L5;
        };
    L25:
        if (ObricLiveServiceDelegate.b.f() == false) goto L27;
        r2.addOnViewClickCallback("svg:expand_mic_off", new x());
        goto L5
    L27:
        r2.addOnViewClickCallback("svg:expand_mic_on", new y());
        r2.addOnViewClickCallback("svg:mic_on_orange_with_bg", new sea.z());
        goto L5
    L9:
        r18 = i0.a.a[r12.ordinal()];
        goto L11
    }

    public final PendingIntent z(ObricState r17, Context r18) {
        if (r17.getScene() != ObricInteractionScene.REALTIME_CALL_SCENE) goto L6;
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r17, "obricState");
        Intent r2 = new Intent();
        r2.setPackage(r18.getPackageName());
        r2.setAction("com.obric.assistant.obric.live.pending.action");
        r2.putExtra("island_conversation_id", r17.getConversationId());
        r2.putExtra("live_state", -101);
        r2.putExtra("launch_method", "dynamic_island");
        FLogger.a.e("ObricStateUtils", "getContentPendingIntent with intent " + r2 + ", extras: " + r2.getExtras());
        return PendingIntent.getBroadcast(r18, -101, r2, 201326592);
    L6:
        if (r17.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L29;
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r17, "obricState");
        FLogger r3 = FLogger.a;
        r3.i("ObricStateUtils", "getComplexTaskPendingIntent, currentIslandState:" + r17.getCurrentIslandState() + ", EXT_KEY_COMPLEX_TASK_SOURCE_TYPE: " + r17.getExt().get("o_complex_source_type"));
        if (r17.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_CALL_USER) goto L10;
    L24:
        int r4 = -107;
    L25:
        Intent r13 = new Intent();
        r13.setPackage(r18.getPackageName());
        r13.setAction("com.obric.assistant.obric.live.pending.action");
        r13.putExtra("live_state", r4);
        r13.putExtra("launch_method", "dynamic_island");
        r13.putExtra("is_complex_task_scene", true);
        r13.putExtra("island_conversation_id", r17.getConversationId());
        if (r4 != (-100)) goto L28;
        r13.putExtra("request_lock_screen_authentication", true);
    L28:
        sea.b.a.getClass();
        sea.b.f(r13, r17);
        r3.e("ObricStateUtils", "getContentPendingIntent with intent " + r13 + ", extras: " + r13.getExtras());
        return PendingIntent.getBroadcast(r18, -10087, r13, 201326592);
    L10:
        if (r17.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN) goto L24;
        if (r17.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L17;
        if (Intrinsics.areEqual(r17.getExt().get("o_complex_source_type"), "gui") == true) goto L24;
    L17:
        if (r17.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L19;
    L23:
        r4 = -100;
        goto L25
    L19:
        if (g.d(r17) == false) goto L22;
        r4 = -108;
        goto L25
    L22:
        if (j0.j(r17) == false) goto L24;
    L29:
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r17, "obricState");
        Intent r5 = new Intent(r18, ObricLiveReceiver.class);
        r5.setPackage(r18.getPackageName());
        r5.setAction("com.obric.assistant.obric.live.pending.action");
        if (r17.getScene() != ObricInteractionScene.AIGC_GENERATION_SCENE) goto L33;
        String r6 = "aigc_generation";
    L36:
        r5.addCategory(r6);
        r5.setData(UriProtector.parse("island://notification/" + r17.getConversationId()));
        r5.putExtra("island_conversation_id", r17.getConversationId());
        r5.putExtra("live_state", -100);
        r5.putExtra("launch_method", "dynamic_island");
        r5.putExtra("is_complex_task_scene", false);
        r5.putExtra("request_lock_screen_authentication", true);
        FLogger.a.e("ObricStateUtils", "getContentPendingIntent with intent " + r5 + ", extras: " + r5.getExtras());
        return PendingIntent.getBroadcast(r18, -100, r5, 201326592);
    L33:
        if (com.obric.assistant.live.api.b.a(r17) == false) goto L35;
        r6 = "directly_answer";
        goto L36
    L35:
        r6 = "simple_task";
        goto L36
    }

    public final void D(IslandSession r4, ObricState r5, Context r6) {
        IslandSession r0 = v(r5, r6);
        AtomicReference r1 = B("complex_task", r5.getConversationId());
        if (r1 == null) goto L5;
        r1.set(r0);
    L5:
        g.put("complex_task", r5.getConversationId());
        ILiveCard.Companion r7 = ILiveCard.Companion;
        IslandApi r2 = r7.getInst().getIslandService();
        if (r2 == null) goto L8;
        r2.createSession(r0, r6);
    L8:
        if (r4 == null) goto L13;
        IslandApi r8 = r7.getInst().getIslandService();
        if (r8 == null) goto L14;
        r8.destroySession(r4);
        return;
    L14:
        return;
    }

    public final void G(String r5, ObricState r6, Context r7) {
        if (Intrinsics.areEqual(r5, "aigc_generation") == false) goto L9;
        ConcurrentHashMap<String, ObricIslandCreateScene> r1 = h;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L7;
        ObricIslandCreateScene r2 = ObricIslandCreateScene.KEYGUARD_LOCKED;
    L8:
        r1.put("aigc_generation", r2);
        goto L9
    L7:
        r2 = ObricIslandCreateScene.KEYGUARD_UNLOCKED;
    L9:
        IslandSession r0 = v(r6, r7);
        AtomicReference r3 = B(r5, r6.getConversationId());
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.compareAndSet(null, r0) == true) goto L14;
        if (r3.get() == null) goto L13;
        boolean r4 = false;
    L19:
        if (r4 == true) goto L21;
        FLogger.a.i("ObricLiveDelegate", "setNewSession compareAndSet failed");
        return;
    L21:
        g.put(r5, r6.getConversationId());
        FLogger.a.i("ObricLiveDelegate", "setNewSession createSession success, obricState: " + r6);
        IslandApi r8 = ILiveCard.Companion.getInst().getIslandService();
        if (r8 == null) goto L29;
        r8.createSession(r0, r7);
        return;
    L29:
        return;
    L14:
        r4 = true;
        goto L19
    }

    public final void L(IslandSession r11, ObricState r12, Context r13) {
        FLogger.a.i("ObricLiveDelegate", "updateLiveCard, currentSession: " + r11 + ", currentState: " + r12);
        ObricInteractionScene r0 = r12.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L28;
        r11.setIntent(z(r12, r13));
        IslandWidget r14 = r11.getCollapseWidget();
        if (r14 == null) goto L11;
        r14.setTemplateData(i0.d(r12));
        r11.update(r14);
    L11:
        IslandWidget r15 = r11.getExpandWidget();
        if (r15 == null) goto L15;
        r15.setTemplateData(i0.f(r12));
        i0.a(r12, r15);
        r11.update(r15);
    L15:
        if (C() == true) goto L17;
    L27:
        r11.setFlags(i0.q(r12));
        r11.updateFlags();
        return;
    L17:
        if (r12.getCurrentIslandState() != ObricIslandStateType.TTS_PLAYING) goto L19;
    L25:
        r11.setSceneEntity(null);
    L26:
        r11.refreshScene();
        goto L27
    L19:
        if (r12.getCurrentIslandState() == ObricIslandStateType.TTS_END) goto L25;
        IslandWidget r16 = r11.getNotificationWidget();
        if (r16 == null) goto L24;
        r16.setTemplateData(i0.g(r12));
        i0.b(r12, r16);
        r11.update(r16);
    L24:
        r11.setSceneEntity(new TaskSceneEntity(SceneType.AI_TASK, i0.l(r12), j0.h(r12).getText(), sea.h.v(r11), 0, "omni", 16, null));
        goto L26
    L28:
        r11.setIntent(z(r12, r13));
        IslandWidget r17 = r11.getCollapseWidget();
        if (r17 == null) goto L31;
        r17.setTemplateData(i0.d(r12));
        r11.update(r17);
    L31:
        IslandWidget r18 = r11.getExpandWidget();
        if (r18 == null) goto L42;
        r18.setTemplateData(i0.h(r12));
        a.getClass();
        if (r12.getScene() == ObricInteractionScene.REALTIME_CALL_SCENE) goto L36;
    L39:
        r11.update(r18);
        return;
    L36:
        if (ObricLiveServiceDelegate.b.f() == false) goto L38;
        r18.addOnViewClickCallback("svg:expand_mic_off", new com.obric.assistant.live.api.d());
        goto L39
    L38:
        r18.addOnViewClickCallback("svg:expand_mic_on", new com.obric.assistant.live.api.e());
        r18.addOnViewClickCallback("svg:mic_on_orange_with_bg", new f());
        goto L39
    L42:
        return;
    L5:
        r1 = a.b[r0.ordinal()];
        goto L7
    }

    public final void d(Context r2, ObricInteractionScene r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scene");
        w(r3, r4, null);
    }

    public final void w(ObricInteractionScene r5, boolean r6, String r7) {
        FLogger r0 = FLogger.a;
        r0.i("ObricLiveDelegate", "destroyLiveCardByScene, " + r5);
        if (r6 == false) goto L10;
        r0.i("ObricLiveDelegate", "destroyLiveCardByScene, isFromContinuousIntents");
        IslandSession r8 = F("directly_answer", r7);
        if (r8 == null) goto L48;
        IslandApi r9 = ILiveCard.Companion.getInst().getIslandService();
        if (r9 == null) goto L49;
        r9.destroySession(r8);
        return;
    L49:
        return;
    L48:
        return;
    L10:
        int r10 = a.b[r5.ordinal()];
        if (r10 != 1) goto L13;
        IslandSession r11 = F("complex_task", r7);
        if (r11 == null) goto L42;
        IslandApi r12 = ILiveCard.Companion.getInst().getIslandService();
        if (r12 == null) goto L42;
        r12.destroySession(r11);
    L42:
        if (e() == false) goto L44;
        f(false);
    L44:
        q.set(false);
        k.set(false);
        p = false;
        r = false;
        r0.i("ObricLiveDelegate", "unregister task stack listener");
        ITaskStackService r13 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r13 == null) goto L55;
        r13.a(i);
        return;
    L55:
        return;
    L13:
        if (r10 != 2) goto L15;
        u("aigc_end_state_showing_task");
        IslandSession r14 = F("aigc_generation", r7);
        if (r14 == null) goto L52;
        IslandApi r15 = ILiveCard.Companion.getInst().getIslandService();
        if (r15 == null) goto L53;
        r15.destroySession(r14);
        return;
    L53:
        return;
    L52:
        return;
    L15:
        if (r10 != 3) goto L17;
    L23:
        IslandSession r16 = F("simple_task", r7);
        if (r16 == null) goto L29;
        IslandApi r17 = ILiveCard.Companion.getInst().getIslandService();
        if (r17 == null) goto L29;
        r17.destroySession(r16);
    L29:
        if (r5 != ObricInteractionScene.REALTIME_CALL_SCENE) goto L50;
        d = false;
        ObricLiveServiceDelegate.b.e();
        return;
    L50:
        return;
    L17:
        if (r10 == 4) goto L23;
        if (r10 == 5) goto L23;
        throw new NoWhenBranchMatchedException();
    }

    public final void H(String r13, long r14, String r16, Function0<Unit> r17) {
        FLogger.a.i("ObricLiveDelegate", "startTimer");
        u(r13);
        Job r0 = BuildersKt.launch$default(b, null, null, new startTimer.1(r14, r16, r17, null), 3, null);
        c.put(r13, r0);
    }

    public final void o(Context r2, ObricInteractionScene r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        w(r3, r4, r5);
    }
}
