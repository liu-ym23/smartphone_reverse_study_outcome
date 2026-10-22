package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IAudienceLeaveInfoResponse;
import com.bytedance.android.livesdk.chatroom.model.IUserInfoInLinkmic;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements BannerWidget.a {
    public final /* synthetic */ LinkResultDialogFragmentV2 a;

    @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
    public final boolean a() {
        return true;
    }

    public v(LinkResultDialogFragmentV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
    public final void b(boolean r5, Map<String, String> r6) {
        this.a.p = Boolean.valueOf(r5);
        LinkResultDialogFragmentV2 r7 = this.a;
        if (r7.k != null) goto L5;
        return;
    L5:
        if (r7.p == null) goto L45;
        ExtraResponse<IAudienceLeaveInfoResponse, Extra> r8 = r7.n;
        IUserInfoInLinkmic r0 = null;
        if (r8 == null) goto L9;
        IAudienceLeaveInfoResponse r1 = r8.data;
    L10:
        if (r1 == null) goto L46;
        if (r8 == null) goto L15;
        IAudienceLeaveInfoResponse r9 = r8.data;
        if (r9 == null) goto L15;
        r0 = r9.getUserInfoInLinkmic();
    L15:
        Pair[] r10 = new Pair[4];
        String r2 = "";
        if (r0 == null) goto L21;
        Long r3 = r0.getLinkDuration();
        if (r3 == null) goto L21;
        String r4 = String.valueOf(r3.longValue());
        if (r4 == null) goto L21;
    L22:
        r10[0] = TuplesKt.to("link_duration", r4);
        if (r0 == null) goto L26;
        String r11 = r0.getAddFanTicketStr();
        if (r11 == null) goto L26;
    L27:
        r10[1] = TuplesKt.to("money", r11);
        if (r0 == null) goto L31;
        String r12 = r0.getAddFanTicketStr();
        if (r12 == null) goto L31;
    L32:
        r10[2] = TuplesKt.to("new_fans_cnt", r12);
        if (r0 == null) goto L40;
        Long r13 = r0.getScoreMoreThan();
        if (r13 == null) goto L40;
        String r14 = String.valueOf(r13.longValue());
        if (r14 == null) goto L40;
        r2 = r14;
    L40:
        r10[3] = TuplesKt.to("win_part", r2);
        Map<String, String> r15 = MapsKt.mutableMapOf(r10);
        BannerWidget.a r16 = r7.k;
        if (r16 == null) goto L47;
        Boolean r17 = r7.p;
        Intrinsics.checkNotNull(r17);
        r16.b(r17.booleanValue(), r15);
        return;
    L47:
        return;
    L31:
        r12 = "";
    L26:
        r11 = "";
    L21:
        r4 = "";
        goto L22
    L46:
        return;
    L9:
        r1 = null;
        goto L10
    }
}
