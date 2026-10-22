package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.panel.FullScreenOpenPanel;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class c<T> implements m {
    public T a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.m
    public final void a() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AsyncCreatePanelFactory", new Object[]{"real create panel if not, has created: " + this.b});
        if (this.b == true) goto L13;
        this.b = true;
        com.bytedance.android.live.broadcastgame.opengame.sonicgame.i r1 = (com.bytedance.android.live.broadcastgame.opengame.sonicgame.i) this;
        AtomicInteger r2 = FullScreenOpenPanel.E;
        Integer r3 = (Integer) r1.a;
        Context r4 = r1.c.K.getContext();
        Long r5 = Long.valueOf(r1.c.K.m.a);
        boolean r6 = r1.c.K.o;
        Intrinsics.checkNotNullParameter(r4, "ctx");
        if (r3 == null) goto L7;
        int r7 = r3.intValue();
    L8:
        InteractGameContext r8 = InteractGameContext.Companion.getContext();
        if (r8 == null) goto L11;
        r8.setGameFullPanelIsShowing(true);
    L11:
        Intent r9 = new Intent(r4, FullScreenOpenPanel.class);
        r9.putExtra("token", r7);
        r9.putExtra("room_id", r5);
        r9.putExtra("is_anchor", r6);
        Unit r11 = Unit.INSTANCE;
        r4.startActivity(r9);
        this.a = (T) Integer.valueOf(r7);
        return;
    L7:
        r7 = FullScreenOpenPanel.E.getAndIncrement();
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.l
    public final void q0() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AsyncCreatePanelFactory", new Object[]{"create panel lazily"});
        this.a = (T) Integer.valueOf(FullScreenOpenPanel.E.getAndIncrement());
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.l
    public final void r0(Function0<Unit> r4, Function1<? super com.bytedance.android.live.broadcastgame.opengame.panel.h, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Integer r1 = (Integer) this.a;
        Intrinsics.checkNotNullParameter(r5, "block");
        if (r1 == null) goto L23;
        int r2 = r1.intValue();
        AtomicInteger r3 = FullScreenOpenPanel.E;
        Intrinsics.checkNotNullParameter(r5, "block");
        if (FullScreenOpenPanel.G.contains(Integer.valueOf(r2)) == false) goto L8;
        if (r4 == null) goto L24;
        Unit r6 = (Unit) r4.invoke();
        return;
    L24:
        return;
    L8:
        WeakReference<FullScreenOpenPanel> r0 = FullScreenOpenPanel.F.get(Integer.valueOf(r2));
        if (r0 == null) goto L11;
        FragmentActivity r7 = (FullScreenOpenPanel) r0.get();
    L12:
        if (r7 != null) goto L14;
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = null;
        r8.element = FullScreenOpenPanel.H.subscribe(new com.bytedance.android.live.broadcastgame.opengame.panel.b(r2, r5, r8));
        return;
    L14:
        if (r7.isDestroyed() != true) goto L16;
    L19:
        if (r4 == null) goto L27;
        Unit r9 = (Unit) r4.invoke();
        return;
    L27:
        return;
    L16:
        if (r7.isFinishing() == true) goto L19;
        r5.invoke(r7);
        return;
    L11:
        r7 = null;
        goto L12
    }
}
