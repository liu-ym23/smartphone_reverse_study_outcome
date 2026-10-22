package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/event/IEventContext;", "it", "Lcom/ss/android/lark/keyboard/biz/notify/MentionDoubaoNotify;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1 extends Lambda implements Function2<com.ss.android.lark.keyboard.event.g, znb.c, Unit> {
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c $chatApp;
    final /* synthetic */ a this$0;

    public FlowMentionDoubaoTipPlugin$observeKeyboardEvent$1(a r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2) {
        this.this$0 = r1;
        this.$chatApp = r2;
        super(2);
    }

    public final void invoke(com.ss.android.lark.keyboard.event.g r2, znb.c r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectNotify");
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.a == true) goto L6;
        Log.d("FlowMentionDoubaoTipPlugin", "observeKeyboardEvent: isMentionDoubao is false");
        return;
    L6:
        a r4 = this.this$0;
        com.ss.android.lark.storage.a r5 = a.g;
        r4.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((com.ss.android.lark.keyboard.event.g) r1, (znb.c) r2);
        return Unit.INSTANCE;
    }
}
