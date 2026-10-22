package aa2;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.batch.PsFirstFetchMsgBatchHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.PSFirstMessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements IPSMessageRepoManager.Listener {
    public final /* synthetic */ TransTextMessagePresenter a;

    public u(TransTextMessagePresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void c(List<? extends tlc.d> r8) {
        StringBuilder r0 = new StringBuilder("use backend top message, num：");
        ArrayList r9 = (ArrayList) r8;
        r0.append(r9.size());
        ALogger.i(PSTopMessagePayload.TAG, r0.toString());
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.i.b.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.i.b r1 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.i.a;
        if (r1 == null) goto L5;
        z32.f.d(PSRoomStatValueNode.ReceiveBackendTopMsgCostTime, System.currentTimeMillis() - r1.c);
    L5:
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        tlc.d r2 = (tlc.d) r10.next();
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.c(r2) == true) goto L11;
        ALogger.e(PSTopMessagePayload.TAG, "top msg not mark. msg id ：" + r2.getMessageId() + "msg method: " + r2.getMessageMethod());
    L11:
        this.a.y0(r2, true);
        goto L7
    L12:
        z32.f.a(PSRoomStatDescNode.PublicScreenReceiveFirstMessageType, "backend_top");
        this.a.I.b(PSFirstMessageType.BACKEND_TOP);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void d(IPSMessageRepoManager.Listener.Event r2) {
        if (r2 != IPSMessageRepoManager.Listener.Event.PAUSE) goto L5;
    L6:
        this.a.C.clearAll();
        return;
    L5:
        if (r2 == IPSMessageRepoManager.Listener.Event.UPDATE) goto L6;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void e(List r4) {
        Iterator r5 = ((ArrayList) r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        tlc.d r0 = (tlc.d) r5.next();
        this.a.y0(r0, true);
        goto L4
    L6:
        this.a.I.b(PSFirstMessageType.BACKEND_TOP);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void onMessage(tlc.d r3) {
        this.a.y0(r3, false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void a(List<? extends tlc.d> r3, boolean r4) {
        TransTextMessagePresenter r0 = this.a;
        r0.getClass();
        if (r3 != null) goto L5;
    L24:
        InteractivityMonitor.b(InteractivityMonitor.Event.IMFirstMessageEmpty, r0.e);
        return;
    L5:
        if (r3.isEmpty() == true) goto L24;
        if (PublicScreenABHelper.R == false) goto L16;
        IRoom r1 = r0.e;
        if (r1 == null) goto L16;
        if (r1.isMergeVSRoom() == false) goto L16;
        r0.I0();
        r42.h r2 = r0.x;
        if (r2 == null) goto L16;
        r2.b.b = r4;
    L16:
        Iterator<? extends tlc.d> r5 = r3.iterator();
    L18:
        if (r5.hasNext() == false) goto L21;
        r0.y0(r5.next(), true);
        goto L18
    L21:
        if (r0.G == true) goto L23;
        r0.p0(false);
    L23:
        r0.t0();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void b(List<? extends tlc.d> r4, boolean r5) {
        TransTextMessagePresenter r0 = this.a;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) r0).c) == null) goto L25;
        r42.h r1 = (r42.h) com.bytedance.android.livesdk.interactivity.api.i.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) r0).c).getHistoryDataManager().getValue();
        r0.x = r1;
        if (r1 == null) goto L29;
        r1.b.b = r5;
        Iterator<? extends tlc.d> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        com.bytedance.android.live.base.model.message.t r2 = (tlc.d) r6.next();
        if ((r2 instanceof k0) == false) goto L9;
        r0.x.a(r2);
        goto L9
    L13:
        r0.I.b(PSFirstMessageType.HISTORY);
        r0.x.b();
        ITextMessageView r7 = ((q46.b) r0).a;
        if (r7 != null) goto L16;
        return;
    L16:
        if (r7.d() == false) goto L27;
        if (r5 == false) goto L28;
        ((q46.b) r0).a.a40();
        return;
    L28:
        return;
    L27:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void f(List<? extends tlc.d> r7, boolean r8) {
        TransTextMessagePresenter r0 = this.a;
        int r1 = TransTextMessagePresenter.Y;
        r0.getClass();
        if (r7 != null) goto L5;
    L79:
        InteractivityMonitor.b(InteractivityMonitor.Event.FirstHistoryMessageEmpty, this.a.e);
        return;
    L5:
        if (r7.isEmpty() == true) goto L79;
        this.a.I0();
        r42.h r2 = this.a.x;
        if (r2 == null) goto L110;
        r2.b.b = r8;
        if (r42.g.a(null, null) == false) goto L111;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.i.b.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.i.v();
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.e r9 = this.a.I;
        PSFirstMessageType r3 = PSFirstMessageType.REALTIME;
        if (r9.a(r3) == true) goto L16;
        ALogger.i("MESSAGE_INDEPENDENT_SHOW", "先展示历史消息");
    L16:
        ALogger.i("HISTORY_COMMENT_TAG", "onReceiveHistoryMessage message count: " + r7.size());
        if (this.a.I.a(r3) == false) goto L26;
        Iterator<? extends tlc.d> r10 = r7.iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        com.bytedance.android.live.base.model.message.t r11 = (tlc.d) r10.next();
        if ((r11 instanceof com.bytedance.android.live.base.model.message.t) == false) goto L20;
        this.a.x.a(r11);
        goto L20
    L24:
        this.a.x.b();
    L73:
        ITextMessageView r13 = ((q46.b) this.a).a;
        if (r13 != null) goto L76;
    L78:
        this.a.I.b(PSFirstMessageType.HISTORY);
        return;
    L76:
        if (r13.d() == false) goto L78;
        ((q46.b) this.a).a.a40();
        goto L78
    L26:
        if (this.a.I.a <= 0) goto L28;
        boolean r14 = true;
    L29:
        if (r14 == true) goto L31;
        z32.f.a(PSRoomStatDescNode.PublicScreenReceiveFirstMessageType, "history");
    L31:
        this.a.x.c(r7);
        va2.a r15 = new va2.a();
        Iterator<? extends tlc.d> r16 = r7.iterator();
    L33:
        if (r16.hasNext() == false) goto L72;
        c4 r4 = (tlc.d) r16.next();
        if ((r4 instanceof k0) == true) goto L36;
        Intrinsics.checkNotNullParameter(r4, "msg");
        if ((r4 instanceof c4) == false) goto L71;
        c4 r5 = r4;
        if (r5.getBuriedPoint() == null) goto L71;
        Map r6 = r5.getBuriedPoint();
        Intrinsics.checkNotNull(r6);
        String r17 = (String) r6.get("history_chat_aggre_pattern");
        if (Intrinsics.areEqual("general_similar", r17) == false) goto L64;
        r15.a("low_quality_group");
        goto L71
    L64:
        if (Intrinsics.areEqual("interested_ecom_goods", r17) == false) goto L66;
        r15.a("ecom_group");
        goto L71
    L66:
        Map r18 = r5.getBuriedPoint();
        Intrinsics.checkNotNull(r18);
        String r19 = (String) r18.get("hist_msg_scene");
        if (r19 == null) goto L71;
        if (TextUtils.isEmpty(r19) == true) goto L71;
        r15.a(r19);
    L71:
        this.a.y0(r4, true);
        goto L33
    L36:
        com.bytedance.android.live.base.model.message.t r20 = (k0) r4;
        if (r20.isFirstFetchShowMessage() == true) goto L38;
        this.a.x.a(r20);
        goto L33
    L38:
        this.a.y0(r4, true);
        Intrinsics.checkNotNullParameter(r20, "message");
        Map r21 = r20.getMessageExtra();
        if (r21 == null) goto L33;
        if (r21.get("history_comment_type") == null) goto L33;
        String r23 = (String) r21.get("history_comment_type");
        if (Intrinsics.areEqual("normal", r23) == true) goto L44;
        if (Intrinsics.areEqual("personal", r23) == true) goto L47;
        if (r23 == null) goto L33;
        if (r23.length() <= 0) goto L52;
        boolean r24 = true;
    L53:
        if (r24 == false) goto L33;
        r15.a(r23);
        goto L33
    L52:
        r24 = false;
        goto L53
    L47:
        r15.a("personal");
        goto L33
    L44:
        r15.a("normal");
        goto L33
    L72:
        this.a.getClass();
        TransTextMessagePresenter.D0(r15);
        this.a.x.b();
        TransTextMessagePresenter r25 = this.a;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.b.a(r25.B, r25.C.c());
        goto L73
    L28:
        r14 = false;
        goto L29
    L111:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager.Listener
    public final void onFirstMessage(List<? extends tlc.d> r9, boolean r10) {
        TransTextMessagePresenter r0 = this.a;
        r0.getClass();
        if (r9 != null) goto L5;
    L108:
        InteractivityMonitor.b(InteractivityMonitor.Event.IMFirstMessageEmpty, r0.e);
        return;
    L5:
        if (r9.isEmpty() == true) goto L108;
        if (com.bytedance.android.livesdk.interactivity.api.i.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) r0).c) != null) goto L11;
        return;
    L11:
        if (r0.I.a(PSFirstMessageType.BACKEND_TOP) == false) goto L28;
        int r1 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.a;
        Intrinsics.checkNotNullParameter(r9, "messages");
        ArrayList r4 = new ArrayList();
        Iterator r2 = r9.iterator();
    L14:
        if (r2.hasNext() == false) goto L27;
        Object r5 = r2.next();
        tlc.d r6 = (tlc.d) r5;
        if ((r6 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L18;
        r6 = null;
    L18:
        com.bytedance.android.live.base.model.message.t r7 = (com.bytedance.android.live.base.model.message.t) r6;
        if (r7 == null) goto L23;
        Map r8 = r7.getMessageExtra();
        if (r8 == null) goto L23;
        String r11 = (String) r8.get("top_message");
    L25:
        if ((!Intrinsics.areEqual(r11, "1")) == false) goto L14;
        r4.add(r5);
    L23:
        r11 = null;
        goto L25
    L27:
        ALogger.i(PSTopMessagePayload.TAG, "realtime filter top message num：" + (r9.size() - r4.size()));
        r9 = r4;
    L28:
        r42.h r3 = (r42.h) com.bytedance.android.livesdk.interactivity.api.i.a(null, ((com.bytedance.android.livesdk.chatroom.presenter.n) r0).c).getHistoryDataManager().getValue();
        r0.x = r3;
        if (r3 == null) goto L144;
        r3.b.b = r10;
        PsFirstFetchMsgBatchHelper r13 = r0.Q;
        if (r13 == null) goto L35;
        r13.c(r9, ((com.bytedance.android.livesdk.chatroom.presenter.n) r0).c);
    L35:
        if (r42.g.a(null, null) == true) goto L46;
        Iterator<? extends tlc.d> r14 = r9.iterator();
    L38:
        if (r14.hasNext() == false) goto L41;
        r0.y0((tlc.d) r14.next(), true);
        goto L38
    L41:
        if (r0.G == true) goto L43;
        r0.p0(false);
    L43:
        r0.t0();
        PsFirstFetchMsgBatchHelper r15 = r0.Q;
        if (r15 == null) goto L138;
        r15.a(r0.B, r0.C.d());
        return;
    L138:
        return;
    L46:
        ALogger.i("HISTORY_COMMENT_TAG", "onReceiveFirstMessage message count: " + r9.size());
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.o.a(((com.bytedance.android.livesdk.chatroom.presenter.n) r0).c) == true) goto L49;
        r0.x.c(r9);
    L49:
        va2.a r16 = new va2.a();
        Iterator<? extends tlc.d> r17 = r9.iterator();
    L51:
        if (r17.hasNext() == false) goto L94;
        c4 r18 = (tlc.d) r17.next();
        if ((r18 instanceof k0) == true) goto L54;
        if ((r18 instanceof c4) == false) goto L93;
        c4 r19 = r18;
        if (r19.getBuriedPoint() == null) goto L93;
        String r20 = (String) r19.getBuriedPoint().get("history_chat_aggre_pattern");
        if ("general_similar".equals(r20) == false) goto L86;
        r16.a("low_quality_group");
        goto L93
    L86:
        if ("interested_ecom_goods".equals(r20) == false) goto L88;
        r16.a("ecom_group");
        goto L93
    L88:
        String r21 = (String) r19.getBuriedPoint().get("hist_msg_scene");
        if (r21 == null) goto L93;
        if (TextUtils.isEmpty(r21) == true) goto L93;
        r16.a(r21);
    L93:
        r0.y0(r18, true);
        goto L51
    L54:
        com.bytedance.android.live.base.model.message.t r23 = (k0) r18;
        if (r23.isFirstFetchShowMessage() == true) goto L65;
        if (r23.getOrInitPublicAreaCommon().isFirstAggregateHistoryMessage() == true) goto L59;
    L61:
        boolean r24 = false;
    L62:
        if (r24 == true) goto L65;
        r0.x.a(r23);
        goto L51
    L59:
        if (r42.g.a(null, null) == false) goto L61;
        r24 = true;
    L65:
        r0.y0(r18, true);
        Map r25 = r23.getMessageExtra();
        if (r25 == null) goto L51;
        if (r25.get("history_comment_type") == null) goto L51;
        String r26 = (String) r25.get("history_comment_type");
        if ("normal".equals(r26) == true) goto L71;
        if ("personal".equals(r26) == true) goto L74;
        if (TextUtils.isEmpty(r26) == true) goto L51;
        r16.a(r26);
        goto L51
    L74:
        r16.a("personal");
        goto L51
    L71:
        r16.a("normal");
        goto L51
    L94:
        TransTextMessagePresenter.D0(r16);
        r0.I.b(PSFirstMessageType.HISTORY);
        r0.t0();
        if (r0.G == true) goto L97;
        r0.p0(false);
    L97:
        r0.x.b();
        PsFirstFetchMsgBatchHelper r27 = r0.Q;
        if (r27 == null) goto L101;
        r27.a(r0.B, r0.C.d());
    L101:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.o.a(((com.bytedance.android.livesdk.chatroom.presenter.n) r0).c) == true) goto L103;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.b.a(r0.B, r0.C.c());
    L103:
        ITextMessageView r28 = ((q46.b) r0).a;
        if (r28 != null) goto L106;
        return;
    L106:
        if (r28.d() == false) goto L141;
        ((q46.b) r0).a.a40();
        return;
    L141:
        return;
    }
}
