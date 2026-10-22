package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {
    private final r database;
    private final AtomicBoolean lock;
    private final xd.b stmt$delegate;

    public static final class a extends he.j implements ge.a<a1.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f2714a;

        public a(x r8) {
            this.f2714a = r8;
            super(0);
        }

        @Override // ge.a
        public final a1.f f() {
            return x.access$createNewStatement(this.f2714a);
        }
    }

    public x(r r8) {
        he.i.f(r8, "database");
        this.database = r8;
        this.lock = new AtomicBoolean(false);
        this.stmt$delegate = defpackage.c.R(new a(this));
    }

    public static final /* synthetic */ a1.f access$createNewStatement(x r8) {
        return r8.createNewStatement();
    }

    private final a1.f createNewStatement() {
        String r8 = createQuery();
        return this.database.compileStatement(r8);
    }

    private final a1.f getStmt() {
        return (a1.f) this.stmt$delegate.getValue();
    }

    public a1.f acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(a1.f r8) {
        he.i.f(r8, "statement");
        if (r8 != getStmt()) goto L6;
        this.lock.set(false);
        return;
    }

    private final a1.f getStmt(boolean r8) {
        if (r8 == false) goto L5;
        return getStmt();
    L5:
        return createNewStatement();
    }
}
