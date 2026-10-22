package com.obric.memorydata.recommend.tile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/recommend/tile/ScreenObservationTilePluginBootstrap;", "", "<init>", "()V", "register", "", "unregister", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationTilePluginBootstrap {
    public static final ScreenObservationTilePluginBootstrap INSTANCE = null;

    static {
        INSTANCE = new ScreenObservationTilePluginBootstrap();
    }

    private ScreenObservationTilePluginBootstrap() {
    }

    @JvmStatic
    public static final void register() {
        ScreenObservationTileRegistry.registerDelegate((IScreenObservationTileDelegate) ZeusTransformUtils.preCheckCast(new a(), IScreenObservationTileDelegate.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void unregister() {
        ScreenObservationTileRegistry.unregisterDelegate();
    }
}
