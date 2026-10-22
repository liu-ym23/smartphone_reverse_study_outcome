package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import com.bytedance.android.livesdk.gift.platform.business.toolbar.ToolbarGiftBehavior;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftScopeProviderService implements com.bytedance.android.scope.o, yz0.m {
    public Disposable a;
    public final y2 b;
    public final yz0.k c;
    public final com.bytedance.android.livesdk.revenue.service.room.c d;

    public static final class a extends DataContext implements i12.n {
        private final i12.e inst;

        @Override // i12.n
        public i12.e getInst() {
            return this.inst;
        }

        public a(i12.e r2) {
            Intrinsics.checkNotNullParameter(r2, "inst");
            this.inst = r2;
        }

        public final void shareAsCurrent(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            int r0 = com.bytedance.live.datacontext.d.a;
            Intrinsics.checkNotNullParameter(this, "self");
            com.bytedance.live.datacontext.b.a(this, r2);
        }
    }

    public final void onStart() {
    }

    public final void onWidgetLoaded() {
    }

    public final void x() {
    }

    public final void i() {
        final i12.r r0 = new i12.r(this.b.getScope());
        Intrinsics.checkNotNullParameter(r0, "scope");
        Context r1 = this.c.getContext();
        Intrinsics.checkNotNullParameter(r1, "value");
        r0.e = r1;
        DataCenter r2 = this.c.getDataCenter();
        Intrinsics.checkNotNullParameter(r2, "value");
        r0.f = r2;
        com.bytedance.android.livesdk.revenue.room.a r3 = this.d.getRoomContext();
        Intrinsics.checkNotNullParameter(r3, "value");
        r0.g = r3;
        r0.h = Boolean.valueOf(this.b.getScope() instanceof cy0.f);
        i12.g.a r4 = i12.g.a;
        Intrinsics.checkNotNullParameter(r4, "value");
        r0.i = r4;
        Object r5 = e33.k.a;
        if (r0.e != r5) goto L6;
        String r6 = "context";
    L17:
        if (r6 != null) goto L25;
        Pair r7 = com.bytedance.live.datacontext.d.a(new GiftScopeProviderService$onRoomReady$1(r0));
        a r8 = (a) r7.component1();
        this.a = (Disposable) r7.component2();
        if ((this.b.getScope() instanceof ur.a) == false) goto L21;
        Object r9 = i12.l.class;
    L22:
        r8.shareAsCurrent(r9);
        com.bytedance.android.scope.l.a(r0);
        return;
    L21:
        r9 = i12.n.class;
        goto L22
    L25:
        throw new UninitializedPropertyAccessException(r6);
    L6:
        if (r0.f != r5) goto L9;
        r6 = "dataCenter";
        goto L17
    L9:
        if (r0.g != r5) goto L12;
        r6 = "roomContext";
        goto L17
    L12:
        if (r0.h != r5) goto L14;
        r6 = "isInLive";
        goto L17
    L14:
        if (r4 != r5) goto L16;
        r6 = "roomInstance";
        goto L17
    L16:
        r6 = null;
        goto L17
    }

    public final void onStop() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onViewReady() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, ToolbarGiftBehavior.class);
    L6:
        ToolbarGiftBehavior r2 = (ToolbarGiftBehavior) r1;
        if (r2 != null) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.c() == true) goto L13;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(r2.j).e(RevToolbarButton.Gift, r2);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public GiftScopeProviderService(y2 r2, yz0.k r3, com.bytedance.android.livesdk.revenue.service.room.c r4) {
        Intrinsics.checkNotNullParameter(r2, "parentScopeProvider");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
