package com.bytedance.android.live.room.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.arch.mvvm.d;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.rank.IAudienceRankType;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import w71.b;
import zo2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.AudienceRankService")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&J&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&J \u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H&J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/room/api/IAudienceRankService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/room/api/rank/IAudienceRankType;", "type", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getAudienceRankWidget", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getRoomPCU", "getDynamicRoomMemberCount", "", "getShareCountText", "Lw71/b;", "createAudienceRankContext", "", "Lzo2/a;", "getAudienceRankNitaViewList", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAudienceRankService extends IService {
    b createAudienceRankContext(DataCenter r1);

    List<a> getAudienceRankNitaViewList();

    Class<? extends LiveRecyclableWidget> getAudienceRankWidget(IAudienceRankType r1);

    d<Long> getDynamicRoomMemberCount(DataCenter r1, long r2);

    d<Long> getRoomPCU(DataCenter r1, long r2);

    String getShareCountText(DataCenter r1, long r2);
}
