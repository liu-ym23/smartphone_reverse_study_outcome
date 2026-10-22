package com.ss.ttvideoengine.strategy;

import android.os.Handler;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.strategy.source.StrategySource;
import com.ss.ttvideoengine.superresolution.SRStrategyConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StrategyManager {
    public static final int STRATEGY_SCENE_SMALL_VIDEO = 0;
    public static final int STRATEGY_TYPE_COMMON = 0;
    public static final int STRATEGY_TYPE_PRELOAD = 1;
    public static final int STRATEGY_TYPE_PRE_RENDER = 2;
    public static final int VERSION_1 = 1;
    public static final int VERSION_2 = 2;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.strategy.StrategyManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final StrategyManager instance = null;

        private Holder() {
        }

        static {
            instance = new StrategyManager(null);
        }

        public static /* synthetic */ StrategyManager access$100() {
            return instance;
        }
    }

    private StrategyManager() {
    }

    public void addStrategySources(List<StrategySource> r1) {
    }

    public void bufferStart(TTVideoEngine r1, int r2, int r3, int r4) {
    }

    public void clearAll() {
    }

    public void codecType(TTVideoEngineInterface r1, String r2) {
    }

    public void enable(int r1, int r2) {
    }

    public boolean enableEngineLooper() {
        return false;
    }

    public void engineCreate(TTVideoEngineInterface r1) {
    }

    public void enginePlay(TTVideoEngine r1) {
    }

    public TTVideoEngine getPreRenderEngine(StrategySource r1) {
        return null;
    }

    public TTVideoEngine getPreRenderEngine(String r1) {
        return null;
    }

    public void initGearGlobalConfig() {
    }

    public void mdlStart(AVMDLDataLoaderConfigure r1) {
    }

    public void onPrepared(TTVideoEngineInterface r1) {
    }

    public TTVideoEngine removePreRenderEngine(String r1) {
        return null;
    }

    public void setListener(EngineStrategyListener r1) {
    }

    public void setStrategySources(List<StrategySource> r1) {
    }

    public void setVideoInfo(TTVideoEngineInterface r1, VideoInfo r2) {
    }

    public void startSpeedPredictor() {
    }

    public void updateSRStrategyConfig(SRStrategyConfig r1) {
    }

    public Handler handler() {
        throw new UnsupportedOperationException("tob only");
    }

    public void mdlCleanCache() {
        throw new UnsupportedOperationException("tob only");
    }

    public int version() {
        throw new UnsupportedOperationException("tob only");
    }

    public static StrategyManager instance() {
        return Holder.access$100();
    }

    public /* synthetic */ StrategyManager(AnonymousClass1 r1) {
        this();
    }

    public void engineRenderStart(TTVideoEngine r2) {
        throw new UnsupportedOperationException("tob only");
    }
}
