package com.larus.avlink.plugins;

import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a4 extends com.larus.audio.call.arch.a<n4> {
    public final String f;
    public final List<Pair<TriggerMode, String>> g;

    public static final class a implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ a4 b;

        public final String getName() {
            return this.a;
        }

        public a(a4 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r4, jd9.c r5) {
            Intrinsics.checkNotNullParameter(r4, "oldState");
            Intrinsics.checkNotNullParameter(r5, "newState");
            com.larus.avlink.n1.d(this.b.f, "onConnectionStateChanged status=" + r5);
            if ((r5 instanceof jd9.c.a) == false) goto L17;
            a4 r6 = this.b;
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

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;

        public final void n(com.larus.im.service.audio.z0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final String g() {
            return this.a;
        }

        public b(a4 r1) {
            this.a = r1.f;
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return new a(this);
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public final void e3() {
        super.e3();
        if (Intrinsics.areEqual(((n4) getContext()).params().n.m.get("definite_intent_type"), "11") == false) goto L16;
        LinkedHashMap r0 = new LinkedHashMap();
        ouc.g0 r1 = ouc.k.c("1");
        Intrinsics.checkNotNullParameter("query_from_dora_gesture", "key");
        Intrinsics.checkNotNullParameter(r1, "element");
        ouc.i r2 = (ouc.i) r0.put("query_from_dora_gesture", r1);
        ouc.g0 r3 = ouc.k.c("dora_note_open");
        Intrinsics.checkNotNullParameter("query_key", "key");
        Intrinsics.checkNotNullParameter(r3, "element");
        ouc.i r4 = (ouc.i) r0.put("query_key", r3);
        String r5 = new ouc.d0(r0).toString();
        id9.d r6 = ((n4) getContext()).j();
        if (r6 == null) goto L7;
        jd9.c r7 = r6.state();
    L9:
        if ((r7 instanceof jd9.c.a) == false) goto L13;
        com.larus.avlink.n1.d(this.f, "sendBotTrigger. trigger FULL_TEXT_QUERY.");
        id9.d r8 = ((n4) getContext()).j();
        if (r8 == null) goto L14;
        r8.p(TriggerMode.FULL_TEXT_QUERY, r5);
    L14:
        getContext().b(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class), null).m1(new z3());
        return;
    L13:
        com.larus.avlink.n1.d(this.f, "mediaSession is not connected, add to pendingTriggerList.");
        ((ArrayList) this.g).add(TuplesKt.to(TriggerMode.FULL_TEXT_QUERY, r5));
        goto L14
    L7:
        r7 = null;
        goto L9
    }

    public final String T2() {
        return this.f;
    }

    public a4(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraTriggerPlugin";
        this.g = new ArrayList();
    }
}
