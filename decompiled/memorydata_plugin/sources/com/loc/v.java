package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class v {
    private static Map<Class<? extends t>, t> d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y f5645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f5646b;
    private t c;

    static {
        d = new HashMap();
    }

    public v(Context r4, t r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        t r7 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        this.f5645a = new y((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7.a(), r7);     // Catch: Throwable -> L5
    L7:
        this.c = r7;
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    private static ContentValues a(Object r5, w r6) {
        w r7 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.memorydata.plugin");
        ContentValues r0 = new ContentValues();
        Field[] r8 = a(r5.getClass(), r7.b());
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Field r3 = r8[r2];
        r3.setAccessible(true);
        a(r5, r3, r0);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private SQLiteDatabase a() {
    L6:
        th = move-exception;
        n.a(th, "dbs", "grd");
    L9:
        return this.f5646b;
    L3:
        if (this.f5646b != null) goto L9;
        this.f5646b = this.f5645a.getReadableDatabase();     // Catch: Throwable -> L6
        goto L9
    }

    public static synchronized t a(Class<? extends t> r3) {
        monitor-enter(v.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (d.get(r3) != null) goto L7;
        d.put(r3, r3.newInstance());     // Catch: Throwable -> L10
    L7:
        t r4 = (t) ZeusTransformUtils.preCheckCast(d.get(r3), t.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        monitor-exit(v.class);
        return r4;
    }

    private static <T> T a(Cursor r7, Class<T> r8, w r9) {
        Cursor r10 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r7, Cursor.class, "com.obric.memorydata.plugin");
        Field[] r11 = a(r8, ((w) ZeusTransformUtils.wrapperContextForParams(r9, w.class, "com.obric.memorydata.plugin")).b());
        int r0 = 0;
        Constructor<T> r12 = r8.getDeclaredConstructor(new Class[0]);
        r12.setAccessible(true);
        T r13 = r12.newInstance(new Object[0]);
        int r3 = r11.length;
    L3:
        if (r0 >= r3) goto L18;
        Field r4 = r11[r0];
        r4.setAccessible(true);
        Annotation r5 = r4.getAnnotation(x.class);
        if (r5 == null) goto L17;
        x r6 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.memorydata.plugin");
        int r14 = r6.b();
        int r15 = r10.getColumnIndex(r6.a());
        switch(r14) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L17;
        };
    L9:
        r4.set(r13, r10.getBlob(r15));
        goto L17
    L10:
        Object r16 = r10.getString(r15);
    L16:
        r4.set(r13, r16);
        goto L17
    L11:
        r16 = Long.valueOf(r10.getLong(r15));
        goto L16
    L12:
        r16 = Double.valueOf(r10.getDouble(r15));
        goto L16
    L13:
        r16 = Float.valueOf(r10.getFloat(r15));
        goto L16
    L14:
        r16 = Integer.valueOf(r10.getInt(r15));
        goto L16
    L15:
        r16 = Short.valueOf(r10.getShort(r15));
    L17:
        r0 = r0 + 1;
        goto L3
    L18:
        return r13;
    }

    private static <T> String a(w r2) {
        w r3 = (w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a();
    }

    private static <T> void a(SQLiteDatabase r3, T r4) {
        w r0 = b(r4.getClass());
        String r1 = a(r0);
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (r4 == null) goto L10;
        if (r3 == null) goto L11;
        r3.insert(r1, null, a(r4, r0));
        return;
    L11:
        return;
    }

    private <T> void a(T r1) {
        b(r1);
    }

    private static void a(Object r3, Field r4, ContentValues r5) {
        Annotation r0 = r4.getAnnotation(x.class);
        if (r0 != null) goto L5;
        return;
    L5:
        x r1 = (x) ZeusTransformUtils.preCheckCast(r0, x.class, "com.obric.memorydata.plugin");
        switch(r1.b()) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L26;
        };
    L8:
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r4.get(r3), byte[].class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L21
        r5.put(r1.a(), r6);     // Catch: IllegalAccessException -> L21
        return;
    L9:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.get(r3), String.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L21
        r5.put(r1.a(), r7);     // Catch: IllegalAccessException -> L21
        return;
    L11:
        long r8 = r4.getLong(r3);     // Catch: IllegalAccessException -> L21
        r5.put(r1.a(), Long.valueOf(r8));     // Catch: IllegalAccessException -> L21
        return;
    L13:
        double r9 = r4.getDouble(r3);     // Catch: IllegalAccessException -> L21
        r5.put(r1.a(), Double.valueOf(r9));     // Catch: IllegalAccessException -> L21
        return;
    L15:
        float r10 = r4.getFloat(r3);     // Catch: IllegalAccessException -> L21
        r5.put(r1.a(), Float.valueOf(r10));     // Catch: IllegalAccessException -> L21
        return;
    L17:
        int r11 = r4.getInt(r3);     // Catch: IllegalAccessException -> L21
        r5.put(r1.a(), Integer.valueOf(r11));     // Catch: IllegalAccessException -> L21
        return;
    L19:
        short r12 = r4.getShort(r3);     // Catch: IllegalAccessException -> L21
        r5.put(r1.a(), Short.valueOf(r12));     // Catch: IllegalAccessException -> L21
        return;
    L26:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    private <T> void a(String r5, Object r6) {
        t r0 = this.c;
        monitor-enter(r0);
        if (r6 != null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L7:
        w r1 = b(r6.getClass());     // Catch: Throwable -> L34
        String r2 = a(r1);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r2) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L11:
        ContentValues r7 = a(r6, r1);     // Catch: Throwable -> L34
        SQLiteDatabase r3 = b();     // Catch: Throwable -> L34
        this.f5646b = r3;     // Catch: Throwable -> L34
        if (r3 != null) goto L38;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L38:
        r3.update(r2, r7, r5, null);     // Catch: Throwable -> L22
        SQLiteDatabase r8 = this.f5646b;     // Catch: Throwable -> L34
        if (r8 == null) goto L27;
        r8.close();     // Catch: Throwable -> L34
    L20:
        this.f5646b = null;     // Catch: Throwable -> L34
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L22:
        th = move-exception;
        n.a(th, "dbs", "udd");     // Catch: Throwable -> L29
        SQLiteDatabase r9 = this.f5646b;     // Catch: Throwable -> L34
        if (r9 == null) goto L27;
        r9.close();     // Catch: Throwable -> L34
        goto L20
    L29:
        th = move-exception;
        SQLiteDatabase r10 = this.f5646b;     // Catch: Throwable -> L34
        if (r10 == null) goto L33;
        r10.close();     // Catch: Throwable -> L34
        this.f5646b = null;     // Catch: Throwable -> L34
    L33:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    private static Field[] a(Class<?> r0, boolean r1) {
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r1 == false) goto L9;
        return r0.getSuperclass().getDeclaredFields();
    L9:
        return r0.getDeclaredFields();
    }

    private SQLiteDatabase b() {
        SQLiteDatabase r0 = this.f5646b;     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
    L6:
        SQLiteDatabase r1 = this.f5646b;     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        r1.close();     // Catch: Throwable -> L11
    L9:
        this.f5646b = this.f5645a.getWritableDatabase();     // Catch: Throwable -> L11
    L14:
        return this.f5646b;
    L5:
        if (r0.isReadOnly() == false) goto L14;
    L11:
        th = move-exception;
        n.a(th, "dbs", "gwd");
        goto L14
    }

    private static <T> w b(Class<T> r2) {
        Annotation r3 = r2.getAnnotation(w.class);
        if (r3 == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return (w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin");
    L5:
        r0 = false;
        goto L6
    }

    private <T> List<T> b(String r13, Class<T> r14) {
        t r0 = this.c;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L80
        w r2 = b(r14);     // Catch: Throwable -> L80
        String r4 = a(r2);     // Catch: Throwable -> L80
        if (this.f5646b != null) goto L8;
        this.f5646b = a();     // Catch: Throwable -> L80
    L8:
        if (this.f5646b != null) goto L10;
    L78:
        monitor-exit(r0);     // Catch: Throwable -> L80
        return r1;
    L10:
        if (TextUtils.isEmpty(r4) == true) goto L78;
        if (r13 == null) goto L78;
        Cursor r15 = this.f5646b.query(r4, null, r13, null, null, null, null);     // Catch: Throwable -> L49
        if (r15 != null) goto L31;
        this.f5646b.close();     // Catch: Throwable -> L47
        this.f5646b = null;     // Catch: Throwable -> L47
        if (r15 == null) goto L99;
        r15.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L80
    L99:
        SQLiteDatabase r16 = this.f5646b;     // Catch: Throwable -> L26
        if (r16 == null) goto L28;
        r16.close();     // Catch: Throwable -> L26
        this.f5646b = null;     // Catch: Throwable -> L26
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L80
        return r1;
    L26:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L80
    L31:
        if (r15.moveToNext() == false) goto L34;
        r1.add(a(r15, r14, r2));     // Catch: Throwable -> L47
        goto L31
    L34:
        if (r15 == null) goto L97;
        r15.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L80
    L97:
        SQLiteDatabase r17 = this.f5646b;     // Catch: Throwable -> L43
        if (r17 == null) goto L63;
        r17.close();     // Catch: Throwable -> L43
        this.f5646b = null;     // Catch: Throwable -> L43
    L63:
        monitor-exit(r0);     // Catch: Throwable -> L80
        return r1;
    L43:
        th = th;
        String r18 = "dbs";
        String r19 = "sld";
    L45:
        n.a(th, r18, r19);     // Catch: Throwable -> L80
    L47:
        th = th;
    L101:
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L65
        if (r15 == null) goto L89;
        r15.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L80
    L89:
        SQLiteDatabase r110 = this.f5646b;     // Catch: Throwable -> L61
        if (r110 == null) goto L63;
        r110.close();     // Catch: Throwable -> L61
        this.f5646b = null;     // Catch: Throwable -> L61
    L61:
        th = th;
        r18 = "dbs";
        r19 = "sld";
        goto L45
    L65:
        th = move-exception;
        if (r15 == null) goto L91;
        r15.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L80
    L91:
        SQLiteDatabase r111 = this.f5646b;     // Catch: Throwable -> L75
        if (r111 == null) goto L106;
        r111.close();     // Catch: Throwable -> L75
        this.f5646b = null;     // Catch: Throwable -> L75
    L107:
        throw th;     // Catch: Throwable -> L80
    L106:
        throw th;     // Catch: Throwable -> L80
    L75:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L80
        throw th;     // Catch: Throwable -> L80
    L49:
        th = th;
        r15 = null;
    L80:
        th = move-exception;
        throw th;
    }

    private <T> void b(T r5) {
        t r0 = this.c;
        monitor-enter(r0);
        SQLiteDatabase r1 = b();     // Catch: Throwable -> L27
        this.f5646b = r1;     // Catch: Throwable -> L27
        if (r1 != null) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L31:
        a(r1, r5);     // Catch: Throwable -> L15
        SQLiteDatabase r6 = this.f5646b;     // Catch: Throwable -> L27
        if (r6 == null) goto L20;
        r6.close();     // Catch: Throwable -> L27
    L13:
        this.f5646b = null;     // Catch: Throwable -> L27
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L15:
        th = move-exception;
        n.a(th, "dbs", "itd");     // Catch: Throwable -> L22
        SQLiteDatabase r7 = this.f5646b;     // Catch: Throwable -> L27
        if (r7 == null) goto L20;
        r7.close();     // Catch: Throwable -> L27
        goto L13
    L22:
        th = move-exception;
        SQLiteDatabase r2 = this.f5646b;     // Catch: Throwable -> L27
        if (r2 == null) goto L26;
        r2.close();     // Catch: Throwable -> L27
        this.f5646b = null;     // Catch: Throwable -> L27
    L26:
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private <T> void b(String r1, Object r2) {
        a(r1, r2);
    }

    public final <T> List<T> a(String r1, Class<T> r2) {
        return b(r1, r2);
    }

    public final void a(Object r3, String r4) {
        t r0 = this.c;
        monitor-enter(r0);
        List r1 = a(r4, r3.getClass());     // Catch: Throwable -> L13
        if (r1 != null) goto L7;
    L10:
        a(r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (r1.size() == 0) goto L10;
        b(r4, r3);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
