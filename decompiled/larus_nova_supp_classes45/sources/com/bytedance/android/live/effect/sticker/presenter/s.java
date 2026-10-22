package com.bytedance.android.live.effect.sticker.presenter;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.api.AigcBackgroundImageGenerateTask;
import com.bytedance.android.live.effect.sticker.api.CheckAigcBackgroundImageGenerateTaskByTaskIDResponse;
import com.bytedance.android.live.effect.sticker.api.LiveEffectApi;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.utils.n1;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonArray;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public static final /* synthetic */ int q = 0;
    public final CompositeDisposable a;
    public final Map<Long, com.bytedance.android.live.effect.sticker.presenter.g> b;
    public final Map<Long, List<n0>> c;
    public final Map<Long, Long> d;
    public final List<Long> e;
    public boolean f;
    public final Map<Long, Sticker> g;
    public final Integer h;
    public final Map<String, String> i;
    public final Map<String, List<l>> j;
    public boolean k;
    public Disposable l;
    public final Map<Long, Long> m;
    public final Map<Long, String> n;
    public final c o;
    public final e p;

    public static final class a {
    }

    public static final class b implements l {
        public final /* synthetic */ List a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ List c;
        public final /* synthetic */ k d;

        @Override // com.bytedance.android.live.effect.sticker.presenter.l
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "path");
            if (r3.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            this.a.add(r3);
        L8:
            Ref.IntRef r4 = this.b;
            int r1 = r4.element + 1;
            r4.element = r1;
            if (r1 != this.c.size()) goto L14;
            k r5 = this.d;
            if (r5 == null) goto L15;
            r5.a(this.a);
            return;
        L15:
            return;
        L14:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public b(List r1, Ref.IntRef r2, List r3, k r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c extends o0 {
        public final /* synthetic */ s a;

        public c(s r1) {
            this.a = r1;
        }

        public final void onSuccessed(DownloadInfo r4) {
            if (r4 == null) goto L13;
            String r0 = r4.getSavePath() + '/' + r4.getName();
            List r1 = (List) ((LinkedHashMap) this.a.j).get(r4.getUrl());
            if (r1 != null) goto L6;
            r1 = CollectionsKt.emptyList();
        L6:
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            ((l) r2.next()).a(r0);
            goto L8
        L10:
            this.a.j.remove(r4.getUrl());
            this.a.i.put(r4.getUrl(), r0);
            return;
        }

        public final void onFailed(DownloadInfo r3, BaseException r4) {
            if (r3 == null) goto L13;
            Map<String, List<l>> r5 = this.a.j;
            LinkedHashMap r6 = (LinkedHashMap) r5;
            List r7 = (List) r6.get(r3.getUrl());
            if (r7 != null) goto L6;
            r7 = CollectionsKt.emptyList();
        L6:
            Iterator r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            ((l) r8.next()).a("");
            goto L8
        L10:
            this.a.j.remove(r3.getUrl());
            return;
        }
    }

    public static final class d implements com.bytedance.android.live.effect.api.k.a {
        public final /* synthetic */ s a;
        public final /* synthetic */ p b;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;
            public final /* synthetic */ List b;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.presenter.s$d$a$a, reason: collision with other inner class name */
            public static final class RunnableC0192a implements Runnable {
                public final /* synthetic */ a a;
                public final /* synthetic */ List b;

                /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.presenter.s$d$a$a$a, reason: collision with other inner class name */
                public static final class C0193a implements m {
                    public final /* synthetic */ RunnableC0192a a;

                    @Override // com.bytedance.android.live.effect.sticker.presenter.m
                    public final void onFail() {
                        p r0 = this.a.a.a.b;
                        if (r0 == null) goto L6;
                        r0.onFail();
                        return;
                    }

                    public C0193a(RunnableC0192a r1) {
                        this.a = r1;
                    }

                    @Override // com.bytedance.android.live.effect.sticker.presenter.m
                    public final void onSuccess(Map<Long, ? extends Map<Long, AigcBackgroundImageGenerateTask>> r3) {
                        Intrinsics.checkNotNullParameter(r3, "taskMap");
                        d r4 = this.a.a.a;
                        r4.a.k = true;
                        p r5 = r4.b;
                        if (r5 == null) goto L6;
                        r5.onSuccess();
                        return;
                    }
                }

                public RunnableC0192a(a r1, List r2) {
                    this.a = r1;
                    this.b = r2;
                }

                public final void a() {
                    s r0 = this.a.a.a;
                    List r1 = this.b;
                    r0.getClass();
                    Intrinsics.checkNotNullParameter(r1, "stickers");
                    ((LinkedHashMap) r0.g).clear();
                    Iterator r2 = r1.iterator();
                L4:
                    if (r2.hasNext() == false) goto L6;
                    Sticker r3 = (Sticker) r2.next();
                    r0.g.put(Long.valueOf(r3.getId()), r3);
                    goto L4
                L6:
                    a r4 = this.a;
                    s r5 = r4.a.a;
                    List r6 = r4.b;
                    ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
                    Iterator r8 = r6.iterator();
                L8:
                    if (r8.hasNext() == false) goto L14;
                    Long r9 = StringsKt.toLongOrNull(((Effect) r8.next()).getEffect_id());
                    if (r9 == null) goto L12;
                    long r11 = r9.longValue();
                L13:
                    r7.add(Long.valueOf(r11));
                    goto L8
                L12:
                    r11 = 0;
                    goto L13
                L14:
                    C0193a r12 = new C0193a(this);
                    r5.getClass();
                    Intrinsics.checkNotNullParameter(r7, "effectIDList");
                    JsonArray r13 = new JsonArray();
                    Iterator r14 = r7.iterator();
                L16:
                    if (r14.hasNext() == false) goto L18;
                    r13.add(String.valueOf(((Number) r14.next()).longValue()));
                    goto L16
                L18:
                    String r15 = r13.toString();
                    RxUtilKt.c(((LiveEffectApi) com.bytedance.android.live.network.c.b().e(LiveEffectApi.class)).checkAigcBackgroundImageGenerateTaskListByEffectID(r15).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(r5, r7, r12), new w(r12)), r5.a);
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public a(d r1, List r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                ArrayList r0 = new ArrayList();
                ArrayList r1 = new ArrayList();
                Iterator r2 = this.b.iterator();
            L4:
                if (r2.hasNext() == false) goto L10;
                Effect r3 = (Effect) r2.next();
                r0.add(com.bytedance.android.live.effect.sticker.d.b(r3));
                Long r4 = StringsKt.toLongOrNull(r3.getEffect_id());
                if (r4 == null) goto L8;
                long r5 = r4.longValue();
            L9:
                r1.add(Long.valueOf(r5));
                goto L4
            L8:
                r5 = 0;
                goto L9
            L10:
                MainThreadPostUtils.b(new RunnableC0192a(this, r0));
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.api.k.a
        public final void onFetchFailed() {
            p r0 = this.b;
            if (r0 == null) goto L6;
            r0.onFail();
            return;
        }

        public d(s r1, p r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.effect.api.k.a
        public final void a(List<Effect> r2, EffectDataFetchCacheType r3) {
            Intrinsics.checkNotNullParameter(r2, "effectList");
            Intrinsics.checkNotNullParameter(r3, "cacheType");
            TTExecutors.getNormalExecutor().submit(new a(this, r2));
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ s a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ e a;

            public a(e r1) {
                this.a = r1;
            }

            public final void accept(Object r9) {
                Iterator<Map.Entry<Long, AigcBackgroundImageGenerateTask>> r11 = ((CheckAigcBackgroundImageGenerateTaskByTaskIDResponse) ((BaseResponse) r9).data).getTaskMap().getTaskMap().entrySet().iterator();
            L4:
                if (r11.hasNext() == false) goto L34;
                Map.Entry<Long, AigcBackgroundImageGenerateTask> r0 = r11.next();
                long r1 = r0.getKey().longValue();
                AigcBackgroundImageGenerateTask r2 = r0.getValue();
                s r3 = this.a.a;
                Map<Long, com.bytedance.android.live.effect.sticker.presenter.g> r4 = r3.b;
                Long r5 = (Long) ((LinkedHashMap) r3.d).get(Long.valueOf(r1));
                if (r5 == null) goto L8;
                long r6 = r5.longValue();
            L9:
                com.bytedance.android.live.effect.sticker.presenter.g r7 = (com.bytedance.android.live.effect.sticker.presenter.g) ((LinkedHashMap) r4).get(Long.valueOf(r6));
                if (r7 == null) goto L25;
                Intrinsics.checkNotNullParameter(r2, "task");
                AigcBackgroundImageGenerateTask r8 = (AigcBackgroundImageGenerateTask) ((LinkedHashMap) r7.a).get(Long.valueOf(r1));
                if (r8 != null) goto L15;
                ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", "modify task not exist");
                goto L25
            L15:
                if (r2.getStatus() == LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L17;
            L23:
                ALogger.e("ttlive_anchor_effect_LiveEffectAigcTaskManager", "modify task must be finish and current task must be running, current is " + r8.getStatus() + " -> " + r2.getStatus());
                goto L25
            L17:
                if (r8.getStatus() != LiveEffectApi.AigcTaskStatus.RUNNING.getValue()) goto L23;
                ((ArrayList) r7.b).remove(Long.valueOf(r1));
                Iterator r12 = ((ArrayList) r7.c).iterator();
            L20:
                if (r12.hasNext() == false) goto L22;
                r7.a.remove(Long.valueOf(((Number) r12.next()).longValue()));
                goto L20
            L22:
                ((ArrayList) r7.c).clear();
                ((ArrayList) r7.c).add(Long.valueOf(r1));
                r7.a.put(Long.valueOf(r1), r2);
            L25:
                if (r2.getStatus() != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L27;
                s.b(this.a.a, r2);
                s r13 = this.a.a;
                r13.d.remove(Long.valueOf(r1));
                ((ArrayList) r13.e).remove(Long.valueOf(r1));
                r13.c();
            L27:
                List r14 = (List) ((LinkedHashMap) this.a.a.c).get(Long.valueOf(r1));
                if (r14 != null) goto L30;
                r14 = CollectionsKt.emptyList();
            L30:
                Iterator r15 = r14.iterator();
            L32:
                if (r15.hasNext() == false) goto L4;
                ((n0) r15.next()).a(r2);
                goto L32
            L8:
                r6 = 0;
                goto L9
            L34:
                s r16 = this.a.a;
                int r17 = s.q;
                r16.c();
                this.a.a.l();
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ e a;

            public b(e r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                s r4 = this.a.a;
                int r0 = s.q;
                r4.c();
                this.a.a.l();
            }
        }

        public e(s r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.f == false) goto L11;
            JsonArray r0 = new JsonArray();
            Iterator r1 = ((ArrayList) this.a.e).iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            r0.add(String.valueOf(((Number) r1.next()).longValue()));
            goto L6
        L8:
            String r2 = r0.toString();
            RxUtilKt.c(((LiveEffectApi) com.bytedance.android.live.network.c.b().e(LiveEffectApi.class)).checkAigcBackgroundImageGenerateTaskByTaskID(r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), new b(this)), this.a.a);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ Sticker a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public f(Sticker r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            List<String> r8 = com.bytedance.android.live.effect.utils.q.a;
            Sticker r9 = this.a;
            String r0 = this.b;
            String r1 = this.c;
            Intrinsics.checkNotNullParameter(r9, "sticker");
            Intrinsics.checkNotNullParameter(r0, "keyword");
            Intrinsics.checkNotNullParameter(r1, "eventPage");
            HashMap r2 = new HashMap();
            r2.put("sticker_id", String.valueOf(r9.getId()));
            r2.put("sticker_type", r9.getStickerType().getTypeName());
            com.bytedance.android.live.effect.sticker.k.k.getClass();
            r2.put("connect_type", com.bytedance.android.live.effect.sticker.k.a.b());
            r2.put("key_word", r0);
            com.bytedance.android.live.effect.utils.q.e("livesdk_live_take_ai_sticker_effective_use", r2, r1);
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public final void c() {
        if (((ArrayList) this.e).isEmpty() == false) goto L8;
        if (this.f == false) goto L11;
        this.f = false;
        return;
    L11:
        return;
    L8:
        if (this.f == true) goto L13;
        this.f = true;
        l();
        return;
    }

    public final void l() {
        MainThreadPostUtils.c(this.p, LiveEffectSettings.LIVE_EFFECT_POLLING_AIGC_TASK_INTERVAL.getValue().longValue());
    }

    public s() {
        this.a = new CompositeDisposable();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new ArrayList();
        this.g = new LinkedHashMap();
        this.h = LiveEffectSettings.LIVE_EFFECT_AIGC_TASK_BACKGROUND_IMAGE_TARGET_SIZE.getValue();
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        this.o = new c(this);
        this.p = new e(this);
    }

    public static String h(String r1) {
        String r2 = DigestUtils.md5Hex(r1);
        if (StringUtils.isEmpty(r2) == false) goto L6;
        r2 = "images";
    L6:
        return r2 + ".jpeg";
    }

    public final List<String> e(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "urlList");
        ArrayList r0 = new ArrayList();
        Iterator r5 = ((ArrayList) r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        String r1 = (String) r5.next();
        String r2 = (String) ((LinkedHashMap) this.i).get(r1);
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public final Map<Long, Map<Long, AigcBackgroundImageGenerateTask>> f(List<Long> r6) {
        Intrinsics.checkNotNullParameter(r6, "effectIDList");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Long> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        long r1 = r7.next().longValue();
        Long r3 = Long.valueOf(r1);
        Map<Long, com.bytedance.android.live.effect.sticker.presenter.g> r4 = this.b;
        LinkedHashMap r5 = (LinkedHashMap) r4;
        com.bytedance.android.live.effect.sticker.presenter.g r2 = (com.bytedance.android.live.effect.sticker.presenter.g) r5.get(Long.valueOf(r1));
        if (r2 == null) goto L9;
        Map<Long, AigcBackgroundImageGenerateTask> r8 = r2.a;
        if (r8 == null) goto L9;
    L10:
        r0.put(r3, r8);
    L9:
        r8 = MapsKt.emptyMap();
        goto L10
    L11:
        return r0;
    }

    public final boolean g(long r1) {
        Iterator<String> r2 = i(r1).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (k(r2.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public final List<String> i(long r3) {
        Map<Long, Map<Long, AigcBackgroundImageGenerateTask>> r0 = f(CollectionsKt.listOf(Long.valueOf(r3)));
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Map r4 = (Map) r1.get(Long.valueOf(r3));
        if (r4 == null) goto L8;
        Collection r5 = r4.values();
        if (r5 == null) goto L8;
        List r6 = CollectionsKt.toList(r5);
        if (r6 == null) goto L8;
    L9:
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L24;
        AigcBackgroundImageGenerateTask r8 = (AigcBackgroundImageGenerateTask) r7.next();
        if (r8.getStatus() != LiveEffectApi.AigcTaskStatus.FINISH.getValue()) goto L11;
        ArrayList r9 = new ArrayList();
        Iterator<ImageModel> r11 = r8.getImageList().iterator();
    L16:
        if (r11.hasNext() == false) goto L22;
        List<String> r2 = r11.next().getUrls();
        if (r2 == null) goto L16;
        String r12 = (String) CollectionsKt.firstOrNull(r2);
        if (r12 == null) goto L16;
        r9.add(r12);
        goto L16
    L22:
        return r9;
    L24:
        return CollectionsKt.emptyList();
    L8:
        r6 = CollectionsKt.emptyList();
        goto L9
    }

    public final void j(p r5) {
        if (this.k == false) goto L7;
        if (r5 == null) goto L9;
        r5.onSuccess();
        return;
    L9:
        return;
    L7:
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().d().k(com.bytedance.android.live.effect.api.d0.c, "aibackground", LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue().a(), new d(this, r5));
    }

    public final boolean k(String r4) {
        Intrinsics.checkNotNullParameter(r4, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((LinkedHashMap) this.i).get(r4) == null) goto L6;
        return true;
    L6:
        String r0 = new PolarisFileWrapper(n1.a(s1.getContext()), "pixel_loop_sticker") + '/' + h(r4);
        boolean r1 = new PolarisFileWrapper(r0).exists();
        if (r1 == false) goto L9;
        this.i.put(r4, r0);
    L9:
        return r1;
    }

    public static final void b(s r4, AigcBackgroundImageGenerateTask r5) {
        int r0 = r4.h.intValue() - r5.getImageList().size();
        if (r0 <= 0) goto L21;
        Map<Long, Sticker> r6 = r4.g;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        Sticker r8 = (Sticker) r7.get(Long.valueOf(r5.getEffectID()));
        if (r8 == null) goto L14;
        Sticker.AigcEffectInfo r9 = r8.getAigcEffectInfo();
        if (r9 == null) goto L14;
        Map r11 = r9.getKeywordInfoMap();
        if (r11 == null) goto L14;
        Sticker.AigcKeywordInfo r12 = (Sticker.AigcKeywordInfo) r11.get(r5.getKeyWord());
        if (r12 == null) goto L14;
        List r13 = r12.getDefaultUrlList();
        if (r13 == null) goto L14;
    L15:
        int r1 = 0;
    L16:
        if (r1 >= r0) goto L25;
        if (r1 >= r13.size()) goto L20;
        r5.getImageList().add(ImageModel.genBy((String) ListProtector.get(r13, r1)));
    L20:
        r1 = r1 + 1;
        goto L16
    L25:
        return;
    L14:
        r13 = CollectionsKt.emptyList();
        goto L15
    }

    public final void d(List<String> r12, k r13) {
        Intrinsics.checkNotNullParameter(r12, "urls");
        Ref.IntRef r0 = new Ref.IntRef();
        r0.element = 0;
        ArrayList r2 = new ArrayList();
        ArrayList r3 = (ArrayList) r12;
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L22;
        String r5 = (String) r4.next();
        String r6 = (String) ((LinkedHashMap) this.i).get(r5);
        if (r6 != null) goto L7;
        b r7 = new b(r2, r0, r12, r13);
        if (r5 == null) goto L4;
        PolarisFileWrapper r9 = new PolarisFileWrapper(n1.a(s1.getContext()), "pixel_loop_sticker");
        String r8 = h(r5);
        if (k(r5) == true) goto L15;
        if (this.j.containsKey(r5) == true) goto L18;
        this.j.put(r5, CollectionsKt.mutableListOf(new l[]{r7}));
        DownloadTask r11 = Downloader.with(s1.getContext()).url(r5).name(r8).savePath(r9.getPath()).monitorScene("live_pixel_loop_sticker");
        r11.addDownloadListener(this.o.hashCode(), this.o, ListenerType.MAIN, false);
        r11.download();
        goto L4
    L18:
        List r14 = (List) ((LinkedHashMap) this.j).get(r5);
        if (r14 == null) goto L4;
        r14.add(r7);
        goto L4
    L15:
        String r15 = r9 + '/' + r8;
        this.i.put(r5, r15);
        r7.a(r15);
        goto L4
    L7:
        r2.add(r6);
        int r16 = r0.element + 1;
        r0.element = r16;
        if (r16 != r3.size()) goto L4;
        r13.a(r2);
        goto L4
    }

    public static final void a(s r2, long r3, long r5) {
        List<Long> r0 = r2.e;
        ArrayList r1 = (ArrayList) r0;
        if (r1.contains(Long.valueOf(r5)) == true) goto L7;
        r2.d.put(Long.valueOf(r5), Long.valueOf(r3));
        List<Long> r4 = r2.e;
        ArrayList r6 = (ArrayList) r4;
        r6.add(Long.valueOf(r5));
        r2.c();
        return;
    }

    public final void m(Sticker r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "sticker");
        Intrinsics.checkNotNullParameter(r8, "keyWord");
        Intrinsics.checkNotNullParameter(r9, "eventPage");
        long r0 = r7.getId();
        this.m.put(Long.valueOf(r0), Long.valueOf(SystemClock.elapsedRealtime()));
        this.n.put(Long.valueOf(r0), r8);
        Disposable r1 = this.l;
        if (r1 != null) goto L5;
    L9:
        this.l = Observable.timer(LiveEffectSettings.LIVE_FACE_STICKER_EFFECTIVELY_USE_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(r7, r8, r9), g.a);
        return;
    L5:
        if (r1.isDisposed() == true) goto L9;
        Disposable r2 = this.l;
        if (r2 == null) goto L9;
        r2.dispose();
        goto L9
    }
}
