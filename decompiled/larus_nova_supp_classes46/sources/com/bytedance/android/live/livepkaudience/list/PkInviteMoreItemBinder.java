package com.bytedance.android.live.livepkaudience.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.utils.x0;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PkInviteMoreItemBinder extends me.drakeet.multitype.b<j, ViewHolder> {
    public boolean b;
    public final boolean c;
    public final Function0<Unit> d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkInviteMoreItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public PkInviteMoreItemBinder(boolean r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onClick");
        this.c = r2;
        this.d = r3;
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        ViewHolder r5 = (ViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter((j) r4, "item");
        int r6 = al0.d.a;
        boolean r7 = this.c;
        if (al0.d.b() == true) goto L9;
        HashMap r0 = new HashMap();
        if (r7 == false) goto L7;
        String r8 = "voice_live";
    L8:
        r0.put("live_type", r8);
        el0.j.j(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        el0.j.n(r0, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        al0.d.g("livesdk_audience_invite_user_button_show", r0, new Object[0]);
        goto L9
    L7:
        r8 = "video_live";
    L9:
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(x0.a(new PkInviteMoreItemBinder$onBindViewHolder$1(this)));
        if (this.b == true) goto L13;
        this.b = true;
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566355, r5, false));
    }
}
