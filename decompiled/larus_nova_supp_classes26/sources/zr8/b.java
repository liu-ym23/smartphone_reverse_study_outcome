package zr8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends xc8.b {
    public final CharSequence e;

    public final int d() {
        return -1;
    }

    public b(Message r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "systemMessage");
        super(r2);
        this.e = r3;
    }
}
