package p4;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.bridge.remote.model.FailedKey;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<AppMeta> a;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FailedKey> b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<AppMeta> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        List<FailedKey> r12 = this.b;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BatchAppletMetaInfoResult(items=" + this.a + ", failedKeys=" + this.b + ')';
    }

    public b() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final List<AppMeta> a() {
        return this.a;
    }

    public b(List<AppMeta> r1, List<FailedKey> r10) {
        this.a = r1;
        this.b = r10;
    }
}
