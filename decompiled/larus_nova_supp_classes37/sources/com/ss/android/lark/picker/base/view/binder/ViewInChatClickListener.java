package com.ss.android.lark.picker.base.view.binder;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.reporter.SearchClickReporter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.y0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ViewInChatClickListener;", "T", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "<init>", "()V", "onViewInChatClick", "", "data", "position", "", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;I)V", "getThreadId", "", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)Ljava/lang/String;", "getChatId", "getThreadPosition", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)I", "getChatPosition", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class ViewInChatClickListener<T extends SearchBaseInfo> {
    public ViewInChatClickListener() {
    }

    public abstract String getChatId(T r1);

    public abstract int getChatPosition(T r1);

    public abstract String getThreadId(T r1);

    public abstract int getThreadPosition(T r1);

    public final void onViewInChatClick(final T r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        SearchClickReporter.reportSearchResultClickInChat(r4, "chat", "file", Integer.valueOf(r5 + 1), "enter_conversation");
        if (y0.d(getThreadId(r4)) == false) goto L6;
        PickerBaseModuleDependency.getDependency().peakFeedCard(getChatId(r4), SearchCommonConstants.FeedType.CHAT);
        PickerBaseModuleDependency.getDependency().openChat(getChatId(r4), getChatPosition(r4));
        return;
    L6:
        PickerBaseModuleDependency.getDependency().getChatById(getChatId(r4), new UIGetDataCallback(new AnonymousClass1(this, r4)));
    }
}
