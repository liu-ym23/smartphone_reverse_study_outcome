package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "()V", "createPersistableBundle", "Landroid/os/PersistableBundle;", "capacity", "", "putValue", "", "persistableBundle", "key", "", EventBody.KEY_VALUE, "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = null;

    static {
        INSTANCE = new PersistableBundleApi21ImplKt();
    }

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    public static final PersistableBundle createPersistableBundle(int r1) {
        return new PersistableBundle(r1);
    }

    @JvmStatic
    public static final void putValue(PersistableBundle r5, String r6, Object r7) {
        if (r7 != null) goto L6;
        String r8 = null;
    L4:
        r5.putString(r6, r8);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, Boolean.class) == false) goto L13;
        if (Build.VERSION.SDK_INT < 22) goto L11;
        PersistableBundleApi22ImplKt.putBoolean(r5, r6, ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L11:
        throw new IllegalArgumentException("Illegal value type boolean for key \"" + r6 + Typography.quote);
    L13:
        if (ZeusTransformUtils.instanceOf(r7, Double.class) == false) goto L16;
        r5.putDouble(r6, ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L19;
        r5.putInt(r6, ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r7, Long.class) == false) goto L22;
        r5.putLong(r6, ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L25;
        r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        goto L4
    L25:
        if ((r7 instanceof boolean[]) == false) goto L32;
        if (Build.VERSION.SDK_INT < 22) goto L30;
        PersistableBundleApi22ImplKt.putBooleanArray(r5, r6, (boolean[]) ZeusTransformUtils.preCheckCast(r7, boolean[].class, "com.obric.memorydata.plugin"));
        return;
    L30:
        throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + r6 + Typography.quote);
    L32:
        if ((r7 instanceof double[]) == false) goto L35;
        r5.putDoubleArray(r6, (double[]) ZeusTransformUtils.preCheckCast(r7, double[].class, "com.obric.memorydata.plugin"));
        return;
    L35:
        if ((r7 instanceof int[]) == false) goto L38;
        r5.putIntArray(r6, (int[]) ZeusTransformUtils.preCheckCast(r7, int[].class, "com.obric.memorydata.plugin"));
        return;
    L38:
        if ((r7 instanceof long[]) == false) goto L41;
        r5.putLongArray(r6, (long[]) ZeusTransformUtils.preCheckCast(r7, long[].class, "com.obric.memorydata.plugin"));
        return;
    L41:
        if ((r7 instanceof Object[]) == false) goto L49;
        Class<?> r0 = r7.getClass().getComponentType();
        Intrinsics.checkNotNull(r0);
        if (String.class.isAssignableFrom(r0) == false) goto L47;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r5.putStringArray(r6, (String[]) ZeusTransformUtils.preCheckCast(r7, String[].class, "com.obric.memorydata.plugin"));
        return;
    L47:
        throw new IllegalArgumentException("Illegal value array type " + r0.getCanonicalName() + " for key \"" + r6 + Typography.quote);
    L49:
        throw new IllegalArgumentException("Illegal value type " + r7.getClass().getCanonicalName() + " for key \"" + r6 + Typography.quote);
    }
}
