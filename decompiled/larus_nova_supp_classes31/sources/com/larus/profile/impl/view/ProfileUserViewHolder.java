package com.larus.profile.impl.view;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/profile/impl/view/ProfileUserViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/profile/api/bean/ProfilePageHeaderInfo;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "userInfo", "Lcom/larus/profile/impl/view/ProfileHeaderUserInfoView;", "kotlin.jvm.PlatformType", "bindData", "", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileUserViewHolder extends ListViewHolder<fs9.v> {
    public static final /* synthetic */ int f = 0;
    public final ProfileHeaderUserInfoView e;

    public ProfileUserViewHolder(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = (ProfileHeaderUserInfoView) r2.findViewById(2131374317);
    }

    public final void T3(Object r3) {
        fs9.v r4 = (fs9.v) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        ((ListViewHolder) this).a = r4;
        this.e.S5(r4.a, r4.b);
        this.e.setAvatarClick(new y(this));
        this.e.setEditClick(new z(this));
        this.e.setQrCodeClick(new a0(this));
    }
}
