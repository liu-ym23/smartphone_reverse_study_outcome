package com.larus.dora.impl.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.settings.DoraSetting", f = "DoraSetting.kt", i = {}, l = {115}, m = "waitForDoraSettingInit", n = {}, s = {})
public final class DoraSetting$waitForDoraSettingInit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraSetting this$0;

    public DoraSetting$waitForDoraSettingInit$1(DoraSetting r1, Continuation<? super DoraSetting$waitForDoraSettingInit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(0, 0, this);
    }
}
