package com.larus.tts.impl;

import com.larus.platform.service.z2;
import com.larus.tts.IChatTtsService;
import com.larus.tts.UserSettingRepoDelegate;
import com.larus.utils.MainBotInfoUtil;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/tts/impl/ChatTtsServiceImpl;", "Lcom/larus/tts/IChatTtsService;", "<init>", "()V", "getTtsSwitchStatus", "", "ttsSwitch", "", "isMainBot", "cvsId", "", "getGlobalTtsSwitchStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ChatTtsServiceImpl implements IChatTtsService {
    public ChatTtsServiceImpl() {
        MainBotInfoUtil.a();
    }

    @Override // com.larus.tts.IChatTtsService
    public final boolean a(int r4) {
        if (r4 == (-1)) goto L7;
        if (r4 == 0) goto L6;
        if (r4 != 1) goto L6;
        return true;
    L6:
        return false;
    L7:
        lq9.i0 r5 = z2.a.U0().f();
        if (r5 == null) goto L6;
        if (r5.a() != true) goto L6;
        return true;
    }

    @Override // com.larus.tts.IChatTtsService
    public final boolean b(int r4, boolean r5, String r6) {
        if (r4 == (-1)) goto L7;
        if (r4 == 0) goto L6;
        if (r4 != 1) goto L6;
        return true;
    L6:
        return false;
    L7:
        if (r5 == true) goto L14;
        UserSettingRepoDelegate r7 = UserSettingRepoDelegate.a;
        if (r7.a(r6) == (-1)) goto L14;
        if (r7.a(r6) != 1) goto L6;
        return true;
    L14:
        lq9.i0 r8 = z2.a.U0().f();
        if (r8 == null) goto L6;
        if (r8.a() != true) goto L6;
        return true;
    }
}
