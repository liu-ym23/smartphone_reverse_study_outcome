package com.ss.android.lark.picker.doubao.view.pickercommon;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avatar.AvatarHelperKt;
import com.ss.android.lark.picker.doubao.ExternalTargetConstants;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u001f\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010,H\u0000¢\u0006\u0002\b-J\u0006\u0010.\u001a\u00020&J\r\u0010/\u001a\u00020&H\u0000¢\u0006\u0002\b0J\u0010\u00101\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u00102\u001a\u00020&2\u0006\u0010'\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerCommonBinderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivAvatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getIvAvatar", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "ivDoubaoCheckbox", "Landroid/widget/ImageView;", "getIvDoubaoCheckbox", "()Landroid/widget/ImageView;", "checkboxContainer", "getCheckboxContainer", "()Landroid/view/View;", "ivAvatarMini", "getIvAvatarMini", "avatarContainer", "getAvatarContainer", "tagContainer", "Landroid/widget/LinearLayout;", "getTagContainer", "()Landroid/widget/LinearLayout;", "boundEntityId", "", "tagBindingVersion", "", "highlightColor", "", "getHighlightColor", "()I", "bindTitle", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "bindAvatar", "bindTags", "tagEnricher", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;", "bindTags$picker_doubao_release", "clearTags", "resetAvatarViews", "resetAvatarViews$picker_doubao_release", "bindThreadAvatar", "bindChatAvatar", "Lcom/ss/android/lark/search/dto/info/SearchChatInfo;", "bindChatterOrChatAvatar", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPickerCommonBinderViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    public static final String EXTRA_KEY_AVATAR_DRAWABLE = "external_target_avatar_drawable";
    public static final String TAG = "DoubaoCustomBinderViewHolder";
    private final View avatarContainer;
    private String boundEntityId;
    private final View checkboxContainer;
    private final int highlightColor;
    private final LarkAvatarView ivAvatar;
    private final LarkAvatarView ivAvatarMini;
    private final ImageView ivDoubaoCheckbox;
    private long tagBindingVersion;
    private final LinearLayout tagContainer;
    private final TextView tvTitle;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerCommonBinderViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_KEY_AVATAR_DRAWABLE", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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

    public final void clearTags() {
        this.tagBindingVersion++;
        this.boundEntityId = null;
        this.tagContainer.removeAllViews();
        this.tagContainer.setVisibility(8);
    }

    public final void resetAvatarViews$picker_doubao_release() {
        this.ivAvatarMini.setVisibility(8);
        this.ivAvatarMini.m(AvatarModel.class);
        this.ivAvatar.m(AvatarModel.class);
    }

    public final View getAvatarContainer() {
        return this.avatarContainer;
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

    public final LarkAvatarView getIvAvatarMini() {
        return this.ivAvatarMini;
    }

    public final ImageView getIvDoubaoCheckbox() {
        return this.ivDoubaoCheckbox;
    }

    public final LinearLayout getTagContainer() {
        return this.tagContainer;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public DoubaoPickerCommonBinderViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.ivAvatar = r2.findViewById(2131376019);
        this.tvTitle = (TextView) r2.findViewById(2131391606);
        this.ivDoubaoCheckbox = (ImageView) r2.findViewById(2131376185);
        this.checkboxContainer = r2.findViewById(2131365642);
        this.ivAvatarMini = r2.findViewById(2131376026);
        this.avatarContainer = r2.findViewById(2131376023);
        this.tagContainer = (LinearLayout) r2.findViewById(2131388092);
        this.highlightColor = ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131105548);
    }

    public static final /* synthetic */ String access$getBoundEntityId$p(DoubaoPickerCommonBinderViewHolder r0) {
        return r0.boundEntityId;
    }

    public static final /* synthetic */ long access$getTagBindingVersion$p(DoubaoPickerCommonBinderViewHolder r2) {
        return r2.tagBindingVersion;
    }

    private final void bindChatAvatar(SearchChatInfo r3) {
        bindChatterOrChatAvatar(r3);
        Integer r4 = DoubaoThreadAvatar.INSTANCE.badgeIconRes(r3);
        if (r4 == null) goto L6;
        int r5 = r4.intValue();
        this.ivAvatarMini.setVisibility(0);
        LarkAvatarView r0 = this.ivAvatarMini;
        a.a r1 = new a.a();
        r1.d(r5);
        r0.j(new a(r1));
        return;
    }

    private final void bindChatterOrChatAvatar(SearchBaseInfo r4) {
        if (Intrinsics.areEqual(r4.getId(), ExternalTargetConstants.DOUBAO_EXTERNAL_TARGET_ID) == false) goto L5;
        return;
    L5:
        LarkAvatarView r0 = this.ivAvatar;
        a.a r1 = new a.a();
        r1.b(r4.getAvatarKey());
        r1.f(r4.getId());
        r0.j(new a(r1));
    }

    private final void bindThreadAvatar(SearchBaseInfo r5) {
        DoubaoThreadAvatar r0 = DoubaoThreadAvatar.INSTANCE;
        Integer r1 = r0.mainIconRes(r5);
        if (r1 == null) goto L6;
        int r2 = r1.intValue();
        LarkAvatarView r3 = this.ivAvatar;
        a.a r4 = new a.a();
        r4.d(r2);
        r3.j(new a(r4));
        this.ivAvatarMini.setVisibility(0);
        LarkAvatarView r6 = this.ivAvatarMini;
        a.a r7 = new a.a();
        r7.b(r5.getAvatarKey());
        r7.f(r0.avatarEntityId(r5));
        r7.h(AvatarModel.Size.MINI);
        r6.j(new a(r7));
        return;
    }

    public final void bindAvatar(SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        resetAvatarViews$picker_doubao_release();
        if (AvatarHelperKt.bindExternalTargetAvatar(this.ivAvatar, r4) == false) goto L5;
        return;
    L5:
        Map r0 = r4.getExtraParams();
        Drawable r1 = null;
        if (r0 == null) goto L8;
        Object r2 = r0.get(EXTRA_KEY_AVATAR_DRAWABLE);
    L10:
        if ((r2 instanceof Drawable) == false) goto L12;
        r1 = (Drawable) r2;
    L12:
        if (r1 == null) goto L16;
        LarkAvatarView r5 = this.ivAvatar;
        a.a r3 = new a.a();
        r3.e(r1);
        r5.j(new a(r3));
        return;
    L16:
        if ((r4 instanceof SearchThreadInfo) == false) goto L18;
    L26:
        bindThreadAvatar(r4);
        return;
    L18:
        if ((r4 instanceof SearchReplyInThreadInfo) == true) goto L26;
        if ((r4 instanceof SearchChatInfo) == false) goto L24;
        bindChatAvatar((SearchChatInfo) r4);
        return;
    L24:
        if ((r4 instanceof SearchChatterInfo) == false) goto L29;
        bindChatterOrChatAvatar(r4);
        return;
    L29:
        return;
    L8:
        r2 = null;
        goto L10
    }

    public final void bindTitle(SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        PickerBaseModuleDependency.getDependency().bindHighLightTitle(this.tvTitle, r5.getTitle(), r5.getTitleTagList(), this.highlightColor);
    }

    public final void bindTags$picker_doubao_release(final SearchBaseInfo r17, DoubaoChatterTagEnricher r18) {
        Intrinsics.checkNotNullParameter(r17, "data");
        clearTags();
        this.boundEntityId = r17.getId();
        final long r3 = this.tagBindingVersion;
        final Function1<DoubaoLocalChatterTagState, Unit> r5 = new DoubaoPickerCommonBinderViewHolder$bindTags$renderTags$1(this, r17);
        r5.invoke(null);
        if ((r17 instanceof SearchChatterInfo) == true) goto L5;
        return;
    L5:
        SearchChatterInfo r1 = (SearchChatterInfo) r17;
        String r2 = r1.getId();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        final String r15 = r2;
        if (r18 == null) goto L16;
        DoubaoPickerTagState r7 = DoubaoPickerTagMapper.map$default(DoubaoPickerTagMapper.INSTANCE, r17, null, 0, 6, null);
        if (r1.getTagData() == null) goto L13;
        boolean r8 = true;
    L14:
        r18.request(r15, r7, r8, new DoubaoPickerCommonBinderViewHolder$bindTags$1(this, r15, r3, r5));
        return;
    L13:
        r8 = false;
        goto L14
    }
}
