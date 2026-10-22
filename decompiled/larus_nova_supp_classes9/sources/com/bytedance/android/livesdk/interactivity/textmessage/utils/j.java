package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ec2.n;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Action {
        public final /* synthetic */ vlc.d a;
        public final /* synthetic */ String b;
        public final /* synthetic */ l c;

        public a(vlc.d r1, String r2, l r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            this.a.removeMessageListener(this.b, this.c);
        }
    }

    static {
    }

    @JvmStatic
    public static final vlc.d b(DataCenter r4) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        o r5 = IRoomContextService.a.a(r0, r4, 0, 2);
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.j r6 = r5.getMessageManager();
        if (r6 == null) goto L9;
        return (vlc.d) r6.getValue();
    L9:
        return null;
    }

    @CheckReturnValue
    public static Disposable c(vlc.d r1, String r2, l r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$listenMessage");
        Intrinsics.checkNotNullParameter(r2, "messageMethod");
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.addMessageListener(r2, r3);
        return Disposables.fromAction(new a(r1, r2, r3));
    }

    public static c4 a(long r7, boolean r9, boolean r10, IRoom r11) {
        int r0 = com.bytedance.android.livesdk.interactivity.service.model.e.a;
        boolean r1 = false;
        String r3 = null;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().chatAuthTip == false) goto L27;
        if (r11 == null) goto L19;
        IRoomAuthStatus r13 = r11.getRoomAuthStatus();
        if (r13 == null) goto L19;
        IRoomAuthStatus.IRoomAuthSpecialStyle r14 = r13.getRoomAuthSpecialStyle();
        if (r14 == null) goto L19;
        IRoomAuthStatusStyle r15 = r14.getChatStyle();
        if (r15 == null) goto L19;
        String r16 = r15.getSwitchStatusTipMsg();
        if (r16 == null) goto L19;
        if (r16.length() <= 0) goto L16;
        r1 = true;
    L16:
        if (r1 == false) goto L18;
        r3 = r16;
    L18:
        if (r3 == null) goto L19;
    L80:
        c4 r17 = vh7.f.c(c4.class);
        r17.setMessageMethod("WebcastRoomMessage");
        m0 r18 = vh7.f.c(m0.class);
        r18.setRoomId(r7);
        r18.setShowMsg(true);
        r18.setMethod("WebcastRoomMessage");
        r17.setBaseMessage(r18);
        r17.setContent(r3);
        r17.setSystemTopMsg(true);
        return r17;
    L19:
        if (r9 == false) goto L23;
        String r19 = s1.B(2131919967);
        if (r19 == null) goto L78;
    L26:
        r3 = r19;
    L78:
        r3 = BuildConfig.FLAVOR;
        goto L80
    L23:
        r19 = s1.B(2131919965);
        if (r19 != null) goto L26;
    L27:
        o72.a r2 = (o72.a) n.a.getValue();
        if (r9 == false) goto L32;
        if (r10 == false) goto L31;
        String r4 = r2.b();
    L35:
        if (r4 != null) goto L37;
    L40:
        boolean r6 = true;
    L41:
        if (r6 == false) goto L50;
        if (r9 == false) goto L47;
        if (r10 == false) goto L46;
        r4 = s1.B(2131919967);
        goto L50
    L46:
        r4 = s1.B(2131919966);
        goto L50
    L47:
        if (r10 == false) goto L49;
        r4 = s1.B(2131919965);
        goto L50
    L49:
        r4 = s1.B(2131919964);
    L50:
        if (r11 == null) goto L56;
        IRoomAuthStatus r20 = r11.getRoomAuthStatus();
        if (r20 == null) goto L56;
        IRoomAuthStatus.IRoomAuthSpecialStyle r21 = r20.getRoomAuthSpecialStyle();
        if (r21 == null) goto L56;
        r3 = r21.getChatStyle();
    L56:
        if (r3 == null) goto L79;
        if (r10 == false) goto L70;
        String r23 = r3.getSwitchStatusAnchorTipMsg();
        if (r23 != null) goto L62;
    L65:
        boolean r24 = true;
    L66:
        if (r24 == true) goto L70;
        r19 = r3.getSwitchStatusAnchorTipMsg();
        if (r19 != null) goto L26;
    L62:
        if (r23.length() == 0) goto L65;
        r24 = false;
    L70:
        String r25 = r3.getSwitchStatusTipMsg();
        if (r25 != null) goto L73;
    L74:
        r1 = true;
    L75:
        if (r1 == true) goto L79;
        r19 = r3.getSwitchStatusTipMsg();
        if (r19 != null) goto L26;
    L73:
        if (r25.length() != 0) goto L75;
    L79:
        r3 = r4;
        goto L80
    L37:
        if (r4.length() == 0) goto L40;
        r6 = false;
        goto L41
    L31:
        r4 = r2.d();
        goto L35
    L32:
        if (r10 == false) goto L34;
        r4 = r2.a();
        goto L35
    L34:
        r4 = r2.c();
        goto L35
    }
}
