package fq1;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k
    public final void a(Context r2) {
        this.a.a(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k
    public final boolean c(Context r2) {
        return this.a.c(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k
    public final boolean d(Context r2) {
        return this.a.d(r2);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public m(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.k r2) {
        Intrinsics.checkNotNullParameter(r2, "replayPermissionService");
        this.a = r2;
    }
}
