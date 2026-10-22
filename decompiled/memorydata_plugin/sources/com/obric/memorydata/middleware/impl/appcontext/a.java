package com.obric.memorydata.middleware.impl.appcontext;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\"\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\u0007"}, d2 = {"normalizeOsDeviceId", "", EventBody.KEY_VALUE, "normalizeStoredOsDeviceId", "removeInvalidValue", "Lkotlin/Function0;", "", "middleware_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final String a(String r7) {
        if (r7 == null) goto L5;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        boolean r3 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L28;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        int r4 = 0;
    L15:
        if (r4 >= r1.length()) goto L25;
        char r5 = r1.charAt(r4);
        if ('0' <= r5) goto L19;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L23;
        r4 = r4 + 1;
        goto L15
    L23:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L28;
    L29:
        if (r3 == true) goto L31;
        return null;
    L31:
        return r8;
    L19:
        if (r5 >= ':') goto L21;
        r6 = true;
        goto L22
    L25:
        r9 = true;
    L28:
        r3 = false;
        goto L29
    L11:
        r2 = false;
        goto L12
    L5:
        r8 = null;
        goto L6
    }

    public static final String a(String r2, Function0<Unit> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "removeInvalidValue");
        String r0 = a(r2);
        if (r2 == null) goto L6;
        if (r0 != null) goto L6;
        r4.invoke();
    L6:
        return r0;
    }
}
