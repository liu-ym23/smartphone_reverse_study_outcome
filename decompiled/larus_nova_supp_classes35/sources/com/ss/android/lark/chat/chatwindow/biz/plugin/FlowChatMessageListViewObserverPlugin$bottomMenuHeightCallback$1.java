package com.ss.android.lark.chat.chatwindow.biz.plugin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FlowChatMessageListViewObserverPlugin$bottomMenuHeightCallback$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    public FlowChatMessageListViewObserverPlugin$bottomMenuHeightCallback$1(Object r8) {
        super(2, r8, FlowChatMessageListViewObserverPlugin.class, "updateBottomMenuHeight", "updateBottomMenuHeight(II)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, int r3) {
        FlowChatMessageListViewObserverPlugin.F((FlowChatMessageListViewObserverPlugin) ((CallableReference) this).receiver, r2, r3);
    }
}
