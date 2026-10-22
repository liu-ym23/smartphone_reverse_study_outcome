package androidx.room;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class s extends a1.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f2685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2688e;

    public static abstract class a {
        public final int version;

        public a(int r8) {
            this.version = r8;
        }

        public abstract void createAllTables(a1.b r8);

        public abstract void dropAllTables(a1.b r8);

        public abstract void onCreate(a1.b r8);

        public abstract void onOpen(a1.b r8);

        public void onPostMigrate(a1.b r8) {
            he.i.f(r8, "db");
        }

        public void onPreMigrate(a1.b r8) {
            he.i.f(r8, "db");
        }

        public b onValidateSchema(a1.b r8) {
            he.i.f(r8, "db");
            validateMigration(r8);
            return new b(null, true);
        }

        public void validateMigration(a1.b r8) {
            he.i.f(r8, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2690b;

        public b(String r8, boolean r10) {
            this.f2689a = r10;
            this.f2690b = r8;
        }
    }

    public s(c r8, a r10, String r11, String r12) {
        he.i.f(r8, "configuration");
        super(r10.version);
        this.f2685b = r8;
        this.f2686c = r10;
        this.f2687d = r11;
        this.f2688e = r12;
    }

    @Override // a1.c.a
    public final void b(b1.c r8) {
    }

    @Override // a1.c.a
    public final void d(b1.c r8) {
        Cursor r10 = r8.a0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        boolean r11 = false;
        if (r10.moveToFirst() == false) goto L8;
        if (r10.getInt(0) != 0) goto L8;
        r11 = true;
    L8:
        defpackage.c.A(r10, null);
        a r12 = this.f2686c;
        r12.createAllTables(r8);
        if (r11 == true) goto L15;
        b r13 = r12.onValidateSchema(r8);
        if (r13.f2689a == true) goto L15;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r13.f2690b);
    L15:
        h(r8);
        r12.onCreate(r8);
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        defpackage.c.A(r10, th);
        throw th;
    }

    @Override // a1.c.a
    public final void e(b1.c r8, int r10, int r11) {
        g(r8, r10, r11);
    }

    @Override // a1.c.a
    public final void f(b1.c r8) {
        Cursor r10 = r8.a0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        defpackage.c.A(r10, th);
        throw th;
    L4:
        if (r10.moveToFirst() == false) goto L8;
        if (r10.getInt(0) == 0) goto L8;
        boolean r11 = true;
    L9:
        defpackage.c.A(r10, null);
        a r12 = this.f2686c;
        if (r11 == false) goto L29;
        Cursor r13 = r8.q(new a1.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        defpackage.c.A(r13, th);
        throw th;
    L13:
        if (r13.moveToFirst() == false) goto L16;
        String r14 = r13.getString(0);     // Catch: Throwable -> L24
    L17:
        defpackage.c.A(r13, null);
        String r15 = this.f2687d;
        if (he.i.a(r15, r14) == false) goto L20;
    L32:
        r12.onOpen(r8);
        this.f2685b = null;
        return;
    L20:
        if (he.i.a(this.f2688e, r14) == true) goto L32;
        throw new IllegalStateException(defpackage.b.e("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: ", r15, ", found: ", r14));
    L16:
        r14 = null;
        goto L17
    L29:
        b r16 = r12.onValidateSchema(r8);
        if (r16.f2689a == false) goto L35;
        r12.onPostMigrate(r8);
        h(r8);
        goto L32
    L35:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r16.f2690b);
    L8:
        r11 = false;
        goto L9
    }

    @Override // a1.c.a
    public final void g(b1.c r13, int r14, int r15) {
        c r8 = this.f2685b;
        a r10 = this.f2686c;
        boolean r11 = false;
        if (r8 == null) goto L54;
        r.e r12 = r8.f2605d;
        r12.getClass();
        if (r14 != r15) goto L7;
        Iterable r16 = yd.k.f14119a;
    L44:
        if (r16 == null) goto L54;
        r10.onPreMigrate(r13);
        Iterator r17 = r16.iterator();
    L47:
        if (r17.hasNext() == false) goto L49;
        ((x0.a) r17.next()).a(r13);
        goto L47
    L49:
        b r18 = r10.onValidateSchema(r13);
        if (r18.f2689a == false) goto L53;
        r10.onPostMigrate(r13);
        h(r13);
        r11 = true;
        goto L54
    L53:
        throw new IllegalStateException("Migration didn't properly handle: " + r18.f2690b);
    L7:
        if (r15 <= r14) goto L9;
        boolean r19 = true;
    L10:
        ArrayList r20 = new ArrayList();
        int r21 = r14;
    L11:
        if (r19 == false) goto L14;
        if (r21 < r15) goto L15;
    L16:
        boolean r22 = false;
    L17:
        if (r22 == false) goto L43;
        TreeMap r23 = (TreeMap) r12.f2684a.get(Integer.valueOf(r21));
        if (r23 == null) goto L42;
        if (r19 == false) goto L23;
        Set r24 = r23.descendingKeySet();
    L24:
        Iterator r25 = r24.iterator();
    L26:
        if (r25.hasNext() == false) goto L40;
        Integer r26 = (Integer) r25.next();
        if (r19 == false) goto L33;
        int r110 = r21 + 1;
        he.i.e(r26, "targetVersion");
        int r111 = r26.intValue();
        if (r110 > r111) goto L37;
        if (r111 > r15) goto L37;
    L36:
        boolean r112 = true;
    L38:
        if (r112 == false) goto L26;
        Object r27 = r23.get(r26);
        he.i.c(r27);
        r20.add(r27);
        r21 = r26.intValue();
        boolean r28 = true;
    L41:
        if (r28 == true) goto L11;
    L37:
        r112 = false;
        goto L38
    L33:
        he.i.e(r26, "targetVersion");
        int r113 = r26.intValue();
        if (r15 > r113) goto L37;
        if (r113 >= r21) goto L37;
    L40:
        r28 = false;
        goto L41
    L23:
        r24 = r23.keySet();
    L42:
        r16 = null;
        goto L44
    L43:
        r16 = r20;
    L15:
        r22 = true;
        goto L17
    L14:
        if (r21 <= r15) goto L16;
    L9:
        r19 = false;
    L54:
        if (r11 == true) goto L62;
        c r114 = this.f2685b;
        if (r114 == null) goto L61;
        if (r114.a(r14, r15) == true) goto L61;
        r10.dropAllTables(r13);
        r10.createAllTables(r13);
        return;
    L61:
        throw new IllegalStateException("A migration from " + r14 + " to " + r15 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public final void h(b1.c r8) {
        r8.e("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        String r10 = this.f2687d;
        he.i.f(r10, "hash");
        r8.e("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + r10 + "')");
    }
}
