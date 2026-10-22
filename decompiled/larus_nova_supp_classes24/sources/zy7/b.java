package zy7;

import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements c {
    public final ILarkLynxContainer a;

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
    }

    public b(com.larksuite.component.card.service.b r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceContext");
        this.a = r2.b;
    }

    @Override // zy7.c
    public final void k(List r3) {
        Intrinsics.checkNotNullParameter("universalCardAudioStateChange", "event");
        Intrinsics.checkNotNullParameter(r3, "data");
        ILarkLynxContainer r0 = this.a;
        if (r0 == null) goto L6;
        r0.sendGlobalEventToJS("universalCardAudioStateChange", r3);
        return;
    }
}
