package wo0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends xo0.a {
    jr0.a getAudienceMiniGameWidgetDescriptor();

    void openMountedMiniGame(MountedMiniGameSource r1, String r2);

    void reportMpClick(MountedMiniGameSource r1);

    void reportMpShow();
}
