package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends b {
    public final Message e;

    @Override // xc8.b
    public final int d() {
        return com.larus.bmhome.chat.bean.d.G0(this.e) ? 1 : 0;
    }

    public a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "nestedFileMessage");
        super(r2);
        this.e = r2;
    }
}
