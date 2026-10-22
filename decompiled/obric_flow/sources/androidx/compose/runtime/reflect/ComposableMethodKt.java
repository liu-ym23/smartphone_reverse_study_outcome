package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u0002H\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0082\b¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\bH\u0002\u001a7\u0010\u0010\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0014\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\n\"\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0002\u0010\u0015\u001a\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0006\u0012\u0002\b\u00030\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"BITS_PER_INT", "", "changedParamCount", "realValueParams", "thisParams", "defaultParamCount", "asComposableMethod", "Landroidx/compose/runtime/reflect/ComposableMethod;", "Ljava/lang/reflect/Method;", "dup", "", ExifInterface.GPS_DIRECTION_TRUE, "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "getComposableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "getDeclaredComposableMethod", "Ljava/lang/Class;", "methodName", "", "args", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Landroidx/compose/runtime/reflect/ComposableMethod;", "getDefaultValue", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposableMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposableMethod.kt\nandroidx/compose/runtime/reflect/ComposableMethodKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,219:1\n185#1:232\n185#1:239\n185#1:246\n1735#2,6:220\n1549#3:226\n1620#3,3:227\n1549#3:233\n1620#3,3:234\n1549#3:240\n1620#3,3:241\n1549#3:247\n1620#3,3:248\n37#4,2:230\n37#4,2:237\n37#4,2:244\n37#4,2:251\n*S KotlinDebug\n*F\n+ 1 ComposableMethod.kt\nandroidx/compose/runtime/reflect/ComposableMethodKt\n*L\n201#1:232\n210#1:239\n211#1:246\n57#1:220,6\n185#1:226\n185#1:227,3\n201#1:233\n201#1:234,3\n210#1:240\n210#1:241,3\n211#1:247\n211#1:248,3\n185#1:230,2\n201#1:237,2\n210#1:244,2\n211#1:251,2\n*E\n"})
public final class ComposableMethodKt {
    private static final int BITS_PER_INT = 31;

    public static final /* synthetic */ Object access$getDefaultValue(Class r5) {
        return getDefaultValue(r5);
    }

    public static final ComposableMethod asComposableMethod(Method r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ComposableInfo r10 = getComposableInfo(r5);
        if (r10.isComposable() == true) goto L5;
        return null;
    L5:
        return new ComposableMethod(r5, r10);
    }

    private static final int changedParamCount(int r5, int r10) {
        if (r5 != 0) goto L6;
        return 1;
    L6:
        return (int) Math.ceil(((double) (r5 + r10)) / 10.0d);
    }

