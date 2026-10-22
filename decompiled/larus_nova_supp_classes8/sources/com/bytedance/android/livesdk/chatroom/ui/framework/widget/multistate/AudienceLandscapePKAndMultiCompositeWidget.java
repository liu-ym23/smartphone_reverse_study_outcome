package com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate;

import android.view.View;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import h70.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/multistate/AudienceLandscapePKAndMultiCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/multistate/PKAndMultiCompositeWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLandscapePKAndMultiCompositeWidget extends PKAndMultiCompositeWidget {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final boolean Bq() {
        return DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), false, false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Gq() {
        Room r0 = getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L11;
        View r1 = Ia();
        if (r1 == null) goto L12;
        r1.setVisibility(0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Jq() {
        Room r0 = getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L11;
        View r1 = Ia();
        if (r1 == null) goto L12;
        r1.setVisibility(8);
        return;
    L12:
        return;
    }

    public AudienceLandscapePKAndMultiCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Mq(z0 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (hq() == true) goto L5;
        return;
    L5:
        super.Mq(r3);
        b r0 = getComponentContext();
        if (r0 == null) goto L10;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L10;
        jo1.b r2 = (jo1.b) r1.getAbility(jo1.b.class);
    L11:
        if (r2 == null) goto L14;
        r2.Go(r3);
        return;
    L14:
        return;
    L10:
        r2 = null;
        goto L11
    }
}
