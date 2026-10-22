package com.larus.avlink.gallery.processor;

import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.larus.mirabridge.api.pluginservice.VideoStabilizeParams;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m implements Function0 {
    public final /* synthetic */ IDoraPluginService a;
    public final /* synthetic */ VideoStabilizeParams b;

    public /* synthetic */ m(IDoraPluginService r1, VideoStabilizeParams r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        IDoraPluginService r0 = this.a;
        VideoStabilizeParams r1 = this.b;
        return r0.stabilizeVideoPack(AppHost.a.getApplication(), r1);
    }
}
