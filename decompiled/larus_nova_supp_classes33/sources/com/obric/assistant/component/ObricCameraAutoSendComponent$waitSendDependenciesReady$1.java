package com.obric.assistant.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricCameraAutoSendComponent", f = "ObricCameraAutoSendComponent.kt", i = {}, l = {122}, m = "waitSendDependenciesReady", n = {}, s = {})
public final class ObricCameraAutoSendComponent$waitSendDependenciesReady$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricCameraAutoSendComponent this$0;

    public ObricCameraAutoSendComponent$waitSendDependenciesReady$1(ObricCameraAutoSendComponent r1, Continuation<? super ObricCameraAutoSendComponent$waitSendDependenciesReady$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ObricCameraAutoSendComponent r3 = this.this$0;
        int r0 = ObricCameraAutoSendComponent.o;
        return r3.h3(this);
    }
}
