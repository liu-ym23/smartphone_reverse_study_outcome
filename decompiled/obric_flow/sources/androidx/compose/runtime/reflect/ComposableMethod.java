package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J:\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001d\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "parameterCount", "", "getParameterCount", "()I", "parameterTypes", "", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", "parameters", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "asMethod", "equals", "", "other", "hashCode", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposableMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposableMethod.kt\nandroidx/compose/runtime/reflect/ComposableMethod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n1549#2:220\n1620#2,3:221\n1804#2,4:224\n*S KotlinDebug\n*F\n+ 1 ComposableMethod.kt\nandroidx/compose/runtime/reflect/ComposableMethod\n*L\n143#1:220\n143#1:221,3\n144#1:224,4\n*E\n"})
public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    public ComposableMethod(Method r5, ComposableInfo r10) {
        Intrinsics.checkNotNullParameter(r5, "method");
        Intrinsics.checkNotNullParameter(r10, "composableInfo");
        this.method = r5;
        this.composableInfo = r10;
    }

    public final Method asMethod() {
        return this.method;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ComposableMethod) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.method, ((ComposableMethod) r5).method);
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Class<?>[] getParameterTypes() {
        return (Class[]) ArraysKt.copyOfRange(this.method.getParameterTypes(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Parameter[] getParameters() {
        return (Parameter[]) ArraysKt.copyOfRange(this.method.getParameters(), 0, this.composableInfo.getRealParamsCount());
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public final Object invoke(Composer r18, Object r19, Object... r20) {
        Intrinsics.checkNotNullParameter(r18, "composer");
        Intrinsics.checkNotNullParameter(r20, "args");
        ComposableInfo r5 = this.composableInfo;
        int r10 = r5.component2();
        int r11 = r5.component3();
        int r12 = r5.component4();
        int r13 = this.method.getParameterTypes().length;
        int r14 = r10 + 1;
        int r15 = r11 + r14;
        Object[] r16 = new Integer[r12];
        int r17 = 0;
        int r110 = 0;
    L3:
        if (r110 >= r12) goto L23;
        int r111 = r110 * 31;
        IntRange r112 = RangesKt.until(r111, Math.min(r111 + 31, r10));
        ArrayList r113 = new ArrayList(CollectionsKt.h(r112));
        Iterator<Integer> r114 = r112.iterator();
    L6:
        if (r114.hasNext() == false) goto L15;
        int r115 = ((IntIterator) r114).nextInt();
        if (r115 < r20.length) goto L10;
    L13:
        int r116 = 1;
    L14:
        r113.add(Integer.valueOf(r116));
        goto L6
    L10:
        if (r20[r115] == null) goto L13;
        r116 = 0;
        goto L14
    L15:
        Iterator r117 = r113.iterator();
        int r118 = 0;
        int r119 = 0;
    L17:
        if (r117.hasNext() == false) goto L22;
        Object r120 = r117.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        r118 = r118 | (((Number) r120).intValue() << r119);
        r119 = r121;
        goto L17
    L22:
        r16[r110] = Integer.valueOf(r118);
        r110 = r110 + 1;
        goto L3
    L23:
        Object[] r21 = new Object[r13];
    L24:
        if (r17 >= r13) goto L47;
        if (r17 < 0) goto L32;
        if (r17 >= r10) goto L32;
        if (r17 >= 0) goto L29;
    L31:
        Object r122 = ComposableMethodKt.access$getDefaultValue(this.method.getParameterTypes()[r17]);
    L43:
        r21[r17] = r122;
        r17 = r17 + 1;
        goto L24
    L29:
        if (r17 > ArraysKt.getLastIndex(r20)) goto L31;
        r122 = r20[r17];
    L32:
        if (r17 != r10) goto L34;
        r122 = r18;
        goto L43
    L34:
        if (r17 != r14) goto L37;
    L35:
        r122 = 0;
        goto L43
    L37:
        if ((r10 + 2) > r17) goto L40;
        if (r17 < r15) goto L35;
    L40:
        if (r15 > r17) goto L45;
        if (r17 >= r13) goto L45;
        r122 = r16[r17 - r15];
    L45:
        throw new IllegalStateException("Unexpected index");
    L47:
        return this.method.invoke(r19, Arrays.copyOf(r21, r13));
    }
}
