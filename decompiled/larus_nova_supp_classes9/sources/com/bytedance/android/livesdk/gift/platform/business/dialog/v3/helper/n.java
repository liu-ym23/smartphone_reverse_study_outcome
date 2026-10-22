package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public static final /* synthetic */ int f = 0;
    public h1 a;
    public long b;
    public int c;
    public Disposable d;
    public Disposable e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ n a;

        public b(n r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            n r8 = this.a;
            long r0 = r8.b + 1000;
            r8.b = r0;
            int r1 = (((int) (r0 / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) * 3) + 5;
            if (r1 <= 50) goto L8;
            Disposable r2 = r8.d;
            if (r2 == null) goto L7;
            r2.dispose();
        L7:
            r1 = 50;
        L8:
            int r3 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW / r1;
            Disposable r4 = r8.e;
            if (r4 == null) goto L11;
            r4.dispose();
        L11:
            com.bytedance.android.live.core.utils.rxutils.j.a r5 = com.bytedance.android.live.core.utils.rxutils.j.a;
            r8.e = com.bytedance.android.live.core.utils.rxutils.j.a(0, r3, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(r8), s.a, t.a);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d implements Action {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void run() {
        }
    }

    static {
    }

    public n() {
    }

    public final void a() {
        this.a = null;
        this.c = 0;
        this.b = 0;
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.d;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public final void b(boolean r5) {
        if (r5 == true) goto L5;
        this.b = 0;
    L5:
        Disposable r6 = this.d;
        if (r6 == null) goto L8;
        r6.dispose();
    L8:
        com.bytedance.android.live.core.utils.rxutils.j.a r7 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.d = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a, d.a);
    }
}
