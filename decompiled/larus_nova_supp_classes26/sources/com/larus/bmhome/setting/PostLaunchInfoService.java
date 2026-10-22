package com.larus.bmhome.setting;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.require.IPostLaunchInfoService;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/setting/PostLaunchInfoService;", "Lcom/larus/bmhome/chat/api/require/IPostLaunchInfoService;", "<init>", "()V", "TAG", "", "requestAndSyncUserSettings", "Lkotlinx/coroutines/Job;", "launchData", "Lcom/larus/bmhome/auth/LaunchInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostLaunchInfoService implements IPostLaunchInfoService {
    public final String a;

    public PostLaunchInfoService() {
        this.a = "AuthViewModel";
    }

    public final Job a(LaunchInfo r7) {
        return BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new PostLaunchInfoService$requestAndSyncUserSettings$1(this, r7, null), 2, null);
    }
}
