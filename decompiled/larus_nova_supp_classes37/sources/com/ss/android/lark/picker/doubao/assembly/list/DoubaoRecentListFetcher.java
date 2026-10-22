package com.ss.android.lark.picker.doubao.assembly.list;

import com.bytedance.ee.bear.list.constants.RankType;
import com.bytedance.ee.bear.list.constants.ThumbnailPolicy;
import com.bytedance.ee.bear.list.recent.f;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.RecentListPageResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/doubao/assembly/list/DoubaoRecentListFetcher;", "", "<init>", "()V", "TAG", "", "doubaoObjTypeList", "", "", "THUMBNAIL_SIZE_PX", "thumbnailPolicy", "fetchRecentListPage", "", "lastLabel", "length", "objTypeList", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/picker/base/RecentListPageResult;", "picker-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoRecentListFetcher {
    public static final DoubaoRecentListFetcher INSTANCE = null;
    private static final String TAG = "DoubaoRecentListFetcher";
    private static final int THUMBNAIL_SIZE_PX = 40;
    private static final List<Integer> doubaoObjTypeList = null;
    private static final int thumbnailPolicy = 0;

    private DoubaoRecentListFetcher() {
    }

    static {
        INSTANCE = new DoubaoRecentListFetcher();
        doubaoObjTypeList = CollectionsKt.listOf(new Integer[]{0, 12, 22, 30, 3});
        thumbnailPolicy = ThumbnailPolicy.ALLOW_UP_DEFAULT.getValue();
    }

    @JvmStatic
    public static final void fetchRecentListPage(final String r9, int r10, List<Integer> r11, final IGetDataCallback<RecentListPageResult> r12) {
        Intrinsics.checkNotNullParameter(r12, "callback");
        StringBuilder r0 = new StringBuilder("fetchRecentListPage start. length=");
        r0.append(r10);
        r0.append(", lastLabelLen=");
        if (r9 == null) goto L5;
        int r1 = r9.length();
    L6:
        r0.append(r1);
        Log.i(TAG, r0.toString());
        if (r11 != null) goto L9;
        r11 = doubaoObjTypeList;
    L9:
        f r2 = new f();
        r2.d(r9, r11, r10, RankType.VISIT_TIME.getValue(), 40, 40, thumbnailPolicy, new AnonymousClass1(r12, r9));
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
