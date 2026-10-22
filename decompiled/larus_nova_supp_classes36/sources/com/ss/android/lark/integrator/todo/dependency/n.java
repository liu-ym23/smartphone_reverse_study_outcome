package com.ss.android.lark.integrator.todo.dependency;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements g7c.f {
    public final IIMApi a;

    public final void b(FragmentActivity r2, MergeForwardContent r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "sourceId");
    }

    public final void d(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "threadId");
    }

    public final void e(Chatter r2) {
        Intrinsics.checkNotNullParameter(r2, "pbChatter");
    }

    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
    }

    public final void getChatById(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
    }

    public final void i(String r2, Map r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "chat2MessageMap");
        Intrinsics.checkNotNullParameter(r4, "message2threads");
    }

    public final void n(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
    }

    public final DefaultEmojiPanelData a() {
        return new DefaultEmojiPanelData();
    }

    public n() {
        this.a = (IIMApi) ApiUtils.getApi(IIMApi.class);
    }

    public final List<String> f() {
        return CollectionsKt.emptyList();
    }

    public final List<String> h() {
        return CollectionsKt.emptyList();
    }

    public final Pair<String, CharSequence> generateMergeForwardInfo(MergeForwardContent r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        pxa.a r4 = this.a.generateMergeForwardInfo(r3);
        return new Pair(r4.a, r4.b);
    }

    public final Message c(Entity r2, String r3) {
        return this.a.getMessage(r2, r3);
    }
}
