package com.obric.memorydata.memory.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isValidAutoLearnAddress", "", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "memory_api_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final boolean a(AddressInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.isFromAutoLearn() == false) goto L38;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7.getName(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
    L8:
        double r3 = r7.getLongitude();
        if (Double.isInfinite(r3) == false) goto L11;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L38;
        double r4 = r7.getLongitude();
        if ((-180.0d) <= r4) goto L18;
    L20:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L38;
        double r5 = r7.getLatitude();
        if (Double.isInfinite(r5) == false) goto L25;
    L27:
        boolean r2 = false;
    L28:
        if (r2 == false) goto L38;
        double r6 = r7.getLatitude();
        if ((-90.0d) <= r6) goto L32;
    L34:
        boolean r8 = false;
    L35:
        if (r8 == false) goto L38;
        return true;
    L32:
        if (r6 > 90.0d) goto L34;
        r8 = true;
        goto L35
    L25:
        if (Double.isNaN(r5) == true) goto L27;
        r2 = true;
        goto L28
    L18:
        if (r4 > 180.0d) goto L20;
        r1 = true;
        goto L21
    L11:
        if (Double.isNaN(r3) == true) goto L13;
        r0 = true;
        goto L14
    L7:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7.getDetail(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
    L38:
        return false;
    }
}
