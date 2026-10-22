package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.VSOgcDynamicLoader;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j4 implements nm1.w, com.bytedance.android.scope.o {
    public j4() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.b0 a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.b0(r2);
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.w c(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.w(r2);
    }

    public final VSOgcDynamicLoader d(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        return new VSOgcDynamicLoader(r2);
    }
}
