package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class f<P> extends BaseOpenMethod<P> {
    public final String h;
    public final long i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ CallContext c;

        public b(f r1, Object r2, CallContext r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("BaseOpenMethodUsingCryptData", new Object[]{"get crypt success, crypt: " + ((com.bytedance.android.live.broadcastgame.opengame.network.p) ((BaseResponse) r5).data).a().a()});
            BootInfoService r1 = (BootInfoService) this.a.d.o(BootInfoService.class);
            String r6 = ((com.bytedance.android.live.broadcastgame.opengame.network.p) ((BaseResponse) r5).data).a().a();
            Intrinsics.checkNotNullParameter(r6, "crypt");
            com.bytedance.android.live.broadcastgame.opengame.runtime.g r2 = r1.c();
            if (r2 == null) goto L5;
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r2.a = r6;
        L5:
            this.a.call(this.b, this.c);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.e("BaseOpenMethodUsingCryptData", new Object[]{"get crypt fail, error: ", r5});
            this.a.o(r5);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final void invoke(P r6, CallContext r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        OpenPlatformMonitorService r0 = (OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class);
        String r1 = getMethodName();
        Intrinsics.checkNotNullParameter(r1, "method");
        OpenPlatformMonitorService.p(r0, r1, "ttlive_open_platform_openapi_call", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 56).c();
        if (k(getMethodName()) == false) goto L24;
        boolean r2 = false;
        String r3 = null;
        ((OpenPlatformMonitorService) this.d.o(OpenPlatformMonitorService.class)).i(getMethodName(), 0, null, null);
        if (this.c.length() != 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L13;
        String r5 = r7.b;
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.c = r5;
    L13:
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r8 = ((BootInfoService) this.d.o(BootInfoService.class)).c();
        if (r8 == null) goto L16;
        r3 = r8.a;
    L16:
        if (r3 != null) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        Lazy r9 = LiveOpenGameClient.d;
        j(((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).getCrypt(this.h, this.i).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r6, r7), new c(this)));
        return;
    L22:
        call(r6, r7);
        return;
    L18:
        if (r3.length() != 0) goto L20;
    L7:
        r4 = false;
        goto L8
    }

    public f(PluginContext r2, String r3, long r4, Queue<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r6);
        this.h = r3;
        this.i = r4;
    }
}
