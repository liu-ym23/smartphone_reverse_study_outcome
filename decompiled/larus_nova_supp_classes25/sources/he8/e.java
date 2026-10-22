package he8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements je8.a {
    public e() {
    }

    public final boolean a(Object r2) {
        Intrinsics.checkNotNullParameter((Message) r2, "sourceData");
        return false;
    }

    public final ei9.f b(Object r2) {
        Message r3 = (Message) r2;
        Intrinsics.checkNotNullParameter(r3, "sourceData");
        return new d(r3);
    }
}
