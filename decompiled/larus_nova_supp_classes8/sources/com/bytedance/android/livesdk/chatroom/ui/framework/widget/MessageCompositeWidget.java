package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Looper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.dl0;
import com.bytedance.android.livesdk.config.j80;
import com.bytedance.android.livesdk.config.u80;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.message.model.c2;
import com.bytedance.android.livesdk.message.model.hj;
import com.bytedance.android.livesdk.message.model.r4;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework.LiveInteractionFrameworkOptHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/MessageCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MessageCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData>, vlc.l {
    public static final /* synthetic */ int d = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a b;
    public final CompositeDisposable c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MessageCompositeWidget a;

        public b(MessageCompositeWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageCompositeWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MessageCompositeWidget.d;     // Catch: Throwable -> L4
            r0.xq("anchor_start_fetch_message");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MessageCompositeWidget a;

        public c(MessageCompositeWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageCompositeWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MessageCompositeWidget.d;     // Catch: Throwable -> L4
            r0.xq("anchor_start_fetch_message");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MessageCompositeWidget a;

        public d(MessageCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.chatroom.ui.framework.o r3 = (com.bytedance.android.livesdk.chatroom.ui.framework.o) ((h80.c) r2).a();
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.b == true) goto L11;
            MessageCompositeWidget r4 = this.a;
            int r0 = MessageCompositeWidget.d;
            vlc.d r5 = n3.e(((Widget) r4).dataCenter);
            if (r5 == null) goto L12;
            r5.r(false);
            return;
        L12:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MessageCompositeWidget a;

        public e(MessageCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((h80.c) r2).a() == null) goto L6;
            MessageCompositeWidget r3 = this.a;
            int r0 = MessageCompositeWidget.d;
            r3.xq("widget_reload_fetch_message");
            return;
        }
    }

    static {
    }

    public MessageCompositeWidget() {
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.c(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.dg();
    L6:
        if (r1 == false) goto L10;
        MainThreadPostUtils.b(new b(this));
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.u) b4.a.getValue()).e() == false) goto L26;
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_msg", "register BroadcastRtcRoomMessageEvent");
        RxUtilKt.c(xs2.b.a().b(dh1.b.class).subscribe(new i0(this)), this.c);
    L26:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L29;
        r2.observeForever("cmd_widget_loaded", this);
    L29:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L32;
        r3.observeForever("cmd_text_message_widget_loaded", this);
    L32:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L35;
        r4.observe("data_restart_message", this);
    L35:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L38;
        r5.observe("data_stop_message", this);
    L38:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r6 = this.b;
        if (r6 == null) goto L45;
        PropertyOwner r7 = r6.i8();
        if (r7 == null) goto L45;
        Disposable r8 = r7.subscribe(new d(this));
        if (r8 == null) goto L45;
        RxUtilKt.c(r8, this.c);
    L45:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r9 = this.b;
        if (r9 == null) goto L52;
        PropertyOwner r10 = r9.Na();
        if (r10 == null) goto L52;
        Disposable r11 = r10.subscribe(new e(this));
        if (r11 == null) goto L52;
        RxUtilKt.c(r11, this.c);
    L52:
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L58;
        vlc.d r13 = (vlc.d) r12.get("data_message_manager", null);
        if (r13 == null) goto L59;
        r13.addMessageListener(MessageType.DOU_PLUS_MESSAGE.getIntType(), this);
        r13.addMessageListener(MessageType.FRATERNITY_MESSAGE.getIntType(), this);
        r13.addMessageListener(MessageType.RECOMMEND_USER_MESSAGE.getIntType(), this);
        r13.addMessageListener(MessageType.CEREMONY_MESSAGE.getIntType(), this);
        return;
    L59:
        return;
    L58:
        return;
    L10:
        int r14 = LiveInteractionFrameworkOptHelper.INSTANCE.audienceMessageFetchType();
        if (r14 != 0) goto L13;
        runWithRoomEntered(new AnonymousClass2(this));
        goto L26
    L13:
        if (r14 != 1) goto L15;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r15 = this.b;
        if (r15 == null) goto L26;
        PropertyOwner r16 = r15.getLoadState();
        if (r16 == null) goto L26;
        Disposable r17 = com.bytedance.android.livesdk.chatroom.ui.framework.b.a(r16, new AnonymousClass3(this));
        if (r17 == null) goto L26;
        RxUtilKt.c(r17, this.c);
        goto L26
    L15:
        if (r14 != 2) goto L26;
        MainThreadPostUtils.b(new c(this));
        goto L26
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.c.dispose();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L10;
        vlc.d r2 = (vlc.d) r1.get("data_message_manager", null);
        if (r2 == null) goto L10;
        r2.removeMessageListener(this);
    L10:
        this.a = null;
        this.b = null;
        wq();
    }

    public final void wq() {
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n r1 = r0.getRtcRoomMessageManager();
        vlc.d r2 = (vlc.d) r1.getValue();
        if (r2 == null) goto L7;
        r2.release();
    L7:
        r1.setValue(null);
        r0.getRtcRoomInfo().setValue(null);
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L55;
        if (r5 == null) goto L9;
        String r1 = r5.getKey();
    L10:
        if (r1 == null) goto L56;
        boolean r2 = false;
        switch(r1.hashCode()) {
            case -1836833765: goto L34;
            case -1446414526: goto L28;
            case 1164331839: goto L23;
            case 1267773627: goto L16;
            default: goto L57;
        };
    L57:
        return;
    L16:
        if (r1.equals("cmd_text_message_widget_loaded") == false) goto L44;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r6 = this.a;
        if (r6 == null) goto L20;
        r2 = r6.dg();
    L20:
        if (r2 == false) goto L45;
        d4.n(n3.e(((Widget) this).dataCenter));
        return;
    L45:
        return;
    L44:
        return;
    L23:
        if (r1.equals("data_stop_message") == false) goto L47;
        vlc.d r7 = n3.e(((Widget) this).dataCenter);
        if (r7 == null) goto L48;
        r7.r(false);
        return;
    L48:
        return;
    L47:
        return;
    L28:
        if (r1.equals("data_restart_message") == false) goto L50;
        vlc.d r8 = n3.e(((Widget) this).dataCenter);
        if (r8 == null) goto L32;
        r8.r(false);
    L32:
        xq("restart_event_fetch_message");
        return;
    L50:
        return;
    L34:
        if (r1.equals("cmd_widget_loaded") == true) goto L36;
        return;
    L36:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r5) == false) goto L53;
        xq("widget_loaded_fetch_message");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r9 = this.a;
        if (r9 == null) goto L40;
        r2 = r9.dg();
    L40:
        if (r2 == false) goto L54;
        d4.n(n3.e(((Widget) this).dataCenter));
        return;
    L54:
        return;
    L53:
        return;
    L56:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof com.bytedance.android.livesdk.message.model.b4) == false) goto L8;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L17;
        r0.put("data_dou_plus_promote_message", r3);
        return;
    L17:
        return;
    L8:
        if ((r3 instanceof r4) == false) goto L11;
        ((Widget) this).dataCenter.put("data_hs_fraternity_bubble", r3);
        return;
    L11:
        if ((r3 instanceof hj) == false) goto L14;
        ((Widget) this).dataCenter.put("data_d_live_message", r3);
        return;
    L14:
        if ((r3 instanceof c2) == false) goto L21;
        ((Widget) this).dataCenter.put("data_d_live_message", r3);
        return;
    }

    public final void xq(String r12) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 != null) goto L5;
    L102:
        PublicScreenTraceMonitor.l(r12.concat(":startMessage fail, container is not valid"), System.currentTimeMillis());
        return;
    L5:
        if (r2.hq() != true) goto L102;
        vlc.d r3 = n3.e(((Widget) this).dataCenter);
        if (r3 != null) goto L11;
        PublicScreenTraceMonitor.l(r12.concat(":startMessage fail, messageManager is not null"), System.currentTimeMillis());
        return;
    L11:
        DataCenter r4 = ((Widget) this).dataCenter;
        com.bytedance.android.livesdk.log.filter.z r5 = null;
        if (r4 == null) goto L14;
        Room r6 = com.bytedance.android.live.core.utils.z.o(r4);
    L15:
        if (r6 != null) goto L18;
        PublicScreenTraceMonitor.l(r12.concat(":startMessage fail, room is not null"), System.currentTimeMillis());
        return;
    L18:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.b("MessageCompositeWidget, fetch message for ".concat(r12));
    L94:
        e = move-exception;
        PublicScreenTraceMonitor.l(r12 + ":startMessage error," + e, System.currentTimeMillis());
        IHostContext r13 = jc1.k.f(IHostContext.class);
        if (r13 != null) goto L98;
        return;
    L98:
        if (r13.isLocalTest() != true) goto L107;
        throw e;
    L107:
        return;
    L20:
        if (pm1.f.r() == null) goto L26;
        nm1.y r7 = pm1.f.r();     // Catch: Exception -> L94
        if (r7 == null) goto L26;
        r7.g();     // Catch: Exception -> L94
        vp1.e.a.a(r3, ((Widget) this).dataCenter);     // Catch: Exception -> L94
    L26:
        HashMap r8 = new HashMap();     // Catch: Exception -> L94
        boolean r9 = false;
        if (((Boolean) dl0.a.getValue()).booleanValue() == true) goto L31;
        if (PublicScreenABHelper.P == true) goto L31;
    L43:
        if (j80.a.getValue().booleanValue() == false) goto L86;
        com.bytedance.android.livesdk.log.filter.n0 r10 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);     // Catch: Exception -> L94
        String r11 = "";
        if (r10 != null) goto L49;
    L66:
        com.bytedance.android.livesdk.log.filter.z r14 = com.bytedance.android.livesdk.log.u.l().c(am2.n.class);     // Catch: Exception -> L94
        if (r14 == null) goto L86;
        if ((r14 instanceof com.bytedance.android.livesdk.log.filter.z) == false) goto L76;
        Map r15 = ((com.bytedance.android.livesdk.log.filter.a) r14).b;     // Catch: Exception -> L94
        if (r15 == null) goto L76;
        if (r15.containsKey("is_other_channel") != true) goto L76;
        r9 = true;
    L76:
        if (r9 == false) goto L78;
        r5 = r14;
    L78:
        if (r5 == null) goto L86;
        Map r16 = r5.getMap();     // Catch: Exception -> L94
        if (r16 == null) goto L85;
        String r17 = (String) r16.get("is_other_channel");     // Catch: Exception -> L94
        if (r17 == null) goto L85;
        r11 = r17;
    L85:
        String r18 = (String) r8.put("is_other_channel", r11);     // Catch: Exception -> L94
        goto L86
    L49:
        if ((r10 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L55;
        Map r19 = ((com.bytedance.android.livesdk.log.filter.a) r10).b;     // Catch: Exception -> L94
        if (r19 == null) goto L55;
        if (r19.containsKey("enter_from_merge") != true) goto L55;
        boolean r20 = true;
    L56:
        if (r20 == true) goto L59;
        r10 = null;
    L59:
        if (r10 == null) goto L66;
        Map r21 = r10.getMap();     // Catch: Exception -> L94
        if (r21 == null) goto L64;
        String r22 = (String) r21.get("enter_from_merge");     // Catch: Exception -> L94
        if (r22 == null) goto L64;
    L65:
        String r23 = (String) r8.put("enter_from_merge", r22);     // Catch: Exception -> L94
    L64:
        r22 = "";
    L55:
        r20 = false;
    L86:
        d4.j(r3, r8);     // Catch: Exception -> L94
        r3.startMessage();     // Catch: Exception -> L94
        PublicScreenTraceMonitor.l(r12.concat(":startMessage"), System.currentTimeMillis());     // Catch: Exception -> L94
        Integer r0 = u80.a.getValue();     // Catch: Exception -> L94
        if (r0 != null) goto L90;
    L92:
        boolean r1 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());     // Catch: Exception -> L94
        String r24 = ThreadMethodProxy.currentThread().getName();     // Catch: Exception -> L94
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Exception -> L94
        com.bytedance.android.live.core.log.g.a("ttlive_msg", "start query message, isMain=" + r1 + ", name=" + r24);     // Catch: Exception -> L94
        return;
    L90:
        if (r0.intValue() != 0) goto L92;
        d4.n(n3.e(((Widget) this).dataCenter));     // Catch: Exception -> L94
    L31:
        if (r6.isMediaRoom() == true) goto L43;
        if (r6.isMergeVSRoom() == true) goto L43;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r25 = this.a;     // Catch: Exception -> L94
        if (r25 == null) goto L37;
        boolean r26 = r25.dg();     // Catch: Exception -> L94
    L38:
        if (r26 == true) goto L43;
        if (((int) r6.getRoomLayout()) == 2) goto L43;
        r8.put("skip_first_fetch", "1");     // Catch: Exception -> L94
        goto L43
    L37:
        r26 = false;
        goto L38
    L14:
        r6 = null;
        goto L15
    }
}
