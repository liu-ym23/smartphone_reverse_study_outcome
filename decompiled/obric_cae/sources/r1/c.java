package r1;

import android.database.Cursor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.room.r f11311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11312b;

    public class a extends androidx.room.f<r1.a> {
        @Override // androidx.room.f
        public final void bind(a1.f r8, r1.a r10) {
            r1.a r11 = r10;
            if (r11.b() != null) goto L5;
            r8.g0(1);
        L7:
            if (r11.a() != null) goto L9;
            r8.g0(2);
            return;
        L9:
            r8.R(2, r11.a());
            return;
        L5:
            r8.R(1, r11.b());
            goto L7
        }

        @Override // androidx.room.x
        public final String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public c(androidx.room.r r8) {
        this.f11311a = r8;
        this.f11312b = new a(r8);
    }

    @Override // r1.b
    public final ArrayList a(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11311a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r10.n();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L5:
        r10.R(1, r8);
        goto L6
    }

    @Override // r1.b
    public final boolean b(String r8) {
        boolean r10 = true;
        androidx.room.t r11 = androidx.room.t.k(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
        if (r8 != null) goto L5;
        r11.g0(1);
    L6:
        androidx.room.r r12 = this.f11311a;
        r12.assertNotSuspendingTransaction();
        boolean r13 = false;
        Cursor r14 = y0.b.b(r12, r11, false);
    L16:
        th = move-exception;
        r14.close();
        r11.n();
        throw th;
    L8:
        if (r14.moveToFirst() == false) goto L14;
        if (r14.getInt(0) != 0) goto L13;
        r10 = false;
    L13:
        r13 = r10;
    L14:
        r14.close();
        r11.n();
        return r13;
    L5:
        r11.R(1, r8);
        goto L6
    }

    @Override // r1.b
    public final void c(r1.a r8) {
        androidx.room.r r10 = this.f11311a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11312b.insert(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @Override // r1.b
    public final boolean d(String r8) {
        boolean r10 = true;
        androidx.room.t r11 = androidx.room.t.k(1, "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?");
        if (r8 != null) goto L5;
        r11.g0(1);
    L6:
        androidx.room.r r12 = this.f11311a;
        r12.assertNotSuspendingTransaction();
        boolean r13 = false;
        Cursor r14 = y0.b.b(r12, r11, false);
    L16:
        th = move-exception;
        r14.close();
        r11.n();
        throw th;
    L8:
        if (r14.moveToFirst() == false) goto L14;
        if (r14.getInt(0) != 0) goto L13;
        r10 = false;
    L13:
        r13 = r10;
    L14:
        r14.close();
        r11.n();
        return r13;
    L5:
        r11.R(1, r8);
        goto L6
    }
}
