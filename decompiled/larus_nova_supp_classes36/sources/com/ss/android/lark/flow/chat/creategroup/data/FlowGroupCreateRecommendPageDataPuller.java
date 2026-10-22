package com.ss.android.lark.flow.chat.creategroup.data;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowGroupCreateRecommendPageDataPuller implements y3c.a {
    public static final /* synthetic */ int b = 0;
    public final f a;

    public static final class a {
    }

    static {
    }

    public final boolean canLoadMore() {
        return false;
    }

    public final boolean needHeader() {
        return false;
    }

    public FlowGroupCreateRecommendPageDataPuller(f r2) {
        Intrinsics.checkNotNullParameter(r2, "pullerCallback");
        this.a = r2;
    }

    public final void loadData(final IGetDataCallback<List<SearchBaseInfo>> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        int r1 = d.a;
        Long r2 = this.a.getChatId();
        IGetDataCallback<List<? extends com.ss.android.lark.flow.chat.creategroup.data.a>> r3 = new AnonymousClass1(r10);
        Intrinsics.checkNotNullParameter(r3, "callback");
        Log.i("FlowGroupCreateContactRepository", "getContactList preferLocal=false ");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new FlowGroupCreateContactRepository$getContactList$1(false, r2, r3, null), 2, null);
    }

    public final void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }
}
