package com.obric.memorydata.database.entity;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.rpc.model.POIInfo;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.thirdparty.api.location.LocationManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J1\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/memorydata/database/entity/PoiInfoGroupEntity;", "", "reqSource", "", "msgContent", "", CommonConsts.COUNT_TYPE, "", OaidModel.KEY_ID, "<init>", "(JLjava/lang/String;IJ)V", "getReqSource", "()J", "setReqSource", "(J)V", "getMsgContent", "()Ljava/lang/String;", "getCount", "()I", "getId", "poiInfoList", "", "Lcom/bytedance/rpc/model/POIInfo;", "isBuildInfo", "", "buildPoiInfo", "", "searchPoiInfo", "latitude", "", "longitude", "delta", "getAllPoiInfo", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class em {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9081b;
    private final int c;
    private final long d;
    private List<? extends POIInfo> e;
    private boolean f;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/database/entity/PoiInfoGroupEntity$getAllPoiInfo$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/rpc/model/POIInfo;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends POIInfo>> {
        a() {
        }
    }

    public em(long r2, String r4, int r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "msgContent");
        this.f9080a = r2;
        this.f9081b = r4;
        this.c = r5;
        this.d = r6;
    }

    public /* synthetic */ em(long r8, String r10, int r11, long r12, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r12 = 0;
    L5:
        this(r8, r10, r11, r12);
    }

    private final void e() {
        if (this.f == true) goto L5;
    L7:
        this.e = f();
        return;
    L5:
        if (this.e == null) goto L7;
    }

    private final List<POIInfo> f() {
        Object r7 = com.obric.memorydata.utils.u.a().fromJson(this.f9081b, new a().getType());     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r7, "fromJson(...)");     // Catch: Exception -> L5
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PoiInfoGroupEntity", "Poi Info Covert Error " + e, null, 4, null);
        return CollectionsKt.emptyList();
    }

    public final long a() {
        return this.f9080a;
    }

    public final List<POIInfo> a(double r14, double r16, double r18) {
        e();
        List<POIInfo> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<? extends POIInfo> r1 = this.e;
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        Iterator<? extends POIInfo> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        POIInfo r3 = (POIInfo) ZeusTransformUtils.preCheckCast(r2.next(), POIInfo.class, "com.obric.memorydata.plugin");
        LocationManager r4 = LocationManager.INSTANCE;
        String r5 = r3.geo.longitude;
        Intrinsics.checkNotNullExpressionValue(r5, "longitude");
        double r9 = Double.parseDouble(r5);
        String r6 = r3.geo.latitude;
        Intrinsics.checkNotNullExpressionValue(r6, "latitude");
        if (r4.getDistance(r16, r14, r9, Double.parseDouble(r6)) > r18) goto L7;
        r0.add(r3);
        goto L7
    L11:
        return r0;
    }

    public final void a(long r1) {
        this.f9080a = r1;
    }

    public final String b() {
        return this.f9081b;
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, em.class) == true) goto L8;
        return false;
    L8:
        em r10 = (em) ZeusTransformUtils.preCheckCast(r9, em.class, "com.obric.memorydata.plugin");
        if (this.f9080a == r10.f9080a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9081b, r10.f9081b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f9080a) * 31) + this.f9081b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "PoiInfoGroupEntity(reqSource=" + this.f9080a + ", msgContent=" + this.f9081b + ", count=" + this.c + ", id=" + this.d + ')';
    }
}
