package com.ss.android.lark.picker.base.view.binder.bridge;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import w3c.b;
import w3c.f;
import w3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/bridge/DefaultItemViewBridge;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridge;", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "<init>", "(Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;)V", "avatarItemView", "Lcom/ss/android/lark/picker/base/view/avataritem/AvatarItemView;", "reset", "", "setPrimaryText", "text", "", "setSecondaryText", "setLeadingContent", "content", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "setDynamicTag", "tag", "setExtraInfoSummary", "summary", "showMask", "show", "", "checkState", "model", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "updateCheckState", "isChecked", "setOnItemClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnItemLongClickListener", "Landroid/view/View$OnLongClickListener;", "attachRightSideView", "view", "Landroid/view/View;", "setAvatar", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class DefaultItemViewBridge implements IItemViewBridge {
    private final AvatarItemView avatarItemView;
    private final ChatterChatViewHolder holder;

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setDynamicTag(CharSequence r1) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setExtraInfoSummary(CharSequence r1) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void reset() {
        this.avatarItemView.resetAllViews();
    }

    public DefaultItemViewBridge(ChatterChatViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.holder = r2;
        this.avatarItemView = r2.getAvatarItemView().getItem();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void attachRightSideView(View r7) {
        if (r7 != null) goto L4;
        this.avatarItemView.removeRightView();
        return;
    L4:
        AvatarItemView.attachRightView$default(this.avatarItemView, r7, false, false, 6, null);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void bindData(SearchBaseInfo r1) {
        IItemViewBridge.DefaultImpls.bindData(this, r1);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void checkState(b r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.avatarItemView.checkState(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setAvatar(SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        AvatarItemView r0 = this.avatarItemView;
        a.a r1 = new a.a();
        r1.b(r4.getAvatarKey());
        r1.f(r4.getId());
        r0.avatar(new a(r1));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setLeadingContent(LeadingContent r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        if ((r4 instanceof LeadingContent.Avatar) == false) goto L6;
        AvatarItemView r0 = this.avatarItemView;
        a.a r1 = new a.a();
        LeadingContent.Avatar r5 = (LeadingContent.Avatar) r4;
        r1.b(r5.getKey());
        r1.f(r5.getId());
        r0.avatar(new a(r1));
        return;
    L6:
        if ((r4 instanceof LeadingContent.Icon) == false) goto L8;
        return;
    L8:
        if ((r4 instanceof LeadingContent.Initial) == false) goto L11;
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((RecyclerView.ViewHolder) this.holder).itemView.setOnClickListener(r2);
        this.holder.getAvatarItemView().setOnClickListener(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemLongClickListener(View.OnLongClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((RecyclerView.ViewHolder) this.holder).itemView.setOnLongClickListener(r2);
        this.holder.getAvatarItemView().setOnLongClickListener(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setPrimaryText(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "text");
        this.avatarItemView.title(new g(r5.toString(), false, 14));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setSecondaryText(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.avatarItemView.subTitle(new f(r3.toString()));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void showMask(boolean r1) {
        if (r1 == false) goto L4;
        this.holder.getAvatarItemView().showShadow();
        return;
    L4:
        this.holder.getAvatarItemView().hideShadow();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void updateCheckState(boolean r2) {
        this.avatarItemView.updateCheckState(r2);
    }
}
