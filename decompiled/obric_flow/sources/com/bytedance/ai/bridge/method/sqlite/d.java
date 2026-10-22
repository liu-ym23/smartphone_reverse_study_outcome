package com.bytedance.ai.bridge.method.sqlite;

import android.app.Application;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final Pattern f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f1992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f1994c;
    public boolean d;
    public final Lazy e;

    static {
        f = Pattern.compile("^\\s*(\\S+)", 2);
    }

    public d(Application r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "dbName");
        this.f1992a = r5;
        this.f1993b = r10;
        this.e = LazyKt.lazy(new a3.f(5));
    }

    public static DBOperation$QueryType a(String r10) {
        Matcher r11 = f.matcher(r10);
        if (r11.find() == true) goto L22;
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L21;
        r12.w("ExecuteSqliteActionMethod", "unsupported query type");
    L21:
        return DBOperation$QueryType.f;
    L22:
        String r13 = r11.group().toLowerCase();     // Catch: IllegalArgumentException -> L12
        DBOperation$QueryType[] r5 = DBOperation$QueryType.values();     // Catch: IllegalArgumentException -> L12
        int r14 = r5.length;     // Catch: IllegalArgumentException -> L12
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L11;
        DBOperation$QueryType r16 = r5[r15];     // Catch: IllegalArgumentException -> L12
        if (Intrinsics.areEqual(r16.f1968a, r13) == true) goto L8;
        r15 = r15 + 1;     // Catch: IllegalArgumentException -> L12
        goto L5
    L8:
        return r16;
    L11:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: IllegalArgumentException -> L12
    L12:
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L16;
        r17.w("ExecuteSqliteActionMethod", "unsupported query type");
    L16:
        return DBOperation$QueryType.f;
    }

    public static void b(SQLiteStatement r5, ArrayList r10) {
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L37;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if ((r13 instanceof Integer) == false) goto L12;
        r5.bindLong(r14, ((Number) r13).intValue());
    L36:
        r12 = r14;
        goto L4
    L12:
        if ((r13 instanceof Long) == false) goto L15;
        r5.bindLong(r14, ((Number) r13).longValue());
        goto L36
    L15:
        if ((r13 instanceof Double) == false) goto L18;
        r5.bindDouble(r14, ((Number) r13).doubleValue());
        goto L36
    L18:
        if ((r13 instanceof String) == false) goto L36;
        String r15 = (String) r13;
        if (Intrinsics.areEqual(r15.toUpperCase(), "NULL") == false) goto L23;
        r5.bindNull(r14);
        goto L36
    L23:
        if ((r13 instanceof String) == false) goto L26;
    L35:
        r5.bindString(r14, r15);
        goto L36
    L26:
        if ((r13 instanceof Integer) == false) goto L29;
        r15 = String.valueOf(((Number) r13).intValue());
        goto L35
    L29:
        if ((r13 instanceof Long) == false) goto L32;
        r15 = String.valueOf(((Number) r13).longValue());
        goto L35
    L32:
        if ((r13 instanceof Boolean) == false) goto L34;
        r15 = String.valueOf(((Boolean) r13).booleanValue());
        goto L35
    L34:
        r15 = "";
        goto L35
    }

    public static void c(LinkedHashMap r5, String r10, Cursor r11, int r12) {
        int r13 = r11.getType(r12);
        Long r14 = null;
        byte[] r15 = null;
        String r16 = null;
        Double r17 = null;
        if (r13 != 0) goto L5;
        r5.put(r10, null);
        return;
    L5:
        if (r13 == 1) goto L37;
        if (r13 == 2) goto L31;
        if (r13 == 3) goto L25;
        if (r13 == 4) goto L14;
        return;
    L14:
        if (r11.isNull(r12) == true) goto L17;
        r15 = r11.getBlob(r12);
    L17:
        if (r15 == null) goto L21;
        byte[] r18 = Base64.encode(r15, 0);
        Object r19 = r18;
        if (r18 == null) goto L21;
    L22:
        r5.put(r10, r19);
        return;
    L21:
        r19 = "";
        goto L22
    L25:
        if (r11.isNull(r12) == true) goto L28;
        r16 = r11.getString(r12);
    L28:
        r5.put(r10, r16);
        return;
    L31:
        if (r11.isNull(r12) == true) goto L34;
        r17 = Double.valueOf(r11.getDouble(r12));
    L34:
        r5.put(r10, r17);
        return;
    L37:
        if (r11.isNull(r12) == true) goto L40;
        r14 = Long.valueOf(r11.getLong(r12));
    L40:
        r5.put(r10, r14);
    }

    public final void d(o1.f r10, Function1 r11) {
        BuildersKt.launch$default((CoroutineScope) this.e.getValue(), null, null, new DBOperation$safeRun$1(this, r11, r10, null), 3, null);
    }
}
