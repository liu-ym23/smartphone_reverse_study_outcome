package com.bytedance.apm.core;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.apm.util.i;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e implements SharedPreferences {
    private static int d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f1268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1269b;
    private Uri c;

    /* JADX INFO: renamed from: com.bytedance.apm.core.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f1270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1271b;
        private HashMap<String, Object> c;

        private a(e r1) {
            this.f1270a = r1;
            this.f1271b = false;
            this.c = new HashMap();
        }

        /* synthetic */ a(e r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            if (this.f1271b == false) goto L5;
        L7:
            Bundle r5 = new Bundle();
            if (this.f1271b == false) goto L10;
            r5.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r0 = new ArrayList(this.c.size());
            Iterator<Map.Entry<String, Object>> r1 = this.c.entrySet().iterator();
        L12:
            if (r1.hasNext() == false) goto L14;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r0.add(new SpPair((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue()));
            goto L12
        L14:
            r5.putParcelableArrayList("edit", r0);
            ZeusProviderTransform.call(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.c(this.f1270a), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver(), e.a(this.f1270a), e.b(this.f1270a), "edit", r5, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
            return;
        L21:
            return;
        L5:
            if (this.c.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.c.clear();
            this.f1271b = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.c.put(r2, Boolean.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.c.put(r2, Float.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.c.put(r2, Integer.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            this.c.put(r2, Long.valueOf(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, String r3) {
            this.c.put(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r3, Set<String> r4) {
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            this.c.put(r3, i.a(r5));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r3) {
            this.c.put(r3, null);
            return this;
        }
    }

    static {
    }

    private e(Application r3, String r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        this.f1268a = r5;
        String r6 = "content://" + r5.getPackageName() + CommonConsts.MONITOR_PROVIDER_SUFFIX + "/sp/" + r4;
        this.f1269b = r6;
        this.c = Uri.parse(r6);
    }

    public static SharedPreferences a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (a(r4) == false) goto L7;
        return r4.getSharedPreferences(r3, 0);
    L7:
        return b(r4, r3);
    }

    static /* synthetic */ Uri a(e r0) {
        return r0.c;
    }

    private ArrayList<SpPair> a(String r11, Object r12) {
        Bundle r0 = new Bundle();
        if (r12 == null) goto L21;
        r0.putParcelable("sp", new SpPair(r11, r12));
    L21:
        ContentResolver r4 = this.f1268a.getContentResolver();     // Catch: Exception -> L16
        Uri r5 = this.c;     // Catch: Exception -> L16
        if (r11 == null) goto L9;
        String r13 = this.f1269b + "/" + r11;     // Catch: Exception -> L16
    L10:
        String r6 = r13;
        if (r12 == null) goto L13;
        Bundle r8 = r0;
    L14:
        Bundle r14 = ZeusProviderTransform.call(r4, r5, r6, ChatMessage.TYPE_QUERY, r8, "com.obric.memorydata.plugin");     // Catch: Exception -> L16
    L17:
        if (r14 != null) goto L19;
        return null;
    L19:
        r14.setClassLoader(getClass().getClassLoader());
        return r14.getParcelableArrayList("sp");
    L13:
        r8 = null;
        goto L14
    L9:
        r13 = this.f1269b;     // Catch: Exception -> L16
    L16:
        r14 = null;
        goto L17
    }

    public static boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (d != (-1)) goto L6;
        d = b(r3);
    L6:
        if (d != Process.myPid()) goto L8;
        return true;
    L8:
        return false;
    }

    private static int b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Bundle r9 = ZeusProviderTransform.call(r8.getContentResolver(), Uri.parse("content://" + r8.getPackageName() + CommonConsts.MONITOR_PROVIDER_SUFFIX), "getPid", null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        if (r9 == null) goto L7;
        return r9.getInt("Pid", -1);
    L7:
        return -1;
    }

    static SharedPreferences b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Application.class) == true) goto L7;
        r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L7:
        return new e((Application) ZeusTransformUtils.preCheckCast(r4, Application.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ String b(e r0) {
        return r0.f1269b;
    }

    static /* synthetic */ Application c(e r0) {
        return r0.f1268a;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r8) {
        ContentResolver r1 = this.f1268a.getContentResolver();     // Catch: Exception -> L8
        Uri r2 = this.c;     // Catch: Exception -> L8
        if (r8 == null) goto L5;
        String r7 = this.f1269b + "/" + r8;     // Catch: Exception -> L8
    L6:
        Bundle r9 = ZeusProviderTransform.call(r1, r2, r7, "contains", null, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
    L9:
        if (r9 != null) goto L11;
    L13:
        return false;
    L11:
        if (r9.getBoolean("contains") == false) goto L13;
        return true;
    L5:
        r7 = this.f1269b;     // Catch: Exception -> L8
    L8:
        r9 = null;
        goto L9
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new a(this, null);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        ArrayList<SpPair> r4 = a(null, null);
        if (r4 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator<SpPair> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        SpPair r1 = (SpPair) ZeusTransformUtils.preCheckCast(r5.next(), SpPair.class, "com.obric.memorydata.plugin");
        r0.put(r1.mKey, r1.mValue);
        goto L7
    L9:
        return r0;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r2, boolean r3) {
        ArrayList<SpPair> r1 = a(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.memorydata.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L11;
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin");
    L9:
        return r5.booleanValue();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L13;
        r5 = Boolean.valueOf((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r2, float r3) {
        ArrayList<SpPair> r1 = a(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.memorydata.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L11;
        Float r5 = (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin");
    L9:
        return r5.floatValue();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L13;
        r5 = Float.valueOf((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r2, int r3) {
        ArrayList<SpPair> r1 = a(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.memorydata.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L11;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");
    L9:
        return r5.intValue();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L13;
        r5 = Integer.decode((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r2, long r3) {
        ArrayList<SpPair> r1 = a(r2, String.valueOf(r3));
        if (r1 != null) goto L5;
        return r3;
    L5:
        Object r4 = ((SpPair) ZeusTransformUtils.preCheckCast(r1.get(0), SpPair.class, "com.obric.memorydata.plugin")).mValue;
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L11;
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin");
    L9:
        return r5.longValue();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L13;
        r5 = Long.decode((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        goto L9
    L13:
        return r3;
    }

    @Override // android.content.SharedPreferences
    public String getString(String r1, String r2) {
        ArrayList<SpPair> r0 = a(r1, r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(((SpPair) ZeusTransformUtils.preCheckCast(r0.get(0), SpPair.class, "com.obric.memorydata.plugin")).mValue, String.class, "com.obric.memorydata.plugin");
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r4, Set<String> r5) {
        ArrayList<SpPair> r3 = a(r4, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
        if (r3 != null) goto L6;
        return null;
    L6:
        if (((SpPair) ZeusTransformUtils.preCheckCast(r3.get(0), SpPair.class, "com.obric.memorydata.plugin")).mValue != null) goto L8;
        return null;
    L8:
        String[] r6 = (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(((SpPair) ZeusTransformUtils.preCheckCast(r3.get(0), SpPair.class, "com.obric.memorydata.plugin")).mValue, String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
        HashSet r7 = new HashSet(r6.length);
        r7.addAll(Arrays.asList(r6));
        return r7;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        SharedPreferences.OnSharedPreferenceChangeListener r1 = (SharedPreferences.OnSharedPreferenceChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.OnSharedPreferenceChangeListener.class, "com.obric.memorydata.plugin");
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        SharedPreferences.OnSharedPreferenceChangeListener r1 = (SharedPreferences.OnSharedPreferenceChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.OnSharedPreferenceChangeListener.class, "com.obric.memorydata.plugin");
    }
}
