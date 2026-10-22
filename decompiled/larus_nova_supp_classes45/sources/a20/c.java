package a20;

import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c {

    public static final class a {
        public static boolean a(c r0) {
            return r0.f().isInLive();
        }
    }

    AbsOpenFeaturePanelViewModel f();

    void onDestroy();
}
