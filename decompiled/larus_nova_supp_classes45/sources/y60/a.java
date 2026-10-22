package y60;

import android.content.SharedPreferences;
import android.util.ArrayMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements SharedPreferences {
    public final SharedPreferences a;
    public volatile ConcurrentHashMap<String, Object> b;

    /* JADX INFO: renamed from: y60.a$a, reason: collision with other inner class name */
    public class SharedPreferencesEditorC0297a implements SharedPreferences.Editor {
        public boolean a;
        public Map<String, Object> b;
        public final /* synthetic */ a c;

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            if (this.c.b != null) goto L5;
        L6:
            this.c.a();
        L7:
            Map<String, Object> r0 = this.b;
            boolean r1 = this.a;
            SharedPreferences.Editor r2 = this.c.a.edit();
            if (r1 == false) goto L10;
            r2.clear();
            this.c.b.clear();
        L10:
            monitor-enter(r0);
            Iterator<Map.Entry<String, Object>> r3 = r0.entrySet().iterator();     // Catch: Throwable -> L47
        L12:
            boolean r4 = true;
            if (r3.hasNext() == false) goto L42;
            Map.Entry<String, Object> r5 = r3.next();     // Catch: Throwable -> L47
            String r6 = r5.getKey();     // Catch: Throwable -> L47
            Object r7 = r5.getValue();     // Catch: Throwable -> L47
            if (r7 != null) goto L18;
            r2.remove(r6);     // Catch: Throwable -> L47
        L36:
            r4 = false;
        L37:
            if (r6 != null) goto L39;
            r6 = "";
        L39:
            if (r4 == true) goto L40;
            this.c.b.remove(r6);     // Catch: Throwable -> L47
            goto L12
        L40:
            this.c.b.put(r6, r7);     // Catch: Throwable -> L47
            goto L12
        L18:
            if ((r7 instanceof Integer) == false) goto L21;
            r2.putInt(r6, ((Integer) r7).intValue());     // Catch: Throwable -> L47
            goto L37
        L21:
            if ((r7 instanceof Boolean) == false) goto L24;
            r2.putBoolean(r6, ((Boolean) r7).booleanValue());     // Catch: Throwable -> L47
            goto L37
        L24:
            if ((r7 instanceof String) == false) goto L27;
            r2.putString(r6, (String) r7);     // Catch: Throwable -> L47
            goto L37
        L27:
            if ((r7 instanceof Long) == false) goto L30;
            r2.putLong(r6, ((Long) r7).longValue());     // Catch: Throwable -> L47
            goto L37
        L30:
            if ((r7 instanceof Float) == false) goto L33;
            r2.putFloat(r6, ((Float) r7).floatValue());     // Catch: Throwable -> L47
            goto L37
        L33:
            if ((r7 instanceof Set) == false) goto L35;
            r2.putStringSet(r6, (Set) r7);     // Catch: Throwable -> L47
            goto L37
        L35:
            r2.remove(r6);     // Catch: Throwable -> L47
            goto L36
        L42:
            monitor-exit(r0);     // Catch: Throwable -> L47
            r2.commit();
            this.b = new ArrayMap();
            if (this.a == false) goto L46;
            this.a = false;
        L46:
            return true;
        L47:
            th = move-exception;
            throw th;
        L5:
            if (this.c.b.isEmpty() == false) goto L7;
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            commit();
        }

        public SharedPreferencesEditorC0297a(a r1) {
            this.c = r1;
            this.b = new ArrayMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r3) {
            Map<String, Object> r0 = this.b;
            monitor-enter(r0);
            this.b.put(r3, this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r3, boolean r4) {
            Map<String, Object> r0 = this.b;
            monitor-enter(r0);
            this.b.put(r3, Boolean.valueOf(r4));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r3, float r4) {
            Map<String, Object> r0 = this.b;
            monitor-enter(r0);
            this.b.put(r3, Float.valueOf(r4));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r3, int r4) {
            Map<String, Object> r0 = this.b;
            monitor-enter(r0);
            this.b.put(r3, Integer.valueOf(r4));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r3, long r4) {
            Map<String, Object> r0 = this.b;
            monitor-enter(r0);
            this.b.put(r3, Long.valueOf(r4));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r3, String r4) {
            Map<String, Object> r0 = this.b;
            monitor-enter(r0);
            this.b.put(r3, r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r3, Set<String> r4) {
            Map<String, Object> r0 = this.b;
            monitor-enter(r0);
            this.b.put(r3, r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public final Map<String, ?> a() {
        if (this.b != null) goto L5;
    L6:
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (this.b != null) goto L10;
    L11:
        Map<String, ?> r0 = this.a.getAll();     // Catch: Throwable -> L17
        Object r1 = r0.remove(null);     // Catch: Throwable -> L17
        this.b = new ConcurrentHashMap(r0);     // Catch: Throwable -> L17
        if (r1 == null) goto L14;
        this.b.put("", r1);     // Catch: Throwable -> L17
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
    L16:
        return this.b;
    L10:
        if (this.b.isEmpty() == false) goto L14;
    L5:
        if (this.b.isEmpty() == false) goto L16;
        goto L6
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new SharedPreferencesEditorC0297a(this);
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return Collections.unmodifiableMap(a());
    }

    public a(SharedPreferences r2) {
        this.b = null;
        this.a = r2;
    }

    public final Object b(String r2) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        return a().get(r2);
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r2) {
        if (this.b == null) goto L15;
        if (this.b.isEmpty() == true) goto L15;
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        if (a().get(r2) == null) goto L12;
        return true;
    L12:
        return false;
    L15:
        return this.a.contains(r2);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        this.a.registerOnSharedPreferenceChangeListener(r2);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        this.a.unregisterOnSharedPreferenceChangeListener(r2);
    }

    public static void c(Object r1, Throwable r2) {
        Objects.toString(r1);
        r2.getMessage();
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r2, boolean r3) {
        if (this.b == null) goto L15;
        if (this.b.isEmpty() == true) goto L15;
        Object r4 = b(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        return ((Boolean) r4).booleanValue();
    L13:
        return r3;
    L11:
        th = move-exception;
        c(Boolean.valueOf(r3), th);
    L15:
        return this.a.getBoolean(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r2, float r3) {
        if (this.b == null) goto L15;
        if (this.b.isEmpty() == true) goto L15;
        Object r4 = b(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        return ((Float) r4).floatValue();
    L13:
        return r3;
    L11:
        th = move-exception;
        c(Float.valueOf(r3), th);
    L15:
        return this.a.getFloat(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r2, int r3) {
        if (this.b == null) goto L15;
        if (this.b.isEmpty() == true) goto L15;
        Object r4 = b(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        return ((Integer) r4).intValue();
    L13:
        return r3;
    L11:
        th = move-exception;
        c(Integer.valueOf(r3), th);
    L15:
        return this.a.getInt(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r2, long r3) {
        if (this.b == null) goto L15;
        if (this.b.isEmpty() == true) goto L15;
        Object r4 = b(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        return ((Long) r4).longValue();
    L13:
        return r3;
    L11:
        th = move-exception;
        c(Long.valueOf(r3), th);
    L15:
        return this.a.getLong(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r2, String r3) {
        if (this.b == null) goto L15;
        if (this.b.isEmpty() == true) goto L15;
        Object r4 = b(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        return (String) r4;
    L13:
        return r3;
    L11:
        th = move-exception;
        c(r3, th);
    L15:
        return this.a.getString(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r2, Set<String> r3) {
        if (this.b == null) goto L15;
        if (this.b.isEmpty() == true) goto L15;
        Object r4 = b(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        return (Set) r4;
    L13:
        return r3;
    L11:
        th = move-exception;
        c(r3, th);
    L15:
        return this.a.getStringSet(r2, r3);
    }
}
