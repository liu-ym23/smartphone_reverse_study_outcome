package com.bytedance.android.live.platformplayer.layout;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface d {
    Context b();

    void c(e r1);

    c d();

    Function0<a> e();

    ILivePlayerScene f();

    BottomContainerSize g();

    DataCenter getDataCenter();

    ILivePlayerClient getLivePlayerClient();

    void getMarginTop();

    Room getRoom();

    int getScreenHeight();

    int getScreenWidth();

    LiveMode getStreamType();

    StreamUrl getStreamUrl();

    TranslationAndScaleProperty getTranslationAndScaleProperty();

    int getVideoHeight();

    int getVideoWidth();

    Function0<a> h();

    boolean isPortrait();
}
