package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Charsets {
    public static final Charsets INSTANCE = null;

    @JvmField
    public static final Charset ISO_8859_1 = null;

    @JvmField
    public static final Charset US_ASCII = null;

    @JvmField
    public static final Charset UTF_16 = null;

    @JvmField
    public static final Charset UTF_16BE = null;

    @JvmField
    public static final Charset UTF_16LE = null;

    @JvmField
    public static final Charset UTF_8 = null;
    private static volatile Charset utf_32;
    private static volatile Charset utf_32be;
    private static volatile Charset utf_32le;

    static {
        INSTANCE = new Charsets();
        Charset r10 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(r10, "forName(\"UTF-8\")");
        UTF_8 = r10;
        Charset r11 = Charset.forName("UTF-16");
        Intrinsics.checkNotNullExpressionValue(r11, "forName(\"UTF-16\")");
        UTF_16 = r11;
        Charset r12 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(r12, "forName(\"UTF-16BE\")");
        UTF_16BE = r12;
        Charset r13 = Charset.forName("UTF-16LE");
        Intrinsics.checkNotNullExpressionValue(r13, "forName(\"UTF-16LE\")");
        UTF_16LE = r13;
        Charset r14 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(r14, "forName(\"US-ASCII\")");
        US_ASCII = r14;
        Charset r15 = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(r15, "forName(\"ISO-8859-1\")");
        ISO_8859_1 = r15;
    }

    private Charsets() {
    }

    @JvmName(name = "UTF32")
    public final Charset UTF32() {
        Charset r10 = utf_32;
        if (r10 != null) goto L6;
        Charset r11 = Charset.forName("UTF-32");
        Intrinsics.checkNotNullExpressionValue(r11, "forName(\"UTF-32\")");
        utf_32 = r11;
        return r11;
    L6:
        return r10;
    }

    @JvmName(name = "UTF32_BE")
    public final Charset UTF32_BE() {
        Charset r10 = utf_32be;
        if (r10 != null) goto L6;
        Charset r11 = Charset.forName("UTF-32BE");
        Intrinsics.checkNotNullExpressionValue(r11, "forName(\"UTF-32BE\")");
        utf_32be = r11;
        return r11;
    L6:
        return r10;
    }

    @JvmName(name = "UTF32_LE")
    public final Charset UTF32_LE() {
        Charset r10 = utf_32le;
        if (r10 != null) goto L6;
        Charset r11 = Charset.forName("UTF-32LE");
        Intrinsics.checkNotNullExpressionValue(r11, "forName(\"UTF-32LE\")");
        utf_32le = r11;
        return r11;
    L6:
        return r10;
    }
}
