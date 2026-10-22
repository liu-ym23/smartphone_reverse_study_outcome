package j21;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    void onInviteeOrApplicantListChanged(List<? extends IBaseUser> r1);

    void onPageRecsFetch(List<? extends p> r1, List<? extends p> r2, List<? extends IBaseUser> r3, IRivalRankRecommendResponse r4, boolean r5);

    void onPageUpdate(List<? extends p> r1, List<? extends p> r2, List<? extends IBaseUser> r3, IRivalRankRecommendResponse r4, boolean r5);
}
