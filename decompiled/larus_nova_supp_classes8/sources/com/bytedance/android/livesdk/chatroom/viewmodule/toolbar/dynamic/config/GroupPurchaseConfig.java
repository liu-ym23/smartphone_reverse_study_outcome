package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarGroupPurchaseAudienceBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarGroupPurchaseWidgetBehavior;
import com.bytedance.android.livesdk.room.placeholder.behavior.AudienceGroupPurchaseWrapper;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GroupPurchaseConfig extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Lazy f;
    public final Context g;
    public final DataCenter h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.GROUP_PURCHASE_AUDIENCE, null, ToolbarButton.GROUP_PURCHASE, ToolbarButton.GROUP_PURCHASE_MORE);
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.LifeGroupon.INSTANCE;
    }

    public GroupPurchaseConfig(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(null, null, 7);
        this.g = r3;
        this.h = r4;
        this.f = LazyKt.lazy(GroupPurchaseConfig$liveLocalLifeService$2.INSTANCE);
        IHostLiveLocalLife r5 = jc1.k.f(IHostLiveLocalLife.class);
        if (r5 == null) goto L7;
        if (r5.getLiveLifeIconButtonOptEnable() != true) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.core.utils.z.e(r4, false) == true) goto L12;
        Lazy r6 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r4, NewToolbarButtonConstants.LifeGroupon.INSTANCE, new k(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if (r4 == false) goto L8;
        LiveMode r5 = (LiveMode) this.h.get("data_live_mode", LiveMode.VIDEO);
        int r6 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(r5) == true) goto L17;
        return null;
    L17:
        return new ToolbarGroupPurchaseWidgetBehavior(r3);
    L8:
        Object r7 = r2.l.c;
        IHostLiveLocalLife r8 = jc1.k.f(IHostLiveLocalLife.class);
        if (r8 == null) goto L16;
        if (r8.getLiveLifeIconButtonOptEnable() != true) goto L16;
        if ((r7 instanceof IExternalButton) == false) goto L16;
        return new AudienceGroupPurchaseWrapper((IExternalButton) r7);
    L16:
        return new ToolbarGroupPurchaseAudienceBehavior(this.g);
    }

    public static final void q(GroupPurchaseConfig r11, boolean r12, long r13, ToolbarMatchInterface r15, Function0 r16, Function1 r17, boolean r18, String r19) {
        IHostLiveLocalLife r8 = (IHostLiveLocalLife) r11.f.getValue();
        if (r8 == null) goto L9;
        if (r12 == false) goto L6;
        String r0 = "push";
    L7:
        r8.getLifeComponentInfo(r0, r13, new j(r11, r12, r17, r18, r15, r16), com.bytedance.android.live.core.utils.z.d(r11.h, null), r19);
        return;
    L6:
        r0 = "enter";
        goto L7
    }
}
