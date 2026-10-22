package n92;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.pin.utils.PinAppLogger;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ HighlightItem.f a;

    public e(HighlightItem.f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        RoomContext.a r9 = RoomContext.Companion;
        RoomContext r4 = RoomContext.a.c(r9, null, 0, 3);
        if (r4 == null) goto L7;
        m r5 = r4.getPlayAwemeVideoId();
        if (r5 == null) goto L7;
        r5.setValue(Long.valueOf(this.a.b()));
    L7:
        RoomContext r6 = RoomContext.a.c(r9, null, 0, 3);
        if (r6 == null) goto L12;
        m r7 = r6.getVideoPlaySource();
        if (r7 == null) goto L12;
        r7.setValue("pin_area");
    L12:
        RoomContext r10 = RoomContext.a.c(r9, null, 0, 3);
        if (r10 == null) goto L20;
        i r11 = r10.isAnchor();
        if (r11 == null) goto L20;
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L20;
        String r13 = "anchor";
    L23:
        PinAppLogger.f(String.valueOf(this.a.b()), r13);
        return;
    L20:
        if (hd0.c.f().h() == false) goto L22;
        r13 = "guest";
        goto L23
    L22:
        r13 = "audience";
        goto L23
    }
}
