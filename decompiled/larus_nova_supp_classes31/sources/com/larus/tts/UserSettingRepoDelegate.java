package com.larus.tts;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J.\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001aH\u0016J\u000f\u0010!\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\"J\n\u0010#\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0010H\u0016J\u001a\u0010&\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006'"}, d2 = {"Lcom/larus/tts/UserSettingRepoDelegate;", "Lcom/larus/tts/IUserSettingRepoService;", "<init>", "()V", "_delegate", "get_delegate", "()Lcom/larus/tts/IUserSettingRepoService;", "init", "", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "source", "", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainBotTtsSwitch", "cvsId", "openTts", "getMainTtsSwitch", "setGlobalTtsSwitch", "getGlobalTtsSwitch", "getTtsSwitch", "hasSetTts", "", "setTts", "getMainBotUserChangedTtsSwitch", "setGlobalUserChangedTtsSwitch", "switch", "getGlobalUserChangedTtsSwitch", "saveIsInCvsList", "isInCvsList", "()Ljava/lang/Boolean;", "getCvsId", "saveCvsId", "convId", "setBotTtsSwitch", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UserSettingRepoDelegate implements IUserSettingRepoService {
    public static final UserSettingRepoDelegate a = null;

    static {
        a = new UserSettingRepoDelegate();
    }

    private UserSettingRepoDelegate() {
    }

    @Override // com.larus.tts.IUserSettingRepoService
    public final int b() {
        IUserSettingRepoService r0 = (IUserSettingRepoService) ServiceManager.get().getService(IUserSettingRepoService.class);
        if (r0 != null) goto L6;
        r0 = new UserSettingRepoServiceNoop();
    L6:
        return r0.b();
    }

    @Override // com.larus.tts.IUserSettingRepoService
    public final int a(String r3) {
        IUserSettingRepoService r0 = (IUserSettingRepoService) ServiceManager.get().getService(IUserSettingRepoService.class);
        if (r0 != null) goto L6;
        r0 = new UserSettingRepoServiceNoop();
    L6:
        return r0.a(r3);
    }
}
