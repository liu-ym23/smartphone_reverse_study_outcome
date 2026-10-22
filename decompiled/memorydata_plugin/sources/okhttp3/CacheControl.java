package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
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
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class CacheControl {
    public static final Companion Companion = null;
    public static final CacheControl FORCE_CACHE = null;
    public static final CacheControl FORCE_NETWORK = null;
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\u0000J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", "build", "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds;
        private int maxStaleSeconds;
        private int minFreshSeconds;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public Builder() {
            this.maxAgeSeconds = -1;
            this.maxStaleSeconds = -1;
            this.minFreshSeconds = -1;
        }

        private final int clampToInt(long r3) {
            if (r3 <= Integer.MAX_VALUE) goto L6;
            return Integer.MAX_VALUE;
        L6:
            return (int) r3;
        }

        public final CacheControl build() {
            int r4 = -1;
            boolean r5 = false;
            boolean r6 = false;
            boolean r7 = false;
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, r4, r5, r6, r7, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder immutable() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).immutable = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder maxAge(int r6, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, "timeUnit");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r6 < 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L10;
            r2.maxAgeSeconds = r2.clampToInt(r7.toSeconds(r6));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("maxAge < 0: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r3 = false;
            goto L6
        }

        public final Builder maxStale(int r6, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, "timeUnit");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r6 < 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L10;
            r2.maxStaleSeconds = r2.clampToInt(r7.toSeconds(r6));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("maxStale < 0: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r3 = false;
            goto L6
        }

        public final Builder minFresh(int r6, TimeUnit r7) {
            Intrinsics.checkParameterIsNotNull(r7, "timeUnit");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r6 < 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L10;
            r2.minFreshSeconds = r2.clampToInt(r7.toSeconds(r6));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L10:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("minFresh < 0: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r3 = false;
            goto L6
        }

        public final Builder noCache() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).noCache = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder noStore() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).noStore = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder noTransform() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).noTransform = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder onlyIfCached() {
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).onlyIfCached = true;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final int indexOfElement(String r6, String r7, int r8) {
            int r5 = r6.length();
        L3:
            if (r8 >= r5) goto L9;
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r6.charAt(r8), false, 2, null) == true) goto L6;
            r8 = r8 + 1;
            goto L3
        L6:
            return r8;
        L9:
            return r6.length();
        }

        static /* synthetic */ int indexOfElement$default(Companion r0, String r1, String r2, int r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L6;
            r3 = 0;
        L6:
            return r0.indexOfElement(r1, r2, r3);
        }

        @JvmStatic
        public final CacheControl parse(Headers r36) {
            Headers r1 = r36;
            Intrinsics.checkParameterIsNotNull(r1, "headers");
            String r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
            int r6 = r36.size();
            boolean r9 = true;
            boolean r11 = true;
            int r10 = 0;
            boolean r13 = false;
            boolean r14 = false;
            int r15 = -1;
            int r16 = -1;
            boolean r17 = false;
            boolean r18 = false;
            boolean r19 = false;
            int r20 = -1;
            int r21 = -1;
            boolean r22 = false;
            boolean r23 = false;
            boolean r24 = false;
        L3:
            if (r10 >= r6) goto L91;
            String r12 = r1.name(r10);
            String r8 = r1.value(r10);
            if (StringsKt.equals(r12, "Cache-Control", r9) == false) goto L10;
            if (r3 != null) goto L11;
            r3 = r8;
        L12:
            int r7 = 0;
        L14:
            if (r7 >= r8.length()) goto L90;
            int r4 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).indexOfElement(r8, "=,;", r7);
            if (r8 == null) goto L88;
            String r25 = r8.substring(r7, r4);
            Intrinsics.checkExpressionValueIsNotNull(r25, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (r25 == null) goto L86;
            String r27 = r3;
            String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (r4 == r8.length()) goto L44;
            int r28 = r6;
            if (r8.charAt(r4) != ',') goto L24;
        L45:
            r7 = r4 + 1;
            String r26 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        L47:
            if (StringsKt.equals("no-cache", r5, true) == false) goto L51;
            r13 = true;
        L84:
            r9 = true;
            r3 = r27;
            r6 = r28;
            goto L14
        L51:
            if (StringsKt.equals("no-store", r5, true) == false) goto L54;
            r14 = true;
            goto L84
        L54:
            if (StringsKt.equals("max-age", r5, true) == false) goto L57;
            byte r2 = -1;
            r15 = Util.toNonNegativeInt(r26, -1);
            goto L84
        L57:
            r2 = -1;
            if (StringsKt.equals("s-maxage", r5, true) == false) goto L61;
            r16 = Util.toNonNegativeInt(r26, -1);
            goto L84
        L61:
            if (StringsKt.equals("private", r5, true) == false) goto L64;
            r17 = true;
            goto L84
        L64:
            if (StringsKt.equals("public", r5, true) == false) goto L67;
            r18 = true;
            goto L84
        L67:
            if (StringsKt.equals("must-revalidate", r5, true) == false) goto L70;
            r19 = true;
            goto L84
        L70:
            if (StringsKt.equals("max-stale", r5, true) == false) goto L73;
            r20 = Util.toNonNegativeInt(r26, Integer.MAX_VALUE);
            goto L84
        L73:
            if (StringsKt.equals("min-fresh", r5, true) == false) goto L76;
            r21 = Util.toNonNegativeInt(r26, -1);
            goto L84
        L76:
            if (StringsKt.equals("only-if-cached", r5, true) == false) goto L79;
            r22 = true;
            goto L84
        L79:
            if (StringsKt.equals("no-transform", r5, true) == false) goto L82;
            r23 = true;
            goto L84
        L82:
            if (StringsKt.equals("immutable", r5, true) == false) goto L84;
            r24 = true;
            goto L84
        L24:
            if (r8.charAt(r4) == ';') goto L45;
            int r29 = Util.indexOfNonWhitespace(r8, r4 + 1);
            if (r29 < r8.length()) goto L29;
        L35:
            int r30 = ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).indexOfElement(r8, ",;", r29);
            if (r8 == null) goto L43;
            String r31 = r8.substring(r29, r30);
            Intrinsics.checkExpressionValueIsNotNull(r31, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (r31 == null) goto L41;
            r26 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            r7 = r30;
            goto L47
        L41:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L43:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L29:
            if (r8.charAt(r29) != '\"') goto L35;
            int r32 = r29 + 1;
            int r33 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), Typography.quote, r32, false, 4, null);
            if (r8 == null) goto L34;
            r26 = r8.substring(r32, r33);
            Intrinsics.checkExpressionValueIsNotNull(r26, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r7 = r33 + 1;
            goto L47
        L34:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L44:
            r28 = r6;
            goto L45
        L86:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        L88:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L90:
            r10 = r10 + 1;
            r1 = r36;
            r9 = r9;
            r6 = r6;
        L11:
            r11 = false;
            goto L12
        L10:
            if (StringsKt.equals(r12, "Pragma", r9) == false) goto L90;
        L91:
            if (r11 == true) goto L94;
            r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
        L94:
            return new CacheControl(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r3, null);
        }
    }

    static {
        Companion = new Companion(null);
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }

    private CacheControl(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13) {
        this.noCache = r1;
        this.noStore = r2;
        this.maxAgeSeconds = r3;
        this.sMaxAgeSeconds = r4;
        this.isPrivate = r5;
        this.isPublic = r6;
        this.mustRevalidate = r7;
        this.maxStaleSeconds = r8;
        this.minFreshSeconds = r9;
        this.onlyIfCached = r10;
        this.noTransform = r11;
        this.immutable = r12;
        this.headerValue = r13;
    }

    public /* synthetic */ CacheControl(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13, DefaultConstructorMarker r14) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    @JvmStatic
    public static final CacheControl parse(Headers r1) {
        return Companion.parse(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    /* JADX INFO: renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m2925deprecated_immutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m2926deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m2927deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m2928deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    /* JADX INFO: renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m2929deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m2930deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m2931deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    /* JADX INFO: renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m2932deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    /* JADX INFO: renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m2933deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m2934deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String r0 = this.headerValue;
        if (r0 != null) goto L49;
        StringBuilder r1 = new StringBuilder();
        if (this.noCache == false) goto L8;
        r1.append("no-cache, ");
    L8:
        if (this.noStore == false) goto L11;
        r1.append("no-store, ");
    L11:
        if (this.maxAgeSeconds == (-1)) goto L14;
        r1.append("max-age=").append(this.maxAgeSeconds).append(", ");
    L14:
        if (this.sMaxAgeSeconds == (-1)) goto L17;
        r1.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
    L17:
        if (this.isPrivate == false) goto L20;
        r1.append("private, ");
    L20:
        if (this.isPublic == false) goto L23;
        r1.append("public, ");
    L23:
        if (this.mustRevalidate == false) goto L26;
        r1.append("must-revalidate, ");
    L26:
        if (this.maxStaleSeconds == (-1)) goto L29;
        r1.append("max-stale=").append(this.maxStaleSeconds).append(", ");
    L29:
        if (this.minFreshSeconds == (-1)) goto L32;
        r1.append("min-fresh=").append(this.minFreshSeconds).append(", ");
    L32:
        if (this.onlyIfCached == false) goto L35;
        r1.append("only-if-cached, ");
    L35:
        if (this.noTransform == false) goto L38;
        r1.append("no-transform, ");
    L38:
        if (this.immutable == false) goto L41;
        r1.append("immutable, ");
    L41:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L43;
        boolean r2 = true;
    L44:
        if (r2 == false) goto L47;
        return "";
    L47:
        r1.delete(r1.length() - 2, r1.length());
        String r3 = r1.toString();
        Intrinsics.checkExpressionValueIsNotNull(r3, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = r3;
        return r3;
    L43:
        r2 = false;
        goto L44
    L49:
        return r0;
    }
}
