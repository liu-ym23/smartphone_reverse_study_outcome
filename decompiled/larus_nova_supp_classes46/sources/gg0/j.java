package gg0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSelfDisciplineEndViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends b<MultiLinkSelfDisciplineEndViewBinder.a> {
    public j() {
    }

    @Override // gg0.b
    public final boolean b(tf0.e r3, tf0.e r4) {
        MultiLinkSelfDisciplineEndViewBinder.a r5 = (MultiLinkSelfDisciplineEndViewBinder.a) r3;
        MultiLinkSelfDisciplineEndViewBinder.a r6 = (MultiLinkSelfDisciplineEndViewBinder.a) r4;
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        if (Intrinsics.areEqual(r5.k.getInteractId(), r6.k.getInteractId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.l != r6.l) goto L7;
        return true;
    }
}
