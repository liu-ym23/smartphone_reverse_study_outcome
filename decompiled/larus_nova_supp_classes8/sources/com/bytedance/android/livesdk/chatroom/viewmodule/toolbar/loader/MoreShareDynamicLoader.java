package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.config.setting.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/MoreShareDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MoreShareDynamicLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        int r1 = ConfigCompatFixLoader.i;
        if (ConfigCompatFixLoader.a.a(this.a) == false) goto L6;
        return r0;
    L6:
        if (o.b() == true) goto L8;
    L18:
        r0.add(ToolbarButton.SHARE);
    L19:
        return r0;
    L8:
        if (this.d == false) goto L18;
        if (this.c == true) goto L18;
        com.bytedance.android.livesdk.service.f r2 = TTLiveSDKContext.getHostService();
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.user.f r3 = r2.h();
        if (r3 == null) goto L18;
        if (r3.isLogin() != true) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r4 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(ToolbarButton.SHARE.extended());
        r4.f(s1.B(2131922489));
        r4.i = 3;
        r4.k = new bp1.a();
        r0.add(r4);
        goto L19
    }

    public MoreShareDynamicLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
