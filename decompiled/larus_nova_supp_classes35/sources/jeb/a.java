package jeb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a implements d {
    public String a;
    public final ArrayList<e> b;

    /* JADX INFO: renamed from: jeb.a$a, reason: collision with other inner class name */
    public static final class C0243a {
    }

    static {
    }

    @Override // jeb.d
    public final void Xa() {
        this.a = null;
    }

    @Override // jeb.d
    public final String q3() {
        return this.a;
    }

    @Inject
    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.b = new ArrayList();
    }

    @Override // jeb.d
    public final void g5(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.b.contains(r2) == true) goto L6;
        this.b.add(r2);
        return;
    }

    @Override // jeb.d
    public final void k4(String r3) {
        Intrinsics.checkNotNullParameter(r3, "feedId");
        this.a = r3;
        Iterator<e> r4 = this.b.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        e r0 = r4.next();
        if (r0 != null) goto L7;
        Log.w("FeedClickDataCache", "IFeedClickDataCacheChangedListener is null");
        goto L4
    L7:
        r0.a(this.a);
        goto L4
    }

    @Override // jeb.d
    public final void od(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.b.contains(r2) == false) goto L6;
        this.b.remove(r2);
        return;
    }
}
