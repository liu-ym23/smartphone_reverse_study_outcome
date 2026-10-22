package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenPluginService;", "Lcom/bytedance/android/livesdk/interactivity/api/IPublicScreenPluginService;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "publicScreenContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "loadInPublicScreenContext", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PublicScreenPluginService implements IPublicScreenPluginService {
    public PublicScreenPluginService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IPublicScreenPluginService
    public void loadInPublicScreenContext(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2, RoomContext r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
    }
}
