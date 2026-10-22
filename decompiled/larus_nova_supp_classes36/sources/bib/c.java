package bib;

import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.core.model.d;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.chatbase.model.FirstScreenLoader;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends FirstScreenLoader<MessageInfo, x4b.a<MessageInfo>> {
    public final String a() {
        return IOfflineExtraParser.ParserType.THREAD;
    }

    public final String b() {
        return "MockFirstScreenLoader";
    }

    public final boolean d() {
        return false;
    }

    public final void e(List<Integer> r1, IGetDataCallback<Boolean> r2) {
    }

    public final void g() {
    }

    public final void h() {
    }

    public final void c(x4b.a<MessageInfo> r1, d<MessageInfo> r2, List<Integer> r3, IGetDataCallback<d<MessageInfo>> r4) {
        super.c(r1, r2, r3, r4);
    }

    public c(com.ss.android.lark.chat.core.model.a r1, BasePageStore r2, Executor r3, x4b.b r4, CallbackManager r5) {
        super(r1, r2, r3, r4, r5);
    }
}
