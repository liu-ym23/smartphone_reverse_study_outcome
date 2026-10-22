package com.ss.android.lark.flow.feed.cell.chat;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.flow.feed.utils.FlowEventManager;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.flow.feed.utils.d {
    public final /* synthetic */ FlowChatAction a;
    public final /* synthetic */ String b;
    public final /* synthetic */ UIFeedCard c;

    @Override // com.ss.android.lark.flow.feed.utils.d
    public final void a(Object r5) {
        Intrinsics.checkNotNullParameter("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED", "eventName");
        Lazy r2 = FlowEventManager.a;
        Intrinsics.checkNotNullParameter("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED", "eventName");
        Intrinsics.checkNotNullParameter(this, "callback");
        Lazy r1 = FlowEventManager.a;     // Catch: Throwable -> L9
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) ((ConcurrentHashMap) r1.getValue()).get("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED");     // Catch: Throwable -> L9
        if (r3 == null) goto L11;
        r3.remove(this);     // Catch: Throwable -> L9
        if (r3.isEmpty() == false) goto L11;
        ((ConcurrentHashMap) r1.getValue()).remove("EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED");     // Catch: Throwable -> L9
    L11:
        Log.d("FlowEventManager", "unRegisterEvent: EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED, callback: " + hashCode());
        if ((r5 instanceof String) == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r5, "click_btn_know") == false) goto L20;
        FlowChatAction r6 = this.a;
        String r0 = this.b;
        Intrinsics.checkNotNull(r0);
        r6.r(r0, this.c);
        return;
    L20:
        return;
    L9:
        th = move-exception;
        Log.e("FlowEventManager", "unRegisterEvent error, EVENT_FLOW_CHAT_DISMISS_DIALOG_CLOSED, error: " + th.getMessage());
        goto L11
    }

    public a(FlowChatAction r1, String r2, UIFeedCard r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
