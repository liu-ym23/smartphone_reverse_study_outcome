package com.ss.android.lark.conditional.access.auth.v2;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ j b;
    public final /* synthetic */ String c;

    public i(d r1, j r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        Gson r0 = com.ss.android.lark.utils.e0.a;
        String r5 = com.ss.android.lark.utils.e0.c(this.a);
        if (r5 != null) goto L5;
        return;
    L5:
        x4c.g r1 = this.b.a();
        String r8 = this.c;
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        x4c.f r4 = r1.b.a(r8);
        if (r4 == null) goto L8;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.c = r5;
        r4.d = System.currentTimeMillis();
        r1.b.b(r4);
        ((HashMap) r1.c).put(r8, r4);
        return;
    L8:
        x4c.e r6 = r1.b;
        r6.getClass();
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM lru_cache", 0);
        r6.a.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(r6.a, r7, false, null);
    L41:
        th = move-exception;
        r9.close();
        r7.release();
        throw th;
    L10:
        if (r9.moveToFirst() == false) goto L13;
        int r10 = r9.getInt(0);     // Catch: Throwable -> L41
    L14:
        r9.close();
        r7.release();
        int r11 = r10 - r1.a;
        if (r11 < 0) goto L34;
        x4c.e r12 = r1.b;
        int r13 = Math.max(5, r11 + 1);
        x4c.e r14 = r12;
        r14.getClass();
        RoomSQLiteQuery r15 = RoomSQLiteQuery.acquire("SELECT * FROM lru_cache ORDER BY lastAccessTime DESC LIMIT ?", 1);
        r15.bindLong(1, r13);
        r14.a.assertNotSuspendingTransaction();
        Cursor r16 = DBUtil.query(r14.a, r15, false, null);
        int r17 = CursorUtil.getColumnIndexOrThrow(r16, "id");     // Catch: Throwable -> L31
        int r2 = CursorUtil.getColumnIndexOrThrow(r16, "key");     // Catch: Throwable -> L31
        int r3 = CursorUtil.getColumnIndexOrThrow(r16, "value");     // Catch: Throwable -> L31
        int r18 = CursorUtil.getColumnIndexOrThrow(r16, "lastAccessTime");     // Catch: Throwable -> L31
        ArrayList r19 = new ArrayList(r16.getCount());     // Catch: Throwable -> L31
    L19:
        if (r16.moveToNext() == false) goto L22;
        r19.add(new x4c.f(r16.getInt(r17), r16.getString(r2), r16.getString(r3), r16.getLong(r18)));     // Catch: Throwable -> L31
        goto L19
    L22:
        r16.close();
        r15.release();
        Iterator r20 = r19.iterator();
    L24:
        if (r20.hasNext() == false) goto L34;
        x4c.f r21 = (x4c.f) r20.next();
        x4c.e r22 = r1.b;
        r22.a.assertNotSuspendingTransaction();
        r22.a.beginTransaction();
        r22.c.handle(r21);     // Catch: Throwable -> L28
        r22.a.setTransactionSuccessful();     // Catch: Throwable -> L28
        r22.a.endTransaction();
        ((HashMap) r1.c).remove(r21.b);
    L28:
        th = move-exception;
        r22.a.endTransaction();
        throw th;
    L31:
        th = move-exception;
        r16.close();
        r15.release();
        throw th;
    L34:
        x4c.f r23 = new x4c.f(0, r8, r5, System.currentTimeMillis());
        x4c.e r24 = r1.b;
        r24.a.assertNotSuspendingTransaction();
        r24.a.beginTransaction();
        r24.b.insert(r23);     // Catch: Throwable -> L38
        r24.a.setTransactionSuccessful();     // Catch: Throwable -> L38
        r24.a.endTransaction();
        ((HashMap) r1.c).put(r8, r23);
        return;
    L38:
        th = move-exception;
        r24.a.endTransaction();
        throw th;
    L13:
        r10 = 0;
        goto L14
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
