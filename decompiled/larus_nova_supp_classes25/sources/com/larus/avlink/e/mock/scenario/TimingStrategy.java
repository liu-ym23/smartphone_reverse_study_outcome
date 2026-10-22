package com.larus.avlink.e.mock.scenario;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/e/mock/scenario/TimingStrategy;", "", "<init>", "()V", "Immediate", "Realtime", "CustomDelay", "Lcom/larus/avlink/e/mock/scenario/TimingStrategy$CustomDelay;", "Lcom/larus/avlink/e/mock/scenario/TimingStrategy$Immediate;", "Lcom/larus/avlink/e/mock/scenario/TimingStrategy$Realtime;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class TimingStrategy {
    public static final int $stable = 0;

    public static final class a extends TimingStrategy {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return (int) 0;
        }

        public final String toString() {
            return "CustomDelay (0ms)";
        }
    }

    public static final class b extends TimingStrategy {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super(null);
        }

        public final String toString() {
            return "Immediate (所有回调立即执行)";
        }
    }

    public static final class c extends TimingStrategy {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
            super(null);
        }

        public final String toString() {
            return "Realtime (保留原始延迟间隔)";
        }
    }

    private TimingStrategy() {
    }

    public /* synthetic */ TimingStrategy(DefaultConstructorMarker r1) {
        this();
    }
}
