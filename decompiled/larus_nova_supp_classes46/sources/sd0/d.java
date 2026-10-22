package sd0;

import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lsd0/d;", "", "", "Lcom/bytedance/android/live/liveinteract/awemeplay/model/VideoTab;", "tabList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "defaultType", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    @SerializedName("default_type")
    private final Integer defaultType;

    @SerializedName("tab_list")
    private final List<VideoTab> tabList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L10;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.tabList, r4.tabList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultType, r4.defaultType) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<VideoTab> r0 = this.tabList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.defaultType;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoTabRequestResponse(tabList=" + this.tabList + ", defaultType=" + this.defaultType + ")";
    }

    public d() {
        this.tabList = null;
        this.defaultType = null;
    }

    public final Integer a() {
        return this.defaultType;
    }

    public final List<VideoTab> b() {
        return this.tabList;
    }
}
