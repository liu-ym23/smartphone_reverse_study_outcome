package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class TuningEffectAbility {
    public final List<com.bytedance.android.live.ktv.common.model.bean.h> a;
    public Disposable b;
    public Disposable c;
    public final Lazy d;
    public DownloadTask e;
    public Integer f;
    public b g;
    public final String h;

    public static final class a {
    }

    public static final class b extends AbsDownloadListener {
        public final SingleEmitter<String> a;
        public final String b;

        public final void onSuccessed(DownloadInfo r2) {
            super.onSuccessed(r2);
            this.a.onSuccess(this.b);
        }

        public b(SingleEmitter<String> r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "emitter");
            Intrinsics.checkNotNullParameter(r3, "filePath");
            this.a = r2;
            this.b = r3;
        }

        public final void onFailed(DownloadInfo r1, BaseException r2) {
            super.onFailed(r1, r2);
            f2.b(2131918633, 0);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TuningEffectAbility a;
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.h b;

        public c(TuningEffectAbility r1, com.bytedance.android.live.ktv.common.model.bean.h r2, boolean r3) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.h(this.b);
            Disposable r4 = this.a.b;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.isDisposed() == true) goto L9;
            r4.dispose();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e<T> implements SingleOnSubscribe {
        public final /* synthetic */ TuningEffectAbility a;
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.h b;

        public e(TuningEffectAbility r1, com.bytedance.android.live.ktv.common.model.bean.h r2) {
            this.a = r1;
            this.b = r2;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
        }

        public final void subscribe(SingleEmitter<String> r18) {
            Intrinsics.checkNotNullParameter(r18, "it");
            TuningEffectAbility r0 = this.a;
            com.bytedance.android.live.ktv.common.model.bean.h r3 = this.b;
            r0.getClass();
            StringBuilder r4 = new StringBuilder(r0.h);
            r4.append(r3.d());
            String r1 = File.separator;
            r4.append(r1);
            r4.append(r3.d());
            r4.append("_version_");
            r4.append(r3.f());
            r4.append(".json");
            String r5 = r4.toString();
            if (new PolarisFileWrapper(r5).exists() == false) goto L5;
            r18.onSuccess(r5);
            return;
        L5:
            this.a.getClass();
            FileUtils.removeDir(new PolarisFileWrapper(r5));
            TuningEffectAbility r6 = this.a;
            r6.e = null;
            Integer r7 = r6.f;
            if (r7 == null) goto L8;
            Downloader.getInstance(s1.getContext()).cancel(r7.intValue());
        L8:
            TuningEffectAbility r8 = this.a;
            com.bytedance.android.live.ktv.common.model.bean.h r9 = this.b;
            r8.getClass();
            List<String> r11 = r9.b().getUrls();
            if (CollectionsKt.getLastIndex(r11) < 0) goto L11;
            Object r12 = ListProtector.get(r11, 0);
        L12:
            TuningEffectAbility r13 = this.a;
            DownloadTask r14 = Downloader.with(s1.getContext()).url((String) r12);
            this.a.getClass();
            int r15 = StringsKt.lastIndexOf$default(r5, "/", 0, false, 6, null);
            if (r15 == (-1)) goto L18;
            if (r5 == null) goto L17;
            String r16 = r5.substring(r15);
        L19:
            DownloadTask r17 = r14.name(r16);
            TuningEffectAbility r19 = this.a;
            r19.getClass();
            int r21 = StringsKt.lastIndexOf$default(r5, "/", 0, false, 6, null);
            if (r21 == (-1)) goto L25;
            if (r5 == null) goto L24;
            String r2 = r5.substring(0, r21);
        L26:
            r13.e = r17.savePath(r2).monitorScene("musicpack_tuningeffect");
            DownloadTask r22 = this.a.e;
            if (r22 == null) goto L42;
            r22.autoRemoveCallback(true);
        L42:
            Class r23 = a();     // Catch: Exception -> L31
            Object r24 = r23.newInstance();     // Catch: Exception -> L31
            Method r25 = r23.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L31
            r25.setAccessible(true);     // Catch: Exception -> L31
            r25.invoke(r24, new Object[]{1209600});     // Catch: Exception -> L31
        L33:
            this.a.g = new b(r18, r5);
            TuningEffectAbility r26 = this.a;
            DownloadTask r27 = r26.e;
            if (r27 == null) goto L36;
            r27.mainThreadListener(r26.g);
        L36:
            TuningEffectAbility r28 = this.a;
            DownloadTask r29 = r28.e;
            if (r29 == null) goto L39;
            Integer r110 = Integer.valueOf(r29.download());
        L40:
            r28.f = r110;
            return;
        L39:
            r110 = null;
        L31:
            e = move-exception;
            String r31 = "set cache life time max fail : " + e.getMessage();
            ALogger.i(bb0.b.b(), r31 + ", invoke class :" + TuningEffectAbility.class.getSimpleName());
            goto L33
        L24:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L25:
            r2 = r19.h + "none" + r1;
            goto L26
        L17:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L18:
            r16 = "none.json";
            goto L19
        L11:
            r12 = "";
            goto L12
        }
    }

    public static final class f<T> implements FlowableOnSubscribe {
        public final /* synthetic */ TuningEffectAbility a;

        public f(TuningEffectAbility r1) {
            this.a = r1;
        }

        public final void subscribe(FlowableEmitter<List<com.bytedance.android.live.ktv.common.model.bean.h>> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            List r0 = (List) com.bytedance.android.livesdk.sharedpref.c.m.getValue();
            ((CopyOnWriteArrayList) this.a.a).clear();
            Iterator<T> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            String r2 = (String) r1.next();
            com.bytedance.android.live.ktv.common.model.bean.h r3 = (com.bytedance.android.live.ktv.common.model.bean.h) GsonProtectorUtils.fromJson(new Gson(), r2, com.bytedance.android.live.ktv.common.model.bean.h.class);
            r3.a = false;
            ((CopyOnWriteArrayList) this.a.a).add(r3);
            goto L4
        L6:
            r5.onNext(this.a.a);
            r5.onComplete();
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ TuningEffectAbility a;
        public final /* synthetic */ cc0.b b;

        public g(TuningEffectAbility r1, cc0.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            List<com.bytedance.android.live.ktv.common.model.bean.h> r3 = (List) r2;
            this.a.getClass();
            TuningEffectAbility.f(r3);
            this.b.onLocalTuningEffectsSuccess(r3);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ TuningEffectAbility a;
        public final /* synthetic */ cc0.b b;

        public h(TuningEffectAbility r1, cc0.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            TuningEffectAbility.f(this.a.a);
            this.b.onLocalTuningEffectsFailed();
            pb0.a r0 = pb0.b.a;
            pb0.b.b("TuningEffectAbility", (Throwable) r2);
        }
    }

    static {
    }

    public void h(com.bytedance.android.live.ktv.common.model.bean.h r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
    }

    public final com.bytedance.android.live.ktv.common.model.bean.h c() {
        Iterator r0 = ((CopyOnWriteArrayList) this.a).iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.ktv.common.model.bean.h) r1).d(), e()) == false) goto L3;
    L9:
        com.bytedance.android.live.ktv.common.model.bean.h r3 = (com.bytedance.android.live.ktv.common.model.bean.h) r1;
        if (r3 != null) goto L18;
        Iterator r4 = ((CopyOnWriteArrayList) this.a).iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((com.bytedance.android.live.ktv.common.model.bean.h) r5).d(), d()) == false) goto L13;
        r2 = r5;
    L17:
        r3 = (com.bytedance.android.live.ktv.common.model.bean.h) r2;
    L18:
        if (r3 == null) goto L20;
        return r3;
    L20:
        return (com.bytedance.android.live.ktv.common.model.bean.h) CollectionsKt.getOrNull(this.a, 0);
    L8:
        r1 = null;
        goto L9
    }

    public String d() {
        return (String) com.bytedance.android.livesdk.sharedpref.c.r0.getValue();
    }

    public String e() {
        return (String) com.bytedance.android.livesdk.sharedpref.c.e.getValue();
    }

    public TuningEffectAbility() {
        this.a = new CopyOnWriteArrayList();
        this.d = LazyKt.lazy(TuningEffectAbility$compositeDisposable$2.INSTANCE);
        StringBuilder r0 = new StringBuilder(KtvCommonConfigParams.a());
        String r1 = File.separator;
        r0.append(r1);
        r0.append("ktv_tunings");
        r0.append(r1);
        this.h = r0.toString();
    }

    public static void f(List r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        if (r9.isEmpty() == false) goto L5;
    L6:
        ListProtector.add(r9, 0, new com.bytedance.android.live.ktv.common.model.bean.h("none", "原声", qy.a.c(), qy.a.c(), 1, false));
        return;
    L5:
        if (((com.bytedance.android.live.ktv.common.model.bean.h) ListProtector.get(r9, 0)).g() == false) goto L6;
    }

    public final Disposable g(cc0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "loadTuningEffectCallback");
        return Flowable.create(new f(this), BackpressureStrategy.BUFFER).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r4), new h(this, r4));
    }

    public void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.r0;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
    }

    public void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.e;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
    }

    public final Disposable k(final cc0.b r6) {
        int r0 = dc0.a.a;
        dc0.a r1 = dc0.a.b.a;
        long r2 = System.currentTimeMillis();
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.bean.c>, Unit> r3 = new TuningEffectAbility$syncTuningEffects$1(this, r6);
        Function1<Throwable, Unit> r4 = new TuningEffectAbility$syncTuningEffects$2(this, r6);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "successCallback");
        Intrinsics.checkNotNullParameter(r4, "failCallback");
        return ((KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class)).getTuningInfoList().compose(RxUtil.rxSchedulerHelper()).subscribe(new dc0.b(r2, r3), new dc0.c(r2, r4));
    }

    public final void a(com.bytedance.android.live.ktv.common.model.bean.h r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "target");
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        this.b = Observable.timer(30, TimeUnit.SECONDS).subscribe(new c(this, r4, r5), d.a);
        if (r5 == false) goto L11;
        ALogger.d("TuningEffectAbility", "update ktv user manual selected : " + r4.d());
        j(r4.d());
        return;
    L11:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void b(com.bytedance.android.live.ktv.common.model.bean.h r3, cc0.c r4) {
        Intrinsics.checkNotNullParameter(r3, "tuningEffectItem");
        Intrinsics.checkNotNullParameter(r4, "tuningEffectDownloadCallback");
        if (r3.g() == false) goto L6;
        r4.a("");
        return;
    L6:
        Disposable r0 = this.c;
        if (r0 == null) goto L9;
        ((CompositeDisposable) this.d.getValue()).remove(r0);
    L9:
        Single r5 = Single.create(new e(this, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final TuningEffectAbility$downLoadTuningEffect$3 r1 = new TuningEffectAbility$downLoadTuningEffect$3(r4);
        Disposable r6 = r5.subscribe(new i(r1));
        if (r6 == null) goto L12;
        RxUtilKt.c(r6, (CompositeDisposable) this.d.getValue());
    L13:
        this.c = r6;
        return;
    L12:
        r6 = null;
        goto L13
    }
}
