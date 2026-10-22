package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.android.ec.opt.session.model.StageType;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "ec.writePerfSession")
public final class j extends e {
    public final boolean canRunInBackground() {
        return true;
    }

    public j() {
    }

    public final void handle(IBDXBridgeContext r10, XBaseParamModel r11, CompletionBlock r12) {
        e.b r13 = (e.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        String r1 = r13.getSessionId();     // Catch: Throwable -> L17
        String r14 = r13.getStage();     // Catch: Throwable -> L17
        if (StringsKt.isBlank(r1) == false) goto L6;
    L15:
        r12.onFailure(0, "invalid id or stage", ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class)));     // Catch: Throwable -> L17
        return;
    L6:
        if (StringsKt.isBlank(r14) == true) goto L15;
        String r15 = r13.getTimestamp();     // Catch: Throwable -> L17
        if (r15 != null) goto L11;
        r15 = "0";
    L11:
        String r16 = r13.getStageType();     // Catch: Throwable -> L17
        Map<String, Object> r17 = r13.getStageData();     // Catch: Throwable -> L17
        bm.b r18 = new bm.b(r14, r15);     // Catch: Throwable -> L17
        StageType.Companion.getClass();     // Catch: Throwable -> L17
        StageType r19 = StageType.a.a(r16);     // Catch: Throwable -> L17
        if (r19 != null) goto L14;
        r19 = StageType.NORMAL;     // Catch: Throwable -> L17
    L14:
        Intrinsics.checkNotNullParameter(r19, "<set-?>");     // Catch: Throwable -> L17
        r18.a = r19;     // Catch: Throwable -> L17
        r18.update(r17);     // Catch: Throwable -> L17
        ECPerfSessionManager.d.d(r1, r14, r18);     // Catch: Throwable -> L17
        CompletionBlock.DefaultImpls.onSuccess$default(r12, ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class)), null, 2, null);     // Catch: Throwable -> L17
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L24;
        r12.onFailure(0, "write session fail: " + r21.getMessage(), ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class)));
        return;
    L24:
        return;
    L17:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
