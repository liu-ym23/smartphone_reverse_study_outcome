package s61;

import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimState;
import com.bytedance.android.live.room.api.messagewindow.anim.CardAnimType;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements r61.a {
    public r61.a a;

    public a() {
    }

    @Override // r61.b
    public final t61.a b() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.b();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    public final ICardLifecycle$State d() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.m();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final void dismiss() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.dismiss();
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // t61.b
    public final Observable<CardAnimState> f() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.f();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final DataCenter getDataCenter() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.getDataCenter();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final o getRoomContext() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.getRoomContext();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final void hide() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.hide();
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final g<c> j() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.j();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // b71.b
    public final Observable<b71.a> l() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.l();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final boolean o() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.o();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final void show() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.show();
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final Collection<t71.a> u() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.u();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // c71.b
    public final Observable<ICardLifecycle$State> v() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.v();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // o71.a
    public final Observable<p71.a> w() {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.w();
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // c71.b
    public final /* bridge */ /* synthetic */ ICardLifecycle$State m() {
        return d();
    }

    @Override // t61.b
    public final void a(CardAnimType r2) {
        Intrinsics.checkNotNullParameter(r2, "animType");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.a(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final void c(t61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "anim");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.c(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    public final void e(ICardLifecycle$State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.n(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // t61.b
    public final void h(CardAnimType r2) {
        Intrinsics.checkNotNullParameter(r2, "animType");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.h(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final void i(t71.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.i(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // o71.a
    public final /* bridge */ /* synthetic */ void k(Object r1) {
        p((p71.a) r1);
    }

    @Override // c71.b
    public final /* bridge */ /* synthetic */ void n(Object r1) {
        e((ICardLifecycle$State) r1);
    }

    public final void p(p71.a r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.k(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.a
    public final void s(CardConstraint r2) {
        Intrinsics.checkNotNullParameter(r2, "newConstraint");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.s(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final void t(g<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "fight");
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.t(r2);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.b
    public final Disposable x(long r2) {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        return r0.x(r2);
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }

    @Override // r61.a
    public final void g(o r2, DataCenter r3) {
        r61.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.g(r2, r3);
        return;
    L7:
        throw new IllegalStateException("ICardAbility doesn't attach".toString());
    }
}
