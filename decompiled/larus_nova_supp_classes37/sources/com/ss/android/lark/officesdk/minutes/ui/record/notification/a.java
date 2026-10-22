package com.ss.android.lark.officesdk.minutes.ui.record.notification;

import bwb.b;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.notification.MmRecordingNotificationType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final Map<MmRecordingNotificationType, Long> a;

    public a() {
        this.a = new LinkedHashMap();
    }

    public final void a(MmRecordingNotificationType r13, String r14, jub.a r15) {
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "content");
        Intrinsics.checkNotNullParameter(r15, "config");
        int r0 = b.a;
        MmUiLogScene r1 = MmUiLogScene.NOTIFICATION;
        b.g(r1, "show", "brand=doubao, type=" + r13 + ", throttle=" + r15.d, null, 8);
        long r8 = 0;
        if (r15.d <= 0) goto L12;
        Long r2 = (Long) ((LinkedHashMap) this.a).get(r13);
        if (r2 == null) goto L7;
        r8 = r2.longValue();
    L7:
        long r6 = System.currentTimeMillis();
        long r9 = r6 - r8;
        if (r9 >= r15.d) goto L11;
        b.g(r1, "show", "brand=doubao, type=" + r13 + ", throttled=" + r9 + "ms", null, 8);
        return;
    L11:
        this.a.put(r13, Long.valueOf(r6));
    L12:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.g(r14);
    }
}
