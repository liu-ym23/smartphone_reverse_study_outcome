package mq1;

import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.VSRecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface v {

    public static final class a {
        public static /* synthetic */ void a(v r12, PlayerViewControl.KEY r13, PlayerViewControl.Type r14, PlayerViewControl.Style r15, View r16, float r17, boolean r18, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r19, int r20) {
            if ((r20 & 16) == 0) goto L5;
            float r7 = 0.0f;
        L7:
            if ((r20 & 32) == 0) goto L9;
            boolean r8 = false;
        L11:
            if ((r20 & 128) == 0) goto L13;
            com.bytedance.android.livesdk.chatroom.vsplayer.model.a r10 = null;
        L14:
            r12.b(r13, r14, r15, r16, r7, r8, false, r10, false);
            return;
        L13:
            r10 = r19;
            goto L14
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

    void h(VSRecyclableWidgetManager r1);

    void markVisibilityStatusChangeByUser();

    VSPlayerViewControlContext provideContext();

    void releaseService();

    void resetHideTask();

    void setVisibilityStatus(boolean r1);
}
