package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DnsResult implements Serializable {
    public List<String> ipv4List;
    public List<String> ipv6List;
    public Source source;

    public static final enum Source extends Enum<Source> {
        public static final Source HARDCODE_IPS = null;
        public static final Source HTTPDNS_CACHE = null;
        public static final Source HTTPDNS_REQUEST = null;
        public static final Source HTTPDNS_STALE_CACHE = null;
        public static final Source LOCALDNS_CACHE = null;
        public static final Source LOCALDNS_REQUEST = null;
        public static final Source UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f4685a = null;

        static {
            Source r5 = new Source("UNKNOWN", 0);
            UNKNOWN = r5;
            Source r10 = new Source("HTTPDNS_CACHE", 1);
            HTTPDNS_CACHE = r10;
            Source r11 = new Source("HTTPDNS_STALE_CACHE", 2);
            HTTPDNS_STALE_CACHE = r11;
            Source r12 = new Source("HTTPDNS_REQUEST", 3);
            HTTPDNS_REQUEST = r12;
            Source r13 = new Source("LOCALDNS_REQUEST", 4);
            LOCALDNS_REQUEST = r13;
            Source r14 = new Source("LOCALDNS_CACHE", 5);
            LOCALDNS_CACHE = r14;
            Source r15 = new Source("HARDCODE_IPS", 6);
            HARDCODE_IPS = r15;
            f4685a = new Source[]{r5, r10, r11, r12, r13, r14, r15};
        }

        public static Source valueOf(String r5) {
            return (Source) Enum.valueOf(Source.class, r5);
        }

        public static Source[] values() {
            return (Source[]) f4685a.clone();
        }
    }

    public DnsResult() {
        this.ipv4List = new ArrayList();
        this.ipv6List = new ArrayList();
        this.source = Source.HTTPDNS_CACHE;
    }
}
