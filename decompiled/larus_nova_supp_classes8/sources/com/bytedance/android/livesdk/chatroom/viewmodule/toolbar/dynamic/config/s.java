package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.utils.k0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarTransformWidgetBehavior;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final Context f;
    public final DataCenter g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean m() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(ToolbarButton.COMMERCE_LIVE_AD, ToolbarButton.TRANSFORM_WIDGET_AUDIENCE_MORE, ToolbarButton.TRANSFORM_WIDGET, ToolbarButton.TRANSFORM_WIDGET_MORE);
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.TransformWidget.INSTANCE;
    }

    public s(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(null, null, 7);
        this.f = r3;
        this.g = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "button");
        if (r5 == false) goto L11;
        DataCenter r6 = this.g;
        if (r6 == null) goto L7;
        LiveMode r7 = (LiveMode) r6.get("data_live_mode", LiveMode.VIDEO);
    L9:
        if (k0.e(r7) == true) goto L20;
        return null;
    L20:
        return new ToolbarTransformWidgetBehavior(this.f, r4, this.g);
    L7:
        r7 = null;
        goto L9
    L11:
        if (r4 == true) goto L21;
        Object r8 = r3.l.c;
        if ((r8 instanceof IExternalButton) == true) goto L15;
        r8 = null;
    L15:
        IExternalButton r9 = (IExternalButton) r8;
        if (r9 != null) goto L18;
        return null;
    L18:
        return new com.bytedance.android.livesdk.room.placeholder.behavior.k(r9);
    L21:
        return null;
    }
}
