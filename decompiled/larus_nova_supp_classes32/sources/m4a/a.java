package m4a;

import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.callback.IIMCallback;
import com.larus.im.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(MessageListRequest r1, IIMCallback r2) {
        Intrinsics.checkNotNullParameter(r1, "msgListReq");
        Intrinsics.checkNotNullParameter(r1, "msgListReq");
        d.e().getMessageListFromLocal(r1, r2);
    }
}
