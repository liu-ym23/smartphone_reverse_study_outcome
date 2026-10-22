package ji8;

import com.larus.bmhome.chat.api.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements y {
    public static final d a = null;
    public static final HashMap<String, Set<c>> b = null;
    public static final Set<b> c = null;

    public d() {
    }

    static {
        a = new d();
        b = new HashMap();
        c = new LinkedHashSet();
    }

    @Override // com.larus.bmhome.chat.api.y
    public final void d(b r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        c.add(r2);
    }

    @Override // com.larus.bmhome.chat.api.y
    public final void e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        c.remove(r2);
    }

    @Override // com.larus.bmhome.chat.api.y
    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Set<c> r4 = b.get(r2);
        if (r4 == null) goto L8;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ((c) r5.next()).a();
        goto L6
    L10:
        return;
    }
}
