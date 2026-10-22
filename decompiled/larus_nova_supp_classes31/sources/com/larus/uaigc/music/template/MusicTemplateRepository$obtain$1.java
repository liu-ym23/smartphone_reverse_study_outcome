package com.larus.uaigc.music.template;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateRepository", f = "MusicTemplateRepository.kt", i = {0}, l = {139}, m = "obtain", n = {"consume"}, s = {"Z$0"})
public final class MusicTemplateRepository$obtain$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicTemplateRepository this$0;

    public MusicTemplateRepository$obtain$1(MusicTemplateRepository r1, Continuation<? super MusicTemplateRepository$obtain$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, this);
    }
}
