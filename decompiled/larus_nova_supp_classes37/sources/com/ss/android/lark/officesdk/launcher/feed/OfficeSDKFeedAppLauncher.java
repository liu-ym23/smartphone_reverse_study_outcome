package com.ss.android.lark.officesdk.launcher.feed;

import android.content.Context;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKFeedAppLauncher {
    public final Lazy a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/feed/OfficeSDKFeedAppLauncher$OfficeSdkFeedInitorEntryPoint;", "", "getOfficeSdkFeedInitor", "Lcom/ss/android/lark/officesdk/launcher/feed/IProcessFeedInitor;", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface a {
        b n();
    }

    public OfficeSDKFeedAppLauncher(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new OfficeSDKFeedAppLauncher$initor$2(r2));
    }
}
