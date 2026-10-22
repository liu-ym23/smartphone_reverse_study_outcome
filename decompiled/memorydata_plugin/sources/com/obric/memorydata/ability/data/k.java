package com.obric.memorydata.ability.data;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.database.dao.LocationDao;
import com.obric.memorydata.database.entity.bz;
import com.obric.memorydata.database.entity.cl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bq\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\bH\u0016J\b\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010G\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010H\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u0086\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\nHÖ\u0001J\t\u0010P\u001a\u00020\fHÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u000e\u00107\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/obric/memorydata/ability/data/LocationStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "Lcom/obric/memorydata/ability/data/ITeaTrackerReportData;", "longitude", "", "latitude", "cellId", "", "lac", "", "cellType", "", "bssid", Api.KEY_SSID, LocationMonitorConst.ACCURACY, "", "speed", "harState", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;)V", "getLongitude", "()Ljava/lang/Double;", "setLongitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getLatitude", "setLatitude", "getCellId", "()Ljava/lang/Long;", "setCellId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLac", "()Ljava/lang/Integer;", "setLac", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCellType", "()Ljava/lang/String;", "setCellType", "(Ljava/lang/String;)V", "getBssid", "setBssid", "getSsid", "setSsid", "getAccuracy", "()Ljava/lang/Float;", "setAccuracy", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getSpeed", "setSpeed", "getHarState", "setHarState", "dataId", "dataVersion", "timestamp", "getDataId", "getDataVersion", "collectNewData", "reportByOsTeaTracker", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;)Lcom/obric/memorydata/ability/data/LocationStandardData;", "equals", "", "other", "", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements h, i, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Double f8333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Double f8334b;
    private Long c;
    private Integer d;
    private String e;
    private String f;
    private String g;
    private Float h;
    private Float i;
    private Integer j;
    private final int k;
    private final int l;
    private final long m;

    public k(Double r1, Double r2, Long r3, Integer r4, String r5, String r6, String r7, Float r8, Float r9, Integer r10) {
        this.f8333a = r1;
        this.f8334b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = 100000004;
        this.l = 1;
        this.m = System.currentTimeMillis();
    }

    public /* synthetic */ k(Double r15, Double r16, Long r17, Integer r18, String r19, String r20, String r21, Float r22, Float r23, Integer r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 128) == 0) goto L5;
        Float r11 = null;
    L7:
        if ((r25 & 256) == 0) goto L9;
        Float r12 = null;
    L11:
        if ((r25 & 512) == 0) goto L13;
        Integer r13 = null;
    L14:
        this(r15, r16, r17, r18, r19, r20, r21, r11, r12, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r12 = r23;
        goto L11
    L5:
        r11 = r22;
        goto L7
    }

    @Override // com.obric.memorydata.ability.data.i
    public void a() {
        Double r0 = this.f8333a;
        if (r0 == null) goto L38;
        double r1 = 0.0d;
        if (Intrinsics.areEqual(r0, 0.0d) == true) goto L39;
        Double r2 = this.f8334b;
        if (r2 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r2, 0.0d) == true) goto L41;
        Tracker r3 = Tracker.INSTANCE;
        String r4 = OsTeaTrackerEventId.LOCATION.getValue();
        Pair[] r5 = new Pair[7];
        Double r6 = this.f8333a;
        if (r6 == null) goto L14;
        double r7 = r6.doubleValue();
    L15:
        r5[0] = TuplesKt.to("longitude", Double.valueOf(r7));
        Double r8 = this.f8334b;
        if (r8 == null) goto L18;
        r1 = r8.doubleValue();
    L18:
        r5[1] = TuplesKt.to("latitude", Double.valueOf(r1));
        Long r9 = this.c;
        if (r9 == null) goto L21;
        long r10 = r9.longValue();
    L22:
        r5[2] = TuplesKt.to("cellId", Long.valueOf(r10));
        Integer r11 = this.d;
        if (r11 == null) goto L25;
        int r12 = r11.intValue();
    L26:
        r5[3] = TuplesKt.to("lac", Integer.valueOf(r12));
        String r13 = this.e;
        String r14 = "";
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        r5[4] = TuplesKt.to("cellType", r13);
        String r15 = this.f;
        if (r15 != null) goto L32;
        r15 = "";
    L32:
        r5[5] = TuplesKt.to("bssid", r15);
        String r16 = this.g;
        if (r16 == null) goto L36;
        r14 = r16;
    L36:
        r5[6] = TuplesKt.to(Api.KEY_SSID, r14);
        r3.reportWithSystemId(r4, MapsKt.mapOf(r5));
        return;
    L25:
        r12 = -1;
        goto L26
    L21:
        r10 = -1;
        goto L22
    L14:
        r7 = 0.0d;
        goto L15
    L41:
        return;
    L39:
        return;
    }

    public final void a(Double r1) {
        this.f8333a = r1;
    }

    public final void a(Float r1) {
        this.h = r1;
    }

    public final void a(Integer r1) {
        this.d = r1;
    }

    public final void a(Long r1) {
        this.c = r1;
    }

    public final void a(String r1) {
        this.e = r1;
    }

    public final Double b() {
        return this.f8333a;
    }

    public final void b(Double r1) {
        this.f8334b = r1;
    }

    public final void b(Float r1) {
        this.i = r1;
    }

    public final void b(String r1) {
        this.f = r1;
    }

    public final Double c() {
        return this.f8334b;
    }

    public final void c(String r1) {
        this.g = r1;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        Double r1 = this.f8333a;
        if (r1 != null) goto L5;
    L16:
        return -1;
    L5:
        if (Intrinsics.areEqual(r1, 0.0d) == true) goto L16;
        Double r2 = this.f8334b;
        if (r2 == null) goto L16;
        if (Intrinsics.areEqual(r2, 0.0d) == true) goto L16;
        bz r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getHarStateDao().queryLatest();
        if (r3 == null) goto L14;
        Integer r4 = Integer.valueOf(r3.a());
    L15:
        Integer r18 = r4;
        LocationDao r5 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationDao();
        int r6 = this.k;
        int r7 = this.l;
        long r8 = this.m;
        Double r9 = this.f8333a;
        Intrinsics.checkNotNull(r9);
        double r10 = r9.doubleValue();
        Double r11 = this.f8334b;
        Intrinsics.checkNotNull(r11);
        return r5.insert(new cl(r6, r7, r8, r10, r11.doubleValue(), this.c, this.d, this.e, this.f, this.g, this.h, this.i, r18, 0, 8192, null));
    L14:
        r4 = null;
        goto L15
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8333a, r6.f8333a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8334b, r6.f8334b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.k;
    }

    public int hashCode() {
        Double r0 = this.f8333a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Double r4 = this.f8334b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Float r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Float r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "LocationStandardData(longitude=" + this.f8333a + ", latitude=" + this.f8334b + ", cellId=" + this.c + ", lac=" + this.d + ", cellType=" + this.e + ", bssid=" + this.f + ", ssid=" + this.g + ", accuracy=" + this.h + ", speed=" + this.i + ", harState=" + this.j + ')';
    }
}
