package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = null;

    static {
        INSTANCE = new PersistableBundleApi21ImplKt();
    }

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final PersistableBundle createPersistableBundle(int r10) {
        return new PersistableBundle(r10);
    }

    @JvmStatic
    @DoNotInline
    public static final void putValue(PersistableBundle r10, String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "persistableBundle");
        if (r12 != null) goto L7;
        String r13 = null;
    L5:
        r10.putString(r11, r13);
        return;
    L7:
        if ((r12 instanceof Boolean) == false) goto L14;
        if (Build.VERSION.SDK_INT < 22) goto L12;
        PersistableBundleApi22ImplKt.putBoolean(r10, r11, ((Boolean) r12).booleanValue());
        return;
    L12:
        throw new IllegalArgumentException("Illegal value type boolean for key \"" + r11 + Typography.quote);
    L14:
        if ((r12 instanceof Double) == false) goto L17;
        r10.putDouble(r11, ((Number) r12).doubleValue());
        return;
    L17:
        if ((r12 instanceof Integer) == false) goto L20;
        r10.putInt(r11, ((Number) r12).intValue());
        return;
    L20:
        if ((r12 instanceof Long) == false) goto L23;
        r10.putLong(r11, ((Number) r12).longValue());
        return;
    L23:
        if ((r12 instanceof String) == false) goto L26;
        r13 = (String) r12;
        goto L5
    L26:
        if ((r12 instanceof boolean[]) == false) goto L33;
        if (Build.VERSION.SDK_INT < 22) goto L31;
        PersistableBundleApi22ImplKt.putBooleanArray(r10, r11, (boolean[]) r12);
        return;
    L31:
        throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + r11 + Typography.quote);
    L33:
        if ((r12 instanceof double[]) == false) goto L36;
        r10.putDoubleArray(r11, (double[]) r12);
        return;
    L36:
        if ((r12 instanceof int[]) == false) goto L39;
        r10.putIntArray(r11, (int[]) r12);
        return;
    L39:
        if ((r12 instanceof long[]) == false) goto L42;
        r10.putLongArray(r11, (long[]) r12);
        return;
    L42:
        if ((r12 instanceof Object[]) == false) goto L50;
        Class<?> r14 = r12.getClass().getComponentType();
        Intrinsics.checkNotNull(r14);
        if (String.class.isAssignableFrom(r14) == false) goto L48;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r10.putStringArray(r11, (String[]) r12);
        return;
    L48:
        throw new IllegalArgumentException("Illegal value array type " + r14.getCanonicalName() + " for key \"" + r11 + Typography.quote);
    L50:
        throw new IllegalArgumentException("Illegal value type " + r12.getClass().getCanonicalName() + " for key \"" + r11 + Typography.quote);
    }
}
