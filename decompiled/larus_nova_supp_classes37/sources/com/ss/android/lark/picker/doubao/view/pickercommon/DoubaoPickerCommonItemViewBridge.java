package com.ss.android.lark.picker.doubao.view.pickercommon;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.officesdk.utils.AppInfoUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge;
import com.ss.android.lark.picker.base.view.binder.bridge.LeadingContent;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import w3c.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerCommonItemViewBridge;", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridge;", "holder", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerCommonBinderViewHolder;", "tagEnricher", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;", "<init>", "(Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerCommonBinderViewHolder;Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;)V", "checkBoxModel", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "reset", "", "setPrimaryText", "text", "", "setSecondaryText", "setLeadingContent", "content", "Lcom/ss/android/lark/picker/base/view/binder/bridge/LeadingContent;", "setDynamicTag", "tag", "setExtraInfoSummary", "summary", "showMask", "show", "", "applyMaskAlpha", AppInfoUtils.VERSION_TYPE.VERSION_ALPHA, "", "setOnItemClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnItemLongClickListener", "Landroid/view/View$OnLongClickListener;", "attachRightSideView", "view", "Landroid/view/View;", "setAvatar", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "checkState", "model", "updateCheckState", "isChecked", "bindData", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPickerCommonItemViewBridge implements IItemViewBridge {
    private b checkBoxModel;
    private final DoubaoPickerCommonBinderViewHolder holder;
    private final DoubaoChatterTagEnricher tagEnricher;

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void attachRightSideView(View r1) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setDynamicTag(CharSequence r1) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setExtraInfoSummary(CharSequence r1) {
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setSecondaryText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void reset() {
        this.holder.getTvTitle().setText("");
        ((RecyclerView.ViewHolder) this.holder).itemView.setEnabled(true);
        ((RecyclerView.ViewHolder) this.holder).itemView.setAlpha(1.0f);
        applyMaskAlpha(1.0f);
        this.holder.resetAvatarViews$picker_doubao_release();
        this.holder.clearTags();
    }

    private final void applyMaskAlpha(float r2) {
        this.holder.getAvatarContainer().setAlpha(r2);
        this.holder.getTvTitle().setAlpha(r2);
        this.holder.getTagContainer().setAlpha(r2);
        this.holder.getCheckboxContainer().setAlpha(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void bindData(SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        this.holder.bindTitle(r3);
        this.holder.bindAvatar(r3);
        this.holder.bindTags$picker_doubao_release(r3, this.tagEnricher);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void checkState(b r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        ImageView r0 = this.holder.getIvDoubaoCheckbox();
        if (r4.c == false) goto L9;
        this.holder.getCheckboxContainer().setVisibility(0);
        r0.setVisibility(0);
        if (r4.a == false) goto L7;
        int r1 = 2131235900;
    L8:
        r0.setImageResource(r1);
    L10:
        this.checkBoxModel = r4;
        return;
    L7:
        r1 = 2131235901;
        goto L8
    L9:
        this.holder.getCheckboxContainer().setVisibility(8);
        r0.setVisibility(8);
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setAvatar(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        this.holder.bindAvatar(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setLeadingContent(LeadingContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        if ((r2 instanceof LeadingContent.Avatar) == false) goto L5;
        return;
    L5:
        if ((r2 instanceof LeadingContent.Icon) == false) goto L7;
        return;
    L7:
        if ((r2 instanceof LeadingContent.Initial) == false) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((RecyclerView.ViewHolder) this.holder).itemView.setOnClickListener(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setOnItemLongClickListener(View.OnLongClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((RecyclerView.ViewHolder) this.holder).itemView.setOnLongClickListener(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void setPrimaryText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.holder.getTvTitle().setText(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void showMask(boolean r1) {
        if (r1 == false) goto L4;
        float r2 = 0.4f;
    L5:
        applyMaskAlpha(r2);
        return;
    L4:
        r2 = 1.0f;
        goto L5
    }

    @Override // com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge
    public void updateCheckState(boolean r2) {
        b r0 = this.checkBoxModel;
        if (r0 == null) goto L5;
        r0.a = r2;
    L5:
        if (r0 == null) goto L8;
        checkState(r0);
        return;
    }

    public DoubaoPickerCommonItemViewBridge(DoubaoPickerCommonBinderViewHolder r2, DoubaoChatterTagEnricher r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.holder = r2;
        this.tagEnricher = r3;
    }
}
