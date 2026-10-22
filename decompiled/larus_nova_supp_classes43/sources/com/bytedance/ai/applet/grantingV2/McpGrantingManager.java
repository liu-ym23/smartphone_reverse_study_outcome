package com.bytedance.ai.applet.grantingV2;

import android.os.SystemClock;
import com.bytedance.ai.applet.granting.GrantingAction;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class McpGrantingManager {
    public static final McpGrantingManager a = null;
    public static final ConcurrentHashMap<String, f> b = null;
    public static final CoroutineScope c = null;
    public static final List<h> d = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[StrategyType.values().length];
            r0[StrategyType.PERMISSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r0[StrategyType.FIRST_PARTY_LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L38:
            r0[StrategyType.PRIVACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L28:
            r0[StrategyType.LOGIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L30:
            r0[StrategyType.QS_MUSIC_LOGIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[GrantingAction.values().length];
            r1[GrantingAction.AGREED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L24:
            r1[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L32:
            r1[GrantingAction.DISMISSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L14:
            b = r1;
        }
    }

    public McpGrantingManager() {
    }

    static {
        a = new McpGrantingManager();
        b = new ConcurrentHashMap();
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        d = CollectionsKt.listOf(new h[]{new z(), new e(), new k(), new c0(), new x()});
    }

    public static h e(u2.f r10) {
        Iterator<T> r0 = d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((h) r1).a(r10) == false) goto L4;
    L10:
        return (h) r1;
    L8:
        r1 = null;
        goto L10
    }

    public static String h(String r1) {
        if (r1 != null) goto L4;
    L36:
        return "";
    L4:
        switch(r1.hashCode()) {
            case -1750762604: goto L33;
            case -653473286: goto L29;
            case -21617665: goto L25;
            case 411225387: goto L21;
            case 421939912: goto L18;
            case 934308869: goto L14;
            case 1403059833: goto L10;
            case 2106603706: goto L7;
            default: goto L36;
        };
    L7:
        if (r1.equals("scope.userFuzzyLocation") == false) goto L36;
    L31:
        return com.bytedance.android.ec.core.event.a.KEY_LOCATION;
    L10:
        if (r1.equals("scope.addPhoneContact") == false) goto L36;
        return "addPhoneContact";
    L14:
        if (r1.equals("scope.addPhoneCalendar") == false) goto L36;
        return "addPhoneCalendar";
    L18:
        if (r1.equals("scope.userLocationBackground") == false) goto L36;
    L21:
        if (r1.equals("scope.record") == false) goto L36;
        return "microphone";
    L25:
        if (r1.equals("scope.camera") == false) goto L36;
        return "camera";
    L29:
        if (r1.equals("scope.userLocation") == true) goto L31;
    L33:
        if (r1.equals("scope.bluetooth") == false) goto L36;
        return "bluetooth";
    }

    public static String n(i r1) {
        if (r1 == null) goto L4;
        StrategyType r10 = r1.g();
    L5:
        if (r10 != null) goto L7;
        int r11 = -1;
    L9:
        if (r11 != 3) goto L11;
        return "privacy_commit";
    L11:
        return "user_decision";
    L7:
        r11 = a.a[r10.ordinal()];
        goto L9
    L4:
        r10 = null;
        goto L5
    }

    public static u2.c c(u2.b r10, u2.e r11) {
        String r0 = r11.d();
        if (r0 != null) goto L5;
        String r12 = "";
    L6:
        String r1 = r11.e();
        if (r1 != null) goto L9;
        String r13 = "";
    L10:
        String r14 = r11.c();
        if (r14 != null) goto L13;
        String r15 = "";
    L14:
        String r16 = r11.g();
        if (r16 != null) goto L17;
        String r17 = "";
    L18:
        String r18 = r11.f();
        if (r18 != null) goto L22;
        r18 = "";
    L22:
        return new u2.c(r12, r13, r15, r17, r18, r10);
    L17:
        r17 = r16;
        goto L18
    L13:
        r15 = r14;
        goto L14
    L9:
        r13 = r1;
        goto L10
    L5:
        r12 = r0;
        goto L6
    }

    public static void d(String r12, String r13) {
        Iterator r0 = CollectionsKt.toList(b.entrySet()).iterator();
    L4:
        if (r0.hasNext() == false) goto L41;
        Map.Entry r1 = (Map.Entry) r0.next();
        final String r10 = (String) r1.getKey();
        f r11 = (f) r1.getValue();
        boolean r14 = false;
        if (Intrinsics.areEqual(r12, "new_message") == false) goto L15;
        com.bytedance.applet.impl.j r15 = r11.e;
        if (r15 != null) goto L10;
    L12:
        boolean r16 = false;
    L13:
        if (r16 == false) goto L15;
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "expireCurrentInteractiveCards: Skip latest card, msgID=" + r10);
        goto L4
    L10:
        if (r15.a(r10) != true) goto L12;
        r16 = true;
    L15:
        i r17 = r11.g;
        if (r17 == null) goto L17;
        u2.f r18 = r17.c();
        if (g.b(r18, r11.a.b()) == true) goto L20;
        if (g.c(r18.c()) == false) goto L23;
        u2.e r19 = u2.e.a(r11.a, "expired", null, 191);
        a.getClass();
        h r20 = e(r18);
        if (r20 == null) goto L40;
        i r21 = r20.b(r18, r19.b());
        if (r21 == null) goto L40;
        Pair<u2.a, String> r22 = r21.b(r11.c);
        u2.a r23 = (u2.a) r22.getFirst();
        String r24 = (String) r22.getSecond();
        if (r24 != null) goto L32;
    L33:
        r14 = true;
    L34:
        if (r14 == false) goto L36;
        r24 = r18.e();
    L36:
        u2.e r25 = v.c(r19, u2.f.a(r18, null, r24, 15));
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r11.a = r25;
        String r26 = r11.c.f.c;
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "expireCurrentInteractiveCards: msgID=" + r10 + ", latestMsgID=" + r13 + ", reason=" + r12);
        r11.d.a(r10, r23);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r27 = AppletRuntimeManager.d;
        if (r27 == null) goto L39;
        r27.t(r10, r26, com.bytedance.ai.applet.base.gson.e.c(r25), new m(r10));
    L39:
        b.remove(r10);
        goto L4
    L32:
        if (r24.length() != 0) goto L34;
    L40:
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "expireCurrentInteractiveCards: Failed to create expired strategy for msgID=" + r10);
        goto L4
    L23:
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "expireCurrentInteractiveCards: Skip terminal permissionStatus=" + r18.c() + ", msgID=" + r10);
        goto L4
    L20:
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "expireCurrentInteractiveCards: Already expired, msgID=" + r10);
        b.remove(r10);
        goto L4
    L17:
        com.bytedance.ai.utils.g.a.w("McpGrantingManagerV2", "expireCurrentInteractiveCards: No strategy found for msgID=" + r10);
        goto L4
    }

    public static void f(f r10, AppletAuthTaskMonitor.a r11) {
        AppletAuthTaskMonitor.Session r0 = r10.i;
        if (r0 != null) goto L5;
    L8:
        r10.i = null;
        return;
    L5:
        if (r11.b != null) goto L7;
        r11 = AppletAuthTaskMonitor.a.a(r11, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded");
    L7:
        r0.d(r11);
        goto L8
    }

    public static void g(f r13, boolean r14) {
        u2.b r0 = r13.c.f;
        String r1 = r0.a;
        String r10 = r0.b;
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "finishGrantingFlow: msgID=" + r1 + ", queryMsgID=" + r10 + ", result=" + r14);
        if (r13.i != null) goto L5;
    L16:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L19;
        r15.E(r10, r14);
    L19:
        b.remove(r1);
        return;
    L5:
        if (r14 == false) goto L7;
        String r11 = "success";
    L8:
        String r12 = r11;
        AppletAuthTaskMonitor.ErrorCode r16 = null;
        if (r14 == false) goto L11;
        String r17 = null;
    L12:
        if (r14 == true) goto L15;
        r16 = AppletAuthTaskMonitor.ErrorCode.UNKNOWN;
    L15:
        f(r13, new AppletAuthTaskMonitor.a(r12, null, r17, r16, null, null, null, null, 498));
        goto L16
    L11:
        r17 = "user_decision";
        goto L12
    L7:
        r11 = MessageIndication.STATUS_FAILED;
        goto L8
    }

    public static void i(u2.c r17, GrantingAction r18) {
        Intrinsics.checkNotNullParameter(r17, "appletMetaData");
        Intrinsics.checkNotNullParameter(r18, "action");
        String r10 = r17.f.a;
        f r11 = b.get(r10);
        if (r11 != null) goto L6;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "onConfirmationResult: No data found for msgID: " + r10);
        return;
    L6:
        u2.a r12 = r11.h;
        if (r12 == null) goto L10;
        r12.k = false;
        r12.j = false;
        r11.d.a(r10, r12);
    L10:
        if (r18 != GrantingAction.DISMISSED) goto L13;
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "User action is DISMISSED");
        f(r11, new AppletAuthTaskMonitor.a("user_cancelled", null, "user_decision", AppletAuthTaskMonitor.ErrorCode.USER_CANCELLED, null, null, null, null, 498));
        r11.j.set(false);
        r11.k.set(0);
        return;
    L13:
        i r13 = r11.g;
        if (r13 != null) goto L17;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "onConfirmationResult: No strategy found for msgID: " + r10);
        return;
    L17:
        BuildersKt.launch$default(c, null, null, new McpGrantingManager$onConfirmationResult$2(r18, r13, r11, r10, r17, null), 3, null);
    }

    public static String k(i r10, u2.f r11) {
        if (r10 == null) goto L5;
        StrategyType r1 = r10.g();
    L7:
        if (r1 == StrategyType.PERMISSION) goto L9;
        return null;
    L9:
        if (r11 == null) goto L13;
        String r12 = r11.c();
        if (r12 == null) goto L13;
        return r12;
    L13:
        return r10.c().c();
    L5:
        r1 = null;
        goto L7
    }

    public static void l(f r10, boolean r11) {
        String r0 = r10.c.f.a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<u2.f> r1 = r10.b;
        i r12 = r10.g;
        if (r12 == null) goto L7;
        u2.f r13 = r12.c();
        if (r13 == null) goto L7;
        Integer r14 = Integer.valueOf(r13.d());
    L8:
        u2.f r15 = v.a(r1, r14, r10.a.b());
        if (r15 != null) goto L14;
        com.bytedance.ai.utils.g.a.i("McpGrantingManagerV2", "All granting items processed for " + r0 + ", fromBindData: " + r11);
        if (r11 == true) goto L24;
        g(r10, true);
        return;
    L24:
        return;
    L14:
        h r16 = e(r15);
        if (r16 != null) goto L18;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "No provider found for " + r0 + ": " + r15.b());
        return;
    L18:
        i r17 = r16.b(r15, r10.a.b());
        if (r17 != null) goto L22;
        com.bytedance.ai.utils.g.a.e("McpGrantingManagerV2", "Strategy failed to create for " + r0 + '.');
        return;
    L22:
        u2.a r18 = r17.i(r10.c);
        r10.g = r17;
        r10.h = r18;
        r10.j.set(false);
        r10.k.set(0);
        r10.d.a(r0, r18);
        return;
    L7:
        r14 = null;
        goto L8
    }

    public static String m(i r10, u2.f r11) {
        if (r10 == null) goto L5;
        StrategyType r1 = r10.g();
    L7:
        if (r1 == StrategyType.PERMISSION) goto L9;
        return null;
    L9:
        if (r11 == null) goto L12;
        String r12 = r11.c();
        if (r12 == null) goto L12;
    L14:
        if (Intrinsics.areEqual(r12, "granted") == false) goto L17;
        return "granted";
    L17:
        if (Intrinsics.areEqual(r12, "granted_without_system") == false) goto L21;
        return "refused";
    L21:
        return null;
    L12:
        r12 = r10.c().c();
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public static void j(boolean r33, WeakReference r34, u2.a r35) {
        Intrinsics.checkNotNullParameter(r34, "contextWk");
        Intrinsics.checkNotNullParameter(r35, "cardData");
        u2.b r1 = r35.a;
        String r10 = r1.a;
        String r11 = r1.c;
        com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
        r12.i("McpGrantingManagerV2", "onMessageCardAction: msg: " + r10 + ", card: " + r11 + ", granted: " + r33);
        f r13 = b.get(r10);
        if (r13 != null) goto L6;
        r12.e("McpGrantingManagerV2", "onMessageCardAction: No context found for msgID: " + r10);
        return;
    L6:
        i r14 = r13.g;
        if (r14 != null) goto L11;
        r12.e("McpGrantingManagerV2", "onMessageCardAction: No strategy found for msgID: " + r10);
        return;
    L11:
        if (g.b(r14.c(), r13.a.b()) == false) goto L14;
        r12.i("McpGrantingManagerV2", "onMessageCardAction: Ignore expired granting card action, msgID=" + r10);
        return;
    L14:
        String r15 = r13.c.f.a;
        long r16 = SystemClock.elapsedRealtime();
        boolean r17 = true;
        if (r13.j.compareAndSet(false, true) == false) goto L17;
        r12.i("McpGrantingManagerV2", "tryStartActionHandling: set actionHandling true, msgID=" + r15);
        r13.k.set(r16);
    L28:
        if (r17 == true) goto L31;
        r12.i("McpGrantingManagerV2", "onMessageCardAction: Ignore duplicate action, msgID=" + r10);
        return;
    L31:
        String r18 = "aweme_login";
        if (r14.g() != StrategyType.PRIVACY) goto L34;
        r13.i = null;
    L54:
        i r19 = r13.g;
        if (r19 != null) goto L57;
        r12.w("McpGrantingManagerV2", "clickTracking: No strategy found");
    L87:
        r13.f = r34;
        com.bytedance.applet.impl.j r0 = r13.e;
        if (r0 == null) goto L90;
        boolean r110 = r0.a(r10);
    L91:
        BuildersKt.launch$default(c, null, null, new McpGrantingManager$onMessageCardAction$1(r13, r35, r33, r10, r14, !r110, r11, null), 3, null);
        return;
    L90:
        r110 = false;
        goto L91
    L57:
        if (r33 == false) goto L59;
        String r20 = "allow";
    L60:
        StrategyType r21 = r19.g();
        int[] r22 = a.a;
        int r23 = r22[r21.ordinal()];
        if (r23 != 1) goto L63;
        Object r24 = r19.a();
        if ((r24 instanceof u2.k) == false) goto L82;
        u2.k r25 = (u2.k) r24;
    L83:
        if (r25 == null) goto L85;
        String r111 = r25.c();
    L86:
        com.bytedance.ai.monitor.b.b("doubao_apps_system_auth_card_click", new o(h(r111), r13, r20));
        goto L87
    L85:
        r111 = null;
        goto L86
    L82:
        r25 = null;
        goto L83
    L63:
        if (r23 == 2) goto L70;
        if (r23 == 3) goto L70;
        if (r23 == 4) goto L70;
        if (r23 == 5) goto L70;
        throw new NoWhenBranchMatchedException();
    L70:
        int r26 = r22[r19.g().ordinal()];
        if (r26 == 2) goto L78;
        if (r26 == 3) goto L77;
        if (r26 == 4) goto L76;
        if (r26 == 5) goto L76;
        r18 = "";
    L76:
        r18 = "login";
        goto L78
    L77:
        r18 = "privacy";
    L78:
        com.bytedance.ai.monitor.b.b("doubao_apps_agreement_card_click", new p(r20, r13, r18));
        goto L87
    L59:
        r20 = "reject";
        goto L60
    L34:
        SecureRandom r27 = AppletAuthTaskMonitor.a;
        u2.f r28 = r14.c();
        Object r112 = r14.a();
        if ((r112 instanceof u2.k) == false) goto L37;
        u2.k r113 = (u2.k) r112;
    L38:
        StrategyType r114 = r14.g();
        int[] r115 = a.a;
        if (r115[r114.ordinal()] != 1) goto L41;
        String r29 = "authorize";
    L42:
        int r116 = r115[r14.g().ordinal()];
        if (r116 == 1) goto L47;
        if (r116 == 2) goto L46;
        String r117 = "normal_login";
    L48:
        String r210 = r117;
    L49:
        u2.c r118 = r13.c;
        String r119 = r118.a;
        u2.b r120 = r118.f;
        String r30 = r120.a;
        String r121 = r120.c;
        String r31 = r28.b();
        if (r113 == null) goto L52;
        String r32 = r113.c();
    L53:
        r13.i = AppletAuthTaskMonitor.g(new AppletAuthTaskMonitor.b(r29, "mcp", r210, "AIMcpGrantingManager.executeCurrentTask", r119, "widget_container", null, null, r30, r121, r31, r32, 192));
        goto L54
    L52:
        r32 = null;
        goto L53
    L46:
        r210 = "aweme_login";
        goto L49
    L47:
        r117 = "applet_scope";
        goto L48
    L41:
        r29 = "login";
        goto L42
    L37:
        r113 = null;
        goto L38
    L17:
        long r122 = r13.k.get();
        if (r122 > 0) goto L20;
    L22:
        boolean r123 = false;
    L23:
        if (r123 == true) goto L25;
    L27:
        r17 = false;
        goto L28
    L25:
        if (r13.k.compareAndSet(r122, r16) == false) goto L27;
        r12.i("McpGrantingManagerV2", "tryStartActionHandling: previous action expired, msgID=" + r15);
        r17 = true;
        goto L28
    L20:
        if ((r16 - r122) < 3000) goto L22;
        r123 = true;
        goto L23
    }

    public static final void a(McpGrantingManager r25, f r26, boolean r27, u2.f r28) {
        r25.getClass();
        i r10 = r26.g;
        if (r27 == false) goto L11;
        if (r10 == null) goto L6;
        StrategyType r11 = r10.g();
    L8:
        if (r11 != StrategyType.PERMISSION) goto L11;
        if (r28 != null) goto L11;
        AppletAuthTaskMonitor.a r1 = new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, null, "permission_post", AppletAuthTaskMonitor.ErrorCode.API_FAILED, null, null, null, null, 498);
    L15:
        f(r26, r1);
        return;
    L6:
        r11 = null;
    L11:
        if (r27 == false) goto L13;
        AppletAuthTaskMonitor.a r12 = new AppletAuthTaskMonitor.a("success", null, null, null, null, k(r10, r28), null, k(r10, r28), 190);
    L14:
        r1 = r12;
        goto L15
    L13:
        r12 = new AppletAuthTaskMonitor.a("user_refused", null, n(r10), AppletAuthTaskMonitor.ErrorCode.USER_REFUSED, null, k(r10, r28), null, k(r10, r28), 178);
        goto L14
    }

    public static final void b(McpGrantingManager r23, f r24, GrantingAction r25, u2.f r26) {
        r23.getClass();
        i r10 = r24.g;
        int r11 = a.b[r25.ordinal()];
        if (r11 != 1) goto L5;
        AppletAuthTaskMonitor.a r1 = new AppletAuthTaskMonitor.a("success", null, null, null, null, k(r10, r26), m(r10, r26), k(r10, r26), 62);
    L37:
        f(r24, r1);
        return;
    L5:
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        r1 = new AppletAuthTaskMonitor.a("user_cancelled", null, n(r10), AppletAuthTaskMonitor.ErrorCode.USER_CANCELLED, null, null, null, null, 498);
        goto L37
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        String r12 = null;
        if (r10 == null) goto L13;
        StrategyType r13 = r10.g();
    L14:
        if (r13 != null) goto L16;
        int r14 = -1;
    L17:
        if (r14 == 1) goto L23;
        if (r14 == 2) goto L22;
        if (r14 == 3) goto L21;
        String r15 = "user_decision";
    L24:
        if (r10 == null) goto L26;
        StrategyType r16 = r10.g();
    L28:
        if (r16 != StrategyType.PERMISSION) goto L34;
        if (r26 == null) goto L32;
        r12 = r26.c();
    L32:
        if (Intrinsics.areEqual(r12, "granted_without_system") == false) goto L34;
        AppletAuthTaskMonitor.ErrorCode r17 = AppletAuthTaskMonitor.ErrorCode.SYSTEM_PERMISSION_DENIED;
    L35:
        r1 = new AppletAuthTaskMonitor.a("user_refused", null, r15, r17, null, k(r10, r26), m(r10, r26), k(r10, r26), 50);
    L34:
        r17 = AppletAuthTaskMonitor.ErrorCode.USER_REFUSED;
        goto L35
    L26:
        r16 = null;
        goto L28
    L21:
        r15 = "privacy_commit";
        goto L24
    L22:
        r15 = "aweme_auth_request";
        goto L24
    L23:
        r15 = "system_permission";
        goto L24
    L16:
        r14 = a.a[r13.ordinal()];
        goto L17
    L13:
        r13 = null;
        goto L14
    }
}
