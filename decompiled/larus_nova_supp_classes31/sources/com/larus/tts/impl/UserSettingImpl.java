package com.larus.tts.impl;

import com.bytedance.keva.Keva;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.g;
import com.larus.tts.IUserSettingRepoService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J.\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001fJ\n\u0010 \u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\rH\u0016J\u001a\u0010#\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\nH\u0016¨\u0006$"}, d2 = {"Lcom/larus/tts/impl/UserSettingImpl;", "Lcom/larus/tts/IUserSettingRepoService;", "<init>", "()V", "init", "", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "", "", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "source", "", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainBotTtsSwitch", "cvsId", "openTts", "getMainTtsSwitch", "setGlobalTtsSwitch", "getGlobalTtsSwitch", "getTtsSwitch", "hasSetTts", "", "setTts", "getMainBotUserChangedTtsSwitch", "setGlobalUserChangedTtsSwitch", "switch", "getGlobalUserChangedTtsSwitch", "saveIsInCvsList", "isInCvsList", "()Ljava/lang/Boolean;", "getCvsId", "saveCvsId", "convId", "setBotTtsSwitch", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UserSettingImpl implements IUserSettingRepoService {
    public UserSettingImpl() {
    }

    @Override // com.larus.tts.IUserSettingRepoService
    public final int b() {
        return j0.a();
    }

    @Override // com.larus.tts.IUserSettingRepoService
    public final int a(String r5) {
        Keva r0 = j0.a;
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        g.a.ensureNotReachHere("cvs id is null please check code !!!");
        return -1;
    L12:
        Keva r2 = j0.d();
        if (r2 != null) goto L15;
        return -1;
    L15:
        return r2.getInt("bot_tts_switch_" + r5, -1);
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
