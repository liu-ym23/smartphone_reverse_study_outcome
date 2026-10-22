package com.google.common.util.concurrent;

import com.google.common.collect.Ordering;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
final class FuturesGetChecked {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Ordering<Constructor<?>> f4819a = null;

    static class GetCheckedTypeValidatorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f4820a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final a f4821b = null;

        static final enum ClassValueValidator extends Enum<ClassValueValidator> implements a {
            private static final /* synthetic */ ClassValueValidator[] $VALUES = null;
            public static final ClassValueValidator INSTANCE = null;
            private static final ClassValue<Boolean> isValidClass = null;

            private static /* synthetic */ ClassValueValidator[] $values() {
                return new ClassValueValidator[]{INSTANCE};
            }

            static {
                INSTANCE = new ClassValueValidator("INSTANCE", 0);
                $VALUES = $values();
                isValidClass = new AnonymousClass1();
            }

            private ClassValueValidator(String r1, int r2) {
                super(r1, r2);
            }

            public static ClassValueValidator valueOf(String r2) {
                return (ClassValueValidator) ZeusTransformUtils.preCheckCast(Enum.valueOf(ClassValueValidator.class, r2), ClassValueValidator.class, "com.obric.memorydata.plugin");
            }

            public static ClassValueValidator[] values() {
                return (ClassValueValidator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ClassValueValidator[].class, "com.obric.memorydata.plugin");
            }

            public void validateClass(Class<? extends Exception> r1) {
                isValidClass.get(r1);
            }
        }

        static final enum WeakSetValidator extends Enum<WeakSetValidator> implements a {
            private static final /* synthetic */ WeakSetValidator[] $VALUES = null;
            public static final WeakSetValidator INSTANCE = null;
            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = null;

            private static /* synthetic */ WeakSetValidator[] $values() {
                return new WeakSetValidator[]{INSTANCE};
            }

            static {
                INSTANCE = new WeakSetValidator("INSTANCE", 0);
                $VALUES = $values();
                validClasses = new CopyOnWriteArraySet();
            }

            private WeakSetValidator(String r1, int r2) {
                super(r1, r2);
            }

            public static WeakSetValidator valueOf(String r2) {
                return (WeakSetValidator) ZeusTransformUtils.preCheckCast(Enum.valueOf(WeakSetValidator.class, r2), WeakSetValidator.class, "com.obric.memorydata.plugin");
            }

            public static WeakSetValidator[] values() {
                return (WeakSetValidator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WeakSetValidator[].class, "com.obric.memorydata.plugin");
            }

            public void validateClass(Class<? extends Exception> r4) {
                Iterator<WeakReference<Class<? extends Exception>>> r3 = validClasses.iterator();
            L4:
                if (r3.hasNext() == false) goto L8;
                if (r4.equals(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get()) == false) goto L4;
                return;
            L8:
                FuturesGetChecked.b(r4);
                Set<WeakReference<Class<? extends Exception>>> r5 = validClasses;
                if (r5.size() <= 1000) goto L11;
                r5.clear();
            L11:
                r5.add(new WeakReference(r4));
            }
        }

        static {
            f4820a = GetCheckedTypeValidatorHolder.class.getName() + "$ClassValueValidator";
            f4821b = a();
        }

        GetCheckedTypeValidatorHolder() {
        }

        static a a() {
            return (a) ZeusTransformUtils.preCheckCast(((Enum[]) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(f4820a, "com.obric.memorydata.plugin").asSubclass(Enum.class).getEnumConstants(), Enum[].class, "com.obric.memorydata.plugin"))[0], a.class, "com.obric.memorydata.plugin");
        L6:
            return FuturesGetChecked.a();
        }
    }

    interface a {
    }

    static {
        f4819a = Ordering.natural().onResultOf($$Lambda$FuturesGetChecked$3cPLRxQ5v4gzXOsN_wwfhQcoYeI.INSTANCE).reverse();
    }

    static a a() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    private static /* synthetic */ Boolean a(Constructor r1) {
        return Boolean.valueOf(Arrays.asList(r1.getParameterTypes()).contains(String.class));
    }

    private static <X extends Exception> X a(Class<X> r4, Throwable r5) {
        Iterator r0 = a(Arrays.asList(r4.getConstructors())).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        X r1 = (X) ZeusTransformUtils.preCheckCast(a((Constructor) ZeusTransformUtils.preCheckCast(r0.next(), Constructor.class, "com.obric.memorydata.plugin"), r5), Exception.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        if (r1.getCause() != null) goto L10;
        r1.initCause(r5);
    L10:
        return r1;
    L12:
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + r4 + " in response to chained exception", r5);
    }

    private static <X> X a(Constructor<X> r6, Throwable r7) {
        Class<?>[] r0 = r6.getParameterTypes();
        Object[] r1 = new Object[r0.length];
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L16;
        Class<?> r3 = r0[r2];
        if (r3.equals(String.class) == false) goto L9;
        r1[r2] = r7.toString();
    L11:
        r2 = r2 + 1;
        goto L4
    L9:
        if (r3.equals(Throwable.class) == false) goto L12;
        r1[r2] = r7;
        goto L11
    L12:
        return null;
    L16:
        return r6.newInstance(r1);
    L15:
        return null;
    }

    private static <X extends Exception> List<Constructor<X>> a(List<Constructor<X>> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return (List<Constructor<X>>) f4819a.sortedCopy(r3);
    }

    static boolean a(Class<? extends Exception> r1) {
        return !RuntimeException.class.isAssignableFrom(r1);
    }

    static void b(Class<? extends Exception> r2) {
        com.google.common.base.n.a(a(r2), "Futures.getChecked exception type (%s) must not be a RuntimeException", r2);
        com.google.common.base.n.a(c(r2), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", r2);
    }

    private static boolean c(Class<? extends Exception> r1) {
        a(r1, new Exception());     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ Boolean lambda$3cPLRxQ5v4gzXOsN_wwfhQcoYeI(Constructor r0) {
        return a(r0);
    }
}
