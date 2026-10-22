package com.bytedance.android.live.anchormodelink.livelink;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.l;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.google.gson.JsonObject;
import gi6.e;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import yb6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final class LiveLinkWrapper$mRtcListener$2$1$onInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $code;
    final /* synthetic */ Object[] $params;
    final /* synthetic */ int $type;
    final /* synthetic */ LiveLinkWrapper$mRtcListener$2.AnonymousClass1 this$0;

    public LiveLinkWrapper$mRtcListener$2$1$onInfo$1(LiveLinkWrapper$mRtcListener$2.AnonymousClass1 r1, int r2, long r3, Object[] r5) {
        this.this$0 = r1;
        this.$type = r2;
        this.$code = r3;
        this.$params = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m22invoke() {
        int r0 = this.$type;
        boolean r3 = true;
        Object r4 = null;
        String r5 = null;
        Object r6 = null;
        String r7 = null;
        Object r8 = null;
        int r9 = 0;
        if (r0 == 11) goto L90;
        if (r0 != 25) goto L6;
    L82:
        Object[] r1 = this.$params;
        Object r2 = r1[0];
        if ((r2 instanceof String[]) == true) goto L85;
        r2 = null;
    L85:
        String[] r11 = (String[]) r2;
        Object r12 = r1[1];
        if ((r12 instanceof boolean[]) == false) goto L89;
        r8 = r12;
    L89:
        pi6.a.a(r11, (boolean[]) r8, new AnonymousClass7(this));
    L106:
        if (this.this$0.a.this$0.l == false) goto L116;
        int r13 = this.$type;
        if (r13 == 9) goto L117;
        if (r13 == 25) goto L118;
        JsonObject r14 = new JsonObject();
        r14.addProperty("type", Integer.valueOf(this.$type));
        r14.addProperty("code", Long.valueOf(this.$code));
        this.this$0.a.this$0.j("onRtcInfo", r14);
        return;
    L118:
        return;
    L117:
        return;
    L116:
        return;
    L6:
        switch(r0) {
            case 4: goto L61;
            case 5: goto L49;
            case 6: goto L34;
            case 7: goto L20;
            case 8: goto L9;
            case 9: goto L82;
            default: goto L7;
        };
    L7:
        switch(r0) {
            case 301: goto L81;
            case 302: goto L80;
            case 303: goto L79;
            default: goto L106;
        };
    L79:
        this.this$0.a.this$0.g().getClass();
        LinkMonitor.a(this.this$0.a.this$0.a, "forward stream failure", String.valueOf(this.$params), null, null, false, 120);
        InteractLinkFullLinkMonitor.a0(String.valueOf(this.$params[0]), String.valueOf(this.$params[1]));
        goto L106
    L80:
        LinkMonitor.a(this.this$0.a.this$0.a, "forward stream success", String.valueOf(this.$params), null, null, false, 120);
        this.this$0.a.this$0.g().getClass();
        Object[] r15 = this.$params;
        InteractLinkFullLinkMonitor.b0(r15[0], r15[1], 0);
        goto L106
    L81:
        LinkMonitor.a(this.this$0.a.this$0.a, "forward stream idle", String.valueOf(this.$params), null, null, false, 120);
        this.this$0.a.this$0.g().getClass();
        goto L106
    L9:
        Object r16 = ArraysKt.getOrNull(this.$params, 0);
        if ((r16 instanceof String) == true) goto L12;
        r16 = null;
    L12:
        String r17 = (String) r16;
        LinkMonitor.a(this.this$0.a.this$0.a, "user leave " + r17, null, null, null, false, 92);
        if (r17 != null) goto L15;
    L19:
        JsonObject r18 = new JsonObject();
        r18.addProperty("linkmic_id_str", r17);
        this.this$0.a.this$0.j("userDidLeaveRTC", r18);
        goto L106
    L15:
        if ((true ^ StringsKt.isBlank(r17)) == false) goto L17;
        r5 = r17;
    L17:
        if (r5 == null) goto L19;
        j r19 = this.this$0.a.this$0.g.remove(r5);
        goto L19
    L20:
        Object r21 = this.$params[0];
        if (r21 == null) goto L26;
        l r22 = this.this$0.a.this$0.u.r4();
        if (r22 == null) goto L25;
        r22.ui(r21.toString());
    L25:
        InteractLinkFullLinkMonitor.Q(r21.toString());
    L26:
        Object r23 = this.$params[0];
        if ((r23 instanceof String) == false) goto L30;
        r6 = r23;
    L30:
        String r24 = (String) r6;
        if (r24 == null) goto L106;
        LinkMonitor.a(this.this$0.a.this$0.a, "user join ".concat(r24), null, null, null, false, 92);
        JsonObject r25 = new JsonObject();
        r25.addProperty("linkmic_id_str", r24);
        this.this$0.a.this$0.j("userDidJoinRTC", r25);
        this.this$0.a.this$0.q.remove(r24);
        goto L106
    L49:
        LinkMonitor.a(this.this$0.a.this$0.a, "rtc end succeed", "duration " + LiveLinkWrapper.e(this.this$0.a.this$0.n), null, null, false, 120);
        InteractLinkFullLinkMonitor.j0(LiveLinkWrapper.e(this.this$0.a.this$0.n));
        this.this$0.a.this$0.g().b(false, "rtc end succeed");
        this.this$0.a.this$0.g().d = false;
        this.this$0.a.this$0.g().getClass();
        ei6.a r26 = this.this$0.a.this$0.d;
        if (r26 == null) goto L54;
        e r27 = r26.getEventManager();
        if (r27 == null) goto L54;
        r27.b(null);
    L54:
        Disposable r28 = this.this$0.a.this$0.i;
        if (r28 == null) goto L57;
        r28.dispose();
    L57:
        Disposable r29 = this.this$0.a.this$0.h;
        if (r29 == null) goto L60;
        r29.dispose();
    L60:
        this.this$0.a.this$0.j("didLeaveChannel", null);
        this.this$0.a.this$0.u.m4();
        goto L106
    L61:
        boolean r31 = this.this$0.a.this$0.u.v4();
        Disposable r32 = this.this$0.a.this$0.h;
        if (r32 == null) goto L64;
        r32.dispose();
    L64:
        boolean r33 = LinkMonitor.h;
        i97.a r34 = i97.a.a;
        LinkMonitor.f = System.currentTimeMillis();
        LinkMonitor.a(this.this$0.a.this$0.a, "rtc start succeed", " duration " + LiveLinkWrapper.e(this.this$0.a.this$0.m), null, null, false, 120);
        InteractLinkFullLinkMonitor.e0(LinkMonitor.f - LinkMonitor.d);
        this.this$0.a.this$0.g().c = false;
        if (this.this$0.a.this$0.g().d == true) goto L77;
        LiveLinkWrapper r35 = this.this$0.a.this$0;
        if (r35.d == null) goto L77;
        r35.g().b(true, "rtc start succeed");
        this.this$0.a.this$0.j("didJoinChannel", null);
        this.this$0.a.this$0.u.Q1();
        if (r31 == false) goto L74;
        sk0.c r36 = this.this$0.a.this$0.c();
        if (r36 == null) goto L74;
        r36.k();
    L74:
        sk0.c r37 = this.this$0.a.this$0.c();
        if (r37 == null) goto L106;
        r37.j();
    L77:
        LinkMonitor.a(this.this$0.a.this$0.a, "rtc start succeed when engine is stopping or stopped,ignore!", null, null, null, false, 124);
        return;
    L34:
        if (this.this$0.a.this$0.b != this.$code) goto L106;
        Object[] r38 = this.$params;
        if (r38 == null) goto L106;
        if (r38.length > 0) goto L41;
        r3 = false;
    L41:
        if (r3 == false) goto L43;
        Object[] r39 = r38;
    L44:
        if (r39 == null) goto L106;
        Object r41 = r38[0];
        if (r41 == null) goto L48;
        r7 = r41.toString();
    L48:
        InteractLinkFullLinkMonitor.O(r7);
        LinkMonitor.a(this.this$0.a.this$0.a, "onInfo", "rtc connection lost " + this.$params[0], null, null, false, 120);
        goto L106
    L43:
        r39 = null;
        goto L44
    L90:
        LinkMonitor.a(this.this$0.a.this$0.a, "first remote video", null, null, null, false, 92);
        Object r42 = ArraysKt.getOrNull(this.$params, 0);
        if ((r42 instanceof String) == false) goto L94;
        r4 = r42;
    L94:
        String r43 = (String) r4;
        Object r44 = ArraysKt.getOrNull(this.$params, 1);
        Object[] r45 = this.$params;
        if (2 > ArraysKt.getLastIndex(r45)) goto L97;
        Object r46 = r45[2];
    L99:
        if (r46 == null) goto L115;
        final int r47 = ((Integer) r46).intValue();
        Object[] r48 = this.$params;
        if (3 > ArraysKt.getLastIndex(r48)) goto L103;
        r9 = r48[3];
    L103:
        if (r9 == null) goto L113;
        final int r49 = ((Integer) r9).intValue();
        Unit r51 = (Unit) pi6.a.a(r43, r44, new LiveLinkWrapper$mRtcListener$2$1$onInfo$1$$special$$inlined$let$lambda$1(r47, r49, this));
        goto L106
    L113:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L97:
        r46 = 0;
        goto L99
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m22invoke();
        return Unit.INSTANCE;
    }
}
