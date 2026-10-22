package com.bytedance.android.livesdk.interactivity.common.emoji;

import com.bytedance.android.live.base.model.message.e3;
import com.bytedance.android.live.base.model.message.i6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.emoji.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gb2.a;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/emoji/LowPcuGuideChatManager;", "Lcom/bytedance/android/livesdk/interactivity/api/emoji/f;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LowPcuGuideChatManager implements f, l, Observer<KVData> {
    public e3 a;
    public boolean b;
    public final d c;
    public final DataCenter d;

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.f
    public final void destroy() {
        this.d.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.f
    public final String getCity() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L9;
        m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
    L10:
        if (r3 == null) goto L15;
        IRoomOthersData r4 = r3.getRoomOthers();
        if (r4 != null) goto L14;
        return null;
    L14:
        return r4.getmRoomChatGuideLocaleCity();
    L15:
        return null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.f
    public final i6 getLowPcuGuideChatData() {
        e3 r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLowPcuGuideChatData();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.f
    public final boolean a() {
        return this.b;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L28;
        String r0 = r5.getKey();
        if (r0.hashCode() == 1995521258) goto L9;
        return;
    L9:
        if (r0.equals("cmd_specific_behavior_loaded") == false) goto L24;
        Object r6 = r5.getData();
        if ((r6 instanceof ToolbarBehaviorData) == true) goto L13;
        r6 = null;
    L13:
        ToolbarBehaviorData r7 = (ToolbarBehaviorData) r6;
        if (r7 == null) goto L25;
        ALogger.i("LowPcuGuideChatManager", r7.getId() + ", " + r7.getBehaviorMappingName() + ", " + r7.isFold() + ", roomId=" + a.e(this.d).getRoomId() + ", dataCenter=" + this.d.hashCode());
        int r1 = r7.getId();
        if (1 <= r1) goto L19;
        return;
    L19:
        if (9 >= r1) goto L21;
        return;
    L21:
        if (r7.isFold() == true) goto L27;
        this.b = true;
        return;
    L27:
        return;
    L25:
        return;
    L24:
        return;
    }

    public final void onMessage(tlc.d r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof e3) == false) goto L25;
        e3 r5 = (e3) r4;
        i6 r0 = r5.getLowPcuGuideChatData();
        if (r0 == null) goto L9;
        Integer r1 = Integer.valueOf(r0.b());
    L10:
        if (r1 != null) goto L13;
    L15:
        if (r1 != null) goto L18;
        return;
    L18:
        if (r1.intValue() != 2) goto L27;
        e3 r6 = this.a;
        if (r6 == null) goto L28;
        i6 r7 = r6.getLowPcuGuideChatData();
        if (r7 == null) goto L29;
        r7.d(2);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L13:
        if (r1.intValue() != 1) goto L15;
        this.a = r5;
        return;
    L9:
        r1 = null;
        goto L10
    }

    public LowPcuGuideChatManager(d r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c = r2;
        this.d = r3;
        if (r2 == null) goto L5;
        r2.addMessageListener("WebcastLowPcuGuideChatMessage", this);
    L5:
        r3.observe("cmd_specific_behavior_loaded", this);
    }
}
