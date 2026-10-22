package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class QSMusicLoginStrategy implements i {
    public final u2.f a;
    public final u2.l b;
    public final String c;

    public static final class a {
    }

    public static final class b implements u2.h {
        public b() {
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object a() {
        return this.b;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.f c() {
        return this.a;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final StrategyType g() {
        return StrategyType.QS_MUSIC_LOGIN;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r10) {
        Intrinsics.checkNotNullParameter(r10, "meta");
        String r0 = this.a.c();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return k(r10, r0, null);
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c h(f r10) {
        Pair<u2.a, String> r11 = k(r10.c, "refused", null);
        u2.a r12 = (u2.a) r11.getFirst();
        String r13 = (String) r11.getSecond();
        FlowResult r14 = FlowResult.STOP_FLOW;
        u2.f r15 = this.a;
        if (r13 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == false) goto L12;
        r13 = this.a.e();
    L12:
        return new c(r14, null, null, r12, u2.f.a(r15, "refused", r13, 7));
    L5:
        if (r13.length() == 0) goto L8;
        r16 = false;
        goto L9
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.a i(u2.c r10) {
        Intrinsics.checkNotNullParameter(r10, "meta");
        String r0 = this.a.c();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r11 = this.b.f();
        if (r11 == null) goto L10;
        r1 = r11;
    L10:
        return (u2.a) k(r10, r0, r1).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r10, boolean r11) {
        String r0 = "granted";
        Pair<u2.a, String> r12 = k(r10.c, "granted", null);
        u2.a r13 = (u2.a) r12.getFirst();
        String r14 = (String) r12.getSecond();
        if (r11 == false) goto L5;
        FlowResult r15 = FlowResult.STOP_FLOW;
    L6:
        FlowResult r16 = r15;
        u2.f r17 = this.a;
        if (r11 == false) goto L9;
        r0 = "granted_by_history";
    L9:
        if (r14 != null) goto L11;
    L14:
        boolean r18 = true;
    L15:
        if (r18 == false) goto L18;
        r14 = this.a.e();
    L18:
        return new c(r16, null, null, r13, u2.f.a(r17, r0, r14, 7));
    L11:
        if (r14.length() == 0) goto L14;
        r18 = false;
        goto L15
    L5:
        r15 = FlowResult.CONTINUE_NEXT;
        goto L6
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object f(f r20, Continuation<? super Unit> r21) {
        int r1 = com.bytedance.ai.applet.login.r.a;
        final u2.c r10 = r20.c;
        u2.l r11 = this.b;
        final AppletAuthTaskMonitor.Session r0 = r20.i;
        Intrinsics.checkNotNullParameter(r10, "appMeta");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        String r12 = r11.b();
        boolean r13 = false;
        if (r12 != null) goto L5;
    L8:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L14;
        com.bytedance.ai.utils.g.a.e("QSMusicLoginProcessor", "handleAgree: authLink empty.");
        if (r0 == null) goto L49;
        r0.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLink empty", null, null, null, 480));
    L49:
        return Unit.INSTANCE;
    L14:
        int r15 = com.bytedance.ai.applet.login.a.a;
        com.bytedance.ai.applet.login.c r16 = com.bytedance.ai.applet.login.a.a(r11.b());
        String r17 = r16.d;
        String r18 = r16.f;
        String r19 = r16.c;
        if (r17 != null) goto L17;
    L20:
        boolean r22 = true;
    L21:
        if (r22 == true) goto L45;
        if (r18 != null) goto L24;
    L27:
        boolean r23 = true;
    L28:
        if (r23 == true) goto L45;
        if (r19 != null) goto L31;
    L32:
        r13 = true;
    L33:
        if (r13 == true) goto L45;
        u2.b r24 = r10.f;
        final String r25 = r24.a;
        HashMap<String, Object> r26 = r24.g;
        HashMap r27 = new HashMap();
        if (r26 == null) goto L38;
        r27.putAll(r26);
    L38:
        r27.put("current_page", "chat");
        r27.put("source", "doubao_apps_auth_request");
        r27.put("app_key", r10.a);
        r27.put("app_name", r10.b);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r28 = AppletRuntimeManager.d;
        if (r28 != null) goto L42;
        if (r0 == null) goto L49;
        r0.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_request", AppletAuthTaskMonitor.ErrorCode.CONTEXT_MISSING, "aiAbility is null", null, null, null, 480));
        goto L49
    L42:
        if (r0 == null) goto L44;
        r0.b();
    L44:
        r28.H(new com.bytedance.ai.applet.login.i(r17, r18, r19, r27), new com.bytedance.ai.applet.login.q(r0, r25, r10));
        goto L49
    L31:
        if (StringsKt.isBlank(r19) == false) goto L33;
    L24:
        if (StringsKt.isBlank(r18) == true) goto L27;
        r23 = false;
    L45:
        com.bytedance.ai.utils.g.a.e("QSMusicLoginProcessor", "handleAgree: authLink format error");
        if (r0 == null) goto L49;
        r0.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "aweme_auth_prepare", AppletAuthTaskMonitor.ErrorCode.AUTH_LINK_INVALID, "authLink format error", null, null, null, 480));
        goto L49
    L17:
        if (StringsKt.isBlank(r17) == true) goto L20;
        r22 = false;
        goto L21
    L5:
        if (StringsKt.isBlank(r12) == true) goto L8;
        r14 = false;
        goto L10
    }

    public QSMusicLoginStrategy(u2.f r10, u2.l r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public static final Object j(QSMusicLoginStrategy r10, String r11, Continuation r12) {
        r10.getClass();
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r13 = AppletRuntimeManager.d;
        if (r13 != null) goto L5;
        com.bytedance.ai.utils.g.a.e("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus failed: aiAbility is null");
        return Boxing.boxBoolean(false);
    L5:
        kotlinx.coroutines.j r1 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r12), 1);
        r1.C();
        b0 r14 = new b0(r1);
        com.bytedance.ai.utils.g.a.i("QSMusicLoginStrategyV2", "fetchQSMusicLoginStatus for " + r11 + "...");
        r13.c(r14);
        r1.i(new a0(r11));
        Object r15 = r1.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r12);
        return r15;
    L10:
        return r15;
    }

    public final Pair<u2.a, String> k(u2.c r18, String r19, String r20) {
        com.bytedance.ai.applet.grantingV2.b r10 = g.a(r19, this.c);
        if (r10 == null) goto L6;
    L55:
        if (r20 == null) goto L57;
    L59:
        String r11 = null;
    L60:
        u2.b r12 = r18.f;
        b r13 = new b();
        String r14 = r18.c;
        String r15 = r18.b;
        String r16 = this.b.g();
        if (r16 != null) goto L63;
        String r17 = "在豆包内使用" + r18.b;
    L64:
        String r110 = r10.a;
        boolean r111 = r10.b;
        String r1 = this.b.c();
        if (r1 != null) goto L67;
        r1 = "登录";
    L67:
        String r112 = r1;
        String r21 = this.b.d();
        if (r21 != null) goto L71;
        r21 = "不登录";
    L71:
        return new Pair(new u2.a(r12, r13, r14, r15, r17, r110, r111, r112, r21, false, false), r11);
    L63:
        r17 = r16;
        goto L64
    L57:
        if (Intrinsics.areEqual(r10.a, this.b.f()) == true) goto L59;
        Lazy r22 = com.bytedance.ai.applet.base.gson.e.a;
        r11 = com.bytedance.ai.applet.base.gson.e.c(u2.l.a(this.b, null, null, r10.a, null, null, null, 251));
        goto L60
    L6:
        switch(r19.hashCode()) {
            case -682587753: goto L44;
            case 280295099: goto L31;
            case 664583344: goto L28;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L53;
        };
    L53:
        com.bytedance.ai.utils.g.a.w("QSMusicLoginStrategyV2", "calculateCardUIState unknown status: ".concat(r19));
        com.bytedance.ai.applet.grantingV2.b r23 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L54:
        r10 = r23;
        goto L55
    L9:
        if (r19.equals("refused_by_history") == false) goto L53;
    L21:
        if (r20 != null) goto L25;
        String r24 = this.b.e();
        if (r24 != null) goto L26;
        r24 = "已拒绝登录汽水音乐";
    L26:
        r23 = new com.bytedance.ai.applet.grantingV2.b(r24, false);
        goto L54
    L25:
        r24 = r20;
        goto L26
    L12:
        if (r19.equals("granted_stopped") == false) goto L53;
    L34:
        if (r20 != null) goto L41;
        String r25 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_loggedIn");
        if (r25 == null) goto L40;
        String r26 = String.format(r25, Arrays.copyOf(new Object[]{r18.b}, 1));
        if (r26 == null) goto L40;
    L42:
        r23 = new com.bytedance.ai.applet.grantingV2.b(r26, false);
    L40:
        r26 = "已登录" + r18.b;
        goto L42
    L41:
        r26 = r20;
        goto L42
    L15:
        if (r19.equals("revoked") == false) goto L53;
    L47:
        if (r20 != null) goto L51;
        String r27 = this.b.f();
        if (r27 != null) goto L52;
        r27 = "登录后获取更优质的音乐体验";
    L52:
        r23 = new com.bytedance.ai.applet.grantingV2.b(r27, true);
        goto L54
    L51:
        r27 = r20;
        goto L52
    L18:
        if (r19.equals("refused") == true) goto L21;
    L28:
        if (r19.equals("granted_by_history") == true) goto L34;
    L31:
        if (r19.equals("granted") == true) goto L34;
    L44:
        if (r19.equals("pending") == true) goto L47;
        goto L53
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r19, boolean r20, boolean r21, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r22) {
        f r1 = r19;
        if ((r22 instanceof QSMusicLoginStrategy$onGrantingIntent$1) == false) goto L7;
        QSMusicLoginStrategy$onGrantingIntent$1 r10 = (QSMusicLoginStrategy$onGrantingIntent$1) r22;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        boolean r15 = true;
        u2.a r16 = null;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        boolean r17 = r10.Z$1;
        boolean r18 = r10.Z$0;
        u2.c r23 = (u2.c) r10.L$1;
        f r24 = (f) r10.L$0;
        ResultKt.throwOnFailure(r12);
        boolean r25 = r17;
        r1 = r24;
    L18:
        Boolean r26 = (Boolean) r12;
        if (r26 == null) goto L21;
        boolean r27 = r26.booleanValue();
    L23:
        if (r27 == false) goto L25;
        String r28 = "granted";
    L26:
        com.bytedance.ai.utils.g.a.i("QSMusicLoginStrategyV2", "onGrantingIntent: serverStatus=" + r28 + ", granted=" + r18 + ", isHistory=" + r25 + ", required=" + this.a.f());
        String r110 = "refused";
        if (Intrinsics.areEqual(r28, "granted") == false) goto L62;
        String r29 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_toast_loggedIn");
        if (r29 != null) goto L31;
        r29 = "你此前已完成登录";
    L31:
        String r111 = r29;
        Pair<u2.a, String> r30 = k(r23, "granted", null);
        u2.a r112 = (u2.a) r30.getFirst();
        String r31 = (String) r30.getSecond();
        if (r18 == false) goto L52;
        if (r25 == false) goto L43;
        FlowResult r113 = FlowResult.STOP_FLOW;
        u2.f r32 = this.a;
        if (r31 != null) goto L37;
    L40:
        if (r15 == false) goto L42;
        r31 = this.a.e();
    L42:
        com.bytedance.ai.applet.grantingV2.a r33 = new com.bytedance.ai.applet.grantingV2.a(r113, "SUCCESS", r111, r112, u2.f.a(r32, "granted_by_history", r31, 7));
    L61:
        return r33;
    L37:
        if (r31.length() == 0) goto L40;
        r15 = false;
        goto L40
    L43:
        FlowResult r114 = FlowResult.CONTINUE_NEXT;
        u2.f r34 = this.a;
        if (r31 != null) goto L46;
    L49:
        if (r15 == false) goto L51;
        r31 = this.a.e();
    L51:
        r33 = new com.bytedance.ai.applet.grantingV2.a(r114, "SUCCESS", r111, r112, u2.f.a(r34, "granted", r31, 7));
        goto L61
    L46:
        if (r31.length() == 0) goto L49;
        r15 = false;
        goto L49
    L52:
        FlowResult r115 = FlowResult.STOP_FLOW;
        u2.f r35 = this.a;
        if (r31 != null) goto L55;
    L58:
        if (r15 == false) goto L60;
        r31 = this.a.e();
    L60:
        r33 = new com.bytedance.ai.applet.grantingV2.a(r115, "WARNING", r111, r112, u2.f.a(r35, "refused", r31, 7));
        goto L61
    L55:
        if (r31.length() == 0) goto L58;
        r15 = false;
        goto L58
    L62:
        if (r18 == false) goto L67;
        u2.a r36 = r1.h;
        if (r36 == null) goto L79;
        r16 = u2.a.a(r36, true, false, 1535);
    L79:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r16, null);
    L67:
        Pair<u2.a, String> r37 = k(r23, "refused", null);
        u2.a r116 = (u2.a) r37.getFirst();
        String r38 = (String) r37.getSecond();
        FlowResult r117 = FlowResult.STOP_FLOW;
        u2.f r39 = this.a;
        if (r25 == false) goto L70;
        r110 = "refused_by_history";
    L70:
        if (r38 != null) goto L72;
    L75:
        if (r15 == false) goto L78;
        r38 = this.a.e();
    L78:
        return new com.bytedance.ai.applet.grantingV2.a(r117, null, null, r116, u2.f.a(r39, r110, r38, 7));
    L72:
        if (r38.length() == 0) goto L75;
        r15 = false;
        goto L75
    L25:
        r28 = "pending";
        goto L26
    L21:
        r27 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r23 = r1.c;
        QSMusicLoginStrategy$onGrantingIntent$hasLogin$1 r40 = new QSMusicLoginStrategy$onGrantingIntent$hasLogin$1(r1, this, r23, null);
        r10.L$0 = r1;
        r10.L$1 = r23;
        r10.Z$0 = r20;
        r25 = r21;
        r10.Z$1 = r25;
        r10.label = 1;
        r12 = TimeoutKt.c(1000, r40, r10);
        if (r12 != r13) goto L17;
        return r13;
    L17:
        r18 = r20;
    L7:
        r10 = new QSMusicLoginStrategy$onGrantingIntent$1(this, r22);
        goto L8
    }
}
