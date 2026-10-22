package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionHelper {
    private static final RecordHelper RECORD_HELPER = null;

    /* JADX INFO: renamed from: com.google.gson.internal.reflect.ReflectionHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class RecordHelper {
        private RecordHelper() {
        }

        /* synthetic */ RecordHelper(AnonymousClass1 r1) {
            this();
        }

        public abstract Method getAccessor(Class<?> r1, Field r2);

        abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r1);

        abstract String[] getRecordComponentNames(Class<?> r1);

        abstract boolean isRecord(Class<?> r1);
    }

    private static class RecordNotSupportedHelper extends RecordHelper {
        private RecordNotSupportedHelper() {
            super(null);
        }

        /* synthetic */ RecordNotSupportedHelper(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r1, Field r2) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r1) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] getRecordComponentNames(Class<?> r1) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean isRecord(Class<?> r1) {
            return false;
        }
    }

    private static class RecordSupportedHelper extends RecordHelper {
        private final Method getName;
        private final Method getRecordComponents;
        private final Method getType;
        private final Method isRecord;

        private RecordSupportedHelper() {
            super(null);
            this.isRecord = Class.class.getMethod("isRecord", new Class[0]);
            Method r0 = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.getRecordComponents = r0;
            Class<?> r1 = r0.getReturnType().getComponentType();
            this.getName = r1.getMethod("getName", new Class[0]);
            this.getType = r1.getMethod("getType", new Class[0]);
        }

        /* synthetic */ RecordSupportedHelper(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r1, Field r2) {
            return r1.getMethod(r2.getName(), new Class[0]);
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r9) {
            Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(this.getRecordComponents.invoke(r9, new Object[0]), Object[].class, "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L9
            Class<?>[] r3 = new Class[r1.length];     // Catch: ReflectiveOperationException -> L9
            int r4 = 0;
        L5:
            if (r4 >= r1.length) goto L7;
            r3[r4] = (Class) ZeusTransformUtils.preCheckCast(this.getType.invoke(r1[r4], new Object[0]), Class.class, "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L9
            r4 = r4 + 1;     // Catch: ReflectiveOperationException -> L9
            goto L5
        L7:
            return r9.getDeclaredConstructor(r3);
        L9:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] getRecordComponentNames(Class<?> r8) {
            Object[] r9 = (Object[]) ZeusTransformUtils.preCheckCast(this.getRecordComponents.invoke(r8, new Object[0]), Object[].class, "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L9
            String[] r1 = new String[r9.length];     // Catch: ReflectiveOperationException -> L9
            int r3 = 0;
        L5:
            if (r3 >= r9.length) goto L8;
            r1[r3] = (String) ZeusTransformUtils.preCheckCast(this.getName.invoke(r9[r3], new Object[0]), String.class, "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L9
            r3 = r3 + 1;
            goto L5
        L8:
            return r1;
        L9:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean isRecord(Class<?> r2) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.isRecord.invoke(r2, new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }
    }

    static {
        AnonymousClass1 r0 = null;
        RecordHelper r1 = new RecordSupportedHelper(r0);     // Catch: NoSuchMethodException -> L5
    L6:
        RECORD_HELPER = r1;
        return;
    L5:
        r1 = new RecordNotSupportedHelper(r0);
        goto L6
    }

    private ReflectionHelper() {
    }

    static /* synthetic */ RuntimeException access$300(ReflectiveOperationException r0) {
        return createExceptionForRecordReflectionException(r0);
    }

    private static void appendExecutableParameters(AccessibleObject r2, StringBuilder r3) {
        r3.append('(');
        if (ZeusTransformUtils.instanceOf(r2, Method.class) == false) goto L5;
        Class<?>[] r4 = ((Method) ZeusTransformUtils.preCheckCast(r2, Method.class, "com.obric.memorydata.plugin")).getParameterTypes();
    L6:
        int r0 = 0;
    L8:
        if (r0 >= r4.length) goto L12;
        if (r0 <= 0) goto L11;
        r3.append(", ");
    L11:
        r3.append(r4[r0].getSimpleName());
        r0 = r0 + 1;
        goto L8
    L12:
        r3.append(')');
        return;
    L5:
        r4 = ((Constructor) ZeusTransformUtils.preCheckCast(r2, Constructor.class, "com.obric.memorydata.plugin")).getParameterTypes();
        goto L6
    }

    public static String constructorToString(Constructor<?> r2) {
        StringBuilder r0 = new StringBuilder(r2.getDeclaringClass().getName());
        appendExecutableParameters(r2, r0);
        return r0.toString();
    }

    private static RuntimeException createExceptionForRecordReflectionException(ReflectiveOperationException r2) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", r2);
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException r2) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", r2);
    }

    public static String fieldToString(Field r2) {
        return r2.getDeclaringClass().getName() + "#" + r2.getName();
    }

    public static String getAccessibleObjectDescription(AccessibleObject r4, boolean r5) {
        if (ZeusTransformUtils.instanceOf(r4, Field.class) == false) goto L9;
        StringBuilder r0 = new StringBuilder().append("field '");
        String r6 = fieldToString((Field) ZeusTransformUtils.preCheckCast(r4, Field.class, "com.obric.memorydata.plugin"));
    L5:
        StringBuilder r7 = r0.append(r6);
    L6:
        StringBuilder r8 = r7.append("'");
    L7:
        String r9 = r8.toString();
        if (r5 == true) goto L17;
        return r9;
    L17:
        if (Character.isLowerCase(r9.charAt(0)) == true) goto L19;
        return r9;
    L19:
        return Character.toUpperCase(r9.charAt(0)) + r9.substring(1);
    L9:
        if (ZeusTransformUtils.instanceOf(r4, Method.class) == false) goto L12;
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(r4, Method.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder(r10.getName());
        appendExecutableParameters(r10, r1);
        r7 = new StringBuilder().append("method '").append(r10.getDeclaringClass().getName()).append("#").append(r1.toString());
        goto L6
    L12:
        if (ZeusTransformUtils.instanceOf(r4, Constructor.class) == false) goto L14;
        r0 = new StringBuilder().append("constructor '");
        r6 = constructorToString((Constructor) ZeusTransformUtils.preCheckCast(r4, Constructor.class, "com.obric.memorydata.plugin"));
        goto L5
    L14:
        r8 = new StringBuilder().append("<unknown AccessibleObject> ").append(r4.toString());
        goto L7
    }

    public static Method getAccessor(Class<?> r1, Field r2) {
        return RECORD_HELPER.getAccessor(r1, r2);
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r1) {
        return RECORD_HELPER.getCanonicalRecordConstructor(r1);
    }

    public static String[] getRecordComponentNames(Class<?> r1) {
        return RECORD_HELPER.getRecordComponentNames(r1);
    }

    public static boolean isRecord(Class<?> r1) {
        return RECORD_HELPER.isRecord(r1);
    }

    public static void makeAccessible(AccessibleObject r4) {
        r4.setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new JsonIOException("Failed making " + getAccessibleObjectDescription(r4, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e);
    }

    public static String tryMakeAccessible(Constructor<?> r3) {
        r3.setAccessible(true);     // Catch: Exception -> L6
        return null;
    L6:
        e = move-exception;
        return "Failed making constructor '" + constructorToString(r3) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
    }
}
