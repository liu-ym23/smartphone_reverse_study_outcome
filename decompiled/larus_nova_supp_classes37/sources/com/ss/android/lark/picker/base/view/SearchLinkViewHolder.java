package com.ss.android.lark.picker.base.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchLinkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "mUrlAvatarIV", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "getMUrlAvatarIV", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "setMUrlAvatarIV", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;)V", "mUrlNameTV", "Landroid/widget/TextView;", "getMUrlNameTV", "()Landroid/widget/TextView;", "setMUrlNameTV", "(Landroid/widget/TextView;)V", "mUrlContentLayoutLL", "Landroid/widget/LinearLayout;", "getMUrlContentLayoutLL", "()Landroid/widget/LinearLayout;", "setMUrlContentLayoutLL", "(Landroid/widget/LinearLayout;)V", "mUrlContentTV", "getMUrlContentTV", "setMUrlContentTV", "mUrlDetailTV", "getMUrlDetailTV", "setMUrlDetailTV", "mMsgUrlSenderInfoTV", "getMMsgUrlSenderInfoTV", "setMMsgUrlSenderInfoTV", "mMsgUrlOpenChatRL", "Landroid/widget/RelativeLayout;", "getMMsgUrlOpenChatRL", "()Landroid/widget/RelativeLayout;", "setMMsgUrlOpenChatRL", "(Landroid/widget/RelativeLayout;)V", "mMsgUrlOpenChatIv", "Landroid/widget/ImageView;", "getMMsgUrlOpenChatIv", "()Landroid/widget/ImageView;", "setMMsgUrlOpenChatIv", "(Landroid/widget/ImageView;)V", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchLinkViewHolder extends RecyclerView.ViewHolder {
    private ImageView mMsgUrlOpenChatIv;
    private RelativeLayout mMsgUrlOpenChatRL;
    private TextView mMsgUrlSenderInfoTV;
    private LKUIRoundedImageView mUrlAvatarIV;
    private LinearLayout mUrlContentLayoutLL;
    private TextView mUrlContentTV;
    private TextView mUrlDetailTV;
    private TextView mUrlNameTV;
    private final View view;

    public final ImageView getMMsgUrlOpenChatIv() {
        return this.mMsgUrlOpenChatIv;
    }

    public final RelativeLayout getMMsgUrlOpenChatRL() {
        return this.mMsgUrlOpenChatRL;
    }

    public final TextView getMMsgUrlSenderInfoTV() {
        return this.mMsgUrlSenderInfoTV;
    }

    public final LKUIRoundedImageView getMUrlAvatarIV() {
        return this.mUrlAvatarIV;
    }

    public final LinearLayout getMUrlContentLayoutLL() {
        return this.mUrlContentLayoutLL;
    }

    public final TextView getMUrlContentTV() {
        return this.mUrlContentTV;
    }

    public final TextView getMUrlDetailTV() {
        return this.mUrlDetailTV;
    }

    public final TextView getMUrlNameTV() {
        return this.mUrlNameTV;
    }

    public final View getView() {
        return this.view;
    }

    public SearchLinkViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.view = r2;
        this.mUrlAvatarIV = r2.findViewById(2131391946);
        this.mUrlNameTV = (TextView) r2.findViewById(2131391958);
        this.mUrlContentLayoutLL = (LinearLayout) r2.findViewById(2131391950);
        this.mUrlContentTV = (TextView) r2.findViewById(2131391951);
        this.mUrlDetailTV = (TextView) r2.findViewById(2131391953);
        this.mMsgUrlSenderInfoTV = (TextView) r2.findViewById(2131380025);
        this.mMsgUrlOpenChatRL = (RelativeLayout) r2.findViewById(2131380024);
        this.mMsgUrlOpenChatIv = (ImageView) r2.findViewById(2131380023);
    }

    public final void setMMsgUrlOpenChatIv(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mMsgUrlOpenChatIv = r2;
    }

    public final void setMMsgUrlOpenChatRL(RelativeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mMsgUrlOpenChatRL = r2;
    }

    public final void setMMsgUrlSenderInfoTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mMsgUrlSenderInfoTV = r2;
    }

    public final void setMUrlAvatarIV(LKUIRoundedImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mUrlAvatarIV = r2;
    }

    public final void setMUrlContentLayoutLL(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mUrlContentLayoutLL = r2;
    }

    public final void setMUrlContentTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mUrlContentTV = r2;
    }

    public final void setMUrlDetailTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mUrlDetailTV = r2;
    }

    public final void setMUrlNameTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mUrlNameTV = r2;
    }
}
