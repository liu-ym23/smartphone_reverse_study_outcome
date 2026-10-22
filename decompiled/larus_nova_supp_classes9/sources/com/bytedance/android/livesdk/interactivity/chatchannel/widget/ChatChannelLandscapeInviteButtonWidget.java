package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.ViewGroup;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelLandscapeInviteButtonWidget;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/AbsChatChannelInviteButtonWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelLandscapeInviteButtonWidget extends AbsChatChannelInviteButtonWidget {
    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelInviteButtonWidget
    public final void wq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = e62.d.a;
        Intrinsics.checkNotNullParameter(r0, "dataCenter");
        r0.put("cmd_chat_channel_close_landscape_dialog", Boolean.TRUE);
        MainThreadPostUtils.c(e62.b.a, 200);
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.g("icon");
    }

    public final void xq() {
        s22.a r0 = ChatChannelUtils.c(getRoomContext());
        if (r0 == null) goto L17;
        boolean r1 = true;
        if (r0.w() != true) goto L17;
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 != null) goto L9;
    L12:
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r3);
    L15:
        if (r1 == false) goto L21;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.h("icon");
        return;
    L21:
        return;
    L9:
        if (r2.getVisibility() != 0) goto L12;
        r1 = false;
    L17:
        ViewGroup r4 = ((Widget) this).containerView;
        if (r4 == null) goto L23;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    }

    public ChatChannelLandscapeInviteButtonWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelInviteButtonWidget
    public final void onLoad(Object[] r3) {
        super.onLoad(r3);
        CompositeDisposable r4 = this.b;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        this.b = new CompositeDisposable();
        s22.a r5 = ChatChannelUtils.c(getRoomContext());
        if (r5 == null) goto L12;
        PropertyOwner r0 = r5.z();
        if (r0 == null) goto L12;
        Disposable r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r0, new ChatChannelLandscapeInviteButtonWidget$observeChannelInviteState$1(this));
        if (r1 == null) goto L12;
        RxUtilKt.c(r1, this.b);
    L12:
        if (r5 == null) goto L18;
        PropertyOwner r6 = r5.v();
        if (r6 == null) goto L18;
        Disposable r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r6, new ChatChannelLandscapeInviteButtonWidget$observeChannelInviteState$2(this));
        if (r7 == null) goto L18;
        RxUtilKt.c(r7, this.b);
    L18:
        xq();
    }
}
