package zx1;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.gamesticker.LiveGameStickerWidgetV2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.KVData;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ LiveGameStickerWidgetV2 a;

    public a(LiveGameStickerWidgetV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        LiveGameStickerWidgetV2 r0 = this.a;
        r0.c = (d) ((KVData) r3).getData();
        d r4 = this.a.c;
        if (r4 == null) goto L6;
        r4.addMessageListener(MessageType.GAME_ROOM_STICKER_OPR_MESSAGE.getIntType(), this.a.n);
        return;
    }
}
