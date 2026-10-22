package p32;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.PinContainerHighlightProcessor;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface c {
    View f(int r1);

    Context getContext();

    DataCenter getDataCenter();

    RoomContext getDataContext();

    void o(PinContainerHighlightProcessor r1);

    void z(e r1);
}
