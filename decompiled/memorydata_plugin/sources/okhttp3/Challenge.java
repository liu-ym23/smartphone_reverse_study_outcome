package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\b\u000eJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR!\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r¨\u0006\u0019"}, d2 = {"Lokhttp3/Challenge;", "", "scheme", "", "realm", "(Ljava/lang/String;Ljava/lang/String;)V", "authParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "()Ljava/util/Map;", "charset", "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", "()Ljava/lang/String;", "-deprecated_authParams", "-deprecated_charset", "equals", "", "other", "hashCode", "", "-deprecated_realm", "-deprecated_scheme", "toString", "withCharset", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Challenge {
    private final Map<String, String> authParams;
    private final String scheme;

    public Challenge(String r2, String r3) {
        Intrinsics.checkParameterIsNotNull(r2, "scheme");
        Intrinsics.checkParameterIsNotNull(r3, "realm");
        Map r4 = Collections.singletonMap("realm", r3);
        Intrinsics.checkExpressionValueIsNotNull(r4, "singletonMap(\"realm\", realm)");
        this(r2, r4);
    }

    public Challenge(String r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "scheme");
        Intrinsics.checkParameterIsNotNull(r8, "authParams");
        this.scheme = r6;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        Locale r3 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(r3, "US");
        if (r2 == null) goto L11;
        String r4 = r2.toLowerCase(r3);
        Intrinsics.checkExpressionValueIsNotNull(r4, "(this as java.lang.String).toLowerCase(locale)");
    L13:
        r9.put(r4, r1);
        goto L4
    L11:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L12:
        r4 = null;
        goto L13
    L14:
        Map<String, String> r11 = Collections.unmodifiableMap(r9);
        Intrinsics.checkExpressionValueIsNotNull(r11, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = r11;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authParams", imports = {}))
    /* JADX INFO: renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m2935deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "charset", imports = {}))
    /* JADX INFO: renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m2936deprecated_charset() {
        return charset();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "realm", imports = {}))
    /* JADX INFO: renamed from: -deprecated_realm, reason: not valid java name */
    public final String m2937deprecated_realm() {
        return realm();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m2938deprecated_scheme() {
        return this.scheme;
    }

    public final Map<String, String> authParams() {
        return this.authParams;
    }

    public final Charset charset() {
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.authParams.get("charset"), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
    L6:
        Charset r3 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkExpressionValueIsNotNull(r3, "ISO_8859_1");
        return r3;
    L9:
        Charset r4 = Charset.forName(r2);     // Catch: Exception -> L8
        Intrinsics.checkExpressionValueIsNotNull(r4, "Charset.forName(charset)");     // Catch: Exception -> L8
        return r4;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Challenge.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(((Challenge) ZeusTransformUtils.preCheckCast(r5, Challenge.class, "com.obric.memorydata.plugin")).scheme, this.scheme) == false) goto L9;
        if (Intrinsics.areEqual(((Challenge) ZeusTransformUtils.preCheckCast(r5, Challenge.class, "com.obric.memorydata.plugin")).authParams, this.authParams) == false) goto L9;
        return true;
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    public final String realm() {
        return (String) ZeusTransformUtils.preCheckCast(this.authParams.get("realm"), String.class, "com.obric.memorydata.plugin");
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    public final Challenge withCharset(Charset r4) {
        Intrinsics.checkParameterIsNotNull(r4, "charset");
        Map r1 = MapsKt.toMutableMap(this.authParams);
        String r5 = r4.name();
        Intrinsics.checkExpressionValueIsNotNull(r5, "charset.name()");
        r1.put("charset", r5);
        return new Challenge(this.scheme, r1);
    }
}
