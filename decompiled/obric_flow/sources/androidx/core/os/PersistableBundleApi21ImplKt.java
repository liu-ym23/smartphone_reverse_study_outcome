package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "()V", "createPersistableBundle", "Landroid/os/PersistableBundle;", "capacity", "", "putValue", "", "persistableBundle", STGroup.DICT_KEY, "", "value", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = null;

    static {
        INSTANCE = new PersistableBundleApi21ImplKt();
    }

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final PersistableBundle createPersistableBundle(int r5) {
        return new PersistableBundle(r5);
    }

    @JvmStatic
    @DoNotInline
    public static final void putValue(PersistableBundle r5, String r10, Object r11) {
        if (r11 != null) goto L5;
        r5.putString(r10, null);
        return;
    L5:
        if ((r11 instanceof Boolean) == false) goto L8;
        PersistableBundleApi22ImplKt.putBoolean(r5, r10, ((Boolean) r11).booleanValue());
        return;
    L8:
        if ((r11 instanceof Double) == false) goto L11;
        r5.putDouble(r10, ((Number) r11).doubleValue());
        return;
    L11:
        if ((r11 instanceof Integer) == false) goto L14;
        r5.putInt(r10, ((Number) r11).intValue());
        return;
    L14:
        if ((r11 instanceof Long) == false) goto L17;
        r5.putLong(r10, ((Number) r11).longValue());
        return;
    L17:
        if ((r11 instanceof String) == false) goto L20;
        r5.putString(r10, (String) r11);
        return;
    L20:
        if ((r11 instanceof boolean[]) == false) goto L23;
        PersistableBundleApi22ImplKt.putBooleanArray(r5, r10, (boolean[]) r11);
        return;
    L23:
        if ((r11 instanceof double[]) == false) goto L26;
        r5.putDoubleArray(r10, (double[]) r11);
        return;
    L26:
        if ((r11 instanceof int[]) == false) goto L29;
        r5.putIntArray(r10, (int[]) r11);
        return;
    L29:
        if ((r11 instanceof long[]) == false) goto L32;
        r5.putLongArray(r10, (long[]) r11);
        return;
    L32:
        if ((r11 instanceof Object[]) == false) goto L40;
        Class<?> r12 = r11.getClass().getComponentType();
        Intrinsics.checkNotNull(r12);
        if (String.class.isAssignableFrom(r12) == false) goto L38;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r5.putStringArray(r10, (String[]) r11);
        return;
    L38:
        throw new IllegalArgumentException("Illegal value array type " + r12.getCanonicalName() + " for key \"" + r10 + Typography.quote);
    L40:
        throw new IllegalArgumentException("Illegal value type " + r11.getClass().getCanonicalName() + " for key \"" + r10 + Typography.quote);
    }
}
