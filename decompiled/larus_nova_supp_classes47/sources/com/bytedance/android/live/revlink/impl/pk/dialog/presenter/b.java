package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogLinkRecordContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractLinkRecordFragment;
import com.bytedance.android.livesdk.link.model.o5;
import com.bytedance.android.livesdk.link.model.p5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends x31.c {
    public String d;
    public int e;
    public final Lazy f;
    public int g;
    public boolean h;
    public boolean i;
    public Disposable j;
    public final com.bytedance.android.live.revenuelink.connect.f k;
    public final com.bytedance.android.live.revlink.impl.pk.dialog.presenter.c l;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.dialog.presenter.b$b, reason: collision with other inner class name */
    public static final class C0157b<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ int b;

        public C0157b(b r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            ExtraResponse r12 = (ExtraResponse) r10;
            b r0 = this.a;
            if (r12 == null) goto L9;
            p5 r2 = (p5) r12.data;
            if (r2 == null) goto L9;
            Boolean r3 = r2.getHasMoreQueryResult();
            if (r3 == null) goto L9;
            boolean r4 = r3.booleanValue();
        L10:
            r0.h = r4;
            b r1 = this.a;
            int r5 = this.b;
            if (r12 == null) goto L17;
            p5 r6 = (p5) r12.data;
            if (r6 == null) goto L17;
            List r7 = r6.getRecords();
            if (r7 == null) goto L17;
            int r8 = r7.size();
        L18:
            r1.e = r5 + r8;
            b r9 = this.a;
            String r13 = null;
            if (r12 == null) goto L23;
            p5 r14 = (p5) r12.data;
            if (r14 == null) goto L23;
            String r15 = r14.getNextQueryIndex();
        L24:
            r9.d = r15;
            if (r12 == null) goto L44;
            p5 r16 = (p5) r12.data;
            if (r16 == null) goto L44;
            List r17 = r16.getRecords();
            if (r17 == null) goto L44;
            Iterator<T> r18 = r17.iterator();
        L32:
            if (r18.hasNext() == false) goto L44;
            o5 r19 = (o5) r18.next();
            IBaseUser r20 = r19.getUser();
            if (r20 == null) goto L32;
            String r22 = r20.getIdString();
            if (r22 == null) goto L32;
            ConcurrentHashMap r23 = (ConcurrentHashMap) this.a.f.getValue();
            Intrinsics.checkNotNullParameter(r19, "$this$toBanSecondData");
            IBaseUser r24 = r19.getUser();
            if (r24 == null) goto L42;
            py.j r25 = r24.getFollowInfo();
            if (r25 == null) goto L42;
            int r26 = (int) r25.getFollowStatus();
        L43:
            r23.put(r22, new x31.t(r26));
        L42:
            r26 = 0;
        L44:
            b r27 = this.a;
            if (r27.e < 100) goto L47;
            boolean r28 = true;
        L48:
            if (r28 == false) goto L51;
            r27.h = false;
        L51:
            if (r27.h == true) goto L55;
            if (r28 == false) goto L54;
            r13 = "最多展示100条";
            goto L55
        L54:
            r13 = "近3个月无更多连线记录";
        L55:
            InteractDialogLinkRecordContract$View r29 = (InteractDialogLinkRecordContract$View) r27.c;
            if (r29 == null) goto L66;
            r29.ea0((p5) r12.data, r13);
            return;
        L66:
            return;
        L47:
            r28 = false;
        L23:
            r15 = null;
        L17:
            r8 = 0;
        L9:
            r4 = false;
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.d(r3);
            InteractDialogLinkRecordContract$View r0 = (InteractDialogLinkRecordContract$View) this.a.c;
            if (r0 == null) goto L6;
            r0.da0(r3);
            return;
        }
    }

    static {
    }

    public final void b() {
        ((com.bytedance.android.livesdk.common.c) this).a = null;
        com.bytedance.android.live.revenuelink.connect.f r0 = this.k;
        if (r0 == null) goto L6;
        r0.removeLinkOutListener(7, this.l);
        return;
    }

    @Override // x31.c
    public final void j() {
        this.e = 0;
        this.d = null;
        this.h = true;
        Disposable r0 = this.j;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ((ConcurrentHashMap) this.f.getValue()).clear();
    }

    @Override // x31.c
    public final void e() {
        i(this.d, false, this.e);
    }

    @Override // x31.c
    public final int g() {
        return this.g;
    }

    public b(InteractLinkRecordFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r3);
        this.f = LazyKt.lazy(InteractDialogLinkRecordPresenter$mLinkBanSecondMap$2.INSTANCE);
        this.h = true;
        com.bytedance.android.live.revenuelink.connect.f r4 = com.bytedance.android.live.revlink.impl.global.b.a();
        this.k = r4;
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.c r0 = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.c(this);
        this.l = r0;
        if (r4 == null) goto L6;
        r4.addLinkOutListener(7, r0);
        return;
    }

    @Override // x31.c
    public final x31.t f(String r2) {
        return (x31.t) ((ConcurrentHashMap) this.f.getValue()).get(r2);
    }

    @Override // x31.c
    public final void k(int r3) {
        if (r3 == this.g) goto L6;
        this.g = r3;
        j();
        i(null, true, 0);
        return;
    }

    @Override // x31.c
    public final void h(int r42, o5 r43) {
        Intrinsics.checkNotNullParameter(r43, "linkRecord");
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r1 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r1 == null) goto L48;
        com.bytedance.android.live.revenuelink.connect.n r2 = r1.getLinkOutManagerFn();
        if (r2 == null) goto L49;
        yz0.k r4 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        long r5 = 0;
        if (r4 == null) goto L14;
        IRoom r6 = r4.getRoom();
        if (r6 == null) goto L14;
        long r7 = r6.getRoomId();
    L15:
        IBaseUser r8 = r43.getUser();
        if (r8 == null) goto L18;
        long r9 = r8.getLiveRoomId();
    L19:
        IBaseUser r10 = r43.getUser();
        if (r10 == null) goto L22;
        String r36 = r10.getIdString();
    L23:
        IBaseUser r12 = r43.getUser();
        if (r12 == null) goto L26;
        Intrinsics.checkNotNullParameter(r12, "$this$secUidExt");
        String r37 = r12.getCastSecUid();
    L27:
        IRoom r13 = vh7.f.c(IRoom.class);
        IBaseUser r14 = r43.getUser();
        if (r14 == null) goto L30;
        r5 = r14.getLiveRoomId();
    L30:
        r13.setId(r5);
        IBaseUser r15 = vh7.f.c(IBaseUser.class);
        IBaseUser r16 = r43.getUser();
        if (r16 == null) goto L33;
        String r17 = r16.getIdString();
    L34:
        String r18 = "";
        if (r15 == null) goto L39;
        if (r17 != null) goto L38;
        r17 = "";
    L38:
        r15.setIdString(r17);
    L39:
        IBaseUser r3 = r43.getUser();
        if (r3 == null) goto L42;
        Intrinsics.checkNotNullParameter(r3, "$this$secUidExt");
        String r19 = r3.getCastSecUid();
    L43:
        if (r19 == null) goto L46;
        r18 = r19;
    L46:
        com.bytedance.android.live.base.model.user.o.c(r15, r18);
        Unit r20 = Unit.INSTANCE;
        r13.setOwner(r15);
        r2.d(new d11.d(7, r7, r9, r42, 0, r36, r37, r13, BizType.AnchorLink.ordinal(), null, 0, null, 0, 0, null, 0, null, null, null, null, 0, 0, 0, null, null, null, null, null, 536866304), null);
        return;
    L42:
        r19 = null;
        goto L43
    L33:
        r17 = null;
        goto L34
    L26:
        r37 = null;
        goto L27
    L22:
        r36 = null;
        goto L23
    L18:
        r9 = 0;
    L14:
        r7 = 0;
        goto L15
    L49:
        return;
    }

    @Override // x31.c
    public final void i(String r2, boolean r3, int r4) {
        if (r3 == false) goto L5;
        j();
    L5:
        if (this.h == false) goto L14;
        Observable r5 = r31.b.a(r31.a.a).B(r2, this.g);
        if (r5 == null) goto L11;
        ObservableSubscribeProxy r6 = (ObservableSubscribeProxy) r5.as(c());
        if (r6 == null) goto L11;
        Disposable r7 = r6.subscribe(new C0157b(this, r4), new c(this));
    L12:
        this.j = r7;
        return;
    L11:
        r7 = null;
        goto L12
    }
}
