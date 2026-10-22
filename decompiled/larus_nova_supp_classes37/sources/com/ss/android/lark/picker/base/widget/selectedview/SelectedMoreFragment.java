package com.ss.android.lark.picker.base.widget.selectedview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.picker.base.staging.SelectedMoreAdapter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "titleBarRightTv", "Landroid/widget/TextView;", "moreList", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "selectedData", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "adapter", "Lcom/ss/android/lark/picker/base/staging/SelectedMoreAdapter;", "removedData", "isEnableChatPreview", "", "isUseResult", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "updateRightTvBySelectedCount", "count", "", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SelectedMoreFragment extends BaseFragment {
    public static final Companion Companion = null;
    private static final String ENABLE_CHAT_PREVIEW = "enableChatPreview";
    public static final String KEY_REMOVE_DATA = "removeData";
    private static final String KEY_SCENE = "keyScene";
    private static final String KEY_USE_RESULT = "useResult";
    public static final String SELECTED_DATA = "selected.data";
    public static final String _TAG = "LarkSearch.SearchWidget.SelectedMoreActivity";
    private SelectedMoreAdapter adapter;
    private boolean isEnableChatPreview;
    private boolean isUseResult;
    private CommonRecyclerView moreList;
    private final List<SearchBaseInfo> removedData;
    private final List<SearchBaseInfo> selectedData;
    private CommonTitleBar titleBar;
    private TextView titleBarRightTv;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreFragment$Companion;", "", "<init>", "()V", "_TAG", "", "SELECTED_DATA", "KEY_REMOVE_DATA", "ENABLE_CHAT_PREVIEW", "KEY_SCENE", "KEY_USE_RESULT", "newInstance", "Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreFragment;", "data", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isEnableChatPreview", "", "isUseResult", "scene", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Serializable, java.lang.Object[]] */
        @JvmStatic
        public final SelectedMoreFragment newInstance(List<? extends SearchBaseInfo> r4, boolean r5, boolean r6, String r7) {
            Intrinsics.checkNotNullParameter(r4, "data");
            Intrinsics.checkNotNullParameter(r7, "scene");
            SelectedMoreFragment r0 = new SelectedMoreFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("selected.data", r4.toArray(new SearchBaseInfo[0]));
            r1.putBoolean(SelectedMoreFragment.ENABLE_CHAT_PREVIEW, r5);
            r1.putBoolean(SelectedMoreFragment.KEY_USE_RESULT, r6);
            r1.putString(SelectedMoreFragment.KEY_SCENE, r7);
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final SelectedMoreFragment newInstance(List<? extends SearchBaseInfo> r1, boolean r2, boolean r3, String r4) {
        return Companion.newInstance(r1, r2, r3, r4);
    }

    public SelectedMoreFragment() {
        this.selectedData = new ArrayList();
        this.removedData = new ArrayList();
    }

    public static final /* synthetic */ SelectedMoreAdapter access$getAdapter$p(SelectedMoreFragment r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ List access$getRemovedData$p(SelectedMoreFragment r0) {
        return r0.removedData;
    }

    public static final /* synthetic */ List access$getSelectedData$p(SelectedMoreFragment r0) {
        return r0.selectedData;
    }

    public static final /* synthetic */ boolean access$isUseResult$p(SelectedMoreFragment r0) {
        return r0.isUseResult;
    }

    private final void updateRightTvBySelectedCount(int r4) {
        TextView r0 = null;
        if (r4 <= 0) goto L9;
        TextView r2 = this.titleBarRightTv;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarRightTv");
    L8:
        r0.setText(UIHelper.mustacheFormat(2131892184, "select_count", String.valueOf(r4)));
        return;
    L7:
        r0 = r2;
        goto L8
    L9:
        TextView r5 = this.titleBarRightTv;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarRightTv");
    L13:
        r0.setText(UIHelper.getString(2131891624));
        return;
    L12:
        r0 = r5;
        goto L13
    }

    public static final /* synthetic */ void access$updateRightTvBySelectedCount(SelectedMoreFragment r0, int r1) {
        r0.updateRightTvBySelectedCount(r1);
    }

    public void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        this.moreList = r6.findViewById(2131380315);
        Bundle r8 = getArguments();
        SelectedMoreAdapter r0 = null;
        if (r8 == null) goto L5;
        Object r9 = r8.get("selected.data");
    L6:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        SearchBaseInfo[] r1 = (SearchBaseInfo[]) r9;
        CollectionsKt.addAll(this.selectedData, (Object[]) r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L9;
        boolean r11 = r10.getBoolean(ENABLE_CHAT_PREVIEW, false);
    L10:
        this.isEnableChatPreview = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L13;
        boolean r13 = r12.getBoolean(KEY_USE_RESULT, false);
    L14:
        this.isUseResult = r13;
        final CommonTitleBar r14 = r6.findViewById(2131388807);
        final String r15 = getString(2131891624);
        final int r3 = 2131105548;
        r14.addAction(new SelectedMoreFragment$onViewCreated$2$1(this, r15, r3));
        r14.setLeftClickListener(new SelectedMoreFragment$onViewCreated$2$2(this, r14));
        r14.setImmersive(true);
        this.titleBar = r14;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r14 = null;
    L17:
        this.titleBarRightTv = r14.getRightText();
        this.adapter = new SelectedMoreAdapter(getContext());
        RecyclerView r16 = this.moreList;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("moreList");
        r16 = null;
    L20:
        RecyclerView.Adapter r4 = this.adapter;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L23:
        r16.setAdapter(r4);
        RecyclerView r17 = this.moreList;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("moreList");
        r17 = null;
    L26:
        r17.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        SelectedMoreAdapter r18 = this.adapter;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r18 = null;
    L29:
        r18.setOnItemRemoveListener(new AnonymousClass3(this));
        SelectedMoreAdapter r19 = this.adapter;
        if (r19 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r19 = null;
    L32:
        r19.setIsEnableChatPreview(this.isEnableChatPreview);
        SelectedMoreAdapter r20 = this.adapter;
        if (r20 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r20 = null;
    L35:
        Bundle r21 = getArguments();
        if (r21 == null) goto L39;
        String r22 = r21.getString(KEY_SCENE);
        if (r22 == null) goto L39;
    L40:
        r20.setScene(r22);
        SelectedMoreAdapter r23 = this.adapter;
        if (r23 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L44:
        r0.addAll(this.selectedData);
        updateRightTvBySelectedCount(this.selectedData.size());
        return;
    L43:
        r0 = r23;
    L39:
        r22 = "";
        goto L40
    L13:
        r13 = false;
        goto L14
    L9:
        r11 = false;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568191, r3, false);
    }
}
