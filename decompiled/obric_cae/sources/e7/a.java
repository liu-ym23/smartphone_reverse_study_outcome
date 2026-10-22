package e7;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f7135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f7136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f7137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f7138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakHandler f7139f;

    /* JADX INFO: renamed from: e7.a$a, reason: collision with other inner class name */
    public static final enum EnumC0065a extends Enum<EnumC0065a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0065a f7140a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0065a f7141b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0065a f7142m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final EnumC0065a f7143n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final EnumC0065a f7144o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final /* synthetic */ EnumC0065a[] f7145p = null;

        static {
            EnumC0065a r8 = new EnumC0065a("CACHE_UNSET", 0);
            f7140a = r8;
            EnumC0065a r10 = new EnumC0065a("CACHE_VALID", 1);
            EnumC0065a r11 = new EnumC0065a("CACHE_STALE_BOTH", 2);
            EnumC0065a r12 = new EnumC0065a("CACHE_STALE_NETCHANGED", 3);
            f7141b = r12;
            EnumC0065a r13 = new EnumC0065a("CACHE_STALE_EXPIRED", 4);
            f7142m = r13;
            EnumC0065a r14 = new EnumC0065a("PRELOAD_BATCH", 5);
            f7143n = r14;
            EnumC0065a r15 = new EnumC0065a("REFRESH_BATCH", 6);
            f7144o = r15;
            f7145p = new EnumC0065a[]{r8, r10, r11, r12, r13, r14, r15};
        }

        public EnumC0065a(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0065a valueOf(String r8) {
            return (EnumC0065a) Enum.valueOf(EnumC0065a.class, r8);
        }

        public static EnumC0065a[] values() {
            return (EnumC0065a[]) f7145p.clone();
        }
    }

    public a(String r8, long r10, ArrayList r11, ArrayList r12, int r13) {
        this.f7134a = r8;
        this.f7138e = r10;
        this.f7135b = r11;
        this.f7136c = r12;
        this.f7137d = r13;
        e.g().getClass();
        this.f7139f = new WeakHandler(e.E.getLooper(), e.g());
    }

    public final void a() {
        Message r8 = Message.obtain();
        r8.obj = this;
        r8.what = 11;
        e(r8);
        long r10 = ((long) e.g().f7174q.get()) * 1000;
        this.f7139f.sendMessageDelayed(r8, r10);
    }

    public final void b() {
        WeakHandler r8 = this.f7139f;
        r8.removeMessages(10);
        r8.removeMessages(12);
    }

    public final void c() {
        this.f7139f.removeMessages(13);
    }

    public final void d() {
        this.f7139f.removeMessages(11);
    }

    public final void e(Message r8) {
        Bundle r10 = new Bundle();
        r10.putString("dnsrecord_host", this.f7134a);
        r8.setData(r10);
    }
}
