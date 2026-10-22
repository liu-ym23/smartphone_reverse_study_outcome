package hg8;

import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q implements xc8.g {
    public final int c() {
        return 10;
    }

    public q() {
    }

    public final boolean a(Object r2) {
        Intrinsics.checkNotNullParameter((Message) r2, "sourceData");
        return false;
    }

    public final ei9.f b(Object r8) {
        Message r5 = (Message) r8;
        Intrinsics.checkNotNullParameter(r5, "sourceData");
        return new p(false, 0, true, false, r5, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.BOTTOM_CELL_COMPONENT, 0, 0, 62));
    }
}
