package sg8;

import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 extends ib8.k {
    public final /* synthetic */ b0 i;

    public c0(b0 r2, kc8.b r3, nb8.c r4) {
        this.i = r2;
        super(r3, r4, null, 4);
    }

    @Override // ib8.g
    public final void b(Message r51, st8.a r52, ow8.a r53, LongClickSource r54) {
        Intrinsics.checkNotNullParameter(r52, "anchorView");
        Intrinsics.checkNotNullParameter(r54, "longClickSource");
        b0 r3 = this.i;
        int r4 = b0.z;
        nb8.c r5 = (nb8.c) r3.x.getValue();
        if (r51 != null) goto L5;
        Message r6 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
    L6:
        r5.b(r6, r53, r52, r54);
        return;
    L5:
        r6 = r51;
        goto L6
    }
}
