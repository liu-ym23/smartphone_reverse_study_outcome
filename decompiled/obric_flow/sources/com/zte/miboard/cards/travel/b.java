package com.zte.miboard.cards.travel;

import ai.j0;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.m;
import c.o;
import c.s0;
import c.v;
import c.x;
import cn.nubia.neopush.commons.AppUtil;
import cn.nubia.neopush.commons.Constant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.behavior.ui.utils.n;
import com.zte.miboard.cards.AppCallbackUtils;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.travel.data.FlightData;
import com.zte.miboard.cards.travel.data.HotelData;
import com.zte.miboard.cards.travel.data.IntelligentAgentData;
import com.zte.miboard.cards.travel.data.MatchData;
import com.zte.miboard.cards.travel.data.TrainData;
import com.zte.miboard.cards.travel.data.TravelData;
import com.zte.miboard.cards.travel.net.data.FlightReq;
import com.zte.miboard.cards.travel.net.data.GaodePoiResult;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static String f16453a = "miboard.travel.switches_state_changed";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<f> f16454b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<f> f16455c = null;
    private static final ArrayList<f> d = null;
    private static volatile HashMap<f, ArrayList<? extends TravelData>> e;
    private static volatile HashMap<f, ArrayList<h>> f;
    private static volatile boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile HashMap<f, Boolean> f16456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Comparator<TravelData> f16457i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f16458a;

        public a(f r5) {
            this.f16458a = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r5 = ((ArrayList) b.a().get(this.f16458a)).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ((h) r5.next()).a(this.f16458a, new ArrayList((Collection) b.b().get(this.f16458a)));
            goto L4
        }
    }

    /* JADX INFO: renamed from: com.zte.miboard.cards.travel.b$b, reason: collision with other inner class name */
    public class C0028b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TravelData f16459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f16460b;

        public C0028b(TravelData r5, Context r10) {
            this.f16459a = r5;
            this.f16460b = r10;
        }

        @Override // mt.u
        public void onComplete() {
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            m.j("TravelUtils", "onTravelDataAdded queryPlaceInfo onError travelData=" + this.f16459a, r5);
        }

        @Override // mt.u
        public void onNext(Object r5) {
            m.i("TravelUtils", "onTravelDataAdded queryPlaceInfo onNext travelData=" + this.f16459a);
            if (r5 == null) goto L21;
            String r10 = new Gson().toJson(r5);     // Catch: Throwable -> L16
            if (TextUtils.isEmpty(r10) == true) goto L22;
            GaodePoiResult r11 = (GaodePoiResult) new Gson().fromJson(r10, GaodePoiResult.class);     // Catch: Throwable -> L16
            if (r11 != null) goto L9;
            return;
        L9:
            if (r11.isAvailable() == false) goto L24;
            TravelData.LngLat r12 = r11.getLngLat();     // Catch: Throwable -> L16
            if (r12 != null) goto L13;
            return;
        L13:
            if (r12.isAvailable() == false) goto L26;
            this.f16459a.fromStationLngLat = r12;     // Catch: Throwable -> L16
            m.i("TravelUtils", "onTravelDataAdded queryPlaceInfo onNext updateTravelData travelData=" + this.f16459a);     // Catch: Throwable -> L16
            b.c(this.f16460b, this.f16459a);     // Catch: Throwable -> L16
            return;
        L26:
            return;
        L24:
            return;
        L22:
            return;
        L16:
            th = move-exception;
            m.j("TravelUtils", "onTravelDataAdded queryPlaceInfo onNext error travelData=" + this.f16459a, th);
            return;
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    public class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f16461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f16462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f16463c;

        public c(ArrayList r5, Context r10, ArrayList r11) {
            this.f16461a = r5;
            this.f16462b = r10;
            this.f16463c = r11;
        }

        @Override // mt.u
        public void onComplete() {
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            m.j("TravelUtils", "onTravelDataAdded requestFlightNetInfo onError, flightReqs=" + this.f16461a, r5);
        }

        @Override // mt.u
        public void onNext(Object r5) {
            m.i("TravelUtils", "onTravelDataAdded requestFlightNetInfo onNext flightReqs=" + this.f16461a);
            TravelCard.a(this.f16462b, this.f16461a, this.f16463c, r5);
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
        }
    }

    public class d extends TypeToken<HashMap<Object, Object>> {
        public d() {
        }
    }

    public class e implements Comparator<TravelData> {
        public e() {
        }

        public int a(TravelData r5, TravelData r10) {
            if (r5 == null) goto L14;
            if (r10 != null) goto L5;
            return 0;
        L5:
            if (r5.isAvailable() == true) goto L7;
            return 0;
        L7:
            if (r10.isAvailable() == true) goto L10;
            return 0;
        L10:
            if ((r5.getCurAvailableFromTimeLong() - r10.getCurAvailableFromTimeLong()) <= 0) goto L12;
            return 1;
        L12:
            return -1;
        L14:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(TravelData r5, TravelData r10) {
            return a(r5, r10);
        }
    }

    public static final enum f extends Enum<f> {
        public static final f d = null;
        public static final f e = null;
        public static final f f = null;
        public static final f g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ f[] f16464h = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<? extends TravelData> f16466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f16467c;

        static {
            d = new f("FLIGHT", 0, "flight", FlightData.class, R.layout.travel_card_item_flight);
            e = new f("TRAIN", 1, "train", TrainData.class, R.layout.travel_card_item_train);
            f = new f("HOTEL", 2, "hotel", HotelData.class, R.layout.travel_card_item_hotel);
            g = new f("MATCH", 3, "match", MatchData.class, R.layout.travel_card_item_match);
            f16464h = a();
        }

        private f(String r5, int r10, String r11, Class r12, int r13) {
            super(r5, r10);
            this.f16465a = r11;
            this.f16466b = r12;
            this.f16467c = r13;
        }

        private static /* synthetic */ f[] a() {
            return new f[]{d, e, f, g};
        }

        @Nullable
        private static f b(String r5) {
            Iterator r10 = b.c().iterator();
        L4:
            if (r10.hasNext() == false) goto L8;
            f r11 = (f) r10.next();
            if (r11.f16465a.equalsIgnoreCase(r5) == false) goto L4;
            return r11;
        L8:
            return null;
        }

        public static f valueOf(String r5) {
            return (f) Enum.valueOf(f.class, r5);
        }

        public static f[] values() {
            return (f[]) f16464h.clone();
        }

        public static /* synthetic */ f a(String r5) {
            return b(r5);
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f16468b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f16469c = null;
        public static final g d = null;
        public static final g e = null;
        public static final g f = null;
        public static final g g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ g[] f16470h = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f16471a;

        static {
            f16468b = new g("ADD", 0, "add");
            f16469c = new g("UPDATE", 1, "update");
            d = new g("DELETE", 2, Constant.ClientMessageType.DELETE);
            e = new g("CHANGE", 3, "change");
            f = new g("PUSH", 4, "push");
            g = new g("FORCE", 5, "force");
            f16470h = a();
        }

        private g(String r5, int r10, String r11) {
            super(r5, r10);
            this.f16471a = r11;
        }

        private static /* synthetic */ g[] a() {
            return new g[]{f16468b, f16469c, d, e, f, g};
        }

        public static g valueOf(String r5) {
            return (g) Enum.valueOf(g.class, r5);
        }

        public static g[] values() {
            return (g[]) f16470h.clone();
        }

        @Nullable
        public static g a(String r5) {
            g[] r10 = values();
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            g r13 = r10[r12];
            if (r13.f16471a.equalsIgnoreCase(r5) == true) goto L6;
            r12 = r12 + 1;
            goto L3
        L6:
            return r13;
        L8:
            return null;
        }
    }

    public interface h {
        void a(@NonNull f r5, @NonNull ArrayList<? extends TravelData> r10);
    }

    static {
        List<f> r5 = Arrays.asList(new f[]{f.d, f.e, f.f});
        f16454b = r5;
        f16455c = Arrays.asList(new f[]{f.g});
        ArrayList<f> r10 = new ArrayList();
        d = r10;
        e = new HashMap();
        f = new HashMap();
        r10.addAll(r5);
        Iterator<f> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        f r12 = r11.next();
        e.put(r12, new ArrayList());
        f.put(r12, new ArrayList());
        goto L4
    L6:
        g = false;
        f16456h = new HashMap();
        f16457i = new e();
    }

    public static /* synthetic */ HashMap a() {
        return f;
    }

    public static /* synthetic */ boolean b(String r5, TravelData r10) {
        return a(r5, r10);
    }

    public static /* synthetic */ boolean c(TravelData r5) {
        return b(r5);
    }

    public static SimpleDateFormat d() {
        return s0.f("yyyy-MM-dd HH:mm:ss_SSS");
    }

    public static SimpleDateFormat e() {
        return s0.f("HH:mm");
    }

    public static SimpleDateFormat f() {
        return s0.f("M月d日");
    }

    public static SimpleDateFormat g() {
        return s0.f("MM-dd HH:mm");
    }

    public static SimpleDateFormat h() {
        return s0.f("yyyy-MM-dd");
    }

    public static SimpleDateFormat i() {
        return s0.f("yyyy-MM-dd HH:mm");
    }

    public static void a(@NonNull f r5, h r10) {
        ArrayList<h> r11 = f.get(r5);
        if (r10 != null) goto L5;
    L7:
        m.i("TravelUtils", "addTravelDataListener dataKey=" + r5 + " size=" + r11.size());
        return;
    L5:
        if (r11.contains(r10) == true) goto L7;
        r11.add(r10);
        goto L7
    }

    public static /* synthetic */ HashMap b() {
        return e;
    }

    public static /* synthetic */ ArrayList c() {
        return d;
    }

    public static boolean d(String r5) {
        if (g.a(r5) != g.e) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(String r5) {
        if (g.a(r5) != g.g) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(Context r5, FlightData r10) {
        f r11 = f.d;
        a(r5, g.f16468b, r11, r10);
    }

    public static void b(Context r5, TravelData r10) {
        f r11 = a(r10);
        r10.setIgnored();
        a(r5, g.f16469c, r11, r10);
    }

    public static boolean c(String r5) {
        if (g.a(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static int a(Context r10, long r11, long r12) {
        if (r11 > 0) goto L5;
        return 0;
    L5:
        if (r12 <= 0) goto L24;
        String r13 = h().format(Long.valueOf(r11));     // Catch: Throwable -> L15
        String r5 = h().format(Long.valueOf(r12));     // Catch: Throwable -> L15
        long r14 = a(r13, true);     // Catch: Throwable -> L15
        long r15 = a(r5, true);     // Catch: Throwable -> L15
        if (r14 > 0) goto L10;
        return 0;
    L10:
        if (r15 > 0) goto L12;
        return 0;
    L12:
        if (r14 == r15) goto L23;
        return Math.round(((r15 - r14) * 1.0f) / 8.64E7f);
    L23:
        return 0;
    L15:
        th = move-exception;
        StringBuilder r16 = j0.t(r11, "calcDayCountBetweenFromAndTo error, fromTimeLong=", ", toTimeLong=");
        r16.append(r12);
        m.j("TravelUtils", r16.toString(), th);
        return 0;
    L24:
        return 0;
    }

    public static boolean b(String r5) {
        if (f.a(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static void c(Context r10, TravelData r11, boolean r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        String r5 = a(r10, "amapuri://drive/takeTaxi?sourceApplication=mfr_tri_free_voice_taxi_zte&externalChannel=1&dname=__DESTINATION__&dlat=__FROM_LATITUDE__&dlon=_FROM_LONGITUDE__&dev=__TRAVEL_FROM_LAT_LNG_TYPE__", r11);
        TravelData.LngLat r13 = r11.getFromStationLngLat();
        String r14 = "0";
        if (r13 != null) goto L7;
    L13:
        String r15 = r5.replaceAll("_FROM_LONGITUDE__", "").replaceAll("__FROM_LATITUDE__", "");
    L14:
        boolean r16 = s0.d(r10, "com.autonavi.minimap", r15.replaceAll("__TRAVEL_FROM_LAT_LNG_TYPE__", r14));
        if (r16 == true) goto L17;
        r16 = s0.d(r10, "com.baidu.BaiduMap", a(r10, "baidumap://map/component?popRoot=no&resetRoot=no&needLocation=yes&needCloud=yes&comName=rentcar&coord_type=gcj02&target=rentcar_entrance&mode=CLEAN_MODE&param={\"src_from\":\"zhongxin_leftscreen_card\",\"start_latitude\":\"\",\"start_longitude\":\"\",\"start_keyword\":\"\",\"end_latitude\":\"\",\"end_longitude\":\"\",\"end_keyword\":\"__DESTINATION__\"}&src=MPOoem.zhongxin.zhuomian.taxicard", r11));
    L17:
        if (r16 == true) goto L21;
        boolean r17 = AppCallbackUtils.showDownloadAppDialog(r10, "com.autonavi.minimap", r10.getDrawable(R.drawable.app_icon_gaode), r10.getString(R.string.app_title_gaode));
        m.i("TravelUtils", "jumpToRoutePlan showDownloadAppDialog jumped=" + r17);
        if (r17 == true) goto L21;
        s0.i(r10, "com.autonavi.minimap");
    L21:
        if (r16 == false) goto L27;
        if (r12 == true) goto L24;
        return;
    L24:
        if (v.b(r10) == true) goto L29;
        Toast.makeText(r10, R.string.net_connected_error, 0).show();
        return;
    L29:
        return;
    L27:
        return;
    L7:
        if (r13.isAvailable() == false) goto L13;
        r15 = r5.replaceAll("_FROM_LONGITUDE__", r13.lng).replaceAll("__FROM_LATITUDE__", r13.lat);
        if (r13.isGCJ() == true) goto L14;
        r14 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        goto L14
    }

    private static void b(Context r5, TravelData r10, boolean r11) {
        boolean r12 = s0.d(r5, "com.autonavi.minimap", a(r5, "amapuri://route/plan/?&slat=&slon=sname=我的位置&dname=__DESTINATION__&dev=0&t=1", r10));
        if (r12 == true) goto L5;
        r12 = s0.d(r5, "com.baidu.BaiduMap", a(r5, "baidumap://map/direction?coord_type=gcj02&src=andr.zte.miboard&mode=transit&origin=我的位置&destination=name:__DESTINATION__|latlng:,", r10));
    L5:
        if (r12 == true) goto L9;
        boolean r13 = AppCallbackUtils.showDownloadAppDialog(r5, "com.autonavi.minimap", r5.getDrawable(R.drawable.app_icon_gaode), r5.getString(R.string.app_title_gaode));
        m.i("TravelUtils", "jumpToRoutePlan showDownloadAppDialog jumped=" + r13);
        if (r13 == true) goto L9;
        s0.i(r5, "com.autonavi.minimap");
    L9:
        if (r12 == false) goto L15;
        if (r11 == true) goto L12;
        return;
    L12:
        if (v.b(r5) == true) goto L17;
        Toast.makeText(r5, R.string.net_connected_error, 0).show();
        return;
    L17:
        return;
    }

    private static void c(Context r5, f r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        a(r5, r10, e.get(r10));
        b(r5, r10, e.get(r10));
        a r11 = new a(r10);
        boolean r12 = s0.f1083a;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L7;
        r11.run();
        return;
    L7:
        m.h(new n(r11));
    }

    private static /* synthetic */ boolean b(TravelData r12) {
        if (r12 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        m.n("TravelUtils", "removeNoNeedTravelDataInList removed. null or not isAvailable, travelData=" + r12);
    L12:
        if (r5 == true) goto L24;
        long r10 = r12.getCurAvailableFromTimeLong();
        long r11 = r12.getCurAvailableToTimeLong();
        long r13 = System.currentTimeMillis();
        if (r10 > 0) goto L16;
        StringBuilder r14 = new StringBuilder("removeNoNeedTravelDataInList removed. fromTime not right, travelData=");
    L21:
        r14.append(r12);
        m.n("TravelUtils", r14.toString());
        return true;
    L16:
        if (r11 > 0) goto L19;
        r11 = 60000 + r10;
    L19:
        if (r13 <= (r11 + AppUtil.MILLIS_IN_DAYS)) goto L24;
        r14 = new StringBuilder("removeNoNeedTravelDataInList removed. time not right, travelData=");
    L24:
        return r5;
    L5:
        if (r12.isAvailable() == false) goto L8;
        r5 = false;
        goto L10
    }

    private static ArrayList<? extends TravelData> b(Context r10, @NonNull f r11) {
        int r5 = 0;
        ArrayList<? extends TravelData> r12 = null;
        ArrayList<? extends TravelData> r13 = (ArrayList) new Gson().fromJson(r10.getSharedPreferences("travel_data", 0).getString(r11.f16465a, ""), TypeToken.getParameterized(ArrayList.class, new Type[]{r11.f16466b}).getType());     // Catch: Throwable -> L11
        if (r13 != null) goto L22;
    L13:
        if (r13 != null) goto L15;
        r13 = new ArrayList();
    L15:
        a(r10, r11, r13);
        m.i("TravelUtils", "readTravelDataList dataKey=" + r11 + " size=" + r13.size());
    L17:
        if (r5 >= r13.size()) goto L19;
        m.i("TravelUtils", "readTravelDataList dataKey=" + r11 + " i=" + r5 + " data=" + r13.get(r5));
        r5 = r5 + 1;
        goto L17
    L19:
        return r13;
    L22:
        int r14 = r13.size();     // Catch: Throwable -> L9
        a(r10, r13);     // Catch: Throwable -> L9
        if (r14 == r13.size()) goto L13;
        m.n("TravelUtils", "readTravelDataList remove no need force save, size=" + r14 + " result.size=" + r13.size());     // Catch: Throwable -> L9
        b(r10, r11, r13);     // Catch: Throwable -> L9
    L9:
        th = th;
        r12 = r13;
    L12:
        m.j("TravelUtils", "readTravelDataList fromJson error, dataKey=" + r11, th);
        r13 = r12;
    L11:
        th = th;
        goto L12
    }

    public static void c(Context r5, TravelData r10) {
        f r11 = a(r10);
        a(r5, g.f16469c, r11, r10);
    }

    public static void b(@NonNull f r5, h r10) {
        ArrayList<h> r11 = f.get(r5);
        r11.remove(r10);
        m.i("TravelUtils", "removeTravelDataListener dataKey=" + r5 + " size=" + r11.size());
    }

    private static String a(Context r10, @NonNull f r11, TravelData r12, TravelData r13) {
        if (r12 != null) goto L5;
    L26:
        m.l("TravelUtils", "changeTravelData data error return, reason_change_from_null_or_not_available, dataKey=" + r11 + " changeFrom=" + r12 + " changeTo=" + r13);
        return "reason_change_from_null_or_not_available";
    L5:
        if (r12.isBaseInfoAvailable() == false) goto L26;
        if (r13 != null) goto L9;
    L24:
        m.l("TravelUtils", "changeTravelData data error return, reason_change_to_null_or_not_available, dataKey=" + r11 + " changeFrom=" + r12 + " changeTo=" + r13);
        return "reason_change_to_null_or_not_available";
    L9:
        if (r13.isAvailable() == false) goto L24;
        ArrayList<? extends TravelData> r5 = e.get(r11);
        TravelData r14 = a(r12, r5);
        m.i("TravelUtils", "changeTravelData dataKey=" + r11 + " changeFrom=" + r12);
        m.i("TravelUtils", "changeTravelData dataKey=" + r11 + "   changeTo=" + r13);
        m.i("TravelUtils", "changeTravelData dataKey=" + r11 + "       find=" + r14);
        if (r14 != null) goto L15;
        m.l("TravelUtils", "changeTravelData dataKey=" + r11 + " not find changeFrom return");
        return "reason_change_not_find_change_from";
    L15:
        int r15 = 0;
    L17:
        if (r15 >= r5.size()) goto L22;
        if (r5.get(r15) != r14) goto L21;
        r5.set(r15, r13);
        m.i("TravelUtils", "changeTravelData replace i=" + r15 + " replace=" + r5.get(r15));
    L21:
        r15 = r15 + 1;
        goto L17
    L22:
        r5.sort(f16457i);
        c(r10, r11);
        return "";
    }

    private static void b(Context r5, @NonNull f r10, ArrayList<? extends TravelData> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        m.i("TravelUtils", "saveTravelDataList 1 dataKey=" + r10 + " size=" + r11.size() + " " + Log.getStackTraceString(new Throwable()));
        a(r5, r11);
        StringBuilder r12 = new StringBuilder("saveTravelDataList 2 dataKey=");
        r12.append(r10);
        r12.append(" size=");
        r12.append(r11.size());
        m.i("TravelUtils", r12.toString());
        int r13 = 0;
    L6:
        if (r13 >= r11.size()) goto L8;
        m.i("TravelUtils", "saveTravelDataList i=" + r13 + " dataKey=" + r10 + " data=" + r11.get(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        r5.getSharedPreferences("travel_data", 0).edit().putString(r10.f16465a, new Gson().toJson(r11)).apply();
    }

    public static boolean a(String r5) {
        if (a(r5, true) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public static void a(Context r5, TravelData r10) {
        f r11 = a(r10);
        a(r5, g.d, r11, r10);
    }

    public static f a(TravelData r5) {
        Iterator<f> r10 = d.iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        f r11 = r10.next();
        if (r5 == null) goto L4;
        if (r11.f16466b == r5.getClass()) goto L11;
        if (r11.f16466b != r5.getClass().getSuperclass()) goto L4;
    L11:
        return r11;
    L12:
        return null;
    }

    @Nullable
    public static TravelData a(TravelData r10, ArrayList<? extends TravelData> r11) {
        if (r10 != null) goto L5;
    L32:
        return null;
    L5:
        if (TextUtils.isEmpty(r10.getTravelKey()) == true) goto L32;
        if (r11 == null) goto L32;
        if (r11.isEmpty() == true) goto L32;
        ArrayList r5 = new ArrayList();
        Iterator<? extends TravelData> r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L19;
        TravelData r13 = r12.next();
        if (r13 == null) goto L12;
        if (r10.getTravelKey().equalsIgnoreCase(r13.getTravelKey()) == false) goto L12;
        r5.add(r13);
        goto L12
    L19:
        if (r5.isEmpty() == true) goto L32;
        if ((r10 instanceof TrainData) == false) goto L31;
        Iterator r14 = r5.iterator();
    L24:
        if (r14.hasNext() == false) goto L32;
        TravelData r15 = (TravelData) r14.next();
        if (r10.getFromTimeLong() <= 0) goto L24;
        if (r10.getFromTimeLong() != r15.getFromTimeLong()) goto L24;
        return r15;
    L31:
        return (TravelData) r5.get(0);
    }

    private static void a(Context r5, @NonNull f r10, ArrayList<? extends TravelData> r11, final String r12) {
        if (r11 != null) goto L6;
        m.l("TravelUtils", "forceTravelDataList dataKey=" + r10 + " forceList null");
        return;
    L6:
        r11.removeIf(new com.zte.miboard.cards.travel.h(r12));
        m.i("TravelUtils", "forceTravelDataList dataKey=" + r10 + " forceList.size=" + r11.size());
        int r13 = 0;
    L8:
        if (r13 >= r11.size()) goto L10;
        m.i("TravelUtils", "forceTravelDataList dataKey=" + r10 + " i=" + r13 + " data=" + r11.get(r13));
        r13 = r13 + 1;
        goto L8
    L10:
        ArrayList<? extends TravelData> r14 = e.get(r10);
        r14.clear();
        r14.addAll(r11);
        r14.sort(f16457i);
        c(r5, r10);
    }

    public static ArrayList<f> a(Context r5, boolean r10) {
        ArrayList<f> r11 = new ArrayList();
        if (r10 == false) goto L5;
        List<f> r12 = f16455c;
    L6:
        Iterator r13 = new ArrayList(r12).iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        f r14 = (f) r13.next();
        if (x.c(r5, r14.f16465a) == false) goto L8;
        r11.add(r14);
        goto L8
    L12:
        return r11;
    L5:
        r12 = f16454b;
        goto L6
    }

    public static long a(String r5, SimpleDateFormat r10) {
        if (TextUtils.isEmpty(r5) == true) goto L17;
        if (r10 == null) goto L19;
        Date r11 = r10.parse(r5);     // Catch: Throwable -> L8
    L9:
        if (r11 != null) goto L12;
        return 0;
    L12:
        if (r5.equals(r10.format(r11)) == true) goto L14;
        return 0;
    L14:
        return r11.getTime();
    L8:
        StringBuilder r12 = j0.x("checkTimeStrIsFormat error, timeStr=", r5, ", format=");
        r12.append(r10.toPattern());
        m.l("TravelUtils", r12.toString());
        r11 = null;
        goto L9
    L19:
        return 0;
    L17:
        return 0;
    }

    public static long a(String r5, boolean r10) {
        if (r10 == false) goto L4;
        SimpleDateFormat r11 = h();
    L6:
        return a(r5, r11);
    L4:
        r11 = i();
        goto L6
    }

    @NonNull
    public static ArrayList<? extends TravelData> a(@NonNull f r5) {
        ArrayList<? extends TravelData> r10 = e.get(r5);
        if (r10 != null) goto L6;
        r10 = new ArrayList();
    L6:
        return new ArrayList(r10);
    }

    private static String a(Context r5, String r10, TravelData r11) {
        if (TextUtils.isEmpty(r10) == true) goto L16;
        if (r11 == null) goto L16;
        String r12 = r11.getFromStation();
        if ((r11 instanceof HotelData) == false) goto L10;
        r12 = ((HotelData) r11).getHotelLocation();
    L10:
        if ((r11 instanceof TrainData) == false) goto L15;
        if (r12.endsWith("站") == true) goto L15;
        r12 = r12.concat("站");
    L15:
        return r10.replaceAll("__DESTINATION__", r12);
    L16:
        return r10;
    }

    public static void a(@NonNull Context r5, @NonNull f r10) {
        f16456h.put(r10, Boolean.TRUE);
        e.put(r10, b(r5, r10));
    }

    public static void a(Context r5, String r10, String r11, TravelData r12) {
        if (TextUtils.isEmpty(r11) == true) goto L19;
        if (r12 == null) goto L19;
        if (r12.isAvailable() == false) goto L19;
        if (r5.getString(R.string.travel_card_btn_route_plan).equalsIgnoreCase(r11) == false) goto L12;
        b(r5, r12, true);
        return;
    L12:
        if (r5.getString(R.string.travel_card_btn_navigation).equalsIgnoreCase(r11) == false) goto L15;
        a(r5, r12, true);
        return;
    L15:
        if (r5.getString(R.string.travel_card_btn_taxi).equalsIgnoreCase(r11) == false) goto L17;
        c(r5, r12, true);
        return;
    L17:
        m.l("TravelUtils", "jumpToMapNavigation btnText error not handled, btnText=" + r11 + " travelData=" + r12);
        return;
    L19:
        m.l("TravelUtils", "jumpToMapNavigation btnText travelData error return, btnText=" + r11 + " travelData=" + r12);
    }

    public static void a(Context r10, boolean r11, String r12, String r13, String r14) {
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L31:
        StringBuilder r15 = new StringBuilder();
        String r16 = "jumpToMapNavigationFromMiddleJumpAty input error return, btnTextResName=";
    L32:
        androidx.constraintlayout.motion.widget.a.C(r15, r16, r12, ", dataKeyStr=", r13);
        r15.append(", travelDataStr=");
        r15.append(r14);
        m.l("TravelUtils", r15.toString());
        return;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L31;
        if (TextUtils.isEmpty(r14) == true) goto L31;
        int r5 = r10.getResources().getIdentifier(r12, "string", r10.getPackageName());     // Catch: Throwable -> L13
        if (r5 != 0) goto L15;
        m.l("TravelUtils", "jumpToMapNavigationFromMiddleJumpAty btnTextId == 0 error return, btnTextResName=" + r12 + ", dataKeyStr=" + r13 + ", travelDataStr=" + r14);     // Catch: Throwable -> L13
        return;
    L15:
        String r17 = r10.getResources().getString(r5);     // Catch: Throwable -> L13
    L19:
        if (TextUtils.isEmpty(r17) == false) goto L21;
        r15 = j0.w("jumpToMapNavigationFromMiddleJumpAty btnText error return, btnText=", r17);
        r16 = " btnTextResName=";
        goto L32
    L21:
        f r18 = f.a(r13);
        if (r18 != null) goto L35;
        r15 = new StringBuilder();
        r15.append("jumpToMapNavigationFromMiddleJumpAty dataKey error return, dataKey=");
        r15.append(r18);
        r16 = ", btnTextResName=";
        goto L32
    L35:
        TravelData r19 = (TravelData) new Gson().fromJson(r14, r18.f16466b);     // Catch: Throwable -> L26
    L27:
        m.i("TravelUtils", "jumpToMapNavigationFromMiddleJumpAty needCancel=" + r11 + ", btnTextResName=" + r12 + ", dataKeyStr=" + r13 + ", travelDataStr=" + r14);
        a(r10, Constant.NOTIFICATION, r17, r19);
        if (r11 == false) goto L37;
        com.zte.miboard.cards.travel.a.a(r10);
        return;
    L37:
        return;
    L26:
        m.l("TravelUtils", "jumpToMapNavigationFromMiddleJumpAty fromJson error, dataKey=" + r18 + ", btnTextResName=" + r12 + ", dataKeyStr=" + r13 + ", travelDataStr=" + r14);
        r19 = null;
    L13:
        th = move-exception;
        StringBuilder r20 = androidx.constraintlayout.motion.widget.a.y("jumpToMapNavigationFromMiddleJumpAty getString error, btnTextResName=", r12, ", dataKeyStr=", r13, ", travelDataStr=");
        r20.append(r14);
        m.j("TravelUtils", r20.toString(), th);
        r17 = "";
        goto L19
    }

    private static void a(Context r5, TravelData r10, boolean r11) {
        boolean r12 = s0.d(r5, "com.autonavi.minimap", a(r5, "amapuri://route/plan/?&slat=&slon=sname=我的位置&dname=__DESTINATION__&dev=0&t=0", r10));
        if (r12 == true) goto L5;
        r12 = s0.d(r5, "com.baidu.BaiduMap", a(r5, "baidumap://map/direction?coord_type=gcj02&src=andr.zte.miboard&mode=driving&origin=我的位置&destination=name:__DESTINATION__|latlng:,", r10));
    L5:
        if (r12 == true) goto L9;
        boolean r13 = AppCallbackUtils.showDownloadAppDialog(r5, "com.autonavi.minimap", r5.getDrawable(R.drawable.app_icon_gaode), r5.getString(R.string.app_title_gaode));
        m.i("TravelUtils", "jumpToRoutePlan showDownloadAppDialog jumped=" + r13);
        if (r13 == true) goto L9;
        s0.i(r5, "com.autonavi.minimap");
    L9:
        if (r12 == false) goto L15;
        if (r11 == true) goto L12;
        return;
    L12:
        if (v.b(r5) == true) goto L17;
        Toast.makeText(r5, R.string.net_connected_error, 0).show();
        return;
    L17:
        return;
    }

    private static /* synthetic */ boolean a(String r5, TravelData r10) {
        if (r10 != null) goto L4;
    L7:
        boolean r11 = true;
    L8:
        if (r11 == true) goto L10;
        r10.setDataFrom(r5);
        r10.setUpdateTimeToNowIfNeed();
    L15:
        return r11;
    L10:
        StringBuilder r12 = new StringBuilder("forceTravelDataList remove error data.getClass=");
        if (r10 == null) goto L13;
        String r13 = r10.getClass().getSimpleName();
    L14:
        r12.append(r13);
        r12.append(" data=");
        r12.append(r10);
        m.l("TravelUtils", r12.toString());
        goto L15
    L13:
        r13 = null;
        goto L14
    L4:
        if (r10.isAvailable() == false) goto L7;
        r11 = false;
        goto L8
    }

    private static void a(Context r10, f r11, ArrayList<? extends TravelData> r12) {
        if (r11 != f.f) goto L78;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.isEmpty() == true) goto L81;
        ArrayList r13 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Iterator<? extends TravelData> r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L21;
        TravelData r15 = (TravelData) r14.next();
        if (r15 == null) goto L10;
        if (r15.isAvailable() == false) goto L10;
        if ((r15 instanceof HotelData) == false) goto L10;
        if (r15.needIgnoreByHasMergeFromTime() == true) goto L10;
        r5.add((HotelData) r15);
        goto L10
    L21:
        if (r5.isEmpty() == false) goto L54;
        return;
    L54:
        HashMap r16 = new HashMap();     // Catch: Throwable -> L29
        Iterator r17 = r5.iterator();     // Catch: Throwable -> L29
    L25:
        if (r17.hasNext() == false) goto L32;
        HotelData r18 = (HotelData) r17.next();     // Catch: Throwable -> L29
        String r19 = r18.travelNumber + "_" + r18.getHotelRoomType();     // Catch: Throwable -> L29
        if (r16.containsKey(r19) == true) goto L31;
        r16.put(r19, new ArrayList());     // Catch: Throwable -> L29
    L31:
        ((ArrayList) r16.get(r19)).add(r18);     // Catch: Throwable -> L29
        goto L25
    L32:
        Iterator r20 = r16.values().iterator();     // Catch: Throwable -> L29
    L33:
        int r21 = 0;
        if (r20.hasNext() == false) goto L46;
        ArrayList r22 = (ArrayList) r20.next();     // Catch: Throwable -> L29
        if (r22.size() < 2) goto L33;
        ArrayList r23 = new ArrayList(r22);     // Catch: Throwable -> L29
        r23.sort(f16457i);     // Catch: Throwable -> L29
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L29
        r24.add((HotelData) r23.get(0));     // Catch: Throwable -> L29
        int r25 = 1;
    L39:
        if (r25 >= r23.size()) goto L33;
        HotelData r26 = (HotelData) r24.get(r24.size() - 1);     // Catch: Throwable -> L29
        HotelData r27 = (HotelData) r23.get(r25);     // Catch: Throwable -> L29
        if (r26.getToTimeString().equals(r27.getFromTimeString()) == false) goto L43;
        m.i("TravelUtils", "mergeMapCacheHotelDataList merge tmpData=" + r27);     // Catch: Throwable -> L29
        m.i("TravelUtils", "mergeMapCacheHotelDataList merge start newListLastData=" + r26);     // Catch: Throwable -> L29
        r26.mergeTravelData(r27);     // Catch: Throwable -> L29
        r13.add(r27);     // Catch: Throwable -> L29
        m.i("TravelUtils", "mergeMapCacheHotelDataList merge end   newListLastData=" + r26);     // Catch: Throwable -> L29
    L44:
        r25 = r25 + 1;     // Catch: Throwable -> L29
        goto L39
    L43:
        r24.add((HotelData) r23.get(r25));     // Catch: Throwable -> L29
        goto L44
    L46:
        if (r13.isEmpty() == false) goto L48;
        return;
    L48:
        if (r21 >= r13.size()) goto L50;
        m.i("TravelUtils", "mergeMapCacheHotelDataList end remove i=" + r21 + " data=" + r13.get(r21));     // Catch: Throwable -> L29
        r21 = r21 + 1;     // Catch: Throwable -> L29
        goto L48
    L50:
        r12.removeAll(r13);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        m.j("TravelUtils", "mergeMapCacheHotelDataList error", th);
        return;
    L81:
        return;
    }

    public static Bundle a(@NonNull Context r16, Bundle r17) {
        boolean r5 = true;
        Bundle r10 = new Bundle();
        TravelData r11 = null;
        if (r17 == null) goto L5;
        String r12 = r17.getString("travel_data", "");
    L7:
        if (s0.f1083a == true) goto L10;
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged error return, REASON_ATLEAST_V_ERROR");
        r10.putString("error_reason_result", "reason_atleast_v_error");
        return r10;
    L10:
        m.i("TravelUtils", "onIntelligentAgentTravelDataChanged dataStr=" + r12);
        if (TextUtils.isEmpty(r12) == false) goto L98;
        StringBuilder r13 = j0.x("onIntelligentAgentTravelDataChanged error return, dataStr=", r12, " extras=");
        if (r17 != null) goto L16;
        r5 = false;
    L16:
        r13.append(r5);
        m.l("TravelUtils", r13.toString());
        r10.putString("error_reason_result", "reason_input_data_error");
        return r10;
    L98:
        IntelligentAgentData r14 = (IntelligentAgentData) new Gson().fromJson(r12, IntelligentAgentData.class);     // Catch: Throwable -> L20
    L22:
        if (r14 != null) goto L24;
    L27:
        if (r14 != null) goto L29;
    L90:
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged agentData error return, agentData=" + r14);
        r10.putString("error_reason_result", "reason_input_data_error");
        return r10;
    L29:
        if (r14.isAvailable() == false) goto L90;
        m.i("TravelUtils", "onIntelligentAgentTravelDataChanged agentData=" + r14);
        g r15 = g.a(r14.eventType);
        if (r15 != null) goto L35;
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged eventType null return, agentData=" + r14);
        r10.putString("error_reason_result", "reason_input_data_error");
        return r10;
    L35:
        f r18 = f.a(r14.dataKey);
        if (r18 != null) goto L40;
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged dataKey null return, agentData=" + r14);
        r10.putString("error_reason_result", "reason_input_data_error");
        return r10;
    L40:
        if (x.c(r16, r18.f16465a) == true) goto L43;
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged dataKey switch state error return, REASON_TRAVEL_DATA_KEY_SWITCH_STATE_ERROR, dataKey=" + r18 + " agentData=" + r14);
        r10.putString("error_reason_result", "reason_travel_data_key_switch_state_error");
        return r10;
    L43:
        Boolean r19 = f16456h.get(r18);
        if (r19 != null) goto L46;
    L47:
        a(r16, r18);
    L49:
        if (r15 != g.g) goto L94;
        ArrayList r20 = new ArrayList();
        r20 = (ArrayList) new Gson().fromJson(new Gson().toJson(r14.forceObjList), TypeToken.getParameterized(ArrayList.class, new Type[]{r18.f16466b}).getType());     // Catch: Throwable -> L53
    L55:
        a(r16, r18, r20, "intelligent");
        r10.putBoolean("boolean_result", true);
        return r10;
    L53:
        th = move-exception;
        m.j("TravelUtils", "onIntelligentAgentTravelDataChanged FORCE parse error", th);
        goto L55
    L94:
        TravelData r21 = (TravelData) new Gson().fromJson(new Gson().toJson(r14.travelDataObj), r18.f16466b);     // Catch: Throwable -> L59
    L61:
        if (r21 != null) goto L63;
    L88:
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged travelData error, travelData=" + r21 + " agentData=" + r14);
        r10.putString("error_reason_result", "reason_input_data_error");
        return r10;
    L63:
        if (r21.isBaseInfoAvailable() == false) goto L88;
        r21.setDataFrom("intelligent");
        r21.setUpdateTimeToNowIfNeed();
        if (r15 == g.e) goto L92;
        String r22 = a(r16, r15, r18, r21);
    L80:
        if (TextUtils.isEmpty(r22) == false) goto L82;
    L85:
        boolean r23 = true;
    L86:
        r10.putBoolean("boolean_result", r23);
        m.i("TravelUtils", "onIntelligentAgentTravelDataChanged booleanResult=" + r23 + " errorResultReason=" + r22);
        return r10;
    L82:
        if ("success_reason".equals(r22) == true) goto L85;
        r23 = false;
        goto L86
    L92:
        r11 = (TravelData) new Gson().fromJson(new Gson().toJson(r14.changeFromObj), r18.f16466b);     // Catch: Throwable -> L69
    L71:
        if (r11 != null) goto L73;
    L76:
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged TRAVEL_EVENT_TYPE_CHANGE changeFromTravelData error, changeFromTravelData=" + r21 + " agentData=" + r14);
        r10.putString("error_reason_result", "reason_input_data_error");
        return r10;
    L73:
        if (r11.isBaseInfoAvailable() == false) goto L76;
        r11.setDataFrom("intelligent");
        r22 = a(r16, r18, r11, r21);
    L69:
        th = move-exception;
        m.j("TravelUtils", "onIntelligentAgentTravelDataChanged parse changeFromJsonStr to cls error, cls=" + r18.f16466b + " changeFromObj=" + r14.changeFromObj, th);
    L59:
        th = move-exception;
        m.j("TravelUtils", "onIntelligentAgentTravelDataChanged parse dataJsonStr to cls error, cls=" + r18.f16466b + " travelDataObj=" + r14.travelDataObj, th);
        r21 = null;
        goto L61
    L46:
        if (r19.booleanValue() == true) goto L49;
    L24:
        if (f.a(r14.dataKey) != null) goto L27;
        m.l("TravelUtils", "onIntelligentAgentTravelDataChanged error return, REASON_NOT_SUPPORT_DATA_KEY, agentData.dataKey=" + r14.dataKey);
        r10.putString("error_reason_result", "reason_not_support_data_key");
        return r10;
    L20:
        th = move-exception;
        m.j("TravelUtils", "onIntelligentAgentTravelDataChanged parseData error", th);
        r14 = null;
        goto L22
    L5:
        r12 = null;
        goto L7
    }

    private static void a(Context r5, f r10, TravelData r11) {
        com.zte.miboard.cards.travel.a.a(r5, r11);
        ("" + r10).toLowerCase(Locale.ROOT);
        if (r10 != null) goto L5;
    L9:
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10 == f.d) goto L13;
        return;
    L13:
        if ((r11 instanceof FlightData) == false) goto L18;
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        FlightData r14 = (FlightData) r11;
        FlightReq r15 = new FlightReq(r14);
        r12.add(r14);
        r13.add(r15);
        m.i("TravelUtils", "onTravelDataAdded requestFlightNetInfo flightReqs=" + r13);
        v.a(r5, r13, new c(r13, r5, r12));
        return;
    L18:
        return;
    L5:
        if (r10 == f.d) goto L9;
        if (r10 == f.g) goto L9;
        x.b(r5, r11.getFromStation(), new C0028b(r11, r5));
        goto L9
    }

    private static String a(Context r10, g r11, f r12, TravelData r13) {
        if (r11 == null) goto L61;
        if (r12 == null) goto L61;
        if (r13 != null) goto L8;
    L59:
        m.l("TravelUtils", "onTravelDataChanged travelData error return, eventType=" + r11 + ", dataKey=" + r12 + ", travelData=" + r13);
        return "reason_travel_data_null_or_base_not_available";
    L8:
        if (r13.isBaseInfoAvailable() == false) goto L59;
        g r5 = g.f16468b;
        if (r11 == r5) goto L15;
        if (r11 == g.e) goto L15;
    L18:
        ArrayList<? extends TravelData> r14 = e.get(r12);
        TravelData r15 = a(r13, r14);
        m.i("TravelUtils", "onTravelDataChanged eventType=" + r11 + ", dataKey=" + r12 + " findTravelData=" + r15 + ", travelData=" + r13);
        if (r11 == r5) goto L53;
        g r16 = g.f;
        if (r11 != r16) goto L25;
        if (r15 == null) goto L53;
    L25:
        if (r11 != g.d) goto L31;
        if (r15 == null) goto L28;
        r14.remove(r15);
    L55:
        r14.sort(f16457i);
        c(r10, r12);
        return "";
    L28:
        m.l("TravelUtils", "onTravelDataChanged TRAVEL_EVENT_TYPE_DELETE error, not find");
        return "reason_delete_not_find";
    L31:
        if (r11 == g.f16469c) goto L34;
        if (r11 != r16) goto L55;
        if (r15 == null) goto L55;
    L34:
        if (r15 != null) goto L37;
        m.l("TravelUtils", "onTravelDataChanged TRAVEL_EVENT_TYPE_UPDATE error, not find findTravelData");
        return "reason_update_not_find";
    L37:
        TravelData r17 = (TravelData) a(r10, r12.f16466b, r15, r13);
        m.i("TravelUtils", "onTravelDataChanged TRAVEL_EVENT_TYPE_UPDATE findTravelData=" + r15);
        m.i("TravelUtils", "onTravelDataChanged TRAVEL_EVENT_TYPE_UPDATE    updatedData=" + r17);
        if (r17 != null) goto L42;
        m.l("TravelUtils", "onTravelDataChanged TRAVEL_EVENT_TYPE_UPDATE error, not find updatedData");
        return "reason_update_not_find_update_data";
    L42:
        if ((r15 instanceof FlightData) == true) goto L44;
    L46:
        int r18 = 0;
    L48:
        if (r18 >= r14.size()) goto L55;
        if (r14.get(r18) != r15) goto L52;
        r14.set(r18, r17);
    L52:
        r18 = r18 + 1;
        goto L48
    L44:
        if ((r13 instanceof FlightData) == false) goto L46;
        com.zte.miboard.cards.travel.a.a(r10, (FlightData) r15, (FlightData) r17);
    L53:
        if (r15 != null) goto L57;
        r14.add(r13);
        a(r10, r12, r13);
        goto L55
    L57:
        m.l("TravelUtils", "onTravelDataChanged TRAVEL_EVENT_TYPE_ADD error, already exist");
        return "reason_add_already_exist";
    L15:
        if (r13.isAvailable() == true) goto L18;
        m.l("TravelUtils", "onTravelDataChanged travelData and eventType error return, eventType=" + r11 + ", dataKey=" + r12 + ", travelData=" + r13);
        return "reason_add_or_change_travel_data_not_available";
    L61:
        m.l("TravelUtils", "onTravelDataChanged eventType or dataKey error return, eventType=" + r11 + ", dataKey=" + r12 + ", travelData=" + r13);
        return "reason_event_type_or_data_key_null";
    }

    private static void a(Context r5, ArrayList<? extends TravelData> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L9;
        r10.removeIf(new o(6));
        return;
    }

    @Nullable
    public static <T> T a(Context r5, @NonNull Class<T> r10, TravelData r11, TravelData r12) {
        if (r11 == null) goto L29;
        if (r12 == null) goto L29;
        Type r13 = new d().getType();     // Catch: Throwable -> L18
        String r14 = new Gson().toJson(r11);     // Catch: Throwable -> L18
        String r15 = new Gson().toJson(r12);     // Catch: Throwable -> L18
        HashMap r16 = (HashMap) new Gson().fromJson(r14, r13);     // Catch: Throwable -> L18
        Iterator r17 = ((HashMap) new Gson().fromJson(r15, r13)).entrySet().iterator();     // Catch: Throwable -> L18
    L8:
        if (r17.hasNext() == false) goto L26;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L18
        if (r18.getKey() == null) goto L8;
        if (r18.getValue() == null) goto L8;
        if ((r18.getKey() instanceof String) == false) goto L21;
        if (TextUtils.isEmpty((String) r18.getKey()) == true) goto L8;
    L21:
        if ((r18.getValue() instanceof String) == false) goto L25;
        if (TextUtils.isEmpty((String) r18.getValue()) == true) goto L8;
    L25:
        r16.put(r18.getKey(), r18.getValue());     // Catch: Throwable -> L18
        goto L8
    L26:
        return (T) new Gson().fromJson(new Gson().toJson(r16), r10);
    L18:
        th = move-exception;
        m.j("TravelUtils", "updateTravelData error, classOfT=" + r10 + ", data1=" + r11 + ", data2=" + r12, th);
    L29:
        return null;
    }
}
