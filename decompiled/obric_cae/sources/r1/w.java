package r1;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Callable<List<t.b>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ androidx.room.t f11380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f11381b;

    public w(v r8, androidx.room.t r10) {
        this.f11381b = r8;
        this.f11380a = r10;
    }

    @Override // java.util.concurrent.Callable
    public final List<t.b> call() {
        v r8 = this.f11381b;
        androidx.room.r r10 = r8.f11368a;
        r10.beginTransaction();
        Cursor r11 = y0.b.b(r10, this.f11380a, true);     // Catch: Throwable -> L39
        n.b<String, ArrayList<String>> r12 = new n.b();     // Catch: Throwable -> L31
        n.b<String, ArrayList<androidx.work.e>> r13 = new n.b();     // Catch: Throwable -> L31
    L6:
        if (r11.moveToNext() == false) goto L13;
        String r14 = r11.getString(0);     // Catch: Throwable -> L31
        if (r12.getOrDefault(r14, null) != null) goto L10;
        r12.put(r14, new ArrayList());     // Catch: Throwable -> L31
    L10:
        String r15 = r11.getString(0);     // Catch: Throwable -> L31
        if (r13.getOrDefault(r15, null) != null) goto L6;
        r13.put(r15, new ArrayList());     // Catch: Throwable -> L31
        goto L6
    L13:
        r11.moveToPosition(-1);     // Catch: Throwable -> L31
        r8.z(r12);     // Catch: Throwable -> L31
        r8.y(r13);     // Catch: Throwable -> L31
        ArrayList r16 = new ArrayList(r11.getCount());     // Catch: Throwable -> L31
    L15:
        if (r11.moveToNext() == false) goto L33;
        if (r11.isNull(0) == false) goto L19;
        String r17 = null;
    L20:
        androidx.work.u.a r18 = l6.a.a0(r11.getInt(1));     // Catch: Throwable -> L31
        if (r11.isNull(2) == false) goto L23;
        byte[] r19 = null;
    L24:
        androidx.work.e r110 = androidx.work.e.a(r19);     // Catch: Throwable -> L31
        int r111 = r11.getInt(3);     // Catch: Throwable -> L31
        int r112 = r11.getInt(4);     // Catch: Throwable -> L31
        ArrayList<String> r20 = r12.getOrDefault(r11.getString(0), null);     // Catch: Throwable -> L31
        if (r20 != null) goto L27;
        r20 = new ArrayList();     // Catch: Throwable -> L31
    L27:
        ArrayList<String> r113 = r20;
        ArrayList<androidx.work.e> r21 = r13.getOrDefault(r11.getString(0), null);     // Catch: Throwable -> L31
        if (r21 != null) goto L30;
        r21 = new ArrayList();     // Catch: Throwable -> L31
    L30:
        r16.add(new t.b(r17, r18, r110, r111, r112, r113, r21));     // Catch: Throwable -> L31
        goto L15
    L23:
        r19 = r11.getBlob(2);     // Catch: Throwable -> L31
        goto L24
    L19:
        r17 = r11.getString(0);     // Catch: Throwable -> L31
        goto L20
    L33:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L31
        r11.close();     // Catch: Throwable -> L39
        r10.endTransaction();
        return r16;
    L31:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    public final void finalize() {
        this.f11380a.n();
    }
}
