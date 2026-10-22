package iy;

import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.anchormodelink.livelink.LiveLinkWrapper;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.o;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements o, f {
    public com.bytedance.android.live.anchormodelink.handlers.g a;
    public final List<e> b;
    public long c;
    public com.bytedance.android.live.anchormodelink.handlers.d d;
    public final yz0.g e;

    public static final class a {
    }

    static {
    }

    @Override // iy.f
    public final my.a getLinkMicInfo() {
        com.bytedance.android.live.anchormodelink.handlers.g r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final void onStart() {
        this.c = IRoomKtKt.getId(this.e.getRoom());
        jy0.b.d("DynamicCenterScopeService", "[DynamicCenterScopeService] roomID[" + this.c + "] #onStart ");
    }

    public final void onStop() {
        List<e> r0 = this.b;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((e) r1.next()).onStop();
    L8:
        jy0.b.d("DynamicCenterScopeService", "[DynamicCenterScopeService] roomID[" + this.c + "] #onStop");
    }

    @Override // iy.f
    public final boolean ye() {
        com.bytedance.android.live.anchormodelink.handlers.g r0 = this.a;
        if (r0 == null) goto L13;
        LiveLinkWrapper r1 = r0.a;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r1.g().e != true) goto L9;
        r2 = true;
        goto L10
    L13:
        return false;
    }

    public c(yz0.g r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.e = r2;
        this.b = new ArrayList();
    }

    @Override // iy.f
    public final JsonObject C(my.b r4) {
        Intrinsics.checkNotNullParameter(r4, "getStatusData");
        List<e> r0 = this.b;
        if (r0 == null) goto L11;
        Iterator r1 = ((ArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        e r2 = (e) r1.next();
        if (r2.c(r4.getType()) == false) goto L6;
        return r2.C(r4);
    L16:
        return null;
    L11:
        return null;
    }

    @Override // iy.f
    public final void j7(AnchorModeLinkDynamicWidget.f r4) {
        Intrinsics.checkNotNullParameter(r4, "provider");
        com.bytedance.android.live.anchormodelink.handlers.g r0 = new com.bytedance.android.live.anchormodelink.handlers.g(r4);
        this.a = r0;
        List<e> r1 = this.b;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        ((ArrayList) r1).add(r0);
    L5:
        com.bytedance.android.live.anchormodelink.handlers.d r2 = r4.c();
        if (r2 == null) goto L10;
        jy0.b.d("DynamicCenterScopeService", "onBizStart seiHandler:" + r2);
        this.d = r2;
        r2.j = r4;
        List<e> r3 = this.b;
        if (r3 == null) goto L10;
        ((ArrayList) r3).add(r2);
    L10:
        com.bytedance.android.live.anchormodelink.handlers.a r5 = r4.b();
        if (r5 == null) goto L15;
        List<e> r6 = this.b;
        if (r6 == null) goto L15;
        ((ArrayList) r6).add(r5);
    L15:
        com.bytedance.android.live.anchormodelink.handlers.c r7 = new com.bytedance.android.live.anchormodelink.handlers.c(r4);
        List<e> r8 = this.b;
        if (r8 == null) goto L18;
        ((ArrayList) r8).add(r7);
    L18:
        List<e> r9 = this.b;
        if (r9 == null) goto L24;
        Iterator r11 = ((ArrayList) r9).iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        ((e) r11.next()).onStart();
        goto L22
    L26:
        return;
    }

    @Override // iy.f
    public final void I5(String r1, my.e r2) {
        Intrinsics.checkNotNullParameter(r1, "sei");
        com.bytedance.android.live.anchormodelink.handlers.d r3 = this.d;
        if (r3 == null) goto L6;
        r3.j(r1);
        return;
    }

    @Override // iy.f
    public final void P0(my.c r3, k r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "updateStatus");
        Intrinsics.checkNotNullParameter(r4, "updateCallback");
        List<e> r6 = this.b;
        if (r6 == null) goto L10;
        Iterator r7 = ((ArrayList) r6).iterator();
    L6:
        if (r7.hasNext() == false) goto L16;
        e r0 = (e) r7.next();
        if (r0.a(r3.getType()) == false) goto L6;
        r0.b(r3, r4);
        goto L6
    L16:
        return;
    }
}
