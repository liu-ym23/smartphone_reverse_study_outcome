package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public int a;
    public final Set<String> b;
    public int c;
    public final com.bytedance.android.live.revlink.impl.global.c d;
    public final h e;
    public final long f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final String j;
    public final boolean k;

    public final String toString() {
        return "ConnectProcess{role=" + this.e.a + ", fromSingle=" + this.h + ", oppoSingle=" + this.i + ", waitFrame=" + this.c + ", expectFrames=" + this.b + ", connectID=" + this.g + "}";
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "frame");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L5;
        LinkCrossRoomDataHolder r2 = r0.getLinkCrossRoomDataHolder();
    L6:
        if (r2 == null) goto L9;
        r1 = r2.e();
    L9:
        if (Intrinsics.areEqual(r3, r1) == false) goto L11;
        return;
    L11:
        this.b.add(r3);
        this.c = this.b.size();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b(List<? extends com.bytedance.android.livesdk.link.model.p> r5) {
        if (r5 == null) goto L22;
        Iterator<T> r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L22;
        com.bytedance.android.livesdk.link.model.p r0 = (com.bytedance.android.livesdk.link.model.p) r6.next();
        IBaseUser r1 = r0.getUser();
        String r2 = null;
        if (r1 == null) goto L9;
        String r3 = r1.getIdString();
    L10:
        com.bytedance.android.live.revlink.impl.global.c r4 = this.d;
        if (r4 == null) goto L13;
        com.bytedance.android.live.revlink.impl.utils.s r7 = r4.getRevLinkCommonUtil();
    L14:
        if (r7 == null) goto L17;
        r2 = r7.e();
    L17:
        if (Intrinsics.areEqual(r3, r2) == true) goto L5;
        String r8 = r0.getInteractId();
        if (r8 == null) goto L5;
        this.b.add(r8);
        goto L5
    L13:
        r7 = null;
        goto L14
    L9:
        r3 = null;
    L22:
        this.b.remove("");
        this.c = this.b.size();
    }

    public /* synthetic */ g(com.bytedance.android.live.revlink.impl.global.c r12, h r13, long r14, String r15, boolean r16, boolean r17, String r18) {
        this(r12, r13, r14, r15, r16, r17, r18, false);
    }

    public g(com.bytedance.android.live.revlink.impl.global.c r2, h r3, long r4, String r6, boolean r7, boolean r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r3, "role");
        Intrinsics.checkNotNullParameter(r6, "connectID");
        Intrinsics.checkNotNullParameter(r9, "bindID");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.b = new LinkedHashSet();
    }
}
