package com.bytedance.android.debug;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.pushstream.mock.LiveAnchorPushStreamMockManager;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.h0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.s0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.utils.z;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DebugAssetsManager implements ia0.a, com.bytedance.android.scope.o {
    public static final String[] h = null;
    public static final String[] i = null;
    public final List<IAssetsManager.b> a;
    public CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> b;
    public Disposable c;
    public final Map<String, com.bytedance.android.live.core.resources.e> d;
    public final i e;
    public final ConcurrentHashMap<Long, Boolean> f;
    public boolean g;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ long a;

        public b(long r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            ExtraResponse r11 = (ExtraResponse) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            List r12 = ((s0) r11.data).getGiftList();
            if (r12 == null) goto L10;
            Iterator<T> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L10;
            h1 r0 = (h1) r13.next();
            if (r0.getId() != this.a) goto L6;
            return r0;
        L10:
            return null;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ h1 a;
        public final /* synthetic */ long b;

        public c(h1 r1, long r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r12) {
            Integer r13 = (Integer) r12;
            h1 r14 = this.a;
            IBaseUser r0 = null;
            if (r14 != null) goto L5;
            r14 = GiftManagerKt.j(this.b, null);
        L5:
            if (r14 == null) goto L21;
            com.bytedance.android.live.revenue.core.util.j.a r1 = com.bytedance.android.live.revenue.core.util.j.C0;
            yz0.l r10 = com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.l.class);
            yz0.k r11 = com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.k.class);
            l01.d r15 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
            o7 r16 = vh7.f.c(o7.class);
            m0 r17 = vh7.f.c(m0.class);
            if (r11 == null) goto L11;
            IRoom r18 = r11.getRoom();
            if (r18 == null) goto L11;
            long r19 = r18.getRoomId();
        L12:
            r17.setRoomId(r19);
            r17.setMessageId(System.currentTimeMillis());
            r17.setShowMsg(true);
            r17.setDescribe(r14.getDescribe());
            r16.setCommonData(r17);
            r16.setFromUser(r15.b());
            r16.setRepeatCount(1);
            r16.setGiftId(r14.getId());
            if (r11 == null) goto L17;
            IRoom r20 = r11.getRoom();
            if (r20 == null) goto L17;
            r0 = r20.getOwner();
        L17:
            r16.setToUser(r0);
            r16.setComboCount(1);
            r16.setGroupCount(1);
            r16.setLocal(true);
            r16.setSendGiftTime(System.currentTimeMillis());
            r16.setGift(r14);
            r16.setCount(1);
            r16.setClientGiftSource(1);
            if (r10 == null) goto L22;
            r10.insert(r16, false);
            return;
        L22:
            return;
        L11:
            r19 = 0;
            goto L12
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
            Throwable r10 = (Throwable) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ DebugAssetsManager a;
        public final /* synthetic */ int b;

        public e(DebugAssetsManager r1, int r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            ExtraResponse r11 = (ExtraResponse) r10;
            Intrinsics.checkNotNullParameter(r11, "listResponse");
            this.a.b = new CopyOnWriteArrayList(((com.bytedance.android.livesdk.gift.model.d) r11.data).getAssets());
            AssetsUtils.a();
            int r12 = this.a.b.size();
            int r0 = 0;
        L3:
            if (r0 >= r12) goto L5;
            this.a.Re(this.a.b.get(r0), this.b);
            r0 = r0 + 1;
            goto L3
        L5:
            DebugAssetsManager r13 = this.a;
            CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> r1 = r13.b;
            if (Lists.isEmpty(r1) == true) goto L9;
            Single.just(1).observeOn(Schedulers.io()).subscribe(new com.bytedance.android.debug.d(r13, r1), h0.a);
        L9:
            CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> r14 = this.a.b;
            if (this.b == 1) goto L18;
            ArrayList r15 = new ArrayList();
            Iterator<com.bytedance.android.live.core.resources.e> r16 = r14.iterator();
        L14:
            if (r16.hasNext() == false) goto L18;
            com.bytedance.android.live.core.resources.e r17 = r16.next();
            if (r17.getDownloadType() != 2) goto L14;
            r15.add(Long.valueOf(r17.getId()));
        L18:
            int r18 = ((ArrayList) this.a.a).size();
        L19:
            r18 = r18 - 1;
            if (r18 < 0) goto L22;
            ((IAssetsManager.b) ListProtector.get(this.a.a, r18)).b(this.a.b);
            goto L19
        L22:
            Disposable r19 = this.a.c;
            if (r19 != null) goto L25;
            return;
        L25:
            if (r19.isDisposed() == true) goto L39;
            Disposable r20 = this.a.c;
            if (r20 == null) goto L29;
            r20.dispose();
        L29:
            this.a.c = null;
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ DebugAssetsManager a;

        public f(DebugAssetsManager r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            Intrinsics.checkNotNullParameter(r11, "throwable");
            Logger.e(DebugAssetsManager.class.getSimpleName(), r11.getMessage());
            int r12 = ((ArrayList) this.a.a).size();
        L3:
            r12 = r12 - 1;
            if (r12 < 0) goto L6;
            ((IAssetsManager.b) ListProtector.get(this.a.a, r12)).a();
            goto L3
        L6:
            Disposable r13 = this.a.c;
            if (r13 != null) goto L9;
            return;
        L9:
            if (r13.isDisposed() == true) goto L17;
            Disposable r14 = this.a.c;
            if (r14 == null) goto L13;
            r14.dispose();
        L13:
            this.a.c = null;
            return;
        }
    }

    public final boolean A() {
        boolean r0 = true;
        boolean r1 = false;
        ILiveWrappedEffectSDKService.Companion.getClass();     // Catch: Throwable -> L8
        if (ILiveWrappedEffectSDKService.a.a() == null) goto L9;
        ILiveWrappedEffectSDKService r10 = ILiveWrappedEffectSDKService.a.a();     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L8
        r10.getSdkVersion();     // Catch: Throwable -> L8
        boolean r11 = true;
    L10:
        this.g = r11;
        if (r11 == false) goto L31;
        return true;
    L31:
        KmpEnv r12 = KmpEnv.a;     // Catch: Throwable -> L29
        if (KmpEnv.a() == false) goto L16;
        h(i, 1);     // Catch: Throwable -> L29
    L30:
        goto L35
    L16:
        h(h, 2);     // Catch: Throwable -> L29
    L35:
        ILiveWrappedEffectSDKService.Companion.getClass();     // Catch: Throwable -> L22
        if (ILiveWrappedEffectSDKService.a.a() != null) goto L20;
        r0 = false;
    L21:
        r1 = r0;
        goto L23
    L20:
        ILiveWrappedEffectSDKService r13 = ILiveWrappedEffectSDKService.a.a();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L22
        r13.getSdkVersion();     // Catch: Throwable -> L22
    L23:
        this.g = r1;
        if (r1 == false) goto L26;
        int r14 = b12.a.a;
        jy0.b.a("BEFViewLogger", "try load effect so success");
    L28:
        return this.g;
    L26:
        int r15 = b12.a.a;
        jy0.b.a("BEFViewLogger", "try load effect so fail");
    L9:
        r11 = false;
        goto L10
    }

    public final LiveData<List<Pair<com.bytedance.android.live.core.resources.e, Boolean>>> h0() {
        return null;
    }

    public final void onStop() {
    }

    public final void yj() {
    }

    static {
        h = new String[]{"yuv", "NailSLAM_jni", "ttffmpeg", "c++_shared", "AGFX", "bytenn", "audioeffect", "byteaudio", "gaia_lib", "effect"};
        i = new String[]{"yuv", "NailSLAM_jni", "ttffmpeg", "c++_shared", "AGFX", "bytenn", "IESSaliency", "audioeffect", "byteaudio", "gaia_lib", "effect"};
    }

    public final int B7() {
        return this.b.size();
    }

    public final long g() {
        Collection r0 = ((LinkedHashMap) this.d).values();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r10 = r0.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r1.add(Long.valueOf(((com.bytedance.android.live.core.resources.e) r10.next()).getId()));
        goto L4
    L6:
        Long r11 = (Long) CollectionsKt.maxOrNull(r1);
        if (r11 != null) goto L12;
        return 65535;
    L12:
        return r11.longValue() + 1;
    }

    public DebugAssetsManager() {
        this.a = new ArrayList();
        new ArrayList();
        this.b = new CopyOnWriteArrayList();
        this.d = new LinkedHashMap();
        this.f = new ConcurrentHashMap();
        this.e = new i();
    }

    public final String vg() {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r0 = GiftResourceManagerFactory.a();
        if (r0 == null) goto L8;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r1 = r0.a();
        if (r1 == null) goto L8;
        String r10 = r1.a();
        if (r10 == null) goto L8;
        return r10;
    L8:
        return "";
    }

    public final void onStart() {
        v.a();
    }

    public final Observable<h1> B2(long r16) {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        tz0.b r1 = tz0.b.a;
        uz0.c r10 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "$this$beforeConfigureRequest");
        Map r11 = ((uz0.a) r10).b;
        Intrinsics.checkNotNullParameter(r11, "queriesMap");
        String r12 = CollectionsKt.joinToString$default(CollectionsKt.mutableListOf(new String[]{String.valueOf(r16)}), ",", null, null, 0, null, null, 62, null);
        Intrinsics.checkNotNullParameter("gift_ids", "$this$setTo");
        if (r12 == null) goto L5;
        r11.put("gift_ids", r12);
    L5:
        if (r0 == null) goto L9;
        IRoom r13 = r0.getRoom();
        if (r13 == null) goto L9;
        long r14 = r13.getRoomId();
    L10:
        String r15 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, "$this$setTo");
        if (r15 == null) goto L13;
        r11.put(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r15);
    L13:
        Integer r17 = 2;
        String r18 = r17.toString();
        Intrinsics.checkNotNullParameter("fetch_from", "$this$setTo");
        if (r18 == null) goto L16;
        r11.put("fetch_from", r18);
    L16:
        Intrinsics.checkNotNullParameter(r10, "$this$afterConfigureRequest");
        return com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(r1.b(), "/webcast/gift/detail/", TypesJVMKt.getJavaType(Reflection.typeOf(s0.class)), Extra.class, ((uz0.a) r10).d, ((uz0.a) r10).a, ((uz0.a) r10).b, ((uz0.a) r10).c).compose(RxUtil.rxSchedulerHelper()).map(new b(r16));
    L9:
        r14 = 0;
        goto L10
    }

    public final String D1(long r10) {
        c12.e r11 = this.e.c(G1(r10), 0);
        if (r11 != null) goto L7;
        return null;
    L7:
        return ((com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r11).k;
    }

    public final com.bytedance.android.live.core.resources.e G1(long r10) {
        CopyOnWriteArrayList<com.bytedance.android.live.core.resources.e> r0 = this.b;
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterator<com.bytedance.android.live.core.resources.e> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        com.bytedance.android.live.core.resources.e r11 = r1.next();
        if (r11.getId() != r10) goto L7;
        return r11;
    L11:
        return null;
    }

    public final String H0(long r10) {
        return gn(r10, com.bytedance.android.livesdk.gift.platform.business.i.a().H7());
    }

    public final String Nk(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (v.a() == true) goto L5;
        return null;
    L5:
        ALogger.e("LiveAnchorPushStreamMockManager", "get AssetPath " + ((com.bytedance.android.live.core.resources.e) ((LinkedHashMap) this.d).get(r10)));
        if (((com.bytedance.android.live.core.resources.e) ((LinkedHashMap) this.d).get(r10)) != null) goto L8;
        return null;
    L8:
        ALogger.e("LiveAnchorPushStreamMockManager", "createResourcePath " + this.e.c((com.bytedance.android.live.core.resources.e) ((LinkedHashMap) this.d).get(r10), 10));
        ALogger.e("LiveAnchorPushStreamMockManager", "check Asset download " + this.e.a((com.bytedance.android.live.core.resources.e) ((LinkedHashMap) this.d).get(r10)));
        c12.e r11 = this.e.c((com.bytedance.android.live.core.resources.e) ((LinkedHashMap) this.d).get(r10), 10);
        if (r11 != null) goto L11;
        return null;
    L11:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r0 = GiftResourceManagerFactory.a();
        if (r0 != null) goto L14;
        return null;
    L14:
        return r0.h(r11, com.bytedance.android.livesdk.gift.platform.business.i.a().H7());
    }

    public final boolean O9(com.bytedance.android.live.core.resources.e r10) {
        return this.e.d(r10);
    }

    public final void T(IAssetsManager.b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (((ArrayList) this.a).contains(r10) == true) goto L6;
        ((ArrayList) this.a).add(r10);
        return;
    }

    public final boolean a7(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (v.a() == true) goto L6;
        return false;
    L6:
        if (((LinkedHashMap) this.d).get(r10) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final void cb(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        AssetsUtils.c(r1);
    }

    public final boolean g1(long r10) {
        com.bytedance.android.live.core.resources.e r11 = G1(r10);
        boolean r12 = this.e.a(r11);
        if (r11 != null) goto L5;
    L14:
        if (r11 != null) goto L16;
    L27:
        if (r12 == false) goto L30;
        if (r11 == null) goto L30;
        this.f.put(Long.valueOf(r11.getId()), Boolean.TRUE);
    L30:
        return r12;
    L16:
        if (r11.getResourceType() != 8) goto L27;
        if (r11.getLokiExtraModel() == null) goto L27;
        if (r11.getLokiExtraModel() == null) goto L22;
        boolean r1 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.effect.c.class).he(r11);
    L23:
        if (r12 == false) goto L26;
        if (r1 == false) goto L26;
    L25:
        r12 = true;
    L26:
        r12 = false;
        goto L27
    L22:
        r1 = true;
        goto L23
    L5:
        if (r11.getResourceType() != 5) goto L14;
        if (r11.getModelRequirements() == null) goto L14;
        List r13 = r11.getModelRequirements();
        Intrinsics.checkNotNull(r13);
        if ((!r13.isEmpty()) == false) goto L14;
        IRevBroadcastService r14 = com.bytedance.android.live.revenue.core.util.e.a(IRevBroadcastService.class);
        List r15 = r11.getModelRequirements();
        Intrinsics.checkNotNull(r15);
        boolean r16 = r14.Li(r15);
        if (r12 == false) goto L26;
        if (r16 == false) goto L26;
        goto L26
    }

    public final com.bytedance.android.live.core.resources.e kd(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (v.a() == true) goto L7;
        return null;
    L7:
        return (com.bytedance.android.live.core.resources.e) ((LinkedHashMap) this.d).get(r10);
    }

    public final void l0(IAssetsManager.b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        if (((ArrayList) this.a).contains(r10) == false) goto L6;
        ((ArrayList) this.a).remove(r10);
        return;
    }

    public static void h(String[] r10, int r11) {
        int r0 = r10.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        String r12 = r10[r1];
        ALogger.e("AssetsManager", "start load library:" + r12, null);     // Catch: Throwable -> L7
        com.bytedance.android.live.revenue.core.util.e.a(dr2.h.class).loadLibraryV2(r11, s1.getContext(), com.bytedance.android.live.revenue.core.util.e.a(dr2.h.class).getHostPackageName(), r12, DebugAssetsManager.class.getClassLoader());     // Catch: Throwable -> L7
    L9:
        r1 = r1 + 1;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public final void A5(final String r12, final LiveAnchorPushStreamMockManager.Companion.a r13) {
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (v.a() == true) goto L5;
        return;
    L5:
        com.bytedance.android.live.core.resources.e r0 = (com.bytedance.android.live.core.resources.e) ((LinkedHashMap) this.d).get(r12);
        if (r0 == null) goto L9;
        ib(r0, r13, 4, AssetDownloadPriority.ANCHOR_MOCK);
        return;
    L9:
        if (StringsKt.contains$default(r12, ".zip", false, 2, null) == false) goto L12;
        int r1 = StringsKt.lastIndexOf$default(r12, ".zip", 0, false, 6, null);
    L15:
        final com.bytedance.android.live.core.resources.f r10 = vh7.f.c(com.bytedance.android.live.core.resources.f.class);
        com.bytedance.android.live.core.resources.l r11 = vh7.f.c(com.bytedance.android.live.core.resources.l.class);
        r11.setUrlList(CollectionsKt.listOf(r12));
        Unit r14 = Unit.INSTANCE;
        r10.setResourceModel(r11);
        Class r15 = com.bytedance.android.live.core.resources.h.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r16 = vh7.b.a;
        Object r17 = r16.get(r15);
        if (r17 != null) goto L25;
        r17 = r15.getConstructor(new Class[0]);
        if (r17 == null) goto L24;
        Object r18 = r16.putIfAbsent(r15, r17);
        if (r18 == null) goto L25;
        r17 = r18;
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L25:
        Object r19 = ((SerializableObjectJsonAdapterBase) ((Constructor) r17).newInstance(new Object[0])).createInstance();
        if (r19 == null) goto L30;
        r10.setLokiExtraModel((com.bytedance.android.live.core.resources.h) r19);
        r10.setMD5(r12.substring(StringsKt.lastIndexOf$default(r12, '/', 0, false, 6, null) + 1, r1));
        r10.setId(g());
        ib(r10, new DebugAssetsManager$downloadAssetByUrl$$inlined$let$lambda$1(r10, this, r12, r13), 4, AssetDownloadPriority.ANCHOR_MOCK);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.resources.LokiExtraKt");
    L12:
        if (StringsKt.contains$default(r12, '?', false, 2, null) == false) goto L14;
        r1 = StringsKt.lastIndexOf$default(r12, "?", 0, false, 6, null);
        goto L15
    L14:
        r1 = StringsKt.getLastIndex(r12) + 1;
        goto L15
    }

    public final boolean Re(com.bytedance.android.live.core.resources.e r10, int r11) {
        Ne(r10, null, r11);
        return false;
    }

    public final void Rg(h1 r10, long r11) {
        Single.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r10, r11), d.a);
    }

    public final void T2(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "traceFlag");
        x(r10, false, r11);
    }

    public final void Tf(String r11, com.bytedance.android.debug.f r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.contains$default(r11, ".zip", false, 2, null) == false) goto L6;
        int r0 = StringsKt.lastIndexOf$default(r11, ".zip", 0, false, 6, null);
    L9:
        com.bytedance.android.live.core.resources.f r1 = vh7.f.c(com.bytedance.android.live.core.resources.f.class);
        com.bytedance.android.live.core.resources.l r10 = vh7.f.c(com.bytedance.android.live.core.resources.l.class);
        r10.setUrlList(CollectionsKt.listOf(r11));
        Unit r13 = Unit.INSTANCE;
        r1.setResourceModel(r10);
        r1.setMD5(r11.substring(StringsKt.lastIndexOf$default(r11, '/', 0, false, 6, null) + 1, r0));
        r1.setId(g());
        Ne(r1, new com.bytedance.android.debug.b(r1, r12), 10);
        return;
    L6:
        if (StringsKt.contains$default(r11, '?', false, 2, null) == false) goto L8;
        r0 = StringsKt.lastIndexOf$default(r11, "?", 0, false, 6, null);
        goto L9
    L8:
        r0 = StringsKt.getLastIndex(r11) + 1;
        goto L9
    }

    public final void f(JSONObject r10, final Function1<? super JSONObject, Unit> r11) {
        Function2<String, Object, Unit> r0 = new DebugAssetsManager$findJsObjAtJsObjRecursive$1(this, r11);
        Iterator<String> r12 = r10.keys();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r1 = r12.next();
        r0.invoke(r1, r10.get(r1));
        goto L4
    }

    public final String gn(long r10, boolean r11) {
        c12.e r12 = this.e.c(G1(r10), 0);
        if (r12 != null) goto L5;
        return null;
    L5:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r0 = GiftResourceManagerFactory.a();
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.h(r12, r11);
    }

    public static final void a(final DebugAssetsManager r10, JSONArray r11, final Function1 r12) {
        r10.getClass();
        Function2<Integer, Object, Unit> r0 = new DebugAssetsManager$findJsObjAtJsAryRecursive$1(r10, r12);
        if (r11.length() == 0) goto L8;
        int r13 = r11.length();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L10;
        r0.invoke(Integer.valueOf(r14), r11.get(r14));
        r14 = r14 + 1;
        goto L6
    L10:
        return;
    }

    public final boolean Ne(com.bytedance.android.live.core.resources.e r10, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r11, int r12) {
        ib(r10, r11, r12, AssetDownloadPriority.NORMAL);
        return false;
    }

    public final boolean j4(long r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r10, int r11) {
        Ne(G1(r1), r10, r11);
        return false;
    }

    public final void x(int r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "traceFlag");
        SystemClock.uptimeMillis();
        if (com.bytedance.android.livesdk.gift.platform.business.effect.b.a() == false) goto L5;
        String r13 = "1";
    L7:
        if (A() == false) goto L16;
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.performance.b.class).W7();
        int r1 = a12.a.a;     // Catch: Throwable -> L11
        Observable r14 = a12.a.a(A(), r10, r13);     // Catch: Throwable -> L11
        int r15 = b12.b.a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter("ttlive_get_effect_sdk_version_status", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);     // Catch: Throwable -> L11
        b12.b.b(z.a("ttlive_get_effect_sdk_version_status"), new JSONObject(), 0);     // Catch: Throwable -> L11
    L17:
        this.c = r14.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r10), new f(this));
        return;
    L11:
        th = move-exception;
        Observable r16 = a12.a.a(false, r10, r13);
        int r17 = b12.b.a;
        JSONObject r18 = new JSONObject();
        String r19 = th.getMessage();
        if (r19 != null) goto L15;
        r19 = "";
    L15:
        j01.d.b(r18, com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r19);
        Intrinsics.checkNotNullParameter("ttlive_get_effect_sdk_version_status", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        b12.b.b(z.a("ttlive_get_effect_sdk_version_status"), r18, 1);
        Intrinsics.checkNotNullParameter("ttlive_get_effect_sdk_version_status", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        b12.b.b(z.b("ttlive_get_effect_sdk_version_status"), r18, 1);
        r14 = r16;
        goto L17
    L16:
        r14 = a12.a.a(false, r10, r13);
        goto L17
    L5:
        r13 = "0";
        goto L7
    }

    public final void d4(int r10, boolean r11, long r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "traceFlag");
        ArrayList r0 = new ArrayList();
        r0.add(Long.valueOf(r12));
        ji(r10, r11, r0, r13);
    }

    public final boolean ib(com.bytedance.android.live.core.resources.e r10, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r11, int r12, AssetDownloadPriority r13) {
        ArrayList r0 = new ArrayList();
        if (r12 == 10) goto L12;
        if (r12 == 20) goto L12;
        if (r12 == 30) goto L12;
        List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.e> r1 = this.e.b(r10, 2);
        Iterator<T> r14 = r1.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r15 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r14.next();
        r15.d = IAssetsManager.a.a(r13, r12).getPriority();
        goto L9
    L11:
        r0.addAll(r1);
    L26:
        if (v.a() == true) goto L29;
    L37:
        return false;
    L29:
        if (r0.isEmpty() == false) goto L31;
        ToastUtil.b("下载失败", 0);
        goto L37
    L31:
        int r16 = r0.size();
        int r17 = 0;
    L32:
        if (r17 >= r16) goto L37;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r18 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) ListProtector.get(r0, r17);
        r18.a = true;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r19 = GiftResourceManagerFactory.a();
        if (r19 == null) goto L36;
        r19.c(r18, new com.bytedance.android.debug.c(this, r10, r11));
    L36:
        r17 = r17 + 1;
    L12:
        c12.e r20 = this.e.c(r10, r12);
        if (r20 == null) goto L15;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.assets.e) r20).d = IAssetsManager.a.a(r13, r12).getPriority();
    L16:
        if (r20 != null) goto L24;
        if (r12 != 10) goto L19;
        ToastUtil.b("该资源未配置H264", 0);
    L23:
        return false;
    L19:
        if (r12 != 20) goto L21;
        ToastUtil.b("该资源未配置H265", 0);
        goto L23
    L21:
        if (r12 != 30) goto L23;
        ToastUtil.b("该资源未配置H265超分", 0);
        goto L23
    L24:
        r0.add(r20);
        goto L26
    L15:
        r20 = null;
        goto L16
    }

    public final void ji(int r1, boolean r10, List<Long> r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "traceFlag");
        x(r1, false, r12);
    }

    public final boolean r0(long r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r10, int r11, AssetDownloadPriority r12) {
        Ne(G1(r1), r10, r11);
        return false;
    }
}
