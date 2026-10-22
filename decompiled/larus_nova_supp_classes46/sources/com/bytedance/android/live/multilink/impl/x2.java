package com.bytedance.android.live.multilink.impl;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceAnchorContainerWidget;
import com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.MultiLinkVoiceGuestContainerWidget;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.multilink.external.api.core.service.IMultiLinkExternalService;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class x2 extends a implements com.bytedance.android.scope.o, IService, IMultiLinkExternalService, IMultiLinkInternalService {
    public void onStart() {
    }

    public void onStop() {
    }

    public x2() {
        jc1.k.l(IMultiLinkInternalService.class, this);
    }

    @Override // com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService
    public BaseMultiLinkWidget createVoiceGuestContainerWidget(hh1.w0 r2, gd0.p r3) {
        Intrinsics.checkNotNullParameter(r3, "liveCycleCallback");
        return new MultiLinkVoiceGuestContainerWidget(r2, r3);
    }

    @Override // com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService
    public cg6.a getMultiLinkComponentService(Object r3, Object r4) {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
    L22:
        jn0.b r5 = getInRoomService();
        if (r5 != null) goto L25;
        return null;
    L25:
        return r5.Pl();
    L5:
        if ((r3 instanceof DataCenter) == false) goto L14;
        com.bytedance.live.datacontext.n r6 = com.bytedance.android.live.liveinteract.api.utils.m.n((DataCenter) r3, null, 2).getMultiLinkRoomScope();
        if (r6 == null) goto L9;
        bn0.b r7 = (bn0.b) r6.getValue();
    L10:
        if (r7 == null) goto L14;
        return (cg6.a) com.bytedance.android.scope.m.e.d(r7, cg6.a.class);
    L9:
        r7 = null;
    L14:
        if ((r4 instanceof com.bytedance.android.livesdk.chatroom.o) == false) goto L22;
        com.bytedance.live.datacontext.n r8 = ((com.bytedance.android.livesdk.chatroom.o) r4).getMultiLinkRoomScope();
        if (r8 == null) goto L18;
        bn0.b r9 = (bn0.b) r8.getValue();
    L19:
        if (r9 == null) goto L22;
        return (cg6.a) com.bytedance.android.scope.m.e.d(r9, cg6.a.class);
    L18:
        r9 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService
    public BaseMultiLinkWidget createVoiceAnchorContainerWidget(FragmentManager r2, com.bytedance.android.live.pushstream.d r3, hh1.w0 r4) {
        Intrinsics.checkNotNullParameter(r3, "liveStream");
        return new MultiLinkVoiceAnchorContainerWidget(r2, r3, r4);
    }
}
