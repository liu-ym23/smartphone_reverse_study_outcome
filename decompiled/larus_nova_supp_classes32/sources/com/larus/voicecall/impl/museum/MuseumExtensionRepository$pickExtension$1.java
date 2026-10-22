package com.larus.voicecall.impl.museum;

import com.mammon.audiosdk.enums.SAMICoreSessionRequestType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.museum.MuseumExtensionRepository", f = "MuseumExtensionRepository.kt", i = {0}, l = {SAMICoreSessionRequestType.SAMICore_Session_RequestType_BidirectionalTranslate}, m = "pickExtension", n = {"payload"}, s = {"L$0"})
public final class MuseumExtensionRepository$pickExtension$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MuseumExtensionRepository this$0;

    public MuseumExtensionRepository$pickExtension$1(MuseumExtensionRepository r1, Continuation<? super MuseumExtensionRepository$pickExtension$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
