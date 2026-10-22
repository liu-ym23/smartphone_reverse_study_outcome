package com.bytedance.android.ec.core.imagex.opt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final DomainPreConnect a() {
        ImageDomainPreConnectConfig r0 = ImageDomainPreConnectConfig.d;
        r0.getClass();
        if (((Boolean) ImageDomainPreConnectConfig.b.getValue()).booleanValue() == false) goto L14;
        com.bytedance.android.shopping.api.image.a0 r1 = (com.bytedance.android.shopping.api.image.a0) ImageDomainPreConnectConfig.c.getValue(r0, ImageDomainPreConnectConfig.a[0]);
        if (r1 == null) goto L7;
        Integer r10 = r1.a();
    L8:
        if (r10 != null) goto L11;
        return null;
    L11:
        if (r10.intValue() == 1) goto L13;
        return null;
    L13:
        return DomainPreConnect.c;
    L7:
        r10 = null;
        goto L8
    L14:
        return null;
    }
}
