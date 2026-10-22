package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.l5;
import com.bytedance.android.livesdk.config.lt0;
import com.bytedance.android.livesdk.config.setting.p;
import java.util.HashSet;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nm1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/ShareToDailyDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareToDailyDynamicLoader extends AbsDynamicLoader {
    public final l5 h;
    public final Context i;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        return !k.n(ILiveShareService.class).enableFilterBusinessAccount();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        HashSet r0 = new HashSet();
        if (this.d == false) goto L18;
        int r1 = p.a;
        Integer r2 = lt0.a.getValue();
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L18;
        m r4 = pm1.f.l();
        if (r4 != null) goto L15;
    L16:
        r0.add(ToolbarButton.SHARE_TO_DAILY);
        goto L18
    L15:
        if (r4.a(this.a) == true) goto L18;
    L8:
        if (r2.intValue() != 1) goto L10;
        r3 = true;
    L18:
        return CollectionsKt.toList(r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).k(ToolbarButton.SHARE_TO_DAILY, this.h);
    }

    public final Context getContext() {
        return this.i;
    }

    public ShareToDailyDynamicLoader(Context r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "env");
        super(r3);
        this.i = r2;
        this.h = new l5(r2, this.a);
    }
}
