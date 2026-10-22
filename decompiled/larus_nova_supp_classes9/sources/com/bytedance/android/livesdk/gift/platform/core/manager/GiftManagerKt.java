package com.bytedance.android.livesdk.gift.platform.core.manager;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.rxutils.CommonTransformer;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.configmodel.m0;
import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.download.TTDownloadException;
import com.bytedance.android.livesdk.gift.platform.core.model.e0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.Md5InvalidException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.NetworkException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.UnzipException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.WriteStorageException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftManagerKt {
    public static h1 a;
    public static py.k b;
    public static final HashMap<Long, h1> c = null;
    public static final HashMap<Long, e0> d = null;
    public static boolean e;
    public static final HashMap<String, Long> f = null;
    public static wwc.c g;
    public static com.bytedance.android.livesdk.gift.platform.core.model.g h;
    public static final HashSet<Integer> i = null;
    public static boolean j;
    public static final Lazy k = null;
    public static final g l = null;
    public static final Gson m = null;
    public static final Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i> n = null;
    public static final Map<Long, com.bytedance.android.livesdk.gift.platform.core.model.i> o = null;
    public static com.bytedance.android.livesdk.gift.platform.core.model.i p;
    public static final LongSparseArray<h1> q = null;
    public static final SparseArray<LongSparseArray<h1>> r = null;
    public static final List<com.bytedance.android.livesdk.gift.platform.core.model.h> s = null;
    public static final List<com.bytedance.android.livesdk.gift.platform.core.model.e> t = null;
    public static com.bytedance.android.livesdk.gift.platform.core.model.i u;
    public static final LongSparseArray<h1> v = null;
    public static com.bytedance.android.livesdk.gift.platform.core.model.i w;
    public static final LongSparseArray<h1> x = null;
    public static h1 y;
    public static final GiftManagerKt z = null;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r2, Object r3) {
            com.bytedance.android.livesdk.gift.platform.core.model.e r4 = (com.bytedance.android.livesdk.gift.platform.core.model.e) r2;
            com.bytedance.android.livesdk.gift.platform.core.model.e r5 = (com.bytedance.android.livesdk.gift.platform.core.model.e) r3;
            Intrinsics.checkNotNullParameter(r4, "o1");
            Intrinsics.checkNotNullParameter(r5, "o2");
            return r4.comboCount - r5.comboCount;
        }
    }

    public static final class b<T> implements FlowableOnSubscribe {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void subscribe(FlowableEmitter<Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i>> r7) {
            Intrinsics.checkNotNullParameter(r7, "emitter");
            HashSet<String> r0 = ay1.b.k();
            HashMap r1 = new HashMap(4);
            Iterator<String> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L12;
            int r3 = CastIntegerProtector.parseInt(r2.next());
            GiftManagerKt.z.getClass();
            String r4 = (String) GiftManagerKt.w(r3).getValue();
            if (StringUtils.isEmpty(r4) == true) goto L4;
            com.bytedance.android.livesdk.gift.platform.core.model.i r5 = (com.bytedance.android.livesdk.gift.platform.core.model.i) GsonProtectorUtils.fromJson(GiftManagerKt.m, r4, com.bytedance.android.livesdk.gift.platform.core.model.i.class);
            if (r5 == null) goto L4;
            r1.put(Integer.valueOf(r3), r5);
            goto L4
        L12:
            r7.onNext(r1);
            r7.onComplete();
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
            Map r3 = (Map) r2;
            if (nz1.a.a() == false) goto L5;
            Single.create(new j(r3)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L5:
            GiftManagerKt.b(GiftManagerKt.z, r3);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "error");
            Logger.e("GIFT_MANAGER", r3.getMessage());
        }
    }

    public static final class e implements Action {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void run() {
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r2) {
            wwc.c r3 = (wwc.c) r2;
            Intrinsics.checkNotNullParameter(r3, "subscription");
            GiftManagerKt.g = r3;
        }
    }

    public static final class g implements com.bytedance.kmp.livesdk.gift.platform.resourcemanager.b {
        public g() {
        }

        public final void b(BaseGetResourceException r13) {
            Intrinsics.checkNotNullParameter(r13, "t");
            JSONObject r1 = new JSONObject();     // Catch: JSONException -> L33
            int r4 = -1;
            if ((r13 instanceof NetworkException) == false) goto L7;
            r1.put("response_code", ((NetworkException) r13).getErrorCode());     // Catch: JSONException -> L33
            int r2 = 1;
        L19:
            long r6 = -1;
            if (r13.getResourceRequest() == null) goto L22;
            long r8 = r13.getResourceRequest().l;     // Catch: JSONException -> L33
        L23:
            GiftManagerKt.z.getClass();     // Catch: JSONException -> L33
            com.bytedance.android.live.core.resources.e r5 = GiftManagerKt.v().G1(r13.getId());     // Catch: JSONException -> L33
            if (r5 == null) goto L26;
            r4 = r5.getResourceType();     // Catch: JSONException -> L33
            r6 = r5.getSize();     // Catch: JSONException -> L33
        L26:
            r1.put("gift_id", r13.getId());     // Catch: JSONException -> L33
            r1.put("gift_type", r4);     // Catch: JSONException -> L33
            r1.put("size", r6);     // Catch: JSONException -> L33
            r1.put("error_code", r2);     // Catch: JSONException -> L33
            r1.put("error_desc", r13.toString());     // Catch: JSONException -> L33
            r1.put("download_assets_from", r8);     // Catch: JSONException -> L33
            LiveSlardarMonitor.monitorStatusAndDuration("hotsoon_live_gift_resource_download_rate", 1, new JSONObject(), r1);     // Catch: JSONException -> L33
            HashMap r7 = new HashMap(1);     // Catch: JSONException -> L33
            r7.put("info", r1.toString());     // Catch: JSONException -> L33
            mz0.n r3 = new mz0.n();     // Catch: JSONException -> L33
            Map r9 = r3.a;     // Catch: JSONException -> L33
            Intrinsics.checkNotNullParameter(r9, "map");     // Catch: JSONException -> L33
            Intrinsics.checkNotNullParameter(r7, "map");     // Catch: JSONException -> L33
            r9.putAll(r7);     // Catch: JSONException -> L33
            cy0.e.a.getClass();     // Catch: JSONException -> L33
            cy0.j r0 = cy0.e.a.a;     // Catch: JSONException -> L33
            com.bytedance.android.scope.m.e.getClass();     // Catch: JSONException -> L33
            Object r10 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(mz0.i.class));     // Catch: JSONException -> L33
            Intrinsics.checkNotNull(r10);     // Catch: JSONException -> L33
            ((f80.a) r10).w3("hotsoon_live_gift_resource_download_failed", r3.a, r3.b);     // Catch: JSONException -> L33
            if ((r13 instanceof TTDownloadException) == false) goto L30;
            r2 = ((TTDownloadException) r13).getErrorCode();     // Catch: JSONException -> L33
        L30:
            if (r4 != 8) goto L38;
            b12.b.a(Long.valueOf(r13.getId()), Long.valueOf(r8), Integer.valueOf(r2), r13.toString());     // Catch: JSONException -> L33
            return;
        L38:
            return;
        L22:
            r8 = -1;
            goto L23
        L7:
            if ((r13 instanceof WriteStorageException) == false) goto L10;
            r2 = 2;
            goto L19
        L10:
            if ((r13 instanceof Md5InvalidException) == false) goto L13;
            r2 = 3;
            goto L19
        L13:
            if ((r13 instanceof UnzipException) == false) goto L16;
            r2 = 4;
            goto L19
        L16:
            if ((r13 instanceof TTDownloadException) == false) goto L18;
            r1.put("downloader_error_code", ((TTDownloadException) r13).getErrorCode());     // Catch: JSONException -> L33
            r2 = 5;
            goto L19
        L18:
            r2 = -1;
        L33:
            e = move-exception;
            Logger.e(e.toString());
        }

        public final void c(long r13, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r14) {
            JSONObject r1 = new JSONObject();
            long r2 = r14.l;
            GiftManagerKt.z.getClass();
            com.bytedance.android.live.core.resources.e r4 = GiftManagerKt.v().G1(r13);
            if (r4 == null) goto L5;
            int r5 = r4.getResourceType();
            long r6 = r4.getSize();
        L39:
            r1.put("gift_id", r13);     // Catch: JSONException -> L8
            r1.put("gift_type", r5);     // Catch: JSONException -> L8
            r1.put("size", r6);     // Catch: JSONException -> L8
            r1.put("download_assets_from", r2);     // Catch: JSONException -> L8
        L10:
            LiveSlardarMonitor.monitorStatusAndDuration("hotsoon_live_gift_resource_download_rate", 0, new JSONObject(), r1);
            xs2.b.a().post(new ay1.c());
            HashMap r3 = new HashMap(1);
            r3.put("resource_id", String.valueOf(r13));
            mz0.n r7 = new mz0.n();
            Map r8 = r7.a;
            Intrinsics.checkNotNullParameter(r8, "map");
            Intrinsics.checkNotNullParameter(r3, "map");
            r8.putAll(r3);
            cy0.e.a.getClass();
            cy0.j r9 = cy0.e.a.a;
            com.bytedance.android.scope.m r10 = com.bytedance.android.scope.m.e;
            r10.getClass();
            Object r11 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r11);
            ((f80.a) r11).w3("hotsoon_live_gift_resource_download_success", r7.a, r7.b);
            if (r5 != 8) goto L20;
            Long r15 = Long.valueOf(r13);
            Long r16 = Long.valueOf(r2);
            int r17 = b12.b.a;
            JSONObject r18 = new JSONObject();
            long r19 = 0;
            if (r15 == null) goto L15;
            long r20 = r15.longValue();
        L16:
            j01.d.b(r18, "asset_id", Long.valueOf(r20));
            if (r16 == null) goto L19;
            r19 = r16.longValue();
        L19:
            j01.d.b(r18, "download_assets_from", Long.valueOf(r19));
            Intrinsics.checkNotNullParameter("ttlive_download_befview_resource_status", "name");
            b12.b.b(z.a("ttlive_download_befview_resource_status"), r18, 0);
            goto L20
        L15:
            r20 = 0;
        L20:
            i12.e r110 = i12.o.b();
            if (r110 == null) goto L23;
            Object r111 = r10.d(r110, com.bytedance.android.livesdk.gift.platform.core.scope.service.d.class);
        L24:
            com.bytedance.android.livesdk.gift.platform.core.scope.service.d r112 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.d) r111;
            if (r112 != null) goto L27;
            return;
        L27:
            if (com.bytedance.android.livesdk.gift.platform.business.effect.a.c().isEmpty() == true) goto L43;
            com.bytedance.android.live.core.resources.e r113 = r112.b.G1(r14.i);
            if (r113 == null) goto L44;
            com.bytedance.android.live.core.resources.b r0 = r113.getCleanStrategy();
            if (r0 != null) goto L35;
            return;
        L35:
            if (r0.getCleanType() != 1) goto L45;
            Single.create(new com.bytedance.android.livesdk.gift.platform.core.scope.service.g(r112, r113, r14)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L23:
            r111 = null;
        L8:
            e = move-exception;
            Logger.e(e.toString());
            goto L10
        L5:
            r6 = -1;
            r5 = -1;
            goto L39
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ WeakReference d;
        public final /* synthetic */ long e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ int g;
        public final /* synthetic */ long h;
        public final /* synthetic */ boolean i;

        public h(int r1, boolean r2, long r3, WeakReference r5, long r6, boolean r8, int r9, long r10, boolean r13) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r13;
        }

        public final void accept(Object r18) {
            ExtraResponse r1 = (ExtraResponse) r18;
            if (r1 == null) goto L16;
            if (r1.data == null) goto L16;
            if (nz1.a.a() == true) goto L9;
        L11:
            GiftManagerKt.a(GiftManagerKt.z, (com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data, r1.extra.now, this.b, (ca0.w) this.d.get(), this.e, this.f, r1.logId, this.a, this.g);
        L12:
            long r2 = SystemClock.uptimeMillis() - this.h;
            if (this.i == false) goto L23;
            LinkedHashMap r14 = new LinkedHashMap();
            r14.put("trace", "VS");
            int r5 = this.a;
            long r10 = this.h;
            com.bytedance.android.livesdk.gift.platform.core.utils.h.U(r5, r10, r10, r10, -1, -1, r14, ((com.bytedance.android.livesdk.gift.platform.core.model.i) r1.data).fetchStrategy, -1);
            c0 r3 = c0.a;
            c0.e(r2, this.g);
        L23:
            if (com.bytedance.android.livesdk.gift.platform.core.h.e() == false) goto L25;
            GiftManagerKt.z.getClass();
            GiftManagerKt.v().S0(this.a, this.b, String.valueOf(this.c), "GiftManager1");
            return;
        L25:
            GiftManagerKt.z.getClass();
            GiftManagerKt.v().L0(this.a, this.b, "GiftManager2");
            return;
        L9:
            if (this.a != 1) goto L11;
            Single.create(new q(this, r1)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        L16:
            if (this.i == false) goto L23;
            c0 r4 = c0.a;
            if (r1 != null) goto L20;
            String r6 = "response is empty";
        L21:
            r4.d(r6, 0, this.g);
            goto L23
        L20:
            r6 = "response.data is empty";
            goto L21
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ long f;

        public i(boolean r1, int r2, WeakReference r3, int r4, boolean r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r6) {
            Exception r0 = new Exception((Throwable) r6);
            r0.printStackTrace();
            if (r0.getCause() == null) goto L20;
            Throwable r7 = r0.getCause();
            String r1 = null;
            if (r7 == null) goto L7;
            StackTraceElement[] r8 = r7.getStackTrace();
        L8:
            if (r8 == null) goto L20;
            Throwable r9 = r0.getCause();
            if (r9 == null) goto L12;
            StackTraceElement[] r10 = r9.getStackTrace();
        L13:
            jy0.b.c("GIFT_MANAGER", "syncgiftlist error! " + Arrays.toString(r10), null, 4);
            if (this.a == false) goto L20;
            c0 r2 = c0.a;
            StringBuilder r3 = new StringBuilder();
            Throwable r4 = r0.getCause();
            if (r4 == null) goto L18;
            r1 = r4.getMessage();
        L18:
            r3.append(r1);
            r3.append(" ");
            r3.append(Arrays.toString(r10));
            r2.d(r3.toString(), r0.a(r0), this.b);
            goto L20
        L12:
            r10 = null;
            goto L13
        L7:
            r8 = null;
        L20:
            if (this.c.get() == null) goto L25;
            ca0.w r11 = (ca0.w) this.c.get();
            if (r11 == null) goto L25;
            r11.a();
        L25:
            if (com.bytedance.android.livesdk.gift.platform.core.h.e() == false) goto L27;
            GiftManagerKt.z.getClass();
            GiftManagerKt.v().S0(this.d, this.e, String.valueOf(this.f), "GiftManager3");
            return;
        L27:
            GiftManagerKt.z.getClass();
            GiftManagerKt.v().L0(this.d, this.e, "GiftManager4");
        }
    }

    public GiftManagerKt() {
    }

    static {
        z = new GiftManagerKt();
        c = new HashMap();
        d = new HashMap();
        f = new HashMap();
        i = new HashSet();
        k = LazyKt.lazy(GiftManagerKt$addHeaderEnable$2.INSTANCE);
        l = new g();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L13;
        C();
    L13:
        com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).initGiftResourceManager(s1.getContext());     // Catch: Exception -> L7
    L8:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r0 = GiftResourceManagerFactory.a();
        if (r0 == null) goto L11;
        r0.g(l);
    L11:
        m = GsonHelper.get();
        n = new HashMap();
        o = new HashMap();
        q = new LongSparseArray();
        r = new SparseArray();
        s = new ArrayList();
        t = new ArrayList();
        v = new LongSparseArray();
        x = new LongSparseArray();
    }

    public static boolean A() {
        e1 r0 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
    L8:
        List r1 = t();
        if (r1 != null) goto L11;
    L13:
        return false;
    L11:
        if (r1.isEmpty() == true) goto L13;
        return true;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.a0.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[51])).booleanValue() == false) goto L8;
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).isGiftListLoaded();
    }

    public static boolean B() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L9;
        if (r0.b == null) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (a == null) goto L13;
        return true;
    L13:
        return false;
    }

    public static List m() {
        com.bytedance.android.livesdk.gift.platform.core.model.i r0 = u;
        if (r0 == null) goto L8;
        List<? extends w1> r1 = r0.giftPages;
        if (r1 == null) goto L8;
        return new ArrayList(r1);
    L8:
        return new ArrayList();
    }

    public static List n() {
        com.bytedance.android.livesdk.gift.platform.core.model.i r0 = w;
        if (r0 == null) goto L8;
        List<? extends w1> r1 = r0.giftPages;
        if (r1 == null) goto L8;
        return new ArrayList(r1);
    L8:
        return new ArrayList();
    }

    @JvmStatic
    public static final h1 p() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L8;
        h1 r1 = r0.a();
        h1 r2 = r0.b;
        if (r2 != null) goto L7;
        return r1;
    L7:
        return r2;
    L8:
        z.getClass();
        h1 r3 = q();
        h1 r4 = a;
        if (r4 != null) goto L11;
        return r3;
    L11:
        return r4;
    }

    public static h1 q() {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return c.get(Long.valueOf(r1.getId()));
    L5:
        r1 = null;
        goto L6
    }

    public static long r() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L15;
        yz0.k r1 = r0.f();
        if (r1 == null) goto L26;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L29;
        long r4 = r2.getId();
        if (r0.a.containsKey(Long.valueOf(r4)) == true) goto L12;
        return 0;
    L12:
        if (r0.a.get(Long.valueOf(r4)) == null) goto L28;
        e0 r3 = r0.a.get(Long.valueOf(r4));
        Objects.requireNonNull(r3);
        return r3.a;
    L28:
        return 0;
    L29:
        return 0;
    L26:
        return 0;
    L15:
        yz0.k r5 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r5 == null) goto L30;
        IRoom r6 = r5.getRoom();
        if (r6 == null) goto L33;
        long r7 = r6.getId();
        HashMap<Long, e0> r8 = d;
        if (r8.containsKey(Long.valueOf(r7)) == true) goto L23;
        return 0;
    L23:
        if (r8.get(Long.valueOf(r7)) == null) goto L32;
        e0 r9 = r8.get(Long.valueOf(r7));
        Objects.requireNonNull(r9);
        return r9.a;
    L32:
        return 0;
    L33:
        return 0;
    L30:
        return 0;
    }

    public static AssetsService v() {
        return (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
    }

    public static e0 x() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
        yz0.k r1 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L9;
        IRoom r2 = r1.getRoom();
    L10:
        if (r2 == null) goto L16;
        HashMap<Long, e0> r3 = d;
        if (r3.containsKey(Long.valueOf(r2.getId())) == true) goto L15;
        return null;
    L15:
        return r3.get(Long.valueOf(r2.getId()));
    L16:
        return null;
    L9:
        r2 = null;
        goto L10
    L5:
        return r0.g();
    }

    public static List y() {
        e1 r0 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.model.i r1 = p;
        if (r1 == null) goto L18;
        if (Lists.isEmpty(r1.giftPages) == true) goto L18;
        com.bytedance.android.livesdk.gift.platform.core.model.i r2 = p;
        if (r2 == null) goto L15;
        List<? extends w1> r3 = r2.giftPages;
        if (r3 == null) goto L15;
    L19:
        return new ArrayList(r3);
    L15:
        r3 = CollectionsKt.emptyList();
    L18:
        return new ArrayList();
    L5:
        return new ArrayList();
    }

    public static void C() {
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().e() == true) goto L5;
        wwc.c r0 = g;
        if (r0 == null) goto L12;
        r0.cancel();
    L12:
        Flowable.create(b.a, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(c.a, d.a, e.a, f.a);
        return;
    L5:
        if (e == true) goto L14;
        e = true;
        Single.create(k.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(l.a, m.a);
        return;
    }

    public static Map o() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.model.g r0 = h;
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.a();
    L5:
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).getExtraParam();
    }

    @JvmStatic
    public static final List<com.bytedance.android.livesdk.gift.platform.core.model.e> s() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
        List<com.bytedance.android.livesdk.gift.platform.core.model.e> r0 = t;
        Collections.sort(r0, a.a);
        return new ArrayList(r0);
    L5:
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).q();
    }

    public static List t() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        IRoom r1 = null;
        if (r0 == null) goto L9;
        IRoom r2 = r0.getRoom();
    L11:
        if ((r2 instanceof Room) == false) goto L14;
        r1 = r2;
    L14:
        Room r3 = (Room) r1;
        if (r3 == null) goto L17;
        int r4 = r3.orientation;
    L19:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L22;
        com.bytedance.android.livesdk.gift.platform.core.model.i r5 = u;
    L25:
        if (r5 == null) goto L30;
        if (Lists.isEmpty(r5.giftPages) == true) goto L30;
        return new ArrayList(r5.giftPages);
    L30:
        return new ArrayList();
    L22:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.t() == false) goto L24;
        r5 = w;
        goto L25
    L24:
        r5 = (com.bytedance.android.livesdk.gift.platform.core.model.i) ((HashMap) n).get(Integer.valueOf(r4));
        goto L25
    L17:
        r4 = 0;
        goto L19
    L9:
        r2 = null;
        goto L11
    L5:
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).N3().c;
    }

    @JvmStatic
    public static final void D(Long r6) {
        j = false;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r1 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L5;
        HashMap<Long, h1> r0 = c;
        if (r0 == null) goto L26;
        TypeIntrinsics.asMutableMap(r0).remove(r6);
        HashMap<Long, e0> r2 = d;
        if (r2 == null) goto L24;
        TypeIntrinsics.asMutableMap(r2).remove(r6);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.m0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[63])).booleanValue() == false) goto L7;
        r1.d = false;
    L7:
        HashMap<Long, h1> r3 = r1.c;
        if (r3 == null) goto L16;
        TypeIntrinsics.asMutableMap(r3).remove(r6);
        HashMap<Long, e0> r4 = r1.a;
        if (r4 == null) goto L14;
        TypeIntrinsics.asMutableMap(r4).remove(r6);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public static CommonTransformer E(boolean r0) {
        if (r0 == true) goto L8;
        if (k60.b.d() == true) goto L8;
        return RxUtil.rxSchedulerHelper();
    L8:
        return new com.bytedance.android.live.core.utils.rxutils.i();
    }

    public static void F(h1 r4) {
        Intrinsics.checkNotNullParameter(r4, "gift");
        if (j == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L9;
        r0.h(r4);
        return;
    L9:
        yz0.k r1 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L12;
        IRoom r2 = r1.getRoom();
    L13:
        if (r2 == null) goto L16;
        c.put(Long.valueOf(r2.getId()), r4);
        return;
    L16:
        return;
    L12:
        r2 = null;
        goto L13
    }

    @JvmStatic
    public static final void H(int r8) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L6;
        GiftListRepo.g(r8);
        return;
    L6:
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L9;
        IRoom r1 = r0.getRoom();
    L10:
        if (r1 != null) goto L12;
    L14:
        String r2 = BuildConfig.FLAVOR;
    L15:
        String r7 = r2;
        if (r1 == null) goto L18;
        long r3 = r1.getId();
    L19:
        I(null, r3, r8, false, r7);
        return;
    L18:
        r3 = 0;
        goto L19
    L12:
        if (r1.getOwner() == null) goto L14;
        IBaseUser r4 = r1.getOwner();
        Intrinsics.checkNotNull(r4);
        r2 = com.bytedance.android.live.base.model.user.o.a(r4);
        goto L15
    L9:
        r1 = null;
        goto L10
    }

    public static void e(Collection r5) {
        Intrinsics.checkNotNullParameter(r5, "gifts");
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == true) goto L5;
        return;
    L5:
        if (u == null) goto L51;
        Iterator r6 = r5.iterator();
        ArrayList r0 = new ArrayList();
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L26;
        com.bytedance.android.livesdk.gift.platform.core.model.i r1 = u;
        if (r1 == null) goto L26;
        List<? extends w1> r2 = r1.giftPages;
        if (r2 == null) goto L26;
        Iterator<? extends w1> r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L26;
        w1 r4 = r3.next();
        if (r4.getGifts() == null) goto L16;
        Iterator<h1> r7 = r4.getGifts().iterator();
    L21:
        if (r7.hasNext() == false) goto L16;
        h1 r8 = r7.next();
        if (r8.isDisplayedOnPanel() == false) goto L21;
        r0.add(Long.valueOf(r8.getId()));
    L26:
        if (r6.hasNext() == false) goto L52;
        Object r9 = r6.next();
        if (r9 == null) goto L33;
        if (r0.contains(Long.valueOf(((h1) r9).getId())) == true) goto L26;
        r6.remove();
        goto L26
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L52:
        return;
    }

    public static void f(Collection r5) {
        Intrinsics.checkNotNullParameter(r5, "gifts");
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.t() == true) goto L5;
        return;
    L5:
        if (w == null) goto L51;
        Iterator r6 = r5.iterator();
        ArrayList r0 = new ArrayList();
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.t() == false) goto L26;
        com.bytedance.android.livesdk.gift.platform.core.model.i r1 = w;
        if (r1 == null) goto L26;
        List<? extends w1> r2 = r1.giftPages;
        if (r2 == null) goto L26;
        Iterator<? extends w1> r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L26;
        w1 r4 = r3.next();
        if (r4.getGifts() == null) goto L16;
        Iterator<h1> r7 = r4.getGifts().iterator();
    L21:
        if (r7.hasNext() == false) goto L16;
        h1 r8 = r7.next();
        if (r8.isDisplayedOnPanel() == false) goto L21;
        r0.add(Long.valueOf(r8.getId()));
    L26:
        if (r6.hasNext() == false) goto L52;
        Object r9 = r6.next();
        if (r9 == null) goto L33;
        if (r0.contains(Long.valueOf(((h1) r9).getId())) == true) goto L26;
        r6.remove();
        goto L26
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L52:
        return;
    }

    public static void g(Collection r2) {
        Intrinsics.checkNotNullParameter(r2, "gifts");
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L6;
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.f.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r2);
        return;
    L6:
        yz0.k r1 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L9;
        IRoom r3 = r1.getRoom();
    L10:
        if (r3 != null) goto L21;
        Iterator r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L28;
        Object r5 = r4.next();
        if (r5 == null) goto L20;
        if (z(((h1) r5).getId()) == false) goto L13;
        r4.remove();
        goto L13
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L28:
        return;
    L21:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public static void h(Collection r1) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r1);
        return;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        Object r0 = r2.next();
        if (r0 == null) goto L17;
        if (((h1) r0).isDisplayedOnPanel() == true) goto L10;
        r2.remove();
        goto L10
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    }

    public static /* synthetic */ h1 k(long r1) {
        return j(r1, null);
    }

    public static h2 l(long r1) {
        return j(r1, null);
    }

    @JvmStatic
    public static final GiftType u(Integer r2) {
        if (r2 == null) goto L39;
        r2.intValue();
        if (r2.intValue() != 10) goto L7;
        return GiftType.GOLDEN_BEAN_CELL;
    L7:
        if (r2.intValue() != 9) goto L10;
        return GiftType.FREE_CELL;
    L10:
        if (r2.intValue() != 1) goto L13;
        return GiftType.NORMAL_GIFT;
    L13:
        if (r2.intValue() != 5) goto L16;
        return GiftType.TASK_GIFT;
    L16:
        if (r2.intValue() != 4) goto L19;
        return GiftType.STICKER_GIFT;
    L19:
        if (r2.intValue() != 8) goto L22;
        return GiftType.MIDDLE_GIFT;
    L22:
        if (r2.intValue() != 2) goto L25;
        return GiftType.SPECIAL_GIFT;
    L25:
        if (r2.intValue() != 11) goto L28;
        return GiftType.GAME;
    L28:
        if (r2.intValue() != 12) goto L31;
        return GiftType.BLIND_BOX;
    L31:
        if (r2.intValue() != 13) goto L34;
        return GiftType.INTERACT_GIFT;
    L34:
        if (r2.intValue() != 15) goto L37;
        return GiftType.MULTI_INTERACT;
    L37:
        return GiftType.UNKNOWN;
    L39:
        return GiftType.UNKNOWN;
    }

    public static com.bytedance.android.livesdk.sharedpref.e w(int r3) {
        return new com.bytedance.android.livesdk.sharedpref.e("gift_list_response_" + r3, BuildConfig.FLAVOR);
    }

    public static boolean z(long r7) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L28;
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.f.a;
        h2 r8 = l(r7);
        if (r8 != null) goto L8;
    L26:
        return false;
    L8:
        if (r8.getType() != 2) goto L10;
    L15:
        Iterator<Long> r9 = r8.getAssetIds().iterator();
    L17:
        if (r9.hasNext() == false) goto L26;
        long r1 = r9.next().longValue();
        if (((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).g1(r1) != true) goto L26;
        com.bytedance.android.live.core.resources.e r10 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).G1(r1);
        if (r10 == null) goto L17;
        if (r10.getResourceType() != 8) goto L17;
        return true;
    L10:
        if (r8.getType() == 8) goto L15;
        if (r8.getType() == 11) goto L15;
        if (r8.getType() != 13) goto L26;
    L28:
        h2 r11 = l(r7);
        if (r11 != null) goto L32;
        return false;
    L32:
        if (r11.getType() != 2) goto L34;
    L41:
        Iterator<Long> r13 = r11.getAssetIds().iterator();
    L43:
        if (r13.hasNext() == false) goto L52;
        long r2 = r13.next().longValue();
        if (v().g1(r2) == false) goto L52;
        com.bytedance.android.live.core.resources.e r14 = v().G1(r2);
        if (r14 == null) goto L43;
        if (r14.getResourceType() != 8) goto L43;
        return true;
    L52:
        return false;
    L34:
        if (r11.getType() == 8) goto L41;
        if (r11.getType() == 11) goto L41;
        if (r11.getType() == 13) goto L41;
        return false;
    }

    public static void G(boolean r3, h1 r4) {
        Intrinsics.checkNotNullParameter(r4, "gift");
        j = r3;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b r0 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.b.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L6;
        r0.d = r3;
        r0.h(r4);
        return;
    L6:
        yz0.k r5 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r5 == null) goto L9;
        IRoom r6 = r5.getRoom();
    L10:
        if (r6 == null) goto L13;
        c.put(Long.valueOf(r6.getId()), r4);
        return;
    L13:
        return;
    L9:
        r6 = null;
        goto L10
    }

    public static final void b(GiftManagerKt r3, Map r4) {
        r3.getClass();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isEmpty() == true) goto L26;
        Iterator r5 = r4.keySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L16;
        int r0 = ((Number) r5.next()).intValue();
        com.bytedance.android.livesdk.gift.platform.core.model.i r1 = (com.bytedance.android.livesdk.gift.platform.core.model.i) r4.get(Integer.valueOf(r0));
        if (r1 == null) goto L9;
        c(r1, r0);
        if (com.bytedance.android.livesdk.gift.platform.core.h.h().e() == false) goto L9;
        d(r1, r0);
        goto L9
    L16:
        L((com.bytedance.android.livesdk.gift.platform.core.model.i) ((HashMap) n).get(0), false, true, 0);
        return;
    }

    public static void c(com.bytedance.android.livesdk.gift.platform.core.model.i r6, int r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i> r0 = n;
        HashMap r1 = (HashMap) r0;
        r1.put(Integer.valueOf(r7), r6);
        SparseArray<LongSparseArray<h1>> r2 = r;
        LongSparseArray<h1> r3 = r2.get(r7);
        if (r3 == null) goto L7;
        r3.clear();
    L8:
        ArrayList r8 = new ArrayList();
        List<? extends w1> r9 = r6.giftPages;
        if (r9 == null) goto L14;
        Iterator<? extends w1> r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        r8.addAll(r10.next().getGifts());
    L14:
        f.clear();
        Iterator r11 = r8.iterator();
    L16:
        if (r11.hasNext() == false) goto L23;
        h1 r13 = (h1) r11.next();
        r3.append(r13.getId(), r13);
        if (Lists.isEmpty(r13.getTriggerWords()) == true) goto L16;
        Iterator<String> r4 = r13.getTriggerWords().iterator();
    L21:
        if (r4.hasNext() == false) goto L16;
        String r5 = r4.next();
        f.put(r5, Long.valueOf(r13.getId()));
        goto L21
    L23:
        return;
    L7:
        r3 = new LongSparseArray();
        r2.append(r7, r3);
        goto L8
    }

    public static void d(com.bytedance.android.livesdk.gift.platform.core.model.i r3, int r4) {
        Map<Integer, com.bytedance.android.livesdk.gift.platform.core.model.i> r0 = n;
        HashMap r1 = (HashMap) r0;
        r1.put(Integer.valueOf(r4), r3);
        p = r3;
        q.clear();
        ArrayList r5 = new ArrayList();
        Iterator r6 = y().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.addAll(((w1) r6.next()).getGifts());
        goto L4
    L6:
        Iterator r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        h1 r8 = (h1) r7.next();
        q.append(r8.getId(), r8);
        goto L8
    }

    public static int i(Collection r14, boolean r15) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L7;
        return com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r14, r15, null);
    L7:
        if (r14 != null) goto L9;
        return 0;
    L9:
        ((Number) com.bytedance.android.livesdk.gift.platform.core.h.h.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[6])).intValue();
        v1 r1 = com.bytedance.android.livesdk.gift.platform.business.i.m();
        Iterator r16 = r14.iterator();
        boolean r2 = AssetsUtils.b(r15);
        ResourceRecordService r3 = (ResourceRecordService) com.bytedance.android.live.revenue.core.util.f.a(ResourceRecordService.class);
        int r4 = 0;
    L11:
        if (r16.hasNext() == false) goto L94;
        Object r5 = r16.next();
        if (r5 == null) goto L93;
        h1 r6 = (h1) r5;
        if (r6.getId() == 998) goto L16;
        if (r2 == true) goto L19;
        int r9 = -1;
        if (r6.getType() == 2) goto L31;
        if (r6.getType() == 8) goto L31;
        if (r6.getType() == 11) goto L31;
        if (r6.getType() == 13) goto L31;
        if (r6.getType() == 15) goto L31;
    L70:
        if (r6.getType() != 4) goto L11;
        if (r15 == false) goto L11;
        if (r6.getGiftSource() == 1) goto L11;
        if (r2 == true) goto L11;
        if (v().g1(r6.getPrimaryEffectId()) == true) goto L11;
        if (r1.getEnable() == true) goto L79;
        r4 = r4 + 1;
        r16.remove();
        goto L11
    L79:
        com.bytedance.android.live.core.resources.e r7 = v().G1(r6.getPrimaryEffectId());
        if (r7 == null) goto L83;
        r9 = r7.getResourceType();
    L83:
        if (r1.s3().contains(Integer.valueOf(r6.getType())) == true) goto L90;
        if (r1.z5().contains(Integer.valueOf(r9)) == true) goto L90;
        List<Long> r8 = r1.f2();
        if (r8 == null) goto L11;
        if (r8.contains(Long.valueOf(r6.getId())) != true) goto L11;
    L90:
        r4 = r4 + 1;
        r16.remove();
    L31:
        if (r6.isDisplayedOnPanel() == true) goto L33;
        r16.remove();
        goto L11
    L33:
        List<Long> r10 = r6.getAssetIds();
        Iterator<Long> r11 = r10.iterator();
    L35:
        if (r11.hasNext() == false) goto L46;
        long r13 = r11.next().longValue();
        if (r6.getOptionalAssetIds() == null) goto L44;
        List<Long> r17 = r6.getOptionalAssetIds();
        if (r17 == null) goto L44;
        if (r17.contains(Long.valueOf(r13)) == true) goto L35;
    L44:
        if (v().g1(r13) == true) goto L35;
        boolean r18 = false;
    L47:
        if (r18 == true) goto L70;
        if (r1.getEnable() == false) goto L68;
        com.bytedance.android.live.core.resources.e r19 = v().G1(r6.getPrimaryEffectId());
        if (r19 == null) goto L54;
        r9 = r19.getResourceType();
    L54:
        if (r1.s3().contains(Integer.valueOf(r6.getType())) == true) goto L62;
        if (r1.z5().contains(Integer.valueOf(r9)) == true) goto L62;
        List<Long> r20 = r1.f2();
        if (r20 == null) goto L61;
        if (r20.contains(Long.valueOf(r6.getId())) == true) goto L62;
    L61:
        r6.setFreeDisplay(true);
    L62:
        Iterator<Long> r21 = r10.iterator();
    L64:
        if (r21.hasNext() == false) goto L68;
        long r23 = r21.next().longValue();
        String r24 = v().D1(r23);
        if (r24 == null) goto L64;
        r3.x(r24, true, r23);
    L68:
        r16.remove();
        r4 = r4 + 1;
        goto L11
    L46:
        r18 = true;
        goto L47
    L19:
        r6.setFreeDisplay(true);
        goto L11
    L16:
        r16.remove();
        goto L11
    L93:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L94:
        return r4;
    }

    @JvmStatic
    public static final h1 j(long r5, Integer r7) {
        if (r5 > 0) goto L5;
        return null;
    L5:
        e1 r0 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L10;
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).o4(r5, r7);
    L10:
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L22;
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r8 == null) goto L22;
        com.bytedance.live.datacontext.m<Boolean> r9 = r8.isVS();
        if (r9 == null) goto L22;
        if (((Boolean) r9.getValue()).booleanValue() != true) goto L22;
        return q.get(r5);
    L19:
        e = move-exception;
        e.printStackTrace();
    L22:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L28;
        return v.get(r5);
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.t() == true) goto L70;
    L33:
        yz0.k r10 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r10 == null) goto L36;
        IRoom r11 = r10.getRoom();
    L38:
        if ((r11 instanceof Room) == true) goto L40;
        r11 = null;
    L40:
        Room r13 = (Room) r11;
        if (r13 == null) goto L43;
        int r14 = r13.orientation;
    L44:
        LongSparseArray<h1> r15 = r.get(r14);
        if (r15 != null) goto L68;
        z.getClass();
        h1 r16 = y;
        if (r16 != null) goto L49;
        return null;
    L49:
        if (r16.getId() == r5) goto L51;
        return null;
    L51:
        return y;
    L68:
        h1 r17 = r15.get(r5);     // Catch: Exception -> L61
        if (r17 != null) goto L77;
        z.getClass();     // Catch: Exception -> L61
        h1 r18 = y;     // Catch: Exception -> L61
        if (r18 != null) goto L57;
        return null;
    L57:
        if (r18.getId() != r5) goto L75;
        return y;
    L75:
        return null;
    L77:
        return r17;
    L61:
        e = move-exception;
        jy0.b.a("GiftManager", "findGiftById LongSparseArray exception: " + e.getMessage());
        return null;
    L43:
        r14 = 0;
        goto L44
    L36:
        r11 = null;
        goto L38
    L70:
        return x.get(r5);
    L31:
        e = move-exception;
        jy0.b.a("GiftManager", "findGiftById LongSparseArray exception: " + e.getMessage());
        goto L33
    }

    public static void L(com.bytedance.android.livesdk.gift.platform.core.model.i r6, boolean r7, boolean r8, int r9) {
        if (r6 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.gift.platform.core.model.u r10 = r6.giftsInfo;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r8 == false) goto L60;
        Intrinsics.checkNotNullParameter(r10, "giftsInfo");
        yz0.k r11 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r11 == null) goto L35;
        IRoom r13 = r11.getRoom();
        if (r13 == null) goto L35;
        GiftManagerKt r1 = z;
        e0 r2 = r10.getSpeedyGiftPopupInfo();
        r1.getClass();
        if (r2 != null) goto L16;
    L24:
        boolean r3 = false;
    L25:
        Unit r4 = null;
        if (r3 == false) goto L28;
        com.bytedance.android.livesdk.gift.platform.core.model.u r5 = r10;
    L29:
        if (r5 == null) goto L34;
        e0 r14 = r5.getSpeedyGiftPopupInfo();
        if (r14 == null) goto L33;
        r14.a = r5.getFirstChargeSpeedyGiftId();
        d.put(Long.valueOf(r13.getId()), r14);
        r4 = Unit.INSTANCE;
    L33:
        if (r4 != null) goto L35;
    L34:
        d.remove(Long.valueOf(r13.getId()));
        goto L35
    L28:
        r5 = null;
        goto L29
    L16:
        if (a1.j(r2.e()) == false) goto L24;
        if (a1.j(r2.c()) == false) goto L24;
        if (r2.b() == null) goto L24;
        if (r2.d() == null) goto L24;
        r3 = true;
    L35:
        if (r9 == 1) goto L53;
        long r15 = r10.getFastGiftId();
        if (0 != r15) goto L39;
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c());
        goto L53
    L39:
        ArrayList r0 = new ArrayList();
        List r16 = t();
        if (r16 == null) goto L45;
        Iterator r17 = r16.iterator();
    L43:
        if (r17.hasNext() == false) goto L45;
        r0.addAll(((w1) r17.next()).getGifts());
    L45:
        ArrayList r18 = new ArrayList(r0);
        i(r18, r7);
        Iterator r19 = r18.iterator();
    L47:
        if (r19.hasNext() == false) goto L51;
        h1 r20 = (h1) r19.next();
        if (r20.getId() != r15) goto L47;
        F(r20);
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c(r20, 3));
        goto L53
    L51:
        xs2.b.a().post(new com.bytedance.android.livesdk.gift.platform.core.model.c());
    L53:
        if (r10.getGroupCountInfo() == null) goto L56;
        ArrayList r21 = (ArrayList) s;
        r21.clear();
        r21.addAll(r10.getGroupCountInfo());
    L56:
        if (r10.getGiftComboInfoList() == null) goto L58;
        ArrayList r23 = (ArrayList) t;
        r23.clear();
        r23.addAll(r10.getGiftComboInfoList());
    L59:
        b = r10.getGiftEntranceIcon();
        h = r10.getExtraParam();
        Completable.complete().observeOn(Schedulers.computation()).subscribe(r.a);
        goto L60
    L58:
        ((ArrayList) t).clear();
    L60:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.a.class).Hi().putAll(r10.getMsgProcessFilter());
        h = r10.getExtraParam();
    }

    @JvmStatic
    public static final void I(ca0.w r11, long r13, int r14, boolean r15, String r16) {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L24;
        z.getClass();
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L7;
        IRoom r1 = r0.getRoom();
    L8:
        if (r1 != null) goto L10;
    L12:
        String r2 = BuildConfig.FLAVOR;
    L13:
        String r7 = r2;
        if (r1 == null) goto L16;
        long r3 = r1.getId();
    L18:
        if (r3 != r13) goto L21;
        if (r1 == null) goto L21;
        int r8 = (int) r1.getRoomLayout();
    L22:
        GiftListRepo.j(r11, r13, r14, r15, r7, r8);
        return;
    L21:
        r8 = 0;
        goto L22
    L16:
        r3 = 0;
        goto L18
    L10:
        if (r1.getOwner() == null) goto L12;
        IBaseUser r4 = r1.getOwner();
        Intrinsics.checkNotNull(r4);
        r2 = com.bytedance.android.live.base.model.user.o.a(r4);
        goto L13
    L7:
        r1 = null;
        goto L8
    L24:
        z.getClass();
        J(r11, r13, r13, 1, r14, r15, r16, r16, null);
    }

    public static void J(ca0.w r13, long r14, long r16, int r18, int r19, boolean r20, String r21, String r23, IEpisode r24) {
        K(r13, r14, r16, r18, r19, r20, r21, r23, r24, 0);
    }

    public static void K(ca0.w r33, long r34, long r35, int r37, int r38, boolean r39, String r40, String r41, IEpisode r43, long r44) {
        String r1 = r40;
        String r2 = r41;
        Context r0 = s1.getContext();
        int r3 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r0) == false) goto L121;
        WeakReference r15 = new WeakReference(r33);
        if (r34 == 0) goto L7;
        boolean r16 = true;
    L8:
        long r11 = SystemClock.uptimeMillis();
        boolean r9 = TextUtils.equals(r2, r1);
        yz0.k r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r4 == null) goto L13;
        IRoom r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IMainRoom r6 = (IMainRoom) r5.castToOrNull(IMainRoom.class);
    L14:
        if (r6 == null) goto L20;
        com.bytedance.android.live.revenue.model.extension.main.c r7 = r6.getMainOthers();
        if (r7 == null) goto L20;
        IGroupLiveData r8 = r7.getGroupLiveData();
        if (r8 == null) goto L20;
        boolean r10 = r8.isCurrentGroupLive();
    L21:
        if (r10 == false) goto L23;
        int r13 = 128;
    L24:
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L45;
        z.getClass();
        JSONObject r17 = new JSONObject();
        Bundle r18 = (Bundle) r14.getGiftLogExtra().getValue();     // Catch: JSONException -> L41
        if (r18 == null) goto L32;
        String r19 = r18.getString("gift_show_from");     // Catch: JSONException -> L41
        if (r19 == null) goto L32;
    L33:
        r17.put("gift_show_from", r19);     // Catch: JSONException -> L41
        Bundle r20 = (Bundle) r14.getGiftLogExtra().getValue();     // Catch: JSONException -> L41
        if (r20 == null) goto L38;
        String r21 = r20.getString("gift_send_times");     // Catch: JSONException -> L41
        if (r21 == null) goto L38;
    L39:
        r17.put("gift_send_times", r21);     // Catch: JSONException -> L41
    L43:
        String r23 = r17.toString();
        if (r23 == null) goto L45;
    L47:
        if (((Boolean) k.getValue()).booleanValue() == false) goto L49;
        Pair r24 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new com.bytedance.android.livesdk.gift.platform.core.manager.i());
    L117:
        tz0.b r25 = tz0.b.a;     // Catch: Throwable -> L97
        uz0.c r26 = new uz0.c();     // Catch: Throwable -> L97
        r25.getClass();     // Catch: Throwable -> L97
        Intrinsics.checkNotNullParameter(r26, "$this$beforeConfigureRequest");     // Catch: Throwable -> L97
        uz0.f r27 = new uz0.f(((uz0.a) r26).b);     // Catch: Throwable -> L97
        if (r44 != 0) goto L119;
    L57:
        long r30 = r11;
        if (r43 == null) goto L63;
    L95:
        th = th;
    L96:
        boolean r110 = r9;
    L99:
        th.printStackTrace();
        jy0.b.a("GiftManager", "message: " + th.getMessage());
        Observable r28 = null;
    L100:
        if (r28 == null) goto L122;
        Observable r29 = r28.compose(E(false));
        if (r38 != 1) goto L104;
    L106:
        boolean r31 = false;
    L107:
        if (r31 == false) goto L109;
        r29 = RxCompatKt.b(r29, RxUtil.rxRetryHelper(3));
    L109:
        if (r29 == null) goto L123;
        r29.subscribe(new h(r38, r39, r34, r15, r35, r110, r37, r30, r16), new i(r16, r37, r15, r38, r39, r34));
        return;
    L123:
        return;
    L104:
        if (r38 == 2) goto L106;
        r31 = true;
        goto L107
    L122:
        return;
    L60:
        if (r43.getIdExt() <= 0) goto L63;
        r27.a("room_id", Long.valueOf(r43.getRoomIdExt()).toString());     // Catch: Throwable -> L95
        r27.a("to_room_id", Long.valueOf(r43.getRoomIdExt()).toString());     // Catch: Throwable -> L95
        r27.a("to_episode_id", Long.valueOf(r43.getIdExt()).toString());     // Catch: Throwable -> L95
        r110 = r9;
    L82:
        r27.a("gift_scene", Integer.valueOf(r13).toString());     // Catch: Throwable -> L93
        if (r2 != null) goto L85;
        r2 = BuildConfig.FLAVOR;
    L85:
        r27.a("to_open_id", r2);     // Catch: Throwable -> L93
        if (r1 != null) goto L88;
        r1 = BuildConfig.FLAVOR;
    L88:
        r27.a("anchor_open_id", r1);     // Catch: Throwable -> L93
        r27.a("fetch_giftlist_from", Integer.valueOf(r38).toString());     // Catch: Throwable -> L93
        r27.a("extra", r23);     // Catch: Throwable -> L93
        if (r24 == null) goto L91;
        Map r36 = ((uz0.a) r26).a;     // Catch: Throwable -> L93
        Intrinsics.checkNotNullParameter(r36, "headersMap");     // Catch: Throwable -> L93
        String r45 = (String) r24.first;     // Catch: Throwable -> L93
        String r46 = (String) r24.second;     // Catch: Throwable -> L93
        Intrinsics.checkNotNullParameter(r45, "$this$setTo");     // Catch: Throwable -> L93
        Intrinsics.checkNotNullParameter(r46, "value");     // Catch: Throwable -> L93
        r36.put(r45, r46);     // Catch: Throwable -> L93
    L91:
        Intrinsics.checkNotNullParameter(r26, "$this$afterConfigureRequest");     // Catch: Throwable -> L93
        r28 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/list/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.platform.core.model.i.class)), Extra.class, ((uz0.a) r26).d, ((uz0.a) r26).a, ((uz0.a) r26).b, ((uz0.a) r26).c);     // Catch: Throwable -> L93
    L93:
        th = th;
    L63:
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L69;
        GiftContext r111 = com.bytedance.android.livesdk.gift.util.b.b();     // Catch: Throwable -> L95
        if (r111 == null) goto L69;
        com.bytedance.live.datacontext.n<IRoom> r112 = r111.getRoom();     // Catch: Throwable -> L95
        if (r112 == null) goto L69;
        IRoom r113 = (IRoom) r112.getValue();     // Catch: Throwable -> L95
    L70:
        if (r113 == null) goto L72;
        IEpisodeExtraInfo r114 = r113.getEpisodeExtra();     // Catch: Throwable -> L95
    L73:
        if (r114 == null) goto L78;
        IEpisodeExtraInfo r115 = r113.getEpisodeExtra();     // Catch: Throwable -> L95
        if (r115 == null) goto L77;
        Long r116 = Long.valueOf(r115.getId());     // Catch: Throwable -> L95
    L80:
        r110 = r9;
        r27.a("room_id", Long.valueOf(r34).toString());     // Catch: Throwable -> L93
        r27.a("to_room_id", Long.valueOf(r35).toString());     // Catch: Throwable -> L93
        r27.a("to_episode_id", String.valueOf(r116));     // Catch: Throwable -> L93
        goto L82
    L77:
        r116 = null;
        goto L80
    L78:
        r116 = 0L;     // Catch: Throwable -> L95
        goto L80
    L72:
        r114 = null;
    L69:
        r113 = null;
        goto L70
    L119:
        r27.a("required_gift_id", Long.valueOf(r44).toString());     // Catch: Throwable -> L55
    L55:
        th = th;
        r30 = r11;
    L97:
        th = th;
        r110 = r9;
        r30 = r11;
        goto L99
    L49:
        r24 = null;
    L38:
        r21 = BuildConfig.FLAVOR;
    L32:
        r19 = BuildConfig.FLAVOR;
    L41:
        e = move-exception;
        jy0.b.c("GiftManager", "message: " + e.getMessage(), null, 4);
    L45:
        r23 = BuildConfig.FLAVOR;
        goto L47
    L23:
        r13 = r37;
    L20:
        r10 = false;
    L13:
        r6 = null;
        goto L14
    L7:
        r16 = false;
        goto L8
    }

    public static final void a(GiftManagerKt r4, com.bytedance.android.livesdk.gift.platform.core.model.i r5, long r6, boolean r8, ca0.w r9, long r10, boolean r13, String r14, int r15, int r16) {
        r4.getClass();
        String r1 = null;
        int r0 = 0;
        if (((m0) com.bytedance.android.livesdk.gift.platform.core.h.g0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[57])).a() == false) goto L10;
        if (r5 == null) goto L9;
        List<? extends w1> r7 = r5.giftPages;
        if (r7 == null) goto L9;
        if (r7.size() != 0) goto L10;
    L9:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.A(0, -1, r15, BuildConfig.FLAVOR);
        return;
    L10:
        if (r5 != null) goto L16;
        if (r9 == null) goto L78;
        if (nz1.a.a() == false) goto L15;
        Single.create(new o(r9)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L78
    L15:
        r9.b(new ArrayList());
    L78:
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L113;
        GiftContext r11 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r11 == null) goto L84;
        com.bytedance.live.datacontext.n<Boolean> r17 = r11.isContinuous();
        if (r17 == null) goto L84;
        Boolean r18 = (Boolean) r17.getValue();
    L85:
        if (r18 == null) goto L100;
        GiftContext r19 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r19 == null) goto L91;
        com.bytedance.live.datacontext.n<Boolean> r20 = r19.isContinuous();
        if (r20 == null) goto L91;
        Boolean r21 = (Boolean) r20.getValue();
    L93:
        if (Intrinsics.areEqual(r21, Boolean.FALSE) == true) goto L100;
        GiftContext r23 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r23 == null) goto L99;
        com.bytedance.live.datacontext.m<String> r24 = r23.getGiftListResultLogId();
        if (r24 == null) goto L99;
        r1 = (String) r24.getValue();
    L99:
        if (r1 == null) goto L100;
        return;
    L91:
        r21 = null;
    L100:
        GiftContext r25 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r25 == null) goto L115;
        com.bytedance.live.datacontext.m<String> r26 = r25.getGiftListResultLogId();
        if (r26 == null) goto L116;
        r26.setValue(r14);
        return;
    L116:
        return;
    L115:
        return;
    L84:
        r18 = null;
        goto L85
    L113:
        return;
    L16:
        ((HashMap) o).put(Long.valueOf(r10), r5);
        ArrayList r27 = new ArrayList();
        long r110 = (System.currentTimeMillis() - r6) / 1000;
        List<? extends w1> r28 = r5.giftPages;
        if (r28 == null) goto L26;
        Iterator<? extends w1> r29 = r28.iterator();
    L20:
        if (r29.hasNext() == false) goto L26;
        w1 r30 = r29.next();
        Iterator<h1> r2 = r30.getGifts().iterator();
    L23:
        if (r2.hasNext() == false) goto L25;
        r2.next().setNowTimeDiffSeconds(r110);
        goto L23
    L25:
        r27.add(j0.d(r30));
    L26:
        ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).h(r27);
        if (r13 == true) goto L30;
        if (r16 == 512) goto L30;
        if (r16 == 1024) goto L30;
    L71:
        if (r9 != null) goto L73;
    L76:
        L(r5, r8, r13, r15);
        goto L78
    L73:
        if (nz1.a.a() == false) goto L75;
        Single.create(new p(r9, r27)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L76
    L75:
        r9.b(r27);
    L30:
        yz0.k r111 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r111 == null) goto L33;
        IRoom r112 = r111.getRoom();
    L35:
        if ((r112 instanceof Room) == true) goto L37;
        r112 = null;
    L37:
        Room r113 = (Room) r112;
        if (r113 == null) goto L41;
        r0 = r113.orientation;
    L41:
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L49;
        GiftContext r114 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r114 == null) goto L49;
        com.bytedance.live.datacontext.m<Boolean> r115 = r114.isVS();
        if (r115 == null) goto L49;
        if (((Boolean) r115.getValue()).booleanValue() != true) goto L49;
        d(r5, r0);
    L69:
        if ((!Lists.isEmpty(r27)) == false) goto L71;
        Single.create(new n(r5, r0)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
    L49:
        if (r16 != 512) goto L58;
        u = r5;
        v.clear();
        ArrayList r31 = new ArrayList();
        Iterator r33 = m().iterator();
    L52:
        if (r33.hasNext() == false) goto L54;
        r31.addAll(((w1) r33.next()).getGifts());
        goto L52
    L54:
        Iterator r34 = r31.iterator();
    L56:
        if (r34.hasNext() == false) goto L69;
        h1 r35 = (h1) r34.next();
        v.append(r35.getId(), r35);
        goto L56
    L58:
        if (r16 != 1024) goto L67;
        w = r5;
        x.clear();
        ArrayList r36 = new ArrayList();
        Iterator r37 = n().iterator();
    L61:
        if (r37.hasNext() == false) goto L63;
        r36.addAll(((w1) r37.next()).getGifts());
        goto L61
    L63:
        Iterator r38 = r36.iterator();
    L65:
        if (r38.hasNext() == false) goto L69;
        h1 r39 = (h1) r38.next();
        x.append(r39.getId(), r39);
        goto L65
    L67:
        c(r5, r0);
        goto L69
    L33:
        r112 = null;
        goto L35
    }
}
