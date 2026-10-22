package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.bytedance.android.livesdk.feed.services.AppointmentService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSAnchorInfoWidget$timerListener$1 implements d9.b {
    public final /* synthetic */ VSAnchorInfoWidget a;

    @Override // com.bytedance.android.livesdk.chatroom.ui.d9.b
    public final String getTag() {
        return "VSAnchorInfoWidget";
    }

    public VSAnchorInfoWidget$timerListener$1(VSAnchorInfoWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.d9.b
    public final boolean a(long r3, long r5, int r7) {
        long r4 = r3 * r5;
        if (r4 < AppointmentService.SOURCE_UNDEFINED) goto L10;
        if (r7 != 0) goto L10;
        MarqueeTextView r6 = this.a.j;
        if (r6 == null) goto L8;
        r6.startMarqueeIfNeed(new VSAnchorInfoWidget$timerListener$1$onTick$1(this));
    L8:
        return true;
    L10:
        if (r4 < 110000) goto L16;
        if (r7 != 1) goto L18;
        MarqueeTextView r8 = this.a.j;
        if (r8 == null) goto L15;
        r8.startMarqueeIfNeed(new VSAnchorInfoWidget$timerListener$1$onTick$2(this));
    L15:
        return true;
    L18:
        return false;
    L16:
        return false;
    }
}
