package kj0;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r0, int r1, String r2, int r3) {
            if ((r3 & 2) == 0) goto L5;
            r2 = "";
        L5:
            r0.setSelfDisciplineStatus(r1, r2, null);
        }
    }

    void addExtraLog(Map<String, String> r1);

    boolean canShowContributionPanelItem();

    void fastStartSelfDiscipline();

    c0.b getToolbarBehavior();

    boolean isSelfDisciplineOn();

    void logUpdateRoomIntro(String r1);

    void setSelfDisciplineStatus(int r1, String r2, Long r3);

    void showManagePanel(String r1);

    boolean supportSelfDiscipline();
}
