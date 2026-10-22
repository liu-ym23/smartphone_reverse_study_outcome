package dla;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements SharedPreferences, Keva.OnChangeListener {
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

        public a(Keva r2) {
            Intrinsics.checkNotNullParameter(r2, "sp");
            this.a = r2;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r2) {
            this.a.erase(r2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            Keva r0 = this.a;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.storeBoolean(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r2, float r3) {
            Keva r0 = this.a;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.storeFloat(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r2, int r3) {
            Keva r0 = this.a;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.storeInt(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r2, long r3) {
            Keva r0 = this.a;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.storeLong(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r3, String r4) {
            Keva r0 = this.a;
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            if (r4 != null) goto L7;
            r4 = "";
        L7:
            r0.storeString(r3, r4);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
            Keva r0 = this.a;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            if (r3 != null) goto L7;
            r3 = new LinkedHashSet();
        L7:
            r0.storeStringSet(r2, r3);
            return this;
        }
    }

    public static final class b extends g<SharedPreferences.OnSharedPreferenceChangeListener> {
        public final /* synthetic */ c c;

        public b(c r1) {
            this.c = r1;
        }

        public final void a(int r2) {
            if (r2 != 0) goto L4;
            this.c.a().unRegisterChangeListener(this.c);
            return;
        L4:
            if (r2 != 1) goto L10;
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
    public final boolean contains(String r2) {
        Keva r0 = a();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.contains(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r5) {
        b r0 = (b) this.b.getValue();
        if (r5 == null) goto L15;
        Object r1 = r0.a;
        monitor-enter(r1);
        T r6 = (T) r5;
        if (r0.b.put(r6, r0.a) != null) goto L9;
        r0.a(r0.b.size());     // Catch: Throwable -> L12
    L9:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        r0.getClass();
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r4) {
        b r0 = (b) this.b.getValue();
        if (r4 == null) goto L15;
        Object r1 = r0.a;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r0.b.remove(r4) == null) goto L9;
        r0.a(r0.b.size());     // Catch: Throwable -> L12
    L9:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L15:
        r0.getClass();
    }

    public c(final String r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "fileName");
        this.a = LazyKt.lazy(new dla.a(r2, r3));
        this.b = LazyKt.lazy(new dla.b(this));
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r2, boolean r3) {
        Keva r0 = a();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.getBoolean(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r2, float r3) {
        Keva r0 = a();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.getFloat(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r2, int r3) {
        Keva r0 = a();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.getInt(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r2, long r3) {
        Keva r0 = a();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.getLong(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r2, String r3) {
        Keva r0 = a();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.getString(r2, r3);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r2, Set<String> r3) {
        Keva r0 = a();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.getStringSet(r2, r3);
    }

    public final void onChanged(Keva r3, String r4) {
        b r5 = (b) this.b.getValue();
        Object r0 = r5.a;
        monitor-enter(r0);
        HashSet r1 = new HashSet(r5.b.keySet());     // Catch: Throwable -> L11
        monitor-exit(r0);
        Iterator r6 = r1.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ((SharedPreferences.OnSharedPreferenceChangeListener) r6.next()).onSharedPreferenceChanged(this, r4);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
