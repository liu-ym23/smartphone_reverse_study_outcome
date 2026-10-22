package com.larus.uaigc.lynx.pocket;

import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011JT\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\b\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "", "pocket", "Lcom/larus/uaigc/lynx/pocket/Pocket;", "originData", "", "", "extra", "isFromAvatarResult", "", "<init>", "(Lcom/larus/uaigc/lynx/pocket/Pocket;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)V", "getPocket", "()Lcom/larus/uaigc/lynx/pocket/Pocket;", "getOriginData", "()Ljava/util/Map;", "getExtra", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/uaigc/lynx/pocket/Pocket;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ClickPocketInfo {
    private final Map<String, Object> extra;
    private final Boolean isFromAvatarResult;
    private final Map<String, Object> originData;
    private final Pocket pocket;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClickPocketInfo copy$default(ClickPocketInfo r0, Pocket r1, Map r2, Map r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.pocket;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.originData;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.extra;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isFromAvatarResult;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Pocket component1() {
        return this.pocket;
    }

    public final Map<String, Object> component2() {
        return this.originData;
    }

    public final Map<String, Object> component3() {
        return this.extra;
    }

    public final Boolean component4() {
        return this.isFromAvatarResult;
    }

    public final ClickPocketInfo copy(Pocket r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "pocket");
        Intrinsics.checkNotNullParameter(r3, "originData");
        Intrinsics.checkNotNullParameter(r4, "extra");
        return new ClickPocketInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClickPocketInfo) == true) goto L8;
        return false;
    L8:
        ClickPocketInfo r6 = (ClickPocketInfo) r5;
        if (Intrinsics.areEqual(this.pocket, r6.pocket) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originData, r6.originData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isFromAvatarResult, r6.isFromAvatarResult) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.pocket.hashCode() * 31) + this.originData.hashCode()) * 31) + this.extra.hashCode()) * 31;
        Boolean r1 = this.isFromAvatarResult;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ClickPocketInfo(pocket=" + this.pocket + ", originData=" + this.originData + ", extra=" + this.extra + ", isFromAvatarResult=" + this.isFromAvatarResult + ')';
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final Map<String, Object> getOriginData() {
        return this.originData;
    }

    public final Pocket getPocket() {
        return this.pocket;
    }

    public final Boolean isFromAvatarResult() {
        return this.isFromAvatarResult;
    }

    public ClickPocketInfo(Pocket r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "pocket");
        Intrinsics.checkNotNullParameter(r3, "originData");
        Intrinsics.checkNotNullParameter(r4, "extra");
        this.pocket = r2;
        this.originData = r3;
        this.extra = r4;
        this.isFromAvatarResult = r5;
    }

    public /* synthetic */ ClickPocketInfo(Pocket r1, Map r2, Map r3, Boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = MapsKt.emptyMap();
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        this(r1, r2, r3, r4);
    }
}
