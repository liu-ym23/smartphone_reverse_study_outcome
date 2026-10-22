package com.ss.ugc.live.sdk.msg.network;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements l {

    /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.network.a$a, reason: collision with other inner class name */
    public static final class C0212a implements j {
        public C0212a() {
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final boolean a() {
            return false;
        }

        @Override // com.ss.ugc.live.sdk.msg.network.j
        public final void b(tlc.f r2) {
            Intrinsics.checkNotNullParameter(r2, "payloadItem");
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void disconnect() {
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void e(tlc.f r2) {
            Intrinsics.checkNotNullParameter(r2, "payloadItem");
        }

        @Override // com.ss.ugc.live.sdk.msg.network.k
        public final void f(tlc.f r2) {
            Intrinsics.checkNotNullParameter(r2, "payloadItem");
        }
    }

    public a() {
    }

    @Override // com.ss.ugc.live.sdk.msg.network.l
    public final k a(String r1, Map<String, String> r2, m r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "onWSListener");
        C0212a r5 = new C0212a();
        r3.b("empty");
        return r5;
    }
}
