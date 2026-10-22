package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoFlipPresenter;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoFlipTabElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoFlipTabElement extends BaseElement {
    public static final /* synthetic */ int o = 0;
    public UserInfoFlipPresenter d;
    public TextView e;
    public TextView f;
    public com.bytedance.android.livesdk.user.e g;
    public ValueAnimator h;
    public final CompositeDisposable i;
    public o91.c j;
    public LivePopupWindow k;
    public final int l;
    public final ViewGroup m;
    public final ViewGroup n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void f() {
        this.j = null;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final String g() {
        return "UserInfoFlipTabElement";
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
        ViewGroup r0 = this.n;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        TextView r2 = (TextView) r0.findViewById(2131362273);
    L6:
        this.e = r2;
        ViewGroup r3 = this.n;
        if (r3 == null) goto L9;
        TextView r4 = (TextView) r3.findViewById(2131362272);
    L10:
        this.f = r4;
        if (((Boolean) com.bytedance.android.live.misc.c.a.getValue()).booleanValue() == true) goto L13;
    L38:
        ViewGroup r5 = this.m;
        if (r5 == null) goto L41;
        r1 = r5.getLayoutParams();
    L41:
        if (r1 == null) goto L46;
        r1.width = this.l;
        ViewGroup r6 = this.m;
        if (r6 == null) goto L46;
        r6.setLayoutParams(r1);
    L46:
        if (isAnchor() == true) goto L63;
        com.bytedance.android.livesdk.user.e r7 = this.g;
        if (r7 == null) goto L63;
        IRoom r8 = getRoom();
        if (r8 == null) goto L53;
        String r9 = r8.getOwnerUserIdString();
        if (r9 == null) goto L53;
    L54:
        Observable r10 = r7.u0(r9);
        if (r10 == null) goto L63;
        Observable r12 = r10.subscribeOn(Schedulers.io());
        if (r12 == null) goto L63;
        Observable r13 = r12.observeOn(AndroidSchedulers.mainThread());
        if (r13 == null) goto L63;
        Disposable r14 = r13.subscribe(new e(this), RxUtil.getNoOpThrowable());
        if (r14 == null) goto L63;
        this.i.add(r14);
    L53:
        r9 = DataType.FALSE;
    L63:
        m(b().getMiddleVm().getShowProfileViewAnim().onEvent(), new UserInfoFlipTabElement$initVm$$inlined$run$lambda$1(this));
        return;
    L13:
        if (this.c.isAnchor() == false) goto L38;
        if (a0.g(this.c.getDataCenter()) == true) goto L38;
        ViewGroup r15 = this.m;
        if (r15 == null) goto L19;
        r15.setOnClickListener(new w0(UserInfoFlipTabElement$onInit$1.INSTANCE, 1000));
    L19:
        xs1.a r16 = (xs1.a) com.bytedance.android.live.misc.d.a.getValue();
        if (r16 != null) goto L22;
    L26:
        boolean r17 = false;
    L27:
        if (r17 == false) goto L38;
        SharedPrefHelper r18 = SharedPrefHelper.b(this.c.getContext());
        if (r18.f("live.pred.PREF_ANCHOR_BIZ_PABEL_POPUP", false) == true) goto L38;
        if (this.c.a() == false) goto L38;
        ViewGroup r19 = this.m;
        if (r19 == null) goto L35;
        r19.postDelayed(new f(this, r18), 15000);
    L35:
        ViewGroup r20 = this.m;
        if (r20 == null) goto L38;
        r20.postDelayed(new g(this), 22000);
        goto L38
    L22:
        if (r16.a() == true) goto L26;
        if (r16.c() == false) goto L26;
        r17 = true;
        goto L27
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        LivePopupWindow r0 = this.k;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.i.clear();
        o91.c r1 = this.j;
        if (r1 == null) goto L9;
        r1.c();
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        super.i();
        UserInfoFlipPresenter r0 = new UserInfoFlipPresenter(this.c);
        Unit r1 = Unit.INSTANCE;
        this.d = r0;
        this.g = (com.bytedance.android.livesdk.user.e) getDataCenter().get("data_user_center", null);
        UserInfoFlipPresenter r2 = this.d;
        if (r2 == null) goto L11;
        IRoom r3 = r2.b();
        if (r3 == null) goto L11;
        IBaseUser r4 = r3.getOwner();
        if (r4 == null) goto L11;
        py.j r5 = r4.getFollowInfo();
        if (r5 == null) goto L11;
        r5.getFollowerCount();
    L11:
        ViewGroup r6 = this.m;
        if (r6 == null) goto L14;
        m91.c r7 = this.c;
        this.j = new o91.c(r7.getContext(), r7.getDataCenter(), r7.getRoomContext(), r6);
    L14:
        IRoom r8 = getRoom();
        if (r8 == null) goto L22;
        UserInfoFlipPresenter r9 = this.d;
        if (r9 == null) goto L23;
        int r10 = r8.getAnchorTabType();
        int r12 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.a;
        int r13 = com.bytedance.android.live.room.navi.userinfo_p.utils.a.a(r10, r9.e.getDataCenter());
        o91.c r14 = this.j;
        if (r14 == null) goto L24;
        r14.e(r13);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        super.k();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r1) {
        super.l(r1);
    }

    public UserInfoFlipTabElement(m91.d r2, ViewGroup r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        super(r2);
        this.m = r3;
        this.n = r4;
        this.i = new CompositeDisposable();
        this.l = UtilityKotlinExtentionsKt.i(66);
    }
}
