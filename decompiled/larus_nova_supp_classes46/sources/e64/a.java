package e64;

import android.content.SharedPreferences;
import android.util.ArrayMap;
import com.bytedance.keva.Keva;
import com.bytedance.tma.base.keva.KevaManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements SharedPreferences {
    public final Map<SharedPreferences.OnSharedPreferenceChangeListener, Keva.OnChangeListener> a;
    public final boolean b;
    public final Keva c;

    /* JADX INFO: renamed from: e64.a$a, reason: collision with other inner class name */
    public class C0202a implements Keva.OnChangeListener {
        public final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener a;
        public final /* synthetic */ a b;

        public C0202a(a r1, SharedPreferences.OnSharedPreferenceChangeListener r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onChanged(Keva r2, String r3) {
            this.a.onSharedPreferenceChanged(this.b, r3);
        }
    }

    public class b implements SharedPreferences.Editor {
        public Map<String, Object> a;
        public boolean b;
        public final /* synthetic */ a c;

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.b = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            Map<String, Object> r0 = this.a;
            boolean r1 = this.b;
            a r2 = this.c;
            if (r1 == false) goto L5;
            r2.c.clear();
        L6:
            monitor-enter(r0);
            Iterator r3 = ((ArrayMap) r0).entrySet().iterator();     // Catch: Throwable -> L38
        L9:
            if (r3.hasNext() == false) goto L29;
            Map.Entry r4 = (Map.Entry) r3.next();     // Catch: Throwable -> L38
            String r5 = (String) r4.getKey();     // Catch: Throwable -> L38
            Object r6 = r4.getValue();     // Catch: Throwable -> L38
            if ((r6 instanceof Integer) == true) goto L12;
            if ((r6 instanceof Boolean) == true) goto L15;
            if ((r6 instanceof String) == true) goto L18;
            if ((r6 instanceof Long) == true) goto L21;
            if ((r6 instanceof Float) == true) goto L24;
            if ((r6 instanceof Set) == true) goto L27;
            r2.c.erase(r5);     // Catch: Throwable -> L38
            goto L9
        L27:
            r2.c.storeStringSet(r5, (Set) r6);     // Catch: Throwable -> L38
            goto L9
        L24:
            r2.c.storeFloat(r5, ((Float) r6).floatValue());     // Catch: Throwable -> L38
            goto L9
        L21:
            r2.c.storeLong(r5, ((Long) r6).longValue());     // Catch: Throwable -> L38
            goto L9
        L18:
            r2.c.storeString(r5, (String) r6);     // Catch: Throwable -> L38
            goto L9
        L15:
            r2.c.storeBoolean(r5, ((Boolean) r6).booleanValue());     // Catch: Throwable -> L38
            goto L9
        L12:
            r2.c.storeInt(r5, ((Integer) r6).intValue());     // Catch: Throwable -> L38
            goto L9
        L29:
            monitor-exit(r0);     // Catch: Throwable -> L38
            a r7 = this.c;
            if (r7.b == false) goto L33;
            r7.a();
        L33:
            this.a = new ArrayMap();
            if (this.b == false) goto L64;
            this.b = false;
            return true;
        L64:
            return true;
        L38:
            th = move-exception;
            throw th;
        L5:
            r2.getClass();
            goto L6
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            commit();
        }

        public b(a r1) {
            this.c = r1;
            this.a = new ArrayMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r2) {
            Map<String, Object> r0 = this.a;
            monitor-enter(r0);
            r0.put(r2, this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            Map<String, Object> r0 = this.a;
            monitor-enter(r0);
            r0.put(r2, Boolean.valueOf(r3));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r2, float r3) {
            Map<String, Object> r0 = this.a;
            monitor-enter(r0);
            r0.put(r2, Float.valueOf(r3));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r2, int r3) {
            Map<String, Object> r0 = this.a;
            monitor-enter(r0);
            r0.put(r2, Integer.valueOf(r3));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r2, long r3) {
            Map<String, Object> r0 = this.a;
            monitor-enter(r0);
            r0.put(r2, Long.valueOf(r3));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r2, String r3) {
            Map<String, Object> r0 = this.a;
            monitor-enter(r0);
            r0.put(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
            Map<String, Object> r0 = this.a;
            monitor-enter(r0);
            r0.put(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return this;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public abstract void a();

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new b(this);
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap r0 = new HashMap();
        Iterator r1 = this.c.getAll().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        Object r4 = r2.getValue();
        if (r4 == null) goto L4;
        if ((r4 instanceof String[]) == false) goto L13;
        String[] r5 = (String[]) r4;
        HashSet r6 = new HashSet(16, 0.75f);
        int r7 = r5.length;
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L12;
        r6.add(r5[r8]);
        r8 = r8 + 1;
        goto L10
    L12:
        r4 = r6;
    L13:
        r0.put(r3, r4);
        goto L4
    L14:
        return r0;
    }

    public a(String r2) {
        this.a = new ArrayMap();
        this.b = false;
        Lazy r0 = KevaManager.a;
        Intrinsics.checkNotNullParameter(r2, "repoName");
        this.c = Keva.getRepo(r2, 1);
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r2) {
        return this.c.contains(r2);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r3) {
        C0202a r0 = new C0202a(this, r3);
        this.c.registerChangeListener(r0);
        ((ArrayMap) this.a).put(r3, r0);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        Keva.OnChangeListener r3 = (Keva.OnChangeListener) ((ArrayMap) this.a).remove(r2);
        this.c.unRegisterChangeListener(r3);
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r2, boolean r3) {
        return this.c.getBoolean(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r2, float r3) {
        return this.c.getFloat(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r2, int r3) {
        return this.c.getInt(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r2, long r3) {
        return this.c.getLong(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r2, String r3) {
        String r4 = this.c.getString(r2, r3);
        if (r4 != null) goto L5;
        return r3;
    L5:
        return r4;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r2, Set<String> r3) {
        Set<String> r4 = this.c.getStringSet(r2, r3);
        if (r4 != null) goto L5;
        return r3;
    L5:
        return r4;
    }
}
