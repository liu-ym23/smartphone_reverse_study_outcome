package com.ss.android.lark.picker.doubao.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.PickerRecentSpaceInfo;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obb.b;
import sbb.c;
import tz7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010$\u001a\u00020%H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010 \u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00060"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/DoubaoCustomBinderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivAvatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getIvAvatar", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvSubtitle", "getTvSubtitle", "ivDoubaoCheckbox", "Landroid/widget/ImageView;", "getIvDoubaoCheckbox", "()Landroid/widget/ImageView;", "checkboxContainer", "getCheckboxContainer", "()Landroid/view/View;", "docCoverPaddingPx", "", "getDocCoverPaddingPx", "()I", "docCoverPaddingPx$delegate", "Lkotlin/Lazy;", "coverSizePx", "getCoverSizePx", "coverSizePx$delegate", "highlightColor", "getHighlightColor", "bindTitle", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "bindSummary", "getSpaceInfo", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "bindAvatar", "bindDocAvatar", "bindCoverAvatar", "spaceInfo", "isPic", "", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoCustomBinderViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    public static final String TAG = "DoubaoCustomBinderViewHolder";
    private final View checkboxContainer;
    private final Lazy coverSizePx$delegate;
    private final Lazy docCoverPaddingPx$delegate;
    private final int highlightColor;
    private final LarkAvatarView ivAvatar;
    private final ImageView ivDoubaoCheckbox;
    private final TextView tvSubtitle;
    private final TextView tvTitle;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/DoubaoCustomBinderViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final int getCoverSizePx() {
        return ((Number) this.coverSizePx$delegate.getValue()).intValue();
    }

    private final int getDocCoverPaddingPx() {
        return ((Number) this.docCoverPaddingPx$delegate.getValue()).intValue();
    }

    public final View getCheckboxContainer() {
        return this.checkboxContainer;
    }

    public final int getHighlightColor() {
        return this.highlightColor;
    }

    public final LarkAvatarView getIvAvatar() {
        return this.ivAvatar;
    }

    public final ImageView getIvDoubaoCheckbox() {
        return this.ivDoubaoCheckbox;
    }

    public final TextView getTvSubtitle() {
        return this.tvSubtitle;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public DoubaoCustomBinderViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.ivAvatar = r2.findViewById(2131376019);
        this.tvTitle = (TextView) r2.findViewById(2131391606);
        this.tvSubtitle = (TextView) r2.findViewById(2131391531);
        this.ivDoubaoCheckbox = (ImageView) r2.findViewById(2131376185);
        this.checkboxContainer = r2.findViewById(2131365642);
        this.docCoverPaddingPx$delegate = LazyKt.lazy(DoubaoCustomBinderViewHolder$docCoverPaddingPx$2.INSTANCE);
        this.coverSizePx$delegate = LazyKt.lazy(DoubaoCustomBinderViewHolder$coverSizePx$2.INSTANCE);
        this.highlightColor = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131105548);
    }

    private final void bindCoverAvatar(SearchSpaceInfo r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        this.ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ivAvatar.setPadding(getDocCoverPaddingPx(), getDocCoverPaddingPx(), getDocCoverPaddingPx(), getDocCoverPaddingPx());
        boolean r1 = false;
        this.ivAvatar.setOval(false);
        c r0 = c.a;
        String r2 = r11.getDocUrl();
        r0.getClass();
        b r3 = c.c(c.e(r2), r11.getIconInfo());
        if (r3 == null) goto L7;
        String r4 = r3.b;
    L8:
        String r5 = r4;
        if (r5 != null) goto L11;
    L12:
        r1 = true;
    L13:
        if (r1 == false) goto L16;
        bindDocAvatar(r11);
        return;
    L16:
        PickerBaseModuleDependency.getDependency().loadDocCover(this.ivAvatar.getContext(), this.ivAvatar, r5, getCoverSizePx(), getCoverSizePx(), "near", 4);
        return;
    L11:
        if (r5.length() != 0) goto L13;
    L7:
        r4 = null;
        goto L8
    }

    private final void bindDocAvatar(SearchBaseInfo r8) {
        SearchSpaceInfo r9 = getSpaceInfo(r8);
        a.a r0 = new a.a();
        if (r9 == null) goto L5;
        String r2 = r9.getDocUrl();
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        Intrinsics.checkNotNullParameter(r2, "url");
        r0.k = r2;
        IconShape r4 = IconShape.SQUARE;
        Intrinsics.checkNotNullParameter(r4, "shape");
        r0.m = r4;
        if (r9 != null) goto L12;
    L24:
        a r10 = new a(r0);
        this.ivAvatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.ivAvatar.setOval(false);
        this.ivAvatar.j(r10);
        return;
    L12:
        if (r9.getDocType() != Doc.Type.SHORTCUT) goto L14;
        boolean r5 = true;
    L15:
        Boolean r6 = Boolean.valueOf(r5);
        if (r6.booleanValue() == true) goto L19;
        r6 = null;
    L19:
        obb.a r7 = new obb.a(r6, r9.getIsShareFolder(), null);
        Intrinsics.checkNotNullParameter(r7, "container");
        r0.n = r7;
        String r11 = r9.getIconInfo();
        if (r11 == null) goto L23;
        r3 = r11;
    L23:
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_RESERVED_FIELD.META);
        r0.l = r3;
        goto L24
    L14:
        r5 = false;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    private final SearchSpaceInfo getSpaceInfo(SearchBaseInfo r2) {
        if ((r2 instanceof SearchWikiInfo) == false) goto L6;
        return ((SearchWikiInfo) r2).getSpaceInfo();
    L6:
        if ((r2 instanceof SearchSpaceInfo) == true) goto L11;
        return null;
    L11:
        return (SearchSpaceInfo) r2;
    }

    private final boolean isPic(SearchBaseInfo r3) {
        String r1 = null;
        if ((r3 instanceof SearchWikiInfo) == false) goto L8;
        SearchSpaceInfo r4 = ((SearchWikiInfo) r3).getSpaceInfo();
        if (r4 == null) goto L10;
        String r5 = r4.getIconInfo();
    L11:
        c.a.getClass();
        b r6 = c.c(null, r5);
        PickerBaseModuleDependency.IPickerCommonModuleDependency r0 = PickerBaseModuleDependency.getDependency();
        if (r6 == null) goto L15;
        r1 = r6.c;
    L15:
        return r0.isSupportDocCover(r1);
    L10:
        r5 = null;
        goto L11
    L8:
        if ((r3 instanceof SearchSpaceInfo) == false) goto L10;
        r5 = ((SearchSpaceInfo) r3).getIconInfo();
        goto L11
    }

    public final void bindAvatar(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (isPic(r2) == false) goto L6;
        bindCoverAvatar(getSpaceInfo(r2));
        return;
    L6:
        bindDocAvatar(r2);
    }

    public final void bindSummary(SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        SearchSpaceInfo r6 = getSpaceInfo(r5);
        if (r6 != null) goto L6;
        return;
    L6:
        if ((r6 instanceof PickerRecentSpaceInfo) == false) goto L8;
        int r0 = 2131889605;
    L9:
        String r7 = UIHelper.mustacheFormat(r0, "time", SearchCommonUtils.getSearchResultTimeForLong(((RecyclerView.ViewHolder) this).itemView.getContext(), r6.getUpdateTime(), true));
        TextUtils.TruncateAt r1 = TextUtils.TruncateAt.END;
        int r2 = ((RecyclerView.ViewHolder) this).itemView.getContext().getResources().getColor(2131106620);
        this.tvSubtitle.setTextColor(r2);
        PickerBaseModuleDependency.getDependency().bindHighLightTitle(this.tvSubtitle, r7, null, this.highlightColor);
        return;
    L8:
        r0 = 2131889604;
        goto L9
    }

    public final void bindTitle(SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if ((r5 instanceof SearchWikiInfo) == false) goto L9;
        SearchWikiInfo r0 = (SearchWikiInfo) r5;
        SearchSpaceInfo r1 = r0.getSpaceInfo();
        if (r1 == null) goto L8;
        String r2 = r1.getTitle();
        if (r2 == null) goto L8;
    L10:
        PickerBaseModuleDependency.getDependency().bindHighLightTitle(this.tvTitle, r2, r5.getTitleTagList(), this.highlightColor);
        return;
    L8:
        r2 = r0.getTitle();
        goto L10
    L9:
        r2 = r5.getTitle();
        goto L10
    }
}
