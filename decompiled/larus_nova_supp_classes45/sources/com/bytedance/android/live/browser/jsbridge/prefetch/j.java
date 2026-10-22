package com.bytedance.android.live.browser.jsbridge.prefetch;

import android.util.Pair;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.livesdk.config.gj0;
import com.bytedance.android.livesdk.config.td1;
import com.bytedance.android.livesdk.f4;
import com.bytedance.android.livesdk.gecko.LiveGeckoConfig;
import com.bytedance.android.livesdk.gecko.LiveResourcesDistributionImpl;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements com.bytedance.android.live.browser.jsbridge.g {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "channel");
            InputStream r0 = com.bytedance.android.livesdk.gecko.n.b.a("prefetch." + r5 + ".json", r5);
            if (r0 == null) goto L18;
            Reader r2 = new InputStreamReader(r0, Charsets.UTF_8);
            if ((r2 instanceof BufferedReader) == false) goto L7;
            BufferedReader r3 = (BufferedReader) r2;
        L19:
            String r1 = TextStreamsKt.readText(r3);     // Catch: Throwable -> L12
            CloseableKt.closeFinally(r3, null);
            if (r1 == null) goto L18;
            return new com.bytedance.android.live.browser.jsbridge.g.a(r5, r1);
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            CloseableKt.closeFinally(r3, th);
            throw th;
        L7:
            r3 = new BufferedReader(r2, IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        L18:
            return com.bytedance.android.live.browser.jsbridge.g.a.c;
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
            Intrinsics.checkNotNullParameter((Throwable) r2, "it");
            return com.bytedance.android.live.browser.jsbridge.g.a.c;
        }
    }

    public static final class c<T> implements Predicate {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean test(Object r2) {
            com.bytedance.android.live.browser.jsbridge.g.a r3 = (com.bytedance.android.live.browser.jsbridge.g.a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3 == com.bytedance.android.live.browser.jsbridge.g.a.c) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.live.browser.jsbridge.g
    public final Observable<com.bytedance.android.live.browser.jsbridge.g.a> getConfig() {
        if (((Boolean) td1.a.getValue()).booleanValue() == false) goto L15;
        LiveResourcesDistributionImpl r0 = com.bytedance.android.livesdk.gecko.n.b.a;
        r0.getClass();
        if (((Boolean) f4.a.getValue()).booleanValue() == false) goto L10;
        List r1 = ResLoadUtils.getAllLocalChannels(new PolarisFileWrapper(LiveGeckoConfig.c()), LiveGeckoConfig.b());
        ?? r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        r2.add((String) ((Pair) r3.next()).first);
    L17:
        return Observable.fromIterable((Iterable) r2).subscribeOn(Schedulers.io()).map(a.a).onErrorReturn(b.a).filter(c.a);
    L10:
        com.bytedance.android.livesdk.gecko.j r4 = r0.a;
        if (r4 == null) goto L14;
        r2 = r4.b();
        if (r2 != 0) goto L17;
    L14:
        r2 = CollectionsKt.emptyList();
        goto L17
    L15:
        r2 = TTLiveWebOfflineConfig.DOUYIN_CHANNEL_LIST;
        r2.addAll((List) gj0.a.getValue());
        goto L17
    }
}
