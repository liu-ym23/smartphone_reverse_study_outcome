package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeCurrentReceiverMode;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements com.bytedance.android.scope.o, c0 {
    public static final /* synthetic */ KProperty[] j = null;
    public final a a;
    public final BehaviorSubject<Integer> b;
    public long c;
    public Boolean d;
    public final GiftReceiverRepoService e;
    public final i12.e f;
    public final yz0.g g;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a h;
    public final i0 i;

    public static final class a extends ObservableProperty<Integer> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ k b;

        public a(Object r1, Object r2, k r3) {
            this.a = r1;
            this.b = r3;
            super(r2);
        }

        public final void afterChange(KProperty<?> r2, Integer r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            int r5 = r4.intValue();
            int r6 = r3.intValue();
            if (r6 == r5) goto L20;
            jy0.b.d("GiftReceiver", "GiftReceiverModeService currentModeChange " + r6 + " -> " + r5);
            if (r5 != 0) goto L17;
            i12.d r7 = i12.m.e2.a();
            if (r7 == null) goto L9;
            com.bytedance.android.scope.m.e.getClass();
            com.bytedance.android.scope.o r8 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(f.class));
        L10:
            f r9 = (f) r8;
            if (r9 == null) goto L17;
            IBaseUser r10 = this.b.g.getRoom().getOwnerKt();
            if (r10 != null) goto L15;
            r10 = (IBaseUser) vh7.f.c(IBaseUser.class);
        L15:
            r9.c(r10, ChangeReceiverSource.Other);
            goto L17
        L9:
            r8 = null;
        L17:
            if (r5 == 2) goto L21;
            this.b.h.f();
            return;
        L21:
            return;
        }
    }

    static {
        j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(k.class, "currentMode", "getCurrentMode()I", 0))};
    }

    public final int c() {
        return ((Number) this.a.getValue(this, j[0])).intValue();
    }

    public final int d() {
        int r1 = 2;
        if (this.e.h(2) == true) goto L7;
        r1 = 0;
    L7:
        if (this.e.h(4) == false) goto L10;
        r1 = r1 + 4;
    L10:
        if (this.e.h(8) == false) goto L13;
        r1 = r1 + 8;
    L13:
        if (this.e.h(1024) == false) goto L15;
        r1 = r1 + 1024;
    L15:
        if (r1 != 0) goto L22;
        ReceiverType r0 = this.i.a();
        if (r0 != null) goto L20;
        r0 = ReceiverType.Anchor;
    L20:
        if (r0 != ReceiverType.Audience) goto L22;
        r1 = r1 + 1024;
    L22:
        jy0.b.d("GiftReceiver", "GiftReceiverModeService getCurrentModeForViewModel " + r1);
        return r1;
    }

    public final void onStart() {
        GiftReceiverRepoService r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r0.e).add(this);
    }

    public final void onStop() {
        GiftReceiverRepoService r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r0.e).remove(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.c0
    public final void a() {
        f();
        int r0 = c();
        int r1 = d();
        this.a.setValue(this, j[0], Integer.valueOf(r1));
        if (r0 == c()) goto L6;
        this.b.onNext(Integer.valueOf(c()));
        return;
    }

    public final void f() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.b0.b() == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        boolean r1 = g();
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.d().o5() == true) goto L10;
    L15:
        com.bytedance.live.kmp.util.c r2 = com.bytedance.live.kmp.util.c.a;
        this.c = System.currentTimeMillis();
        this.d = Boolean.valueOf(r1);
        uz1.a r3 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r3 == null) goto L20;
        r3.a(new ChangeCurrentReceiverMode(r1));
        return;
    L20:
        return;
    L10:
        if (Intrinsics.areEqual(this.d, Boolean.valueOf(r1)) == false) goto L15;
        com.bytedance.live.kmp.util.c r4 = com.bytedance.live.kmp.util.c.a;
        if ((System.currentTimeMillis() - this.c) >= IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) goto L15;
        jy0.b.f("ttlive_gift_panel", "intercept send ChangeCurrentReceiverMode", null, 4);
        return;
    L19:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean g() {
        int r0 = d();
        if (d0.a(r0, 2) == false) goto L5;
    L12:
        boolean r1 = true;
    L13:
        jy0.b.d("GiftReceiver", "GiftReceiverModeService shouldShowGuestListPanel " + r1);
        return r1;
    L5:
        if (d0.a(r0, 4) == true) goto L12;
        if (d0.a(r0, 1024) == true) goto L12;
        if (d0.a(r0, 8) == true) goto L12;
        r1 = false;
        goto L13
    }

    public k(GiftReceiverRepoService r2, i12.e r3, yz0.g r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r5, i0 r6) {
        Intrinsics.checkNotNullParameter(r2, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "allMicService");
        Intrinsics.checkNotNullParameter(r6, "receiverService");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        Delegates r7 = Delegates.INSTANCE;
        this.a = new a(0, 0, this);
        int r8 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.b = BehaviorSubject.createDefault(0);
    }
}
