package com.obric.aiagent.messenger.stub;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.AppIntentIDLStub", f = "AppIntentIDLStub.kt", i = {0, 0}, l = {249}, m = "handleCheckPermission", n = {CloudControlInf.PERMISSION, "isResumed"}, s = {"L$0", "L$1"})
public final class AppIntentIDLStub$handleCheckPermission$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppIntentIDLStub this$0;

    public AppIntentIDLStub$handleCheckPermission$1(AppIntentIDLStub r1, Continuation<? super AppIntentIDLStub$handleCheckPermission$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return AppIntentIDLStub.access$handleCheckPermission(this.this$0, null, false, this);
    }
}
