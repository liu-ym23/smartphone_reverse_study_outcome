package com.google.gson.internal.reflect;

import ai.j0;
import com.google.gson.JsonIOException;
import com.google.gson.internal.TroubleshootingGuide;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionHelper {
    private static final RecordHelper RECORD_HELPER = null;

    /* JADX INFO: renamed from: com.google.gson.internal.reflect.ReflectionHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class RecordHelper {
        private RecordHelper() {
        }

        public abstract Method getAccessor(Class<?> r5, Field r10);

        public abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r5);

        public abstract String[] getRecordComponentNames(Class<?> r5);

        public abstract boolean isRecord(Class<?> r5);

        public /* synthetic */ RecordHelper(AnonymousClass1 r5) {
            this();
        }
    }

    public static class RecordNotSupportedHelper extends RecordHelper {
        private RecordNotSupportedHelper() {
            super(null);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r5, Field r10) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r5) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public String[] getRecordComponentNames(Class<?> r5) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public boolean isRecord(Class<?> r5) {
            return false;
        }

        public /* synthetic */ RecordNotSupportedHelper(AnonymousClass1 r5) {
            this();
        }
    }

    public static class RecordSupportedHelper extends RecordHelper {
        private final Method getName;
        private final Method getRecordComponents;
        private final Method getType;
        private final Method isRecord;

        public /* synthetic */ RecordSupportedHelper(AnonymousClass1 r5) throws NoSuchMethodException, ClassNotFoundException {
            this();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r5, Field r10) {
            return r5.getMethod(r10.getName(), null);
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r10) {
            Object[] r5 = (Object[]) this.getRecordComponents.invoke(r10, null);     // Catch: ReflectiveOperationException -> L6
            Class<?>[] r11 = new Class[r5.length];     // Catch: ReflectiveOperationException -> L6
            int r12 = 0;
        L4:
            if (r12 >= r5.length) goto L8;
            r11[r12] = (Class) this.getType.invoke(r5[r12], null);     // Catch: ReflectiveOperationException -> L6
            r12 = r12 + 1;     // Catch: ReflectiveOperationException -> L6
            goto L4
        L8:
            return r10.getDeclaredConstructor(r11);
        L6:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public String[] getRecordComponentNames(Class<?> r10) {
            Object[] r11 = (Object[]) this.getRecordComponents.invoke(r10, null);     // Catch: ReflectiveOperationException -> L7
            String[] r5 = new String[r11.length];     // Catch: ReflectiveOperationException -> L7
            int r12 = 0;
        L4:
            if (r12 >= r11.length) goto L9;
            r5[r12] = (String) this.getName.invoke(r11[r12], null);     // Catch: ReflectiveOperationException -> L7
            r12 = r12 + 1;
            goto L4
        L9:
            return r5;
        L7:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public boolean isRecord(Class<?> r5) {
            return ((Boolean) this.isRecord.invoke(r5, null)).booleanValue();
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        private RecordSupportedHelper() throws NoSuchMethodException, ClassNotFoundException {
            super(null);
            this.isRecord = Class.class.getMethod("isRecord", null);
            this.getRecordComponents = Class.class.getMethod("getRecordComponents", null);
            Class<?> r5 = Class.forName("java.lang.reflect.RecordComponent");
            this.getName = r5.getMethod("getName", null);
            this.getType = r5.getMethod("getType", null);
        }
    }

    static {
        AnonymousClass1 r5 = null;
        RecordHelper r10 = new RecordSupportedHelper(r5);     // Catch: ReflectiveOperationException -> L5
    L6:
        RECORD_HELPER = r10;
        return;
    L5:
        r10 = new RecordNotSupportedHelper(r5);
        goto L6
    }

    private ReflectionHelper() {
    }

    public static /* synthetic */ RuntimeException access$300(ReflectiveOperationException r5) {
        return createExceptionForRecordReflectionException(r5);
    }

    private static void appendExecutableParameters(AccessibleObject r5, StringBuilder r10) {
        r10.append('(');
        if ((r5 instanceof Method) == false) goto L5;
        Class<?>[] r11 = ((Method) r5).getParameterTypes();
    L6:
        int r12 = 0;
    L8:
        if (r12 >= r11.length) goto L12;
        if (r12 <= 0) goto L11;
        r10.append(", ");
    L11:
        r10.append(r11[r12].getSimpleName());
        r12 = r12 + 1;
        goto L8
    L12:
        r10.append(')');
        return;
    L5:
        r11 = ((Constructor) r5).getParameterTypes();
        goto L6
    }

    public static String constructorToString(Constructor<?> r5) {
        StringBuilder r10 = new StringBuilder(r5.getDeclaringClass().getName());
        appendExecutableParameters(r5, r10);
        return r10.toString();
    }

    private static RuntimeException createExceptionForRecordReflectionException(ReflectiveOperationException r5) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.14.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", r5);
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException r5) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.14.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", r5);
    }

    public static String fieldToString(Field r5) {
        return r5.getDeclaringClass().getName() + "#" + r5.getName();
    }

    public static String getAccessibleObjectDescription(AccessibleObject r5, boolean r10) {
        if ((r5 instanceof Field) == false) goto L6;
        String r11 = "field '" + fieldToString((Field) r5) + "'";
    L12:
        if (r10 == true) goto L14;
        return r11;
    L14:
        if (Character.isLowerCase(r11.charAt(0)) == true) goto L16;
        return r11;
    L16:
        return Character.toUpperCase(r11.charAt(0)) + r11.substring(1);
    L6:
        if ((r5 instanceof Method) == false) goto L9;
        Method r12 = (Method) r5;
        StringBuilder r13 = new StringBuilder(r12.getName());
        appendExecutableParameters(r12, r13);
        r11 = "method '" + r12.getDeclaringClass().getName() + "#" + r13.toString() + "'";
        goto L12
    L9:
        if ((r5 instanceof Constructor) == false) goto L11;
        r11 = "constructor '" + constructorToString((Constructor) r5) + "'";
        goto L12
    L11:
        r11 = "<unknown AccessibleObject> " + r5.toString();
        goto L12
    }

    public static Method getAccessor(Class<?> r5, Field r10) {
        return RECORD_HELPER.getAccessor(r5, r10);
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r5) {
        return RECORD_HELPER.getCanonicalRecordConstructor(r5);
    }

    private static String getInaccessibleTroubleshootingSuffix(Exception r5) {
        if (r5.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException") == false) goto L12;
        String r10 = r5.getMessage();
        if (r10 != null) goto L7;
    L9:
        String r11 = "reflection-inaccessible";
    L11:
        return "\nSee " + TroubleshootingGuide.createUrl(r11);
    L7:
        if (r10.contains("to module com.google.gson") == false) goto L9;
        r11 = "reflection-inaccessible-to-module-gson";
        goto L11
    L12:
        return "";
    }

    public static String[] getRecordComponentNames(Class<?> r5) {
        return RECORD_HELPER.getRecordComponentNames(r5);
    }

    public static boolean isAnonymousOrNonStaticLocal(Class<?> r5) {
        if (isStatic(r5) == false) goto L5;
    L9:
        return false;
    L5:
        if (r5.isAnonymousClass() == false) goto L7;
    L8:
        return true;
    L7:
        if (r5.isLocalClass() == false) goto L9;
        goto L8
    }

    public static boolean isRecord(Class<?> r5) {
        return RECORD_HELPER.isRecord(r5);
    }

    public static boolean isStatic(Class<?> r5) {
        return Modifier.isStatic(r5.getModifiers());
    }

    public static void makeAccessible(AccessibleObject r5) throws JsonIOException {
        r5.setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        StringBuilder r10 = j0.x("Failed making ", getAccessibleObjectDescription(r5, false), " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.");
        r10.append(getInaccessibleTroubleshootingSuffix(e));
        throw new JsonIOException(r10.toString(), e);
    }

    public static String tryMakeAccessible(Constructor<?> r5) {
        r5.setAccessible(true);     // Catch: Exception -> L6
        return null;
    L6:
        e = move-exception;
        return "Failed making constructor '" + constructorToString(r5) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage() + getInaccessibleTroubleshootingSuffix(e);
    }
}
