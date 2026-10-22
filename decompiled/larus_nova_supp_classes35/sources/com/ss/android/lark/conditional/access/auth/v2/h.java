package com.ss.android.lark.conditional.access.auth.v2;

import android.database.Cursor;
import android.util.LruCache;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ j b;
    public final /* synthetic */ Function1<LruCache<String, d>, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public h(int r1, j r2, Function1<? super LruCache<String, d>, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        LruCache r0 = new LruCache(this.a);
        x4c.g r1 = this.b.a();
        int r2 = this.a;
        x4c.e r3 = r1.b;
        r3.getClass();
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM lru_cache ORDER BY lastAccessTime ASC LIMIT ?", 1);
        r4.bindLong(1, r2);
        r3.a.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(r3.a, r4, false, null);
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "id");     // Catch: Throwable -> L20
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "key");     // Catch: Throwable -> L20
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "value");     // Catch: Throwable -> L20
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "lastAccessTime");     // Catch: Throwable -> L20
        ArrayList r10 = new ArrayList(r5.getCount());     // Catch: Throwable -> L20
    L5:
        if (r5.moveToNext() == false) goto L8;
        r10.add(new x4c.f(r5.getInt(r6), r5.getString(r7), r5.getString(r8), r5.getLong(r9)));     // Catch: Throwable -> L20
        goto L5
    L8:
        r5.close();
        r4.release();
        LinkedHashMap r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r10, 10)), 16));
        Iterator r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        x4c.f r13 = (x4c.f) r12.next();
        Pair r14 = TuplesKt.to(r13.b, r13.c);
        r11.put(r14.getFirst(), r14.getSecond());
        goto L10
    L12:
        Iterator r15 = new HashMap(MapsKt.toMap(r11)).entrySet().iterator();
    L14:
        if (r15.hasNext() == false) goto L18;
        Map.Entry r16 = (Map.Entry) r15.next();
        Gson r17 = com.ss.android.lark.utils.e0.a;
        d r18 = (d) com.ss.android.lark.utils.e0.a((String) r16.getValue(), d.class);
        if (r18 == null) goto L14;
        r0.put(r16.getKey(), r18);
        goto L14
    L18:
        this.c.invoke(r0);
        return;
    L20:
        th = move-exception;
        r5.close();
        r4.release();
        throw th;
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
