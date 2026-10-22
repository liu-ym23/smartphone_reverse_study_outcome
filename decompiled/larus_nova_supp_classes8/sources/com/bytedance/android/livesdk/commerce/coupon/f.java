package com.bytedance.android.livesdk.commerce.coupon;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.TiltedIconTemplate;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.WidgetDelegate;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework.a<a> {
    public LiveCouponPresenter e;
    public b f;
    public final DataCenter g;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.commerce.coupon.f$a$a, reason: collision with other inner class name */
        public static final class C0109a extends a {
            public static final C0109a a = null;

            static {
                a = new C0109a();
            }

            public C0109a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public final class b implements LiveCouponPresenter.b, IWidget {
        public final /* synthetic */ WidgetDelegate a;
        public final /* synthetic */ f b;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        public Context getContext() {
            return this.a.getContext();
        }

        public final Lifecycle getLifecycle() {
            WidgetDelegate r0 = this.a;
            r0.getClass();
            return LifecycleOwnerCompat.-CC.$default$getLifecycle(r0);
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        public final /* synthetic */ String getLogTag() {
            return IWidget.CC.$default$getLogTag(this);
        }

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponPresenter.b
        public final void Z80() {
            this.b.moveToState(a.b.a);
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        public final DataCenter getDataCenter() {
            return this.a.d;
        }

        public final Lifecycle getLifecycleCompat() {
            return this.a.a;
        }

        public b(f r4) {
            this.b = r4;
            DataCenter r0 = r4.g;
            Intrinsics.checkNotNullParameter(r4, "$this$createWidgetDelegate");
            Intrinsics.checkNotNullParameter(r0, "dataCenter");
            WidgetDelegate r1 = new WidgetDelegate(r4.getContext(), r0);
            r4.bindModel(r1);
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponPresenter.b
        public final void Be(boolean r2) {
            if (r2 == true) goto L5;
            this.b.moveToState(a.b.a);
            return;
        }

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponPresenter.b
        public final void HT(vl2.b r2) {
            this.b.moveToState(a.C0109a.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            f r4 = this.a;
            r4.moveToState(r4.getCurrentState());
        }
    }

    public final IIconModel.EntryView getBigCardEntryViewForState() {
        return null;
    }

    public final void onClick() {
        LiveCouponPresenter r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r0.e0();
    }

    public final void onCreate() {
        this.f = new b(this);
        LiveCouponPresenter r0 = new LiveCouponPresenter(getContext(), this.g);
        this.e = r0;
        com.bytedance.android.livesdk.chatroom.o r1 = z51.a.g(a());
        long r2 = 0;
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L9;
        long r5 = r4.getId();
    L10:
        r0.b = r5;
        LiveCouponPresenter r6 = this.e;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L13:
        com.bytedance.android.livesdk.chatroom.o r7 = z51.a.g(a());
        if (r7 == null) goto L26;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L26;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L26;
        IBaseUser r10 = r9.getOwner();
        if (r10 == null) goto L26;
        String r11 = r10.getIdString();
        if (r11 == null) goto L26;
        Long r12 = StringsKt.toLongOrNull(r11);
        if (r12 == null) goto L26;
        r2 = r12.longValue();
    L26:
        r6.c = r2;
        LiveCouponPresenter r13 = this.e;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L29:
        b r14 = this.f;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("iView");
    L32:
        ((q46.b) r13).a = r14;
        r13.q.observe("DATA_COMMERCE_ECOM_MESSAGE", r13);
        com.bytedance.android.livesdk.service.l.d().getClass();
        r13.f = ((LiveCouponApi) com.bytedance.android.live.network.c.b().e(LiveCouponApi.class)).queryCurCouponInfo(r13.b).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(r13), new l(r13));
        com.bytedance.android.livesdk.chatroom.o r15 = z51.a.g(a());
        if (r15 == null) goto L40;
        com.bytedance.live.datacontext.m r16 = r15.e2();
        if (r16 == null) goto L41;
        Observable r17 = r16.a();
        if (r17 == null) goto L42;
        r17.subscribe(new c(this));
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L9:
        r5 = 0;
        goto L10
    }

    public final void onDestroy() {
        LiveCouponPresenter r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        r0.detachView();
    }

    public f(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(a.b.a, ShortTermIndicatorConfig.ElementType.CommerceRaffleTicket.getTypeId());
        this.g = r3;
    }

    public final IconTemplate getViewForState(Object r7) {
        a r8 = (a) r7;
        Intrinsics.checkNotNullParameter(r8, "state");
        com.bytedance.android.livesdk.chatroom.o r0 = z51.a.g(a());
        if (r0 == null) goto L5;
        Boolean r1 = r0.isPortraitInteraction();
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L10;
        return null;
    L10:
        if ((r8 instanceof a.C0109a) == false) goto L22;
        TiltedIconTemplate r9 = new TiltedIconTemplate(getContext(), null, 6, 0);
        LiveCouponPresenter r2 = this.e;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L14:
        com.bytedance.android.livesdk.commerce.coupon.b r3 = r2.d;
        if (r3 != null) goto L17;
    L19:
        int r4 = 2131250286;
    L20:
        r9.setContentView(imageViewOf(r4, 25.0f, 40.0f));
        r9.setContentRightMargin(UtilityKotlinExtentionsKt.i(11));
        r9.setContentTopMargin(UtilityKotlinExtentionsKt.i(6));
        return r9;
    L17:
        if (r3.activityType != 1) goto L19;
        r4 = 2131250283;
        goto L20
    L22:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final IIconModel.EntryView getEntryViewForState(Object r4, Object r5) {
        a r6 = (a) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "state");
        if ((r6 instanceof a.C0109a) == true) goto L5;
    L15:
        return null;
    L5:
        if ((r7 instanceof a.b) == false) goto L15;
        LiveCouponPresenter r8 = this.e;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L9:
        com.bytedance.android.livesdk.commerce.coupon.b r9 = r8.d;
        if (r9 == null) goto L18;
        if (r9.activityType != 1) goto L18;
        return inflateEntryView(2131565343);
    L18:
        return inflateEntryView(2131565342);
    }

    public final void applyState(Object r1, Object r2, IconTemplate r3) {
        a r4 = (a) r1;
        a r5 = (a) r2;
        Intrinsics.checkNotNullParameter(r5, "curState");
        if ((r5 instanceof a.C0109a) == true) goto L5;
        return;
    L5:
        if ((r4 instanceof a.C0109a) == true) goto L10;
        LiveCouponPresenter r6 = this.e;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L9:
        r6.getClass();
        LiveCouponPresenter.i0("livesdk_coupon_show", new String[0]);
        return;
    L10:
        activateIcon();
    }
}
