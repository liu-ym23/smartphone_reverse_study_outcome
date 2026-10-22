package r1;

import android.database.Cursor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.room.r f11320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f11322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f11323d;

    public class a extends androidx.room.f<i> {
        @Override // androidx.room.f
        public final void bind(a1.f r8, i r10) {
            i r11 = r10;
            String r12 = r11.f11317a;
            if (r12 != null) goto L5;
            r8.g0(1);
        L6:
            r8.W(2, r11.a());
            r8.W(3, r11.f11319c);
            return;
        L5:
            r8.R(1, r12);
            goto L6
        }

        @Override // androidx.room.x
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }
    }

    public class b extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
        }
    }

    public class c extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public k(androidx.room.r r8) {
        this.f11320a = r8;
        this.f11321b = new a(r8);
        this.f11322c = new b(r8);
        this.f11323d = new c(r8);
    }

    @Override // r1.j
    public final void a(i r8) {
        androidx.room.r r10 = this.f11320a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11321b.insert(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @Override // r1.j
    public final i b(l r8) {
        he.i.f(r8, "id");
        return f(r8.f11325b, r8.f11324a);
    }

    @Override // r1.j
    public final ArrayList c() {
        androidx.room.t r8 = androidx.room.t.k(0, "SELECT DISTINCT work_spec_id FROM SystemIdInfo");
        androidx.room.r r10 = this.f11320a;
        r10.assertNotSuspendingTransaction();
        Cursor r11 = y0.b.b(r10, r8, false);
        ArrayList r12 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L4:
        if (r11.moveToNext() == false) goto L12;
        if (r11.isNull(0) == false) goto L9;
        String r13 = null;
    L10:
        r12.add(r13);     // Catch: Throwable -> L14
        goto L4
    L9:
        r13 = r11.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r11.close();
        r8.n();
        return r12;
    L14:
        th = move-exception;
        r11.close();
        r8.n();
        throw th;
    }

    @Override // r1.j
    public final void d(String r8) {
        androidx.room.r r10 = this.f11320a;
        r10.assertNotSuspendingTransaction();
        c r11 = this.f11323d;
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

    @Override // r1.j
    public final void e(l r8) {
        g(r8.f11325b, r8.f11324a);
    }

    public final i f(int r8, String r10) {
        androidx.room.t r11 = androidx.room.t.k(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        if (r10 != null) goto L5;
        r11.g0(1);
    L6:
        r11.W(2, r8);
        androidx.room.r r12 = this.f11320a;
        r12.assertNotSuspendingTransaction();
        Cursor r13 = y0.b.b(r12, r11, false);
        int r14 = y0.a.b(r13, "work_spec_id");     // Catch: Throwable -> L17
        int r15 = y0.a.b(r13, "generation");     // Catch: Throwable -> L17
        int r16 = y0.a.b(r13, "system_id");     // Catch: Throwable -> L17
        i r17 = null;
        String r18 = null;
        if (r13.moveToFirst() == true) goto L10;
    L15:
        r13.close();
        r11.n();
        return r17;
    L10:
        if (r13.isNull(r14) == true) goto L13;
        r18 = r13.getString(r14);     // Catch: Throwable -> L17
    L13:
        r17 = new i(r18, r13.getInt(r15), r13.getInt(r16));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r13.close();
        r11.n();
        throw th;
    L5:
        r11.R(1, r10);
        goto L6
    }

    public final void g(int r8, String r10) {
        androidx.room.r r11 = this.f11320a;
        r11.assertNotSuspendingTransaction();
        b r12 = this.f11322c;
        a1.f r13 = r12.acquire();
        if (r10 != null) goto L5;
        r13.g0(1);
    L6:
        r13.W(2, r8);
        r11.beginTransaction();
        r13.g();     // Catch: Throwable -> L10
        r11.setTransactionSuccessful();     // Catch: Throwable -> L10
        r11.endTransaction();
        r12.release(r13);
        return;
    L10:
        th = move-exception;
        r11.endTransaction();
        r12.release(r13);
        throw th;
    L5:
        r13.R(1, r10);
        goto L6
    }
}
