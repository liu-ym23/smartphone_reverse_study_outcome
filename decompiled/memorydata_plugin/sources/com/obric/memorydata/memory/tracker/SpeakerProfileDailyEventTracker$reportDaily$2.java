package com.obric.memorydata.memory.tracker;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class SpeakerProfileDailyEventTracker$reportDaily$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    SpeakerProfileDailyEventTracker$reportDaily$2(Object r8) {
        super(0, r8, UserSettings.class, "hasAgreePrivacyAndLogin", "hasAgreePrivacyAndLogin()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((UserSettings) ZeusTransformUtils.preCheckCast(this.receiver, UserSettings.class, "com.obric.memorydata.plugin")).hasAgreePrivacyAndLogin());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
