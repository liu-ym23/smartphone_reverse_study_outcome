package com.larus.dora.api.offline.record;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService$DefaultImpls", f = "IDoraOfflineRecordSyncService.kt", i = {0}, l = {46}, m = "getSyncedRecording", n = {"vuiId"}, s = {"L$0"})
final class IDoraOfflineRecordSyncService$getSyncedRecording$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public IDoraOfflineRecordSyncService$getSyncedRecording$1(Continuation<? super IDoraOfflineRecordSyncService$getSyncedRecording$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r6 = this.label | Integer.MIN_VALUE;
        this.label = r6;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r6 - Integer.MIN_VALUE;
        IDoraOfflineRecordSyncService$getSyncedRecording$1 r7 = this;
    L6:
        Object r0 = r7.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r7.label;
        if (r1 == 0) goto L18;
        if (r1 != 1) goto L17;
        String r8 = (String) r7.L$0;
        ResultKt.throwOnFailure(r0);
        Iterator r2 = ((Iterable) r0).iterator();
    L11:
        if (r2.hasNext() == false) goto L23;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((e) r3).a, r8) == false) goto L11;
        return r3;
    L23:
        return null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r7.L$0 = null;
        r7.label = 1;
        throw null;
    L5:
        r7 = new IDoraOfflineRecordSyncService$getSyncedRecording$1(this);
        goto L6
    }
}
