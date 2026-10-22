package com.bytedance.apm.util;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiProcessSharedPreferences extends ContentProvider implements SharedPreferences {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f1093j = "apm_config";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f1094k = ".apm6";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentResolver f1095c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Application f1096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Uri f1098i;

    static /* synthetic */ class a {
    }

    private class b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private HashMap<String, Object> f1100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MultiProcessSharedPreferences f1101c;

        private b(MultiProcessSharedPreferences r10) {
            this.f1101c = r10;
            this.f1099a = false;
            this.f1100b = new HashMap();
        }

        /* synthetic */ b(MultiProcessSharedPreferences r10, a r11) {
            this(r10);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.f1099a == false) goto L5;
        L7:
            Bundle r10 = new Bundle();
            if (this.f1099a == false) goto L10;
            r10.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r11 = new ArrayList(this.f1100b.size());
            Iterator<Map.Entry<String, Object>> r12 = this.f1100b.entrySet().iterator();
        L12:
            if (r12.hasNext() == false) goto L14;
            Map.Entry<String, Object> r13 = r12.next();
            r11.add(new SpPair(r13.getKey(), r13.getValue()));
            goto L12
        L14:
            r10.putParcelableArrayList("edit", r11);
            MultiProcessSharedPreferences.c(this.f1101c).getContentResolver().call(MultiProcessSharedPreferences.a(this.f1101c), MultiProcessSharedPreferences.b(this.f1101c), "edit", r10);     // Catch: Exception -> L17
            return;
        L17:
            e = move-exception;
            Logger.e("MultiProcessSharedPref", "apply exception: ", e);
            return;
        L5:
            if (this.f1100b.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f1100b.clear();
            this.f1099a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r10, boolean r11) {
            this.f1100b.put(r10, Boolean.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r10, float r11) {
            this.f1100b.put(r10, Float.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r10, int r11) {
            this.f1100b.put(r10, Integer.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r10, long r11) {
            this.f1100b.put(r10, Long.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r10, String r11) {
            this.f1100b.put(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r10, Set<String> r11) {
            this.f1100b.put(r10, ListUtils.toArray(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r10) {
            this.f1100b.put(r10, null);
            return this;
        }
    }

    static {
    }

    public MultiProcessSharedPreferences() {
    }

    private MultiProcessSharedPreferences(Application r10) {
        this.f1096g = r10;
        Uri r11 = j(r10);
        this.f1098i = r11;
        this.f1097h = r11.toString();
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.d("MultiProcessSharedPref", "getSpUri is " + this.f1098i);
        return;
    }

    static /* synthetic */ Uri a(MultiProcessSharedPreferences r10) {
        return r10.f1098i;
    }

    static /* synthetic */ String b(MultiProcessSharedPreferences r10) {
        return r10.f1097h;
    }

    static /* synthetic */ Application c(MultiProcessSharedPreferences r10) {
        return r10.f1096g;
    }

    private Bundle d(SharedPreferences r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putBoolean("contains", r10.contains(r11));
        return r12;
    }

    private static void e(SharedPreferences.Editor r10, String r11, Object r12) {
        if ((r12 instanceof String) == false) goto L6;
        r10.putString(r11, (String) r12);
        return;
    L6:
        if ((r12 instanceof Integer) == false) goto L9;
        r10.putInt(r11, ((Integer) r12).intValue());
        return;
    L9:
        if ((r12 instanceof Long) == false) goto L12;
        r10.putLong(r11, ((Long) r12).longValue());
        return;
    L12:
        if ((r12 instanceof Float) == false) goto L15;
        r10.putFloat(r11, ((Float) r12).floatValue());
        return;
    L15:
        if ((r12 instanceof Boolean) == false) goto L18;
        r10.putBoolean(r11, ((Boolean) r12).booleanValue());
        return;
    L18:
        if ((r12 instanceof String[]) == false) goto L26;
        r10.putStringSet(r11, new HashSet(Arrays.asList((String[]) r12)));
        return;
    }

    private void f(SharedPreferences r10, Bundle r11) {
        SharedPreferences.Editor r12 = r10.edit();
        if (r11.getBoolean("clear") == false) goto L5;
        r12.clear();
    L5:
        ArrayList r13 = r11.getParcelableArrayList("edit");
        if (r13 != null) goto L8;
        return;
    L8:
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L15;
        SpPair r15 = (SpPair) r14.next();
        Object r16 = r15.mValue;
        String r17 = r15.mKey;
        if (r16 == null) goto L13;
        e(r12, r17, r16);
        goto L10
    L13:
        r12.remove(r17);
        goto L10
    L15:
        r12.commit();
    }

    private ArrayList<SpPair> g(String r10, Object r11) {
        Bundle r12 = new Bundle();
        if (r11 == null) goto L21;
        r12.putParcelable("sp", new SpPair(r10, r11));
    L21:
        ContentResolver r13 = this.f1096g.getContentResolver();     // Catch: Exception -> L16
        Uri r14 = this.f1098i;     // Catch: Exception -> L16
        if (r10 == null) goto L9;
        String r15 = this.f1097h + "/" + r10;     // Catch: Exception -> L16
    L11:
        if (r11 != null) goto L14;
        r12 = null;
    L14:
        Bundle r16 = r13.call(r14, r15, "query", r12);     // Catch: Exception -> L16
    L17:
        if (r16 != null) goto L19;
        return null;
    L19:
        r16.setClassLoader(getClass().getClassLoader());
        return r16.getParcelableArrayList("sp");
    L9:
        r15 = this.f1097h;     // Catch: Exception -> L16
    L16:
        r16 = null;
        goto L17
    }

    private static SharedPreferences h(Context r10) {
        if ((r10 instanceof Application) == true) goto L7;
        r10 = r10.getApplicationContext();
    L7:
        return new MultiProcessSharedPreferences((Application) r10);
    }

    public static SharedPreferences i(Context r10) {
        return h(r10);
    }

    public static Uri j(Context r10) {
        String r11 = r10.getPackageName();
        String r12 = ya.a.c(r10, MultiProcessSharedPreferences.class.getName());
        if (TextUtils.isEmpty(r12) == false) goto L5;
        Uri r13 = Uri.parse("content://" + r11 + f1094k);
    L9:
        return r13.buildUpon().appendPath("sp").appendPath(f1093j).build();
    L5:
        r13 = Uri.parse("content://" + r12);
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d("MultiProcessSharedPref", "authority is " + r13);
        goto L9
    }

    private synchronized Pair<SharedPreferences, String> k(Uri r10) {
        monitor-enter(this);
        List<String> r11 = r10.getPathSegments();     // Catch: Throwable -> L17
        String r12 = null;
        if (r11 != null) goto L6;
    L15:
        monitor-exit(this);
        return null;
    L6:
        if (r11.size() < 2) goto L15;
        if ("sp".equals(r11.get(0)) == false) goto L15;
        SharedPreferences r13 = getContext().getSharedPreferences(r11.get(1), 0);     // Catch: Throwable -> L17
        if (r11.size() <= 2) goto L12;
        r12 = r11.get(2);     // Catch: Throwable -> L17
    L12:
        Pair<SharedPreferences, String> r14 = new Pair(r13, r12);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r14;
    L17:
        th = move-exception;
        throw th;
    }

    private Bundle l(SharedPreferences r10, String r11, Object r12) {
        Bundle r13 = new Bundle();
        ArrayList<? extends Parcelable> r14 = new ArrayList();
        Map<String, ?> r15 = r10.getAll();
        if (r11 != null) goto L8;
        Iterator<Map.Entry<String, ?>> r16 = r15.entrySet().iterator();
    L6:
        if (r16.hasNext() == false) goto L16;
        Map.Entry<String, ?> r17 = r16.next();
        r14.add(new SpPair(r17.getKey(), r17.getValue()));
    L16:
        r13.putParcelableArrayList("sp", r14);
        return r13;
    L8:
        Object r18 = r15.get(r11);
        if (r18 == null) goto L13;
        r12 = r18;
    L13:
        if ((r12 instanceof Set) == false) goto L15;
        r12 = ListUtils.toArray((Set) r12);
    L15:
        r14.add(new SpPair(r11, r12));
        goto L16
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r10, String r11, Bundle r12) {
        if (r12 == null) goto L4;
        r12.setClassLoader(getClass().getClassLoader());
    L4:
        Pair<SharedPreferences, String> r13 = k(Uri.parse(r10));
        Object r14 = null;
        if (r13 != null) goto L8;
        return null;
    L8:
        if ("query".equals(r11) == false) goto L16;
        if (r12 == null) goto L14;
        SpPair r15 = (SpPair) r12.getParcelable("sp");
        if (r15 == null) goto L14;
        r14 = r15.mValue;
    L14:
        return l((SharedPreferences) r13.first, (String) r13.second, r14);
    L16:
        if ("contains".equals(r11) == false) goto L20;
        return d((SharedPreferences) r13.first, (String) r13.second);
    L20:
        if ("edit".equals(r11) == false) goto L26;
        if (r12 == null) goto L26;
        f((SharedPreferences) r13.first, r12);     // Catch: Throwable -> L24
        long r16 = Binder.clearCallingIdentity();     // Catch: Throwable -> L24
        this.f1095c.notifyChange(Uri.parse(r10), null);     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(r16);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Logger.e("MultiProcessSharedPref", "edit", th);
    L26:
        return null;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r10) {
        if (this.f1098i != null) goto L5;
        return false;
    L5:
        Bundle r11 = null;
        ContentResolver r12 = this.f1096g.getContentResolver();     // Catch: Throwable -> L12
        Uri r13 = this.f1098i;     // Catch: Throwable -> L12
        if (r10 == null) goto L9;
        String r14 = this.f1097h + "/" + r10;     // Catch: Throwable -> L12
    L10:
        r11 = r12.call(r13, r14, "contains", null);     // Catch: Throwable -> L12
    L14:
        if (r11 != null) goto L16;
        return false;
    L16:
        if (r11.getBoolean("contains") == false) goto L22;
        return true;
    L22:
        return false;
    L9:
        r14 = this.f1097h;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Logger.e(Constant.TAG, "contains", th);
        goto L14
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        return -1;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, null);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        ArrayList<SpPair> r10 = g(null, null);
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap r11 = new HashMap();
        Iterator<SpPair> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        SpPair r13 = r12.next();
        r11.put(r13.mKey, r13.mValue);
        goto L7
    L9:
        return r11;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r10, boolean r11) {
        ArrayList<SpPair> r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = r12.get(0).mValue;
        if ((r13 instanceof Boolean) == false) goto L11;
        Boolean r14 = (Boolean) r13;
    L9:
        return r14.booleanValue();
    L11:
        if ((r13 instanceof String) == false) goto L13;
        r14 = Boolean.valueOf((String) r13);
        goto L9
    L13:
        return r11;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r10, float r11) {
        ArrayList<SpPair> r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = r12.get(0).mValue;
        if ((r13 instanceof Float) == false) goto L11;
        Float r14 = (Float) r13;
    L9:
        return r14.floatValue();
    L11:
        if ((r13 instanceof String) == false) goto L13;
        r14 = Float.valueOf((String) r13);
        goto L9
    L13:
        return r11;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r10, int r11) {
        ArrayList<SpPair> r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = r12.get(0).mValue;
        if ((r13 instanceof Integer) == false) goto L11;
        Integer r14 = (Integer) r13;
    L9:
        return r14.intValue();
    L11:
        if ((r13 instanceof String) == false) goto L13;
        r14 = Integer.decode((String) r13);
        goto L9
    L13:
        return r11;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r10, long r11) {
        ArrayList<SpPair> r12 = g(r10, String.valueOf(r11));
        if (r12 != null) goto L5;
        return r11;
    L5:
        Object r13 = r12.get(0).mValue;
        if ((r13 instanceof Long) == false) goto L11;
        Long r14 = (Long) r13;
    L9:
        return r14.longValue();
    L11:
        if ((r13 instanceof String) == false) goto L13;
        r14 = Long.decode((String) r13);
        goto L9
    L13:
        return r11;
    }

    @Override // android.content.SharedPreferences
    public String getString(String r10, String r11) {
        ArrayList<SpPair> r12 = g(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return (String) r12.get(0).mValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r10, Set<String> r11) {
        ArrayList<SpPair> r12 = g(r10, r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.get(0).mValue != null) goto L8;
        return null;
    L8:
        String[] r13 = (String[]) r12.get(0).mValue;
        HashSet r14 = new HashSet(r13.length);
        r14.addAll(Arrays.asList(r13));
        return r14;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f1095c = getContext().getContentResolver();
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        return -1;
    }
}
