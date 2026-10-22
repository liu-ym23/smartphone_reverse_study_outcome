package com.bytedance.ai.uiu;

import com.bytedance.ai.model.m;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f2828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f2829b = null;

    static {
        f2828a = new Regex("(?=;[cligbnpt]:\\d{3})");
        f2829b = new Regex("^\\d{3}(&&\\d{3})*$");
    }

    public static g3.c a(String r10, String r11) {
        String r5 = "parseUIOperations data: ".concat(r10);
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.UIUMessageFormatter", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L6;
        r12.d("com.bytedance.ai.uiu.UIUMessageFormatter", r5);
    L6:
        if (r10.length() != 0) goto L9;
        return null;
    L9:
        if (StringsKt.P(r10, "\"") == false) goto L12;
        r10 = r10.substring(1);
    L12:
        if (StringsKt.k(r10, ";") == false) goto L14;
        r10 = StringsKt.dropLast(r10, 1);
    L14:
        List r13 = Regex.split$default(f2828a, r10, 0, 2, null);
        if (r13.isEmpty() == false) goto L20;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.UIUMessageFormatter", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L19;
        r14.d("com.bytedance.ai.uiu.UIUMessageFormatter", "parseUIOperations No data to split for uiOperations");
    L19:
        return null;
    L20:
        if (r11 != null) goto L23;
        r11 = (String) r13.get(0);
    L23:
        return new g3.c(r11, SequencesKt.toList(SequencesKt.flattenSequenceOfIterable(SequencesKt.mapNotNull(SequencesKt.drop(CollectionsKt.asSequence(r13), 1), new m(3)))));
    }
}
