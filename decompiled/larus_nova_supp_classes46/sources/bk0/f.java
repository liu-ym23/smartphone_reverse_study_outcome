package bk0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final List<e> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends e> r2) {
        Intrinsics.checkNotNullParameter(r2, "mIconFilters");
        this.a = r2;
    }

    public final List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> a(List<? extends com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r5) {
        Intrinsics.checkNotNullParameter(r5, "icons");
        ArrayList r0 = new ArrayList();
        Iterator r6 = ((ArrayList) r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r1 = (com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r6.next();
        Iterator<e> r2 = this.a.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r2.next().a(r1) == true) goto L7;
        boolean r3 = false;
    L12:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L11:
        r3 = true;
        goto L12
    L15:
        return CollectionsKt.toList(r0);
    }
}
