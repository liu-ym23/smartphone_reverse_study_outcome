package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface l {
    com.bytedance.live.datacontext.m<? extends Boolean> getHasChangeOrientation();

    com.bytedance.live.datacontext.j<List<tlc.d>> getHistoryMentionChat();

    com.bytedance.live.datacontext.j<Object> getLikeEggSyncModel();

    com.bytedance.live.datacontext.m<? extends PublicScreenHeatState> getMessageHeat();

    com.bytedance.live.datacontext.j<? extends v42.b> getMessageLogicFacade();

    x getMessagePlugin(Object r1);

    h52.a<h52.d, ? extends h52.c> getMessagePluginByType(MessagePluginType r1);

    com.bytedance.live.datacontext.i<g> getMessageSourceManager();

    e52.a getTextConfig();

    h52.b<? extends h52.c> getViewBinderPluginByItemType(int r1);

    com.bytedance.live.datacontext.m<? extends com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f> getWaitMessageState();

    void insertMessage(i r1);

    void insertMessageSourceData(h52.d r1);

    com.bytedance.live.datacontext.m<? extends Boolean> isMessageListEmpty();

    void registerMessagePlugin(h52.a<h52.d, ? extends h52.c> r1);

    void registerPlugin(x r1);

    void unregisterMessagePlugin(h52.a<h52.d, ? extends h52.c> r1);
}
