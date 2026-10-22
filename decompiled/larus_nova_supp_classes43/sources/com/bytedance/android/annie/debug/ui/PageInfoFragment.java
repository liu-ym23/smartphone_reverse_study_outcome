package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.AnnieCard;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/PageInfoFragment;", "Lcom/bytedance/android/annie/debug/ui/AbsInfoDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class PageInfoFragment extends AbsInfoDialogFragment {
    public final LinkedList<y7.d> g;

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final String T90() {
        return "Hybrid调试(长按复制)";
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final List<DialogItem> S90() {
        LinkedList r0 = new LinkedList();
        if (this.g.isEmpty() == false) goto L12;
        AnnieCard r1 = this.d;
        if (r1 == null) goto L9;
        this.g.add(new y7.f(r1));
        if (r1.hybridType() != IHybridComponent.HybridType.LYNX) goto L9;
        this.g.add(new y7.e());
    L9:
        Context r10 = getContext();
        if (r10 == null) goto L12;
        this.g.add(new y7.b(r10));
        this.g.add(new y7.c(r10, this.d));
        this.g.add(new y7.a(r10, this.d));
    L12:
        Iterator<T> r11 = this.g.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        y7.d r12 = (y7.d) r11.next();
        r0.add(new DialogItem(r12.getTitle(), null, null, 6));
        r0.addAll(r12.a());
        goto L14
    L16:
        return r0;
    }

    public PageInfoFragment() {
        this.g = new LinkedList();
    }
}
