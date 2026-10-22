package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AudienceFansRedPacketWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceFansRedPacketWidget extends LiveWidget implements Observer<KVData> {
    public boolean a;

    public final void onCreate() {
        super.onCreate();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.observe("click_fans_red_packet_from_preview", this, true);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L9;
        r1.observe("click_fans_red_packet_from_preview_schema", this, true);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a = false;
    }

    public AudienceFansRedPacketWidget() {
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (this.a == true) goto L36;
        String r0 = null;
        if (r7 == null) goto L8;
        String r1 = r7.getKey();
    L10:
        if (Intrinsics.areEqual(r1, "click_fans_red_packet_from_preview") == true) goto L15;
        if (r7 == null) goto L14;
        r0 = r7.getKey();
    L14:
        if (Intrinsics.areEqual(r0, "click_fans_red_packet_from_preview_schema") == true) goto L15;
        return;
    L15:
        DataCenter r8 = ((Widget) this).dataCenter;
        Boolean r2 = Boolean.FALSE;
        Boolean r9 = (Boolean) r8.get("click_fans_red_packet_from_preview", r2);
        String r3 = (String) ((Widget) this).dataCenter.get("click_fans_red_packet_from_preview_schema", "");
        if (r9.booleanValue() == true) goto L18;
        return;
    L18:
        if (r3.length() <= 0) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L33;
        this.a = true;
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L25;
        r11.put("click_fans_red_packet_from_preview", r2);
    L25:
        ALogger.d("PreviewFansRedPacketLogger", "FansRedPacket: handle schema: ".concat(r3));
        IRoomService r12 = jc1.k.f(IRoomService.class);
        if (r12 == null) goto L34;
        ILiveActionHandler r13 = r12.actionHandler();
        if (r13 == null) goto L35;
        r13.handle(getContext(), r3);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L20:
        r10 = false;
        goto L21
    L8:
        r1 = null;
        goto L10
    }
}
