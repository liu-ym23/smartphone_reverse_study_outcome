package com.larus.audio.realtimecall;

import android.os.Bundle;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/realtimecall/RealtimeCallStrategyNoop;", "Lcom/larus/audio/realtimecall/IRealtimeCallStrategy;", "<init>", "()V", "realtimeCallAutoHelloParam", "Landroid/os/Bundle;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "lastMsg", "Lcom/larus/im/bean/message/Message;", "realtimeCallAutoHelloParamByCvsId", "cvsId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RealtimeCallStrategyNoop implements IRealtimeCallStrategy {
    public RealtimeCallStrategyNoop() {
    }

    @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
    public final Bundle a(e r1, Message r2) {
        return Bundle.EMPTY;
    }

    @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
    public final Object b(String r1, Continuation<? super Bundle> r2) {
        return Bundle.EMPTY;
    }
}
