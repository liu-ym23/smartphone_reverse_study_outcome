package com.bytedance.android.livesdk.interactivity.api;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PSTopContainerService;", "Lcom/bytedance/android/livesdk/interactivity/api/IPSTopContainerService;", "Landroid/widget/FrameLayout;", "rootView", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lf52/b;", "createPSTopContainer", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PSTopContainerService implements IPSTopContainerService {
    public PSTopContainerService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPSTopContainerService
    public f52.b createPSTopContainer(FrameLayout r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        return new PSTopContainer(r2, r3);
    }
}
