package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketAction;", "", "()V", "toString", "", "Dispose", "MarkEmpty", "MarkExpired", "MarkRushed", "Ready", "Rush", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$Dispose;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$MarkEmpty;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$MarkExpired;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$MarkRushed;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$Ready;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$Rush;", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class RedPacketAction {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$Dispose;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction;", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Dispose extends RedPacketAction {
        public static final Dispose INSTANCE = null;

        private Dispose() {
            super(null);
        }

        static {
            INSTANCE = new Dispose();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$MarkEmpty;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction;", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class MarkEmpty extends RedPacketAction {
        public static final MarkEmpty INSTANCE = null;

        private MarkEmpty() {
            super(null);
        }

        static {
            INSTANCE = new MarkEmpty();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$MarkExpired;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction;", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class MarkExpired extends RedPacketAction {
        public static final MarkExpired INSTANCE = null;

        private MarkExpired() {
            super(null);
        }

        static {
            INSTANCE = new MarkExpired();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$MarkRushed;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction;", "result", "Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;", "(Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;)V", "getResult", "()Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class MarkRushed extends RedPacketAction {
        private final RedPacketRushResult result;

        public static /* synthetic */ MarkRushed copy$default(MarkRushed r0, RedPacketRushResult r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.result;
        L6:
            return r0.copy(r1);
        }

        public final RedPacketRushResult component1() {
            return this.result;
        }

        public final MarkRushed copy(RedPacketRushResult r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            return new MarkRushed(r2);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof MarkRushed) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.result, ((MarkRushed) r2).result) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            RedPacketRushResult r0 = this.result;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        @Override // com.bytedance.android.live.profit.redpacket.RedPacketAction
        public String toString() {
            return "MarkRushed(result=" + this.result + ")";
        }

        public final RedPacketRushResult getResult() {
            return this.result;
        }

        public MarkRushed(RedPacketRushResult r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            super(null);
            this.result = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$Ready;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction;", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Ready extends RedPacketAction {
        public static final Ready INSTANCE = null;

        private Ready() {
            super(null);
        }

        static {
            INSTANCE = new Ready();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketAction$Rush;", "Lcom/bytedance/android/live/profit/redpacket/RedPacketAction;", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Rush extends RedPacketAction {
        public static final Rush INSTANCE = null;

        private Rush() {
            super(null);
        }

        static {
            INSTANCE = new Rush();
        }
    }

    private RedPacketAction() {
    }

    public String toString() {
        String r0 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public /* synthetic */ RedPacketAction(DefaultConstructorMarker r1) {
        this();
    }
}
