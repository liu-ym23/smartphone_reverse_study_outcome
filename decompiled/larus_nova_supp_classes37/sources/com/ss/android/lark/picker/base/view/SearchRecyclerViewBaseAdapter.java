package com.ss.android.lark.picker.base.view;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import aoc.b;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.reporter.SearchConsistencyReporter;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u0015*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u0015B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000eJ+\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchRecyclerViewBaseAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Data", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionAdapter;", "<init>", "()V", "isItemSelectable", "", "position", "", "onBindViewHolder", "", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "payloads", "", "", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "getTopNRptId", "", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class SearchRecyclerViewBaseAdapter<VH extends RecyclerView.ViewHolder, Data> extends KeyboardSelectionAdapter<VH, Data> {
    public static final Companion Companion = null;
    private static final String TAG = "LarkSearch.Common.SearchRecyclerViewBaseAdapter";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchRecyclerViewBaseAdapter$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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

    public abstract String getTopNRptId(int r1);

    @Override // com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionAdapter
    public boolean isItemSelectable(int r1) {
        return true;
    }

    public SearchRecyclerViewBaseAdapter() {
    }

    public void onBindViewHolder(VH r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Log.d(TAG, "onBindViewHolder, position: " + r3);
        String r4 = getTopNRptId(r3);
        if (r4 == null) goto L6;
        SearchConsistencyReporter.INSTANCE.addOnScreenID(r3, r4);
        return;
    }

    @Override // com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionAdapter
    public void onBindViewHolder(VH r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (b.a() == false) goto L8;
        Boolean r0 = ExternalKeyboardUtils.a;
        if (ExternalKeyboardUtils.b(false) == false) goto L9;
        super.onBindViewHolder(r2, r3, r4);
        return;
    L9:
        return;
    }
}
