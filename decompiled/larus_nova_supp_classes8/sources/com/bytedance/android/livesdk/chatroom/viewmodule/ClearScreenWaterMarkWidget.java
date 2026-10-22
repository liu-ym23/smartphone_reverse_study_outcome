package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/ClearScreenWaterMarkWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClearScreenWaterMarkWidget extends LiveRecyclableWidget {
    public final int getLayoutId() {
        return 2131568044;
    }

    public final String getSpm() {
        return "a100.a100.a122";
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    public ClearScreenWaterMarkWidget() {
    }

    public final void onLoad(Object[] r4) {
        String r1 = null;
        Room r5 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        if (r5 == null) goto L5;
        User r6 = r5.getOwner();
    L6:
        ImageView r0 = (ImageView) findViewById(2131393015);
        if (r6 == null) goto L9;
        ImageModel r2 = r6.getAvatarThumb();
    L10:
        ImageUtil.loadRoundImage(r0, r2);
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L13;
        View r7 = r3.findViewById(2131391723);
    L14:
        TextView r8 = (TextView) r7;
        if (r8 == null) goto L20;
        if (r6 == null) goto L18;
        r1 = r6.getNickName();
    L18:
        r8.setText(r1);
        return;
    L20:
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
