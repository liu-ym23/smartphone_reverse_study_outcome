package zgb;

import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.flow.chatthread.page.FlowChatThreadViewModel;
import kotlin.jvm.internal.Intrinsics;
import x4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements z0 {
    public final FlowChatThreadViewModel a;
    public final v b;

    public b(FlowChatThreadViewModel r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "chatAppContainer");
        this.a = r2;
        this.b = r3;
    }

    public final y0 a(BasePageStore r12, d r13, d r14, CallbackManager r15, String r16, MutableLiveData r17, int r18) {
        Intrinsics.checkNotNullParameter(r12, "pageStore");
        Intrinsics.checkNotNullParameter(r13, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r14, "workExecutor");
        Intrinsics.checkNotNullParameter(r15, "callbackManager");
        Intrinsics.checkNotNullParameter(r16, "chatId");
        Intrinsics.checkNotNullParameter(r17, "currentChatLiveData");
        return new a(r12, this.b, this.a, r13, r14, r15, r16, r17);
    }
}
