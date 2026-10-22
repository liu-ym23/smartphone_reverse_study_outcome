package com.larus.bmhome.chat.api.require;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/api/require/IPostLaunchInfoService;", "", "requestAndSyncUserSettings", "Lkotlinx/coroutines/Job;", "launchData", "Lcom/larus/bmhome/auth/LaunchInfo;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IPostLaunchInfoService {
    Job a(LaunchInfo r1);
}
