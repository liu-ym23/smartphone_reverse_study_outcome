package v61;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.messagewindow.business.card.BottomRightCommonCard;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdkapi.interact.IAbsCardWindow;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import s71.g;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a implements c, b, IAbsCardWindow, r61.a {
    public final MsgWindowPosition a;
    public CardConstraint b;
    public boolean c;
    public View d;
    public boolean e;
    public boolean f;
    public final d g;
    public b71.a h;
    public final DataCenter i;
    public final Object j;
    public final int k;
    public final s61.a l;

    public final ICardLifecycle$State A() {
        return this.l.d();
    }

    public boolean E() {
        return this instanceof BottomRightCommonCard;
    }

    public final void H(p71.a r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.l.p(r2);
    }

    public void I() {
    }

    public void J() {
        this.c = false;
        this.e = false;
    }

    public void K() {
    }

    public void L() {
    }

    public void M() {
    }

    public void N(View r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
    }

    public void Q(HybridCard r1) {
    }

    public void R(i3 r1) {
    }

    @Override // t61.b
    public final void a(CardAnimType r2) {
        Intrinsics.checkNotNullParameter(r2, "animType");
        this.l.a(r2);
    }

    @Override // r61.b
    public final t61.a b() {
        return this.l.b();
    }

    @Override // r61.b
    public final void c(t61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "anim");
        this.l.c(r2);
    }

    @Override // r61.b
    public final void dismiss() {
        this.l.dismiss();
    }

    @Override // v61.b
    public void e(h r1, String r2) {
    }

    @Override // t61.b
    public final Observable<CardAnimState> f() {
        return this.l.f();
    }

    @Override // r61.a
    public final void g(o r2, DataCenter r3) {
        this.l.g(r2, r3);
    }

    @Override // r61.b
    public final o getRoomContext() {
        return this.l.getRoomContext();
    }

    @Override // t61.b
    public final void h(CardAnimType r2) {
        Intrinsics.checkNotNullParameter(r2, "animType");
        this.l.h(r2);
    }

    @Override // r61.b
    public final void hide() {
        this.l.hide();
    }

    @Override // r61.b
    public final void i(t71.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.l.i(r2);
    }

    @Override // r61.b
    public final g<c> j() {
        return this.l.j();
    }

    @Override // b71.b
    public final Observable<b71.a> l() {
        return this.l.l();
    }

    @Override // r61.b
    public final boolean o() {
        return this.l.o();
    }

    @Override // r61.a
    public final void s(CardConstraint r2) {
        Intrinsics.checkNotNullParameter(r2, "newConstraint");
        this.l.s(r2);
    }

    @Override // r61.b
    public final void show() {
        this.l.show();
    }

    @Override // r61.b
    public final void t(g<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "fight");
        this.l.t(r2);
    }

    @Override // r61.b
    public final Collection<t71.a> u() {
        return this.l.u();
    }

    @Override // c71.b
    public final Observable<ICardLifecycle$State> v() {
        return this.l.v();
    }

    @Override // o71.a
    public final Observable<p71.a> w() {
        return this.l.w();
    }

    @Override // r61.b
    public final Disposable x(long r2) {
        return this.l.x(r2);
    }

    @Override // v61.c
    public final boolean isShowing() {
        if (A().compareTo(ICardLifecycle$State.Showed) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (A().compareTo(ICardLifecycle$State.Hidden) >= 0) goto L7;
        return true;
    }

    public boolean isShowingWindow() {
        return isShowing();
    }

    @Override // c71.b
    public final /* bridge */ /* synthetic */ ICardLifecycle$State m() {
        return A();
    }

    public CardConstraint z() {
        return y();
    }

    public d B() {
        return this.g;
    }

    public boolean C() {
        return this.f;
    }

    public void dismissWindow() {
        dismiss();
    }

    @Override // r61.b
    public DataCenter getDataCenter() {
        return this.i;
    }

    @Override // v61.c
    public final Object getIdentity() {
        return this.j;
    }

    @Override // v61.c
    public MsgWindowPosition getPosition() {
        return this.a;
    }

    @Override // v61.c
    public final b71.a p() {
        return this.h;
    }

    public void showWindow() {
        show();
    }

    public CardConstraint y() {
        return this.b;
    }

    public void O(CardConstraint r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void P(CardConstraint r2) {
        Intrinsics.checkNotNullParameter(r2, "constraint");
        O(r2);
        if (this.c == false) goto L6;
        s(r2);
        return;
    }

    @Override // o71.a
    public final /* bridge */ /* synthetic */ void k(Object r1) {
        H((p71.a) r1);
    }

    @Override // c71.b
    public final void n(Object r2) {
        ICardLifecycle$State r3 = (ICardLifecycle$State) r2;
        Intrinsics.checkNotNullParameter(r3, "state");
        this.l.e(r3);
    }

    public a(DataCenter r2, Object r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "identity");
        s61.a r0 = new s61.a();
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r0;
        this.a = MsgWindowPosition.BOTTOM_RIGHT;
        this.b = new CardConstraint(-2, -2);
        this.g = new d(0);
        this.h = new b71.a.b();
        Intrinsics.checkNotNullParameter(this, "cardWindow");
        IPlatformCardService.Companion.getClass();
        IPlatformCardService r5 = IPlatformCardService.a.a();
        if (r5 == null) goto L5;
        r61.a r6 = r5.newCardAbilityImpl(this);
    L6:
        r0.a = r6;
        return;
    L5:
        r6 = null;
        goto L6
    }
}
