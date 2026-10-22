package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/LiveEndRemindWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveEndRemindWidget extends LiveRecyclableWidget implements Observer<KVData>, vlc.l {
    public static final /* synthetic */ int d = 0;
    public Disposable a;
    public c9 b;
    public c9 c;

    public static final class a {
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void yq() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
        c9 r1 = this.b;
        if (r1 == null) goto L8;
        wq(r1);
    L8:
        this.b = null;
        c9 r2 = this.c;
        if (r2 == null) goto L11;
        wq(r2);
    L11:
        this.c = null;
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r0 == null) goto L5;
        r0.removeMessageListener(MessageType.REMIND.getIntType(), this);
    L5:
        ((Widget) this).dataCenter.removeObserver(this);
        yq();
    }

    public LiveEndRemindWidget() {
    }

    public static String Aq(Text r2) {
        return sb2.a.h(r2, "", false).toString();
    }

    public static void wq(c9 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final void xq(LiveEndRemindWidget r5) {
        r5.getClass();
        HashMap r6 = new HashMap();
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L9;
        r6.put("room_id", String.valueOf(r2.id));
        r6.put("anchor_id", r2.getOwnerUserIdString());
        LiveMode r3 = r2.getStreamType();
        int r4 = com.bytedance.android.live.core.utils.h1.a;
        r6.put("live_type", com.bytedance.android.live.core.utils.i1.a(r3));
    L9:
        xs2.b r7 = xs2.b.a();
        zg1.h1 r8 = new zg1.h1(49);
        r8.e = r6;
        Unit r9 = Unit.INSTANCE;
        r7.post(r8);
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L13;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-774172322)) goto L9;
        return;
    L9:
        if (r5.equals("cmd_dismiss_dialog_end") == false) goto L12;
        yq();
        return;
    L12:
        return;
    }

    public final void onLoad(Object[] r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        vlc.d r4 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r4 == null) goto L5;
        r4.addMessageListener(MessageType.REMIND.getIntType(), this);
    L5:
        ((Widget) this).dataCenter.observe("cmd_dismiss_dialog_end", this);
    }

    public final void onMessage(tlc.d r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        if ((r18 instanceof kj) == false) goto L58;
        kj r1 = (kj) r18;
        switch(r1.s()) {
            case 12: goto L35;
            case 13: goto L10;
            case 14: goto L10;
            default: goto L59;
        };
    L10:
        int r2 = r1.s();
        yq();
        int r6 = r1.noticeTime;
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        Text r8 = r1.buttonConfirm;
        if (r8 == null) goto L13;
        String r9 = Aq(r8);
    L14:
        r7.element = r9;
        if (r9 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        if (r10 == false) goto L23;
        r7.element = "立即关播";
    L23:
        Context r11 = ((Widget) this).context;
        c9.b r12 = new c9.b();
        r12.a = r11;
        r12.b = 1;
        r12.c = 2131565752;
        r12.d = com.bytedance.android.live.core.utils.s1.m(2131251277);
        r12.p = false;
        r12.q = false;
        r12.e = Aq(r1.noticeTitle);
        r12.f = Aq(r1.E());
        r12.g = 17;
        String r3 = ((String) r7.element) + '(' + r6 + ")s";
        v1 r4 = new v1(this, r2, r1);
        r12.h = r3;
        r12.i = r4;
        c9 r5 = new c9(r12.a, r12);
        this.c = r5;
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r5);
    L29:
        if (13 != r2) goto L31;
        zq("livesdk_anchor_elderly_midnight2_popup_show", null);
    L34:
        this.a = du2.a.e(0, r6, 1000, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).doOnComplete(new w1(this, r2, r1)).subscribe(new x1(this, r7, r6));
        return;
    L31:
        String r13 = r1.eventName;
        if (r13 == null) goto L34;
        zq(r13, null);
        goto L34
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L27:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        goto L29
    L17:
        if (r9.length() == 0) goto L20;
        r10 = false;
        goto L21
    L13:
        r9 = null;
        goto L14
    L35:
        yq();
        Context r14 = ((Widget) this).context;
        c9.b r15 = new c9.b();
        r15.a = r14;
        r15.b = 2;
        r15.c = 2131565753;
        r15.e = Aq(r1.noticeTitle);
        r15.f = Aq(r1.E());
        r15.g = 17;
        r15.p = true;
        r15.q = true;
        Text r16 = r1.buttonCancel;
        if (r16 == null) goto L38;
        String r17 = Aq(r16);
    L39:
        y1 r19 = new y1(this);
        r15.j = r17;
        r15.k = r19;
        Text r20 = r1.buttonConfirm;
        if (r20 == null) goto L42;
        String r21 = Aq(r20);
    L43:
        z1 r22 = new z1(this, r1);
        r15.l = r21;
        r15.m = r22;
        c9 r23 = new c9(r15.a, r15);
        this.b = r23;
        if (DialogLancet.shouldBlockDialogShow(r23) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r23);
    L48:
        zq("livesdk_anchor_elderly_midnight1_popup_show", null);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
    L47:
        DialogLancet.beforeDialogShow(r23);
        r23.show();
        DialogLancet.afterDialogShow(r23);
        goto L48
    L42:
        r21 = null;
        goto L43
    L38:
        r17 = null;
        goto L39
    L59:
        return;
    }

    public static void zq(String r5, String r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L14;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L15;
        HashMap r3 = new HashMap();
        r3.put("anchor_id", r2.getOwnerUserIdString());
        r3.put("room_id", String.valueOf(r2.getRoomId()));
        LiveMode r4 = r2.getStreamType();
        int r7 = com.bytedance.android.live.core.utils.h1.a;
        r3.put("live_type", com.bytedance.android.live.core.utils.i1.a(r4));
        if (r6 == null) goto L11;
        r3.put("action_type", r6);
    L11:
        com.bytedance.android.livesdk.log.u.l().sendLog(r5, r3, new Object[0]);
        return;
    L15:
        return;
    L14:
        return;
    }
}
