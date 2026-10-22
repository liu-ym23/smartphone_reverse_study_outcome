package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import com.bytedance.android.live.media.api.IMediaReplayService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/FullVideoServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullVideoServiceWidget extends MiddlewareRoomWidget {
    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        Room r1 = null;
        if (r0 == null) goto L5;
        Bundle r2 = r0.Wl();
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = ho1.a.d(getComponentContext());
        if (r3 == null) goto L9;
        r1 = r3.getRoom();
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.getBoolean("live.intent.extra.EXTRA_NO_FULL_VIDEO_BTN", false) == false) goto L13;
        return;
    L13:
        if (PadConfigUtils.c() == false) goto L15;
        return;
    L15:
        if (jc1.k.f(IMediaReplayService.class) == null) goto L20;
        IMediaReplayService r4 = jc1.k.f(IMediaReplayService.class);
        if (r4 == null) goto L20;
        if (r4.isShowGenerating() != true) goto L20;
        return;
    L20:
        RoomContext.a r5 = RoomContext.Companion;
        DataCenter r6 = ((Widget) this).dataCenter;
        long r7 = 0;
        if (r1 == null) goto L23;
        long r8 = r1.getId();
    L24:
        r5.getClass();
        if (RoomContext.a.a(r6, r8) == null) goto L39;
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r1 == null) goto L29;
        r7 = r1.getId();
    L29:
        RoomContext r10 = RoomContext.a.a(r9, r7);
        if (r10 == null) goto L40;
        com.bytedance.live.datacontext.m r11 = r10.getShowFullVideoButton();
        if (r11 == null) goto L41;
        r11.setValue(Boolean.TRUE);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L23:
        r8 = 0;
        goto L24
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
    }

    public FullVideoServiceWidget() {
    }
}
