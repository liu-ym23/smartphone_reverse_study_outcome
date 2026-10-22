package ut1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.drawer.LiveMergeDrawerAdapter;
import com.bytedance.android.livesdk.drawer.LiveMergeDrawerViewHolder;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ LiveMergeDrawerViewHolder a;
    public final /* synthetic */ LiveMergeDrawerAdapter b;

    public o(LiveMergeDrawerViewHolder r1, LiveMergeDrawerAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        MergeDrawerViewModel r5 = this.b.h;
        RecyclerView.ViewHolder r0 = null;
        if (r5 == null) goto L16;
        List r6 = r5.isClosedRooms();
        if (r6 == null) goto L16;
        List r7 = r6;
        Room r1 = this.a.f;
        if (r1 == null) goto L9;
        Long r2 = Long.valueOf(r1.id);
    L11:
        if (CollectionsKt.contains(r7, r2) != true) goto L16;
        f2.b(2131920329, 0);
        ListProtector.remove(this.b.a, this.a.getAdapterPosition());
        this.b.notifyItemRemoved(this.a.getAdapterPosition());
        this.b.notifyDataSetChanged();
        int r8 = this.a.getAdapterPosition();
        LiveMergeDrawerAdapter r3 = this.b;
        int r9 = r3.b;
        if (r8 >= r9) goto L28;
        r3.b = r9 - 1;
        return;
    L28:
        return;
    L9:
        r2 = null;
    L16:
        LiveMergeDrawerAdapter r10 = this.b;
        r10.c = r10.b;
        r10.b = this.a.getAdapterPosition();
        LiveMergeDrawerAdapter r11 = this.b;
        int r12 = r11.c;
        if (r12 == (-1)) goto L26;
        RecyclerView.ViewHolder r13 = r11.f.findViewHolderForAdapterPosition(r12);
        if ((r13 instanceof LiveMergeDrawerViewHolder) == false) goto L22;
        r0 = r13;
    L22:
        LiveMergeDrawerViewHolder r14 = (LiveMergeDrawerViewHolder) r0;
        if (r14 != null) goto L25;
        LiveMergeDrawerAdapter r15 = this.b;
        r15.notifyItemChanged(r15.c);
        goto L26
    L25:
        UtilityKotlinExtentionsKt.t(r14.c);
        UtilityKotlinExtentionsKt.t(r14.b);
        r14.c.pauseAnimation();
    L26:
        this.a.T3();
        this.b.f.smoothScrollToPosition(this.a.getAdapterPosition());
    }
}
