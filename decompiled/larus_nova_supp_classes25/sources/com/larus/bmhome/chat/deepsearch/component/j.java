package com.larus.bmhome.chat.deepsearch.component;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements nf9.b {
    public final /* synthetic */ DeepSearchContentComponent a;
    public final /* synthetic */ String b;

    public final void a(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void b(String r2, MessageListState r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "msgList");
    }

    public final void d(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void f(String r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
        Intrinsics.checkNotNullParameter(r2, "cid");
        Intrinsics.checkNotNullParameter(r3, "oldMsgList");
        Intrinsics.checkNotNullParameter(r4, "newMsgList");
    }

    public j(DeepSearchContentComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void c(String r50, Message r51, Map<String, String> r52) {
        Intrinsics.checkNotNullParameter(r50, "cid");
        Intrinsics.checkNotNullParameter(r51, "msg");
        FLogger.a.d(this.a.m, "[biz_deep_search]MessageChangedObserver.onUpdateMessage content type " + r51.getContentType() + " :  " + this.b + " -> " + r51.getContent());
        Map r2 = r51.getExt();
        q0 r46 = null;
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("deep_search_from_id");
    L6:
        DeepSearchParam r4 = this.a.Y2();
        if (r4 == null) goto L9;
        String r5 = r4.b;
    L11:
        if (Intrinsics.areEqual(r3, r5) == false) goto L56;
        RecyclerView r6 = this.a.r;
        if (r6 == null) goto L15;
        RecyclerView.Adapter r7 = r6.getAdapter();
    L17:
        if ((r7 instanceof q0) == false) goto L19;
        q0 r15 = (q0) r7;
    L21:
        if (r15 != null) goto L23;
    L27:
        RecyclerView r1 = this.a.r;
        if (r1 == null) goto L30;
        RecyclerView.Adapter r8 = r1.getAdapter();
    L32:
        if ((r8 instanceof q0) == false) goto L34;
        q0 r9 = (q0) r8;
    L35:
        String r10 = "";
        if (r9 == null) goto L41;
        String r11 = r51.getMessageId();
        if (r11 != null) goto L40;
        r11 = "";
    L40:
        r9.x7(r11, 800);
    L41:
        RecyclerView r12 = this.a.r;
        if (r12 == null) goto L44;
        RecyclerView.Adapter r13 = r12.getAdapter();
    L46:
        if ((r13 instanceof q0) == false) goto L48;
        r46 = (q0) r13;
    L48:
        q0 r14 = r46;
        if (r14 == null) goto L57;
        String r16 = r51.getMessageId();
        if (r16 == null) goto L54;
        r10 = r16;
    L54:
        r14.x7(r10, 2);
        return;
    L57:
        return;
    L44:
        r13 = null;
        goto L46
    L34:
        r9 = null;
        goto L35
    L30:
        r8 = null;
        goto L32
    L23:
        if (com.larus.bmhome.chat.bean.d.j0(r51) == false) goto L25;
        List r17 = CollectionsKt.listOf(new Message[]{r51, Message.copy$default(r51, null, null, null, 0, 0, null, 2, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null)});
    L26:
        com.larus.bmhome.chat.deepsearch.j.a(r15, r17, false);
        goto L27
    L25:
        r17 = CollectionsKt.listOf(r51);
        goto L26
    L19:
        r15 = null;
        goto L21
    L15:
        r7 = null;
        goto L17
    L56:
        return;
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final void e(String r3, Message r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "cid");
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.d(this.a.m, "[biz_deep_search]MessageChangedObserver.onReceiveMessage, content type " + r4.getContentType() + " : " + this.b + " -> " + r4.getContent());
    }
}
