package x31;

import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface l {
    boolean isRequesting(IRoom r1);

    void onCancel(IRoom r1);

    void onInvite(IRoom r1, int r2, IRivalExtraInfo r3, int r4, m2 r5, List<IBattleRivalTag> r6, int r7, int r8, String r9, HashMap<String, String> r10, Boolean r12);
}
