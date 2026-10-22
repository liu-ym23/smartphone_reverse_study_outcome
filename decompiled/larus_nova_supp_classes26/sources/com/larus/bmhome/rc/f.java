package com.larus.bmhome.rc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final String a(ResourceInstantUploadInfo r3, String r4) {
        if (r3 == null) goto L19;
        String r0 = r3.getRegisterUri();
        if (r0 == null) goto L20;
        boolean r1 = false;
        if (Intrinsics.areEqual(r3.getPreQueryHit(), Boolean.TRUE) == true) goto L8;
    L13:
        if (r1 == true) goto L16;
        r0 = null;
    L16:
        if (r0 != null) goto L18;
        return r4;
    L18:
        return r0;
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        r1 = true;
        goto L13
    L10:
        r5 = false;
        goto L11
    L20:
        return r4;
    L19:
        return r4;
    }

    public static final FlowResourceMeta b(FlowResourceMeta r22, ResourceInstantUploadInfo r23, Long r24) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        if (r23 != null) goto L5;
        return r22;
    L5:
        ResourceFingerprintMeta r5 = r23.getFingerprintMeta();
        if (r5 != null) goto L9;
        ResourceFingerprintMeta r6 = null;
    L18:
        if (Intrinsics.areEqual(r23.getPreQueryHit(), Boolean.TRUE) == false) goto L46;
        ResourceTargetMeta r7 = r23.getTargetMeta();
        if (r7 == null) goto L46;
        String r8 = r7.getTargetUri();
        if (r8 == null) goto L46;
        boolean r9 = true;
        if (r8.length() <= 0) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == true) goto L32;
        r8 = null;
    L32:
        if (r8 == null) goto L46;
        String r11 = r7.getTargetResourceId();
        if (r11 == null) goto L46;
        if (r11.length() > 0) goto L40;
        r9 = false;
    L40:
        if (r9 == true) goto L43;
        r11 = null;
    L43:
        if (r11 == null) goto L46;
        ResourceTargetMeta r12 = new ResourceTargetMeta(r8, r11);
    L48:
        return FlowResourceMeta.copy$default(r22, null, null, null, null, r6, r12, 15, null);
    L28:
        r10 = false;
    L46:
        r12 = null;
        goto L48
    L9:
        if (Intrinsics.areEqual(r23.getPreQueryHit(), Boolean.TRUE) == false) goto L11;
        Long r13 = null;
    L16:
        r6 = ResourceFingerprintMeta.copy$default(r5, null, null, null, null, null, null, r13, null, null, null, null, null, null, 8127, null);
        goto L18
    L11:
        if (r24 != null) goto L13;
    L15:
        r13 = r5.getFileSize();
        goto L16
    L13:
        if (r24.longValue() <= 0) goto L15;
        r13 = r24;
        goto L16
    }
}
