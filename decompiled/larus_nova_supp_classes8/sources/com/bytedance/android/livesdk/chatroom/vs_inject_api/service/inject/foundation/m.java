package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.rxutils.autodispose.v;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import fq1.s;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.HashMap;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface m {

    public static final class a {
        public static /* synthetic */ Observable a(s r10, Context r11, String r12, String r13, String r14, String r15, int r16, String r17, int r18) {
            if ((r18 & 4) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r18 & 8) == 0) goto L9;
            String r6 = null;
        L11:
            if ((r18 & 16) == 0) goto L13;
            String r7 = null;
        L15:
            if ((r18 & 32) == 0) goto L17;
            int r8 = 0;
        L19:
            if ((r18 & 64) == 0) goto L21;
            String r9 = null;
        L23:
            return r10.y(r11, r12, r5, r6, r7, r8, r9);
        L21:
            r9 = r17;
            goto L23
        L17:
            r8 = r16;
            goto L19
        L13:
            r7 = r15;
            goto L15
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L7
        }
    }

    String a(String r1);

    IBaseUser b();

    boolean c();

    void f(t r1);

    Observable<IFollowPair> followStateChanged();

    Observable g(String r1, Activity r2, LiveFollowScene r3);

    String getCurrentUserId();

    py.k h();

    String i();

    boolean isLogin();

    int j();

    String k();

    void n(Fragment r1, bm1.b r2);

    boolean o();

    Single q(HashMap r1, String r2, Long r3, String r4);

    String s();

    Observable w(String r1, Activity r2, LiveFollowScene r3);

    v<UserEvent> x(LifecycleOwner r1);

    Observable<IBaseUser> y(Context r1, String r2, String r3, String r4, String r5, int r6, String r7);
}
