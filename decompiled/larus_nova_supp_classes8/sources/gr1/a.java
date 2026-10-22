package gr1;

import com.bytedance.android.livesdk.chatroom.vsplayer.api.b;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.c;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    b provideVSPlayerTipService(DataCenter r1);

    c provideVSPlayerViewControlService(DataCenter r1);

    void releaseService(DataCenter r1);
}
