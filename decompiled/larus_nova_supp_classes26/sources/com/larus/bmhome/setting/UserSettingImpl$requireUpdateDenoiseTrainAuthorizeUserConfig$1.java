package com.larus.bmhome.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.UserSettingImpl", f = "UserSettingRepo.kt", i = {}, l = {34}, m = "requireUpdateDenoiseTrainAuthorizeUserConfig", n = {}, s = {})
public final class UserSettingImpl$requireUpdateDenoiseTrainAuthorizeUserConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserSettingImpl this$0;

    public UserSettingImpl$requireUpdateDenoiseTrainAuthorizeUserConfig$1(UserSettingImpl r1, Continuation<? super UserSettingImpl$requireUpdateDenoiseTrainAuthorizeUserConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(this);
    }
}
