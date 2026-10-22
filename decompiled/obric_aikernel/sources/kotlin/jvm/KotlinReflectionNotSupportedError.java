package kotlin.jvm;

/* JADX INFO: loaded from: classes2.dex */
public class KotlinReflectionNotSupportedError extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(String r10) {
        super(r10);
    }

    public KotlinReflectionNotSupportedError(String r10, Throwable r11) {
        super(r10, r11);
    }

    public KotlinReflectionNotSupportedError(Throwable r10) {
        super(r10);
    }
}
