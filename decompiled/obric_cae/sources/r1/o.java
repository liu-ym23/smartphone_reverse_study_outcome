package r1;

import android.database.Cursor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.room.r f11328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11329b;

    public class a extends androidx.room.f<m> {
        @Override // androidx.room.f
        public final void bind(a1.f r8, m r10) {
            m r11 = r10;
            if (r11.a() != null) goto L5;
            r8.g0(1);
        L7:
            if (r11.b() != null) goto L9;
            r8.g0(2);
            return;
        L9:
            r8.R(2, r11.b());
            return;
        L5:
            r8.R(1, r11.a());
            goto L7
        }

        @Override // androidx.room.x
        public final String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public o(androidx.room.r r8) {
        this.f11328a = r8;
        this.f11329b = new a(r8);
    }

    @Override // r1.n
    public final void a(m r8) {
        androidx.room.r r10 = this.f11328a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11329b.insert(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @Override // r1.n
    public final ArrayList b(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT name FROM workname WHERE work_spec_id=?");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11328a;
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
}
