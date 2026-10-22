package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.message.model.DisplayPosition;
import com.bytedance.android.livesdk.message.model.a7;
import com.bytedance.android.livesdk.message.model.q6;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CarnivalMessageService implements q2 {
    public final CompositeDisposable a;
    public final Map<String, q6> b;
    public final Map<String, com.bytedance.android.livesdk.gift.model.x1> c;
    public final Map<String, a7> d;
    public final PublishSubject<a7> e;
    public final PublishSubject<com.bytedance.android.livesdk.gift.model.x1> f;
    public final PublishSubject<String> g;
    public final PublishSubject<Unit> h;
    public final PublishSubject<q2.a> i;
    public final PublishSubject<q2.a> j;
    public String k;
    public final yz0.l l;
    public final GiftReceiverRepoService m;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y n;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x o;
    public final yz0.k p;

    public final class a implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.scope.service.CarnivalMessageService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", BuildConfig.FLAVOR, "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(CarnivalMessageService r8) {
            super(1, r8, CarnivalMessageService.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r10) {
            Intrinsics.checkNotNullParameter(r10, "p1");
            CarnivalMessageService r0 = (CarnivalMessageService) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r10, "message");
            if ((r10 instanceof q6) == false) goto L34;
            String r1 = r0.a();
            String r2 = r0.p.getRoom().getAnchorId();
            if (r2 != null) goto L35;
            r2 = BuildConfig.FLAVOR;
        L35:
            List<IBaseUser> r3 = r0.m.k().a;     // Catch: ConcurrentModificationException -> L14
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: ConcurrentModificationException -> L14
            Iterator<T> r5 = r3.iterator();     // Catch: ConcurrentModificationException -> L14
        L10:
            if (r5.hasNext() == false) goto L12;
            r4.add(((IBaseUser) r5.next()).getIdString());     // Catch: ConcurrentModificationException -> L14
            goto L10
        L12:
            List r6 = CollectionsKt.toMutableList(r4);     // Catch: ConcurrentModificationException -> L14
            ListProtector.add(r6, 0, r2);     // Catch: ConcurrentModificationException -> L14
        L15:
            Iterator r7 = r6.iterator();
        L17:
            if (r7.hasNext() == false) goto L44;
            String r8 = (String) r7.next();
            q6 r9 = (q6) r10;
            if ((!Intrinsics.areEqual(r9.getCurrentAnchor().getIdString(), r8)) == true) goto L17;
            q6 r11 = (q6) ((LinkedHashMap) r0.b).get(r8);
            if (r11 == null) goto L26;
            if (new Timestamp(r11.getTimeStamp()).after(new Timestamp(r9.getTimeStamp())) == false) goto L26;
            return;
        L26:
            if ((r9.getDisplayPosition() & DisplayPosition.GiftPanelTopBar.getValue()) == 0) goto L31;
            r0.c.put(r8, r9.getGiftPanelTopBar());
            r9.getGiftPanelTopBar().getTopBarAction();
            r9.getGiftPanelTopBar().getExtra();
            if (Intrinsics.areEqual(r1, r8) == false) goto L33;
            r0.f.onNext(r9.getGiftPanelTopBar());
        L33:
            r0.b.put(r8, r10);
            r0.k = r9.getScene();
            goto L17
        L31:
            if ((r9.getDisplayPosition() & DisplayPosition.ComboTray.getValue()) == 0) goto L33;
            r0.d.put(r8, r9.getComboTrayInfo());
            r9.getComboTrayInfo().getAction();
            r9.getComboTrayInfo().getExtra();
            r0.e.onNext(r9.getComboTrayInfo());
            goto L33
        L44:
            return;
        L14:
            r6 = CollectionsKt.listOf(r2);
            goto L15
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public final String a() {
        String r0 = this.p.getRoom().getAnchorId();
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        IBaseUser r1 = this.n.i();
        if (r1 == null) goto L9;
        String r2 = r1.getIdString();
        if (r2 == null) goto L9;
    L10:
        if (r2 != null) goto L13;
        return r0;
    L13:
        return r2;
    L9:
        r2 = this.o.a().getIdString();
        goto L10
    }

    public final void onStart() {
        yz0.l r0 = this.l;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.R, false, 6).subscribe(new a(new AnonymousClass1(this))), this.a);
    }

    public final void onStop() {
        this.a.dispose();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final q6 Y9() {
        String r0 = a();
        return (q6) ((LinkedHashMap) this.b).get(r0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final com.bytedance.android.livesdk.gift.model.x1 getGiftPanelTopBar() {
        String r0 = a();
        return (com.bytedance.android.livesdk.gift.model.x1) ((LinkedHashMap) this.c).get(r0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final PublishSubject<q2.a> K5() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final PublishSubject<String> X4() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final PublishSubject<q2.a> bh() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final String getScene() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final PublishSubject rj() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q2
    public final PublishSubject<Unit> w5() {
        return this.h;
    }

    public CarnivalMessageService(yz0.l r2, GiftReceiverRepoService r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r5, yz0.k r6) {
        Intrinsics.checkNotNullParameter(r2, "roomMessageService");
        Intrinsics.checkNotNullParameter(r3, "giftReceiverRepoService");
        Intrinsics.checkNotNullParameter(r4, "giftSelectReceiverService");
        Intrinsics.checkNotNullParameter(r5, "giftRecommendReceiverService");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        this.a = new CompositeDisposable();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = PublishSubject.create();
        this.f = PublishSubject.create();
        this.g = PublishSubject.create();
        this.h = PublishSubject.create();
        this.i = PublishSubject.create();
        this.j = PublishSubject.create();
    }
}
