package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.applet.login.LoginProcessor;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PrivacyStrategy implements i {
    public static final /* synthetic */ int d = 0;
    public final u2.f a;
    public final u2.j b;
    public final String c;

    public static final class a {
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
        return StrategyType.PRIVACY;
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Pair<u2.a, String> b(u2.c r10) {
        Intrinsics.checkNotNullParameter(r10, "meta");
        String r0 = this.a.c();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return j(this, r10, r0);
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c h(f r10) {
        Pair r11 = j(this, r10.c, "refused");
        u2.a r12 = (u2.a) r11.getFirst();
        String r13 = (String) r11.getSecond();
        FlowResult r1 = FlowResult.STOP_FLOW;
        u2.f r14 = this.a;
        if (r13 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == false) goto L12;
        r13 = this.a.e();
    L12:
        return new c(r1, null, null, r12, u2.f.a(r14, "refused", r13, 7));
    L5:
        if (r13.length() == 0) goto L8;
        r15 = false;
        goto L9
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final u2.a i(u2.c r10) {
        Intrinsics.checkNotNullParameter(r10, "meta");
        String r0 = this.a.c();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return (u2.a) j(this, r10, r0).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r10, boolean r11) {
        String r0 = "granted";
        Pair r12 = j(this, r10.c, "granted");
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
        LoginProcessor.f(r0, r1, null, "chat", r13);
        return Unit.INSTANCE;
    }

    public PrivacyStrategy(u2.f r10, u2.j r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public static Pair j(PrivacyStrategy r17, u2.c r18, String r19) {
        b r10 = g.a(r19, r17.c);
        if (r10 == null) goto L6;
    L51:
        u2.b r11 = r18.f;
        y r12 = new y();
        String r13 = r18.c;
        String r14 = r18.b;
        com.bytedance.ai.utils.l r15 = com.bytedance.ai.utils.l.a;
        String r16 = com.bytedance.ai.utils.l.e(r15, "larus_appEntry_chatCard_title_useApp");
        if (r16 == null) goto L59;
        Object[] r110 = new Object[2];
        String r111 = com.bytedance.ai.utils.l.e(r15, "larus_LarkIM_Common_Doubao_Brandname");
        if (r111 != null) goto L56;
        r111 = "豆包";
    L56:
        r110[0] = r111;
        r110[1] = r18.b;
        String r20 = String.format(r16, Arrays.copyOf(r110, 2));
        if (r20 == null) goto L59;
        String r112 = r20;
    L60:
        String r113 = r10.a;
        boolean r114 = r10.b;
        String r0 = com.bytedance.ai.utils.l.e(r15, "larus_appEntry_chatCard_btn_continue");
        if (r0 != null) goto L63;
        r0 = "允许";
    L63:
        String r115 = r0;
        String r1 = com.bytedance.ai.utils.l.e(r15, "larus_appEntry_chatCard_btn_reject");
        if (r1 != null) goto L67;
        r1 = "拒绝";
    L67:
        return new Pair(new u2.a(r11, r12, r13, r14, r112, r113, r114, r115, r1, false, false), null);
    L59:
        r112 = "在豆包内使用" + r18.b;
        goto L60
    L6:
        switch(r19.hashCode()) {
            case -682587753: goto L41;
            case 280295099: goto L31;
            case 664583344: goto L28;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L49;
        };
    L49:
        com.bytedance.ai.utils.g.a.w("PrivacyStrategyV2", "calculateCardUIState unknown status: ".concat(r19));
        b r21 = new b("状态异常，请重试", false);
    L50:
        r10 = r21;
        goto L51
    L9:
        if (r19.equals("refused_by_history") == false) goto L49;
    L20:
        String r22 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_rejectPolicy");
        if (r22 == null) goto L25;
        String r23 = String.format(r22, Arrays.copyOf(new Object[]{r18.b}, 1));
        if (r23 == null) goto L25;
    L26:
        r21 = new b(r23, false);
    L25:
        r23 = "已拒绝" + r18.b + "的隐私协议";
        goto L26
    L12:
        if (r19.equals("granted_stopped") == false) goto L49;
    L33:
        String r24 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_policyAgreed");
        if (r24 == null) goto L38;
        String r25 = String.format(r24, Arrays.copyOf(new Object[]{r18.b}, 1));
        if (r25 == null) goto L38;
    L39:
        r21 = new b(r25, false);
    L38:
        r25 = "已同意" + r18.b + "的隐私协议";
        goto L39
    L15:
        if (r19.equals("revoked") == false) goto L49;
    L43:
        String r26 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_agreePolicy");
        if (r26 == null) goto L47;
        String r27 = String.format(r26, Arrays.copyOf(new Object[]{r18.b}, 1));
        if (r27 == null) goto L47;
    L48:
        r21 = new b(r27, true);
    L47:
        r27 = "需同意" + r18.b + "的隐私协议";
        goto L48
    L18:
        if (r19.equals("refused") == true) goto L20;
    L28:
        if (r19.equals("granted_by_history") == true) goto L33;
    L31:
        if (r19.equals("granted") == true) goto L33;
    L41:
        if (r19.equals("pending") == true) goto L43;
        goto L43
    }

    public final Object k(String r10, String r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof PrivacyStrategy$fetchWhetherAgree$1) == false) goto L7;
        PrivacyStrategy$fetchWhetherAgree$1 r0 = (PrivacyStrategy$fetchWhetherAgree$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L17;
        if (r15 != 1) goto L16;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L13
    L21:
        boolean r16 = ((Boolean) r13).booleanValue();     // Catch: Exception -> L13
    L25:
        return Boxing.boxBoolean(r16);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r17 = Dispatchers.getIO();     // Catch: Exception -> L13
        PrivacyStrategy$fetchWhetherAgree$2 r18 = new PrivacyStrategy$fetchWhetherAgree$2(r10, r11, null);     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r13 = BuildersKt.withContext(r17, r18, r0);     // Catch: Exception -> L13
        if (r13 != r14) goto L21;
        return r14;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("PrivacyStrategyV2", "fetchWhetherAgree failed: " + e.getMessage(), e);
        r16 = false;
    L7:
        r0 = new PrivacyStrategy$fetchWhetherAgree$1(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r20, boolean r21, boolean r22, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r23) {
        f r1 = r20;
        boolean r10 = r21;
        boolean r11 = r22;
        if ((r23 instanceof PrivacyStrategy$onGrantingIntent$1) == false) goto L7;
        PrivacyStrategy$onGrantingIntent$1 r12 = (PrivacyStrategy$onGrantingIntent$1) r23;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        boolean r17 = true;
        u2.a r18 = null;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        boolean r19 = r12.Z$1;
        r10 = r12.Z$0;
        u2.c r24 = (u2.c) r12.L$1;
        f r25 = (f) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r11 = r19;
        r1 = r25;
        Object r26 = r14;
        u2.c r27 = r24;
    L25:
        boolean r28 = ((Boolean) r26).booleanValue();
    L27:
        if (r28 == false) goto L29;
        String r29 = "granted";
    L30:
        com.bytedance.ai.utils.g.a.i("PrivacyStrategyV2", "onGrantingIntent: serverStatus=" + r29 + ", granted=" + r10 + ", isHistory=" + r11 + ", required=" + this.a.f());
        String r30 = "refused";
        if (Intrinsics.areEqual(r29, "granted") == false) goto L66;
        String r31 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_toast_agreedPolicy");
        if (r31 != null) goto L35;
        r31 = "你此前已完成授权";
    L35:
        String r110 = r31;
        Pair r32 = j(this, r27, "granted");
        u2.a r111 = (u2.a) r32.getFirst();
        String r33 = (String) r32.getSecond();
        if (r10 == false) goto L56;
        if (r11 == false) goto L47;
        FlowResult r112 = FlowResult.STOP_FLOW;
        u2.f r34 = this.a;
        if (r33 != null) goto L41;
    L44:
        if (r17 == false) goto L46;
        r33 = this.a.e();
    L46:
        com.bytedance.ai.applet.grantingV2.a r35 = new com.bytedance.ai.applet.grantingV2.a(r112, "SUCCESS", r110, r111, u2.f.a(r34, "granted_by_history", r33, 7));
    L65:
        return r35;
    L41:
        if (r33.length() == 0) goto L44;
        r17 = false;
        goto L44
    L47:
        FlowResult r113 = FlowResult.CONTINUE_NEXT;
        u2.f r36 = this.a;
        if (r33 != null) goto L50;
    L53:
        if (r17 == false) goto L55;
        r33 = this.a.e();
    L55:
        r35 = new com.bytedance.ai.applet.grantingV2.a(r113, "SUCCESS", r110, r111, u2.f.a(r36, "granted", r33, 7));
        goto L65
    L50:
        if (r33.length() == 0) goto L53;
        r17 = false;
        goto L53
    L56:
        FlowResult r114 = FlowResult.STOP_FLOW;
        u2.f r37 = this.a;
        if (r33 != null) goto L59;
    L62:
        if (r17 == false) goto L64;
        r33 = this.a.e();
    L64:
        r35 = new com.bytedance.ai.applet.grantingV2.a(r114, "WARNING", r110, r111, u2.f.a(r37, "refused", r33, 7));
        goto L65
    L59:
        if (r33.length() == 0) goto L62;
        r17 = false;
        goto L62
    L66:
        if (r10 == false) goto L71;
        u2.a r38 = r1.h;
        if (r38 == null) goto L83;
        r18 = u2.a.a(r38, true, false, 1535);
    L83:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r18, null);
    L71:
        Pair r39 = j(this, r27, "refused");
        u2.a r115 = (u2.a) r39.getFirst();
        String r40 = (String) r39.getSecond();
        FlowResult r116 = FlowResult.STOP_FLOW;
        u2.f r41 = this.a;
        if (r11 == false) goto L74;
        r30 = "refused_by_history";
    L74:
        if (r40 != null) goto L76;
    L79:
        if (r17 == false) goto L82;
        r40 = this.a.e();
    L82:
        return new com.bytedance.ai.applet.grantingV2.a(r116, null, null, r115, u2.f.a(r41, r30, r40, 7));
    L76:
        if (r40.length() == 0) goto L79;
        r17 = false;
        goto L79
    L29:
        r29 = "pending";
        goto L30
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r42 = r12.Z$1;
        r10 = r12.Z$0;
        u2.c r43 = (u2.c) r12.L$1;
        f r44 = (f) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r11 = r42;
        r1 = r44;
        Object r45 = r14;
        r27 = r43;
    L21:
        r28 = ((Boolean) r45).booleanValue();
        goto L27
    L16:
        ResultKt.throwOnFailure(r14);
        r27 = r1.c;
        AppletAuthTaskMonitor.Session r46 = r1.i;
        if (r46 == null) goto L22;
        PrivacyStrategy$onGrantingIntent$hasAgreed$1 r117 = new PrivacyStrategy$onGrantingIntent$hasAgreed$1(this, r27, null);
        r12.L$0 = r1;
        r12.L$1 = r27;
        r12.Z$0 = r10;
        r12.Z$1 = r11;
        r12.label = 1;
        r45 = r46.f(r117, r12);
        if (r45 != r15) goto L21;
        return r15;
    L22:
        String r47 = r27.a;
        String r118 = r27.d;
        r12.L$0 = r1;
        r12.L$1 = r27;
        r12.Z$0 = r10;
        r12.Z$1 = r11;
        r12.label = 2;
        r26 = k(r47, r118, r12);
        if (r26 != r15) goto L25;
        return r15;
    L7:
        r12 = new PrivacyStrategy$onGrantingIntent$1(this, r23);
        goto L8
    }
}
