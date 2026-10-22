package com.larus.sheet.impl.chat.component;

import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.tencent.open.log.TraceLevel;
import ic8.t;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mw9.a;
import mw9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/sheet/impl/chat/component/SheetCotInfoComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/sheet/api/ISheetCotInfoAbility;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/sheet/api/ISheetCotInfoListener;", "setCotInfo", "", "cotInfo", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "addCotInfoListener", "listener", "removeCotInfoListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetCotInfoComponent extends BaseContentWidget implements a {
    public final CopyOnWriteArraySet<b> m;

    public SheetCotInfoComponent() {
        this.m = new CopyOnWriteArraySet();
    }

    @Override // mw9.a
    public final void f80(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.m.contains(r2) == true) goto L6;
        this.m.add(r2);
        return;
    }

    @Override // mw9.a
    public final void iI(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.m.remove(r2);
    }

    @Override // mw9.a
    public final void s(t r3) {
        Intrinsics.checkNotNullParameter(r3, "cotInfo");
        Iterator<b> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCotInfoUpdate(r3);
        goto L4
    }
}
