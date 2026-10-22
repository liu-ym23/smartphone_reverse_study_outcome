package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.more;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.l;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yo1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MorePanelHandler extends b {
    public final Lazy e;
    public final boolean f;

    @Override // yo1.b
    public final boolean o() {
        return true;
    }

    @Override // yo1.b
    public final void t(s r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // zo1.e
    public final c0.b j(int r2) {
        return this.a.get(Integer.valueOf(r2));
    }

    @Override // yo1.b
    public final boolean p(s r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        int r0 = r6.a;
        if (this.f == true) goto L5;
    L8:
        a0 r1 = this.d.getToolbarConfig(r0);
        if (r1 != null) goto L12;
        q(r6 + " can't find config");
        return false;
    L12:
        ToolbarButton r2 = r1.l(this.b, true);
        if (r2 != null) goto L16;
        q(r2 + " can't find ToolbarButton");
        return false;
    L16:
        c0.b r3 = n(r6);
        if (r3 != null) goto L19;
    L27:
        q(r6 + " behavior is null.");
        return false;
    L19:
        if ((r3 instanceof l) == true) goto L27;
        StringBuilder r4 = new StringBuilder("load ");
        r4.append(r6);
        r4.append(" behavior ");
        if (this.f == false) goto L24;
        String r5 = "for move";
    L25:
        r4.append(r5);
        q(r4.toString());
        this.a.put(Integer.valueOf(r0), r3);
        ((g3) this.e.getValue()).A(r6, r3);
        r(r6, true);
        return true;
    L24:
        r5 = "";
        goto L25
    L5:
        if (g.a.contains(Integer.valueOf(r0)) == true) goto L8;
        q("not move " + r6 + " to more panel");
        return false;
    }

    @Override // yo1.b
    public final void s(s r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        c0.b r0 = this.a.remove(Integer.valueOf(r3.a));
        if (r0 == null) goto L5;
        ((g3) this.e.getValue()).G(r3, r0);
    L5:
        r(r3, false);
    }

    public MorePanelHandler(boolean r2, ContainerContextEnv r3) {
        Intrinsics.checkNotNullParameter(r3, "env");
        super(r3);
        this.f = r2;
        this.e = LazyKt.lazy(new MorePanelHandler$toolbarManager$2(this));
    }
}
