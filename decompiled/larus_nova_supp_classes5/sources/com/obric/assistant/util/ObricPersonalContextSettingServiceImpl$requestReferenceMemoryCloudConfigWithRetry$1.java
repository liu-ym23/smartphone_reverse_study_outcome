package com.obric.assistant.util;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.util.ObricPersonalContextSettingServiceImpl", f = "ObricPersonalContextSettingServiceImpl.kt", i = {0, 0}, l = {329, 342}, m = "requestReferenceMemoryCloudConfigWithRetry", n = {"index", "attempt"}, s = {"I$2", "I$3"})
public final class ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricPersonalContextSettingServiceImpl this$0;

    public ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1(ObricPersonalContextSettingServiceImpl r1, Continuation<? super ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= IntCompanionObject.MIN_VALUE;
        ObricPersonalContextSettingServiceImpl r3 = this.this$0;
        Uri r0 = ObricPersonalContextSettingServiceImpl.f;
        return r3.B(this);
    }
}
