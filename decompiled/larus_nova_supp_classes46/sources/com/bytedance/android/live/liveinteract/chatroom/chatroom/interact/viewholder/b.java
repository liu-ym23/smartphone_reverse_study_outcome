package com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.viewholder;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LinkApplyUserViewBinder.ViewHolder a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ LinkApplyUserViewBinder c;
    public final /* synthetic */ ILinkPlayerInfoBridge d;

    public b(LinkApplyUserViewBinder.ViewHolder r1, Ref.BooleanRef r2, LinkApplyUserViewBinder r3, ILinkPlayerInfoBridge r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        if (this.b.element == true) goto L5;
        return;
    L5:
        this.c.d.invoke(this.d);
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("position", String.valueOf(this.a.getAdapterPosition()));
        this.d.getPaidAmount();
        r15.put("paid_amount", String.valueOf(this.d.getPaidAmount()));
        TalkRoomLogUtils r3 = TalkRoomLogUtils.B;
        IBaseUser r1 = this.d.getUser();
        Intrinsics.checkNotNull(r1);
        String r4 = r1.getIdString();
        if (this.c.c == false) goto L8;
        String r2 = "anchor";
    L9:
        String r5 = r2;
        o0 r6 = this.d.getWaitingListUserInfo();
        if (r6 == null) goto L12;
        String r7 = r6.getApplyReason();
    L13:
        boolean r8 = !TextUtils.isEmpty(r7);
        IBaseUser r9 = this.d.getUser();
        Intrinsics.checkNotNull(r9);
        TalkRoomLogUtils.s0(r3, r4, r5, null, "list", r8, null, null, null, null, r9.isSubscriber(), null, r15, 1504);
        return;
    L12:
        r7 = null;
        goto L13
    L8:
        r2 = "administrator";
        goto L9
    }
}
