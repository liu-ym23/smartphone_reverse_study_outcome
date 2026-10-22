package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 extends lh0.b {
    public final String d;
    public fd2.e e;
    public final j1 f;

    @Override // lh0.b
    public final void d() {
        super.d();
        fd2.e r0 = this.e;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.e = null;
    }

    public final void f(ih0.f r12, ih0.h r13) {
        Intrinsics.checkNotNullParameter(r12, "updateStatus");
        Intrinsics.checkNotNullParameter(r13, "updateCallback");
        JsonObject r1 = r12.d;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = g0.a[r12.getType().ordinal()];
        boolean r4 = true;
        if (r2 != 1) goto L8;
        fd2.e r14 = this.e;
        if (r14 == null) goto L34;
        JsonObject r15 = r14.handleDynamicJsbUpdateAction(r1);
    L35:
        if (r15 == null) goto L37;
        Intrinsics.checkNotNullParameter(r13, "updateCallback");
        lh0.c.a.a(r13, r15);
    L38:
        a(r13, null);
        return;
    L37:
        e(r13, "");
        goto L38
    L34:
        r15 = null;
        goto L35
    L8:
        if (r2 != 2) goto L38;
        Integer r0 = je0.d.h();
        if (r0 != null) goto L14;
    L16:
        JsonObject r3 = r12.d;
        if (r3 == null) goto L19;
        JsonElement r5 = r3.get("user_id");
    L20:
        String r6 = StringsKt.replace$default(String.valueOf(r5), "\"", "", false, 4, null);
        if (r6 != null) goto L23;
    L26:
        if (r4 == false) goto L28;
        return;
    L28:
        ALogger.i("MultiLinkDynamicWidget", "OPEN_EMOJI_PANEL " + r12.d + ' ' + r6);
        DataCenter r16 = this.c;
        if (r16 == null) goto L38;
        r16.put("data_dynamic_show_emoji_panel", r6);
        goto L38
    L23:
        if (r6.length() == 0) goto L26;
        r4 = false;
        goto L26
    L19:
        r5 = null;
        goto L20
    L14:
        if (r0.intValue() != 61) goto L16;
    }

    public h0(Context r2, DataCenter r3, j1 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
        this.f = r4;
        this.d = "RealTimeChorusDynamicHandler";
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L5;
        fd2.e r5 = r0.loadChorusDynamicJsbService(r2, r3, r4);
    L6:
        this.e = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }
}
