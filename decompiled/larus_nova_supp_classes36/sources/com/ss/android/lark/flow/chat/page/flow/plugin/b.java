package com.ss.android.lark.flow.chat.page.flow.plugin;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.chatwindow.biz.plugin.FlowChatMessageListViewObserverPlugin;
import com.ss.android.lark.chat.chatwindow.biz.plugin.NewIntentScrollMessagePlugin;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin;
import com.ss.android.lark.chat.chatwindow.biz.plugin.watermark.WaterMarkPlugin;
import com.ss.android.lark.chat.plugin.InitialPositionPlugin;
import com.ss.android.lark.flow.bottomsheet.plugin.FlowBottomSheetPlugin;
import com.ss.android.lark.flow.bottomsheet.plugin.FlowStatusBarPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b implements com.ss.android.lark.chat.chatwindow.biz.plugin.core.e {
    public b() {
    }

    public List<com.ss.android.lark.chat.chatwindow.biz.plugin.core.d> a(FragmentActivity r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        return CollectionsKt.listOf(new BaseChatPlugin[]{new com.ss.android.lark.chat.chatwindow.biz.plugin.b(), new NewIntentScrollMessagePlugin(), new com.ss.android.lark.chat.plugin.a(), new InitialPositionPlugin(), new g(), new l(), new FlowBottomSheetPlugin(), new FlowStatusBarPlugin(), new k(), new h(), new WaterMarkPlugin(), new com.ss.android.lark.chat.chatwindow.chat.v2.plugin.e(), new com.ss.android.lark.chat.chatwindow.biz.plugin.a(), new FlowAskDoubaoPlugin(), new FlowChatMessageListViewObserverPlugin(), new FlowMessageEditPlugin(), new a()});
    }
}
