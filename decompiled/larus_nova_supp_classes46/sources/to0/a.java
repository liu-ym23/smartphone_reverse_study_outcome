package to0;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends uo0.a {
    void f();

    void g(Context r1, DataCenter r2);

    sq0.a getAudienceMiniAppWidgetDescriptor();

    gq0.a getShelfInfoBackendHandler();

    void hideMiniAppExplainCard();

    boolean isMiniAppExplainCardShowing();

    void onDestroy();

    void onSei(String r1);

    void onSnowFlakeShow(s r1);

    void openMountedMiniApp(MountedMiniAppSource r1);

    void openMountedMiniApp(String r1);

    void openSnowFlake();

    void reportAudienceLiveProjectionWatch(boolean r1);

    void reportAudienceLiveProjectionWatchDuration(long r1, boolean r3);

    void reportMpLiveLinkClick();

    void reportMpLiveLinkShow();

    void reportSnowFlakeAnimShow();

    void showMiniAppExplainCard();
}
