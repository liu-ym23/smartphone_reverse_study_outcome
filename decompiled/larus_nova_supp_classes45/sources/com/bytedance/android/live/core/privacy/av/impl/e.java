package com.bytedance.android.live.core.privacy.av.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements com.bytedance.android.live.core.privacy.av.api.e, com.bytedance.android.live.core.privacy.av.api.g {
    public static int i;
    public final AtomicInteger a;
    public final Map<Integer, List<Integer>> b;
    public final List<c> c;
    public final Map<Integer, String> d;
    public final Handler e;
    public final com.bytedance.android.live.core.privacy.av.api.d f;
    public final com.bytedance.android.live.core.privacy.av.api.b g;
    public final PrivacyConfig h;

    public static final class a {
    }

    public static final class b {
        public final int a;

        public b() {
            this(-1);
        }

        public b(int r1) {
            this.a = r1;
        }
    }

    public static final class c {
        public final int a;
        public final String b;
        public final String c;
        public final Map<String, String> d;
        public final com.bytedance.android.live.core.privacy.av.api.b e;
        public final com.bytedance.android.live.core.privacy.av.api.a f;
        public final int g;
        public boolean h;

        public c() {
            throw null;
        }

        public final int getType() {
            return this.g;
        }

        public c(int r2, String r3, String r4, Map r5, com.bytedance.android.live.core.privacy.av.api.b r6, com.bytedance.android.live.core.privacy.av.api.a r7, int r8) {
            Intrinsics.checkNotNullParameter(r3, "biz");
            Intrinsics.checkNotNullParameter(r4, "sense");
            Intrinsics.checkNotNullParameter(r5, "params");
            Intrinsics.checkNotNullParameter(r6, "callback");
            Intrinsics.checkNotNullParameter(r7, "config");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = false;
        }
    }

    static {
        i = -1;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void a() {
        Handler r0 = this.e;
        r0.sendMessageAtFrontOfQueue(Message.obtain(r0, 2, new b(-1)));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void b() {
        Handler r0 = this.e;
        r0.sendMessageAtFrontOfQueue(Message.obtain(r0, 4, new b(-1)));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void f() {
        Handler r0 = this.e;
        r0.sendMessageAtFrontOfQueue(Message.obtain(r0, 1, new b(-1)));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final void g() {
        if (LiveInfraSettingKeys.LIVE_AV_PRIVACY_DETECT_SYS_AUDIO_OPT.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        int r0 = i;
        if (r0 <= (-1)) goto L9;
        Handler r2 = this.e;
        r2.sendMessageAtFrontOfQueue(Message.obtain(r2, 5, new b(r0)));
        i = -1;
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void h() {
        Handler r0 = this.e;
        r0.sendMessageAtFrontOfQueue(Message.obtain(r0, 3, new b(-1)));
    }

    public e(com.bytedance.android.live.core.privacy.av.impl.c r3, AudioAndVideoCallbackSystemImpl r4, PrivacyConfig r5) {
        Intrinsics.checkNotNullParameter(r3, "checker");
        Intrinsics.checkNotNullParameter(r4, "systemCallback");
        Intrinsics.checkNotNullParameter(r5, "privacyConfig");
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = new AtomicInteger(1);
        this.b = new ConcurrentHashMap();
        this.c = new CopyOnWriteArrayList();
        this.d = MapsKt.mapOf(new Pair[]{new Pair(4, "audio_open"), new Pair(1, "audio_release"), new Pair(2, "video_release"), new Pair(3, "video_open")});
        this.e = new Handler(Looper.getMainLooper(), new f(this));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int c(String r17, String r18, Map<String, String> r19, com.bytedance.android.live.core.privacy.av.api.b r21, com.bytedance.android.live.core.privacy.av.api.a r22) {
        Intrinsics.checkNotNullParameter(r17, "biz");
        Intrinsics.checkNotNullParameter(r18, "sense");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r21, "callback");
        Intrinsics.checkNotNullParameter(r22, "config");
        int r14 = this.a.getAndIncrement();
        if (r22.a >= 0) goto L6;
        r22.a = r14;
    L6:
        if (r22.b() == false) goto L8;
        i = r14;
    L8:
        c r15 = new c(r14, r17, r18, r19, r21, r22, 1);
        Message r1 = Message.obtain(this.e, 1, r15);
        ((CopyOnWriteArrayList) this.c).add(r15);
        if (r22.a() > 0) goto L11;
        int r2 = this.h.a();
    L12:
        this.e.sendMessageDelayed(r1, r2);
        r21.b(r17, r18, "audio_release", r19, r22);
        this.g.b(r17, r18, "audio_release", r19, r22);
        return r14;
    L11:
        r2 = r22.a();
        goto L12
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int d(String r3, String r4, Map<String, String> r5, com.bytedance.android.live.core.privacy.av.api.b r6, com.bytedance.android.live.core.privacy.av.api.a r7) {
        Intrinsics.checkNotNullParameter(r3, "biz");
        Intrinsics.checkNotNullParameter(r4, "sense");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "config");
        int r0 = this.a.getAndIncrement();
        r7.a = r0;
        int r1 = c(r3, r4, r5, r6, r7);
        int r8 = e(r3, r4, r5, r6, r7);
        Map<Integer, List<Integer>> r9 = this.b;
        ConcurrentHashMap r11 = (ConcurrentHashMap) r9;
        r11.put(Integer.valueOf(r0), CollectionsKt.listOf(new Integer[]{Integer.valueOf(r1), Integer.valueOf(r8)}));
        return r0;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int e(String r17, String r18, Map<String, String> r19, com.bytedance.android.live.core.privacy.av.api.b r21, com.bytedance.android.live.core.privacy.av.api.a r22) {
        Intrinsics.checkNotNullParameter(r17, "biz");
        Intrinsics.checkNotNullParameter(r18, "sense");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r21, "callback");
        Intrinsics.checkNotNullParameter(r22, "config");
        int r14 = this.a.getAndIncrement();
        if (r22.a >= 0) goto L5;
        r22.a = r14;
    L5:
        c r15 = new c(r14, r17, r18, r19, r21, r22, 2);
        Message r1 = Message.obtain(this.e, 2, r15);
        ((CopyOnWriteArrayList) this.c).add(r15);
        if (r22.a() > 0) goto L8;
        int r2 = this.h.a();
    L9:
        this.e.sendMessageDelayed(r1, r2);
        r21.b(r17, r18, "video_release", r19, r22);
        this.g.b(r17, r18, "video_release", r19, r22);
        return r14;
    L8:
        r2 = r22.a();
        goto L9
    }
}
