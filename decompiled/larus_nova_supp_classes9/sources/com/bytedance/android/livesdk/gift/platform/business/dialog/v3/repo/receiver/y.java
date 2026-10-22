package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y implements com.bytedance.android.scope.o {
    public static final /* synthetic */ int h = 0;
    public String a;
    public IBaseUser b;
    public final com.bytedance.android.scope.j c;
    public final yz0.g d;
    public final GiftReceiverRepoService e;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a f;
    public final com.bytedance.kmp.livesdk.gift.platform.service.d g;

    public static final class a {
    }

    static {
    }

    public final void onStop() {
    }

    public final IBaseUser f() {
        IBaseUser r0 = this.d.getRoom().getOwnerKt();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return vh7.f.c(IBaseUser.class);
    }

    public final boolean g() {
        return x12.a.b(this.d.getRoom());
    }

    public final IBaseUser i() {
        String r0 = this.a;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r0, f().getIdString()) == true) goto L7;
        IBaseUser r2 = this.b;
        if (r2 == null) goto L11;
        String r3 = r2.getIdString();
    L13:
        if (Intrinsics.areEqual(r0, r3) == true) goto L15;
        Iterator<T> r4 = this.e.k().a.iterator();
    L18:
        if (r4.hasNext() == false) goto L23;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((IBaseUser) r5).getIdString(), r0) == false) goto L18;
        r1 = r5;
    L23:
        return (IBaseUser) r1;
    L15:
        return this.b;
    L11:
        r3 = null;
        goto L13
    L7:
        return f();
    }

    public final void onStart() {
        if (g() == false) goto L8;
        String r0 = f().getIdString();
        ay1.d.k.getClass();
        Intrinsics.checkNotNullParameter(r0, "key");
        String r1 = (String) ((LruCache) cd6.b.h.getValue(null, cd6.b.a[3])).get(r0);
        if (r1 == null) goto L7;
        this.a = r1;
    L7:
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService initFromDiskCache isGroupLive = true, " + r0 + ' ' + this.a);
        return;
    L8:
        String r2 = this.d.getRoom().getIdStr();
        ay1.d.j.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        String r3 = (String) ((LruCache) cd6.b.f.getValue(null, cd6.b.a[2])).get(r2);
        if (r3 != null) goto L11;
    L14:
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService initFromDiskCache isGroupLive = false, " + r2 + ' ' + this.a);
        return;
    L11:
        if (Intrinsics.areEqual(f().getIdString(), r3) == false) goto L13;
        this.a = f().getIdString();
    L13:
        this.a = r3;
        goto L14
    }

    public final ReceiverType h(IBaseUser r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        if (this.e.h(8) == false) goto L9;
        if (Intrinsics.areEqual(r4.getIdString(), f().getIdString()) == false) goto L7;
        ReceiverType r0 = ReceiverType.Anchor;
    L27:
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService judgeReceiverType " + r4.getIdString() + ", " + r0);
        return r0;
    L7:
        r0 = ReceiverType.GroupLive;
        goto L27
    L9:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.e() == false) goto L12;
        r0 = ReceiverType.Anchor;
        goto L27
    L12:
        if (this.f.j() == false) goto L15;
        r0 = ReceiverType.AllMic;
        goto L27
    L15:
        if (Intrinsics.areEqual(r4.getIdString(), f().getIdString()) == false) goto L18;
        r0 = ReceiverType.Anchor;
        goto L27
    L18:
        if (this.e.K(r4, 4) == false) goto L21;
        r0 = ReceiverType.OtherAnchor;
        goto L27
    L21:
        if (this.e.K(r4, 2) == false) goto L24;
        r0 = ReceiverType.Guest;
        goto L27
    L24:
        if (this.e.K(r4, 1024) == false) goto L26;
        r0 = ReceiverType.Audience;
        goto L27
    L26:
        r0 = ReceiverType.Audience;
        goto L27
    }

    public static /* synthetic */ void d(y r1, IBaseUser r2) {
        r1.c(r2, ChangeReceiverSource.Other);
    }

    public final void a(String r15, ChangeReceiverSource r16) {
        Intrinsics.checkNotNullParameter(r15, "userId");
        Intrinsics.checkNotNullParameter(r16, "source");
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService changeReceiverWithSyncList " + r15);
        if (this.e.L(r15) == false) goto L5;
    L6:
        GiftReceiverRepoService r3 = this.e;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r15, "userId");
        Iterator<IBaseUser> r2 = r3.k().a.iterator();
    L7:
        com.bytedance.android.scope.o r5 = null;
        if (r2.hasNext() == false) goto L13;
        IBaseUser r4 = r2.next();
        if (r4.getIdString().equals(r15) == false) goto L7;
    L16:
        if (r4 == null) goto L37;
        i12.d r1 = i12.m.e2.a();
        if (r1 == null) goto L20;
        com.bytedance.android.scope.m.e.getClass();
        r5 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r1).a(Reflection.getOrCreateKotlinClass(f.class));
    L20:
        f r6 = (f) r5;
        if (r6 == null) goto L26;
        IBaseUser r7 = r6.a;
        if (r7 == null) goto L26;
        String r8 = r7.getIdString();
        if (r8 == null) goto L26;
    L27:
        String r9 = r8;
        boolean r10 = this.f.j();
        c(r4, r16);
        GiftReceiverRepoService r11 = this.e;
        r11.X(r4, r11.R(r4));
        zc6.a r13 = zc6.a.a;
        com.bytedance.android.scope.j r14 = this.c;
        int r17 = x12.c.a(r14);
        Intrinsics.checkNotNullParameter(zc6.a.a, "$this$changeMode2String");
        Intrinsics.checkNotNullParameter(r14, "scope");
        String r18 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r17);
        com.bytedance.kmp.livesdk.gift.platform.service.d r19 = this.g;
        String r20 = r4.getIdString();
        int r21 = this.e.k().a.size();
        IRoom r23 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        List<IBaseUser> r24 = this.e.k().a;
        ReceiverType r110 = this.e.R(r4);
        boolean r111 = true;
        if (r10 == true) goto L31;
        r111 = !Intrinsics.areEqual(r9, r4.getIdString());
    L31:
        r19.a(r9, r20, r10, r21, r23, r18, r24, r110, r111, r16, null);
        return;
    L26:
        r8 = BuildConfig.FLAVOR;
        goto L27
    L37:
        return;
    L13:
        if (r15.equals(r3.j().getIdString()) == false) goto L15;
        r4 = r3.j();
        goto L16
    L15:
        r4 = null;
        goto L16
    L5:
        if (r15.equals(f().getIdString()) == true) goto L6;
    }

    public final void c(IBaseUser r4, ChangeReceiverSource r5) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r5, "changeSource");
        jy0.b.d("GiftReceiver", "GiftSelectReceiverService changeSelectReceiver " + r4.getIdString());
        this.a = r4.getIdString();
        this.f.f();
        com.bytedance.android.scope.o r2 = null;
        if (this.e.R(r4) != ReceiverType.Audience) goto L5;
    L8:
        this.b = r4;
    L9:
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L12;
        com.bytedance.android.scope.m.e.getClass();
        r2 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(f.class));
    L12:
        f r3 = (f) r2;
        if (r3 == null) goto L15;
        r3.c(r4, r5);
    L15:
        final String r6 = this.d.getRoom().getIdStr();
        IRoom r7 = this.d.getRoom();
        if (r7 == null) goto L19;
        final String r8 = IRoomKt_androidKt.getAnchorId(r7);
        if (r8 == null) goto L19;
    L20:
        final String r1 = this.a;
        if (r1 == null) goto L24;
        int r9 = com.bytedance.revenue.platform.api.core.rx.q.a;
        final Function0<Unit> r10 = new GiftSelectReceiverService$writeToCache$$inlined$let$lambda$1(r1, this, r6, r8);
        Single r11 = Single.fromCallable(new z(r10));
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r11.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
        return;
    L24:
        return;
    L19:
        r8 = BuildConfig.FLAVOR;
        goto L20
    L5:
        if (this.e.J(r4.getIdString()) == true) goto L8;
        this.b = null;
        goto L9
    }

    public y(com.bytedance.android.scope.j r2, yz0.g r3, GiftReceiverRepoService r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r5, com.bytedance.kmp.livesdk.gift.platform.service.d r6) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "giftReceiverRepoService");
        Intrinsics.checkNotNullParameter(r5, "allMicService");
        Intrinsics.checkNotNullParameter(r6, "logService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
    }
}
