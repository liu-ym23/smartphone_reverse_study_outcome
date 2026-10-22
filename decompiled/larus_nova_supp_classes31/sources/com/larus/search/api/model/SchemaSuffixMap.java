package com.larus.search.api.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J%\u0010\n\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R(\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/search/api/model/SchemaSuffixMap;", "Ljava/io/Serializable;", "map", "", "", "<init>", "(Ljava/util/Map;)V", "getMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SchemaSuffixMap implements Serializable {

    @SerializedName("schema_suffix_map")
    private final Map<String, String> map;

    public SchemaSuffixMap() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SchemaSuffixMap copy$default(SchemaSuffixMap r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.map;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, String> component1() {
        return this.map;
    }

    public final SchemaSuffixMap copy(Map<String, String> r2) {
        return new SchemaSuffixMap(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SchemaSuffixMap) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.map, ((SchemaSuffixMap) r4).map) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Map<String, String> r0 = this.map;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SchemaSuffixMap(map=" + this.map + ')';
    }

    public final Map<String, String> getMap() {
        return this.map;
    }

    public SchemaSuffixMap(Map<String, String> r1) {
        this.map = r1;
    }

    public /* synthetic */ SchemaSuffixMap(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
