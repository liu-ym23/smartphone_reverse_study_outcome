package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AnchorToolbarButtonMoreDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarDisableController;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends AudienceMoreDialogManagerService {
    public final String h;
    public final ToolbarDisableController i;
    public final boolean j;
    public final a k;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogManagerService
    public final CommonStandardBottomDialog d() {
        AnchorToolbarButtonMoreDialog r0 = new AnchorToolbarButtonMoreDialog(getContext(), !this.b);
        ToolbarDisableController r1 = this.i;
        Intrinsics.checkNotNullParameter(r1, "controller");
        r0.D = r1;
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogManagerService
    public final f e() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogManagerService
    public final String f() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogManagerService
    public final boolean g() {
        return this.j;
    }

    public b(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dc");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        super(r2, r3);
        this.h = "AnchorMoreDialogManagerService";
        this.i = new ToolbarDisableController(getContext());
        this.j = true;
        this.k = new a(this.f, getContext());
    }
}
