package xp8;

import aq8.d;
import com.larus.bmhome.instruction.core.impl.base.e;
import com.larus.im.internal.delegate.c0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public d a;
    public final CoroutineScope b;
    public final LinkedHashMap<String, Map<String, e>> c;

    public static final class a {
    }

    static {
    }

    public final Map<String, e> a(String r2) {
        if (r2 != null) goto L6;
        Map<String, e> r3 = (Map) CollectionsKt.lastOrNull(this.c.values());
        if (r3 == null) goto L11;
        return r3;
    L11:
        return MapsKt.emptyMap();
    L6:
        Map<String, e> r4 = this.c.get(r2);
        if (r4 == null) goto L9;
        return r4;
    L9:
        return MapsKt.emptyMap();
    }

    public final void b(String r4) {
        LinkedHashMap<String, Map<String, e>> r0 = this.c;
        if (r4 != null) goto L5;
        r0.clear();
    L6:
        c0.b.i("ProcessorContext", "[removePanelControllers] panelId:" + r4 + ", panelCount:" + this.c.size());
        return;
    L5:
        r0.remove(r4);
        goto L6
    }

    public j(d r2, CoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r2;
        this.b = r3;
        this.c = new LinkedHashMap();
    }
}
