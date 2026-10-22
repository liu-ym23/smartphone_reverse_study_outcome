package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.b2;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AnchorAIHelperLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorAIHelperLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        Room r0 = z.o(this.a);
        LiveMode r1 = z.c(this.a);
        boolean r2 = this.c;
        DataCenter r3 = this.a;
        boolean r4 = SelectedMsgABHelper.a(r2, r0, r1);
        boolean r5 = false;
        if (r4 == true) goto L6;
    L11:
        if (r5 == false) goto L15;
        return CollectionsKt.listOf(ToolbarButton.PUBLIC_SCREEN_AI_HELPER);
    L15:
        return CollectionsKt.emptyList();
    L6:
        if (r1 != LiveMode.VIDEO) goto L9;
        r5 = true;
        goto L11
    L9:
        if (r1 != LiveMode.AUDIO) goto L11;
        r5 = SelectedMsgABHelper.e(r3);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.PUBLIC_SCREEN_AI_HELPER, new b2());
    }

    public AnchorAIHelperLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
