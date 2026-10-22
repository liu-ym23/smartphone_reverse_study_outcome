package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.vipim.VipIMManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/VipIMLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VipIMLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ExtendedToolbarButton.a r0 = ExtendedToolbarButton.h;
        ToolbarButton r1 = ToolbarButton.VIP_IM;
        r0.getClass();
        ExtendedToolbarButton.b r2 = ExtendedToolbarButton.a.a(r1);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r3 = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e(r2);
        r3.b = r2.i.getDrawableFolded();
        r3.f(r2.g());
        Lazy r4 = VipIMManager.f;
        String r5 = VipIMManager.a.a().b;
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r3.f(r5);
    L6:
        return CollectionsKt.arrayListOf(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e[]{r3});
    }

    public VipIMLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
