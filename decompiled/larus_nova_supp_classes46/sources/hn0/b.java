package hn0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.multilink.impl.control.MultiControlContext;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import dn0.c;
import gd0.j;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements o, jn0.b {
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> a;
    public final BehaviorSubject<Integer> b;
    public final BehaviorSubject<Boolean> c;
    public final bn0.b d;
    public final g e;
    public final cg6.a f;
    public final tc0.b g;
    public final c h;
    public final jb6.a i;
    public final j j;

    public static final class a {
    }

    static {
    }

    @Override // jn0.b
    public final String Ya() {
        return "01-21: in roomID[" + this.e.getRoom().getIdStr() + ']';
    }

    public final void onStart() {
        jy0.b.c("MLR_ScopeService", hashCode() + "#onStart: ", null, 4);
        Intrinsics.checkNotNullParameter(this, "inRoomService");
        IMultiLinkInternalService r0 = (IMultiLinkInternalService) k.f(IMultiLinkInternalService.class);
        if (r0 == null) goto L6;
        r0.registerInRoomService(this);
        return;
    }

    public final void onStop() {
        IMultiLinkInternalService r0 = (IMultiLinkInternalService) k.f(IMultiLinkInternalService.class);
        if (r0 == null) goto L5;
        r0.unregisterInRoomService();
    L5:
        jy0.b.c("MLR_ScopeService", hashCode() + "#onStop: ", null, 4);
    }

    @Override // jn0.b
    public final cg6.a Pl() {
        return this.f;
    }

    @Override // jn0.b
    public final BehaviorSubject<List<ILinkPlayerInfoBridge>> Xh() {
        return this.a;
    }

    @Override // jn0.b
    public final BehaviorSubject<Integer> b5() {
        return this.b;
    }

    @Override // jn0.b
    public final BehaviorSubject<Boolean> dk() {
        return this.c;
    }

    @Override // jn0.b
    public final tc0.b getLinkInRoomDataHolderKt() {
        return this.g;
    }

    @Override // jn0.b
    public final c getLinkSecurityService() {
        return this.h;
    }

    @Override // jn0.b
    public final jb6.a getLinkServiceScopeService() {
        return this.i;
    }

    @Override // jn0.b
    public final DataContext Jn(DataContext r5) {
        Intrinsics.checkNotNullParameter(MultiControlContext.TAG, "key");
        Intrinsics.checkNotNullParameter(r5, "dataContext");
        com.bytedance.live.datacontext.b.a(r5, "MultiControlContext_" + IRoomKtKt.getId(this.e.getRoom()));
        return r5;
    }

    public b(bn0.b r2, g r3, cg6.a r4, tc0.b r5, c r6, jb6.a r7, j r8) {
        Intrinsics.checkNotNullParameter(r2, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "multiLinkComponentService");
        Intrinsics.checkNotNullParameter(r5, "linkInRoomDataHolderKt");
        Intrinsics.checkNotNullParameter(r6, "linkSecurityService");
        Intrinsics.checkNotNullParameter(r7, "linkServiceScopeService");
        Intrinsics.checkNotNullParameter(r8, "interactService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        int r9 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.a = BehaviorSubject.create();
        this.b = BehaviorSubject.create();
        this.c = BehaviorSubject.create();
    }
}
