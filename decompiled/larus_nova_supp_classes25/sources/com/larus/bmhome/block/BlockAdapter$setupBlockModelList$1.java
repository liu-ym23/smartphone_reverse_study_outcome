package com.larus.bmhome.block;

import androidx.recyclerview.widget.ListUpdateCallback;
import cb8.a;
import cb8.b;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/larus/bmhome/block/BlockAdapter$setupBlockModelList$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onInserted", "", "position", "", "count", "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", "payload", "", "block-kit-impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BlockAdapter$setupBlockModelList$1 implements ListUpdateCallback {
    public final /* synthetic */ a a;

    public BlockAdapter$setupBlockModelList$1(a r1) {
        this.a = r1;
    }

    public final void onInserted(int r3, int r4) {
        Iterator r0 = ((ArrayList) this.a.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).c(r3, r4);
        goto L4
    }

    public final void onMoved(int r3, int r4) {
        Iterator r0 = ((ArrayList) this.a.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).notifyItemMoved(r3, r4);
        goto L4
    }

    public final void onRemoved(int r3, int r4) {
        Iterator r0 = ((ArrayList) this.a.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).b(r3, r4);
        goto L4
    }

    public final void onChanged(int r2, int r3, Object r4) {
        a r5 = this.a;
        int r0 = a.e;
        Iterator r6 = ((ArrayList) r5.c).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((b) r6.next()).a(r2, r3);
        goto L4
    }
}
