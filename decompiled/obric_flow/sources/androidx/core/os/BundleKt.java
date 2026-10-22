package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BundleKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... r10) {
        Bundle r5 = new Bundle(r10.length);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L95;
        Pair<String, ? extends Object> r13 = r10[r12];
        String r14 = r13.component1();
        Object r15 = r13.component2();
        if (r15 != null) goto L8;
        r5.putString(r14, null);
    L92:
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r15 instanceof Boolean) == false) goto L11;
        r5.putBoolean(r14, ((Boolean) r15).booleanValue());
        goto L92
    L11:
        if ((r15 instanceof Byte) == false) goto L14;
        r5.putByte(r14, ((Number) r15).byteValue());
        goto L92
    L14:
        if ((r15 instanceof Character) == false) goto L17;
        r5.putChar(r14, ((Character) r15).charValue());
        goto L92
    L17:
        if ((r15 instanceof Double) == false) goto L20;
        r5.putDouble(r14, ((Number) r15).doubleValue());
        goto L92
    L20:
        if ((r15 instanceof Float) == false) goto L23;
        r5.putFloat(r14, ((Number) r15).floatValue());
        goto L92
    L23:
        if ((r15 instanceof Integer) == false) goto L26;
        r5.putInt(r14, ((Number) r15).intValue());
        goto L92
    L26:
        if ((r15 instanceof Long) == false) goto L29;
        r5.putLong(r14, ((Number) r15).longValue());
        goto L92
    L29:
        if ((r15 instanceof Short) == false) goto L32;
        r5.putShort(r14, ((Number) r15).shortValue());
        goto L92
    L32:
        if ((r15 instanceof Bundle) == false) goto L35;
        r5.putBundle(r14, (Bundle) r15);
        goto L92
    L35:
        if ((r15 instanceof CharSequence) == false) goto L38;
        r5.putCharSequence(r14, (CharSequence) r15);
        goto L92
    L38:
        if ((r15 instanceof Parcelable) == false) goto L41;
        r5.putParcelable(r14, (Parcelable) r15);
        goto L92
    L41:
        if ((r15 instanceof boolean[]) == false) goto L44;
        r5.putBooleanArray(r14, (boolean[]) r15);
        goto L92
    L44:
        if ((r15 instanceof byte[]) == false) goto L47;
        r5.putByteArray(r14, (byte[]) r15);
        goto L92
    L47:
        if ((r15 instanceof char[]) == false) goto L50;
        r5.putCharArray(r14, (char[]) r15);
        goto L92
    L50:
        if ((r15 instanceof double[]) == false) goto L53;
        r5.putDoubleArray(r14, (double[]) r15);
        goto L92
    L53:
        if ((r15 instanceof float[]) == false) goto L56;
        r5.putFloatArray(r14, (float[]) r15);
        goto L92
    L56:
        if ((r15 instanceof int[]) == false) goto L59;
        r5.putIntArray(r14, (int[]) r15);
        goto L92
    L59:
        if ((r15 instanceof long[]) == false) goto L62;
        r5.putLongArray(r14, (long[]) r15);
        goto L92
    L62:
        if ((r15 instanceof short[]) == false) goto L65;
        r5.putShortArray(r14, (short[]) r15);
        goto L92
    L65:
        if ((r15 instanceof Object[]) == false) goto L81;
        Class<?> r16 = r15.getClass().getComponentType();
        Intrinsics.checkNotNull(r16);
        if (Parcelable.class.isAssignableFrom(r16) == false) goto L70;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
        r5.putParcelableArray(r14, (Parcelable[]) r15);
        goto L92
    L70:
        if (String.class.isAssignableFrom(r16) == false) goto L73;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r5.putStringArray(r14, (String[]) r15);
        goto L92
    L73:
        if (CharSequence.class.isAssignableFrom(r16) == false) goto L76;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
        r5.putCharSequenceArray(r14, (CharSequence[]) r15);
        goto L92
    L76:
        if (Serializable.class.isAssignableFrom(r16) == false) goto L79;
        r5.putSerializable(r14, (Serializable) r15);
        goto L92
    L79:
        throw new IllegalArgumentException("Illegal value array type " + r16.getCanonicalName() + " for key \"" + r14 + Typography.quote);
    L81:
        if ((r15 instanceof Serializable) == false) goto L84;
        r5.putSerializable(r14, (Serializable) r15);
        goto L92
    L84:
        if ((r15 instanceof IBinder) == false) goto L87;
        r5.putBinder(r14, (IBinder) r15);
        goto L92
    L87:
        if ((r15 instanceof Size) == false) goto L90;
        BundleApi21ImplKt.putSize(r5, r14, (Size) r15);
        goto L92
    L90:
        if ((r15 instanceof SizeF) == false) goto L94;
        BundleApi21ImplKt.putSizeF(r5, r14, (SizeF) r15);
        goto L92
    L94:
        throw new IllegalArgumentException("Illegal value type " + r15.getClass().getCanonicalName() + " for key \"" + r14 + Typography.quote);
    L95:
        return r5;
    }

    public static final Bundle bundleOf() {
        return new Bundle(0);
    }
}
