package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import am2.x;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.x3;
import com.bytedance.android.livesdk.config.t90;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/MinorRefundLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MinorRefundLoader extends AbsDynamicLoader {
    public final x3 h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        return CollectionsKt.arrayListOf(new ToolbarButton[]{ToolbarButton.MINOR_REFUND});
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.f.a, 0, 2);
        boolean r1 = t90.a.getValue().enableShow;
        if (r0 == null) goto L5;
        boolean r3 = r0.isMediaRoom();
    L6:
        if (r0 == null) goto L8;
        boolean r2 = r0.isVSRoom();
    L9:
        IUserService r4 = k.f(IUserService.class);
        if (r4 == null) goto L16;
        com.bytedance.android.livesdk.user.f r5 = r4.user();
        if (r5 == null) goto L16;
        if (r5.isLogin() != true) goto L16;
        boolean r6 = true;
    L17:
        if (r1 == false) goto L23;
        if (r3 == true) goto L24;
        if (r2 == true) goto L25;
        if (r6 == false) goto L26;
        return true;
    L26:
        return false;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L16:
        r6 = false;
        goto L17
    L8:
        r2 = false;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.MINOR_REFUND, this.h);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        HashMap r1 = new HashMap();
        ILiveMode r2 = (ILiveMode) this.f.a.get("data_live_mode", null);
        int r3 = h1.a;
        r1.put("live_type", i1.a(r2));
        Unit r4 = Unit.INSTANCE;
        r0.sendLog("livesdk_teenager_refund_button_show", r1, new Object[]{new x(), Room.class});
    }

    public MinorRefundLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new x3();
    }
}
