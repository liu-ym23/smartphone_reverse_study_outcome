package r1;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class z implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.room.r f11384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f11386c;

    public class a extends androidx.room.f<x> {
        @Override // androidx.room.f
        public final void bind(a1.f r8, x r10) {
            x r11 = r10;
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
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public class b extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }

    public z(androidx.room.r r8) {
        this.f11384a = r8;
        this.f11385b = new a(r8);
        this.f11386c = new b(r8);
    }

    @Override // r1.y
    public final ArrayList a(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11384a;
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

    @Override // r1.y
    public final void b(String r8) {
        androidx.room.r r10 = this.f11384a;
        r10.assertNotSuspendingTransaction();
        b r11 = this.f11386c;
        a1.f r12 = r11.acquire();
        r12.R(1, r8);
        r10.beginTransaction();
        r12.g();     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        r11.release(r12);
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        r11.release(r12);
        throw th;
    }

    @Override // r1.y
    public final void c(String r8, Set<String> r10) {
        he.i.f(r10, "tags");
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        d(new x((String) r11.next(), r8));
        goto L4
    }

    public final void d(x r8) {
        androidx.room.r r10 = this.f11384a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11385b.insert(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }
}
