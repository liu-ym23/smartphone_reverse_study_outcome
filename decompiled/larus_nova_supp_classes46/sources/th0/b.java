package th0;

import com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements com.bytedance.android.live.liveinteract.widget.widget.a {
    public final /* synthetic */ MultiLinkVideoBaseGuestLinkWidget a;

    @Override // com.bytedance.android.live.liveinteract.widget.widget.a
    public final void show() {
        ChatMatchWidget r0 = this.a.t;
        if (r0 == null) goto L6;
        ChatMatchWidget.Aq(r0, null, true, null, 12);
        return;
    }

    public b(MultiLinkVideoBaseGuestLinkWidget r1) {
        this.a = r1;
    }
}
