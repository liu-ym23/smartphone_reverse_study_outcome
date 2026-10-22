package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetThreadsByPositionsResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/response/ChannelThreadResponse;", "it", "Lcom/bytedance/lark/pb/im/v1/GetThreadsByPositionsResponse;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ThreadRepositoryV2$getThreadByPositions$1 extends Lambda implements Function1<GetThreadsByPositionsResponse, l5b.b> {
    final /* synthetic */ Function1<GetThreadsByPositionsResponse, l5b.b> $respMap;

    public ThreadRepositoryV2$getThreadByPositions$1(Function1<? super GetThreadsByPositionsResponse, ? extends l5b.b> r1) {
        this.$respMap = r1;
        super(1);
    }

    public final l5b.b invoke(GetThreadsByPositionsResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (l5b.b) this.$respMap.invoke(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((GetThreadsByPositionsResponse) r1);
    }
}
