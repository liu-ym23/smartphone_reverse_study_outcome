package p82;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.pin.utils.PinAppLogger;
import com.bytedance.android.livesdk.message.model.fn;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t extends a {
    public final RoomContext e;

    @Override // p82.a
    public final int e() {
        return 2131567226;
    }

    public t(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        super(PanelItemSymbol.OPEN_VIDEO_SYMBOL);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.l r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return com.bytedance.android.livesdk.interactivity.utils.s.c(r2);
    }

    @Override // p82.a, com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.a
    public final void onClick(View r4) {
        super.onClick(r4);
        com.bytedance.android.livesdk.interactivity.api.entity.l r5 = this.b;
        com.bytedance.android.live.base.model.message.t r0 = null;
        if (r5 == null) goto L5;
        com.bytedance.android.live.base.model.message.t r6 = r5.b;
    L7:
        if ((r6 instanceof fn) == false) goto L10;
        r0 = r6;
    L10:
        fn r1 = (fn) r0;
        if (r1 == null) goto L13;
        PinAppLogger.e(r1.getItemId(), "view_video");
        this.e.getPlayAwemeVideoId().setValue(Long.valueOf(r1.getItemId()));
        this.e.getVideoPlaySource().setValue("comment_area");
    L13:
        com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api.e r7 = this.c;
        if (r7 == null) goto L17;
        r7.dismissDialog();
        return;
    L17:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
