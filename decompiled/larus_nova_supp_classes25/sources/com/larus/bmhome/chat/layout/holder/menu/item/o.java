package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o extends a {
    public o() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r4) {
        return CollectionsKt.listOf(new Integer[]{2131907403, 2131908746}).contains(Integer.valueOf(r4));
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r4, View r5, ef8.b r6) {
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "menuContext");
        if (com.larus.bmhome.chat.bean.d.h0(r6.a) == false) goto L9;
        com.larus.bmhome.chat.api.q0.a r7 = r6.b;
        if (r7 == null) goto L21;
        u7 r8 = r7.u3();
        if (r8 == null) goto L22;
        r8.Y70(r6.a, 8);
        return true;
    L22:
        return true;
    L21:
        return true;
    L9:
        com.larus.bmhome.chat.api.q0.a r9 = r6.b;
        if (r9 == null) goto L14;
        u7 r10 = r9.u3();
        if (r10 == null) goto L14;
        r10.Mf(r6.a, 8);
    L14:
        ChatControlTrace r11 = ChatControlTrace.b;
        Message r12 = r6.a;
        by7.e r0 = r6.d;
        Function0<Long> r13 = r6.e;
        if (r13 == null) goto L17;
        long r1 = ((Number) r13.invoke()).longValue();
    L18:
        r11.getClass();
        ChatControlTrace.L("long_press_answer", r12, r0, r1);
        return true;
    L17:
        r1 = -1;
        goto L18
    }
}
