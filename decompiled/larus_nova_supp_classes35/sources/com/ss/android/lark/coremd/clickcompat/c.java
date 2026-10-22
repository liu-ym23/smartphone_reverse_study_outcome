package com.ss.android.lark.coremd.clickcompat;

import b3b.j;
import b3b.s;
import com.ss.android.lark.biz.im.api.message.params.l;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class c implements l {
    public final ChatImageClickHandler a;
    public final ChatAtClickHandler b;
    public final ChatLinkClickHandler c;
    public final ChatMediaClickHandler d;
    public final ChatCodeBlockClickHandler e;
    public final com.ss.android.lark.coremd.clickcompat.b f;
    public final com.ss.android.lark.coremd.clickcompat.a g;
    public final d h;

    public static final class a {
        public final j a;
        public final s b;

        public a(j r1, s r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface b {
        y6b.a<?> getMessageById(String r1);
    }

    public ChatMediaClickHandler a() {
        return this.d;
    }

    public c(m2b.a r3, g.b r4, a r5) {
        Intrinsics.checkNotNullParameter(r3, "chatContext");
        Intrinsics.checkNotNullParameter(r4, "messageProvider");
        this.a = new ChatImageClickHandler(r3, r4, r5, null);
        this.b = new ChatAtClickHandler(r3, r4);
        this.c = new ChatLinkClickHandler(r3, r4, r5);
        this.d = new ChatMediaClickHandler(r3, r4, null);
        this.e = new ChatCodeBlockClickHandler(r3, r4);
        this.f = new com.ss.android.lark.coremd.clickcompat.b(r3);
        this.g = new com.ss.android.lark.coremd.clickcompat.a(r3, r4);
        this.h = new d(r3, r4);
    }
}
