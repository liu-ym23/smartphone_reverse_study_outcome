package androidx.room.compiler.processing.javac.kotlin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\f\u0010\n\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u000b\u001a\u00020\f*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/JvmAbi;", "", "()V", "GET_PREFIX", "", "IS_PREFIX", "SET_PREFIX", "computeGetterName", "propertyName", "computeSetterName", "capitalizeAsciiOnly", "startsWithIsPrefix", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmAbi {
    private static final String GET_PREFIX = "get";
    public static final JvmAbi INSTANCE = null;
    private static final String IS_PREFIX = "is";
    private static final String SET_PREFIX = "set";

    static {
        INSTANCE = new JvmAbi();
    }

    private JvmAbi() {
    }

    private final String capitalizeAsciiOnly(String r5) {
        if (r5.length() != 0) goto L5;
        return r5;
    L5:
        char r10 = r5.charAt(0);
        if ('a' <= r10) goto L8;
        return r5;
    L8:
        if (r10 < '{') goto L10;
        return r5;
    L10:
        return Character.toUpperCase(r10) + r5.substring(1);
    }

    private final boolean startsWithIsPrefix(String r5) {
        if (StringsKt.P(r5, IS_PREFIX) == true) goto L6;
        return false;
    L6:
        if (r5.length() != 2) goto L8;
        return false;
    L8:
        char r10 = r5.charAt(2);
        if (Intrinsics.compare(97, r10) <= 0) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.compare(r10, 122) > 0) goto L12;
        return false;
    }

    public final String computeGetterName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "propertyName");
        if (startsWithIsPrefix(r5) == false) goto L6;
        return r5;
    L6:
        return GET_PREFIX + capitalizeAsciiOnly(r5);
    }

    public final String computeSetterName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "propertyName");
        StringBuilder r10 = new StringBuilder(SET_PREFIX);
        if (startsWithIsPrefix(r5) == false) goto L5;
        String r11 = r5.substring(2);
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r11 = capitalizeAsciiOnly(r5);
        goto L6
    }
}
