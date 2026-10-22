package com.larksuite.component.card.protocol.data;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/card/protocol/data/StreamingConfig;", "Ljava/io/Serializable;", "printStrategy", "Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "printFrequencyMs", "", "printStep", "<init>", "(Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;II)V", "getPrintStrategy", "()Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "getPrintFrequencyMs", "()I", "getPrintStep", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "PrintStrategy", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class StreamingConfig implements Serializable {
    private final int printFrequencyMs;
    private final int printStep;
    private final PrintStrategy printStrategy;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/card/protocol/data/StreamingConfig$PrintStrategy;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FAST", "DELAY", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PrintStrategy extends Enum<PrintStrategy> implements Serializable {
        public static final PrintStrategy DELAY = null;
        public static final PrintStrategy FAST = null;
        public static final /* synthetic */ PrintStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<PrintStrategy> getEntries() {
            return b;
        }

        static {
            PrintStrategy r0 = new PrintStrategy("FAST", 0, "fast");
            FAST = r0;
            PrintStrategy r1 = new PrintStrategy("DELAY", 1, "delay");
            DELAY = r1;
            PrintStrategy[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static PrintStrategy[] values() {
            return (PrintStrategy[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static PrintStrategy valueOf(String r1) {
            return (PrintStrategy) a.a(PrintStrategy.class, r1);
        }

        public PrintStrategy(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public StreamingConfig() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ StreamingConfig copy$default(StreamingConfig r0, PrintStrategy r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.printStrategy;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.printFrequencyMs;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.printStep;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final PrintStrategy component1() {
        return this.printStrategy;
    }

    public final int component2() {
        return this.printFrequencyMs;
    }

    public final int component3() {
        return this.printStep;
    }

    public final StreamingConfig copy(PrintStrategy r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "printStrategy");
        return new StreamingConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof StreamingConfig) == true) goto L8;
        return false;
    L8:
        StreamingConfig r6 = (StreamingConfig) r5;
        if (this.printStrategy == r6.printStrategy) goto L12;
        return false;
    L12:
        if (this.printFrequencyMs == r6.printFrequencyMs) goto L15;
        return false;
    L15:
        if (this.printStep == r6.printStep) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.printStrategy.hashCode() * 31) + this.printFrequencyMs) * 31) + this.printStep;
    }

    public String toString() {
        return "StreamingConfig(printStrategy=" + this.printStrategy + ", printFrequencyMs=" + this.printFrequencyMs + ", printStep=" + this.printStep + ')';
    }

    public final int getPrintFrequencyMs() {
        return this.printFrequencyMs;
    }

    public final int getPrintStep() {
        return this.printStep;
    }

    public final PrintStrategy getPrintStrategy() {
        return this.printStrategy;
    }

    public StreamingConfig(PrintStrategy r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "printStrategy");
        this.printStrategy = r2;
        this.printFrequencyMs = r3;
        this.printStep = r4;
    }

    public /* synthetic */ StreamingConfig(PrintStrategy r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = PrintStrategy.FAST;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
