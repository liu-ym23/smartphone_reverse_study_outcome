package com.bytedance.android.live.messagewindow.framework.context;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.live.datacontext.j;
import d71.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c extends y61.b {
    j<y61.a> getCommonCardContext();

    d<v61.a, d71.b> recordManager(MsgWindowPosition r1);

    q71.a stateDispatcher();
}
