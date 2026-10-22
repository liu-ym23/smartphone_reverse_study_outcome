package i2;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f17485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Consumer f17486c;

    public /* synthetic */ a(c r5, Consumer r10, int r11) {
        this.f17484a = r11;
        this.f17485b = r5;
        this.f17486c = r10;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r10) {
        c r5 = this.f17485b;
        Consumer r11 = this.f17486c;
        switch(this.f17484a) {
            case 0: goto L46;
            case 1: goto L25;
            default: goto L4;
        };
    L4:
        a r12 = (a) r11;
        ReadableMap r13 = (ReadableMap) r10;
        if (((j) r5).f17489a.get() == true) goto L60;
        long r14 = System.currentTimeMillis();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L14
        ProtocolMessage r16 = com.lynx.tasm.utils.b.a(ConvertUtils.toJson(r13));     // Catch: Throwable -> L14
        if (r16 == null) goto L57;
        String r17 = "[WorkerAIBridgePort] receive msg from worker " + r16;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");     // Catch: Throwable -> L14
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L14
        if (r18 == null) goto L16;
        r18.d("ai_bridge", r17);     // Catch: Throwable -> L14
    L16:
        Intrinsics.checkNotNullParameter(r16, "message");     // Catch: Throwable -> L14
        j2.b r19 = new j2.b(r16);     // Catch: Throwable -> L14
        r19.f18231c = r14;     // Catch: Throwable -> L14
        r12.accept(r19);     // Catch: Throwable -> L14
        Object r20 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L19:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L58;
        String r22 = "[WorkerAIBridgePort] receive msg form worker error with msg:" + r21.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L59;
        r110.e("ai_bridge", r22);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L14:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    L60:
        return;
    L25:
        a r23 = (a) r11;
        com.lynx.react.bridge.ReadableMap r112 = (com.lynx.react.bridge.ReadableMap) r10;
        if (((d) r5).f17489a.get() == true) goto L64;
        long r24 = System.currentTimeMillis();
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L35
        ProtocolMessage r26 = com.lynx.tasm.utils.b.a(ym.h.f(r112));     // Catch: Throwable -> L35
        if (r26 == null) goto L61;
        String r113 = "[WorkerAIBridgePort] receive msg from worker " + r26;     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");     // Catch: Throwable -> L35
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L35
        if (r27 == null) goto L37;
        r27.d("ai_bridge", r113);     // Catch: Throwable -> L35
    L37:
        Intrinsics.checkNotNullParameter(r26, "message");     // Catch: Throwable -> L35
        j2.b r114 = new j2.b(r26);     // Catch: Throwable -> L35
        r114.f18231c = r24;     // Catch: Throwable -> L35
        r23.accept(r114);     // Catch: Throwable -> L35
        Object r28 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L40:
        Throwable r29 = Result.m127exceptionOrNullimpl(r28);
        if (r29 == null) goto L62;
        String r30 = "[WorkerAIBridgePort] receive msg form worker error with msg:" + r29.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        t0.d r115 = com.bytedance.ai.utils.c.f2846a;
        if (r115 == null) goto L63;
        r115.e("ai_bridge", r30);
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L35:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r28 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L40
    L64:
        return;
    L46:
        j2.b r117 = (j2.b) r10;
        ProtocolMessage r31 = (ProtocolMessage) r117.f22372b;
        if (r31.i() == ProtocolMessage.Type.Event) goto L49;
    L51:
        ((m1.c) r11).accept(r117);
        return;
    L49:
        if (Intrinsics.areEqual(r31.e(), "__bridge_ready__") == false) goto L51;
        r5.c();
    }
}
