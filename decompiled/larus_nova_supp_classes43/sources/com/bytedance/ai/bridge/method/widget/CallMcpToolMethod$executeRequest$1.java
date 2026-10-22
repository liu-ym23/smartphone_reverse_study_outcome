package com.bytedance.ai.bridge.method.widget;

import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.widget.AbsCallMcpToolMethodIDL;
import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p4.d;
import p4.e;
import p4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.widget.CallMcpToolMethod$executeRequest$1", f = "CallMcpToolMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CallMcpToolMethod$executeRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h<AbsCallMcpToolMethodIDL.b> $callback;
    final /* synthetic */ f $request;
    private /* synthetic */ Object L$0;
    int label;

    public CallMcpToolMethod$executeRequest$1(f r1, h<AbsCallMcpToolMethodIDL.b> r10, Continuation<? super CallMcpToolMethod$executeRequest$1> r11) {
        this.$request = r1;
        this.$callback = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CallMcpToolMethod$executeRequest$1 r0 = new CallMcpToolMethod$executeRequest$1(this.$request, this.$callback, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L122;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        UserAuthService r15 = UserAuthService.a;
        f r16 = this.$request;
        Intrinsics.checkNotNullParameter(r16, "request");
        AbsCallMcpToolMethodIDL.CallMcpToolBusinessError r10 = null;
        SsResponse r17 = UserAuthService.d.callMcpTool(r16).execute();     // Catch: Exception -> L15
        if (r17.isSuccessful() == true) goto L8;
    L13:
        g.a.e("UserAuthService", "callMcpTool: Http Error, code = " + r17.code());     // Catch: Exception -> L15
    L125:
    L17:
        p4.g r18 = null;
    L19:
        if (r18 != null) goto L22;
        g r19 = g.a;
        StringBuilder r11 = new StringBuilder("call failed, errNo=");
        f3.a r1 = f3.a.f;
        r11.append(r1.a);
        r11.append(", msg=call MCP tool failed");
        r19.e("AISDK_JSB_CallMcpToolMethod", r11.toString());
        h.a.a(this.$callback, "call MCP tool failed", r1, null, 10);
        return Unit.INSTANCE;
    L22:
        p4.h r110 = r18.e();
        if (r110 == null) goto L25;
        String r12 = r110.d();
    L26:
        if (r12 != null) goto L123;
        Map<String, ? extends Object> r20 = null;
    L36:
        if (r110 == null) goto L38;
        d r21 = r110.c();
    L39:
        if (r110 == null) goto L119;
        boolean r22 = true;
        if (CollectionsKt.contains(SetsKt.setOf(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)}), r110.b()) == false) goto L119;
        if (r12 == null) goto L44;
        if (r20 == null) goto L119;
    L44:
        if (r21 != null) goto L46;
    L55:
        if (r20 != null) goto L57;
        if (r21 == null) goto L119;
    L57:
        if (r20 == null) goto L60;
        if (r21 != null) goto L119;
    L60:
        e r23 = r110.a();
        if (r23 == null) goto L82;
        String r24 = r23.a();
        if (r24 != null) goto L65;
    L68:
        boolean r25 = true;
    L69:
        if (r25 == true) goto L80;
        String r26 = r23.b();
        if (r26 != null) goto L73;
    L76:
        boolean r27 = true;
    L77:
        if (r27 == true) goto L80;
        if (Intrinsics.areEqual(r23.c(), "render") == true) goto L82;
    L73:
        if (r26.length() == 0) goto L76;
        r27 = false;
    L80:
        g r111 = g.a;
        StringBuilder r28 = new StringBuilder("call failed, errNo=");
        f3.a r29 = f3.a.m;
        r28.append(r29.a);
        r28.append(", msg=invalid card update error");
        r111.e("AISDK_JSB_CallMcpToolMethod", r28.toString());
        h.a.a(this.$callback, "invalid card update error", r29, null, 10);
        return Unit.INSTANCE;
    L65:
        if (r24.length() == 0) goto L68;
        r25 = false;
    L82:
        Intrinsics.checkNotNullParameter(AbsCallMcpToolMethodIDL.b.class, "<this>");
        AbsCallMcpToolMethodIDL.b r0 = (AbsCallMcpToolMethodIDL.b) c.a(AbsCallMcpToolMethodIDL.b.class);
        r0.setToolResult(r20);
        String r30 = "";
        if (r23 == null) goto L94;
        String r31 = r23.a();
        if (r31 != null) goto L87;
        r31 = "";
    L87:
        String r32 = r23.b();
        if (r32 != null) goto L90;
        r32 = "";
    L90:
        String r112 = r23.c();
        if (r112 != null) goto L93;
        r112 = "";
    L93:
        AbsCallMcpToolMethodIDL.CallMcpToolError r33 = new AbsCallMcpToolMethodIDL.CallMcpToolError(r31, r32, r112);
    L95:
        r0.setCardUpdateError(r33);
        if (r21 == null) goto L106;
        Long r34 = r21.a();
        if (r34 == null) goto L105;
        long r35 = r34.longValue();
        String r36 = r21.b();
        if (r36 == null) goto L103;
        r30 = r36;
    L103:
        r10 = new AbsCallMcpToolMethodIDL.CallMcpToolBusinessError(r35, r30);
        goto L106
    L105:
        throw new IllegalStateException("Required value was null.".toString());
    L106:
        r0.setToolError(r10);
        if (r23 == null) goto L109;
        g.a.w("AISDK_JSB_CallMcpToolMethod", "card update failed, code=" + r23.a() + ", phase=" + r23.c());
    L109:
        g r37 = g.a;
        StringBuilder r38 = new StringBuilder("call success, outputKind=");
        r38.append(r110.b());
        r38.append(", hasCardUpdateError=");
        if (r23 == null) goto L112;
        boolean r113 = true;
    L113:
        r38.append(r113);
        r38.append(", hasToolError=");
        if (r21 != null) goto L117;
        r22 = false;
    L117:
        r38.append(r22);
        r37.i("AISDK_JSB_CallMcpToolMethod", r38.toString());
        h.a.b(this.$callback, r0);
        return Unit.INSTANCE;
    L112:
        r113 = false;
        goto L113
    L94:
        r33 = null;
        goto L95
    L46:
        if (r21.a() == null) goto L119;
        String r39 = r21.b();
        if (r39 != null) goto L50;
    L53:
        boolean r40 = true;
    L54:
        if (r40 == true) goto L119;
    L50:
        if (r39.length() == 0) goto L53;
        r40 = false;
    L119:
        g r114 = g.a;
        StringBuilder r41 = new StringBuilder("call failed, errNo=");
        f3.a r42 = f3.a.m;
        r41.append(r42.a);
        r41.append(", msg=invalid call MCP tool result");
        r114.e("AISDK_JSB_CallMcpToolMethod", r41.toString());
        h.a.a(this.$callback, "invalid call MCP tool result", r42, null, 10);
        return Unit.INSTANCE;
    L38:
        r21 = null;
        goto L39
    L123:
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L29
        Lazy r44 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Throwable -> L29
        Object r45 = Result.constructor-impl((Map) com.bytedance.ai.applet.base.gson.e.b(r12, CallMcpToolMethod.b));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r45) == false) goto L34;
        r45 = null;
    L34:
        r20 = (Map) r45;
    L29:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L25:
        r12 = null;
        goto L26
    L8:
        if (r17.body() == null) goto L13;
        r18 = (p4.g) r17.body();     // Catch: Exception -> L15
        if (r18.d() == true) goto L19;
        g.a.e("UserAuthService", "callMcpTool: Server Error, errCode=" + r18.a() + ", errMsg=" + r18.b() + ", logId=" + r18.c());     // Catch: Exception -> L15
    L15:
        e = move-exception;
        g.a.e("UserAuthService", "callMcpTool ERROR: " + e.getMessage(), e);
        goto L17
    L122:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
