package fq1;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final boolean a(LottieAnimationView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "lottieView");
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.a.a(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final String c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final void d(py.k r2, Function1<? super Bitmap, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onNewResultImpl");
        this.a.d(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final void f(HSImageView r2, String r3) {
        this.a.f(r2, r3);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public g(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d r2) {
        Intrinsics.checkNotNullParameter(r2, "replayImageService");
        this.a = r2;
    }
}
