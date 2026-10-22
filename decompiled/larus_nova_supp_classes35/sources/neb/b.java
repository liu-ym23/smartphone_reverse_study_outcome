package neb;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class b implements a {
    public final Set<String> a;
    public final ReadWriteLock b;

    @Override // neb.a
    public final boolean e1() {
        return false;
    }

    @Inject
    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.a = new HashSet();
        new HashSet();
        this.b = new ReentrantReadWriteLock();
    }

    @Override // neb.a
    public final void qe(String r3) {
        Intrinsics.checkNotNullParameter(r3, "feedId");
        Lock r0 = ((ReentrantReadWriteLock) this.b).writeLock();
        r0.lock();
        ((HashSet) this.a).add(r3);     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
