package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.net.Uri;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements vr1.i, com.bytedance.android.scope.o {
    public j() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.i
    public final Uri Q(String r2) {
        Intrinsics.checkNotNullParameter("/vs/ttlive_vs_linked_room_living.webp", "key");
        return i2.c("/vs/ttlive_vs_linked_room_living.webp");
    }

    @Override // vr1.i
    public final boolean R(LottieAnimationView r3) {
        Intrinsics.checkNotNullParameter(r3, "lottieView");
        Intrinsics.checkNotNullParameter("/vs/ttlive_match_room_camera_playing.json", "key");
        return i2.f(r3, "/vs/ttlive_match_room_camera_playing.json");
    }
}
