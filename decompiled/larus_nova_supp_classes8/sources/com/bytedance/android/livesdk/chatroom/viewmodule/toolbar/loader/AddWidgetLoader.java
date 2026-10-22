package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AddWidgetBehavior;
import com.bytedance.android.livesdk.config.aa;
import com.bytedance.android.livesdk.config.b11;
import com.bytedance.android.livesdk.config.v9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AddWidgetLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddWidgetLoader extends AbsDynamicLoader {
    public final AddWidgetBehavior h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        return CollectionsKt.arrayListOf(new ToolbarButton[]{ToolbarButton.LIVE_WIDGET});
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        if (o4.c == true) goto L5;
        return false;
    L5:
        e r0 = this.f;
        if (r0 == null) goto L14;
        DataCenter r1 = r0.a;
        if (r1 == null) goto L14;
        Room r2 = z.o(r1);
        if (r2 == null) goto L14;
        RoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L14;
        Boolean r4 = Boolean.valueOf(r3.isEnableRoomWidget());
    L16:
        if (r4.booleanValue() == true) goto L18;
        return false;
    L18:
        if (aa.a.getValue().booleanValue() == false) goto L22;
        return true;
    L22:
        return false;
    L14:
        r4 = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
        if (((b11) v9.a.getValue()).b() == false) goto L5;
        return;
    L5:
        DataCenter r0 = this.a;
        if (r0 == null) goto L8;
        Room r1 = z.o(r0);
    L9:
        com.bytedance.android.livesdk.castscreen.utils.c.a("livesdk_live_widget_show", r1, AddWidgetLoader$onShowDialog$1.INSTANCE);
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.LIVE_WIDGET, this.h);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
    }

    public AddWidgetLoader(e r6) {
        Intrinsics.checkNotNullParameter(r6, "env");
        super(r6);
        RoomContext.a r0 = RoomContext.Companion;
        e r1 = this.f;
        if (r1 == null) goto L5;
        DataCenter r2 = r1.a;
    L6:
        RoomContext.a.c(r0, r2, 0, 2);
        this.h = new AddWidgetBehavior();
        return;
    L5:
        r2 = null;
        goto L6
    }
}
