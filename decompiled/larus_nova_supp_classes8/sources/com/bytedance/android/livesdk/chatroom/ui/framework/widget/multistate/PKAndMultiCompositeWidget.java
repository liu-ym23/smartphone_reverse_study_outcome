package com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate;

import android.view.View;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.f;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.h;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.c40;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import jc1.k;
import jd0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.l3;
import zg1.u1;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/multistate/PKAndMultiCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PKAndMultiCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public static final /* synthetic */ int g = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public float d;
    public boolean e;
    public final CompositeDisposable f;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ PKAndMultiCompositeWidget a;

        public b(PKAndMultiCompositeWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            PKAndMultiCompositeWidget r0 = this.a;
            r0.Lq((RevPkState) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PKAndMultiCompositeWidget a;

        public c(PKAndMultiCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r4 = ((Number) r3).intValue();
            this.a.Cq(v.a(r4, 1));
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ lc0.d a;
        public final /* synthetic */ Observer b;

        public d(lc0.d r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            this.a.c(this.b);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PKAndMultiCompositeWidget a;

        public e(PKAndMultiCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            i r2 = (i) r1;
            MainThreadPostUtils.b(new com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.a(this));
        }
    }

    static {
    }

    public boolean Bq() {
        return false;
    }

    public void Cq(boolean r1) {
    }

    public void Eq(boolean r1) {
    }

    public void Fq(int r1) {
    }

    public void Gq() {
    }

    public void Jq() {
    }

    public void Kq(int r1) {
    }

    public void Lq(RevPkState r2) {
        Intrinsics.checkNotNullParameter(r2, "pkState");
    }

    public void Nq(boolean r1, boolean r2) {
    }

    public void Pq(l3 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void wq(boolean r1) {
    }

    public final boolean Aq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.c;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r0, "$this$isKtvLoaded");
        if (r0.w8(f.c0) != null) goto L7;
        return false;
    L7:
        return true;
    L8:
        return false;
    }

    public final View Ia() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ia();
    }

    public final boolean Nt() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L5;
        LiveMode r1 = r0.getLiveMode();
    L7:
        if (r1 != LiveMode.AUDIO) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final int c9() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c9();
    }

    public final Room getRoom() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return z.o(r0);
    }

    public final boolean hq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.hq();
    }

    public final View yq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r7();
    }

    public PKAndMultiCompositeWidget() {
        this.f = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        this.c = ho1.a.c(getComponentContext());
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.observe("cmd_interact_audio", this);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.observe("data_is_score_open", this);
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L11;
        r2.observeForever("cmd_pk_state_change", this);
    L11:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L14;
        r3.observeForever("cmd_multi_state_change", this);
    L14:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L17;
        r4.observeForever("cmd_video_talkroom_state_change", this);
    L17:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L20;
        r5.observeForever("cmd_equal_talkroom_state_change", this);
    L20:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L23;
        r6.observe("cmd_enter_room_multil_link_room_mode_sysnc", this);
    L23:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L27;
        r7.observe("data_link_state", this);
    L27:
        if (((Boolean) c40.a.getValue()).booleanValue() == false) goto L35;
        IKtvService r8 = k.f(IKtvService.class);
        if (r8 == null) goto L35;
        Observable r9 = r8.getKtvAllStateObservable();
        if (r9 == null) goto L35;
        Disposable r10 = r9.subscribe(new c(this));
        if (r10 == null) goto L35;
        RxUtilKt.c(r10, this.f);
    L35:
        ILinkServiceExternal r11 = k.f(ILinkServiceExternal.class);
        if (r11 == null) goto L40;
        lc0.d r12 = r11.getPkServiceExternal();
        if (r12 == null) goto L40;
        b r13 = new b(this);
        r12.a(r13);
        this.f.add(Disposables.fromAction(new d(r12, r13)));
    L40:
        MiddlewareRoomContext r14 = getMiddlewareRoomContext();
        if ((r14 instanceof RoomContext) == true) goto L43;
        r14 = null;
    L43:
        RoomContext r15 = (RoomContext) r14;
        if (r15 == null) goto L54;
        j r16 = r15.getVoiceTalkRoomSubScene();
        if (r16 == null) goto L54;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r16.getValue();
        if (r17 == null) goto L54;
        BehaviorSubject r18 = r17.a();
        if (r18 == null) goto L54;
        Disposable r19 = r18.subscribe(new e(this));
        if (r19 == null) goto L54;
        RxUtilKt.c(r19, this.f);
    L54:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r20 = this.c;
        if (r20 == null) goto L62;
        PropertyOwner r21 = r20.getLoadState();
        if (r21 == null) goto L63;
        Disposable r22 = com.bytedance.android.livesdk.chatroom.ui.framework.b.e(r21, new AnonymousClass4(this));
        if (r22 == null) goto L64;
        RxUtilKt.c(r22, this.f);
        return;
    L64:
        return;
    L63:
        return;
    }

    public void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.f.dispose();
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public final q xq() {
        h70.b r0 = getComponentContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ho1.a.f(r0);
    }

    public final yh0.c zq() {
        h70.b r0 = getComponentContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ho1.a.m(r0);
    }

    public void Iq(u1 r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (hq() == true) goto L5;
        return;
    L5:
        Room r0 = getRoom();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = r6.f;
        boolean r3 = false;
        if (r1 != 1) goto L27;
        if (r0.isLiveTypeAudio() == false) goto L18;
        View r2 = Ia();
        if (r2 == null) goto L15;
        r2.setVisibility(8);
    L15:
        yh0.c r4 = zq();
        if (r4 == null) goto L18;
        r4.F4(false);
    L18:
        Jq();
        q r5 = xq();
        if (r5 == null) goto L40;
        Integer r7 = Integer.valueOf(r6.h);
        Integer r8 = Integer.valueOf(r6.g);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r9 = this.a;
        if (r9 != null) goto L23;
    L25:
        r5.N9(true, r7, r8, Boolean.valueOf(r3));
        return;
    L23:
        if (r9.dg() != true) goto L25;
        r3 = true;
        goto L25
    L40:
        return;
    L27:
        if (r1 == 2) goto L29;
        return;
    L29:
        if (r0.isLiveTypeAudio() == false) goto L36;
        View r10 = Ia();
        if (r10 == null) goto L33;
        r10.setVisibility(0);
    L33:
        yh0.c r11 = zq();
        if (r11 == null) goto L36;
        r11.F4(true);
    L36:
        Gq();
        q r12 = xq();
        if (r12 == null) goto L43;
        r12.N9(false, null, null, null);
        return;
    }

    public void Mq(z0 r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (hq() == true) goto L5;
        return;
    L5:
        Room r0 = getRoom();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = r6.a;
        boolean r3 = false;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L49;
        Object r7 = r6.b;
        if ((r7 instanceof Boolean) == false) goto L36;
        if (r7 == null) goto L34;
        if (((Boolean) r7).booleanValue() == false) goto L36;
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L36:
        if (r0.isLiveTypeAudio() == false) goto L43;
        View r8 = Ia();
        if (r8 == null) goto L40;
        r8.setVisibility(0);
    L40:
        yh0.c r9 = zq();
        if (r9 == null) goto L43;
        r9.F4(true);
    L43:
        q r10 = xq();
        if (r10 == null) goto L50;
        r10.jp(false, null, null, null);
        return;
    L50:
        return;
    L49:
        return;
    L11:
        if (r0.isLiveTypeAudio() == false) goto L18;
        View r11 = Ia();
        if (r11 == null) goto L15;
        r11.setVisibility(8);
    L15:
        yh0.c r12 = zq();
        if (r12 == null) goto L18;
        r12.F4(false);
    L18:
        ILinkServiceExternal r13 = k.f(ILinkServiceExternal.class);
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getPkServiceExternal().G().a;
        ILinkServiceExternal r2 = k.f(ILinkServiceExternal.class);
        Intrinsics.checkNotNull(r2);
        int r4 = r2.getPkServiceExternal().G().c + r14;
        q r5 = xq();
        if (r5 == null) goto L47;
        Integer r15 = Integer.valueOf(r14);
        Integer r16 = Integer.valueOf(r4);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r17 = this.a;
        if (r17 != null) goto L23;
    L25:
        r5.jp(true, r15, r16, Boolean.valueOf(r3));
        return;
    L23:
        if (r17.dg() != true) goto L25;
        r3 = true;
        goto L25
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L119;
        boolean r1 = true;
        if (r0.hq() != true) goto L143;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = false;
        boolean r8 = false;
        if (r2 != null) goto L10;
    L12:
        boolean r9 = false;
    L13:
        String r10 = null;
        if (r9 == false) goto L24;
        StringBuilder r11 = new StringBuilder("key:");
        if (r7 == null) goto L18;
        String r12 = r7.getKey();
    L19:
        r11.append(r12);
        r11.append("---top:");
        View r13 = yq();
        if (r13 == null) goto L22;
        Integer r14 = Integer.valueOf(r13.getTop());
    L23:
        r11.append(r14);
        ALogger.i("fragment_onChanged", r11.toString());
        goto L24
    L22:
        r14 = null;
        goto L23
    L18:
        r12 = null;
    L24:
        if (r7 == null) goto L26;
        r10 = r7.getKey();
    L26:
        if (r10 != null) goto L29;
        return;
    L29:
        switch(r10.hashCode()) {
            case -1540323875: goto L85;
            case -1470664839: goto L80;
            case -1091008631: goto L74;
            case -1073136005: goto L67;
            case -271145422: goto L61;
            case -261927283: goto L55;
            case 139872040: goto L52;
            case 694542470: goto L49;
            case 791939802: goto L43;
            case 872172481: goto L38;
            case 1420969527: goto L32;
            default: goto L145;
        };
    L145:
        return;
    L32:
        if (r10.equals("data_is_score_open") == false) goto L120;
        Boolean r15 = (Boolean) r7.getData();
        if (r15 == null) goto L36;
        r4 = r15.booleanValue();
    L36:
        Eq(r4);
        return;
    L120:
        return;
    L38:
        if (r10.equals("data_link_state") == false) goto L122;
        Integer r16 = (Integer) r7.getData();
        if (r16 == null) goto L123;
        Fq(r16.intValue());
        return;
    L123:
        return;
    L122:
        return;
    L43:
        if (r10.equals("data_self_is_silenced") == false) goto L125;
        Boolean r17 = (Boolean) r7.getData();
        if (r17 == null) goto L47;
        r5 = r17.booleanValue();
    L47:
        Nq(!r5, true);
        return;
    L125:
        return;
    L49:
        if (r10.equals("cmd_equal_talkroom_state_change") == false) goto L127;
        h.a(((Widget) this).dataCenter, "CMD_LINK_EQUAL_TALK_ROOM_STATE_CHANGE");
        return;
    L127:
        return;
    L52:
        if (r10.equals("DATA_DISCONNECT_LINK") == false) goto L129;
        Nq(false, false);
        return;
    L129:
        return;
    L55:
        if (r10.equals("cmd_video_talkroom_state_change") == false) goto L131;
        l3 r18 = (l3) r7.getData();
        if (r18 == null) goto L146;
        h.b(((Widget) this).dataCenter, "CMD_LINK_MULTI_ROOM_STATE_CHANGE");
        Pq(r18);
        xs2.b.a().post(new zg1.h("VideoTalkRoom", String.valueOf(r18.a)));
        return;
    L146:
        return;
    L131:
        return;
    L61:
        if (r10.equals("cmd_interact_audio") == false) goto L133;
        g r19 = (g) r7.getData();
        if (r19 == null) goto L65;
        r8 = r19.a;
    L65:
        h.a(((Widget) this).dataCenter, "ForVoiceChat");
        wq(r8);
        return;
    L133:
        return;
    L67:
        if (r10.equals("data_talk_room_capture_audio_notification_show_state") == false) goto L135;
        Boolean r20 = (Boolean) r7.getData();
        if (r20 == null) goto L71;
        boolean r21 = r20.booleanValue();
    L72:
        Nq(r21, false);
        return;
    L71:
        r21 = false;
        goto L72
    L135:
        return;
    L74:
        if (r10.equals("cmd_multi_state_change") == false) goto L137;
        u1 r22 = (u1) r7.getData();
        if (r22 == null) goto L147;
        h.b(((Widget) this).dataCenter, "CMD_LINK_MULTI_ROOM_STATE_CHANGE");
        Iq(r22);
        xs2.b.a().post(new zg1.h("MultiAnchor", String.valueOf(r22.f)));
        return;
    L147:
        return;
    L137:
        return;
    L80:
        if (r10.equals("cmd_enter_room_multil_link_room_mode_sysnc") == false) goto L139;
        Integer r23 = (Integer) r7.getData();
        if (r23 == null) goto L140;
        Kq(r23.intValue());
        return;
    L140:
        return;
    L139:
        return;
    L85:
        if (r10.equals("cmd_pk_state_change") == false) goto L142;
        z0 r24 = (z0) r7.getData();
        if (r24 == null) goto L148;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r25 = this.a;
        if (r25 != null) goto L92;
    L93:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r26 = this.a;
        if (r26 != null) goto L96;
    L98:
        boolean r27 = false;
    L99:
        if (r27 == true) goto L101;
    L117:
        Mq(r24);
        h.b(((Widget) this).dataCenter, "CMD_LINK_CROSS_ROOM_STATE_CHANGE");
        xs2.b.a().post(new zg1.h("LinkCrossRoom", String.valueOf(r24.a)));
        return;
    L101:
        if (hq() == false) goto L117;
        Room r28 = getRoom();
        if (r28 != null) goto L107;
    L111:
        r1 = false;
    L112:
        if (r1 == true) goto L117;
        DataCenter r29 = ((Widget) this).dataCenter;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r30 = this.b;
        if (r30 == null) goto L116;
        r3 = r30.En();
    L116:
        Bq();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.a(r29, r24, r3);
        goto L117
    L107:
        if (r28.getLinkMap() == null) goto L111;
        if (r28.getLinkMap().containsKey(String.valueOf(1)) == false) goto L111;
    L96:
        if (r26.V9() != true) goto L98;
    L97:
        r27 = true;
        goto L99
    L92:
        if (r25.dg() == true) goto L97;
    L148:
        return;
    L142:
        return;
    L10:
        if (r2.dg() != true) goto L12;
        r9 = true;
        goto L13
    L143:
        return;
    }
}
