package zc8;

import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends b {
    @Override // xc8.b
    public final int d() {
        return d.G0(this.a) ? 1 : 0;
    }

    public a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
    }
}
