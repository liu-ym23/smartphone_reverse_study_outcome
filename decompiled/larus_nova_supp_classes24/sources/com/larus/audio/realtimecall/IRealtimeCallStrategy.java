package com.larus.audio.realtimecall;

import android.os.Bundle;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/audio/realtimecall/IRealtimeCallStrategy;", "", "realtimeCallAutoHelloParam", "Landroid/os/Bundle;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "lastMsg", "Lcom/larus/im/bean/message/Message;", "realtimeCallAutoHelloParamByCvsId", "cvsId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RealtimeCallStrategyDelegate", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IRealtimeCallStrategy {
    public static final RealtimeCallStrategyDelegate a = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096A¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/realtimecall/IRealtimeCallStrategy$RealtimeCallStrategyDelegate;", "Lcom/larus/audio/realtimecall/IRealtimeCallStrategy;", "<init>", "()V", "realtimeCallAutoHelloParam", "Landroid/os/Bundle;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "lastMsg", "Lcom/larus/im/bean/message/Message;", "realtimeCallAutoHelloParamByCvsId", "cvsId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class RealtimeCallStrategyDelegate implements IRealtimeCallStrategy {
        public static final /* synthetic */ RealtimeCallStrategyDelegate c = null;
        public final /* synthetic */ IRealtimeCallStrategy b;

        static {
            c = new RealtimeCallStrategyDelegate();
        }

        @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
        public final Bundle a(e r2, Message r3) {
            return this.b.a(r2, r3);
        }

        @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
        public final Object b(String r2, Continuation<? super Bundle> r3) {
            return this.b.b(r2, r3);
        }

        private RealtimeCallStrategyDelegate() {
            IRealtimeCallStrategy r0 = (IRealtimeCallStrategy) ServiceManager.get().getService(IRealtimeCallStrategy.class);
            if (r0 != null) goto L5;
            r0 = new RealtimeCallStrategyNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = RealtimeCallStrategyDelegate.c;
    }

    Bundle a(e r1, Message r2);

    Object b(String r1, Continuation<? super Bundle> r2);
}
