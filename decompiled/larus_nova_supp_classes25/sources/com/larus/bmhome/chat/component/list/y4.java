package com.larus.bmhome.chat.component.list;

import android.view.View;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.chat.model.strategy.AnswerAnchorTopStrategy;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y4 implements Function1 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ LarusPageChatBinding b;

    public /* synthetic */ y4(ChatListComponent r1, LarusPageChatBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r6) {
        final ChatListComponent r0 = this.a;
        LarusPageChatBinding r1 = this.b;
        int r2 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter((View) r6, "it");
        r0.b7("chat_fast_button_callback_enter");
        if (r1.n.getChildCount() <= 0) goto L51;
        ChatMessageList r7 = r1.n;
        boolean r3 = false;
        r7.i = false;
        r7.j = false;
        if (r7.canScrollVertically(1) == true) goto L8;
        r7.setBottomReached(true);
    L8:
        if (((TextCellCutType) r0.L.getValue()) == TextCellCutType.DeepThinkCutMultipleCell) goto L16;
        com.larus.bmhome.chat.component.showcase.y r8 = r0.x5();
        if (r8 != null) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == true) goto L16;
    L17:
        com.larus.bmhome.double_post.drag_panel.l0 r10 = (com.larus.bmhome.double_post.drag_panel.l0) r0.Z2.getValue();
        if (r10 == null) goto L20;
        r10.t5();
    L20:
        AnswerAnchorTopStrategy.c = false;
        wc9.e r11 = r0.R4();
        if (r11 == null) goto L25;
        String r12 = r11.a;
        if (r12 == null) goto L25;
        ConcurrentHashMap r4 = com.larus.bmhome.utils.v3.a;
        com.larus.bmhome.utils.v3.e(r12);
    L25:
        r0.b7("handle_start");
        r0.c7("click_start");
        ChatMessageList r13 = r0.o5();
        if (r13 != null) goto L29;
    L39:
        if (r3 == false) goto L50;
        r0.b7("handle_defer");
        ChatMessageList r14 = r0.o5();
        if (r14 == null) goto L53;
        if (r0.F == false) goto L46;
        FLogger.a.i("pending-unread-scroll-click", "defer click decision skipped: already pending");
        r0.b7("defer_drop_already_pending");
        goto L53
    L46:
        r0.F = true;
        FLogger.a.i("pending-unread-scroll-click", "defer click decision until next frame: scrollState=" + r14.getScrollState() + " programmaticActive=" + r0.S3);
        if (r14.getScrollState() == 0) goto L49;
        r14.stopScroll();
    L49:
        r0.X3("click_defer_before_retry");
        r14.postOnAnimation(new n0(r0));
    L53:
        return Unit.INSTANCE;
    L50:
        r0.f7();
        goto L53
    L29:
        if (r0.F6() == false) goto L39;
        if (r0.j6() == false) goto L39;
        if (r0.S3 == false) goto L37;
    L38:
        r3 = true;
        goto L39
    L37:
        if (r13.getScrollState() == 0) goto L39;
    L12:
        if (r8.iQ() != true) goto L14;
        r9 = true;
    L16:
        r1.n.setBottomReached(true);
        goto L17
    L51:
        r0.b7("chat_fast_button_callback_drop_child_empty");
        goto L53
    }
}
