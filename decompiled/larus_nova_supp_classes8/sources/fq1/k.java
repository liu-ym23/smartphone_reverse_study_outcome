package fq1;

import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i, com.bytedance.android.scope.o {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int a() {
        return this.a.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final Gson d() {
        return this.a.d();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int f() {
        return this.a.f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int g() {
        return this.a.g();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final <T> T getService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "cls");
        return (T) this.a.getService(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int h() {
        return this.a.h();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public k(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i r2) {
        Intrinsics.checkNotNullParameter(r2, "networkService");
        this.a = r2;
    }
}
