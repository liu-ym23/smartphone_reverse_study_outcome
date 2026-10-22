package com.bytedance.android.live.liveinteract.revenue.paid.profilecard;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.data.b;
import com.bytedance.android.live.liveinteract.plantform.base.f;
import com.bytedance.android.live.liveinteract.plantform.base.g;
import com.bytedance.android.live.liveinteract.plantform.base.j;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/PaidProfileCardControlWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter$IView;", "Lcom/bytedance/android/live/liveinteract/plantform/base/j;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidProfileCardControlWidget extends MiddlewareRoomWidget implements PaidProfileCardControlPresenter.IView, j, Observer<KVData> {
    public boolean a;
    public IRoom b;
    public PaidProfileCardControlPresenter c;
    public boolean d;
    public Disposable e;
    public PaidProfileCardWidget f;
    public Disposable g;
    public v61.a h;

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter.IView
    public final void Dg() {
        if (this.d == false) goto L6;
        n7();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.j
    public final void Ld() {
        g r0 = f.a();
        boolean r1 = true;
        if (r0 == null) goto L7;
        if (r0.j7() != true) goto L7;
    L10:
        if (r1 == true) goto L13;
        Dg();
        return;
    L13:
        return;
    L7:
        if (f.a().k0(32) == true) goto L10;
        r1 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter.IView, com.bytedance.android.live.liveinteract.plantform.base.j
    public final void n7() {
        if (v71.a.c() == false) goto L9;
        v61.a r0 = this.h;
        if (r0 == null) goto L21;
        r0.dismiss();
        return;
    L21:
        return;
    L9:
        if (this.d == true) goto L11;
        return;
    L11:
        g r1 = f.a();
        if (r1 == null) goto L14;
        r1.xh(this.f);
    L14:
        PaidProfileCardContext r2 = PaidProfileCardContext.Companion.getContext();
        if (r2 == null) goto L19;
        n<b> r3 = r2.getPaidProfileCardData();
        if (r3 == null) goto L19;
        r3.setValue(null);
    L19:
        this.f = null;
        this.d = false;
        this.e = null;
    }

    public final void onCreate() {
        super.onCreate();
        Boolean r0 = (Boolean) ((Widget) this).dataCenter.get("data_is_anchor");
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        this.a = r1;
        ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        this.b = (IRoom) ((Widget) this).dataCenter.get("data_room", vh7.f.c(IRoom.class));
        PaidProfileCardControlPresenter r2 = new PaidProfileCardControlPresenter(this.b, this.a);
        this.c = r2;
        r2.g0(this);
        Pair r3 = d.a(PaidProfileCardControlWidget$onCreate$pair$1.INSTANCE);
        ((PaidProfileCardContext) r3.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r3.getFirst(), cj0.d.class);
        this.g = (Disposable) r3.getSecond();
        ((Widget) this).dataCenter.observe("data_promotion_right_card_container_show", this);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        PaidProfileCardControlPresenter r0 = this.c;
        if (r0 == null) goto L5;
        r0.detachView();
    L5:
        Disposable r1 = this.e;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.g;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.g = null;
        ((Widget) this).dataCenter.removeObserver(this);
    }

    public PaidProfileCardControlWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.j
    public final boolean Ie() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter.PaidProfileCardControlPresenter.IView
    public final void El(b r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        if (this.d == false) goto L5;
        return;
    L5:
        Disposable r1 = this.e;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Widget r4 = null;
        if (v71.a.c() == false) goto L20;
        IMiddlewareMsgWindowService r2 = k.f(IMiddlewareMsgWindowService.class);
        if (r2 == null) goto L18;
        u61.a r3 = r2.cardBuilder();
        if (r3 == null) goto L18;
        cm0.a r5 = r3.a(new PaidProfileCardControlWidget$initPaidProfileCard$1(this, 10000));
        if (r5 == null) goto L18;
        dm0.a r6 = r5.b();
    L19:
        this.h = r6;
    L18:
        r6 = null;
    L20:
        Intrinsics.checkNotNullParameter(r7, "data");
        if (this.d == true) goto L43;
        PaidProfileCardContext r0 = PaidProfileCardContext.Companion.getContext();
        if (r0 == null) goto L28;
        n<b> r8 = r0.getPaidProfileCardData();
        if (r8 == null) goto L28;
        r8.setValue(r7);
    L28:
        g r9 = f.a();
        if (r9 == null) goto L31;
        r4 = r9.em();
    L31:
        this.f = (PaidProfileCardWidget) r4;
        if (v71.a.c() == false) goto L41;
        PaidProfileCardWidget r10 = this.f;
        if (r10 == null) goto L38;
        ViewGroup r11 = ((Widget) r10).containerView;
        if (r11 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r11);
    L38:
        v61.a r12 = this.h;
        if (r12 == null) goto L43;
        r12.show();
        goto L43
    L41:
        this.d = true;
    L43:
        if (v71.a.c() == true) goto L46;
        this.e = Observable.timer(10000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        return;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4.getKey(), "data_bottom_right_state") == false) goto L7;
    L8:
        PaidProfileCardControlPresenter r5 = this.c;
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.h0() != true) goto L17;
        Dg();
        return;
    L17:
        return;
    L7:
        if (Intrinsics.areEqual(r4.getKey(), "data_promotion_right_card_container_show") == true) goto L8;
    }
}
