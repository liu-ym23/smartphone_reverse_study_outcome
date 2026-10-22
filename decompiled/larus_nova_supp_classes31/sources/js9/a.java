package js9;

import androidx.fragment.app.Fragment;
import com.larus.platform.api.creation.UserCreation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements b {
    public static final a a = null;
    public static final List<b> b = null;

    public a() {
    }

    static {
        a = new a();
        ArrayList r0 = new ArrayList();
        b = r0;
        c r1 = new c();
        if (r0.contains(r1) == true) goto L5;
        r0.add(r1);
    L5:
        g r2 = new g();
        if (r0.contains(r2) == true) goto L8;
        r0.add(r2);
    L8:
        f r3 = new f();
        if (r0.contains(r3) == true) goto L11;
        r0.add(r3);
    L11:
        d r4 = new d();
        if (r0.contains(r4) == true) goto L15;
        r0.add(r4);
        return;
    }

    @Override // js9.b
    public final Fragment a(UserCreation r3, Fragment r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "creation");
        Iterator<T> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Fragment r1 = ((b) r0.next()).a(r3, r4, r5, r6);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }
}
