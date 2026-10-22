package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.executor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.model.b1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/executor/DoubleLikeNextTabExecutor;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/core/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleLikeNextTabExecutor extends com.bytedance.android.live.room.navi.userinfo_p.flipper.core.a implements Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public Disposable b;
    public Disposable c;
    public final DataCenter d;
    public b1 e;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ DoubleLikeNextTabExecutor a;

        public b(DoubleLikeNextTabExecutor r1) {
            this.a = r1;
        }

        public final void run() {
            DoubleLikeNextTabExecutor r0 = this.a;
            int r1 = DoubleLikeNextTabExecutor.f;
            r0.g();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DoubleLikeNextTabExecutor a;

        public c(DoubleLikeNextTabExecutor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            DoubleLikeNextTabExecutor r4 = this.a;
            int r0 = DoubleLikeNextTabExecutor.f;
            r4.g();
            this.a.f();
        }
    }

    static {
    }

    public final void g() {
        Disposable r0 = this.b;
        Disposable r1 = null;
        if (r0 != null) goto L5;
    L10:
        Disposable r2 = this.c;
        if (r2 != null) goto L13;
    L17:
        this.d.removeObserver(this);
        return;
    L13:
        if ((!r2.isDisposed()) == false) goto L15;
        r1 = r2;
    L15:
        if (r1 == null) goto L17;
        r1.dispose();
        goto L17
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final void h() {
        b1 r0 = this.e;
        if (r0 == null) goto L5;
        long r1 = r0.c;
    L6:
        ALogger.d("DoubleLikeNextTabExecutor", "start next tab task by double like");
        Disposable r2 = this.c;
        if (r2 != null) goto L9;
    L14:
        this.c = Observable.just("").delay(r1, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this));
        return;
    L9:
        if ((!r2.isDisposed()) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        r2.dispose();
        goto L14
    L5:
        r1 = 2000;
        goto L6
    }

    @Override // w91.a
    public final Disposable execute() {
        g();
        this.d.observe("cmd_user_info_sub_title_anim", this);
        h();
        Disposable r0 = Disposables.fromAction(new b(this));
        this.b = r0;
        return r0;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L19;
        String r0 = r5.getKey();
        if (r0.hashCode() == (-777370727)) goto L9;
        return;
    L9:
        if (r0.equals("cmd_user_info_sub_title_anim") == false) goto L17;
        Object r6 = r5.getData();
        if ((r6 instanceof b1) == true) goto L13;
        r6 = null;
    L13:
        b1 r7 = (b1) r6;
        if (r7 == null) goto L18;
        this.e = r7;
        h();
        return;
    L18:
        return;
    L17:
        return;
    }

    public DoubleLikeNextTabExecutor(DataCenter r2, b1 r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.d = r2;
        this.e = r3;
    }
}
