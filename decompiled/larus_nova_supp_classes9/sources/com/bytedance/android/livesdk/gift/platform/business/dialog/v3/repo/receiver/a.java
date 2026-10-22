package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.utils.LiveEmptyObserverKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeAllMic;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeMultiSendReceiver;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.scope.o, c0 {
    public static final /* synthetic */ KProperty[] h = null;
    public List<? extends IBaseUser> a;
    public final C0047a b;
    public final b c;
    public final GiftReceiverRepoService d;
    public final i12.e e;
    public final com.bytedance.kmp.livesdk.gift.platform.service.d f;
    public final yz0.g g;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a$a, reason: collision with other inner class name */
    public static final class C0047a extends ObservableProperty<Boolean> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ a b;

        public C0047a(Object r1, Object r2, a r3) {
            this.a = r1;
            this.b = r3;
            super(r2);
        }

        public final void afterChange(KProperty<?> r2, Boolean r3, Boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            boolean r5 = r4.booleanValue();
            boolean r6 = r3.booleanValue();
            if (r6 == r5) goto L6;
            jy0.b.d("GiftReceiver", "GiftAllMicService allMicSceneChange " + r6 + ' ' + r5);
            final a r7 = this.b;
            final String r8 = r7.g.getRoom().getIdStr();
            int r9 = com.bytedance.revenue.platform.api.core.rx.q.a;
            Single r10 = Single.fromCallable(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.b(new GiftAllMicService$writeToCache$1(r7, r8)));
            int r11 = com.bytedance.revenue.platform.api.core.rx.p.a;
            r10.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
            return;
        }
    }

    public static final class b extends ObservableProperty<Boolean> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ a b;

        public b(Object r1, Object r2, a r3) {
            this.a = r1;
            this.b = r3;
            super(r2);
        }

        public final void afterChange(KProperty<?> r2, Boolean r3, Boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            boolean r5 = r4.booleanValue();
            boolean r6 = r3.booleanValue();
            if (r6 == r5) goto L6;
            jy0.b.d("GiftReceiver", "GiftAllMicService isMultiUserChange " + r6 + ' ' + r5);
            final a r7 = this.b;
            final String r8 = r7.g.getRoom().getIdStr();
            int r9 = com.bytedance.revenue.platform.api.core.rx.q.a;
            Single r10 = Single.fromCallable(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.b(new GiftAllMicService$writeIsMultiUser$1(r7, r8)));
            int r11 = com.bytedance.revenue.platform.api.core.rx.p.a;
            r10.subscribeOn(Schedulers.io()).subscribe(new LiveEmptyObserverKt());
            return;
        }
    }

    static {
        h = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "allMicScene", "getAllMicScene()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "isMultiUser", "isMultiUser()Z", 0))};
    }

    public final boolean h() {
        return ((Boolean) this.b.getValue(this, h[0])).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) this.c.getValue(this, h[1])).booleanValue();
    }

    public final void f() {
        jy0.b.d("GiftReceiver", "GiftAllMicService clearAllMicState");
        this.a = CollectionsKt.emptyList();
        boolean r0 = h();
        this.b.setValue(this, h[0], Boolean.FALSE);
        boolean r1 = h();
        uz1.a r2 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r2 == null) goto L6;
        r2.a(new ChangeAllMic(r0, r1));
        return;
    }

    public final boolean g() {
        if (this.d.h(2) == true) goto L5;
        return false;
    L5:
        if (this.d.f() == false) goto L9;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.f.g.getValue(null, com.bytedance.android.livesdk.gift.platform.core.f.a[5])).booleanValue() == true) goto L9;
        return false;
    L9:
        if (this.d.h(4) == true) goto L16;
        return true;
    L16:
        return false;
    }

    public final void n() {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(f.class));
    L6:
        f r2 = (f) r1;
        if (r2 == null) goto L25;
        BehaviorSubject<lc6.h> r3 = r2.e;
        if (r3 == null) goto L26;
        lc6.h r4 = new lc6.h();
        List<? extends IBaseUser> r5 = this.a;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L12:
        if (r7.hasNext() == false) goto L20;
        IBaseUser r8 = (IBaseUser) r7.next();
        lc6.c r9 = new lc6.c();
        r9.c(r8.getIdString());
        Intrinsics.checkNotNullParameter(r8, "$this$realNickNameExt");
        r9.d(r8.getRealNickName());
        py.k r10 = r8.getAvatarThumbKt();
        if (r10 == null) goto L18;
        List r11 = r10.getUrls();
        if (r11 == null) goto L18;
        String r13 = (String) CollectionsKt.getOrNull(r11, 0);
    L19:
        r9.a(r13);
        r9.b(null);
        r6.add(r9);
    L18:
        r13 = null;
        goto L19
    L20:
        r4.b(r6);
        Unit r14 = Unit.INSTANCE;
        r3.onNext(r4);
        return;
    L26:
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onStart() {
        GiftReceiverRepoService r0 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r0.e).add(this);
        String r1 = this.g.getRoom().getIdStr();
        ay1.d.h.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = cd6.b.b;
        KProperty[] r3 = cd6.b.a;
        Boolean r4 = (Boolean) ((LruCache) r2.getValue(null, r3[0])).get(r1);
        if (r4 == null) goto L5;
        this.b.setValue(this, h[0], Boolean.valueOf(r4.booleanValue()));
    L5:
        ay1.d.i.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        Boolean r5 = (Boolean) ((LruCache) cd6.b.d.getValue(null, r3[1])).get(r1);
        if (r5 == null) goto L8;
        this.c.setValue(this, h[1], Boolean.valueOf(r5.booleanValue()));
    L8:
        boolean r6 = h();
        boolean r7 = h();
        uz1.a r8 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r8 == null) goto L11;
        r8.a(new ChangeAllMic(r6, r7));
    L11:
        jy0.b.d("GiftReceiver", "GiftAllMicService initDataFromDiskCache " + h() + ' ' + k());
    }

    public final void onStop() {
        GiftReceiverRepoService r0 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r0.e).remove(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.c0
    public final void a() {
        if (h() == false) goto L44;
        List<IBaseUser> r0 = this.d.k().a;
        List<? extends IBaseUser> r1 = this.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(((IBaseUser) r3.next()).getIdString());
        goto L6
    L8:
        List<IBaseUser> r4 = r0;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5.add(((IBaseUser) r6.next()).getIdString());
        goto L10
    L12:
        List<? extends IBaseUser> r7 = this.a;
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
        this.a = r0;
    L29:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.f.h.getValue(null, com.bytedance.android.livesdk.gift.platform.core.f.a[6])).booleanValue() == true) goto L31;
    L33:
        List<? extends IBaseUser> r9 = this.a;
        Intrinsics.checkNotNullParameter(r9, "multiReceiverList");
        uz1.a r10 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r10 == null) goto L45;
        r10.a(new ChangeMultiSendReceiver(r9));
        return;
    L45:
        return;
    L31:
        if ((!Intrinsics.areEqual(r2, r5)) == false) goto L33;
        n();
        goto L33
    L21:
        List<? extends IBaseUser> r11 = this.a;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r11.iterator();
    L23:
        if (r14.hasNext() == false) goto L27;
        Object r15 = r14.next();
        if (r5.contains(((IBaseUser) r15).getIdString()) == false) goto L23;
        r13.add(r15);
        goto L23
    L27:
        this.a = r13;
        goto L29
    L15:
        if (r7.isEmpty() == true) goto L18;
        r8 = false;
        goto L19
    }

    public final List<IBaseUser> i() {
        if (j() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.a;
    }

    public final boolean j() {
        if (g() == true) goto L7;
        return false;
    L7:
        return h();
    }

    public final void c(List<? extends IBaseUser> r6) {
        Intrinsics.checkNotNullParameter(r6, "receiverList");
        jy0.b.d("GiftReceiver", "GiftAllMicService changeMultiReceivers " + r6.size());
        List<? extends IBaseUser> r0 = this.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((IBaseUser) r2.next()).getIdString());
        goto L4
    L6:
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r4 = r6.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add(((IBaseUser) r4.next()).getIdString());
        goto L8
    L10:
        this.a = r6;
        boolean r7 = h();
        this.b.setValue(this, h[0], Boolean.TRUE);
        boolean r5 = !Intrinsics.areEqual(r1, r3);
        com.bytedance.android.scope.o r8 = null;
        if (r5 == true) goto L13;
    L15:
        i12.d r9 = i12.m.e2.a();
        if (r9 == null) goto L18;
        com.bytedance.android.scope.m.e.getClass();
        r8 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(f.class));
    L18:
        f r10 = (f) r8;
        if (r10 == null) goto L21;
        r10.j(r10.a);
    L21:
        boolean r11 = h();
        uz1.a r13 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r13 == null) goto L24;
        r13.a(new ChangeAllMic(r7, r11));
    L24:
        List<? extends IBaseUser> r14 = this.a;
        Intrinsics.checkNotNullParameter(r14, "multiReceiverList");
        uz1.a r15 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r15 == null) goto L30;
        r15.a(new ChangeMultiSendReceiver(r14));
        return;
    L30:
        return;
    L13:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.f.i.getValue(null, com.bytedance.android.livesdk.gift.platform.core.f.a[7])).booleanValue() == false) goto L15;
        n();
        goto L15
    }

    public final void d(List<String> r15) {
        Intrinsics.checkNotNullParameter(r15, "userIds");
        List<IBaseUser> r0 = this.d.k().a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (r15.contains(((IBaseUser) r3).getIdString()) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        com.bytedance.android.scope.o r4 = null;
        if ((!r1.isEmpty()) == false) goto L11;
        List<? extends IBaseUser> r13 = r1;
    L12:
        if (r13 == null) goto L33;
        boolean r5 = j();
        i12.d r16 = i12.m.e2.a();
        if (r16 == null) goto L16;
        com.bytedance.android.scope.m.e.getClass();
        r4 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(f.class));
    L16:
        f r6 = (f) r4;
        if (r6 == null) goto L22;
        IBaseUser r17 = r6.a;
        if (r17 == null) goto L22;
        String r18 = r17.getIdString();
        if (r18 == null) goto L22;
    L23:
        String r7 = r18;
        c(r13);
        GiftReceiverRepoService r19 = this.d;
        IBaseUser r8 = this.g.getRoom().getOwnerKt();
        if (r8 != null) goto L26;
        r8 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L26:
        ReceiverType r10 = ReceiverType.AllMic;
        r19.X(r8, r10);
        zc6.a r110 = zc6.a.a;
        i12.e r111 = this.e;
        int r9 = x12.c.a(r111);
        Intrinsics.checkNotNullParameter(zc6.a.a, "$this$changeMode2String");
        Intrinsics.checkNotNullParameter(r111, "scope");
        this.f.a(r7, ((IBaseUser) ListProtector.get(r13, 0)).getIdString(), r5, r1.size(), com.bytedance.android.livesdk.gift.platform.core.utils.x.a(), vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r9), this.d.k().a, r10, !r5, ChangeReceiverSource.ReceiverPanel, r13);
        return;
    L22:
        r18 = BuildConfig.FLAVOR;
        goto L23
    L33:
        return;
    L11:
        r13 = null;
        goto L12
    }

    public a(GiftReceiverRepoService r2, i12.e r3, com.bytedance.kmp.livesdk.gift.platform.service.d r4, yz0.g r5) {
        Intrinsics.checkNotNullParameter(r2, "giftReceiverRepoService");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "logService");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = CollectionsKt.emptyList();
        Delegates r6 = Delegates.INSTANCE;
        Boolean r7 = Boolean.FALSE;
        this.b = new C0047a(r7, r7, this);
        this.c = new b(r7, r7, this);
    }
}
