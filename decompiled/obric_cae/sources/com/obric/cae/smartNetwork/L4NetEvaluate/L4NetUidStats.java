package com.obric.cae.smartNetwork.L4NetEvaluate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class L4NetUidStats {

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.L4NetEvaluate.L4NetUidStats$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$StatSrcType = null;

        static {
            int[] r8 = new int[L4NetEvaluate.StatSrcType.values().length];
            $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$StatSrcType = r8;
            r8[L4NetEvaluate.StatSrcType.WLAN0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$StatSrcType[L4NetEvaluate.StatSrcType.WLAN1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$StatSrcType[L4NetEvaluate.StatSrcType.RMNET0.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$StatSrcType[L4NetEvaluate.StatSrcType.RMNET1.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class UidRateInfo {
        int recvRate;
        int sendRate;
        int totalRate;
        int uid;

        public UidRateInfo(int r8, int r10, int r11, int r12) {
            this.uid = r8;
            this.sendRate = r10;
            this.recvRate = r11;
            this.totalRate = r12;
        }
    }

    public L4NetUidStats() {
    }

    private static L4NetEvaluate.UidQosStats getQosStatsForInterface(L4NetEvaluate.UidNetifRateStats r8, L4NetEvaluate.StatSrcType r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        int r11 = AnonymousClass2.$SwitchMap$com$obric$cae$smartNetwork$L4NetEvaluate$L4NetEvaluate$StatSrcType[r10.ordinal()];
        if (r11 == 1) goto L21;
        if (r11 == 2) goto L19;
        if (r11 == 3) goto L17;
        if (r11 == 4) goto L15;
        return null;
    L15:
        return r8.rmnet1QosStats;
    L17:
        return r8.rmnet0QosStats;
    L19:
        return r8.wlan1QosStats;
    L21:
        return r8.wlan0QosStats;
    }

    public static String getTopThreeAppsString(ConcurrentHashMap<Integer, L4NetEvaluate.UidNetifRateStats> r8, L4NetEvaluate.StatSrcType r10) {
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<Integer, L4NetEvaluate.UidNetifRateStats>> r12 = r8.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<Integer, L4NetEvaluate.UidNetifRateStats> r13 = r12.next();
        int r14 = r13.getKey().intValue();
        L4NetEvaluate.UidQosStats r15 = getQosStatsForInterface(r13.getValue(), r10);
        if (r15 == null) goto L4;
        int r16 = r15.sendRate;
        int r17 = r15.recvRate;
        r11.add(new UidRateInfo(r14, r16, r17, r16 + r17));
        goto L4
    L9:
        r11.sort(new AnonymousClass1());
        StringBuilder r18 = new StringBuilder();
        r18.append(" Top 3 apps of " + r10 + ": ");
        int r19 = 0;
    L11:
        if (r19 >= Math.min(3, r11.size())) goto L14;
        UidRateInfo r20 = (UidRateInfo) r11.get(r19);
        StringBuilder r21 = new StringBuilder("Rank ");
        r19 = r19 + 1;
        r21.append(r19);
        r21.append(": UID: ");
        r21.append(r20.uid);
        r21.append(", SendRate: ");
        r21.append(r20.sendRate);
        r21.append("Bps, RecvRate: ");
        r21.append(r20.recvRate);
        r21.append("Bps. ");
        r18.append(r21.toString());
        goto L11
    L14:
        return r18.toString();
    }
}
