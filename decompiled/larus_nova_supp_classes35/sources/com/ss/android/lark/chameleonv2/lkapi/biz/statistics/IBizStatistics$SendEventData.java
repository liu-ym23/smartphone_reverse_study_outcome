package com.ss.android.lark.chameleonv2.lkapi.biz.statistics;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/biz/statistics/IBizStatistics$SendEventData;", "Lcom/bytedance/ee/util/io/NonProguard;", "eventType", BuildConfig.FLAVOR, "timeStamp", BuildConfig.FLAVOR, "params", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;JLjava/util/Map;)V", "getEventType", "()Ljava/lang/String;", "getTimeStamp", "()J", "getParams", "()Ljava/util/Map;", "toString", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IBizStatistics$SendEventData implements NonProguard {
    private final String eventType;
    private final Map<String, String> params;
    private final long timeStamp;

    public IBizStatistics$SendEventData() {
        this(null, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IBizStatistics$SendEventData copy$default(IBizStatistics$SendEventData r0, String r1, long r2, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.eventType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.timeStamp;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.params;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final String component1() {
        return this.eventType;
    }

    public final long component2() {
        return this.timeStamp;
    }

    public final Map<String, String> component3() {
        return this.params;
    }

    public final IBizStatistics$SendEventData copy(String r2, long r3, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r5, "params");
        return new IBizStatistics$SendEventData(r2, r3, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IBizStatistics$SendEventData) == true) goto L8;
        return false;
    L8:
        IBizStatistics$SendEventData r9 = (IBizStatistics$SendEventData) r8;
        if (Intrinsics.areEqual(this.eventType, r9.eventType) == true) goto L12;
        return false;
    L12:
        if (this.timeStamp == r9.timeStamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r9.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.eventType.hashCode() * 31;
        long r1 = this.timeStamp;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "SendEventData(eventType='" + this.eventType + "', timeStamp=" + this.timeStamp + ", params=" + this.params.size() + ')';
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public IBizStatistics$SendEventData(String r2, long r3, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.eventType = r2;
        this.timeStamp = r3;
        this.params = r5;
    }

    public /* synthetic */ IBizStatistics$SendEventData(String r1, long r2, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = BuildConfig.FLAVOR;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new LinkedHashMap();
    L11:
        this(r1, r2, r4);
    }
}
