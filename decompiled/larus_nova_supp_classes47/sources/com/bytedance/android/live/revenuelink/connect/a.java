package com.bytedance.android.live.revenuelink.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revenuelink.withroom.LinkStoreService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements g {
    public final com.bytedance.android.live.revenuelink.withroom.a a;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.connect.a$a, reason: collision with other inner class name */
    public static final class C0111a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final LiveData<ey.f> connectState() {
        com.bytedance.android.live.revenuelink.withroom.a r0 = this.a;
        if (r0 == null) goto L7;
        f r1 = r0.Z0();
        if (r1 == null) goto L7;
        return r1.connectState();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final int s1() {
        com.bytedance.android.live.revenuelink.withroom.a r0 = this.a;
        if (r0 == null) goto L11;
        f r1 = r0.Z0();
        if (r1 == null) goto L11;
        LiveData<ey.f> r2 = r1.connectState();
        if (r2 == null) goto L11;
        ey.f r3 = (ey.f) r2.getValue();
        if (r3 == null) goto L11;
        return r3.d;
    L11:
        return 0;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final long getChannelId() {
        LiveData<ey.f> r0 = connectState();
        if (r0 == null) goto L7;
        ey.f r1 = (ey.f) r0.getValue();
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final String getLinkMicId() {
        LiveData<ey.f> r0 = connectState();
        if (r0 == null) goto L8;
        ey.f r1 = (ey.f) r0.getValue();
        if (r1 == null) goto L8;
        String r2 = r1.e;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean t1() {
        LiveData<ey.f> r0 = connectState();
        if (r0 == null) goto L9;
        ey.f r1 = (ey.f) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.d != 4) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean u1() {
        LiveData<ey.f> r0 = connectState();
        if (r0 == null) goto L10;
        ey.f r1 = (ey.f) r0.getValue();
        if (r1 == null) goto L10;
        if (r1.d != 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean v1() {
        LiveData<ey.f> r0 = connectState();
        if (r0 == null) goto L21;
        ey.f r1 = (ey.f) r0.getValue();
        if (r1 == null) goto L22;
        Intrinsics.checkNotNullParameter(r1, "$this$isClassicDouble");
        int r2 = r1.c;
        if (r2 == 2) goto L11;
        if (r2 == 1) goto L11;
        boolean r3 = false;
    L12:
        if (r3 != true) goto L23;
        LiveData<ey.f> r4 = connectState();
        if (r4 == null) goto L19;
        ey.f r5 = (ey.f) r4.getValue();
        if (r5 == null) goto L19;
        if (r5.d != 0) goto L19;
        return false;
    L19:
        return true;
    L23:
        return false;
    L11:
        r3 = true;
        goto L12
    L22:
        return false;
    L21:
        return false;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean w1() {
        LiveData<ey.f> r0 = connectState();
        if (r0 == null) goto L22;
        ey.f r1 = (ey.f) r0.getValue();
        if (r1 == null) goto L23;
        Intrinsics.checkNotNullParameter(r1, "$this$isClassicMulti");
        int r2 = r1.c;
        if (r2 != 0) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 != true) goto L24;
        LiveData<ey.f> r4 = connectState();
        if (r4 == null) goto L20;
        ey.f r5 = (ey.f) r4.getValue();
        if (r5 == null) goto L20;
        if (r5.d != 0) goto L20;
        return false;
    L20:
        return true;
    L24:
        return false;
    L9:
        if (r2 == 3) goto L12;
        r3 = false;
        goto L13
    L23:
        return false;
    L22:
        return false;
    }

    public a(LinkStoreService r1) {
        this.a = r1;
    }
}
