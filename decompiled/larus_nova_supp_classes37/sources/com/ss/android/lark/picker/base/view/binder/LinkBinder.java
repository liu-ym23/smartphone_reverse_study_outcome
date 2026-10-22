package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlock;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlockSegment;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonFgUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchLinkViewHolder;
import com.ss.android.lark.search.dto.info.ExtraInfoSummary;
import com.ss.android.lark.search.dto.info.SearchLinkInfo;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.t;
import com.ss.android.lark.utils.y0;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;
import v3c.l;
import v3c.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0011\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\"\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u001d\u001a\u00020\u0016H\u0002J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH\u0002J\"\u0010#\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u001d\u001a\u00020\u0016H\u0002J\"\u0010$\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u001d\u001a\u00020\u0016H\u0002J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006'"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/LinkBinder;", "Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;", "Lcom/ss/android/lark/picker/base/view/binder/IHighlightBinder;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "isEnableHighLight", "", "()Z", "setEnableHighLight", "(Z)V", "fgUtils", "Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "linkViewInChat", "com/ss/android/lark/picker/base/view/binder/LinkBinder$linkViewInChat$1", "Lcom/ss/android/lark/picker/base/view/binder/LinkBinder$linkViewInChat$1;", "bind", "", "position", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchLinkInfo;", "holder", "Lcom/ss/android/lark/picker/base/view/SearchLinkViewHolder;", "setMessageUrlAvatar", "setMessageUrlName", "highColor", "getHitTerms", "", "", "tagList", "Lcom/ss/android/lark/search/dto/info/TagContent;", "setMessageUrlDetail", "setMessageUrlContent", "setMessageSendInfo", "setSelectedStatus", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LinkBinder implements IViewBinder, IHighlightBinder {
    private SearchCommonFgUtils fgUtils;
    private boolean isEnableHighLight;
    private final LinkBinder$linkViewInChat$1 linkViewInChat;
    private final Context mContext;
    private final g mOnItemClickHandler;

    @Override // com.ss.android.lark.picker.base.view.binder.IHighlightBinder
    public boolean isEnableHighLight() {
        return this.isEnableHighLight;
    }

    public static final /* synthetic */ LinkBinder$linkViewInChat$1 access$getLinkViewInChat$p(LinkBinder r0) {
        return r0.linkViewInChat;
    }

    public static final /* synthetic */ Context access$getMContext$p(LinkBinder r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ g access$getMOnItemClickHandler$p(LinkBinder r0) {
        return r0.mOnItemClickHandler;
    }

    private final List<String> getHitTerms(List<TagContent> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(((TagContent) r1).getTag(), "h") == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        r7.add(((TagContent) r2.next()).getContent().getContent());
        goto L10
    L12:
        return r7;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IHighlightBinder
    public void setEnableHighLight(boolean r1) {
        this.isEnableHighLight = r1;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.android.lark.picker.base.view.binder.LinkBinder$linkViewInChat$1] */
    public LinkBinder(Context r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mOnItemClickHandler");
        this.mContext = r2;
        this.mOnItemClickHandler = r3;
        this.isEnableHighLight = true;
        this.fgUtils = new SearchCommonFgUtils();
        this.linkViewInChat = new LinkBinder$linkViewInChat$1();
    }

    private final void setMessageSendInfo(SearchLinkViewHolder r18, SearchLinkInfo r19) {
        String r3 = "";
        if (this.fgUtils.isExtraInfoEnable() == false) goto L60;
        ExtraInfoSummary r1 = r19.getExtraInfoSummary();
        if (r1 == null) goto L59;
        ArrayList r2 = r1.getExtraInfoList();
        if (r2 == null) goto L59;
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L53;
        ExtraInfoBlock r5 = (ExtraInfoBlock) r4.next();
        List r6 = r5.block_segments;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
        int r9 = 0;
    L13:
        if (r8.hasNext() == false) goto L38;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        ExtraInfoBlockSegment r12 = (ExtraInfoBlockSegment) r10;
        if (r12 == null) goto L27;
        String r13 = r12.text_highlighted;
        if (r13 == null) goto L27;
        if (r12.type != ExtraInfoBlockSegment.SegmentTextType.TIMESTAMP) goto L25;
        r13 = t.a(this.mContext, new Date(1000 * CastLongProtector.parseLong(r13)), PickerBaseModuleDependency.getDependency().getCachedLanguageSetting());
    L25:
        if (r13 == null) goto L28;
    L29:
        boolean r14 = true;
        if (r9 >= (r5.block_segments.size() - 1)) goto L37;
        if (r13.length() > 0) goto L35;
        r14 = false;
    L35:
        if (r14 == false) goto L37;
        r13 = r13 + r5.segment_separator;
    L37:
        r7.add(r13);
        r9 = r11;
        r8 = r8;
    L28:
        r13 = "";
    L27:
        r8 = r8;
        goto L28
    L38:
        Iterator r15 = r7.iterator();
        if (r15.hasNext() == true) goto L41;
        Object r16 = null;
    L45:
        String r17 = (String) r16;
        if (r17 == null) goto L50;
        String r20 = m.a(r17);
        if (r20 == null) goto L50;
        l r21 = m.b(r20, this.fgUtils.isUrlIconMoreTypesEnable());
    L51:
        if (r21 == null) goto L10;
    L54:
        if (r21 == null) goto L59;
        SpannableStringBuilder r22 = new SpannableStringBuilder(r21.a);
        if (CollectionUtils.isEmpty(r21.b) == false) goto L58;
        r18.getMMsgUrlSenderInfoTV().setText(r22);
        return;
    L58:
        PickerBaseModuleDependency.getDependency().addSearchHighLightedTag(r22, r18.getMMsgUrlSenderInfoTV(), r21.b, this.mContext.getResources().getColor(2131103404));
        r18.getMMsgUrlSenderInfoTV().setText(r22);
        return;
    L50:
        r21 = null;
        goto L51
    L41:
        r16 = r15.next();
    L43:
        if (r15.hasNext() == false) goto L45;
        r16 = ((String) r16) + ((String) r15.next());
        goto L43
    L53:
        r21 = null;
    L59:
        r18.getMMsgUrlSenderInfoTV().setText("");
        return;
    L60:
        String r23 = t.a(this.mContext, new Date(r19.getCreateTime() * ((long) 1000)), PickerBaseModuleDependency.getDependency().getCachedLanguageSetting());
        String r24 = r19.getFromName();
        if (r24 == null) goto L64;
        r3 = r24;
    L64:
        r18.getMMsgUrlSenderInfoTV().setText(r3 + ' ' + UIHelper.getString(2131892085) + ' ' + r23);
    }

    private final void setMessageUrlAvatar(SearchLinkViewHolder r11, SearchLinkInfo r12) {
        if (TextUtils.isEmpty(r12.getImageUrl()) == false) goto L5;
        r11.getMUrlAvatarIV().setImageResource(2131236032);
        return;
    L5:
        PickerBaseModuleDependency.getDependency().loadImage(this.mContext, r12.getImageUrl(), r11.getMUrlAvatarIV(), null, UIHelper.getDrawable(2131236032), 48, 48);
    }

    private final void setSelectedStatus(SearchLinkViewHolder r2, SearchLinkInfo r3) {
        if (r3.isSelected() == false) goto L5;
        int r0 = UIHelper.getColor(2131100548);
    L6:
        setMessageUrlName(r2, r3, r0);
        setMessageUrlDetail(r2, r3, r0);
        setMessageUrlContent(r2, r3, r0);
        setMessageSendInfo(r2, r3);
        return;
    L5:
        r0 = UIHelper.getColor(2131106614);
        goto L6
    }

    private final void setMessageUrlContent(SearchLinkViewHolder r4, SearchLinkInfo r5, int r6) {
        String r0 = r5.getSubTitle();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        r4.getMUrlContentLayoutLL().setVisibility(0);
        r4.getMUrlContentTV().setText(y0.c(r0, getHitTerms(r5.getSubTitleTagList()), r6));
        return;
    L5:
        r4.getMUrlContentLayoutLL().setVisibility(8);
    }

    private final void setMessageUrlDetail(SearchLinkViewHolder r3, SearchLinkInfo r4, int r5) {
        if (r4.getTitleTagList() != null) goto L5;
    L8:
        r3.getMUrlDetailTV().setVisibility(8);
        return;
    L5:
        if (r4.getTitleTagList().isEmpty() == true) goto L8;
        r3.getMUrlDetailTV().setVisibility(0);
        r3.getMUrlDetailTV().setText(y0.c(r4.getOriginalUrl(), getHitTerms(r4.getTitleTagList()), r5));
    }

    private final void setMessageUrlName(SearchLinkViewHolder r3, SearchLinkInfo r4, int r5) {
        if (TextUtils.isEmpty(r4.getTitle()) == true) goto L5;
        CharSequence r0 = r4.getTitle();
    L6:
        TextView r6 = r3.getMUrlNameTV();
        if (isEnableHighLight() == false) goto L9;
        r0 = y0.c(r0, getHitTerms(r4.getTitleTagList()), r5);
    L9:
        r6.setText(r0);
        return;
    L5:
        r0 = r4.getOriginalUrl();
        goto L6
    }

    public final void bind(final int r3, final SearchLinkInfo r4, SearchLinkViewHolder r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "holder");
        setMessageUrlAvatar(r5, r4);
        setSelectedStatus(r5, r4);
        r5.getView().setOnClickListener(new AnonymousClass1(this, r4, r3));
        r5.getMMsgUrlOpenChatIv().setOnClickListener(new AnonymousClass2(this, r4, r3));
    }
}
