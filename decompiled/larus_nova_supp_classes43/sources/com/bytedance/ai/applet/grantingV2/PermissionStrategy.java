package com.bytedance.ai.applet.grantingV2;

import android.content.Context;
import com.bytedance.ai.applet.granting.GrantStatus;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PermissionStrategy implements i {
    public static final /* synthetic */ int d = 0;
    public final u2.f a;
    public final u2.k b;
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
        return StrategyType.PERMISSION;
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
        Pair<u2.a, String> r11 = j(r10.c, "granted_without_system", null);
        u2.a r12 = (u2.a) r11.getFirst();
        String r13 = (String) r11.getSecond();
        if (this.a.f() == false) goto L5;
        FlowResult r14 = FlowResult.STOP_FLOW;
    L6:
        FlowResult r15 = r14;
        u2.f r16 = this.a;
        if (r13 != null) goto L9;
    L12:
        boolean r17 = true;
    L13:
        if (r17 == false) goto L16;
        r13 = this.a.e();
    L16:
        return new c(r15, null, null, r12, u2.f.a(r16, "granted_without_system", r13, 7));
    L9:
        if (r13.length() == 0) goto L12;
        r17 = false;
        goto L13
    L5:
        r14 = FlowResult.CONTINUE_NEXT;
        goto L6
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
    public final Object f(final f r11, Continuation<? super Unit> r12) {
        String r13 = this.b.c();
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L16;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyV2", "requestConfirmation: scopeName empty.");
        AppletAuthTaskMonitor.Session r15 = r11.i;
        if (r15 == null) goto L15;
        r15.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, "scopeName empty", null, null, null, 480));
    L15:
        return Unit.INSTANCE;
    L16:
        int r16 = com.bytedance.ai.applet.permission.h.a;
        String r17 = com.bytedance.ai.applet.permission.h.b(this.b.c());
        if (r17 != null) goto L23;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyV2", "requestConfirmation: can not find " + this.b.c() + "'s native permission'");
        AppletAuthTaskMonitor.Session r18 = r11.i;
        if (r18 == null) goto L22;
        r18.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "permission_context_check", AppletAuthTaskMonitor.ErrorCode.INVALID_PARAM, "native permission not found for " + this.b.c(), null, null, null, 480));
    L22:
        return Unit.INSTANCE;
    L23:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r1 = AppletRuntimeManager.d;
        if (r1 != null) goto L30;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyV2", "requestConfirmation: aiAbility null.");
        AppletAuthTaskMonitor.Session r19 = r11.i;
        if (r19 == null) goto L29;
        r19.d(new AppletAuthTaskMonitor.a(MessageIndication.STATUS_FAILED, "AIMcpGrantingManager.reportAuthTraceResultIfNeeded", "permission_context_check", AppletAuthTaskMonitor.ErrorCode.CONTEXT_MISSING, "aiAbility is null", null, null, null, 480));
    L29:
        return Unit.INSTANCE;
    L30:
        AppletAuthTaskMonitor.Session r0 = r11.i;
        if (r0 == null) goto L33;
        r0.b();
    L33:
        WeakReference<Context> r10 = r11.f;
        if (r10 == null) goto L36;
        Context r20 = r10.get();
    L37:
        r1.y(r20, r17, new w(r11));
        return Unit.INSTANCE;
    L36:
        r20 = null;
        goto L37
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r14 = false;
        goto L10
    }

    public PermissionStrategy(u2.f r10, u2.k r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "relatedData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public final Pair<u2.a, String> j(u2.c r18, String r19, String r20) {
        com.bytedance.ai.applet.grantingV2.b r10 = g.a(r19, this.c);
        if (r10 != null) goto L57;
        String r11 = this.b.b();
        if (r11 != null) goto L9;
        r11 = "未知的权限描述信息";
    L9:
        switch(r19.hashCode()) {
            case -682587753: goto L48;
            case 280295099: goto L40;
            case 664583344: goto L37;
            case 854280074: goto L29;
            case 1085547216: goto L21;
            case 1100137118: goto L18;
            case 1234912329: goto L15;
            case 2084348283: goto L12;
            default: goto L55;
        };
    L55:
        com.bytedance.ai.utils.g.a.w("PermissionStrategyV2", "calculateCardUIState unknown status: ".concat(r19));
        com.bytedance.ai.applet.grantingV2.b r12 = new com.bytedance.ai.applet.grantingV2.b("状态异常，请重试", false);
    L56:
        r10 = r12;
        goto L57
    L12:
        if (r19.equals("refused_by_history") == false) goto L55;
    L24:
        if (r20 != null) goto L26;
        String r13 = "已拒绝" + r18.b + "获取";
    L27:
        r12 = new com.bytedance.ai.applet.grantingV2.b(r13, false);
        goto L56
    L26:
        r13 = r20;
        goto L27
    L15:
        if (r19.equals("granted_stopped") == false) goto L55;
    L43:
        if (r20 != null) goto L45;
        String r14 = "已允许" + r18.b + "获取";
    L46:
        r12 = new com.bytedance.ai.applet.grantingV2.b(r14, false);
        goto L56
    L45:
        r14 = r20;
        goto L46
    L18:
        if (r19.equals("revoked") == false) goto L55;
    L51:
        if (r20 == null) goto L54;
        r11 = r20;
    L54:
        r12 = new com.bytedance.ai.applet.grantingV2.b(r11, true);
        goto L56
    L21:
        if (r19.equals("refused") == true) goto L24;
    L29:
        if (r19.equals("granted_without_system") == false) goto L55;
        if (r20 != null) goto L34;
        String r15 = "已允许" + r18.b + "获取，但还需开启系统权限";
    L35:
        r12 = new com.bytedance.ai.applet.grantingV2.b(r15, false);
        goto L56
    L34:
        r15 = r20;
        goto L35
    L37:
        if (r19.equals("granted_by_history") == true) goto L43;
    L40:
        if (r19.equals("granted") == true) goto L43;
    L48:
        if (r19.equals("pending") == true) goto L51;
    L57:
        if (r20 == null) goto L59;
    L61:
        String r16 = null;
    L62:
        u2.b r17 = r18.f;
        b r21 = new b();
        String r22 = r18.c;
        String r23 = r18.b;
        int r1 = com.bytedance.ai.applet.permission.h.a;
        String r110 = com.bytedance.ai.applet.permission.h.a(this.b.c());
        String r111 = r10.a;
        boolean r112 = r10.b;
        com.bytedance.ai.utils.l r24 = com.bytedance.ai.utils.l.a;
        String r25 = com.bytedance.ai.utils.l.e(r24, "larus_appEntry_chatCard_btn_continue");
        if (r25 != null) goto L65;
        r25 = "允许";
    L65:
        String r113 = r25;
        String r26 = com.bytedance.ai.utils.l.e(r24, "larus_appEntry_chatCard_btn_reject");
        if (r26 != null) goto L69;
        r26 = "拒绝";
    L69:
        return new Pair(new u2.a(r17, r21, r22, r23, r110, r111, r112, r113, r26, false, false), r16);
    L59:
        if (Intrinsics.areEqual(r10.a, this.b.b()) == true) goto L61;
        Lazy r27 = com.bytedance.ai.applet.base.gson.e.a;
        r16 = com.bytedance.ai.applet.base.gson.e.c(u2.k.a(this.b, r10.a));
        goto L62
    }

    public final Object k(String r10, String r11, Continuation<? super GrantStatus> r12) {
        if ((r12 instanceof PermissionStrategy$fetchPermissionDetail$1) == false) goto L7;
        PermissionStrategy$fetchPermissionDetail$1 r0 = (PermissionStrategy$fetchPermissionDetail$1) r12;
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
        return (GrantStatus) r13;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r16 = Dispatchers.getIO();     // Catch: Exception -> L13
        PermissionStrategy$fetchPermissionDetail$2 r17 = new PermissionStrategy$fetchPermissionDetail$2(r10, r11, null);     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r13 = BuildersKt.withContext(r16, r17, r0);     // Catch: Exception -> L13
        if (r13 != r14) goto L21;
        return r14;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyV2", "fetchPermissionDetail failed: " + e.getMessage(), e);
        return GrantStatus.PENDING;
    L7:
        r0 = new PermissionStrategy$fetchPermissionDetail$1(this, r12);
        goto L8
    }

    @Override // com.bytedance.ai.applet.grantingV2.i
    public final Object d(f r26, boolean r27, boolean r28, Continuation<? super com.bytedance.ai.applet.grantingV2.a> r29) {
        boolean r1 = r27;
        if ((r29 instanceof PermissionStrategy$onGrantingIntent$1) == false) goto L7;
        PermissionStrategy$onGrantingIntent$1 r10 = (PermissionStrategy$onGrantingIntent$1) r29;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        PermissionStrategy$onGrantingIntent$1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
    L106:
        return r13;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r0 = r12.Z$1;
        r1 = r12.Z$0;
        String r16 = (String) r12.L$2;
        u2.c r17 = (u2.c) r12.L$1;
        f r18 = (f) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L34:
        GrantStatus r19 = (GrantStatus) r13;
    L29:
        f r24 = r18;
        boolean r110 = r0;
        GrantStatus r20 = r19;
        String r21 = r16;
        u2.c r22 = r17;
        boolean r23 = r1;
        if (r20 == null) goto L51;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        int r25 = u2.g.a.a[r20.ordinal()];
        if (r25 != 1) goto L40;
        String r30 = "pending";
    L52:
        com.bytedance.ai.utils.g r31 = com.bytedance.ai.utils.g.a;
        r31.i("PermissionStrategyV2", "onGrantingIntent: serverStatus=" + r30 + ", granted=" + r23 + ", isHistory=" + r110 + ", required=" + this.a.f());
        if (Intrinsics.areEqual(r30, "granted") == false) goto L86;
        String r32 = com.bytedance.ai.utils.l.e(com.bytedance.ai.utils.l.a, "larus_appEntry_chatCard_toast_agreedPolicy");
        if (r32 != null) goto L57;
        r32 = "你此前已完成授权";
    L57:
        String r210 = r32;
        Pair<u2.a, String> r33 = j(r22, "granted", null);
        u2.a r211 = (u2.a) r33.getFirst();
        String r34 = (String) r33.getSecond();
        if (r23 == false) goto L75;
        if (r110 == false) goto L70;
        FlowResult r111 = FlowResult.STOP_FLOW;
        u2.f r35 = this.a;
        if (r34 != null) goto L63;
    L66:
        boolean r112 = true;
    L67:
        if (r112 == false) goto L109;
        r34 = this.a.e();
    L109:
        return new com.bytedance.ai.applet.grantingV2.a(r111, "SUCCESS", r210, r211, u2.f.a(r35, "granted_by_history", r34, 7));
    L63:
        if (r34.length() == 0) goto L66;
        r112 = false;
        goto L67
    L70:
        u2.a r36 = r24.h;
        if (r36 == null) goto L73;
        u2.a r212 = u2.a.a(r36, true, false, 1535);
    L110:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, "SUCCESS", r210, r212, null);
    L73:
        r212 = null;
        goto L110
    L75:
        FlowResult r113 = FlowResult.STOP_FLOW;
        u2.f r37 = this.a;
        if (r34 != null) goto L78;
    L81:
        boolean r114 = true;
    L82:
        if (r114 == false) goto L85;
        r34 = this.a.e();
    L85:
        return new com.bytedance.ai.applet.grantingV2.a(r113, "WARNING", r210, r211, u2.f.a(r37, "refused", r34, 7));
    L78:
        if (r34.length() == 0) goto L81;
        r114 = false;
        goto L82
    L86:
        if (r30 == null) goto L107;
        int r38 = r30.hashCode();
        if (r38 == (-682587753)) goto L101;
        if (r38 == 1085547216) goto L98;
        if (r38 != 1100137118) goto L107;
        if (r30.equals("revoked") == false) goto L107;
    L103:
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.label = 3;
        r13 = l(r24, r22, r21, r23, r110, r12);
        if (r13 != r14) goto L106;
        return r14;
    L98:
        if (r30.equals("refused") == true) goto L103;
    L101:
        if (r30.equals("pending") == true) goto L103;
    L107:
        r31.e("PermissionStrategyV2", "Unknown server status: " + r30);
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.STOP_FLOW, "FAILURE", "状态异常，请稍后重试", r24.h, null);
    L40:
        if (r25 != 2) goto L42;
        r30 = "granted";
        goto L52
    L42:
        if (r25 != 3) goto L44;
        r30 = "refused";
        goto L52
    L44:
        if (r25 != 4) goto L47;
        r30 = "revoked";
        goto L52
    L47:
        throw new NoWhenBranchMatchedException();
    L51:
        r30 = null;
        goto L52
    L17:
        r0 = r12.Z$1;
        r1 = r12.Z$0;
        r16 = (String) r12.L$2;
        r17 = (u2.c) r12.L$1;
        r18 = (f) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L28:
        r19 = (GrantStatus) r13;
        goto L29
    L18:
        ResultKt.throwOnFailure(r13);
        r17 = r26.c;
        String r39 = this.b.c();
        if (r39 != null) goto L22;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyV2", "onGrantingIntent scopeName is null");
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.STOP_FLOW, null, null, null, null);
    L22:
        AppletAuthTaskMonitor.Session r115 = r26.i;
        if (r115 == null) goto L30;
        PermissionStrategy$onGrantingIntent$permissionDetail$1 r116 = new PermissionStrategy$onGrantingIntent$permissionDetail$1(this, r17, r39, null);
        r12.L$0 = r26;
        r12.L$1 = r17;
        r12.L$2 = r39;
        r12.Z$0 = r1;
        r12.Z$1 = r28;
        r12.label = 1;
        Object r117 = r115.f(r116, r12);
        if (r117 != r14) goto L27;
        return r14;
    L27:
        r18 = r26;
        r0 = r28;
        r16 = r39;
        r13 = r117;
        goto L28
    L30:
        String r118 = r17.a;
        r12.L$0 = r26;
        r12.L$1 = r17;
        r12.L$2 = r39;
        r12.Z$0 = r1;
        r12.Z$1 = r28;
        r12.label = 2;
        Object r119 = k(r118, r39, r12);
        if (r119 != r14) goto L33;
        return r14;
    L33:
        r18 = r26;
        r0 = r28;
        r16 = r39;
        r13 = r119;
    L7:
        r10 = new PermissionStrategy$onGrantingIntent$1(this, r29);
        goto L8
    }

    public final Object m(String r10, String r11, GrantStatus r12, Continuation<? super Boolean> r13) {
        if ((r13 instanceof PermissionStrategy$postPermissionDetail$1) == false) goto L7;
        PermissionStrategy$postPermissionDetail$1 r0 = (PermissionStrategy$postPermissionDetail$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L17;
        if (r16 != 1) goto L16;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L13
    L21:
        boolean r17 = ((Boolean) r14).booleanValue();     // Catch: Exception -> L13
    L25:
        return Boxing.boxBoolean(r17);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r14);
        com.bytedance.ai.utils.g.a.i("PermissionStrategyV2", "postPermissionDetail " + r10 + ' ' + r11);
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Exception -> L13
        PermissionStrategy$postPermissionDetail$2 r19 = new PermissionStrategy$postPermissionDetail$2(r10, r11, r12, null);     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r14 = BuildersKt.withContext(r18, r19, r0);     // Catch: Exception -> L13
        if (r14 != r15) goto L21;
        return r15;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("PermissionStrategyV2", "postPermissionDetail failed: " + e.getMessage(), e);
        r17 = false;
    L7:
        r0 = new PermissionStrategy$postPermissionDetail$1(this, r13);
        goto L8
    }

    public final Object l(f r26, u2.c r27, String r28, boolean r29, boolean r30, Continuation r31) {
        boolean r10 = r30;
        if ((r31 instanceof PermissionStrategy$handlePendingOrRefusedStatus$1) == false) goto L7;
        PermissionStrategy$handlePendingOrRefusedStatus$1 r1 = (PermissionStrategy$handlePendingOrRefusedStatus$1) r31;
        int r11 = r1.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r11 - Integer.MIN_VALUE;
    L8:
        PermissionStrategy$handlePendingOrRefusedStatus$1 r12 = r1;
        Object r0 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r12.label;
        u2.a r15 = null;
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L19;
        if (r14 == 2) goto L18;
        if (r14 == 3) goto L17;
        if (r14 != 4) goto L16;
        boolean r16 = r12.Z$0;
        u2.c r17 = (u2.c) r12.L$1;
        f r18 = (f) r12.L$0;
        ResultKt.throwOnFailure(r0);
        r10 = r16;
    L56:
        boolean r19 = ((Boolean) r0).booleanValue();
    L57:
        if (r19 == true) goto L64;
        FlowResult r20 = FlowResult.STOP_FLOW;
        u2.a r21 = r18.h;
        if (r21 == null) goto L61;
        u2.a r23 = u2.a.a(r21, false, false, 511);
    L63:
        return new com.bytedance.ai.applet.grantingV2.a(r20, "FAILURE", "网络异常，请稍后重试", r23, null);
    L61:
        r23 = null;
        goto L63
    L64:
        String r22 = "refused";
        Pair<u2.a, String> r24 = j(r17, "refused", null);
        u2.a r110 = (u2.a) r24.getFirst();
        String r25 = (String) r24.getSecond();
        if (this.a.f() == false) goto L67;
        FlowResult r32 = FlowResult.STOP_FLOW;
    L68:
        FlowResult r111 = r32;
        u2.f r33 = this.a;
        if (r10 == false) goto L71;
        r22 = "refused_by_history";
    L71:
        if (r25 != null) goto L73;
    L76:
        boolean r112 = true;
    L77:
        if (r112 == false) goto L80;
        r25 = this.a.e();
    L80:
        return new com.bytedance.ai.applet.grantingV2.a(r111, null, null, r110, u2.f.a(r33, r22, r25, 7));
    L73:
        if (r25.length() == 0) goto L76;
        r112 = false;
        goto L77
    L67:
        r32 = FlowResult.CONTINUE_NEXT;
        goto L68
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        boolean r34 = r12.Z$0;
        r17 = (u2.c) r12.L$1;
        r18 = (f) r12.L$0;
        ResultKt.throwOnFailure(r0);
        r10 = r34;
    L51:
        r19 = ((Boolean) r0).booleanValue();
        goto L57
    L18:
        f r35 = (f) r12.L$0;
        ResultKt.throwOnFailure(r0);
    L33:
        boolean r36 = ((Boolean) r0).booleanValue();
    L34:
        if (r36 == true) goto L40;
        FlowResult r37 = FlowResult.STOP_FLOW;
        u2.a r38 = r35.h;
        if (r38 == null) goto L39;
        r15 = u2.a.a(r38, false, false, 511);
    L39:
        return new com.bytedance.ai.applet.grantingV2.a(r37, "FAILURE", "网络异常，请稍后重试", r15, null);
    L40:
        u2.a r39 = r35.h;
        if (r39 == null) goto L44;
        r15 = u2.a.a(r39, true, false, 1535);
    L44:
        return new com.bytedance.ai.applet.grantingV2.a(FlowResult.REQUIRES_CONFIRMATION, null, null, r15, null);
    L19:
        r35 = (f) r12.L$0;
        ResultKt.throwOnFailure(r0);
    L28:
        r36 = ((Boolean) r0).booleanValue();
        r15 = null;
        goto L34
    L20:
        ResultKt.throwOnFailure(r0);
        if (r29 == false) goto L45;
        GrantStatus r40 = GrantStatus.GRANTED;
        AppletAuthTaskMonitor.Session r113 = r26.i;
        if (r113 == null) goto L29;
        PermissionStrategy$handlePendingOrRefusedStatus$postResult$1 r41 = new PermissionStrategy$handlePendingOrRefusedStatus$postResult$1(this, r27, r28, r40, null);
        r12.L$0 = r26;
        r12.label = 1;
        r0 = r113.f(r41, r12);
        if (r0 != r13) goto L27;
        return r13;
    L27:
        r35 = r26;
        goto L28
    L29:
        String r42 = r27.a;
        r12.L$0 = r26;
        r12.label = 2;
        r0 = m(r42, r28, r40, r12);
        if (r0 != r13) goto L32;
        return r13;
    L32:
        r35 = r26;
        goto L33
    L45:
        GrantStatus r43 = GrantStatus.DENIED;
        AppletAuthTaskMonitor.Session r44 = r26.i;
        if (r44 == null) goto L52;
        PermissionStrategy$handlePendingOrRefusedStatus$postResult$2 r45 = new PermissionStrategy$handlePendingOrRefusedStatus$postResult$2(this, r27, r28, r43, null);
        r12.L$0 = r26;
        r12.L$1 = r27;
        r12.Z$0 = r10;
        r12.label = 3;
        r0 = r44.f(r45, r12);
        if (r0 != r13) goto L50;
        return r13;
    L50:
        r18 = r26;
        r17 = r27;
        goto L51
    L52:
        String r46 = r27.a;
        r12.L$0 = r26;
        r12.L$1 = r27;
        r12.Z$0 = r10;
        r12.label = 4;
        r0 = m(r46, r28, r43, r12);
        if (r0 != r13) goto L55;
        return r13;
    L55:
        r18 = r26;
        r17 = r27;
    L7:
        r1 = new PermissionStrategy$handlePendingOrRefusedStatus$1(this, r31);
        goto L8
    }
}
