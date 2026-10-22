package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.res.Resources;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.eventbus.DoFollowEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements View.OnClickListener {
    public final /* synthetic */ SelectPairRankAdapter.SelectPairRankItemViewHolder a;
    public final /* synthetic */ IBaseUser b;
    public final /* synthetic */ boolean c;

    public y(SelectPairRankAdapter.SelectPairRankItemViewHolder r1, IBaseUser r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.c == false) goto L12;
        IBaseUser r5 = this.b;
        if (r5 == null) goto L16;
        SelectPairRankAdapter.SelectPairRankItemViewHolder r0 = this.a;
        int r1 = SelectPairRankAdapter.SelectPairRankItemViewHolder.j;
        r0.getClass();
        kz.a r2 = kz.b.a;
        if (r2 != null) goto L9;
    L11:
        xs2.b.a().post(new DoFollowEvent(r5.getIdString(), true));
        return;
    L9:
        if (r2.a() != true) goto L11;
        Resources r6 = s1.getResources();
        Intrinsics.checkNotNull(r6);
        f2.c(r6.getString(2131914662), 0);
        return;
    L16:
        return;
    L12:
        IBaseUser r7 = this.b;
        if (r7 == null) goto L19;
        xs2.b.a().post(new UserProfileEvent(r7.getIdString()).setReportType("data_type_card_linker_rank"));
        return;
    }
}
