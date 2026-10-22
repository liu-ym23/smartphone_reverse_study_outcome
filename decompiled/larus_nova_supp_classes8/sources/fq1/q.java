package fq1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void a(StackTraceElement[] r2) {
        Intrinsics.checkNotNullParameter(r2, "traceElements");
        this.a.a(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void c(String r2, Map<String, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a.c(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final String d() {
        return this.a.d();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "dataString");
        this.a.d(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "dataString");
        this.a.e(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final String f() {
        return this.a.f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "dataString");
        this.a.i(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void logV3(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter("feed_enter_room", "eventName");
        Intrinsics.checkNotNullParameter(r3, "map");
        this.a.logV3("feed_enter_room", r3);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public q(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e r2) {
        Intrinsics.checkNotNullParameter(r2, "liveTraceService");
        this.a = r2;
    }
}
