package aa2;

import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.presenter.n<ITextMessageView> implements vlc.l {
    public final boolean e;

    public final void detachView() {
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.removeMessageListener(this);
    }

    public b(boolean r1) {
        this.e = r1;
    }

    public final void A(ITextMessageView r2) {
        super.c0(r2);
        if (this.e == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastOChannelAnchorMessage", this);
        ((com.bytedance.android.livesdk.chatroom.presenter.n) this).d.addMessageListener("WebcastOChannelModifyMessage", this);
        return;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        A((ITextMessageView) r1);
    }

    public final void onMessage(tlc.d r2) {
        ITextMessageView r0 = ((q46.b) this).a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.lU(r2);
    }
}
