package com.bytedance.android.live.room.discovery.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.widget.UnionLiveAvatarImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/discovery/adapter/AnchorTogetherAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/room/discovery/adapter/AnchorTogetherAvatarHolder;", "<init>", "()V", "a", "DiffUtilCallback", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorTogetherAvatarAdapter extends RecyclerView.Adapter<AnchorTogetherAvatarHolder> {
    public final List<IBaseUser> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/discovery/adapter/AnchorTogetherAvatarAdapter$DiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DiffUtilCallback extends DiffUtil.Callback {
        public final List<IBaseUser> a;
        public final List<IBaseUser> b;

        public final int getNewListSize() {
            return RangesKt.coerceAtMost(this.a.size(), 2);
        }

        public final int getOldListSize() {
            return RangesKt.coerceAtMost(this.b.size(), 2);
        }

        public DiffUtilCallback(List<? extends IBaseUser> r2, List<? extends IBaseUser> r3) {
            Intrinsics.checkNotNullParameter(r2, "newList");
            Intrinsics.checkNotNullParameter(r3, "oldList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r4, int r5) {
            if ((!Intrinsics.areEqual(((IBaseUser) ListProtector.get(this.b, r4)).getIdString(), ((IBaseUser) ListProtector.get(this.a, r5)).getIdString())) == false) goto L6;
            return false;
        L6:
            if (r4 != (getOldListSize() - 1)) goto L11;
            if (r5 == (getNewListSize() - 1)) goto L11;
            return false;
        L11:
            if (r4 != (getOldListSize() - 1)) goto L13;
        L15:
            return true;
        L13:
            if (r5 != (getNewListSize() - 1)) goto L15;
            return false;
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            if (r2 == r3) goto L4;
        L6:
            return false;
        L4:
            if (Intrinsics.areEqual((IBaseUser) ListProtector.get(this.a, r3), (IBaseUser) ListProtector.get(this.b, r2)) == false) goto L6;
            return true;
        }

        public final Object getChangePayload(int r4, int r5) {
            if ((!Intrinsics.areEqual(((IBaseUser) ListProtector.get(this.b, r4)).getIdString(), ((IBaseUser) ListProtector.get(this.a, r5)).getIdString())) == false) goto L6;
            return null;
        L6:
            if (r4 != (getOldListSize() - 1)) goto L12;
            if (r5 == (getNewListSize() - 1)) goto L12;
            return 898;
        L12:
            if (r4 != (getOldListSize() - 1)) goto L14;
        L17:
            return null;
        L14:
            if (r5 != (getNewListSize() - 1)) goto L17;
            return 898;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return RangesKt.coerceAtMost(((ArrayList) this.a).size(), 2);
    }

    public AnchorTogetherAvatarAdapter() {
        this.a = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((AnchorTogetherAvatarHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new AnchorTogetherAvatarHolder(LayoutInflater.from(r4.getContext()).inflate(2131567520, r4, false));
    }

    public final void y2(AnchorTogetherAvatarHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        IBaseUser r0 = (IBaseUser) ListProtector.get(this.a, r7);
        int r1 = getItemCount();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "anchor");
        ImageLoader.bindAvatar(r6.a, r0.getAvatarMedium(), UtilityKotlinExtentionsKt.i(18), UtilityKotlinExtentionsKt.i(18));
        ViewGroup.LayoutParams r2 = ((RecyclerView.ViewHolder) r6).itemView.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        boolean r4 = false;
        if (r3 == null) goto L11;
        if (r7 != 0) goto L9;
        int r5 = 0;
    L10:
        r3.leftMargin = r5;
        goto L11
    L9:
        r5 = UtilityKotlinExtentionsKt.i(-8);
    L11:
        UnionLiveAvatarImageView r8 = r6.a;
        if (r1 >= 2) goto L15;
    L17:
        r8.setEnable(r4);
        return;
    L15:
        if (r7 == (r1 - 1)) goto L17;
        r4 = true;
        goto L17
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List r5) {
        AnchorTogetherAvatarHolder r6 = (AnchorTogetherAvatarHolder) r3;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if (r5.isEmpty() == false) goto L5;
        y2(r6, r4);
        return;
    L5:
        boolean r0 = false;
        if (Intrinsics.areEqual(ListProtector.get(r5, 0), 898) == false) goto L16;
        int r7 = getItemCount();
        UnionLiveAvatarImageView r8 = r6.a;
        if (r7 >= 2) goto L11;
    L13:
        r8.setEnable(r0);
        return;
    L11:
        if (r4 == (r7 - 1)) goto L13;
        r0 = true;
        goto L13
    }
}
