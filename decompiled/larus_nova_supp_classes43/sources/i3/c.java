package i3;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final CopyOnWriteArrayList<b> a;

    public c() {
        this.a = new CopyOnWriteArrayList();
    }

    public final AIBridgeMethod.Error a(a r10) {
        Intrinsics.checkNotNullParameter(r10, "invocation");
        Iterator<b> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        AIBridgeMethod.Error r1 = r0.next().a(r10);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }
}
