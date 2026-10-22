package com.larus.aweme.api.video.service;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H'J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/aweme/api/video/service/IAwemeVideoFeedService;", "", "updateDataCache", "", "isEnableDouyinFeedCocoEntrance", "", "isEnableDouyinFeedBotEntrance", "isEnableDouyinFeedBottomTabEntrance", "isEnableDouYinSdk", "getSearchSceneId", "", "getSceneId", "getPushEntranceType", "", "()Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IAwemeVideoFeedService {
    String a();

    boolean b();

    void c();

    boolean d();

    boolean e();

    @Deprecated(message = "tab style not use user/launch to config, use tabbar/config api", replaceWith = @ReplaceWith(expression = "BottomTabConfigManager", imports = {}))
    boolean f();

    String getSceneId();
}
