package obric.flow.nlwidget.ui.feeds.drag;

import androidx.recyclerview.widget.RecyclerView;
import com.drakeet.multitype.MultiTypeAdapter;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.ui.viewbinder.c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiTypeAdapter f20523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f20524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f20525c;

    public a(MultiTypeAdapter r5, c r10, c r11) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        this.f20523a = r5;
        this.f20524b = r10;
        this.f20525c = r11;
    }

    @Override // com.obric.flow.cardlistpage.ui.viewbinder.c
    public final void a(RecyclerView.ViewHolder r5, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        c r12 = this.f20524b;
        if (r12 == null) goto L5;
        r12.a(r5, r10, r11);
    L5:
        c r13 = this.f20525c;
        if (r13 == null) goto L9;
        r13.a(r5, r10, r11);
        return;
    }

    @Override // com.obric.flow.cardlistpage.ui.viewbinder.c
    public final void b(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        if ((CollectionsKt.getOrNull(this.f20523a.f7569a, r5.getAdapterPosition()) instanceof MiniAppWidgetCardModel) == false) goto L5;
        c r10 = this.f20525c;
    L6:
        if (r10 == null) goto L9;
        r10.b(r5);
        return;
    L9:
        return;
    L5:
        r10 = this.f20524b;
        goto L6
    }

    @Override // com.obric.flow.cardlistpage.ui.viewbinder.c
    public final void c(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        if ((CollectionsKt.getOrNull(this.f20523a.f7569a, r5.getAdapterPosition()) instanceof MiniAppWidgetCardModel) == false) goto L5;
        c r10 = this.f20525c;
    L6:
        if (r10 == null) goto L9;
        r10.c(r5);
        return;
    L9:
        return;
    L5:
        r10 = this.f20524b;
        goto L6
    }
}
