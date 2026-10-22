package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 {
    public static boolean b;
    public final ConcurrentHashMap<Integer, q> a;

    public static final class a {
        public boolean a;
        public boolean b;
        public com.bytedance.android.live.pushstream.d c;

        public a() {
        }

        public final d0 a() {
            d0 r0 = new d0();
            if (this.a == false) goto L6;
            r0.b(2, new IMStreamInfoSender());
        L6:
            if (this.b == false) goto L10;
            com.bytedance.android.live.pushstream.d r1 = this.c;
            if (r1 == null) goto L10;
            r0.b(1, new c(r1));
        L10:
            ALogger.i("LiveStreamInfoSenderManager", "build: IM:" + this.a + ",SEI:" + this.b + ", liveStream:" + this.c);
            return r0;
        }

        public final void b(boolean r2) {
            this.a = r2;
            ALogger.i("LiveStreamInfoSenderManager", "enableIM：" + this.a);
        }

        public final void c(boolean r2, com.bytedance.android.live.pushstream.d r3) {
            Intrinsics.checkNotNullParameter(r3, "liveStream");
            this.b = r2;
            this.c = r3;
            ALogger.i("LiveStreamInfoSenderManager", "enableSei：" + this.b);
        }
    }

    public static final class b {
    }

    static {
    }

    public d0() {
        this.a = new ConcurrentHashMap();
    }

    public final q a(int r2) {
        return this.a.get(Integer.valueOf(r2));
    }

    public final void b(int r5, q r6) {
        Intrinsics.checkNotNullParameter(r6, "sender");
        boolean r1 = false;
        if (this.a.contains(Integer.valueOf(r5)) == false) goto L12;
        q r0 = this.a.remove(Integer.valueOf(r5));
        if (r0 == null) goto L8;
        r0.onClose();
    L8:
        if (this.a.size() > 1) goto L10;
        boolean r2 = true;
    L11:
        b = r2;
        goto L12
    L10:
        r2 = false;
    L12:
        this.a.put(Integer.valueOf(r5), r6);
        if (this.a.size() > 1) goto L15;
        r1 = true;
    L15:
        b = r1;
    }
}
