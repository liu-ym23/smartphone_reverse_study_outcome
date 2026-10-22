package aw8;

import bw8.k;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.favorite.network.FavoriteEntranceNetworkAPI;
import com.larus.business.debug.base.register.favorite.network.bean.FavoriteEntranceGetResponse;
import com.larus.common.apphost.AppHost;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final List<Map<EntranceGroup, LinkedList<e>>> a = null;
    public static final List<d> b = null;
    public static boolean c;
    public static String d;
    public static final List<Map<EntranceGroup, LinkedList<e>>> e = null;

    static {
        a = new ArrayList();
        b = new ArrayList();
        d = "";
        e = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [aw8.a] */
    /* JADX WARN: Type inference failed for: r2v5, types: [bw8.a] */
    /* JADX WARN: Type inference failed for: r2v6, types: [bw8.c] */
    @JvmStatic
    public static final void a() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isOversea() == true) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        return;
    L12:
        if (c == false) goto L14;
        return;
    L14:
        e0 r2 = (e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L20;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L20;
        String r4 = r3.A1();
        if (r4 == null) goto L20;
    L21:
        final ?? r5 = new a();
        Lazy r6 = k.a;
        Intrinsics.checkNotNullParameter(r4, "uid");
        FavoriteEntranceNetworkAPI r7 = (FavoriteEntranceNetworkAPI) k.a.getValue();
        if (r7 == null) goto L31;
        Observable<FavoriteEntranceGetResponse> r8 = r7.getFavoriteEntrance("/mobile/debug/entrance/favorite/get", MapsKt.mapOf(new Pair[]{TuplesKt.to("uid", r4), TuplesKt.to("platform", "Android")}));
        if (r8 == null) goto L32;
        Observable r9 = r8.subscribeOn(Schedulers.io());
        if (r9 == null) goto L33;
        Observable r10 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r10 == null) goto L34;
        final ?? r11 = new bw8.a(r5);
        Consumer r12 = new bw8.b(r11);
        final ?? r13 = new bw8.c(r5);
        r10.subscribe(r12, new bw8.d(r13));
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L20:
        r4 = "";
        goto L21
    L6:
        if (r0.isTestChannel() == true) goto L4;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean b(e r6) {
        Intrinsics.checkNotNullParameter(r6, "entrance");
        Iterator<T> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        Map r1 = (Map) r0.next();
        Iterator r2 = r1.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        LinkedList r3 = (LinkedList) r1.get((EntranceGroup) r2.next());
        if (r3 == null) goto L7;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L7;
        if (Intrinsics.areEqual(((e) r4.next()).toString(), r6.toString()) == false) goto L12;
        return true;
    L17:
        return false;
    }
}
