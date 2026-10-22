package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.unionlive.anchor.AnchorUnionLiveDataContext;
import com.bytedance.android.livesdk.message.model.om;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/UnionLiveCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UnionLiveCompositeWidget extends MiddlewareRoomWidget implements vlc.l {
    public com.bytedance.android.livesdk.chatroom.widget.unionlive.c a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (this.dataContext == null) goto L12;
        AnchorUnionLiveDataContext r0 = new AnchorUnionLiveDataContext();
        r0.reqAnchorUnionLiveAccess(((Widget) this).dataCenter);
        DataContext r2 = this.dataContext;
        if ((r2 instanceof RoomContext) == true) goto L7;
        r2 = null;
    L7:
        RoomContext r3 = (RoomContext) r2;
        if (r3 == null) goto L12;
        com.bytedance.live.datacontext.j r4 = r3.getAnchorUnionLiveDataContext();
        if (r4 == null) goto L12;
        r4.d(r0);
    L12:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L18;
        vlc.d r5 = (vlc.d) r1.get("data_message_manager", null);
        if (r5 == null) goto L19;
        r5.addMessageListener(MessageType.ROOM_UNION_LIVE_MESSAGE.getWsMethod(), this);
        r5.addMessageListener(MessageType.UNION_LIVE_NOTICE_MESSAGE.getWsMethod(), this);
        return;
    L19:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L9;
        r1.removeMessageListener(this);
        return;
    L9:
        return;
    }

    public UnionLiveCompositeWidget() {
    }

    public final void onMessage(tlc.d r6) {
        if (r6 == null) goto L5;
        String r0 = r6.getMessageMethod();
        if (r0 == null) goto L5;
    L7:
        if (Intrinsics.areEqual(r0, MessageType.ROOM_UNION_LIVE_MESSAGE.getWsMethod()) == false) goto L10;
        int r1 = com.bytedance.android.live.room.utils.c.a;
        com.bytedance.android.live.room.utils.c.a(((Widget) this).dataCenter, r6);
        return;
    L10:
        if (Intrinsics.areEqual(r0, MessageType.UNION_LIVE_NOTICE_MESSAGE.getWsMethod()) == true) goto L12;
        return;
    L12:
        if ((r6 instanceof om) == false) goto L59;
        om r7 = (om) r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = ho1.a.d(getComponentContext());
        if (r2 != null) goto L16;
    L17:
        if (r2 != null) goto L19;
        return;
    L19:
        if (r2.V9() != true) goto L63;
    L21:
        com.bytedance.android.livesdk.chatroom.widget.unionlive.c r3 = this.a;
        FragmentActivity r4 = null;
        if (r3 == null) goto L41;
        Handler r5 = DialogLancet.resolveDialogHandler(r3);
        if (r5 != null) goto L26;
    L28:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L31 Exception -> L33
    L37:
        DialogLancet.afterDialogDismiss(r3);
    L38:
        this.a = null;
        goto L41
    L31:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L33:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L31
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L31
        if (r8 == null) goto L37;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L31
        goto L37
    L26:
        if (Looper.myLooper() == r5.getLooper()) goto L28;
        r5.post(DialogLancet.createDismissRunnable(r3));
    L41:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r9 = ho1.a.d(getComponentContext());
        if (r9 == null) goto L44;
        r4 = r9.p0();
    L44:
        if (r4 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.widget.unionlive.c r10 = new com.bytedance.android.livesdk.chatroom.widget.unionlive.c(r4, r7);
        this.a = r10;
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L49:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L61:
        return;
    L63:
        return;
    L16:
        if (r2.dg() == true) goto L21;
    L59:
        return;
    L5:
        r0 = "";
        goto L7
    }
}
