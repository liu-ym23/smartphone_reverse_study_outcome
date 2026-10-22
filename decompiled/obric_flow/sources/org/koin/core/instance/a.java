package org.koin.core.instance;

import com.lynx.jsbridge.LynxResourceModule;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final Object[] a(Constructor r10, org.koin.core.scope.a r11, final vu.a r12) {
        int r5 = r10.getParameterTypes().length;
        int r13 = 0;
        if (r5 == 0) goto L24;
        Object[] r14 = new Object[r5];
        int r15 = 0;
    L6:
        if (r15 >= r5) goto L8;
        r14[r15] = Unit.INSTANCE;
        r15 = r15 + 1;
    L8:
        if (r13 >= r5) goto L18;
        Class<?> r16 = r10.getParameterTypes()[r13];
        Intrinsics.checkNotNull(r16);
        KClass r17 = JvmClassMappingKt.getKotlinClass(r16);
        Object r18 = r11.c(new InstanceBuilderKt$getArguments$1(r12), r17, null);
        if (r18 != null) goto L16;
        r18 = r12.b(r17);
        if (r18 != null) goto L16;
        throw new NoBeanDefFoundException("No definition found for class '" + r17 + '\'');
    L16:
        r14[r13] = r18;
        r13 = r13 + 1;
        goto L8
    L18:
        return r14;
    L24:
        return new Object[0];
    }

    public static final Object b(org.koin.core.scope.a r10, KClass r11, vu.a r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "kClass");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        um.a r5 = r10.d.f21001c;
        Level r13 = (Level) r5.f22372b;
        Level r14 = Level.DEBUG;
        if (r13 != r14) goto L5;
        r5.o("|- creating new instance - ".concat(yu.a.a(r11)));
    L5:
        Constructor r15 = (Constructor) ArraysKt.firstOrNull(JvmClassMappingKt.getJavaClass(r11).getConstructors());
        if (r15 == null) goto L26;
        org.koin.core.a r16 = r10.d;
        if (((Level) r16.f21001c.f22372b) != r14) goto L10;
        Pair r17 = new Pair(a(r15, r10, r12), Double.valueOf((System.nanoTime() - System.nanoTime()) / 1000000.0d));
        Pair r18 = new Pair(r17.component1(), Double.valueOf(((Number) r17.component2()).doubleValue()));
        Object[] r19 = (Object[]) r18.component1();
        double r20 = ((Number) r18.component2()).doubleValue();
        r16.f21001c.o("|- got arguments in " + r20 + " ms");
    L12:
        if (((Level) r16.f21001c.f22372b) != r14) goto L19;
        long r21 = System.nanoTime();
        if (r19.length != 0) goto L16;
        Object r110 = r15.newInstance(null);
    L17:
        Intrinsics.checkNotNull(r110);
        Pair r111 = new Pair(r110, Double.valueOf((System.nanoTime() - r21) / 1000000.0d));
        Pair r112 = new Pair(r111.component1(), Double.valueOf(((Number) r111.component2()).doubleValue()));
        Object r113 = r112.component1();
        double r22 = ((Number) r112.component2()).doubleValue();
        r16.f21001c.o("|- created instance in " + r22 + " ms");
    L23:
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type T of org.koin.core.instance.InstanceBuilderKt.newInstance");
        return r113;
    L16:
        r110 = r15.newInstance(Arrays.copyOf(r19, r19.length));
        goto L17
    L19:
        if (r19.length != 0) goto L21;
        r113 = r15.newInstance(null);
    L22:
        Intrinsics.checkNotNull(r113);
        goto L23
    L21:
        r113 = r15.newInstance(Arrays.copyOf(r19, r19.length));
        goto L22
    L10:
        r19 = a(r15, r10, r12);
        goto L12
    L26:
        throw new IllegalStateException(("No constructor found for class '" + yu.a.a(r11) + '\'').toString());
    }
}
