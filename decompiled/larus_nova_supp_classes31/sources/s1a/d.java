package s1a;

import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.context.internal.VContextStore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final t1a.b a(AttachReceiver r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof EmptyComponent) == false) goto L7;
        return new t0();
    L7:
        if ((r3 instanceof Container) == false) goto L13;
        t1a.b r4 = com.larus.ui.arch.context.internal.a.a(((Container) r3).getParent());
        if (r4 == null) goto L11;
        return r4;
    L11:
        return new t0();
    L13:
        if (x1a.a.b == true) goto L15;
        int r0 = y1a.a.a;
        y1a.a.a("ComponentArch", "find vContext from " + r3.getParent());
    L15:
        t1a.b r1 = com.larus.ui.arch.context.internal.a.a(r3.getParent());
        if (r1 == null) goto L23;
        if ((r1 instanceof t0) == true) goto L25;
        VContextStore.Companion.getClass();
        return VContextStore.a.a(r3).getOrInit(r1);
    L25:
        return r1;
    L23:
        throw new Exception("can't find parent: " + r3.getParent());
    }
}
