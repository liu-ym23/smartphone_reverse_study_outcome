package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchHelpDeskInfo;
import com.ss.android.lark.utils.y0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v3c.g;
import w3c.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/HelpDeskBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchHelpDeskInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "bindTag", "", "position", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "bindSummary", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class HelpDeskBinder extends CommonBinder<SearchHelpDeskInfo> {
    private final Context mContext;
    private final g mOnItemClickHandler;

    public HelpDeskBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
    }

    public void bindSummary(SearchHelpDeskInfo r6, ChatterChatViewHolder r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "holder");
        f r0 = new f(!StringsKt.isBlank(r6.getFaqTitle()));
        String r1 = this.mContext.getString(2131892630) + ": " + r6.getFaqTitle();
        if (isEnableHighLight() == false) goto L5;
        r0.a = y0.c(r1, CollectionsKt.mutableListOf(new String[]{r6.getFaqTitle()}), this.mContext.getResources().getColor(2131103404));
    L6:
        r0.e = isSingleChoice(r6);
        r7.getAvatarItemView().getItem().summary(r0);
        return;
    L5:
        r0.a = r1;
        goto L6
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bindSummary(SearchBaseInfo r1, ChatterChatViewHolder r2) {
        bindSummary((SearchHelpDeskInfo) r1, r2);
    }

    public void bindTag(int r4, ChatterChatViewHolder r5, SearchHelpDeskInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "data");
        LarkNameTag.d r7 = new LarkNameTag.d(this.mContext);
        List r0 = r6.getTags();
        boolean r2 = false;
        if (r6.isOfficialOnCall() == true) goto L10;
        if (r0 == null) goto L6;
        boolean r8 = r0.contains(Tag.OFFICIAL);
    L7:
        if (r8 == true) goto L10;
        boolean r9 = false;
    L11:
        r7.y = r9;
        if (r0 == null) goto L14;
        r2 = r0.contains(Tag.ONCALL_OFFLINE);
    L14:
        r7.n = true;
        r7.o = r2;
        r5.getAvatarItemView().getItem().setTag(r7);
        return;
    L6:
        r8 = false;
    L10:
        r9 = true;
        goto L11
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchHelpDeskInfo) r3);
    }
}
