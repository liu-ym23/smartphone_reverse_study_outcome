package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y0 extends BaseOpenMethod<JSONObject> {
    public final com.bytedance.android.live.broadcastgame.opengame.message.g h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ y0 a;

        public b(y0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("send msg to anchor success, status: ", new Object[]{(com.bytedance.android.live.broadcastgame.j0) r3});
            this.a.r(null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ y0 a;

        public c(y0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("send msg to anchor fail, error: ", new Object[]{r4});
            this.a.o(r4);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "sendMessageToAnchor";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r9, CallContext r11) {
        Intrinsics.checkNotNullParameter(r9, "param");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r6 = r9.optString("message");
        com.bytedance.android.live.broadcastgame.opengame.message.g r12 = this.h;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        Observable<com.bytedance.android.live.broadcastgame.j0> r13 = r12.a.e(new com.bytedance.android.live.broadcastgame.opengame.message.f(r12.h.id, r12.e, r12.f, r6));
        if (r13 == null) goto L8;
        Disposable r14 = r13.subscribe(new b(this), new c(this));
        if (r14 == null) goto L9;
        j(r14);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public y0(PluginContext r2, com.bytedance.android.live.broadcastgame.opengame.message.g r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "messageChanel");
        super(r2, r4);
        this.h = r3;
    }
}
