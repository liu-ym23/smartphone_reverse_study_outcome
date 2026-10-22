package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: loaded from: classes2.dex */
public class Intrinsics {

    @SinceKotlin(version = "1.4")
    public static class Kotlin {
        private Kotlin() {
        }
    }

    private Intrinsics() {
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(double r10, Double r11) {
        if (r11 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10 != r11.doubleValue()) goto L6;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(float r10, Float r11) {
        if (r11 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10 != r11.floatValue()) goto L6;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double r10, double r11) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.doubleValue() != r11) goto L6;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double r10, Double r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L11;
        return true;
    L11:
        return false;
    L6:
        if (r11 == null) goto L11;
        if (r10.doubleValue() != r11.doubleValue()) goto L11;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float r10, float r11) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.floatValue() != r11) goto L6;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float r10, Float r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L11;
        return true;
    L11:
        return false;
    L6:
        if (r11 == null) goto L11;
        if (r10.floatValue() != r11.floatValue()) goto L11;
        return true;
    }

    public static boolean areEqual(Object r10, Object r11) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r10.equals(r11);
    }

    public static void checkExpressionValueIsNotNull(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r11 + " must not be null")));
    }

    public static void checkFieldIsNotNull(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r11)));
    }

    public static void checkFieldIsNotNull(Object r10, String r11, String r12) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Field specified as non-null is null: " + r11 + "." + r12)));
    }

    public static void checkHasClass(String r10) {
        String r11 = r10.replace('/', '.');
        Class.forName(r11);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + r11 + " is not found. Please update the Kotlin runtime to the latest version", e)));
    }

    public static void checkHasClass(String r10, String r11) {
        String r12 = r10.replace('/', '.');
        Class.forName(r12);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + r12 + " is not found: this code requires the Kotlin runtime of version at least " + r11, e)));
    }

    public static void checkNotNull(Object r10) {
        if (r10 != null) goto L5;
        throwJavaNpe();
        return;
    }

    public static void checkNotNull(Object r10, String r11) {
        if (r10 != null) goto L5;
        throwJavaNpe(r11);
        return;
    }

    public static void checkNotNullExpressionValue(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(r11 + " must not be null")));
    }

    public static void checkNotNullParameter(Object r10, String r11) {
        if (r10 != null) goto L5;
        throwParameterIsNullNPE(r11);
        return;
    }

    public static void checkParameterIsNotNull(Object r10, String r11) {
        if (r10 != null) goto L5;
        throwParameterIsNullIAE(r11);
        return;
    }

    public static void checkReturnedValueIsNotNull(Object r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r11)));
    }

    public static void checkReturnedValueIsNotNull(Object r10, String r11, String r12) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Method specified as non-null returned null: " + r11 + "." + r12)));
    }

    public static int compare(int r10, int r11) {
        if (r10 >= r11) goto L4;
        return -1;
    L4:
        if (r10 != r11) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static int compare(long r10, long r11) {
        if (r10 >= r11) goto L5;
        return -1;
    L5:
        if (r10 != r11) goto L7;
        return 0;
    L7:
        return 1;
    }

    private static String createParameterIsNullExceptionMessage(String r10) {
        StackTraceElement[] r11 = Thread.currentThread().getStackTrace();
        String r12 = Intrinsics.class.getName();
        int r13 = 0;
    L4:
        if (r11[r13].getClassName().equals(r12) == true) goto L7;
        r13 = r13 + 1;
    L7:
        if (r11[r13].getClassName().equals(r12) == false) goto L9;
        r13 = r13 + 1;
        goto L7
    L9:
        StackTraceElement r14 = r11[r13];
        return "Parameter specified as non-null is null: method " + r14.getClassName() + "." + r14.getMethodName() + ", parameter " + r10;
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void needClassReification(String r10) {
        throwUndefinedForReified(r10);
    }

    public static void reifiedOperationMarker(int r10, String r11) {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int r10, String r11, String r12) {
        throwUndefinedForReified(r12);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r10) {
        return (T) sanitizeStackTrace(r10, Intrinsics.class.getName());
    }

    static <T extends Throwable> T sanitizeStackTrace(T r10, String r11) {
        StackTraceElement[] r12 = r10.getStackTrace();
        int r13 = r12.length;
        int r14 = -1;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L8;
        if (r11.equals(r12[r15].getClassName()) == false) goto L7;
        r14 = r15;
    L7:
        r15 = r15 + 1;
        goto L3
    L8:
        r10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r12, r14 + 1, r13));
        return r10;
    }

    public static String stringPlus(String r10, Object r11) {
        return r10 + r11;
    }

    public static void throwAssert() {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError()));
    }

    public static void throwAssert(String r10) {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r10)));
    }

    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException()));
    }

    public static void throwIllegalArgument(String r10) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(r10)));
    }

    public static void throwIllegalState() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException()));
    }

    public static void throwIllegalState(String r10) {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r10)));
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe(String r10) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(r10)));
    }

    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    public static void throwNpe(String r10) {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException(r10)));
    }

    private static void throwParameterIsNullIAE(String r10) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(r10))));
    }

    private static void throwParameterIsNullNPE(String r10) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(r10))));
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(String r10) {
        throw new UnsupportedOperationException(r10);
    }

    public static void throwUninitializedProperty(String r10) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(r10)));
    }

    public static void throwUninitializedPropertyAccessException(String r10) {
        throwUninitializedProperty("lateinit property " + r10 + " has not been initialized");
    }
}
