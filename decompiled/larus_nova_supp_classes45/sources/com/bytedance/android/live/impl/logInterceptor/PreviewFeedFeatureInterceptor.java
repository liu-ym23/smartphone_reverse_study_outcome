package com.bytedance.android.live.impl.logInterceptor;

import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.impl.logfilter.d;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.common.utility.concurrent.TTExecutors;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import j40.c0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PreviewFeedFeatureInterceptor extends d {
    public static volatile long b;
    public static final LiveFeatureConfig c = null;
    public static long d;
    public static boolean e;
    public static boolean f;
    public static final Lazy g = null;
    public static Disposable h;
    public static final Map<String, JSONObject> i = null;
    public static final PreviewFeedFeatureInterceptor j = null;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            long r0 = System.currentTimeMillis();
            PreviewFeedFeatureInterceptor r11 = PreviewFeedFeatureInterceptor.j;
            final long r1 = (r0 - PreviewFeedFeatureInterceptor.d) / ((long) 1000);
            LiveFeatureConfig r2 = PreviewFeedFeatureInterceptor.c;
            List<Integer> r3 = r2.getPreviewStayDurationReportList();
            if (r3 == null) goto L8;
            boolean r4 = com.bytedance.android.live.impl.utils.a.a;
            com.bytedance.android.live.impl.utils.a.a(r11.a, new PreviewFeedFeatureInterceptor$startOrStoppreviewStayDurationTimerTask$1$1(r1));
            if (r3.contains(Integer.valueOf((int) r1)) == false) goto L13;
            FeatureManager.u.c("preview_stay_duration", Long.valueOf(r1));
            return;
        L13:
            return;
        L8:
            if (r1 > 0) goto L10;
            return;
        L10:
            if ((r1 % ((long) r2.getPreviewStayDurationUpdateInterval())) != 0) goto L16;
            FeatureManager.u.c("preview_stay_duration", Long.valueOf(r1));
            return;
        }
    }

    @Override // com.bytedance.android.live.impl.logfilter.d
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "name");
    }

    public final k0 e() {
        return (k0) g.getValue();
    }

    static {
        j = new PreviewFeedFeatureInterceptor();
        b = System.currentTimeMillis();
        c = c0.a.getValue();
        e = true;
        g = LazyKt.lazy(PreviewFeedFeatureInterceptor$kevaOrSpHelper$2.INSTANCE);
        i = new LinkedHashMap();
        TTExecutors.getNormalExecutor().submit(new c(true));
        TTExecutors.getNormalExecutor().submit(new b(true));
    }

    public PreviewFeedFeatureInterceptor() {
    }

    public static void f(boolean r6) {
        LiveFeatureConfig r0 = c;
        if (r0.getPreviewStayDurationUpdatePeriod() > 0) goto L5;
        return;
    L5:
        Disposable r1 = h;
        if (r1 != null) goto L8;
    L12:
        h = null;
        if (r6 == false) goto L16;
        h = du2.a.d(r0.getPreviewStayDurationUpdatePeriod(), TimeUnit.MILLISECONDS).observeOn(Schedulers.computation()).subscribe(a.a);
        return;
    L16:
        return;
    L8:
        if (r1.isDisposed() == true) goto L12;
        Disposable r2 = h;
        if (r2 == null) goto L12;
        r2.dispose();
        goto L12
    }

    @Override // z90.d
    public final <T> T getFeature(String r6) {
        Intrinsics.checkNotNullParameter(r6, "name");
        if (r6.hashCode() == 609944707) goto L6;
        return null;
    L6:
        if (r6.equals("preview_stay_duration") == true) goto L8;
        return null;
    L8:
        if (d == 0) goto L13;
        long r7 = Long.valueOf((System.currentTimeMillis() - d) * 1000);
        if ((r7 instanceof Object) == true) goto L16;
        return null;
    L16:
        return (T) r7;
    L13:
        r7 = -1L;
        if (((-1L) instanceof Object) == true) goto L16;
        return null;
    }
}
