package com.ss.bduploader;

import com.ss.bduploader.net.BDUploadDNSInfo;
import com.ss.bduploader.net.BDUploadDNSParser;
import com.ss.bduploader.net.BDUploadDNSParserListener;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.ss.bduploader.net.HTTPDNS;
import com.ss.bduploader.net.IPCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class BDUploadResolver implements BDUploadDNSParserListener {
    public static final int DNS_TYPE_IS_VERSION_1 = 1;
    public static final int DNS_TYPE_IS_VERSION_2 = 2;
    public static int HOST_MAX_CACHE_TIME = 60000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "BDUploadResolver";
    private static final Hashtable<String, HostInfo> mCacheHosts = null;
    public static volatile int mDNSVersion = 1;
    private static int mEnableThreadPool;
    public static volatile int mIsUseTTnetDNS;
    private String mError;
    private Future mFuture;
    private HostInfo mHostInfo;
    private volatile String mHostName;
    private volatile String[] mIPStr;
    private volatile boolean mRet;
    private Thread mThread;
    private int mUseDNSType;

    static class HostInfo {
        public String ip;
        public long time;

        HostInfo() {
        }
    }

    static class ParserHost implements Runnable {
        String mHostName;
        BDUploadResolver mResolver;

        public ParserHost(BDUploadResolver r2, String r3) {
            this.mResolver = null;
            this.mResolver = r2;
            this.mHostName = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            InetAddress r3 = null;
            if (BDUploadResolver.mIsUseTTnetDNS == 1) goto L22;
        L12:
            boolean r0 = false;
        L13:
            if (r0 == false) goto L24;
        L18:
            if (r3 == null) goto L20;
            String r1 = r3.getHostAddress();
            BDUploadResolver.access$102(this.mResolver, new String[1]);
            BDUploadResolver.access$100(this.mResolver)[0] = r1;
            HostInfo r2 = new HostInfo();
            r2.time = System.currentTimeMillis();
            r2.ip = r1;
            BDUploadResolver.putHostInfo(this.mHostName, r2);
            r2.time = System.currentTimeMillis();
        L20:
            BDUploadResolver.access$202(this.mResolver, true);
            return;
        L24:
            r3 = InetAddress.getByName(this.mHostName);     // Catch: UnknownHostException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            BDUploadResolver.access$002(this.mResolver, e.getMessage());
            goto L18
        L22:
            List<InetAddress> r4 = TTNetWrapper.dnsLookup(this.mHostName);     // Catch: Throwable -> L10
            if (r4 == null) goto L12;
            if (r4.get(0) == null) goto L12;
            r3 = (InetAddress) ZeusTransformUtils.preCheckCast(r4.get(0), InetAddress.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            r0 = true;
        L10:
            th = move-exception;
            th.printStackTrace();
            goto L12
        }
    }

    static {
        mCacheHosts = new Hashtable();
        mEnableThreadPool = 1;
    }

    public BDUploadResolver() {
        this.mRet = false;
        this.mThread = null;
        this.mFuture = null;
        this.mUseDNSType = mDNSVersion;
    }

    private native void _notifyParserResult(String r1, String r2, long r3, String r5);

    static /* synthetic */ String access$002(BDUploadResolver r0, String r1) {
        r0.mError = r1;
        return r1;
    }

    static /* synthetic */ String[] access$100(BDUploadResolver r0) {
        return r0.mIPStr;
    }

    static /* synthetic */ String[] access$102(BDUploadResolver r0, String[] r1) {
        r0.mIPStr = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(BDUploadResolver r0, boolean r1) {
        r0.mRet = r1;
        return r1;
    }

    private void getAddressInfoVersion_1(String r8) {
        this.mHostName = r8;
        if (r8 != null) goto L5;
    L28:
        this.mRet = true;
        return;
    L5:
        if (r8.length() < 1) goto L28;
        if ("".equals(r8) == true) goto L28;
        if (isIP(this.mHostName) == false) goto L11;
        this.mIPStr = new String[1];
        this.mIPStr[0] = this.mHostName;
        goto L28
    L11:
        Hashtable<String, HostInfo> r1 = mCacheHosts;
        HostInfo r3 = (HostInfo) ZeusTransformUtils.preCheckCast(r1.get(r8), HostInfo.class, "com.obric.memorydata.plugin");
        this.mHostInfo = r3;
        if (r3 != null) goto L14;
    L31:
    L26:
        e = move-exception;
        this.mRet = true;
        this.mError = e.getMessage();
        return;
    L22:
        if (mEnableThreadPool <= 0) goto L24;
        BDUploadLog.d(TAG, "----enable dns parser thread pool");     // Catch: Exception -> L26
        this.mFuture = BDUploadThreadPool.addExecuteTask(new ParserHost(this, this.mHostName));     // Catch: Exception -> L26
    L30:
        return;
    L24:
        BDUploadLog.d(TAG, "----disable dns parser thread pool");     // Catch: Exception -> L26
        Thread r9 = new Thread(new ParserHost(this, this.mHostName));     // Catch: Exception -> L26
        this.mThread = r9;     // Catch: Exception -> L26
        r9.start();     // Catch: Exception -> L26
        goto L30
    L14:
        if (r3.ip != null) goto L16;
    L19:
        r1.remove(r8);
        this.mHostInfo = null;
        goto L31
    L16:
        if ((System.currentTimeMillis() - this.mHostInfo.time) >= HOST_MAX_CACHE_TIME) goto L19;
        this.mIPStr = new String[1];
        this.mIPStr[0] = this.mHostInfo.ip;
        this.mRet = true;
    }

    private void getAddressInfoVersion_2(String r9) {
        BDUploadLog.d(TAG, "----add host to parser");
        this.mHostName = r9;
        BDUploadDNSInfo r1 = IPCache.getInstance().get(r9);
        if (r1 == null) goto L15;
        if (r1.mIpList == null) goto L15;
        long r2 = System.currentTimeMillis();
        BDUploadLog.d(TAG, String.format("get result from cache expiredT:%d curT:%d ", new Object[]{Long.valueOf(r1.mExpiredTime), Long.valueOf(r2)}));
        if (r1.mExpiredTime > r2) goto L9;
        BDUploadLog.d(TAG, String.format("has expired try call parse:", new Object[0]));
        BDUploadDNSParser.getInstance().addHost(r9, null);
    L9:
        String[] r3 = r1.mIpList.split(",");
        if (r3 == null) goto L15;
        if (r3.length <= 0) goto L15;
        this.mIPStr = new String[1];
        this.mIPStr[0] = r3[0];
        this.mRet = true;
        BDUploadLog.d(TAG, String.format("get result from cache suc, ip:%s ", new Object[]{r3[0]}));
    L15:
        if (this.mRet == true) goto L18;
        BDUploadLog.d(TAG, "****add host to parser");
        BDUploadDNSParser.getInstance().addHost(r9, this);
        return;
    }

    public static final boolean isIP(String r4) {
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (r4.length() < 7) goto L10;
        if (r4.length() > 15) goto L10;
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(r4).find();
    L10:
        if (r4.charAt(0) == '[') goto L13;
        return false;
    L13:
        if (r4.charAt(r4.length() - 1) == ']') goto L15;
        return false;
    L15:
        return true;
    }

    static synchronized void putHostInfo(String r9, HostInfo r10) {
        monitor-enter(BDUploadResolver.class);
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L22
        Hashtable<String, HostInfo> r3 = mCacheHosts;     // Catch: Throwable -> L22
        Object r6 = null;
        if (r3.size() <= 128) goto L15;
        Iterator<Map.Entry<String, HostInfo>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L22
        Object r5 = null;
    L8:
        if (r4.hasNext() == false) goto L14;
        HostInfo r7 = (HostInfo) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), HostInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r6 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r7 == null) goto L8;
        if (r7.time >= r1) goto L8;
        r1 = r7.time;     // Catch: Throwable -> L22
        r5 = r7;
        goto L8
    L14:
        Object r2 = r6;
        r6 = r5;
    L16:
        if (r6 == null) goto L19;
        if (r2 == null) goto L19;
        mCacheHosts.remove(r2);     // Catch: Throwable -> L22
    L19:
        mCacheHosts.put(r9, r10);     // Catch: Throwable -> L22
        monitor-exit(BDUploadResolver.class);
        return;
    L15:
        r2 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public static void setDNSServer(String r0, String r1) {
        HTTPDNS.setDNSServerHost(r0, r1);
    }

    public static void setDNSType(int r3, int r4, int r5, int r6, int r7) {
        if (r3 == 1) goto L6;
        if (r3 == 2) goto L6;
        return;
    L6:
        BDUploadDNSParser.setIntValue(0, r4);
        BDUploadDNSParser.setIntValue(1, r5);
        BDUploadDNSParser.setIntValue(3, r6);
        BDUploadDNSParser.setIntValue(2, r7);
        mDNSVersion = r3;
    }

    public static void setEnableDNSParserThreadPool(int r0) {
        mEnableThreadPool = r0;
    }

    public static void setEnableTTNetDNS(int r0) {
        mIsUseTTnetDNS = r0;
    }

    public void freeAddress() {
        if (this.mUseDNSType != 1) goto L17;
        Future r0 = this.mFuture;
        if (r0 != null) goto L23;
    L10:
        Thread r1 = this.mThread;
        if (r1 == null) goto L17;
        r1.interrupt();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L23:
        r0.cancel(true);     // Catch: Exception -> L8
        this.mFuture = null;     // Catch: Exception -> L8
        BDUploadLog.d(TAG, "----cancel parser thread");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    L17:
        if (this.mUseDNSType != 2) goto L29;
        BDUploadDNSParser.getInstance().removeHost(this.mHostName, this);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public String getAddress() {
        if (this.mRet == true) goto L5;
    L9:
        return null;
    L5:
        if (this.mIPStr == null) goto L9;
        if (this.mIPStr[0] == null) goto L9;
        return this.mIPStr[0];
    }

    public void getAddressInfo(String r3) {
        int r0 = this.mUseDNSType;
        if (r0 != 1) goto L5;
    L8:
        getAddressInfoVersion_1(r3);
        return;
    L5:
        if (r0 != 2) goto L8;
        getAddressInfoVersion_2(r3);
    }

    public int isSuccess() {
        if (this.mRet == true) goto L5;
        return 0;
    L5:
        if (this.mIPStr != null) goto L7;
    L9:
        return -1;
    L7:
        if (this.mIPStr[0] == null) goto L9;
        return 1;
    }

    @Override // com.ss.bduploader.net.BDUploadDNSParserListener
    public void onCompletion(int r1, String r2, String r3, long r4, String r6) {
        BDUploadLog.d(TAG, String.format("notify result host:%s iplist:%s ", new Object[]{r2, r3}));
        if (this.mRet == true) goto L15;
        if (r3 == null) goto L13;
        if (r2 == null) goto L13;
        if (r2.equals(this.mHostName) == false) goto L13;
        String[] r5 = r3.split(",");
        if (r5 == null) goto L13;
        if (r5.length <= 0) goto L13;
        this.mIPStr = new String[1];
        this.mIPStr[0] = r5[0];
    L13:
        this.mRet = true;
        return;
    }
}
