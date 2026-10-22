package jb;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<Integer> f9872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<Integer> f9875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Long> f9876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<Long> f9877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Set<Integer> f9878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f9880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set<Integer> f9881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<c> f9883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f9884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f9885n;

    private class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ v f9889d;

        a(v r10) {
            this.f9889d = r10;
            this.f9886a = false;
            this.f9887b = false;
            this.f9888c = -1;
            if (v.i(r10) > 0) goto L5;
            return;
        L5:
            if (v.j(r10).isEmpty() == true) goto L9;
            this.f9886a = true;
            return;
        }

        private boolean d(BaseException r10) {
            if (this.f9886a == true) goto L5;
        L26:
            return false;
        L5:
            if (this.f9888c >= v.i(this.f9889d)) goto L26;
            if (v.k(this.f9889d).isEmpty() == false) goto L10;
        L13:
            boolean r11 = true;
        L15:
            if (r11 == false) goto L24;
            int r12 = this.f9888c + 1;
            this.f9888c = r12;
            if (r12 == v.i(this.f9889d)) goto L19;
            return true;
        L19:
            if (lb.a.a() == false) goto L21;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9889d), "handleBackHostError", "BackHostCountLimit" + v.i(this.f9889d) + " currentBackHostCount:" + this.f9888c + " errorCode:" + r10.getErrorCode());
        L21:
            return false;
        L24:
            if (lb.a.a() == false) goto L26;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9889d), "handleBackHostError", "IsMatch" + r11 + " BackHostCountLimit:" + v.i(this.f9889d) + " errorCode:" + r10.getErrorCode());
            goto L26
        L10:
            if (v.k(this.f9889d).contains(Integer.valueOf(r10.getErrorCode())) == true) goto L13;
            r11 = false;
            goto L15
        }

        private void e(List<HttpHeader> r10) {
            if (this.f9886a == true) goto L5;
            return;
        L5:
            if (this.f9887b == false) goto L17;
            int r11 = this.f9888c;
            if (r11 >= 0) goto L9;
            return;
        L9:
            if (r11 >= v.i(this.f9889d)) goto L19;
            this.f9887b = false;
            String r12 = (String) v.j(this.f9889d).get(this.f9888c % v.j(this.f9889d).size());
            if (lb.a.a() == false) goto L14;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9889d), "handleBackHostHeader", "Add BackHost Header: " + r12);
        L14:
            r10.add(new HttpHeader("extra_ttnet_back_host", r12));
            return;
        L19:
            return;
        }

        @Override // jb.v.c
        public void a(List<HttpHeader> r10) {
            e(r10);
        }

        @Override // jb.v.c
        public boolean b() {
            return true;
        }

        @Override // jb.v.c
        public boolean c(BaseException r10) {
            boolean r11 = d(r10);
            this.f9887b = r11;
            return r11;
        }
    }

    private class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Set<String> f9893d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ v f9894e;

        b(v r10) {
            this.f9894e = r10;
            this.f9890a = false;
            this.f9891b = false;
            this.f9892c = -1;
            this.f9893d = new HashSet();
            if (v.a(r10) > 0) goto L5;
            return;
        L5:
            if (v.b(r10).isEmpty() == true) goto L9;
            this.f9890a = true;
            return;
        }

        private boolean d(BaseException r10) {
            if (this.f9890a == true) goto L5;
        L29:
            return false;
        L5:
            if ((r10 instanceof DownloadTTNetException) == false) goto L29;
            if (this.f9892c >= v.a(this.f9894e)) goto L29;
            if (v.b(this.f9894e).contains(Integer.valueOf(r10.getErrorCode())) == true) goto L12;
            return false;
        L12:
            String r11 = ((DownloadTTNetException) r10).getRemoteIp();
            if (this.f9892c >= v.a(this.f9894e)) goto L27;
            int r12 = this.f9892c + 1;
            this.f9892c = r12;
            if (r12 == v.a(this.f9894e)) goto L17;
            boolean r13 = TextUtils.isEmpty(r11);
            Set<String> r14 = this.f9893d;
            if (r13 == true) goto L24;
            r14.add(r11);
            return true;
        L24:
            r14.add("0.0.0.0");
            return true;
        L17:
            if (lb.a.a() == false) goto L19;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9894e), "handleIpChangeError", "CurrentIpChangeCount:" + this.f9892c + " mIpChangeCountLimit:" + v.a(this.f9894e));
        L19:
            return false;
        L27:
            if (lb.a.a() == false) goto L29;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9894e), "handleIpChangeError", " RemoteIp:" + r11 + " currentIpChangeCount:" + this.f9892c + " errorCode:" + r10.getErrorCode() + " mIpChangeErrorIps:" + this.f9893d.toString());
            goto L29
        }

        private void e(List<HttpHeader> r10) {
            if (this.f9890a == true) goto L5;
            return;
        L5:
            if (this.f9891b == false) goto L22;
            int r11 = this.f9892c;
            if (r11 >= 0) goto L9;
            return;
        L9:
            if (r11 >= v.a(this.f9894e)) goto L24;
            this.f9891b = false;
            StringBuilder r12 = new StringBuilder();
            Iterator<String> r13 = this.f9893d.iterator();
        L13:
            if (r13.hasNext() == false) goto L16;
            r12.append(r13.next());
            r12.append(",");
            goto L13
        L16:
            if (lb.a.a() == false) goto L18;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9894e), "handleIpChangeHeader", "Add extra_ttnet_change_ip:" + r12.toString());
        L18:
            r10.add(new HttpHeader("extra_ttnet_change_ip", r12.toString()));
            return;
        L24:
            return;
        }

        @Override // jb.v.c
        public void a(List<HttpHeader> r10) {
            e(r10);
        }

        @Override // jb.v.c
        public boolean b() {
            return true;
        }

        @Override // jb.v.c
        public boolean c(BaseException r10) {
            boolean r11 = d(r10);
            this.f9891b = r11;
            return r11;
        }
    }

    private interface c {
        void a(List<HttpHeader> r10);

        boolean b();

        boolean c(BaseException r10);
    }

    private class d extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f9895f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f9896g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f9897h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ v f9898i;

        d(v r10) {
            this.f9898i = r10;
            super(r10);
            this.f9895f = false;
            this.f9896g = false;
            this.f9897h = -1;
            if (v.f(r10) > 0) goto L5;
            return;
        L5:
            if (v.g(r10).isEmpty() == true) goto L9;
            this.f9895f = true;
            return;
        }

        private boolean f(BaseException r10) {
            if (this.f9895f == true) goto L5;
        L19:
            return false;
        L5:
            if (this.f9897h >= v.f(this.f9898i)) goto L19;
            boolean r11 = v.g(this.f9898i).contains(Integer.valueOf(r10.getErrorCode()));
            if (r11 == false) goto L17;
            int r12 = this.f9897h + 1;
            this.f9897h = r12;
            if (r12 == v.f(this.f9898i)) goto L12;
            return true;
        L12:
            if (lb.a.a() == false) goto L14;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9898i), "handleIsolationError", "IsolationCount" + v.f(this.f9898i) + " ttnetIsolationIndex:" + this.f9897h + " errorCode:" + r10.getErrorCode());
        L14:
            return false;
        L17:
            if (lb.a.a() == false) goto L19;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9898i), "handleIsolationError", "IsMatch" + r11 + " ttnetIsolationIndex:" + this.f9897h + " errorCode:" + r10.getErrorCode());
            goto L19
        }

        private boolean g(List<HttpHeader> r10) {
            if (this.f9895f == true) goto L5;
        L22:
            return false;
        L5:
            if (this.f9896g == false) goto L22;
            int r11 = this.f9897h;
            if (r11 < 0) goto L22;
            if (r11 >= v.f(this.f9898i)) goto L22;
            this.f9896g = false;
            if (lb.a.a() == false) goto L14;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9898i), "handleIsolationHeader", "Add handleIsolationHeader: https://dl");
        L14:
            r10.add(new HttpHeader("x-ttnet-isolation-info", "https://dl"));
            if (v.h(this.f9898i) > 0) goto L17;
            return true;
        L17:
            if (lb.a.a() == false) goto L19;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9898i), "handleIsolationHeader", "Add x-ttnet-http-proto-type: " + v.h(this.f9898i));
        L19:
            com.ss.android.socialbase.downloader.utils.c.Y(r10, "x-ttnet-http-proto-type");
            r10.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(v.h(this.f9898i))));
            return true;
        }

        @Override // jb.v.b, jb.v.c
        public void a(List<HttpHeader> r10) {
            if (g(r10) == false) goto L6;
            super.a(r10);
            return;
        }

        @Override // jb.v.b, jb.v.c
        public boolean c(BaseException r10) {
            boolean r11 = f(r10);
            this.f9896g = r11;
            if (r11 == false) goto L6;
            super.c(r10);
        L6:
            return this.f9896g;
        }
    }

    private class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f9900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ v f9901c;

        e(v r10) {
            this.f9901c = r10;
            this.f9899a = false;
            this.f9900b = -1;
            if (v.l(r10).isEmpty() == false) goto L5;
            return;
        L5:
            if (v.c(r10).isEmpty() == true) goto L7;
        L8:
            this.f9899a = true;
            return;
        L7:
            if (v.d(r10).isEmpty() == false) goto L8;
        }

        private boolean d(BaseException r10) {
            if (this.f9899a == true) goto L5;
            return false;
        L5:
            boolean r11 = v.l(this.f9901c).contains(Integer.valueOf(r10.getErrorCode()));
            if (r11 == false) goto L10;
            this.f9900b++;
            return true;
        L10:
            if (lb.a.a() == false) goto L12;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9901c), "handleTimeoutError", "IsMatch:" + r11 + " ttnetTimeoutIndex:" + this.f9900b + " errorCode:" + r10.getErrorCode());
        L12:
            return false;
        }

        private void e(List<HttpHeader> r10) {
            if (this.f9899a == true) goto L5;
            return;
        L5:
            if (this.f9900b >= 0) goto L8;
            return;
        L8:
            if (v.d(this.f9901c).isEmpty() == true) goto L18;
            if (this.f9900b >= v.d(this.f9901c).size()) goto L12;
            int r11 = this.f9900b;
        L13:
            String r12 = String.valueOf(v.d(this.f9901c).get(r11));
            if (lb.a.a() == false) goto L16;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9901c), "handleTimeoutHeader", "Add ConnectTimeout:" + r12);
        L16:
            r10.add(new HttpHeader("extra_ttnet_connect_timeout", r12));
            goto L18
        L12:
            r11 = v.d(this.f9901c).size() - 1;
        L18:
            if (v.c(this.f9901c).isEmpty() == false) goto L20;
            return;
        L20:
            if (this.f9900b >= v.c(this.f9901c).size()) goto L22;
            int r13 = this.f9900b;
        L23:
            String r14 = String.valueOf(v.c(this.f9901c).get(r13));
            if (lb.a.a() == false) goto L26;
            lb.a.g("NetworkFailoverStrategy", v.e(this.f9901c), "handleTimeoutHeader", "Add IoTimeout:" + r14);
        L26:
            r10.add(new HttpHeader("extra_ttnet_io_timeout", r14));
            return;
        L22:
            r13 = v.c(this.f9901c).size() - 1;
            goto L23
        }

        @Override // jb.v.c
        public void a(List<HttpHeader> r10) {
            e(r10);
        }

        @Override // jb.v.c
        public boolean b() {
            return false;
        }

        @Override // jb.v.c
        public boolean c(BaseException r10) {
            return d(r10);
        }
    }

    public v(DownloadInfo r19) {
        String r10 = " backHostCountLimit:";
        this.f9872a = new HashSet();
        this.f9873b = 0;
        this.f9874c = 0;
        this.f9875d = new HashSet();
        this.f9876e = new ArrayList();
        this.f9877f = new ArrayList();
        this.f9878g = new HashSet();
        this.f9879h = 0;
        this.f9880i = new ArrayList();
        this.f9881j = new HashSet();
        this.f9882k = 0;
        this.f9883l = new ArrayList();
        this.f9884m = 0;
        o(r19);     // Catch: Throwable -> L8
        if (lb.a.a() == false) goto L18;
        int r11 = this.f9884m;
        String r12 = "Init ttnetIsolationCount:" + this.f9873b + " mIsolationErrorCodeSet:" + this.f9872a.toString() + " mIsolationHttpProtoType:" + this.f9874c + " ttnetTimeoutErrorCodes:" + this.f9875d.toString() + " ttnetConnectTimeout:" + this.f9876e.toString() + " ttnetIoTimeout:" + this.f9877f.toString() + " ipChangeCountLimit:" + this.f9879h + " ipChangeErrorCodeSet:" + this.f9878g + " host:" + this.f9885n + " backHostList:" + this.f9880i.toString() + " backHostCountLimit:" + this.f9882k + " backHostErrorCodeSet:" + this.f9881j;
    L7:
        lb.a.g("NetworkFailoverStrategy", r11, "NetworkFailoverStrategy", r12);
    L18:
        this.f9883l.add(new e(this));
        this.f9883l.add(new b(this));
        this.f9883l.add(new d(this));
        this.f9883l.add(new a(this));
        this.f9883l.add(new e(this));
        return;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        int r13 = this.f9884m;     // Catch: Throwable -> L24
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L22
        r14.append("Init Error");     // Catch: Throwable -> L20
        r14.append(th.toString());     // Catch: Throwable -> L20
        lb.a.h("NetworkFailoverStrategy", r13, "NetworkFailoverStrategy", r14.toString());     // Catch: Throwable -> L20
        if (lb.a.a() == false) goto L18;
        r11 = this.f9884m;
        r12 = "Init ttnetIsolationCount:" + this.f9873b + " mIsolationErrorCodeSet:" + this.f9872a.toString() + " mIsolationHttpProtoType:" + this.f9874c + " ttnetTimeoutErrorCodes:" + this.f9875d.toString() + " ttnetConnectTimeout:" + this.f9876e.toString() + " ttnetIoTimeout:" + this.f9877f.toString() + " ipChangeCountLimit:" + this.f9879h + " ipChangeErrorCodeSet:" + this.f9878g + " host:" + this.f9885n + " backHostList:" + this.f9880i.toString() + " backHostCountLimit:" + this.f9882k + " backHostErrorCodeSet:" + this.f9881j;
    L20:
        th = th;
        String r15 = " backHostErrorCodeSet:";
        r10 = " backHostCountLimit:";
    L27:
        if (lb.a.a() == false) goto L30;
        Throwable r110 = th;
        lb.a.g("NetworkFailoverStrategy", this.f9884m, "NetworkFailoverStrategy", "Init ttnetIsolationCount:" + this.f9873b + " mIsolationErrorCodeSet:" + this.f9872a.toString() + " mIsolationHttpProtoType:" + this.f9874c + " ttnetTimeoutErrorCodes:" + this.f9875d.toString() + " ttnetConnectTimeout:" + this.f9876e.toString() + " ttnetIoTimeout:" + this.f9877f.toString() + " ipChangeCountLimit:" + this.f9879h + " ipChangeErrorCodeSet:" + this.f9878g + " host:" + this.f9885n + " backHostList:" + this.f9880i.toString() + r10 + this.f9882k + r15 + this.f9881j);
        throw r110;
    L30:
        throw th;
    L22:
        th = th;
        r15 = " backHostErrorCodeSet:";
    L24:
        th = th;
        r15 = " backHostErrorCodeSet:";
        goto L27
    }

    static /* synthetic */ int a(v r10) {
        return r10.f9879h;
    }

    static /* synthetic */ Set b(v r10) {
        return r10.f9878g;
    }

    static /* synthetic */ List c(v r10) {
        return r10.f9877f;
    }

    static /* synthetic */ List d(v r10) {
        return r10.f9876e;
    }

    static /* synthetic */ int e(v r10) {
        return r10.f9884m;
    }

    static /* synthetic */ int f(v r10) {
        return r10.f9873b;
    }

    static /* synthetic */ Set g(v r10) {
        return r10.f9872a;
    }

    static /* synthetic */ int h(v r10) {
        return r10.f9874c;
    }

    static /* synthetic */ int i(v r10) {
        return r10.f9882k;
    }

    static /* synthetic */ List j(v r10) {
        return r10.f9880i;
    }

    static /* synthetic */ Set k(v r10) {
        return r10.f9881j;
    }

    static /* synthetic */ Set l(v r10) {
        return r10.f9875d;
    }

    private void o(DownloadInfo r10) {
        if (r10 == null) goto L5;
        this.f9884m = r10.getId();
        this.f9885n = new URL(r10.getUrl()).getHost();
        rb.a r11 = rb.a.g(this.f9884m);
    L6:
        JSONObject r12 = r11.q("network_failover_strategy");
        if (r12 != null) goto L9;
        return;
    L9:
        int r13 = r12.optInt("ttnet_back_host_count_limit");
        if (r13 <= 0) goto L12;
        this.f9882k = r13;
    L12:
        JSONArray r14 = r12.optJSONArray("ttnet_back_host");
        int r15 = 0;
        if (TextUtils.isEmpty(this.f9885n) == true) goto L41;
        if (r14 == null) goto L41;
        if (r14.length() <= 0) goto L41;
        int r16 = 0;
    L19:
        if (r16 >= r14.length()) goto L41;
        String r17 = r14.optString(r16);
        if (TextUtils.isEmpty(r17) == true) goto L40;
        String[] r18 = r17.split(":");
        if (r18 == null) goto L40;
        if (r18.length != 2) goto L40;
        if (this.f9885n.equals(r18[0]) == false) goto L40;
        if (TextUtils.isEmpty(r18[1]) == true) goto L40;
        String[] r19 = r18[1].split(",");
        if (r19 == null) goto L41;
        if (r19.length <= 0) goto L41;
        int r20 = r19.length;
        int r21 = 0;
    L35:
        if (r21 >= r20) goto L41;
        String r22 = r19[r21];
        if (TextUtils.isEmpty(r22) == true) goto L39;
        this.f9880i.add(r22);
    L39:
        r21 = r21 + 1;
    L40:
        r16 = r16 + 1;
    L41:
        JSONArray r23 = r12.optJSONArray("ttnet_back_host_error_code");
        if (r23 != null) goto L44;
    L52:
        int r24 = r12.optInt("ttnet_isolation_count");
        if (r24 <= 0) goto L55;
        this.f9873b = r24;
    L55:
        JSONArray r25 = r12.optJSONArray("ttnet_isolation_error_code");
        if (r25 != null) goto L58;
    L66:
        int r26 = r12.optInt("ttnet_isolation_http_proto_type");
        if (1 == r26) goto L71;
        if (2 == r26) goto L71;
        if (3 == r26) goto L71;
    L72:
        JSONArray r27 = r12.optJSONArray("ttnet_timeout_error_code");
        if (r27 != null) goto L75;
    L83:
        JSONArray r28 = r12.optJSONArray("ttnet_timeout_connect");
        if (r28 != null) goto L86;
    L94:
        JSONArray r29 = r12.optJSONArray("ttnet_timeout_io");
        if (r29 != null) goto L97;
    L105:
        JSONArray r30 = r12.optJSONArray("ttnet_ip_change_error_code");
        if (r30 != null) goto L108;
    L115:
        int r31 = r12.optInt("ttnet_ip_change_count_limit");
        if (r31 <= 0) goto L147;
        this.f9879h = r31;
        return;
    L147:
        return;
    L108:
        if (r30.length() <= 0) goto L115;
    L110:
        if (r15 >= r30.length()) goto L115;
        int r32 = r30.optInt(r15);
        if (r32 <= 0) goto L114;
        this.f9878g.add(Integer.valueOf(r32));
    L114:
        r15 = r15 + 1;
        goto L110
    L97:
        if (r29.length() <= 0) goto L105;
        int r33 = 0;
    L100:
        if (r33 >= r29.length()) goto L105;
        long r34 = r29.optLong(r33);
        if (r34 <= 0) goto L104;
        this.f9877f.add(Long.valueOf(r34));
    L104:
        r33 = r33 + 1;
        goto L100
    L86:
        if (r28.length() <= 0) goto L94;
        int r35 = 0;
    L89:
        if (r35 >= r28.length()) goto L94;
        long r36 = r28.optLong(r35);
        if (r36 <= 0) goto L93;
        this.f9876e.add(Long.valueOf(r36));
    L93:
        r35 = r35 + 1;
        goto L89
    L75:
        if (r27.length() <= 0) goto L83;
        int r37 = 0;
    L78:
        if (r37 >= r27.length()) goto L83;
        int r38 = r27.optInt(r37);
        if (r38 <= 0) goto L82;
        this.f9875d.add(Integer.valueOf(r38));
    L82:
        r37 = r37 + 1;
    L71:
        this.f9874c = r26;
        goto L72
    L58:
        if (r25.length() <= 0) goto L66;
        int r39 = 0;
    L61:
        if (r39 >= r25.length()) goto L66;
        int r40 = r25.optInt(r39);
        if (r40 <= 0) goto L65;
        this.f9872a.add(Integer.valueOf(r40));
    L65:
        r39 = r39 + 1;
        goto L61
    L44:
        if (r23.length() <= 0) goto L52;
        int r41 = 0;
    L47:
        if (r41 >= r23.length()) goto L52;
        int r42 = r23.optInt(r41);
        if (r42 <= 0) goto L51;
        this.f9881j.add(Integer.valueOf(r42));
    L51:
        r41 = r41 + 1;
        goto L47
    L5:
        r11 = rb.a.j();
        goto L6
    }

    public void m(BaseException r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<c> r11 = this.f9883l.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        c r12 = r11.next();
        boolean r13 = r12.c(r10);
        if (r12.b() == false) goto L6;
        if (r13 == false) goto L6;
        return;
    }

    public void n(List<HttpHeader> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<c> r11 = this.f9883l.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().a(r10);
        goto L6
    }
}
