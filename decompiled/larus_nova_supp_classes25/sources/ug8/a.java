package ug8;

import com.larus.bmhome.chat.list.cell.text.components.middle.h0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements b {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // ug8.b
    public final h0 a(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        return r2;
    }

    @Override // ug8.b
    public final Message b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return r2;
    }
}
