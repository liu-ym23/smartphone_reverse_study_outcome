package okhttp3;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class MediaType {
    private static final Pattern PARAMETER = null;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = null;

    @Nullable
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    @Nullable
    public Charset charset() {
        return charset(null);
    }

    static {
        TYPE_SUBTYPE = PatternProtector.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = PatternProtector.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public String type() {
        return this.type;
    }

    public static MediaType get(String r11) {
        Matcher r0 = TYPE_SUBTYPE.matcher(r11);
        if (r0.lookingAt() == false) goto L37;
        String r3 = r0.group(1);
        Locale r4 = Locale.US;
        String r5 = r3.toLowerCase(r4);
        String r6 = r0.group(2).toLowerCase(r4);
        Matcher r7 = PARAMETER.matcher(r11);
        int r1 = r0.end();
        String r8 = null;
    L6:
        if (r1 >= r11.length()) goto L35;
        r7.region(r1, r11.length());
        if (r7.lookingAt() == false) goto L33;
        String r2 = r7.group(1);
        if (r2 == null) goto L31;
        if (r2.equalsIgnoreCase("charset") == false) goto L31;
        String r9 = r7.group(2);
        if (r9 != null) goto L17;
        r9 = r7.group(3);
    L24:
        if (r8 != null) goto L26;
    L30:
        r8 = r9;
        goto L31
    L26:
        if (r9.equalsIgnoreCase(r8) == true) goto L30;
        throw new IllegalArgumentException("Multiple charsets defined: \"" + r8 + "\" and: \"" + r9 + "\" for: \"" + r11 + '\"');
    L17:
        if (r9.startsWith("'") == false) goto L24;
        if (r9.endsWith("'") == false) goto L24;
        if (r9.length() <= 2) goto L24;
        r9 = r9.substring(1, r9.length() - 1);
    L31:
        r1 = r7.end();
        goto L6
    L33:
        throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + r11.substring(r1) + "\" for: \"" + r11 + '\"');
    L35:
        return new MediaType(r11, r5, r6, r8);
    L37:
        throw new IllegalArgumentException("No subtype found for: \"" + r11 + '\"');
    }

    @Nullable
    public static MediaType parse(String r0) {
        return get(r0);
    L4:
        return null;
    }

    @Nullable
    public Charset charset(@Nullable Charset r2) {
        String r0 = this.charset;     // Catch: IllegalArgumentException -> L6
        if (r0 == null) goto L9;
        return Charset.forName(r0);
    L9:
        return r2;
    L10:
        return r2;
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof MediaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (((MediaType) r2).mediaType.equals(this.mediaType) == false) goto L7;
        return true;
    }

    private MediaType(String r1, String r2, String r3, @Nullable String r4) {
        this.mediaType = r1;
        this.type = r2;
        this.subtype = r3;
        this.charset = r4;
    }
}
