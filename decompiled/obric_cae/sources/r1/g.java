package r1;

import android.database.Cursor;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.room.r f11315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f11316b;

    public g(WorkDatabase r8) {
        this.f11315a = r8;
        this.f11316b = new f(r8);
    }

    @Override // r1.e
    public final void a(d r8) {
        androidx.room.r r10 = this.f11315a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11316b.insert(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @Override // r1.e
    public final Long b(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT long_value FROM Preference where `key`=?");
        r10.R(1, r8);
        androidx.room.r r11 = this.f11315a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
    L13:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L4:
        if (r12.moveToFirst() == true) goto L6;
    L10:
        Long r13 = null;
    L11:
        r12.close();
        r10.n();
        return r13;
    L6:
        if (r12.isNull(0) == true) goto L10;
        r13 = Long.valueOf(r12.getLong(0));     // Catch: Throwable -> L13
        goto L11
    }
}
