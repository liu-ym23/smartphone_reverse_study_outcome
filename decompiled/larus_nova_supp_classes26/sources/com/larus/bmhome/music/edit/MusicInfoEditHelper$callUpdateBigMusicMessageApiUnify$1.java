package com.larus.bmhome.music.edit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicInfoEditHelper", f = "MusicInfoEditHelper.kt", i = {0, 0, 0, 0, 0}, l = {65}, m = "callUpdateBigMusicMessageApiUnify", n = {"$this$callUpdateBigMusicMessageApiUnify", "image", "callback", "messageId", "musicContent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicInfoEditHelper this$0;

    public MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1(MusicInfoEditHelper r1, Continuation<? super MusicInfoEditHelper$callUpdateBigMusicMessageApiUnify$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MusicInfoEditHelper.a(this.this$0, null, null, null, this);
    }
}
