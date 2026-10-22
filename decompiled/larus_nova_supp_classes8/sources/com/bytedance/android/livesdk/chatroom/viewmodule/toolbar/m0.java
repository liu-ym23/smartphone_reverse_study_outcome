package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a {
    public final /* synthetic */ i0.c a;
    public final /* synthetic */ i0.f b;

    public m0(i0.c r1, i0.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "path");
        i0.c r4 = this.a;
        r4.c = r3;
        r4.b = true;
        r4.getClass();
        this.b.onFinish();
        i0.e.getClass();
        ((ArrayList) i0.d).add(r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a
    public final void onFail(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "path");
        this.a.b = true;
        this.b.onFinish();
    }
}
