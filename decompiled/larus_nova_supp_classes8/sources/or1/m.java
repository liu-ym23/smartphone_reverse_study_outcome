package or1;

import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.b0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements com.bytedance.android.scope.o, com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e {
    public m() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final String d() {
        return "ttlive_room";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final String f() {
        return "ttlive_msg";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void a(StackTraceElement[] r2) {
        Intrinsics.checkNotNullParameter(r2, "traceElements");
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.m(6, r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void c(String r2, Map<String, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "data");
        b0.o().j(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "dataString");
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.a(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "dataString");
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "dataString");
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.i(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.e
    public final void logV3(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter("feed_enter_room", "eventName");
        Intrinsics.checkNotNullParameter(r3, "map");
        TTLiveSDKContext.getHostService().f().logV3("feed_enter_room", r3);
    }
}
