package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.dto.chat.ProfileSource;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class y implements f1.a {
    public final /* synthetic */ MessageDingDescBlock a;
    public final /* synthetic */ y6b.a<?> b;

    /* JADX WARN: Type inference failed for: r0v1, types: [v5b.a] */
    @Override // com.ss.android.lark.chat.utils.f1.a
    public final void o1() {
        ArrayList<String> r6 = h7b.l.a(this.b.b());
        ChatCoreModule.a().openReadStateDetailPage(this.a.getContext(), this.b.getChatId(), this.b.getType(), this.b.getId(), r6, true);
    }

    @Override // com.ss.android.lark.chat.utils.f1.a
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        w4b.b0 r0 = ChatCoreModule.a().getProfileDependency();
        Context r1 = this.a.getContext();
        ProfileSource.a r2 = new ProfileSource.a();
        r2.e = r4;
        r2.b = 2;
        r2.c = com.ss.android.lark.chat.utils.k.a(this.a.c.getChat());
        r0.e(r1, r2.a());
    }

    public y(MessageDingDescBlock r1, y6b.a<?> r2) {
        this.a = r1;
        this.b = r2;
    }
}
