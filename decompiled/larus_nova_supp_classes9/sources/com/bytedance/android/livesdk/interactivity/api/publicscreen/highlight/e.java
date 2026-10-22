package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.TopicDismissTrigger;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements m.b {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m.b
    public final TopicDismissTrigger a(DataCenter r5, b6.b r6) {
        Intrinsics.checkNotNullParameter(r6, "trigger");
        gb2.a.a(r5, false);
        Long r7 = r6.a();
        long r0 = TriggerKey.TopicDismiss.getId();
        if (r7 != null) goto L6;
    L8:
        return null;
    L6:
        if (r7.longValue() != r0) goto L8;
        return new TopicDismissTrigger(r5);
    }
}
