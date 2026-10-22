package com.larus.bmhome.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.UserSettingRepo", f = "UserSettingRepo.kt", i = {0, 0}, l = {277}, m = "requireAllUserConfig", n = {"requestSecUserId", "includesAdminPreview"}, s = {"L$0", "Z$0"})
public final class UserSettingRepo$requireAllUserConfig$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserSettingRepo this$0;

    public UserSettingRepo$requireAllUserConfig$1(UserSettingRepo r1, Continuation<? super UserSettingRepo$requireAllUserConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, 0, null, this);
    }
}
