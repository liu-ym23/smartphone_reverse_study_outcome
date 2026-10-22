package com.larus.bmhome.chat.list.cell.send_file;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends xc8.b {
    public final Message e;

    @Override // xc8.b
    public final int d() {
        return com.larus.bmhome.chat.bean.d.G0(this.e) ? 1 : 0;
    }

    public d(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "sendFileMessage");
        super(r2);
        this.e = r2;
    }
}
