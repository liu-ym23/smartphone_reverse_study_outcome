package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelInviteButtonWidget;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/AbsChatChannelInviteButtonWidget;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelInviteButtonWidget extends AbsChatChannelInviteButtonWidget {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatChannelInviteButtonWidget a;
        public final /* synthetic */ View b;

        public b(ChatChannelInviteButtonWidget r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Long r9 = (Long) r8;
            View r10 = LayoutInflater.from(this.b.getContext()).inflate(2131565296, null);
            yo2.e r1 = new yo2.e(this.a.getContext());
            ((yo2.d) r1).d = r10;
            ((yo2.d) r1).e = 0;
            ((yo2.d) r1).m = 2;
            ((yo2.d) r1).o = 1;
            ((yo2.d) r1).n = false;
            ((yo2.d) r1).l = true;
            r1.x = l.a;
            r1.a();
            r1.i(this.b, 1, 4, 0, s1.f(-4.0f));
            com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.h3;
            Boolean r0 = Boolean.TRUE;
            r11.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r11, r0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelInviteButtonWidget
    public final void wq() {
        Context r0 = ((Widget) this).context;
        if (r0 != null) goto L5;
        return;
    L5:
        RoomContext r1 = getRoomContext();
        if (r1 != null) goto L8;
        return;
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 != null) goto L11;
        return;
    L11:
        s22.e r3 = ChatChannelUtils.b(r1);
        if (r3 != null) goto L14;
        return;
    L14:
        s22.a r4 = ChatChannelUtils.c(r1);
        if (r4 != null) goto L17;
        return;
    L17:
        n62.e r5 = n62.h.b(r0, r1, r2, r3);
        Intrinsics.checkNotNullParameter(r4, "channel");
        r5.e(r4, null);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.g("icon");
    }

    public final void xq() {
        CompositeDisposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = new CompositeDisposable();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r1 = ChatChannelUtils.f(getRoomContext());
        if (r1 == null) goto L29;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r2 = r1.getState();
        if (r2 == null) goto L30;
        com.bytedance.android.livesdk.interactivity.api.base.d r3 = (com.bytedance.android.livesdk.interactivity.api.base.d) r2.getValue();
        if (r3 == null) goto L34;
        s22.e r4 = ChatChannelUtils.b(getRoomContext());
        if (r4 == null) goto L15;
        s22.a r5 = r4.getChannel(r3.b);
    L16:
        if (r5 == null) goto L22;
        PropertyOwner r6 = r5.z();
        if (r6 == null) goto L22;
        Disposable r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r6, new ChatChannelInviteButtonWidget$observeChannelInviteState$1(this));
        if (r7 == null) goto L22;
        RxUtilKt.c(r7, this.b);
    L22:
        if (r5 == null) goto L31;
        PropertyOwner r8 = r5.v();
        if (r8 == null) goto L32;
        Disposable r9 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r8, new ChatChannelInviteButtonWidget$observeChannelInviteState$2(this));
        if (r9 == null) goto L33;
        RxUtilKt.c(r9, this.b);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L15:
        r5 = null;
        goto L16
    L34:
        return;
    L30:
        return;
    }

    public final void zq() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r0 = ChatChannelUtils.f(getRoomContext());
        s22.a r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r2 = r0.getState();
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.base.d r3 = (com.bytedance.android.livesdk.interactivity.api.base.d) r2.getValue();
    L8:
        s22.e r4 = ChatChannelUtils.b(getRoomContext());
        if (r4 == null) goto L15;
        if (r3 == null) goto L12;
        long r5 = r3.b;
    L13:
        r1 = r4.getChannel(r5);
        goto L15
    L12:
        r5 = 0;
    L15:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.b.a(r3) == false) goto L32;
        if (r1 == null) goto L32;
        boolean r6 = r1.w();
        boolean r7 = true;
        if (r6 != true) goto L32;
        if (((Widget) this).containerView.getVisibility() != 0) goto L23;
        r7 = false;
    L23:
        ViewGroup r8 = ((Widget) this).containerView;
        if (r8 == null) goto L26;
        UtilityKotlinExtentionsKt.w(r8);
    L26:
        if (r7 == false) goto L36;
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 != null) goto L30;
        return;
    L30:
        if (ChatChannelUtils.h(r9) == false) goto L38;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.h("icon");
        return;
    L38:
        return;
    L36:
        return;
    L32:
        ViewGroup r10 = ((Widget) this).containerView;
        if (r10 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r10);
        return;
    L40:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public ChatChannelInviteButtonWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelInviteButtonWidget
    public final void onLoad(Object[] r3) {
        super.onLoad(r3);
        ViewGroup r4 = ((Widget) this).containerView;
        if (r4 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r4);
    L5:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r5 = ChatChannelUtils.f(getRoomContext());
        if (r5 == null) goto L12;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r6 = r5.getState();
        if (r6 == null) goto L12;
        Disposable r7 = i80.a.a(r6, new ChatChannelInviteButtonWidget$observePageState$1(this));
        if (r7 == null) goto L12;
        RxUtilKt.c(r7, this.a);
    L12:
        xq();
        zq();
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.h3.getValue(), Boolean.TRUE) == true) goto L29;
        k r8 = new k(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L18;
        r0.observe("multi_selected_tab_id", r8);
    L18:
        RxUtilKt.c(Disposables.fromAction(new i(this, r8)), this.a);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r9 = ChatChannelUtils.f(getRoomContext());
        if (r9 == null) goto L27;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r10 = r9.getState();
        if (r10 == null) goto L27;
        Observable r11 = r10.a();
        if (r11 == null) goto L27;
        Disposable r13 = r11.subscribe(new j(this));
        if (r13 == null) goto L27;
        RxUtilKt.c(r13, this.a);
    L27:
        yq(((Widget) this).contentView);
        return;
    }

    public final void yq(View r6) {
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.h3.getValue(), Boolean.TRUE) == false) goto L6;
        return;
    L6:
        if (isScreenPortrait() == true) goto L8;
        return;
    L8:
        if (r6 != null) goto L10;
        return;
    L10:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L13;
        return;
    L13:
        boolean r1 = ChatChannelUtils.h(r0);
        ViewGroup r2 = ((Widget) this).containerView;
        boolean r3 = false;
        if (r2 != null) goto L16;
    L18:
        boolean r4 = false;
    L20:
        if (n62.a.d == false) goto L22;
    L23:
        r3 = true;
    L24:
        if (r1 == false) goto L29;
        if (r4 == false) goto L30;
        if (r3 == true) goto L31;
        RxUtilKt.c(Observable.timer(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r6)), this.a);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L22:
        if (n62.a.e == false) goto L24;
    L16:
        if (r2.getVisibility() != 0) goto L18;
        r4 = true;
        goto L20
    }
}
