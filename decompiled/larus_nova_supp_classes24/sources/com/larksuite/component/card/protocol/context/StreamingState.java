package com.larksuite.component.card.protocol.context;

import com.larksuite.component.card.protocol.CardRenderData;
import com.larksuite.component.card.protocol.data.StreamingConfig;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/larksuite/component/card/protocol/context/StreamingState;", "Ljava/io/Serializable;", "printStrategy", "Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "streamingPhase", "Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "pendingStreamingData", "Lcom/larksuite/component/card/protocol/CardRenderData;", "<init>", "(Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;Lcom/larksuite/component/card/protocol/CardRenderData;)V", "getPrintStrategy", "()Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "setPrintStrategy", "(Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;)V", "getStreamingPhase", "()Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "setStreamingPhase", "(Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;)V", "getPendingStreamingData", "()Lcom/larksuite/component/card/protocol/CardRenderData;", "setPendingStreamingData", "(Lcom/larksuite/component/card/protocol/CardRenderData;)V", "reset", "", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "StreamingPhase", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class StreamingState implements Serializable {
    private CardRenderData pendingStreamingData;
    private StreamingConfig.PrintStrategy printStrategy;
    private StreamingPhase streamingPhase;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/card/protocol/context/StreamingState$StreamingPhase;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "IN_STREAMING", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum StreamingPhase extends Enum<StreamingPhase> implements Serializable {
        public static final StreamingPhase IDLE = null;
        public static final StreamingPhase IN_STREAMING = null;
        public static final /* synthetic */ StreamingPhase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<StreamingPhase> getEntries() {
            return b;
        }

        static {
            StreamingPhase r0 = new StreamingPhase("IDLE", 0);
            IDLE = r0;
            StreamingPhase r1 = new StreamingPhase("IN_STREAMING", 1);
            IN_STREAMING = r1;
            StreamingPhase[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static StreamingPhase[] values() {
            return (StreamingPhase[]) a.clone();
        }

        public static StreamingPhase valueOf(String r1) {
            return (StreamingPhase) a.a(StreamingPhase.class, r1);
        }

        public StreamingPhase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public StreamingState() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StreamingState copy$default(StreamingState r0, StreamingConfig.PrintStrategy r1, StreamingPhase r2, CardRenderData r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.printStrategy;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.streamingPhase;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.pendingStreamingData;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final StreamingConfig.PrintStrategy component1() {
        return this.printStrategy;
    }

    public final StreamingPhase component2() {
        return this.streamingPhase;
    }

    public final CardRenderData component3() {
        return this.pendingStreamingData;
    }

    public final StreamingState copy(StreamingConfig.PrintStrategy r2, StreamingPhase r3, CardRenderData r4) {
        Intrinsics.checkNotNullParameter(r2, "printStrategy");
        Intrinsics.checkNotNullParameter(r3, "streamingPhase");
        return new StreamingState(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof StreamingState) == true) goto L8;
        return false;
    L8:
        StreamingState r6 = (StreamingState) r5;
        if (this.printStrategy == r6.printStrategy) goto L12;
        return false;
    L12:
        if (this.streamingPhase == r6.streamingPhase) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pendingStreamingData, r6.pendingStreamingData) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.printStrategy.hashCode() * 31) + this.streamingPhase.hashCode()) * 31;
        CardRenderData r1 = this.pendingStreamingData;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "StreamingState(printStrategy=" + this.printStrategy + ", streamingPhase=" + this.streamingPhase + ", pendingStreamingData=" + this.pendingStreamingData + ')';
    }

    public final void reset() {
        this.streamingPhase = StreamingPhase.IDLE;
        this.pendingStreamingData = null;
    }

    public final CardRenderData getPendingStreamingData() {
        return this.pendingStreamingData;
    }

    public final StreamingConfig.PrintStrategy getPrintStrategy() {
        return this.printStrategy;
    }

    public final StreamingPhase getStreamingPhase() {
        return this.streamingPhase;
    }

    public final void setPendingStreamingData(CardRenderData r1) {
        this.pendingStreamingData = r1;
    }

    public final void setPrintStrategy(StreamingConfig.PrintStrategy r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.printStrategy = r2;
    }

    public final void setStreamingPhase(StreamingPhase r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.streamingPhase = r2;
    }

    public StreamingState(StreamingConfig.PrintStrategy r2, StreamingPhase r3, CardRenderData r4) {
        Intrinsics.checkNotNullParameter(r2, "printStrategy");
        Intrinsics.checkNotNullParameter(r3, "streamingPhase");
        this.printStrategy = r2;
        this.streamingPhase = r3;
        this.pendingStreamingData = r4;
    }

    public /* synthetic */ StreamingState(StreamingConfig.PrintStrategy r1, StreamingPhase r2, CardRenderData r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = StreamingConfig.PrintStrategy.FAST;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = StreamingPhase.IDLE;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }
}
