package t5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/settings/provider/OptimizeSettings;", "", "optimizeRender", "", "enableToolRuntimeEntry", "preloadAppIdList", "", "", "<init>", "(ZZLjava/util/List;)V", "getOptimizeRender", "()Z", "getEnableToolRuntimeEntry", "getPreloadAppIdList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

    @SerializedName("enable_tool_runtime_entry")
    private final boolean enableToolRuntimeEntry;

    @SerializedName("optimize_render")
    private final boolean optimizeRender;

    @SerializedName("preload_app_id_list")
    private final List<String> preloadAppIdList;

    public m() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m) == true) goto L8;
        return false;
    L8:
        m r11 = (m) r10;
        if (this.optimizeRender == r11.optimizeRender) goto L12;
        return false;
    L12:
        if (this.enableToolRuntimeEntry == r11.enableToolRuntimeEntry) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.preloadAppIdList, r11.preloadAppIdList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.optimizeRender == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.enableToolRuntimeEntry == true) goto L10;
        r1 = 1237;
    L10:
        int r11 = (r10 + r1) * 31;
        List<String> r12 = this.preloadAppIdList;
        if (r12 != null) goto L13;
        int r13 = 0;
    L15:
        return r11 + r13;
    L13:
        r13 = r12.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OptimizeSettings(optimizeRender=" + this.optimizeRender + ", enableToolRuntimeEntry=" + this.enableToolRuntimeEntry + ", preloadAppIdList=" + this.preloadAppIdList + ')';
    }

    public final boolean a() {
        return this.enableToolRuntimeEntry;
    }

    public final List<String> b() {
        return this.preloadAppIdList;
    }

    public m(Object r10) {
        List<String> r11 = CollectionsKt.emptyList();
        this.optimizeRender = true;
        this.enableToolRuntimeEntry = true;
        this.preloadAppIdList = r11;
    }
}
