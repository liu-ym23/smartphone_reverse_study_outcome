package com.bytedance.ies.bullet.lynx.bridge;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.h;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxBridgeModule f5615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.core.kit.bridge.c f5616c;
    public final /* synthetic */ ReadableMap d;
    public final /* synthetic */ Callback e;
    public final /* synthetic */ int f;

    public f(String r5, LynxBridgeModule r10, com.bytedance.ies.bullet.core.kit.bridge.c r11, ReadableMap r12, Callback r13, int r14) {
        this.f5614a = r5;
        this.f5615b = r10;
        this.f5616c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r10 = new StringBuilder();
        String r11 = this.f5614a;
        r10.append(r11);
        r10.append(" execute in ");
        r10.append(Thread.currentThread().getName());
        com.bytedance.ies.bullet.service.base.b.d(r10.toString(), LogLevel.f5953a, "XLynxKit");
        LynxBridgeModule r12 = this.f5615b;
        LynxBridgeModule.access$getTestService$p(r12);
        long r13 = SystemClock.elapsedRealtime();
        com.bytedance.ies.bullet.core.e r14 = LynxBridgeModule.access$getBulletContext$p(r12);
        if (r14 == null) goto L7;
        h r15 = r14.f5298l;
        if (r15 == null) goto L7;
        View r16 = r15.a();
    L8:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.lynx.tasm.LynxView");
        LynxView r17 = (LynxView) r16;
        final com.bytedance.ies.bullet.core.kit.bridge.c r18 = this.f5616c;
        r18.getClass();
        r18.f5338c = System.currentTimeMillis();
        com.bytedance.ies.bullet.core.kit.bridge.e r19 = LynxBridgeModule.access$getBridgeRegistry(r12);
        if (r19 == null) goto L11;
        Function1<com.bytedance.ies.bullet.core.kit.bridge.b, Unit> r20 = new LynxBridgeModule$getExecuteTask$1$2(r18);
        Intrinsics.checkNotNullParameter(r20, "bridgePreInvokeHandler");
        ((com.bytedance.ies.bullet.core.kit.bridge.d) r19).f5345i = r20;
    L11:
        com.bytedance.ies.bullet.core.kit.bridge.e r21 = LynxBridgeModule.access$getBridgeRegistry(r12);
        if (r21 == null) goto L14;
        Intrinsics.checkNotNullParameter(r11, "func");
        com.bytedance.ies.bullet.core.kit.bridge.b r22 = (com.bytedance.ies.bullet.core.kit.bridge.b) ((com.bytedance.ies.bullet.core.kit.bridge.d) r21).f().get(r11);
    L15:
        if (r22 != null) goto L17;
    L21:
        com.bytedance.ies.bullet.core.kit.bridge.e r23 = LynxBridgeModule.access$getBridgeRegistry(r12);
        if (r23 == null) goto L29;
        JSONObject r24 = com.lynx.tasm.utils.b.m(this.d);
        JSONObject r25 = r24.optJSONObject("data");
        if (r25 != null) goto L26;
        JSONObject r110 = r24;
    L27:
        c r111 = new c(this.f5615b, this.f5616c, this.f5614a, this.e, r13, this.f, r17);
        a r112 = new a(this.f5615b, this.f5616c, this.f5614a, this.e, r13, this.f, r17);
        Intrinsics.checkNotNullParameter("lynx bridge IBridgeMethod rejected", "<set-?>");
        r112.g = "lynx bridge IBridgeMethod rejected";
        Unit r26 = Unit.INSTANCE;
        ((com.bytedance.ies.bullet.core.kit.bridge.d) r23).b(r11, r110, r111, r112);
        return r26;
    L26:
        r110 = r25;
        goto L27
    L29:
        return null;
    L17:
        if ((r22 instanceof com.bytedance.ies.bullet.core.kit.bridge.b) == true) goto L21;
        throw new ClassCastException();
    L14:
        r22 = null;
    L7:
        r16 = null;
        goto L8
    }
}
