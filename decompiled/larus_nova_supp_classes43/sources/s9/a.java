package s9;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.prerender.PrerenderMaxSizeLruCache;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.annie.util.r;
import com.bytedance.android.annie.util.s;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final ConcurrentHashMap<Integer, f> a = null;
    public static final ConcurrentHashMap<String, WeakReference<Disposable>> b = null;
    public static final ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> c = null;
    public static HybridCard d;

    /* JADX INFO: renamed from: s9.a$a, reason: collision with other inner class name */
    public static final class C0196a extends b7.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ e f;

        @Override // b7.a, b7.b
        public final void onLoadSuccess(View r13) {
            super.onLoadSuccess(r13);
            ConcurrentHashMap<Integer, f> r0 = a.a;
            ViewParent r1 = null;
            if (r13 == null) goto L5;
            ViewParent r10 = r13.getParent();
        L7:
            if (r10 == null) goto L9;
            int r11 = r10.hashCode();
        L10:
            a.e(Integer.valueOf(r11), System.currentTimeMillis(), false);
            if (r13 == null) goto L24;
            String r12 = this.a;
            String r14 = this.b;
            ViewParent r15 = r13.getParent();
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.android.annie.api.card.HybridCard");
            HybridCard r16 = (HybridCard) r15;
            ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> r17 = a.c;
            if (r17.get(r12) != null) goto L21;
            com.bytedance.android.annie.ng.a r18 = g.c.get(r12);
            if (r18 == null) goto L19;
            o8.g r19 = r18.d;
            if (r19 == null) goto L19;
            int r20 = r19.a;
        L20:
            PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r21 = new PrerenderMaxSizeLruCache(r20);
            r21.put(r14, new WeakReference(r16));
            r17.put(r12, r21);
        L19:
            r20 = 5;
            goto L20
        L21:
            PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r22 = r17.get(r12);
            if (r22 == null) goto L24;
            WeakReference<HybridCard> r23 = r22.put(r14, new WeakReference(r16));
        L24:
            String r24 = this.c;
            String r25 = this.d;
            String r26 = this.b;
            String r27 = this.a;
            int r28 = this.e;
            int r29 = s.a;
            Ref.IntRef r30 = new Ref.IntRef();
            if (r28 <= 0) goto L27;
            r30.element = r28;
        L27:
            a.b.put(r26, new WeakReference(Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).map(new r(r30)).take(r30.element + 1).doOnComplete(new c(r24, r26, r27, r25)).doOnError(d.a).subscribe()));
            int r31 = x8.a.a;
            x8.a.d(Annie.ANNIE_TAG, "预渲染成功:" + this.c, false);
            e r32 = this.f;
            if (r32 == null) goto L30;
            r32.onSuccess(this.c);
        L30:
            j9.b r33 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            if (r13 == null) goto L33;
            r1 = r13.getParent();
        L33:
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.View");
            View r34 = (View) r1;
            String r35 = this.d;
            JSONObject r36 = new JSONObject();
            String r37 = this.a;
            String r38 = this.b;
            r36.put("biz", r37);
            r36.put("cache_key", r38);
            r36.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, "success");
            r36.put(com.bytedance.android.ec.core.event.a.KEY_MSG, "success");
            Unit r39 = Unit.INSTANCE;
            JSONObject r40 = new JSONObject();
            r40.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, a.a(Integer.valueOf(r13.getParent().hashCode())));
            JSONObject r41 = new JSONObject();
            r41.put("start_timestamp", a.b(Integer.valueOf(r13.getParent().hashCode())).a);
            r41.put("end_timestamp", a.b(Integer.valueOf(r13.getParent().hashCode())).b);
            j9.b.a.a(r33, r34, "annie_container_prerender", r35, r36, r40, r41, null, 1, 320);
            a.a.remove(Integer.valueOf(r13.getParent().hashCode()));
            return;
        L9:
            r11 = 0;
            goto L10
        L5:
            r10 = null;
            goto L7
        }

        @Override // b7.a, b7.b
        public final void onLoadFail(View r13, String r14, String r15) {
            super.onLoadFail(r13, r14, r15);
            ConcurrentHashMap<Integer, f> r0 = a.a;
            ViewParent r1 = null;
            if (r13 == null) goto L5;
            ViewParent r10 = r13.getParent();
        L7:
            if (r10 == null) goto L9;
            int r11 = r10.hashCode();
        L10:
            a.e(Integer.valueOf(r11), System.currentTimeMillis(), false);
            int r12 = x8.a.a;
            x8.a.b(Annie.ANNIE_TAG, "预渲染失败:" + this.c + " reason:" + r15, false);
            e r16 = this.f;
            if (r16 == null) goto L13;
            r16.onFailed(this.c, "预渲染失败:" + this.c + " reason:" + r15);
        L13:
            j9.b r17 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            if (r13 == null) goto L16;
            r1 = r13.getParent();
        L16:
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.View");
            View r18 = (View) r1;
            JSONObject r19 = new JSONObject();
            String r20 = this.a;
            String r21 = this.b;
            r19.put("biz", r20);
            r19.put("cache_key", r21);
            r19.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, "fail");
            if (r15 != null) goto L19;
            r15 = "fail";
        L19:
            r19.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r15);
            Unit r110 = Unit.INSTANCE;
            JSONObject r22 = new JSONObject();
            r22.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, a.a(Integer.valueOf(r13.getParent().hashCode())));
            JSONObject r23 = new JSONObject();
            r23.put("start_timestamp", a.b(Integer.valueOf(r13.getParent().hashCode())).a);
            r23.put("end_timestamp", a.b(Integer.valueOf(r13.getParent().hashCode())).b);
            j9.b.a.a(r17, r18, "annie_container_prerender", r14, r19, r22, r23, null, 1, 320);
            a.a.remove(Integer.valueOf(r13.getParent().hashCode()));
            return;
        L9:
            r11 = 0;
            goto L10
        L5:
            r10 = null;
            goto L7
        }

        public C0196a(String r1, String r10, String r11, String r12, int r13, e r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WeakReference<HybridCard> a;

        public b(WeakReference<HybridCard> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<HybridCard> r0 = this.a;     // Catch: Throwable -> L8 Exception -> L10
            if (r0 == null) goto L17;
            HybridCard r1 = r0.get();     // Catch: Throwable -> L8 Exception -> L10
            if (r1 == null) goto L17;
            r1.release();     // Catch: Throwable -> L8 Exception -> L10
        L17:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        L21:
            return;
        L10:
            e = move-exception;
            int r10 = x8.a.a;     // Catch: Throwable -> L8
            x8.a.b(Annie.ANNIE_TAG, "回收预渲染View失败:" + e, false);     // Catch: Throwable -> L8
            goto L17
        }
    }

    public a() {
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static final long a(Integer r10) {
        if (r10 == null) goto L12;
        ConcurrentHashMap<Integer, f> r0 = a;
        if (r0.containsKey(r10) == false) goto L12;
        f r11 = r0.get(r10);
        if (r11 == null) goto L9;
        Long r12 = Long.valueOf(r11.b - r11.a);
    L10:
        if (r12 == null) goto L12;
        return r12.longValue();
    L9:
        r12 = null;
    L12:
        return 0;
    }

    public static final f b(Integer r10) {
        ConcurrentHashMap<Integer, f> r0 = a;
        if (r0 == null) goto L10;
        if (r0.containsKey(r10) == false) goto L8;
        f r11 = r0.get(r10);
        Intrinsics.checkNotNull(r11);
        return r11;
    L8:
        return new f();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public static boolean d(String r10, String r11) {
        ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> r0 = c;
        if (r0.get(r10) != null) goto L5;
        return false;
    L5:
        PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r12 = r0.get(r10);
        Intrinsics.checkNotNull(r12);
        if (r12.get(r11) != null) goto L8;
        return false;
    L8:
        return true;
    }

    public static void e(Integer r10, long r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<Integer, f> r0 = a;
        if (r0.containsKey(r10) == false) goto L11;
        f r13 = r0.get(r10);
        if (r13 == null) goto L17;
        if (r12 == false) goto L10;
        r13.a = r11;
        return;
    L10:
        r13.b = r11;
        return;
    L17:
        return;
    L11:
        f r1 = new f();
        if (r12 == false) goto L14;
        r1.a = r11;
    L15:
        r0.put(r10, r1);
        return;
    L14:
        r1.b = r11;
        goto L15
    }

    public static void f(String r10, String r11, boolean r12) {
        ConcurrentHashMap<String, PrerenderMaxSizeLruCache<WeakReference<HybridCard>>> r0 = c;
        if (r0.get(r11) != null) goto L5;
        return;
    L5:
        PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r13 = r0.get(r11);
        if (r13 == null) goto L8;
        WeakReference r14 = (WeakReference) r13.remove(r10);
    L9:
        if (r12 == false) goto L12;
        ThreadUtils.c(new b(r14));
        return;
    L12:
        return;
    L8:
        r14 = null;
        goto L9
    }

    public static void c(Context r15, String r16, String r17, int r18, e r19) {
        Uri r10 = UriProtector.parse(r16);
        String r11 = UriProtector.getQueryParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == false) goto L15;
        int r0 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, "url == null schema is: " + r16, false);
        if (r19 == null) goto L62;
        r19.onFailed(r16, "url == null");
        return;
    L62:
        return;
    L15:
        String r13 = UriProtector.getQueryParameter(r10, "prerender_cache_key");
        if (r13 != null) goto L18;
    L21:
        boolean r14 = true;
    L22:
        if (r14 == false) goto L60;
        int r1 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, "prerenderCacheKey == null schema is: " + r16, false);
        if (r19 == null) goto L63;
        r19.onFailed(r16, "prerenderCacheKey == null");
        return;
    L63:
        return;
    L60:
        Uri r20 = UriProtector.parse(r11);     // Catch: Exception -> L56
        StringBuilder r21 = new StringBuilder();     // Catch: Exception -> L56
        r21.append(r20.getScheme());     // Catch: Exception -> L56
        r21.append(':');     // Catch: Exception -> L56
        if (r20.getPort() != (-1)) goto L30;
        Object r110 = "";
    L31:
        r21.append(r110);     // Catch: Exception -> L56
        r21.append("//");     // Catch: Exception -> L56
        r21.append(r20.getHost());     // Catch: Exception -> L56
        r21.append(r20.getPath());     // Catch: Exception -> L56
        String r22 = r21.toString() + '_' + r13;
        if (d(r17, r22) == false) goto L46;
        int r23 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, "当前缓存中已存在指定card schema is: " + r16, false);
        PrerenderMaxSizeLruCache<WeakReference<HybridCard>> r24 = c.get(r17);
        Intrinsics.checkNotNull(r24);
        Object r25 = r24.get(r22);
        Intrinsics.checkNotNull(r25);
        Object r26 = ((WeakReference) r25).get();
        Intrinsics.checkNotNull(r26);
        if (Intrinsics.areEqual(((HybridCard) r26).getContext(), r15) == false) goto L39;
        if (r19 == null) goto L64;
        r19.onFailed(r16, "当前缓存中已存在指定card");
        return;
    L64:
        return;
    L39:
        x8.a.d(Annie.ANNIE_TAG, "删除缓存card, 重新创建", false);
        f(r22, r17, true);
        ConcurrentHashMap<String, WeakReference<Disposable>> r27 = b;
        WeakReference<Disposable> r28 = r27.get(r22);
        if (r28 == null) goto L46;
        r27.remove(r22);
        Disposable r29 = r28.get();
        if (r29 == null) goto L46;
        if (r29.isDisposed() == true) goto L46;
        r29.dispose();
    L46:
        d = null;
        com.bytedance.android.annie.ng.c r111 = Annie.with(r15, r10, r17);
        Bundle r30 = new Bundle();
        r30.putInt("isPrerender", 1);
        r111.getClass();
        Intrinsics.checkNotNullParameter(r30, "bundle");
        r111.e = r30;
        C0196a r112 = new C0196a(r17, r22, r16, r11, r18, r19);
        Intrinsics.checkNotNullParameter(r112, "commonLifecycle");
        r111.d = r112;
        HybridCard r31 = r111.a();
        d = r31;
        if (r31 != null) goto L52;
        int r32 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, "预渲染失败:" + r16, false);
        if (r19 == null) goto L65;
        r19.onFailed(r16, "预渲染失败:" + r16);
        return;
    L65:
        return;
    L52:
        e(Integer.valueOf(r31.hashCode()), System.currentTimeMillis(), true);
        HybridCard r33 = d;
        if (r33 == null) goto L66;
        a7.a.a(r33, null, null, 3);
        return;
    L66:
        return;
    L30:
        r110 = Integer.valueOf(r20.getPort());     // Catch: Exception -> L56
    L56:
        int r34 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, "解析schema种的url失败:" + r16, false);
        if (r19 == null) goto L67;
        r19.onFailed(r16, "解析schema种的url失败:" + r16);
        return;
    L67:
        return;
    L18:
        if (r13.length() == 0) goto L21;
        r14 = false;
        goto L22
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L10
    }
}
