package com.bytedance.android.live.liveinteract.plantform.datamerge;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.q;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.r;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.t;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.u;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends com.bytedance.android.live.liveinteract.plantform.datamergev2.a {
    public t f;
    public r g;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> h;
    public eg6.b i;
    public final DataCenter j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void O1() {
        if (this.a == false) goto L6;
        ALogger.i("LinkRoomFightDataMergeCenter", "LinkRoomFightDataMergeCenter=" + hashCode() + ", isInitDefaultHandler=" + this.a);
        return;
    L6:
        this.a = true;
        ArrayList r0 = new ArrayList();
        t r1 = new t(this.i);
        this.f = r1;
        Intrinsics.checkNotNullParameter(this, "proxy");
        r1.a = this;
        r0.add(r1);
        r r2 = new r(this.j, this.i);
        this.g = r2;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r2.a = this;
        r0.add(r2);
        u r3 = new u(this.j);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r3.a = this;
        r0.add(r3);
        this.b.addAllAbsent(r0);
        CopyOnWriteArrayList<eh0.c> r4 = this.b;
        q r5 = new q(r0, this.h);
        Intrinsics.checkNotNullParameter(this, "proxy");
        r5.a = this;
        r4.add(r5);
        Iterator<eh0.c> r6 = this.b.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r6.next().attach();
        goto L8
    }

    @Override // eh0.b
    public final void e() {
        this.h.c().clear();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.b
    public final void N1(hg6.g r4) {
        this.i = r4;
        r r0 = this.g;
        if (r0 == null) goto L11;
        eg6.b r1 = r0.i;
        if (r1 == null) goto L7;
        r1.s(r0.g);
    L7:
        r0.i = r4;
        if (r0.f == false) goto L11;
        if (r4 == null) goto L11;
        r4.h0(r0.g);
    L11:
        t r2 = this.f;
        if (r2 == null) goto L21;
        eg6.b r3 = r2.f;
        if (r3 == null) goto L16;
        r3.s(r2.e);
    L16:
        r2.f = r4;
        if (r2.d == false) goto L22;
        if (r4 == null) goto L23;
        r4.h0(r2.e);
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // eh0.b
    public final void t0(SeiAppData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        t r0 = this.f;
        if (r0 == null) goto L8;
        r0.d(r2);
        return;
    }

    public h(LifecycleOwner r2, com.bytedance.android.live.liveinteract.plantform.base.i r3, eg6.b r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r3, "linkUserCenter");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        super(r2, null);
        this.h = r3;
        this.i = r4;
        this.j = r5;
    }
}
