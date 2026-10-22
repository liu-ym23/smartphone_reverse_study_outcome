package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LoginStrategy implements i {
    public final u2.f a;
    public final u2.j b;
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
        return StrategyType.LOGIN;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r10) {
        Intrinsics.checkNotNullParameter(r10, "meta");
        String r0 = this.a.c();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return j(r10, r0, null);
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c h(f r10) {
        Pair<u2.a, String> r11 = j(r10.c, "refused", null);
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
        String r11 = this.b.b();
        if (r11 == null) goto L10;
        r1 = r11;
    L10:
        return (u2.a) j(r10, r0, r1).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r10, boolean r11) {
        String r0 = "granted";
        Pair<u2.a, String> r12 = j(r10.c, "granted", null);
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
    public final Object f(f r10, Continuation<? super Unit> r11) {
        LoginProcessor r12 = LoginProcessor.a;
        u2.c r0 = r10.c;
        u2.j r1 = this.b;
        AppletAuthTaskMonitor.Session r13 = r10.i;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r0, "appMeta");
        Intrinsics.checkNotNullParameter(r1, "relatedData");
        LoginProcessor.e(r0, r1, null, "chat", r13);
        return Unit.INSTANCE;
    }

    public LoginStrategy(u2.f r10, u2.j r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public final Pair<u2.a, String> j(u2.c r20, String r21, String r22) {
        com.bytedance.ai.applet.grantingV2.b r10 = g.a(r21, this.c);
        String r11 = null;
        if (r10 == null) goto L6;
    L61:
        if (r22 == null) goto L63;
    L65:
        u2.b r12 = r20.f;
        b r13 = new b();
        String r14 = r20.c;
        String r15 = r20.b;
        com.bytedance.ai.utils.l r16 = com.bytedance.ai.utils.l.a;
        String r17 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_chatCard_title_useApp");
        if (r17 == null) goto L73;
        Object[] r18 = new Object[2];
        String r19 = com.bytedance.ai.utils.l.e(r16, "larus_LarkIM_Common_Doubao_Brandname");
        if (r19 != null) goto L70;
        r19 = "豆包";
    L70:
        r18[0] = r19;
        r18[1] = r20.b;
        String r23 = String.format(r17, Arrays.copyOf(r18, 2));
        if (r23 == null) goto L73;
        String r110 = r23;
    L74:
        String r111 = r10.a;
        boolean r112 = r10.b;
        String r1 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_chatCard_btn_logIn");
        if (r1 != null) goto L77;
        r1 = "登录";
    L77:
        String r24 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_chatCard_btn_notNow");
        if (r24 != null) goto L81;
        r24 = "暂不登录";
    L81:
        return new Pair(new u2.a(r12, r13, r14, r15, r110, r111, r112, r1, r24, false, false), r11);
    L73:
        r110 = "在豆包内使用" + r20.b;
        goto L74
    L63:
        if (Intrinsics.areEqual(r10.a, this.b.b()) == true) goto L65;
        Lazy r25 = com.bytedance.ai.applet.base.gson.e.a;
        r11 = com.bytedance.ai.applet.base.gson.e.c(u2.j.a(this.b, null, null, null, null, r10.a, 111));
        goto L65
    L6:
        switch(r21.hashCode()) {
            case -682587753: goto L47;
            case 280295099: goto L34;
            case 664583344: goto L31;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L59;
        };
    L59:
        com.bytedance.ai.utils.g.a.w("LoginStrategyV2", "calculateCardUIState unknown status: ".concat(r21));
        com.bytedance.ai.applet.grantingV2.b r26 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L60:
        r10 = r26;
        goto L61
    L9:
        if (r21.equals("refused_by_history") == false) goto L59;
    L21:
        if (r22 != null) goto L28;
        String r27 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_rejectLogin");
        if (r27 == null) goto L25;
        String r28 = String.format(r27, Arrays.copyOf(new Object[]{r20.b}, 1));
    L26:
        if (r28 != null) goto L29;
        r28 = "已拒绝登录" + r20.b;
    L29:
        r26 = new com.bytedance.ai.applet.grantingV2.b(r28, false);
        goto L60
    L25:
        r28 = null;
        goto L26
    L28:
        r28 = r22;
        goto L29
    L12:
        if (r21.equals("granted_stopped") == false) goto L59;
    L37:
        if (r22 != null) goto L44;
        String r29 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_loggedIn");
        if (r29 == null) goto L41;
        String r30 = String.format(r29, Arrays.copyOf(new Object[]{r20.b}, 1));
    L42:
        if (r30 != null) goto L45;
        r30 = "已登录" + r20.b;
    L45:
        r26 = new com.bytedance.ai.applet.grantingV2.b(r30, false);
        goto L60
    L41:
        r30 = null;
        goto L42
    L44:
        r30 = r22;
        goto L45
    L15:
        if (r21.equals("revoked") == false) goto L59;
    L50:
        if (r22 != null) goto L57;
        String r31 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_logIn");
        if (r31 == null) goto L54;
        String r32 = String.format(r31, Arrays.copyOf(new Object[]{r20.b}, 1));
    L55:
        if (r32 != null) goto L58;
        r32 = "需登录" + r20.b + "后才可以继续使用";
    L58:
        r26 = new com.bytedance.ai.applet.grantingV2.b(r32, true);
        goto L60
    L54:
        r32 = null;
        goto L55
    L57:
        r32 = r22;
        goto L58
    L18:
        if (r21.equals("refused") == true) goto L21;
    L31:
        if (r21.equals("granted_by_history") == true) goto L37;
    L34:
        if (r21.equals("granted") == true) goto L37;
    L47:
        if (r21.equals("pending") == true) goto L50;
        goto L59
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r23, boolean r24, boolean r25, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r26) {
        f r1 = r23;
        if ((r26 instanceof LoginStrategy$onGrantingIntent$1) == false) goto L7;
        LoginStrategy$onGrantingIntent$1 r10 = (LoginStrategy$onGrantingIntent$1) r26;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        boolean r15 = false;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        boolean r16 = r10.Z$1;
        boolean r17 = r10.Z$0;
        u2.c r18 = (u2.c) r10.L$1;
        f r19 = (f) r10.L$0;
        ResultKt.throwOnFailure(r12);
        boolean r20 = r16;
        r1 = r19;
        Object r21 = r12;
        boolean r22 = r17;
    L18:
        if (((Boolean) r21).booleanValue() == false) goto L20;
        String r27 = "granted";
    L21:
        com.bytedance.ai.utils.g.a.i("LoginStrategyV2", "onGrantingIntent: serverStatus=" + r27 + ", granted=" + r22 + ", isHistory=" + r20 + ", required=" + this.a.f());
        String r28 = "refused";
        u2.a r110 = null;
        if (Intrinsics.areEqual(r27, "granted") == false) goto L54;
        String r29 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_toast_loggedIn");
        if (r29 != null) goto L26;
        r29 = "你此前已完成登录";
    L26:
        String r111 = r29;
        Pair<u2.a, String> r30 = j(r18, "granted", null);
        u2.a r210 = (u2.a) r30.getFirst();
        String r31 = (String) r30.getSecond();
        if (r22 == false) goto L45;
        if (r20 == false) goto L37;
        FlowResult r112 = FlowResult.STOP_FLOW;
        u2.f r32 = this.a;
        if (r31 != null) goto L32;
    L33:
        r15 = true;
    L34:
        if (r15 == false) goto L36;
        r31 = this.a.e();
    L36:
        com.bytedance.ai.applet.grantingV2.a r33 = new com.bytedance.ai.applet.grantingV2.a(r112, "SUCCESS", r111, r210, u2.f.a(r32, "granted_by_history", r31, 7));
    L53:
        return r33;
    L32:
        if (r31.length() != 0) goto L34;
    L37:
        FlowResult r113 = FlowResult.CONTINUE_NEXT;
        u2.f r34 = this.a;
        if (r31 != null) goto L40;
    L41:
        r15 = true;
    L42:
        if (r15 == false) goto L44;
        r31 = this.a.e();
    L44:
        r33 = new com.bytedance.ai.applet.grantingV2.a(r113, null, null, r210, u2.f.a(r34, "granted", r31, 7));
        goto L53
    L40:
        if (r31.length() != 0) goto L42;
    L45:
        FlowResult r114 = FlowResult.STOP_FLOW;
        u2.f r35 = this.a;
        if (r31 != null) goto L48;
    L49:
        r15 = true;
    L50:
        if (r15 == false) goto L52;
        r31 = this.a.e();
    L52:
        r33 = new com.bytedance.ai.applet.grantingV2.a(r114, "WARNING", r111, r210, u2.f.a(r35, "refused", r31, 7));
        goto L53
    L48:
        if (r31.length() != 0) goto L50;
    L54:
        if (r22 == false) goto L59;
        u2.a r36 = r1.h;
        if (r36 == null) goto L70;
        r110 = u2.a.a(r36, true, false, 1535);
    L70:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r110, null);
    L59:
        Pair<u2.a, String> r37 = j(r18, "refused", null);
        u2.a r115 = (u2.a) r37.getFirst();
        String r38 = (String) r37.getSecond();
        FlowResult r116 = FlowResult.STOP_FLOW;
        u2.f r39 = this.a;
        if (r20 == false) goto L62;
        r28 = "refused_by_history";
    L62:
        if (r38 != null) goto L64;
    L65:
        r15 = true;
    L66:
        if (r15 == false) goto L69;
        r38 = this.a.e();
    L69:
        return new com.bytedance.ai.applet.grantingV2.a(r116, null, null, r115, u2.f.a(r39, r28, r38, 7));
    L64:
        if (r38.length() != 0) goto L66;
    L20:
        r27 = "pending";
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r18 = r1.c;
        String r40 = r18.a;
        r10.L$0 = r1;
        r10.L$1 = r18;
        r22 = r24;
        r10.Z$0 = r22;
        r20 = r25;
        r10.Z$1 = r20;
        r10.label = 1;
        r21 = Boxing.boxBoolean(false);
        if (r21 != r13) goto L18;
        return r13;
    L7:
        r10 = new LoginStrategy$onGrantingIntent$1(this, r26);
        goto L8
    }
}
