package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 extends OnSingleClickListener {
    public final /* synthetic */ y6b.c<?> a;
    public final /* synthetic */ Chat b;
    public final /* synthetic */ z c;

    public final void onSingleClick(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        ArrayList<String> r6 = h7b.l.a(this.a.o);
        c2b.d.b(this.b.getId()).c(this.a.c);
        w4b.c r1 = ChatCoreModule.a();
        Context r2 = this.c.getContext();
        y6b.c<?> r0 = this.a;
        String r3 = r0.e;
        Message.Type r4 = r0.getType();
        String r5 = this.a.c;
        Object r10 = r9.getTag();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");
        r1.openReadStateDetailPage(r2, r3, r4, r5, r6, ((Boolean) r10).booleanValue());
        ChatCoreModule.a().getGuideDependency().b("mobile_read_status");
    }

    public b0(y6b.c<?> r1, Chat r2, z r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
