package com.bytedance.android.ec.core.hybrid.prefetch;

import android.net.Uri;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.y;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.data.gecko.HybridForestLoader;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.Converter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.Channel;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class NativePrefetch {
    public static final p i = null;
    public static final int j = 0;
    public JSONObject a;
    public Map<String, String> b;
    public final Map<String, a> c;
    public Long d;
    public final long e;
    public String f;
    public final Lazy g;
    public boolean h;

    public static final class a {
        public ECBaseBridgeMethod.a a;
        public o b;
        public q c;
        public JSONObject d;

        public a() {
            this(0);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L14;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            ECBaseBridgeMethod.a r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            o r12 = this.b;
            if (r12 == null) goto L9;
            int r13 = r12.hashCode();
        L10:
            int r14 = (r11 + r13) * 31;
            q r15 = this.c;
            if (r15 == null) goto L13;
            int r16 = r15.hashCode();
        L14:
            int r17 = (r14 + r16) * 31;
            JSONObject r18 = this.d;
            if (r18 == null) goto L18;
            r1 = r18.hashCode();
        L18:
            return r17 + r1;
        L13:
            r16 = 0;
            goto L14
        L9:
            r13 = 0;
            goto L10
        L5:
            r10 = 0;
            goto L6
        }

        public final String toString() {
            return "ApiKeyRequestModel(prefetchCallback=" + this.a + ", prefetching=" + this.b + ", prefetchTiming=" + this.c + ", extraInfo=" + this.d + ")";
        }

        public a(int r1) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    public static final class b {
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ NativePrefetch a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ Uri c;

        public c(NativePrefetch r1, Ref.IntRef r10, Uri r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void subscribe(final ObservableEmitter<JSONObject> r10) {
            Intrinsics.checkNotNullParameter(r10, "emitter");
            JSONObject r1 = null;
            String r11 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            r1 = null;
            JSONObject r0 = this.a.z(null);
            if (r0 == null) goto L6;
            this.b.element = 2;
            r10.onNext(r0);
            return;
        L6:
            boolean r12 = true;
            this.b.element = 1;
            NativePrefetch r13 = this.a;
            y.b r14 = r13.o().get(r13.f);
            if (r14 == null) goto L11;
            Boolean r15 = r14.h;
            if (r15 == null) goto L11;
            boolean r16 = r15.booleanValue();
        L13:
            if (r16 == false) goto L41;
            ConcurrentHashMap<String, NativePrefetch> r17 = NativePrefetchUtil.a;
            NativePrefetchUtil.k("NativePrefetch", "use forest get config");
            final NativePrefetch r18 = this.a;
            Uri r19 = this.c;
            r18.getClass();
            if (StringsKt.startsWith$default(r19.toString(), "http", false, 2, null) == false) goto L17;
            String r20 = r19.toString();
        L21:
            if (NativePrefetch.h(r20) == true) goto L23;
            r10.onError(new Throwable("host is not safe"));
            return;
        L23:
            y.b r21 = r18.o().get(r18.f);
            if (r21 == null) goto L26;
            String r22 = r21.b;
        L27:
            y.b r23 = r18.o().get(r18.f);
            if (r23 == null) goto L30;
            r11 = r23.c;
        L30:
            String r24 = NativePrefetch.q(r20, r22, r11);
            if (r24 == null) goto L77;
            Map r25 = HybridForestLoader.a;
            Forest r26 = HybridForestLoader.e();
            if (r26 == null) goto L78;
            RequestParams r27 = new RequestParams(0);
            int r28 = NativePrefetch.j;
            if (r28 == 1) goto L39;
            if (r28 != 2) goto L40;
            r27.g = true;
            r27.i = true;
        L40:
            r26.fetchResourceAsync(r24, r27, new NativePrefetch$readConfigByForest$$inlined$also$lambda$1(r18, r10));
            return;
        L39:
            r27.g = true;
            goto L40
        L78:
            return;
        L77:
            return;
        L26:
            r22 = null;
            goto L27
        L17:
            r20 = UriProtector.getQueryParameter(r19, com.bytedance.android.ec.core.event.a.KEY_URL);
            if (r20 != null) goto L21;
            r20 = "";
            goto L21
        L41:
            ConcurrentHashMap<String, NativePrefetch> r29 = NativePrefetchUtil.a;
            NativePrefetchUtil.k("NativePrefetch", "not use forest get config");
            NativePrefetch r30 = this.a;
            Uri r31 = this.c;
            r30.getClass();
            if (StringsKt.startsWith$default(r31.toString(), "http", false, 2, null) == false) goto L44;
            String r32 = r31.toString();
        L45:
            y.b r33 = r30.o().get(r30.f);
            if (r33 == null) goto L48;
            String r34 = r33.b;
        L49:
            y.b r35 = r30.o().get(r30.f);
            if (r35 == null) goto L52;
            String r36 = r35.c;
        L53:
            String r37 = r30.f;
            if (r37 == null) goto L63;
            y.b r38 = r30.o().get(r37);
            if (r38 == null) goto L63;
            if (r38.b == null) goto L63;
            if (r38.c == null) goto L63;
        L64:
            if (r12 == false) goto L73;
            if (r34 == null) goto L73;
            if (r36 == null) goto L73;
            if (r32 == null) goto L73;
            int r39 = ECSdk.a;
            IAdapterService r40 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r40 == null) goto L73;
            pd.e r41 = r40.getIExternaHybridService();
            if (r41 == null) goto L73;
            r1 = r41.readGeckoFromChannel(r32, r34, r36);
        L73:
            if (r1 == null) goto L80;
            r10.onNext(r1);
            return;
        L80:
            return;
        L63:
            r12 = false;
            goto L64
        L52:
            r36 = null;
            goto L53
        L48:
            r34 = null;
            goto L49
        L44:
            r32 = UriProtector.getQueryParameter(r31, com.bytedance.android.ec.core.event.a.KEY_URL);
        L11:
            r16 = false;
            goto L13
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ NativePrefetch a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;

        public d(NativePrefetch r1, Uri r10, Ref.IntRef r11, String r12, JSONObject r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        public final void accept(Object r10) {
            JSONObject r1 = (JSONObject) r10;
            if (r1 == null) goto L6;
            NativePrefetch.e(this.a, r1, this.b, this.c.element, this.d, this.e);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Uri a;

        public e(Uri r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            int r0 = u.a;
            String r1 = this.a.toString();
            Integer r12 = Integer.valueOf(IServerListener.WHAT_NSD_ERROR);
            if (r11 == null) goto L5;
            String r13 = r11.getMessage();
        L6:
            u.a(r1, r12, r13, null);
            ConcurrentHashMap<String, NativePrefetch> r14 = NativePrefetchUtil.a;
            NativePrefetchUtil.k("NativePrefetch", "read native request config error " + r11);
            return;
        L5:
            r13 = null;
            goto L6
        }
    }

    public final Map<String, y.b> o() {
        return (Map) this.g.getValue();
    }

    static {
        int r0 = com.bytedance.android.ec.base.settings.c.a;
        Object r10 = null;
        Object r1 = new p(null);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L83
        Object r12 = com.bytedance.android.ec.base.settings.d.c.get("na_prefetch_security_check");     // Catch: Throwable -> L56
        if (r12 != null) goto L8;
    L53:
        Object r13 = null;
    L54:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L56
    L58:
        Throwable r15 = Result.exceptionOrNull-impl(r14);     // Catch: Throwable -> L83
        if (r15 == null) goto L62;
        EnsureManager.ensureNotReachHere(r15);     // Catch: Throwable -> L83
    L62:
        if (Result.isFailure-impl(r14) == false) goto L65;
        r14 = null;
    L65:
        if ((r14 instanceof p) == true) goto L67;
        r14 = null;
    L67:
        p r16 = (p) r14;     // Catch: Throwable -> L83
        if (r16 == null) goto L70;
        r1 = r16;
    L91:
        i = (p) r1;
        int r17 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r18 = 2;
        jj4.b r19 = jj4.b.b;     // Catch: Throwable -> L96
        Object r20 = jj4.a.a("na_prefetch_fetch_config_opt", Integer.class, r18, false);     // Catch: Throwable -> L96
        if (r20 != null) goto L102;
        Intrinsics.throwNpe();     // Catch: Throwable -> L96
    L102:
        j = ((Number) r20).intValue();
        return;
    L96:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r22) == true) goto L101;
        r18 = r22;
    L101:
        r20 = r18;
        goto L102
    L70:
        IHybridHostService r23 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L83
        if (r23 == null) goto L73;
        Object r24 = r23.getHostABValue("na_prefetch_security_check", r1);     // Catch: Throwable -> L83
    L74:
        if (r24 == null) goto L91;
        if ((r24 instanceof p) == false) goto L79;
        r10 = r24;
    L79:
        p r25 = (p) r10;     // Catch: Throwable -> L83
        if (r25 == null) goto L91;
        r1 = r25;
        goto L91
    L73:
        r24 = null;
        goto L74
    L8:
        if ((r12 instanceof p) == true) goto L10;
        Object r26 = null;
    L11:
        r13 = (p) r26;     // Catch: Throwable -> L56
        if (r13 != null) goto L54;
        if ((r12 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(p.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r27 = Float.valueOf(((Number) r12).floatValue());     // Catch: Throwable -> L56
        if ((r27 instanceof p) == true) goto L21;
        r27 = null;
    L21:
        r13 = (p) r27;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(p.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r28 = Double.valueOf(((Number) r12).doubleValue());     // Catch: Throwable -> L56
        if ((r28 instanceof p) == true) goto L27;
        r28 = null;
    L27:
        r13 = (p) r28;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(p.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r29 = Integer.valueOf(((Number) r12).intValue());     // Catch: Throwable -> L56
        if ((r29 instanceof p) == true) goto L33;
        r29 = null;
    L33:
        r13 = (p) r29;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(p.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r30 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L56
        if ((r30 instanceof p) == true) goto L39;
        r30 = null;
    L39:
        r13 = (p) r30;     // Catch: Throwable -> L56
    L41:
        if ((r12 instanceof JSONObject) == false) goto L43;
    L104:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
        Object r31 = SDKSettingsCacheManager.a().fromJson(r12.toString(), p.class);     // Catch: Throwable -> L49
        if ((r31 instanceof p) == true) goto L47;
        r31 = null;
    L47:
        Object r32 = Result.constructor-impl((p) r31);     // Catch: Throwable -> L49
    L51:
        r13 = r32;
        if (Result.isFailure-impl(r13) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L56
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r12 instanceof JSONArray) == false) goto L53;
    L10:
        r26 = r12;
    L56:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L83
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L83
    L83:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Object r36 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L88;
        EnsureManager.ensureNotReachHere(r37);
    L88:
        if (Result.isFailure-impl(r36) == true) goto L91;
        r1 = r36;
        goto L91
    }

    public NativePrefetch() {
        this.c = new LinkedHashMap();
        this.e = 60000;
        this.g = LazyKt.lazy(NativePrefetch$configs$2.INSTANCE);
    }

    public final boolean u() {
        y.b r0 = o().get(this.f);
        if (r0 == null) goto L198;
        Boolean r10 = r0.g;
        if (r10 != null) goto L7;
    L9:
        String r1 = r0.f;
        if (r1 != null) goto L12;
        return false;
    L12:
        if (r1.length() <= 0) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == false) goto L200;
        int r12 = com.bytedance.android.ec.core.opt.ab.n.a;
        Object r13 = 0;
        int r14 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L174
        Object r16 = null;
        Object r17 = com.bytedance.android.ec.base.settings.d.c.get(r1);     // Catch: Throwable -> L68
        if (r17 != null) goto L23;
    L65:
        Object r18 = null;
    L66:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L68
    L70:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L174
        if (r20 == null) goto L74;
        EnsureManager.ensureNotReachHere(r20);     // Catch: Throwable -> L174
    L74:
        if (Result.isFailure-impl(r19) == false) goto L77;
        r19 = null;
    L77:
        if ((r19 instanceof Integer) == true) goto L79;
        r19 = null;
    L79:
        Object r21 = (Integer) r19;     // Catch: Throwable -> L174
        if (r21 != null) goto L86;
        Object r22 = com.bytedance.android.ec.base.settings.d.a.get(r1);     // Catch: Throwable -> L174
        if ((r22 instanceof Integer) == true) goto L85;
        r22 = null;
    L85:
        r21 = (Integer) r22;     // Catch: Throwable -> L174
    L86:
        if (r21 != null) goto L184;
        int r23 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L174
        Object r24 = com.bytedance.android.ec.base.settings.d.c.get(r1);     // Catch: Throwable -> L138
        if (r24 != null) goto L93;
    L135:
        Object r25 = null;
    L136:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L138
    L140:
        Throwable r27 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L164
        if (r27 == null) goto L144;
        EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L164
    L144:
        if (Result.isFailure-impl(r26) == false) goto L147;
        r26 = null;
    L147:
        if ((r26 instanceof Integer) == true) goto L149;
        r26 = null;
    L149:
        r21 = (Integer) r26;     // Catch: Throwable -> L164
        if (r21 != null) goto L172;
        IHybridHostService r28 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L164
        if (r28 == null) goto L155;
        Object r29 = r28.getHostABValue(r1, r13);     // Catch: Throwable -> L164
    L156:
        if (r29 != null) goto L158;
    L163:
        r21 = r13;
        goto L172
    L158:
        if ((r29 instanceof Integer) == false) goto L161;
        r16 = r29;
    L161:
        Object r30 = (Integer) r16;     // Catch: Throwable -> L164
        if (r30 == null) goto L163;
    L171:
        r21 = r30;
        goto L172
    L155:
        r29 = null;
    L172:
        com.bytedance.android.ec.base.settings.d.d(r1, r21);     // Catch: Throwable -> L174
        goto L184
    L93:
        if ((r24 instanceof Integer) == true) goto L95;
        Object r31 = null;
    L96:
        r25 = (Integer) r31;     // Catch: Throwable -> L138
        if (r25 != null) goto L136;
        if ((r24 instanceof Number) == false) goto L123;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L108;
        Float r32 = Float.valueOf(((Number) r24).floatValue());     // Catch: Throwable -> L138
        if ((r32 instanceof Integer) == true) goto L106;
        r32 = null;
    L106:
        r25 = (Integer) r32;     // Catch: Throwable -> L138
        goto L136
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L114;
        Double r33 = Double.valueOf(((Number) r24).doubleValue());     // Catch: Throwable -> L138
        if ((r33 instanceof Integer) == true) goto L112;
        r33 = null;
    L112:
        r25 = (Integer) r33;     // Catch: Throwable -> L138
        goto L136
    L114:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L117;
        r25 = Integer.valueOf(((Number) r24).intValue());     // Catch: Throwable -> L138
        goto L136
    L117:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L123;
        Long r34 = Long.valueOf(((Number) r24).longValue());     // Catch: Throwable -> L138
        if ((r34 instanceof Integer) == true) goto L121;
        r34 = null;
    L121:
        r25 = (Integer) r34;     // Catch: Throwable -> L138
    L123:
        if ((r24 instanceof JSONObject) == false) goto L125;
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L131
        Object r35 = SDKSettingsCacheManager.a().fromJson(r24.toString(), Integer.class);     // Catch: Throwable -> L131
        if ((r35 instanceof Integer) == true) goto L129;
        r35 = null;
    L129:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L131
    L133:
        r25 = r36;
        if (Result.isFailure-impl(r25) == false) goto L136;
    L131:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L138
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L138
        goto L133
    L125:
        if ((r24 instanceof JSONArray) == false) goto L135;
    L95:
        r31 = r24;
    L164:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L174
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
        Throwable r39 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L174
        if (r39 == null) goto L169;
        EnsureManager.ensureNotReachHere(r39);     // Catch: Throwable -> L174
    L169:
        if (Result.isFailure-impl(r30) == false) goto L171;
        r30 = r13;
    L138:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L164
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L164
    L184:
        if (((Number) r21).intValue() != 1) goto L201;
        return true;
    L201:
        return false;
    L23:
        if ((r17 instanceof Integer) == true) goto L25;
        Object r41 = null;
    L26:
        r18 = (Integer) r41;     // Catch: Throwable -> L68
        if (r18 != null) goto L66;
        if ((r17 instanceof Number) == false) goto L53;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L38;
        Float r42 = Float.valueOf(((Number) r17).floatValue());     // Catch: Throwable -> L68
        if ((r42 instanceof Integer) == true) goto L36;
        r42 = null;
    L36:
        r18 = (Integer) r42;     // Catch: Throwable -> L68
        goto L66
    L38:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L44;
        Double r43 = Double.valueOf(((Number) r17).doubleValue());     // Catch: Throwable -> L68
        if ((r43 instanceof Integer) == true) goto L42;
        r43 = null;
    L42:
        r18 = (Integer) r43;     // Catch: Throwable -> L68
        goto L66
    L44:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L47;
        r18 = Integer.valueOf(((Number) r17).intValue());     // Catch: Throwable -> L68
        goto L66
    L47:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L53;
        Long r44 = Long.valueOf(((Number) r17).longValue());     // Catch: Throwable -> L68
        if ((r44 instanceof Integer) == true) goto L51;
        r44 = null;
    L51:
        r18 = (Integer) r44;     // Catch: Throwable -> L68
    L53:
        if ((r17 instanceof JSONObject) == false) goto L55;
    L187:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L61
        Object r45 = SDKSettingsCacheManager.a().fromJson(r17.toString(), Integer.class);     // Catch: Throwable -> L61
        if ((r45 instanceof Integer) == true) goto L59;
        r45 = null;
    L59:
        Object r46 = Result.constructor-impl((Integer) r45);     // Catch: Throwable -> L61
    L63:
        r18 = r46;
        if (Result.isFailure-impl(r18) == false) goto L66;
    L61:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L68
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L68
        goto L63
    L55:
        if ((r17 instanceof JSONArray) == false) goto L65;
    L25:
        r41 = r17;
    L68:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L174
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Object r50 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r51 = Result.exceptionOrNull-impl(r50);
        if (r51 == null) goto L179;
        EnsureManager.ensureNotReachHere(r51);
    L179:
        if (Result.isFailure-impl(r50) == true) goto L182;
        r13 = r50;
    L182:
        r21 = r13;
        goto L184
    L200:
        return false;
    L14:
        r11 = false;
        goto L15
    L7:
        if (r10.booleanValue() == false) goto L9;
        return true;
    L198:
        return false;
    }

    public void y() {
        this.d = Long.valueOf(System.currentTimeMillis());
    }

    public static boolean g(Uri r10) {
        p r0 = i;
        List<String> r1 = r0.b();
        if (r1 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        return true;
    L11:
        String r12 = r10.getHost();
        if (r12 != null) goto L14;
    L17:
        boolean r13 = true;
    L18:
        if (r13 == false) goto L26;
        u.c(r10);
        Integer r14 = r0.a();
        if (r14 != null) goto L23;
        return false;
    L23:
        if (r14.intValue() != 1) goto L42;
        return true;
    L42:
        return false;
    L26:
        Iterator<T> r15 = r0.b().iterator();
    L28:
        if (r15.hasNext() == false) goto L32;
        if (StringsKt.endsWith$default(r12, (String) r15.next(), false, 2, null) == false) goto L28;
        return true;
    L32:
        u.c(r10);
        Integer r16 = i.a();
        if (r16 != null) goto L36;
        return false;
    L36:
        if (r16.intValue() != 1) goto L44;
        return true;
    L44:
        return false;
    L14:
        if (r12.length() == 0) goto L17;
        r13 = false;
        goto L18
    L5:
        if (r1.isEmpty() == true) goto L8;
        r11 = false;
        goto L9
    }

    public static boolean h(String r10) {
        List<String> r0 = i.b();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        return true;
    L16:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        return g(UriProtector.parse(r10));
    L13:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return true;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static JsonObject v(Map r10) {
        JsonObject r0 = new JsonObject();
        if (r10 == null) goto L10;
        Set r1 = r10.keySet();
        if (r1 == null) goto L10;
        Iterator r11 = r1.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        String r12 = (String) r11.next();
        r0.addProperty(r12, (String) r10.get(r12));
    L10:
        return r0;
    }

    public synchronized void i(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L6
        this.c.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized JSONObject p(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "apiKey");     // Catch: Throwable -> L15
        JSONObject r1 = null;
        if (this.c.containsKey(r10) == false) goto L13;
        a r0 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Throwable -> L15
        if (r0 == null) goto L8;
        o r11 = r0.b;     // Catch: Throwable -> L15
    L9:
        if (r11 == null) goto L13;
        if (r11.b != 1) goto L13;
        r1 = H(r10, r11);     // Catch: Throwable -> L15
        goto L13
    L8:
        r11 = null;
    L13:
        monitor-exit(this);
        return r1;
    L15:
        th = move-exception;
        throw th;
    }

    public final q r(String r10) {
        a r11 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r11 == null) goto L6;
        q r12 = r11.c;
        if (r12 == null) goto L6;
    L7:
        r12.g(this.d);
        r12.h(this.d);
        return r12;
    L6:
        r12 = new q(0);
        goto L7
    }

    public void t(String r10) {
        Intrinsics.checkNotNullParameter(r10, "apiKey");
        this.c.put(r10, new a(0));
    }

    public void w(String r10) {
        Intrinsics.checkNotNullParameter(r10, "apiKey");
        q r0 = r(r10);
        r0.f(Long.valueOf(System.currentTimeMillis()));
        a r11 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r11 == null) goto L6;
        r11.c = r0;
        return;
    }

    public void x(String r10) {
        Intrinsics.checkNotNullParameter(r10, "apiKey");
        q r0 = r(r10);
        r0.i(Long.valueOf(System.currentTimeMillis()));
        a r11 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r11 == null) goto L6;
        r11.c = r0;
        return;
    }

    public final JSONObject z(y.c r10) {
        if (r10 == null) goto L8;
        String r11 = r10.d();
        if (r11 == null) goto L8;
        String r12 = a2.c(r11);
        if (r12 == null) goto L8;
    L14:
        if (r12 != null) goto L16;
        return null;
    L16:
        Map r1 = HybridForestLoader.a;
        Forest r13 = HybridForestLoader.e();
        if (r13 == null) goto L230;
        GeckoConfig r14 = r13.getConfig().h;
        if (r14 == null) goto L230;
        String r15 = r14.b;
        if (r15 == null) goto L230;
        String r16 = a2.c(r15);
        if (r16 == null) goto L230;
        y.b r17 = o().get(this.f);
        if (r17 == null) goto L230;
        String r18 = r17.b;
        if (r18 == null) goto L230;
        String r19 = a2.c(r18);
        if (r19 == null) goto L230;
        GeckoConfig r20 = r13.getConfig().h;
        if (r20 == null) goto L230;
        String r21 = r20.c;
        if (r21 == null) goto L230;
        String r22 = a2.c(r21);
        if (r22 == null) goto L230;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L227
        File r24 = new PolarisFileWrapper(r22);     // Catch: Throwable -> L227
        if (r24.exists() == true) goto L42;
    L44:
        boolean r25 = false;
    L45:
        if (r25 == true) goto L48;
        r24 = null;
    L48:
        if (r24 != null) goto L51;
        return null;
    L51:
        if (ResLoadUtils.checkExist(r24, r16, r19) == true) goto L225;
        int r26 = com.bytedance.android.ec.core.opt.ab.n.a;     // Catch: Throwable -> L227
        Object r27 = new y.d(0);     // Catch: Throwable -> L227
        int r28 = com.bytedance.android.ec.base.settings.a.a;     // Catch: Throwable -> L227
        Object r29 = com.bytedance.android.ec.base.settings.d.c.get(r12);     // Catch: Throwable -> L105
        if (r29 != null) goto L57;
    L102:
        Object r30 = null;
    L103:
        Object r31 = Result.constructor-impl(r30);     // Catch: Throwable -> L105
    L107:
        Throwable r32 = Result.exceptionOrNull-impl(r31);     // Catch: Throwable -> L212
        if (r32 == null) goto L111;
        EnsureManager.ensureNotReachHere(r32);     // Catch: Throwable -> L212
    L111:
        if (Result.isFailure-impl(r31) == false) goto L114;
        r31 = null;
    L114:
        if ((r31 instanceof y.d) == true) goto L116;
        r31 = null;
    L116:
        Object r33 = (y.d) r31;     // Catch: Throwable -> L212
        if (r33 != null) goto L123;
        Object r34 = com.bytedance.android.ec.base.settings.d.a.get(r12);     // Catch: Throwable -> L212
        if ((r34 instanceof y.d) == true) goto L122;
        r34 = null;
    L122:
        r33 = (y.d) r34;     // Catch: Throwable -> L212
    L123:
        if (r33 != null) goto L221;
        int r35 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L212
        Object r36 = com.bytedance.android.ec.base.settings.d.c.get(r12);     // Catch: Throwable -> L178
        if (r36 != null) goto L130;
    L175:
        Object r37 = null;
    L176:
        Object r38 = Result.constructor-impl(r37);     // Catch: Throwable -> L178
    L180:
        Throwable r39 = Result.exceptionOrNull-impl(r38);     // Catch: Throwable -> L203
        if (r39 == null) goto L184;
        EnsureManager.ensureNotReachHere(r39);     // Catch: Throwable -> L203
    L184:
        if (Result.isFailure-impl(r38) == false) goto L187;
        r38 = null;
    L187:
        if ((r38 instanceof y.d) == true) goto L189;
        r38 = null;
    L189:
        r33 = (y.d) r38;     // Catch: Throwable -> L203
        if (r33 != null) goto L210;
        IHybridHostService r40 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L203
        if (r40 == null) goto L195;
        Object r41 = r40.getHostABValue(r12, r27);     // Catch: Throwable -> L203
    L196:
        if (r41 != null) goto L198;
    L209:
        r33 = r27;
        goto L210
    L198:
        if ((r41 instanceof y.d) == true) goto L200;
        r41 = null;
    L200:
        r33 = (y.d) r41;     // Catch: Throwable -> L203
        if (r33 != null) goto L210;
    L203:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L212
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L212
        Throwable r43 = Result.exceptionOrNull-impl(r33);     // Catch: Throwable -> L212
        if (r43 == null) goto L208;
        EnsureManager.ensureNotReachHere(r43);     // Catch: Throwable -> L212
    L208:
        if (Result.isFailure-impl(r33) == false) goto L210;
    L195:
        r41 = null;
    L210:
        com.bytedance.android.ec.base.settings.d.d(r12, r33);     // Catch: Throwable -> L212
    L130:
        if ((r36 instanceof y.d) == true) goto L132;
        Object r44 = null;
    L133:
        r37 = (y.d) r44;     // Catch: Throwable -> L178
        if (r37 != null) goto L176;
        if ((r36 instanceof Number) == false) goto L163;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L145;
        Float r45 = Float.valueOf(((Number) r36).floatValue());     // Catch: Throwable -> L178
        if ((r45 instanceof y.d) == true) goto L143;
        r45 = null;
    L143:
        r37 = (y.d) r45;     // Catch: Throwable -> L178
        goto L176
    L145:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L151;
        Double r46 = Double.valueOf(((Number) r36).doubleValue());     // Catch: Throwable -> L178
        if ((r46 instanceof y.d) == true) goto L149;
        r46 = null;
    L149:
        r37 = (y.d) r46;     // Catch: Throwable -> L178
        goto L176
    L151:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L157;
        Integer r47 = Integer.valueOf(((Number) r36).intValue());     // Catch: Throwable -> L178
        if ((r47 instanceof y.d) == true) goto L155;
        r47 = null;
    L155:
        r37 = (y.d) r47;     // Catch: Throwable -> L178
        goto L176
    L157:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L163;
        Long r48 = Long.valueOf(((Number) r36).longValue());     // Catch: Throwable -> L178
        if ((r48 instanceof y.d) == true) goto L161;
        r48 = null;
    L161:
        r37 = (y.d) r48;     // Catch: Throwable -> L178
    L163:
        if ((r36 instanceof JSONObject) == false) goto L165;
    L231:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        Object r49 = SDKSettingsCacheManager.a().fromJson(r36.toString(), y.d.class);     // Catch: Throwable -> L171
        if ((r49 instanceof y.d) == true) goto L169;
        r49 = null;
    L169:
        Object r50 = Result.constructor-impl((y.d) r49);     // Catch: Throwable -> L171
    L173:
        r37 = r50;
        if (Result.isFailure-impl(r37) == false) goto L176;
    L171:
        th = move-exception;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L178
        r50 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
        goto L173
    L165:
        if ((r36 instanceof JSONArray) == false) goto L175;
    L132:
        r44 = r36;
    L178:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L203
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L203
    L221:
        JsonObject r53 = ((y.d) r33).a();     // Catch: Throwable -> L227
        if (r53 != null) goto L224;
        return null;
    L224:
        return com.bytedance.android.ec.hybrid.list.util.k.b(r53);
    L57:
        if ((r29 instanceof y.d) == true) goto L59;
        Object r54 = null;
    L60:
        r30 = (y.d) r54;     // Catch: Throwable -> L105
        if (r30 != null) goto L103;
        if ((r29 instanceof Number) == false) goto L90;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L72;
        Float r55 = Float.valueOf(((Number) r29).floatValue());     // Catch: Throwable -> L105
        if ((r55 instanceof y.d) == true) goto L70;
        r55 = null;
    L70:
        r30 = (y.d) r55;     // Catch: Throwable -> L105
        goto L103
    L72:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L78;
        Double r56 = Double.valueOf(((Number) r29).doubleValue());     // Catch: Throwable -> L105
        if ((r56 instanceof y.d) == true) goto L76;
        r56 = null;
    L76:
        r30 = (y.d) r56;     // Catch: Throwable -> L105
        goto L103
    L78:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L84;
        Integer r57 = Integer.valueOf(((Number) r29).intValue());     // Catch: Throwable -> L105
        if ((r57 instanceof y.d) == true) goto L82;
        r57 = null;
    L82:
        r30 = (y.d) r57;     // Catch: Throwable -> L105
        goto L103
    L84:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(y.d.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L90;
        Long r58 = Long.valueOf(((Number) r29).longValue());     // Catch: Throwable -> L105
        if ((r58 instanceof y.d) == true) goto L88;
        r58 = null;
    L88:
        r30 = (y.d) r58;     // Catch: Throwable -> L105
    L90:
        if ((r29 instanceof JSONObject) == false) goto L92;
    L239:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L98
        Object r59 = SDKSettingsCacheManager.a().fromJson(r29.toString(), y.d.class);     // Catch: Throwable -> L98
        if ((r59 instanceof y.d) == true) goto L96;
        r59 = null;
    L96:
        Object r60 = Result.constructor-impl((y.d) r59);     // Catch: Throwable -> L98
    L100:
        r30 = r60;
        if (Result.isFailure-impl(r30) == false) goto L103;
    L98:
        th = move-exception;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L105
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L105
        goto L100
    L92:
        if ((r29 instanceof JSONArray) == false) goto L102;
    L59:
        r54 = r29;
    L105:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L212
        r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L212
    L212:
        th = move-exception;
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L227
        Object r64 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L227
        Throwable r65 = Result.exceptionOrNull-impl(r64);     // Catch: Throwable -> L227
        if (r65 == null) goto L217;
        EnsureManager.ensureNotReachHere(r65);     // Catch: Throwable -> L227
    L217:
        if (Result.isFailure-impl(r64) == true) goto L220;
        r27 = r64;
    L220:
        r33 = r27;
        goto L221
    L225:
        Object r66 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L227
    L229:
        Result.box-impl(r66);
        goto L230
    L42:
        if (r24.isDirectory() == false) goto L44;
        r25 = true;
    L227:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r66 = Result.constructor-impl(ResultKt.createFailure(th));
    L230:
        return null;
    L8:
        y.b r68 = o().get(this.f);
        if (r68 == null) goto L13;
        String r69 = r68.l;
        if (r69 == null) goto L13;
        r12 = a2.c(r69);
    L13:
        r12 = null;
        goto L14
    }

    public static final boolean a(NativePrefetch r10, Response r11) {
        r10.getClass();
        String r12 = r11.q.getUrl();
        ResourceFrom r0 = r11.w;
        ResourceFrom r1 = ResourceFrom.CDN;
        if (r0 == r1) goto L7;
        if (r11.u == r1) goto L7;
    L11:
        r12 = null;
    L13:
        if (r12 != null) goto L15;
    L18:
        boolean r13 = true;
    L19:
        if (r13 == false) goto L21;
    L23:
        return true;
    L21:
        if (h(r12) == true) goto L23;
        return false;
    L15:
        if (r12.length() == 0) goto L18;
        r13 = false;
    L7:
        if (StringsKt.startsWith$default(r12, "http://", false, 2, null) == true) goto L13;
        if (StringsKt.startsWith$default(r12, "https://", false, 2, null) == false) goto L11;
        goto L11
    }

    public static JSONObject n(t r10, Integer r11) {
        JSONObject r0 = new JSONObject();
        r0.putOpt("match_res", r11);
        r0.putOpt("api_key", r10.i);
        r0.putOpt("api_url", r10.a);
        r0.putOpt("method", r10.b);
        r0.putOpt("headers", r10.c);
        r0.putOpt("params", r10.d);
        r0.putOpt("data", r10.e);
        return r0;
    }

    public synchronized void A(String r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L20
        if (r10 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Map<String, a> r0 = this.c;     // Catch: Throwable -> L20
        ConcurrentHashMap<String, NativePrefetch> r1 = NativePrefetchUtil.a;     // Catch: Throwable -> L20
        if (StringsKt.isBlank(r10) == false) goto L10;
        boolean r12 = true;
    L11:
        a r13 = null;
        if (r12 == false) goto L14;
        NativePrefetch r14 = null;
    L15:
        if (r14 == null) goto L17;
        r13 = (a) ((LinkedHashMap) r14.c).get(r11);     // Catch: Throwable -> L20
    L17:
        r0.put(r11, r13);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L14:
        r14 = NativePrefetchUtil.a.get(r10);     // Catch: Throwable -> L20
        goto L15
    L10:
        r12 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public void B(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "apiKey");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        a r1 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        a r12 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Throwable -> L13
        if (r12 == null) goto L9;
        JSONObject r13 = r12.d;     // Catch: Throwable -> L13
        if (r13 == null) goto L9;
    L10:
        r13.putOpt("na_prefetch_config_from", Integer.valueOf(r11));     // Catch: Throwable -> L13
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r1.d = r13;     // Catch: Throwable -> L13
    L9:
        r13 = new JSONObject();     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public void C(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "apiKey");
        q r0 = r(r10);
        r0.a = r11;
        a r12 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r12 == null) goto L6;
        r12.c = r0;
        return;
    }

    public synchronized void D(o r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "data");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r11, "apiKey");     // Catch: Throwable -> L25
        if (this.c.containsKey(r11) == false) goto L23;
        a r0 = (a) ((LinkedHashMap) this.c).get(r11);     // Catch: Throwable -> L25
        if (r0 == null) goto L8;
        ECBaseBridgeMethod.a r1 = r0.a;     // Catch: Throwable -> L25
    L9:
        if (r1 != null) goto L13;
        a r12 = (a) ((LinkedHashMap) this.c).get(r11);     // Catch: Throwable -> L25
        if (r12 == null) goto L23;
        r12.b = r10;     // Catch: Throwable -> L25
        goto L23
    L13:
        int r13 = r10.b;     // Catch: Throwable -> L25
        if (r13 != 1) goto L16;
        G(r11, r10, r1);     // Catch: Throwable -> L25
    L20:
        a r14 = (a) ((LinkedHashMap) this.c).get(r11);     // Catch: Throwable -> L25
        if (r14 == null) goto L23;
        r14.a = null;     // Catch: Throwable -> L25
        goto L23
    L16:
        if (r13 != 2) goto L20;
        l(r11, r13, r1, "");     // Catch: Throwable -> L25
        goto L20
    L8:
        r1 = null;
    L23:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public void E(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "apiKey");
        if (r11 != null) goto L22;
        return;
    L22:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        a r1 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Throwable -> L19
        if (r1 == null) goto L17;
        a r12 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Throwable -> L19
        if (r12 == null) goto L11;
        JSONObject r13 = r12.d;     // Catch: Throwable -> L19
        if (r13 == null) goto L11;
    L12:
        Iterator<String> r14 = r11.keys();     // Catch: Throwable -> L19
    L14:
        if (r14.hasNext() == false) goto L16;
        String r15 = r14.next();     // Catch: Throwable -> L19
        r13.putOpt(r15, r11.opt(r15));     // Catch: Throwable -> L19
        goto L14
    L16:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r1.d = r13;     // Catch: Throwable -> L19
    L11:
        r13 = new JSONObject();     // Catch: Throwable -> L19
    L17:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final JSONObject H(String r10, o r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L14
        r1.putOpt("raw", new JSONObject(r11.a));     // Catch: Throwable -> L14
        a r12 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Throwable -> L14
        if (r12 == null) goto L7;
        q r13 = r12.c;     // Catch: Throwable -> L14
        if (r13 == null) goto L7;
        r1.putOpt("perf_timing", r13.a());     // Catch: Throwable -> L14
        r1.putOpt("net_detail", r13.a);     // Catch: Throwable -> L14
    L7:
        a r14 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Throwable -> L14
        if (r14 == null) goto L12;
        JSONObject r15 = r14.d;     // Catch: Throwable -> L14
        if (r15 == null) goto L12;
        r1.putOpt("extra_info", r15);     // Catch: Throwable -> L14
    L12:
        Object r16 = Result.constructor-impl(r1);     // Catch: Throwable -> L14
    L16:
        JSONObject r17 = new JSONObject();
        if (Result.isFailure-impl(r16) == false) goto L20;
        r16 = r17;
    L20:
        return (JSONObject) r16;
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static String q(String r13, String r14, String r15) {
        if (r14 == null) goto L22;
        if (r15 == null) goto L22;
        if (r13 == null) goto L22;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L20
        Uri r11 = UriProtector.parse(r13);     // Catch: Throwable -> L20
        List<String> r12 = r11.getPathSegments();     // Catch: Throwable -> L20
        if (r12 == null) goto L18;
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L20
        int r17 = r12.size();     // Catch: Throwable -> L20
    L10:
        r17 = r17 - 1;     // Catch: Throwable -> L20
        if (r17 < 0) goto L16;
        if (Intrinsics.areEqual((String) ListProtector.get(r12, r17), r14) == true) goto L16;
        r16.add(ListProtector.get(r12, r17));     // Catch: Throwable -> L20
    L16:
        CollectionsKt.reverse(r16);     // Catch: Throwable -> L20
        return StringsKt.replace$default(r11.buildUpon().clearQuery().build().toString(), CollectionsKt.joinToString$default(r16, "/", null, null, 0, null, null, 62, null), r15, false, 4, null);
    L18:
        Result.constructor-impl(null);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        return null;
    }

    public final void F(Uri r10, String r11, JSONObject r12) {
        y();
        Ref.IntRef r13 = new Ref.IntRef();
        r13.element = 0;
        Observable r0 = Observable.create(new c(this, r13, r10));
        if (this.h == true) goto L6;
        r0 = r0.subscribeOn(Schedulers.io());
    L6:
        r0.subscribe(new d(this, r10, r13, r11, r12), new e(r10));
    }

    public final void G(String r10, o r11, ECBaseBridgeMethod.a r12) {
        a r0 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Exception -> L11
        if (r0 == null) goto L7;
        q r1 = r0.c;     // Catch: Exception -> L11
        if (r1 == null) goto L7;
        r1.d(Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L11
    L7:
        JSONObject r13 = H(r10, r11);     // Catch: Exception -> L11
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L11
        r14.putOpt("code", 1);     // Catch: Exception -> L11
        r14.putOpt("data", r13);     // Catch: Exception -> L11
        r14.putOpt(com.bytedance.android.ec.core.event.a.KEY_STATUS, Integer.valueOf(r11.b));     // Catch: Exception -> L11
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L11
        r12.a(r14);     // Catch: Exception -> L11
        a r16 = (a) ((LinkedHashMap) this.c).get(r10);     // Catch: Exception -> L11
        if (r16 == null) goto L15;
        r16.c = null;     // Catch: Exception -> L11
        return;
    L15:
        return;
    L11:
        l(r10, 2, r12, "");
    }

    public final <T> T k(String r10, Class<T> r11, Converter.Factory r12) {
        long r0 = System.currentTimeMillis();
        T r13 = (T) com.bytedance.android.ec.sdk.helper.n.a.create(r10, r11, r12, null);
        com.bytedance.android.ec.sdk.helper.g r14 = com.bytedance.android.ec.sdk.helper.g.a;
        JSONObject r15 = new JSONObject();
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L5
        r15.putOpt("page_path", this.f);     // Catch: Throwable -> L5
        r15.putOpt(com.bytedance.android.ec.core.event.a.KEY_URL, r10);     // Catch: Throwable -> L5
        r15.putOpt("na_prefetch_create_retrofit_start", Long.valueOf(r0));     // Catch: Throwable -> L5
        Result.constructor-impl(r15.putOpt("na_prefetch_create_retrofit_end", Long.valueOf(System.currentTimeMillis())));     // Catch: Throwable -> L5
    L7:
        Unit r17 = Unit.INSTANCE;
        r14.logV3("na_prefetch_create_retrofit", r15);
        return r13;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object m(String r10, Channel r11, ContinuationImpl r12) {
        if (h(r10) == true) goto L9;
        Object r13 = r11.send(null, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r13;
    L8:
        return Unit.INSTANCE;
    L9:
        Map r14 = HybridForestLoader.a;
        Forest r15 = HybridForestLoader.e();
        if (r15 == null) goto L20;
        RequestParams r0 = new RequestParams(0);
        int r1 = j;
        if (r1 != 1) goto L14;
        r0.g = true;
    L18:
        r15.fetchResourceAsync(r10, r0, new NativePrefetch$fetchGecko$2(this, r11, r10));
        goto L20
    L14:
        if (r1 != 2) goto L18;
        r0.g = true;
        r0.i = true;
    L20:
        return Unit.INSTANCE;
    }

    public static final void b(final NativePrefetch r10, final Object r11, final t r12, final String r13) {
        r10.getClass();
        if ((r11 instanceof String) == false) goto L6;
        b2.b(new NativePrefetch$handleResponse$1(r10, r11, r12, r13));
        r10.D(new o((String) r11, 1, null), r13);
        return;
    L6:
        if ((r11 instanceof NativePrefetchResponse) == false) goto L11;
        NativePrefetchResponse r14 = (NativePrefetchResponse) r11;
        r10.C(r13, r14.getEcNetReportJSON());
        final String r15 = r14.getData();
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        b2.b(new NativePrefetch$handleResponse$2(r10, r15, r12, r13));
        r10.D(new o(r15, 1, null), r13);
        return;
    L11:
        ECExceptionMonitor.c("invalid resp of na-prefetch");
    }

    public static final void c(NativePrefetch r22, String r23, com.bytedance.android.ec.core.hybrid.prefetch.e r24, String r25) {
        r22.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L60
        if (r24 == null) goto L80;
        List<com.bytedance.android.ec.core.hybrid.prefetch.a> r1 = r24.a();     // Catch: Throwable -> L60
        if (r1 == null) goto L81;
        int r10 = 1;
        if ((!r1.isEmpty()) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L82;
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L60
        JSONObject r12 = new JSONObject(r23);     // Catch: Throwable -> L60
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L60
        Iterator<T> r14 = r1.iterator();     // Catch: Throwable -> L60
    L15:
        if (r14.hasNext() == false) goto L53;
        com.bytedance.android.ec.core.hybrid.prefetch.a r15 = (com.bytedance.android.ec.core.hybrid.prefetch.a) r14.next();     // Catch: Throwable -> L60
        String r16 = r15.b();     // Catch: Throwable -> L60
        if (r16 == null) goto L52;
        char[] r17 = new char[r10];     // Catch: Throwable -> L60
        r17[0] = '.';     // Catch: Throwable -> L60
        List r18 = StringsKt.split$default(r16, r17, false, 0, 6, null);     // Catch: Throwable -> L60
        if (r18 == null) goto L52;
        if (((r18.isEmpty() ? 1 : 0) ^ r10) != 0) goto L24;
        r18 = null;
    L24:
        if (r18 == null) goto L52;
        int r19 = r18.size() - r10;     // Catch: Throwable -> L60
        int r110 = 0;
    L27:
        if (r110 >= r19) goto L35;
        String r111 = (String) CollectionsKt.getOrNull(r18, r110);     // Catch: Throwable -> L60
        if (r111 == null) goto L52;
        JSONObject r112 = r12.optJSONObject(r111);     // Catch: Throwable -> L60
        if (r112 == null) goto L52;
        r110 = r110 + 1;     // Catch: Throwable -> L60
        r12 = r112;
        goto L27
    L35:
        JSONArray r113 = r12.optJSONArray((String) CollectionsKt.last(r18));     // Catch: Throwable -> L60
        if (r113 == null) goto L52;
        int r114 = r113.length();     // Catch: Throwable -> L60
        int r115 = 0;
    L39:
        if (r115 >= r114) goto L52;
        String r116 = r113.optString(r115);     // Catch: Throwable -> L60
        if (r116 == null) goto L51;
        String r117 = r15.a();     // Catch: Throwable -> L60
        if (r117 != null) goto L46;
        r117 = "";
    L46:
        String r118 = r15.c();     // Catch: Throwable -> L60
        if (r118 != null) goto L49;
        String r20 = "";
    L50:
        ImageExtensionsKt.B(r116, new com.bytedance.android.ec.core.imagex.r(r117, r20), null, null, null, null, null, false, 192);     // Catch: Throwable -> L60
        goto L51
    L49:
        r20 = r118;
    L51:
        r115 = r115 + 1;     // Catch: Throwable -> L60
    L52:
        r10 = 1;
        goto L15
    L53:
        long r21 = System.currentTimeMillis();     // Catch: Throwable -> L60
        com.bytedance.android.ec.sdk.helper.g r26 = com.bytedance.android.ec.sdk.helper.g.a;     // Catch: Throwable -> L60
        JSONObject r27 = new JSONObject();     // Catch: Throwable -> L60
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L56
        r27.putOpt("page_path", r22.f);     // Catch: Throwable -> L56
        r27.putOpt("api_key", r25);     // Catch: Throwable -> L56
        r27.putOpt("na_prefetch_api_img_start", Long.valueOf(r11));     // Catch: Throwable -> L56
        r27.putOpt("na_prefetch_api_img_parsed", Long.valueOf(r13));     // Catch: Throwable -> L56
        r27.putOpt("na_prefetch_api_img_end", Long.valueOf(r21));     // Catch: Throwable -> L56
        Result.constructor-impl(r27.putOpt("resp_size", Integer.valueOf(r23.length())));     // Catch: Throwable -> L56
    L58:
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L60
        r26.logV3("na_prefetch_api_img_timing", r27);     // Catch: Throwable -> L60
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
        return;
    L56:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L60
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L58
    L82:
        return;
    L81:
        return;
    L80:
        return;
    L60:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final Object d(NativePrefetch r10, Uri r11, Channel r12, Continuation r13) {
        r10.getClass();
        if ((r13 instanceof NativePrefetch$readDefaultConfig$1) == false) goto L7;
        NativePrefetch$readDefaultConfig$1 r0 = (NativePrefetch$readDefaultConfig$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L33:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        String r18 = null;
        if (StringsKt.startsWith$default(r11.toString(), "http", false, 2, null) == false) goto L17;
        String r19 = r11.toString();
    L20:
        y.b r110 = r10.o().get(r10.f);
        if (r110 == null) goto L23;
        String r111 = r110.b;
    L24:
        y.b r20 = r10.o().get(r10.f);
        if (r20 == null) goto L27;
        r18 = r20.c;
    L27:
        String r21 = q(r19, r111, r18);
        if (r21 == null) goto L33;
        r0.L$0 = r21;
        r0.label = 1;
        if (r10.m(r21, r12, r0) != r15) goto L33;
        return r15;
    L23:
        r111 = null;
        goto L24
    L17:
        r19 = UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r19 != null) goto L20;
        r19 = "";
    L7:
        r0 = new NativePrefetch$readDefaultConfig$1(r10, r13);
        goto L8
    }

    public final void f(t r10, Uri r11, String r12, JSONObject r13) {
        String r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, NativePrefetch> r1 = NativePrefetchUtil.a;
        NativeRequestCache r14 = new NativeRequestCache(r10, r12, r13);
        Intrinsics.checkNotNullParameter(r0, "path");
        Intrinsics.checkNotNullParameter(r14, "cache");
        ConcurrentHashMap<String, CopyOnWriteArrayList<NativeRequestCache>> r15 = NativePrefetchUtil.b;
        CopyOnWriteArrayList<NativeRequestCache> r16 = r15.get(r0);
        if (r16 != null) goto L8;
    L11:
        boolean r17 = true;
    L12:
        if (r17 == false) goto L14;
        r15.put(r0, new CopyOnWriteArrayList(CollectionsKt.listOf(r14)));
    L17:
        dm.a.a("NativePrefetch").i("addRequestPool apiKey: " + r10.i + ",enter_from:" + UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM) + ",path:" + r0);
        return;
    L14:
        CopyOnWriteArrayList<NativeRequestCache> r18 = r15.get(r0);
        if (r18 == null) goto L17;
        r18.add(r14);
        goto L17
    L8:
        if (r16.isEmpty() == true) goto L11;
        r17 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Iterable, java.lang.Object, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch] */
    /* JADX WARN: Type inference failed for: r36v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v100 */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v98 */
    /* JADX WARN: Type inference failed for: r6v99 */
    public final boolean j(t r33, Uri r34, String r35, JSONObject r36) {
        String r10 = "monitor_info";
        String r11 = "na_prefetch_strategy";
        String r12 = "matching_result_detail";
        String r13 = "matching_result";
        String r14 = this.f;
        if (r14 != null) goto L5;
        return false;
    L5:
        ?? r15 = (CopyOnWriteArrayList) NativePrefetchUtil.b.get(r14);
        dm.a.b r16 = dm.a.a("NativePrefetch");
        StringBuilder r17 = new StringBuilder("compareRequestConfig apiKey: ");
        r17.append(r35);
        r17.append(",enter_from:");
        r17.append(UriProtector.getQueryParameter(r34, com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM));
        r17.append(",list size：");
        if (r15 == 0) goto L8;
        Integer r18 = Integer.valueOf(r15.size());
    L9:
        r17.append(r18);
        r17.append(",path:");
        r17.append(r14);
        r16.i(r17.toString());
        ArrayList r19 = new ArrayList();
        ArrayList r110 = new ArrayList();
        if (r15 == 0) goto L184;
        Iterator r111 = r15.iterator();
        boolean r112 = false;
        String r20 = r10;
    L12:
        String r26 = r20;
        if (r111.hasNext() == false) goto L97;
        NativeRequestCache r21 = (NativeRequestCache) r111.next();
        r21.getClass();
        String r27 = r11;
        String r28 = r12;
        if (System.currentTimeMillis() <= r21.b) goto L17;
        boolean r22 = true;
    L18:
        if (r22 == false) goto L20;
        t r23 = r21.e;
        NativeRequestMatchState r24 = NativeRequestMatchState.REQUEST_MATCH_EXPIRED;
        r110.add(n(r23, Integer.valueOf(r24.getValue())));
        r19.add(Integer.valueOf(r24.getValue()));
        String r29 = r13;
        Iterator r113 = r111;
    L96:
        r111 = r113;
        r20 = r26;
        r11 = r27;
        r12 = r28;
        r13 = r29;
        goto L12
    L20:
        t r25 = r21.e;
        if (r25 == null) goto L23;
        String r30 = r25.i;
    L25:
        if ((!Intrinsics.areEqual(r30, r33.i)) == false) goto L31;
        dm.a.b r31 = dm.a.a;
        dm.a.b r32 = dm.a.a(r21.d);
        r113 = r111;
        r29 = r13;
        StringBuilder r114 = new StringBuilder("apiKey not match,storeApiKey :");
        t r37 = r21.e;
        if (r37 == null) goto L29;
        String r38 = r37.i;
    L30:
        r114.append(r38);
        r114.append(",infoMap:");
        r114.append(r33.i);
        r32.i(r114.toString());
        Pair r39 = new Pair(Boolean.FALSE, Integer.valueOf(NativeRequestMatchState.REQUEST_MATCH_APIKEY_FAILED.getValue()));
    L88:
        if (((Boolean) r39.getFirst()).booleanValue() == true) goto L90;
        r110.add(n(r21.e, (Integer) r39.getSecond()));
    L90:
        r19.add(r39.getSecond());
        if (((Boolean) r39.getFirst()).booleanValue() == false) goto L96;
        r112 = !r21.c.getAndSet(true);
        if (r112 == true) goto L94;
        ListProtector.remove(r19, CollectionsKt.getLastIndex(r19));
        goto L96
    L94:
        String r40 = r21.f;
        JSONObject r41 = r21.g;
        boolean r42 = r112;
    L98:
        if (r42 == true) goto L100;
        JSONObject r0 = n(r33, null);
    L101:
        ConcurrentHashMap<String, NativePrefetch> r115 = NativePrefetchUtil.a;
        Intrinsics.checkNotNullParameter(r14, "path");
        Intrinsics.checkNotNullParameter(r15, "cache");
        ArrayList r43 = new ArrayList();
        Iterator r44 = r15.iterator();
    L103:
        if (r44.hasNext() == false) goto L117;
        Object r116 = r44.next();
        Iterator r310 = r44;
        NativeRequestCache r45 = (NativeRequestCache) r116;
        r45.getClass();
        JSONObject r311 = r41;
        String r312 = r40;
        if (System.currentTimeMillis() <= r45.b) goto L107;
        boolean r46 = true;
    L108:
        if (r46 == false) goto L110;
    L113:
        boolean r47 = true;
    L114:
        if (r47 == false) goto L116;
        r43.add(r116);
    L116:
        r44 = r310;
        r41 = r311;
        r40 = r312;
        goto L103
    L110:
        if (r45.c.get() == true) goto L113;
        r47 = false;
        goto L114
    L107:
        r46 = false;
        goto L108
    L117:
        JSONObject r313 = r41;
        String r314 = r40;
        r15.removeAll(r43);
        dm.a.a("NativePrefetch").i("compareRequestConfig apiKey: " + r35 + ",enter_from:" + UriProtector.getQueryParameter(r34, com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM) + ",matchArray:" + CollectionsKt.joinToString$default(r19, "|", null, null, 0, null, null, 62, null));
        int r1 = com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r42));
        ?? r48 = new JSONObject();
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L160
        String r50 = r29;
        r48.putOpt(r50, Integer.valueOf(r1));     // Catch: Throwable -> L158
        r48.putOpt("target_url", r34.toString());     // Catch: Throwable -> L158
        r48.putOpt("api_key", r35);     // Catch: Throwable -> L158
        String r51 = r28;
        r48.putOpt(r51, CollectionsKt.joinToString$default(r19, "|", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L156
        ConcurrentHashMap<String, NativePrefetch> r52 = NativePrefetchUtil.a;     // Catch: Throwable -> L156
        ?? r53 = Integer.valueOf(NativePrefetchUtil.c(r34));     // Catch: Throwable -> L156
        String r117 = r27;
        r48.putOpt(r117, r53);     // Catch: Throwable -> L153
        if (r1 <= 0) goto L137;
        if (r313 == null) goto L136;
        r53 = r26;
        r15 = r313;
        JSONObject r118 = r15.optJSONObject(r53);     // Catch: Throwable -> L134
        if (r118 == null) goto L145;
        Iterator<String> r119 = r118.keys();     // Catch: Throwable -> L134
    L132:
        if (r119.hasNext() == false) goto L145;
        String r120 = r119.next();     // Catch: Throwable -> L134
        r48.putOpt(r120, r118.opt(r120));     // Catch: Throwable -> L134
    L145:
        if (r1 == 0) goto L147;
    L151:
        Result.constructor-impl(r48);     // Catch: Throwable -> L134
        ?? r54 = r53;
        ?? r121 = r15;
    L163:
        int r55 = ECSdk.a;
        IECHostService r56 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r56 == null) goto L168;
        xi.a r57 = r56.getIECHostLogService();
        if (r57 == null) goto L168;
        r57.logV3("na_prefetch_reuse_matching_result", r48);
    L168:
        A(r314, r35);
        int r58 = com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r42));
        String r59 = CollectionsKt.joinToString$default(r19, "|", null, null, 0, null, null, 62, null);
        JSONObject r60 = new JSONObject();     // Catch: Throwable -> L179
        JSONObject r122 = new JSONObject();     // Catch: Throwable -> L179
        r122.put(r50, r58);     // Catch: Throwable -> L179
        r122.put(r51, r59);     // Catch: Throwable -> L179
        Unit r61 = Unit.INSTANCE;     // Catch: Throwable -> L179
        r60.put("extra_reuse_info", r122);     // Catch: Throwable -> L179
        ConcurrentHashMap<String, NativePrefetch> r62 = NativePrefetchUtil.a;     // Catch: Throwable -> L179
        r60.put(r117, NativePrefetchUtil.c(r34));     // Catch: Throwable -> L179
        if (r121 == 0) goto L172;
        JSONObject r63 = r121.optJSONObject(r54);     // Catch: Throwable -> L179
    L173:
        r60.put("extra_monitor_info", r63);     // Catch: Throwable -> L179
        if (r121 == 0) goto L176;
        JSONObject r64 = r121.optJSONObject("perf_timing");     // Catch: Throwable -> L179
    L177:
        r60.put("extra_perf_timing", r64);     // Catch: Throwable -> L179
    L181:
        E(r35, r60);
        return r42;
    L176:
        r64 = null;
        goto L177
    L172:
        r63 = null;
    L179:
        th = move-exception;
        Result.Companion r65 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r60 = null;
        goto L181
    L147:
        if (r0 == null) goto L149;
        String r66 = r0.toString();     // Catch: Throwable -> L134
    L150:
        r48.putOpt("request_detail", r66);     // Catch: Throwable -> L134
        r48.putOpt("cache_request_detail", r110.toString());     // Catch: Throwable -> L134
        goto L151
    L149:
        r66 = null;
        goto L150
    L136:
        r53 = r26;
        r15 = r313;
        goto L145
    L137:
        r53 = r26;
        r15 = r313;
        if (r36 == 0) goto L145;
        JSONObject r67 = r36.optJSONObject(r53);     // Catch: Throwable -> L134
        if (r67 == null) goto L145;
        Iterator<String> r123 = r67.keys();     // Catch: Throwable -> L134
    L143:
        if (r123.hasNext() == false) goto L145;
        String r124 = r123.next();     // Catch: Throwable -> L134
        r48.putOpt(r124, r67.opt(r124));     // Catch: Throwable -> L134
    L134:
        th = th;
        ?? r68 = r53;
        ?? r125 = r15;
    L162:
        Result.Companion r69 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r54 = r68;
        r121 = r125;
    L153:
        th = th;
    L155:
        r125 = r313;
        r68 = r26;
    L156:
        th = th;
        r117 = r27;
    L158:
        th = th;
        r117 = r27;
        r51 = r28;
    L160:
        th = th;
        r117 = r27;
        r51 = r28;
        r50 = r29;
        goto L155
    L100:
        r0 = null;
        goto L101
    L29:
        r38 = null;
        goto L30
    L31:
        r29 = r13;
        r113 = r111;
        t r70 = r21.e;
        if (r70 == null) goto L34;
        String r71 = r70.a;
    L36:
        if ((!Intrinsics.areEqual(r71, r33.a)) == false) goto L42;
        dm.a.b r72 = dm.a.a;
        dm.a.b r73 = dm.a.a(r21.d);
        StringBuilder r74 = new StringBuilder("apiUrl not match,storeApiUrl :");
        t r75 = r21.e;
        if (r75 == null) goto L40;
        String r76 = r75.a;
    L41:
        r74.append(r76);
        r74.append(",infoApiUrl:");
        r74.append(r33.a);
        r73.i(r74.toString());
        r39 = new Pair(Boolean.FALSE, Integer.valueOf(NativeRequestMatchState.REQUEST_MATCH_APIURL_FAILED.getValue()));
        goto L88
    L40:
        r76 = null;
        goto L41
    L42:
        t r77 = r21.e;
        if (r77 == null) goto L45;
        String r78 = r77.b;
    L47:
        if ((!Intrinsics.areEqual(r78, r33.b)) == false) goto L53;
        dm.a.b r79 = dm.a.a;
        dm.a.b r80 = dm.a.a(r21.d);
        StringBuilder r81 = new StringBuilder("method not match,storeMethod :");
        t r82 = r21.e;
        if (r82 == null) goto L51;
        String r83 = r82.b;
    L52:
        r81.append(r83);
        r81.append(",infoMethod:");
        r81.append(r33.b);
        r80.i(r81.toString());
        r39 = new Pair(Boolean.FALSE, Integer.valueOf(NativeRequestMatchState.REQUEST_MATCH_METHOD_FAILED.getValue()));
        goto L88
    L51:
        r83 = null;
        goto L52
    L53:
        t r84 = r21.e;
        if (r84 == null) goto L56;
        Map<String, String> r85 = r84.c;
    L58:
        if (r21.a(r85, r33.c, ParamsType.Header) == true) goto L64;
        dm.a.b r86 = dm.a.a;
        dm.a.b r87 = dm.a.a(r21.d);
        StringBuilder r88 = new StringBuilder("headerMap not match,storeMap :");
        t r126 = r21.e;
        if (r126 == null) goto L62;
        Map<String, String> r127 = r126.c;
    L63:
        r88.append(r127);
        r88.append(",infoMap:");
        r88.append(r33.c);
        r87.i(r88.toString());
        r39 = new Pair(Boolean.FALSE, Integer.valueOf(NativeRequestMatchState.REQUEST_MATCH_HEADER_FAILED.getValue()));
        goto L88
    L62:
        r127 = null;
        goto L63
    L64:
        t r89 = r21.e;
        if (r89 == null) goto L67;
        Map<String, String> r90 = r89.d;
    L69:
        if (r21.a(r90, r33.d, ParamsType.Params) == true) goto L75;
        dm.a.b r91 = dm.a.a;
        dm.a.b r92 = dm.a.a(r21.d);
        StringBuilder r93 = new StringBuilder("queryMap not match,storeMap :");
        t r128 = r21.e;
        if (r128 == null) goto L73;
        Map<String, String> r129 = r128.d;
    L74:
        r93.append(r129);
        r93.append(",infoMap:");
        r93.append(r33.d);
        r92.i(r93.toString());
        r39 = new Pair(Boolean.FALSE, Integer.valueOf(NativeRequestMatchState.REQUEST_MATCH_PARAMS_FAILED.getValue()));
        goto L88
    L73:
        r129 = null;
        goto L74
    L75:
        t r94 = r21.e;
        if (r94 == null) goto L78;
        Map<String, String> r95 = r94.e;
    L80:
        if (r21.a(r95, r33.e, ParamsType.Data) == true) goto L86;
        dm.a.b r96 = dm.a.a;
        dm.a.b r97 = dm.a.a(r21.d);
        StringBuilder r98 = new StringBuilder("bodyMap not match,storeMap :");
        t r130 = r21.e;
        if (r130 == null) goto L84;
        Map<String, String> r131 = r130.e;
    L85:
        r98.append(r131);
        r98.append(",infoMap:");
        r98.append(r33.e);
        r97.i(r98.toString());
        r39 = new Pair(Boolean.FALSE, Integer.valueOf(NativeRequestMatchState.REQUEST_MATCH_DATA_FAILED.getValue()));
        goto L88
    L84:
        r131 = null;
        goto L85
    L86:
        r39 = new Pair(Boolean.TRUE, Integer.valueOf(NativeRequestMatchState.REQUEST_MATCH_SUCCESS.getValue()));
        goto L88
    L78:
        r95 = null;
        goto L80
    L67:
        r90 = null;
        goto L69
    L56:
        r85 = null;
        goto L58
    L45:
        r78 = null;
        goto L47
    L34:
        r71 = null;
        goto L36
    L23:
        r30 = null;
        goto L25
    L17:
        r22 = false;
        goto L18
    L97:
        r27 = r11;
        r28 = r12;
        r29 = r13;
        r42 = r112;
        r41 = null;
        r40 = null;
        goto L98
    L184:
        return false;
    L8:
        r18 = null;
        goto L9
    }

    public final void l(String r10, int r11, ECBaseBridgeMethod.a r12, String r13) {
        a r0 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r0 == null) goto L7;
        q r1 = r0.c;
        if (r1 == null) goto L7;
        r1.d(Long.valueOf(System.currentTimeMillis()));
    L7:
        JSONObject r14 = new JSONObject();
        a r15 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r15 == null) goto L12;
        q r16 = r15.c;
        if (r16 == null) goto L12;
        r14.putOpt("perf_timing", r16.a());
        r14.putOpt("net_detail", r16.a);
    L12:
        a r17 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r17 == null) goto L17;
        JSONObject r18 = r17.d;
        if (r18 == null) goto L17;
        r14.putOpt("extra_info", r18);
    L17:
        a r19 = (a) ((LinkedHashMap) this.c).get(r10);
        if (r19 == null) goto L20;
        r19.c = null;
    L20:
        JSONObject r20 = new JSONObject();
        r20.put("code", 0);
        r20.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r11);
        r20.put("errorMessage", r13);
        r20.putOpt("data", r14);
        Unit r21 = Unit.INSTANCE;
        r12.a(r20);
    }

    public final Pair<String, String> s(String r22, JSONObject r23, String r24, boolean r25, JSONObject r26) {
        Intrinsics.checkNotNullParameter(r22, com.bytedance.android.ec.core.event.a.KEY_URL);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L73
        Uri r11 = UriProtector.parse(r22);     // Catch: Throwable -> L73
        boolean r12 = false;
        if (StringsKt.startsWith$default(r11.toString(), "http", false, 2, null) == false) goto L6;
        Uri r13 = r11;
    L7:
        this.f = r13.getPath();     // Catch: Throwable -> L73
        String r14 = j1.c(r11, "ec_request_id");     // Catch: Throwable -> L73
        String r15 = j1.c(r11, "na_prefetch_cert");     // Catch: Throwable -> L73
        if (r14 == null) goto L10;
    L12:
        r15 = null;
    L13:
        if (r24 == null) goto L16;
        r15 = r24;
    L16:
        if (r15 != null) goto L18;
        r15 = UUID.randomUUID().toString();     // Catch: Throwable -> L73
    L18:
        String r16 = r15;
        ConcurrentHashMap<String, NativePrefetch> r17 = NativePrefetchUtil.a;     // Catch: Throwable -> L73
        NativePrefetchUtil.k("NativePrefetch", "generate request id is " + r16);     // Catch: Throwable -> L73
        this.a = r23;     // Catch: Throwable -> L73
        this.b = new LinkedHashMap();     // Catch: Throwable -> L73
        String r1 = this.f;     // Catch: Throwable -> L73
        Intrinsics.checkNotNullParameter(r22, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L73
        List<String> r18 = NativePrefetchUtil.f.get(r1);     // Catch: Throwable -> L73
        if (r18 != null) goto L21;
        r18 = (List) NativePrefetchUtil.j(r22).getFirst();     // Catch: Throwable -> L73
    L21:
        List<String> r19 = r18;
        Intrinsics.checkNotNullParameter(this, "nativePrefetch");     // Catch: Throwable -> L73
        if (r16 != null) goto L24;
    L27:
        boolean r20 = true;
    L28:
        if (r20 == true) goto L35;
        NativePrefetch r21 = NativePrefetchUtil.a.putIfAbsent(r16, this);     // Catch: Throwable -> L73
        if (r21 != null) goto L33;
        NativePrefetchUtil.c.postDelayed(new r(r16), 60000);     // Catch: Throwable -> L73
    L33:
        if (r21 == null) goto L35;
        boolean r27 = true;
    L36:
        if (r25 == false) goto L42;
        int r28 = u.a;     // Catch: Throwable -> L73
        if (r27 == true) goto L40;
        boolean r29 = true;
    L41:
        u.b(r22, r29);     // Catch: Throwable -> L73
        goto L42
    L40:
        r29 = false;
    L42:
        if (r27 == false) goto L48;
        if (r19 == null) goto L45;
        String r0 = CollectionsKt.joinToString$default(r19, "_", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L73
    L47:
        return TuplesKt.to(r16, r0);
    L45:
        r0 = null;
        goto L47
    L48:
        y.b r30 = o().get(this.f);     // Catch: Throwable -> L73
        if (r30 == null) goto L53;
        Boolean r31 = r30.h;     // Catch: Throwable -> L73
        if (r31 == null) goto L53;
        boolean r32 = r31.booleanValue();     // Catch: Throwable -> L73
    L54:
        if (r32 == false) goto L67;
        List<String> r33 = r19;     // Catch: Throwable -> L73
        if (r33 != null) goto L58;
    L59:
        r12 = true;
    L60:
        if (r12 == true) goto L67;
        if (r19.size() == 1) goto L64;
    L66:
        y();     // Catch: Throwable -> L73
        NativePrefetchUtil.c.postDelayed(new k(BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new NativePrefetch$startPrefetchWithMultipleConfig$job$1(this, r19, r11, r16, r26, null), 2, null)), this.e);     // Catch: Throwable -> L73
    L68:
        if (r19 == null) goto L70;
        String r34 = CollectionsKt.joinToString$default(r19, "_", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L73
    L72:
        return TuplesKt.to(r16, r34);
    L70:
        r34 = null;
        goto L72
    L64:
        if (r19.contains("default") == false) goto L66;
    L58:
        if (r33.isEmpty() == false) goto L60;
    L67:
        F(r11, r16, r26);     // Catch: Throwable -> L73
    L53:
        r32 = false;
    L35:
        r27 = false;
        goto L36
    L24:
        if (StringsKt.isBlank(r16) == true) goto L27;
        r20 = false;
        goto L28
    L10:
        if (com.bytedance.android.shopping.extensions.k.c(r15) == false) goto L12;
    L6:
        r13 = UriProtector.parse(UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL));     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return TuplesKt.to("", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static final void e(final NativePrefetch r25, JSONObject r26, final Uri r27, final int r28, final String r29, final JSONObject r30) {
        String r1 = r25.f;
        if (r1 != null) goto L5;
    L71:
        LinkedHashMap r12 = null;
    L72:
        if (r12 == null) goto L188;
        Iterator r13 = r12.keySet().iterator();
    L75:
        if (r13.hasNext() == false) goto L219;
        String r10 = (String) r13.next();
        final t r11 = (t) r12.get(r10);
        if (r11 == null) goto L75;
        String r0 = r11.f;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L89
        String r15 = UriProtector.getQueryParameter(r27, r0);     // Catch: Throwable -> L89
        if (r15 != null) goto L83;
    L86:
        boolean r16 = true;
    L87:
        Object r17 = Result.constructor-impl(Boolean.valueOf(!r16));     // Catch: Throwable -> L89
    L91:
        Boolean r18 = Boolean.FALSE;
        if (Result.isFailure-impl(r17) == false) goto L95;
        r17 = r18;
    L95:
        if (((Boolean) r17).booleanValue() == true) goto L75;
        ConcurrentHashMap<String, NativePrefetch> r19 = NativePrefetchUtil.a;
        NativePrefetchUtil.c.postDelayed(new l(r10, r12, r25), r25.e);
        monitor-enter(r12);
        r25.t(r10);     // Catch: Throwable -> L185
        if (r30 != null) goto L102;
    L104:
        boolean r20 = false;
    L105:
        if (r20 == true) goto L106;
        Intrinsics.checkNotNullParameter(r27, "uri");     // Catch: Throwable -> L185
        if ((NativePrefetchUtil.c(r27) & 1) <= 0) goto L110;
        boolean r21 = true;
    L111:
        if (r21 == false) goto L116;
        if (r25.j(r11, r27, r10, r30) == false) goto L116;
        monitor-exit(r12);
    L116:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L185
        monitor-exit(r12);
        r25.B(r10, r28);
        r25.x(r10);
        String r23 = r11.b;
        int r24 = r23.hashCode();
        if (r24 == 102230) goto L154;
        if (r24 == 3446944) goto L124;
    L183:
        NativePrefetchUtil.k("NativePrefetch", "request method error, method is " + r11.b);
    L184:
        final LinkedHashMap r31 = r12;
        b2.b(new NativePrefetch$startRequest$$inlined$apply$lambda$2(r11, r31, r25, r27, r30, r29, r28));
        goto L75
    L124:
        if (r23.equals("post") == false) goto L183;
        NativePrefetchUtil.k("NativePrefetch", "start post request , api key is " + r10);
        if (r11.g == false) goto L136;
        NativePrefetchApi r32 = (NativePrefetchApi) r25.k(r11.a, NativePrefetchApi.class, new n());
        if (r32 == null) goto L145;
        String r33 = r11.a;
        Map<String, String> r34 = r11.d;
        if (r34 != null) goto L132;
        r34 = MapsKt.emptyMap();
    L132:
        Map<String, String> r35 = r11.c;
        if (r35 != null) goto L135;
        r35 = MapsKt.emptyMap();
    L135:
        Observable r36 = r32.prefetchForPostV2(r33, r34, r35, v(r11.e));
    L146:
        if (r36 == null) goto L184;
        Observable r37 = r36.subscribeOn(Schedulers.io());
        if (r25.u() == true) goto L152;
        r37 = r37.observeOn(AndroidSchedulers.mainThread());
    L152:
        r37.subscribe(new i(r25, r10, r11), new j(r25, r10, r11));
    L145:
        r36 = null;
        goto L146
    L136:
        NativePrefetchApi r38 = (NativePrefetchApi) r25.k(r11.a, NativePrefetchApi.class, null);
        if (r38 == null) goto L145;
        String r39 = r11.a;
        Map<String, String> r40 = r11.d;
        if (r40 != null) goto L141;
        r40 = MapsKt.emptyMap();
    L141:
        Map<String, String> r41 = r11.c;
        if (r41 != null) goto L144;
        r41 = MapsKt.emptyMap();
    L144:
        r36 = r38.prefetchForPost(r39, r40, r41, v(r11.e));
        goto L146
    L154:
        if (r23.equals("get") == false) goto L183;
        NativePrefetchUtil.k("NativePrefetch", "start get request , api key is " + r10);
        if (r11.g == false) goto L166;
        NativePrefetchApi r42 = (NativePrefetchApi) r25.k(r11.a, NativePrefetchApi.class, new n());
        if (r42 == null) goto L175;
        String r43 = r11.a;
        Map<String, String> r44 = r11.d;
        if (r44 != null) goto L162;
        r44 = MapsKt.emptyMap();
    L162:
        Map<String, String> r45 = r11.c;
        if (r45 != null) goto L165;
        r45 = MapsKt.emptyMap();
    L165:
        Observable r46 = r42.prefetchForGetV2(r43, r44, r45);
    L176:
        if (r46 == null) goto L184;
        Observable r47 = r46.subscribeOn(Schedulers.io());
        if (r25.u() == true) goto L182;
        r47 = r47.observeOn(AndroidSchedulers.mainThread());
    L182:
        r47.subscribe(new g(r25, r10, r11), new h(r25, r10, r11));
    L175:
        r46 = null;
        goto L176
    L166:
        NativePrefetchApi r48 = (NativePrefetchApi) r25.k(r11.a, NativePrefetchApi.class, null);
        if (r48 == null) goto L175;
        String r49 = r11.a;
        Map<String, String> r50 = r11.d;
        if (r50 != null) goto L171;
        r50 = MapsKt.emptyMap();
    L171:
        Map<String, String> r51 = r11.c;
        if (r51 != null) goto L174;
        r51 = MapsKt.emptyMap();
    L174:
        r46 = r48.prefetchForGet(r49, r50, r51);
        goto L176
    L110:
        r21 = false;
        goto L111
    L106:
        r25.f(r11, r27, r29, r30);     // Catch: Throwable -> L185
        goto L116
    L102:
        if (r30.optBoolean("add_reuse_pool") != true) goto L104;
        r20 = true;
    L185:
        th = move-exception;
        throw th;
    L83:
        if (StringsKt.isBlank(r15) == true) goto L86;
        r16 = false;
    L89:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L91
    L219:
        return;
    L188:
        int r53 = u.a;
        u.a(r27.toString(), 3001, null, null);
        return;
    L5:
        if (r26 != null) goto L7;
        f r54 = null;
    L8:
        if (r54 == null) goto L71;
        int r55 = t.j;
        JSONObject r56 = r25.a;
        Map<String, String> r57 = r25.b;
        Intrinsics.checkNotNullParameter(r54, "preFetchConfig");
        Intrinsics.checkNotNullParameter(r1, "prefetchTag");
        Intrinsics.checkNotNullParameter(r27, "uri");
        JSONObject r58 = r54.b();
        if (r58 == null) goto L18;
        JSONObject r59 = r58.optJSONObject(r1);
        if (r59 == null) goto L18;
        JSONArray r60 = r59.optJSONArray("prefetch_apis");
        if (r60 == null) goto L18;
        ?? r61 = new ArrayList();
        int r62 = r60.length();
        int r63 = 0;
    L16:
        if (r63 >= r62) goto L19;
        r61.add(r60.get(r63).toString());
        r63 = r63 + 1;
    L19:
        LinkedHashMap r64 = new LinkedHashMap();
        Iterator r65 = ((Iterable) r61).iterator();
    L21:
        if (r65.hasNext() == false) goto L70;
        String r66 = (String) r65.next();
        JSONObject r67 = r54.a();
        if (r67 == null) goto L21;
        JSONObject r68 = r67.optJSONObject(r66);
        if (r68 == null) goto L21;
        JSONObject r69 = r68.optJSONObject("headers");
        if (r69 != null) goto L30;
        r69 = new JSONObject();
    L30:
        r69.putOpt("Ec-Native-Prefetch", 1);
        if (r30 == null) goto L37;
        String r70 = r30.optString("_bcm_chain_cache_id");
        if (r70 == null) goto L37;
        String r71 = a2.d(r70);
        if (r71 == null) goto L37;
        int r110 = t.j;
        JSONObject r111 = new JSONObject();
        r111.putOpt("type", "static");
        r111.putOpt(com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, r71);
        r69.putOpt("Ec-Native-Prefetch-Bcm-Cache-UUID", r111);
    L37:
        String r112 = r68.optString(com.bytedance.android.ec.core.event.a.KEY_URL, "");
        String r72 = r68.optString("method", "GET");
        Locale r113 = Locale.ROOT;
        if (r72 == null) goto L69;
        String r114 = r72.toLowerCase(r113);
        int r73 = t.j;
        Map r115 = t.a.a(r69, r27, r56, r57);
        Map r116 = t.a.a(r68.optJSONObject("params"), r27, r56, r57);
        Map r210 = t.a.a(r68.optJSONObject("data"), r27, r56, r57);
        String r74 = r68.optString("interrupt_flag");
        if (r74 != null) goto L42;
    L45:
        boolean r75 = true;
    L47:
        if ((!r75) == false) goto L49;
        String r211 = r74;
    L50:
        boolean r212 = Intrinsics.areEqual(r68.optString("enable_net_perf_timing"), "1");
        JSONObject r76 = r68.optJSONObject("image_preload_config");
        if (r76 != null) goto L190;
    L61:
        com.bytedance.android.ec.core.hybrid.prefetch.e r213 = null;
    L62:
        t r77 = new t(r112, r114, r115, r116, r210, r211, r212, r213, r66);
        if (r77.a.length() <= 0) goto L65;
        boolean r78 = true;
    L66:
        if (r78 == false) goto L21;
        r64.put(r66, r77);
        goto L21
    L65:
        r78 = false;
        goto L66
    L190:
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L59
        int r80 = w0.a;     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.hybrid.prefetch.e.class, "clazz");     // Catch: Throwable -> L59
        String r81 = r76.toString();     // Catch: Throwable -> L59
        if (r81 == null) goto L56;
        Object r82 = w0.b(r81, com.bytedance.android.ec.core.hybrid.prefetch.e.class);     // Catch: Throwable -> L59
    L58:
        r213 = (com.bytedance.android.ec.core.hybrid.prefetch.e) r82;     // Catch: Throwable -> L59
        goto L62
    L56:
        r82 = null;
    L59:
        th = move-exception;
        Result.Companion r83 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L49:
        r211 = null;
        goto L50
    L42:
        if (StringsKt.isBlank(r74) == true) goto L45;
        r75 = false;
        goto L47
    L69:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L70:
        r12 = r64;
    L18:
        r61 = CollectionsKt.emptyList();
        goto L19
    L7:
        r54 = new f(r26.optString("version"), r26.optString("project"), r26.optJSONObject("rules"), r26.optJSONObject("prefetch_apis"));
        goto L8
    }
}
