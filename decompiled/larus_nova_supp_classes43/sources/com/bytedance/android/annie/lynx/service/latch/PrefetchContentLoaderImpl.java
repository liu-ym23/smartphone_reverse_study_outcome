package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.latch.prefetch.internal.q;
import com.bytedance.android.latch.prefetch.internal.x;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PrefetchContentLoaderImpl implements x {
    public final Map<String, com.bytedance.android.latch.prefetch.internal.g> a;
    public final Function1<String, Unit> b;

    public static String b(final String r10) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<T> r12 = AnnieConfigSettingKeys.LIVE_OFFLINE_PATTERNS.a().iterator();     // Catch: Throwable -> L13
    L5:
        if (r12.hasNext() == false) goto L7;
        r11.add(PatternProtector.compile((String) r12.next()));     // Catch: Throwable -> L13
        goto L5
    L7:
        Matcher r13 = (Matcher) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r11), new PrefetchContentLoaderImpl$getChannelFrom$1$2(r10)), PrefetchContentLoaderImpl$getChannelFrom$1$3.INSTANCE));     // Catch: Throwable -> L13
        if (r13 == null) goto L10;
        String r14 = StringsKt.substringBefore$default(c(r10, r13), '/', null, 2, null);     // Catch: Throwable -> L13
    L11:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L13
    L15:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L19;
        int r17 = x8.a.a;
        x8.a.b("PrefetchContentLoaderImpl", "extractChannel exception=" + r16.getMessage(), false);
    L19:
        if (Result.isFailure-impl(r15) == true) goto L23;
        r0 = r15;
    L23:
        return (String) r0;
    L10:
        r14 = null;
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final q a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageUrl");
        com.bytedance.android.latch.prefetch.internal.g r11 = this.a.get(b(r10));
        if (r11 == null) goto L6;
        return r11;
    L6:
        return this.a.get(null);
    }

    public final void reload(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageUrl");
        String r11 = b(r10);
        if (r11 == null) goto L6;
        this.b.invoke(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PrefetchContentLoaderImpl(Map<String, com.bytedance.android.latch.prefetch.internal.g> r10, Function1<? super String, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "processors");
        Intrinsics.checkNotNullParameter(r11, "onReload");
        this.a = r10;
        this.b = r11;
    }

    public static String c(String r10, Matcher r11) {
        int r0 = StringsKt.indexOf$default(r10, "?", 0, false, 6, null);
        int r1 = StringsKt.indexOf$default(r10, "#", 0, false, 6, null);
        Integer r12 = Integer.valueOf(RangesKt.coerceAtMost(r0, r1));
        if (r12.intValue() < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L9;
        r12 = null;
    L9:
        if (r12 == null) goto L11;
        int r14 = r12.intValue();
    L13:
        if (r14 == (-1)) goto L19;
        int r15 = r11.end();
        if (r10 == null) goto L18;
        String r16 = r10.substring(r15, r14);
    L23:
        return StringsKt.trim(r16, new char[]{'/'});
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        int r17 = r11.end();
        if (r10 == null) goto L25;
        r16 = r10.substring(r17);
        goto L23
    L25:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        r14 = RangesKt.coerceAtLeast(r0, r1);
        goto L13
    L5:
        r13 = false;
        goto L6
    }
}
