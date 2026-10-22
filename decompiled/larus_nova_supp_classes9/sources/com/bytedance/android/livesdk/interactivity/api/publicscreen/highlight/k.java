package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface k {
    void bindContainer(j r1);

    void dismiss(AbsPSHighlightComp r1);

    /* JADX INFO: renamed from: getContainer */
    j mo773getContainer();

    DataCenter getDataCenter();

    boolean getHasComponentShow();

    /* JADX INFO: renamed from: getLaunchManager */
    h mo774getLaunchManager();

    MiddlewareRoomContext getRoomContext();

    m.c getTriggerMapper();

    void release();

    void setHasComponentShow(boolean r1);

    void show(AbsPSHighlightComp r1);

    l stateCenter();
}
