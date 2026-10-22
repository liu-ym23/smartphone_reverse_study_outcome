package com.bytedance.android.live.liveinteract.aimv;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.livesdk.message.model.LinkmicRoomSongMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import je0.d;
import kotlin.Metadata;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/aimv/LiveLinkmicAIMVWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lvlc/l;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveLinkmicAIMVWidget extends PlatformMultiLinkWidget implements l {
    public LiveLinkmicAIMVManager a;
    public final CompositeDisposable b;

    public LiveLinkmicAIMVWidget() {
        this.b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return d.f();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        LiveLinkmicAIMVManager r0 = new LiveLinkmicAIMVManager(((Widget) this).context, ((Widget) this).dataCenter, this);
        this.a = r0;
        ViewGroup r1 = ((Widget) this).containerView;
        xlc.a r3 = null;
        if ((r1 instanceof FrameLayout) == true) goto L5;
        r1 = null;
    L5:
        r0.a((FrameLayout) r1);
        xlc.a r2 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        if (r2 != null) goto L8;
        return;
    L8:
        if ((r2 instanceof xlc.a) == false) goto L11;
        r3 = r2;
    L11:
        xlc.a r4 = r3;
        if (r4 == null) goto L16;
        r4.y(MessageType.LINKMIC_ROOM_SONG_MESSAGE.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        this.b.dispose();
        LiveLinkmicAIMVManager r0 = this.a;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        vlc.d r1 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        if (r1 == null) goto L9;
        r1.removeMessageListener(this);
        return;
    }

    public final void onMessage(tlc.d r2) {
        if ((r2 instanceof LinkmicRoomSongMessage) == false) goto L8;
        LiveLinkmicAIMVManager r0 = this.a;
        if (r0 == null) goto L9;
        r0.c((LinkmicRoomSongMessage) r2);
        return;
    L9:
        return;
    }
}
