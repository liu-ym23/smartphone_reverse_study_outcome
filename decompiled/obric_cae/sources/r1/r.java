package r1;

/* JADX INFO: loaded from: classes.dex */
public final class r implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.room.r f11332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f11334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f11335d;

    public class a extends androidx.room.f<p> {
        @Override // androidx.room.f
        public final void bind(a1.f r8, p r10) {
            p r11 = r10;
            if (r11.b() != null) goto L5;
            r8.g0(1);
        L6:
            byte[] r12 = androidx.work.e.e(r11.a());
            if (r12 != null) goto L9;
            r8.g0(2);
            return;
        L9:
            r8.Y(2, r12);
            return;
        L5:
            r8.R(1, r11.b());
            goto L6
        }

        @Override // androidx.room.x
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    public class b extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public r(androidx.room.r r8) {
        this.f11332a = r8;
        this.f11333b = new a(r8);
        this.f11334c = new b(r8);
        this.f11335d = new c(r8);
    }

    @Override // r1.q
    public final void a(p r8) {
        androidx.room.r r10 = this.f11332a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11333b.insert(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @Override // r1.q
    public final void b() {
        androidx.room.r r8 = this.f11332a;
        r8.assertNotSuspendingTransaction();
        c r10 = this.f11335d;
        a1.f r11 = r10.acquire();
        r8.beginTransaction();
        r11.g();     // Catch: Throwable -> L6
        r8.setTransactionSuccessful();     // Catch: Throwable -> L6
        r8.endTransaction();
        r10.release(r11);
        return;
    L6:
        th = move-exception;
        r8.endTransaction();
        r10.release(r11);
        throw th;
    }

    @Override // r1.q
    public final void delete(String r8) {
        androidx.room.r r10 = this.f11332a;
        r10.assertNotSuspendingTransaction();
        b r11 = this.f11334c;
        a1.f r12 = r11.acquire();
        if (r8 != null) goto L5;
        r12.g0(1);
    L6:
        r10.beginTransaction();
        r12.g();     // Catch: Throwable -> L10
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        r10.endTransaction();
        r11.release(r12);
        return;
    L10:
        th = move-exception;
        r10.endTransaction();
        r11.release(r12);
        throw th;
    L5:
        r12.R(1, r8);
        goto L6
    }
}
