package yhb;

import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowReplyInThreadViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements b {
    public final v a;
    public final zhb.a b;

    @Override // yhb.b
    public final List<TitleBarActionKey> a() {
        return CollectionsKt.listOf(new TitleBarActionKey[]{TitleBarActionKey.FORWARD, TitleBarActionKey.SETTING});
    }

    @Override // yhb.b
    public final FlowBaseReplyInThreadViewModel a1() {
        return (FlowBaseReplyInThreadViewModel) this.b.getViewModel(FlowReplyInThreadViewModel.class);
    }

    public d(v r2, zhb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
    }
}
