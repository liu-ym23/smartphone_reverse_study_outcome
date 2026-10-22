package bg8;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.i0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements i0 {
    public h() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final void a(Message r1, ImageContentData r2, Message r3) {
        Intrinsics.checkNotNullParameter(r1, "message");
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final boolean b(Message r1) {
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final boolean c(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.image.i0
    public final void d(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }
}