    private static final int defaultParamCount(int r5) {
        return (int) Math.ceil(((double) r5) / 31.0d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T[] dup(T r5, int r10) {
        IntRange r11 = RangesKt.until(0, r10);
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<Integer> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((IntIterator) r13).nextInt();
        r12.add(r5);
        goto L4
    L6:
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) r12.toArray(new Object[0]);
    }

    private static final ComposableInfo getComposableInfo(Method r10) {
        Class<?>[] r5 = r10.getParameterTypes();
        int r11 = r5.length - 1;
        if (r11 < 0) goto L10;
    L4:
        int r12 = r11 - 1;
        if (Intrinsics.areEqual(r5[r11], Composer.class) == true) goto L11;
        if (r12 < 0) goto L10;
        r11 = r12;
    L11:
        boolean r13 = false;
        if (r11 == (-1)) goto L14;
        int r14 = changedParamCount(r11, !Modifier.isStatic(r10.getModifiers()) ? 1 : 0);
        int r15 = (r11 + 1) + r14;
        int r16 = r10.getParameterTypes().length;
        if (r16 == r15) goto L18;
        int r17 = defaultParamCount(r11);
    L20:
        if ((r15 + r17) != r16) goto L23;
        r13 = true;
    L23:
        return new ComposableInfo(r13, r11, r14, r17);
    L18:
        r17 = 0;
        goto L20
    L14:
        return new ComposableInfo(false, r10.getParameterTypes().length, 0, 0);
    L10:
        r11 = -1;
        goto L11
    }

    public static final ComposableMethod getDeclaredComposableMethod(Class<?> r10, String r11, Class<?>... r12) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "methodName");
        Intrinsics.checkNotNullParameter(r12, "args");
        int r5 = changedParamCount(r12.length, 0);
        SpreadBuilder r13 = new SpreadBuilder(3);     // Catch: ReflectiveOperationException -> L9
        r13.addSpread(r12);     // Catch: ReflectiveOperationException -> L9
        r13.add(Composer.class);     // Catch: ReflectiveOperationException -> L9
        Class r14 = Integer.TYPE;     // Catch: ReflectiveOperationException -> L9
        IntRange r15 = RangesKt.until(0, r5);     // Catch: ReflectiveOperationException -> L9
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));     // Catch: ReflectiveOperationException -> L9
        Iterator<Integer> r17 = r15.iterator();     // Catch: ReflectiveOperationException -> L9
    L5:
        if (r17.hasNext() == false) goto L7;
        ((IntIterator) r17).nextInt();     // Catch: ReflectiveOperationException -> L9
        r16.add(r14);     // Catch: ReflectiveOperationException -> L9
        goto L5
    L7:
        r13.addSpread(r16.toArray(new Class[0]));     // Catch: ReflectiveOperationException -> L9
        Method r18 = r10.getDeclaredMethod(r11, (Class[]) r13.toArray(new Class[r13.size()]));     // Catch: ReflectiveOperationException -> L9
    L21:
        if (r18 == null) goto L25;
        ComposableMethod r19 = asComposableMethod(r18);
        Intrinsics.checkNotNull(r19);
        return r19;
    L25:
        throw new NoSuchMethodException(r10.getName() + '.' + r11);
    L9:
        int r20 = defaultParamCount(r12.length);
        SpreadBuilder r21 = new SpreadBuilder(4);     // Catch: ReflectiveOperationException -> L20
        r21.addSpread(r12);     // Catch: ReflectiveOperationException -> L20
        r21.add(Composer.class);     // Catch: ReflectiveOperationException -> L20
        Class r110 = Integer.TYPE;     // Catch: ReflectiveOperationException -> L20
        IntRange r22 = RangesKt.until(0, r5);     // Catch: ReflectiveOperationException -> L20
        ArrayList r23 = new ArrayList(CollectionsKt.h(r22));     // Catch: ReflectiveOperationException -> L20
        Iterator<Integer> r24 = r22.iterator();     // Catch: ReflectiveOperationException -> L20
    L12:
        if (r24.hasNext() == false) goto L14;
        ((IntIterator) r24).nextInt();     // Catch: ReflectiveOperationException -> L20
        r23.add(r110);     // Catch: ReflectiveOperationException -> L20
        goto L12
    L14:
        r21.addSpread(r23.toArray(new Class[0]));     // Catch: ReflectiveOperationException -> L20
        Class r111 = Integer.TYPE;     // Catch: ReflectiveOperationException -> L20
        IntRange r25 = RangesKt.until(0, r20);     // Catch: ReflectiveOperationException -> L20
        ArrayList r26 = new ArrayList(CollectionsKt.h(r25));     // Catch: ReflectiveOperationException -> L20
        Iterator<Integer> r27 = r25.iterator();     // Catch: ReflectiveOperationException -> L20
    L16:
        if (r27.hasNext() == false) goto L18;
        ((IntIterator) r27).nextInt();     // Catch: ReflectiveOperationException -> L20
        r26.add(r111);     // Catch: ReflectiveOperationException -> L20
        goto L16
    L18:
        r21.addSpread(r26.toArray(new Class[0]));     // Catch: ReflectiveOperationException -> L20
        r18 = r10.getDeclaredMethod(r11, (Class[]) r21.toArray(new Class[r21.size()]));     // Catch: ReflectiveOperationException -> L20
    L20:
        r18 = null;
        goto L21
    }

    private static final Object getDefaultValue(Class<?> r5) {
        String r10 = r5.getName();
        switch(r10.hashCode()) {
            case -1325958191: goto L34;
            case 104431: goto L30;
            case 3039496: goto L26;
            case 3052374: goto L22;
            case 3327612: goto L18;
            case 64711720: goto L14;
            case 97526364: goto L10;
            case 109413500: goto L6;
            default: goto L35;
        };
    L35:
        return null;
    L6:
        if (r10.equals("short") == false) goto L35;
        return (short) 0;
    L10:
        if (r10.equals("float") == false) goto L35;
        return Float.valueOf(0.0f);
    L14:
        if (r10.equals("boolean") == false) goto L35;
        return Boolean.FALSE;
    L18:
        if (r10.equals("long") == false) goto L35;
        return 0L;
    L22:
        if (r10.equals("char") == false) goto L35;
        return (char) 0;
    L26:
        if (r10.equals("byte") == false) goto L35;
        return (byte) 0;
    L30:
        if (r10.equals("int") == false) goto L35;
        return 0;
    L34:
        if (r10.equals("double") == false) goto L35;
        return Double.valueOf(0.0d);
    }
}
