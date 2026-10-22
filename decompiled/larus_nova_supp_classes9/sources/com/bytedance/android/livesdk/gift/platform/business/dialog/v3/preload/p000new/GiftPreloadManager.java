package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import bytekn.foundation.logger.a;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPreloadSettingsKt;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftPreloadManager {
    public static final HashMap<GiftPreloadResType, k<?>> a = null;
    public static final CompositeDisposable b = null;
    public static final boolean c = false;

    static {
        HashMap<GiftPreloadResType, k<?>> r0 = new HashMap();
        a = r0;
        b = new CompositeDisposable();
        c = ((Boolean) GiftPreloadSettingsKt.f.getValue()).booleanValue();
        r0.put(GiftPreloadResType.ITEM_LIST_DATA, new m());
        r0.put(GiftPreloadResType.ICON_ANIMATOR_URI, new l());
    }

    public static Object a(f r3) {
        Intrinsics.checkNotNullParameter(r3, "cacheKey");
        if (c == true) goto L5;
        return null;
    L5:
        k<?> r0 = a.get(r3.b);
        if (r0 == null) goto L12;
        Object r4 = r0.d(r3);
        if ((r4 instanceof Object) == true) goto L11;
        return null;
    L11:
        return r4;
    L12:
        return null;
    }

    public static void b(final h r4) {
        Intrinsics.checkNotNullParameter(r4, "trigger");
        if (c == false) goto L5;
        Collection<k<?>> r0 = a.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L14:
        if (r2.hasNext() == false) goto L18;
        Object r3 = r2.next();
        if (((k) r3).c(r4) == false) goto L14;
        r1.add(r3);
        goto L14
    L18:
        Iterator r5 = r1.iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        final k r6 = (k) r5.next();
        RxUtilKt.c(Single.fromCallable(new g(new GiftPreloadManager$preload$$inlined$forEach$lambda$1(r6, r4))).subscribeOn(Schedulers.computation()).subscribe(), b);
        goto L20
    L22:
        int r7 = a.a;
        Objects.toString(r4);
        return;
    L5:
        if (GiftPreloadSettingsKt.b().e() == false) goto L30;
        final k<?> r8 = a.get(GiftPreloadResType.GIFT_ICON);
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.c(r4) != true) goto L32;
        RxUtilKt.c(Single.fromCallable(new g(new GiftPreloadManager$preload$1(r8, r4))).subscribeOn(Schedulers.computation()).subscribe(), b);
        return;
    L32:
        return;
    }

    public static void c(k r2) {
        Intrinsics.checkNotNullParameter(r2, "preloader");
        a.put(r2.a(), r2);
    }

    public static void d(k r1) {
        Intrinsics.checkNotNullParameter(r1, "preloader");
        a.remove(r1.a());
    }
}
