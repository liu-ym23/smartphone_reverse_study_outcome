package com.larus.uaigc.chat.markdown.video.statemanager;

import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a {
    ChatPageContext M1();

    ISketchLoadingController a();

    String b();

    CoroutineScope c();

    Boolean d();

    LarusWidgetMarkdownCreationSingleVideoBinding d0();

    q0.a f();

    String getBotId();

    String getCurrentPage();

    View getHostView();

    boolean l();
}
