package com.ss.android.lark.picker.recommand.history;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.recommend.DefaultRecommendView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/recommand/history/HistoryRecommendView;", "Lcom/ss/android/lark/picker/base/view/recommend/DefaultRecommendView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pickerRecommendRequestId", "", "setUp", "", "itemConsumeDelegate", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "callback", "Lcom/ss/android/lark/picker/recommand/history/HistoryRecommendView$HistoryActionCallback;", "Companion", "HistoryActionCallback", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class HistoryRecommendView extends DefaultRecommendView {
    public static final Companion Companion = null;
    public static final String TAG = "HistoryRecommendView";
    private String pickerRecommendRequestId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/recommand/history/HistoryRecommendView$Companion;", "", "<init>", "()V", "TAG", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/recommand/history/HistoryRecommendView$HistoryActionCallback;", "", "onDeleteClick", "", "view", "Landroid/view/View;", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "position", "", "onContentClick", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface HistoryActionCallback {
        void onContentClick(View r1, SearchBaseInfo r2, int r3);

        void onDeleteClick(View r1, SearchBaseInfo r2, int r3);
    }

    static {
        Companion = new Companion(null);
    }

    public HistoryRecommendView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.pickerRecommendRequestId = "";
    }

    public static final /* synthetic */ String access$getPickerRecommendRequestId$p(HistoryRecommendView r0) {
        return r0.pickerRecommendRequestId;
    }

    public static final /* synthetic */ void access$setPickerRecommendRequestId$p(HistoryRecommendView r0, String r1) {
        r0.pickerRecommendRequestId = r1;
    }

    public final void setUp(SearchResultView.IOnBusinessConsumeItem r1, final HistoryActionCallback r2) {
        erasePadding();
        setOnBusinessConsumeItem(r1);
        setDataPuller(new AnonymousClass1(this));
        setClickHandler(new AnonymousClass2());
        setCustomBinder(new AnonymousClass3(this, r2));
        setAllowEmpty(true);
    }

    public static /* synthetic */ void setUp$default(HistoryRecommendView r0, SearchResultView.IOnBusinessConsumeItem r1, HistoryActionCallback r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setUp(r1, r2);
    }
}
