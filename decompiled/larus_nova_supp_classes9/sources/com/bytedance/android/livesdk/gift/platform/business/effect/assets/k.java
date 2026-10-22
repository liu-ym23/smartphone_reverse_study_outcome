package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {

    public static final class a {
        public final long a;
        public final String b;
        public final int c;
        public final int d;
        public final boolean e;

        public a() {
            this(0, null, 0, 0, false, 31);
        }

        public a(long r3, String r5, int r6, int r7, boolean r8, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r5 = BuildConfig.FLAVOR;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r6 = 0;
        L12:
            if ((r9 & 8) == 0) goto L15;
            r7 = 0;
        L15:
            if ((r9 & 16) == 0) goto L17;
            r8 = false;
        L17:
            Intrinsics.checkNotNullParameter(r5, "path");
            this.a = r3;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
        }
    }

    public interface b {
        void a(List<a> r1);

        void b(boolean r1);

        void onFailed(Throwable r1);

        void onResult(List<a> r1);
    }

    public static void a(IAssetsManager r8, List r9, b r10, int r11, AssetDownloadPriority r13) {
        Intrinsics.checkNotNullParameter(r8, "assetsManager");
        Intrinsics.checkNotNullParameter(r9, "assetsIds");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r13, "priority");
        ArrayList r0 = new ArrayList();
        Iterator r14 = r9.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r0.add(Observable.create(new l(r8, ((Number) r14.next()).longValue(), r11, r13)));
        goto L4
    L6:
        Observable.merge(r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).toList().subscribe(new m(r10), new n(r10));
    }
}
