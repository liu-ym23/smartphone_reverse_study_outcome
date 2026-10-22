package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DnsRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2471a = "DnsRecord";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2472b;
    private List<String> c;
    private List<String> d;
    private long e;
    private long f;
    private final WeakHandler g;

    public static final enum CacheStaleReason extends Enum<CacheStaleReason> {
        private static final /* synthetic */ CacheStaleReason[] $VALUES = null;
        public static final CacheStaleReason CACHE_STALE_BOTH = null;
        public static final CacheStaleReason CACHE_STALE_EXPIRED = null;
        public static final CacheStaleReason CACHE_STALE_NETCHANGED = null;
        public static final CacheStaleReason CACHE_UNSET = null;
        public static final CacheStaleReason CACHE_VALID = null;
        public static final CacheStaleReason PRELOAD_BATCH = null;
        public static final CacheStaleReason REFRESH_BATCH = null;

        static {
            CacheStaleReason r0 = new CacheStaleReason("CACHE_UNSET", 0);
            CACHE_UNSET = r0;
            CacheStaleReason r1 = new CacheStaleReason("CACHE_VALID", 1);
            CACHE_VALID = r1;
            CacheStaleReason r3 = new CacheStaleReason("CACHE_STALE_BOTH", 2);
            CACHE_STALE_BOTH = r3;
            CacheStaleReason r5 = new CacheStaleReason("CACHE_STALE_NETCHANGED", 3);
            CACHE_STALE_NETCHANGED = r5;
            CacheStaleReason r7 = new CacheStaleReason("CACHE_STALE_EXPIRED", 4);
            CACHE_STALE_EXPIRED = r7;
            CacheStaleReason r9 = new CacheStaleReason("PRELOAD_BATCH", 5);
            PRELOAD_BATCH = r9;
            CacheStaleReason r11 = new CacheStaleReason("REFRESH_BATCH", 6);
            REFRESH_BATCH = r11;
            $VALUES = new CacheStaleReason[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private CacheStaleReason(String r1, int r2) {
            super(r1, r2);
        }

        public static CacheStaleReason valueOf(String r2) {
            return (CacheStaleReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(CacheStaleReason.class, r2), CacheStaleReason.class, "com.obric.memorydata.plugin");
        }

        public static CacheStaleReason[] values() {
            return (CacheStaleReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CacheStaleReason[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public DnsRecord(String r3, long r4, List<String> r6, List<String> r7, int r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.f2472b = r3;
        this.f = r4;
        this.c = r9;
        this.d = r10;
        this.e = r8;
        this.g = new WeakHandler(b.a().k().getLooper(), b.a());
    }

    private void a(Message r3) {
        Bundle r0 = new Bundle();
        r0.putString("dnsrecord_host", this.f2472b);
        r3.setData(r0);
    }

    public void a() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 12;
        a(r0);
        this.g.sendMessageDelayed(r0, this.e * 1000);
        Message r1 = Message.obtain();
        r1.obj = this;
        r1.what = 10;
        a(r1);
        this.g.sendMessageDelayed(r1, (this.e * 1000) + (((long) b.a().c().get()) * 1000));
    }

    public void b() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 13;
        a(r0);
        this.g.sendMessageDelayed(r0, this.e * 1000);
    }

    public void c() {
        this.g.removeMessages(10);
        this.g.removeMessages(12);
    }

    public void d() {
        this.g.removeMessages(13);
    }

    public void e() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 11;
        a(r0);
        this.g.sendMessageDelayed(r0, ((long) b.a().b().get()) * 1000);
    }

    public void f() {
        this.g.removeMessages(11);
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public List<String> i() {
        return this.c;
    }

    public List<String> j() {
        return this.d;
    }
}
