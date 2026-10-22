package gg8;

import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements xc8.g {
    public final int c() {
        return 8;
    }

    public h() {
    }

    public final boolean a(Object r2) {
        Intrinsics.checkNotNullParameter((Message) r2, "sourceData");
        return false;
    }

    public final ei9.f b(Object r5) {
        Message r6 = (Message) r5;
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        return new g(r6, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.BOTTOM_CELL_COMPONENT, 0, 0, 62));
    }
}
