package com.obric.memorydata.union.build;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0010\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0000¨\u0006\u0007"}, d2 = {"supportsPersonSpeakerSummary", "", "businessType", "", "normalizePersonSpeakerSummary", "", "rawSummary", "memory_build_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class l {
    public static final Map<String, String> a(Map<?, ?> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        r9 = MapsKt.emptyMap();
    L5:
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L40;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getKey();
        Object r4 = r2.getValue();
        Pair r5 = null;
        if (r3 == null) goto L13;
        String r6 = r3.toString();
        if (r6 == null) goto L13;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L14:
        String r11 = "";
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        if (r4 == null) goto L21;
        String r12 = r4.toString();
        if (r12 == null) goto L21;
        String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L22:
        if (r13 == null) goto L25;
        r11 = r13;
    L25:
        boolean r14 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L31;
    L37:
        if (r5 == null) goto L7;
        r0.add(r5);
        goto L7
    L31:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L34;
        r14 = false;
    L34:
        if (r14 == true) goto L37;
        r5 = TuplesKt.to(r7, r11);
        goto L37
    L28:
        r15 = false;
    L21:
        r13 = null;
    L13:
        r7 = null;
        goto L14
    L40:
        return (Map) ZeusTransformUtils.preCheckCast(MapsKt.toSortedMap(MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"))), Map.class, "com.obric.memorydata.plugin");
    }

    public static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "businessType");
        if (Intrinsics.areEqual(r1, "glasses") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "auditory") == true) goto L8;
        return false;
    }
}
