package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class FirstPartyLoginStrategy implements i {
    public static final /* synthetic */ int e = 0;
    public final u2.f a;
    public final u2.d b;
    public final String c;
    public final Lazy d;

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
        return StrategyType.FIRST_PARTY_LOGIN;
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
        u2.a r1 = (u2.a) r11.getFirst();
        String r12 = (String) r11.getSecond();
        FlowResult r13 = FlowResult.STOP_FLOW;
        u2.f r14 = this.a;
        if (r12 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == false) goto L12;
        r12 = this.a.e();
    L12:
        return new c(r13, r1, u2.f.a(r14, "refused", r12, 7));
    L5:
        if (r12.length() == 0) goto L8;
        r15 = false;
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
        String r11 = this.b.e();
        if (r11 == null) goto L10;
        r1 = r11;
    L10:
        return (u2.a) j(r10, r0, r1).getFirst();
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final c e(f r10, boolean r11) {
        String r0 = "granted";
        Pair<u2.a, String> r12 = j(r10.c, "granted", null);
        u2.a r1 = (u2.a) r12.getFirst();
        String r13 = (String) r12.getSecond();
        if (r11 == false) goto L5;
        FlowResult r14 = FlowResult.STOP_FLOW;
    L6:
        u2.f r15 = this.a;
        if (r11 == false) goto L9;
        r0 = "granted_by_history";
    L9:
        if (r13 != null) goto L11;
    L14:
        boolean r16 = true;
    L15:
        if (r16 == false) goto L18;
        r13 = this.a.e();
    L18:
        return new c(r14, r1, u2.f.a(r15, r0, r13, 7));
    L11:
        if (r13.length() == 0) goto L14;
        r16 = false;
        goto L15
    L5:
        r14 = FlowResult.CONTINUE_NEXT;
        goto L6
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object f(f r10, Continuation<? super Unit> r11) {
        Object r12 = DouyinGeneralAuthHelper.a.c(r10.c, this.b, (com.bytedance.ai.applet.login.c) this.d.getValue(), r10.i, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public FirstPartyLoginStrategy(u2.f r10, u2.d r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = LazyKt.lazy(new d(this));
    }

    public final Pair<u2.a, String> j(u2.c r20, String r21, String r22) {
        com.bytedance.ai.applet.grantingV2.b r10 = g.a(r21, this.c);
        if (r10 == null) goto L6;
    L58:
        if (r22 == null) goto L60;
    L62:
        String r11 = null;
    L63:
        u2.b r12 = r20.f;
        b r13 = new b();
        String r14 = r20.c;
        String r15 = r20.b;
        com.bytedance.ai.utils.l r16 = com.bytedance.ai.utils.l.a;
        String r17 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_chatCard_title_useApp");
        if (r17 == null) goto L71;
        Object[] r18 = new Object[2];
        String r19 = com.bytedance.ai.utils.l.e(r16, "larus_LarkIM_Common_Doubao_Brandname");
        if (r19 != null) goto L68;
        r19 = "豆包";
    L68:
        r18[0] = r19;
        r18[1] = r20.b;
        String r23 = String.format(r17, Arrays.copyOf(r18, 2));
        if (r23 == null) goto L71;
        String r110 = r23;
    L72:
        String r111 = r10.a;
        boolean r112 = r10.b;
        String r1 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_dyAuth_Card_btn_confirm_cn");
        if (r1 != null) goto L75;
        r1 = "登录";
    L75:
        String r24 = com.bytedance.ai.utils.l.e(r16, "larus_appEntry_dyAuth_Card_btn_cancel_cn");
        if (r24 != null) goto L79;
        r24 = "不登录";
    L79:
        return new Pair(new u2.a(r12, r13, r14, r15, r110, r111, r112, r1, r24, false, false), r11);
    L71:
        r110 = "在豆包内使用" + r20.b;
        goto L72
    L60:
        if (Intrinsics.areEqual(r10.a, this.b.e()) == true) goto L62;
        Lazy r25 = com.bytedance.ai.applet.base.gson.e.a;
        r11 = com.bytedance.ai.applet.base.gson.e.c(u2.d.a(this.b, null, r10.a, null, null, 61));
        goto L63
    L6:
        switch(r21.hashCode()) {
            case -682587753: goto L47;
            case 280295099: goto L34;
            case 664583344: goto L31;
            case 1085547216: goto L18;
            case 1100137118: goto L15;
            case 1234912329: goto L12;
            case 2084348283: goto L9;
            default: goto L56;
        };
    L56:
        com.bytedance.ai.utils.g.a.w("FirstPartyLoginStrategyV2", "calculateCardUIState unknown status: ".concat(r21));
        com.bytedance.ai.applet.grantingV2.b r26 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L57:
        r10 = r26;
        goto L58
    L9:
        if (r21.equals("refused_by_history") == false) goto L56;
    L21:
        if (r22 != null) goto L28;
        String r27 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_rejectLogin");
        if (r27 == null) goto L27;
        String r28 = String.format(r27, Arrays.copyOf(new Object[]{r20.b}, 1));
        if (r28 == null) goto L27;
    L29:
        r26 = new com.bytedance.ai.applet.grantingV2.b(r28, false);
    L27:
        r28 = "已拒绝登录" + r20.b;
        goto L29
    L28:
        r28 = r22;
        goto L29
    L12:
        if (r21.equals("granted_stopped") == false) goto L56;
    L37:
        if (r22 != null) goto L44;
        String r29 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_desc_loggedIn");
        if (r29 == null) goto L43;
        String r30 = String.format(r29, Arrays.copyOf(new Object[]{r20.b}, 1));
        if (r30 == null) goto L43;
    L45:
        r26 = new com.bytedance.ai.applet.grantingV2.b(r30, false);
    L43:
        r30 = "已登录" + r20.b;
        goto L45
    L44:
        r30 = r22;
        goto L45
    L15:
        if (r21.equals("revoked") == false) goto L56;
    L50:
        if (r22 != null) goto L54;
        String r31 = this.b.e();
        if (r31 != null) goto L55;
        r31 = "登录后继续使用";
    L55:
        r26 = new com.bytedance.ai.applet.grantingV2.b(r31, true);
        goto L57
    L54:
        r31 = r22;
        goto L55
    L18:
        if (r21.equals("refused") == true) goto L21;
    L31:
        if (r21.equals("granted_by_history") == true) goto L37;
    L34:
        if (r21.equals("granted") == true) goto L37;
    L47:
        if (r21.equals("pending") == true) goto L50;
        goto L56
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r19, boolean r20, boolean r21, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r22) {
        f r1 = r19;
        if ((r22 instanceof FirstPartyLoginStrategy$onGrantingIntent$1) == false) goto L7;
        FirstPartyLoginStrategy$onGrantingIntent$1 r10 = (FirstPartyLoginStrategy$onGrantingIntent$1) r22;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        boolean r15 = true;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        boolean r16 = r10.Z$1;
        boolean r17 = r10.Z$0;
        u2.c r18 = (u2.c) r10.L$1;
        f r23 = (f) r10.L$0;
        ResultKt.throwOnFailure(r12);
        boolean r110 = r16;
        r1 = r23;
    L22:
        Boolean r24 = (Boolean) r12;
        if (r24 == null) goto L25;
        boolean r25 = r24.booleanValue();
    L27:
        if (r25 == false) goto L29;
        String r26 = "granted";
    L30:
        com.bytedance.ai.utils.g.a.i("FirstPartyLoginStrategyV2", "onGrantingIntent: serverStatus=" + r26 + ", granted=" + r17 + ", isHistory=" + r110 + ", required=" + this.a.f());
        String r27 = "refused";
        if (Intrinsics.areEqual(r26, "granted") == false) goto L66;
        String r28 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_toast_loggedIn");
        if (r28 != null) goto L35;
        r28 = "你此前已完成登录";
    L35:
        String r111 = r28;
        Pair<u2.a, String> r29 = j(r18, "granted", null);
        u2.a r112 = (u2.a) r29.getFirst();
        String r30 = (String) r29.getSecond();
        if (r17 == false) goto L56;
        if (r110 == false) goto L47;
        FlowResult r113 = FlowResult.STOP_FLOW;
        u2.f r31 = this.a;
        if (r30 != null) goto L41;
    L44:
        if (r15 == false) goto L46;
        r30 = this.a.e();
    L46:
        com.bytedance.ai.applet.grantingV2.a r32 = new com.bytedance.ai.applet.grantingV2.a(r113, "SUCCESS", r111, r112, u2.f.a(r31, "granted_by_history", r30, 7));
    L65:
        return r32;
    L41:
        if (r30.length() == 0) goto L44;
        r15 = false;
        goto L44
    L47:
        FlowResult r114 = FlowResult.CONTINUE_NEXT;
        u2.f r33 = this.a;
        if (r30 != null) goto L50;
    L53:
        if (r15 == false) goto L55;
        r30 = this.a.e();
    L55:
        r32 = new com.bytedance.ai.applet.grantingV2.a(r114, "SUCCESS", r111, r112, u2.f.a(r33, "granted", r30, 7));
        goto L65
    L50:
        if (r30.length() == 0) goto L53;
        r15 = false;
        goto L53
    L56:
        FlowResult r115 = FlowResult.STOP_FLOW;
        u2.f r34 = this.a;
        if (r30 != null) goto L59;
    L62:
        if (r15 == false) goto L64;
        r30 = this.a.e();
    L64:
        r32 = new com.bytedance.ai.applet.grantingV2.a(r115, "WARNING", r111, r112, u2.f.a(r34, "refused", r30, 7));
        goto L65
    L59:
        if (r30.length() == 0) goto L62;
        r15 = false;
        goto L62
    L66:
        if (r17 == false) goto L72;
        u2.a r35 = r1.h;
        if (r35 == null) goto L70;
        u2.a r36 = u2.a.a(r35, true, false, 1535);
    L84:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, r36, null);
    L70:
        r36 = null;
        goto L84
    L72:
        Pair<u2.a, String> r37 = j(r18, "refused", null);
        u2.a r38 = (u2.a) r37.getFirst();
        String r39 = (String) r37.getSecond();
        FlowResult r40 = FlowResult.STOP_FLOW;
        u2.f r41 = this.a;
        if (r110 == false) goto L75;
        r27 = "refused_by_history";
    L75:
        if (r39 != null) goto L77;
    L80:
        if (r15 == false) goto L83;
        r39 = this.a.e();
    L83:
        return new com.bytedance.ai.applet.grantingV2.a(r40, r38, u2.f.a(r41, r27, r39, 7));
    L77:
        if (r39.length() == 0) goto L80;
        r15 = false;
        goto L80
    L29:
        r26 = "pending";
        goto L30
    L25:
        r25 = false;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r18 = r1.c;
        Integer r42 = this.b.f();
        if (r42 == null) goto L17;
        long r43 = r42.intValue();
    L18:
        FirstPartyLoginStrategy$onGrantingIntent$hasLogin$1 r44 = new FirstPartyLoginStrategy$onGrantingIntent$hasLogin$1(r1, this, null);
        r10.L$0 = r1;
        r10.L$1 = r18;
        r10.Z$0 = r20;
        r110 = r21;
        r10.Z$1 = r110;
        r10.label = 1;
        r12 = TimeoutKt.c(r43, r44, r10);
        if (r12 != r13) goto L21;
        return r13;
    L21:
        r17 = r20;
        goto L22
    L17:
        r43 = 1000;
    L7:
        r10 = new FirstPartyLoginStrategy$onGrantingIntent$1(this, r22);
        goto L8
    }
}
