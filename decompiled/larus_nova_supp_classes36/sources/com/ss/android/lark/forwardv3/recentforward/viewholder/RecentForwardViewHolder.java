package com.ss.android.lark.forwardv3.recentforward.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/forwardv3/recentforward/viewholder/RecentForwardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "viewType", "", "<init>", "(Landroid/view/View;I)V", "getViewType", "()I", "value", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "avatarView", "getAvatarView", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "userCheckBox", "getUserCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "Landroid/widget/TextView;", "userNameTv", "getUserNameTv", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "otherIcon", "getOtherIcon", "()Landroid/widget/ImageView;", "Landroid/widget/LinearLayout;", "recentForwardContainer", "getRecentForwardContainer", "()Landroid/widget/LinearLayout;", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RecentForwardViewHolder extends RecyclerView.ViewHolder {
    public final int a;
    public final UDAvatar b;
    public final UDCheckBox c;
    public final TextView d;
    public final ImageView e;
    public final LinearLayout f;

    public RecentForwardViewHolder(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r3;
        this.b = r2.findViewById(2131363751);
        this.c = r2.findViewById(2131392012);
        this.d = (TextView) r2.findViewById(2131392055);
        this.e = (ImageView) r2.findViewById(2131381728);
        this.f = (LinearLayout) r2.findViewById(2131383863);
    }
}
