package j21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d {
    void onInitPageFailed(int r1);

    void onInviteeOrApplicantListChanged(List<? extends IBaseUser> r1, String r2);

    void onPersonalPageUpdate(List<? extends p> r1, List<? extends p> r2, List<? extends IBaseUser> r3, String r4);

    void onRequestChangeMultiTeamFailed();

    void onTeamPageUpdate(List<? extends p> r1, List<? extends p> r2, List<? extends IBaseUser> r3, String r4, Map<String, Long> r5, boolean r6);
}
