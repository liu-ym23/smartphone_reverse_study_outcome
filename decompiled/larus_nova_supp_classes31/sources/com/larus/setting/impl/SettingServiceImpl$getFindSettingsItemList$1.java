package com.larus.setting.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.SettingServiceImpl", f = "SettingServiceImpl.kt", i = {0, 0, 0, 0}, l = {131}, m = "getFindSettingsItemList", n = {"activity", "result", "model", "phoneNumber"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class SettingServiceImpl$getFindSettingsItemList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingServiceImpl this$0;

    public SettingServiceImpl$getFindSettingsItemList$1(SettingServiceImpl r1, Continuation<? super SettingServiceImpl$getFindSettingsItemList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
