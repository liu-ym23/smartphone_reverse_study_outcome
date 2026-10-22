package com.ss.android.lark.chat.preview.memberlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.chat.preview.components.baseview.CrescentAvatarListView;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0016\u0010\u0014\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/preview/memberlist/MemberListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "chatterInfos", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "itemClickListener", "Lcom/ss/android/lark/chat/preview/memberlist/MemberListAdapter$OnItemClickListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", BuildConfig.FLAVOR, "onBindViewHolder", BuildConfig.FLAVOR, "holder", "position", "getItemCount", "setDataList", "newData", BuildConfig.FLAVOR, "setOnItemClickListener", "OnItemClickListener", "MemberViewHolder", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemberListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<ChatterPreviewChatterInfo> a;
    public a b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/preview/memberlist/MemberListAdapter$MemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getItemView", "()Landroid/view/View;", "avatar", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getAvatar", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "setAvatar", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;)V", "userName", "Landroid/widget/TextView;", "getUserName", "()Landroid/widget/TextView;", "setUserName", "(Landroid/widget/TextView;)V", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MemberViewHolder extends RecyclerView.ViewHolder {
        public final View a;

        public MemberViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2;
            LKUIRoundedImageView2 r0 = r2.findViewById(2131363623);
            TextView r3 = (TextView) r2.findViewById(2131392049);
        }
    }

    public interface a {
        void a(String r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MemberListAdapter a;
        public final /* synthetic */ ChatterPreviewChatterInfo b;

        public b(MemberListAdapter r1, ChatterPreviewChatterInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            a r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a(this.b.getChatterId());
            return;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public MemberListAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        ChatterPreviewChatterInfo r10 = (ChatterPreviewChatterInfo) ListProtector.get(this.a, r9);
        LKUIRoundedImageView2 r0 = r8.itemView.findViewById(2131363623);
        if (r0.getLayoutParams().width <= 0) goto L5;
        int r2 = r0.getLayoutParams().width;
    L7:
        if (r0.getLayoutParams().height <= 0) goto L9;
        int r3 = r0.getLayoutParams().height;
    L10:
        AvatarImage r4 = AvatarImage.Builder.obtain(r10.getAvatarKey(), r10.getChatterId(), r2, r3).build();
        com.ss.android.lark.image.entity.a r5 = CrescentAvatarListView.a(r0.getContext(), r2, r3);
        IRequestCreator r6 = ImageLoader.with(r0.getContext()).load(r4);
        g6b.a.InterfaceC0223a r7 = g6b.a.a;
        if (r7 == null) goto L13;
        r7.c();
    L13:
        r6.isAsync(false).placeholder(r5).override(r2, r3).into(r0);
        ((TextView) r8.itemView.findViewById(2131392049)).setText(r10.getName());
        r8.itemView.findViewById(2131363623).setOnClickListener(new b(this, r10));
        return;
    L9:
        r3 = UIHelper.dp2px(40.0f);
        goto L10
    L5:
        r2 = UIHelper.dp2px(40.0f);
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131563628, r3, false);
        Intrinsics.checkNotNull(r5);
        return new MemberViewHolder(r5);
    }
}
