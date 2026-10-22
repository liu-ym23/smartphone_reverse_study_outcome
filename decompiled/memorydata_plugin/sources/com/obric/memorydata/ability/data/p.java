package com.obric.memorydata.ability.data;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.entity.ic;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\fHÖ\u0001J\t\u0010(\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/ability/data/ScreenStateStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "state", "", InfoRequestQPSOptTraceLogger.REASON, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getState", "()Ljava/lang/String;", "getReason", "dataId", "", "dataVersion", "timestamp", "", "screenOnReason", "getScreenOnReason", "setScreenOnReason", "(Ljava/lang/String;)V", "screenOffTs", "getScreenOffTs", "()J", "setScreenOffTs", "(J)V", "trackEventDict", "", "getDataId", "getDataVersion", "reportScreenState", "", "collectNewData", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8343b;
    private final int c;
    private final int d;
    private final long e;
    private String f;
    private long g;
    private final Map<String, String> h;

    public p(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
        this.f8342a = r3;
        this.f8343b = r4;
        this.c = 100000005;
        this.d = 1;
        this.e = System.currentTimeMillis();
        this.f = "";
        this.h = MapsKt.mapOf(new Pair[]{TuplesKt.to(com.tom_roush.pdfbox.pdmodel.a.d.f.f, "turn_on_screen"), TuplesKt.to(com.tom_roush.pdfbox.pdmodel.a.d.f.g, "turn_off_screen"), TuplesKt.to("unlock", "device_unlock_type")});
    }

    private final void e() {
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.h.get(this.f8342a), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        Tracker r1 = Tracker.INSTANCE;
        JSONObject r2 = new JSONObject();
        r2.put("operation_method", this.f8343b);
        Unit r4 = Unit.INSTANCE;
        r1.reportEvent(r0, r2);
        return;
    }

    public final String a() {
        return this.f8342a;
    }

    public final void a(long r1) {
        this.g = r1;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final String b() {
        return this.f8343b;
    }

    public final String c() {
        return this.f;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        e();
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScreenStateDao().insert(new ic(this.c, this.d, this.e, this.f8342a, this.f8343b, 0, 32, null));
    }

    public final long d() {
        return this.g;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, p.class) == true) goto L8;
        return false;
    L8:
        p r6 = (p) ZeusTransformUtils.preCheckCast(r5, p.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8342a, r6.f8342a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8343b, r6.f8343b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.c;
    }

    public int hashCode() {
        return (this.f8342a.hashCode() * 31) + this.f8343b.hashCode();
    }

    public String toString() {
        return "ScreenStateStandardData(state=" + this.f8342a + ", reason=" + this.f8343b + ')';
    }
}
