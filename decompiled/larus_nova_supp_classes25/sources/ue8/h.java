package ue8;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements RecyclerView.RecyclerListener {
    public final /* synthetic */ com.larus.bmhome.chat.exposure.a a;

    public /* synthetic */ h(com.larus.bmhome.chat.exposure.a r1) {
        this.a = r1;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r5) {
        com.larus.bmhome.chat.exposure.a r0 = this.a;
        Intrinsics.checkNotNullParameter(r5, "holder");
        FLogger.a.i("ExposureManager", "recycled: itemView=" + r5.itemView.getClass().getSimpleName() + ", adapterPosition=" + r5.getAdapterPosition());
        final m r1 = r0.b;
        final View r6 = r5.itemView;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "parentView");
        CollectionsKt.removeAll(r1.a.entrySet(), new l(r1, r6));
    }
}
