package com.bytedance.ai.applet.login;

import com.bytedance.ai.bridge.remote.UserAuthService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.McpLoginManager", f = "McpLoginManager.kt", i = {0}, l = {568}, m = "checkPrivacy", n = {"appletId"}, s = {"L$0"})
final class McpLoginManager$checkPrivacy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ p this$0;

    public McpLoginManager$checkPrivacy$1(p r1, Continuation<? super McpLoginManager$checkPrivacy$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        p r11 = this.this$0;
        p r1 = p.a;
        r11.getClass();
        int r12 = this.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r12 - Integer.MIN_VALUE;
        McpLoginManager$checkPrivacy$1 r0 = this;
    L6:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        String r16 = null;
        Object r17 = null;
        if (r15 == 0) goto L16;
        if (r15 != 1) goto L15;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L12
        Object r18 = ((Result) r13).unbox-impl();     // Catch: Exception -> L12
    L22:
        if (Result.isFailure-impl(r18) == true) goto L25;
        r17 = r18;
    L25:
        Boolean r19 = (Boolean) r17;     // Catch: Exception -> L12
        if (r19 == null) goto L28;
        boolean r20 = r19.booleanValue();     // Catch: Exception -> L12
    L35:
        return Boxing.boxBoolean(r20);
    L28:
        Throwable r21 = Result.exceptionOrNull-impl(r18);     // Catch: Exception -> L12
        if (r21 == null) goto L31;
        throw r21;     // Catch: Exception -> L12
    L31:
        throw new Exception("check result is null, but no error message");     // Catch: Exception -> L12
    L12:
        e = e;
        r16 = (String) r0.L$0;
    L33:
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "checkPrivacy failed for appletId: " + r16, e);
        r20 = false;
        goto L35
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        b r22 = (b) ((LinkedHashMap) p.b).get(null);
        UserAuthService r23 = UserAuthService.a;     // Catch: Exception -> L32
        r0.L$0 = null;     // Catch: Exception -> L32
        r0.label = 1;     // Catch: Exception -> L32
        r18 = r23.d(null, "null", r0);     // Catch: Exception -> L32
        if (r18 != r14) goto L22;
        return r14;
    L32:
        e = e;
        goto L33
    L5:
        r0 = new McpLoginManager$checkPrivacy$1(r11, this);
        goto L6
    }
}
