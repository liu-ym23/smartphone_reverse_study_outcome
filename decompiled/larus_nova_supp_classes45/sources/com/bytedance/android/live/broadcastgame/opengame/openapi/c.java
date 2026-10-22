package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.message.AnchorGameMessageChannel;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends BaseOpenMethod<JSONObject> {
    public final AnchorGameMessageChannel h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AudienceBroadcastMethod", new Object[]{"send msg to audiences success, status: ", (com.bytedance.android.live.broadcastgame.j0) r4});
            this.a.r(null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.openapi.c$c, reason: collision with other inner class name */
    public static final class C0070c<T> implements Consumer {
        public final /* synthetic */ c a;

        public C0070c(c r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("AudienceBroadcastMethod", new Object[]{"send msg to audiences fail, error: ", r5});
            this.a.o(r5);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "sendMessageToAudiences";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r18, CallContext r19) {
        Intrinsics.checkNotNullParameter(r18, "param");
        Intrinsics.checkNotNullParameter(r19, "context");
        String r2 = r18.optString("timeliness");
        JSONArray r3 = r18.optJSONArray("openUIDs");
        String r13 = r18.optString("message");
        AnchorGameMessageChannel r1 = this.h;
        if (r3 == null) goto L5;
        String r4 = r3.toString();
    L6:
        String r16 = r4;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r2, "sendTye");
        com.bytedance.android.live.broadcastgame.i0 r5 = r1.a;
        String r6 = r1.h;
        long r7 = r1.j;
        long r9 = r1.b.b.getAndIncrement();
        long r11 = r1.b.a;
        if (Intrinsics.areEqual(r2, "follow_av_stream") == false) goto L9;
        long r8 = 2;
    L10:
        Observable<com.bytedance.android.live.broadcastgame.j0> r12 = r5.e(new com.bytedance.android.live.broadcastgame.opengame.message.a(r6, r7, r9, r11, r13, r8, r16));
        if (r12 == null) goto L16;
        Disposable r14 = r12.subscribe(new b(this), new C0070c(this));
        if (r14 == null) goto L17;
        j(r14);
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r8 = 1;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public c(PluginContext r2, AnchorGameMessageChannel r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "messageChannel");
        super(r2, r4);
        this.h = r3;
    }
}
