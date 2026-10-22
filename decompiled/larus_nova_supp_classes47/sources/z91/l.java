package z91;

import b30.c0;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements Runnable {
    public final /* synthetic */ UserInfoDataSource a;

    public l(UserInfoDataSource r1) {
        this.a = r1;
    }

    public final void a() {
        UserInfoDataSource r0 = this.a;
        r0.g = new com.bytedance.android.live.room.navi.userinfo_p.utils.c(r0.h.getDataCenter(), this.a.h.getRoom());
        UserInfoDataSource r1 = this.a;
        r1.e = yt0.c.c();
        UserInfoDataSource r2 = this.a;
        String r3 = (String) r2.h.getDataCenter().get("log_enter_live_source");
        r2.getClass();
        UserInfoDataSource r4 = this.a;
        if (r4.h.isAnchor() == true) goto L36;
        r4.c = (com.bytedance.android.livesdk.user.e) r4.h.getDataCenter().get("data_user_center");
        IRoom r5 = r4.h.getRoom();
        if (r5 == null) goto L38;
        String r6 = r5.getOwnerUserIdString();
        if (r6 == null) goto L40;
        IRoom r7 = r4.h.getRoom();
        if (r7 == null) goto L39;
        long r8 = r7.getId();
        com.bytedance.android.livesdk.user.e r9 = r4.c;
        if (r9 == null) goto L22;
        Observable r10 = r9.u0(r6);
        if (r10 == null) goto L22;
        Observable r12 = r10.subscribeOn(Schedulers.io());
        if (r12 == null) goto L22;
        Observable r13 = r12.observeOn(AndroidSchedulers.mainThread());
        if (r13 == null) goto L22;
        Disposable r14 = r13.subscribe(new e(r4), new f(r4));
        if (r14 == null) goto L22;
        r4.b.add(r14);
    L22:
        Disposable r15 = xs2.b.a().b(c0.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r4, r8));
        if (r15 == null) goto L25;
        r4.b.add(r15);
    L25:
        o r16 = r4.e;
        if (r16 == null) goto L36;
        Observable<com.bytedance.android.live.profit.fansclub.c> r17 = r16.r1();
        if (r17 == null) goto L36;
        Observable r18 = r17.subscribeOn(Schedulers.io());
        if (r18 == null) goto L36;
        Observable r19 = r18.observeOn(AndroidSchedulers.mainThread());
        if (r19 == null) goto L36;
        Disposable r20 = r19.subscribe(new h(r4));
        if (r20 == null) goto L36;
        r4.b.add(r20);
        goto L36
    L39:
        return;
    L40:
        return;
    L38:
        return;
    L36:
        r4.h.getDataCenter().observeForever("data_login_event", r4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
