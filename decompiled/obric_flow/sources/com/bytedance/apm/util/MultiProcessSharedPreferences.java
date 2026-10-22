package com.bytedance.apm.util;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3900b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContentResolver f3901a;

    public MultiProcessSharedPreferences() {
    }

    public static void a(SharedPreferences r5, Bundle r10) {
        SharedPreferences.Editor r11 = r5.edit();
        if (r10.getBoolean("clear") == false) goto L5;
        r11.clear();
    L5:
        ArrayList r12 = r10.getParcelableArrayList("edit");
        if (r12 != null) goto L8;
        return;
    L8:
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L32;
        SpPair r14 = (SpPair) r13.next();
        Object r15 = r14.f3903b;
        String r16 = r14.f3902a;
        if (r15 == null) goto L13;
        if ((r15 instanceof String) == true) goto L16;
        if ((r15 instanceof Integer) == true) goto L19;
        if ((r15 instanceof Long) == true) goto L22;
        if ((r15 instanceof Float) == true) goto L25;
        if ((r15 instanceof Boolean) == true) goto L28;
        if ((r15 instanceof String[]) == false) goto L10;
        r11.putStringSet(r16, new HashSet(Arrays.asList((String[]) r15)));
        goto L10
    L28:
        r11.putBoolean(r16, ((Boolean) r15).booleanValue());
        goto L10
    L25:
        r11.putFloat(r16, ((Float) r15).floatValue());
        goto L10
    L22:
        r11.putLong(r16, ((Long) r15).longValue());
        goto L10
    L19:
        r11.putInt(r16, ((Integer) r15).intValue());
        goto L10
    L16:
        r11.putString(r16, (String) r15);
        goto L10
    L13:
        r11.remove(r16);
        goto L10
    L32:
        r11.commit();
    }

    public static void b(Object r5, String r10) {
        Bundle r11 = new Bundle();
        if (r5 == null) goto L8;
        r11.putParcelable("sp", new SpPair(r10, r5));
    L8:
        throw null;     // Catch: Exception -> L7
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String r10, String r11, Bundle r12) {
        if (r12 == null) goto L4;
        r12.setClassLoader(getClass().getClassLoader());
    L4:
        Uri r5 = Uri.parse(r10);
        monitor-enter(this);
        List<String> r13 = r5.getPathSegments();     // Catch: Throwable -> L15
        int r14 = 0;
        Object r15 = null;
        if (r13 != null) goto L9;
    L21:
        monitor-exit(this);
        Pair r16 = null;
    L23:
        if (r16 != null) goto L26;
        return null;
    L26:
        if ("query".equals(r11) == false) goto L52;
        if (r12 == null) goto L31;
        SpPair r17 = (SpPair) r12.getParcelable("sp");
        if (r17 == null) goto L31;
        r15 = r17.f3903b;
    L31:
        SharedPreferences r18 = (SharedPreferences) r16.first;
        String r19 = (String) r16.second;
        Bundle r20 = new Bundle();
        ArrayList<? extends Parcelable> r110 = new ArrayList();
        if (r19 != null) goto L38;
        Iterator<Map.Entry<String, ?>> r21 = r18.getAll().entrySet().iterator();
    L35:
        if (r21.hasNext() == false) goto L37;
        Map.Entry<String, ?> r22 = r21.next();
        r110.add(new SpPair(r22.getKey(), r22.getValue()));
        goto L35
    L37:
        r20.putParcelableArrayList("sp", r110);
    L50:
        return r20;
    L38:
        Object r23 = r18.getAll().get(r19);
        if (r23 == null) goto L43;
        r15 = r23;
    L43:
        if ((r15 instanceof Set) == false) goto L49;
        Set r24 = (Set) r15;
        String[] r25 = new String[r24.size()];
        Iterator r26 = r24.iterator();
    L46:
        if (r26.hasNext() == false) goto L48;
        r25[r14] = (String) r26.next();
        r14 = r14 + 1;
        goto L46
    L48:
        r15 = r25;
    L49:
        r110.add(new SpPair(r19, r15));
        r20.putParcelableArrayList("sp", r110);
        goto L50
    L52:
        if ("contains".equals(r11) == false) goto L56;
        SharedPreferences r27 = (SharedPreferences) r16.first;
        String r28 = (String) r16.second;
        Bundle r29 = new Bundle();
        r29.putBoolean("contains", r27.contains(r28));
        return r29;
    L56:
        if ("edit".equals(r11) == false) goto L62;
        if (r12 == null) goto L62;
        a((SharedPreferences) r16.first, r12);     // Catch: Throwable -> L60
        long r30 = Binder.clearCallingIdentity();     // Catch: Throwable -> L60
        this.f3901a.notifyChange(Uri.parse(r10), null);     // Catch: Throwable -> L60
        Binder.restoreCallingIdentity(r30);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        io.reactivex.exceptions.a.n("MultiProcessSharedPref", "edit", th);
    L62:
        return null;
    L9:
        if (r13.size() < 2) goto L21;
        if ("sp".equals(r13.get(0)) == false) goto L21;
        SharedPreferences r31 = getContext().getSharedPreferences(r13.get(1), 0);     // Catch: Throwable -> L15
        if (r13.size() <= 2) goto L17;
        String r32 = r13.get(2);     // Catch: Throwable -> L15
    L18:
        r16 = new Pair(r31, r32);     // Catch: Throwable -> L15
        monitor-exit(this);
        goto L23
    L17:
        r32 = null;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r5) {
        return false;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new f(this);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        b(null, null);
        return null;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r5, boolean r10) {
        b(String.valueOf(r10), r5);
        return r10;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r5, float r10) {
        b(String.valueOf(r10), r5);
        return r10;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r5, int r10) {
        b(String.valueOf(r10), r5);
        return r10;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r5, long r10) {
        b(String.valueOf(r10), r5);
        return r10;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r5, String r10) {
        b(r10, r5);
        return null;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String r5, Set r10) {
        b(r10, r5);
        return null;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r5, ContentValues r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.f3901a = getContext().getContentResolver();
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r5, String[] r10, String r11, String[] r12, String r13) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r5) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r5) {
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r5, ContentValues r10, String r11, String[] r12) {
        return -1;
    }
}
