package com.bytedance.android.livesdk.interactivity.api;

import android.widget.FrameLayout;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.PSTopContainerService")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IPSTopContainerService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/widget/FrameLayout;", "rootView", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lf52/b;", "createPSTopContainer", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPSTopContainerService extends IService {
    f52.b createPSTopContainer(FrameLayout r1, DataCenter r2);
}
