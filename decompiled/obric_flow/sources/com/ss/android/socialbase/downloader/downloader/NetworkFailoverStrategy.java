package com.ss.android.socialbase.downloader.downloader;

import android.text.TextUtils;
import android.util.SparseArray;
import com.lynx.tasm.utils.e;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import td.d;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkFailoverStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f15572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15574c;
    public final HashSet d;
    public final ArrayList e;
    public final ArrayList f;
    public final HashSet g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f15576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashSet f15577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f15579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15580m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f15581n;

    public class BackHostStrategyImpl implements FailoverStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f15582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15584c;
        public final /* synthetic */ NetworkFailoverStrategy d;

        public BackHostStrategyImpl(NetworkFailoverStrategy r5) {
            this.d = r5;
            this.f15582a = false;
            this.f15583b = false;
            this.f15584c = -1;
            if (r5.f15578k > 0) goto L5;
            return;
        L5:
            if (r5.f15576i.isEmpty() == true) goto L9;
            this.f15582a = true;
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final boolean a() {
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final boolean a(BaseException r11) {
            boolean r5 = false;
            if (this.f15582a == false) goto L25;
            int r10 = this.f15584c;
            NetworkFailoverStrategy r12 = this.d;
            if (r10 >= r12.f15578k) goto L25;
            if (r12.f15577j.isEmpty() == false) goto L10;
        L13:
            boolean r13 = true;
        L15:
            if (r13 == false) goto L23;
            int r14 = this.f15584c + 1;
            this.f15584c = r14;
            if (r14 == this.d.f15578k) goto L19;
            r5 = true;
            goto L25
        L19:
            if (Logger.b() == false) goto L25;
            Logger.a("NetworkFailoverStrategy", this.d.f15580m, null, "handleBackHostError", "BackHostCountLimit" + this.d.f15578k + " currentBackHostCount:" + this.f15584c + " errorCode:" + r11.f15601a, false);
            goto L25
        L23:
            if (Logger.b() == false) goto L25;
            Logger.a("NetworkFailoverStrategy", this.d.f15580m, null, "handleBackHostError", "IsMatch" + r13 + " BackHostCountLimit:" + this.d.f15578k + " errorCode:" + r11.f15601a, false);
            goto L25
        L10:
            if (this.d.f15577j.contains(Integer.valueOf(r11.f15601a)) == true) goto L13;
            r13 = false;
        L25:
            this.f15583b = r5;
            return r5;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final void a(ArrayList r10) {
            if (this.f15582a == true) goto L5;
            return;
        L5:
            if (this.f15583b == false) goto L17;
            int r5 = this.f15584c;
            if (r5 < 0) goto L18;
            NetworkFailoverStrategy r11 = this.d;
            if (r5 >= r11.f15578k) goto L19;
            this.f15583b = false;
            ArrayList r12 = r11.f15576i;
            String r13 = (String) r12.get(r5 % r12.size());
            if (Logger.b() == false) goto L14;
            Logger.a("NetworkFailoverStrategy", this.d.f15580m, null, "handleBackHostHeader", d.b("Add BackHost Header: ", r13), false);
        L14:
            r10.add(new HttpHeader("extra_ttnet_back_host", r13));
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    public class DefaultIpChangeStrategyImpl implements FailoverStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f15585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15587c;
        public final HashSet d;
        public final /* synthetic */ NetworkFailoverStrategy e;

        public DefaultIpChangeStrategyImpl(NetworkFailoverStrategy r5) {
            this.e = r5;
            this.f15585a = false;
            this.f15586b = false;
            this.f15587c = -1;
            this.d = new HashSet();
            if (r5.f15575h > 0) goto L5;
            return;
        L5:
            if (r5.g.isEmpty() == true) goto L9;
            this.f15585a = true;
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final boolean a() {
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public boolean a(BaseException r10) {
            if (this.f15585a == true) goto L5;
        L26:
            boolean r11 = false;
        L27:
            this.f15586b = r11;
            return r11;
        L5:
            if ((r10 instanceof DownloadTTNetException) == false) goto L26;
            int r5 = this.f15587c;
            NetworkFailoverStrategy r12 = this.e;
            if (r5 >= r12.f15575h) goto L26;
            if (r12.g.contains(Integer.valueOf(r10.f15601a)) == false) goto L26;
            String r13 = ((DownloadTTNetException) r10).d;
            int r14 = this.f15587c;
            int r15 = this.e.f15575h;
            if (r14 >= r15) goto L24;
            r11 = true;
            int r16 = r14 + 1;
            this.f15587c = r16;
            if (r16 != r15) goto L20;
            if (Logger.b() == false) goto L26;
            Logger.a("NetworkFailoverStrategy", this.e.f15580m, null, "handleIpChangeError", "CurrentIpChangeCount:" + this.f15587c + " mIpChangeCountLimit:" + this.e.f15575h, false);
            goto L26
        L20:
            if (TextUtils.isEmpty(r13) == true) goto L22;
            this.d.add(r13);
            goto L27
        L22:
            this.d.add("0.0.0.0");
            goto L27
        L24:
            if (Logger.b() == false) goto L26;
            int r17 = this.e.f15580m;
            StringBuilder r18 = e.b(" RemoteIp:", r13, " currentIpChangeCount:");
            r18.append(this.f15587c);
            r18.append(" errorCode:");
            r18.append(r10.f15601a);
            r18.append(" mIpChangeErrorIps:");
            r18.append(this.d.toString());
            Logger.a("NetworkFailoverStrategy", r17, null, "handleIpChangeError", r18.toString(), false);
            goto L26
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public void a(ArrayList r10) {
            if (this.f15585a == true) goto L5;
            return;
        L5:
            if (this.f15586b == false) goto L22;
            int r5 = this.f15587c;
            if (r5 >= 0) goto L9;
            return;
        L9:
            if (r5 >= this.e.f15575h) goto L24;
            this.f15586b = false;
            StringBuilder r11 = new StringBuilder();
            Iterator r12 = this.d.iterator();
        L13:
            if (r12.hasNext() == false) goto L16;
            r11.append((String) r12.next());
            r11.append(",");
            goto L13
        L16:
            if (Logger.b() == false) goto L18;
            Logger.a("NetworkFailoverStrategy", this.e.f15580m, null, "handleIpChangeHeader", "Add extra_ttnet_change_ip:" + r11.toString(), false);
        L18:
            r10.add(new HttpHeader("extra_ttnet_change_ip", r11.toString()));
            return;
        L24:
            return;
        }
    }

    public interface FailoverStrategy {
        void a(ArrayList r5);

        boolean a();

        boolean a(BaseException r5);
    }

    public class IsolationIpChangeStrategyImpl extends DefaultIpChangeStrategyImpl {
        public final boolean f;
        public boolean g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15588h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ NetworkFailoverStrategy f15589i;

        public IsolationIpChangeStrategyImpl(NetworkFailoverStrategy r5) {
            this.f15589i = r5;
            super(r5);
            this.f = false;
            this.g = false;
            this.f15588h = -1;
            if (r5.f15573b > 0) goto L5;
            return;
        L5:
            if (r5.f15572a.isEmpty() == true) goto L9;
            this.f = true;
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final boolean a(BaseException r11) {
            if (this.f == false) goto L17;
            int r5 = this.f15588h;
            NetworkFailoverStrategy r10 = this.f15589i;
            if (r5 >= r10.f15573b) goto L17;
            boolean r12 = r10.f15572a.contains(Integer.valueOf(r11.f15601a));
            if (r12 == false) goto L15;
            boolean r13 = true;
            int r14 = this.f15588h + 1;
            this.f15588h = r14;
            if (r14 == this.f15589i.f15573b) goto L12;
        L18:
            this.g = r13;
            if (r13 == false) goto L22;
            super.a(r11);
        L22:
            return this.g;
        L12:
            if (Logger.b() == false) goto L17;
            Logger.a("NetworkFailoverStrategy", this.f15589i.f15580m, null, "handleIsolationError", "IsolationCount" + this.f15589i.f15573b + " ttnetIsolationIndex:" + this.f15588h + " errorCode:" + r11.f15601a, false);
            goto L17
        L15:
            if (Logger.b() == false) goto L17;
            Logger.a("NetworkFailoverStrategy", this.f15589i.f15580m, null, "handleIsolationError", "IsMatch" + r12 + " ttnetIsolationIndex:" + this.f15588h + " errorCode:" + r11.f15601a, false);
        L17:
            r13 = false;
            goto L18
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.DefaultIpChangeStrategyImpl, com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final void a(ArrayList r10) {
            if (this.f == true) goto L5;
            return;
        L5:
            if (this.g == false) goto L41;
            int r5 = this.f15588h;
            if (r5 >= 0) goto L9;
            return;
        L9:
            if (r5 >= this.f15589i.f15573b) goto L43;
            this.g = false;
            if (Logger.b() == false) goto L14;
            Logger.a("NetworkFailoverStrategy", this.f15589i.f15580m, null, "handleIsolationHeader", "Add handleIsolationHeader: https://dl", false);
        L14:
            r10.add(new HttpHeader("x-ttnet-isolation-info", "https://dl"));
            if (this.f15589i.f15574c > 0) goto L17;
        L30:
            super.a(r10);
            return;
        L17:
            if (Logger.b() == false) goto L19;
            Logger.a("NetworkFailoverStrategy", this.f15589i.f15580m, null, "handleIsolationHeader", "Add x-ttnet-http-proto-type: " + this.f15589i.f15574c, false);
        L19:
            SparseArray r11 = DownloadHelper.f16133a;
            Iterator r12 = r10.iterator();
        L21:
            if (r12.hasNext() == false) goto L29;
            HttpHeader r13 = (HttpHeader) r12.next();
            if (r13 == null) goto L21;
            if (TextUtils.isEmpty(r13.f15909a) == true) goto L21;
            if (r13.f15909a.contains("x-ttnet-http-proto-type") == false) goto L21;
            r12.remove();
        L29:
            r10.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(this.f15589i.f15574c)));
            goto L30
        L43:
            return;
        }
    }

    public class TimeoutStrategyImpl implements FailoverStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f15590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NetworkFailoverStrategy f15592c;

        public TimeoutStrategyImpl(NetworkFailoverStrategy r5) {
            this.f15592c = r5;
            this.f15590a = false;
            this.f15591b = -1;
            if (r5.d.isEmpty() == false) goto L5;
            return;
        L5:
            if (r5.f.isEmpty() == true) goto L7;
        L8:
            this.f15590a = true;
            return;
        L7:
            if (r5.e.isEmpty() == false) goto L8;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final boolean a() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final boolean a(BaseException r10) {
            if (this.f15590a == true) goto L5;
            return false;
        L5:
            boolean r5 = this.f15592c.d.contains(Integer.valueOf(r10.f15601a));
            if (r5 == false) goto L10;
            this.f15591b++;
            return true;
        L10:
            if (Logger.b() == false) goto L12;
            Logger.a("NetworkFailoverStrategy", this.f15592c.f15580m, null, "handleTimeoutError", "IsMatch:" + r5 + " ttnetTimeoutIndex:" + this.f15591b + " errorCode:" + r10.f15601a, false);
        L12:
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy.FailoverStrategy
        public final void a(ArrayList r10) {
            if (this.f15590a == true) goto L5;
            return;
        L5:
            if (this.f15591b >= 0) goto L8;
            return;
        L8:
            if (this.f15592c.e.isEmpty() == true) goto L18;
            if (this.f15591b >= this.f15592c.e.size()) goto L12;
            int r5 = this.f15591b;
        L13:
            String r11 = String.valueOf(this.f15592c.e.get(r5));
            if (Logger.b() == false) goto L16;
            Logger.a("NetworkFailoverStrategy", this.f15592c.f15580m, null, "handleTimeoutHeader", "Add ConnectTimeout:".concat(r11), false);
        L16:
            r10.add(new HttpHeader("extra_ttnet_connect_timeout", r11));
            goto L18
        L12:
            r5 = this.f15592c.e.size() - 1;
        L18:
            if (this.f15592c.f.isEmpty() == false) goto L20;
            return;
        L20:
            if (this.f15591b >= this.f15592c.f.size()) goto L22;
            int r12 = this.f15591b;
        L23:
            String r13 = String.valueOf(this.f15592c.f.get(r12));
            if (Logger.b() == false) goto L26;
            Logger.a("NetworkFailoverStrategy", this.f15592c.f15580m, null, "handleTimeoutHeader", "Add IoTimeout:".concat(r13), false);
        L26:
            r10.add(new HttpHeader("extra_ttnet_io_timeout", r13));
            return;
        L22:
            r12 = this.f15592c.f.size() - 1;
            goto L23
        }
    }

    public NetworkFailoverStrategy(DownloadInfo r24) {
        HashSet r5 = new HashSet();
        this.f15572a = r5;
        this.f15573b = 0;
        this.f15574c = 0;
        HashSet r10 = new HashSet();
        this.d = r10;
        ArrayList r15 = new ArrayList();
        this.e = r15;
        ArrayList r11 = new ArrayList();
        this.f = r11;
        HashSet r12 = new HashSet();
        this.g = r12;
        this.f15575h = 0;
        ArrayList r13 = new ArrayList();
        this.f15576i = r13;
        HashSet r14 = new HashSet();
        this.f15577j = r14;
        this.f15578k = 0;
        this.f15579l = new ArrayList();
        this.f15580m = 0;
        a(r24);     // Catch: Throwable -> L7
        if (Logger.a(r24) == false) goto L15;
        Logger.a("NetworkFailoverStrategy", r24, "NetworkFailoverStrategy", "Init ttnetIsolationCount:" + this.f15573b + " mIsolationErrorCodeSet:" + r5.toString() + " mIsolationHttpProtoType:" + this.f15574c + " ttnetTimeoutErrorCodes:" + r10.toString() + " ttnetConnectTimeout:" + r15.toString() + " ttnetIoTimeout:" + r11.toString() + " ipChangeCountLimit:" + this.f15575h + " ipChangeErrorCodeSet:" + r12 + " host:" + this.f15581n + " backHostList:" + r13.toString() + " backHostCountLimit:" + this.f15578k + " backHostErrorCodeSet:" + r14);
    L15:
        this.f15579l.add(new TimeoutStrategyImpl(this));
        this.f15579l.add(new DefaultIpChangeStrategyImpl(this));
        this.f15579l.add(new IsolationIpChangeStrategyImpl(this));
        this.f15579l.add(new BackHostStrategyImpl(this));
        this.f15579l.add(new TimeoutStrategyImpl(this));
        return;
    L7:
        th = move-exception;
        String r16 = " backHostErrorCodeSet:";
        th.printStackTrace();     // Catch: Throwable -> L19
        Logger.a("NetworkFailoverStrategy", this.f15580m, "NetworkFailoverStrategy", "Init Error" + th.toString());     // Catch: Throwable -> L17
        if (Logger.a(r24) == false) goto L15;
        Logger.a("NetworkFailoverStrategy", r24, "NetworkFailoverStrategy", "Init ttnetIsolationCount:" + this.f15573b + " mIsolationErrorCodeSet:" + this.f15572a.toString() + " mIsolationHttpProtoType:" + this.f15574c + " ttnetTimeoutErrorCodes:" + this.d.toString() + " ttnetConnectTimeout:" + this.e.toString() + " ttnetIoTimeout:" + this.f.toString() + " ipChangeCountLimit:" + this.f15575h + " ipChangeErrorCodeSet:" + this.g + " host:" + this.f15581n + " backHostList:" + this.f15576i.toString() + " backHostCountLimit:" + this.f15578k + r16 + this.f15577j);
    L17:
        th = th;
        r16 = r16;
    L22:
        if (Logger.a(r24) == false) goto L25;
        Throwable r17 = th;
        Logger.a("NetworkFailoverStrategy", r24, "NetworkFailoverStrategy", "Init ttnetIsolationCount:" + this.f15573b + " mIsolationErrorCodeSet:" + this.f15572a.toString() + " mIsolationHttpProtoType:" + this.f15574c + " ttnetTimeoutErrorCodes:" + this.d.toString() + " ttnetConnectTimeout:" + this.e.toString() + " ttnetIoTimeout:" + this.f.toString() + " ipChangeCountLimit:" + this.f15575h + " ipChangeErrorCodeSet:" + this.g + " host:" + this.f15581n + " backHostList:" + this.f15576i.toString() + " backHostCountLimit:" + this.f15578k + r16 + this.f15577j);
        throw r17;
    L25:
        throw th;
    L19:
        th = th;
        goto L22
    }

    public final void a(DownloadInfo r10) {
        if (r10 == null) goto L5;
        this.f15580m = r10.l();
        this.f15581n = new URL(r10.d).getHost();
        JSONObject r11 = DownloadSetting.a(this.f15580m, null).d("network_failover_strategy");
    L6:
        if (r11 == null) goto L147;
        int r5 = r11.optInt("ttnet_back_host_count_limit");
        if (r5 <= 0) goto L11;
        this.f15578k = r5;
    L11:
        JSONArray r12 = r11.optJSONArray("ttnet_back_host");
        int r13 = 0;
        if (TextUtils.isEmpty(this.f15581n) == true) goto L40;
        if (r12 == null) goto L40;
        if (r12.length() <= 0) goto L40;
        int r14 = 0;
    L18:
        if (r14 >= r12.length()) goto L40;
        String r15 = r12.optString(r14);
        if (TextUtils.isEmpty(r15) == true) goto L39;
        String[] r16 = r15.split(":");
        if (r16 == null) goto L39;
        if (r16.length != 2) goto L39;
        if (this.f15581n.equals(r16[0]) == false) goto L39;
        if (TextUtils.isEmpty(r16[1]) == true) goto L39;
        String[] r17 = r16[1].split(",");
        if (r17 == null) goto L40;
        if (r17.length <= 0) goto L40;
        int r18 = r17.length;
        int r19 = 0;
    L34:
        if (r19 >= r18) goto L40;
        String r20 = r17[r19];
        if (TextUtils.isEmpty(r20) == true) goto L38;
        this.f15576i.add(r20);
    L38:
        r19 = r19 + 1;
    L39:
        r14 = r14 + 1;
    L40:
        JSONArray r21 = r11.optJSONArray("ttnet_back_host_error_code");
        if (r21 != null) goto L43;
    L51:
        int r22 = r11.optInt("ttnet_isolation_count");
        if (r22 <= 0) goto L54;
        this.f15573b = r22;
    L54:
        JSONArray r23 = r11.optJSONArray("ttnet_isolation_error_code");
        if (r23 != null) goto L57;
    L65:
        int r24 = r11.optInt("ttnet_isolation_http_proto_type");
        if (1 == r24) goto L70;
        if (2 == r24) goto L70;
        if (3 == r24) goto L70;
    L71:
        JSONArray r25 = r11.optJSONArray("ttnet_timeout_error_code");
        if (r25 != null) goto L74;
    L82:
        JSONArray r26 = r11.optJSONArray("ttnet_timeout_connect");
        if (r26 != null) goto L85;
    L93:
        JSONArray r27 = r11.optJSONArray("ttnet_timeout_io");
        if (r27 != null) goto L96;
    L104:
        JSONArray r28 = r11.optJSONArray("ttnet_ip_change_error_code");
        if (r28 != null) goto L107;
    L114:
        int r29 = r11.optInt("ttnet_ip_change_count_limit");
        if (r29 <= 0) goto L146;
        this.f15575h = r29;
        return;
    L146:
        return;
    L107:
        if (r28.length() <= 0) goto L114;
    L109:
        if (r13 >= r28.length()) goto L114;
        int r30 = r28.optInt(r13);
        if (r30 <= 0) goto L113;
        this.g.add(Integer.valueOf(r30));
    L113:
        r13 = r13 + 1;
        goto L109
    L96:
        if (r27.length() <= 0) goto L104;
        int r31 = 0;
    L99:
        if (r31 >= r27.length()) goto L104;
        long r32 = r27.optLong(r31);
        if (r32 <= 0) goto L103;
        this.f.add(Long.valueOf(r32));
    L103:
        r31 = r31 + 1;
        goto L99
    L85:
        if (r26.length() <= 0) goto L93;
        int r33 = 0;
    L88:
        if (r33 >= r26.length()) goto L93;
        long r34 = r26.optLong(r33);
        if (r34 <= 0) goto L92;
        this.e.add(Long.valueOf(r34));
    L92:
        r33 = r33 + 1;
        goto L88
    L74:
        if (r25.length() <= 0) goto L82;
        int r35 = 0;
    L77:
        if (r35 >= r25.length()) goto L82;
        int r36 = r25.optInt(r35);
        if (r36 <= 0) goto L81;
        this.d.add(Integer.valueOf(r36));
    L81:
        r35 = r35 + 1;
    L70:
        this.f15574c = r24;
        goto L71
    L57:
        if (r23.length() <= 0) goto L65;
        int r37 = 0;
    L60:
        if (r37 >= r23.length()) goto L65;
        int r38 = r23.optInt(r37);
        if (r38 <= 0) goto L64;
        this.f15572a.add(Integer.valueOf(r38));
    L64:
        r37 = r37 + 1;
        goto L60
    L43:
        if (r21.length() <= 0) goto L51;
        int r39 = 0;
    L46:
        if (r39 >= r21.length()) goto L51;
        int r40 = r21.optInt(r39);
        if (r40 <= 0) goto L50;
        this.f15577j.add(Integer.valueOf(r40));
    L50:
        r39 = r39 + 1;
        goto L46
    L147:
        return;
    L5:
        r11 = DownloadSetting.f.d("network_failover_strategy");
        goto L6
    }

    public final void a(BaseException r5) {
        Iterator r10 = this.f15579l.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        FailoverStrategy r11 = (FailoverStrategy) r10.next();
        boolean r12 = r11.a(r5);
        if (r11.a() == false) goto L4;
        if (r12 == false) goto L4;
        return;
    }

    public final void a(ArrayList r5) {
        if (r5 == null) goto L8;
        Iterator r10 = this.f15579l.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        ((FailoverStrategy) r10.next()).a(r5);
        goto L6
    L10:
        return;
    }
}
