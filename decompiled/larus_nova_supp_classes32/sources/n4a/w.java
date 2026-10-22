package n4a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.loc.av;
import com.loc.aw;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w {
    public static final Map<Class<? extends v>, v> d = null;
    public final x a;
    public SQLiteDatabase b;
    public final v c;

    static {
        d = new HashMap();
    }

    public w(Context r3, v r4) {
        Context r5 = r3.getApplicationContext();     // Catch: Throwable -> L7
        r4.a();     // Catch: Throwable -> L7
        this.a = new x(r5, "alsn20170807.db", r4);     // Catch: Throwable -> L7
    L9:
        this.c = r4;
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public static synchronized v d(Class<? extends v> r4) throws IllegalAccessException, InstantiationException {
        monitor-enter(w.class);
        Map<Class<? extends v>, v> r1 = d;     // Catch: Throwable -> L10
        if (((HashMap) r1).get(r4) != null) goto L7;
        HashMap r3 = (HashMap) r1;     // Catch: Throwable -> L10
        r3.put(r4, r4.newInstance());     // Catch: Throwable -> L10
    L7:
        v r5 = (v) ((HashMap) r1).get(r4);     // Catch: Throwable -> L10
        monitor-exit(w.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public static <T> av g(Class<T> r1) {
        Annotation r2 = r1.getAnnotation(av.class);
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return (av) r2;
    L5:
        r0 = false;
        goto L6
    }

    public final SQLiteDatabase f() {
        SQLiteDatabase r0 = this.b;     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
    L6:
        SQLiteDatabase r1 = this.b;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        r1.close();     // Catch: Throwable -> L11
    L9:
        this.b = this.a.getWritableDatabase();     // Catch: Throwable -> L11
    L14:
        return this.b;
    L5:
        if (r0.isReadOnly() == false) goto L14;
    L11:
        th = move-exception;
        n.a(th, "dbs", "gwd");
        goto L14
    }

    public final List c(Class r13) {
        v r8 = this.c;
        monitor-enter(r8);
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L84
        av r10 = g(r13);     // Catch: Throwable -> L84
        if (r10 != null) goto L7;
        String r1 = null;
    L8:
        SQLiteDatabase r0 = this.b;     // Catch: Throwable -> L84
        if (r0 != null) goto L17;
        if (r0 == null) goto L91;
    L15:
        this.b = this.b;     // Catch: Throwable -> L84
        goto L17
    L91:
        this.b = this.a.getReadableDatabase();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        n.a(th, "dbs", "grd");     // Catch: Throwable -> L84
    L17:
        if (this.b != null) goto L19;
    L82:
        monitor-exit(r8);     // Catch: Throwable -> L84
        return r9;
    L19:
        if (TextUtils.isEmpty(r1) == true) goto L82;
        Cursor r2 = this.b.query(r1, null, "_id=1", null, null, null, null);     // Catch: Throwable -> L53
        if (r2 != null) goto L37;
        this.b.close();     // Catch: Throwable -> L51
        this.b = null;     // Catch: Throwable -> L51
        if (r2 != null) goto L100;
    L94:
        SQLiteDatabase r14 = this.b;     // Catch: Throwable -> L32
        if (r14 == null) goto L82;
        r14.close();     // Catch: Throwable -> L32
        this.b = null;     // Catch: Throwable -> L32
    L32:
        th = th;
        String r3 = "dbs";
        String r4 = "sld";
    L34:
        n.a(th, r3, r4);     // Catch: Throwable -> L84
        goto L82
    L100:
        r2.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L37:
        if (r2.moveToNext() == false) goto L89;
        r9.add(b(r2, r13, r10));     // Catch: Throwable -> L51
        goto L37
    L89:
        r2.close();     // Catch: Throwable -> L42
    L102:
        SQLiteDatabase r15 = this.b;     // Catch: Throwable -> L48
        if (r15 == null) goto L82;
        r15.close();     // Catch: Throwable -> L48
        this.b = null;     // Catch: Throwable -> L48
    L48:
        th = th;
    L49:
        r3 = "dbs";
        r4 = "sld";
    L42:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L51:
        th = th;
    L87:
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L69
        if (r2 == null) goto L109;
        r2.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L109:
        SQLiteDatabase r16 = this.b;     // Catch: Throwable -> L65
        if (r16 == null) goto L82;
        r16.close();     // Catch: Throwable -> L65
        this.b = null;     // Catch: Throwable -> L65
    L65:
        th = th;
        goto L49
    L69:
        th = move-exception;
        if (r2 == null) goto L105;
        r2.close();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L105:
        SQLiteDatabase r5 = this.b;     // Catch: Throwable -> L79
        if (r5 == null) goto L111;
        r5.close();     // Catch: Throwable -> L79
        this.b = null;     // Catch: Throwable -> L79
    L112:
        throw th;     // Catch: Throwable -> L84
    L111:
        throw th;     // Catch: Throwable -> L84
    L79:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
        throw th;     // Catch: Throwable -> L84
    L53:
        th = th;
        r2 = null;
        goto L87
    L7:
        r1 = r10.a();     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        throw th;
    }

    public final void e(v3 r7) {
        v r0 = this.c;
        monitor-enter(r0);
        SQLiteDatabase r1 = f();     // Catch: Throwable -> L31
        this.b = r1;     // Catch: Throwable -> L31
        if (r1 != null) goto L37;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L31
        return;
    L37:
        av r3 = g(v3.class);     // Catch: Throwable -> L19
        if (r3 != null) goto L11;
        String r4 = null;
    L13:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r1.insert(r4, null, a(r7, r3));     // Catch: Throwable -> L19
    L16:
        SQLiteDatabase r8 = this.b;     // Catch: Throwable -> L31
        if (r8 == null) goto L24;
    L23:
        r8.close();     // Catch: Throwable -> L31
        this.b = null;     // Catch: Throwable -> L31
        goto L24
    L11:
        r4 = r3.a();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        n.a(th, "dbs", "itd");     // Catch: Throwable -> L26
        r8 = this.b;     // Catch: Throwable -> L31
        if (r8 == null) goto L24;
    L26:
        th = move-exception;
        SQLiteDatabase r2 = this.b;     // Catch: Throwable -> L31
        if (r2 == null) goto L30;
        r2.close();     // Catch: Throwable -> L31
        this.b = null;     // Catch: Throwable -> L31
    L30:
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public final void h(v3 r7) {
        v r1 = this.c;
        monitor-enter(r1);
        av r2 = g(v3.class);     // Catch: Throwable -> L25
        if (r2 != null) goto L7;
        String r4 = null;
    L9:
        if (TextUtils.isEmpty(r4) == true) goto L23;
        ContentValues r8 = a(r7, r2);     // Catch: Throwable -> L25
        SQLiteDatabase r3 = f();     // Catch: Throwable -> L25
        this.b = r3;     // Catch: Throwable -> L25
        if (r3 == null) goto L23;
        r3.update(r4, r8, "_id=1", null);     // Catch: Throwable -> L18
        SQLiteDatabase r9 = this.b;     // Catch: Throwable -> L25
        if (r9 == null) goto L23;
    L22:
        r9.close();     // Catch: Throwable -> L25
        this.b = null;     // Catch: Throwable -> L25
        goto L23
    L18:
        th = move-exception;
        n.a(th, "dbs", "udd");     // Catch: Throwable -> L27
        r9 = this.b;     // Catch: Throwable -> L25
        if (r9 == null) goto L23;
    L27:
        th = move-exception;
        SQLiteDatabase r0 = this.b;     // Catch: Throwable -> L25
        if (r0 == null) goto L31;
        r0.close();     // Catch: Throwable -> L25
        this.b = null;     // Catch: Throwable -> L25
    L31:
        throw th;     // Catch: Throwable -> L25
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L25
        return;
    L7:
        r4 = r2.a();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public static ContentValues a(v3 r7, av r8) {
        ContentValues r0 = new ContentValues();
        if (r8.b() == false) goto L5;
        Field[] r9 = v3.class.getSuperclass().getDeclaredFields();
    L6:
        int r1 = r9.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L25;
        Field r3 = r9[r2];
        r3.setAccessible(true);
        Annotation r4 = r3.getAnnotation(aw.class);
        if (r4 == null) goto L24;
        aw r5 = (aw) r4;
        switch(r5.b()) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L26;
            default: goto L24;
        };
    L15:
        String r6 = (String) r3.get(r7);     // Catch: IllegalAccessException -> L22
        r0.put(r5.a(), r6);     // Catch: IllegalAccessException -> L22
        goto L24
    L16:
        long r10 = r3.getLong(r7);     // Catch: IllegalAccessException -> L22
        r0.put(r5.a(), Long.valueOf(r10));     // Catch: IllegalAccessException -> L22
        goto L24
    L17:
        double r11 = r3.getDouble(r7);     // Catch: IllegalAccessException -> L22
        r0.put(r5.a(), Double.valueOf(r11));     // Catch: IllegalAccessException -> L22
        goto L24
    L18:
        float r12 = r3.getFloat(r7);     // Catch: IllegalAccessException -> L22
        r0.put(r5.a(), Float.valueOf(r12));     // Catch: IllegalAccessException -> L22
        goto L24
    L19:
        int r13 = r3.getInt(r7);     // Catch: IllegalAccessException -> L22
        r0.put(r5.a(), Integer.valueOf(r13));     // Catch: IllegalAccessException -> L22
        goto L24
    L20:
        short r14 = r3.getShort(r7);     // Catch: IllegalAccessException -> L22
        r0.put(r5.a(), Short.valueOf(r14));     // Catch: IllegalAccessException -> L22
        goto L24
    L26:
        byte[] r15 = (byte[]) r3.get(r7);     // Catch: IllegalAccessException -> L22
        r0.put(r5.a(), r15);     // Catch: IllegalAccessException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L24:
        r2 = r2 + 1;
        goto L7
    L25:
        return r0;
    L5:
        r9 = v3.class.getDeclaredFields();
        goto L6
    }

    public static <T> T b(Cursor r6, Class<T> r7, av r8) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (r8.b() == false) goto L5;
        Field[] r9 = r7.getSuperclass().getDeclaredFields();
    L6:
        int r0 = 0;
        Constructor<T> r10 = r7.getDeclaredConstructor(new Class[0]);
        r10.setAccessible(true);
        T r11 = r10.newInstance(new Object[0]);
        int r2 = r9.length;
    L7:
        if (r0 >= r2) goto L22;
        Field r3 = r9[r0];
        r3.setAccessible(true);
        Annotation r4 = r3.getAnnotation(aw.class);
        if (r4 == null) goto L21;
        aw r5 = (aw) r4;
        int r12 = r5.b();
        int r13 = r6.getColumnIndex(r5.a());
        switch(r12) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L21;
        };
    L13:
        r3.set(r11, r6.getBlob(r13));
        goto L21
    L14:
        Object r14 = r6.getString(r13);
    L20:
        r3.set(r11, r14);
        goto L21
    L15:
        r14 = Long.valueOf(r6.getLong(r13));
        goto L20
    L16:
        r14 = Double.valueOf(r6.getDouble(r13));
        goto L20
    L17:
        r14 = Float.valueOf(r6.getFloat(r13));
        goto L20
    L18:
        r14 = Integer.valueOf(r6.getInt(r13));
        goto L20
    L19:
        r14 = Short.valueOf(r6.getShort(r13));
    L21:
        r0 = r0 + 1;
        goto L7
    L22:
        return r11;
    L5:
        r9 = r7.getDeclaredFields();
        goto L6
    }
}
