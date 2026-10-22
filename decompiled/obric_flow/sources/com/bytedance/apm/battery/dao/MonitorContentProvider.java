package com.bytedance.apm.battery.dao;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.core.SpPair;
import ea.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3850a;

    public MonitorContentProvider() {
        this.f3850a = new HashMap();
    }

    public final synchronized Pair a(Uri r10) {
        monitor-enter(this);
        List<String> r11 = r10.getPathSegments();     // Catch: Throwable -> L18 Exception -> L29
        if (r11 == null) goto L27;
        if (r11.size() < 2) goto L27;
        String r12 = r11.get(0);     // Catch: Throwable -> L18 Exception -> L29
        String r13 = r11.get(1);     // Catch: Throwable -> L18 Exception -> L29
        if (r12 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        SQLiteOpenHelper r5 = (SQLiteOpenHelper) this.f3850a.get(r12);     // Catch: Throwable -> L18 Exception -> L29
        if (r5 == null) goto L15;
    L22:
        Pair r14 = new Pair(r5.getWritableDatabase(), r13);     // Catch: Throwable -> L18 Exception -> L29
        monitor-exit(this);
        return r14;
        goto L27
    L15:
        if (r12.contains("apm_monitor_t1.db") == false) goto L20;
        a r15 = new a(getContext(), r12, null, 2, 2);     // Catch: Throwable -> L18 Exception -> L29
        this.f3850a.put(r12, r15);     // Catch: Throwable -> L18 Exception -> L29
        r5 = r15;
        goto L22
    L20:
        monitor-exit(this);
        return null;
    L18:
        th = move-exception;
        throw th;
    L27:
        monitor-exit(this);
        return null;
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String r10, String r11, Bundle r12) {
        if (r12 == null) goto L5;
        r12.setClassLoader(getClass().getClassLoader());
    L5:
        if ("getPid".equals(r10) == false) goto L8;
        Bundle r13 = new Bundle();
        r13.putInt("Pid", Process.myPid());
        return r13;
    L8:
        Uri.parse(r10);
        Uri r14 = Uri.parse(r10);
        monitor-enter(this);
        List<String> r15 = r14.getPathSegments();     // Catch: Throwable -> L19
        int r5 = 0;
        Object r16 = null;
        if (r15 != null) goto L13;
    L25:
        monitor-exit(this);
        Pair r17 = null;
    L27:
        if (r17 != null) goto L30;
        return null;
    L30:
        if ("query".equals(r11) == false) goto L56;
        if (r12 == null) goto L35;
        SpPair r18 = (SpPair) r12.getParcelable("sp");
        if (r18 == null) goto L35;
        r16 = r18.f3861b;
    L35:
        SharedPreferences r19 = (SharedPreferences) r17.first;
        String r20 = (String) r17.second;
        Bundle r21 = new Bundle();
        ArrayList<? extends Parcelable> r22 = new ArrayList();
        if (r20 != null) goto L42;
        Iterator<Map.Entry<String, ?>> r23 = r19.getAll().entrySet().iterator();
    L39:
        if (r23.hasNext() == false) goto L41;
        Map.Entry<String, ?> r24 = r23.next();
        r22.add(new SpPair(r24.getKey(), r24.getValue()));
        goto L39
    L41:
        r21.putParcelableArrayList("sp", r22);
    L54:
        return r21;
    L42:
        Object r25 = r19.getAll().get(r20);
        if (r25 == null) goto L47;
        r16 = r25;
    L47:
        if ((r16 instanceof Set) == false) goto L53;
        Set r26 = (Set) r16;
        String[] r27 = new String[r26.size()];
        Iterator r28 = r26.iterator();
    L50:
        if (r28.hasNext() == false) goto L52;
        r27[r5] = (String) r28.next();
        r5 = r5 + 1;
        goto L50
    L52:
        r16 = r27;
    L53:
        r22.add(new SpPair(r20, r16));
        r21.putParcelableArrayList("sp", r22);
        goto L54
    L56:
        if ("contains".equals(r11) == false) goto L60;
        SharedPreferences r29 = (SharedPreferences) r17.first;
        String r30 = (String) r17.second;
        Bundle r31 = new Bundle();
        r31.putBoolean("contains", r29.contains(r30));
        return r31;
    L60:
        if ("edit".equals(r11) == false) goto L93;
        if (r12 == null) goto L93;
        SharedPreferences.Editor r32 = ((SharedPreferences) r17.first).edit();
        if (r12.getBoolean("clear") == false) goto L65;
        r32.clear();
    L65:
        ArrayList r33 = r12.getParcelableArrayList("edit");
        if (r33 == null) goto L93;
        Iterator r34 = r33.iterator();
    L70:
        if (r34.hasNext() == false) goto L92;
        SpPair r35 = (SpPair) r34.next();
        Object r36 = r35.f3861b;
        String r37 = r35.f3860a;
        if (r36 == null) goto L73;
        if ((r36 instanceof String) == true) goto L76;
        if ((r36 instanceof Integer) == true) goto L79;
        if ((r36 instanceof Long) == true) goto L82;
        if ((r36 instanceof Float) == true) goto L85;
        if ((r36 instanceof Boolean) == true) goto L88;
        if ((r36 instanceof String[]) == false) goto L70;
        r32.putStringSet(r37, new HashSet(Arrays.asList((String[]) r36)));
        goto L70
    L88:
        r32.putBoolean(r37, ((Boolean) r36).booleanValue());
        goto L70
    L85:
        r32.putFloat(r37, ((Float) r36).floatValue());
        goto L70
    L82:
        r32.putLong(r37, ((Long) r36).longValue());
        goto L70
    L79:
        r32.putInt(r37, ((Integer) r36).intValue());
        goto L70
    L76:
        r32.putString(r37, (String) r36);
        goto L70
    L73:
        r32.remove(r37);
        goto L70
    L92:
        r32.apply();
    L93:
        return null;
    L13:
        if (r15.size() < 2) goto L25;
        if ("sp".equals(r15.get(0)) == false) goto L25;
        SharedPreferences r38 = getContext().getSharedPreferences(r15.get(1), 0);     // Catch: Throwable -> L19
        if (r15.size() <= 2) goto L21;
        String r39 = r15.get(2);     // Catch: Throwable -> L19
    L22:
        r17 = new Pair(r38, r39);     // Catch: Throwable -> L19
        monitor-exit(this);
        goto L27
    L21:
        r39 = null;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
        Pair r12 = a(r5);
        if (r12 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r13 = (SQLiteDatabase) r12.first;
        if (r13 != null) goto L11;
        return -1;
    L11:
        return r13.delete((String) r12.second, r10, r11);
    L10:
        return -1;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r10, ContentValues r11) {
        Pair r5 = a(r10);
        if (r5 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r12 = (SQLiteDatabase) r5.first;
        if (r12 != null) goto L14;
        return null;
    L14:
        long r13 = r12.insert((String) r5.second, null, r11);     // Catch: Throwable -> L13
        if (r13 < 0) goto L12;
        return ContentUris.withAppendedId(r10, r13);
    L12:
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        getContext().getPackageName();
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        Pair r15 = a(r10);
        if (r15 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r5 = (SQLiteDatabase) r15.first;
        if (r5 != null) goto L9;
        return null;
    L9:
        if (TextUtils.equals(r14, "rawQuery") == false) goto L13;
        return r5.rawQuery(r12, r13);
    L13:
        if (TextUtils.equals(r14, "execSQL") == false) goto L21;
        String[] r16 = r12.split(";");
        int r17 = r16.length;
        int r18 = 0;
    L15:
        if (r18 >= r17) goto L20;
        String r19 = r16[r18];
        if (TextUtils.isEmpty(r19) == true) goto L19;
        r5.execSQL(r19);
    L19:
        r18 = r18 + 1;
        goto L15
    L20:
        return null;
    L21:
        SQLiteQueryBuilder r20 = new SQLiteQueryBuilder();
        r20.setTables((String) r15.second);
        return r20.query(r5, r11, r12, r13, null, null, r14);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r5, ContentValues r10, String r11, String[] r12) {
        Pair r13 = a(r5);
        if (r13 != null) goto L5;
        return -1;
    L5:
        SQLiteDatabase r14 = (SQLiteDatabase) r13.first;
        if (r14 != null) goto L11;
        return -1;
    L11:
        return r14.update((String) r13.second, r10, r11, r12);
    L10:
        return -1;
    }
}
