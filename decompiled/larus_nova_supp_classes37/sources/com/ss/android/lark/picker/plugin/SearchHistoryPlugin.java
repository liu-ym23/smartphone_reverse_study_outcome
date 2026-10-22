package com.ss.android.lark.picker.plugin;

import android.content.Context;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.usearch.ClientType;
import com.ss.android.lark.pb.usearch.DeleteDoubaoSearchQueryHistoryRequest;
import com.ss.android.lark.pb.usearch.DoubaoSearchQueryMeta;
import com.ss.android.lark.pb.usearch.DoubaoSearchSceneMeta;
import com.ss.android.lark.pb.usearch.PutDoubaoSearchQueryHistoryRequest;
import com.ss.android.lark.picker.PickerViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.PickerExtra;
import com.ss.android.lark.picker.recommand.history.HistoryRecommendView;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/picker/plugin/SearchHistoryPlugin;", "Lcom/ss/android/lark/picker/plugin/PickerPlugin;", "<init>", "()V", "apply", "", "picker", "Lcom/ss/android/lark/picker/base/widget/BasePicker;", "viewModel", "Lcom/ss/android/lark/picker/PickerViewModel;", "extra", "Lcom/ss/android/lark/picker/config/PickerExtra;", "recommendEmptyIconResId", "", "recommendEmptyHintText", "", "(Lcom/ss/android/lark/picker/base/widget/BasePicker;Lcom/ss/android/lark/picker/PickerViewModel;Lcom/ss/android/lark/picker/config/PickerExtra;Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "updateSearchHistory", "context", "Landroid/content/Context;", "history", "Lcom/ss/android/lark/picker/plugin/SearchHistoryPlugin$SearchHistoryBean;", "onHistoryDeleteClick", "Companion", "SearchHistoryBean", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchHistoryPlugin implements PickerPlugin {
    public static final Companion Companion = null;
    public static final String TAG = "SearchHistoryPlugin";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/plugin/SearchHistoryPlugin$Companion;", "", "<init>", "()V", "TAG", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/picker/plugin/SearchHistoryPlugin$SearchHistoryBean;", "", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "", "digest", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "getDigest", "setDigest", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class SearchHistoryBean {
        private String digest;
        private String query;

        public SearchHistoryBean() {
            String r0 = null;
            this(r0, r0, 3, r0);
        }

        public static /* synthetic */ SearchHistoryBean copy$default(SearchHistoryBean r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.query;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.digest;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.query;
        }

        public final String component2() {
            return this.digest;
        }

        public final SearchHistoryBean copy(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
            Intrinsics.checkNotNullParameter(r3, "digest");
            return new SearchHistoryBean(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SearchHistoryBean) == true) goto L8;
            return false;
        L8:
            SearchHistoryBean r6 = (SearchHistoryBean) r5;
            if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.digest, r6.digest) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.query.hashCode() * 31) + this.digest.hashCode();
        }

        public String toString() {
            return "SearchHistoryBean(query=" + this.query + ", digest=" + this.digest + ')';
        }

        public final String getDigest() {
            return this.digest;
        }

        public final String getQuery() {
            return this.query;
        }

        public final void setDigest(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.digest = r2;
        }

        public final void setQuery(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.query = r2;
        }

        public SearchHistoryBean(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
            Intrinsics.checkNotNullParameter(r3, "digest");
            this.query = r2;
            this.digest = r3;
        }

        public /* synthetic */ SearchHistoryBean(String r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = "";
        L8:
            this(r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SearchHistoryPlugin() {
    }

    public final void onHistoryDeleteClick(Context r3, final SearchHistoryBean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "history");
        DeleteDoubaoSearchQueryHistoryRequest.Builder r5 = new DeleteDoubaoSearchQueryHistoryRequest.Builder();
        r5.mquery_meta = new DoubaoSearchQueryMeta.Builder().digest(r4.getDigest()).m2633build();
        r5.mscene_meta = new DoubaoSearchSceneMeta.Builder().scene(DoubaoSearchSceneMeta.DoubaoSearchScene.PICKER).picker_scene("DOUBAO_SEARCH_DOCS").m2636build();
        r5.client_type(ClientType.ANDROID);
        SdkSender.sendPassThroughRequest(Command.DELETE_DOUBAO_SEARCH_QUERY_HISTORY, r5, new C03701(r4), C03712.INSTANCE);
    }

    public final void updateSearchHistory(Context r3, SearchHistoryBean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "history");
        PutDoubaoSearchQueryHistoryRequest.Builder r5 = new PutDoubaoSearchQueryHistoryRequest.Builder();
        r5.mscene_meta = new DoubaoSearchSceneMeta.Builder().scene(DoubaoSearchSceneMeta.DoubaoSearchScene.PICKER).picker_scene("DOUBAO_SEARCH_DOCS").m2636build();
        r5.client_type(ClientType.ANDROID);
        r5.mquery_meta = new DoubaoSearchQueryMeta.Builder().query(r4.getQuery()).m2633build();
        SdkSender.sendPassThroughRequest(Command.PUT_DOUBAO_SEARCH_QUERY_HISTORY, r5, new C03721(), C03732.INSTANCE);
    }

    @Override // com.ss.android.lark.picker.plugin.PickerPlugin
    public void apply(final BasePicker<?, ?> r2, PickerViewModel r3, PickerExtra r4, Integer r5, CharSequence r6) {
        Intrinsics.checkNotNullParameter(r2, "picker");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        boolean r7 = false;
        if (r4 != null) goto L5;
    L7:
        if (r7 == true) goto L9;
        return;
    L9:
        HistoryRecommendView r8 = new HistoryRecommendView(r2.getContext());
        r8.setBackgroundColor(r2.getResources().getColor(2131100548));
        r8.setRecommendEmptyViewConfig(r5, r6);
        r8.setUp(r2.getBusinessConsumeDelegate(), new AnonymousClass1(this, r2));
        r2.attachRecommendView(r8);
        r2.getSearchInputView().setOnImeSearchAction(new AnonymousClass2(this, r2));
        return;
    L5:
        if (r4.getEnableSearchHistory() != true) goto L7;
        r7 = true;
        goto L7
    }
}
