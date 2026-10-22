package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements LinkEmojiTextView.f {
    public final /* synthetic */ RecalledContentBlock a;
    public final /* synthetic */ y6b.a<v5b.a<?>> b;

    public final boolean c(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        return false;
    }

    public a(RecalledContentBlock r1, y6b.a<v5b.a<?>> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d(View r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "userId");
        b0 r5 = ChatCoreModule.a().getProfileDependency();
        Context r6 = this.a.getContext();
        ProfileSource.a r0 = new ProfileSource.a();
        r0.e = r4;
        r0.d = this.b.getChatId();
        r0.b = 2;
        r0.c = k.a(this.a.c.getChat());
        r5.e(r6, r0.a());
    }
}
