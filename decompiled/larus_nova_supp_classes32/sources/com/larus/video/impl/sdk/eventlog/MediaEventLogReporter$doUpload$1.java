package com.larus.video.impl.sdk.eventlog;

import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.sdk.eventlog.MediaEventLogReporter", f = "MediaEventLogReporter.kt", i = {}, l = {MessageContentType.CONTENT_TYPE_MULTI_CONTENT}, m = "doUpload", n = {}, s = {})
final class MediaEventLogReporter$doUpload$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaEventLogReporter this$0;

    public MediaEventLogReporter$doUpload$1(MediaEventLogReporter r1, Continuation<? super MediaEventLogReporter$doUpload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MediaEventLogReporter.a(this.this$0, null, null, this);
    }
}
