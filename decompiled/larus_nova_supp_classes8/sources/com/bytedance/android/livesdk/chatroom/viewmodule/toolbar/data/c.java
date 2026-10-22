package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a {
    public final /* synthetic */ AudienceMoreDialogManagerService a;
    public final /* synthetic */ String b;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final void onFailed(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final void a() {
        this.a.i(this.b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final void b() {
        AudienceMoreDialogManagerService.c(this.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.a
    public final boolean isShowing() {
        CommonStandardBottomDialog r0 = this.a.c;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() != true) goto L7;
        return true;
    }

    public c(AudienceMoreDialogManagerService r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
