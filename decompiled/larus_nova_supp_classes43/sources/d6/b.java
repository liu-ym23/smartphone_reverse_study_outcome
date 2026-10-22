package d6;

import com.bytedance.als.LogicComponent;
import com.bytedance.als.monitor.ComponentLifecycle;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final HashMap<ComponentLifecycle, Long> a;
    public long b;
    public final LogicComponent<?> c;

    public b(LogicComponent<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "component");
        this.c = r10;
        this.a = new HashMap();
    }

    public final void a(LogicComponent<?> r10, ComponentLifecycle r11, long r12) {
        if (this.a.get(r11) != null) goto L5;
        this.a.put(r11, Long.valueOf(r12));
    L5:
        int r13 = a.a;
        Intrinsics.checkNotNullParameter(r10, "component");
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
    }
}
