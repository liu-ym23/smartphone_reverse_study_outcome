package yo1;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.l;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.ComponentConfigManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import zo1.e;
import zo1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class b implements g<s>, e {
    public final HashMap<Integer, c0.b> a;
    public final boolean b;
    public final DataCenter c;
    public final ContainerContextEnv d;

    public abstract boolean o();

    public abstract boolean p(s r1);

    public abstract void s(s r1);

    public abstract void t(s r1);

    public void a() {
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        this.a.clear();
    }

    public b(ContainerContextEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.d = r2;
        this.a = new HashMap();
        this.b = ((Boolean) r2.g.getValue()).booleanValue();
        this.c = r2.f;
    }

    public final c0.b n(s r6) {
        Intrinsics.checkNotNullParameter(r6, "model");
        int r0 = r6.a;
        a0 r1 = this.d.getToolbarConfig(r0);
        l r2 = null;
        if (r1 == null) goto L5;
        c0.b r3 = r1.h(r6, o(), Boolean.valueOf(this.b));
    L6:
        if (r3 == null) goto L8;
        return r3;
    L8:
        if (this.d.getToolbarConfig(r0) == null) goto L11;
        o();
        SparseArray<w> r4 = a0.e;
        Intrinsics.checkNotNullParameter(r6, "button");
        r2 = new l();
    L11:
        return r2;
    L5:
        r3 = null;
        goto L6
    }

    public final void q(String r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if (o() == false) goto L5;
        String r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.a();
    L6:
        ALogger.i(r0, "behavior " + r4);
        return;
    L5:
        r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.b();
        goto L6
    }

    @Override // zo1.g
    public final void e(s r7, ListActionEnum r8) {
        s r1 = r7;
        Intrinsics.checkNotNullParameter(r1, "data");
        Intrinsics.checkNotNullParameter(r8, "action");
        int r9 = a.a[r8.ordinal()];
        if (r9 != 1) goto L5;
        boolean r5 = p(r1);
    L13:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.a.b.j(r1, r8.name(), o(), this.b, r5);
        return;
    L5:
        if (r9 != 2) goto L7;
        s(r1);
    L11:
        r5 = true;
        goto L13
    L7:
        if (r9 != 3) goto L11;
        t(r1);
        goto L11
    }

    public final void r(s r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "data");
        ComponentConfigManager r0 = this.d.a;
        boolean r8 = o();
        if (r0 == null) goto L29;
        if (r15 == false) goto L6;
        String r1 = "cmd_specific_behavior_loaded";
    L7:
        String r9 = r1;
        boolean r2 = this.b;
        Intrinsics.checkNotNullParameter(r14, "toolbarButton");
        a0 r3 = r0.a.get(r14.a);
        if (r3 == null) goto L11;
        String r4 = r3.i(r8, r2);
        if (r4 == null) goto L11;
    L12:
        String r5 = r4;
        DataCenter r11 = this.c;
        if (r11 == null) goto L15;
        r11.put(r9, new ToolbarBehaviorData(r5, r8, r14.l.b, r14.a, r14.d, r14.c));
    L15:
        q("notify to component config.");
        ToolbarButton r6 = null;
        if (r15 == false) goto L23;
        boolean r16 = this.b;
        Intrinsics.checkNotNullParameter(r14, "toolbarButton");
        a0 r7 = r0.a.get(r14.a);
        if (r7 == null) goto L31;
        Intrinsics.checkNotNullParameter(r14, "model");
        a0 r17 = r0.a.get(r14.a);
        if (r17 == null) goto L22;
        r6 = r17.l(r16, r8);
    L22:
        r7.a(r6);
        return;
    L31:
        return;
    L23:
        boolean r18 = this.b;
        Intrinsics.checkNotNullParameter(r14, "toolbarButton");
        a0 r10 = r0.a.get(r14.a);
        if (r10 == null) goto L33;
        Intrinsics.checkNotNullParameter(r14, "model");
        a0 r19 = r0.a.get(r14.a);
        if (r19 == null) goto L28;
        r6 = r19.l(r18, r8);
    L28:
        r10.b(r6);
        return;
    L33:
        return;
    L11:
        r4 = "null";
        goto L12
    L6:
        r1 = "cmd_specific_behavior_un_loaded";
        goto L7
    L29:
        q("configManager is null when notify");
    }
}
