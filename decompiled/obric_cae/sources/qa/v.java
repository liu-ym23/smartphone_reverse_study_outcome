package qa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f11152d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f11153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SQLiteDatabase f11154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f11155c;

    static {
        f11152d = new HashMap();
    }

    public v(Context r8, u r10) {
        Context r11 = r8.getApplicationContext();     // Catch: Throwable -> L7
        r10.a();     // Catch: Throwable -> L7
        this.f11153a = new y(r11, "alsn20170807.db", r10);     // Catch: Throwable -> L7
    L9:
        this.f11155c = r10;
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public static ContentValues a(j3 r8, w r10) {
        ContentValues r11 = new ContentValues();
        if (r10.b() == false) goto L5;
        Field[] r12 = j3.class.getSuperclass().getDeclaredFields();
    L6:
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L25;
        Field r15 = r12[r14];
        r15.setAccessible(true);
        Annotation r16 = r15.getAnnotation(x.class);
        if (r16 == null) goto L24;
        x r17 = (x) r16;
        switch(r17.b()) {
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
        String r18 = (String) r15.get(r8);     // Catch: IllegalAccessException -> L22
        r11.put(r17.a(), r18);     // Catch: IllegalAccessException -> L22
        goto L24
    L16:
        long r19 = r15.getLong(r8);     // Catch: IllegalAccessException -> L22
        r11.put(r17.a(), Long.valueOf(r19));     // Catch: IllegalAccessException -> L22
        goto L24
    L17:
        double r20 = r15.getDouble(r8);     // Catch: IllegalAccessException -> L22
        r11.put(r17.a(), Double.valueOf(r20));     // Catch: IllegalAccessException -> L22
        goto L24
    L18:
        float r21 = r15.getFloat(r8);     // Catch: IllegalAccessException -> L22
        r11.put(r17.a(), Float.valueOf(r21));     // Catch: IllegalAccessException -> L22
        goto L24
    L19:
        int r22 = r15.getInt(r8);     // Catch: IllegalAccessException -> L22
        r11.put(r17.a(), Integer.valueOf(r22));     // Catch: IllegalAccessException -> L22
        goto L24
    L20:
        short r23 = r15.getShort(r8);     // Catch: IllegalAccessException -> L22
        r11.put(r17.a(), Short.valueOf(r23));     // Catch: IllegalAccessException -> L22
        goto L24
    L26:
        byte[] r24 = (byte[]) r15.get(r8);     // Catch: IllegalAccessException -> L22
        r11.put(r17.a(), r24);     // Catch: IllegalAccessException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L24:
        r14 = r14 + 1;
        goto L7
    L25:
        return r11;
    L5:
        r12 = j3.class.getDeclaredFields();
        goto L6
    }

    public static <T> T b(Cursor r8, Class<T> r10, w r11) {
        if (r11.b() == false) goto L5;
        Field[] r12 = r10.getSuperclass().getDeclaredFields();
    L6:
        int r13 = 0;
        Constructor<T> r14 = r10.getDeclaredConstructor(new Class[0]);
        r14.setAccessible(true);
        T r15 = r14.newInstance(new Object[0]);
        int r16 = r12.length;
    L7:
        if (r13 >= r16) goto L22;
        Field r17 = r12[r13];
        r17.setAccessible(true);
        Annotation r18 = r17.getAnnotation(x.class);
        if (r18 == null) goto L21;
        x r19 = (x) r18;
        int r20 = r19.b();
        int r21 = r8.getColumnIndex(r19.a());
        switch(r20) {
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
        r17.set(r15, r8.getBlob(r21));
        goto L21
    L14:
        Object r22 = r8.getString(r21);
    L20:
        r17.set(r15, r22);
        goto L21
    L15:
        r22 = Long.valueOf(r8.getLong(r21));
        goto L20
    L16:
        r22 = Double.valueOf(r8.getDouble(r21));
        goto L20
    L17:
        r22 = Float.valueOf(r8.getFloat(r21));
        goto L20
    L18:
        r22 = Integer.valueOf(r8.getInt(r21));
        goto L20
    L19:
        r22 = Short.valueOf(r8.getShort(r21));
    L21:
        r13 = r13 + 1;
        goto L7
    L22:
        return r15;
    L5:
        r12 = r10.getDeclaredFields();
        goto L6
    }

    public static synchronized u d() {
        monitor-enter(v.class);
        HashMap r8 = f11152d;     // Catch: Throwable -> L10
        if (r8.get(k3.class) != null) goto L7;
        r8.put(k3.class, k3.class.newInstance());     // Catch: Throwable -> L10
    L7:
        u r10 = (u) r8.get(k3.class);     // Catch: Throwable -> L10
        monitor-exit(v.class);
        return r10;
    L10:
        th = move-exception;
        throw th;
    }

    public static <T> w g(Class<T> r8) {
        Annotation r10 = r8.getAnnotation(w.class);
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L10;
        return null;
    L10:
        return (w) r10;
    L5:
        r11 = false;
        goto L6
    }

    public final ArrayList c(Class r13) {
        u r8 = this.f11155c;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L84
        w r11 = g(r13);     // Catch: Throwable -> L84
        if (r11 != null) goto L7;
        String r12 = null;
    L8:
        SQLiteDatabase r14 = this.f11154b;     // Catch: Throwable -> L84
        if (r14 != null) goto L17;
        if (r14 == null) goto L91;
    L15:
        this.f11154b = this.f11154b;     // Catch: Throwable -> L84
        goto L17
    L91:
        this.f11154b = this.f11153a.getReadableDatabase();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        l.a("dbs", "grd", th);     // Catch: Throwable -> L84
    L17:
        if (this.f11154b != null) goto L19;
    L82:
        monitor-exit(r8);     // Catch: Throwable -> L84
        return r10;
    L19:
        if (TextUtils.isEmpty(r12) == true) goto L82;
        Cursor r15 = this.f11154b.query(r12, null, "_id=1", null, null, null, null);     // Catch: Throwable -> L53
        if (r15 != null) goto L37;
        this.f11154b.close();     // Catch: Throwable -> L51
        this.f11154b = null;     // Catch: Throwable -> L51
        if (r15 != null) goto L100;
    L94:
        SQLiteDatabase r16 = this.f11154b;     // Catch: Throwable -> L32
        if (r16 == null) goto L82;
        r16.close();     // Catch: Throwable -> L32
        this.f11154b = null;     // Catch: Throwable -> L32
    L32:
        th = th;
        String r17 = "dbs";
        String r18 = "sld";
    L34:
        l.a(r17, r18, th);     // Catch: Throwable -> L84
        goto L82
    L100:
        r15.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        l.a("dbs", "sld", th);     // Catch: Throwable -> L84
    L37:
        if (r15.moveToNext() == false) goto L89;
        r10.add(b(r15, r13, r11));     // Catch: Throwable -> L51
        goto L37
    L89:
        r15.close();     // Catch: Throwable -> L42
    L102:
        SQLiteDatabase r19 = this.f11154b;     // Catch: Throwable -> L48
        if (r19 == null) goto L82;
        r19.close();     // Catch: Throwable -> L48
        this.f11154b = null;     // Catch: Throwable -> L48
    L48:
        th = th;
    L49:
        r17 = "dbs";
        r18 = "sld";
    L42:
        th = move-exception;
        l.a("dbs", "sld", th);     // Catch: Throwable -> L84
    L51:
        th = th;
    L87:
        l.a("dbs", "sld", th);     // Catch: Throwable -> L69
        if (r15 == null) goto L109;
        r15.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        l.a("dbs", "sld", th);     // Catch: Throwable -> L84
    L109:
        SQLiteDatabase r110 = this.f11154b;     // Catch: Throwable -> L65
        if (r110 == null) goto L82;
        r110.close();     // Catch: Throwable -> L65
        this.f11154b = null;     // Catch: Throwable -> L65
    L65:
        th = th;
        goto L49
    L69:
        th = move-exception;
        if (r15 == null) goto L105;
        r15.close();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        l.a("dbs", "sld", th);     // Catch: Throwable -> L84
    L105:
        SQLiteDatabase r20 = this.f11154b;     // Catch: Throwable -> L79
        if (r20 == null) goto L111;
        r20.close();     // Catch: Throwable -> L79
        this.f11154b = null;     // Catch: Throwable -> L79
    L112:
        throw th;     // Catch: Throwable -> L84
    L111:
        throw th;     // Catch: Throwable -> L84
    L79:
        th = move-exception;
        l.a("dbs", "sld", th);     // Catch: Throwable -> L84
        throw th;     // Catch: Throwable -> L84
    L53:
        th = th;
        r15 = null;
        goto L87
    L7:
        r12 = r11.a();     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        throw th;
    }

    public final void e(j3 r8) {
        u r10 = this.f11155c;
        monitor-enter(r10);
        SQLiteDatabase r11 = f();     // Catch: Throwable -> L31
        this.f11154b = r11;     // Catch: Throwable -> L31
        if (r11 != null) goto L37;
    L24:
        monitor-exit(r10);     // Catch: Throwable -> L31
        return;
    L37:
        w r12 = g(j3.class);     // Catch: Throwable -> L19
        if (r12 != null) goto L11;
        String r13 = null;
    L13:
        if (TextUtils.isEmpty(r13) == true) goto L16;
        r11.insert(r13, null, a(r8, r12));     // Catch: Throwable -> L19
    L16:
        SQLiteDatabase r14 = this.f11154b;     // Catch: Throwable -> L31
        if (r14 == null) goto L24;
    L23:
        r14.close();     // Catch: Throwable -> L31
        this.f11154b = null;     // Catch: Throwable -> L31
        goto L24
    L11:
        r13 = r12.a();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        l.a("dbs", "itd", th);     // Catch: Throwable -> L26
        r14 = this.f11154b;     // Catch: Throwable -> L31
        if (r14 == null) goto L24;
    L26:
        th = move-exception;
        SQLiteDatabase r15 = this.f11154b;     // Catch: Throwable -> L31
        if (r15 == null) goto L30;
        r15.close();     // Catch: Throwable -> L31
        this.f11154b = null;     // Catch: Throwable -> L31
    L30:
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public final SQLiteDatabase f() {
        SQLiteDatabase r8 = this.f11154b;     // Catch: Throwable -> L11
        if (r8 != null) goto L5;
    L6:
        SQLiteDatabase r10 = this.f11154b;     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        r10.close();     // Catch: Throwable -> L11
    L9:
        this.f11154b = this.f11153a.getWritableDatabase();     // Catch: Throwable -> L11
    L14:
        return this.f11154b;
    L5:
        if (r8.isReadOnly() == false) goto L14;
    L11:
        th = move-exception;
        l.a("dbs", "gwd", th);
        goto L14
    }

    public final void h(j3 r8) {
        u r10 = this.f11155c;
        monitor-enter(r10);
        w r11 = g(j3.class);     // Catch: Throwable -> L25
        if (r11 != null) goto L7;
        String r12 = null;
    L9:
        if (TextUtils.isEmpty(r12) == true) goto L23;
        ContentValues r13 = a(r8, r11);     // Catch: Throwable -> L25
        SQLiteDatabase r14 = f();     // Catch: Throwable -> L25
        this.f11154b = r14;     // Catch: Throwable -> L25
        if (r14 == null) goto L23;
        r14.update(r12, r13, "_id=1", null);     // Catch: Throwable -> L18
        SQLiteDatabase r15 = this.f11154b;     // Catch: Throwable -> L25
        if (r15 == null) goto L23;
    L22:
        r15.close();     // Catch: Throwable -> L25
        this.f11154b = null;     // Catch: Throwable -> L25
        goto L23
    L18:
        th = move-exception;
        l.a("dbs", "udd", th);     // Catch: Throwable -> L27
        r15 = this.f11154b;     // Catch: Throwable -> L25
        if (r15 == null) goto L23;
    L27:
        th = move-exception;
        SQLiteDatabase r16 = this.f11154b;     // Catch: Throwable -> L25
        if (r16 == null) goto L31;
        r16.close();     // Catch: Throwable -> L25
        this.f11154b = null;     // Catch: Throwable -> L25
    L31:
        throw th;     // Catch: Throwable -> L25
    L23:
        monitor-exit(r10);     // Catch: Throwable -> L25
        return;
    L7:
        r12 = r11.a();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
