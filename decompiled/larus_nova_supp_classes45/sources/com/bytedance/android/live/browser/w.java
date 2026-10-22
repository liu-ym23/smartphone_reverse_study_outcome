package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface w extends IService {
    void addHybridDebugTool(Context r1, ViewGroup r2, String r3, boolean r4);

    com.bytedance.android.live.lynx.api.c create(Activity r1, Integer r2, String r3, LynxThreadStrategy r4, String r5, d0 r6);

    com.bytedance.android.live.lynx.api.d create(Context r1, Integer r2, LynxThreadStrategy r3, d0 r4, String r5);

    com.bytedance.android.live.lynx.api.c createAndLoad(ILiveHybridContainer r1, String r2, Integer r3, LynxThreadStrategy r4, String r5, d0 r6);

    Fragment createLynxFragment(Context r1, Bundle r2, d0 r3);

    <T extends LiveRecyclableWidget> Class<T> createTestWidgetClass();

    d8a.b getAbsTemplateProvider();

    List<com.lynx.tasm.behavior.a> getBehaviorList();

    k7a.a getDynamicComponentFetcher();

    n30.a getHybridMonitor();

    List<com.lynx.tasm.behavior.a> getLiveExportedXElements();

    LynxGroup getLynxGroup(String r1, String[] r2, boolean r3, boolean r4, boolean r5, int r6);

    boolean isEnableDevtoolDebug();

    Object map2TemplateData(Map<String, ? extends Object> r1, String r2);

    void monitorCachePropsInject(String r1, JSONObject r2);

    void monitorLynxListFps(LynxView r1, String r2, String r3, double r4, boolean r6);

    void prepareRemoteDebug(String r1);

    List<com.lynx.tasm.behavior.a> provideLynxLiveBehaviors();

    void reportLynxFallback(String r1, int r2, String r3);

    void reportLynxFetchJsbError(View r1, String r2, String r3, int r4, String r5);

    void setEnableDevtoolDebug(boolean r1);

    void setEnableJSRuntime(LynxViewBuilder r1, boolean r2);

    void setEnableUserCodeCache(LynxViewBuilder r1, boolean r2, String r3);

    long startLynxCast(LynxView r1, String r2, Surface r3, int r4, int r5);

    void stopLynxCast(LynxView r1, String r2, long r3);

    void tryInitEnvIfNeeded(Context r1);

    void updateData(View r1, Object r2, boolean r3);
}
