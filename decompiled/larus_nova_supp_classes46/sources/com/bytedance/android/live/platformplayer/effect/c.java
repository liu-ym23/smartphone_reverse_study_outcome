package com.bytedance.android.live.platformplayer.effect;

import com.bytedance.android.livehostapi.foundation.depend.IToolsPluginInstallCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements IToolsPluginInstallCallback {
    public final /* synthetic */ Function0 a;

    public final void onSuccess() {
        this.a.invoke();
        com.bytedance.android.live.player.utils.b.g("LiveVrEffect_VrEffectDownloader", "tools plugin install success");
    }

    public c(Function0 r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        com.bytedance.android.live.player.utils.b.e("tools plugin install failed");
    }
}
