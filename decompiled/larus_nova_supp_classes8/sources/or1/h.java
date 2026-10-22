package or1;

import android.content.Context;
import com.bytedance.android.livesdk.TTLiveSDKContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.g, com.bytedance.android.scope.o {
    public h() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.g
    public final boolean isFreeFlow() {
        return TTLiveSDKContext.getHostService().d().appConfig().isFreeFlow();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.g
    public final void a(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        tm2.a r0 = (tm2.a) com.bytedance.android.livesdk.service.l.d().b().a(tm2.a.class);
        if (r0 == null) goto L8;
        r0.a(r3);
        return;
    }
}
