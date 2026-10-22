package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.configmodel.c2;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.f2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.ai.GiftAsyncSortManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.utils.GiftImageFormat;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.FastGiftRecommendService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftListPagingService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.livesdk.gift.util.GiftListFetchAction;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.JsonParseException;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListRepo {
    public static final /* synthetic */ KProperty[] a = null;
    public static long b;
    public static int c;
    public static int d;
    public static final ReadOnlyProperty e = null;
    public static final Lazy f = null;
    public static final ReadOnlyProperty g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final GiftListRepo k = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(GiftListRepo.class, "LIVE_GIFT_LIST_CALLBACK_SCHEDULER_OPT", "getLIVE_GIFT_LIST_CALLBACK_SCHEDULER_OPT()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftListRepo.class, "LIVE_GIFT_LIST_REQUEST_ADVANCE_OPT", "getLIVE_GIFT_LIST_REQUEST_ADVANCE_OPT()Z", 0))};
        a = r0;
        k = new GiftListRepo();
        Boolean r3 = Boolean.FALSE;
        Class r4 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_callback_scheduler_opt", r3, r4, false);
        e = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        f = LazyKt.lazy(GiftListRepo$apiScheduleOpt$2.INSTANCE);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_request_advance_opt", r3, r4, false);
        g = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        h = LazyKt.lazy(GiftListRepo$createPanelRequestList$2.INSTANCE);
        i = LazyKt.lazy(GiftListRepo$addHeaderEnable$2.INSTANCE);
        j = LazyKt.lazy(GiftListRepo$asyncRequestAssets$2.INSTANCE);
    }

    public GiftListRepo() {
    }

    public static List c(List r3) {
        Intrinsics.checkNotNullParameter(r3, "giftPages");
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        w1 r1 = (w1) r4.next();
        if (r1.getDisplay() == false) goto L4;
        r0.addAll(r1.getGifts());
    L8:
        ArrayList r5 = new ArrayList(r0);
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.F.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[30])).booleanValue() == false) goto L11;
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r5);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r5, false, null);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r5);
    L12:
        return r5;
    L11:
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r5, false, null);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.d(r5);
        int r2 = com.bytedance.android.livesdk.gift.platform.core.utils.f.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.f.a(r5);
        goto L12
    }

    public static void d(com.bytedance.android.livesdk.gift.platform.core.model.i r6) {
        boolean r0 = com.bytedance.android.livesdk.gift.platform.business.i.h().w0();
        boolean r1 = com.bytedance.android.livesdk.gift.platform.business.i.h().T0();
        if (r0 == true) goto L6;
        w12.b.b = null;
        return;
    L6:
        f2 r2 = r6.imageTemplate;
        if (r2 == null) goto L11;
        ArrayList<String> r3 = w12.b.a;
        Intrinsics.checkNotNullParameter(r2, "imageTemplate");
        w12.b.b = r2;
        List<String> r4 = r2.getDomainList();
        if (r4 == null) goto L11;
        ArrayList r5 = new ArrayList(r4);
        ArrayList<String> r7 = w12.b.a;
        r7.clear();
        r7.addAll(r5);
    L11:
        f2 r8 = r6.imageTemplate;
        int r9 = 0;
        if (r8 == null) goto L30;
        List<String> r10 = r8.getDomainList();
        if (r10 != null) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == true) goto L30;
        List<? extends w1> r13 = r6.giftPages;
        if (r13 == null) goto L27;
        Iterator<T> r14 = r13.iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        w1 r15 = (w1) r14.next();
        GiftListRepo r16 = k;
        List<h1> r17 = r15.getGifts();
        r16.getClass();
        l(r17, r1);
    L27:
        List<? extends h1> r18 = r6.giftList;
        if (r18 == null) goto L30;
        k.getClass();
        l(r18, r1);
        goto L30
    L16:
        if (r10.isEmpty() == true) goto L19;
        r11 = false;
    L30:
        int r19 = com.bytedance.android.livesdk.gift.platform.business.i.h().M3();
        if (r19 <= 0) goto L78;
        List<? extends w1> r20 = r6.giftPages;
        if (r20 == null) goto L56;
        Iterator<T> r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L56;
        w1 r23 = (w1) r21.next();
        if (r23.getDisplay() == false) goto L36;
        List<h1> r24 = r23.getGifts();
        if (r24 == null) goto L36;
        Iterator<T> r25 = r24.iterator();
    L43:
        if (r25.hasNext() == false) goto L36;
        h1 r26 = (h1) r25.next();
        if (r26.isDisplayedOnPanel() == false) goto L43;
        if (r26.getImage() == null) goto L55;
        py.k r27 = r26.getImage();
        if (r27 == null) goto L43;
        List r28 = r27.getUrls();
        if (r28 == null) goto L43;
        if (r28.isEmpty() != true) goto L43;
    L55:
        r9 = r9 + 1;
    L56:
        if (r9 <= r19) goto L79;
        e(r9, "api");
        return;
    L79:
        return;
    }

    public static void f(JSONObject r8) {
        JSONObject r0 = new JSONObject();
        GiftDataStorageService r1 = com.bytedance.android.livesdk.gift.platform.core.utils.s.b();
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.b);
    L6:
        r0.put("send_count", r3);
        GiftDataStorageService r4 = com.bytedance.android.livesdk.gift.platform.core.utils.s.b();
        if (r4 == null) goto L9;
        r2 = Integer.valueOf(r4.a);
    L9:
        r0.put("send_diamond", r2);
        GiftDataStorageService r5 = com.bytedance.android.livesdk.gift.platform.core.utils.s.b();
        long r6 = 0;
        if (r5 == null) goto L12;
        long r7 = r5.c;
    L13:
        GiftDataStorageService r9 = com.bytedance.android.livesdk.gift.platform.core.utils.s.b();
        if (r9 == null) goto L16;
        long r10 = r9.d;
    L18:
        if (r7 <= 0) goto L20;
        r0.put("biggift", Float.valueOf(r10 / r7));
    L20:
        IRechargeService r11 = jc1.k.f(IRechargeService.class);
        if (r11 == null) goto L25;
        zv0.f r13 = r11.rechargeCenter();
        if (r13 == null) goto L25;
        r6 = r13.getAvailableDiamonds();
    L25:
        r0.put("available", r6);
        r8.put("gift_data", r0);
        return;
    L16:
        r10 = 0;
        goto L18
    L12:
        r7 = 0;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    @JvmStatic
    public static final void g(int r9) {
        k.getClass();
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        if (r1 != null) goto L8;
    L10:
        String r2 = BuildConfig.FLAVOR;
    L11:
        String r7 = r2;
        if (r1 == null) goto L14;
        long r3 = r1.getId();
    L15:
        long r4 = r3;
        if (r1 == null) goto L18;
        int r8 = (int) r1.getRoomLayout();
    L19:
        j(null, r4, r9, false, r7, r8);
        return;
    L18:
        r8 = 0;
        goto L19
    L14:
        r3 = 0;
        goto L15
    L8:
        if (r1.getOwner() == null) goto L10;
        IBaseUser r5 = r1.getOwner();
        Intrinsics.checkNotNull(r5);
        r2 = com.bytedance.android.live.base.model.user.o.a(r5);
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public static void e(int r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "from");
        w12.b.d = false;
        i12.e r2 = i12.o.b();
        Object r3 = null;
        if (r2 == null) goto L5;
        Object r4 = com.bytedance.android.scope.m.e.d(r2, GiftDataStorageService.class);
    L6:
        GiftDataStorageService r5 = (GiftDataStorageService) r4;
        if (r5 == null) goto L25;
        int r6 = r5.i;
        if (r6 >= 1) goto L26;
        int r7 = r6 + 1;
        r5.i = r7;
        String r10 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter(r9, "from");
        Pair[] r11 = {TuplesKt.to("fail_count", String.valueOf(r8)), TuplesKt.to("callback_count", String.valueOf(r7)), TuplesKt.to("from", r9)};
        LinkedHashMap r13 = new LinkedHashMap();
        MapsKt.putAll(r13, r11);
        mz0.n r14 = new mz0.n();
        Map r0 = r14.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Intrinsics.checkNotNullParameter(r13, "map");
        r0.putAll(r13);
        mz0.m r15 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r1 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r1, "pageSourceLog");
        ((ArrayList) r15.a).add(r1.a);
        r15.b(LogCommon.ROOM);
        ((ArrayList) r14.b).addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m r17 = com.bytedance.android.scope.m.e;
        r17.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((f80.a) r18).w3("livesdk_gift_image_error_template", r14.a, r14.b);
        i12.d r19 = i12.m.e2.a();
        if (r19 == null) goto L13;
        Object r20 = r17.d(r19, a2.class);
    L14:
        a2 r21 = (a2) r20;
        if (r21 == null) goto L18;
        r21.a(3, BuildConfig.FLAVOR);
        return;
    L18:
        i12.e r23 = i12.o.b();
        if (r23 == null) goto L21;
        r3 = r17.d(r23, com.bytedance.android.livesdk.gift.platform.core.giftlist.h.class);
    L21:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.h r24 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.h) r3;
        if (r24 == null) goto L27;
        r24.Kg();
        return;
    L27:
        return;
    L13:
        r20 = null;
        goto L14
    L26:
        return;
    L25:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static void l(List r3, boolean r4) {
        if (r3 == null) goto L15;
        Iterator r5 = r3.iterator();
    L5:
        if (r5.hasNext() == false) goto L21;
        h1 r0 = (h1) r5.next();
        py.k r1 = r0.getImage();
        if (r1 == null) goto L9;
        k.getClass();
        m(r1, r4);
    L9:
        py.k r2 = r0.getLeftLogo();
        if (r2 == null) goto L12;
        k.getClass();
        m(r2, r4);
    L12:
        py.k r6 = r0.getRightTopSelectedLabel();
        if (r6 == null) goto L5;
        k.getClass();
        m(r6, r4);
        goto L5
    L21:
        return;
    }

    public static void m(py.k r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "imageModel");
        boolean r1 = false;
        if (r9 == true) goto L29;
        Intrinsics.checkNotNullParameter(r8, "imageModel");
        List r10 = r8.getUrls();
        if (r10 != null) goto L7;
    L8:
        r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (r8.getUrls() != null) goto L14;
        r8.setUrls(new ArrayList());
    L14:
        if (r8.getUrls() == null) goto L57;
        String r11 = r8.getUri();
        if (r11 == null) goto L58;
        ArrayList<String> r0 = w12.b.a;
        Intrinsics.checkNotNullParameter(r11, "uri");
        if (w12.b.b != null) goto L20;
        ArrayList r13 = new ArrayList();
    L27:
        r8.setUrls(r13);
        return;
    L20:
        ArrayList r2 = new ArrayList();
        ArrayList<String> r3 = w12.b.a;
        if (r3 == null) goto L26;
        Iterator<String> r4 = r3.iterator();
    L24:
        if (r4.hasNext() == false) goto L26;
        String r6 = r4.next();
        StringBuilder r7 = new StringBuilder(180);
        r7.append(r6);
        r7.append("/img/");
        r7.append(r11);
        r7.append("~");
        r7.append(w12.b.c());
        r7.append(".");
        r7.append(w12.b.b());
        r2.add(r7.toString());
    L26:
        r13 = r2;
        goto L27
    L58:
        return;
    L57:
        return;
    L7:
        if (r10.isEmpty() == false) goto L9;
    L29:
        List r14 = r8.getUrls();
        if (r14 != null) goto L32;
    L33:
        r1 = true;
    L34:
        if (r1 != true) goto L59;
        String r15 = r8.getUri();
        if (r15 == null) goto L60;
        ArrayList<String> r5 = w12.b.a;
        List r16 = r8.getUrls();
        if ((r16 instanceof ArrayList) == true) goto L40;
        r16 = null;
    L40:
        ArrayList r17 = (ArrayList) r16;
        if (r17 != null) goto L43;
        r17 = new ArrayList();
    L43:
        Intrinsics.checkNotNullParameter(r15, "uri");
        Intrinsics.checkNotNullParameter(r17, "urlsList");
        if (w12.b.b == null) goto L52;
        ArrayList<String> r18 = w12.b.a;
        if (r18 == null) goto L52;
        Iterator<String> r19 = r18.iterator();
    L50:
        if (r19.hasNext() == false) goto L52;
        String r20 = r19.next();
        StringBuilder r21 = new StringBuilder(180);
        r21.append(r20);
        r21.append("/img/");
        r21.append(r15);
        r21.append("~");
        r21.append(w12.b.c());
        r21.append(".");
        r21.append(w12.b.b());
        r17.add(r21.toString());
    L52:
        r8.setUrls(r17);
        return;
    L60:
        return;
    L59:
        return;
    L32:
        if (r14.isEmpty() == false) goto L34;
        goto L33
    }

    public static final void b(GiftListRepo r6, int r7, boolean r8, long r9) {
        r6.getClass();
        i12.e r10 = i12.o.b();
        if (r10 == null) goto L5;
        Object r11 = com.bytedance.android.scope.m.e.d(r10, d1.class);
    L6:
        d1 r0 = (d1) r11;
        if (r0 == null) goto L10;
        r0.c(r7, r8, r9, "GiftListRepo");
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static void j(ca0.w r10, long r11, int r13, boolean r14, String r15, int r16) {
        h(r10, r11, r13, r14, r15, 0, r16, null);
    }

    @JvmStatic
    public static final void h(ca0.w r23, long r24, int r26, boolean r27, String r28, long r29, int r31, Map r33) {
        k(r23, r24, r24, 1, r26, r27, r28, r28, null, r29, r31, null, null, null, 0, null, r33, false, 194560);
    }

    @JvmStatic
    public static final void i(ca0.w r25, long r26, long r28, int r30, int r31, boolean r33, String r34, String r35, IEpisode r36) {
        k.getClass();
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        if (r1 == null) goto L8;
        int r15 = (int) r1.getRoomLayout();
    L9:
        k(r25, r26, r28, r30, r31, r33, r34, r35, r36, 0, r15, null, null, null, 0, null, null, false, 260096);
        return;
    L8:
        r15 = 0;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static void k(ca0.w r47, long r48, long r50, int r53, int r54, boolean r55, String r56, String r57, IEpisode r58, long r59, int r60, List r61, Long r63, Integer r64, long r65, String r66, Map r67, boolean r68, int r69) {
        if ((r69 & 1) == 0) goto L5;
        ca0.w r13 = null;
    L7:
        if ((r69 & 2048) == 0) goto L9;
        List r14 = null;
    L11:
        if ((r69 & 4096) == 0) goto L13;
        Long r1 = null;
    L15:
        if ((r69 & 8192) == 0) goto L17;
        Integer r16 = null;
    L19:
        if ((r69 & 16384) == 0) goto L21;
        long r17 = 0;
    L22:
        int r4 = 32768 & r69;
        String r7 = BuildConfig.FLAVOR;
        if (r4 == 0) goto L25;
        String r5 = BuildConfig.FLAVOR;
    L27:
        if ((65536 & r69) == 0) goto L29;
        Map r31 = null;
    L31:
        if ((r69 & 131072) == 0) goto L33;
        boolean r0 = false;
    L34:
        Context r9 = s1.getContext();
        int r10 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r9) == true) goto L38;
        return;
    L38:
        if (r48 == 0) goto L40;
        boolean r33 = true;
    L41:
        Ref.LongRef r11 = new Ref.LongRef();
        r11.element = 0;
        long r27 = System.currentTimeMillis();
        WeakReference r15 = new WeakReference(r13);
        boolean r19 = TextUtils.equals(r57, r56);
        yz0.k r6 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r6 == null) goto L44;
        IRoom r8 = r6.getRoom();
    L45:
        if (r8 == null) goto L51;
        IRoomOthersData r18 = r8.getRoomOthers();
        if (r18 == null) goto L51;
        IGroupLiveData r20 = r18.getGroupData();
        if (r20 == null) goto L51;
        boolean r21 = r20.isCurrentGroupLive();
    L52:
        i12.e r23 = i12.o.b();
        if (r23 == null) goto L55;
        Object r3 = com.bytedance.android.scope.m.e.d(r23, i0.class);
    L56:
        i0 r24 = (i0) r3;
        if (r24 == null) goto L60;
        ReceiverType r25 = r24.a();
        if (r25 == null) goto L60;
    L61:
        ReceiverType r26 = r25;
        boolean r28 = com.bytedance.android.livesdk.gift.platform.business.i.h().D1();
        if (r14 != null) goto L64;
    L67:
        boolean r34 = false;
    L68:
        if (r21 == false) goto L70;
        int r29 = 128;
    L71:
        i12.e r2 = i12.o.b();
        if (r2 == null) goto L74;
        Object r30 = com.bytedance.android.scope.m.e.d(r2, GiftReceiverRepoService.class);
    L75:
        GiftReceiverRepoService r35 = (GiftReceiverRepoService) r30;
        if (r35 == null) goto L78;
        IBaseUser r36 = GiftReceiverRepoService.g(r35, r57, null, 2);
    L79:
        if (r36 == null) goto L81;
        boolean r37 = true;
    L82:
        if (r57 != null) goto L84;
        String r38 = BuildConfig.FLAVOR;
    L85:
        if (r56 != null) goto L87;
        String r210 = BuildConfig.FLAVOR;
    L88:
        i12.e r110 = i12.o.b();
        if (r110 == null) goto L91;
        Object r111 = com.bytedance.android.scope.m.e.d(r110, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L92:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r112 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r111;
        if (r112 != null) goto L95;
    L97:
        boolean r113 = false;
    L98:
        if (r37 == true) goto L100;
        String r39 = BuildConfig.FLAVOR;
    L107:
        String r114 = r39;
        String r115 = BuildConfig.FLAVOR;
        String r116 = r210;
    L108:
        long r211 = Long.valueOf(((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).c5()).longValue();
        GiftListFetchAction r40 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).K3(r54);
        if (r40 != null) goto L111;
        r40 = GiftListFetchAction.FETCH_ACTION_DEFAULT;
    L111:
        GiftListFetchAction r310 = r40;
        if (w12.b.d == true) goto L114;
    L116:
        int r311 = 0;
    L118:
        if (r54 == 3) goto L120;
    L208:
        Long r212 = r1;
        r28 = r28;
        String r213 = BuildConfig.FLAVOR;
        r26 = r26;
        Ref.LongRef r610 = r11;
        String r41 = r213;
        String r43 = r41;
    L209:
        GiftContext r44 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r44 == null) goto L253;
        k.getClass();
        JSONObject r117 = new JSONObject();
        Bundle r118 = (Bundle) r44.getGiftLogExtra().getValue();     // Catch: JSONException -> L247
        if (r118 == null) goto L217;
        String r119 = r118.getString("gift_show_from");     // Catch: JSONException -> L247
        if (r119 == null) goto L217;
    L218:
        r117.put("gift_show_from", r119);     // Catch: JSONException -> L247
        Bundle r45 = (Bundle) r44.getGiftLogExtra().getValue();     // Catch: JSONException -> L247
        if (r45 == null) goto L223;
        String r46 = r45.getString("gift_send_times");     // Catch: JSONException -> L247
        if (r46 == null) goto L223;
    L224:
        r117.put("gift_send_times", r46);     // Catch: JSONException -> L247
        if (((ys1.b) com.bytedance.android.livesdk.gift.platform.business.b.m.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[11])).Q7() != true) goto L227;
    L228:
        f(r117);     // Catch: JSONException -> L247
        if (r54 != 10) goto L231;
    L232:
        com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).setFeatureParams(r117);     // Catch: JSONException -> L247
    L234:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L236;
    L240:
        if (r31 == null) goto L249;
        Iterator r49 = r31.entrySet().iterator();     // Catch: JSONException -> L247
    L242:
        if (r49.hasNext() == false) goto L249;
        Map.Entry r51 = (Map.Entry) r49.next();     // Catch: JSONException -> L247
        r117.put((String) r51.getKey(), r51.getValue());     // Catch: JSONException -> L247
    L249:
        String r70 = r117.toString();
        if (r70 == null) goto L253;
    L254:
        long r71 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.g) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.g.class)).J1();
        k.getClass();
        if (r54 != 0) goto L257;
        int r312 = 0;
    L279:
        if (((Boolean) i.getValue()).booleanValue() == false) goto L281;
        android.util.Pair r120 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new n());
    L282:
        tz0.b r121 = tz0.b.a;
        uz0.c r73 = new uz0.c();
        r121.getClass();
        Intrinsics.checkNotNullParameter(r73, "$this$beforeConfigureRequest");
        android.util.Pair r611 = r120;
        uz0.f r122 = new uz0.f(((uz0.a) r73).b);
        if (r59 == 0) goto L286;
        r122.a("required_gift_id", Long.valueOf(r59).toString());
    L286:
        String r410 = r5;
        if (r58 != null) goto L289;
    L291:
        if (r37 == false) goto L294;
        r122.a("room_id", r114);
        r122.a("to_room_id", r114);
        r122.a("video_linkmic_room_id", r115);
    L308:
        r122.a("gift_scene", Integer.valueOf(r29).toString());
        r122.a("to_open_id", r38);
        r122.a("anchor_open_id", r116);
        r122.a("fetch_giftlist_from", Integer.valueOf(r54).toString());
        r122.a("extra", r70);
        if (r14 != null) goto L352;
    L314:
        String r74 = r213;
    L315:
        r122.a("request_gift_ids", r74);
        if (r212 != null) goto L318;
    L320:
        r122.a("gift_base_version", Long.valueOf(r71).toString());
        r122.a("image_template_type", Integer.valueOf(r311).toString());
        r122.a("request_gift_pages", r41);
        if (r43 != null) goto L323;
        r43 = r213;
    L323:
        r122.a("platform_insert_gifts", r43);
        r122.a("action", String.valueOf(r310.getValue()));
        r122.a("current_fetch_strategy", String.valueOf(r211));
        if (TextUtils.isEmpty(r410) == true) goto L330;
        if (r410 != null) goto L327;
        String r75 = r213;
    L328:
        r122.a("request_search_words", r75);
        goto L330
    L327:
        r75 = r410;
    L330:
        if (r611 == null) goto L332;
        Map r76 = ((uz0.a) r73).a;
        Intrinsics.checkNotNullParameter(r76, "headersMap");
        String r77 = (String) r611.first;
        String r78 = (String) r611.second;
        Intrinsics.checkNotNullParameter(r77, "$this$setTo");
        Intrinsics.checkNotNullParameter(r78, "value");
        r76.put(r77, r78);
        Unit r79 = Unit.INSTANCE;
    L332:
        Intrinsics.checkNotNullParameter(r73, "$this$afterConfigureRequest");
        Ref.LongRef r123 = r610;
        boolean r80 = r28;
        Observable r81 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/list/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.platform.core.model.i.class)), Extra.class, ((uz0.a) r73).d, ((uz0.a) r73).a, ((uz0.a) r73).b, ((uz0.a) r73).c).doOnNext(new s(r123)).doOnNext(new t(r54)).doOnNext(new u(r80));
        GiftManagerKt r83 = GiftManagerKt.z;
        GiftListRepo r84 = k;
        r84.getClass();
        if (r54 != 3) goto L335;
        boolean r85 = ((Boolean) f.getValue()).booleanValue();
    L336:
        r83.getClass();
        Observable r86 = r81.compose(GiftManagerKt.E(r85));
        r84.getClass();
        if (r54 != 1) goto L339;
    L343:
        boolean r87 = false;
    L344:
        if (r87 == false) goto L346;
        r86 = RxCompatKt.b(r86, RxUtil.rxRetryHelper(3));
    L346:
        if (r34 == true) goto L348;
        b = com.bytedance.live.kmp.util.e.b();
    L348:
        d++;
        if (r86 == null) goto L372;
        r86.subscribe(new v(r54, r410, r55, r48, r50, r19, r53, r60, r13, r26, r34, r14, r16, r17, r56, r57, r58, r59, r80, r33, r312, r27, r123, r311, r31, r310), new w(r33, r53, r15, r34, r312, r55, r48));
        return;
    L372:
        return;
    L339:
        if (r54 == 2) goto L343;
        if (r54 == 13) goto L343;
        r87 = true;
        goto L344
    L335:
        r85 = false;
        goto L336
    L318:
        if (r212.longValue() == 0) goto L320;
        r122.a("selected_gift_id", r212.toString());
        goto L320
    L352:
        r74 = GsonProtectorUtils.toJson(GsonHelper.get(), r14);     // Catch: JsonParseException -> L312
    L313:
        if (r74 != null) goto L315;
    L312:
        r74 = r213;
        goto L313
    L294:
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L300;
        GiftContext r88 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r88 == null) goto L300;
        com.bytedance.live.datacontext.n<IRoom> r89 = r88.getRoom();
        if (r89 == null) goto L300;
        IRoom r90 = (IRoom) r89.getValue();
    L301:
        if (r90 == null) goto L303;
        IEpisodeExtraInfo r124 = r90.getEpisodeExtra();
    L304:
        if (r124 == null) goto L306;
        IEpisodeExtraInfo r91 = r90.getEpisodeExtra();
        Intrinsics.checkNotNull(r91);
        long r93 = r91.getId();
    L307:
        r122.a("room_id", Long.valueOf(r48).toString());
        r122.a("to_room_id", Long.valueOf(r50).toString());
        r122.a("to_episode_id", Long.valueOf(r93).toString());
        goto L308
    L306:
        r93 = 0;
        goto L307
    L303:
        r124 = null;
    L300:
        r90 = null;
        goto L301
    L289:
        if (r58.getIdExt() <= 0) goto L291;
        r122.a("room_id", Long.valueOf(r58.getRoomIdExt()).toString());
        r122.a("to_room_id", Long.valueOf(r58.getRoomIdExt()).toString());
        r122.a("to_episode_id", Long.valueOf(r58.getIdExt()).toString());
        goto L308
    L281:
        r120 = null;
        goto L282
    L257:
        if (r54 != 1) goto L259;
        r312 = 1;
        goto L279
    L259:
        if (r54 != 2) goto L261;
    L275:
        r312 = 2;
        goto L279
    L261:
        if (r54 != 3) goto L263;
        r312 = 3;
        goto L279
    L263:
        if (r54 != 4) goto L265;
        r312 = 4;
        goto L279
    L265:
        if (r54 != 5) goto L267;
        r312 = 5;
        goto L279
    L267:
        if (r54 != 12) goto L269;
        r312 = IAssetsManager.DownloadAssetsSource.SOURCE_GIFT_PANEL_LOAD_MORE;
        goto L279
    L269:
        if (r54 == 13) goto L275;
        r312 = -1;
        goto L279
    L236:
        if (r54 != 11) goto L240;
        if (((c2) com.bytedance.android.livesdk.gift.platform.business.a.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[13])).a() == false) goto L240;
        ((GiftAsyncSortManager) GiftAsyncSortManager.e.getValue()).getClass();     // Catch: JSONException -> L247
        Intrinsics.checkNotNullParameter(r117, "extraObject");     // Catch: JSONException -> L247
        r117.put("pitaya_feature", null);     // Catch: JSONException -> L247
        goto L240
    L231:
        if (r54 != 11) goto L234;
    L227:
        if (((c2) com.bytedance.android.livesdk.gift.platform.business.a.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[13])).b() == false) goto L234;
    L223:
        r46 = r213;
    L217:
        r119 = r213;
    L247:
        e = move-exception;
        jy0.b.c("GiftManager", "message: " + e.getMessage(), null, 4);
    L253:
        r70 = r213;
        goto L254
    L120:
        if (r26 != ReceiverType.Anchor) goto L208;
        e1 r94 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        if (com.bytedance.android.livesdk.gift.platform.business.b.h().b() == true) goto L124;
        r212 = r1;
        r28 = r28;
        String r95 = BuildConfig.FLAVOR;
        r26 = r26;
        r610 = r11;
    L156:
        if (r95 != null) goto L158;
        r95 = BuildConfig.FLAVOR;
    L158:
        e1.f();
        JSONObject r96 = new JSONObject();
        if (com.bytedance.android.livesdk.gift.platform.core.h.o().contains(BuildConfig.FLAVOR) == true) goto L161;
        r213 = BuildConfig.FLAVOR;
    L207:
        r43 = r96.toString();
        r41 = r95;
        goto L209
    L161:
        if (com.bytedance.android.livesdk.gift.platform.business.b.e() == false) goto L183;
        i12.e r97 = i12.o.b();
        if (r97 == null) goto L165;
        Object r98 = com.bytedance.android.scope.m.e.d(r97, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i.class);
    L166:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i r99 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i) r98;
        if (r99 == null) goto L182;
        LongSparseArray<Integer> r100 = new LongSparseArray();
        GiftListPanelRepository r125 = r99.g;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r126 = r99.i;
        IBaseUser r214 = r126.i();
        if (r214 != null) goto L171;
        r214 = r99.h.a();
    L171:
        List r101 = (List) r125.c(r126.h(r214)).getSecond();
        if (r101 == null) goto L181;
        Iterator r102 = r101.iterator();
    L175:
        if (r102.hasNext() == false) goto L181;
        com.bytedance.android.livesdk.gift.platform.core.giftlist.p r127 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.p) r102.next();
        if (r127 == null) goto L175;
        h1 r128 = r127.a;
        if (r128 == null) goto L175;
        r100.append(r128.getId(), Integer.valueOf(r127.b));
        r102 = r102;
        r7 = r7;
    L181:
        r213 = r7;
        LongSparseArray<Integer> r103 = r100;
    L201:
        if (r103 == null) goto L207;
        int r104 = r103.size();
        int r105 = 0;
    L203:
        if (r105 >= r104) goto L205;
        long r313 = r103.keyAt(r105);
        r96.put(String.valueOf(r313), ((Number) r103.valueAt(r105)).intValue() + 1);
        r105 = r105 + 1;
        goto L203
    L205:
        Unit r106 = Unit.INSTANCE;
        goto L207
    L182:
        r213 = BuildConfig.FLAVOR;
    L200:
        r103 = null;
        goto L201
    L165:
        r98 = null;
        goto L166
    L183:
        r213 = BuildConfig.FLAVOR;
        i12.d r107 = i12.m.e2.a();
        if (r107 == null) goto L186;
        Object r108 = com.bytedance.android.scope.m.e.d(r107, GiftListSortDataStore.class);
    L187:
        GiftListSortDataStore r109 = (GiftListSortDataStore) r108;
        if (r109 == null) goto L190;
        LongSparseArray<Integer> r129 = r109.f;
    L191:
        if (r129 == null) goto L193;
        r103 = r109.f;
        goto L201
    L193:
        i12.e r130 = i12.o.b();
        if (r130 == null) goto L196;
        Object r131 = com.bytedance.android.scope.m.e.d(r130, f1.class);
    L197:
        f1 r132 = (f1) r131;
        if (r132 == null) goto L200;
        r103 = r132.d;
        goto L201
    L196:
        r131 = null;
        goto L197
    L190:
        r129 = null;
        goto L191
    L186:
        r108 = null;
        goto L187
    L124:
        JSONObject r133 = new JSONObject();
        if (com.bytedance.android.livesdk.gift.platform.business.b.e() == false) goto L133;
        i12.e r134 = i12.o.b();
        if (r134 == null) goto L129;
        Object r135 = com.bytedance.android.scope.m.e.d(r134, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i.class);
    L130:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i r136 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i) r135;
        if (r136 == null) goto L136;
        List<w1> r137 = r136.d().c;
    L137:
        if (r137 == null) goto L155;
        Iterator r138 = r137.iterator();
    L140:
        if (r138.hasNext() == false) goto L155;
        w1 r139 = (w1) r138.next();
        JSONArray r140 = new JSONArray();
        r138 = r138;
        List<Integer> r141 = com.bytedance.android.livesdk.gift.platform.business.b.h().a();
        if (r141 == null) goto L140;
        Ref.LongRef r612 = r11;
        if (r141.contains(Integer.valueOf(r139.getPageType())) != true) goto L152;
        List<h1> r142 = r139.getGifts();
        if (r142 == null) goto L151;
        Iterator r143 = r142.iterator();
    L149:
        if (r143.hasNext() == false) goto L151;
        r140.put(((h1) r143.next()).getId());
        r1 = r1;
        r143 = r143;
    L151:
        Long r215 = r1;
        r133.put(String.valueOf(r139.getPageType()), r140);
    L153:
        r11 = r612;
        r1 = r215;
        goto L140
    L152:
        r215 = r1;
    L155:
        r212 = r1;
        r610 = r11;
        r95 = r133.toString();
    L136:
        r137 = null;
        goto L137
    L129:
        r135 = null;
        goto L130
    L133:
        r28 = r28;
        r26 = r26;
        com.bytedance.android.livesdk.gift.platform.core.model.j r144 = r94.N3();
        if (r144 == null) goto L136;
        r137 = r144.c;
        goto L137
    L114:
        if (com.bytedance.android.livesdk.gift.platform.business.i.h().w0() == false) goto L116;
        r311 = 1;
        goto L118
    L100:
        if (r113 == false) goto L102;
        r39 = String.valueOf(r48);
        jy0.b.d("NewVideoLinkAnchor", "syncGiftList change isAllMic=true " + r39);
        goto L107
    L102:
        if (r36 == null) goto L104;
        long r216 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r36);
    L105:
        String r145 = String.valueOf(r216);
        String r146 = String.valueOf(r48);
        r13 = r13;
        jy0.b.d("NewVideoLinkAnchor", "syncGiftList change isAllMic=false " + r38 + ' ' + r145 + ' ' + r146);
        r116 = r38;
        r115 = r146;
        r114 = r145;
        goto L108
    L104:
        r216 = r50;
        goto L105
    L95:
        if (r112.j() != true) goto L97;
        r113 = true;
        goto L98
    L91:
        r111 = null;
        goto L92
    L87:
        r210 = r56;
        goto L88
    L84:
        r38 = r57;
        goto L85
    L81:
        r37 = false;
        goto L82
    L78:
        r36 = null;
        goto L79
    L74:
        r30 = null;
        goto L75
    L70:
        r29 = r53;
        goto L71
    L64:
        if ((!r14.isEmpty()) != true) goto L67;
        if (r0 == true) goto L67;
        r34 = true;
    L60:
        r25 = ReceiverType.Anchor;
        goto L61
    L55:
        r3 = null;
    L51:
        r21 = false;
        goto L52
    L44:
        r8 = null;
        goto L45
    L40:
        r33 = false;
        goto L41
    L33:
        r0 = r68;
        goto L34
    L29:
        r31 = r67;
        goto L31
    L25:
        r5 = r66;
        goto L27
    L21:
        r17 = r65;
        goto L22
    L17:
        r16 = r64;
        goto L19
    L13:
        r1 = r63;
        goto L15
    L9:
        r14 = r61;
        goto L11
    L5:
        r13 = r47;
        goto L7
    }

    public static final void a(GiftListRepo r26, com.bytedance.android.livesdk.gift.platform.core.model.i r27, boolean r28, long r29, long r31, int r33, int r34, int r35, long r36, ca0.w r38, ReceiverType r39, boolean r40, List r41, Integer r43, long r44, String r45, String r46, IEpisode r47, long r48, boolean r50, String r51) {
        if (r50 == true) goto L5;
        r26.getClass();
        d(r27);
    L6:
        boolean r8 = true;
        if (((com.bytedance.android.livesdk.gift.configmodel.m0) com.bytedance.android.livesdk.gift.platform.core.h.g0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[57])).a() == false) goto L28;
        List<? extends w1> r0 = r27.giftPages;
        if (r0 != null) goto L11;
    L25:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.A(0, -1, r33, BuildConfig.FLAVOR);
    L26:
        Object r3 = null;
    L296:
        List<? extends w1> r1 = r27.giftPages;
        i12.e r2 = i12.o.b();
        if (r2 == null) goto L299;
        Object r10 = com.bytedance.android.scope.m.e.d(r2, GiftListPagingService.class);
    L300:
        GiftListPagingService r11 = (GiftListPagingService) r10;
        if (r40 == false) goto L306;
        if (r43 == null) goto L366;
        r43.intValue();
        if (r11 == null) goto L367;
        r11.a(r39, CollectionsKt.listOf(r43));
        return;
    L367:
        return;
    L366:
        return;
    L306:
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r1.iterator();
    L308:
        if (r5.hasNext() == false) goto L318;
        Object r6 = r5.next();
        List<c1> r7 = ((w1) r6).getBaseGifts();
        if (r7 == null) goto L315;
        if ((!r7.isEmpty()) != true) goto L315;
        boolean r9 = true;
    L316:
        if (r9 == false) goto L308;
        r4.add(r6);
    L315:
        r9 = false;
        goto L316
    L318:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r14 = r4.iterator();
    L320:
        if (r14.hasNext() == false) goto L323;
        r13.add(Integer.valueOf(((w1) r14.next()).getPageType()));
        goto L320
    L323:
        if ((!r13.isEmpty()) == false) goto L369;
        if (r11 == null) goto L370;
        r11.h(new GiftListPagingService.b(r29, r31, r34, r28, r45, r46, r47, r48, r35));
        r11.a(r39, r13);
        return;
    L370:
        return;
    L369:
        return;
    L299:
        r10 = r3;
        goto L300
    L11:
        if (r0.size() == 0) goto L25;
        List<? extends w1> r15 = r27.giftPages;
        if (r15 == null) goto L28;
        Iterator<T> r16 = r15.iterator();
    L17:
        if (r16.hasNext() == false) goto L28;
        w1 r17 = (w1) r16.next();
        if (r17.getPageType() != 1) goto L17;
        int r18 = RangesKt.coerceAtLeast(r17.getGifts().size(), r17.getLiteGifts().size());
        if (r18 == 0) goto L24;
        if (r18 >= ((com.bytedance.android.livesdk.gift.configmodel.m0) com.bytedance.android.livesdk.gift.platform.core.h.g0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[57])).b()) goto L17;
    L24:
        String r19 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.A(r27.giftPages.size(), 0, r33, BuildConfig.FLAVOR);
    L28:
        if (r39 != ReceiverType.Anchor) goto L103;
        i12.e r20 = i12.o.b();
        if (r20 == null) goto L32;
        Object r21 = com.bytedance.android.scope.m.e.d(r20, f1.class);
    L33:
        f1 r23 = (f1) r21;
        if (r23 == null) goto L103;
        Intrinsics.checkNotNullParameter(r27, "giftListResult");
        if (r23.a.b() == false) goto L103;
        long r24 = System.currentTimeMillis();
        List<? extends w1> r25 = r27.giftPages;
        if (r25 == null) goto L101;
        Iterator r30 = r25.iterator();
    L42:
        if (r30.hasNext() == false) goto L101;
        w1 r37 = (w1) r30.next();
        if (r37.getDisplay() == false) goto L99;
        List<h1> r49 = r37.getGifts();
        if (r49 == null) goto L99;
        if ((r49.isEmpty() ^ r8) != r8) goto L99;
        List<Integer> r53 = r23.a.c();
        if (r53 == null) goto L99;
        if (r53.contains(Integer.valueOf(r37.getPageType())) != r8) goto L99;
        Map<Integer, Long> r54 = r37.getForceInsertMap();
        if (r54 == null) goto L56;
        int r55 = r54.size();
    L57:
        if (r55 <= 0) goto L59;
        boolean r56 = true;
    L60:
        int r57 = r37.getGifts().size();
        LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r58 = new LongSparseArray();
        int r110 = 0;
        int r111 = 0;
    L61:
        if (r110 >= r57) goto L97;
        h1 r59 = (h1) ListProtector.get(r37.getGifts(), r110);
        if (r59.isDisplayedOnPanel() == true) goto L65;
    L92:
        Iterator r112 = r30;
        int r113 = r57;
    L94:
        if (r111 >= r23.b) goto L98;
        r110 = r110 + 1;
        r30 = r112;
        r57 = r113;
    L98:
        r23.c.put(Integer.valueOf(r37.getPageType()), r58);
    L100:
        r30 = r112;
        r8 = true;
        goto L42
    L65:
        if (r111 >= r23.b) goto L92;
        com.bytedance.android.livesdk.gift.platform.core.model.o r60 = new com.bytedance.android.livesdk.gift.platform.core.model.o(r59, r111, r24, r37.getPageType(), r59.getType());
        String r114 = r60.e();
        if (r114 != null) goto L69;
    L72:
        boolean r115 = true;
    L73:
        if (r115 == false) goto L81;
        r112 = r30;
        r113 = r57;
        LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r61 = r23.c.get(Integer.valueOf(r37.getPageType()));
        if (r61 == null) goto L82;
        com.bytedance.android.livesdk.gift.platform.core.model.o r63 = (com.bytedance.android.livesdk.gift.platform.core.model.o) r61.get(r59.getId());
        if (r63 == null) goto L82;
        String r64 = r63.e();
        if (r64 == null) goto L82;
        r60.f(r64);
    L82:
        r58.append(r59.getId(), r60);
        if (r56 == false) goto L91;
        Map<Integer, Long> r65 = r37.getForceInsertMap();
        if (r65 != null) goto L87;
    L89:
        r60.g(0);
        goto L91
    L87:
        if (r65.containsKey(Integer.valueOf((int) r59.getId())) != true) goto L89;
        r60.g(1);
    L91:
        r111 = r111 + 1;
        goto L94
    L81:
        r112 = r30;
        r113 = r57;
        goto L82
    L69:
        if (r114.length() == 0) goto L72;
        r115 = false;
        goto L73
    L97:
        r112 = r30;
        goto L98
    L59:
        r56 = false;
        goto L60
    L56:
        r55 = 0;
    L99:
        r112 = r30;
    L101:
        r23.e = r24;
        goto L103
    L32:
        r21 = null;
    L103:
        if (r33 == 2) goto L111;
        if (r33 == 3) goto L111;
        if (r33 == 13) goto L111;
        if (r33 == 15) goto L111;
        if (r33 == 16) goto L111;
    L171:
        boolean r66 = ((Boolean) GiftImageFormat.a.getValue()).booleanValue();
        ArrayList r67 = new ArrayList();
        long r68 = (System.currentTimeMillis() - r36) / 1000;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.e() == false) goto L178;
        GiftContext r69 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r69 == null) goto L178;
        com.bytedance.live.datacontext.i<Map<Long, String>> r70 = r69.getGiftExhibitionMap();
        if (r70 == null) goto L178;
        Map r71 = (Map) r70.getValue();
    L180:
        if (GiftPanelBizBoostUtils.e() == false) goto L186;
        GiftContext r73 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r73 == null) goto L186;
        com.bytedance.live.datacontext.i<Map<Long, com.bytedance.android.livesdk.gift.platform.core.l>> r74 = r73.getGiftIdMapToInfo();
        if (r74 == null) goto L186;
        Map r75 = (Map) r74.getValue();
    L187:
        List<? extends w1> r76 = r27.giftPages;
        if (r76 == null) goto L218;
        Iterator<? extends w1> r77 = r76.iterator();
    L191:
        if (r77.hasNext() == false) goto L218;
        w1 r116 = r77.next();
        Iterator<h1> r117 = r116.getGifts().iterator();
    L194:
        if (r117.hasNext() == false) goto L217;
        h1 r78 = r117.next();
        r78.setNowTimeDiffSeconds(r68);
        r78.getTopBarText();
        if (r71 != null) goto L203;
        GiftContext r118 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r118 == null) goto L202;
        com.bytedance.live.datacontext.i<Map<Long, String>> r119 = r118.getGiftExhibitionMap();
        if (r119 == null) goto L202;
        Map r79 = (Map) r119.getValue();
    L204:
        if (r79 == null) goto L206;
        String r80 = (String) r79.put(Long.valueOf(r78.getId()), r78.getTopBarText());
    L206:
        if (r75 != null) goto L213;
        GiftContext r81 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r81 == null) goto L212;
        com.bytedance.live.datacontext.i<Map<Long, com.bytedance.android.livesdk.gift.platform.core.l>> r83 = r81.getGiftIdMapToInfo();
        if (r83 == null) goto L212;
        Map r84 = (Map) r83.getValue();
    L214:
        if (r84 == null) goto L216;
        com.bytedance.android.livesdk.gift.platform.core.l r85 = (com.bytedance.android.livesdk.gift.platform.core.l) r84.put(Long.valueOf(r78.getId()), new com.bytedance.android.livesdk.gift.platform.core.l(r78.getGiftTip()));
    L216:
        r78.enableImageFormatOpt(r66);
        r78.enableDomainOpt(((Boolean) GiftImageFormat.b.getValue()).booleanValue());
    L212:
        r84 = null;
        goto L214
    L213:
        r84 = r75;
    L202:
        r79 = null;
        goto L204
    L203:
        r79 = r71;
        goto L204
    L217:
        r67.add(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0.d(r116));
    L218:
        ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).J2(r27, r35, r33, r28, r67, r39, r40, r41, r43, r44, r29, r51);
        Long r86 = r27.defaultTabId;
        if (r86 == null) goto L221;
        ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).R((int) r86.longValue());
    L221:
        if (r40 == true) goto L245;
        i12.e r87 = i12.o.b();
        if (r87 == null) goto L225;
        Object r120 = com.bytedance.android.scope.m.e.d(r87, q0.class);
    L226:
        q0 r121 = (q0) r120;
        if (r121 == null) goto L245;
        r121.d(r27.giftPages);
        List<? extends w1> r88 = r27.giftPages;
        Intrinsics.checkNotNullParameter(r88, "pageList");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.d() == false) goto L245;
        Iterator<T> r89 = r88.iterator();
    L232:
        if (r89.hasNext() == false) goto L239;
        Object r90 = r89.next();
        if (((w1) r90).getPageType() != 15) goto L236;
        boolean r91 = true;
    L237:
        if (r91 == false) goto L232;
    L240:
        w1 r93 = (w1) r90;
        if (r93 == null) goto L243;
        List<o2> r94 = r93.getScrollPageNames();
    L244:
        r121.c = r94;
        goto L245
    L243:
        r94 = null;
        goto L244
    L236:
        r91 = false;
        goto L237
    L239:
        r90 = null;
        goto L240
    L225:
        r120 = null;
    L245:
        com.bytedance.android.livesdk.gift.platform.core.model.u r95 = r27.giftsInfo;
        if (r95 != null) goto L248;
        int r96 = r33;
        ArrayList r97 = r67;
        int r98 = 3;
        r3 = null;
    L277:
        if (r38 != 0) goto L279;
    L282:
        i12.e r99 = i12.o.b();
        if (r99 == null) goto L285;
        Object r122 = com.bytedance.android.scope.m.e.d(r99, com.bytedance.android.livesdk.gift.platform.core.scope.service.f0.class);
    L286:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.f0 r123 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.f0) r122;
        if (r123 == null) goto L296;
        if (r96 == r98) goto L296;
        if (r96 == 2) goto L293;
    L295:
        r123.a();
        goto L296
    L293:
        if (r123.a.e() == false) goto L295;
    L285:
        r122 = r3;
        goto L286
    L279:
        if (nz1.a.a() == false) goto L281;
        Single.create(new o(r38, r97)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L282
    L281:
        r38.b(r97);
        goto L282
    L248:
        r3 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.o.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[13])).booleanValue() == false) goto L271;
        r96 = r33;
        r98 = 3;
        if (r96 == 3) goto L272;
        GiftContext r100 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r100 == null) goto L259;
        com.bytedance.live.datacontext.n<IRoom> r101 = r100.getRoom();
        if (r101 == null) goto L259;
        IRoom r102 = (IRoom) r101.getValue();
        if (r102 == null) goto L259;
        Long r124 = Long.valueOf(r102.getId());
    L260:
        JSONObject r103 = new JSONObject().putOpt("predict_type", "gift_show");
        GiftContext r104 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r104 == null) goto L265;
        com.bytedance.live.datacontext.n<IRoom> r105 = r104.getRoom();
        if (r105 == null) goto L265;
        IRoom r106 = (IRoom) r105.getValue();
    L266:
        r97 = r67;
        wp2.c r107 = new wp2.c(r103.putOpt("room_params", r106), new r(r124, r97, r96));
        GiftDataStorageService r108 = com.bytedance.android.livesdk.gift.platform.core.utils.s.b();
        if (r108 == null) goto L269;
        r108.o = -2;
    L269:
        vh6.c.b(rq2.a.class).yc(r107);
    L273:
        Map<String, String> r109 = r95.getMsgProcessFilter();
        if (r109 == null) goto L277;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.message.a.class).Hi().putAll(r109);
    L265:
        r106 = null;
    L259:
        r124 = null;
    L272:
        Completable.complete().observeOn(Schedulers.computation()).subscribe(new p(r96, r67));
        goto L273
    L271:
        r96 = r33;
        r98 = 3;
    L186:
        r75 = null;
    L178:
        r71 = null;
    L111:
        i12.e r125 = i12.o.b();
        if (r125 == null) goto L114;
        Object r126 = com.bytedance.android.scope.m.e.d(r125, f1.class);
    L115:
        f1 r127 = (f1) r126;
        if (r127 == null) goto L147;
        List<? extends com.bytedance.android.livesdk.gift.model.a2> r128 = r27.giftSortStrategyList;
        ((ArrayList) r127.g).clear();
        if (r128 == null) goto L147;
        ((ArrayList) r127.g).addAll(r128);
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r128.iterator();
    L122:
        if (r130.hasNext() == false) goto L130;
        Object r131 = r130.next();
        if (((com.bytedance.android.livesdk.gift.model.a2) r131).getStrategyType() != 1) goto L126;
        boolean r210 = true;
    L127:
        if (r210 == false) goto L122;
        r129.add(r131);
        goto L122
    L126:
        r210 = false;
        goto L127
    L130:
        if ((!r129.isEmpty()) == true) goto L133;
        r129 = null;
    L133:
        if (r129 == null) goto L147;
        r127.g(r129);
        ArrayList r132 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r133 = r129.iterator();
    L136:
        if (r133.hasNext() == false) goto L139;
        r132.add(((com.bytedance.android.livesdk.gift.model.a2) r133.next()).getScene());
        goto L136
    L139:
        if (r132.isEmpty() == true) goto L142;
        TextUtils.join("-", r132);
    L142:
        Iterator r134 = r129.iterator();
    L144:
        if (r134.hasNext() == false) goto L147;
        com.bytedance.android.livesdk.gift.model.a2 r135 = (com.bytedance.android.livesdk.gift.model.a2) r134.next();
        r127.k.a(r135.getScene(), r135.getEventTrack());
    L147:
        i12.e r136 = i12.o.b();
        if (r136 == null) goto L150;
        Object r137 = com.bytedance.android.scope.m.e.d(r136, FastGiftRecommendService.class);
    L151:
        FastGiftRecommendService r138 = (FastGiftRecommendService) r137;
        if (r138 == null) goto L171;
        List<? extends com.bytedance.android.livesdk.gift.model.a2> r139 = r27.giftSortStrategyList;
        if (r139 == null) goto L171;
        ArrayList r140 = new ArrayList();
        Iterator<T> r141 = r139.iterator();
    L157:
        if (r141.hasNext() == false) goto L165;
        Object r142 = r141.next();
        if (((com.bytedance.android.livesdk.gift.model.a2) r142).getStrategyType() != 1) goto L161;
        boolean r143 = true;
    L162:
        if (r143 == false) goto L157;
        r140.add(r142);
        goto L157
    L161:
        r143 = false;
        goto L162
    L165:
        if ((!r140.isEmpty()) == true) goto L168;
        r140 = null;
    L168:
        if (r140 == null) goto L171;
        r138.c(r140);
        goto L171
    L150:
        r137 = null;
        goto L151
    L114:
        r126 = null;
        goto L115
    L5:
        r26.getClass();
        goto L6
    }
}
