package com.bytedance.android.live.revlink.impl.ui;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.ui.LinkGuestSendGiftView;
import com.bytedance.android.livesdk.revenue.datacenter.f;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import wq2.e;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/ui/GiftAnchorTicketWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftAnchorTicketWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public LinkGuestSendGiftView a;
    public IRoom b;
    public final CompositeDisposable c;
    public final b d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftAnchorTicketWidget a;

        public a(GiftAnchorTicketWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            GiftAnchorTicketWidget r9 = this.a;
            IRoom r0 = r9.b;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getOwner() == null) goto L19;
            IRoom r5 = r9.b;
            if (r5 == null) goto L10;
            IBaseUser r1 = r5.getOwner();
        L11:
            IBaseUser r4 = r1;
            if (r5 == null) goto L17;
            if (r4 == null) goto L18;
            vh6.c.b(d.class).showLynxGuestContributionRankList(((Widget) r9).context, ((Widget) r9).dataCenter, r4, r5, new HashMap());
            return;
        L18:
            return;
        L17:
            return;
        L10:
            r1 = null;
            goto L11
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ GiftAnchorTicketWidget a;

        public b(GiftAnchorTicketWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            GiftAnchorTicketWidget r0 = this.a;
            r0.wq((List) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget$onChanged$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass1 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(f.class, "bigPartySupportSendGift2Linker", "getBigPartySupportSendGift2Linker()Z", 0);
        }

        public Object get(Object r1) {
            return Boolean.valueOf(((f) r1).c());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget$onLoad$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C03691 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new C03691();
        }

        public C03691() {
            super(f.class, "bigPartySupportSendGift2Linker", "getBigPartySupportSendGift2Linker()Z", 0);
        }

        public Object get(Object r1) {
            return Boolean.valueOf(((f) r1).c());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.ui.GiftAnchorTicketWidget$onLoad$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/ies/sdk/widgets/KVData;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<KVData, Unit> {
        public AnonymousClass2(GiftAnchorTicketWidget r8) {
            super(1, r8, GiftAnchorTicketWidget.class, "onChanged", "onChanged(Lcom/bytedance/ies/sdk/widgets/KVData;)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((KVData) r1);
            return Unit.INSTANCE;
        }

        public final void invoke(KVData r2) {
            ((GiftAnchorTicketWidget) ((CallableReference) this).receiver).onChanged(r2);
        }
    }

    public final int getLayoutId() {
        return 2131565219;
    }

    public final String getSpm() {
        return "a100.a100.a154";
    }

    public final void onUnload() {
        this.c.clear();
        vh6.c.b(d.class).zm(this.d);
    }

    public GiftAnchorTicketWidget() {
        this.c = new CompositeDisposable();
        this.d = new b(this);
    }

    public final void onChanged(KVData r3) {
        KProperty1 r0 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "property");
        String r1 = vh6.c.b(wq2.d.class).kb(r0);
        if (r3 == null) goto L5;
        String r4 = r3.getKey();
    L7:
        if (Intrinsics.areEqual(r1, r4) == false) goto L12;
        ox0.a r5 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r5 == null) goto L13;
        r5.a();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void onInit(Object[] r2) {
        this.a = ((Widget) this).containerView.findViewById(2131381478);
    }

    public final void onLoad(Object[] r4) {
        k r5 = (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        Observable r0 = null;
        if (r5 == null) goto L5;
        IRoom r6 = r5.getRoom();
    L6:
        this.b = r6;
        ox0.a r7 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r7 == null) goto L9;
        r7.a();
    L9:
        LinkGuestSendGiftView r8 = this.a;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L12:
        r8.setAllowSendGift(false);
        boolean r9 = e.b().c();
        LinkGuestSendGiftView r2 = this.a;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L15:
        r2.setAllowSendGift(r9);
        vh6.c.b(d.class).wj(this.d);
        KProperty1 r10 = C03691.INSTANCE;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(f.class), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.revenue.datacenter.e.class)) == false) goto L19;
        r0 = vh6.c.b(wq2.d.class).ah().a(r10);
    L21:
        if (r0 == null) goto L25;
        final AnonymousClass2 r12 = new AnonymousClass2(this);
        Disposable r13 = r0.subscribe(new c(r12));
        if (r13 == null) goto L25;
        RxUtilKt.c(r13, this.c);
    L25:
        wq(vh6.c.b(d.class).getOnlineList());
        ((Widget) this).containerView.setOnClickListener(new a(this));
        return;
    L19:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(f.class), Reflection.getOrCreateKotlinClass(f.class)) == false) goto L21;
        r0 = vh6.c.b(wq2.d.class).m9().a(r10);
        goto L21
    L5:
        r6 = null;
        goto L6
    }

    public final void wq(List<com.bytedance.android.livesdk.revenue.service.interact.a> r3) {
        if (r3.isEmpty() == false) goto L9;
        LinkGuestSendGiftView r4 = this.a;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L7:
        r4.setAllowSendGift(false);
        return;
    L9:
        ox0.a r5 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r5 == null) goto L12;
        r5.a();
    L12:
        LinkGuestSendGiftView r6 = this.a;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("guestSendGiftView");
    L15:
        r6.setAllowSendGift(false);
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }
}
