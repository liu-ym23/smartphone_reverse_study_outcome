package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.d0;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.MessageListScrollFeature;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a {
    s2b.g C();

    d0 c();

    Map<Class<? extends com.ss.android.lark.biz.im.api.message.params.l>, com.ss.android.lark.biz.im.api.message.params.l> d();

    com.ss.android.lark.chat.chatwindow.chat.a getAdapter();

    SceneCoordinateRecyclerView getRecyclerView();

    v4b.d j();

    void n(com.ss.android.lark.chat.chatwindow.chat.v2.widget.c.InterfaceC0082c<y6b.c<?>> r1);

    Long q();

    void s(MessageListScrollFeature.d r1);

    List<y6b.c<?>> t();

    boolean v();

    List<y6b.c<?>> w();

    FirstMessagePaddingType z();
}
