package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\u0014"}, d2 = {"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "charset", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", "other", "hashCode", "", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class MediaType {
    public static final Companion Companion = null;
    private static final Pattern PARAMETER = null;
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = null;
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u000fJ\u0011\u0010\u0010\u001a\u00020\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "get", "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m2989deprecated_get(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "mediaType");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).get(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}))
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m2990deprecated_parse(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "mediaType");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).parse(r3);
        }

        @JvmStatic
        public final MediaType get(String r14) {
            Intrinsics.checkParameterIsNotNull(r14, "$this$toMediaType");
            Matcher r13 = MediaType.access$getTYPE_SUBTYPE$cp().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
            if (r13.lookingAt() == false) goto L47;
            String r3 = r13.group(1);
            Intrinsics.checkExpressionValueIsNotNull(r3, "typeSubtype.group(1)");
            Locale r4 = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(r4, "Locale.US");
            if (r3 == null) goto L45;
            String r9 = r3.toLowerCase(r4);
            Intrinsics.checkExpressionValueIsNotNull(r9, "(this as java.lang.String).toLowerCase(locale)");
            String r7 = r13.group(2);
            Intrinsics.checkExpressionValueIsNotNull(r7, "typeSubtype.group(2)");
            Locale r8 = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(r8, "Locale.US");
            if (r7 == null) goto L43;
            String r10 = r7.toLowerCase(r8);
            Intrinsics.checkExpressionValueIsNotNull(r10, "(this as java.lang.String).toLowerCase(locale)");
            String r5 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
            Matcher r6 = MediaType.access$getPARAMETER$cp().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
            int r15 = r13.end();
            String r11 = r5;
        L10:
            if (r15 >= r14.length()) goto L41;
            r6.region(r15, r14.length());
            if (r6.lookingAt() == false) goto L38;
            String r16 = r6.group(1);
            if (r16 == null) goto L37;
            if (StringsKt.equals(r16, "charset", true) == false) goto L37;
            String r17 = r6.group(2);
            boolean r12 = false;
            if (r17 != null) goto L23;
            r17 = r6.group(3);
            String r18 = "parameter.group(3)";
        L21:
            Intrinsics.checkExpressionValueIsNotNull(r17, r18);
        L29:
            if (r11 != null) goto L31;
        L32:
            r12 = true;
        L33:
            if (r12 == false) goto L36;
            r11 = r17;
            r15 = r6.end();
            goto L10
        L36:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("Multiple charsets defined: \"" + r11 + "\" and: \"" + r17 + "\" for: \"" + r14 + Typography.quote).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L31:
            if (StringsKt.equals(r17, r11, true) == false) goto L33;
        L23:
            if (StringsKt.startsWith$default(r17, "'", false, 2, null) == false) goto L29;
            if (StringsKt.endsWith$default(r17, "'", false, 2, null) == false) goto L29;
            if (r17.length() <= 2) goto L29;
            r17 = r17.substring(1, r17.length() - 1);
            r18 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
        L37:
            r15 = r6.end();
            goto L10
        L38:
            StringBuilder r0 = new StringBuilder().append("Parameter is not formatted correctly: \"");
            String r19 = r14.substring(r15);
            Intrinsics.checkExpressionValueIsNotNull(r19, "(this as java.lang.String).substring(startIndex)");
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(r0.append(r19).append("\" for: \"").append(r14).append(Typography.quote).toString().toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L41:
            return new MediaType(r14, r9, r10, r11, null);
        L43:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L45:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L47:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("No subtype found for: \"" + r14 + Typography.quote).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @JvmStatic
        public final MediaType parse(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "$this$toMediaTypeOrNull");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).get(r3);
        L5:
            return null;
        }
    }

    static {
        Companion = new Companion(null);
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private MediaType(String r1, String r2, String r3, String r4) {
        this.mediaType = r1;
        this.type = r2;
        this.subtype = r3;
        this.charset = r4;
    }

    public /* synthetic */ MediaType(String r1, String r2, String r3, String r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public static final /* synthetic */ Pattern access$getPARAMETER$cp() {
        return PARAMETER;
    }

    public static final /* synthetic */ Pattern access$getTYPE_SUBTYPE$cp() {
        return TYPE_SUBTYPE;
    }

    public static /* synthetic */ Charset charset$default(MediaType r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = (Charset) ZeusTransformUtils.preCheckCast(null, Charset.class, "com.obric.memorydata.plugin");
    L6:
        return r0.charset(r1);
    }

    @JvmStatic
    public static final MediaType get(String r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final MediaType parse(String r1) {
        return Companion.parse(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}))
    /* JADX INFO: renamed from: -deprecated_subtype, reason: not valid java name */
    public final String m2987deprecated_subtype() {
        return this.subtype;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final String m2988deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public final Charset charset(Charset r1) {
        String r0 = this.charset;     // Catch: IllegalArgumentException -> L7
        if (r0 == null) goto L10;
        return Charset.forName(r0);
    L10:
        return r1;
    L11:
        return r1;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, MediaType.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((MediaType) ZeusTransformUtils.preCheckCast(r3, MediaType.class, "com.obric.memorydata.plugin")).mediaType, this.mediaType) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }
}
