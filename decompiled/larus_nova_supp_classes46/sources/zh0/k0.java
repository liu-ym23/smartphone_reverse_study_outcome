package zh0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k0 implements jk0.e {
    public final /* synthetic */ RadioWidget a;

    @Override // jk0.e
    public final void onStop() {
        this.a.T = false;
        int r0 = s1.j(2131168503);
        int r2 = s1.j(2131168500);
        this.a.Zq(r0, r2);
        this.a.Sq(false, "");
        a(0);
    }

    public k0(RadioWidget r1) {
        this.a = r1;
    }

    public final void a(int r5) {
        if (InteractionWidgetsPosContext.getShared(((Widget) this.a).dataCenter, 0) == null) goto L5;
        InteractionWidgetsPosContext.getShared(((Widget) this.a).dataCenter, 0).getAudioTalkRadioBottomOffset().setValue(Integer.valueOf(r5));
    L5:
        DataCenter r6 = ((Widget) this.a).dataCenter;
        if (r6 == null) goto L9;
        r6.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "RadioWidget gone"));
        return;
    }

    @Override // jk0.e
    public final void onStart(String r5) {
        this.a.T = true;
        int r0 = s1.j(2131168507);
        int r2 = s1.j(2131168502);
        this.a.Zq(r0, r2);
        this.a.Sq(true, r5);
        a(s1.j(2131168509));
    }
}
