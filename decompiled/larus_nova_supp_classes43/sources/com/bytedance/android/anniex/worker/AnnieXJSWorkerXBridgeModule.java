package com.bytedance.android.anniex.worker;

import android.content.Context;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXJSWorkerXBridgeModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "", "functionName", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "params", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "callback", "", "call", "Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;", "jsWorkerBridge", "Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;", "Landroid/content/Context;", "context", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXJSWorkerXBridgeModule extends JSModule {
    private final JSWorkerBDXBridge jsWorkerBridge;

    public static final class a {
        public final JSWorkerBDXBridge a;

        public a(JSWorkerBDXBridge r10) {
            Intrinsics.checkNotNullParameter(r10, "jsWorkerBridge");
            this.a = r10;
        }
    }

    public static final class b extends com.bytedance.sdk.xbridge.cn.protocol.d<ReadableMap> {
        public final /* synthetic */ Callback c;
        public final /* synthetic */ String d;

        public final void b(Object r10) {
            ReadableMap r11 = (ReadableMap) r10;
            Intrinsics.checkNotNullParameter(r11, "data");
            this.c.invoke(new Object[]{r11});     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            HybridLogger r0 = HybridLogger.a;
            HybridLogger.i("JSWorkerBDXBridgeHandler", "dispatchPlatformInvoke  " + this.d + " exception:. " + e, null, 12);
        }

        public b(f r1, Callback r10, String r11) {
            this.c = r10;
            this.d = r11;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<com.bytedance.vmsdk.jsbridge.utils.ReadableMap>");
            super(r1);
        }
    }

    public AnnieXJSWorkerXBridgeModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "params");
        super(r10);
        this.jsWorkerBridge = ((a) r11).a;
    }

    @JSMethod
    public final void call(String r10, ReadableMap r11, Callback r12) {
        Intrinsics.checkNotNullParameter(r10, "functionName");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        f r13 = new f(r10, r11);     // Catch: Throwable -> L13
        this.jsWorkerBridge.o(r13, new b(r13, r12, r10));     // Catch: Throwable -> L6
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L13
        if (r15 == null) goto L11;
        HybridLogger r16 = HybridLogger.a;     // Catch: Throwable -> L13
        HybridLogger.i("JSWorkerBDXBridgeHandler", "handle " + r10 + " exception:. " + r15, null, 12);     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Result.box-impl(r14));     // Catch: Throwable -> L13
        return;
    L6:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L13
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
