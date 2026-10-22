package ih;

import com.bytedance.android.ec.core.apt.ActionType;
import com.bytedance.android.ec.core.monitor.attribution.UserActionCacheMap;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final List<String> a;
    public final UserActionCacheMap<ActionType> b;
    public final UserActionCacheMap<String> c;

    public b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "prefix");
        this.a = new ArrayList();
        this.b = new UserActionCacheMap(r10);
        this.c = new UserActionCacheMap(r10);
    }
}
