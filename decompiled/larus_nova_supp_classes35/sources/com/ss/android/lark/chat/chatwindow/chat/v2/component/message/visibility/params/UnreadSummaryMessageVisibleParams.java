package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/UnreadSummaryMessageVisibleParams;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleBizParams;", "summaryInfoProvider", "Lkotlin/Function0;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/UnreadSummaryVisibleInfo;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getSummaryInfoProvider", "()Lkotlin/jvm/functions/Function0;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnreadSummaryMessageVisibleParams implements MessageVisibleBizParams {
    private final Function0<a> summaryInfoProvider;

    public final Function0<a> getSummaryInfoProvider() {
        return this.summaryInfoProvider;
    }

    public UnreadSummaryMessageVisibleParams(Function0<a> r2) {
        Intrinsics.checkNotNullParameter(r2, "summaryInfoProvider");
        this.summaryInfoProvider = r2;
    }
}
