package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.i3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.p4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.u2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/MoreMixShareLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MoreMixShareLoader extends AbsDynamicLoader {
    public final Context h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        if (MoreMixSharePanelUtils.INSTANCE.isMoreMixShareMode(this.c, this.d) == false) goto L22;
        Room r0 = (Room) this.a.get("data_room", null);
        if (r0 == null) goto L17;
        User r3 = r0.getOwner();
        if (r3 == null) goto L17;
        if (r3.getSecret() != 1) goto L13;
    L16:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L22;
        return CollectionsKt.listOf(new ToolbarButton[]{ToolbarButton.IM_LIST_VIRTUAL, ToolbarButton.COPY_LINK, ToolbarButton.QR_CODE});
    L13:
        if (r0.getRoomAuthStatus() == null) goto L17;
        if (r0.getRoomAuthStatus().getShowShare() == 2) goto L16;
    L17:
        r1 = false;
    L22:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.IM_LIST_VIRTUAL, new i3());
        y3.f(this.a).k(ToolbarButton.COPY_LINK, new u2(this.f.a));
        y3.f(this.a).k(ToolbarButton.QR_CODE, new p4(this.f.a));
    }

    public final Context getContext() {
        return this.h;
    }

    public MoreMixShareLoader(Context r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "env");
        super(r3);
        this.h = r2;
    }
}
