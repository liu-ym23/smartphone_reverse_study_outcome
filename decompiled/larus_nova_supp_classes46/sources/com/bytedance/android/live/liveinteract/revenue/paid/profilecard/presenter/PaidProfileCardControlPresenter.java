package com.bytedance.android.live.liveinteract.revenue.paid.profilecard.presenter;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.data.b;
import com.bytedance.android.live.liveinteract.plantform.api.LinkPaidLinkApi;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.network.c;
import com.bytedance.android.livesdk.chatroom.model.interact.i1;
import com.bytedance.android.livesdk.chatroom.model.interact.j1;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.xa;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vlc.d;
import vlc.l;
import zg1.f3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter$IView;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "IView", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidProfileCardControlPresenter extends n<IView> implements l, Observer<KVData> {
    public static final /* synthetic */ int h = 0;
    public CompositeDisposable e;
    public final IRoom f;
    public final boolean g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/profilecard/presenter/PaidProfileCardControlPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IView extends IWidget {
        void Dg();

        void El(b r1);

        /* synthetic */ Context getContext();

        void n7();
    }

    public static final class a {
    }

    static {
    }

    public final boolean h0() {
        DataCenter r0 = ((n) this).c;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        f3 r2 = (f3) r0.get("data_bottom_right_state", new f3());
    L6:
        DataCenter r3 = ((n) this).c;
        if (r3 == null) goto L10;
        r1 = (Boolean) r3.get("data_promotion_right_card_container_show", Boolean.FALSE);
    L10:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L17;
        if (r2 != null) goto L13;
    L15:
        return false;
    L13:
        if (r2.a != true) goto L15;
        return true;
    L17:
        return true;
    L5:
        r2 = null;
        goto L6
    }

    public final void detachView() {
        super.detachView();
        DataCenter r0 = ((n) this).c;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        d r1 = ((n) this).d;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        CompositeDisposable r2 = this.e;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.e = null;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r2) {
        super.c0(r2);
        this.e = new CompositeDisposable();
        DataCenter r3 = ((n) this).c;
        if (r3 == null) goto L5;
        r3.observe("data_paid_link_profile_show", this);
    L5:
        d r4 = ((n) this).d;
        if (r4 == null) goto L8;
        r4.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getKey(), this);
    L8:
        d r5 = ((n) this).d;
        if (r5 == null) goto L12;
        r5.addMessageListener(MessageType.LINK_MIC_PROFIT.getKey(), this);
        return;
    }

    public final void i0(i1 r10) {
        if (h0() == false) goto L5;
        return;
    L5:
        IView r0 = ((q46.b) this).a;
        if (r0 == null) goto L19;
        boolean r2 = this.g;
        j1 r1 = r10.getTag();
        if (r1 == null) goto L10;
        k r4 = r1.getPic();
    L11:
        IRoom r3 = this.f;
        if (r3 == null) goto L16;
        IBaseUser r5 = r3.getBaseOwner();
        if (r5 == null) goto L16;
        k r6 = r5.getAvatarThumbKt();
    L17:
        r0.El(new b(r2, r4, r6, r10.getNumOfLink(), r10.getAvgGrade()));
        return;
    L16:
        r6 = null;
        goto L17
    L10:
        r4 = null;
        goto L11
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r4.getKey(), "data_paid_link_profile_show") == false) goto L21;
        Boolean r5 = (Boolean) r4.getData();
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L16;
        if (this.f == null) goto L27;
        Disposable r6 = ((LinkPaidLinkApi) c.b().e(LinkPaidLinkApi.class)).getPaidExplainCardInfo(this.f.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new ej0.a(this), ej0.b.a);
        CompositeDisposable r0 = this.e;
        if (r0 == null) goto L22;
        r0.add(r6);
        return;
    L22:
        return;
    L27:
        return;
    L16:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L24;
        IView r7 = ((q46.b) this).a;
        if (r7 == null) goto L25;
        r7.n7();
        return;
    L25:
        return;
    L24:
        return;
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof ILinkMicGuideMessageBridge) == false) goto L22;
        ILinkMicGuideMessageBridge r7 = (ILinkMicGuideMessageBridge) r6;
        if (this.g == false) goto L7;
        return;
    L7:
        if (vm2.d.o0() == true) goto L10;
        return;
    L10:
        if (r7.getGuidelineType() != 9) goto L30;
        xa r8 = r7.getNormalPaidLinkmicExplainCardContent();
        if (r8 == null) goto L31;
        i1 r9 = r8.getPaidLinkmicExplainCardInfo();
        if (r9 == null) goto L39;
        cj0.c r0 = PaidLinkMicContext.Companion.a();
        if (r0 != null) goto L19;
        return;
    L19:
        if (r0.isPaidLinkOn() != true) goto L33;
        i0(r9);
        return;
    L33:
        return;
    L39:
        return;
    L31:
        return;
    L30:
        return;
    L22:
        if ((r6 instanceof ILinkmicProfitMessage) == true) goto L24;
        return;
    L24:
        if (((ILinkmicProfitMessage) r6).getMsgType() != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicClose.ordinal()) goto L36;
        IView r10 = ((q46.b) this).a;
        if (r10 == null) goto L37;
        r10.Dg();
        return;
    L37:
        return;
    }

    public PaidProfileCardControlPresenter(IRoom r1, boolean r2) {
        this.f = r1;
        this.g = r2;
    }
}
