package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.b3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AnchorFlowFeedbackLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorFlowFeedbackLoader extends AbsDynamicLoader {
    public final Context h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        int r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.b.a;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L11;
        m r3 = r2.getRoom();
        if (r3 == null) goto L11;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L11;
        Map r5 = r4.anchorAbMap;
        if (r5 == null) goto L11;
        String r6 = (String) r5.get("live_anchor_flow_feedback_enable");
    L13:
        if (StringsKt.equals$default(r6, "1", false, 2, null) == false) goto L15;
        r0.add(ToolbarButton.FLOW_FEEDBACK);
    L15:
        return r0;
    L11:
        r6 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.FLOW_FEEDBACK, new b3(this.h));
    }

    public final Context getContext() {
        return this.h;
    }

    public AnchorFlowFeedbackLoader(e r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2);
        this.h = r3;
    }
}
