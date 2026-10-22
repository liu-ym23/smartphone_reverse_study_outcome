package com.ss.android.lark.picker.doubao;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/picker/doubao/LarkPickerSelectedAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/picker/doubao/LarkPickerSelectedAvatarAdapter$AvatarViewHolder;", "onItemClick", "Lkotlin/Function1;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "items", "", "submitList", "data", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewRecycled", "getItemCount", "AvatarViewHolder", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LarkPickerSelectedAvatarAdapter extends RecyclerView.Adapter<AvatarViewHolder> {
    private final List<SearchBaseInfo> items;
    private final Function1<SearchBaseInfo, Unit> onItemClick;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/doubao/LarkPickerSelectedAvatarAdapter$AvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "avatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "departmentIcon", "<init>", "(Landroid/view/View;Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;Landroid/view/View;)V", "getAvatar", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getDepartmentIcon", "()Landroid/view/View;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class AvatarViewHolder extends RecyclerView.ViewHolder {
        private final LarkAvatarView avatar;
        private final View departmentIcon;

        public final LarkAvatarView getAvatar() {
            return this.avatar;
        }

        public final View getDepartmentIcon() {
            return this.departmentIcon;
        }

        public AvatarViewHolder(View r2, LarkAvatarView r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "avatar");
            Intrinsics.checkNotNullParameter(r4, "departmentIcon");
            super(r2);
            this.avatar = r3;
            this.departmentIcon = r4;
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    public LarkPickerSelectedAvatarAdapter(Function1<? super SearchBaseInfo, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClick");
        this.onItemClick = r2;
        this.items = new ArrayList();
    }

    public static final /* synthetic */ Function1 access$getOnItemClick$p(LarkPickerSelectedAvatarAdapter r0) {
        return r0.onItemClick;
    }

    public void onViewRecycled(AvatarViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.getAvatar().m(AvatarModel.class);
        r3.getAvatar().setVisibility(0);
        r3.getDepartmentIcon().setVisibility(8);
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(null);
    }

    public final void submitList(List<? extends SearchBaseInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.items.clear();
        this.items.addAll(r2);
        notifyDataSetChanged();
    }

    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r1) {
        onViewRecycled((AvatarViewHolder) r1);
    }

    public void onBindViewHolder(AvatarViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        final SearchBaseInfo r8 = (SearchBaseInfo) ListProtector.get(this.items, r7);
        int r1 = 0;
        if ((r8 instanceof SearchDepartmentInfo) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        ((RecyclerView.ViewHolder) r6).itemView.setContentDescription(r8.getTitle());
        View r2 = r6.getDepartmentIcon();
        if (r0 == false) goto L12;
        int r4 = 0;
    L13:
        r2.setVisibility(r4);
        LarkAvatarView r3 = r6.getAvatar();
        if (r0 == false) goto L16;
        r1 = 8;
    L16:
        r3.setVisibility(r1);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new AnonymousClass1(this, r8));
        if (r0 == true) goto L20;
        LarkAvatarView r9 = r6.getAvatar();
        a.a r5 = new a.a();
        r5.b(r8.getAvatarKey());
        r5.f(r8.getId());
        r9.j(new a(r5));
        return;
    L20:
        return;
    L12:
        r4 = 8;
        goto L13
    L5:
        if (r8.getType() == 17) goto L8;
        r0 = false;
        goto L9
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public AvatarViewHolder m3379onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        int r8 = UIHelper.dp2px(40.0f);
        FrameLayout r0 = new FrameLayout(r6.getContext());
        RecyclerView.LayoutParams r1 = new RecyclerView.LayoutParams(r8, r8);
        r1.setMarginEnd(UIHelper.dp2px(12.0f));
        r0.setLayoutParams(r1);
        LarkAvatarView r9 = new LarkAvatarView(r6.getContext());
        r9.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r2 = new FrameLayout(r6.getContext());
        r2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r2.setBackgroundResource(2131231957);
        r2.setVisibility(8);
        ImageView r10 = new ImageView(r2.getContext());
        r10.setImageResource(2131235902);
        r10.setContentDescription(null);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(UIHelper.dp2px(24.0f), UIHelper.dp2px(24.0f));
        r3.gravity = 17;
        Unit r4 = Unit.INSTANCE;
        r2.addView(r10, r3);
        r0.addView(r9);
        r0.addView(r2);
        return new AvatarViewHolder(r0, r9, r2);
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((AvatarViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m3379onCreateViewHolder(r1, r2);
    }
}
