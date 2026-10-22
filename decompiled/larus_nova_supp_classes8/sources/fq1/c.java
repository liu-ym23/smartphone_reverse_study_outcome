package fq1;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void a(String r2, Map<String, String> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.a(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void c(Context r2, Uri r3, Bundle r4) {
        this.a.c(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void d(FragmentActivity r2, Fragment r3, boolean r4) {
        this.a.d(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void f(Context r2, IRoom r3, Bundle r4) {
        this.a.f(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void g(Activity r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "bindPhoneListener");
        this.a.g(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final xu1.a getColorWeakModelEffectInfo() {
        this.a.getColorWeakModelEffectInfo();
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean h() {
        return this.a.h();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void handleSchema(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        this.a.handleSchema(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void handleSchema(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "uriString");
        this.a.handleSchema(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean isNeedProtectUnderage() {
        return this.a.isNeedProtectUnderage();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final boolean isNetworkStateChanged() {
        return this.a.isNetworkStateChanged();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b
    public final void startLive(Context r2, long r3, Bundle r5) {
        this.a.startLive(r2, r3, r5);
    }

    public c(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.b r2) {
        Intrinsics.checkNotNullParameter(r2, "hostAction");
        this.a = r2;
    }
}
