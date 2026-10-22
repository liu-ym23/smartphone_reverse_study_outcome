package s2b;

import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p<T> implements AndroidThrottle.e {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    public final void a(Collection<MessageInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "tasks");
        this.a.e(r4, false, null);
    }
}
