package com.larus.profile.impl;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.larus.profile.impl.view.BotProfileView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/profile/impl/ProfileBotViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/profile/api/bean/ProfileBot;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "profile", "Lcom/larus/profile/impl/view/BotProfileView;", "kotlin.jvm.PlatformType", "bindData", "", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileBotViewHolder extends ListViewHolder<fs9.n> {
    public static final /* synthetic */ int f = 0;
    public final BotProfileView e;

    public ProfileBotViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = (BotProfileView) r2.findViewById(2131364380);
    }

    public final void T3(Object r5) {
        final fs9.n r6 = (fs9.n) r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        ((ListViewHolder) this).a = r6;
        BotProfileView r0 = this.e;
        if (r0 == null) goto L5;
        r0.R5(r6);
    L5:
        ConstraintLayout r1 = this.e;
        if (r1 == null) goto L8;
        com.larus.utils.e1.u(r1, 0.0f, 2131102529, 2131103188);
    L8:
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) this).itemView, new u(this));
        BotProfileView r2 = this.e;
        if (r2 == null) goto L12;
        r2.setAddItemClick(new v(this, r6));
        return;
    }
}
