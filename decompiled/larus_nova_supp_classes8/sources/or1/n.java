package or1;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.v;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.LiveInteractFunction;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdkapi.depend.event.FollowStateChangeEvent;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m, com.bytedance.android.scope.o {

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "userEvent");
            if (r3.getStatus() != IBaseUser.Status.Login) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            FollowPair r3 = (FollowPair) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3;
        }
    }

    public n() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final int j() {
        return 2;
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final py.k h() {
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L9;
        IUser r2 = r1.b();
        if (r2 == null) goto L9;
        return r2.getAvatarThumb();
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String i() {
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L9;
        IUser r2 = r1.b();
        if (r2 == null) goto L9;
        return r2.getNickName();
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final IBaseUser b() {
        return TTLiveSDKContext.getHostService().h().b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean c() {
        return TTLiveSDKContext.getHostService().h().c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable<IFollowPair> followStateChanged() {
        return TTLiveSDKContext.getHostService().h().followStateChanged().map(b.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String getCurrentUserId() {
        return TTLiveSDKContext.getHostService().h().n();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean isLogin() {
        return TTLiveSDKContext.getHostService().h().isLogin();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String k() {
        return CoreSettingUtil.getLoginPromptForFollow();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final boolean o() {
        return TTLiveSDKContext.getHostService().h().g(LiveInteractFunction.COMMENT);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String s() {
        return CoreSettingUtil.getLoginImageForFollow();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return TTLiveSDKContext.getHostService().h().a(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final void f(t r3) {
        Intrinsics.checkNotNullParameter(r3, "userAttr");
        f0 r0 = TTLiveSDKContext.getHostService().h();
        f0 r1 = r0;
        r1.V((UserAttr) com.bytedance.android.live.base.model.m.b(r3, UserAttr.class));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final v<UserEvent> x(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        return (v) TTLiveSDKContext.getHostService().h().m().onBackpressureLatest().filter(a.a).as(AutoDispose.bind(r3));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final void n(Fragment r3, bm1.b r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((ObservableSubscribeProxy) xs2.b.a().b(FollowStateChangeEvent.class).compose(RxUtil.bindUntilDestroy(r3)).as(AutoDispose.bind(r3))).subscribe(new q(r4));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable g(String r9, Activity r10, LiveFollowScene r11) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter("", "requestId");
        Intrinsics.checkNotNullParameter("live_detail", "enterLiveSource");
        Intrinsics.checkNotNullParameter("", "fromLabel");
        Intrinsics.checkNotNullParameter("", "roomLabels");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        Intrinsics.checkNotNullParameter("follow", "scene");
        Intrinsics.checkNotNullParameter(r11, "followScene");
        com.bytedance.android.livesdk.user.d.c r12 = new com.bytedance.android.livesdk.user.d.c().c(r9).e();
        r12.getClass();
        com.bytedance.android.livesdk.user.d.c r13 = r12.g("");
        r13.getClass();
        com.bytedance.android.livesdk.user.d.c r14 = r13.f(com.bytedance.android.livesdk.user.j.b(r11));
        r14.getClass();
        String r2 = ((com.bytedance.android.livesdk.user.a.a) r14).a;
        String r5 = ((com.bytedance.android.livesdk.user.a.a) r14).b;
        long r3 = ((com.bytedance.android.livesdk.user.b.a) r14).e;
        HashMap r6 = ((com.bytedance.android.livesdk.user.b.a) r14).f;
        boolean r7 = ((com.bytedance.android.livesdk.user.b.a) r14).g;
        f0 r0 = TTLiveSDKContext.getHostService().h();
        r0.getClass();
        return r0.Q(1, r2, r3, r5, r6, r7).map(o.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable w(String r9, Activity r10, LiveFollowScene r11) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter("", "fromLabel");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        Intrinsics.checkNotNullParameter("unfollow", "scene");
        Intrinsics.checkNotNullParameter(r11, "followScene");
        com.bytedance.android.livesdk.user.n.c r12 = new com.bytedance.android.livesdk.user.n.c().c(r9);
        r12.getClass();
        com.bytedance.android.livesdk.user.n.c r13 = r12.e(com.bytedance.android.livesdk.user.j.b(r11));
        r13.getClass();
        String r2 = ((com.bytedance.android.livesdk.user.a.a) r13).a;
        String r5 = ((com.bytedance.android.livesdk.user.a.a) r13).b;
        HashMap r6 = ((com.bytedance.android.livesdk.user.a.a) r13).c;
        long r3 = ((com.bytedance.android.livesdk.user.m.a) r13).d;
        boolean r7 = ((com.bytedance.android.livesdk.user.m.a) r13).e;
        f0 r0 = TTLiveSDKContext.getHostService().h();
        r0.getClass();
        return r0.Q(0, r2, r3, r5, r6, r7).map(r.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Single q(HashMap r1, String r2, Long r3, String r4) {
        return TTLiveSDKContext.getHostService().h().d(r1).map(p.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m
    public final Observable<IBaseUser> y(Context r3, String r4, String r5, String r6, String r7, int r8, String r9) {
        f0 r0 = TTLiveSDKContext.getHostService().h();
        com.bytedance.android.livesdk.user.l.a r1 = new com.bytedance.android.livesdk.user.l.a();
        r1.a = r4;
        r1.d = r5;
        r1.e = r6;
        r1.b = r7;
        r1.c = r8;
        r1.g = r9;
        f0 r2 = r0;
        return r2.login(r3, new com.bytedance.android.livesdk.user.l(r1)).map(c.a);
    }
}
