package com.ss.android.lark.message.vote.message;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoteContentVO extends v5b.a<CardContent> {
    public final Lazy b;

    public VoteContentVO(final CardContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.b = LazyKt.lazy(new VoteContentVO$richText$2(r2));
    }
}
