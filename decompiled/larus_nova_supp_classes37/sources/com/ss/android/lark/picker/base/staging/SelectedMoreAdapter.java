package com.ss.android.lark.picker.base.staging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.AvatarItemViewWithMask;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.binder.BinderRepo;
import com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder;
import com.ss.android.lark.picker.base.view.binder.IHighlightBinder;
import com.ss.android.lark.picker.base.view.binder.IViewBinder;
import com.ss.android.lark.search.dto.info.EmailInfo;
import com.ss.android.lark.search.dto.info.PhoneInfo;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchPermissionGroupInfo;
import com.ss.android.lark.search.dto.info.SearchPersonnelTypeInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.search.dto.info.SearchUserTeamInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class SelectedMoreAdapter extends LarkRecyclerViewBaseAdapter<SelectedMemberViewHolder, SearchBaseInfo> {
    private static final String TAG = "LarkSearch.Common.SelectedMoreAdapter";
    private BinderRepo mBinderRepo;
    private Context mContext;
    private OnItemRemoveListener mItemRemoveListener;

    public interface OnItemRemoveListener {
        void onItemRemove(SearchBaseInfo r1);
    }

    public static class SelectedMemberViewHolder extends RecyclerView.ViewHolder {
        public ChatterChatViewHolder fakeHolder;
        public AvatarItemViewWithMask item;
        public View remove;

        public SelectedMemberViewHolder(View r3) {
            super(r3);
            AvatarItemViewWithMask r0 = (AvatarItemViewWithMask) r3.findViewById(2131385841);
            this.item = r0;
            r0.showDivider(false);
            this.remove = r3.findViewById(2131385848);
            this.fakeHolder = new ChatterChatViewHolder(this.item, -1);
        }
    }

    public static /* synthetic */ Unit A2(boolean r0, List r1) {
        return lambda$setIsEnableChatPreview$1(r0, r1);
    }

    public static /* synthetic */ Unit y2(String r0, List r1) {
        return lambda$setScene$2(r0, r1);
    }

    public static /* synthetic */ Unit z2(List r0) {
        return lambda$new$0(r0);
    }

    public SelectedMoreAdapter(Context r3) {
        this.mContext = r3;
        BinderRepo r4 = new BinderRepo(this.mContext, new AnonymousClass1(this));
        this.mBinderRepo = r4;
        r4.custom(new c());
    }

    public static /* synthetic */ OnItemRemoveListener access$000(SelectedMoreAdapter r0) {
        return r0.mItemRemoveListener;
    }

    private static /* synthetic */ Unit lambda$new$0(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        IViewBinder r0 = (IViewBinder) r3.next();
        if ((r0 instanceof IHighlightBinder) == false) goto L4;
        ((IHighlightBinder) r0).setEnableHighLight(false);
        goto L4
    L8:
        return null;
    }

    public void setIsEnableChatPreview(final boolean r3) {
        this.mBinderRepo.custom(new a(r3));
    }

    public void setOnItemRemoveListener(OnItemRemoveListener r1) {
        this.mItemRemoveListener = r1;
    }

    public void setScene(final String r3) {
        this.mBinderRepo.custom(new b(r3));
    }

    private static /* synthetic */ Unit lambda$setIsEnableChatPreview$1(boolean r2, List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        IViewBinder r0 = (IViewBinder) r4.next();
        if ((r0 instanceof IChatPreviewBinder) == false) goto L4;
        ((IChatPreviewBinder) r0).setEnableChatPreview(r2);
        goto L4
    L8:
        return null;
    }

    private static /* synthetic */ Unit lambda$setScene$2(String r2, List r3) {
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        IViewBinder r0 = (IViewBinder) r4.next();
        if ((r0 instanceof IChatPreviewBinder) == false) goto L4;
        ((IChatPreviewBinder) r0).setScene(r2);
        goto L4
    L8:
        return null;
    }

    public void onBindViewHolder(SelectedMemberViewHolder r5, int r6) {
        final SearchPersonnelTypeInfo r0 = (SearchBaseInfo) getItem(r6);
        if ((r0 instanceof SearchPersonnelTypeInfo) == false) goto L6;
        this.mBinderRepo.getPersonnelTypeBinder().bind(r6, r0, r5.fakeHolder);
    L57:
        r5.remove.setOnClickListener(new AnonymousClass2(this, r0));
        r5.item.setEnablePressBackground(false);
        return;
    L6:
        if ((r0 instanceof SearchPermissionGroupInfo) == false) goto L9;
        this.mBinderRepo.getPermissionGroupBinder().bind(r6, (SearchPermissionGroupInfo) r0, r5.fakeHolder);
        goto L57
    L9:
        if ((r0 instanceof EmailInfo) == false) goto L12;
        this.mBinderRepo.getEmailBinder().bind(r6, (EmailInfo) r0, r5.fakeHolder);
        goto L57
    L12:
        if ((r0 instanceof SearchShieldP2PChatInfo) == false) goto L15;
        this.mBinderRepo.getShieldP2PChatBinder().bind(r6, (SearchShieldP2PChatInfo) r0, r5.fakeHolder);
        goto L57
    L15:
        if ((r0 instanceof SearchUserTeamInfo) == false) goto L18;
        this.mBinderRepo.getUserTeamBinder().bind(r6, (SearchUserTeamInfo) r0, r5.fakeHolder);
        goto L57
    L18:
        if ((r0 instanceof SearchChatterInfo) == false) goto L21;
        this.mBinderRepo.getChatterBinder().bind(r6, (SearchChatterInfo) r0, r5.fakeHolder);
        goto L57
    L21:
        if ((r0 instanceof SearchChatInfo) == false) goto L24;
        this.mBinderRepo.getChatBinder().bind(r6, (SearchChatInfo) r0, r5.fakeHolder);
        goto L57
    L24:
        if ((r0 instanceof SearchThreadInfo) == false) goto L27;
        this.mBinderRepo.getThreadBinder().bind(r6, (SearchThreadInfo) r0, r5.fakeHolder);
        goto L57
    L27:
        if ((r0 instanceof SearchReplyInThreadInfo) == false) goto L30;
        this.mBinderRepo.getReplyInThreadBinder().bind(r6, (SearchReplyInThreadInfo) r0, r5.fakeHolder);
        goto L57
    L30:
        if ((r0 instanceof SearchDepartmentInfo) == false) goto L33;
        this.mBinderRepo.getDepartmentBinder().bind(r6, (SearchDepartmentInfo) r0, r5.fakeHolder);
        goto L57
    L33:
        if ((r0 instanceof SearchMailContactInfo) == false) goto L36;
        this.mBinderRepo.getMailContactBinder().bind(r6, (SearchMailContactInfo) r0, r5.fakeHolder);
        goto L57
    L36:
        if ((r0 instanceof SearchSpaceInfo) == false) goto L39;
        r0.setTitleTagList(null);
        r0.setSubTitleTagList(null);
        this.mBinderRepo.getCcmBinder().bind(r6, (SearchSpaceInfo) r0, r5.fakeHolder);
        goto L57
    L39:
        if ((r0 instanceof SearchWikiInfo) == false) goto L42;
        r0.setTitleTagList(null);
        r0.setSubTitleTagList(null);
        this.mBinderRepo.getCcmBinder().bind(r6, (SearchWikiInfo) r0, r5.fakeHolder);
        goto L57
    L42:
        if ((r0 instanceof SearchWikiSpaceInfo) == false) goto L45;
        r0.setTitleTagList(null);
        r0.setSubTitleTagList(null);
        this.mBinderRepo.getWikiSpaceBinder().bind(r6, (SearchWikiSpaceInfo) r0, r5.fakeHolder);
        goto L57
    L45:
        if ((r0 instanceof SearchOpenSearchInfo) == false) goto L48;
        this.mBinderRepo.getOpenSearchBinder().bind(r6, (SearchOpenSearchInfo) r0, r5.fakeHolder);
        goto L57
    L48:
        if ((r0 instanceof SearchUserGroupInfo) == false) goto L51;
        this.mBinderRepo.getUserGroupBinder().bind(r6, (SearchUserGroupInfo) r0, r5.fakeHolder);
        goto L57
    L51:
        if ((r0 instanceof PhoneInfo) == false) goto L54;
        this.mBinderRepo.getPhoneBinder().bind(r6, (PhoneInfo) r0, r5.fakeHolder);
        goto L57
    L54:
        if ((r0 instanceof SearchAiKnowledgeInfo) == false) goto L56;
        this.mBinderRepo.getAiKnowledgeBinder().bind(r6, (SearchAiKnowledgeInfo) r0, r5.fakeHolder);
        goto L57
    L56:
        Log.e(TAG, "wtf!!!");
        goto L57
    }

    /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
    public SelectedMemberViewHolder m3351onCreateViewHolder(ViewGroup r4, int r5) {
        return new SelectedMemberViewHolder(LayoutInflater.from(this.mContext).inflate(2131564505, r4, false));
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SelectedMemberViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return m3351onCreateViewHolder(r1, r2);
    }
}
