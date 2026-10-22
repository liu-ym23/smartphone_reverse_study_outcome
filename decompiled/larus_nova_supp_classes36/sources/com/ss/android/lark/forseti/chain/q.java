package com.ss.android.lark.forseti.chain;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import com.ss.android.lark.forseti.node.ForsetiNode;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements ForsetiPlaceHolderFragment.b {
    public final /* synthetic */ ForsetiChainHelper a;
    public final /* synthetic */ ForsetiNode b;

    public final void a(int r3) {
        Log.i("FST_ChainHelper", "onPlaceholderUpdated() called with: navigationId = " + r3);
        this.a.g(this.b);
        ForsetiNode r4 = this.b;
        Iterator r0 = com.larksuite.framework.utils.p.a(CollectionsKt.drop(r4.i, 1)).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r4.h((Fragment) r0.next());
        goto L4
    }

    public q(ForsetiChainHelper r1, ForsetiNode r2) {
        this.a = r1;
        this.b = r2;
    }
}
