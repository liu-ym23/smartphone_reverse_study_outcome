package com.bytedance.android.live.liveinteract.linkpanel.viewbinder;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ TalkRoomSearchResultViewBinder.ResultViewHolder a;
    public final /* synthetic */ TalkRoomSearchResultViewBinder.b b;
    public final /* synthetic */ IBaseUser c;

    public a(TalkRoomSearchResultViewBinder.ResultViewHolder r1, TalkRoomSearchResultViewBinder.b r2, IBaseUser r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r19) {
        String r2 = "anchor";
        if (this.b.a.getSearchType() != 1) goto L16;
        n0 r1 = this.b.a.getWaitingInfo();
        if (r1 == null) goto L7;
        r1.setHasApplied(true);
    L7:
        TalkRoomSearchResultViewBinder.ResultViewHolder r3 = this.a;
        r3.g.wJ(this.b.a, r3.getAdapterPosition());
        n0 r4 = this.b.a.getWaitingInfo();
        if (r4 == null) goto L10;
        String r5 = r4.getButtonText();
    L11:
        boolean r16 = Intrinsics.areEqual(r5, s1.B(2131919207));
        String r6 = this.c.getIdString();
        if (gh0.a.d() == false) goto L14;
        String r7 = "anchor";
    L15:
        m.y(r6, r7, null, "invite_search", false, "", "", "null", "", false, null, r16, MapsKt.emptyMap());
        return;
    L14:
        r7 = "administrator";
        goto L15
    L10:
        r5 = null;
        goto L11
    L16:
        ILinkPlayerInfoBridge r8 = this.b.a.getInviteInfo();
        if (r8 == null) goto L19;
        r8.setHasInvited(true);
    L19:
        TalkRoomSearchResultViewBinder.ResultViewHolder r9 = this.a;
        r9.g.xW(this.b.a, r9.getAdapterPosition());
        ILinkPlayerInfoBridge r10 = this.b.a.getInviteInfo();
        if (r10 == null) goto L35;
        if (r10.getInviteeType() != 2) goto L35;
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L28;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L28;
        boolean r13 = r12.isLiveTypeAudio();
    L29:
        String r14 = this.c.getIdString();
        ILinkPlayerInfoBridge r15 = this.b.a.getInviteInfo();
        if (r15 == null) goto L32;
        boolean r17 = r15.isActive();
    L33:
        m.l(r13, r14, r17, "invite_search", false, null, 96);
        return;
    L32:
        r17 = false;
    L28:
        r13 = false;
    L35:
        if (gh0.a.d() == true) goto L38;
        r2 = "administrator";
    L38:
        m.g(r2, this.c.getIdString(), "invite_search", -1);
    }
}
