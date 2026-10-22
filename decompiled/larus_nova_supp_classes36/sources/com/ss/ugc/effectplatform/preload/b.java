package com.ss.ugc.effectplatform.preload;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import bytekn.foundation.logger.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final Object b = null;
    public static b c;
    public static final a d = null;
    public SQLiteDatabase a;

    public static final class a {
        public a() {
        }

        public static b a(Object r2) {
            if (b.c != null) goto L19;
            if (r2 == null) goto L19;
            if ((r2 instanceof Context) == false) goto L19;
            Object r0 = b.b;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (b.c != null) goto L12;
            b.c = new b(r2);     // Catch: Throwable -> L15
        L12:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r0);
        L19:
            return b.c;
        }
    }

    static {
        d = new a();
        b = new Object();
    }

    public final void b() {
        SQLiteDatabase r0 = this.a;
        if (r0 == null) goto L26;
        r0.beginTransaction();
        SQLiteDatabase r1 = this.a;     // Catch: Throwable -> L14 Exception -> L16
        if (r1 == null) goto L8;
        r1.delete("preload_table", null, null);     // Catch: Throwable -> L14 Exception -> L16
    L8:
        SQLiteDatabase r2 = this.a;     // Catch: Throwable -> L14 Exception -> L16
        if (r2 == null) goto L11;
        r2.setTransactionSuccessful();     // Catch: Throwable -> L14 Exception -> L16
    L11:
        SQLiteDatabase r3 = this.a;
        if (r3 == null) goto L21;
    L13:
        r3.endTransaction();
        return;
    L21:
        return;
    L14:
        th = move-exception;
        SQLiteDatabase r4 = this.a;
        if (r4 == null) goto L25;
        r4.endTransaction();
    L25:
        throw th;
    L16:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][删除表-失败]", e);     // Catch: Throwable -> L14
        r3 = this.a;
        if (r3 != null) goto L13;
        return;
    }

    public final List<c> f() {
        ArrayList r0 = new ArrayList();
        SQLiteDatabase r1 = this.a;     // Catch: Exception -> L15
        if (r1 == null) goto L14;
        Cursor r2 = r1.rawQuery("select * from preload_table", null);     // Catch: Exception -> L15
        if (r2 == null) goto L14;
        if (r2.moveToFirst() == true) goto L10;
    L12:
        r2.close();     // Catch: Exception -> L15
    L17:
        return r0;
    L10:
        if (r2.isAfterLast() == true) goto L12;
        r0.add(new c(r2.getString(0), r2.getString(1), r2.getString(2), r2.getString(3), r2.getLong(4), r2.getString(5)));     // Catch: Exception -> L15
        r2.moveToNext();     // Catch: Exception -> L15
    L14:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public b(Object r2) {
        this.a = new com.ss.ugc.effectplatform.preload.a(((Context) r2).getApplicationContext()).getReadableDatabase();
    }

    private final void insert(c r9) {
        SQLiteDatabase r4 = this.a;     // Catch: Throwable -> L17 Exception -> L19
        if (r4 == null) goto L14;
        r4.beginTransaction();     // Catch: Throwable -> L17 Exception -> L19
        ContentValues r5 = new ContentValues();     // Catch: Throwable -> L17 Exception -> L19
        r5.put("file_name", r9.a);     // Catch: Throwable -> L17 Exception -> L19
        r5.put("resource_key", r9.b);     // Catch: Throwable -> L17 Exception -> L19
        r5.put("uri", r9.c);     // Catch: Throwable -> L17 Exception -> L19
        r5.put("res_name", r9.d);     // Catch: Throwable -> L17 Exception -> L19
        r5.put("last_access_time", Long.valueOf(r9.e));     // Catch: Throwable -> L17 Exception -> L19
        r5.put("busi_key_list", r9.f);     // Catch: Throwable -> L17 Exception -> L19
        SQLiteDatabase r6 = this.a;     // Catch: Throwable -> L17 Exception -> L19
        if (r6 == null) goto L8;
        r6.insert("preload_table", null, r5);     // Catch: Throwable -> L17 Exception -> L19
    L8:
        Logger.INSTANCE.d("JKL", "[预加载][数据库][插入成功][" + r9 + ']');     // Catch: Throwable -> L17 Exception -> L19
        SQLiteDatabase r1 = this.a;     // Catch: Throwable -> L17 Exception -> L19
        if (r1 == null) goto L11;
        r1.setTransactionSuccessful();     // Catch: Throwable -> L17 Exception -> L19
    L11:
        SQLiteDatabase r10 = this.a;
        if (r10 == null) goto L24;
    L13:
        r10.endTransaction();
        return;
    L24:
        return;
    L14:
        if (r4 == null) goto L31;
        r4.endTransaction();
        return;
    L31:
        return;
    L17:
        th = move-exception;
        SQLiteDatabase r0 = this.a;
        if (r0 == null) goto L28;
        r0.endTransaction();
    L28:
        throw th;
    L19:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][插入失败][" + r9 + ']', e);     // Catch: Throwable -> L17
        r10 = this.a;
        if (r10 != null) goto L13;
    }

    public final boolean a(String r6) {
        SQLiteDatabase r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L14;
        Cursor r2 = r0.rawQuery("select * from preload_table where file_name=?", new String[]{r6});
        if (r2 == null) goto L14;
        r2.moveToFirst();
    L8:
        if (r2.isAfterLast() == true) goto L13;
        if (Intrinsics.areEqual(r2.getString(0), r6) == true) goto L11;
        r2.moveToNext();
        goto L8
    L11:
        r1 = true;
    L13:
        r2.close();
    L14:
        return r1;
    }

    public final void c(String r7) {
        SQLiteDatabase r1 = this.a;
        if (r1 == null) goto L28;
        r1.beginTransaction();
    L18:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][删除-失败][" + r7 + ']', e);     // Catch: Throwable -> L16
        SQLiteDatabase r8 = this.a;
        if (r8 == null) goto L33;
    L15:
        r8.endTransaction();
        return;
    L33:
        return;
    L16:
        th = move-exception;
        SQLiteDatabase r0 = this.a;
        if (r0 == null) goto L27;
        r0.endTransaction();
    L27:
        throw th;
    L6:
        if (a(r7) == false) goto L10;
        SQLiteDatabase r2 = this.a;     // Catch: Throwable -> L16 Exception -> L18
        if (r2 == null) goto L10;
        r2.delete("preload_table", "file_name=?", new String[]{r7});     // Catch: Throwable -> L16 Exception -> L18
    L10:
        SQLiteDatabase r3 = this.a;     // Catch: Throwable -> L16 Exception -> L18
        if (r3 == null) goto L13;
        r3.setTransactionSuccessful();     // Catch: Throwable -> L16 Exception -> L18
    L13:
        r8 = this.a;
        if (r8 != null) goto L15;
        return;
    }

    public final void d(c r10) {
        String r1 = r10.a;
        LinkedHashSet r2 = new LinkedHashSet();
        SQLiteDatabase r5 = this.a;     // Catch: Exception -> L18
        if (r5 == null) goto L16;
        Cursor r3 = r5.rawQuery("select * from preload_table where file_name=?", new String[]{r1});     // Catch: Exception -> L18
        if (r3 == null) goto L16;
        if (r3.moveToFirst() == true) goto L10;
    L15:
        r3.close();     // Catch: Exception -> L18
    L20:
        Object[] r4 = r2.toArray(new String[0]);
        if (r4 == null) goto L68;
        String[] r6 = (String[]) r4;
    L24:
        if (r6.length != 0) goto L26;
        boolean r7 = true;
    L28:
        if ((!r7) == true) goto L30;
        insert(r10);
        return;
    L30:
        if (ArraysKt.contains(r6, r10.f) == false) goto L32;
        Logger.INSTANCE.d("JKL", "[预加载][数据库][数据已存在][场景" + r10.f + "已存在][" + r10.a + "][无操作]");
        return;
    L32:
        Logger.INSTANCE.w("JKL", "[预加载][数据库][数据已存在][场景" + r10.f + "不存在][" + r10.a + "][更新数据]");
        ArrayList r8 = new ArrayList();
        CollectionsKt.addAll(r8, r6);
        r8.add(r10.f);
        c.a r9 = c.h;
        Object[] r11 = r8.toArray(new String[0]);
        if (r11 == null) goto L64;
        String[] r12 = (String[]) r11;
        r9.getClass();
        int r0 = r12.length;
        String r13 = "";
        int r14 = 0;
    L35:
        if (r14 >= r0) goto L40;
        r13 = r13 + r12[r14];
        if (r14 >= (r12.length - 1)) goto L39;
        r13 = r13 + c.g;
    L39:
        r14 = r14 + 1;
        goto L35
    L40:
        SQLiteDatabase r15 = this.a;
        if (r15 == null) goto L79;
        r15.beginTransaction();
        ContentValues r16 = new ContentValues();     // Catch: Throwable -> L52 Exception -> L54
        r16.put("last_access_time", Long.valueOf(r10.e));     // Catch: Throwable -> L52 Exception -> L54
        r16.put("busi_key_list", r13);     // Catch: Throwable -> L52 Exception -> L54
        SQLiteDatabase r17 = this.a;     // Catch: Throwable -> L52 Exception -> L54
        if (r17 == null) goto L46;
        r17.update("preload_table", r16, "file_name=?", new String[]{r10.a});     // Catch: Throwable -> L52 Exception -> L54
    L46:
        SQLiteDatabase r18 = this.a;     // Catch: Throwable -> L52 Exception -> L54
        if (r18 == null) goto L49;
        r18.setTransactionSuccessful();     // Catch: Throwable -> L52 Exception -> L54
    L49:
        SQLiteDatabase r19 = this.a;
        if (r19 == null) goto L80;
    L58:
        r19.endTransaction();
        return;
    L80:
        return;
    L54:
        e = move-exception;
        Logger.INSTANCE.e("JKL", "[预加载][数据库][更新数据失败]", e);     // Catch: Throwable -> L52
        r19 = this.a;
        if (r19 != null) goto L58;
        return;
    L52:
        th = move-exception;
        SQLiteDatabase r20 = this.a;
        if (r20 == null) goto L62;
        r20.endTransaction();
    L62:
        throw th;
    L79:
        return;
    L64:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L26:
        r7 = false;
        goto L28
    L68:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        if (r3.isAfterLast() == true) goto L15;
        String r21 = r3.getString(5);     // Catch: Exception -> L18
        c.h.getClass();     // Catch: Exception -> L18
        String[] r22 = c.a.a(r21);     // Catch: Exception -> L18
        int r23 = r22.length;     // Catch: Exception -> L18
        int r24 = 0;
    L12:
        if (r24 >= r23) goto L14;
        r2.add(r22[r24]);     // Catch: Exception -> L18
        r24 = r24 + 1;     // Catch: Exception -> L18
        goto L12
    L14:
        r3.moveToNext();     // Catch: Exception -> L18
    L16:
        r6 = new String[0];     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public final c e(String r15) {
        c r0 = null;
        SQLiteDatabase r1 = this.a;     // Catch: Exception -> L15
        if (r1 == null) goto L14;
        Cursor r16 = r1.rawQuery("select * from preload_table where file_name=?", new String[]{r15});     // Catch: Exception -> L15
        if (r16 == null) goto L14;
        if (r16.moveToFirst() == true) goto L10;
    L12:
        r16.close();     // Catch: Exception -> L15
    L17:
        return r0;
    L10:
        if (r16.isAfterLast() == true) goto L12;
        r0 = new c(r16.getString(0), r16.getString(1), r16.getString(2), r16.getString(3), r16.getLong(4), r16.getString(5));     // Catch: Exception -> L15
    L14:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
