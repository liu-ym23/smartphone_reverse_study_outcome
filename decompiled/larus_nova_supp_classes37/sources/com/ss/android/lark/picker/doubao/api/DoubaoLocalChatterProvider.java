package com.ss.android.lark.picker.doubao.api;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterProvider;", "", "getTagStatesByChatterIds", "", "", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "chatterIds", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public interface DoubaoLocalChatterProvider {
    Map<String, DoubaoLocalChatterTagState> getTagStatesByChatterIds(List<String> r1);
}
