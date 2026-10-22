package com.larus.bmhome.chat.component.feedback;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements y.a<wc9.e> {
    public final /* synthetic */ BotFeedbackComponent a;

    public h(BotFeedbackComponent r1) {
        this.a = r1;
    }

    public final void c(Object r7) {
        wc9.e r8 = (wc9.e) r7;
        Intrinsics.checkNotNullParameter(r8, "new");
        FLogger.a.d("BotFeedbackComponent" + hashCode(), "on Conversation Change: new = " + r8.a);
        u7 r0 = (u7) this.a.l.getValue();
        ChatFragment r1 = null;
        if (r0 == null) goto L14;
        List r2 = r0.zj();
        if (r2 == null) goto L14;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (d.G0((Message) r4) == false) goto L8;
    L13:
        Message r5 = (Message) r4;
    L16:
        if (StringsKt.contains$default(this.a.r, "local", false, 2, null) == true) goto L18;
    L23:
        BotFeedbackComponent r6 = this.a;
        r6.r = r8.a;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Fragment r9 = com.larus.ui.arch.component.internal.attach.a.b(r6, r6);
        if ((r9 instanceof ChatFragment) == false) goto L26;
        r1 = (ChatFragment) r9;
    L26:
        if (r1 == null) goto L28;
        String r10 = ChatControlTrace.b.h(r1.getChatUniqueKey());
    L29:
        r6.j = r10;
        return;
    L28:
        r10 = "other_default";
        goto L29
    L18:
        if (StringsKt.contains$default(r8.a, "local", false, 2, null) == true) goto L23;
        BotFeedbackComponent r11 = this.a;
        r11.s = true;
        if (r5 == null) goto L22;
        BotFeedbackComponent.F2(r11);
        goto L23
    L22:
        com.larus.im.d.e().registerOnMessageChangedObserver(r8.a, this.a.x);
        goto L23
    L12:
        r4 = null;
    L14:
        r5 = null;
        goto L16
    }
}
