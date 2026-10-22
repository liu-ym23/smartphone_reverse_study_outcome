package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "ec.readPerfSession")
public final class i extends c {
    public final boolean canRunInBackground() {
        return true;
    }

    public i() {
    }

    public static void b(bm.a r10, CompletionBlock r11) {
        c.InterfaceC0135c r0 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC0135c.class));
        c.InterfaceC0135c r1 = r0;
        r1.setCommon(r10.a);
        LinkedHashMap r12 = r10.c;
        if (r12 == null) goto L8;
        ArrayList r13 = new ArrayList(r12.size());
        Iterator r14 = r12.entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        r13.add(((bm.b) ((Map.Entry) r14.next()).getValue()).b());
    L9:
        r1.setStages(r13);
        Unit r15 = Unit.INSTANCE;
        CompletionBlock.DefaultImpls.onSuccess$default(r11, r0, null, 2, null);
        return;
    L8:
        r13 = null;
        goto L9
    }

    public final void a(String r10, CompletionBlock<c.InterfaceC0135c> r11) {
        r11.onFailure(0, r10, ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC0135c.class)));
    }

    public final void handle(IBDXBridgeContext r10, XBaseParamModel r11, CompletionBlock r12) {
        c.b r13 = (c.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r14 = r13.getSessionId();
        String r15 = r13.getStage();
        if (StringsKt.isBlank(r14) == false) goto L26;
        a("invalid session id", r12);
        return;
    L26:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        if (r15 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        bm.a r16 = ECPerfSessionManager.d.b(r14);     // Catch: Throwable -> L20
    L15:
        if (r16 != null) goto L17;
        a("no session info", r12);     // Catch: Throwable -> L20
    L18:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L29;
        a("read session fail: " + r18.getMessage(), r12);
        return;
    L29:
        return;
    L17:
        b(r16, r12);     // Catch: Throwable -> L20
        goto L18
    L14:
        r16 = ECPerfSessionManager.d.c(r14, r15);     // Catch: Throwable -> L20
        goto L15
    L8:
        if (StringsKt.isBlank(r15) == true) goto L11;
        r1 = false;
    L20:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
