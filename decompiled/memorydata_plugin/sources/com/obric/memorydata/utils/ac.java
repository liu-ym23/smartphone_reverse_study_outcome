package com.obric.memorydata.utils;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/utils/LanguageUtils;", "", "<init>", "()V", "SUPPORTED_LANGS", "", "", "DEFAULT_LANG", "isDebug", "", "getCurrentLanguage", "normalizeLang", "lang", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ac f13156a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f13157b = null;
    private static final boolean c = false;

    static {
        f13156a = new ac();
        f13157b = CollectionsKt.listOf(new String[]{"zh-CN", "zh-HK", "en-HK", "en-US", "en-GB", "en-SG", "en-AU", "en-CA", "en-IN"});
        c = AppContext.INSTANCE.isLocalTest();
    }

    private ac() {
    }

    public final String a() {
        Locale r0 = Locale.getDefault();
        String r1 = r0.getLanguage();
        String r2 = r0.getCountry();
        String r3 = r0.getScript();
        Intrinsics.checkNotNull(r2);
        boolean r5 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L10;
        StringBuilder r6 = new StringBuilder().append(r1).append('-').append(r2);
    L9:
        r1 = r6.toString();
    L17:
        return a(r1);
    L10:
        Intrinsics.checkNotNull(r3);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L14;
        r5 = false;
    L14:
        if (r5 == false) goto L17;
        r6 = new StringBuilder().append(r1).append('-').append(r3);
        goto L9
    L5:
        r4 = false;
        goto L7
    }

    public final String a(String r13) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
    L8:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L12;
        return "zh-CN";
    L12:
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (f13157b.contains(r15) == false) goto L15;
        return r15;
    L15:
        String r16 = r15.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r16, "toLowerCase(...)");
        if (StringsKt.startsWith$default(r16, "en", false, 2, null) == false) goto L22;
        List r17 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"-", "_"}, false, 0, 6, null);
        if (r17.size() < 2) goto L20;
        StringBuilder r18 = new StringBuilder().append("en-");
        String r19 = ((String) ZeusTransformUtils.preCheckCast(r17.get(1), String.class, "com.obric.memorydata.plugin")).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r19, "toUpperCase(...)");
        return r18.append(r19).toString();
    L20:
        return "en-US";
    L22:
        if (StringsKt.startsWith$default(r16, "zh-hant", false, 2, null) == false) goto L24;
    L37:
        return "zh-HK";
    L24:
        if (StringsKt.startsWith$default(r16, "zh_hant", false, 2, null) == true) goto L37;
        if (StringsKt.startsWith$default(r16, "zh-hk", false, 2, null) == true) goto L37;
        if (StringsKt.startsWith$default(r16, "zh_hk", false, 2, null) == true) goto L37;
        if (Intrinsics.areEqual(r16, "zh-tw") == true) goto L37;
        if (StringsKt.startsWith$default(r16, "zh-tw", false, 2, null) == true) goto L37;
        if (StringsKt.startsWith$default(r16, "zh_tw", false, 2, null) == true) goto L37;
        StringsKt.startsWith$default(r16, "zh", false, 2, null);
        return "zh-CN";
    L5:
        if (r12.length() == 0) goto L8;
        r14 = false;
        goto L10
    }
}
