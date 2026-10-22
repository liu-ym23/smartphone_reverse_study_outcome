package com.bytedance.android.anniex.worker;

import ai.j0;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXJSWorkerXBridgeModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "Landroid/content/Context;", "context", "", LynxResourceModule.PARAMS_KEY, "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "", "functionName", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "callback", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Lcom/bytedance/vmsdk/jsbridge/utils/Callback;)V", "Lcom/bytedance/android/anniex/worker/c;", "jsWorkerBridge", "Lcom/bytedance/android/anniex/worker/c;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AnnieXJSWorkerXBridgeModule extends JSModule {
    private final c jsWorkerBridge;

    public AnnieXJSWorkerXBridgeModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        super(r5);
        j0.A(r10);
        throw null;
    }

    @Keep
    @com.bytedance.vmsdk.jsbridge.b
    public final void call(String r5, ReadableMap r10, Callback r11) {
        Intrinsics.checkNotNullParameter(r5, "functionName");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L11
        d r13 = new d(r5, r10);     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<com.bytedance.vmsdk.jsbridge.utils.ReadableMap>");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L7
        throw null;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        Object r15 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
        Throwable r16 = Result.m127exceptionOrNullimpl(r15);     // Catch: Throwable -> L11
        if (r16 == null) goto L13;
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L11
        com.bytedance.ies.bullet.base.utils.logger.a.d("JSWorkerBDXBridgeHandler", "handle " + r5 + " exception:. " + r16, null, 12);     // Catch: Throwable -> L11
    L13:
        Result.m124constructorimpl(Result.m123boximpl(r15));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }
}
