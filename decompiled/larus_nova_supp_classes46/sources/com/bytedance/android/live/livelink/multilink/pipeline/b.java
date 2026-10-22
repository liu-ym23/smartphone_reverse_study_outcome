package com.bytedance.android.live.livelink.multilink.pipeline;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r18) {
        Long r0 = (Long) r18;
        LinkMonitor.a("PipeLineM", "recordLinkDuration", "current LinkSource " + LinkMonitor.j, null, null, false, 120);
        int r1 = a.a[LinkMonitor.j.ordinal()];
        if (r1 != 1) goto L5;
        StringBuilder r2 = new StringBuilder("[duration] first_frame ");
        if (LinkMonitor.h == false) goto L13;
        long r11 = LinkMonitor.g;
        long r13 = LinkMonitor.b;
    L14:
        r2.append(r11 - r13);
        r2.append(" link ");
        if (LinkMonitor.h == false) goto L17;
        long r4 = LinkMonitor.e;
        long r12 = LinkMonitor.b;
    L18:
        r2.append(r4 - r12);
        r2.append(" isAutoJoin ");
        r2.append(LinkMonitor.h);
        r2.append(" autoApplyToPermit ");
        if (LinkMonitor.h == false) goto L21;
        long r5 = LinkMonitor.c - LinkMonitor.b;
    L22:
        r2.append(r5);
        r2.append(" applyApi ");
        r2.append(LinkMonitor.l);
        r2.append(" joinChannel ");
        r2.append(LinkMonitor.m);
        r2.append(" rtc ");
        r2.append(LinkMonitor.f - LinkMonitor.d);
        r2.append(" linkOptInfo ");
        r2.append(LinkMonitor.i);
        LinkMonitor.a("PipeLineM", "applyLinkDuration", r2.toString(), null, null, true, 56);
        if (LinkMonitor.h == false) goto L25;
        InteractLinkFullLinkMonitor.LinkSource r3 = InteractLinkFullLinkMonitor.LinkSource.APPLY_AUTO;
    L26:
        String r6 = LinkMonitor.i;
        if (LinkMonitor.h == false) goto L29;
        long r7 = LinkMonitor.e;
        long r9 = LinkMonitor.b;
    L30:
        InteractLinkFullLinkMonitor.D(r3, r6, r7 - r9, false);
        if (LinkMonitor.h == false) goto L33;
        long r8 = LinkMonitor.g;
        long r10 = LinkMonitor.b;
    L35:
        if ((r8 - r10) > 0) goto L37;
    L49:
        LinkMonitor.b();
        return;
    L37:
        if (LinkMonitor.h == false) goto L39;
        InteractLinkFullLinkMonitor.LinkSource r14 = InteractLinkFullLinkMonitor.LinkSource.APPLY_AUTO;
    L40:
        String r15 = LinkMonitor.i;
        if (LinkMonitor.h == false) goto L43;
        long r16 = LinkMonitor.g;
        long r17 = LinkMonitor.b;
    L44:
        long r19 = r16 - r17;
        if (LinkMonitor.h == false) goto L47;
        long r20 = LinkMonitor.e;
        long r21 = LinkMonitor.b;
    L48:
        InteractLinkFullLinkMonitor.D(r14, r15, RangesKt.coerceAtLeast(r19, r20 - r21), true);
        goto L49
    L47:
        r20 = LinkMonitor.e;
        r21 = LinkMonitor.c;
        goto L48
    L43:
        r16 = LinkMonitor.g;
        r17 = LinkMonitor.c;
        goto L44
    L39:
        r14 = InteractLinkFullLinkMonitor.LinkSource.APPLY;
        goto L40
    L33:
        r8 = LinkMonitor.g;
        r10 = LinkMonitor.c;
        goto L35
    L29:
        r7 = LinkMonitor.e;
        r9 = LinkMonitor.c;
        goto L30
    L25:
        r3 = InteractLinkFullLinkMonitor.LinkSource.APPLY;
        goto L26
    L21:
        r5 = 0;
        goto L22
    L17:
        r4 = LinkMonitor.e;
        r12 = LinkMonitor.c;
        goto L18
    L13:
        r11 = LinkMonitor.g;
        r13 = LinkMonitor.c;
        goto L14
    L5:
        if (r1 != 2) goto L49;
        LinkMonitor.a("PipeLineM", "replyLinkDuration", "[duration] first_frame " + (LinkMonitor.g - LinkMonitor.a) + " link " + (LinkMonitor.e - LinkMonitor.a) + " replyApi " + LinkMonitor.k + " rtc " + (LinkMonitor.f - LinkMonitor.d) + " linkOptInfo " + LinkMonitor.i, null, null, true, 56);
        InteractLinkFullLinkMonitor.LinkSource r22 = InteractLinkFullLinkMonitor.LinkSource.REPLY;
        InteractLinkFullLinkMonitor.D(r22, LinkMonitor.i, LinkMonitor.e - LinkMonitor.a, false);
        if ((LinkMonitor.g - LinkMonitor.a) <= 0) goto L49;
        InteractLinkFullLinkMonitor.D(r22, LinkMonitor.i, RangesKt.coerceAtLeast(LinkMonitor.g - LinkMonitor.a, LinkMonitor.e - LinkMonitor.a), true);
        goto L49
    }
}
