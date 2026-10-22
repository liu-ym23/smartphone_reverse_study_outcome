package com.obric.cae.smartNetwork.netAccel;

import android.net.LinkAddress;
import android.net.LinkProperties;
import android.system.OsConstants;
import com.obric.cae.log.CaeLog;
import java.net.Inet6Address;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class MultiNetInfo {
    private static final String TAG = null;
    private final ConcurrentHashMap<Integer, AccelNet> mAccelNetMap;
    private final ConcurrentMap<Integer, String> mMultiNet;
    private final ConcurrentHashMap<Integer, Boolean> mUidEnableMap;
    private final ConcurrentHashMap<Integer, UidOpt> mUidOptMap;

    public static class AccelNet {
        private LinkProperties linkProperties;
        private int quota;

        public AccelNet() {
        }

        private boolean isIpv6ULA(LinkAddress r8) {
            if ((r8.getAddress().getAddress()[0] & (-2)) != (-4)) goto L6;
            return true;
        L6:
            return false;
        }

        private boolean isPreferred(LinkAddress r8) {
            int r10 = r8.getFlags();
            if (((OsConstants.IFA_F_DADFAILED | OsConstants.IFA_F_DEPRECATED) & r10) == 0) goto L5;
        L9:
            return false;
        L5:
            if ((OsConstants.IFA_F_TENTATIVE & r10) != 0) goto L7;
        L8:
            return true;
        L7:
            if ((r10 & OsConstants.IFA_F_OPTIMISTIC) == 0) goto L9;
            goto L8
        }

        public int getQuota() {
            return this.quota;
        }

        public boolean hasValidIpv6() {
            if (this.linkProperties != null) goto L6;
            CaeLog.e(MultiNetInfo.access$000(), "linkProperties: " + this.linkProperties);
            return false;
        L6:
            CaeLog.d(MultiNetInfo.access$000(), "linkProperties.getLinkAddresses(): " + this.linkProperties.getLinkAddresses());
            Iterator<LinkAddress> r8 = this.linkProperties.getLinkAddresses().iterator();
        L8:
            if (r8.hasNext() == false) goto L19;
            LinkAddress r10 = r8.next();
            CaeLog.d(MultiNetInfo.access$000(), "linkAddress: " + r10.toString());
            if ((r10.getAddress() instanceof Inet6Address) == false) goto L8;
            if (r10.getScope() == OsConstants.RT_SCOPE_UNIVERSE) goto L16;
            if (isIpv6ULA(r10) == false) goto L8;
        L16:
            if (isPreferred(r10) == false) goto L8;
            return true;
        L19:
            return false;
        }

        public AccelNet setLinkProperties(LinkProperties r8) {
            this.linkProperties = r8;
            return this;
        }

        public AccelNet setQuota(int r8) {
            this.quota = r8;
            return this;
        }
    }

    public static class UidOpt {
        private boolean flowSchedEnable;

        public UidOpt() {
            this.flowSchedEnable = true;
        }

        public boolean getFlowSchedEnable() {
            return this.flowSchedEnable;
        }

        public UidOpt setFlowSchedEnable(boolean r8) {
            this.flowSchedEnable = r8;
            return this;
        }
    }

    static {
        TAG = "MultiNetwork-MultiNetInfo";
    }

    public MultiNetInfo() {
        this.mMultiNet = new ConcurrentHashMap();
        this.mUidEnableMap = new ConcurrentHashMap();
        this.mAccelNetMap = new ConcurrentHashMap();
        this.mUidOptMap = new ConcurrentHashMap();
    }

    public static /* synthetic */ AccelNet a(Integer r8) {
        return lambda$setAvailableNetLinkproperties$1(r8);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ UidOpt b(Integer r8) {
        return lambda$setUidFlowSchedEnable$2(r8);
    }

    public static /* synthetic */ AccelNet c(Integer r8) {
        return lambda$setAvailableNetQuota$0(r8);
    }

    private static /* synthetic */ AccelNet lambda$setAvailableNetLinkproperties$1(Integer r8) {
        return new AccelNet();
    }

    private static /* synthetic */ AccelNet lambda$setAvailableNetQuota$0(Integer r8) {
        return new AccelNet();
    }

    private static /* synthetic */ UidOpt lambda$setUidFlowSchedEnable$2(Integer r8) {
        return new UidOpt();
    }

    public void clearAvailableNet() {
        this.mAccelNetMap.clear();
    }

    public void clearEnabledUidMap() {
        this.mUidEnableMap.clear();
    }

    public ConcurrentHashMap<Integer, AccelNet> getAvailableNetMap() {
        return this.mAccelNetMap;
    }

    public Boolean getEnabledUid(int r8) {
        return this.mUidEnableMap.get(Integer.valueOf(r8));
    }

    public Map<Integer, Boolean> getEnabledUidMap() {
        return Collections.unmodifiableMap(this.mUidEnableMap);
    }

    public String getIfaceName(int r8) {
        return this.mMultiNet.get(Integer.valueOf(r8));
    }

    public int getNetType(String r8) {
        Iterator<Map.Entry<Integer, String>> r10 = this.mMultiNet.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<Integer, String> r11 = r10.next();
        if (r11.getValue().equals(r8) == false) goto L4;
        return r11.getKey().intValue();
    L9:
        return -1;
    }

    public boolean hasValidIpv6(byte r8) {
        AccelNet r10 = this.mAccelNetMap.get(new Integer(r8));
        CaeLog.d(TAG, "accelNet: " + r10);
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.hasValidIpv6() == false) goto L7;
        return true;
    }

    public boolean isUidFlowSchedEnable(int r8) {
        UidOpt r10 = this.mUidOptMap.get(Integer.valueOf(r8));
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getFlowSchedEnable() == false) goto L7;
        return true;
    }

    public int makeAvailableNetType() {
        Iterator<Map.Entry<Integer, AccelNet>> r8 = this.mAccelNetMap.entrySet().iterator();
        int r10 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        r10 = r10 | (1 << r8.next().getKey().intValue());
        goto L4
    L6:
        return r10;
    }

    public void putNetType(int r8, String r10) {
        this.mMultiNet.put(Integer.valueOf(r8), r10);
    }

    public void setAvailableNetLinkproperties(byte r8, LinkProperties r10) {
        this.mAccelNetMap.computeIfAbsent(new Integer(r8), new f()).setLinkProperties(r10);
    }

    public void setAvailableNetQuota(byte r8, int r10) {
        this.mAccelNetMap.computeIfAbsent(new Integer(r8), new c(2)).setQuota(r10);
    }

    public void setUidEnabled(int r8, Boolean r10) {
        this.mUidEnableMap.put(Integer.valueOf(r8), r10);
    }

    public void setUidFlowSchedEnable(int r8, boolean r10) {
        this.mUidOptMap.computeIfAbsent(Integer.valueOf(r8), new d(1)).setFlowSchedEnable(r10);
    }
}
