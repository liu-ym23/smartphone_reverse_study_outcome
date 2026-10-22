package com.ss.android.lark.picker.doubao;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.condition.DocTypes;
import com.ss.android.lark.picker.doubao.utils.DoubaoPickerUtils;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u001c\u0010\u0013\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/doubao/RecentFileListPuller;", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "docTypesCondition", "Lcom/ss/android/lark/picker/config/condition/DocTypes;", "<init>", "(Lcom/ss/android/lark/picker/config/condition/DocTypes;)V", "lastLabelCursor", "", "hasMore", "", "isLoadingMore", "loadData", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "needHeader", "canLoadMore", "onLoadMore", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RecentFileListPuller implements a {
    private static final Companion Companion = null;
    private static final int PAGE_SIZE = 30;
    private static final String TAG = "RecentFileListPuller";
    private final DocTypes docTypesCondition;
    private boolean hasMore;
    private boolean isLoadingMore;
    private String lastLabelCursor;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/RecentFileListPuller$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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

    public RecentFileListPuller() {
        DocTypes r0 = null;
        this(r0, 1, r0);
    }

    public boolean needHeader() {
        return false;
    }

    public boolean canLoadMore() {
        if (this.hasMore == true) goto L5;
    L7:
        return false;
    L5:
        if (this.isLoadingMore == true) goto L7;
        return true;
    }

    public RecentFileListPuller(DocTypes r2) {
        Intrinsics.checkNotNullParameter(r2, "docTypesCondition");
        this.docTypesCondition = r2;
        this.hasMore = true;
    }

    public static final /* synthetic */ boolean access$getHasMore$p(RecentFileListPuller r0) {
        return r0.hasMore;
    }

    public void loadData(final IGetDataCallback<List<SearchBaseInfo>> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Log.i(TAG, "loadData start. pageSize=30");
        this.hasMore = true;
        this.isLoadingMore = false;
        PickerBaseModuleDependency.getDependency().fetchRecentListPage("", 30, DoubaoPickerUtils.INSTANCE.mapDocTypesToRecentObjTypeList(this.docTypesCondition), new AnonymousClass1(this, r5));
    }

    public void onLoadMore(final IGetDataCallback<List<SearchBaseInfo>> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (canLoadMore() == true) goto L6;
        Log.i(TAG, "onLoadMore skip. hasMore=" + this.hasMore + ", isLoadingMore=" + this.isLoadingMore + '}');
        return;
    L6:
        this.isLoadingMore = true;
        Log.i(TAG, "onLoadMore start");
        PickerBaseModuleDependency.getDependency().fetchRecentListPage(this.lastLabelCursor, 30, DoubaoPickerUtils.INSTANCE.mapDocTypesToRecentObjTypeList(this.docTypesCondition), new C03671(this, r5));
    }

    public static final /* synthetic */ void access$setHasMore$p(RecentFileListPuller r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setLastLabelCursor$p(RecentFileListPuller r0, String r1) {
        r0.lastLabelCursor = r1;
    }

    public static final /* synthetic */ void access$setLoadingMore$p(RecentFileListPuller r0, boolean r1) {
        r0.isLoadingMore = r1;
    }

    public /* synthetic */ RecentFileListPuller(DocTypes r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = DocTypes.ALL.INSTANCE;
    L5:
        this(r1);
    }
}
