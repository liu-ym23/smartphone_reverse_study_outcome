package com.ss.android.lark.message.universalcard.datachannel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.larksuite.component.card.protocol.context.StreamingState;
import com.larksuite.component.card.protocol.data.StreamingConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\b\u0010 \u001a\u00020\u0012H\u0007J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0014J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0014J.\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&J\u0016\u0010*\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/J8\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00104\u001a\u000205H\u0002J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00101\u001a\u000202H\u0002J\b\u00108\u001a\u00020\u0012H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/ss/android/lark/message/universalcard/datachannel/MessageCardStreamingManager;", "Landroidx/lifecycle/LifecycleObserver;", "chatContext", "Lcom/ss/android/lark/chat/export/ui/message/IMessageContext;", "cellCallback", "Lcom/ss/android/lark/chat/export/ui/message/IOpenCellCallback;", "Lcom/ss/android/lark/message/lynxcard/entity/LynxCardContentVO;", "<init>", "(Lcom/ss/android/lark/chat/export/ui/message/IMessageContext;Lcom/ss/android/lark/chat/export/ui/message/IOpenCellCallback;)V", "dataService", "Lcom/ss/android/lark/message/universalcard/datachannel/IMessageCardDataService;", "getDataService", "()Lcom/ss/android/lark/message/universalcard/datachannel/IMessageCardDataService;", "dataService$delegate", "Lkotlin/Lazy;", "createOPTraceId", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "onBindView", "", "lynxCardViewHolder", "Lcom/ss/android/lark/message/lynxcard/message/LynxCardViewHolder;", "lynxCardContentVO", "streamingBindViewMethod", "Lcom/ss/android/lark/message/universalcard/datachannel/MessageCardRenderUtils$StreamingBindViewMethod;", "messageId", "", "cardData", "Lcom/larksuite/component/card/protocol/CardData;", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "cardConfig", "Lcom/larksuite/component/card/protocol/CardConfig;", "onDestroy", "onAttachedToWindow", "viewHolder", "onDetachedFromWindow", "onSizeChanged", "w", "", "h", "oldw", "oldh", "onRenderDataUpdate", "cardRenderData", "Lcom/larksuite/component/card/protocol/CardRenderData;", "onStreamingStateChanged", "newPhase", "Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "renderInternal", "iCard", "Lcom/larksuite/component/card/protocol/ICard;", "messageID", "delayRender", "", "getCurrentStreamingState", "Lcom/larksuite/component/card/protocol/context/StreamingState;", "registerLifecycleListener", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MessageCardStreamingManager implements LifecycleObserver {
    public r5b.a a;
    public r5b.b<LynxCardContentVO> b;
    public final Lazy c;
    public OPTrace d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StreamingState.StreamingPhase.values().length];
            r0[StreamingState.StreamingPhase.IN_STREAMING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[StreamingState.StreamingPhase.IDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final com.ss.android.lark.message.universalcard.datachannel.a b() {
        return (com.ss.android.lark.message.universalcard.datachannel.a) this.c.getValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        b().onDestroy();
        this.a = null;
        this.b = null;
    }

    public static StreamingState a(bz7.a r3) {
        Object r4 = ((HashMap) r3.b().b.getBizExtra()).get("card_share_data");
        if ((r4 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L5;
        com.larksuite.component.card.cardcontainer.c r5 = (com.larksuite.component.card.cardcontainer.c) r4;
    L7:
        if (r5 != null) goto L10;
        Log.i("MessageCardStreamingManager", "getCardShareData is null");
        return null;
    L10:
        StreamingState r6 = r5.c.getStreamingState();
        if (r6 != null) goto L14;
        Log.e("MessageCardStreamingManager", "getCurrentStreamingState is null");
        return null;
    L14:
        StringBuilder r1 = new StringBuilder("getCurrentStreamingState, strategy=");
        r1.append(r6.getPrintStrategy());
        r1.append(", phase=");
        r1.append(r6.getStreamingPhase());
        r1.append(", hasPendingData=");
        if (r6.getPendingStreamingData() == null) goto L17;
        boolean r2 = true;
    L18:
        r1.append(r2);
        Log.d("MessageCardStreamingManager", r1.toString());
        return r6;
    L17:
        r2 = false;
        goto L18
    L5:
        r5 = null;
        goto L7
    }

    public MessageCardStreamingManager(r5b.a r1, r5b.b<LynxCardContentVO> r2) {
        this.a = r1;
        this.b = r2;
        this.c = LazyKt.lazy(MessageCardStreamingManager$dataService$2.INSTANCE);
        r5b.a r3 = this.a;
        if (r3 == null) goto L7;
        Fragment r4 = r3.R();
        if (r4 == null) goto L7;
        r4.getLifecycle().addObserver(this);
        return;
    L7:
        r5b.a r5 = this.a;
        if (r5 == null) goto L16;
        FragmentActivity r6 = r5.getContext();
        if (r6 == null) goto L17;
        Lifecycle r7 = r6.getLifecycle();
        if (r7 == null) goto L18;
        r7.addObserver(this);
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void c(bz7.a r8, String r9, CardData r10, CardContext r11, CardConfig r12, boolean r13) {
        StreamingState r0 = a(r8);
        if (r0 != null) goto L5;
        Log.i("MessageCardStreamingManager", "renderInternal create new streamingState");
        r0 = new StreamingState(null, null, null, 7, null);
    L5:
        StreamingConfig r2 = r10.getStreamingConfig();
        if (r2 == null) goto L9;
        StreamingConfig.PrintStrategy r3 = r2.getPrintStrategy();
        if (r3 == null) goto L9;
    L10:
        r0.setPrintStrategy(r3);
        r11.setStreamingState(r0);
        Log.i("MessageCardStreamingManager", "renderInternal enableDelay=" + r13 + ", current printStrategy is " + r0.getPrintStrategy() + ", messageId=" + r9);
        if (r13 == true) goto L15;
        r0.reset();
        r8.c(r10, r11, r12);
        return;
    L15:
        if (r0.getPrintStrategy() == StreamingConfig.PrintStrategy.DELAY) goto L17;
    L19:
        Log.i("MessageCardStreamingManager", "renderInternal not in streaming, direct render");
        r0.reset();
        r8.c(r10, r11, r12);
        return;
    L17:
        if (r0.getStreamingPhase() != StreamingState.StreamingPhase.IN_STREAMING) goto L19;
        Log.i("MessageCardStreamingManager", "renderInternal in streaming, save pending data");
        r0.setPendingStreamingData(new CardRenderData(null, r9, r10, r11, r12));
        return;
    L9:
        r3 = StreamingConfig.PrintStrategy.FAST;
        goto L10
    }
}
