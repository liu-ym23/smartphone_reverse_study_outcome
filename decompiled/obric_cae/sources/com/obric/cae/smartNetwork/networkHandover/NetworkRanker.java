package com.obric.cae.smartNetwork.networkHandover;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkRanker {
    private static final int[] PREFERRED_TRANSPORTS_ORDER = null;
    private static final String TAG = "NetworkRanker";

    static {
        PREFERRED_TRANSPORTS_ORDER = new int[]{1, 0};
    }

    public NetworkRanker() {
    }

    private void partitionToPolicy(List<NetworkScore> r8, int r10, List<NetworkScore> r11, List<NetworkScore> r12) {
        r11.clear();
        r12.clear();
        Iterator<NetworkScore> r13 = r8.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        NetworkScore r14 = r13.next();
        if (r14.hasPolicy(r10) == true) goto L7;
        r12.add(r14);
        goto L4
    L7:
        r11.add(r14);
        goto L4
    }

    private void partitionToTransport(List<NetworkScore> r8, int r10, List<NetworkScore> r11, List<NetworkScore> r12) {
        r11.clear();
        r12.clear();
        Iterator<NetworkScore> r13 = r8.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        NetworkScore r14 = r13.next();
        if (r14.getNetType() == r10) goto L7;
        r12.add(r14);
        goto L4
    L7:
        r11.add(r14);
        goto L4
    }

    public int getAOSPBestNetwork(List<NetworkScore> r8, int r10) {
        ArrayList r11 = new ArrayList(r8);
        if (r11.isEmpty() == false) goto L7;
        return -1;
    L7:
        if (r11.size() == 1) goto L9;
        if (r10 != 1) goto L18;
        Iterator r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L27;
        NetworkScore r13 = (NetworkScore) r12.next();
        if (r13.getNetType() != 0) goto L13;
        return r13.getNetId();
    L27:
        return getBestNetwork(r11);
    L18:
        if (r10 != 0) goto L27;
        Iterator r14 = r11.iterator();
    L21:
        if (r14.hasNext() == false) goto L27;
        NetworkScore r15 = (NetworkScore) r14.next();
        if (r15.getNetType() != 1) goto L21;
        return r15.getNetId();
    L9:
        return ((NetworkScore) r11.get(0)).getNetId();
    }

    public int getBestNetwork(List<NetworkScore> r10) {
        ArrayList r8 = new ArrayList(r10);
        ArrayList r11 = new ArrayList(r10.size());
        ArrayList r12 = new ArrayList(r10.size());
        if (r8.size() != 1) goto L8;
        Object r13 = r8.get(0);
    L6:
        return ((NetworkScore) r13).getNetId();
    L8:
        if (r8.isEmpty() == false) goto L11;
        return -1;
    L11:
        partitionToPolicy(r8, 1, r11, r12);
        if (r11.size() != 1) goto L15;
    L13:
        r13 = r11.get(0);
        goto L6
    L15:
        if (r11.isEmpty() == false) goto L17;
    L19:
        partitionToPolicy(r8, 2, r11, r12);
        if (r11.size() == 1) goto L13;
        if (r11.isEmpty() == false) goto L25;
    L27:
        partitionToPolicy(r8, 3, r11, r12);
        if (r11.size() == 1) goto L13;
        if (r11.isEmpty() == false) goto L33;
    L35:
        partitionToPolicy(r8, 4, r11, r12);
        if (r11.size() == 1) goto L13;
        if (r11.isEmpty() == false) goto L41;
    L43:
        int[] r14 = PREFERRED_TRANSPORTS_ORDER;
        int r15 = r14.length;
        int r16 = 0;
    L44:
        if (r16 >= r15) goto L54;
        partitionToTransport(r8, r14[r16], r11, r12);
        if (r11.size() == 1) goto L13;
        if (r11.isEmpty() == true) goto L53;
        if (r12.isEmpty() == true) goto L53;
        r8 = new ArrayList(r11);
    L53:
        r16 = r16 + 1;
    L54:
        r13 = r8.get(0);
        goto L6
    L41:
        if (r12.isEmpty() == true) goto L43;
        r8 = new ArrayList(r11);
        goto L43
    L33:
        if (r12.isEmpty() == true) goto L35;
        r8 = new ArrayList(r11);
        goto L35
    L25:
        if (r12.isEmpty() == true) goto L27;
        r8 = new ArrayList(r11);
        goto L27
    L17:
        if (r12.isEmpty() == true) goto L19;
        r8 = new ArrayList(r11);
        goto L19
    }

    public int getPredictBestNetwork(List<NetworkScore> r8, int r10) {
        ArrayList r11 = new ArrayList(r8);
        if (r11.isEmpty() == false) goto L7;
        return -1;
    L7:
        if (r11.size() == 1) goto L9;
        if (r10 != 1) goto L18;
        Iterator r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L27;
        NetworkScore r13 = (NetworkScore) r12.next();
        if (r13.getNetType() != 0) goto L13;
        return r13.getNetId();
    L27:
        return getBestNetwork(r11);
    L18:
        if (r10 != 0) goto L27;
        Iterator r14 = r11.iterator();
    L21:
        if (r14.hasNext() == false) goto L27;
        NetworkScore r15 = (NetworkScore) r14.next();
        if (r15.getNetType() != 1) goto L21;
        return r15.getNetId();
    L9:
        return ((NetworkScore) r11.get(0)).getNetId();
    }
}
