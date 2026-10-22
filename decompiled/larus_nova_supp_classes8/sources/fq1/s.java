package fq1;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.utils.rxutils.autodispose.v;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return this.a.a(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final IBaseUser b() {
        return this.a.b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final void f(py.t r2) {
        Intrinsics.checkNotNullParameter(r2, "userAttr");
        this.a.f(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable<IFollowPair> followStateChanged() {
        return this.a.followStateChanged();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable g(String r4, Activity r5, LiveFollowScene r6) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter("", "requestId");
        Intrinsics.checkNotNullParameter("live_detail", "enterLiveSource");
        Intrinsics.checkNotNullParameter("", "fromLabel");
        Intrinsics.checkNotNullParameter("", "roomLabels");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        Intrinsics.checkNotNullParameter("follow", "scene");
        Intrinsics.checkNotNullParameter(r6, "followScene");
        return this.a.g(r4, r5, r6);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String getCurrentUserId() {
        return this.a.getCurrentUserId();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final py.k h() {
        return this.a.h();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String i() {
        return this.a.i();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean isLogin() {
        return this.a.isLogin();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final int j() {
        return this.a.j();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String k() {
        return this.a.k();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final void n(Fragment r2, bm1.b r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.n(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean o() {
        return this.a.o();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Single q(HashMap r2, String r3, Long r4, String r5) {
        return this.a.q(r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String s() {
        return this.a.s();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable w(String r3, Activity r4, LiveFollowScene r5) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter("", "fromLabel");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        Intrinsics.checkNotNullParameter("unfollow", "scene");
        Intrinsics.checkNotNullParameter(r5, "followScene");
        return this.a.w(r3, r4, r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final v<UserEvent> x(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        return this.a.x(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable<IBaseUser> y(Context r9, String r10, String r11, String r12, String r13, int r14, String r15) {
        return this.a.y(r9, r10, r11, r12, r13, r14, r15);
    }

    public s(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m r2) {
        Intrinsics.checkNotNullParameter(r2, "userService");
        this.a = r2;
    }
}
