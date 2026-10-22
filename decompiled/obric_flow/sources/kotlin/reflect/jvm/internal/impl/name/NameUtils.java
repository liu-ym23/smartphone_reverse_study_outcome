package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class NameUtils {
    public static final NameUtils INSTANCE = null;
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = null;

    static {
        INSTANCE = new NameUtils();
        SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");
    }

    private NameUtils() {
    }

    @JvmStatic
    public static final Name contextReceiverName(int r5) {
        return Name.identifier("_context_receiver_" + r5);
    }

    @JvmStatic
    public static final String sanitizeAsJavaIdentifier(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(r5, "_");
    }
}
