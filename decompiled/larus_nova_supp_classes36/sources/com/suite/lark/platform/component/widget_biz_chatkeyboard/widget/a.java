package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0243a {
        void a(PlayControlBar r1);
    }

    Context getContext();

    Object getTag(int r1);

    void pausePlay();

    void resumePlay();

    void setProgress(float r1);

    void startPlay();

    void stopPlay();
}
