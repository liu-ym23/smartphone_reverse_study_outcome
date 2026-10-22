package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.bytedance.lark.pb.search.slash.v1.SlashCommandMeta;
import com.bytedance.lark.pb.search.v2.ExplanationTag;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.f;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.UiUtil;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/OpenSearchBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchOpenSearchInfo;", "context", "Landroid/content/Context;", "clickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "getContext", "()Landroid/content/Context;", "tagMap", "Ljava/util/HashMap;", "", "Lcom/larksuite/component/ui/tag/TextTag$Builder;", "Lkotlin/collections/HashMap;", "bindAvatar", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "bindTag", "position", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OpenSearchBinder extends CommonBinder<SearchOpenSearchInfo> {
    private final Context context;
    private final HashMap<Integer, f.a> tagMap;

    public final Context getContext() {
        return this.context;
    }

    public OpenSearchBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "clickHandler");
        super(r8, r9, null, 4, null);
        this.context = r8;
        HashMap<Integer, f.a> r10 = new HashMap();
        this.tagMap = r10;
        f.a r0 = new f.a();
        r0.a = 4096;
        r0.e = 2131103457;
        r0.g = 2131103452;
        r10.put(0, r0);
        f.a r1 = new f.a();
        r1.a = 4097;
        r1.e = 2131099817;
        r1.g = 2131099818;
        r10.put(1, r1);
        f.a r2 = new f.a();
        r2.a = 4098;
        r2.e = 2131099821;
        r2.g = 2131099822;
        r10.put(2, r2);
        f.a r3 = new f.a();
        r3.a = 4099;
        r3.e = 2131099829;
        r3.g = 2131099830;
        r10.put(3, r3);
        f.a r4 = new f.a();
        r4.a = 4100;
        r4.e = 2131099832;
        r4.g = 2131099831;
        r10.put(4, r4);
    }

    public void bindAvatar(ChatterChatViewHolder r4, SearchOpenSearchInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        String r0 = r5.getTitle();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        String r2 = r5.getTitle().substring(0, 1);
    L12:
        int r3 = PickerBaseModuleDependency.getDependency().getUDIconByKey(r5.getImageUrl());
        if (r3 <= 0) goto L15;
        r4.getAvatarItemView().getItem().bindAvatarWithResourceID(r3);
        return;
    L15:
        r4.getAvatarItemView().getItem().bindAvatarWithUrl(r5.getImageUrl(), r2);
        return;
    L11:
        r2 = "";
        goto L12
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindAvatar(ChatterChatViewHolder r1, SearchBaseInfo r2) {
        bindAvatar(r1, (SearchOpenSearchInfo) r2);
    }

    public void bindTag(int r6, ChatterChatViewHolder r7, SearchOpenSearchInfo r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "data");
        List r9 = r8.getExplanationTags();
        boolean r0 = false;
        if (r9 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L15;
        LarkNameTag.e r11 = new LarkNameTag.e(this.context);
        List r12 = r8.getExplanationTags();
        if (r12 == null) goto L27;
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L27;
        ExplanationTag r1 = (ExplanationTag) r13.next();
        int r2 = f.g;
        f.a r3 = new f.a();
        UDTagsDrawable.TagColorSet r4 = UiUtil.Companion.getColorResByTagType(r1.tag_type);
        r3.b = 100;
        r3.d = r1.text;
        r3.e = r4.getTextColorRes();
        r3.g = r4.getBackgroundColorRes();
        r11.d(new f(r3), true);
    L27:
        r7.getAvatarItemView().getItem().setTag(r11);
        return;
    L15:
        r11 = new LarkNameTag.c(this.context);
        List r14 = r8.getTag();
        if (r14 != null) goto L18;
    L20:
        if (r0 == false) goto L27;
        Iterator r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L27;
        SlashCommandMeta.SlashCommandTag r5 = (SlashCommandMeta.SlashCommandTag) r15.next();
        f.a r16 = this.tagMap.get(r5.type);
        if (r16 == null) goto L23;
        r16.d = r5.text;
        r11.d(new f(r16), true);
        goto L23
    L18:
        if ((!r14.isEmpty()) != true) goto L20;
        r0 = true;
        goto L20
    L5:
        if ((!r9.isEmpty()) != true) goto L7;
        r10 = true;
        goto L8
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchOpenSearchInfo) r3);
    }
}
