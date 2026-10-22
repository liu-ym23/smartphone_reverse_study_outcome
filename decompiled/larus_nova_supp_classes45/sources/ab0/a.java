package ab0;

import com.bytedance.android.scope.l;
import cy0.e;
import e33.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import u60.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.live.kmp.core.a {
    public static final List<e> c = null;
    public final b a;
    public final ai6.a b;

    /* JADX INFO: renamed from: ab0.a$a, reason: collision with other inner class name */
    public static final class C0001a {
    }

    static {
        c = new ArrayList();
    }

    public final void start() {
        List<e> r0 = c;
        ArrayList r1 = (ArrayList) r0;
        r1.add(this.a);
        l.a(this.a);
    }

    public final void stop() {
        List<e> r0 = c;
        ArrayList r1 = (ArrayList) r0;
        r1.remove(this.a);
        l.c(this.a);
        ((LinkedHashMap) this.b.a).clear();
    }

    public a() {
        e.a.getClass();
        b r0 = new b(e.a.a);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Intrinsics.checkNotNullParameter(this, "value");
        r0.e = this;
        if (this != k.a) goto L5;
        String r1 = "roomInstance";
    L6:
        if (r1 != null) goto L10;
        this.a = r0;
        this.b = new ai6.a();
        return;
    L10:
        throw new UninitializedPropertyAccessException(r1);
    L5:
        r1 = null;
        goto L6
    }

    public final vh6.a a() {
        return this.b;
    }

    public final u60.a c() {
        return this.a;
    }
}
