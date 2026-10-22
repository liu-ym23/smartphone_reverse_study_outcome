package or1;

import com.bytedance.android.live.GsonHelper;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i, com.bytedance.android.scope.o {
    public i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int a() {
        return 20006;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int c() {
        return 50001;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int f() {
        return 20047;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int g() {
        return 50004;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final int h() {
        return 50019;
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final Gson d() {
        return GsonHelper.get();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.i
    public final <T> T getService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "cls");
        return (T) com.bytedance.android.live.network.c.b().e(r2);
    }
}
