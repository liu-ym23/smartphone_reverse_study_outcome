package com.bytedance.android.ec.core.hybrid.bridges;

import bolts.Task;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "ec.triggerPreProcessor")
public final class k extends d {
    public static final /* synthetic */ int d = 0;

    public final boolean canRunInBackground() {
        return true;
    }

    public k() {
    }

    public static void a(Integer r10, CompletionBlock r11) {
        if (r10 != null) goto L5;
    L7:
        d.c r0 = ne7.e.b(d.c.class);
        d.c r1 = r0;
        if (r10 != null) goto L10;
    L18:
        Unit r12 = Unit.INSTANCE;
        CompletionBlock.DefaultImpls.onSuccess$default(r11, r0, null, 2, null);
        return;
    L10:
        if (r10.intValue() <= 0) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == true) goto L16;
        r10 = null;
    L16:
        if (r10 == null) goto L18;
        r1.setSubCode(Integer.valueOf(r10.intValue()));
        goto L18
    L12:
        r13 = false;
        goto L13
    L5:
        if (r10.intValue() != (-100)) goto L7;
        CompletionBlock.DefaultImpls.onFailure$default(r11, 0, "url is empty", null, 4, null);
    }

    public final void handle(IBDXBridgeContext r10, XBaseParamModel r11, final CompletionBlock r12) {
        d.b r13 = (d.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Number r0 = r13.getOptimization();
        Object r14 = null;
        if ((r0 instanceof Integer) == true) goto L5;
        r0 = null;
    L5:
        Integer r1 = (Integer) r0;
        int r15 = 0;
        if (r1 == null) goto L8;
        int r16 = r1.intValue();
    L9:
        Map<String, Object> r17 = r13.getData();
        Object r18 = r17.get("template_url");
        if ((r18 instanceof String) == true) goto L12;
        r18 = null;
    L12:
        String r19 = (String) r18;
        Object r20 = r17.get("na_prefetch_cert");
        if ((r20 instanceof String) == true) goto L15;
        r20 = null;
    L15:
        String r21 = (String) r20;
        Object r22 = r17.get("thread_strategy");
        if ((r22 instanceof Integer) == false) goto L19;
        r14 = r22;
    L19:
        Integer r23 = (Integer) r14;
        if (r23 == null) goto L22;
        r15 = r23.intValue();
    L22:
        bh.b r24 = new bh.b(r16);
        r24.a = r19;
        r24.b = r21;
        if (r15 != 0) goto L25;
        a(r24.b(), r12);
        return;
    L25:
        if (r15 == 1) goto L27;
        a(r24.b(), r12);
        return;
    L27:
        Function1<Integer, Unit> r25 = new ECTriggerPreProcessorXMethod$handle$1(this, r12);
        Intrinsics.checkNotNullParameter(r25, "callback");
        Task.callInBackground(new bh.a(r24, r25));
        return;
    L8:
        r16 = 0;
        goto L9
    }
}
