package com.ss.android.socialbase.downloader.downloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<Integer> f15424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15425b;
    private int c;
    private Set<Integer> d;
    private List<Long> e;
    private List<Long> f;
    private Set<Integer> g;
    private int h;
    private List<String> i;
    private Set<Integer> j;
    private int k;
    private List<c> l;
    private int m;
    private String n;

    private class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f15426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15427b;
        private boolean c;
        private int d;

        a(v r2) {
            this.f15426a = r2;
            this.f15427b = false;
            this.c = false;
            this.d = -1;
            if (v.g(r2) > 0) goto L5;
            return;
        L5:
            if (v.h(r2).isEmpty() == true) goto L9;
            this.f15427b = true;
            return;
        }

        private void b(List<HttpHeader> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (this.f15427b == true) goto L5;
            return;
        L5:
            if (this.c == false) goto L17;
            int r0 = this.d;
            if (r0 >= 0) goto L9;
            return;
        L9:
            if (r0 >= v.g(this.f15426a)) goto L19;
            this.c = false;
            String r1 = (String) ZeusTransformUtils.preCheckCast(v.h(this.f15426a).get(this.d % v.h(this.f15426a).size()), String.class, "com.obric.memorydata.plugin");
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15426a), "handleBackHostHeader", "Add BackHost Header: " + r1);
        L14:
            r6.add(new HttpHeader("extra_ttnet_back_host", r1));
            return;
        L19:
            return;
        }

        private boolean b(BaseException r9) {
            if (this.f15427b == true) goto L5;
        L26:
            return false;
        L5:
            if (this.d >= v.g(this.f15426a)) goto L26;
            if (v.i(this.f15426a).isEmpty() == false) goto L10;
        L13:
            boolean r0 = true;
        L15:
            if (r0 == false) goto L24;
            int r1 = this.d + 1;
            this.d = r1;
            if (r1 == v.g(this.f15426a)) goto L19;
            return true;
        L19:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L21;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15426a), "handleBackHostError", "BackHostCountLimit" + v.g(this.f15426a) + " currentBackHostCount:" + this.d + " errorCode:" + r9.getErrorCode());
        L21:
            return false;
        L24:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L26;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15426a), "handleBackHostError", "IsMatch" + r0 + " BackHostCountLimit:" + v.g(this.f15426a) + " errorCode:" + r9.getErrorCode());
            goto L26
        L10:
            if (v.i(this.f15426a).contains(Integer.valueOf(r9.getErrorCode())) == true) goto L13;
            r0 = false;
            goto L15
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public void a(List<HttpHeader> r3) {
            b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public boolean a() {
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public boolean a(BaseException r1) {
            boolean r2 = b(r1);
            this.c = r2;
            return r2;
        }
    }

    private class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f15428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15429b;
        private boolean c;
        private int d;
        private Set<String> e;

        b(v r2) {
            this.f15428a = r2;
            this.f15429b = false;
            this.c = false;
            this.d = -1;
            this.e = new HashSet();
            if (v.a(r2) > 0) goto L5;
            return;
        L5:
            if (v.b(r2).isEmpty() == true) goto L9;
            this.f15429b = true;
            return;
        }

        private void b(List<HttpHeader> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            if (this.f15429b == true) goto L5;
            return;
        L5:
            if (this.c == false) goto L22;
            int r0 = this.d;
            if (r0 >= 0) goto L9;
            return;
        L9:
            if (r0 >= v.a(this.f15428a)) goto L24;
            this.c = false;
            StringBuilder r1 = new StringBuilder();
            Iterator<String> r2 = this.e.iterator();
        L13:
            if (r2.hasNext() == false) goto L16;
            r1.append((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));
            r1.append(",");
            goto L13
        L16:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L18;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15428a), "handleIpChangeHeader", "Add extra_ttnet_change_ip:" + r1.toString());
        L18:
            r7.add(new HttpHeader("extra_ttnet_change_ip", r1.toString()));
            return;
        L24:
            return;
        }

        private boolean b(BaseException r8) {
            if (this.f15429b == true) goto L5;
        L29:
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r8, DownloadTTNetException.class) == false) goto L29;
            if (this.d >= v.a(this.f15428a)) goto L29;
            if (v.b(this.f15428a).contains(Integer.valueOf(r8.getErrorCode())) == true) goto L12;
            return false;
        L12:
            String r0 = ((DownloadTTNetException) ZeusTransformUtils.preCheckCast(r8, DownloadTTNetException.class, "com.obric.memorydata.plugin")).getRemoteIp();
            if (this.d >= v.a(this.f15428a)) goto L27;
            int r9 = this.d + 1;
            this.d = r9;
            if (r9 == v.a(this.f15428a)) goto L17;
            boolean r10 = TextUtils.isEmpty(r0);
            Set<String> r7 = this.e;
            if (r10 == true) goto L24;
            r7.add(r0);
            return true;
        L24:
            r7.add("0.0.0.0");
            return true;
        L17:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L19;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15428a), "handleIpChangeError", "CurrentIpChangeCount:" + this.d + " mIpChangeCountLimit:" + v.a(this.f15428a));
        L19:
            return false;
        L27:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L29;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15428a), "handleIpChangeError", " RemoteIp:" + r0 + " currentIpChangeCount:" + this.d + " errorCode:" + r8.getErrorCode() + " mIpChangeErrorIps:" + this.e.toString());
            goto L29
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public void a(List<HttpHeader> r3) {
            b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public boolean a() {
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public boolean a(BaseException r1) {
            boolean r2 = b(r1);
            this.c = r2;
            return r2;
        }
    }

    private interface c {
        void a(List<HttpHeader> r1);

        boolean a();

        boolean a(BaseException r1);
    }

    private class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v f15430b;
        private boolean c;
        private boolean d;
        private int e;

        d(v r2) {
            this.f15430b = r2;
            super(r2);
            this.c = false;
            this.d = false;
            this.e = -1;
            if (v.d(r2) > 0) goto L5;
            return;
        L5:
            if (v.e(r2).isEmpty() == true) goto L9;
            this.c = true;
            return;
        }

        private boolean b(BaseException r10) {
            if (this.c == true) goto L5;
        L19:
            return false;
        L5:
            if (this.e >= v.d(this.f15430b)) goto L19;
            boolean r0 = v.e(this.f15430b).contains(Integer.valueOf(r10.getErrorCode()));
            if (r0 == false) goto L17;
            int r1 = this.e + 1;
            this.e = r1;
            if (r1 == v.d(this.f15430b)) goto L12;
            return true;
        L12:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15430b), "handleIsolationError", "IsolationCount" + v.d(this.f15430b) + " ttnetIsolationIndex:" + this.e + " errorCode:" + r10.getErrorCode());
        L14:
            return false;
        L17:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L19;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15430b), "handleIsolationError", "IsMatch" + r0 + " ttnetIsolationIndex:" + this.e + " errorCode:" + r10.getErrorCode());
            goto L19
        }

        private boolean b(List<HttpHeader> r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            if (this.c == true) goto L5;
        L22:
            return false;
        L5:
            if (this.d == false) goto L22;
            int r0 = this.e;
            if (r0 < 0) goto L22;
            if (r0 >= v.d(this.f15430b)) goto L22;
            this.d = false;
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15430b), "handleIsolationHeader", "Add handleIsolationHeader: https://dl");
        L14:
            r7.add(new HttpHeader("x-ttnet-isolation-info", "https://dl"));
            if (v.f(this.f15430b) > 0) goto L17;
            return true;
        L17:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L19;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15430b), "handleIsolationHeader", "Add x-ttnet-http-proto-type: " + v.f(this.f15430b));
        L19:
            com.ss.android.socialbase.downloader.utils.c.a(r7, "x-ttnet-http-proto-type");
            r7.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(v.f(this.f15430b))));
            return true;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.b, com.ss.android.socialbase.downloader.downloader.v.c
        public void a(List<HttpHeader> r3) {
            List<HttpHeader> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if (b(r4) == false) goto L6;
            super.a(r4);
            return;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.b, com.ss.android.socialbase.downloader.downloader.v.c
        public boolean a(BaseException r2) {
            boolean r0 = b(r2);
            this.d = r0;
            if (r0 == false) goto L6;
            super.a(r2);
        L6:
            return this.d;
        }
    }

    private class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f15431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15432b;
        private int c;

        e(v r2) {
            this.f15431a = r2;
            this.f15432b = false;
            this.c = -1;
            if (v.j(r2).isEmpty() == false) goto L5;
            return;
        L5:
            if (v.k(r2).isEmpty() == true) goto L7;
        L8:
            this.f15432b = true;
            return;
        L7:
            if (v.l(r2).isEmpty() == false) goto L8;
        }

        private void b(List<HttpHeader> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            if (this.f15432b == true) goto L5;
            return;
        L5:
            if (this.c >= 0) goto L8;
            return;
        L8:
            if (v.l(this.f15431a).isEmpty() == true) goto L18;
            if (this.c >= v.l(this.f15431a).size()) goto L12;
            int r0 = this.c;
        L13:
            String r1 = String.valueOf(v.l(this.f15431a).get(r0));
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15431a), "handleTimeoutHeader", "Add ConnectTimeout:" + r1);
        L16:
            r8.add(new HttpHeader("extra_ttnet_connect_timeout", r1));
            goto L18
        L12:
            r0 = v.l(this.f15431a).size() - 1;
        L18:
            if (v.k(this.f15431a).isEmpty() == false) goto L20;
            return;
        L20:
            if (this.c >= v.k(this.f15431a).size()) goto L22;
            int r2 = this.c;
        L23:
            String r3 = String.valueOf(v.k(this.f15431a).get(r2));
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L26;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15431a), "handleTimeoutHeader", "Add IoTimeout:" + r3);
        L26:
            r8.add(new HttpHeader("extra_ttnet_io_timeout", r3));
            return;
        L22:
            r2 = v.k(this.f15431a).size() - 1;
            goto L23
        }

        private boolean b(BaseException r6) {
            if (this.f15432b == true) goto L5;
            return false;
        L5:
            boolean r0 = v.j(this.f15431a).contains(Integer.valueOf(r6.getErrorCode()));
            if (r0 == false) goto L10;
            this.c++;
            return true;
        L10:
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L12;
            com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", v.c(this.f15431a), "handleTimeoutError", "IsMatch:" + r0 + " ttnetTimeoutIndex:" + this.c + " errorCode:" + r6.getErrorCode());
        L12:
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public void a(List<HttpHeader> r3) {
            b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public boolean a() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.v.c
        public boolean a(BaseException r1) {
            return b(r1);
        }
    }

    public v(DownloadInfo r20) {
        this.f15424a = new HashSet();
        this.f15425b = 0;
        this.c = 0;
        this.d = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new HashSet();
        this.h = 0;
        this.i = new ArrayList();
        this.j = new HashSet();
        this.k = 0;
        this.l = new ArrayList();
        this.m = 0;
        a(r20);     // Catch: Throwable -> L7
        if (com.ss.android.socialbase.downloader.e.a.a(r20) == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", r20, "NetworkFailoverStrategy", "Init ttnetIsolationCount:" + this.f15425b + " mIsolationErrorCodeSet:" + this.f15424a.toString() + " mIsolationHttpProtoType:" + this.c + " ttnetTimeoutErrorCodes:" + this.d.toString() + " ttnetConnectTimeout:" + this.e.toString() + " ttnetIoTimeout:" + this.f.toString() + " ipChangeCountLimit:" + this.h + " ipChangeErrorCodeSet:" + this.g + " host:" + this.n + " backHostList:" + this.i.toString() + " backHostCountLimit:" + this.k + " backHostErrorCodeSet:" + this.j);
    L16:
        this.l.add(new e(this));
        this.l.add(new b(this));
        this.l.add(new d(this));
        this.l.add(new a(this));
        this.l.add(new e(this));
        return;
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L22
        com.ss.android.socialbase.downloader.e.a.b("NetworkFailoverStrategy", this.m, "NetworkFailoverStrategy", "Init Error" + th.toString());     // Catch: Throwable -> L18
        if (com.ss.android.socialbase.downloader.e.a.a(r20) == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", r20, "NetworkFailoverStrategy", "Init ttnetIsolationCount:" + this.f15425b + " mIsolationErrorCodeSet:" + this.f15424a.toString() + " mIsolationHttpProtoType:" + this.c + " ttnetTimeoutErrorCodes:" + this.d.toString() + " ttnetConnectTimeout:" + this.e.toString() + " ttnetIoTimeout:" + this.f.toString() + " ipChangeCountLimit:" + this.h + " ipChangeErrorCodeSet:" + this.g + " host:" + this.n + " backHostList:" + this.i.toString() + " backHostCountLimit:" + this.k + " backHostErrorCodeSet:" + this.j);
    L18:
        th = th;
        DownloadInfo r3 = r20;
        String r2 = " backHostErrorCodeSet:";
    L25:
        if (com.ss.android.socialbase.downloader.e.a.a(r20) == false) goto L28;
        Throwable r16 = th;
        com.ss.android.socialbase.downloader.e.a.a("NetworkFailoverStrategy", r3, "NetworkFailoverStrategy", "Init ttnetIsolationCount:" + this.f15425b + " mIsolationErrorCodeSet:" + this.f15424a.toString() + " mIsolationHttpProtoType:" + this.c + " ttnetTimeoutErrorCodes:" + this.d.toString() + " ttnetConnectTimeout:" + this.e.toString() + " ttnetIoTimeout:" + this.f.toString() + " ipChangeCountLimit:" + this.h + " ipChangeErrorCodeSet:" + this.g + " host:" + this.n + " backHostList:" + this.i.toString() + " backHostCountLimit:" + this.k + r2 + this.j);
        throw r16;
    L28:
        throw th;
    L20:
        th = th;
        r2 = " backHostErrorCodeSet:";
        r3 = r20;
    L22:
        th = th;
        r3 = r20;
        r2 = " backHostErrorCodeSet:";
        goto L25
    }

    static /* synthetic */ int a(v r0) {
        return r0.h;
    }

    private void a(DownloadInfo r9) {
        if (r9 == null) goto L5;
        this.m = r9.getId();
        this.n = new URL(r9.getUrl()).getHost();
        com.ss.android.socialbase.downloader.g.a r10 = com.ss.android.socialbase.downloader.g.a.a(this.m);
    L6:
        JSONObject r11 = r10.e("network_failover_strategy");
        if (r11 != null) goto L9;
        return;
    L9:
        int r0 = r11.optInt("ttnet_back_host_count_limit");
        if (r0 <= 0) goto L12;
        this.k = r0;
    L12:
        JSONArray r1 = r11.optJSONArray("ttnet_back_host");
        int r3 = 0;
        if (TextUtils.isEmpty(this.n) == true) goto L41;
        if (r1 == null) goto L41;
        if (r1.length() <= 0) goto L41;
        int r2 = 0;
    L19:
        if (r2 >= r1.length()) goto L41;
        String r5 = r1.optString(r2);
        if (TextUtils.isEmpty(r5) == true) goto L40;
        String[] r6 = r5.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (r6 == null) goto L40;
        if (r6.length != 2) goto L40;
        if (this.n.equals(r6[0]) == false) goto L40;
        if (TextUtils.isEmpty(r6[1]) == true) goto L40;
        String[] r4 = r6[1].split(",");
        if (r4 == null) goto L41;
        if (r4.length <= 0) goto L41;
        int r7 = r4.length;
        int r8 = 0;
    L35:
        if (r8 >= r7) goto L41;
        String r12 = r4[r8];
        if (TextUtils.isEmpty(r12) == true) goto L39;
        this.i.add(r12);
    L39:
        r8 = r8 + 1;
    L40:
        r2 = r2 + 1;
    L41:
        JSONArray r13 = r11.optJSONArray("ttnet_back_host_error_code");
        if (r13 != null) goto L44;
    L52:
        int r14 = r11.optInt("ttnet_isolation_count");
        if (r14 <= 0) goto L55;
        this.f15425b = r14;
    L55:
        JSONArray r15 = r11.optJSONArray("ttnet_isolation_error_code");
        if (r15 != null) goto L58;
    L66:
        int r16 = r11.optInt("ttnet_isolation_http_proto_type");
        if (1 == r16) goto L71;
        if (2 == r16) goto L71;
        if (3 == r16) goto L71;
    L72:
        JSONArray r17 = r11.optJSONArray("ttnet_timeout_error_code");
        if (r17 != null) goto L75;
    L83:
        JSONArray r18 = r11.optJSONArray("ttnet_timeout_connect");
        if (r18 != null) goto L86;
    L94:
        JSONArray r19 = r11.optJSONArray("ttnet_timeout_io");
        if (r19 != null) goto L97;
    L105:
        JSONArray r20 = r11.optJSONArray("ttnet_ip_change_error_code");
        if (r20 != null) goto L108;
    L115:
        int r21 = r11.optInt("ttnet_ip_change_count_limit");
        if (r21 <= 0) goto L147;
        this.h = r21;
        return;
    L147:
        return;
    L108:
        if (r20.length() <= 0) goto L115;
    L110:
        if (r3 >= r20.length()) goto L115;
        int r22 = r20.optInt(r3);
        if (r22 <= 0) goto L114;
        this.g.add(Integer.valueOf(r22));
    L114:
        r3 = r3 + 1;
        goto L110
    L97:
        if (r19.length() <= 0) goto L105;
        int r23 = 0;
    L100:
        if (r23 >= r19.length()) goto L105;
        long r24 = r19.optLong(r23);
        if (r24 <= 0) goto L104;
        this.f.add(Long.valueOf(r24));
    L104:
        r23 = r23 + 1;
        goto L100
    L86:
        if (r18.length() <= 0) goto L94;
        int r25 = 0;
    L89:
        if (r25 >= r18.length()) goto L94;
        long r26 = r18.optLong(r25);
        if (r26 <= 0) goto L93;
        this.e.add(Long.valueOf(r26));
    L93:
        r25 = r25 + 1;
        goto L89
    L75:
        if (r17.length() <= 0) goto L83;
        int r27 = 0;
    L78:
        if (r27 >= r17.length()) goto L83;
        int r28 = r17.optInt(r27);
        if (r28 <= 0) goto L82;
        this.d.add(Integer.valueOf(r28));
    L82:
        r27 = r27 + 1;
    L71:
        this.c = r16;
        goto L72
    L58:
        if (r15.length() <= 0) goto L66;
        int r29 = 0;
    L61:
        if (r29 >= r15.length()) goto L66;
        int r30 = r15.optInt(r29);
        if (r30 <= 0) goto L65;
        this.f15424a.add(Integer.valueOf(r30));
    L65:
        r29 = r29 + 1;
        goto L61
    L44:
        if (r13.length() <= 0) goto L52;
        int r31 = 0;
    L47:
        if (r31 >= r13.length()) goto L52;
        int r32 = r13.optInt(r31);
        if (r32 <= 0) goto L51;
        this.j.add(Integer.valueOf(r32));
    L51:
        r31 = r31 + 1;
        goto L47
    L5:
        r10 = com.ss.android.socialbase.downloader.g.a.c();
        goto L6
    }

    static /* synthetic */ Set b(v r0) {
        return r0.g;
    }

    static /* synthetic */ int c(v r0) {
        return r0.m;
    }

    static /* synthetic */ int d(v r0) {
        return r0.f15425b;
    }

    static /* synthetic */ Set e(v r0) {
        return r0.f15424a;
    }

    static /* synthetic */ int f(v r0) {
        return r0.c;
    }

    static /* synthetic */ int g(v r0) {
        return r0.k;
    }

    static /* synthetic */ List h(v r0) {
        return r0.i;
    }

    static /* synthetic */ Set i(v r0) {
        return r0.j;
    }

    static /* synthetic */ Set j(v r0) {
        return r0.d;
    }

    static /* synthetic */ List k(v r0) {
        return r0.f;
    }

    static /* synthetic */ List l(v r0) {
        return r0.e;
    }

    public void a(BaseException r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<c> r3 = this.l.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.memorydata.plugin");
        boolean r1 = r0.a(r4);
        if (r0.a() == false) goto L6;
        if (r1 == false) goto L6;
        return;
    }

    public void a(List<HttpHeader> r4) {
        List<HttpHeader> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<c> r3 = this.l.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.memorydata.plugin")).a(r5);
        goto L7
    }
}
