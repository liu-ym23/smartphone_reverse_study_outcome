package com.bytedance.android.live.profit.player;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final long a;
    public final CompositeDisposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;

        public a(Activity r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).fk(this.a, this.b);
        }
    }

    public p(CompositeDisposable r3) {
        Intrinsics.checkNotNullParameter(r3, "cd");
        this.b = r3;
        this.a = 1;
    }

    public static boolean a(IBaseUser r3) {
        String r0 = r3.getIdString();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r3.getIdString(), ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId()) == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    public final void b(IBaseUser r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "triggerUser");
        Intrinsics.checkNotNullParameter(r6, "schema");
        boolean r1 = false;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (a(r5) == false) goto L28;
        ALogger.i("OpenAsset", "opening schema: schema=".concat(r6));
        String r7 = UriProtector.parse(r6).getHost();
        if (r7 != null) goto L14;
    L20:
        Activity r8 = com.bytedance.android.live.core.utils.a.d();
        if (r8 == null) goto L23;
        r1 = vh6.c.b(pq2.a.class).handleSchema(r8, r6);
    L23:
        if (r1 == true) goto L27;
        ALogger.e("OpenAsset", "open schema failed: context=" + r8 + ", schema=" + r6);
        return;
    L27:
        return;
    L14:
        if (r7.hashCode() != (-98539011)) goto L20;
        if (r7.equals("webcast_profile") == false) goto L20;
        ALogger.i("OpenAsset", "is profile schema");
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).Xn();
        return;
    L28:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(IBaseUser r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "triggerUser");
        Intrinsics.checkNotNullParameter(r5, "schema");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (a(r4) == false) goto L25;
        ALogger.i("OpenAsset", "preparing schema: schema=".concat(r5));
        String r6 = UriProtector.parse(r5).getHost();
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.hashCode() == (-98539011)) goto L17;
        return;
    L17:
        if (r6.equals("webcast_profile") == false) goto L24;
        ALogger.i("OpenAsset", "is profile schema");
        Activity r7 = com.bytedance.android.live.core.utils.a.d();
        if (r7 != null) goto L21;
        return;
    L21:
        RxUtilKt.c(Observable.timer(this.a, TimeUnit.SECONDS).subscribe(new a(r7, r5)), this.b);
        return;
    L24:
        return;
    L25:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
