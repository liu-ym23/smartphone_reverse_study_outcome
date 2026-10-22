package com.ss.android.lark.officesdk.api.init;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/HostUriParamGroup;", "", "uris", "", "", "params", "", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "getUris", "()Ljava/util/Set;", "getParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class HostUriParamGroup {
    private final Map<String, String> params;
    private final Set<String> uris;

    /* JADX WARN: Multi-variable type inference failed */
    public HostUriParamGroup() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostUriParamGroup copy$default(HostUriParamGroup r0, Set r1, Map r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.uris;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.params;
    L9:
        return r0.copy(r1, r2);
    }

    public final Set<String> component1() {
        return this.uris;
    }

    public final Map<String, String> component2() {
        return this.params;
    }

    public final HostUriParamGroup copy(Set<String> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        return new HostUriParamGroup(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HostUriParamGroup) == true) goto L8;
        return false;
    L8:
        HostUriParamGroup r6 = (HostUriParamGroup) r5;
        if (Intrinsics.areEqual(this.uris, r6.uris) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Set<String> r0 = this.uris;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.params.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "HostUriParamGroup(uris=" + this.uris + ", params=" + this.params + ')';
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final Set<String> getUris() {
        return this.uris;
    }

    public HostUriParamGroup(Set<String> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.uris = r2;
        this.params = r3;
    }

    public /* synthetic */ HostUriParamGroup(Set r1, Map r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = SetsKt.emptySet();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = MapsKt.emptyMap();
    L8:
        this(r1, r2);
    }
}
