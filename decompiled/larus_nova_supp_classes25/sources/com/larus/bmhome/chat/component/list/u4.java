package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import de8.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u4 implements Function2 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ u4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5, Object r6) {
        ChatListComponent r0 = this.a;
        String r7 = (String) r5;
        q99.e r8 = (q99.e) r6;
        int r1 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r7, "eventName");
        if (Intrinsics.areEqual(r7, "complete_dislike_reason") == false) goto L11;
        if (r8 == null) goto L11;
        Message r9 = r0.e4(r8);
        if (r9 == null) goto L13;
        ChatControlTrace r2 = ChatControlTrace.b;
        long r3 = d.a(r0.f1());
        String r10 = r8.d;
        r2.getClass();
        JSONObject r11 = ChatControlTrace.b(r9, r3, r10);
        if (r11 == null) goto L13;
        return r11;
    L13:
        return new JSONObject();
    L11:
        return new JSONObject();
    }
}
