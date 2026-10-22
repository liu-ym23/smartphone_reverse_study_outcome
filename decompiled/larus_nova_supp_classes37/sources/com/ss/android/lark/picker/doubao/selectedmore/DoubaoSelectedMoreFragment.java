package com.ss.android.lark.picker.doubao.selectedmore;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\u0013J\u0012\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0010\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "moreList", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "bottomBarBtn", "Landroid/widget/Button;", "bottomBarDivider", "Landroid/view/View;", "adapter", "Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreAdapter;", "selectedData", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "removedData", "onConfirmRemovedData", "Lkotlin/Function1;", "", "", "getOnConfirmRemovedData", "()Lkotlin/jvm/functions/Function1;", "setOnConfirmRemovedData", "(Lkotlin/jvm/functions/Function1;)V", "onClosed", "Lkotlin/Function0;", "getOnClosed", "()Lkotlin/jvm/functions/Function0;", "setOnClosed", "(Lkotlin/jvm/functions/Function0;)V", "onAttach", "context", "Landroid/content/Context;", "closeWithoutResult", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "safeResName", "", "id", "", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoSelectedMoreFragment extends Fragment {
    public static final Companion Companion = null;
    public static final String TAG = "DoubaoSelectedMoreFragment";
    private DoubaoSelectedMoreAdapter adapter;
    private Button bottomBarBtn;
    private View bottomBarDivider;
    private CommonRecyclerView moreList;
    private Function0<Unit> onClosed;
    private Function1<? super List<? extends SearchBaseInfo>, Unit> onConfirmRemovedData;
    private final List<SearchBaseInfo> removedData;
    private final List<SearchBaseInfo> selectedData;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreFragment;", "data", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Serializable, java.lang.Object[]] */
        public final DoubaoSelectedMoreFragment newInstance(List<? extends SearchBaseInfo> r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            DoubaoSelectedMoreFragment r0 = new DoubaoSelectedMoreFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("selected.data", r4.toArray(new SearchBaseInfo[0]));
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void onDestroyView() {
        Log.i(TAG, "onDestroyView: fragmentId=" + getId() + '(' + safeResName(getId()) + "), tag=" + getTag() + ", removedCount=" + this.removedData.size() + ", selectedRemain=" + this.selectedData.size());
        Function0<Unit> r0 = this.onClosed;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        this.moreList = null;
        this.bottomBarBtn = null;
        this.bottomBarDivider = null;
        this.adapter = null;
        super.onDestroyView();
    }

    public DoubaoSelectedMoreFragment() {
        this.selectedData = new ArrayList();
        this.removedData = new ArrayList();
    }

    public final void closeWithoutResult() {
        if (getParentFragmentManager().isStateSaved() == false) goto L5;
        return;
    L5:
        getParentFragmentManager().popBackStack();
    }

    public final Function0<Unit> getOnClosed() {
        return this.onClosed;
    }

    public final Function1<List<? extends SearchBaseInfo>, Unit> getOnConfirmRemovedData() {
        return this.onConfirmRemovedData;
    }

    public static final /* synthetic */ List access$getRemovedData$p(DoubaoSelectedMoreFragment r0) {
        return r0.removedData;
    }

    public static final /* synthetic */ List access$getSelectedData$p(DoubaoSelectedMoreFragment r0) {
        return r0.selectedData;
    }

    private final String safeResName(int r2) {
        if (r2 != (-1)) goto L17;
        return "no_id";
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(getResources().getResourceName(r2));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        String r4 = (String) r3;
        if (r4 != null) goto L19;
        return "unknown";
    L19:
        return r4;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        StringBuilder r3 = new StringBuilder("onAttach: fragmentId=");
        r3.append(getId());
        r3.append('(');
        r3.append(safeResName(getId()));
        r3.append("), tag=");
        r3.append(getTag());
        r3.append(", parent=");
        Fragment r0 = getParentFragment();
        if (r0 == null) goto L5;
        String r1 = r0.getClass().getSimpleName();
    L6:
        r3.append(r1);
        r3.append(", host=");
        r3.append(requireActivity().getClass().getSimpleName());
        r3.append('@');
        r3.append(System.identityHashCode(requireActivity()));
        Log.i(TAG, r3.toString());
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void onCreate(Bundle r11) {
        super.onCreate(r11);
        Bundle r0 = getArguments();
        SearchBaseInfo[] r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable("selected.data");
    L7:
        if ((r2 instanceof SearchBaseInfo[]) == false) goto L9;
        r1 = (SearchBaseInfo[]) r2;
    L9:
        if (r1 == null) goto L11;
        CollectionsKt.addAll(this.selectedData, r1);
    L11:
        StringBuilder r3 = new StringBuilder("onCreate: fragmentId=");
        r3.append(getId());
        r3.append('(');
        r3.append(safeResName(getId()));
        r3.append("), tag=");
        r3.append(getTag());
        r3.append(", savedInstanceState=");
        if (r11 == null) goto L14;
        boolean r12 = true;
    L15:
        r3.append(r12);
        r3.append(", selectedCount=");
        r3.append(this.selectedData.size());
        r3.append(", argumentsKeys=");
        Bundle r13 = getArguments();
        if (r13 == null) goto L21;
        Set<String> r14 = r13.keySet();
        if (r14 == null) goto L21;
        String r15 = CollectionsKt.joinToString$default(r14, null, null, null, 0, null, null, 63, null);
        if (r15 == null) goto L21;
    L22:
        r3.append(r15);
        Log.i(TAG, r3.toString());
        return;
    L21:
        r15 = "null";
        goto L22
    L14:
        r12 = false;
        goto L15
    L5:
        r2 = null;
        goto L7
    }

    public final void setOnClosed(Function0<Unit> r1) {
        this.onClosed = r1;
    }

    public final void setOnConfirmRemovedData(Function1<? super List<? extends SearchBaseInfo>, Unit> r1) {
        this.onConfirmRemovedData = r1;
    }

    public void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        Log.i(TAG, "onViewCreated: fragmentId=" + getId() + '(' + safeResName(getId()) + "), tag=" + getTag() + ", view=" + r5.getClass().getSimpleName() + ", viewId=" + r5.getId() + '(' + safeResName(r5.getId()) + ')');
        this.moreList = r5.findViewById(2131380315);
        this.bottomBarBtn = (Button) r5.findViewById(2131385846);
        this.bottomBarDivider = r5.findViewById(2131362388);
        Button r7 = this.bottomBarBtn;
        if (r7 == null) goto L5;
        r7.setVisibility(8);
    L5:
        View r8 = this.bottomBarDivider;
        if (r8 == null) goto L8;
        r8.setVisibility(8);
    L8:
        final DoubaoSelectedMoreAdapter r9 = new DoubaoSelectedMoreAdapter(requireContext());
        CommonRecyclerView r10 = this.moreList;
        if (r10 == null) goto L11;
        r10.setAdapter(r9);
    L11:
        CommonRecyclerView r11 = this.moreList;
        if (r11 == null) goto L14;
        r11.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
    L14:
        r9.setOnItemRemoveListener(new DoubaoSelectedMoreFragment$onViewCreated$1$1(this, r9));
        r9.addAll(this.selectedData);
        this.adapter = r9;
    }

    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        StringBuilder r7 = new StringBuilder("onCreateView: fragmentId=");
        r7.append(getId());
        r7.append('(');
        r7.append(safeResName(getId()));
        r7.append("), tag=");
        r7.append(getTag());
        r7.append(", container=");
        if (r5 == null) goto L5;
        String r1 = r5.getClass().getSimpleName();
    L6:
        r7.append(r1);
        r7.append(", containerId=");
        int r2 = -1;
        if (r5 == null) goto L9;
        int r3 = r5.getId();
    L10:
        r7.append(r3);
        r7.append('(');
        if (r5 == null) goto L13;
        r2 = r5.getId();
    L13:
        r7.append(safeResName(r2));
        r7.append(')');
        Log.i(TAG, r7.toString());
        return r4.inflate(2131563315, r5, false);
    L9:
        r3 = -1;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
