package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.InteractivityService")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IInteractivityService;", "Lcom/bytedance/android/live/base/IService;", BuildConfig.FLAVOR, "init", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomDataContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/e;", "iInteractUIContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/i;", "publicScreenContainer", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/h;", "createPublicScreenAdjuster", "Landroid/content/Context;", "context", "roomContext", "Lcom/bytedance/android/livesdk/interactivity/api/f;", "createInteractivityContext", "createInteractivityContextForPreview", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractivityService extends IService {
    f createInteractivityContext(Context r1, RoomContext r2, DataCenter r3);

    f createInteractivityContextForPreview(Context r1, RoomContext r2, DataCenter r3);

    com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.h createPublicScreenAdjuster(DataCenter r1, RoomContext r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.i r4);

    void init();
}
