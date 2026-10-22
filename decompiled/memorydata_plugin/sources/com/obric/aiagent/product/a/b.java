package com.obric.aiagent.product.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/product/utils/OsVersionUtil;", "", "<init>", "()V", "TAG", "", "MIN_VERSION_PART_LENGTH", "", "MAX_VERSION_PART_LENGTH", "DEFAULT_LONG_VERSION", "", "LONG_MAX_VALUE_STRING", "FOUR_PART_VERSION_REGEX", "Lkotlin/text/Regex;", "THREE_PART_VERSION_REGEX", "TWO_PART_VERSION_REGEX", "extractFourPartVersion", "versionStr", "extractThreePartVersion", "extractOsVersion", "convertVersionStringToLong", "version", "formatVersionPart", "versionPart", "trimVersionNumberToLongRange", "versionNumberString", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5965a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5966b = null;
    private static final Regex c = null;
    private static final Regex d = null;
    private static final Regex e = null;

    static {
        f5965a = new b();
        f5966b = "9223372036854775807";
        c = new Regex("(\\d+\\.\\d+\\.\\d+\\.\\d+)");
        d = new Regex("(\\d+\\.\\d+\\.\\d+)");
        e = new Regex("(\\d+\\.\\d+)");
    }

    private b() {
    }

    private final String e(String r2) {
        return StringsKt.padStart(StringsKt.take(r2, 8), 2, '0');
    }

    private final String f(String r7) {
        String r6 = r7;
    L3:
        boolean r2 = false;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L15;
        int r1 = r6.length();
        String r4 = f5966b;
        if (r1 > r4.length()) goto L14;
        if (r6.length() != r4.length()) goto L15;
        if (r6.compareTo(r4) <= 0) goto L15;
    L14:
        r6 = StringsKt.dropLast(r6, 1);
    L15:
        com.obric.aiagent.platform.a.d.f5954a.b("OsVersionUtil", "trimVersionNumberToLongRange: versionNumberString " + r7 + ", trimmedVersion " + r6);
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8.length() != 0) goto L18;
        r2 = true;
    L18:
        if (r2 == false) goto L21;
        r8 = "0";
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
    L6:
        r0 = false;
        goto L7
    }

    private static final CharSequence g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(f5965a.e(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$h710bRPqL7pDAeuS6Ip27M8q8JA(String r0) {
        return g(r0);
    }

    public final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "versionStr");
        MatchResult r5 = Regex.find$default(c, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L7
        if (r5 == null) goto L12;
        return r5.getValue();
    L12:
        return null;
    L7:
        th = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("OsVersionUtil", "extractFourPartVersion crash", th);
        return null;
    }

    public final String b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "versionStr");
        MatchResult r5 = Regex.find$default(d, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L7
        if (r5 == null) goto L12;
        return r5.getValue();
    L12:
        return null;
    L7:
        th = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("OsVersionUtil", "extractThreePartVersion crash", th);
        return null;
    }

    public final String c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "versionStr");
        String r0 = a(r4);     // Catch: Throwable -> L16
        if (r0 == null) goto L6;
        return r0;
    L6:
        String r3 = b(r4);     // Catch: Throwable -> L16
        if (r3 != null) goto L9;
        MatchResult r5 = Regex.find$default(e, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L16
        if (r5 == null) goto L21;
        String r6 = r5.getValue();     // Catch: Throwable -> L16
        if (r6 != null) goto L15;
        return "0.0.0.0";
    L15:
        return r6 + ".0.0";
    L21:
        return "0.0.0.0";
    L9:
        return r3 + ".0";
    L16:
        th = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("OsVersionUtil", "extractOsVersion crash", th);
        return "0.0.0.0";
    }

    public final long d(String r13) {
        Intrinsics.checkNotNullParameter(r13, "version");
        Long r12 = StringsKt.toLongOrNull(f(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(c(r13), CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'.'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$h710bRPqL7pDAeuS6Ip27M8q8JA.INSTANCE, 30, null)));     // Catch: Throwable -> L7
        if (r12 == null) goto L12;
        return r12.longValue();
    L12:
        return 0;
    L7:
        th = move-exception;
        com.obric.aiagent.platform.a.d.f5954a.b("OsVersionUtil", "convertVersionStringToLong crash", th);
        return 0;
    }
}
