package sea;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.live.api.ObricLiveCardStrategy;
import com.obric.assistant.n4;
import com.obric.assistant.o4;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.special_input.ISpecialInputTask$a;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.task.IObricTaskStatusManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public static final g a = null;

    public static final class a implements n4 {
        public final /* synthetic */ Function0<Unit> a;

        public final void onAuthenticationCancelled() {
            FLogger.a.i("ObricStateUtils", "requestAuthenticationBeforeContinue: onAuthenticationCancelled");
        }

        public final void onAuthenticationFailed() {
            FLogger.a.i("ObricStateUtils", "requestAuthenticationBeforeContinue: onAuthenticationFailed");
            g r0 = g.a;
            Function0<Unit> r1 = this.a;
            r0.getClass();
            g.k(r1);
        }

        public final void onAuthenticationNotAvailable() {
            FLogger.a.i("ObricStateUtils", "requestAuthenticationBeforeContinue: onAuthenticationNotAvailable");
            g r0 = g.a;
            Function0<Unit> r1 = this.a;
            r0.getClass();
            g.k(r1);
        }

        public final void onAuthenticationPass() {
            FLogger.a.i("ObricStateUtils", "requestAuthenticationBeforeContinue: onAuthenticationPass");
            this.a.invoke();
        }

        public final void onAuthenticationTimeout() {
            FLogger.a.i("ObricStateUtils", "requestAuthenticationBeforeContinue: onAuthenticationTimeout");
        }

        public a(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public static final class b implements oga.a {
        public final /* synthetic */ Function0<Unit> a;

        @Override // oga.a
        public final void onDismissFailed() {
            FLogger.a.i("ObricStateUtils", "requestDismissKeyguardBeforeContinue: onDismissFailed");
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            FLogger.a.i("ObricStateUtils", "requestDismissKeyguardBeforeContinue: onDismissSucceeded");
            this.a.invoke();
        }

        public b(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    static {
        a = new g();
    }

    public g() {
    }

    public static void b() {
        if (AppHost.a.getApplication().getResources().getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L6:
        FLogger.a.i("ObricStateIslandUtils", "COMPLEX_TASK_ASK_USER, OBRIC_LIVE_ISLAND_ICON_RIGHT_REPLY_WHITE, click, isLandscape: " + r0);
        if (r0 == true) goto L13;
        com.obric.assistant.live.api.j r1 = com.obric.assistant.live.api.j.a;
        ObricLiveCardStrategy r2 = com.obric.assistant.live.api.j.t();
        ObricLiveCardStrategy r3 = ObricLiveCardStrategy.a;
        if (r2 != r3) goto L11;
        r3.x(true);
    L12:
        r1.m(true);
    L14:
        ISpecialInputTask r4 = com.obric.assistant.special_input.c.a();
        if (r4 == null) goto L18;
        ISpecialInputTask$a.a(r4, com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.CLARIFYING.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", "dynamic_island")), null, null, 26), true, true, false, null, 24);
        return;
    L18:
        return;
    L11:
        com.obric.assistant.live.api.j.t().k();
        goto L12
    L13:
        com.obric.assistant.live.api.j.a.j();
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public static void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intent r0 = new Intent();
        r0.setPackage(r4.getPackageName());
        r0.setAction("com.obric.assistant.obric.live.pending.action");
        r0.putExtra("live_state", -102);
        FLogger.a.e("ObricStateUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        r4.sendBroadcast(r0);
    }

    public static void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "launchMethod");
        com.obric.assistant.reporter.b.a(r2, "mcp_input_window", 4);
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L6;
        b();
        return;
    L6:
        j(null, new f());
    }

    public static boolean d(ObricState r1) {
        Intrinsics.checkNotNullParameter(r1, "obricState");
        Object r2 = r1.getExt().get("take_over_reason");
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L7:
        return Intrinsics.areEqual(r3, "lark_authorize");
    L5:
        r3 = null;
        goto L7
    }

    public static void f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intent r0 = new Intent();
        r0.setPackage(r4.getPackageName());
        r0.setAction("com.obric.assistant.obric.live.pending.action");
        r0.putExtra("live_state", -104);
        FLogger.a.e("ObricStateUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        r4.sendBroadcast(r0);
    }

    public static void k(Function0 r11) {
        FLogger.a.i("ObricStateUtils", "requestDismissKeyguardBeforeContinue");
        IKeyguardService$a.a(KeyguardService.a, new b(r11), false, false, false, false, null, 54);
    }

    public static void m(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intent r0 = new Intent();
        r0.setPackage(r4.getPackageName());
        r0.setAction("com.obric.assistant.obric.live.pending.action");
        r0.putExtra("live_state", -105);
        FLogger.a.e("ObricStateUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        r4.sendBroadcast(r0);
    }

    public static void e(Context r6, ObricState r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "obricState");
        Intrinsics.checkNotNullParameter("dynamic_island", "launchMethod");
        FLogger r0 = FLogger.a;
        r0.i("ObricStateUtils", "jumpToChatPage with obricState: " + r7);
        com.obric.assistant.reporter.b.a("dynamic_island", null, 6);
        Intent r2 = new Intent();
        r2.setPackage(r6.getPackageName());
        r2.setAction("com.obric.assistant.obric.live.pending.action");
        r2.putExtra("live_state", -100);
        r2.putExtra(WindowEvent.Params.LAUNCH_METHOD, "dynamic_island");
        if (r7.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L5;
        boolean r1 = true;
    L6:
        r2.putExtra("is_complex_task_scene", r1);
        r2.putExtra("island_conversation_id", r7.getConversationId());
        r2.putExtra("request_lock_screen_authentication", true);
        r0.e("ObricStateUtils", "getContentPendingIntent with intent " + r2 + ", extras: " + r2.getExtras());
        r6.sendBroadcast(r2);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static void j(Bundle r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "onContinue");
        ISessionAuthenticationService r0 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r0 != null) goto L7;
        FLogger.a.w("ObricStateUtils", "requestAuthenticationBeforeContinue: ISessionAuthenticationService is null");
        k(r5);
        return;
    L7:
        if (((Boolean) r0.o().getValue()).booleanValue() == false) goto L10;
        FLogger.a.i("ObricStateUtils", "requestAuthenticationBeforeContinue: biometric already passed");
        r5.invoke();
        return;
    L10:
        FLogger.a.i("ObricStateUtils", "requestAuthenticationBeforeContinue: request biometric auth");
        r0.g(new o4(null, null, r4, 3), 15000L, new a(r5), false);
    }

    public static void i(Context r3, ObricState r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "obricState");
        Intrinsics.checkNotNullParameter(r5, "launchMethod");
        Intent r0 = new Intent();
        r0.setPackage(r3.getPackageName());
        r0.setAction("com.obric.assistant.obric.live.pending.action");
        r0.putExtra("live_state", -108);
        r0.putExtra(WindowEvent.Params.LAUNCH_METHOD, r5);
        r0.putExtra("is_complex_task_scene", true);
        sea.b.a.getClass();
        sea.b.f(r0, r4);
        FLogger.a.e("ObricStateUtils", "getContentPendingIntent with intent " + r0 + ", extras: " + r0.getExtras());
        com.obric.assistant.reporter.b.a(r5, null, 6);
        r3.sendBroadcast(r0);
    }

    public static void g(boolean r5, String r6, Bundle r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "sourceFrom");
        FLogger.a.i("ObricStateUtils", "openOAutoVirtualScreen " + r5 + ", sourceFrom: " + r6 + ", lockScreenAuthReportParams: " + r7);
        com.obric.assistant.live.api.j r0 = com.obric.assistant.live.api.j.a;
        String r4 = "dynamic_island";
        if (r0.e() == false) goto L14;
        if (Intrinsics.areEqual(r6, "dynamic_island") == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L14;
        r0.p();
        goto L14
    L7:
        if (Intrinsics.areEqual(r6, "locked_screen_card") == true) goto L10;
        r1 = false;
    L14:
        if (r8 == null) goto L16;
    L22:
        r4 = r8;
    L23:
        if (r4 == null) goto L25;
        com.obric.assistant.reporter.b.a(r4, null, 6);
    L25:
        IOAutoApi r9 = com.obric.assistant.oauto.b.a();
        if (r9 == null) goto L29;
        Application r2 = AppHost.a.getApplication();
        Intent r3 = new Intent();
        r3.putExtra("source_from", r6);
        r3.putExtra("auto_enter_call_user", r5);
        sea.b.a.getClass();
        sea.b.e(r3, r7);
        Unit r10 = Unit.INSTANCE;
        r9.g(r2, r3, true);
        return;
    L29:
        return;
    L16:
        if (Intrinsics.areEqual(r6, "dynamic_island") == true) goto L23;
        if (Intrinsics.areEqual(r6, "locked_screen_card") == false) goto L21;
        r8 = "notification_center";
        goto L22
    L21:
        r8 = null;
        goto L22
    }

    public static void l(String r17, String r18, String r19, String r20, String r21) {
        String r0 = r17;
        Intrinsics.checkNotNullParameter(r18, "clarify");
        Intrinsics.checkNotNullParameter(r19, "taskId");
        Intrinsics.checkNotNullParameter(r20, "complexSourceType");
        Intrinsics.checkNotNullParameter(r21, "referenceMsgId");
        FLogger.a.d("ObricStateUtils", "sendClarifyResult " + r18 + ", conversationId = " + r0 + ", taskId = " + r19 + ", complexSourceType = " + r20);
        if (r0 != null) goto L10;
        IObricChatService.a.getClass();
        IObricChatService r1 = IObricChatService.a.a();
        if (r1 == null) goto L9;
        wc9.e r2 = r1.h();
        if (r2 == null) goto L9;
        r0 = r2.a;
    L9:
        r0 = null;
    L10:
        String r5 = r0;
        if (r5 == null) goto L22;
        u1 r3 = RepoDispatcherDelegate.b.e().u1();
        String r7 = UUID.randomUUID().toString();
        Pair[] r6 = new Pair[7];
        boolean r9 = false;
        r6[0] = TuplesKt.to("o_task_type", "complex_task");
        r6[1] = TuplesKt.to("o_omni_intention", "task_reply");
        r6[2] = TuplesKt.to("o_omni_task_id", r19);
        String r8 = "1";
        r6[3] = TuplesKt.to("o_is_omni_agent", "1");
        r6[4] = TuplesKt.to("o_reference_msg_id", r21);
        r6[5] = TuplesKt.to("o_complex_source_type", r20);
        IObricTaskStatusManager r4 = (IObricTaskStatusManager) ServiceManager.get().getService(IObricTaskStatusManager.class);
        if (r4 != null) goto L15;
    L17:
        if (r9 == true) goto L20;
        r8 = "0";
    L20:
        r6[6] = TuplesKt.to("o_is_client_authenticated", r8);
        u1.a.f(r3, r18, r5, "", MapsKt.mapOf(r6), null, null, r7, false, null, "complex_task_clarify_answer", null, null, null, false, 31592);
        return;
    L15:
        if (r4.a() != true) goto L17;
        r9 = true;
        goto L17
    }

    public static /* synthetic */ void h(g r2, boolean r3, String r4, Bundle r5, String r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = "dynamic_island";
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        r2.getClass();
        g(r3, r4, r5, r6);
    }
}
