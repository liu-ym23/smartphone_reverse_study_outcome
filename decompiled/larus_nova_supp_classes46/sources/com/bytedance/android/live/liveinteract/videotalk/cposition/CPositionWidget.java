package com.bytedance.android.live.liveinteract.videotalk.cposition;

import android.content.Context;
import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.live.base.model.message.d6;
import com.bytedance.android.live.base.model.message.f6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.g;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rj0.k;
import tf0.o;
import vh7.f;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/cposition/CPositionWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CPositionWidget extends MiddlewareRoomWidget implements l {
    public d a;
    public CPositionContext b;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.c c;
    public final CompositeDisposable d;
    public boolean e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CPositionWidget a;

        public b(CPositionWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            p2 r6 = ((k1) ((e) r5).data).getLinkmicPlayModeInfo();
            if (r6 == null) goto L20;
            EnlargeGuestInfo r7 = r6.getEnlargeGuestInfo();
            if (r7 != null) goto L7;
            return;
        L7:
            if (r7.getEnlargeGuestType() == EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal()) goto L9;
            boolean r0 = true;
        L10:
            CPositionContext r1 = this.a.b;
            if (r1 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
        L13:
            r1.isCPositionOpen().setValue(Boolean.valueOf(r0));
            CPositionContext r2 = this.a.b;
            if (r2 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
        L16:
            r2.getEnlargeGuestInfo().setValue(r7);
            com.bytedance.android.live.liveinteract.plantform.datamerge.handler.c r3 = this.a.c;
            if (r3 == null) goto L22;
            r3.d(r0, r7);
            return;
        L22:
            return;
        L9:
            r0 = false;
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CPositionWidget a;

        public c(CPositionWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = ((Widget) this.a).context;
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    static {
    }

    public final o xq() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L6;
        o r1 = r0.windowManager();
        if (r1 == null) goto L6;
        return r1;
    L6:
        k.m2.getClass();
        k r2 = k.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.windowManager();
    }

    public CPositionWidget() {
        this.d = new CompositeDisposable();
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(CPositionWidget$initDataContext$pair$1.INSTANCE);
        CPositionContext r1 = (CPositionContext) r0.getFirst();
        com.bytedance.live.datacontext.b.a(r1, CPositionContext.class);
        this.b = r1;
        this.d.add((Disposable) r0.getSecond());
        Objects.toString(CPositionContext.Companion.getContext());
        boolean r2 = false;
        if (g.a(0) == true) goto L8;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r3 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r3 == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.c r4 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.c();
        this.c = r4;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r3, "proxy");
        r4.a = r3;
        r3.M0(r4);
    L8:
        List r5 = null;
        d r6 = (d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.a = r6;
        if (r6 == null) goto L11;
        r6.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getKey(), this);
    L11:
        m r7 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r7 == null) goto L37;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L37;
        z5 r9 = r8.getLinkerDetail();
        if (r9 == null) goto L22;
        List r10 = r9.getPlayModes();
        if (r10 == null) goto L22;
        if (r10.contains(Long.valueOf(13)) != true) goto L22;
        boolean r11 = true;
    L23:
        CPositionContext r12 = this.b;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L26:
        r12.isCPositionOpen().setValue(Boolean.valueOf(r11));
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.c r13 = this.c;
        if (r13 == null) goto L29;
        r13.d(r11, null);
    L29:
        CPositionContext r14 = this.b;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L33:
        if (((Boolean) r14.isCPositionOpen().getValue()).booleanValue() == false) goto L37;
        o r15 = xq();
        if (r15 == null) goto L37;
        r15.m(13);
    L22:
        r11 = false;
    L37:
        m r16 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r16 == null) goto L55;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L55;
        z5 r18 = r17.getLinkerDetail();
        if (r18 == null) goto L44;
        r5 = r18.getPlayModes();
    L44:
        if (r5 != null) goto L46;
    L48:
        if (r2 == true) goto L53;
        z5 r19 = r17.getLinkerDetail();
        if (r19 == null) goto L55;
        if (r19.getUiLayout() != 28) goto L55;
    L53:
        wq(r17.getId());
        goto L55
    L46:
        if (r5.contains(13L) == false) goto L48;
        r2 = true;
    L55:
        if (je0.d.r() == false) goto L68;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r20 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r20 == null) goto L65;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r21 = r20.N0();
        if (r21 == null) goto L66;
        Disposable r22 = r21.subscribe(new com.bytedance.android.live.liveinteract.videotalk.cposition.a(this));
        if (r22 == null) goto L67;
        this.d.add(r22);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        if (g.a(0) == true) goto L10;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.c r1 = this.c;
        if (r1 == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r2 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r2 == null) goto L10;
        r2.d1(r1);
    L10:
        d r3 = this.a;
        if (r3 == null) goto L13;
        r3.removeMessageListener(this);
    L13:
        this.d.clear();
        this.e = false;
    }

    public final void onMessage(tlc.d r8) {
        if ((r8 instanceof ILinkmicEnlargeGuestMessage) == false) goto L69;
        ILinkmicEnlargeGuestMessage r9 = (ILinkmicEnlargeGuestMessage) r8;
        int r0 = r9.getMsg_type();
        Integer r4 = null;
        if (r0 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOn.ordinal()) goto L38;
        CPositionContext r1 = this.b;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L9:
        r1.isCPositionOpen().setValue(Boolean.TRUE);
        f6 r2 = r9.getTurn_on_content();
        if (r2 == null) goto L17;
        EnlargeGuestInfo r3 = r2.getEnlargeGuestInfo();
        if (r3 == null) goto L17;
        CPositionContext r5 = this.b;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L16:
        r5.getEnlargeGuestInfo().setValue(r3);
    L17:
        long r6 = r9.getMessageId();
        f6 r7 = r9.getTurn_on_content();
        if (r7 == null) goto L22;
        EnlargeGuestInfo r10 = r7.getEnlargeGuestInfo();
        if (r10 == null) goto L22;
        r4 = Integer.valueOf(r10.getEnlargeGuestType());
    L22:
        yq(r6, "turn_on", r4);
        o r11 = xq();
        if (r11 == null) goto L25;
        r11.m(13);
    L25:
        long r12 = r9.getMessageId();
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 != null) goto L28;
    L36:
        zq(true);
        return;
    L28:
        if (a0.d(r13, false) != true) goto L36;
        m r14 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r14 == null) goto L36;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L36;
        if (r15.isLiveTypeAudio() != true) goto L36;
        TalkRoomBusinessFullLinkMonitor r16 = TalkRoomBusinessFullLinkMonitor.a;
        JSONObject r17 = new JSONObject();
        r16.getClass();
        TalkRoomBusinessFullLinkMonitor.a(r12, r17);
        goto L36
    L38:
        if (r0 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_ChangeUser.ordinal()) goto L57;
        CPositionContext r18 = this.b;
        if (r18 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L42:
        r18.isCPositionOpen().setValue(Boolean.TRUE);
        d6 r19 = r9.getChange_user_content();
        if (r19 == null) goto L50;
        EnlargeGuestInfo r20 = r19.getEnlargeGuestInfo();
        if (r20 == null) goto L50;
        CPositionContext r21 = this.b;
        if (r21 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L49:
        r21.getEnlargeGuestInfo().setValue(r20);
    L50:
        long r22 = r9.getMessageId();
        d6 r23 = r9.getChange_user_content();
        if (r23 == null) goto L55;
        EnlargeGuestInfo r24 = r23.getEnlargeGuestInfo();
        if (r24 == null) goto L55;
        r4 = Integer.valueOf(r24.getEnlargeGuestType());
    L55:
        yq(r22, "change_user", r4);
        return;
    L57:
        if (r0 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOff.ordinal()) goto L72;
        CPositionContext r25 = this.b;
        if (r25 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L61:
        r25.isCPositionOpen().setValue(Boolean.FALSE);
        CPositionContext r26 = this.b;
        if (r26 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L64:
        m<EnlargeGuestInfo> r27 = r26.getEnlargeGuestInfo();
        EnlargeGuestInfo r28 = f.c(EnlargeGuestInfo.class);
        EnlargeGuestInfo.EnlargeGuestType r29 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown;
        r28.setEnlargeGuestType(r29.ordinal());
        Unit r30 = Unit.INSTANCE;
        r27.setValue(r28);
        yq(r9.getMessageId(), "turn_off", Integer.valueOf(r29.ordinal()));
        o r31 = xq();
        if (r31 == null) goto L67;
        r31.m(13);
    L67:
        zq(false);
        return;
    L72:
        return;
    }

    public final void wq(long r3) {
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).fetchPlayModeInfo(r3, true).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this)), this.d);
    }

    public final void zq(boolean r4) {
        j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r0 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L23;
        i r2 = r1.t();
        if (r2 == null) goto L24;
        ArrayList r3 = new ArrayList();
        List r5 = r2.c;
        if (r5 == null) goto L13;
        r3.addAll(r5);
    L13:
        if (r4 == false) goto L18;
        if (r3.contains(13) == true) goto L20;
        r3.add(13);
    L20:
        r2.c = r3;
        return;
    L18:
        if (r3.contains(13) == false) goto L20;
        r3.remove(13);
        goto L20
    L24:
        return;
    L23:
        return;
    }

    public static void yq(long r8, String r10, Integer r11) {
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "msgType");
        JSONObject r3 = new JSONObject();
        r3.put("msg_id", r8);
        r3.put("msg_type", r10);
        r3.put("enlarge_guest_type", r11);
        if (nd0.e.b() != true) goto L5;
    L6:
        nd0.c.o(nd0.c.a, LinkMonitorData.ReceiveEnlargeGuestMessageMonitorData, r3, 0, null, false, 28);
        return;
    L5:
        if (nd0.e.c() == true) goto L6;
    }
}
