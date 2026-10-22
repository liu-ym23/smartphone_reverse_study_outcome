package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/applywindow/LinkmicApplyFloatViewAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicApplyFloatViewAvatarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Context a;
    public final List<? extends ILinkPlayerInfoBridge> b;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        if (this.b.size() <= 4) goto L6;
        return 4;
    L6:
        return this.b.size();
    }

    public LinkmicApplyFloatViewAvatarAdapter(Context r2, List<? extends ILinkPlayerInfoBridge> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onlineUserList");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) ListProtector.get(this.b, r5);
        if ((r4 instanceof LinkmicApplyFloatViewAvatarViewHolder) == false) goto L9;
        LinkmicApplyFloatViewAvatarViewHolder r1 = (LinkmicApplyFloatViewAvatarViewHolder) r4;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "playerInfo");
        HSImageView r2 = r1.a;
        IBaseUser r3 = r0.getUser();
        if (r3 == null) goto L7;
        k r6 = r3.getAvatarThumbKt();
    L8:
        ImageUtil.loadRoundImage(r2, r6);
        goto L9
    L7:
        r6 = null;
    L9:
        if (r5 <= 0) goto L17;
        View r7 = r4.itemView;
        int r8 = 0 - s1.f(10);
        if ((r7.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if (r9 == null) goto L16;
        ((ViewGroup.MarginLayoutParams) r9).setMargins(r8, 0, 0, 0);
        r7.requestLayout();
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new LinkmicApplyFloatViewAvatarViewHolder(LayoutInflater.from(this.a).inflate(2131566316, r3, false));
    }
}
