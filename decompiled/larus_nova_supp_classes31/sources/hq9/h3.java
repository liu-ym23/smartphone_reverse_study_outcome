package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/ModelFilingInfoConfig;", "", "enabled", "", "manufacturerAllowList", "", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getManufacturerAllowList", "()Ljava/util/List;", "shouldShowForDevice", "manufacturer", "brand", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/platform/model/ModelFilingInfoConfig;", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class h3 {

    @SerializedName("enabled")
    private final Boolean enabled;

    @SerializedName("manufacturer_allow_list")
    private final List<String> manufacturerAllowList;

    public h3() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h3) == true) goto L8;
        return false;
    L8:
        h3 r6 = (h3) r5;
        if (Intrinsics.areEqual(this.enabled, r6.enabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.manufacturerAllowList, r6.manufacturerAllowList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.enabled;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.manufacturerAllowList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ModelFilingInfoConfig(enabled=" + this.enabled + ", manufacturerAllowList=" + this.manufacturerAllowList + ')';
    }

    public h3(Object r4) {
        Boolean r5 = Boolean.TRUE;
        List<String> r0 = CollectionsKt.listOf(new String[]{"OPPO", "OnePlus", "realme"});
        this.enabled = r5;
        this.manufacturerAllowList = r0;
    }

    public final boolean a(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "manufacturer");
        Intrinsics.checkNotNullParameter(r7, "brand");
        if (Intrinsics.areEqual(this.enabled, Boolean.TRUE) == true) goto L6;
        return true;
    L6:
        if (StringsKt.isBlank(r6) == true) goto L8;
    L10:
        List<String> r0 = this.manufacturerAllowList;
        if (r0 == null) goto L13;
        List r1 = CollectionsKt.filterNotNull(r0);
    L14:
        if (r1 != null) goto L16;
        r1 = CollectionsKt.emptyList();
    L16:
        List r2 = r1;
        if ((r2 instanceof Collection) == true) goto L19;
    L21:
        Iterator r3 = r2.iterator();
    L23:
        if (r3.hasNext() == false) goto L36;
        String r4 = (String) r3.next();
        if (StringsKt.isBlank(r6) == true) goto L29;
        if (StringsKt.equals(r4, r6, true) == false) goto L29;
    L32:
        boolean r5 = true;
    L34:
        if (r5 == false) goto L23;
        return true;
    L29:
        if (StringsKt.isBlank(r7) == false) goto L31;
    L33:
        r5 = false;
        goto L34
    L31:
        if (StringsKt.equals(r4, r7, true) == false) goto L33;
    L36:
        return false;
    L19:
        if (r2.isEmpty() == false) goto L21;
    L13:
        r1 = null;
        goto L14
    L8:
        if (StringsKt.isBlank(r7) == false) goto L10;
        return false;
    }
}
