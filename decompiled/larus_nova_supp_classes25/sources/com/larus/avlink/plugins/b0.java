package com.larus.avlink.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 extends com.larus.audio.call.arch.a<n4> implements com.larus.audio.call.arch.e {
    public final String f;
    public final List<Pair<TriggerMode, String>> g;

    public static final class a implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ b0 b;

        public final String getName() {
            return this.a;
        }

        public a(b0 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r4, jd9.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            com.larus.avlink.n1.d(this.b.f, "onConnectionStateChanged status=" + r5);
            if ((r5 instanceof jd9.c.a) == false) goto L17;
            b0 r6 = this.b;
            com.larus.avlink.n1.d(r6.f, "resendPendingTrigger. pendingTriggerList: " + r6.g);
            Iterator r7 = ((ArrayList) r6.g).iterator();
        L6:
            if (r7.hasNext() == false) goto L10;
            Pair r0 = (Pair) r7.next();
            TriggerMode r1 = (TriggerMode) r0.component1();
            String r2 = (String) r0.component2();
            id9.d r3 = ((n4) r6.getContext()).j();
            if (r3 == null) goto L6;
            r3.p(r1, r2);
            goto L6
        L10:
            ((ArrayList) r6.g).clear();
            return;
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return new a(this);
    }

    public final void e3() {
        super.e3();
        d98.a.a = false;
        String r0 = d98.a.b;
        if (r0 == null) goto L16;
        LinkedHashMap r1 = new LinkedHashMap();
        ouc.g0 r2 = ouc.k.c(r0);
        Intrinsics.checkNotNullParameter("notice_starling_key", "key");
        Intrinsics.checkNotNullParameter(r2, "element");
        ouc.i r3 = (ouc.i) r1.put("notice_starling_key", r2);
        ouc.d0 r4 = new ouc.d0(r1);
        id9.d r5 = ((n4) getContext()).j();
        if (r5 == null) goto L7;
        jd9.c r6 = r5.state();
    L9:
        if ((r6 instanceof jd9.c.a) == false) goto L13;
        com.larus.avlink.n1.d(this.f, "sendBotTrigger. trigger CLIENT_SUMMON_NOTICE.");
        id9.d r7 = ((n4) getContext()).j();
        if (r7 == null) goto L14;
        r7.p(TriggerMode.CLIENT_SUMMON_NOTICE, r4.toString());
    L14:
        d98.a.b = null;
        return;
    L13:
        com.larus.avlink.n1.d(this.f, "mediaSession is not connected, add to pendingTriggerList.");
        ((ArrayList) this.g).add(TuplesKt.to(TriggerMode.CLIENT_SUMMON_NOTICE, r4.toString()));
        goto L14
    L7:
        r6 = null;
        goto L9
    }

    public final String T2() {
        return this.f;
    }

    public b0(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraDiscoverPlugin";
        this.g = new ArrayList();
    }
}
