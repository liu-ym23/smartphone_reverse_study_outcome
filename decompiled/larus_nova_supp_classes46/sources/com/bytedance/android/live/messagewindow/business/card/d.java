package com.bytedance.android.live.messagewindow.business.card;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends v61.a {
    public Disposable m;
    public final DataCenter n;
    public final View o;

    public static final class a implements t71.a {
        public final /* synthetic */ d a;

        public final Single<Boolean> a() {
            return null;
        }

        public final Object getIdentity() {
            return null;
        }

        public final void onIntercept() {
        }

        public a(d r1) {
            this.a = r1;
        }

        public final boolean b(v61.a r2) {
            Intrinsics.checkNotNullParameter(r2, "msgWindow");
            DataCenter r3 = this.a.n;
            if (r3 == null) goto L11;
            IRoom r4 = a0.n(r3);
            if (r4 == null) goto L11;
            IRoomAuthStatus r5 = r4.getRoomAuthStatus();
            if (r5 == null) goto L11;
            if (r5.enableBanner() == true) goto L11;
            return true;
        L11:
            return false;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            r71.e r4 = (r71.e) r3;
            if (this.a.isShowing() == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r4.a.j, CardTypeAndPriority.AudienceLink.getType()) == true) goto L7;
            return;
        L7:
            if (r4.b != ICardLifecycle.State.Hidden) goto L12;
            this.a.S();
            return;
        }
    }

    public final void I() {
        t(new am0.a(this));
        i(new a(this));
        S();
        q71.a r0 = k.n(IMsgWindowService.class).cardStateDispatcher(this.n);
        if (r0 == null) goto L9;
        q71.d r1 = r0.a();
        if (r1 == null) goto L9;
        Observable r2 = ((q71.e) r1).b;
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new b(this));
    L10:
        this.m = r3;
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void S() {
        CardConstraint r0 = ((v61.a) this).b;
        r0.getClass();
        CardConstraint r1 = new CardConstraint(r0);
        r1.b(CardConstraint.Position.BottomRight);
        r1.a(new PortraitBottomRightBannerCard$bottomRightConstraint$1(this));
        P(r1);
    }

    public final void T() {
        CardConstraint r0 = ((v61.a) this).b;
        r0.getClass();
        CardConstraint r1 = new CardConstraint(r0);
        r1.b(CardConstraint.Position.TopRight);
        r1.a(PortraitBottomRightBannerCard$topRightConstraint$1.INSTANCE);
        P(r1);
    }

    public final x61.h<?, ?> content() {
        x61.h.a.getClass();
        return x61.a.b;
    }

    public final void J() {
        super.J();
        Disposable r0 = this.m;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void K() {
        if (v71.a.b() == false) goto L8;
        View r0 = this.o;
        if (r0 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r0);
        return;
    L9:
        return;
    }

    public final void L() {
        if (v71.a.b() == false) goto L8;
        View r0 = this.o;
        if (r0 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r0);
        return;
    L9:
        return;
    }

    public final DataCenter getDataCenter() {
        return this.n;
    }

    public d(DataCenter r2, View r3, CardTypeAndPriority r4) {
        Intrinsics.checkNotNullParameter(r4, "cardTypeAndPriority");
        super(r2, r4.getType(), r4.getPriority());
        this.n = r2;
        this.o = r3;
    }
}
