package com.bytedance.android.livesdk.interactivity;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityService;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.TextMessageAdjuster;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/InteractivityService;", "Lcom/bytedance/android/livesdk/interactivity/api/IInteractivityService;", BuildConfig.FLAVOR, "registerInteractivityMessages", "init", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomDataContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/e;", "iInteractUIContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/i;", "publicScreenContainer", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/adjuster/h;", "createPublicScreenAdjuster", "Landroid/content/Context;", "context", "roomContext", "Lcom/bytedance/android/livesdk/interactivity/api/f;", "createInteractivityContext", "createInteractivityContextForPreview", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InteractivityService implements IInteractivityService {
    public InteractivityService() {
        init();
    }

    private final void registerInteractivityMessages() {
        ExternalMessageInject r0 = ExternalMessageInject.getInstance();
        InteractivityMessageType.Companion.getClass();
        r0.inject(InteractivityMessageType.access$getInjectInfoList$cp());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public final void init() {
        registerInteractivityMessages();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public com.bytedance.android.livesdk.interactivity.api.f createInteractivityContext(Context r2, RoomContext r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        InteractivityContext r0 = new InteractivityContext();
        r0.initContext(r2, r3, r4);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public com.bytedance.android.livesdk.interactivity.api.f createInteractivityContextForPreview(Context r2, RoomContext r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        InteractivityContext r0 = new InteractivityContext();
        r0.initContextForPreview(r2, r3, r4);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IInteractivityService
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.h createPublicScreenAdjuster(DataCenter r2, RoomContext r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.i r5) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomDataContext");
        Intrinsics.checkNotNullParameter(r4, "iInteractUIContext");
        Intrinsics.checkNotNullParameter(r5, "publicScreenContainer");
        return new TextMessageAdjuster(r2, r3, r4, r5);
    }
}
