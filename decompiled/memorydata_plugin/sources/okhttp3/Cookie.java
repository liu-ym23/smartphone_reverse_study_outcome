package okhttp3;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.calendar.ODatePickerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006'"}, d2 = {"Lokhttp3/Cookie;", "", ActivityLifecycle.NAME, "", EventBody.KEY_VALUE, "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Cookie {
    public static final Companion Companion = null;
    private static final Pattern DAY_OF_MONTH_PATTERN = null;
    private static final Pattern MONTH_PATTERN = null;
    private static final Pattern TIME_PATTERN = null;
    private static final Pattern YEAR_PATTERN = null;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", ActivityLifecycle.NAME, "path", "persistent", "secure", EventBody.KEY_VALUE, "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DatesKt.MAX_DATE;
            this.path = "/";
        }

        private final Builder domain(String r5, boolean r6) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            String r3 = HostnamesKt.toCanonicalHost(r5);
            if (r3 == null) goto L7;
            r2.domain = r3;
            r2.hostOnly = r6;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("unexpected domain: " + r5), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Cookie build() {
            String r1 = this.name;
            if (r1 == null) goto L15;
            String r2 = this.value;
            if (r2 == null) goto L13;
            long r3 = this.expiresAt;
            String r5 = this.domain;
            if (r5 == null) goto L11;
            return new Cookie(r1, r2, r3, r5, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
        L11:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new NullPointerException("builder.domain == null"), Throwable.class, "com.obric.memorydata.plugin"));
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new NullPointerException("builder.value == null"), Throwable.class, "com.obric.memorydata.plugin"));
        L15:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new NullPointerException("builder.name == null"), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder domain(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "domain");
            return domain(r2, false);
        }

        public final Builder expiresAt(long r7) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r7 > 0) goto L6;
            r7 = Long.MIN_VALUE;
        L6:
            if (r7 <= DatesKt.MAX_DATE) goto L8;
            r7 = 253402300799999L;
        L8:
            r2.expiresAt = r7;
            r2.persistent = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder hostOnlyDomain(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "domain");
            return domain(r2, true);
        }

        public final Builder httpOnly() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).httpOnly = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder name(String r5) {
            Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r5) == false) goto L7;
            r2.name = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("name is not trimmed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder path(String r8) {
            Intrinsics.checkParameterIsNotNull(r8, "path");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (StringsKt.startsWith$default(r8, "/", false, 2, null) == false) goto L7;
            r2.path = r8;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("path must start with '/'".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder secure() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).secure = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder value(String r5) {
            Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r5) == false) goto L7;
            r2.value = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("value is not trimmed".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ boolean access$domainMatch(Companion r0, String r1, String r2) {
            return r0.domainMatch(r1, r2);
        }

        public static final /* synthetic */ boolean access$pathMatch(Companion r0, HttpUrl r1, String r2) {
            return r0.pathMatch(r1, r2);
        }

        private final int dateCharacterOffset(String r4, int r5, int r6, boolean r7) {
        L2:
            if (r5 >= r6) goto L27;
            char r3 = r4.charAt(r5);
            if (r3 >= ' ') goto L8;
            if (r3 == '\t') goto L8;
        L22:
            boolean r8 = true;
        L24:
            if (r8 == (!r7)) goto L25;
            r5 = r5 + 1;
            goto L2
        L25:
            return r5;
        L8:
            if (r3 >= 127) goto L22;
            if ('0' > r3) goto L13;
            if ('9' >= r3) goto L22;
        L13:
            if ('a' > r3) goto L16;
            if ('z' >= r3) goto L22;
        L16:
            if ('A' > r3) goto L19;
            if ('Z' >= r3) goto L22;
        L19:
            if (r3 == ':') goto L22;
            r8 = false;
            goto L24
        L27:
            return r6;
        }

        private final boolean domainMatch(String r4, String r5) {
            if (Intrinsics.areEqual(r4, r5) == false) goto L6;
            return true;
        L6:
            if (StringsKt.endsWith$default(r4, r5, false, 2, null) == false) goto L13;
            if (r4.charAt((r4.length() - r5.length()) - 1) != '.') goto L13;
            if (Util.canParseAsIpAddress(r4) == true) goto L13;
            return true;
        L13:
            return false;
        }

        private final String parseDomain(String r4) {
            if ((!StringsKt.endsWith$default(r4, ".", false, 2, null)) == false) goto L10;
            String r3 = HostnamesKt.toCanonicalHost(StringsKt.removePrefix(r4, (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.memorydata.plugin")));
            if (r3 == null) goto L8;
            return r3;
        L8:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(), Throwable.class, "com.obric.memorydata.plugin"));
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final long parseExpires(String r24, int r25, int r26) {
            int r5 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).dateCharacterOffset(r24, r25, r26, false);
            Matcher r7 = Cookie.access$getTIME_PATTERN$cp().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.memorydata.plugin"));
            int r9 = -1;
            int r10 = -1;
            int r11 = -1;
            int r12 = -1;
            int r13 = -1;
            int r14 = -1;
        L4:
            if (r5 >= r26) goto L30;
            int r8 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).dateCharacterOffset(r24, r5 + 1, r26, true);
            r7.region(r5, r8);
            int r6 = -1;
            if (r10 == (-1)) goto L8;
        L11:
            if (r11 == r6) goto L13;
        L15:
            if (r12 == r6) goto L17;
        L24:
            if (r9 != r6) goto L28;
            if (r7.usePattern(Cookie.access$getYEAR_PATTERN$cp()).matches() == false) goto L28;
            r9 = Integer.parseInt(r7.group(1));
        L28:
            r5 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).dateCharacterOffset(r24, r8 + 1, r26, false);
            goto L4
        L17:
            if (r7.usePattern(Cookie.access$getMONTH_PATTERN$cp()).matches() == false) goto L23;
            String r15 = r7.group(1);
            Intrinsics.checkExpressionValueIsNotNull(r15, "matcher.group(1)");
            Locale r16 = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(r16, "Locale.US");
            if (r15 == null) goto L22;
            String r17 = r15.toLowerCase(r16);
            Intrinsics.checkExpressionValueIsNotNull(r17, "(this as java.lang.String).toLowerCase(locale)");
            String r18 = Cookie.access$getMONTH_PATTERN$cp().pattern();
            Intrinsics.checkExpressionValueIsNotNull(r18, "MONTH_PATTERN.pattern()");
            r12 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"), r17, 0, false, 6, null) / 4;
            goto L28
        L22:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L23:
            r6 = -1;
            goto L24
        L13:
            if (r7.usePattern(Cookie.access$getDAY_OF_MONTH_PATTERN$cp()).matches() == false) goto L15;
            r11 = Integer.parseInt(r7.group(1));
            goto L28
        L8:
            if (r7.usePattern(Cookie.access$getTIME_PATTERN$cp()).matches() == false) goto L10;
            r10 = Integer.parseInt(r7.group(1));
            r13 = Integer.parseInt(r7.group(2));
            r14 = Integer.parseInt(r7.group(3));
            goto L28
        L10:
            r6 = -1;
            goto L11
        L30:
            if (70 > r9) goto L35;
            if (99 < r9) goto L35;
            r9 = r9 + ODatePickerView.YEAR_FROM;
        L35:
            if (r9 < 0) goto L40;
            if (69 < r9) goto L40;
            r9 = r9 + 2000;
        L40:
            if (r9 < 1601) goto L42;
            boolean r0 = true;
        L44:
            if (r0 == false) goto L90;
            if (r12 == (-1)) goto L48;
            boolean r1 = true;
        L49:
            if (r1 == false) goto L88;
            if (1 > r11) goto L55;
            if (31 < r11) goto L55;
            boolean r2 = true;
        L56:
            if (r2 == false) goto L86;
            if (r10 < 0) goto L62;
            if (23 < r10) goto L62;
            boolean r3 = true;
        L63:
            if (r3 == false) goto L84;
            if (r13 < 0) goto L69;
            if (59 < r13) goto L69;
            boolean r4 = true;
        L70:
            if (r4 == false) goto L82;
            if (r14 < 0) goto L75;
            if (59 < r14) goto L75;
            boolean r19 = true;
        L76:
            if (r19 == false) goto L80;
            GregorianCalendar r20 = new GregorianCalendar(Util.UTC);
            r20.setLenient(false);
            r20.set(1, r9);
            r20.set(2, r12 - 1);
            r20.set(5, r11);
            r20.set(11, r10);
            r20.set(12, r13);
            r20.set(13, r14);
            r20.set(14, 0);
            return r20.getTimeInMillis();
        L80:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L75:
            r19 = false;
            goto L76
        L82:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L69:
            r4 = false;
            goto L70
        L84:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L62:
            r3 = false;
            goto L63
        L86:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L55:
            r2 = false;
            goto L56
        L88:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L48:
            r1 = false;
            goto L49
        L90:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L42:
            r0 = false;
            goto L44
        }

        private final long parseMaxAge(String r7) {
            long r6 = Long.parseLong(r7);     // Catch: NumberFormatException -> L9
            if (r6 > 0) goto L8;
            return Long.MIN_VALUE;
        L8:
            return r6;
        L9:
            e = move-exception;
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
            if (new Regex("-?\\d+").matches(r2) == false) goto L18;
            if (StringsKt.startsWith$default(r7, "-", false, 2, null) == true) goto L22;
            return Long.MAX_VALUE;
        L22:
            return Long.MIN_VALUE;
        L18:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final boolean pathMatch(HttpUrl r5, String r6) {
            String r4 = r5.encodedPath();
            if (Intrinsics.areEqual(r4, r6) == false) goto L6;
            return true;
        L6:
            if (StringsKt.startsWith$default(r4, r6, false, 2, null) == true) goto L8;
        L13:
            return false;
        L8:
            if (StringsKt.endsWith$default(r6, "/", false, 2, null) == false) goto L11;
            return true;
        L11:
            if (r4.charAt(r6.length()) != '/') goto L13;
            return true;
        }

        @JvmStatic
        public final Cookie parse(HttpUrl r3, String r4) {
            Intrinsics.checkParameterIsNotNull(r3, "url");
            Intrinsics.checkParameterIsNotNull(r4, "setCookie");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).parse$okhttp(System.currentTimeMillis(), r3, r4);
        }

        public final Cookie parse$okhttp(long r27, HttpUrl r29, String r30) {
            Intrinsics.checkParameterIsNotNull(r29, "url");
            Intrinsics.checkParameterIsNotNull(r30, "setCookie");
            int r10 = Util.delimiterOffset$default(r30, ';', 0, 0, 6, null);
            int r1 = Util.delimiterOffset$default(r30, '=', 0, r10, 2, null);
            if (r1 != r10) goto L5;
            return null;
        L5:
            String r12 = Util.trimSubstring$default(r30, 0, r1, 1, null);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == true) goto L87;
            if (Util.indexOfControlOrNonAscii(r12) != (-1)) goto L87;
            String r13 = Util.trimSubstring(r30, r1 + 1, r10);
            if (Util.indexOfControlOrNonAscii(r13) == (-1)) goto L16;
            return null;
        L16:
            String r2 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
            int r11 = r10 + 1;
            int r14 = r30.length();
            boolean r18 = false;
            boolean r19 = false;
            boolean r20 = false;
            boolean r21 = true;
            long r24 = 253402300799999L;
            long r22 = -1;
        L17:
            if (r11 >= r14) goto L44;
            int r3 = Util.delimiterOffset(r30, ';', r11, r14);
            int r15 = Util.delimiterOffset(r30, '=', r11, r3);
            String r16 = Util.trimSubstring(r30, r11, r15);
            if (r15 >= r3) goto L21;
            String r17 = Util.trimSubstring(r30, r15 + 1, r3);
        L23:
            if (StringsKt.equals(r16, "expires", true) == false) goto L27;
            r24 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).parseExpires(r17, 0, r17.length());     // Catch: Throwable -> L88
        L29:
            r20 = true;
        L43:
            r11 = r3 + 1;
            goto L17
        L27:
            if (StringsKt.equals(r16, "max-age", true) == false) goto L31;
            r22 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).parseMaxAge(r17);
            goto L29
        L31:
            if (StringsKt.equals(r16, "domain", true) == false) goto L35;
            r2 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).parseDomain(r17);     // Catch: Throwable -> L88
            r21 = false;
            goto L43
        L35:
            if (StringsKt.equals(r16, "path", true) == false) goto L38;
            r6 = r17;
            goto L43
        L38:
            if (StringsKt.equals(r16, "secure", true) == false) goto L41;
            r18 = true;
            goto L43
        L41:
            if (StringsKt.equals(r16, "httponly", true) == false) goto L43;
            r19 = true;
            goto L43
        L21:
            r17 = "";
            goto L23
        L44:
            long r110 = Long.MIN_VALUE;
            if (r22 != Long.MIN_VALUE) goto L48;
        L46:
            long r111 = r110;
        L59:
            String r4 = r29.host();
            if (r2 != null) goto L63;
            r2 = r4;
        L67:
            if (r4.length() != r2.length()) goto L69;
        L71:
            String r7 = "/";
            if (r6 != null) goto L74;
        L77:
            String r0 = r29.encodedPath();
            int r8 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"), '/', 0, false, 6, null);
            if (r8 == 0) goto L83;
            if (r0 == null) goto L82;
            r7 = r0.substring(0, r8);
            Intrinsics.checkExpressionValueIsNotNull(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            goto L83
        L82:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L83:
            String r112 = r7;
        L85:
            return new Cookie(r12, r13, r111, r2, r112, r18, r19, r20, r21, null);
        L74:
            if (StringsKt.startsWith$default(r6, "/", false, 2, null) == false) goto L77;
            r112 = r6;
            goto L85
        L69:
            if (PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(r2) != null) goto L71;
            return null;
        L63:
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).domainMatch(r4, r2) == true) goto L67;
            return null;
        L48:
            if (r22 != (-1)) goto L50;
            r111 = r24;
            goto L59
        L50:
            if (r22 > 9223372036854775L) goto L52;
            long r23 = r22 * ((long) 1000);
        L53:
            r110 = r27 + r23;
            if (r110 >= r27) goto L56;
        L57:
            r111 = 253402300799999L;
            goto L59
        L56:
            if (r110 <= DatesKt.MAX_DATE) goto L46;
        L52:
            r23 = Long.MAX_VALUE;
        L87:
            return null;
        L8:
            r5 = false;
            goto L9
        }

        @JvmStatic
        public final List<Cookie> parseAll(HttpUrl r8, Headers r9) {
            Intrinsics.checkParameterIsNotNull(r8, "url");
            Intrinsics.checkParameterIsNotNull(r9, "headers");
            List<String> r10 = r9.values(Api.KEY_SET_COOKIE);
            List r0 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
            int r1 = r10.size();
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L10;
            Cookie r4 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).parse(r8, (String) ZeusTransformUtils.preCheckCast(r10.get(r3), String.class, "com.obric.memorydata.plugin"));
            if (r4 == null) goto L9;
            if (r0 != null) goto L8;
            r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        L8:
            r0.add(r4);
        L9:
            r3 = r3 + 1;
            goto L3
        L10:
            if (r0 == null) goto L13;
            List<Cookie> r7 = Collections.unmodifiableList(r0);
            Intrinsics.checkExpressionValueIsNotNull(r7, "Collections.unmodifiableList(cookies)");
            return r7;
        L13:
            return CollectionsKt.emptyList();
        }
    }

    static {
        Companion = new Companion(null);
        YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private Cookie(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        this.name = r1;
        this.value = r2;
        this.expiresAt = r3;
        this.domain = r5;
        this.path = r6;
        this.secure = r7;
        this.httpOnly = r8;
        this.persistent = r9;
        this.hostOnly = r10;
    }

    public /* synthetic */ Cookie(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }

    public static final /* synthetic */ Pattern access$getDAY_OF_MONTH_PATTERN$cp() {
        return DAY_OF_MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getMONTH_PATTERN$cp() {
        return MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getTIME_PATTERN$cp() {
        return TIME_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getYEAR_PATTERN$cp() {
        return YEAR_PATTERN;
    }

    @JvmStatic
    public static final Cookie parse(HttpUrl r1, String r2) {
        return Companion.parse(r1, r2);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl r1, Headers r2) {
        return Companion.parseAll(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    /* JADX INFO: renamed from: -deprecated_domain, reason: not valid java name */
    public final String m2943deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    /* JADX INFO: renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m2944deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    /* JADX INFO: renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m2945deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    /* JADX INFO: renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m2946deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ActivityLifecycle.NAME, imports = {}))
    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name */
    public final String m2947deprecated_name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    /* JADX INFO: renamed from: -deprecated_path, reason: not valid java name */
    public final String m2948deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    /* JADX INFO: renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m2949deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    /* JADX INFO: renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m2950deprecated_secure() {
        return this.secure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = EventBody.KEY_VALUE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_value, reason: not valid java name */
    public final String m2951deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, Cookie.class) == true) goto L5;
    L23:
        return false;
    L5:
        if (Intrinsics.areEqual(((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).name, this.name) == false) goto L23;
        if (Intrinsics.areEqual(((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).value, this.value) == false) goto L23;
        if (((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).expiresAt != this.expiresAt) goto L23;
        if (Intrinsics.areEqual(((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).domain, this.domain) == false) goto L23;
        if (Intrinsics.areEqual(((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).path, this.path) == false) goto L23;
        if (((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).secure != this.secure) goto L23;
        if (((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).httpOnly != this.httpOnly) goto L23;
        if (((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).persistent != this.persistent) goto L23;
        if (((Cookie) ZeusTransformUtils.preCheckCast(r7, Cookie.class, "com.obric.memorydata.plugin")).hostOnly != this.hostOnly) goto L23;
        return true;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl r4) {
        Intrinsics.checkParameterIsNotNull(r4, "url");
        if (this.hostOnly == false) goto L5;
        boolean r0 = Intrinsics.areEqual(r4.host(), this.domain);
    L7:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (Companion.access$pathMatch(Companion, r4, this.path) == true) goto L13;
        return false;
    L13:
        if (this.secure == true) goto L15;
    L16:
        return true;
    L15:
        if (r4.isHttps() == true) goto L16;
        return false;
    L5:
        r0 = Companion.access$domainMatch(Companion, r4.host(), this.domain);
        goto L7
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.name);
        r0.append('=');
        r0.append(this.value);
        if (this.persistent == false) goto L9;
        if (this.expiresAt != Long.MIN_VALUE) goto L7;
        r0.append("; max-age=0");
        goto L9
    L7:
        r0.append("; expires=").append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
    L9:
        if (this.hostOnly == true) goto L14;
        r0.append("; domain=");
        if (r6 == false) goto L13;
        r0.append(".");
    L13:
        r0.append(this.domain);
    L14:
        r0.append("; path=").append(this.path);
        if (this.secure == false) goto L18;
        r0.append("; secure");
    L18:
        if (this.httpOnly == false) goto L20;
        r0.append("; httponly");
    L20:
        String r5 = r0.toString();
        Intrinsics.checkExpressionValueIsNotNull(r5, "toString()");
        return r5;
    }

    public final String value() {
        return this.value;
    }
}
