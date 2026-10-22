package com.obric.cae.location.city;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f7045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7046b;
    public final AtomicReference<String> c;
    public final e d;
    public ExecutorService e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<AoiBoard> f7048b;
        public final Map<String, String> c;

        public a(boolean r3, ArrayList r4, Map r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            this.f7047a = r3;
            this.f7048b = r4;
            this.c = r6;
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.city.b$b, reason: collision with other inner class name */
    public static final class C0352b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.obric.cae.location.geosdk.bytedance.a.ak> f7050b;
        public final Integer c;
        public final String d;

        public C0352b(boolean r1, ArrayList r2, Integer r3, String r4) {
            this.f7049a = r1;
            this.f7050b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public b(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        this.c = new AtomicReference(null);
        Handler r6 = new Handler(Looper.getMainLooper());
        this.f7046b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.d = new e("StarLocation-mallGeo", "mall", r6, new $$Lambda$hvxlcDHPVgGly8ILrSpoNfnpZE(this), new $$Lambda$X_Yj8JbltNWga60kHhH9BffpDuY(this));
    }

    public static C0352b a(String r19, String r20, LinkedHashMap r21) {
        String r9 = new com.obric.cae.location.util.e().a("type_code", r20).b();
        int r10 = r21.size();
        Integer r0 = null;
        String r1 = null;
        int r12 = 1;
    L4:
        if (r12 > 50) goto L36;
        com.obric.cae.log.a.d("StarLocation-mallGeo", "mall request: keyword=商场, typeCode=" + r20 + ", city=" + r19 + ", pageNum=" + r12 + ", pageSize=20");
        com.obric.cae.location.geosdk.bytedance.a.al r2 = com.obric.cae.location.geosdk.bytedance.a.a().e("商场", r12, 20, r19, r9);
        Integer r3 = r2.c;
        String r4 = r2.d;
        if (r2.f7111a == false) goto L7;
        int r5 = r2.f7112b.size();
        if (r5 <= 0) goto L11;
        Iterator<com.obric.cae.location.geosdk.bytedance.a.ak> r6 = r2.f7112b.iterator();
        int r11 = 0;
    L14:
        if (r6.hasNext() == false) goto L24;
        Iterator<com.obric.cae.location.geosdk.bytedance.a.ak> r17 = r6;
        Integer r18 = r3;
        com.obric.cae.location.geosdk.bytedance.a.ak r7 = (com.obric.cae.location.geosdk.bytedance.a.ak) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.cae.location.geosdk.bytedance.a.ak.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L23;
        if (r7.f7109a.isEmpty() == true) goto L23;
        if (r21.containsKey(r7.f7109a) == true) goto L23;
        r21.put(r7.f7109a, r7);
        r11 = r11 + 1;
    L23:
        r6 = r17;
        r3 = r18;
        goto L14
    L24:
        Integer r110 = r3;
        com.obric.cae.log.a.d("StarLocation-mallGeo", com.obric.cae.libs.statemachine.e.a(new StringBuilder("mall page result size=").append(r5).append(", typeCode=").append(r20).append(", pageNum="), r12, ", addedCount=", r11, ", typeCount=").append(r21.size() - r10).append(", totalCount=").append(r21.size()).toString());
        if (r5 < 20) goto L26;
        if (r11 <= 0) goto L29;
        if (r12 != 50) goto L34;
        com.obric.cae.log.a.h("StarLocation-mallGeo", "mall search reaches max page count, city=" + r19 + ", typeCode=" + r20 + ", maxPageCount=50");
    L34:
        r12 = r12 + 1;
        r1 = r4;
        r0 = r110;
        goto L4
    L29:
        StringBuilder r8 = new StringBuilder("mall page has no new candidate for city=");
    L27:
        com.obric.cae.log.a.d("StarLocation-mallGeo", r8.append(r19).append(", typeCode=").append(r20).append(", pageNum=").append(r12).append(", stop paging").toString());
    L30:
        r1 = r4;
        r0 = r110;
        goto L36
    L26:
        r8 = new StringBuilder("mall partial page for city=");
        goto L27
    L11:
        com.obric.cae.log.a.d("StarLocation-mallGeo", "mall result size=0 for city=" + r19 + ", typeCode=" + r20 + ", pageNum=" + r12 + ", stop paging, typeCount=" + (r21.size() - r10) + ", totalCount=" + r21.size());
        r110 = r3;
        goto L30
    L7:
        com.obric.cae.log.a.h("StarLocation-mallGeo", "mall search failed, city=" + r19 + ", typeCode=" + r20 + ", pageNum=" + r12 + ", code=" + r2.c + ", msg=" + r2.d);
        return new C0352b(false, new ArrayList(), r3, r4);
    L36:
        return new C0352b(true, new ArrayList(r21.values()), r0, r1);
    }

    public static b a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f7045a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7045a != null) goto L9;
        f7045a = new b(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f7045a;
    }

    public void a() {
        String r0 = c(null);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L10;
        this.d.a(r0);
        return;
    }

    public void a(Address r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r0 = r3.getSubAdminArea();
        if (r0 != null) goto L7;
    L9:
        r0 = r3.getLocality();
        if (r0 != null) goto L12;
    L14:
        r0 = r3.getSubLocality();
        if (r0 != null) goto L17;
    L19:
        r0 = r3.getAdminArea();
    L20:
        if (r0 != null) goto L22;
    L26:
        com.obric.cae.log.a.d("StarLocation-mallGeo", "skip: city is empty");
        return;
    L22:
        if (r0.isEmpty() == true) goto L26;
        this.d.a(r0);
        return;
    L17:
        if (r0.isEmpty() == true) goto L19;
    L12:
        if (r0.isEmpty() == true) goto L14;
    L7:
        if (r0.isEmpty() == true) goto L9;
        goto L9
    }

    public final void a(String r8) {
        boolean r1 = false;
    L48:
        th = th;
    L58:
        com.obric.cae.log.a.b("StarLocation-mallGeo", "error", th);     // Catch: Throwable -> L53
        if (r1 == false) goto L65;
    L51:
        this.d.a();
        return;
    L65:
        return;
    L53:
        th = move-exception;
        if (r1 == false) goto L56;
        this.d.a();
    L56:
        throw th;
    L4:
        if (com.obric.cae.location.geosdk.poi.a.a(this.f7046b, 0).e() == true) goto L7;
        com.obric.cae.log.a.d("StarLocation-mallGeo", "skip: aoi board recovery not finished");     // Catch: Throwable -> L48
        this.d.b();     // Catch: Throwable -> L48
        return;
    L7:
        e r2 = this.d;     // Catch: Throwable -> L48
        if (r2.k.compareAndSet(false, true) == true) goto L11;
        com.obric.cae.log.a.d(r2.f7061a, "skip: add in progress");     // Catch: Throwable -> L48
        boolean r3 = false;
    L12:
        if (r3 == true) goto L57;
        if (r3 == false) goto L61;
        this.d.a();
        return;
    L61:
        return;
    L57:
        String r9 = c(r8);     // Catch: Throwable -> L46
        if (r9 != null) goto L19;
    L42:
        com.obric.cae.log.a.d("StarLocation-mallGeo", "skip: target city empty");     // Catch: Throwable -> L46
        if (r3 == false) goto L63;
        this.d.a();
        return;
    L63:
        return;
    L19:
        if (r9.isEmpty() == true) goto L42;
        d(r9);     // Catch: Throwable -> L46
        if (r9.equals(d().getString("mall_aoi_board_city", "")) == false) goto L34;
        int r4 = d().getInt("mall_aoi_board", 0);     // Catch: Throwable -> L46
        if (r4 == 0) goto L34;
        if (r4 == 2) goto L33;
        if (r4 != 1) goto L34;
        if (com.obric.cae.location.geosdk.poi.a.a(this.f7046b, 0).a(AoiBoard.Type.MALL).isEmpty() == true) goto L34;
    L33:
        r1 = true;
    L34:
        if (r1 == false) goto L39;
        this.c.set(r9);     // Catch: Throwable -> L46
        if (r3 == false) goto L62;
        this.d.a();
        return;
    L62:
        return;
    L39:
        b(r9);     // Catch: Throwable -> L46
        if (r3 == true) goto L51;
        return;
    L46:
        th = th;
        r1 = r3;
        goto L58
    L11:
        r3 = true;
        goto L12
    }

    public void a(String r7, boolean r8) {
        if (r7.isEmpty() == false) goto L6;
        return;
    L6:
        if (r8 == true) goto L8;
    L10:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
        d().edit().putString("mall_aoi_board_city", r7).putInt("mall_aoi_board", 1).remove("mall_aoi_board_type").apply();
        this.c.set(r7);
    L15:
        com.obric.cae.log.a.d("StarLocation-mallGeo", "city=" + r7 + ", restoredFromArchive=" + r8 + ", hasRestoredMallAoiBoards=" + r2);
        return;
    L14:
        d().edit().putString("mall_aoi_board_city", r7).putInt("mall_aoi_board", 0).remove("mall_aoi_board_type").apply();
        this.c.set(null);
        goto L15
    L8:
        if (com.obric.cae.location.geosdk.poi.a.a(this.f7046b, 0).a(AoiBoard.Type.MALL).isEmpty() == true) goto L10;
        r2 = true;
        goto L12
    }

    public void b() {
        e r0 = this.d;
        r0.c.removeCallbacks(r0.l);
        r0.j.set(false);
        monitor-enter(this);
        ExecutorService r1 = this.e;     // Catch: Throwable -> L11
        if (r1 != null) goto L15;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L15:
        r1.shutdownNow();     // Catch: Throwable -> L14
    L8:
        this.e = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void b(String r11) {
        if (com.obric.cae.location.util.d.a().e() == true) goto L6;
        com.obric.cae.log.a.h("StarLocation-mallGeo", "skip reloadMallDataForCity: network invalid, city=".concat(r11));
        return;
    L6:
        LinkedHashMap r0 = new LinkedHashMap();
        C0352b r2 = a(r11, "052201", r0);
        int r4 = 1;
        if (r2.f7049a == false) goto L14;
        r2 = a(r11, "052202", r0);
        if (r2.f7049a == false) goto L14;
        r2 = new C0352b(true, new ArrayList(r0.values()), r2.c, r2.d);
    L14:
        if (r2.f7049a == true) goto L17;
        a r1 = new a(false, new ArrayList(), Collections.emptyMap());
    L52:
        if (r1.f7047a == true) goto L55;
        this.d.b();
        return;
    L55:
        boolean r3 = com.obric.cae.location.geosdk.poi.a.a(this.f7046b, 0).a(Collections.singleton(AoiBoard.Type.MALL), r1.f7048b);
        com.obric.cae.log.a.d("StarLocation-mallGeo", f.a("reloadMallDataForCity city=", r11, ", mallAoiBoardCount=").append(r1.f7048b.size()).append(", saved=").append(r3).toString());
        if (r3 == false) goto L78;
        com.obric.cae.log.a.f("StarLocation-mallGeo", com.obric.cae.libs.statemachine.d.a("mall new_type_code_l3 saved count=", com.obric.cae.location.database.c.a(this.f7046b, 0).a(r1.c), ", parsed count=").append(r1.c.size()).toString());
        if (r1.f7048b.isEmpty() == false) goto L60;
        r4 = 2;
    L60:
        d().edit().putString("mall_aoi_board_city", r11).putInt("mall_aoi_board", r4).remove("mall_aoi_board_type").apply();
        this.c.set(r11);
        return;
    L78:
        return;
    L17:
        if (r2.f7050b.isEmpty() == false) goto L19;
        r1 = new a(true, new ArrayList(), Collections.emptyMap());
        goto L52
    L19:
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<com.obric.cae.location.geosdk.bytedance.a.ak> r6 = r2.f7050b.iterator();
    L21:
        if (r6.hasNext() == false) goto L34;
        com.obric.cae.location.geosdk.bytedance.a.ak r7 = (com.obric.cae.location.geosdk.bytedance.a.ak) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.cae.location.geosdk.bytedance.a.ak.class, "com.obric.memorydata.plugin");
        AoiBoard r8 = null;
        if (r7 != null) goto L25;
    L31:
        if (r8 == null) goto L21;
        r5.put(r8.getPoiId(), r8);
        goto L21
    L25:
        if (r7.f7109a.isEmpty() == true) goto L31;
        String r9 = r7.i;
        if (r9.isEmpty() == false) goto L30;
        com.obric.cae.log.a.b("StarLocation-mallGeo", "mall candidate missing geo_json, name=" + r7.f7110b + ", poiId=" + r7.f7109a);
        com.obric.cae.location.report.d.a(r7.f7109a, r7.f7110b);
        goto L31
    L30:
        r8 = com.obric.cae.location.geosdk.poi.a.a(r7.f7109a, r7.f7110b, r9, AoiBoard.Type.MALL);
        goto L31
    L34:
        if (r5.isEmpty() == false) goto L36;
        com.obric.cae.log.a.h("StarLocation-mallGeo", "mall search returned candidates but no valid aoi boards, city=".concat(r11));
        r1 = new a(true, new ArrayList(), Collections.emptyMap());
        goto L52
    L36:
        List<com.obric.cae.location.geosdk.bytedance.a.ak> r10 = r2.f7050b;
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<com.obric.cae.location.geosdk.bytedance.a.ak> r13 = r10.iterator();
    L38:
        if (r13.hasNext() == false) goto L50;
        com.obric.cae.location.geosdk.bytedance.a.ak r14 = (com.obric.cae.location.geosdk.bytedance.a.ak) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.cae.location.geosdk.bytedance.a.ak.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L38;
        if (r14.f7109a.isEmpty() == true) goto L38;
        if (r14.g.isEmpty() == true) goto L38;
        if (r5.containsKey(r14.f7109a) == false) goto L38;
        r12.put(r14.f7109a, r14.g);
        goto L38
    L50:
        r1 = new a(true, new ArrayList(r5.values()), r12);
        goto L52
    }

    public final String c(String r2) {
        if (r2 != null) goto L4;
    L6:
        com.obric.cae.location.database.c.b r1 = com.obric.cae.location.database.c.a(this.f7046b, 0).b();
        if (r1 != null) goto L10;
        return null;
    L10:
        String r3 = r1.f7078b;
        if (r3 != null) goto L13;
    L16:
        String r4 = r1.c;
        if (r4 != null) goto L19;
    L22:
        String r5 = r1.d;
        if (r5 == null) goto L29;
        if (r5.isEmpty() == true) goto L29;
        return r1.d;
    L29:
        return r1.f7077a;
    L19:
        if (r4.isEmpty() == true) goto L22;
        return r1.c;
    L13:
        if (r3.isEmpty() == true) goto L16;
        return r1.f7078b;
    L4:
        if (r2.isEmpty() == true) goto L6;
        return r2;
    }

    public final synchronized ExecutorService c() {
        monitor-enter(this);
        ExecutorService r0 = this.e;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L9:
        this.e = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L13
    L10:
        ExecutorService r1 = this.e;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r1;
    L6:
        if (r0.isShutdown() == true) goto L9;
        if (this.e.isTerminated() == false) goto L10;
    L13:
        th = move-exception;
        throw th;
    }

    public final SharedPreferences d() {
        return this.f7046b.getSharedPreferences("star_location_sp", 0);
    }

    public final void d(String r5) {
        String r0 = d().getString("mall_aoi_board_city", "");
        if (r5.equals(r0) == true) goto L5;
        d().edit().putString("mall_aoi_board_city", r5).putInt("mall_aoi_board", 0).remove("mall_aoi_board_type").apply();
        com.obric.cae.log.a.f("StarLocation-mallGeo", "reset mall aoi search state, previousCity=" + r0 + ", currentCity=" + r5);
        return;
    L5:
        if (d().contains("mall_aoi_board_type") == false) goto L11;
        d().edit().remove("mall_aoi_board_type").apply();
        return;
    }
}
