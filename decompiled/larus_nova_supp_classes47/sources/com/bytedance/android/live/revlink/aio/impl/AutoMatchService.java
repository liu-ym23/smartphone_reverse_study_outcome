package com.bytedance.android.live.revlink.aio.impl;

import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.multianchor.match.g;
import com.bytedance.android.livesdk.link.model.IBattlePrecisionMatcher;
import com.bytedance.android.livesdk.link.model.h0;
import com.bytedance.android.scope.o;
import i41.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k11.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r41.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AutoMatchService implements d, o {
    public final c a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/aio/impl/AutoMatchService$AutoMatchEvent;", "", "UNDEFINED", "START", "CANCEL", "MATCHED", "TIMEOUT", "ERROR", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AutoMatchEvent extends Enum<AutoMatchEvent> {
        public static final AutoMatchEvent CANCEL = null;
        public static final AutoMatchEvent ERROR = null;
        public static final AutoMatchEvent MATCHED = null;
        public static final AutoMatchEvent START = null;
        public static final AutoMatchEvent TIMEOUT = null;
        public static final AutoMatchEvent UNDEFINED = null;
        public static final /* synthetic */ AutoMatchEvent[] a = null;

        static {
            AutoMatchEvent r1 = new AutoMatchEvent("UNDEFINED", 0);
            UNDEFINED = r1;
            AutoMatchEvent r2 = new AutoMatchEvent("START", 1);
            START = r2;
            AutoMatchEvent r3 = new AutoMatchEvent("CANCEL", 2);
            CANCEL = r3;
            AutoMatchEvent r4 = new AutoMatchEvent("MATCHED", 3);
            MATCHED = r4;
            AutoMatchEvent r5 = new AutoMatchEvent("TIMEOUT", 4);
            TIMEOUT = r5;
            AutoMatchEvent r6 = new AutoMatchEvent("ERROR", 5);
            ERROR = r6;
            a = new AutoMatchEvent[]{r1, r2, r3, r4, r5, r6};
        }

        public static AutoMatchEvent valueOf(String r1) {
            return (AutoMatchEvent) r27.a.a(AutoMatchEvent.class, r1);
        }

        public static AutoMatchEvent[] values() {
            return (AutoMatchEvent[]) a.clone();
        }

        public AutoMatchEvent(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public AutoMatchService(c r1) {
        this.a = r1;
    }

    @Override // k11.d
    public final void updateAutoMatchState(long r2, int r4) {
        if (b.a == true) goto L5;
        return;
    L5:
        int r3 = (int) r2;
        com.bytedance.android.live.revlink.impl.pk.service.a r0 = null;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r1 = null;
        if (r3 != 1) goto L8;
    L34:
        c r5 = this.a;
        if (r5 == null) goto L37;
        r0 = r5.ja();
    L37:
        if (r0 == null) goto L49;
        List<p> r6 = r0.getListeners();
        if (r6 == null) goto L50;
        Iterator<p> r7 = r6.iterator();
    L42:
        if (r7.hasNext() == false) goto L52;
        r7.next().z1(r4, r3);
        goto L42
    L52:
        return;
    L50:
        return;
    L49:
        return;
    L8:
        if (r3 == 12) goto L34;
        if (r3 == 13) goto L34;
        if (r3 != 4) goto L15;
    L24:
        c r8 = this.a;
        if (r8 == null) goto L27;
        r1 = r8.Mf();
    L27:
        if (r1 == null) goto L47;
        ArrayList<g.b> r9 = r1.getListeners();
        if (r9 == null) goto L48;
        Iterator<g.b> r10 = r9.iterator();
    L32:
        if (r10.hasNext() == false) goto L51;
        r10.next().z1(r4, r3);
        goto L32
    L51:
        return;
    L48:
        return;
    L47:
        return;
    L15:
        if (r3 == 9) goto L24;
        if (r3 == 10) goto L24;
        if (r3 == 11) goto L24;
        if (r3 == 6) goto L24;
        if (r3 == 7) goto L24;
    }

    @Override // k11.d
    public final void updateAutoMatchPredictWaitTime(long r7, long r9, long r12, h0 r13) {
        Intrinsics.checkNotNullParameter(r13, "previewUser");
        if (b.a == true) goto L5;
        return;
    L5:
        int r8 = (int) r7;
        com.bytedance.android.live.revlink.impl.pk.service.a r0 = null;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r1 = null;
        if (r8 != 1) goto L8;
    L34:
        c r10 = this.a;
        if (r10 == null) goto L37;
        r0 = r10.ja();
    L37:
        if (r0 == null) goto L49;
        List<p> r14 = r0.getListeners();
        if (r14 == null) goto L50;
        Iterator<p> r15 = r14.iterator();
    L42:
        if (r15.hasNext() == false) goto L52;
        r15.next().r4(r9, r12, r13);
        goto L42
    L52:
        return;
    L50:
        return;
    L49:
        return;
    L8:
        if (r8 == 12) goto L34;
        if (r8 == 13) goto L34;
        if (r8 != 4) goto L15;
    L24:
        c r16 = this.a;
        if (r16 == null) goto L27;
        r1 = r16.Mf();
    L27:
        if (r1 == null) goto L47;
        ArrayList<g.b> r17 = r1.getListeners();
        if (r17 == null) goto L48;
        Iterator<g.b> r18 = r17.iterator();
    L32:
        if (r18.hasNext() == false) goto L51;
        r18.next().r4(r9, r12, r13);
        goto L32
    L51:
        return;
    L48:
        return;
    L47:
        return;
    L15:
        if (r8 == 9) goto L24;
        if (r8 == 10) goto L24;
        if (r8 == 11) goto L24;
        if (r8 == 6) goto L24;
        if (r8 == 7) goto L24;
    }

    @Override // k11.d
    public final void updateMatchBell(long r1, String r3, long r4, long r6, int r8, IBattlePrecisionMatcher r9, IBattlePrecisionMatcher r10) {
        Intrinsics.checkNotNullParameter(r3, "precisionMatchId");
        Intrinsics.checkNotNullParameter(r9, "ownerAnchor");
        Intrinsics.checkNotNullParameter(r10, "oppositeAnchor");
        boolean r2 = b.a;
        boolean r5 = b.a;
    }
}
