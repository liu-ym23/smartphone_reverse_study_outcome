package com.ss.android.lark.contact.customized.mygroup.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\"\u0010\u0015\u001a\u00020\f2\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ\u0014\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter$GroupItemViewHolder;", "<init>", "()V", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setOnItemClickListener", "listener", "diff", "newItems", BuildConfig.FLAVOR, "bindAvatar", "avatarView", "Landroid/widget/ImageView;", "item", "GroupItemViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyGroupAdapter extends RecyclerView.Adapter<GroupItemViewHolder> {
    public final ArrayList<Chat> a;
    public Function2<? super Chat, ? super Integer, Unit> b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter$GroupItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "root", "getRoot", "()Landroid/view/View;", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GroupItemViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final ImageView b;
        public final TextView c;

        public GroupItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2;
            this.b = (ImageView) r2.findViewById(2131373929);
            this.c = (TextView) r2.findViewById(2131373986);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public OfficeMyGroupAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        GroupItemViewHolder r10 = (GroupItemViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Chat r0 = (Chat) CollectionsKt.getOrNull(this.a, r9);
        if (r0 == null) goto L7;
        r10.c.setText(r0.getName());
        ImageView r1 = r10.b;
        Context r2 = r1.getContext();
        int r3 = UIHelper.dp2px(48.0f);
        String r4 = r0.getAvatarKey();
        String r5 = r0.getId();
        LoadParams r6 = new LoadParams();
        r6.a = r3;
        r6.b = r3;
        ImageModule.a(r2, r1, r4, r5, r6);
        r10.a.setOnClickListener(new a(this, r0, r9));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131559920, r3, false);
        Intrinsics.checkNotNull(r5);
        return new GroupItemViewHolder(r5);
    }
}
