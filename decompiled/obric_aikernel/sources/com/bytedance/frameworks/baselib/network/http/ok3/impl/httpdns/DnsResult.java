package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DnsResult implements Serializable {
    public List<String> ipv4List;
    public List<String> ipv6List;
    public Source source;

    public static final enum Source extends Enum<Source> {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final Source HARDCODE_IPS = null;
        public static final Source HTTPDNS_CACHE = null;
        public static final Source HTTPDNS_REQUEST = null;
        public static final Source HTTPDNS_STALE_CACHE = null;
        public static final Source LOCALDNS_CACHE = null;
        public static final Source LOCALDNS_REQUEST = null;
        public static final Source UNKNOWN = null;

        static {
            Source r10 = new Source("UNKNOWN", 0);
            UNKNOWN = r10;
            Source r11 = new Source("HTTPDNS_CACHE", 1);
            HTTPDNS_CACHE = r11;
            Source r12 = new Source("HTTPDNS_STALE_CACHE", 2);
            HTTPDNS_STALE_CACHE = r12;
            Source r13 = new Source("HTTPDNS_REQUEST", 3);
            HTTPDNS_REQUEST = r13;
            Source r14 = new Source("LOCALDNS_REQUEST", 4);
            LOCALDNS_REQUEST = r14;
            Source r15 = new Source("LOCALDNS_CACHE", 5);
            LOCALDNS_CACHE = r15;
            Source r16 = new Source("HARDCODE_IPS", 6);
            HARDCODE_IPS = r16;
            $VALUES = new Source[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private Source(String r10, int r11) {
            super(r10, r11);
        }

        public static Source valueOf(String r10) {
            return (Source) Enum.valueOf(Source.class, r10);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }
    }

    public DnsResult() {
        this.ipv4List = new ArrayList();
        this.ipv6List = new ArrayList();
        this.source = Source.HTTPDNS_CACHE;
    }
}
