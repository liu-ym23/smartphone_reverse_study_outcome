package com.bytedance.android.live.liveinteract.linkpanel.list;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InviteMoreItemBinder extends me.drakeet.multitype.b<l, ViewHolder> {
    public boolean b;
    public final int c;
    public final boolean d;
    public final Function0<Unit> e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/InviteMoreItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        ViewHolder r10 = (ViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter((l) r9, "item");
        if (this.c != 4) goto L5;
        View r11 = ((RecyclerView.ViewHolder) r10).itemView;
        r11.setPadding(r11.getPaddingLeft(), UtilityKotlinExtentionsKt.i(10), r11.getPaddingRight(), r11.getPaddingBottom());
        HashMap r12 = new HashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r12);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r12, null, 6);
        r12.put("request_page", "invite");
        Pair<String, String> r3 = com.bytedance.android.live.liveinteract.linkpanel.util.m.e();
        r12.put(r3.getFirst(), r3.getSecond());
        j0.l().sendLog("livesdk_anchor_invite_user_button_show", r12, new Object[]{IRoom.class, x.class});
    L5:
        boolean r13 = this.d;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.m.h() == true) goto L12;
        HashMap r4 = new HashMap();
        if (r13 == false) goto L10;
        String r14 = "voice_live";
    L11:
        r4.put("live_type", r14);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r4, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), 4);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.H(r4, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        com.bytedance.android.live.liveinteract.linkpanel.util.m.L("livesdk_audience_invite_user_button_show", r4, new Object[0]);
        goto L12
    L10:
        r14 = "video_live";
    L12:
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new n(this));
        if (this.b == true) goto L16;
        this.b = true;
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566412, r5, false));
    }

    public InviteMoreItemBinder(int r2, boolean r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onClick");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
