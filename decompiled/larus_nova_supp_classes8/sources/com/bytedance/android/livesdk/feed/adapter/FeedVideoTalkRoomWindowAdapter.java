package com.bytedance.android.livesdk.feed.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/FeedVideoTalkRoomWindowAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "BaseAudioGuestViewHolder", "a", "EmptyStubViewHolder", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedVideoTalkRoomWindowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final ArrayList<LinkPlayerInfo> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/FeedVideoTalkRoomWindowAdapter$BaseAudioGuestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class BaseAudioGuestViewHolder extends RecyclerView.ViewHolder {
        public final HSImageView a;
        public final HSImageView b;
        public final TextView c;
        public final View d;
        public final View e;

        public BaseAudioGuestViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131374054);
            this.b = r2.findViewById(2131374059);
            this.c = (TextView) r2.findViewById(2131374072);
            this.d = r2.findViewById(2131374080);
            this.e = r2.findViewById(2131374081);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/FeedVideoTalkRoomWindowAdapter$EmptyStubViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class EmptyStubViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public EmptyStubViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390563);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public FeedVideoTalkRoomWindowAdapter() {
        this.a = new ArrayList(6);
        int r0 = 0;
    L4:
        if (r0 > 5) goto L6;
        this.a.add(new LinkPlayerInfo());
        r0 = r0 + 1;
        goto L4
    }

    public final int getItemViewType(int r2) {
        String r3 = ((LinkPlayerInfo) ListProtector.get(this.a, r2)).getInteractId();
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L8:
        return 0;
    L5:
        if (TextUtils.equals(r3, "0") == true) goto L8;
        return 1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof EmptyStubViewHolder) == false) goto L6;
        EmptyStubViewHolder r8 = (EmptyStubViewHolder) r6;
        r8.a.setText(s1.B(2131923178));
        UIUtils.setViewVisibility(r8.a, 0);
        return;
    L6:
        if ((r6 instanceof BaseAudioGuestViewHolder) == false) goto L24;
        BaseAudioGuestViewHolder r9 = (BaseAudioGuestViewHolder) r6;
        LinkPlayerInfo r10 = (LinkPlayerInfo) ListProtector.get(this.a, r7);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "guestInfo");
        HSImageView r0 = r9.a;
        IBaseUser r2 = r10.getUser();
        k r3 = null;
        if (r2 == null) goto L10;
        k r4 = r2.getAvatarMedium();
    L11:
        ImageUtil.loadRoundImage(r0, r4);
        TextView r1 = r9.c;
        IBaseUser r5 = r10.getUser();
        if (r5 == null) goto L14;
        String r11 = r5.getNickName();
    L15:
        r1.setText(LinkPlayerInfo.getUserNameWithCut(r11));
        HSImageView r12 = r9.b;
        IBaseUser r13 = r10.getUser();
        if (r13 == null) goto L18;
        r3 = r13.getAvatarMedium();
    L18:
        ImageLoader.bindImage(r12, r3, new l3(8));
        if (r10.silenceStatus == 0) goto L21;
        r9.d.setVisibility(0);
        r9.e.setVisibility(0);
        return;
    L21:
        r9.d.setVisibility(8);
        r9.e.setVisibility(8);
        return;
    L14:
        r11 = null;
        goto L15
    L10:
        r4 = null;
        goto L11
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 0) goto L6;
        return new EmptyStubViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131566262, r3, false));
    L6:
        return new BaseAudioGuestViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131566263, r3, false));
    }
}
