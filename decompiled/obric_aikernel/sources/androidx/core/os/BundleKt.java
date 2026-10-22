package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public final class BundleKt {
    public static final Bundle bundleOf() {
        return new Bundle(0);
    }

    public static final Bundle bundleOf(Pair<String, ? extends Object>... r10) {
        Intrinsics.checkNotNullParameter(r10, "pairs");
        Bundle r11 = new Bundle(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L100;
        Pair<String, ? extends Object> r14 = r10[r13];
        String r15 = r14.component1();
        Object r16 = r14.component2();
        if (r16 != null) goto L8;
        r11.putString(r15, null);
    L97:
        r13 = r13 + 1;
        goto L3
    L8:
        if ((r16 instanceof Boolean) == false) goto L11;
        r11.putBoolean(r15, ((Boolean) r16).booleanValue());
        goto L97
    L11:
        if ((r16 instanceof Byte) == false) goto L14;
        r11.putByte(r15, ((Number) r16).byteValue());
        goto L97
    L14:
        if ((r16 instanceof Character) == false) goto L17;
        r11.putChar(r15, ((Character) r16).charValue());
        goto L97
    L17:
        if ((r16 instanceof Double) == false) goto L20;
        r11.putDouble(r15, ((Number) r16).doubleValue());
        goto L97
    L20:
        if ((r16 instanceof Float) == false) goto L23;
        r11.putFloat(r15, ((Number) r16).floatValue());
        goto L97
    L23:
        if ((r16 instanceof Integer) == false) goto L26;
        r11.putInt(r15, ((Number) r16).intValue());
        goto L97
    L26:
        if ((r16 instanceof Long) == false) goto L29;
        r11.putLong(r15, ((Number) r16).longValue());
        goto L97
    L29:
        if ((r16 instanceof Short) == false) goto L32;
        r11.putShort(r15, ((Number) r16).shortValue());
        goto L97
    L32:
        if ((r16 instanceof Bundle) == false) goto L35;
        r11.putBundle(r15, (Bundle) r16);
        goto L97
    L35:
        if ((r16 instanceof CharSequence) == false) goto L38;
        r11.putCharSequence(r15, (CharSequence) r16);
        goto L97
    L38:
        if ((r16 instanceof Parcelable) == false) goto L41;
        r11.putParcelable(r15, (Parcelable) r16);
        goto L97
    L41:
        if ((r16 instanceof boolean[]) == false) goto L44;
        r11.putBooleanArray(r15, (boolean[]) r16);
        goto L97
    L44:
        if ((r16 instanceof byte[]) == false) goto L47;
        r11.putByteArray(r15, (byte[]) r16);
        goto L97
    L47:
        if ((r16 instanceof char[]) == false) goto L50;
        r11.putCharArray(r15, (char[]) r16);
        goto L97
    L50:
        if ((r16 instanceof double[]) == false) goto L53;
        r11.putDoubleArray(r15, (double[]) r16);
        goto L97
    L53:
        if ((r16 instanceof float[]) == false) goto L56;
        r11.putFloatArray(r15, (float[]) r16);
        goto L97
    L56:
        if ((r16 instanceof int[]) == false) goto L59;
        r11.putIntArray(r15, (int[]) r16);
        goto L97
    L59:
        if ((r16 instanceof long[]) == false) goto L62;
        r11.putLongArray(r15, (long[]) r16);
        goto L97
    L62:
        if ((r16 instanceof short[]) == false) goto L65;
        r11.putShortArray(r15, (short[]) r16);
        goto L97
    L65:
        if ((r16 instanceof Object[]) == false) goto L81;
        Class<?> r17 = r16.getClass().getComponentType();
        Intrinsics.checkNotNull(r17);
        if (Parcelable.class.isAssignableFrom(r17) == false) goto L70;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
        r11.putParcelableArray(r15, (Parcelable[]) r16);
        goto L97
    L70:
        if (String.class.isAssignableFrom(r17) == false) goto L73;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r11.putStringArray(r15, (String[]) r16);
        goto L97
    L73:
        if (CharSequence.class.isAssignableFrom(r17) == false) goto L76;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
        r11.putCharSequenceArray(r15, (CharSequence[]) r16);
        goto L97
    L76:
        if (Serializable.class.isAssignableFrom(r17) == false) goto L79;
    L82:
        r11.putSerializable(r15, (Serializable) r16);
        goto L97
    L79:
        throw new IllegalArgumentException("Illegal value array type " + r17.getCanonicalName() + " for key \"" + r15 + Typography.quote);
    L81:
        if ((r16 instanceof Serializable) == true) goto L82;
        int r18 = Build.VERSION.SDK_INT;
        if (r18 < 18) goto L89;
        if ((r16 instanceof IBinder) == false) goto L89;
        BundleApi18ImplKt.putBinder(r11, r15, (IBinder) r16);
    L89:
        if (r18 >= 21) goto L91;
    L93:
        if (r18 < 21) goto L99;
        if ((r16 instanceof SizeF) == false) goto L99;
        BundleApi21ImplKt.putSizeF(r11, r15, (SizeF) r16);
    L99:
        throw new IllegalArgumentException("Illegal value type " + r16.getClass().getCanonicalName() + " for key \"" + r15 + Typography.quote);
    L91:
        if ((r16 instanceof Size) == false) goto L93;
        BundleApi21ImplKt.putSize(r11, r15, (Size) r16);
        goto L97
    L100:
        return r11;
    }
}
