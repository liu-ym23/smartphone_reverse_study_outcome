package wx1;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import bw.p;
import com.bytedance.android.gamecp.host_api.model.user.FollowPair;
import com.bytedance.android.gamecp.host_api.model.user.IUser;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements hw.b {
    public IUser a;
    public final com.bytedance.android.gamecp.base.cache.c b;
    public PublishSubject<IUser> c;
    public final PublishProcessor<hw.c> d;
    public final PublishSubject<IUser> e;
    public final b f;
    public final p g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((UserEvent) r4).isLogin() == false) goto L5;
            g r5 = this.a;
            r5.f(r5.g.b());
            this.a.g().subscribe(new f(this));
            return;
        L5:
            this.a.f(new wx1.e());
            g r6 = this.a;
            PublishProcessor<hw.c> r0 = r6.d;
            IUser.Status r2 = IUser.Status.Login;
            r0.onNext(new hw.c(r6.b()));
        }
    }

    public static final class b implements hw.a {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        public final void a(User r3) {
            Intrinsics.checkNotNullParameter(r3, "user");
            g r0 = this.a;
            if (r0.c == null) goto L6;
            r0.a = r3;
            r0.g().subscribe(new j(this, r3));
            return;
        }

        public final void onCancel(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            PublishSubject<IUser> r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.onError(r2);
        L5:
            this.a.c = null;
            hw.d r3 = new hw.d();
            xr.f r1 = com.bytedance.android.livesdk.gamecp.b.a();
            if (r1 == null) goto L9;
            r1.u(r3);
            return;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r3) {
            BaseResponse r4 = (BaseResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            com.bytedance.android.live.base.model.user.User r5 = jm2.a.d((vh7.c) r4.data);
            if (r5 == null) goto L7;
            com.bytedance.android.live.base.model.user.User r6 = r5;
            User r0 = new User();
            r0.setNickName(r6.getNickName());
            r0.setAvatarThumb(wx1.a.b(r6.getAvatarThumb()));
            r0.setAvatarMedium(wx1.a.b(r6.getAvatarMedium()));
            r0.setAvatarLarge(wx1.a.b(r6.getAvatarLarge()));
            r0.setIdStr(r6.getIdStr());
            r0.setId(r6.getUserId());
            return r0;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.User");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ g a;

        public d(g r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IUser r3 = (IUser) r2;
            Intrinsics.checkNotNullParameter(r3, "user");
            this.a.e.onNext(r3);
            this.a.a = r3;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public final IUser b() {
        String r0 = this.a.getId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        f(this.g.b());
    L12:
        return this.a;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final Single<IUser> g() {
        String r0 = this.g.getCurUserId();
        Single r1 = k.n(IUserService.class).user().r(r0);
        if (r1 == null) goto L15;
        Single r2 = r1.subscribeOn(Schedulers.io());
        if (r2 == null) goto L15;
        Single r3 = r2.map(c.a);
        if (r3 == null) goto L15;
        Single r4 = r3.observeOn(AndroidSchedulers.mainThread());
        if (r4 == null) goto L15;
        Single r5 = r4.doOnSuccess(new d(this));
        if (r5 == null) goto L15;
        Single<IUser> r6 = r5.doOnError(e.a);
        if (r6 == null) goto L15;
        return r6;
    L15:
        return Single.never();
    }

    public final String getCurrentUserId() {
        String r0 = this.a.getId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        f(this.g.b());
    L12:
        return this.a.getId();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean isLogin() {
        return k.n(od1.a.class).shouldTreatAsLoggedIn();
    }

    public g(p r3) {
        Intrinsics.checkNotNullParameter(r3, "userService");
        this.g = r3;
        this.a = new wx1.e();
        this.b = new com.bytedance.android.gamecp.base.cache.c();
        this.d = new PublishProcessor();
        this.e = PublishSubject.create();
        this.f = new b(this);
        f(r3.b());
        Flowable r0 = k.n(IUserService.class).user().x();
        if (r0 == null) goto L6;
        r0.subscribe(new a(this));
    L6:
        if (r3.getCurUserId().length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        g().subscribe(new com.bytedance.android.livesdk.gamecp.utils.e());
        return;
    L12:
        return;
    L8:
        r4 = false;
        goto L9
    }

    public static FragmentActivity e(Context r1) {
        if (r1 != null) goto L5;
    L13:
        return null;
    L5:
        if ((r1 instanceof Application) == true) goto L13;
        if ((r1 instanceof FragmentActivity) == false) goto L11;
        return (FragmentActivity) r1;
    L11:
        if ((r1 instanceof ContextWrapper) == false) goto L13;
        return e(((ContextWrapper) r1).getBaseContext());
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        IUser r3 = (IUser) this.b.a(r2);
        if (r3 == null) goto L6;
        String r4 = r3.getSecUid();
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "";
    }

    public final Observable<FollowPair> d(com.bytedance.android.gamecp.host_api.model.user.b r17) {
        Intrinsics.checkNotNullParameter(r17, "params");
        String r1 = ((com.bytedance.android.gamecp.host_api.model.user.a) r17).a;
        long r10 = r17.b;
        HashMap r0 = new HashMap();
        String r3 = "";
        String r4 = null;
        Pair r2 = new Pair("", null);
        IRoomService r5 = k.f(IRoomService.class);
        if (r5 == null) goto L5;
        Room r6 = r5.getCurrentRoom();
    L6:
        if (r6 == null) goto L18;
        String r7 = r6.getOwnerUserIdString();
        if (r7 == null) goto L12;
        r3 = r7;
    L12:
        if (r6.getOwner() == null) goto L16;
        com.bytedance.android.live.base.model.user.User r8 = r6.getOwner();
        if (r8 == null) goto L16;
        r4 = r8.getSecUid();
    L16:
        r2 = new Pair(r3, r4);
    L18:
        if (((CharSequence) r2.getFirst()).length() <= 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L24;
        r0.put("anchor_id", r2.getFirst());
    L24:
        if (r2.getSecond() == null) goto L26;
        r0.put("sec_anchor_id", r2.getSecond());
    L26:
        PublishSubject r11 = PublishSubject.create();
        long r12 = SystemClock.uptimeMillis();
        Observable r14 = k.n(IUserService.class).user().h(new com.bytedance.android.livesdk.user.b.b().h(r10).c(r1).d());
        if (r14 == null) goto L29;
        r14.subscribe(new h(this, r11, r1, r10, r12), new i(this, r11, r1, r10, r12));
    L29:
        return r11;
    L20:
        r9 = false;
        goto L21
    L5:
        r6 = null;
        goto L6
    }

    public final void f(IUser r4) {
        if (r4 == null) goto L4;
        this.a = r4;
        PublishProcessor<hw.c> r0 = this.d;
        IUser.Status r2 = IUser.Status.Login;
        r0.onNext(new hw.c(r4));
        this.b.b(r4.getId(), r4);
        this.e.onNext(r4);
        return;
    L4:
        this.a = new wx1.e();
    }

    public final Observable<IUser> c(Context r7, com.bytedance.android.gamecp.host_api.model.user.c r8) {
        FragmentActivity r1 = e(r7);
        if (r1 == null) goto L11;
        p r0 = this.g;
        b r2 = this.f;
        Intrinsics.checkNotNull(r8);
        r0.v1(r1, r2, r8.a, r8.b, r8.c);
        PublishSubject<IUser> r9 = PublishSubject.create();
        this.c = r9;
        if (r9 == null) goto L9;
        Observable<IUser> r10 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r10 == null) goto L9;
        return r10;
    L9:
        return Observable.empty();
    L11:
        throw new IllegalArgumentException("Argument \"context\" cannot be transformed to FragmentActivity in UserCenter.login() method. ");
    }
}
