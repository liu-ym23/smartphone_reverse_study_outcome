package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import com.bytedance.android.livesdk.gift.model.j0;
import com.bytedance.android.livesdk.gift.model.t2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateCurrentReceiverList;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements com.bytedance.android.scope.o, c0 {
    public static final AtomicBoolean m = null;
    public IBaseUser a;
    public ReceiverType b;
    public final Map<String, String> c;
    public List<h> d;
    public final BehaviorSubject<lc6.h> e;
    public final BehaviorSubject<lc6.e> f;
    public final x g;
    public final y h;
    public final GiftReceiverRepoService i;
    public final yz0.g j;
    public final i12.e k;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.z l;

    public static final class a {
    }

    static {
        m = new AtomicBoolean(false);
    }

    public final int f() {
        Iterator<h> r0 = this.d.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().a.getIdString(), this.a.getIdString()) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r1;
    L9:
        return -1;
    }

    public final void h() {
        if (this.h.i() == null) goto L8;
        Map<String, String> r0 = this.c;
        y r1 = this.h;
        r1.getClass();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("to_user_st", "memory");
        if (r1.g() == false) goto L7;
        r2.put("group_live_to_user_st", "memory");
    L7:
        r0.putAll(r2);
        return;
    L8:
        this.c.putAll(this.g.b);
    }

    public final void onStart() {
        this.i.F();
        IBaseUser r0 = this.h.i();
        if (r0 != null) goto L5;
        r0 = this.g.a();
    L5:
        j(r0);
        i(this.i.y(this.a));
        GiftReceiverRepoService r1 = this.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r1.e).add(this);
        BehaviorSubject<lc6.e> r2 = this.f;
        lc6.e r3 = new lc6.e();
        r3.a(this.a);
        r3.b(Integer.valueOf(this.b.getValue()));
        Unit r4 = Unit.INSTANCE;
        r2.onNext(r3);
        h();
        if (GiftReceiverRepoService.q == true) goto L9;
        return;
    L9:
        if (m.compareAndSet(false, true) == false) goto L14;
        int r5 = com.bytedance.revenue.platform.api.core.rx.q.a;
        final GiftPanelReceiverService$Companion$addStaticPublishEventJsbListener$1 r6 = GiftPanelReceiverService$Companion$addStaticPublishEventJsbListener$1.INSTANCE;
        Single r7 = Single.fromCallable(new e(r6));
        int r8 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r7.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
        return;
    }

    public final void onStop() {
        GiftReceiverRepoService r0 = this.i;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r0.e).remove(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.c0
    public final void a() {
        if (w.a() == true) goto L5;
        return;
    L5:
        List<h> r0 = CollectionsKt.toMutableList(this.i.x());
        if (d0.b(this.d, r0) == true) goto L8;
        return;
    L8:
        Iterator<h> r1 = r0.iterator();
        int r3 = 0;
    L10:
        if (r1.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r1.next().a.getIdString(), this.a.getIdString()) == true) goto L16;
        r3 = r3 + 1;
    L16:
        if (r3 != (-1)) goto L19;
        ListProtector.add(r0, 0, new h(this.a, null));
        r3 = 0;
    L19:
        if (r3 == f()) goto L27;
        h r2 = (h) ListProtector.remove(r0, r3);
        if (f() < r0.size()) goto L23;
        r0.add(r2);
        goto L27
    L23:
        if (f() != (-1)) goto L25;
        ListProtector.add(r0, 0, r2);
        goto L27
    L25:
        ListProtector.add(r0, f(), r2);
    L27:
        i(r0);
        List<h> r4 = this.d;
        Intrinsics.checkNotNullParameter(r4, "currentReceivers");
        uz1.a r5 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r5 == null) goto L33;
        r5.a(new UpdateCurrentReceiverList(r4, false));
        return;
    L33:
        return;
    L15:
        r3 = -1;
        goto L16
    }

    public final IBaseUser d() {
        return this.a;
    }

    public final ReceiverType g() {
        return this.b;
    }

    public final void i(List<h> r9) {
        boolean r0 = d0.b(this.d, r9);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.d = r9;
        jy0.b.d("GiftReceiver", "GiftPanelReceiverService updateCurrentReceiverList " + r0 + ' ' + this.d.size());
        if (r0 == false) goto L22;
        BehaviorSubject<lc6.h> r10 = this.e;
        lc6.h r1 = new lc6.h();
        List<h> r2 = this.d;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L17;
        h r5 = (h) r4.next();
        lc6.c r6 = new lc6.c();
        r6.c(com.bytedance.android.live.base.model.user.m.a(r5.a));
        IBaseUser r7 = r5.a;
        Intrinsics.checkNotNullParameter(r7, "$this$realNickNameExt");
        r6.d(r7.getRealNickName());
        py.k r8 = r5.a.getAvatarThumbKt();
        j0 r11 = null;
        if (r8 == null) goto L12;
        List r13 = r8.getUrls();
        if (r13 == null) goto L12;
        String r14 = (String) CollectionsKt.getOrNull(r13, 0);
    L13:
        r6.a(r14);
        t2 r15 = r5.b;
        if (r15 == null) goto L16;
        r11 = r15.getExtraInfo();
    L16:
        r6.b(r11);
        r3.add(r6);
    L12:
        r14 = null;
        goto L13
    L17:
        r1.b(r3);
        Unit r16 = Unit.INSTANCE;
        r10.onNext(r1);
        return;
    }

    public final void j(IBaseUser r3) {
        jy0.b.d("GiftReceiver", "GiftPanelReceiverService updateReceiverInfo " + r3.getIdString());
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a = r3;
        this.b = this.h.h(r3);
        jy0.b.d("GiftReceiver", "GiftPanelReceiverService updateReceiverType " + this.b);
        BehaviorSubject<lc6.e> r4 = this.f;
        lc6.e r0 = new lc6.e();
        r0.a(this.a);
        r0.b(Integer.valueOf(this.b.getValue()));
        r4.onNext(r0);
    }

    public final void c(IBaseUser r4, ChangeReceiverSource r5) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "changeReceiverSource");
        IBaseUser r1 = this.a;
        j(r4);
        h();
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r1, "preUser");
        uz1.a r0 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r0 == null) goto L6;
        r0.a(new ChangeReceiver(r4, r1));
    L6:
        if (r5 == ChangeReceiverSource.ReceiverPanel) goto L8;
    L12:
        this.l.vc(this.a);
        return;
    L8:
        if (w.a() == false) goto L12;
        i(this.i.y(this.a));
        List<h> r6 = this.d;
        Intrinsics.checkNotNullParameter(r6, "currentReceivers");
        uz1.a r7 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r7 == null) goto L12;
        r7.a(new UpdateCurrentReceiverList(r6, true));
        goto L12
    }

    public f(x r2, y r3, GiftReceiverRepoService r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r5, yz0.g r6, i12.e r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.z r8) {
        Intrinsics.checkNotNullParameter(r2, "recommendReceiverService");
        Intrinsics.checkNotNullParameter(r3, "selectReceiverService");
        Intrinsics.checkNotNullParameter(r4, "giftReceiverRepoService");
        Intrinsics.checkNotNullParameter(r5, "giftAllMicService");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r8, "carnivalDataStore");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r6;
        this.k = r7;
        this.l = r8;
        IBaseUser r9 = r6.getRoom().getOwnerKt();
        if (r9 != null) goto L5;
        r9 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L5:
        this.a = r9;
        this.b = ReceiverType.Anchor;
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
        int r10 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.e = BehaviorSubject.create();
        this.f = BehaviorSubject.create();
    }
}
