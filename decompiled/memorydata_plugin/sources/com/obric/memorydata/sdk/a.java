package com.obric.memorydata.sdk;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0002H\u0086\b¢\u0006\u0002\u0010\u0007\u001a$\u0010\b\u001a\u0004\u0018\u0001H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010\t\u001a\u001a\u0010\n\u001a\u00020\u0003*\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¨\u0006\r"}, d2 = {"putAny", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Bundle;", "key", "", EventBody.KEY_VALUE, "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "getAs", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "toBundle", "", "", "memoryDataSDK_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final Bundle a(Map<String, ? extends Object> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();
        if (r10 != null) goto L5;
        return r0;
    L5:
        Iterator r11 = r10.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L157;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        Object r4 = r2.getValue();
        if (r4 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L16;
        r0.putBoolean(r3, ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L7
    L16:
        if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L19;
        r0.putByte(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).byteValue());
        goto L7
    L19:
        if (ZeusTransformUtils.instanceOf(r4, Character.class) == false) goto L22;
        r0.putChar(r3, ((Character) ZeusTransformUtils.preCheckCast(r4, Character.class, "com.obric.memorydata.plugin")).charValue());
        goto L7
    L22:
        if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L25;
        r0.putShort(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).shortValue());
        goto L7
    L25:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L28;
        r0.putInt(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L7
    L28:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L31;
        r0.putLong(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L7
    L31:
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L34;
        r0.putFloat(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L7
    L34:
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L37;
        r0.putDouble(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L7
    L37:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L38;
        if (ZeusTransformUtils.instanceOf(r4, CharSequence.class) == true) goto L41;
        if (ZeusTransformUtils.instanceOf(r4, Parcelable.class) == true) goto L44;
        if (ZeusTransformUtils.instanceOf(r4, Serializable.class) == true) goto L47;
        if ((r4 instanceof boolean[]) == true) goto L50;
        if ((r4 instanceof byte[]) == true) goto L53;
        if ((r4 instanceof char[]) == true) goto L56;
        if ((r4 instanceof short[]) == true) goto L59;
        if ((r4 instanceof int[]) == true) goto L62;
        if ((r4 instanceof long[]) == true) goto L65;
        if ((r4 instanceof float[]) == true) goto L68;
        if ((r4 instanceof double[]) == true) goto L71;
        if ((r4 instanceof Object[]) == true) goto L75;
        if (ZeusTransformUtils.instanceOf(r4, ArrayList.class) == true) goto L87;
        if (ZeusTransformUtils.instanceOf(r4, SparseArray.class) == true) goto L142;
        if (ZeusTransformUtils.instanceOf(r4, IBinder.class) == true) goto L145;
        if (ZeusTransformUtils.instanceOf(r4, Size.class) == true) goto L148;
        if (ZeusTransformUtils.instanceOf(r4, SizeF.class) == true) goto L151;
        if (ZeusTransformUtils.instanceOf(r4, Bundle.class) == false) goto L156;
        r0.putBundle(r3, (Bundle) ZeusTransformUtils.preCheckCast(r4, Bundle.class, "com.obric.memorydata.plugin"));
        goto L7
    L156:
        throw new IllegalArgumentException("Unsupported type " + r4.getClass() + " for key=" + r3);
    L151:
        r0.putSizeF(r3, (SizeF) ZeusTransformUtils.preCheckCast(r4, SizeF.class, "com.obric.memorydata.plugin"));
        goto L7
    L148:
        r0.putSize(r3, (Size) ZeusTransformUtils.preCheckCast(r4, Size.class, "com.obric.memorydata.plugin"));
        goto L7
    L145:
        r0.putBinder(r3, (IBinder) ZeusTransformUtils.preCheckCast(r4, IBinder.class, "com.obric.memorydata.plugin"));
        goto L7
    L142:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.util.SparseArray<out android.os.Parcelable>");
        r0.putSparseParcelableArray(r3, (SparseArray) ZeusTransformUtils.preCheckCast(r4, SparseArray.class, "com.obric.memorydata.plugin"));
        goto L7
    L87:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L90;
    L92:
        Iterator r7 = r5.iterator();
    L94:
        if (r7.hasNext() == false) goto L91;
        if (ZeusTransformUtils.instanceOf(r7.next(), String.class) == true) goto L94;
        boolean r8 = false;
    L98:
        if (r8 == true) goto L99;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L103;
    L105:
        Iterator r13 = r12.iterator();
    L107:
        if (r13.hasNext() == false) goto L104;
        if (ZeusTransformUtils.instanceOf(r13.next(), CharSequence.class) == true) goto L107;
        boolean r14 = false;
    L111:
        if (r14 == true) goto L112;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L116;
    L118:
        Iterator r16 = r15.iterator();
    L120:
        if (r16.hasNext() == false) goto L117;
        if (ZeusTransformUtils.instanceOf(r16.next(), Integer.class) == true) goto L120;
        boolean r17 = false;
    L124:
        if (r17 == true) goto L125;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L129;
    L131:
        Iterator r19 = r18.iterator();
    L133:
        if (r19.hasNext() == false) goto L130;
        if (ZeusTransformUtils.instanceOf(r19.next(), Parcelable.class) == true) goto L133;
    L136:
        if (r6 == false) goto L139;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<android.os.Parcelable>");
        r0.putParcelableArrayList(r3, (ArrayList) ZeusTransformUtils.preCheckCast(r4, ArrayList.class, "com.obric.memorydata.plugin"));
        goto L7
    L139:
        throw new IllegalArgumentException("Unsupported ArrayList type for key=" + r3);
    L130:
        r6 = true;
        goto L136
    L129:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L131;
    L125:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
        r0.putIntegerArrayList(r3, (ArrayList) ZeusTransformUtils.preCheckCast(r4, ArrayList.class, "com.obric.memorydata.plugin"));
    L117:
        r17 = true;
        goto L124
    L116:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L118;
    L112:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<kotlin.CharSequence>");
        r0.putCharSequenceArrayList(r3, (ArrayList) ZeusTransformUtils.preCheckCast(r4, ArrayList.class, "com.obric.memorydata.plugin"));
    L104:
        r14 = true;
        goto L111
    L103:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L105;
    L99:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        r0.putStringArrayList(r3, (ArrayList) ZeusTransformUtils.preCheckCast(r4, ArrayList.class, "com.obric.memorydata.plugin"));
    L91:
        r8 = true;
        goto L98
    L90:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L92;
    L75:
        if ((((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin")) instanceof String[]) == true) goto L76;
        if ((((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin")) instanceof CharSequence[]) == true) goto L79;
        if ((((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin")) instanceof Parcelable[]) == false) goto L84;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
        r0.putParcelableArray(r3, (Parcelable[]) ZeusTransformUtils.preCheckCast(r4, Parcelable[].class, "com.obric.memorydata.plugin"));
        goto L7
    L84:
        throw new IllegalArgumentException("Unsupported array type for key=" + r3);
    L79:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
        r0.putCharSequenceArray(r3, (CharSequence[]) ZeusTransformUtils.preCheckCast(r4, CharSequence[].class, "com.obric.memorydata.plugin"));
        goto L7
    L76:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r0.putStringArray(r3, (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.memorydata.plugin"));
        goto L7
    L71:
        r0.putDoubleArray(r3, (double[]) ZeusTransformUtils.preCheckCast(r4, double[].class, "com.obric.memorydata.plugin"));
        goto L7
    L68:
        r0.putFloatArray(r3, (float[]) ZeusTransformUtils.preCheckCast(r4, float[].class, "com.obric.memorydata.plugin"));
        goto L7
    L65:
        r0.putLongArray(r3, (long[]) ZeusTransformUtils.preCheckCast(r4, long[].class, "com.obric.memorydata.plugin"));
        goto L7
    L62:
        r0.putIntArray(r3, (int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.memorydata.plugin"));
        goto L7
    L59:
        r0.putShortArray(r3, (short[]) ZeusTransformUtils.preCheckCast(r4, short[].class, "com.obric.memorydata.plugin"));
        goto L7
    L56:
        r0.putCharArray(r3, (char[]) ZeusTransformUtils.preCheckCast(r4, char[].class, "com.obric.memorydata.plugin"));
        goto L7
    L53:
        r0.putByteArray(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
        goto L7
    L50:
        r0.putBooleanArray(r3, (boolean[]) ZeusTransformUtils.preCheckCast(r4, boolean[].class, "com.obric.memorydata.plugin"));
        goto L7
    L47:
        r0.putSerializable(r3, (Serializable) ZeusTransformUtils.preCheckCast(r4, Serializable.class, "com.obric.memorydata.plugin"));
        goto L7
    L44:
        r0.putParcelable(r3, (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
        goto L7
    L41:
        r0.putCharSequence(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L7
    L38:
        String r20 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L11:
        r0.putString(r3, r20);
        goto L7
    L10:
        r20 = null;
        goto L11
    L157:
        return r0;
    }
}
