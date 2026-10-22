package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkNormalApplyTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkNormalApplyTitleViewHolder extends RecyclerView.ViewHolder {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final boolean e;
    public final com.bytedance.android.live.livepkaudience.presenter.b f;
    public final LinkedList<?> g;

    public static final class a {
    }

    static {
    }

    public PkNormalApplyTitleViewHolder(final View r3, com.bytedance.android.live.livepkaudience.presenter.b r4, LinkedList<?> r5) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.f = r4;
        this.g = r5;
        this.a = LazyKt.lazy(new PkNormalApplyTitleViewHolder$currentOrder$2(r3));
        this.b = LazyKt.lazy(new PkNormalApplyTitleViewHolder$switchSortLayout$2(r3));
        this.c = LazyKt.lazy(new PkNormalApplyTitleViewHolder$tvSortType$2(r3));
        this.d = LazyKt.lazy(new PkNormalApplyTitleViewHolder$ivSwitcher$2(r3));
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L9;
        com.bytedance.live.datacontext.i r7 = r6.isAnchor();
        if (r7 == null) goto L9;
        Boolean r8 = (Boolean) r7.getValue();
        if (r8 == null) goto L9;
        boolean r9 = r8.booleanValue();
    L10:
        this.e = r9;
        jc1.k.n(IUserService.class).user().c();
        return;
    L9:
        r9 = false;
        goto L10
    }
}
