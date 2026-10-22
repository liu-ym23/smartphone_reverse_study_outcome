package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/index/ExtractContentTimeResult;", "", "times", "", "Lcom/obric/memorydata/database/index/ExtractTime;", "timeDescPair", "", "", "Lcom/obric/memorydata/database/index/ExtractTimeDescPair;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getTimes", "()Ljava/util/List;", "getTimeDescPair", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtractContentTimeResult {
    private final Map<String, ExtractTimeDescPair> timeDescPair;
    private final List<ExtractTime> times;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtractContentTimeResult() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public ExtractContentTimeResult(List<ExtractTime> r3, Map<String, ExtractTimeDescPair> r4) {
        List<ExtractTime> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Map<String, ExtractTimeDescPair> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.times = r5;
        this.timeDescPair = r6;
    }

    public /* synthetic */ ExtractContentTimeResult(List r2, Map r3, int r4, DefaultConstructorMarker r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = null;
    L8:
        this(r6, r7);
    }

    public static /* synthetic */ ExtractContentTimeResult copy$default(ExtractContentTimeResult r1, List r2, Map r3, int r4, Object r5) {
        List<ExtractTime> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Map<String, ExtractTimeDescPair> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.times;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.timeDescPair;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<ExtractTime> component1() {
        return this.times;
    }

    public final Map<String, ExtractTimeDescPair> component2() {
        return this.timeDescPair;
    }

    public final ExtractContentTimeResult copy(List<ExtractTime> r2, Map<String, ExtractTimeDescPair> r3) {
        return new ExtractContentTimeResult((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ExtractContentTimeResult.class) == true) goto L8;
        return false;
    L8:
        ExtractContentTimeResult r6 = (ExtractContentTimeResult) ZeusTransformUtils.preCheckCast(r5, ExtractContentTimeResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.times, r6.times) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timeDescPair, r6.timeDescPair) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Map<String, ExtractTimeDescPair> getTimeDescPair() {
        return this.timeDescPair;
    }

    public final List<ExtractTime> getTimes() {
        return this.times;
    }

    public int hashCode() {
        List<ExtractTime> r0 = this.times;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, ExtractTimeDescPair> r4 = this.timeDescPair;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ExtractContentTimeResult(times=" + this.times + ", timeDescPair=" + this.timeDescPair + ')';
    }
}
