package qa2;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.HotMsgType;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.ConfrontType;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import nm1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements f52.d, vlc.l {
    public f52.b a;
    public f52.j<g3> b;
    public f52.j<g3> c;
    public final CompositeDisposable d;
    public boolean e;
    public long f;
    public final long g;
    public long h;
    public boolean i;
    public final a j;
    public final String k;
    public final ViewGroup l;

    public static final class a extends IHostAppMonitorListener.Stub {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void appEnterBackground(boolean r1, boolean r2) {
            this.a.i = r1;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ k a;

        public b(k r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Integer r5 = (Integer) r4;
            k r0 = this.a;
            com.bytedance.android.livesdk.interactivity.api.quickcomment.e.a.getClass();
            if (r5 != null) goto L6;
        L7:
            if (r5 != null) goto L10;
        L11:
            boolean r6 = true;
        L13:
            r0.e = r6;
            return;
        L10:
            if (r5.intValue() != 3) goto L11;
        L12:
            r6 = false;
            goto L13
        L6:
            if (r5.intValue() == 2) goto L12;
            goto L7
        }
    }

    @Override // f52.d
    public final void onUnload() {
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(this.k + " onUnload");
        this.c = null;
        this.b = null;
        this.d.clear();
        Lazy r0 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().b(this.j);
    }

    @Override // f52.d
    public final String getId() {
        return this.k;
    }

    public k(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        this.l = r3;
        this.d = new CompositeDisposable();
        this.e = true;
        this.g = 60000;
        this.j = new a(this);
        this.k = "MatchMsgViewManager";
    }

    @Override // f52.d
    public final void j(f52.b r6) {
        Intrinsics.checkNotNullParameter(r6, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(this.k + " onLoad");
        this.a = r6;
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L13;
        o r1 = IRoomContextService.a.a(r0, null, 0, 2);
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.j r2 = r1.getMessageManager();
        if (r2 == null) goto L13;
        vlc.d r3 = (vlc.d) r2.getValue();
        if (r3 == null) goto L13;
        Disposable r4 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.c(r3, "WebcastMatchHotMessage", this);
        if (r4 == null) goto L13;
        RxUtilKt.c(r4, this.d);
    L13:
        Lazy r5 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().a(this.j);
        com.bytedance.android.livesdk.interactivity.api.h r7 = com.bytedance.android.livesdk.interactivity.api.i.b(r6.getDataCenter(), 1);
        if (r7 == null) goto L25;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r8 = r7.getQuickCommentManager();
        if (r8 == null) goto L26;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r9 = (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) r8.getValue();
        if (r9 == null) goto L27;
        com.bytedance.android.live.core.arch.mvvm.d<Integer> r10 = r9.getQuickCommentType();
        if (r10 == null) goto L28;
        Disposable r11 = r10.subscribe(new b(this));
        if (r11 == null) goto L29;
        RxUtilKt.c(r11, this.d);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void onMessage(tlc.d r17) {
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(this.k + " receive msg");
        if ((r17 instanceof g3) == false) goto L151;
        g3 r1 = (g3) r17;
        if (this.e == false) goto L48;
        if (this.i == true) goto L48;
        m r2 = pm1.f.l();
        if (r2 == null) goto L18;
        f52.b r6 = this.a;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L15:
        if (r2.y(r6.getDataCenter()) != true) goto L18;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("refuse msg cuzz in matchsubcamera");
    L52:
        boolean r3 = false;
    L53:
        if (r3 == true) goto L55;
        return;
    L55:
        if (r1.getMsgType() != HotMsgType.ConfrontMsg.getId()) goto L145;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("dispatchConfrontMsg id=" + r1.getMessageId());
        int r4 = r1.getGroup();
        int r7 = ConfrontType.MainGroup.getId();
        ra2.a r8 = ra2.a.a;
        Long r13 = null;
        String r14 = null;
        Long r15 = null;
        Long r16 = null;
        if (r4 != r7) goto L90;
        PriorityBlockingQueue<g3> r5 = ra2.b.a;
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (ra2.b.a != null) goto L61;
        ra2.b.a = new PriorityBlockingQueue(11, r8);
    L61:
        g3 r9 = ra2.b.c;
        if (r9 == null) goto L72;
        String r10 = r9.getContent();
        if (r10 == null) goto L72;
        if (r10.equals(r1.getContent()) == true) goto L72;
        StringBuilder r11 = new StringBuilder("confrontView is showing, refuse msg because of content is unfit. CurShow msg content is ");
        g3 r18 = ra2.b.c;
        if (r18 == null) goto L70;
        r14 = r18.getContent();
    L70:
        r11.append(r14);
        r11.append(". Received msg's content is ");
        r11.append(r1.getContent());
        r11.append(", type is ");
        r11.append(r1.getMsgType());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r11.toString());
    L126:
        PriorityBlockingQueue<g3> r19 = ra2.b.a;
        if (r19 != null) goto L129;
    L135:
        boolean r20 = false;
    L136:
        if (r20 == true) goto L139;
        return;
    L139:
        if (this.b != null) goto L153;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("start running ConfrontView");
        i r21 = new i(this);
        f52.b r23 = this.a;
        if (r23 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L143:
        r23.a(new d(this.l, r1, r21));
        return;
    L153:
        return;
    L129:
        if ((!r19.isEmpty()) != true) goto L135;
        PriorityBlockingQueue<g3> r24 = ra2.b.b;
        if (r24 == null) goto L135;
        if ((!r24.isEmpty()) != true) goto L135;
        r20 = true;
    L72:
        if (ra2.b.c == null) goto L87;
        long r25 = r1.getCount();
        g3 r26 = ra2.b.c;
        if (r26 == null) goto L76;
        long r110 = r26.getCount();
    L78:
        if (r25 >= r110) goto L87;
        StringBuilder r27 = new StringBuilder("confrontView is showing, refuse msg because of msg's count is smaller than curshow. CurShow msg content is ");
        g3 r28 = ra2.b.c;
        if (r28 == null) goto L82;
        String r29 = r28.getContent();
    L83:
        r27.append(r29);
        r27.append(", count is ");
        g3 r30 = ra2.b.c;
        if (r30 == null) goto L86;
        r15 = Long.valueOf(r30.getCount());
    L86:
        r27.append(r15);
        r27.append(".  Received msg's content is ");
        r27.append(r1.getContent());
        r27.append(", type is ");
        r27.append(r1.getMsgType());
        r27.append(", seqid is ");
        r27.append(r1.getSequenceId());
        r27.append(", count is ");
        r27.append(r1.getCount());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r27.toString());
        goto L126
    L82:
        r29 = null;
        goto L83
    L76:
        r110 = 0;
    L87:
        PriorityBlockingQueue<g3> r31 = ra2.b.a;
        if (r31 == null) goto L126;
        r31.add(r1);
        goto L126
    L90:
        PriorityBlockingQueue<g3> r33 = ra2.b.a;
        Intrinsics.checkNotNullParameter(r1, "msg");
        if (ra2.b.b != null) goto L93;
        ra2.b.b = new PriorityBlockingQueue(11, r8);
    L93:
        g3 r34 = ra2.b.d;
        if (r34 == null) goto L108;
        String r35 = r34.getContent();
        if (r35 == null) goto L108;
        if (r35.equals(r1.getContent()) == true) goto L108;
        StringBuilder r36 = new StringBuilder("confrontView is showing, refuse msg because of content is unfit. CurShow msg content is ");
        g3 r37 = ra2.b.d;
        if (r37 == null) goto L102;
        String r38 = r37.getContent();
    L103:
        r36.append(r38);
        r36.append(", count is ");
        g3 r39 = ra2.b.d;
        if (r39 == null) goto L106;
        r16 = Long.valueOf(r39.getCount());
    L106:
        r36.append(r16);
        r36.append(". Received msg's content is ");
        r36.append(r1.getContent());
        r36.append(", type is ");
        r36.append(r1.getMsgType());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r36.toString());
        goto L126
    L102:
        r38 = null;
    L108:
        if (ra2.b.d == null) goto L123;
        long r40 = r1.getCount();
        g3 r41 = ra2.b.d;
        if (r41 == null) goto L112;
        long r111 = r41.getCount();
    L114:
        if (r40 >= r111) goto L123;
        StringBuilder r43 = new StringBuilder("confrontView is showing, refuse msg because of msg's count is smaller than curshow.CurShow msg content is ");
        g3 r44 = ra2.b.d;
        if (r44 == null) goto L118;
        String r45 = r44.getContent();
    L119:
        r43.append(r45);
        r43.append(", count is ");
        g3 r46 = ra2.b.d;
        if (r46 == null) goto L122;
        r13 = Long.valueOf(r46.getCount());
    L122:
        r43.append(r13);
        r43.append(". Received msg's content is ");
        r43.append(r1.getContent());
        r43.append(", type is ");
        r43.append(r1.getMsgType());
        r43.append(", seqid is ");
        r43.append(r1.getSequenceId());
        r43.append(", count is ");
        r43.append(r1.getCount());
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r43.toString());
        goto L126
    L118:
        r45 = null;
        goto L119
    L112:
        r111 = 0;
    L123:
        PriorityBlockingQueue<g3> r47 = ra2.b.b;
        if (r47 == null) goto L126;
        r47.add(r1);
        goto L126
    L145:
        if (r1.getMsgType() != HotMsgType.AggregateMsg.getId()) goto L155;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("dispatchMatchHotMsg id=" + r1.getMessageId());
        j r48 = new j(this);
        f52.b r49 = this.a;
        if (r49 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L149:
        r49.a(new h(this.l, r1, r48));
        return;
    L155:
        return;
    L18:
        if (v.a() == false) goto L23;
        if (r1.getTriggerTimestamp() != (-10086)) goto L23;
        r1.setTriggerTimestamp(System.currentTimeMillis());
    L23:
        if (r1.getMsgType() != HotMsgType.ConfrontMsg.getId()) goto L28;
        if ((System.currentTimeMillis() - this.f) >= this.g) goto L45;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of freeze time, msg type is " + r1.getMsgType() + ", content is " + r1.getContent() + ", seqId is " + r1.getSequenceId());
    L45:
        r3 = true;
        goto L53
    L28:
        if (r1.getMsgType() == HotMsgType.AggregateMsg.getId()) goto L30;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of unknown msg, receive msg type is " + r1.getMsgType() + ", content is " + r1.getContent() + ", seqId is " + r1.getSequenceId());
        goto L52
    L30:
        if (this.b == null) goto L33;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of ConfrontView is showing, cur msg type is " + r1.getMsgType() + ", content is " + r1.getContent() + ", seqId is " + r1.getSequenceId());
        goto L52
    L33:
        if (this.c == null) goto L35;
        boolean r50 = true;
    L37:
        if (r50 == false) goto L39;
    L41:
        if (r50 == false) goto L45;
        if (r1.getTriggerTimestamp() >= this.h) goto L45;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of MatchHotMsgView is running. triggerTimestamp is smaller than cur msg's timestamp. Receive msg: " + r1.getMsgType() + ", content is " + r1.getContent() + ", seqId is " + r1.getSequenceId() + ", triggerTimestamp is " + r1.getTriggerTimestamp() + '.');
        goto L52
    L39:
        if (r1.getTriggerTimestamp() > this.h) goto L41;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("refuse msg because of triggerTimestamp is smaller than or equal the lastHotMsgTriggerTimeStamp, cur msg: type is " + r1.getMsgType() + ", content is " + r1.getContent() + ", seqId is " + r1.getSequenceId() + ", triggerTimestamp is " + r1.getTriggerTimestamp() + '.');
        goto L52
    L35:
        r50 = false;
    L48:
        if (this.i == false) goto L50;
        String r51 = "refuse msg because of is in background!";
    L51:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r51);
        goto L52
    L50:
        r51 = "refuse msg because of msgReceiveOrShowChanger is off !";
        goto L51
    }
}
