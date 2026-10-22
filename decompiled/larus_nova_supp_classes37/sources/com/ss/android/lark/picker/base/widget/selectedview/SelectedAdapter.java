package com.ss.android.lark.picker.base.widget.selectedview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.search.v2.MailContactMeta;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.calendar.EmailAvatarUtil;
import com.ss.android.lark.picker.base.view.avatar.AvatarHelperKt;
import com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.search.dto.info.EmailInfo;
import com.ss.android.lark.search.dto.info.PhoneInfo;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchPermissionGroupInfo;
import com.ss.android.lark.search.dto.info.SearchPersonnelTypeInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.search.dto.info.SearchUserTeamInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import com.ss.android.lark.utils.UIHelper;
import wz7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class SelectedAdapter extends LarkRecyclerViewBaseAdapter<SelectedMemberViewHolder, SearchBaseInfo> {
    private static final int AVATAR_SIZE_IN_PIX = 0;
    private static final float AVATAR_TEXT_SIZE_IN_PIX = 0.0f;
    private Context mContext;
    private boolean mIsEnableChatPreview;
    private OnItemRemoveListener mItemRemoveListener;

    public interface OnItemRemoveListener {
        void onItemRemove(SearchBaseInfo r1);
    }

    public static class SelectedMemberViewHolder extends RecyclerView.ViewHolder {
        public LarkAvatarView miniAvatar;
        public LarkAvatarView selectedAvatar;
        public View userTeamBadge;

        public SelectedMemberViewHolder(View r2) {
            super(r2);
            this.selectedAvatar = r2.findViewById(2131385830);
            this.miniAvatar = r2.findViewById(2131380140);
            this.userTeamBadge = r2.findViewById(2131385849);
        }
    }

    static {
        AVATAR_SIZE_IN_PIX = UIHelper.dp2px(40.0f);
        AVATAR_TEXT_SIZE_IN_PIX = UIHelper.sp2px(14.0f);
    }

    public SelectedAdapter(Context r2) {
        this.mIsEnableChatPreview = false;
        this.mContext = r2;
    }

    public static /* synthetic */ OnItemRemoveListener access$000(SelectedAdapter r0) {
        return r0.mItemRemoveListener;
    }

    public void setIsEnableChatPreview(boolean r1) {
        this.mIsEnableChatPreview = r1;
    }

    public void setOnItemRemoveListener(OnItemRemoveListener r1) {
        this.mItemRemoveListener = r1;
    }

    private void bindAvatar(SelectedMemberViewHolder r13, SearchBaseInfo r14) {
        r13.selectedAvatar.setTag(r14.getId());
        if (AvatarHelperKt.bindExternalTargetAvatar(r13.selectedAvatar, r14) == false) goto L6;
        return;
    L6:
        if ((r14 instanceof EmailInfo) == false) goto L9;
        r13.selectedAvatar.setImageBitmap(EmailAvatarUtil.getEmailAvatarBitmapByName(((EmailInfo) r14).getAddress(), AVATAR_SIZE_IN_PIX, this.mContext));
        return;
    L9:
        if ((r14 instanceof SearchDepartmentInfo) == false) goto L12;
        r13.selectedAvatar.setImageResource(2131237788);
        return;
    L12:
        if ((r14 instanceof SearchPersonnelTypeInfo) == false) goto L15;
        r13.selectedAvatar.setImageResource(2131247267);
        return;
    L15:
        if ((r14 instanceof SearchPermissionGroupInfo) == false) goto L18;
        r13.selectedAvatar.setImageResource(2131247266);
        return;
    L18:
        if ((r14 instanceof SearchMailContactInfo) == false) goto L33;
        if (TextUtils.isEmpty(r14.getAvatarKey()) == false) goto L33;
        SearchMailContactInfo r0 = (SearchMailContactInfo) r14;
        if (MailContactMeta.ContactType.MAIL_GROUP != r0.getContactType()) goto L25;
        r13.selectedAvatar.setImageResource(2131238003);
        return;
    L25:
        if (MailContactMeta.ContactType.SHARED_MAILBOX != r0.getContactType()) goto L28;
        r13.selectedAvatar.setImageResource(2131238065);
        return;
    L28:
        if (TextUtils.isEmpty(r14.getTitle()) == true) goto L30;
        String r15 = r14.getTitle().substring(0, Math.min(r14.getTitle().length(), 2));
    L31:
        r13.selectedAvatar.setImageBitmap(FakePickerAvatarCreator.createNameAvatarBitmap(AVATAR_SIZE_IN_PIX, AVATAR_TEXT_SIZE_IN_PIX, r15, ContextCompat.getColor(this.mContext, 2131105548), this.mContext));
        return;
    L30:
        r15 = "";
    L33:
        if ((r14 instanceof SearchReplyInThreadInfo) == false) goto L36;
        r13.selectedAvatar.setImageResource(2131237551);
        return;
    L36:
        if ((r14 instanceof SearchUserGroupInfo) == false) goto L39;
        r13.selectedAvatar.setImageResource(2131235952);
        return;
    L39:
        if ((r14 instanceof SearchSpaceInfo) == false) goto L41;
    L70:
        AvatarHelperKt.bindCCMAvatar(r13.selectedAvatar, r14);
        return;
    L41:
        if ((r14 instanceof SearchWikiInfo) == true) goto L70;
        if ((r14 instanceof SearchWikiSpaceInfo) == false) goto L47;
        r13.selectedAvatar.setImageResource(2131256279);
        return;
    L47:
        if ((r14 instanceof SearchOpenSearchInfo) == false) goto L50;
        AvatarHelperKt.bindOpenSearchAvatar(r13.selectedAvatar, (SearchOpenSearchInfo) r14);
        return;
    L50:
        if ((r14 instanceof PhoneInfo) == false) goto L53;
        r13.selectedAvatar.setImageResource(2131232470);
        return;
    L53:
        if ((r14 instanceof SearchAiKnowledgeInfo) == false) goto L55;
        r13.selectedAvatar.setImageResource(2131255192);
        return;
    L55:
        String r1 = r14.getId();
        if ((r14 instanceof SearchThreadInfo) == false) goto L64;
        SearchThreadInfo r2 = (SearchThreadInfo) r14;
        if (r2.getChannel() != null) goto L60;
    L62:
        r1 = r2.getChatId();
    L63:
        r13.selectedAvatar.l(new d(AvatarType.THRED, this.mContext.getDrawable(2131235361)));
        goto L64
    L60:
        if (r2.getChannel().getId() == null) goto L62;
        r1 = r2.getChannel().getId();
    L64:
        String r8 = r1;
        if (TextUtils.isEmpty(r14.getAvatarKey()) == true) goto L68;
        PickerWidgetModuleDependency.IPickerWidgetModuleDependency r5 = PickerWidgetModuleDependency.getDependency();
        Context r6 = this.mContext;
        String r7 = r14.getAvatarKey();
        LarkAvatarView r9 = r13.selectedAvatar;
        int r11 = AVATAR_SIZE_IN_PIX;
        r5.loadImage(r6, r7, r8, r9, r11, r11);
        return;
    L68:
        if (TextUtils.isEmpty(r14.getAvatarUrl()) == true) goto L86;
        GradientDrawable r10 = new GradientDrawable();
        r10.setShape(1);
        r10.setColor(AvatarModel.k);
        PickerBaseModuleDependency.IPickerCommonModuleDependency r3 = PickerBaseModuleDependency.getDependency();
        Context r4 = this.mContext;
        String r12 = r14.getAvatarUrl();
        LarkAvatarView r16 = r13.selectedAvatar;
        int r17 = AVATAR_SIZE_IN_PIX;
        r3.loadImage(r4, r12, r16, null, r10, r17, r17);
        return;
    }

    private void bindMiniAvatar(SelectedMemberViewHolder r3, SearchBaseInfo r4) {
        if ((r4 instanceof SearchReplyInThreadInfo) == false) goto L5;
        SearchReplyInThreadInfo r5 = (SearchReplyInThreadInfo) r4;
        r3.miniAvatar.setVisibility(0);
        LarkAvatarView r6 = r3.miniAvatar;
        AvatarModel.a r0 = new AvatarModel.a();
        r0.b(r5.getAvatarKey());
        r0.f(r5.getEntityId());
        r0.h(AvatarModel.Size.MINI);
        r6.j(new AvatarModel(r0));
        return;
    L5:
        r3.miniAvatar.setVisibility(8);
    }

    private void bindUserTeamBadge(SelectedMemberViewHolder r1, SearchBaseInfo r2) {
        View r3 = r1.userTeamBadge;
        if ((r2 instanceof SearchUserTeamInfo) == false) goto L5;
        int r4 = 0;
    L6:
        r3.setVisibility(r4);
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public void onBindViewHolder(SelectedMemberViewHolder r2, int r3) {
        final SearchBaseInfo r4 = (SearchBaseInfo) getItem(r3);
        bindAvatar(r2, r4);
        bindMiniAvatar(r2, r4);
        bindUserTeamBadge(r2, r4);
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new AnonymousClass1(this, r4));
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public SelectedMemberViewHolder m3373onCreateViewHolder(ViewGroup r3, int r4) {
        return new SelectedMemberViewHolder(LayoutInflater.from(this.mContext).inflate(2131564503, r3, false));
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SelectedMemberViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m3373onCreateViewHolder(r1, r2);
    }
}
