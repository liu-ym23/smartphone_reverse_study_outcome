package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/InteractivityDegradeService;", "Lcom/bytedance/android/livesdk/interactivity/api/IInteractivityDegradeService;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lh32/a;", "createDegradeManager", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractivityDegradeService implements IInteractivityDegradeService {
    public InteractivityDegradeService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityDegradeService
    public h32.a createDegradeManager(RoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        if (PlatformExpUtils.a() == false) goto L13;
        if (((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.b.a.getValue()).booleanValue() == false) goto L13;
        if (com.bytedance.android.livesdk.config.setting.b.a() == false) goto L13;
        if (((Boolean) r2.isAnchor().getValue()).booleanValue() == false) goto L13;
        return new pc2.a();
    L13:
        if (PlatformExpUtils.a() == false) goto L21;
        if (((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.b.a.getValue()).booleanValue() == false) goto L21;
        if (((Boolean) r2.isAnchor().getValue()).booleanValue() == true) goto L21;
        return new pc2.a();
    L21:
        return new nc2.a();
    }
}
