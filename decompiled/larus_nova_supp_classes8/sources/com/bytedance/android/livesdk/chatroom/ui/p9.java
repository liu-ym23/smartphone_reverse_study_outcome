package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarMoreDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.Panel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.ea0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p9 {
    public List<ExtendedToolbarButton> a;
    public List<? extends ToolbarButton> b;
    public List<? extends ToolbarButton> c;
    public final Context d;
    public final boolean e;
    public final boolean f;

    public final Dialog a() {
        Context r1 = this.d;
        boolean r0 = this.e;
        boolean r5 = this.f;
        int r2 = ep1.d.a;
        ep1.c r4 = ep1.d.a(Panel.MORE);
        List r3 = this.a;
        List<? extends ToolbarButton> r6 = this.b;
        List r7 = this.c;
        int r8 = q9.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "layoutStrategy");
        Intrinsics.checkNotNullParameter(r6, "stableAreaStateConfigList");
        if (r5 == true) goto L5;
        if (r0 == false) goto L11;
        return new LiveToolbarMoreDialog(r1, r6, null, r4, r5);
    L11:
        if (ea0.a.getValue().booleanValue() == false) goto L19;
        if (r3 != null) goto L15;
        r3 = new ArrayList();
    L15:
        if (r7 != null) goto L25;
        r7 = new ArrayList();
    L25:
        return new AudienceLiveToolbarMoreDialog(r1, r3, r6, r7);
    L19:
        if (r7 != null) goto L22;
        r7 = new ArrayList();
    L22:
        return new LiveToolbarMoreDialog(r1, r6, r7, r4, r5);
    L5:
        if (r3 != null) goto L23;
        r3 = new ArrayList();
    L23:
        return new LandscapeTopMoreDialog(r1, r3, r6);
    }

    public final Context getContext() {
        return this.d;
    }

    public p9(Context r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.b = new ArrayList();
    }
}
