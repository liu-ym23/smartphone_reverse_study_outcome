package kotlin.jvm.internal;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: loaded from: classes3.dex */
public class Intrinsics {

    @SinceKotlin(version = "1.4")
    public static class Kotlin {
        private Kotlin() {
        }
    }

    private Intrinsics() {
    }

    public static boolean areEqual(Object r5, Object r10) {
        if (r5 != null) goto L7;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r5.equals(r10);
    }

    public static void checkExpressionValueIsNotNull(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(j0.j(r10, " must not be null"))));
    }

    public static void checkFieldIsNotNull(Object r5, String r10, String r11) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(a.p("Field specified as non-null is null: ", r10, ".", r11))));
    }

    public static void checkHasClass(String r5) throws ClassNotFoundException {
        String r10 = r5.replace('/', '.');
        Class.forName(r10);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException(j0.k("Class ", r10, " is not found. Please update the Kotlin runtime to the latest version"), e)));
    }

    public static void checkNotNull(Object r5) {
        if (r5 != null) goto L5;
        throwJavaNpe();
        return;
    }

    public static void checkNotNullExpressionValue(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(j0.j(r10, " must not be null"))));
    }

    public static void checkNotNullParameter(Object r5, String r10) {
        if (r5 != null) goto L5;
        throwParameterIsNullNPE(r10);
        return;
    }

    public static void checkParameterIsNotNull(Object r5, String r10) {
        if (r5 != null) goto L5;
        throwParameterIsNullIAE(r10);
        return;
    }

    public static void checkReturnedValueIsNotNull(Object r5, String r10, String r11) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(a.p("Method specified as non-null returned null: ", r10, ".", r11))));
    }

    public static int compare(int r5, int r10) {
        if (r5 >= r10) goto L4;
        return -1;
    L4:
        if (r5 != r10) goto L6;
        return 0;
    L6:
        return 1;
    }

    private static String createParameterIsNullExceptionMessage(String r5) {
        StackTraceElement[] r10 = Thread.currentThread().getStackTrace();
        String r11 = Intrinsics.class.getName();
        int r12 = 0;
    L4:
        if (r10[r12].getClassName().equals(r11) == true) goto L7;
        r12 = r12 + 1;
    L7:
        if (r10[r12].getClassName().equals(r11) == false) goto L9;
        r12 = r12 + 1;
        goto L7
    L9:
        StackTraceElement r13 = r10[r12];
        StringBuilder r14 = a.y("Parameter specified as non-null is null: method ", r13.getClassName(), ".", r13.getMethodName(), ", parameter ");
        r14.append(r5);
        return r14.toString();
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int r5, String r10) {
        throwUndefinedForReified();
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r5) {
        return (T) sanitizeStackTrace(r5, Intrinsics.class.getName());
    }

    public static String stringPlus(String r5, Object r10) {
        return r5 + r10;
    }

    public static void throwAssert() {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError()));
    }

    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException()));
    }

    public static void throwIllegalState() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException()));
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    private static void throwParameterIsNullIAE(String r5) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(r5))));
    }

    private static void throwParameterIsNullNPE(String r5) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(r5))));
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedProperty(String r5) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(r5)));
    }

    public static void throwUninitializedPropertyAccessException(String r5) {
        throwUninitializedProperty("lateinit property " + r5 + " has not been initialized");
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double r5, Double r10) {
        if (r5 != null) goto L6;
        if (r10 == null) goto L11;
        return false;
    L11:
        return true;
    L6:
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r5.doubleValue() == r10.doubleValue()) goto L11;
        return false;
    }

    public static void checkNotNull(Object r5, String r10) {
        if (r5 != null) goto L5;
        throwJavaNpe(r10);
        return;
    }

    public static int compare(long r5, long r10) {
        if (r5 >= r10) goto L5;
        return -1;
    L5:
        if (r5 != r10) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static void needClassReification(String r5) {
        throwUndefinedForReified(r5);
    }

    public static void reifiedOperationMarker(int r5, String r10, String r11) {
        throwUndefinedForReified(r11);
    }

    public static <T extends Throwable> T sanitizeStackTrace(T r5, String r10) {
        StackTraceElement[] r11 = r5.getStackTrace();
        int r12 = r11.length;
        int r13 = -1;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L8;
        if (r10.equals(r11[r14].getClassName()) == false) goto L7;
        r13 = r14;
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r11, r13 + 1, r12));
        return r5;
    }

    public static void throwAssert(String r5) {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r5)));
    }

    public static void throwIllegalArgument(String r5) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(r5)));
    }

    public static void throwIllegalState(String r5) {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r5)));
    }

    @SinceKotlin(version = "1.4")
    public static void throwJavaNpe(String r5) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(r5)));
    }

    public static void throwNpe(String r5) {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException(r5)));
    }

    public static void throwUndefinedForReified(String r5) {
        throw new UnsupportedOperationException(r5);
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Double r5, double r10) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.doubleValue() != r10) goto L6;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(double r5, Double r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5 != r10.doubleValue()) goto L6;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float r5, Float r10) {
        if (r5 != null) goto L6;
        if (r10 == null) goto L11;
        return false;
    L11:
        return true;
    L6:
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r5.floatValue() == r10.floatValue()) goto L11;
        return false;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(Float r5, float r10) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.floatValue() != r10) goto L6;
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static boolean areEqual(float r5, Float r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5 != r10.floatValue()) goto L6;
        return true;
    }

    public static void checkFieldIsNotNull(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r10)));
    }

    public static void checkReturnedValueIsNotNull(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r10)));
    }

    public static void checkHasClass(String r5, String r10) throws ClassNotFoundException {
        String r11 = r5.replace('/', '.');
        Class.forName(r11);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException(a.p("Class ", r11, " is not found: this code requires the Kotlin runtime of version at least ", r10), e)));
    }
}
