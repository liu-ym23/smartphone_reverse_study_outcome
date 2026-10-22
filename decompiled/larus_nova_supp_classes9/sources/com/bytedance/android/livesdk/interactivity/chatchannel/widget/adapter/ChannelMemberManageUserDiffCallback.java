package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter;

import android.os.Bundle;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListFooterViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberListHeaderViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberSubTitleViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.ChannelMemberTitleViewBinder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.effectplatform.util.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/ChannelMemberManageUserDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelMemberManageUserDiffCallback extends DiffUtil.Callback {
    public final List<Object> a;
    public final List<Object> b;

    public static final class a {
    }

    static {
    }

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public ChannelMemberManageUserDiffCallback(List<? extends Object> r2, List<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldDatas");
        Intrinsics.checkNotNullParameter(r3, "newDatas");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r9, int r10) {
        Object r11 = ListProtector.get(this.a, r9);
        Object r13 = ListProtector.get(this.b, r10);
        if (Intrinsics.areEqual(r11.getClass(), r13.getClass()) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof ChannelMemberTitleViewBinder.b) == false) goto L22;
        if ((r13 instanceof ChannelMemberTitleViewBinder.b) == false) goto L22;
        ChannelMemberTitleViewBinder.b r14 = (ChannelMemberTitleViewBinder.b) r11;
        ChannelMemberTitleViewBinder.b r15 = (ChannelMemberTitleViewBinder.b) r13;
        int r0 = r.a;
        if (r.a(r14.a, r15.a) == true) goto L12;
        return false;
    L12:
        if (r14.b == r15.b) goto L14;
        return false;
    L14:
        if (r14.c == r15.c) goto L16;
        return false;
    L16:
        if (r14.d == r15.d) goto L18;
        return false;
    L18:
        if (r14.f != r15.f) goto L80;
        return true;
    L80:
        return false;
    L22:
        if ((r11 instanceof ChannelMemberListHeaderViewBinder.a) == false) goto L27;
        if ((r13 instanceof ChannelMemberListHeaderViewBinder.a) == false) goto L27;
        return true;
    L27:
        if ((r11 instanceof ChannelMemberSubTitleViewBinder.a) == false) goto L33;
        if ((r13 instanceof ChannelMemberSubTitleViewBinder.a) == false) goto L33;
        int r1 = r.a;
        return r.a(((ChannelMemberSubTitleViewBinder.a) r11).a, ((ChannelMemberSubTitleViewBinder.a) r13).a);
    L33:
        if ((r11 instanceof ChannelLinkUserInfo) == false) goto L71;
        if ((r13 instanceof ChannelLinkUserInfo) == false) goto L71;
        ChannelLinkUserInfo r16 = (ChannelLinkUserInfo) r11;
        ChannelLinkUserInfo r17 = (ChannelLinkUserInfo) r13;
        boolean r2 = Intrinsics.areEqual(r16.a.getCastSecUid(), r17.a.getCastSecUid());
        ChannelLinkUserInfo.a r3 = r16.b;
        ChannelLinkUserInfo.ChannelUserRole r4 = r3.a;
        ChannelLinkUserInfo.a r5 = r17.b;
        if (r4 != r5.a) goto L39;
        boolean r6 = true;
    L41:
        if (r3.b != r5.b) goto L43;
        boolean r7 = true;
    L44:
        ChannelLinkUserInfo.LinkUserInfo r8 = r16.c;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r18 = null;
        if (r8 == null) goto L47;
        Integer r19 = Integer.valueOf(r8.getSilenceStatus());
    L48:
        ChannelLinkUserInfo.LinkUserInfo r20 = r17.c;
        if (r20 == null) goto L51;
        Integer r21 = Integer.valueOf(r20.getSilenceStatus());
    L53:
        if (Intrinsics.areEqual(r19, r21) == false) goto L63;
        ChannelLinkUserInfo.LinkUserInfo r23 = r16.c;
        if (r23 == null) goto L57;
        IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r24 = r23.getVolumeLevel();
    L58:
        ChannelLinkUserInfo.LinkUserInfo r110 = r17.c;
        if (r110 == null) goto L61;
        r18 = r110.getVolumeLevel();
    L61:
        if (r24 != r18) goto L63;
        boolean r25 = true;
    L64:
        if (r2 == false) goto L81;
        if (r6 == false) goto L82;
        if (r7 == false) goto L83;
        if (r25 == false) goto L84;
        return true;
    L84:
        return false;
    L83:
        return false;
    L82:
        return false;
    L81:
        return false;
    L57:
        r24 = null;
    L63:
        r25 = false;
        goto L64
    L51:
        r21 = null;
        goto L53
    L47:
        r19 = null;
        goto L48
    L43:
        r7 = false;
        goto L44
    L39:
        r6 = false;
    L71:
        if ((r11 instanceof ChannelMemberListFooterViewBinder.a) == true) goto L73;
    L75:
        return false;
    L73:
        if ((r13 instanceof ChannelMemberListFooterViewBinder.a) == false) goto L75;
        return true;
    }

    public final boolean areItemsTheSame(int r5, int r6) {
        Object r7 = ListProtector.get(this.a, r5);
        Object r8 = ListProtector.get(this.b, r6);
        if (Intrinsics.areEqual(r7.getClass(), r8.getClass()) == true) goto L6;
        return false;
    L6:
        if ((r7 instanceof ChannelLinkUserInfo) == true) goto L8;
    L18:
        return true;
    L8:
        if ((r8 instanceof ChannelLinkUserInfo) == false) goto L18;
        ChannelLinkUserInfo r9 = (ChannelLinkUserInfo) r7;
        ChannelLinkUserInfo r10 = (ChannelLinkUserInfo) r8;
        if ((!Intrinsics.areEqual(r9.a.getCastSecUid(), r10.a.getCastSecUid())) == false) goto L13;
        return false;
    L13:
        if (r9.b.a == r10.b.a) goto L16;
        return false;
    L16:
        if (r9.a.isMysteryMan() == r10.a.isMysteryMan()) goto L18;
        return false;
    }

    public final Object getChangePayload(int r5, int r6) {
        Object r0 = ListProtector.get(this.a, r5);
        Object r1 = ListProtector.get(this.b, r6);
        if ((r0 instanceof ChannelMemberTitleViewBinder.b) == false) goto L9;
        if ((r1 instanceof ChannelMemberTitleViewBinder.b) == false) goto L9;
        Bundle r7 = new Bundle();
        r7.putBoolean("payload_key_channel_title", true);
        return r7;
    L9:
        if ((r0 instanceof ChannelMemberSubTitleViewBinder.a) == false) goto L15;
        if ((r1 instanceof ChannelMemberSubTitleViewBinder.a) == false) goto L15;
        Bundle r8 = new Bundle();
        r8.putBoolean("payload_key_sub_title", true);
        return r8;
    L15:
        if ((r0 instanceof ChannelLinkUserInfo) == false) goto L21;
        if ((r1 instanceof ChannelLinkUserInfo) == false) goto L21;
        Bundle r9 = new Bundle();
        r9.putBoolean("payload_key_channel_user_item_user_info", true);
        return r9;
    L21:
        return super.getChangePayload(r5, r6);
    }
}
