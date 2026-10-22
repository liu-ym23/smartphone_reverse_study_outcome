package com.bytedance.android.livesdk.gecko;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q<T> implements ObservableOnSubscribe {
    public final /* synthetic */ TC21GeckoClientImpl a;
    public final /* synthetic */ GeckoClient b;
    public final /* synthetic */ o.a c;
    public final /* synthetic */ boolean d;

    public q(TC21GeckoClientImpl r1, GeckoClient r2, o.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = false;
    }

    public final void subscribe(ObservableEmitter<j.b> r13) {
        Intrinsics.checkNotNullParameter(r13, "it");
        final TC21GeckoClientImpl r0 = this.a;
        GeckoClient r2 = this.b;
        final o.a r1 = this.c;
        boolean r3 = this.d;
        r0.getClass();
        LinkedHashMap r4 = new LinkedHashMap();
        String r8 = "";
        if (TextUtils.isEmpty(r1.c) == true) goto L8;
        Pair[] r5 = new Pair[1];
        String r9 = r1.c;
        if (r9 != null) goto L7;
        r9 = "";
    L7:
        r5[0] = TuplesKt.to("business_version", r9);
        r4.put(r1.a, MapsKt.mutableMapOf(r5));
    L8:
        Map r6 = MapsKt.mapOf(TuplesKt.to(r1.a, CollectionsKt.arrayListOf(new CheckRequestBodyModel.TargetChannel[]{new CheckRequestBodyModel.TargetChannel(r1.b)})));
        String r10 = r1.a;
        String r11 = r1.b;
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        String r12 = r1.c;
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        j.a r7 = new j.a(r10, r11, r12);
        Set<j.a> r14 = d.a;
        Intrinsics.checkNotNullParameter(r7, "cache");
        if (d.a.contains(r7) == false) goto L24;
        if (r3 == false) goto L24;
        String r15 = ResLoadUtils.getChannelPath((File) r0.d.getValue(), r1.a, r1.b);
        if (r15 == null) goto L21;
        r8 = r15;
    L21:
        PolarisFileWrapper r16 = new PolarisFileWrapper(r8);
        boolean r17 = r16.exists();
        ALogger.i("AAM.Source.TC21GeckoClientImpl", "gecko cache, file exist: " + r17 + "  " + r16);
        if (r17 == false) goto L24;
        r13.onNext(new j.d(true, r16.getAbsolutePath()));
        r13.onComplete();
        return;
    L24:
        String r18 = r1.b;
        j.f r19 = new j.f(r18, r1.c);
        Function1<String, String> r20 = new TC21GeckoClientImpl$downloadGeckoSource$3(r0, r1);
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter("default", "groupType");
        Intrinsics.checkNotNullParameter(r7, "cacheKey");
        Intrinsics.checkNotNullParameter(r4, "customParam");
        Intrinsics.checkNotNullParameter(r6, "targetChannels");
        Intrinsics.checkNotNullParameter(r13, "emitter");
        Intrinsics.checkNotNullParameter(r19, "args");
        Intrinsics.checkNotNullParameter(r20, "channelDir");
        xo2.c r21 = (xo2.c) com.bytedance.android.livesdk.service.l.d().b().a(xo2.c.class);
        b r22 = new b(r13, r19, r7, r20);
        if (TextUtils.isEmpty(r18) == true) goto L27;
        if (r21 != null) goto L32;
    L38:
        r2.checkUpdateMulti("default", r4, r6, r22);
        return;
    L32:
        if (tb1.c.c == true) goto L38;
        String r23 = r7.a + r7.b;
        Map<String, Set<WeakReference<ObservableEmitter<j.b>>>> r24 = d.b;
        Set<WeakReference<ObservableEmitter<j.b>>> r25 = (Set) ((LinkedHashMap) r24).get(r23);
        if (r25 != null) goto L37;
        r25 = new LinkedHashSet();
    L37:
        r25.add(new WeakReference(r13));
        r24.put(r23, r25);
        r21.a(r2, "default", r4, r6, r22, new c(r23));
        return;
    L27:
        if (r13.isDisposed() == true) goto L29;
        r13.onError(new Throwable("channel is null"));
    L29:
        r13.onComplete();
    }
}
