package com.larus.profile.impl.view;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/profile/impl/view/ProfileBotListEmptyViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/profile/api/bean/ProfileBotListEmptyData;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "description", "Landroid/widget/TextView;", "bindData", "", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileBotListEmptyViewHolder extends ListViewHolder<fs9.q> {
    public static final /* synthetic */ int g = 0;
    public final ConstraintLayout e;
    public final TextView f;

    public ProfileBotListEmptyViewHolder(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = r2.findViewById(2131367728);
        this.f = (TextView) r2.findViewById(2131383236);
    }

    public final void T3(Object r3) {
        fs9.q r4 = (fs9.q) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        ((ListViewHolder) this).a = r4;
        int r0 = 0;
        if (r4.a == false) goto L9;
        TextView r5 = this.f;
        if (z2.a.botCreateEnable() == true) goto L8;
        r0 = 8;
    L8:
        r5.setVisibility(r0);
    L10:
        e1.d(this.e, new h(this));
        return;
    L9:
        this.f.setVisibility(0);
        this.f.setText(((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131905477));
        goto L10
    }
}
