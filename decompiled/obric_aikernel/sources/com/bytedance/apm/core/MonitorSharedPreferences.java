package com.bytedance.apm.core;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.apm.util.j;
import com.bytedance.apm6.util.constant.CommonConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MonitorSharedPreferences implements SharedPreferences {
    private static int sTargetPID = -1;
    private Application mApp;
    private Uri mDefaultUri;
    private String mUriString;

    /* JADX INFO: renamed from: com.bytedance.apm.core.MonitorSharedPreferences$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mPuts;
        final /* synthetic */ MonitorSharedPreferences this$0;

        private EditorImpl(MonitorSharedPreferences r10) {
            this.this$0 = r10;
            this.mClear = false;
            this.mPuts = new HashMap();
        }

        /* synthetic */ EditorImpl(MonitorSharedPreferences r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.mClear == false) goto L5;
        L7:
            Bundle r10 = new Bundle();
            if (this.mClear == false) goto L10;
            r10.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r11 = new ArrayList(this.mPuts.size());
            Iterator<Map.Entry<String, Object>> r12 = this.mPuts.entrySet().iterator();
        L12:
            if (r12.hasNext() == false) goto L14;
            Map.Entry<String, Object> r13 = r12.next();
            r11.add(new SpPair(r13.getKey(), r13.getValue()));
            goto L12
        L14:
            r10.putParcelableArrayList("edit", r11);
            MonitorSharedPreferences.access$300(this.this$0).getContentResolver().call(MonitorSharedPreferences.access$100(this.this$0), MonitorSharedPreferences.access$200(this.this$0), "edit", r10);     // Catch: Exception -> L17
            return;
        L21:
            return;
        L5:
            if (this.mPuts.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mPuts.clear();
            this.mClear = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r10, boolean r11) {
            this.mPuts.put(r10, Boolean.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r10, float r11) {
            this.mPuts.put(r10, Float.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r10, int r11) {
            this.mPuts.put(r10, Integer.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r10, long r11) {
            this.mPuts.put(r10, Long.valueOf(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r10, String r11) {
            this.mPuts.put(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r10, Set<String> r11) {
            this.mPuts.put(r10, j.e(r11));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r10) {
            this.mPuts.put(r10, null);
            return this;
        }
    }

    static {
    }

    private MonitorSharedPreferences(Application r10, String r11) {
        this.mApp = r10;
        String r12 = "content://" + r10.getPackageName() + CommonConsts.MONITOR_PROVIDER_SUFFIX + "/sp/" + r11;
        this.mUriString = r12;
        this.mDefaultUri = Uri.parse(r12);
    }

    static /* synthetic */ Uri access$100(MonitorSharedPreferences r10) {
        return r10.mDefaultUri;
    }

    static /* synthetic */ String access$200(MonitorSharedPreferences r10) {
        return r10.mUriString;
    }

    static /* synthetic */ Application access$300(MonitorSharedPreferences r10) {
        return r10.mApp;
    }

    private ArrayList<SpPair> getPairs(String r10, Object r11) {
        Bundle r12 = new Bundle();
        if (r11 == null) goto L21;
        r12.putParcelable("sp", new SpPair(r10, r11));
    L21:
        ContentResolver r13 = this.mApp.getContentResolver();     // Catch: Exception -> L16
        Uri r14 = this.mDefaultUri;     // Catch: Exception -> L16
        if (r10 == null) goto L9;
        String r15 = this.mUriString + "/" + r10;     // Catch: Exception -> L16
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
        r15 = this.mUriString;     // Catch: Exception -> L16
    L16:
        r16 = null;
        goto L17
    }

    private static int getProviderPID(Context r10) {
        Bundle r11 = r10.getContentResolver().call(Uri.parse("content://" + r10.getPackageName() + CommonConsts.MONITOR_PROVIDER_SUFFIX), "getPid", null, null);     // Catch: Exception -> L8
        if (r11 == null) goto L7;
        return r11.getInt("Pid", -1);
    L7:
        return -1;
    }

    static SharedPreferences getProviderSharedPreferences(Context r10, String r11) {
        if ((r10 instanceof Application) == true) goto L7;
        r10 = r10.getApplicationContext();
    L7:
        return new MonitorSharedPreferences((Application) r10, r11);
    }

    public static SharedPreferences getSharedPreferences(Context r10, String r11) {
        if (isProviderProcess(r10) == false) goto L7;
        return r10.getSharedPreferences(r11, 4);
    L7:
        return getProviderSharedPreferences(r10, r11);
    }

    public static boolean isProviderProcess(Context r10) {
        if (sTargetPID != (-1)) goto L6;
        sTargetPID = getProviderPID(r10);
    L6:
        if (sTargetPID != Process.myPid()) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r10) {
        Bundle r11 = null;
        ContentResolver r12 = this.mApp.getContentResolver();     // Catch: Exception -> L14
        Uri r13 = this.mDefaultUri;     // Catch: Exception -> L14
        if (r10 == null) goto L6;
        String r14 = this.mUriString + "/" + r10;     // Catch: Exception -> L14
    L7:
        r11 = r12.call(r13, r14, "contains", null);     // Catch: Exception -> L14
        goto L8
    L6:
        r14 = this.mUriString;     // Catch: Exception -> L14
    L8:
        if (r11 != null) goto L10;
    L12:
        return false;
    L10:
        if (r11.getBoolean("contains") == false) goto L12;
        return true;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new EditorImpl(this, null);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        ArrayList<SpPair> r10 = getPairs(null, null);
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
        ArrayList<SpPair> r12 = getPairs(r10, String.valueOf(r11));
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
        ArrayList<SpPair> r12 = getPairs(r10, String.valueOf(r11));
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
        ArrayList<SpPair> r12 = getPairs(r10, String.valueOf(r11));
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
        ArrayList<SpPair> r12 = getPairs(r10, String.valueOf(r11));
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
        ArrayList<SpPair> r12 = getPairs(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return (String) r12.get(0).mValue;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r10, Set<String> r11) {
        ArrayList<SpPair> r12 = getPairs(r10, r11);
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

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
    }
}
