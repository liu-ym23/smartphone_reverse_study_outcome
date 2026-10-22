package yhb;

import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.MergeForwardReplyInThreadViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements b {
    public final zhb.a a;

    @Override // yhb.b
    public final FlowBaseReplyInThreadViewModel a1() {
        return (FlowBaseReplyInThreadViewModel) this.a.getViewModel(MergeForwardReplyInThreadViewModel.class);
    }

    @Override // yhb.b
    public final List<TitleBarActionKey> a() {
        return CollectionsKt.emptyList();
    }

    public c(zhb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
    }
}
