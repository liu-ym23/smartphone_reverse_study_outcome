package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ShareGroupChatContentVO extends v5b.a<ShareGroupChatContent> {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public ShareGroupChatContentVO(final ShareGroupChatContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.b = LazyKt.lazy(new ShareGroupChatContentVO$chat$2(r2));
        this.c = LazyKt.lazy(new ShareGroupChatContentVO$joinToken$2(r2));
        this.d = LazyKt.lazy(new ShareGroupChatContentVO$expireTime$2(r2));
        this.e = LazyKt.lazy(new ShareGroupChatContentVO$joinChatErrState$2(r2));
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r7) {
        if (super.d(r7) == true) goto L5;
        return false;
    L5:
        if (r7 != null) goto L7;
        return false;
    L7:
        if ((r7 instanceof ShareGroupChatContentVO) == false) goto L15;
        ShareGroupChatContentVO r8 = (ShareGroupChatContentVO) r7;
        if (((Number) this.d.getValue()).longValue() == ((Number) r8.d.getValue()).longValue()) goto L11;
        return false;
    L11:
        if (((ShareGroupChatContent.GroupState) this.e.getValue()) != ((ShareGroupChatContent.GroupState) r8.e.getValue())) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    }
}
