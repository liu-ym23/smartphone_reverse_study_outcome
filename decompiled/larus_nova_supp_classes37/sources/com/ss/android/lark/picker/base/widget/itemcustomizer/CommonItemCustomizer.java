package com.ss.android.lark.picker.base.widget.itemcustomizer;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/itemcustomizer/CommonItemCustomizer;", "O", "R", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/ss/android/lark/picker/base/widget/dependency/PickerWidgetModuleDependency$IPickerWidgetModuleDependency$IItemCustomizer;", AppbrandHostConstants.Schema_RESERVED_FIELD.VERSION, "", "consumer", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "parse", "Lkotlin/Function1;", "<init>", "(ILcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;Lkotlin/jvm/functions/Function1;)V", "getVersion", "()I", "selectable", "", "item", "(Ljava/lang/Object;)Z", "onBindItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "data", "(Ljava/lang/Object;)Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "onItemClick", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CommonItemCustomizer<O, R extends SearchBaseInfo> implements PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IItemCustomizer<O> {
    private final SearchResultView.IOnBusinessConsumeItem consumer;
    private final Function1<O, R> parse;
    private final int version;

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IItemCustomizer
    public int getVersion() {
        return this.version;
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IItemCustomizer
    public SearchResultView.CheckBoxBindStatus onBindItem(O r3) {
        SearchBaseInfo r4 = (SearchBaseInfo) this.parse.invoke(r3);
        SearchResultView.IOnBusinessConsumeItem r0 = this.consumer;
        if (r0 == null) goto L7;
        SearchResultView.CheckBoxBindStatus r5 = r0.onBusinessBindItemCheckBox(r4);
        if (r5 == null) goto L7;
        return r5;
    L7:
        return new SearchResultView.CheckBoxBindStatus(false, false, true);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IItemCustomizer
    public boolean onItemClick(O r2) {
        SearchBaseInfo r3 = (SearchBaseInfo) this.parse.invoke(r2);
        SearchResultView.IOnBusinessConsumeItem r0 = this.consumer;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onBusinessConsumeItemClick(r3);
    }

    @Override // com.ss.android.lark.picker.base.widget.dependency.PickerWidgetModuleDependency.IPickerWidgetModuleDependency.IItemCustomizer
    public boolean selectable(O r4) {
        SearchBaseInfo r5 = (SearchBaseInfo) this.parse.invoke(r4);
        SearchResultView.IOnBusinessConsumeItem r0 = this.consumer;
        if (r0 == null) goto L5;
        SearchResultView.CheckBoxBindStatus r6 = r0.onBusinessBindItemCheckBox(r5);
    L6:
        boolean r1 = false;
        if (r6 != null) goto L9;
    L11:
        if (r1 == true) goto L13;
        return true;
    L13:
        return r6.isEnabled();
    L9:
        if (r6.isConsume() != true) goto L11;
        r1 = true;
        goto L11
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonItemCustomizer(int r2, SearchResultView.IOnBusinessConsumeItem r3, Function1<? super O, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r4, "parse");
        this.version = r2;
        this.consumer = r3;
        this.parse = r4;
    }
}
