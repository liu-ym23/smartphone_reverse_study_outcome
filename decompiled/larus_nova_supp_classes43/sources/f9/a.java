package f9;

import android.webkit.WebResourceResponse;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // f9.b
    public final String getHostGeckoCacheDir() {
        return null;
    }

    @Override // f9.b
    public final WebResourceResponse interceptRequest(String r1) {
        return null;
    }

    @Override // f9.b
    public final void m1() {
    }

    @Override // f9.b
    public final void setCachePrefix(List<Pattern> r10) {
        Intrinsics.checkNotNullParameter(r10, "patterns");
    }

    @Override // f9.b
    public final List<String> getSafeJsbHostList() {
        return CollectionsKt.emptyList();
    }

    @Override // f9.b
    public final Map<String, String> getHeaderMap(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return MapsKt.emptyMap();
    }
}
