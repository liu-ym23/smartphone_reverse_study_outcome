package com.bytedance.android.livesdk.chatroom.widget;

import android.app.Activity;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r2 {

    public static class a {
        public static final r2 a = null;

        static {
            a = new r2();
        }
    }

    public r2() {
    }

    public static Observable a(Activity r2, String r3, Long r4, final Runnable r5) {
        com.bytedance.android.livesdk.user.f r6 = jc1.k.f(IUserService.class).user();
        com.bytedance.android.livesdk.user.d.b r7 = new com.bytedance.android.livesdk.user.d.b().c(r3).e();
        r7.e();
        com.bytedance.android.livesdk.user.d.b r8 = r7.g("");
        r8.e();
        com.bytedance.android.livesdk.user.d.b r9 = r8.h(r4.longValue());
        r9.e();
        com.bytedance.android.livesdk.user.d.b r10 = r9.f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.VS_USER_INFO));
        r10.getClass();
        return r6.e(new com.bytedance.android.livesdk.user.d(r10)).doOnSubscribe(new p2(r5));
    }
}
