package com.larus.bot.impl.feature.botmaker;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public static final String a(SpeakerVoice r2) {
        if (r2 != null) goto L4;
    L15:
        return null;
    L4:
        if (Intrinsics.areEqual(r2.getId(), TriggerSendLoading.NO_LOADING) == true) goto L15;
        if (Intrinsics.areEqual(r2.getId(), "none") == true) goto L15;
        if (Intrinsics.areEqual(r2.getCreatorId(), AccountService.a.getUserId()) == false) goto L12;
        return "self_created";
    L12:
        if (r2.isUgcVoice() == false) goto L14;
        return "others_created";
    L14:
        return "other_default";
    }
}
