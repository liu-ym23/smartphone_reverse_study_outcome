package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.Gson;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListCacheRepo implements com.bytedance.android.scope.o, dy0.c, xc6.b {
    public final Gson a;
    public boolean b;
    public final HashSet<Integer> c;
    public final Lazy d;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void f() {
        GiftManagerKt.z.getClass();
        if (GiftManagerKt.A() == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().d() != 2) goto L12;
        if (this.b == true) goto L20;
        this.b = true;
        Single.create(new f(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this), new h(this));
        return;
    L20:
        return;
    L12:
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().d() == 3) goto L14;
        return;
    L14:
        if (this.b == true) goto L21;
        this.b = true;
        Single.create(new i(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k(this));
        return;
    }

    public GiftListCacheRepo() {
        this.a = GsonHelper.get();
        this.c = new HashSet();
        this.d = LazyKt.lazy(GiftListCacheRepo$localGiftSPCacheFix$2.INSTANCE);
    }

    public final String o1() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r1 = r0.getGiftListResultLogId();
        if (r1 == null) goto L8;
        String r2 = (String) r1.getValue();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return BuildConfig.FLAVOR;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(GiftListCacheRepo r3, Map r4) {
        r3.getClass();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L28;
        IRoom r0 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (((Boolean) r3.d.getValue()).booleanValue() == false) goto L20;
        if (r0 == null) goto L20;
        int r5 = (int) r0.getRoomLayout();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r6 = r4.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) r6.next();
        if (((Number) r2.getKey()).intValue() != r5) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L12;
        r1.put(r2.getKey(), r2.getValue());
        goto L12
    L16:
        r7 = false;
        goto L17
    L19:
        r4 = r1;
    L20:
        ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).h3(r4);
        return;
    }
}
