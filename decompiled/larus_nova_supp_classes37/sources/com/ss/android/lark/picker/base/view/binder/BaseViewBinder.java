package com.ss.android.lark.picker.base.view.binder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.larksuite.component.ui.tag.a;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.picker.base.utils.PreventDoubleClickListener;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w3c.b;
import w3c.f;
import w3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u0006:\u0001DB\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0001H&¢\u0006\u0002\u0010\"J%\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020$2\u0006\u0010%\u001a\u00020\nH\u0016¢\u0006\u0002\u0010&J\u001d\u0010'\u001a\u00020\u001d2\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020$H\u0016¢\u0006\u0002\u0010(J\u001d\u0010)\u001a\u00020\u001d2\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020$H\u0016¢\u0006\u0002\u0010(J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0004JC\u0010.\u001a\u00020\u001d2\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n002\b\u00101\u001a\u0004\u0018\u00010\u00112\u0006\u00102\u001a\u000203¢\u0006\u0002\u00104JS\u00105\u001a\u00020\u001d2\u0006\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n002\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010\u00112\u0006\u00102\u001a\u000203¢\u0006\u0002\u00107J\u000e\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\nJ\u0006\u00109\u001a\u00020\nJ\u000e\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\nJ\u0006\u0010<\u001a\u00020\nJ\u0013\u0010;\u001a\u00020\n2\u0006\u0010 \u001a\u00028\u0000¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u00010\u0011J\u0010\u0010?\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0004H\u0016J\u001a\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001fH\u0016R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006E"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/BaseViewBinder;", "D", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "H", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;", "Lcom/ss/android/lark/picker/base/view/binder/IHighlightBinder;", "<init>", "()V", "isEnableHighLight", "", "()Z", "setEnableHighLight", "(Z)V", "mIsMultiple", "singleChoiceMode", "mOnBusinessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "getMOnBusinessConsumeItem", "()Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "setMOnBusinessConsumeItem", "(Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;)V", "tagProvider", "Lcom/larksuite/component/ui/tag/DefaultTagProvider;", "getTagProvider", "()Lcom/larksuite/component/ui/tag/DefaultTagProvider;", "tagProvider$delegate", "Lkotlin/Lazy;", "bind", "", "position", "", "data", "holder", "(ILcom/ss/android/lark/search/dto/info/SearchBaseInfo;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "bindTitle", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "isSelectable", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;Z)V", "bindSubTitle", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;)V", "bindSummary", "deDuplicationHighlightKeys", "", "", "list", "bindCheckBoxInner", "checkDisable", "Lkotlin/Function0;", "onBusinessConsumeItem", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;ILkotlin/jvm/functions/Function0;Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "bindItemClickInner", "onDisableClickHandler", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "switchMultiple", "isMultiple", "setSingleChoiceMode", "isSingleChoice", "isSingleChoiceMode", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)Z", "setOnBusinessConsumeItem", "supports", "createCustomViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CompositeBusinessConsumeItem", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class BaseViewBinder<D extends SearchBaseInfo, H extends RecyclerView.ViewHolder> implements IViewBinder, IHighlightBinder {
    private boolean isEnableHighLight;
    private boolean mIsMultiple;
    private SearchResultView.IOnBusinessConsumeItem mOnBusinessConsumeItem;
    private boolean singleChoiceMode;
    private final Lazy tagProvider$delegate;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/BaseViewBinder$CompositeBusinessConsumeItem;", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "delegates", "", "<init>", "(Ljava/util/List;)V", "add", "", "delegate", "onBusinessConsumeItemClick", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onBusinessBindItemCheckBox", "Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class CompositeBusinessConsumeItem implements SearchResultView.IOnBusinessConsumeItem {
        private final List<SearchResultView.IOnBusinessConsumeItem> delegates;

        public CompositeBusinessConsumeItem(List<SearchResultView.IOnBusinessConsumeItem> r2) {
            Intrinsics.checkNotNullParameter(r2, "delegates");
            this.delegates = r2;
        }

        public final void add(SearchResultView.IOnBusinessConsumeItem r5) {
            Intrinsics.checkNotNullParameter(r5, "delegate");
            List<SearchResultView.IOnBusinessConsumeItem> r0 = this.delegates;
            boolean r2 = false;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L16;
            if (((SearchResultView.IOnBusinessConsumeItem) r1.next()) != r5) goto L13;
            boolean r3 = true;
        L14:
            if (r3 == false) goto L9;
            r2 = true;
            goto L16
        L13:
            r3 = false;
        L16:
            if (r2 == false) goto L18;
            return;
        L18:
            this.delegates.add(r5);
            return;
        L5:
            if (r0.isEmpty() == false) goto L7;
            goto L7
        }

        @Override // com.ss.android.lark.picker.base.view.SearchResultView.IOnBusinessConsumeItem
        public SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            Iterator<T> r0 = this.delegates.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            SearchResultView.CheckBoxBindStatus r1 = ((SearchResultView.IOnBusinessConsumeItem) r0.next()).onBusinessBindItemCheckBox(r4);
            if (r1.isConsume() == false) goto L4;
            return r1;
        L9:
            return new SearchResultView.CheckBoxBindStatus(false, false, true);
        }

        @Override // com.ss.android.lark.picker.base.view.SearchResultView.IOnBusinessConsumeItem
        public boolean onBusinessConsumeItemClick(SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            Iterator<T> r0 = this.delegates.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            if (((SearchResultView.IOnBusinessConsumeItem) r0.next()).onBusinessConsumeItemClick(r3) == false) goto L4;
            return true;
        L9:
            return false;
        }
    }

    public abstract void bind(int r1, D r2, H r3);

    public RecyclerView.ViewHolder createCustomViewHolder(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return null;
    }

    public final a getTagProvider() {
        return (a) this.tagProvider$delegate.getValue();
    }

    public BaseViewBinder() {
        this.isEnableHighLight = true;
        this.tagProvider$delegate = LazyKt.lazy(BaseViewBinder$tagProvider$2.INSTANCE);
    }

    public final SearchResultView.IOnBusinessConsumeItem getMOnBusinessConsumeItem() {
        return this.mOnBusinessConsumeItem;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IHighlightBinder
    public boolean isEnableHighLight() {
        return this.isEnableHighLight;
    }

    public final boolean isMultiple() {
        return this.mIsMultiple;
    }

    public final boolean isSingleChoiceMode() {
        return this.singleChoiceMode;
    }

    public static final /* synthetic */ boolean access$getMIsMultiple$p(BaseViewBinder r0) {
        return r0.mIsMultiple;
    }

    public final List<String> deDuplicationHighlightKeys(List<String> r3) {
        HashSet r0 = new HashSet();
        if (r3 == null) goto L9;
        Iterator<String> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r0.add(r4.next());
    L9:
        return CollectionsKt.toList(r0);
    }

    public final boolean isSingleChoice(D r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (isSingleChoiceMode() == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.isSingleChoice() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IHighlightBinder
    public void setEnableHighLight(boolean r1) {
        this.isEnableHighLight = r1;
    }

    public final void setMOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r1) {
        this.mOnBusinessConsumeItem = r1;
    }

    public final void setOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        SearchResultView.IOnBusinessConsumeItem r0 = this.mOnBusinessConsumeItem;
        if (r0 != null) goto L8;
        this.mOnBusinessConsumeItem = r5;
        return;
    L8:
        if (r0 != r5) goto L11;
        return;
    L11:
        if ((r0 instanceof CompositeBusinessConsumeItem) == false) goto L13;
        ((CompositeBusinessConsumeItem) r0).add(r5);
        return;
    L13:
        this.mOnBusinessConsumeItem = new CompositeBusinessConsumeItem(CollectionsKt.mutableListOf(new SearchResultView.IOnBusinessConsumeItem[]{r0, r5}));
    }

    public final void setSingleChoiceMode(boolean r1) {
        this.singleChoiceMode = r1;
    }

    public boolean supports(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        return r2 instanceof ChatterChatViewHolder;
    }

    public final void switchMultiple(boolean r1) {
        this.mIsMultiple = r1;
    }

    public void bindSubTitle(D r3, ChatterChatViewHolder r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        f r0 = new f(r3.getSubTitle());
        if (isEnableHighLight() == false) goto L5;
        r0.c = r3.getSubTitleTagList();
    L5:
        r0.e = isSingleChoice(r3);
        r4.getAvatarItemView().getItem().subTitle(r0);
    }

    public void bindSummary(D r3, ChatterChatViewHolder r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        f r0 = new f(r3.getExtraTitle());
        if (isEnableHighLight() == false) goto L5;
        r0.c = r3.getExtraTitleTagList();
    L5:
        r0.e = isSingleChoice(r3);
        r4.getAvatarItemView().getItem().summary(r0);
    }

    public void bindTitle(D r4, ChatterChatViewHolder r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "holder");
        ArrayList r0 = r4.getTitleTagList();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        g r7 = new g(r4.getTitle(), false, 14);
    L13:
        if (isEnableHighLight() == false) goto L15;
        r7.e = r4.getTitleTagList();
    L15:
        r7.g = isSingleChoice(r4);
        r5.getAvatarItemView().getItem().title(r7);
        return;
    L11:
        r7 = new g(r4.getTitle(), r6, 8);
        goto L13
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void bindCheckBoxInner(D r2, ChatterChatViewHolder r3, int r4, Function0<Boolean> r5, SearchResultView.IOnBusinessConsumeItem r6, v3c.g r7) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "checkDisable");
        Intrinsics.checkNotNullParameter(r7, "onItemClickHandler");
        b r8 = new b();
        r8.c = isMultiple();
        if (((Boolean) r5.invoke()).booleanValue() == false) goto L6;
        r8.b = false;
    L14:
        if (r8.b == false) goto L16;
        r3.getAvatarItemView().hideShadow();
    L17:
        r3.getAvatarItemView().getItem().checkState(r8);
        return;
    L16:
        r3.getAvatarItemView().showShadow();
        int r9 = DesktopUtil.a;
        goto L17
    L6:
        if (r2.isRequired() == false) goto L8;
        r8.a = true;
        r8.b = false;
        goto L14
    L8:
        if (r6 != null) goto L10;
    L12:
        r8.a = r2.isSelected();
        r8.b = true;
        goto L14
    L10:
        if (r6.onBusinessBindItemCheckBox(r2).isConsume() == false) goto L12;
        r8.a = r6.onBusinessBindItemCheckBox(r2).isChecked();
        r8.b = r6.onBusinessBindItemCheckBox(r2).isEnabled();
        goto L14
    }

    public final void bindItemClickInner(final D r12, final ChatterChatViewHolder r13, final int r14, final Function0<Boolean> r15, final Function0<Unit> r16, final SearchResultView.IOnBusinessConsumeItem r17, final v3c.g r18) {
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r15, "checkDisable");
        Intrinsics.checkNotNullParameter(r18, "onItemClickHandler");
        PreventDoubleClickListener r0 = new BaseViewBinder$bindItemClickInner$clickListener$1(r12, r15, r16, this, r13, r14, r17, r18);
        r13.getAvatarItemView().getItem().setOnClickListener(r0);
        r13.getAvatarItemView().setOnClickListener(r0);
    }
}
