package com.bytedance.android.live.livelink.multilink.media;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import gi6.e;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import yb6.j;
import yb6.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final class LinkMediaManager$mRtcListener$2$1$onInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ei6.a $client;
    final /* synthetic */ long $code;
    final /* synthetic */ Object[] $params;
    final /* synthetic */ int $type;
    final /* synthetic */ LinkMediaManager$mRtcListener$2.AnonymousClass1 this$0;

    public LinkMediaManager$mRtcListener$2$1$onInfo$1(LinkMediaManager$mRtcListener$2.AnonymousClass1 r1, int r2, long r3, Object[] r5, ei6.a r6) {
        this.this$0 = r1;
        this.$type = r2;
        this.$code = r3;
        this.$params = r5;
        this.$client = r6;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m440invoke() {
        int r1 = this.$type;
        boolean r3 = true;
        int r5 = 0;
        if (r1 == 4) goto L77;
        String r7 = null;
        Object r8 = null;
        String r9 = null;
        if (r1 != 5) goto L7;
        LinkMonitor.a("LinkMediaM", "rtc end succeed", "duration " + dc6.a.a(this.this$0.a.this$0.p), null, null, false, 120);
        InteractLinkFullLinkMonitor.j0(dc6.a.a(this.this$0.a.this$0.p));
        this.this$0.a.this$0.v0().b(false, "rtc end succeed");
        this.this$0.a.this$0.v0().d = false;
        this.this$0.a.this$0.v0().getClass();
        ei6.a r2 = this.this$0.a.this$0.d;
        if (r2 == null) goto L71;
        e r4 = r2.getEventManager();
        if (r4 == null) goto L71;
        r4.b(null);
    L71:
        Disposable r6 = this.this$0.a.this$0.g;
        if (r6 == null) goto L74;
        r6.dispose();
    L74:
        Disposable r10 = this.this$0.a.this$0.f;
        if (r10 == null) goto L86;
        r10.dispose();
    L86:
        Iterator<o> r11 = this.this$0.a.this$0.h.iterator();
    L88:
        if (r11.hasNext() == false) goto L90;
        o r12 = r11.next();
        ei6.a r13 = this.$client;
        int r14 = this.$type;
        long r15 = this.$code;
        Object[] r16 = this.$params;
        r12.vc(r13, r14, r15, Arrays.copyOf(r16, r16.length));
        goto L88
    L90:
        return;
    L7:
        if (r1 == 6) goto L51;
        if (r1 != 8) goto L11;
        Object[] r17 = this.$params;
        if (r17 == null) goto L86;
        Object r18 = ArraysKt.getOrNull(r17, 0);
        if ((r18 instanceof String) == true) goto L43;
        r18 = null;
    L43:
        String r19 = (String) r18;
        LinkMonitor.a("LinkMediaM", "user leave " + r19, null, null, null, false, 92);
        if (r19 == null) goto L86;
        if ((!StringsKt.isBlank(r19)) == false) goto L48;
        r9 = r19;
    L48:
        if (r9 == null) goto L86;
        j r20 = this.this$0.a.this$0.k.remove(r9);
        goto L86
    L11:
        if (r1 == 11) goto L18;
        switch(r1) {
            case 301: goto L16;
            case 302: goto L15;
            case 303: goto L14;
            default: goto L86;
        };
    L14:
        LinkMediaManager r21 = this.this$0.a.this$0;
        int r22 = LinkMediaManager.x;
        r21.v0().getClass();
        LinkMonitor.a("LinkMediaM", "forward stream failure", String.valueOf(this.$params), null, null, false, 120);
        InteractLinkFullLinkMonitor.a0(String.valueOf(this.$params[0]), String.valueOf(this.$params[1]));
        goto L86
    L15:
        LinkMonitor.a("LinkMediaM", "forward stream success", String.valueOf(this.$params), null, null, false, 120);
        LinkMediaManager r23 = this.this$0.a.this$0;
        int r24 = LinkMediaManager.x;
        r23.v0().getClass();
        Object[] r25 = this.$params;
        InteractLinkFullLinkMonitor.b0(r25[0], r25[1], dc6.a.a(this.this$0.a.this$0.q));
        goto L86
    L16:
        LinkMonitor.a("LinkMediaM", "forward stream idle", String.valueOf(this.$params), null, null, false, 120);
        LinkMediaManager r26 = this.this$0.a.this$0;
        int r27 = LinkMediaManager.x;
        r26.v0().getClass();
        goto L86
    L18:
        if (this.$params == null) goto L86;
        LinkMonitor.a("LinkMediaM", "first remote video", null, null, null, false, 92);
        Object r28 = ArraysKt.getOrNull(this.$params, 0);
        if ((r28 instanceof String) == false) goto L23;
        r8 = r28;
    L23:
        String r29 = (String) r8;
        Object r30 = ArraysKt.getOrNull(this.$params, 1);
        Object[] r31 = this.$params;
        if (3 > ArraysKt.getLastIndex(r31)) goto L26;
        Object r32 = r31[3];
    L28:
        if (r32 == null) goto L37;
        final int r33 = ((Integer) r32).intValue();
        Object[] r34 = this.$params;
        if (4 > ArraysKt.getLastIndex(r34)) goto L32;
        r5 = r34[4];
    L32:
        if (r5 == null) goto L35;
        final int r35 = ((Integer) r5).intValue();
        Unit r36 = (Unit) pi6.a.a(r29, r30, new LinkMediaManager$mRtcListener$2$1$onInfo$1$$special$$inlined$let$lambda$1(r33, r35, this));
        goto L86
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L26:
        r32 = 0;
        goto L28
    L51:
        if (6 != this.$code) goto L86;
        Object[] r37 = this.$params;
        if (r37 == null) goto L86;
        if (r37.length > 0) goto L58;
        r3 = false;
    L58:
        if (r3 == false) goto L60;
        Object[] r38 = r37;
    L61:
        if (r38 == null) goto L86;
        Object r39 = r37[0];
        if (r39 == null) goto L65;
        r7 = r39.toString();
    L65:
        InteractLinkFullLinkMonitor.O(r7);
        LinkMonitor.a("LinkMediaM", "onInfo", "rtc connection lost " + this.$params[0], null, null, false, 120);
        goto L86
    L60:
        r38 = null;
        goto L61
    L77:
        LinkMonitor.a("LinkMediaM", "rtc start succeed", " duration " + dc6.a.a(this.this$0.a.this$0.o), null, null, false, 120);
        this.this$0.a.this$0.v0().c = false;
        Disposable r40 = this.this$0.a.this$0.f;
        if (r40 == null) goto L81;
        r40.dispose();
    L81:
        if (this.this$0.a.this$0.v0().d == false) goto L83;
    L91:
        LinkMonitor.a("LinkMediaM", "rtc start succeed when engine is stopping or stopped,ignore!", null, null, null, false, 124);
        return;
    L83:
        if (this.this$0.a.this$0.d == null) goto L91;
        this.this$0.a.this$0.v0().b(true, "rtc start succeed");
        goto L86
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m440invoke();
        return Unit.INSTANCE;
    }
}
