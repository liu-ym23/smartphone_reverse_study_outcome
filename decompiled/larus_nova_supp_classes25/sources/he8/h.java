package he8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends ie8.a {
    public final int d;

    @Override // ie8.a
    public final int a() {
        return this.d;
    }

    public h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
        this.d = 4;
    }
}
