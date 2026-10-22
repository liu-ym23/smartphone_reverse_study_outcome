package com.bytedance.android.livesdk.dsl.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h70.b;
import j70.h;
import kotlin.Metadata;
import yt1.f;
import yt1.n;
import yt1.q;
import zt1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ServiceLookup("com.bytedance.android.livesdk.dslservice.DSLServiceImpl")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J2\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\rH&J\u0010\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014H&J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u001b\u001a\u00020\u0012H&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/dsl/api/IDSLManagerService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lyt1/n;", "createDSLManager", "createDummy", "Lzt1/c;", "createDSLTemplateCenter", "Landroid/view/View;", "T", "", LiveEndPageData.TAG_NAME, "Lyt1/f;", "customProvider", "type", "", "registerCustomViewManger", "Lj70/h;", "Lh70/b;", "getDescriptor", "Lyt1/q;", "key", "", "hasLocalGlobalCache", "onClear", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDSLManagerService extends IService {
    n createDSLManager(Context r1, DataCenter r2);

    c createDSLTemplateCenter(DataCenter r1);

    n createDummy();

    h<? extends b> getDescriptor();

    boolean hasLocalGlobalCache(q r1);

    void onClear();

    <T extends View> void registerCustomViewManger(String r1, f<T> r2, String r3);
}
