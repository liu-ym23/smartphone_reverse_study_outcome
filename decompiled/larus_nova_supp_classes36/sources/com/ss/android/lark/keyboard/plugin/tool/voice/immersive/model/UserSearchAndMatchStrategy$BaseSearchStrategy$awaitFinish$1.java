package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$BaseSearchStrategy", f = "UserSearchAndMatchStrategy.kt", i = {0, 1}, l = {446, 449}, m = "awaitFinish$suspendImpl", n = {"$this", "$this"}, s = {"L$0", "L$0"})
public final class UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserSearchAndMatchStrategy.BaseSearchStrategy this$0;

    public UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1(UserSearchAndMatchStrategy.BaseSearchStrategy r1, Continuation<? super UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return UserSearchAndMatchStrategy.BaseSearchStrategy.e(this.this$0, this);
    }
}
