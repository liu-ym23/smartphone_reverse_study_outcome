package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements am3.c<AnchorLinkMicIdInfo> {
    public i() {
    }

    public final Object decode(am3.g r7) throws Exception {
        AnchorLinkMicIdInfo r0 = new AnchorLinkMicIdInfo();
        r0.setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L15;
        am3.g.a r4 = r0.decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        r0.mainLinkMicId = am3.h.c(r7);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.backupLinkMicId = am3.h.c(r7);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.useBackupStream = am3.h.a(r7);
        goto L3
    L11:
        am3.h.d(r4, r7);
        goto L3
    L15:
        r7.d(r1);
        r0.setThreadSafe(true);
        return r0;
    }
}
