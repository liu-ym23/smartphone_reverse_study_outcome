package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BundleKt {
    public static final Bundle bundleOf() {
        return new Bundle(0);
    }

    public static final Bundle bundleOf(Pair<String, ? extends Object>... r10) {
        Bundle r0 = new Bundle(r10.length);
        int r1 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L101;
        Pair<String, ? extends Object> r3 = r10[r2];
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.component1(), String.class, "com.obric.memorydata.plugin");
        Object r5 = r3.component2();
        if (r5 != null) goto L8;
        r0.putString(r4, null);
    L98:
        r2 = r2 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L11;
        r0.putBoolean(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L98
    L11:
        if (ZeusTransformUtils.instanceOf(r5, Byte.class) == false) goto L14;
        r0.putByte(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).byteValue());
        goto L98
    L14:
        if (ZeusTransformUtils.instanceOf(r5, Character.class) == false) goto L17;
        r0.putChar(r4, ((Character) ZeusTransformUtils.preCheckCast(r5, Character.class, "com.obric.memorydata.plugin")).charValue());
        goto L98
    L17:
        if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L20;
        r0.putDouble(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L98
    L20:
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L23;
        r0.putFloat(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L98
    L23:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L26;
        r0.putInt(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L98
    L26:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L29;
        r0.putLong(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L98
    L29:
        if (ZeusTransformUtils.instanceOf(r5, Short.class) == false) goto L32;
        r0.putShort(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).shortValue());
        goto L98
    L32:
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L35;
        r0.putBundle(r4, (Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin"));
        goto L98
    L35:
        if (ZeusTransformUtils.instanceOf(r5, CharSequence.class) == false) goto L38;
        r0.putCharSequence(r4, (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L98
    L38:
        if (ZeusTransformUtils.instanceOf(r5, Parcelable.class) == false) goto L41;
        r0.putParcelable(r4, (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.memorydata.plugin"));
        goto L98
    L41:
        if ((r5 instanceof boolean[]) == false) goto L44;
        r0.putBooleanArray(r4, (boolean[]) ZeusTransformUtils.preCheckCast(r5, boolean[].class, "com.obric.memorydata.plugin"));
        goto L98
    L44:
        if ((r5 instanceof byte[]) == false) goto L47;
        r0.putByteArray(r4, (byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"));
        goto L98
    L47:
        if ((r5 instanceof char[]) == false) goto L50;
        r0.putCharArray(r4, (char[]) ZeusTransformUtils.preCheckCast(r5, char[].class, "com.obric.memorydata.plugin"));
        goto L98
    L50:
        if ((r5 instanceof double[]) == false) goto L53;
        r0.putDoubleArray(r4, (double[]) ZeusTransformUtils.preCheckCast(r5, double[].class, "com.obric.memorydata.plugin"));
        goto L98
    L53:
        if ((r5 instanceof float[]) == false) goto L56;
        r0.putFloatArray(r4, (float[]) ZeusTransformUtils.preCheckCast(r5, float[].class, "com.obric.memorydata.plugin"));
        goto L98
    L56:
        if ((r5 instanceof int[]) == false) goto L59;
        r0.putIntArray(r4, (int[]) ZeusTransformUtils.preCheckCast(r5, int[].class, "com.obric.memorydata.plugin"));
        goto L98
    L59:
        if ((r5 instanceof long[]) == false) goto L62;
        r0.putLongArray(r4, (long[]) ZeusTransformUtils.preCheckCast(r5, long[].class, "com.obric.memorydata.plugin"));
        goto L98
    L62:
        if ((r5 instanceof short[]) == false) goto L65;
        r0.putShortArray(r4, (short[]) ZeusTransformUtils.preCheckCast(r5, short[].class, "com.obric.memorydata.plugin"));
        goto L98
    L65:
        if ((r5 instanceof Object[]) == false) goto L81;
        Class<?> r6 = r5.getClass().getComponentType();
        Intrinsics.checkNotNull(r6);
        if (Parcelable.class.isAssignableFrom(r6) == false) goto L70;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
        r0.putParcelableArray(r4, (Parcelable[]) ZeusTransformUtils.preCheckCast(r5, Parcelable[].class, "com.obric.memorydata.plugin"));
        goto L98
    L70:
        if (String.class.isAssignableFrom(r6) == false) goto L73;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r0.putStringArray(r4, (String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.memorydata.plugin"));
        goto L98
    L73:
        if (CharSequence.class.isAssignableFrom(r6) == false) goto L76;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
        r0.putCharSequenceArray(r4, (CharSequence[]) ZeusTransformUtils.preCheckCast(r5, CharSequence[].class, "com.obric.memorydata.plugin"));
        goto L98
    L76:
        if (Serializable.class.isAssignableFrom(r6) == false) goto L79;
    L82:
        r0.putSerializable(r4, (Serializable) ZeusTransformUtils.preCheckCast(r5, Serializable.class, "com.obric.memorydata.plugin"));
        goto L98
    L79:
        throw new IllegalArgumentException("Illegal value array type " + r6.getCanonicalName() + " for key \"" + r4 + Typography.quote);
    L81:
        if (ZeusTransformUtils.instanceOf(r5, Serializable.class) == true) goto L82;
        if (Build.VERSION.SDK_INT < 18) goto L89;
        if (ZeusTransformUtils.instanceOf(r5, IBinder.class) == false) goto L89;
        BundleApi18ImplKt.putBinder(r0, r4, (IBinder) ZeusTransformUtils.preCheckCast(r5, IBinder.class, "com.obric.memorydata.plugin"));
    L89:
        if (Build.VERSION.SDK_INT < 21) goto L94;
        if (ZeusTransformUtils.instanceOf(r5, Size.class) == false) goto L94;
        BundleApi21ImplKt.putSize(r0, r4, (Size) ZeusTransformUtils.preCheckCast(r5, Size.class, "com.obric.memorydata.plugin"));
    L94:
        if (Build.VERSION.SDK_INT < 21) goto L100;
        if (ZeusTransformUtils.instanceOf(r5, SizeF.class) == false) goto L100;
        BundleApi21ImplKt.putSizeF(r0, r4, (SizeF) ZeusTransformUtils.preCheckCast(r5, SizeF.class, "com.obric.memorydata.plugin"));
    L100:
        throw new IllegalArgumentException("Illegal value type " + r5.getClass().getCanonicalName() + " for key \"" + r4 + Typography.quote);
    L101:
        return r0;
    }
}
