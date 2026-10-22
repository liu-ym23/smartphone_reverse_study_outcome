package zmb;

import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.scaffold.PagePlugin;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements qya.a {
    public final Map<PluginType, Provider<PagePlugin>> a;

    @Inject
    public b(Map<PluginType, Provider<PagePlugin>> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a = r2;
    }

    public final PagePlugin a(PluginType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Provider<PagePlugin> r3 = this.a.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (PagePlugin) r3.get();
    }
}
