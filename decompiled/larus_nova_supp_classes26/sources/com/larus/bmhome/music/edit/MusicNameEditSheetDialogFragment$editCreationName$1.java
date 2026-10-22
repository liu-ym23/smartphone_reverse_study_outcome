package com.larus.bmhome.music.edit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicNameEditSheetDialogFragment", f = "MusicNameEditSheetDialogFragment.kt", i = {0, 0}, l = {269}, m = "editCreationName", n = {"name", "editNameCallback"}, s = {"L$0", "L$1"})
final class MusicNameEditSheetDialogFragment$editCreationName$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MusicNameEditSheetDialogFragment this$0;

    public MusicNameEditSheetDialogFragment$editCreationName$1(MusicNameEditSheetDialogFragment r1, Continuation<? super MusicNameEditSheetDialogFragment$editCreationName$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MusicNameEditSheetDialogFragment.U90(this.this$0, null, null, this);
    }
}
