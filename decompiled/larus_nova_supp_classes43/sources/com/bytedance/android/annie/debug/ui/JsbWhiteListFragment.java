package com.bytedance.android.annie.debug.ui;

import com.bytedance.android.annie.card.base.HybridDomainUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/JsbWhiteListFragment;", "Lcom/bytedance/android/annie/debug/ui/AbsInfoDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class JsbWhiteListFragment extends AbsInfoDialogFragment {
    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final String T90() {
        return "JSB白名单";
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final List<DialogItem> S90() {
        LinkedList r0 = new LinkedList();
        Iterator r1 = ((List) HybridDomainUtils.a.getValue()).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add(new DialogItem(null, (String) r1.next(), null, 4));
        goto L4
    L6:
        return r0;
    }

    public JsbWhiteListFragment() {
    }
}
