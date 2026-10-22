package com.bytedance.android.livesdk.chatroom.vsplayer.api;

import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r12, PlayerViewControl.KEY r13, PlayerViewControl.Type r14, PlayerViewControl.Style r15, View r16, float r17, boolean r18, boolean r19, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r20, int r21) {
            if ((r21 & 16) == 0) goto L5;
            float r7 = 0.0f;
        L7:
            if ((r21 & 32) == 0) goto L9;
            boolean r8 = false;
        L11:
            if ((r21 & 64) == 0) goto L13;
            boolean r9 = false;
        L15:
            if ((r21 & 128) == 0) goto L17;
            com.bytedance.android.livesdk.chatroom.vsplayer.model.a r10 = null;
        L18:
            r12.b(r13, r14, r15, r16, r7, r8, r9, r10, false);
            return;
        L17:
            r10 = r20;
            goto L18
        L13:
            r9 = r19;
            goto L15
        L9:
            r8 = r18;
            goto L11
        L5:
            r7 = r17;
            goto L7
        }
    }

    void a(PlayerViewControl.KEY r1, boolean r2);

    void b(PlayerViewControl.KEY r1, PlayerViewControl.Type r2, PlayerViewControl.Style r3, View r4, float r5, boolean r6, boolean r7, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r8, boolean r9);

    void c(PlayerViewControl.KEY r1);

    void changeVisibilityStatus();

    void clearControlWidget();

    void d(PlayerViewControl.KEY r1, boolean r2);

    void e(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r1);

    void f(Widget r1);

    NextLiveData<Integer> g(PlayerViewControl.KEY r1);

    boolean getLockStatus();

    boolean getVisibilityStatus();

    WidgetManager getWidgetManager();

    void h(PlayerViewControl.KEY r1);

    void i(RecyclableWidgetManager r1);

    void j(boolean r1);

    void markVisibilityStatusChangeByUser();

    VSPlayerViewControlContext provideContext();

    void releaseService();

    void resetHideTask();

    void setVisibilityStatus(boolean r1);
}
