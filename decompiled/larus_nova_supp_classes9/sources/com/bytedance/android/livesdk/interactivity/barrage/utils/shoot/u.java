package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends r22.a<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
    public final Deque<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> c;
    public final r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> d;

    public static final class a {
    }

    static {
    }

    @Override // r22.a
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.d j() {
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public final r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> f() {
        return this.d;
    }

    @Override // r22.a
    public final Queue<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> h() {
        return this.c;
    }

    public u(r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.d = r2;
        this.c = new LinkedList();
    }

    @Override // r22.a
    public final void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "danmaku");
        if (((LinkedList) this.c).size() < 100) goto L5;
        ((LinkedList) this.c).removeFirst();
    L5:
        ((LinkedList) this.c).add(r4);
        k();
    }

    @Override // r22.a
    public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r7, r22.a.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r8) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r9 = r7;
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r8, "notifier");
        py.k r1 = null;
        if ((r9 instanceof q72.e) == true) goto L5;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r0 = null;
    L6:
        q72.e r2 = (q72.e) r0;
        IBaseUser r3 = r9.getUserInfo();
        if (r3 == null) goto L9;
        py.k r4 = r3.getAvatarThumbKt();
    L10:
        com.bytedance.android.live.base.model.data.k r5 = r9.getContentExt();
        if (r5 == null) goto L14;
        r1 = r5.b();
    L14:
        if (r4 != null) goto L19;
        if (r1 != null) goto L17;
    L18:
        r8.a(r9);
        return;
    L17:
        if (r1.isValid() != true) goto L18;
    L19:
        if (r4 != null) goto L22;
        if (r2 == null) goto L23;
        r2.b = true;
    L23:
        if (r1 != null) goto L25;
    L28:
        if (r2 == null) goto L30;
        r2.d = true;
    L30:
        if (r2 != null) goto L32;
        return;
    L32:
        if (r2.b != true) goto L38;
        r8.a(r9);
        return;
    L38:
        return;
    L25:
        if (r1.isValid() != true) goto L28;
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r1, new w(r2, r8, r9));
        return;
    L22:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r4, new v(r2, r8, r9));
        goto L23
    L9:
        r4 = null;
        goto L10
    L5:
        r0 = r9;
        goto L6
    }
}
