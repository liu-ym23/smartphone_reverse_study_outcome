package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/AbsChatChannelInviteButtonWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsChatChannelInviteButtonWidget extends RoomRecyclableWidget {
    public CompositeDisposable a;
    public CompositeDisposable b;

    public final int getLayoutId() {
        return 2131566635;
    }

    public final void onInit(Object[] r1) {
    }

    public abstract void wq();

    public final void onUnload() {
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        CompositeDisposable r1 = this.b;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public AbsChatChannelInviteButtonWidget() {
    }

    public void onLoad(Object[] r6) {
        this.a = new CompositeDisposable();
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L5;
        r7.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L5:
        View r8 = ((Widget) this).contentView;
        DataCenter r0 = ((Widget) this).dataCenter;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, r0, 0, 2);
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L10;
        Room r3 = (Room) r2.getValue();
    L12:
        if (ht2.g.f(r3, 16, true) == false) goto L14;
        ht2.g.c(16, r3, r8);
    L14:
        ((Widget) this).containerView.setFocusable(true);
        r3.c(((Widget) this).contentView, "邀请", true);
        return;
    L10:
        r3 = null;
        goto L12
    }
}
