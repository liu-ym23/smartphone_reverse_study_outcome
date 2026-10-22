package com.bytedance.android.live.impl.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.keva.Keva;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KevaHelper extends k0 {
    public static final Keva a = null;
    public static final KevaHelper b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/impl/utils/KevaHelper$Type;", "", "STRING", "INTEGER", "BOOLEAN", "FLOAT", "LONG", "STRING_SET", "ALL", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    static {
        b = new KevaHelper();
        a = Keva.getRepo("live_feature_manager", 0);
    }

    public KevaHelper() {
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
        if ((r5 instanceof String) == false) goto L6;
        a.storeString(r4, (String) r5);
        return;
    L6:
        if ((r5 instanceof Integer) == false) goto L9;
        a.storeInt(r4, ((Number) r5).intValue());
        return;
    L9:
        if ((r5 instanceof Boolean) == false) goto L12;
        a.storeBoolean(r4, ((Boolean) r5).booleanValue());
        return;
    L12:
        if ((r5 instanceof Float) == false) goto L15;
        a.storeFloat(r4, ((Number) r5).floatValue());
        return;
    L15:
        if ((r5 instanceof Long) == false) goto L18;
        a.storeLong(r4, ((Number) r5).longValue());
        return;
    L18:
        if ((r5 instanceof Set) == false) goto L20;
        a.storeStringSet(r4, (Set) r5);
        return;
    L20:
        a.storeString(r4, r5.toString());
    }

    @Override // com.bytedance.android.live.core.utils.k0
    public final void f(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        e(r2, r3.toString());
    }

    public static Object g(String r1, Type r2, Object r3) {
        switch(b.a[r2.ordinal()]) {
            case 1: goto L21;
            case 2: goto L16;
            case 3: goto L13;
            case 4: goto L10;
            case 5: goto L7;
            case 6: goto L23;
            case 7: goto L22;
            default: goto L29;
        };
    L7:
        Long r4 = (Long) r3;
        if (r4 == null) goto L19;
        long r5 = r4.longValue();
        return Long.valueOf(a.getLong(r1, r5));
    L19:
        return null;
    L10:
        Float r6 = (Float) r3;
        if (r6 == null) goto L19;
        float r7 = r6.floatValue();
        return Float.valueOf(a.getFloat(r1, r7));
    L13:
        Boolean r8 = (Boolean) r3;
        if (r8 == null) goto L19;
        boolean r9 = r8.booleanValue();
        return Boolean.valueOf(a.getBoolean(r1, r9));
    L16:
        Integer r11 = (Integer) r3;
        if (r11 == null) goto L19;
        int r12 = r11.intValue();
        return Integer.valueOf(a.getInt(r1, r12));
    L29:
        return r3;
    L22:
        return a.getAll();
    L23:
        return a.getStringSet(r1, (Set) r3);
    L21:
        return a.getString(r1, (String) r3);
    }
}
