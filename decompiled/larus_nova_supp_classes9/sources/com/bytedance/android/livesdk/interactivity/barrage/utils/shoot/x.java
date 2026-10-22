package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x extends r22.a<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
    public final Deque<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> c;
    public boolean d;
    public boolean e;
    public final r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> f;

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
        return this.f;
    }

    @Override // r22.a
    public final Queue<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> h() {
        return this.c;
    }

    public x(LandscapeDanmakuPresenterV2.p r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.f = r2;
        this.c = new LinkedList();
    }

    @Override // r22.a
    public final void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "danmaku");
        if (((LinkedList) this.c).size() < 20) goto L5;
        ((LinkedList) this.c).removeFirst();
    L5:
        ((LinkedList) this.c).add(r4);
        k();
    }

    @Override // r22.a
    public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r5, r22.a.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r6) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r7 = r5;
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r6, "notifier");
        IBaseUser r0 = r7.getUserInfo();
        String r1 = null;
        if (r0 == null) goto L5;
        py.k r2 = r0.getAvatarThumbKt();
    L6:
        if (r2 != null) goto L8;
        r6.a(r7);
        return;
    L8:
        IBaseUser r3 = r7.getUserInfo();
        if (r3 == null) goto L14;
        py.c r4 = r3.getMAuthenticationInfo();
        if (r4 == null) goto L14;
        r1 = r4.getCustomVerify();
    L14:
        if (TextUtils.isEmpty(r1) == true) goto L22;
        IBaseUser r8 = r7.getUserInfo();
        if (r8 == null) goto L23;
        py.c r9 = r8.getMAuthenticationInfo();
        if (r9 == null) goto L23;
        py.k r10 = r9.getAuthenticationBadge();
        if (r10 == null) goto L23;
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r10, new y(this, r7, r6));
    L23:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r2, new z(this, r7, r6));
        return;
    L22:
        this.e = true;
        goto L23
    L5:
        r2 = null;
        goto L6
    }
}
