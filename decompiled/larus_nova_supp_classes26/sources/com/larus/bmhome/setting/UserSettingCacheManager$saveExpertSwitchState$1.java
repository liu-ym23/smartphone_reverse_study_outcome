package com.larus.bmhome.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.setting.UserSettingCacheManager", f = "UserSettingCacheManager.kt", i = {}, l = {836}, m = "saveExpertSwitchState", n = {}, s = {})
public final class UserSettingCacheManager$saveExpertSwitchState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserSettingCacheManager this$0;

    public UserSettingCacheManager$saveExpertSwitchState$1(UserSettingCacheManager r1, Continuation<? super UserSettingCacheManager$saveExpertSwitchState$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(false, this);
    }
}
