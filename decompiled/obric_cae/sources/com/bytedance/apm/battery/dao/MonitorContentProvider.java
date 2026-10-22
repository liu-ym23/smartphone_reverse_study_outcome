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
import g2.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MonitorContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3751a;

    public MonitorContentProvider() {
        this.f3751a = new HashMap();
    }

    public final synchronized Pair<SQLiteDatabase, String> a(Uri r8) {
        monitor-enter(this);
        List<String> r10 = r8.getPathSegments();     // Catch: Throwable -> L23 Exception -> L28
        if (r10 == null) goto L26;
        if (r10.size() < 2) goto L26;
        String r11 = r10.get(0);     // Catch: Throwable -> L23 Exception -> L28
        String r12 = r10.get(1);     // Catch: Throwable -> L23 Exception -> L28
        if (r11 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        SQLiteOpenHelper r13 = (SQLiteOpenHelper) this.f3751a.get(r11);     // Catch: Throwable -> L23 Exception -> L28
        if (r13 == null) goto L15;
    L20:
        Pair<SQLiteDatabase, String> r14 = new Pair(r13.getWritableDatabase(), r12);     // Catch: Throwable -> L23 Exception -> L28
        monitor-exit(this);
        return r14;
        goto L26
    L15:
        if (r11.contains("apm_monitor_t1.db") == false) goto L18;
        r13 = new a(getContext(), r11);     // Catch: Throwable -> L23 Exception -> L28
        this.f3751a.put(r11, r13);     // Catch: Throwable -> L23 Exception -> L28
        goto L20
    L18:
        monitor-exit(this);
        return null;
    L23:
        th = move-exception;
        throw th;
    L26:
        monitor-exit(this);
        return null;
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String r8, String r10, Bundle r11) {
        if (r11 == null) goto L5;
        r11.setClassLoader(getClass().getClassLoader());
    L5:
        if ("getPid".equals(r8) == false) goto L8;
        Bundle r12 = new Bundle();
        r12.putInt("Pid", Process.myPid());
        return r12;
    L8:
        Uri.parse(r8);
        Uri r13 = Uri.parse(r8);
        monitor-enter(this);
        List<String> r14 = r13.getPathSegments();     // Catch: Throwable -> L88
        Object r15 = null;
        if (r14 != null) goto L13;
    L23:
        monitor-exit(this);
        Pair r16 = null;
    L25:
        if (r16 != null) goto L28;
        return null;
    L28:
        if ("query".equals(r10) == false) goto L50;
        if (r11 == null) goto L33;
        SpPair r17 = (SpPair) r11.getParcelable("sp");
        if (r17 == null) goto L33;
        r15 = r17.f3759b;
    L33:
        SharedPreferences r18 = (SharedPreferences) r16.first;
        String r19 = (String) r16.second;
        Bundle r20 = new Bundle();
        ArrayList<? extends Parcelable> r21 = new ArrayList();
        Map<String, ?> r22 = r18.getAll();
        if (r19 != null) goto L39;
        Iterator<Map.Entry<String, ?>> r23 = r22.entrySet().iterator();
    L37:
        if (r23.hasNext() == false) goto L47;
        Map.Entry<String, ?> r24 = r23.next();
        r21.add(new SpPair(r24.getValue(), r24.getKey()));
    L47:
        r20.putParcelableArrayList("sp", r21);
        return r20;
    L39:
        Object r25 = r22.get(r19);
        if (r25 == null) goto L44;
        r15 = r25;
    L44:
        if ((r15 instanceof Set) == false) goto L46;
        r15 = l6.a.W0((Set) r15);
    L46:
        r21.add(new SpPair(r15, r19));
        goto L47
    L50:
        if ("contains".equals(r10) == false) goto L54;
        SharedPreferences r26 = (SharedPreferences) r16.first;
        String r27 = (String) r16.second;
        Bundle r28 = new Bundle();
        r28.putBoolean("contains", r26.contains(r27));
        return r28;
    L54:
        if ("edit".equals(r10) == false) goto L87;
        if (r11 == null) goto L87;
        SharedPreferences.Editor r29 = ((SharedPreferences) r16.first).edit();
        if (r11.getBoolean("clear") == false) goto L59;
        r29.clear();
    L59:
        ArrayList r30 = r11.getParcelableArrayList("edit");
        if (r30 == null) goto L87;
        Iterator r31 = r30.iterator();
    L64:
        if (r31.hasNext() == false) goto L86;
        SpPair r32 = (SpPair) r31.next();
        Object r33 = r32.f3759b;
        String r34 = r32.f3758a;
        if (r33 == null) goto L67;
        if ((r33 instanceof String) == true) goto L70;
        if ((r33 instanceof Integer) == true) goto L73;
        if ((r33 instanceof Long) == true) goto L76;
        if ((r33 instanceof Float) == true) goto L79;
        if ((r33 instanceof Boolean) == true) goto L82;
        if ((r33 instanceof String[]) == false) goto L64;
        r29.putStringSet(r34, new HashSet(Arrays.asList((String[]) r33)));
        goto L64
    L82:
        r29.putBoolean(r34, ((Boolean) r33).booleanValue());
        goto L64
    L79:
        r29.putFloat(r34, ((Float) r33).floatValue());
        goto L64
    L76:
        r29.putLong(r34, ((Long) r33).longValue());
        goto L64
    L73:
        r29.putInt(r34, ((Integer) r33).intValue());
        goto L64
    L70:
        r29.putString(r34, (String) r33);
        goto L64
    L67:
        r29.remove(r34);
        goto L64
    L86:
        r29.apply();
    L87:
        return null;
    L13:
        if (r14.size() < 2) goto L23;
        if ("sp".equals(r14.get(0)) == false) goto L23;
        SharedPreferences r35 = getContext().getSharedPreferences(r14.get(1), 0);     // Catch: Throwable -> L88
        if (r14.size() <= 2) goto L19;
        String r36 = r14.get(2);     // Catch: Throwable -> L88
    L20:
        r16 = new Pair(r35, r36);     // Catch: Throwable -> L88
        monitor-exit(this);
        goto L25
    L19:
        r36 = null;
    L88:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r8, String r10, String[] r11) {
        Pair<SQLiteDatabase, String> r12 = a(r8);
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
    public final String getType(Uri r8) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r8, ContentValues r10) {
        Pair<SQLiteDatabase, String> r11 = a(r8);
        if (r11 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r12 = (SQLiteDatabase) r11.first;
        if (r12 != null) goto L14;
        return null;
    L14:
        long r13 = r12.insert((String) r11.second, null, r10);     // Catch: Throwable -> L13
        if (r13 < 0) goto L12;
        return ContentUris.withAppendedId(r8, r13);
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
        Pair<SQLiteDatabase, String> r15 = a(r10);
        if (r15 != null) goto L5;
        return null;
    L5:
        SQLiteDatabase r8 = (SQLiteDatabase) r15.first;
        if (r8 != null) goto L9;
        return null;
    L9:
        if (TextUtils.equals(r14, "rawQuery") == false) goto L13;
        return r8.rawQuery(r12, r13);
    L13:
        if (TextUtils.equals(r14, "execSQL") == false) goto L21;
        String[] r16 = r12.split(";");
        int r17 = r16.length;
        int r18 = 0;
    L15:
        if (r18 >= r17) goto L20;
        String r19 = r16[r18];
        if (TextUtils.isEmpty(r19) == true) goto L19;
        r8.execSQL(r19);
    L19:
        r18 = r18 + 1;
        goto L15
    L20:
        return null;
    L21:
        SQLiteQueryBuilder r20 = new SQLiteQueryBuilder();
        r20.setTables((String) r15.second);
        return r20.query(r8, r11, r12, r13, null, null, r14);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r8, ContentValues r10, String r11, String[] r12) {
        Pair<SQLiteDatabase, String> r13 = a(r8);
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
