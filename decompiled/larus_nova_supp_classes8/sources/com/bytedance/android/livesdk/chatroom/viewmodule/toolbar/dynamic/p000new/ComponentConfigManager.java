package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ComponentConfigManager implements o {
    public final SparseArray<a0> a;

    public final void b() {
        int r0 = this.a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.a.valueAt(r1).p();
        r1 = r1 + 1;
        goto L3
    L5:
        this.a.clear();
    }

    public ComponentConfigManager() {
        this.a = new SparseArray();
    }

    public final void c(String r4) {
        ALogger.i(a.b.getTAG(), "config: " + r4);
    }

    public final void d(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        int r0 = ((NewToolbarButtonConstants) r5.b.getValue()).getId();
        ALogger.i(a.b.getTAG(), "register config id: " + r0);
        this.a.put(r0, r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final a0 getToolbarConfig(int r2) {
        return this.a.get(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final void register(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        d(r2);
    }

    public final boolean a(final s r5, boolean r6, boolean r7, final DataCenter r8) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r0 = r5.a;
        a0 r1 = this.a.get(r0);
        Function1<String, Unit> r2 = new ComponentConfigManager$canLoad$errorReport$1(r5, r8);
        if (r1 != null) goto L7;
        HashMap<String, String> r9 = q.a;
        q.a(r0, ToolbarReasonTag.CONFIG_ERROR, " can't find config");
        c(r5 + " can't find config");
        a r10 = a.b;
        r10.g(r5.a, r10.e(), "NotFoundConfig");
        r2.invoke(ErrorReason.NOT_FOUND_CONFIG.getValue());
        return false;
    L7:
        if (r1.l(r6, false) != null) goto L11;
        c(" button is null.");
        HashMap<String, String> r11 = q.a;
        q.a(r0, ToolbarReasonTag.CONFIG_ERROR, " local button is null");
        r2.invoke(ErrorReason.LOCAL_BUTTON_IS_NULL.getValue());
        return false;
    L11:
        if (r1.c(r5, r7, r6) == true) goto L14;
        c("behavior is null");
        HashMap<String, String> r12 = q.a;
        q.a(r0, ToolbarReasonTag.CONFIG_ERROR, " behavior is null");
        r2.invoke(ErrorReason.BEHAVIOR_IS_NULL.getValue());
        return false;
    L14:
        return true;
    }
}
