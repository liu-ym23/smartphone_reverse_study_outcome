package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowAskDoubaoPlugin", f = "FlowAskDoubaoPlugin.kt", i = {}, l = {145}, m = "insertAtDoubao", n = {}, s = {})
final class FlowAskDoubaoPlugin$insertAtDoubao$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowAskDoubaoPlugin this$0;

    public FlowAskDoubaoPlugin$insertAtDoubao$1(FlowAskDoubaoPlugin r1, Continuation<? super FlowAskDoubaoPlugin$insertAtDoubao$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return FlowAskDoubaoPlugin.F(this.this$0, this);
    }
}
