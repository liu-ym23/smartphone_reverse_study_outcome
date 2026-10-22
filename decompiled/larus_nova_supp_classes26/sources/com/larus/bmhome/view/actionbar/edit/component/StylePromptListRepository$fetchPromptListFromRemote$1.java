package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.StylePromptListRepository", f = "StylePromptListCache.kt", i = {}, l = {141}, m = "fetchPromptListFromRemote", n = {}, s = {})
public final class StylePromptListRepository$fetchPromptListFromRemote$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StylePromptListRepository this$0;

    public StylePromptListRepository$fetchPromptListFromRemote$1(StylePromptListRepository r1, Continuation<? super StylePromptListRepository$fetchPromptListFromRemote$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        StylePromptListRepository r3 = this.this$0;
        StylePromptListRepository r0 = StylePromptListRepository.a;
        return r3.a(null, this);
    }
}
