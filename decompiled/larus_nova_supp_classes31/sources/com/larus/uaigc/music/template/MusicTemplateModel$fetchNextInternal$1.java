package com.larus.uaigc.music.template;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateModel", f = "MusicTemplateRepository.kt", i = {0}, l = {76}, m = "fetchNextInternal", n = {"cursor"}, s = {"I$0"})
public final class MusicTemplateModel$fetchNextInternal$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicTemplateModel this$0;

    public MusicTemplateModel$fetchNextInternal$1(MusicTemplateModel r1, Continuation<? super MusicTemplateModel$fetchNextInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, this);
    }
}
