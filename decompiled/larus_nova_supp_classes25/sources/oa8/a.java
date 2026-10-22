package oa8;

import com.larus.office.h;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements do4.a {
    public final h a;
    public final LinkedHashSet<String> b;

    /* JADX INFO: renamed from: oa8.a$a, reason: collision with other inner class name */
    public static final class C0082a {
    }

    public final class b implements do4.a.a {
        public final String a;
        public final AtomicBoolean b;
        public final /* synthetic */ a c;

        public final void close() {
            if (this.b.compareAndSet(false, true) == false) goto L12;
            a r0 = this.c;
            monitor-enter(r0);
            r0.a(this.a, false);     // Catch: Throwable -> L9
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r0);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public b(a r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            this.c = r2;
            this.a = r3;
            this.b = new AtomicBoolean(false);
        }
    }

    static {
    }

    public final synchronized b s1() {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("NativeFormEdit", "owner");     // Catch: Throwable -> L7
        String r0 = "token:NativeFormEdit:" + UUID.randomUUID();     // Catch: Throwable -> L7
        a(r0, true);     // Catch: Throwable -> L7
        b r1 = new b(this, r0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "hostAbilityProvider");
        this.a = r2;
        this.b = new LinkedHashSet();
    }

    public final synchronized void xg(boolean r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter("EmbeddedDocument", "owner");     // Catch: Throwable -> L7
        a("owner:EmbeddedDocument", r3);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(String r6, boolean r7) {
        boolean r0 = !this.b.isEmpty();
        if (r7 == false) goto L5;
        this.b.add(r6);
    L6:
        boolean r1 = !this.b.isEmpty();
        FLogger.a.i("BaseMainAIChatVisibility", "update key=" + r6 + " hidden=" + r7 + " active=" + this.b.size());
        if (r0 == r1) goto L12;
        com.larus.office.a r8 = this.a.Ff();
        if (r8 == null) goto L13;
        r8.setChatInputVisibility("base_main_visibility", !r1);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        this.b.remove(r6);
        goto L6
    }
}
