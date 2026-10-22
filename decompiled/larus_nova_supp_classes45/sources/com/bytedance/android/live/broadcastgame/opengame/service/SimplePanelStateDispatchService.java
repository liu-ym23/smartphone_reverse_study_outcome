package com.bytedance.android.live.broadcastgame.opengame.service;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00012\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/SimplePanelStateDispatchService;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "a", "b", "c", "d", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimplePanelStateDispatchService implements y10.a, com.bytedance.android.live.broadcastgame.opengame.panel.i, p {
    public static final /* synthetic */ int f = 0;
    public final List<b> a;
    public final Lazy b;
    public final SimplePanelStateDispatchService$lifecycleObserver$1 c;
    public final PluginContext d;
    public final /* synthetic */ i20.a e;

    public static final class a {
    }

    public interface b {
        void r0();

        void s0();

        void t0();

        void v();
    }

    public final class c {
        public final Sequence<Pair<d, d>> a;
        public final Sequence<Pair<d, d>> b;
        public d c;
        public final /* synthetic */ SimplePanelStateDispatchService d;

        public final void a(d r9) {
            Iterator r0 = this.a.iterator();
        L3:
            Object r4 = null;
            if (r0.hasNext() == false) goto L13;
            Object r1 = r0.next();
            Pair r5 = (Pair) r1;
            if (Intrinsics.areEqual((d) r5.getFirst(), this.c) == true) goto L8;
        L10:
            boolean r6 = false;
        L11:
            if (r6 == false) goto L3;
        L15:
            if (((Pair) r1) == null) goto L20;
            Iterator r2 = ((ArrayList) this.d.a).iterator();
        L18:
            if (r2.hasNext() == false) goto L20;
            ((b) r2.next()).s0();
        L20:
            Iterator r3 = this.b.iterator();
        L22:
            if (r3.hasNext() == false) goto L32;
            Object r7 = r3.next();
            Pair r8 = (Pair) r7;
            if (Intrinsics.areEqual((d) r8.getFirst(), this.c) == true) goto L26;
        L28:
            boolean r11 = false;
        L29:
            if (r11 == false) goto L22;
            r4 = r7;
            goto L32
        L26:
            if (Intrinsics.areEqual((d) r8.getSecond(), r9) == false) goto L28;
            r11 = true;
        L32:
            if (((Pair) r4) == null) goto L37;
            SimplePanelStateDispatchService r12 = this.d;
            int r13 = SimplePanelStateDispatchService.f;
            Iterator r14 = ((ArrayList) r12.a).iterator();
        L35:
            if (r14.hasNext() == false) goto L37;
            ((b) r14.next()).t0();
        L37:
            this.c = r9;
            return;
        L8:
            if (Intrinsics.areEqual((d) r5.getSecond(), r9) == false) goto L10;
            r6 = true;
            goto L11
        L13:
            r1 = null;
            goto L15
        }

        public c(SimplePanelStateDispatchService r6, d r7) {
            Intrinsics.checkNotNullParameter(r7, "curState");
            this.d = r6;
            this.c = r7;
            this.a = SequencesKt.sequenceOf(new Pair[]{new Pair(new d(false, true), new d(true, true)), new Pair(new d(true, false), new d(true, true))});
            this.b = SequencesKt.sequenceOf(new Pair[]{new Pair(new d(true, true), new d(false, true)), new Pair(new d(true, true), new d(true, false))});
        }
    }

    public static final class d {
        public boolean a;
        public boolean b;

        public d() {
            this(false, true);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L10;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            if (r4 == true) goto L10;
            r1 = r4;
        L10:
            return r3 + r1;
        }

        public final String toString() {
            return "PanelStateType(isShow=" + this.a + ", isForeground=" + this.b + ")";
        }

        public d(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public static d a(d r1, boolean r2, boolean r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.a;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = r1.b;
        L8:
            r1.getClass();
            return new d(r2, r3);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    public final c d() {
        return (c) this.b.getValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
        int r0 = q.a;
        q.f("SimplePanelStateDispatchService", new Object[]{"turn to hide"});
        c r1 = d();
        r1.a(d.a(r1.c, false, false, 2));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        int r0 = q.a;
        q.f("SimplePanelStateDispatchService", new Object[]{"register lifecycle observer"});
        Context r1 = this.d.getContext();
        if ((r1 instanceof AppCompatActivity) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        ((AppCompatActivity) r1).getLifecycle().addObserver(this.c);
    L8:
        d r2 = d().c;
        r2.a = false;
        r2.b = true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        int r0 = q.a;
        q.f("SimplePanelStateDispatchService", new Object[]{"unregister lifecycle observer"});
        Iterator r1 = ((ArrayList) this.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((b) r1.next()).t0();
        goto L4
    L6:
        Context r2 = this.d.getContext();
        if ((r2 instanceof AppCompatActivity) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        ((AppCompatActivity) r2).getLifecycle().removeObserver(this.c);
    L12:
        this.e.b();
        ((ArrayList) this.a).clear();
        d r3 = d().c;
        r3.a = false;
        r3.b = true;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService$lifecycleObserver$1] */
    public SimplePanelStateDispatchService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.e = new i20.a();
        this.d = r2;
        this.a = new ArrayList();
        this.b = InfraKotlinExtsKt.mainThreadLazy(new SimplePanelStateDispatchService$panelState$2(this));
        this.c = new SimplePanelStateDispatchService$lifecycleObserver$1(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r5) {
        int r6 = q.a;
        q.f("SimplePanelStateDispatchService", new Object[]{"turn to show"});
        c r0 = d();
        r0.a(d.a(r0.c, true, false, 2));
    }
}
