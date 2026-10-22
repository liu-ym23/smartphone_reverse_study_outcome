package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.newmethods.FetchV3Method;
import com.bytedance.android.live.browser.jsbridge.newmethods.e3;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.config.ni1;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import dagger.internal.SetBuilder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LivePrefetchProcessor implements com.bytedance.android.live.browser.jsbridge.h {
    public static final /* synthetic */ int d = 0;
    public Map<String, x46.a> a;

    @Inject
    public Set<com.bytedance.android.live.browser.jsbridge.g> b;

    @Inject
    public w c;

    public static final class LocalStorageImpl implements com.bytedance.ies.tools.prefetch.h {
        public final Lazy a;
        public final String b;

        public final void removeAll() {
        }

        public final Collection b() {
            Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
            return ((com.bytedance.android.tools.superkv.e) this.a.getValue()).b();
        }

        public LocalStorageImpl(String r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            this.b = r2;
            this.a = LazyKt.lazy(new LivePrefetchProcessor$LocalStorageImpl$dataStore$2(this));
        }

        public final void a(Collection r3) {
            Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
            Intrinsics.checkNotNullParameter(r3, "collection");
            ((com.bytedance.android.tools.superkv.e) this.a.getValue()).a(r3);
        }

        public final String getString(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            return ((com.bytedance.android.tools.superkv.e) this.a.getValue()).getString(r2);
        }

        public final void remove(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            ((com.bytedance.android.tools.superkv.e) this.a.getValue()).remove(r2);
        }

        public final void putString(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            ((com.bytedance.android.tools.superkv.e) this.a.getValue()).putString(r2, r3);
        }
    }

    public static final class a {
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ LivePrefetchProcessor a;

        public b(LivePrefetchProcessor r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            LivePrefetchProcessor r1 = this.a;
            w r2 = r1.c;
            if (r2 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("lynxService");
        L6:
            return new com.bytedance.android.live.browser.jsbridge.prefetch.a(r1, r2);
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            if (((Boolean) ni1.a.getValue()).booleanValue() == false) goto L6;
            return new FetchV3Method();
        L6:
            return new e3();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final void init() {
        BrowserServiceImpl.Companion.getClass();
        s20.a r0 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a();
        this.b = SetBuilder.newSetBuilder(2).add((com.bytedance.android.live.browser.jsbridge.g) r0.a.m.get()).add((com.bytedance.android.live.browser.jsbridge.g) r0.a.n.get()).build();
        this.c = (w) r0.a.h.get();
        Set<com.bytedance.android.live.browser.jsbridge.g> r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("providers");
    L5:
        Observable.merge(SequencesKt.asIterable(SequencesKt.map(CollectionsKt.asSequence(r1), LivePrefetchProcessor$initActual$1.INSTANCE))).subscribeOn(Schedulers.io()).filter(e.a).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), g.a);
        Observable.fromCallable(h.a).subscribeOn(Schedulers.io()).subscribe(Functions.emptyConsumer(), Functions.emptyConsumer());
    }

    public LivePrefetchProcessor() {
        this.a = MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final void a(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "bridge");
        if ((!this.a.isEmpty()) == false) goto L5;
        r3.registerMethod("__prefetch", new b(this));
        return;
    L5:
        r3.registerMethod("__prefetch", c.a);
    }

    public final x46.a c(final String r7) {
        if (r7 == null) goto L26;
        Map<String, x46.a> r1 = this.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Matcher r3 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(TTLiveWebOfflineConfig.getGroupTypePattern()), new LivePrefetchProcessor$getChannelFrom$$inlined$runCatching$lambda$1(r7)), LivePrefetchProcessor$getChannelFrom$1$2.INSTANCE));     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        String r4 = StringsKt.substringBefore$default(b(r7, r3), '/', null, 2, null);     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L17;
        int r8 = x8.a.a;
        x8.a.b("LivePrefetchProcessor", "get channel from url failed, url: " + r7 + ", exception=" + r6.getMessage(), false);
    L17:
        if (Result.isFailure-impl(r5) == false) goto L19;
        r5 = null;
    L19:
        x46.a r9 = r1.get((String) r5);
        if (r9 != null) goto L23;
        r9 = this.a.get(null);
    L23:
        return r9;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L26:
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final Map<String, Object> getCacheByScheme(String r4) {
        Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
        x46.a r0 = c(r4);
        if (r0 == null) goto L5;
        List r5 = r0.getCacheByScheme(r4);
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        if (r5 == null) goto L14;
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        PrefetchProcess r2 = (PrefetchProcess) r6.next();
        com.bytedance.ies.tools.prefetch.i.b r3 = r2.d;
        if (r3 == null) goto L10;
        r1.put(r2.f.d, r3);
    L14:
        return r1;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final JSONObject getCacheJsonByScheme(String r9) {
        Intrinsics.checkNotNullParameter(r9, LiveSlardarConstants.EXTRA_KEY_URL);
        x46.a r0 = c(r9);
        if (r0 == null) goto L48;
        List r11 = r0.getCacheByScheme(r9);
        if (r11 == null) goto L49;
        Iterator r12 = r11.iterator();
        JSONObject r1 = null;
    L8:
        if (r12.hasNext() == false) goto L34;
        PrefetchProcess r2 = (PrefetchProcess) r12.next();
        String r3 = r2.f.d;
        boolean r5 = false;
        if (r3.length() != 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L8;
        com.bytedance.ies.tools.prefetch.i.b r6 = r2.d;
        if (r6 == null) goto L8;
        if ((r6 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == true) goto L20;
    L22:
        if (r5 == true) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L8;
        JSONObject r7 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r6).g.getValue();
        if (r7 == null) goto L8;
        JSONObject r8 = r7.optJSONObject("raw");
        if (r8 == null) goto L8;
        if (r1 != null) goto L32;
        r1 = new JSONObject();
    L32:
        r1.put(r3, r8);
        goto L8
    L20:
        if (r6.d != 200) goto L22;
        r5 = true;
        goto L22
    L12:
        r4 = false;
        goto L13
    L34:
        return r1;
    L49:
        return null;
    L48:
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.h
    public final void prefetch(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        x46.a r0 = c(r2);
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public static String b(String r9, Matcher r11) {
        int r0 = StringsKt.indexOf$default(r9, "?", 0, false, 6, null);
        int r1 = StringsKt.indexOf$default(r9, "#", 0, false, 6, null);
        Integer r2 = Integer.valueOf(RangesKt.coerceAtMost(r0, r1));
        if (r2.intValue() < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        int r4 = r2.intValue();
    L13:
        if (r4 == (-1)) goto L19;
        int r12 = r11.end();
        if (r9 == null) goto L18;
        String r13 = r9.substring(r12, r4);
    L23:
        return StringsKt.trim(r13, new char[]{'/'});
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        int r14 = r11.end();
        if (r9 == null) goto L25;
        r13 = r9.substring(r14);
        goto L23
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        r4 = RangesKt.coerceAtLeast(r0, r1);
        goto L13
    L5:
        r3 = false;
        goto L6
    }
}
