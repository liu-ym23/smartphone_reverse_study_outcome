package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DnsRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f1695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f1696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f1698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakHandler f1699f;

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
            CacheStaleReason r10 = new CacheStaleReason("CACHE_UNSET", 0);
            CACHE_UNSET = r10;
            CacheStaleReason r11 = new CacheStaleReason("CACHE_VALID", 1);
            CACHE_VALID = r11;
            CacheStaleReason r12 = new CacheStaleReason("CACHE_STALE_BOTH", 2);
            CACHE_STALE_BOTH = r12;
            CacheStaleReason r13 = new CacheStaleReason("CACHE_STALE_NETCHANGED", 3);
            CACHE_STALE_NETCHANGED = r13;
            CacheStaleReason r14 = new CacheStaleReason("CACHE_STALE_EXPIRED", 4);
            CACHE_STALE_EXPIRED = r14;
            CacheStaleReason r15 = new CacheStaleReason("PRELOAD_BATCH", 5);
            PRELOAD_BATCH = r15;
            CacheStaleReason r16 = new CacheStaleReason("REFRESH_BATCH", 6);
            REFRESH_BATCH = r16;
            $VALUES = new CacheStaleReason[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private CacheStaleReason(String r10, int r11) {
            super(r10, r11);
        }

        public static CacheStaleReason valueOf(String r10) {
            return (CacheStaleReason) Enum.valueOf(CacheStaleReason.class, r10);
        }

        public static CacheStaleReason[] values() {
            return (CacheStaleReason[]) $VALUES.clone();
        }
    }

    static {
    }

    public DnsRecord(String r10, long r11, List<String> r12, List<String> r13, int r14) {
        this.f1694a = r10;
        this.f1698e = r11;
        this.f1695b = r12;
        this.f1696c = r13;
        this.f1697d = r14;
        this.f1699f = new WeakHandler(b.q().k().getLooper(), b.q());
    }

    private void k(Message r10) {
        Bundle r11 = new Bundle();
        r11.putString("dnsrecord_host", this.f1694a);
        r10.setData(r11);
    }

    public void a() {
        Message r10 = Message.obtain();
        r10.obj = this;
        r10.what = 12;
        k(r10);
        this.f1699f.sendMessageDelayed(r10, this.f1697d * 1000);
        Message r11 = Message.obtain();
        r11.obj = this;
        r11.what = 10;
        k(r11);
        this.f1699f.sendMessageDelayed(r11, (this.f1697d * 1000) + (((long) b.q().m().get()) * 1000));
    }

    public void b() {
        Message r10 = Message.obtain();
        r10.obj = this;
        r10.what = 13;
        k(r10);
        this.f1699f.sendMessageDelayed(r10, this.f1697d * 1000);
    }

    public void c() {
        Message r10 = Message.obtain();
        r10.obj = this;
        r10.what = 11;
        k(r10);
        this.f1699f.sendMessageDelayed(r10, ((long) b.q().p().get()) * 1000);
    }

    public long d() {
        return this.f1698e;
    }

    public List<String> e() {
        return this.f1695b;
    }

    public List<String> f() {
        return this.f1696c;
    }

    public long g() {
        return this.f1697d;
    }

    public void h() {
        this.f1699f.removeMessages(10);
        this.f1699f.removeMessages(12);
    }

    public void i() {
        this.f1699f.removeMessages(13);
    }

    public void j() {
        this.f1699f.removeMessages(11);
    }
}
