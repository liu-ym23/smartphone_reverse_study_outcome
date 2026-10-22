package com.obric.assistant.live.strategy;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.z;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.OnKeyguardLockStateChangedListener;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.live.api.ObricLiveCardStrategy;
import com.obric.assistant.live.api.a$a;
import com.obric.assistant.live.gr.island.business.utils.GRIslandType;
import com.obric.assistant.live.gr.island.island.GRLiveCardType;
import com.obric.assistant.live.gr.island.island.impl.GRIslandImpl;
import com.obric.assistant.live.gr.island.island.template.GRCollapseTemplate;
import com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate;
import com.obric.assistant.live.receiver.GRIslandReceiver;
import com.obric.assistant.live.util.ObricIslandType;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.system.ITaskStackService;
import com.obric.assistant.t1;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import lha.g;
import pea.e;
import pea.j;
import pea.k;
import pea.l;
import sea.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GRIslandStrategy implements com.obric.assistant.live.api.a {
    public static final GRIslandStrategy a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<String, Job> c = null;
    public static final AtomicBoolean d = null;
    public static final ConcurrentHashMap<String, AtomicReference<j>> e = null;
    public static final ConcurrentHashMap<String, ObricLiveCardStrategy.ObricIslandCreateScene> f = null;
    public static final d g = null;
    public static final AtomicBoolean h = null;
    public static final AtomicBoolean i = null;
    public static final AtomicBoolean j = null;
    public static final AtomicBoolean k = null;
    public static final AtomicBoolean l = null;
    public static final AtomicBoolean m = null;
    public static final b n = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricIslandStateType.values().length];
            r0[ObricIslandStateType.TTS_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L40:
            r0[ObricIslandStateType.TTS_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L56:
            r0[ObricIslandStateType.COMPLEX_TASK_ASK_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L42:
            r0[ObricIslandStateType.COMPLEX_TASK_TAKING_OVER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L44:
            r0[ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L34:
            r0[ObricIslandStateType.COMPLEX_TASK_CALL_USER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L46:
            r0[ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L14:
            a = r0;
            int[] r1 = new int[ObricInteractionScene.values().length];
            r1[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L38:
            r1[ObricInteractionScene.AIGC_GENERATION_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L50:
            r1[ObricInteractionScene.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L36:
            r1[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L48:
            r1[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L20:
            b = r1;
        }
    }

    public static final class b implements nea.a {
        public b() {
        }

        @Override // nea.a
        public final void a(j r23, int r24) {
            Intrinsics.checkNotNullParameter(r23, "session");
            FLogger r2 = FLogger.a;
            r2.i("GRIslandStrategy", "onSessionStatusChanged session: " + r23 + ", status: " + r24);
            JsonObject r3 = r23.k;
            ObricIslandStateType r5 = null;
            if (r3 == null) goto L7;
            JsonElement r4 = r3.get("obric_island_type");
            if (r4 == null) goto L7;
            String r6 = r4.getAsString();
        L8:
            ObricIslandType r7 = ObricIslandType.COMPLEX_TASK;
            if (Intrinsics.areEqual(r6, r7.getValue()) == false) goto L32;
            AtomicReference<j> r8 = GRIslandStrategy.e.get("complex_task");
            if (r8 == null) goto L13;
            j r9 = r8.get();
        L15:
            if (Intrinsics.areEqual(r23, r9) == true) goto L17;
            return;
        L17:
            if (r24 != (-1)) goto L27;
            r2.i("GRIslandStrategy", "onSessionStatusChanged notifyAssistantState enter");
            ObricState r0 = ObricLiveServiceDelegate.b.k();
            if (r0 == null) goto L22;
            r5 = r0.getCurrentIslandState();
        L22:
            if (r5 != ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L26;
            ISpecialInputTask r1 = com.obric.assistant.special_input.c.a();
            if (r1 == null) goto L26;
            r1.b(r7.getValue(), Boolean.TRUE, StateInfo.copy$default(com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, null, null, null, 30), 0, null, null, null, 0, true, false, null, 223, null));
        L26:
            GRIslandStrategy.i.set(true);
            return;
        L27:
            GRIslandStrategy.j.set(false);
            AtomicBoolean r10 = GRIslandStrategy.i;
            if (r10.get() == false) goto L30;
            GRIslandStrategy.a.f(GRIslandStrategy.k.get());
        L30:
            r10.set(false);
            GRIslandStrategy.k.set(false);
            GRIslandStrategy.l.set(false);
            return;
        L13:
            r9 = null;
            goto L15
        L32:
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public static final class c implements OnKeyguardLockStateChangedListener {
        public c() {
        }

        public final void onKeyguardLockStateChanged(boolean r7) {
            if (r7 == true) goto L40;
            Iterator<T> r8 = GRIslandStrategy.f.keySet().iterator();
        L5:
            if (r8.hasNext() == false) goto L29;
            String r0 = (String) r8.next();
            GRIslandStrategy.f.put(r0, ObricLiveCardStrategy.ObricIslandCreateScene.KEYGUARD_UNLOCKED);
            GRIslandStrategy r1 = GRIslandStrategy.a;
            Intrinsics.checkNotNull(r0);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r0, "tag");
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("updateSessionFlags, scene: ");
            r3.append(r0);
            r3.append(", isRealtimeCallScene: ");
            AtomicBoolean r4 = GRIslandStrategy.d;
            r3.append(r4.get());
            r2.i("GRIslandStrategy", r3.toString());
            if (Intrinsics.areEqual(r0, "simple_task") == false) goto L16;
            ConcurrentHashMap<String, AtomicReference<j>> r5 = GRIslandStrategy.e;
            AtomicReference<j> r6 = r5.get("simple_task");
            if (r6 == null) goto L12;
            j r9 = r6.get();
            if (r9 == null) goto L12;
        L21:
            if (r9 == null) goto L5;
            if (r4.get() == false) goto L28;
            if (t1.a.i() == false) goto L28;
            r2.i("GRIslandStrategy", "is locked screen use enabled, add dismiss keyguard flags");
            r9.l |= 256;
        L28:
            r9.l &= -257;
            r9.b();
        L12:
            AtomicReference<j> r10 = r5.get("directly_answer");
            if (r10 == null) goto L20;
            r9 = r10.get();
        L20:
            r9 = null;
            goto L21
        L16:
            if (Intrinsics.areEqual(r0, "complex_task") == false) goto L20;
            AtomicReference<j> r11 = GRIslandStrategy.e.get("complex_task");
            if (r11 == null) goto L20;
            r9 = r11.get();
            goto L21
        L29:
            ObricLiveServiceDelegate.b.m();
            return;
        }
    }

    public static final class d implements g {
        public d() {
        }

        public final void onTaskCreated(int r1, ComponentName r2) {
        }

        public final void onChange(ComponentName r7, ComponentName r8) {
            FLogger r9 = FLogger.a;
            r9.i("GRIslandStrategy", "on task stack changed to " + r8);
            AtomicReference<j> r0 = GRIslandStrategy.e.get("complex_task");
            if (r0 == null) goto L5;
            j r1 = r0.get();
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            if (Intrinsics.areEqual(r1.j, Boolean.TRUE) == false) goto L25;
            if (r8 == null) goto L11;
            String r3 = r8.getPackageName();
        L13:
            if (Intrinsics.areEqual(r3, AppHost.a.getApplication().getPackageName()) == false) goto L26;
            boolean r4 = false;
            if (r8 == null) goto L21;
            String r10 = r8.getClassName();
            if (r10 == null) goto L21;
            if (StringsKt.startsWith$default(r10, "com.obric.autoaction", false, 2, null) != true) goto L21;
            r4 = true;
        L21:
            if (r4 == false) goto L27;
            r9.i("GRIslandStrategy", "cancel front show");
            r1.j = Boolean.FALSE;
            r1.b();
            return;
        L27:
            return;
        L26:
            return;
        L11:
            r3 = null;
            goto L13
        L25:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public GRIslandStrategy() {
    }

    public final boolean a() {
        return true;
    }

    public final void i() {
    }

    public final void init() {
    }

    public final void j() {
    }

    public final void p() {
    }

    static {
        a = new GRIslandStrategy();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c = new ConcurrentHashMap();
        d = new AtomicBoolean(false);
        ConcurrentHashMap<String, AtomicReference<j>> r0 = new ConcurrentHashMap();
        r0.put("simple_task", new AtomicReference(null));
        r0.put("complex_task", new AtomicReference(null));
        r0.put("directly_answer", new AtomicReference(null));
        e = r0;
        ObricLiveCardStrategy.ObricIslandCreateScene r4 = ObricLiveCardStrategy.ObricIslandCreateScene.KEYGUARD_UNLOCKED;
        f = new ConcurrentHashMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("simple_task", r4), TuplesKt.to("complex_task", r4)}));
        g = new d();
        h = new AtomicBoolean(true);
        i = new AtomicBoolean(false);
        j = new AtomicBoolean(false);
        k = new AtomicBoolean(false);
        l = new AtomicBoolean(false);
        m = new AtomicBoolean(false);
        c r1 = new c();
        n = new b();
        ((nea.b) nea.c.a.a()).b(AppHost.a.getApplication());
        if (Build.VERSION.SDK_INT < 33) goto L6;
        IKeyguardStateKt.getKeyguardState().registerKeyguardLockStateChangedListener(r1);
        return;
    }

    public final void b() {
        FLogger.a.d("GRIslandStrategy", "updateDialogue() call");
        if (e() == false) goto L6;
        y();
        return;
    }

    public final void collapseNotificationPanel() {
        nea.c.a.a();
        nea.b r0 = nea.b.b;
        FLogger.a.d("GRIslandStrategy", "collapseNotificationPanel() called");
    }

    public final boolean e() {
        return i.get();
    }

    public final void k() {
        AtomicReference<j> r0 = e.get("complex_task");
        if (r0 == null) goto L12;
        j r1 = r0.get();
        if (r1 == null) goto L13;
        FLogger r2 = FLogger.a;
        r2.i("GRIslandStrategy", "enterDialogType session: " + r1);
        if (r1.a() == false) goto L10;
        r2.i("GRIslandStrategy", "current session is in dialog mode");
        return;
    L10:
        r2.i("GRIslandStrategy", "enterDialogType set session flags to dialog mode");
        j.set(true);
        r1.j = Boolean.TRUE;
        r2.d("GRIslandStrategy", "enterDialogType old flags: " + r1.l);
        r1.l = ((r1.l | 8) | 64) | mea.d.f(ObricInteractionScene.COMPLEX_TASK_SCENE);
        r2.d("GRIslandStrategy", "enterDialogType new flags: " + r1.l);
        r1.b();
        a.y();
        return;
    L13:
        return;
    }

    public final void y() {
        FLogger r0 = FLogger.a;
        r0.d("GRIslandStrategy", "updateDismissKeyguard() call");
        AtomicReference<j> r1 = e.get("complex_task");
        if (r1 == null) goto L22;
        j r2 = r1.get();
        if (r2 == null) goto L23;
        k r3 = r2.b;
        if (r3 == null) goto L24;
        l r4 = r3.b;
        Boolean r6 = null;
        if ((r4 instanceof GRComplexTaskExpandedTemplate) == false) goto L11;
        GRComplexTaskExpandedTemplate r5 = (GRComplexTaskExpandedTemplate) r4;
    L12:
        if (r5 == null) goto L25;
        e r7 = (e) CollectionsKt.getOrNull(r5.getDialogue().getTextButton(), 0);
        r0.d("GRIslandStrategy", "updateDismissKeyguard actionBtn: " + r7);
        if (r7 != null) goto L16;
    L20:
        r0.i("GRIslandStrategy", "update dismissKeyguard");
        r2.update(r3);
        return;
    L16:
        if (KeyguardService.a.isKeyguardLocked() == true) goto L19;
        r6 = Boolean.TRUE;
    L19:
        r7.p = r6;
        goto L20
    L25:
        return;
    L11:
        r5 = null;
        goto L12
    L24:
        return;
    L23:
        return;
    }

    public final boolean c(ObricInteractionScene r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        int r5 = a.b[r4.ordinal()];
        if (r5 != 1) goto L5;
        ObricLiveCardStrategy.ObricIslandCreateScene r6 = f.get("complex_task");
        if (r6 != null) goto L34;
        return false;
    L34:
        if (r6.isKeyguardLockedScene() != true) goto L41;
    L35:
        return true;
    L41:
        return false;
    L5:
        if (r5 != 3) goto L7;
    L16:
        ConcurrentHashMap<String, ObricLiveCardStrategy.ObricIslandCreateScene> r7 = f;
        ObricLiveCardStrategy.ObricIslandCreateScene r2 = r7.get("simple_task");
        if (r2 != null) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == true) goto L35;
        ObricLiveCardStrategy.ObricIslandCreateScene r8 = r7.get("directly_answer");
        if (r8 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == true) goto L35;
        return false;
    L26:
        if (r8.isKeyguardLockedScene() != true) goto L28;
        r9 = true;
        goto L29
    L19:
        if (r2.isKeyguardLockedScene() != true) goto L21;
        r3 = true;
        goto L22
    L7:
        if (r5 != 4) goto L9;
        ObricLiveCardStrategy.ObricIslandCreateScene r10 = f.get("realtime_call");
        if (r10 != null) goto L14;
        return false;
    L14:
        if (r10.isKeyguardLockedScene() == true) goto L35;
        return false;
    L9:
        if (r5 == 5) goto L16;
        return false;
    }

    public final void f(boolean r6) {
        ISpecialInputTask r0 = com.obric.assistant.special_input.c.a();
        if (r0 == null) goto L9;
        FLogger.a.i("GRIslandStrategy", "onSessionStatusChanged notifyAssistantState quit");
        ObricIslandType r1 = ObricIslandType.COMPLEX_TASK;
        r0.b(r1.getValue(), Boolean.FALSE, null);
        if (r6 == true) goto L9;
        ISpecialInputTask r7 = com.obric.assistant.special_input.c.a();
        if (r7 == null) goto L9;
        r7.closeAssistantInputPanel(r1.getValue());
    L9:
        ObricFloatChatPageData.a r8 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r2 = (ObricFloatChatPageState) waa.a.b.getValue();
        r8.getClass();
        if (ObricFloatChatPageData.a.d(r2) == false) goto L13;
        a$a.a(this, false, 3);
    L15:
        i.set(false);
        k.set(false);
        l.set(false);
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
        ConcurrentHashMap<String, ObricLiveCardStrategy.ObricIslandCreateScene> r8 = f;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L16;
        ObricLiveCardStrategy.ObricIslandCreateScene r1 = ObricLiveCardStrategy.ObricIslandCreateScene.KEYGUARD_LOCKED;
    L17:
        r8.put(r0, r1);
        FLogger.a.i("GRIslandStrategy", "setCreateSceneByTag tag: " + r0 + ", createScene: " + r8.get(r0));
        return;
    L16:
        r1 = ObricLiveCardStrategy.ObricIslandCreateScene.KEYGUARD_UNLOCKED;
        goto L17
    L8:
        r7 = null;
        goto L9
    }

    public final void l(boolean r4) {
        AtomicBoolean r0 = j;
        if (r0.get() == false) goto L6;
        FLogger.a.d("GRIslandStrategy", "updateComplexTaskSessionFlags isEnterDialogType.get(): " + r0.get() + " , return");
        return;
    L6:
        r(r4);
    }

    public final void m(boolean r6) {
        AtomicBoolean r0 = l;
        if (r0.get() != r6) goto L5;
        return;
    L5:
        r0.set(r6);
        AtomicReference<j> r1 = e.get("complex_task");
        if (r1 == null) goto L19;
        j r2 = r1.get();
        if (r2 == null) goto L20;
        k r3 = r2.b;
        if (r3 == null) goto L21;
        FLogger.a.i("GRIslandStrategy", "sendUpdateEvent, disabled: " + r6);
        a.getClass();
        ObricTaskStatusManager.a.getClass();
        if (Intrinsics.areEqual(ObricTaskStatusManager.a(), "call_for_me_reply") == false) goto L14;
        String r4 = "miui.focus.action_call_for_me_reply";
    L15:
        oea.a r5 = new oea.a(r4, Boolean.valueOf(r6));
        Intrinsics.checkNotNullParameter(r3, "targetWidget");
        Intrinsics.checkNotNullParameter("update_button", "eventId");
        Intrinsics.checkNotNullParameter(r5, "data");
        nea.c.a.a();
        GRIslandImpl r7 = nea.b.c;
        if (r7 == null) goto L22;
        r7.d(r2, r3, r5);
        return;
    L22:
        return;
    L14:
        r4 = "miui.focus.action_dialogue_action_btn";
        goto L15
    L21:
        return;
    L20:
        return;
    }

    public final void q(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        FLogger.a.i("GRIslandStrategy", "destroyAllLiveCard");
        sea.e.c(false);
        ObricLiveServiceDelegate.b.e();
        ConcurrentHashMap<String, AtomicReference<j>> r0 = e;
        AtomicReference<j> r1 = r0.get("complex_task");
        j r2 = null;
        if (r1 == null) goto L5;
        j r3 = r1.getAndSet(null);
    L6:
        AtomicReference<j> r4 = r0.get("simple_task");
        if (r4 == null) goto L9;
        j r5 = r4.getAndSet(null);
    L10:
        AtomicReference<j> r7 = r0.get("directly_answer");
        if (r7 == null) goto L13;
        r2 = r7.getAndSet(null);
    L13:
        if (r3 == null) goto L20;
        nea.c.a.a();
        GRIslandImpl r8 = nea.b.c;
        if (r8 == null) goto L17;
        r8.c(r3);
    L17:
        GRIslandStrategy r9 = a;
        if (r9.e() == false) goto L20;
        r9.f(false);
    L20:
        if (r5 == null) goto L24;
        nea.c.a.a();
        GRIslandImpl r10 = nea.b.c;
        if (r10 == null) goto L24;
        r10.c(r5);
    L24:
        if (r2 == null) goto L28;
        nea.c.a.a();
        GRIslandImpl r11 = nea.b.c;
        if (r11 == null) goto L28;
        r11.c(r2);
    L28:
        d.set(false);
        j.set(false);
        i.set(false);
        k.set(false);
        l.set(false);
        m.set(false);
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void r(boolean r7) {
        FLogger r0 = FLogger.a;
        r0.d("GRIslandStrategy", "updateSessionFlags canFrontShow: " + r7);
        AtomicReference<j> r1 = e.get("complex_task");
        if (r1 == null) goto L5;
        j r2 = r1.get();
    L6:
        if (r2 == null) goto L8;
        boolean r4 = Intrinsics.areEqual(r2.j, Boolean.TRUE);
    L9:
        if (r4 == false) goto L12;
        r0.d("GRIslandStrategy", "updateSessionFlags canFrontShow: " + r7 + ", session.canFrontShow: " + r2.j);
        r2.j = Boolean.valueOf(r7);
        r2.l = (r2.l | 64) | mea.d.f(ObricInteractionScene.COMPLEX_TASK_SCENE);
        r2.b();
        return;
    L12:
        return;
    L8:
        r4 = false;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final boolean s(ObricInteractionScene r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        FLogger.a.i("GRIslandStrategy", "isCreateSceneDeviceLocked, scene: " + r4);
        int r5 = a.b[r4.ordinal()];
        if (r5 != 1) goto L5;
        ObricLiveCardStrategy.ObricIslandCreateScene r6 = f.get("complex_task");
        if (r6 != null) goto L31;
    L33:
        boolean r7 = false;
    L34:
        if (r7 == true) goto L38;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L38;
    L15:
        return true;
    L38:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L15;
        return false;
    L31:
        if (r6.isKeyguardLockedScene() != true) goto L33;
        r7 = true;
        goto L34
    L5:
        if (r5 != 3) goto L7;
    L16:
        ObricLiveCardStrategy.ObricIslandCreateScene r8 = f.get("simple_task");
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == true) goto L26;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L15;
    L26:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L15;
        return false;
    L19:
        if (r8.isKeyguardLockedScene() != true) goto L21;
        r9 = true;
        goto L22
    L7:
        if (r5 == 4) goto L12;
        if (r5 == 5) goto L16;
        return false;
    L12:
        if (t1.a.i() == false) goto L15;
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == false) goto L15;
        return false;
    }

    public final void t(String r4) {
        FLogger.a.i("GRIslandStrategy", "cancelTimer");
        Job r5 = c.remove(r4);
        if (r5 == null) goto L6;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
        return;
    }

    public final void h(Context r16, final ObricState r17) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "obricState");
        FLogger r0 = FLogger.a;
        r0.i("GRIslandStrategy", "showLiveCard newObricState: " + r17);
        ObricInteractionScene r1 = r17.getScene();
        if (r1 != null) goto L5;
        int r2 = -1;
    L6:
        j r3 = null;
        if (r2 != 1) goto L58;
        r0.d("GRIslandStrategy", "showLiveCard obricState.scene: " + r17.getScene());
        AtomicBoolean r4 = h;
        if (r4.get() == false) goto L91;
        r0.d("GRIslandStrategy", "showLiveCard currentIslandState: " + r17.getCurrentIslandState());
        switch(a.a[r17.getCurrentIslandState().ordinal()]) {
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L16;
            default: goto L12;
        };
    L12:
        r0.d("GRIslandStrategy", "showLiveCard else, currentIslandState: " + r17.getCurrentIslandState());
        if (r17.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_COMPLETED) goto L52;
        r0.d("GRIslandStrategy", "showLiveCard COMPLEX_TASK_COMPLETED, startTimer, currentIslandState: " + r17.getCurrentIslandState());
        x("complex_end_state_showing_task", 5000, true, new com.obric.assistant.live.strategy.a(r17));
    L52:
        AtomicReference<j> r5 = e.get("complex_task");
        if (r5 == null) goto L57;
        j r6 = r5.get();
        if (r6 == null) goto L57;
        z(r6, r17, r16);
    L57:
        w("complex_task", r17, r16);
        goto L91
    L28:
        r0.d("GRIslandStrategy", "showLiveCard handle call user, currentIslandState: " + r17.getCurrentIslandState());
        j r7 = u(r17, r16);
        AtomicReference<j> r8 = e.get("complex_task");
        if (r8 == null) goto L32;
        r3 = r8.getAndSet(r7);
    L32:
        if (r3 == null) goto L37;
        nea.c.a.a();
        GRIslandImpl r9 = nea.b.c;
        if (r9 == null) goto L36;
        r9.c(r3);
    L36:
        r0.d("GRIslandStrategy", "showLiveCard destroy oldSession.taskId: " + r3.g + ", currentIslandState: " + r17.getCurrentIslandState());
    L37:
        nea.c.a.a();
        GRIslandImpl r10 = nea.b.c;
        if (r10 == null) goto L41;
        r10.b(r7, r16);
    L41:
        if (r17.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L43;
        r7.l |= 8;
        r7.b();
    L43:
        r0.d("GRIslandStrategy", "showLiveCard create islandSession.taskId: " + r7.g + ", currentIslandState: " + r17.getCurrentIslandState() + ", isDialogueMode: " + i);
        goto L91
    L44:
        r0.d("GRIslandStrategy", "showLiveCard ObricIslandStateType.TTS_END, currentIslandState: " + r17.getCurrentIslandState() + ", call destroyLiveCardByScene()");
        d(r16, ObricInteractionScene.COMPLEX_TASK_SCENE, false);
        goto L91
    L45:
        t("complex_end_state_showing_task");
        AtomicReference<j> r11 = e.get("complex_task");
        if (r11 == null) goto L50;
        j r12 = r11.get();
        if (r12 == null) goto L50;
        z(r12, r17, r16);
    L50:
        w("complex_task", r17, r16);
        goto L91
    L16:
        if (m.get() == true) goto L91;
        r4.set(false);
        j r13 = u(r17, r16);
        AtomicReference<j> r14 = e.get("complex_task");
        if (r14 == null) goto L20;
        r3 = r14.getAndSet(r13);
    L20:
        nea.c.a r15 = nea.c.a;
        r15.a();
        GRIslandImpl r18 = nea.b.c;
        if (r18 == null) goto L23;
        r18.b(r13, r16);
    L23:
        if (r3 == null) goto L27;
        r15.a();
        if (r18 == null) goto L27;
        r18.c(r3);
    L27:
        x("receive_state_showing_task", 3000, true, new GRIslandStrategy$showLiveCard$2(ObricLiveServiceDelegate.b));
    L91:
        if (r17.getCurrentIslandState() != ObricIslandStateType.DEEP_THINK_END) goto L96;
        if (Build.VERSION.SDK_INT < 30) goto L96;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_CONFIRM);
    L96:
        if (r17.getCurrentIslandState() != ObricIslandStateType.TTS_END) goto L98;
    L101:
        boolean r19 = true;
    L102:
        if (r19 == false) goto L107;
        ObricInteractionScene r20 = r17.getScene();
        if (r20 == null) goto L107;
        a.d(r16, r20, false);
    L107:
        if (r17.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY) goto L109;
        m.set(true);
        return;
    L109:
        m.set(false);
        return;
    L98:
        if (r17.getCurrentIslandState() == ObricIslandStateType.REALTIME_CALL_END) goto L101;
        r19 = false;
        goto L102
    L58:
        String r21 = "simple_task";
        if (com.obric.assistant.live.api.b.a(r17) == false) goto L63;
        AtomicReference<j> r22 = e.get("directly_answer");
        if (r22 == null) goto L67;
        r3 = r22.get();
    L67:
        if (com.obric.assistant.live.api.b.a(r17) == false) goto L70;
        r21 = "directly_answer";
    L70:
        if (Intrinsics.areEqual(r21, "directly_answer") == false) goto L79;
        if (r17.getCurrentIslandState() != ObricIslandStateType.TTS_END) goto L79;
        d(r16, ObricInteractionScene.DEFAULT, true);
        if (r17.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY) goto L76;
        m.set(true);
        return;
    L76:
        m.set(false);
        return;
    L79:
        if (r17.getScene() != ObricInteractionScene.REALTIME_CALL_SCENE) goto L81;
        r0.i("GRIslandStrategy", "realtime call scene");
        d.set(true);
    L81:
        if (r3 == null) goto L83;
        z(r3, r17, r16);
    L85:
        if (r17.getCurrentIslandState() != ObricIslandStateType.DEEP_THINK_END) goto L88;
        x("simple_end_state_showing_task", 5000, false, new com.obric.assistant.live.strategy.b());
        goto L91
    L88:
        if (r17.getCurrentIslandState() != ObricIslandStateType.TTS_PLAYING) goto L91;
        t("simple_end_state_showing_task");
        goto L91
    L83:
        w(r21, r17, r16);
        goto L85
    L63:
        AtomicReference<j> r23 = e.get("simple_task");
        if (r23 == null) goto L67;
        r3 = r23.get();
        goto L67
    L5:
        r2 = a.b[r1.ordinal()];
        goto L6
    }

    public final void n(boolean r2, boolean r3) {
        k.set(r3);
        if (r3 == false) goto L7;
        r(r2);
        return;
    L7:
        if (e() == true) goto L9;
        l(r2);
        return;
    L9:
        AppHost.Companion r4 = AppHost.a;
        if (r4.a().isAppBackground() == false) goto L12;
    L15:
        l(r2);
        return;
    L12:
        if (r4.a().isAppBackground() == true) goto L18;
        ObricFloatChatPageData.a r5 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r0 = (ObricFloatChatPageState) waa.a.b.getValue();
        r5.getClass();
        if ((r0 instanceof vda.d) == true) goto L15;
        return;
    }

    public final j u(ObricState r22, Context r23) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        int r5 = -1;
        b r7 = null;
        if (com.obric.assistant.live.api.b.a(r22) == false) goto L6;
        k r2 = l.a.a(mea.d.d(r22));
    L5:
        k r10 = r2;
    L20:
        String r3 = j0.i(r22).getText();
        if (o0.d(r3) == true) goto L24;
        r3 = "豆包手机助手";
    L24:
        String r20 = r3;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        k r9 = l.a.a(mea.d.b(r22));
        int r8 = pea.c.e;
        k r11 = l.a.a(new qea.a(pea.c.a.a("miui.focus.pic_small_collapse", 2131244413, null)));
        PendingIntent r12 = v(r22, r23);
        GRLiveCardType r14 = GRLiveCardType.ASSISTANT;
        long r16 = mea.d.g(r22);
        Intrinsics.checkNotNullParameter(r22, "<this>");
        ObricInteractionScene r1 = r22.getScene();
        ObricInteractionScene r4 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        if (r1 != r4) goto L30;
        Gson r6 = z.a;
        String r13 = z.c(new mea.a(GRIslandType.COMPLEX_TASK.getValue()));
        if (r13 == null) goto L35;
        JsonObject r15 = JsonParser.parseString(r13).getAsJsonObject();
    L34:
        JsonObject r17 = r15;
    L37:
        if (r22.getScene() != r4) goto L39;
        FLogger.a.d("GRIslandStrategy", "createLiveCard, complex task scene, set callback");
        r7 = n;
    L40:
        b r18 = r7;
        ObricInteractionScene r0 = r22.getScene();
        if (r0 == null) goto L44;
        r5 = a.b[r0.ordinal()];
    L44:
        if (r5 == 1) goto L50;
        if (r5 == 3) goto L49;
        if (r5 != 4) goto L49;
        String r19 = "realtime_call";
    L52:
        return new j(r9, r10, r11, r12, r18, r14, r17, r16, r19, r20, r20);
    L49:
        r19 = "simple_ask";
        goto L52
    L50:
        r19 = "operate_phone";
        goto L52
    L39:
        FLogger.a.d("GRIslandStrategy", "createLiveCard, default scene, set callback null");
    L35:
        r17 = null;
        goto L37
    L30:
        if (r22.getScene() != ObricInteractionScene.REALTIME_CALL_SCENE) goto L35;
        Gson r21 = z.a;
        String r24 = z.c(new mea.a(GRIslandType.REALTIME_CALL.getValue()));
        if (r24 == null) goto L35;
        r15 = JsonParser.parseString(r24).getAsJsonObject();
        goto L34
    L6:
        ObricInteractionScene r25 = r22.getScene();
        if (r25 != null) goto L9;
        int r26 = -1;
    L10:
        if (r26 != 1) goto L12;
        r2 = l.a.a(mea.d.d(r22));
        goto L5
    L12:
        if (r26 == 2) goto L18;
        if (r26 == 3) goto L17;
        if (r26 == 4) goto L16;
        r10 = null;
        goto L20
    L16:
        r2 = l.a.a(mea.d.c(r22));
        goto L5
    L17:
        r2 = l.a.a(mea.d.d(r22));
        goto L5
    L18:
        r2 = l.a.a(mea.d.d(r22));
        goto L5
    L9:
        r26 = mea.d.a.a[r25.ordinal()];
        goto L10
    }

    public final PendingIntent v(ObricState r9, Context r10) {
        if (r9.getScene() != ObricInteractionScene.REALTIME_CALL_SCENE) goto L5;
        mea.b.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intent r11 = new Intent(r10, GRIslandReceiver.class);
        r11.setPackage(r10.getPackageName());
        r11.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r11.putExtra("live_state", -101);
        FLogger.a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r11 + ", extras: " + r11.getExtras());
        return PendingIntent.getBroadcast(r10, -101, r11, 201326592);
    L5:
        mea.b.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r9, "obricState");
        ObricIslandStateType r0 = r9.getCurrentIslandState();
        ObricIslandStateType r1 = ObricIslandStateType.COMPLEX_TASK_TAKING_OVER;
        if (r0 != r1) goto L11;
        sea.g.a.getClass();
        if (sea.g.d(r9) == false) goto L11;
        int r2 = -108;
    L23:
        Intent r3 = new Intent(r10, GRIslandReceiver.class);
        r3.setPackage(r10.getPackageName());
        r3.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r3.putExtra("live_state", r2);
        if (r9.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L26;
        boolean r5 = true;
    L27:
        r3.putExtra("is_complex_task_scene", r5);
        sea.b.a.getClass();
        sea.b.f(r3, r9);
        FLogger.a.e("GRStateActionUtils", "getChatActivityPendingIntent() with intent " + r3 + ", extras: " + r3.getExtras());
        return PendingIntent.getBroadcast(r10, r2, r3, 201326592);
    L26:
        r5 = false;
    L11:
        if (r9.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_CALL_USER) goto L13;
    L22:
        r2 = -107;
        goto L23
    L13:
        if (r9.getCurrentIslandState() == r1) goto L22;
        if (r9.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN) goto L22;
        if (r9.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L19;
    L21:
        r2 = -106;
        goto L23
    L19:
        if (Intrinsics.areEqual(r9.getExt().get("o_complex_source_type"), "gui") == false) goto L21;
        goto L21
    }

    public final void d(Context r5, ObricInteractionScene r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scene");
        FLogger r8 = FLogger.a;
        r8.i("GRIslandStrategy", "destroyLiveCardByScene, " + r6);
        j r0 = null;
        if (r7 == false) goto L12;
        r8.i("GRIslandStrategy", "destroyLiveCardByScene, isFromContinuousIntents");
        AtomicReference<j> r9 = e.get("directly_answer");
        if (r9 == null) goto L7;
        r0 = r9.getAndSet(null);
    L7:
        if (r0 == null) goto L49;
        nea.c.a.a();
        GRIslandImpl r10 = nea.b.c;
        if (r10 == null) goto L50;
        r10.c(r0);
        return;
    L50:
        return;
    L49:
        return;
    L12:
        int r11 = a.b[r6.ordinal()];
        if (r11 != 1) goto L15;
        AtomicReference<j> r12 = e.get("complex_task");
        if (r12 == null) goto L38;
        r0 = r12.getAndSet(null);
    L38:
        if (r0 == null) goto L43;
        nea.c.a.a();
        GRIslandImpl r13 = nea.b.c;
        if (r13 == null) goto L43;
        r13.c(r0);
    L43:
        if (e() == false) goto L45;
        f(false);
    L45:
        j.set(false);
        i.set(false);
        k.set(false);
        l.set(false);
        r8.i("GRIslandStrategy", "unregister task stack listener");
        ITaskStackService r14 = (ITaskStackService) ServiceManager.get().getService(ITaskStackService.class);
        if (r14 == null) goto L54;
        r14.a(g);
        return;
    L54:
        return;
    L15:
        if (r11 != 2) goto L17;
        return;
    L17:
        if (r11 != 3) goto L19;
    L25:
        AtomicReference<j> r15 = e.get("simple_task");
        if (r15 == null) goto L28;
        r0 = r15.getAndSet(null);
    L28:
        if (r0 == null) goto L33;
        nea.c.a.a();
        GRIslandImpl r16 = nea.b.c;
        if (r16 == null) goto L33;
        r16.c(r0);
    L33:
        if (r6 != ObricInteractionScene.REALTIME_CALL_SCENE) goto L52;
        d.set(false);
        ObricLiveServiceDelegate.b.e();
        return;
    L52:
        return;
    L19:
        if (r11 == 4) goto L25;
        if (r11 == 5) goto L25;
        throw new NoWhenBranchMatchedException();
    }

    public final void w(String r5, ObricState r6, Context r7) {
        j r0 = u(r6, r7);
        AtomicReference<j> r8 = e.get(r5);
        boolean r1 = false;
        if (r8 == null) goto L13;
    L5:
        if (r8.compareAndSet(null, r0) == true) goto L6;
        if (r8.get() == null) goto L5;
        boolean r9 = false;
    L10:
        if (r9 == true) goto L13;
        r1 = true;
        goto L13
    L6:
        r9 = true;
    L13:
        if (r1 == false) goto L15;
        FLogger.a.i("GRIslandStrategy", "setNewSession compareAndSet failed");
        return;
    L15:
        FLogger.a.i("GRIslandStrategy", "setNewSession createSession success, obricState: " + r6);
        nea.c.a.a();
        GRIslandImpl r10 = nea.b.c;
        if (r10 == null) goto L23;
        r10.b(r0, r7);
        return;
    }

    public final void z(j r4, ObricState r5, Context r6) {
        FLogger.a.i("GRIslandStrategy", "updateLiveCard, currentSession: " + r4 + ", currentState: " + r5);
        ObricInteractionScene r0 = r5.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L12;
        r4.d = v(r5, r6);
        k r7 = r4.a;
        GRCollapseTemplate r2 = mea.d.b(r5);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r7.b = r2;
        k r8 = r4.b;
        if (r8 == null) goto L11;
        l r3 = mea.d.c(r5);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r8.b = r3;
    L11:
        r4.l = mea.d.g(r5);
        r4.update(r4.a);
        r4.b();
        return;
    L12:
        r4.d = v(r5, r6);
        k r9 = r4.a;
        GRCollapseTemplate r10 = mea.d.b(r5);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.b = r10;
        k r11 = r4.b;
        if (r11 == null) goto L20;
        GRExpandedNormalTemplate r12 = mea.d.d(r5);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.b = r12;
        a.getClass();
        if (r5.getScene() != ObricInteractionScene.REALTIME_CALL_SCENE) goto L20;
        if (ObricLiveServiceDelegate.b.f() == false) goto L19;
        mea.b r13 = mea.b.a;
        Context r14 = AppHost.a.getApplication().getApplicationContext();
        r13.getClass();
        r11.a("miui.focus.action_expand_mic_off", mea.b.g(r14));
        goto L20
    L19:
        mea.b r15 = mea.b.a;
        AppHost.Companion r16 = AppHost.a;
        Context r17 = r16.getApplication().getApplicationContext();
        r15.getClass();
        r11.a("miui.focus.action_expand_mic_on", mea.b.e(r17));
        r11.a("miui.focus.action_mic_on_orange_with_bg", mea.b.e(r16.getApplication().getApplicationContext()));
    L20:
        r4.update(r4.a);
        return;
    L5:
        r1 = a.b[r0.ordinal()];
        goto L7
    }

    public final void o(Context r2, ObricInteractionScene r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        d(r2, r3, r4);
    }

    public final void x(String r13, long r14, boolean r16, Function0<Unit> r17) {
        FLogger.a.i("GRIslandStrategy", "startTimer");
        t(r13);
        Job r0 = BuildersKt.launch$default(b, null, null, new GRIslandStrategy$startTimer$1(r14, r16, r17, null), 3, null);
        c.put(r13, r0);
    }
}
