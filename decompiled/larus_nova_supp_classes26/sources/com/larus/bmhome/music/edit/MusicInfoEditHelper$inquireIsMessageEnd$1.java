package com.larus.bmhome.music.edit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicInfoEditHelper", f = "MusicInfoEditHelper.kt", i = {}, l = {185}, m = "inquireIsMessageEnd", n = {}, s = {})
final class MusicInfoEditHelper$inquireIsMessageEnd$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicInfoEditHelper this$0;

    public MusicInfoEditHelper$inquireIsMessageEnd$1(MusicInfoEditHelper r1, Continuation<? super MusicInfoEditHelper$inquireIsMessageEnd$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MusicInfoEditHelper.c(this.this$0, null, this);
    }
}
