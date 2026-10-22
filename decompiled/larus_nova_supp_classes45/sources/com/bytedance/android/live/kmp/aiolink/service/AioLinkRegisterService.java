package com.bytedance.android.live.kmp.aiolink.service;

import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.android.live.revenue.platform.container.impl.e0;
import com.bytedance.android.live.revenue.platform.container.impl.w;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.o;
import com.bytedance.platform.aio.channel.js.c;
import com.bytedance.platform.aio.channel.js.model.e;
import com.lynx.react.bridge.JavaOnlyMap;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import uh6.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AioLinkRegisterService implements b, o {

    public static final class a implements com.bytedance.platform.aio.channel.js.a {
        public final /* synthetic */ uh6.a a;

        public final void a(String r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "methodName");
            Intrinsics.checkNotNullParameter(r3, "method");
        }

        public a(uh6.a r1) {
            this.a = r1;
        }

        public final void b(e r3) {
            Intrinsics.checkNotNullParameter("rpcChannelMessage", "eventName");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.a.sendJsEvent("rpcChannelMessage", r3);
        }

        public final void d(JavaOnlyMap r3) {
            Intrinsics.checkNotNullParameter("rpcChannelMessageV2", "eventName");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.a.sendJsEvent("rpcChannelMessageV2", r3);
        }

        public final void c(String r3, c r4) {
            Intrinsics.checkNotNullParameter(r3, "methodName");
            Intrinsics.checkNotNullParameter(r4, "method");
            uh6.a r0 = this.a;
            KProperty[] r1 = e0.a;
            Intrinsics.checkNotNullParameter(r4, "$this$convertToStatefulMethod");
            r0.b(r3, new d0(r4));
        }
    }

    public AioLinkRegisterService() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Disposable h(uh6.a r8, j r9) {
        Intrinsics.checkNotNullParameter(r8, "aioBridgeExternal");
        return (Disposable) w.b(new a(r8), null, null, r9, AioLinkRegisterService$registerAioLink$1.INSTANCE, 4).getFirst();
    }
}
