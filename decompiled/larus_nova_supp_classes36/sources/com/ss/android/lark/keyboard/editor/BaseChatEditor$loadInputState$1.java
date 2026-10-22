package com.ss.android.lark.keyboard.editor;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import mob.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.editor.BaseChatEditor", f = "BaseChatEditor.kt", i = {0, 0}, l = {62}, m = "loadInputState$suspendImpl", n = {"$this", "isInitial"}, s = {"L$0", "Z$0"})
public final class BaseChatEditor$loadInputState$1<T extends mob.a> extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseChatEditor<T> this$0;

    public BaseChatEditor$loadInputState$1(BaseChatEditor<T> r1, Continuation<? super BaseChatEditor$loadInputState$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return BaseChatEditor.c(this.this$0, false, this);
    }
}
