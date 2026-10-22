package com.bytedance.ai.applet.render.core.lynx;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i2.a f1762b;

    public /* synthetic */ c(i2.a r5, int r10) {
        this.f1761a = r10;
        this.f1762b = r5;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r10) {
        i2.a r5 = this.f1762b;
        switch(this.f1761a) {
            case 0: goto L22;
            case 1: goto L13;
            default: goto L4;
        };
    L4:
        String r11 = (String) r10;
        long r12 = System.currentTimeMillis();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L10
        ProtocolMessage r14 = com.lynx.tasm.utils.b.b(r11);     // Catch: Throwable -> L10
        if (r14 == null) goto L40;
        Intrinsics.checkNotNullParameter(r14, "message");     // Catch: Throwable -> L10
        j2.b r15 = new j2.b(r14);     // Catch: Throwable -> L10
        r15.f18231c = r12;     // Catch: Throwable -> L10
        r5.accept(r15);     // Catch: Throwable -> L10
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L40:
        return;
    L10:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L13:
        com.bytedance.ai.applet.render.core.relax.a r17 = (com.bytedance.ai.applet.render.core.relax.a) r10;
        long r18 = System.currentTimeMillis();
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L19
        ProtocolMessage r20 = com.lynx.tasm.utils.b.b(r17.f1789a);     // Catch: Throwable -> L19
        if (r20 == null) goto L42;
        Intrinsics.checkNotNullParameter(r20, "message");     // Catch: Throwable -> L19
        j2.b r21 = new j2.b(r20);     // Catch: Throwable -> L19
        r21.f18231c = r18;     // Catch: Throwable -> L19
        r5.accept(r21);     // Catch: Throwable -> L19
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L42:
        return;
    L19:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L22:
        ReadableMap r23 = (ReadableMap) r10;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L28
        long r25 = System.currentTimeMillis();     // Catch: Throwable -> L28
        ProtocolMessage r26 = com.lynx.tasm.utils.b.a(z0.a.a().toJsonTree(r23.asHashMap()).getAsJsonObject());     // Catch: Throwable -> L28
        if (r26 == null) goto L44;
        String r27 = "[LynxAIBridgePort] receive msg from lynx " + r26;     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r27, "msg");     // Catch: Throwable -> L28
        a1.a.f43a.d("ai_bridge", r27);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r26, "message");     // Catch: Throwable -> L28
        j2.b r28 = new j2.b(r26);     // Catch: Throwable -> L28
        r28.f18231c = r25;     // Catch: Throwable -> L28
        r5.accept(r28);     // Catch: Throwable -> L28
        Object r29 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r30 = Result.m127exceptionOrNullimpl(r29);
        if (r30 == null) goto L45;
        String r31 = "[LynxAIBridgePort] receive msg form lynx error with msg:" + r30.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r31, "msg");
        a1.a.f43a.e("ai_bridge", r31, null);
        return;
    L45:
        return;
    L44:
        return;
    L28:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r29 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L30
    }
}
