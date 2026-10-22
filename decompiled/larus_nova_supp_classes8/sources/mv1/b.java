package mv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerPlaceHolderViewHolder;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements b90.a {
    public final /* synthetic */ com.bytedance.android.livesdk.feed.j a;

    public b(com.bytedance.android.livesdk.feed.tab.repository.l r1) {
        this.a = r1;
    }

    public final BaseViewHolder<Object> a(ViewGroup r4, Object[] r5) {
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131565982, r4, false);
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L15;
        Object r1 = r5[0];
        if ((r1 instanceof l) == false) goto L15;
        if (r1 == null) goto L13;
        ((l) r1).a();
        goto L15
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L15:
        if (r5.length <= 4) goto L23;
        Object r7 = r5[4];
        if ((r7 instanceof PublishSubject) == false) goto L23;
        if (r7 == null) goto L21;
        PublishSubject r8 = (PublishSubject) r7;
        goto L23
    L21:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L23:
        return new DrawerPlaceHolderViewHolder(r6, this.a);
    L5:
        r0 = false;
        goto L7
    }
}
