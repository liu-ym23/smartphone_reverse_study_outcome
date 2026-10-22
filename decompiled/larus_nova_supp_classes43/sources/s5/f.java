package s5;

import android.content.SharedPreferences;
import com.bytedance.keva.Keva;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements SharedPreferences, Keva.OnChangeListener {
    public final Lazy a;
    public final Lazy b;

    public static final class a implements SharedPreferences.Editor {
        public final Keva a;

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.a.clear();
            return this;
        }

        public a(Keva r10) {
            Intrinsics.checkNotNullParameter(r10, "sp");
            this.a = r10;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r10) {
            this.a.erase(r10);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r10, boolean r11) {
            Keva r0 = this.a;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r0.storeBoolean(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r10, float r11) {
            Keva r0 = this.a;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r0.storeFloat(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r10, int r11) {
            Keva r0 = this.a;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r0.storeInt(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r10, long r11) {
            Keva r0 = this.a;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r0.storeLong(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r10, String r11) {
            Keva r0 = this.a;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            if (r11 != null) goto L7;
            r11 = "";
        L7:
            r0.storeString(r10, r11);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r10, Set<String> r11) {
            Keva r0 = this.a;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            if (r11 != null) goto L7;
            r11 = new LinkedHashSet();
        L7:
            r0.storeStringSet(r10, r11);
            return this;
        }
    }

    public static final class b extends g<SharedPreferences.OnSharedPreferenceChangeListener> {
        public final /* synthetic */ f c;

        public b(f r1) {
            this.c = r1;
        }

        public final void a(int r10) {
            if (r10 != 0) goto L4;
            this.c.a().unRegisterChangeListener(this.c);
            return;
        L4:
            if (r10 != 1) goto L10;
            this.c.a().registerChangeListener(this.c);
            return;
        }
    }

    public final Keva a() {
        return (Keva) this.a.getValue();
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(a());
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return a().getAll();
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r10) {
        Keva r0 = a();
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        return r0.contains(r10);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
        b r0 = (b) this.b.getValue();
        if (r10 == null) goto L15;
        Object r1 = r0.a;
        monitor-enter(r1);
        T r11 = (T) r10;
        if (r0.b.put(r11, r0.a) != null) goto L9;
        r0.a(r0.b.size());     // Catch: Throwable -> L12
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        r0.getClass();
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
        b r0 = (b) this.b.getValue();
        if (r10 == null) goto L15;
        Object r1 = r0.a;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r0.b.remove(r10) == null) goto L9;
        r0.a(r0.b.size());     // Catch: Throwable -> L12
    L9:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L15:
        r0.getClass();
    }

    public f(final String r10, final int r11) {
        Intrinsics.checkNotNullParameter(r10, "fileName");
        this.a = LazyKt.lazy(new d(r10, r11));
        this.b = LazyKt.lazy(new e(this));
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r10, boolean r11) {
        Keva r0 = a();
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        return r0.getBoolean(r10, r11);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r10, float r11) {
        Keva r0 = a();
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        return r0.getFloat(r10, r11);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r10, int r11) {
        Keva r0 = a();
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        return r0.getInt(r10, r11);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r10, long r11) {
        return a().getLong(r10, r11);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r10, String r11) {
        Keva r0 = a();
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        return r0.getString(r10, r11);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r10, Set<String> r11) {
        Keva r0 = a();
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        return r0.getStringSet(r10, r11);
    }

    public final void onChanged(Keva r10, String r11) {
        b r12 = (b) this.b.getValue();
        Object r0 = r12.a;
        monitor-enter(r0);
        HashSet r1 = new HashSet(r12.b.keySet());     // Catch: Throwable -> L11
        monitor-exit(r0);
        Iterator r13 = r1.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ((SharedPreferences.OnSharedPreferenceChangeListener) r13.next()).onSharedPreferenceChanged(this, r11);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
