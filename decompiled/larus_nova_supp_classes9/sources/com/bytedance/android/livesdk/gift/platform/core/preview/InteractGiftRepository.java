package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p0;
import com.bytedance.android.livesdk.gift.model.q0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonParseException;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractGiftRepository {
    public List<com.bytedance.android.livesdk.gift.platform.core.preview.b> a;
    public List<com.bytedance.android.livesdk.gift.platform.core.preview.b> b;
    public List<Long> c;
    public List<Long> d;
    public final CompositeDisposable e;
    public final RequestTimer f;
    public int g;
    public int h;
    public final int i;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ Observable a;

        public a(Observable r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((ExtraResponse) r2, "it");
            return this.a;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractGiftRepository a;
        public final /* synthetic */ Function0 b;

        public b(InteractGiftRepository r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            ExtraResponse r6 = (ExtraResponse) r5;
            InteractGiftRepository r0 = this.a;
            List<h1> r1 = ((q0) r6.data).b();
            if (r1 == null) goto L8;
            List<h1> r2 = r1;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r4 = r2.iterator();
        L6:
            if (r4.hasNext() == false) goto L9;
            r3.add(g.a((h1) r4.next()));
        L9:
            r0.a = r3;
            InteractGiftRepository r7 = this.a;
            List<Long> r8 = ((q0) r6.data).d();
            if (r8 != null) goto L12;
            r8 = new ArrayList();
        L12:
            r7.c = r8;
            InteractGiftRepository r9 = this.a;
            List<Long> r10 = ((q0) r6.data).a();
            if (r10 != null) goto L15;
            r10 = new ArrayList();
        L15:
            r9.d = r10;
            InteractGiftRepository r11 = this.a;
            r11.a = InteractGiftRepository.a(r11, r11.c, r11.a);
            this.b.invoke();
            return;
        L8:
            r3 = new ArrayList();
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ApiServerException r3 = (Throwable) r2;
            if ((r3 instanceof ApiServerException) == false) goto L6;
            int r0 = ToastUtil.a;
            ToastUtil.b(r3.getPrompt(), 0);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ InteractGiftRepository a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Function2 c;
        public final /* synthetic */ int d;

        public d(InteractGiftRepository r1, int r2, Function2 r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            InteractGiftRepository r0 = this.a;
            List<h1> r1 = ((q0) r7.data).b();
            if (r1 == null) goto L8;
            List<h1> r2 = r1;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r4 = r2.iterator();
        L6:
            if (r4.hasNext() == false) goto L9;
            r3.add(g.a((h1) r4.next()));
        L9:
            r0.a = r3;
            InteractGiftRepository r5 = this.a;
            List<h1> r8 = ((q0) r7.data).c();
            if (r8 == null) goto L15;
            List<h1> r9 = r8;
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator<T> r11 = r9.iterator();
        L13:
            if (r11.hasNext() == false) goto L16;
            r10.add(g.a((h1) r11.next()));
        L16:
            r5.b = r10;
            InteractGiftRepository r13 = this.a;
            List<Long> r14 = ((q0) r7.data).d();
            if (r14 != null) goto L19;
            r14 = new ArrayList();
        L19:
            r13.c = r14;
            InteractGiftRepository r15 = this.a;
            List<Long> r16 = ((q0) r7.data).a();
            if (r16 != null) goto L22;
            r16 = new ArrayList();
        L22:
            r15.d = r16;
            InteractGiftRepository r17 = this.a;
            r17.a = InteractGiftRepository.a(r17, r17.c, r17.a);
            InteractGiftRepository r18 = this.a;
            r18.g = this.b + 1;
            this.c.invoke(r18.a, r18.b);
            if (this.d != 1) goto L33;
            List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r19 = this.a.b;
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
            Iterator<T> r21 = r19.iterator();
        L26:
            if (r21.hasNext() == false) goto L28;
            r20.add(Long.valueOf(((com.bytedance.android.livesdk.gift.platform.core.preview.b) r21.next()).b));
            goto L26
        L28:
            ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).ji(7, true, r20, "fetchUGCGiftList");
            return;
        L33:
            return;
        L15:
            r10 = new ArrayList();
            goto L16
        L8:
            r3 = new ArrayList();
            goto L9
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            ApiServerException r3 = (Throwable) r2;
            if ((r3 instanceof ApiServerException) == false) goto L6;
            int r0 = ToastUtil.a;
            ToastUtil.b(r3.getPrompt(), 0);
            return;
        }
    }

    public InteractGiftRepository() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new CompositeDisposable();
        this.f = new RequestTimer();
        this.g = 1;
        this.h = 1;
        this.i = ((Number) com.bytedance.android.livesdk.gift.platform.business.a.x.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[22])).intValue();
    }

    public final void d(int r3, final Function2<? super List<com.bytedance.android.livesdk.gift.platform.core.preview.b>, ? super List<com.bytedance.android.livesdk.gift.platform.core.preview.b>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        int r0 = this.g;
        if (r0 > 1) goto L5;
        return;
    L5:
        if (this.h == r0) goto L9;
        this.h = r0;
        e(r3, r0, new InteractGiftRepository$fetchMore$1(this, r4));
        return;
    }

    public static final List a(InteractGiftRepository r8, List r9, List r10) {
        r8.getClass();
        ArrayList r11 = new ArrayList();
        Iterator r13 = r9.iterator();
    L4:
        if (r13.hasNext() == false) goto L18;
        long r2 = ((Number) r13.next()).longValue();
        Iterator r0 = r10.iterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        Object r4 = r0.next();
        if (((com.bytedance.android.livesdk.gift.platform.core.preview.b) r4).a != r2) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L7;
    L15:
        com.bytedance.android.livesdk.gift.platform.core.preview.b r6 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) r4;
        if (r6 == null) goto L4;
        r11.add(r6);
        goto L4
    L11:
        r5 = false;
        goto L12
    L14:
        r4 = null;
        goto L15
    L18:
        List r14 = CollectionsKt.toMutableList(r11);
        Intrinsics.checkNotNullParameter(r14, "$this$unionWithSort");
        Intrinsics.checkNotNullParameter(r10, "other");
        ArrayList r15 = new ArrayList();
        r15.addAll(r14);
        ArrayList r1 = new ArrayList();
        Iterator r16 = r10.iterator();
    L20:
        if (r16.hasNext() == false) goto L24;
        Object r3 = r16.next();
        if ((!r14.contains(r3)) == false) goto L20;
        r1.add(r3);
        goto L20
    L24:
        r15.addAll(r1);
        return r15;
    }

    public final void e(int r11, int r13, Function2<? super List<com.bytedance.android.livesdk.gift.platform.core.preview.b>, ? super List<com.bytedance.android.livesdk.gift.platform.core.preview.b>, Unit> r14) {
        Intrinsics.checkNotNullParameter(r14, "callback");
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("page", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("page", r3);
    L5:
        Integer r4 = 1;
        String r5 = r4.toString();
        Intrinsics.checkNotNullParameter("fetch_from", "$this$setTo");
        if (r5 == null) goto L8;
        r2.put("fetch_from", r5);
    L8:
        String r6 = Integer.valueOf(this.i).toString();
        Intrinsics.checkNotNullParameter("count", "$this$setTo");
        if (r6 == null) goto L11;
        r2.put("count", r6);
    L11:
        Integer r7 = 0;
        String r8 = r7.toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L14;
        r2.put("room_id", r8);
    L14:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.h(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/ugc/pool/", TypesJVMKt.getJavaType(Reflection.typeOf(q0.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c)).subscribe(new d(this, r13, r14, r11), e.a), this.e);
    }

    public final void b(List<Long> r26, List<Long> r27, int r28, Function0<Unit> r29) {
        String r2 = GsonProtectorUtils.toJson(GsonHelper.get(), r26);     // Catch: JsonParseException -> L5
    L32:
        String r3 = GsonProtectorUtils.toJson(GsonHelper.get(), r27);     // Catch: JsonParseException -> L8
    L9:
        tz0.b r4 = tz0.b.a;
        uz0.e r5 = new uz0.e();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$beforeConfigureRequest");
        Map r6 = r5.e;
        Intrinsics.checkNotNullParameter(r6, "fieldsMap");
        String r8 = Integer.valueOf(r28).toString();
        Intrinsics.checkNotNullParameter("fetch_from", "$this$setTo");
        if (r8 == null) goto L12;
        r6.put("fetch_from", r8);
    L12:
        Intrinsics.checkNotNullParameter("gift_ids", "$this$setTo");
        r6.put("gift_ids", BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter("top_gift_ids", "$this$setTo");
        if (r2 == null) goto L15;
        r6.put("top_gift_ids", r2);
    L15:
        Intrinsics.checkNotNullParameter("dislike_gift_ids", "$this$setTo");
        if (r3 == null) goto L18;
        r6.put("dislike_gift_ids", r3);
    L18:
        Intrinsics.checkNotNullParameter(r5, "$this$afterConfigureRequest");
        INetworkService r7 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class);
        INetworkService.Biz r17 = INetworkService.Biz.Revenue;
        Observable r9 = RxUtilKt.h(r7.L4(r17, "/webcast/gift/ugc/change/", TypesJVMKt.getJavaType(Reflection.typeOf(p0.class)), Extra.class, ((uz0.a) r5).d, ((uz0.a) r5).a, ((uz0.a) r5).b, ((uz0.a) r5).c, r5.e, r5.f, r5.g));
        uz0.c r10 = new uz0.c();
        Intrinsics.checkNotNullParameter(r10, "$this$beforeConfigureRequest");
        Map r11 = ((uz0.a) r10).b;
        Intrinsics.checkNotNullParameter(r11, "queriesMap");
        Integer r13 = 0;
        String r14 = r13.toString();
        Intrinsics.checkNotNullParameter("page", "$this$setTo");
        if (r14 == null) goto L21;
        r11.put("page", r14);
    L21:
        Integer r15 = 1;
        String r16 = r15.toString();
        Intrinsics.checkNotNullParameter("fetch_from", "$this$setTo");
        if (r16 == null) goto L24;
        r11.put("fetch_from", r16);
    L24:
        Integer r18 = 0;
        String r19 = r18.toString();
        Intrinsics.checkNotNullParameter("count", "$this$setTo");
        if (r19 == null) goto L27;
        r11.put("count", r19);
    L27:
        Integer r20 = 0;
        String r21 = r20.toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r21 == null) goto L30;
        r11.put("room_id", r21);
    L30:
        Intrinsics.checkNotNullParameter(r10, "$this$afterConfigureRequest");
        RxUtilKt.c(r9.flatMap(new a(RxUtilKt.h(com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(r17, "/webcast/gift/ugc/pool/", TypesJVMKt.getJavaType(Reflection.typeOf(q0.class)), Extra.class, ((uz0.a) r10).d, ((uz0.a) r10).a, ((uz0.a) r10).b, ((uz0.a) r10).c)))).subscribe(new b(this, r29), c.a), this.e);
        return;
    L8:
        r3 = BuildConfig.FLAVOR;
    L5:
        r2 = BuildConfig.FLAVOR;
        goto L32
    }

    public final void c(List<Long> r7, List<Long> r8, int r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "topGiftIds");
        Intrinsics.checkNotNullParameter(r8, "dislikeGiftIds");
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.a.u.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[19])).booleanValue() == false) goto L14;
        Disposable r3 = this.f.a;
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        RequestTimer r5 = this.f;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "topGiftIds");
        Intrinsics.checkNotNullParameter(r8, "dislikeGiftIds");
        Intrinsics.checkNotNullParameter(r10, "callback");
        r5.c = r7;
        r5.d = r8;
        r5.e = r9;
        r5.f = r10;
        RequestTimer r11 = this.f;
        Function4<List<? extends Long>, List<? extends Long>, Integer, Function0<? extends Unit>, Unit> r13 = new InteractGiftRepository$changeUGCGiftList$1(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "request");
        r11.a = Observable.timer(r11.b, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r11, r13));
        return;
    L13:
        RequestTimer r6 = this.f;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "topGiftIds");
        Intrinsics.checkNotNullParameter(r8, "dislikeGiftIds");
        Intrinsics.checkNotNullParameter(r10, "callback");
        r6.c = r7;
        r6.d = r8;
        r6.e = r9;
        r6.f = r10;
        return;
    L7:
        if (r3.isDisposed() == true) goto L10;
        r4 = false;
        goto L11
    L14:
        b(r7, r8, r9, r10);
    }
}
