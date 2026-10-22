package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomChangeSyncData;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p {
    public static final boolean a() {
        IntercomSyncDataModel r0 = q.h();
        if (r0 == null) goto L11;
        dc2.c<IntercomChangeSyncData> r1 = r0.getIntercomStatus();
        if (r1 == null) goto L11;
        IntercomChangeSyncData r2 = r1.c();
        if (r2 == null) goto L11;
        if (r2.isInIntercom() != true) goto L11;
        return true;
    L11:
        return false;
    }
}
