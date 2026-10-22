package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import am2.x;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.message.f1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f52.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class HotMsgPSTopView extends j<f1> {
    public q4.b n;
    public q4.b o;
    public boolean p;
    public final HotMsgGatherViewV2 q;
    public final c r;

    public final long n() {
        return ((f1) this.m).getSequenceId();
    }

    @Override // f52.c
    public final void a(DiscardReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        o("onDiscard. reason=" + r3);
    }

    @Override // f52.c
    public final void h(f52.b r11) {
        Intrinsics.checkNotNullParameter(r11, "container");
        o("onShow. id=" + this.a);
        boolean r4 = false;
        long r5 = -1;
        if (n() <= this.r.a) goto L5;
    L16:
        boolean r0 = true;
    L17:
        if (r0 == true) goto L24;
        StringBuilder r1 = new StringBuilder("message invalid. seqId=");
        r1.append(n());
        r1.append(" maxSequenceId=");
        r1.append(this.r.a);
        r1.append(" combo=");
        List r2 = ((f1) this.m).getNum();
        if (r2 == null) goto L23;
        Long r3 = (Long) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L23;
        r5 = r3.longValue();
    L23:
        r1.append(r5);
        r1.append(" maxCombo=");
        r1.append(this.r.b);
        o(r1.toString());
        m(r11);
        return;
    L24:
        this.r.a = n();
        c r6 = this.r;
        List r7 = ((f1) this.m).getNum();     // Catch: NoSuchElementException -> L31
        if (r7 == null) goto L33;
        Long r8 = (Long) CollectionsKt.last(r7);     // Catch: NoSuchElementException -> L31
        if (r8 == null) goto L33;
        r5 = r8.longValue();     // Catch: NoSuchElementException -> L31
    L33:
        r6.b = r5;
        if (this.q.getParent() != null) goto L36;
        r11.b(this, this.q, new FrameLayout.LayoutParams(-1, -1));
    L36:
        Boolean r9 = a.a;
        Function0<Unit> r10 = new HotMsgPSTopView$onShow$1(this);
        Intrinsics.checkNotNullParameter(r10, "action");
        if (a.a.booleanValue() == true) goto L39;
        r10.invoke();
    L40:
        UtilityKotlinExtentionsKt.u(this.q);
        q4.b r13 = u4.c(new HotMsgPSTopView$onShow$2(this, r11));
        r13.c();
        this.n = r13;
        String r14 = ((f1) this.m).getContent();
        if (r14 != null) goto L43;
        r14 = BuildConfig.FLAVOR;
    L43:
        long r15 = ((f1) this.m).getChatContentType();
        Map r16 = ((f1) this.m).getExtra();
        if (r16 == null) goto L48;
        String r17 = (String) r16.get("tagContentType");
        if (r17 == null) goto L48;
    L54:
        HashMap r18 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("prompt", r14), TuplesKt.to("action_type", "click"), TuplesKt.to("content_type", r17)});
        if (r16 == null) goto L57;
        r18.putAll(r16);
    L57:
        j0.l().sendLog("livesdk_live_message_collection_show", r18, new Object[]{new x(), IRoom.class});
        f1 r19 = (f1) this.m;
        if (r19 == null) goto L67;
        Long r20 = Long.valueOf(r19.getReceiveTime());
        if (r20.longValue() <= 0) goto L62;
        r4 = true;
    L62:
        if (r4 == true) goto L65;
        r20 = null;
    L65:
        if (r20 == null) goto L67;
        long r21 = System.currentTimeMillis() - r20.longValue();
        JSONObject r23 = new JSONObject();
        d60.b.a(r23, "type", "1");
        JSONObject r24 = new JSONObject();
        d60.b.a(r24, "cost", String.valueOf(r21));
        LiveTracingMonitor.i("ttlive_hot_msg_monitor", r23, r24, null);
    L67:
        o r110 = r11.getRoomContext();
        if (r110 == null) goto L74;
        r110.M2(Boolean.TRUE);
        return;
    L74:
        return;
    L48:
        if (r15 != 2) goto L51;
        r17 = "member_emoji";
        goto L54
    L51:
        if (r15 != 3) goto L53;
        r17 = "activity_emoji";
        goto L54
    L53:
        r17 = "comment";
        goto L54
    L39:
        long r25 = System.nanoTime();
        r10.invoke();
        a.d += System.nanoTime() - r25;
        a.e++;
    L31:
        e = move-exception;
        SafetyGuard.a(null, e, "HotMsgPSTopView onShow error");
        ALogger.e("HotMsgViewManager", "HotMsgPSTopView onShow error. data=" + ((f1) this.m));
        goto L33
    L5:
        if (n() != this.r.a) goto L15;
        List r26 = ((f1) this.m).getNum();
        if (r26 == null) goto L11;
        Long r27 = (Long) CollectionsKt.firstOrNull(r26);
        if (r27 == null) goto L11;
        long r28 = r27.longValue();
    L13:
        if (r28 < this.r.b) goto L15;
    L11:
        r28 = -1;
    L15:
        r0 = false;
        goto L17
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        o("onShowFinish. id=" + this.a);
        this.n = null;
        this.o = null;
        return CleanStrategy.NONE;
    }

    @Override // f52.j, f52.c
    public final boolean j(f52.c r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if ((r5 instanceof HotMsgPSTopView) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HotMsgPSTopView) r5).n() != n()) goto L7;
        return true;
    }

    public final void o(String r2) {
        ALogger.i("HotMsgViewManager", r2);
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r2, f52.c r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        o("onInterrupt. id=" + this.a);
        this.p = true;
        this.q.b();
        q4.b r4 = this.n;
        if (r4 == null) goto L5;
        r4.a();
        this.n = null;
    L5:
        q4.b r5 = this.o;
        if (r5 == null) goto L8;
        r5.a();
        this.o = null;
    L8:
        o r6 = r2.getRoomContext();
        if (r6 == null) goto L12;
        r6.M2(Boolean.FALSE);
    L12:
        return CleanStrategy.NONE;
    }

    @Override // f52.j, f52.c
    public final void e(f52.c r10, PSTopContainer r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "container");
        o("onAssemble. id=" + this.a + " newId=" + r10.getId());
        if ((r10 instanceof HotMsgPSTopView) == false) goto L46;
        HotMsgGatherViewV2 r13 = this.q;
        f1 r14 = (f1) ((HotMsgPSTopView) r10).m;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "msg");
        List r0 = r14.getNum();
        List r2 = null;
        if ((r0 instanceof ArrayList) == true) goto L7;
        r0 = null;
    L7:
        ArrayList r1 = (ArrayList) r0;
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        List r15 = r14.getShowDuration();
        if ((r15 instanceof ArrayList) == false) goto L14;
        r2 = r15;
    L14:
        ArrayList r3 = (ArrayList) r2;
        if (r3 != null) goto L18;
        r3 = new ArrayList();
    L18:
        if (r1.size() == r3.size()) goto L21;
        return;
    L21:
        if (r1.size() != 0) goto L23;
        return;
    L23:
        if (r13.h.size() != 0) goto L26;
        return;
    L26:
        if (r13.k < r13.h.size()) goto L29;
        return;
    L29:
        if (((Number) ListProtector.get(r13.h, r13.k)).longValue() <= ((Number) ListProtector.get(r1, 0)).longValue()) goto L32;
        return;
    L32:
        if (((Number) CollectionsKt.last(r13.h)).longValue() > ((Number) ListProtector.get(r1, 0)).longValue()) goto L34;
        r13.h.addAll(r1);
        r13.i.addAll(r3);
    L40:
        c r16 = r13.q;
        if (r16 == null) goto L48;
        r16.b = ((Number) CollectionsKt.last(r13.h)).longValue();
        return;
    L48:
        return;
    L34:
        int r4 = r13.h.size();
        int r5 = 0;
    L35:
        if (r5 >= r4) goto L40;
        if (((Number) ListProtector.get(r13.h, r5)).longValue() > ((Number) ListProtector.get(r1, 0)).longValue()) goto L38;
        r5 = r5 + 1;
        goto L35
    L38:
        r13.h.addAll(r5, r1);
        r13.i.addAll(r5, r3);
        goto L40
    }

    public HotMsgPSTopView(f1 r20, HotMsgGatherViewV2 r21, c r23) {
        Intrinsics.checkNotNullParameter(r20, "msg");
        Intrinsics.checkNotNullParameter(r21, "hotMsgView");
        Intrinsics.checkNotNullParameter(r23, "showInfo");
        super(String.valueOf(r20.getMessageId()), NativePSTopViewType.HotMsgGather, 0, Integer.MAX_VALUE, 0, 0, 0, ConflictStrategy.DISCARD, ConflictStrategy.QUEUE, ConflictStrategy.INTERRUPT, true, r20.getHighlightAreaPriorityConfig(), r20);
        this.q = r21;
        this.r = r23;
    }
}
