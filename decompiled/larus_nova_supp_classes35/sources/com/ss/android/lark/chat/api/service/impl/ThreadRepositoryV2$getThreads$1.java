package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.MGetThreadsResponse;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "it", "Lcom/bytedance/lark/pb/im/v1/MGetThreadsResponse;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ThreadRepositoryV2$getThreads$1 extends Lambda implements Function1<MGetThreadsResponse, ThreadTopic> {
    final /* synthetic */ Function1<MGetThreadsResponse, ThreadTopic> $respMap;

    public ThreadRepositoryV2$getThreads$1(Function1<? super MGetThreadsResponse, ? extends ThreadTopic> r1) {
        this.$respMap = r1;
        super(1);
    }

    public final ThreadTopic invoke(MGetThreadsResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (ThreadTopic) this.$respMap.invoke(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((MGetThreadsResponse) r1);
    }
}
