package com.bytedance.android.live.revlink.impl.multianchor.scope;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements o {
    public final IRoom a;
    public final i11.b b;
    public final a c;
    public final com.bytedance.android.live.revlink.impl.multianchor.scope.a d;

    public static final class a extends i11.c.a {
        public final /* synthetic */ b a;

        @Override // i11.c.a, i11.c.b
        public final void d(int r1, List<? extends p> r2) {
            Intrinsics.checkNotNullParameter(r2, "list");
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void a(int r5, List r6) {
            if (r5 == 7) goto L5;
            return;
        L5:
            if (r6 == null) goto L21;
            StringBuilder r7 = new StringBuilder("onWaitingListChanged list = ");
            CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) r6;
            r7.append(r0.size());
            String r2 = null;
            jy0.b.c("MultiLinkAnchorToolbarService", r7.toString(), null, 4);
            if (r0.size() != 1) goto L21;
            IBaseUser r8 = ((p) ListProtector.get(r6, 0)).getUser();
            if (r8 == null) goto L11;
            String r9 = iz.a.a(r8);
        L12:
            IRoom r1 = this.a.a;
            if (r1 == null) goto L18;
            IBaseUser r3 = r1.getOwner();
            if (r3 == null) goto L18;
            r2 = iz.a.a(r3);
        L18:
            if (Intrinsics.areEqual(r9, r2) == false) goto L21;
            b.a(this.a, new ArrayList());
            return;
        L11:
            r9 = null;
        L21:
            b.a(this.a, r6);
        }

        @Override // i11.c.a, i11.c.b
        public final void c(int r2, List<? extends IBaseUser> r3) {
            if (r2 == 7) goto L5;
            return;
        L5:
            b.a(this.a, r3);
        }
    }

    public final void onStart() {
        i11.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.i(this.c);
        return;
    }

    public final void onStop() {
        i11.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.l(this.c);
        return;
    }

    public b(com.bytedance.android.live.revlink.impl.multianchor.scope.a r3) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.d = r3;
        k r0 = (k) f.d(j.C0.a(), k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        this.a = r1;
        this.b = r3.getLinkUserCenter();
        this.c = new a(this);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void a(b r0, List r1) {
        r0.getClass();
        if (com.bytedance.android.live.revlink.impl.global.b.n() != null) goto L5;
        return;
    L5:
        if (y.c() == false) goto L7;
    L17:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r2 != null) goto L20;
    L21:
        com.bytedance.android.live.revlink.impl.service.internal.a r3 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r3 == null) goto L31;
        r3.onMultiAnchorStateChange(2);
        return;
    L31:
        return;
    L20:
        if (r2.getCurPKBaseState().b() == true) goto L21;
        return;
    L7:
        if (y.b() == true) goto L17;
        if (Lists.isEmpty(r1) == true) goto L14;
        com.bytedance.android.live.revlink.impl.service.internal.a r4 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r4 == null) goto L26;
        r4.onMultiAnchorStateChange(1);
        return;
    L26:
        return;
    L14:
        com.bytedance.android.live.revlink.impl.service.internal.a r5 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r5 == null) goto L28;
        r5.onMultiAnchorStateChange(0);
        return;
    }
}
