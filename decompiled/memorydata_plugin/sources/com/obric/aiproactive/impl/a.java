package com.obric.aiproactive.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0005"}, d2 = {"normalizeAiProactiveUserId", "", "userId", "hasValidAiProactiveUserId", "", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final String a(String r4) {
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == true) goto L19;
        return null;
    L19:
        return r5;
    L14:
        if (Intrinsics.areEqual(r5, "0") == true) goto L16;
    L11:
        r0 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public static final boolean b(String r0) {
        if (a(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
