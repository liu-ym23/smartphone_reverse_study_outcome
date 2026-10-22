package com.larus.browsertakeover.cdp;

import com.larus.bmhome.share.panel.ShareType;
import iv8.c1;
import java.util.ArrayDeque;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b<T> {
    public final int a;
    public final int b;
    public final int c;
    public final ArrayDeque<AbstractC0066b<T>> d;
    public int e;
    public int f;
    public int g;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0066b<T> {

        /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b$a */
        public static final class a<T> extends AbstractC0066b<T> {
            public final T a;
            public final Function0<Unit> b;
            public final Function0<Unit> c;

            @Override // com.larus.browsertakeover.cdp.b.AbstractC0066b
            public final T a() {
                return this.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(BrowserCdpClient.m r2, Function0 r3, Function0 r4) {
                Intrinsics.checkNotNullParameter(r3, "action");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b$b, reason: collision with other inner class name */
        public static final class C0067b<T> extends AbstractC0066b<T> {
            public final T a;
            public final RemoteInputCommand.Key b;
            public int c;
            public RemoteInputCommand.Phase d;

            public C0067b() {
                throw null;
            }

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0067b) == true) goto L8;
                return false;
            L8:
                C0067b r6 = (C0067b) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L18;
                return false;
            L18:
                if (this.d == r6.d) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                T r0 = this.a;
                if (r0 != null) goto L5;
                int r1 = 0;
            L7:
                return (((((r1 * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode();
            L5:
                r1 = r0.hashCode();
                goto L7
            }

            public final String toString() {
                return "KeyRun(token=" + this.a + ", key=" + this.b + ", remainingPresses=" + this.c + ", nextPhase=" + this.d + ')';
            }

            @Override // com.larus.browsertakeover.cdp.b.AbstractC0066b
            public final T a() {
                return this.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public C0067b(Object r3, RemoteInputCommand.Key r4, int r5) {
                RemoteInputCommand.Phase r0 = RemoteInputCommand.Phase.DOWN;
                Intrinsics.checkNotNullParameter(r4, "key");
                Intrinsics.checkNotNullParameter(r0, "nextPhase");
                this.a = r3;
                this.b = r4;
                this.c = r5;
                this.d = r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.browsertakeover.cdp.b$b$c */
        public static final class c<T> extends AbstractC0066b<T> {
            public final T a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                T r0 = this.a;
                if (r0 != null) goto L5;
                int r1 = 0;
            L7:
                return (r1 * 31) + this.b.hashCode();
            L5:
                r1 = r0.hashCode();
                goto L7
            }

            public final String toString() {
                return "Text(token=" + this.a + ", text=" + this.b + ')';
            }

            @Override // com.larus.browsertakeover.cdp.b.AbstractC0066b
            public final T a() {
                return this.a;
            }

            public c(T r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
                this.a = r2;
                this.b = r3;
            }
        }

        public AbstractC0066b() {
        }

        public abstract T a();
    }

    static {
    }

    public final synchronized int b() {
        monitor-enter(this);
        int r0 = this.e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized c1<T> c() {
        monitor-enter(this);
        AbstractC0066b<T> r0 = this.d.peekFirst();     // Catch: Throwable -> L32
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if ((r0 instanceof AbstractC0066b.c) == false) goto L12;
        this.d.removeFirst();     // Catch: Throwable -> L32
        RemoteInputCommand r1 = new RemoteInputCommand.b(((AbstractC0066b.c) r0).b);     // Catch: Throwable -> L32
    L27:
        this.e--;     // Catch: Throwable -> L32
        c1<T> r2 = new c1(r0.a(), r1);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r2;
    L12:
        if ((r0 instanceof AbstractC0066b.C0067b) == false) goto L22;
        RemoteInputCommand.Phase r3 = ((AbstractC0066b.C0067b) r0).d;     // Catch: Throwable -> L32
        RemoteInputCommand.Phase r4 = RemoteInputCommand.Phase.DOWN;     // Catch: Throwable -> L32
        if (r3 != r4) goto L16;
        RemoteInputCommand.Phase r5 = RemoteInputCommand.Phase.UP;     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r5, "<set-?>");     // Catch: Throwable -> L32
        ((AbstractC0066b.C0067b) r0).d = r5;     // Catch: Throwable -> L32
    L20:
        r1 = new RemoteInputCommand.c(((AbstractC0066b.C0067b) r0).b, r3);     // Catch: Throwable -> L32
        goto L27
    L16:
        ((AbstractC0066b.C0067b) r0).c--;     // Catch: Throwable -> L32
        if (((AbstractC0066b.C0067b) r0).c != 0) goto L19;
        this.d.removeFirst();     // Catch: Throwable -> L32
        goto L20
    L19:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L32
        ((AbstractC0066b.C0067b) r0).d = r4;     // Catch: Throwable -> L32
        goto L20
    L22:
        if ((r0 instanceof AbstractC0066b.a) == false) goto L31;
        this.d.removeFirst();     // Catch: Throwable -> L32
        this.f--;     // Catch: Throwable -> L32
        if (((AbstractC0066b.a) r0).c == null) goto L26;
        this.g--;     // Catch: Throwable -> L32
    L26:
        r1 = new RemoteInputCommand.a(((AbstractC0066b.a) r0).b, ((AbstractC0066b.a) r0).c);     // Catch: Throwable -> L32
        goto L27
    L31:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public b() {
        this.a = 320;
        this.b = 16;
        this.c = 64;
        this.d = new ArrayDeque();
    }

    public final void a(T r3, RemoteInputCommand.Key r4, int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        AbstractC0066b<T> r0 = this.d.peekLast();
        if ((r0 instanceof AbstractC0066b.C0067b) == false) goto L11;
        AbstractC0066b.C0067b r1 = (AbstractC0066b.C0067b) r0;
        if (Intrinsics.areEqual(r1.a, r3) == false) goto L11;
        if (r1.b != r4) goto L11;
        r1.c += r5;
        return;
    L11:
        this.d.addLast(new AbstractC0066b.C0067b(r3, r4, r5));
    }
}
