package com.bytedance.android.live.impl.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.k0;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SharedPrefHelper extends k0 {
    public static final String a = null;
    public static final Lazy b = null;
    public static final SharedPrefHelper c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/impl/utils/SharedPrefHelper$Type;", "", "STRING", "INTEGER", "BOOLEAN", "FLOAT", "LONG", "STRING_SET", "ALL", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type ALL = null;
        public static final Type BOOLEAN = null;
        public static final Type FLOAT = null;
        public static final Type INTEGER = null;
        public static final Type LONG = null;
        public static final Type STRING = null;
        public static final Type STRING_SET = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("STRING", 0);
            STRING = r1;
            Type r2 = new Type("INTEGER", 1);
            INTEGER = r2;
            Type r3 = new Type("BOOLEAN", 2);
            BOOLEAN = r3;
            Type r4 = new Type("FLOAT", 3);
            FLOAT = r4;
            Type r5 = new Type("LONG", 4);
            LONG = r5;
            Type r6 = new Type("STRING_SET", 5);
            STRING_SET = r6;
            Type r7 = new Type("ALL", 6);
            ALL = r7;
            a = new Type[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static SharedPreferences h() {
        return (SharedPreferences) b.getValue();
    }

    static {
        c = new SharedPrefHelper();
        a = "liveai_feature_manager_sp";
        b = LazyKt.lazy(SharedPrefHelper$spForLiveFeatureManager$2.INSTANCE);
    }

    public SharedPrefHelper() {
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final int a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r4 = g(r3, Type.INTEGER, 0);
        Intrinsics.checkNotNull(r4);
        return ((Number) r4).intValue();
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final JSONObject b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        String r4 = d(r3, null);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L11;
        return null;
    L11:
        return new JSONObject(r4);
    L10:
        return null;
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final long c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Object r5 = g(r4, Type.LONG, 0L);
        Intrinsics.checkNotNull(r5);
        return ((Number) r5).longValue();
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final String d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (String) g(r2, Type.STRING, r3);
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final void e(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        SharedPreferences r0 = h();
        if (r0 == null) goto L5;
        SharedPreferences.Editor r1 = r0.edit();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r5 instanceof String) == false) goto L11;
        r1.putString(r4, (String) r5);
    L26:
        r1.apply();
        return;
    L11:
        if ((r5 instanceof Integer) == false) goto L14;
        r1.putInt(r4, ((Number) r5).intValue());
        goto L26
    L14:
        if ((r5 instanceof Boolean) == false) goto L17;
        r1.putBoolean(r4, ((Boolean) r5).booleanValue());
        goto L26
    L17:
        if ((r5 instanceof Float) == false) goto L20;
        r1.putFloat(r4, ((Number) r5).floatValue());
        goto L26
    L20:
        if ((r5 instanceof Long) == false) goto L23;
        r1.putLong(r4, ((Number) r5).longValue());
        goto L26
    L23:
        if ((r5 instanceof Set) == false) goto L25;
        r1.putStringSet(r4, (Set) r5);
        goto L26
    L25:
        r1.putString(r4, r5.toString());
        goto L26
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final void f(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        e(r2, r3.toString());
    }

    public static Object g(String r1, Type r2, Object r3) {
        switch(c.a[r2.ordinal()]) {
            case 1: goto L32;
            case 2: goto L26;
            case 3: goto L21;
            case 4: goto L16;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L5;
            default: goto L41;
        };
    L5:
        SharedPreferences r4 = h();
        if (r4 != null) goto L37;
    L35:
        return null;
    L37:
        return r4.getAll();
    L8:
        SharedPreferences r5 = h();
        if (r5 == null) goto L35;
        return r5.getStringSet(r1, (Set) r3);
    L11:
        Long r6 = (Long) r3;
        if (r6 == null) goto L35;
        long r7 = r6.longValue();
        c.getClass();
        SharedPreferences r0 = h();
        if (r0 == null) goto L35;
        Object r8 = Long.valueOf(r0.getLong(r1, r7));
    L39:
        return r8;
    L16:
        Float r9 = (Float) r3;
        if (r9 == null) goto L35;
        float r11 = r9.floatValue();
        c.getClass();
        SharedPreferences r12 = h();
        if (r12 == null) goto L35;
        r8 = Float.valueOf(r12.getFloat(r1, r11));
        goto L39
    L21:
        Boolean r13 = (Boolean) r3;
        if (r13 == null) goto L35;
        boolean r14 = r13.booleanValue();
        c.getClass();
        SharedPreferences r15 = h();
        if (r15 == null) goto L35;
        r8 = Boolean.valueOf(r15.getBoolean(r1, r14));
        goto L39
    L26:
        Integer r16 = (Integer) r3;
        if (r16 == null) goto L35;
        int r17 = r16.intValue();
        c.getClass();
        SharedPreferences r18 = h();
        if (r18 == null) goto L35;
        r8 = Integer.valueOf(r18.getInt(r1, r17));
        goto L39
    L32:
        SharedPreferences r19 = h();
        if (r19 == null) goto L35;
        return r19.getString(r1, (String) r3);
    L41:
        return r3;
    }
}
