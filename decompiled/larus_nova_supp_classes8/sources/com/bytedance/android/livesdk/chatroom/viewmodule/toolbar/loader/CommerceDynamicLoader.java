package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ux;
import com.bytedance.android.livesdk.room.compatibility.commerce.ToolbarCommerceAudienceInMoreBehavior;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/CommerceDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceDynamicLoader extends AbsDynamicLoader {
    public final Context h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        if (ux.a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.c == true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        DataCenter r1 = this.a;
        Boolean r2 = Boolean.FALSE;
        if (((Boolean) r1.get("DATA_AUDIENCE_COMMERCE_MORE_SHOW", r2)).booleanValue() == false) goto L6;
        r0.add(ToolbarButton.COMMERCE_MORE);
    L6:
        if (((Boolean) this.a.get("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", r2)).booleanValue() == false) goto L8;
        r0.add(ToolbarButton.TRANSFORM_WIDGET_AUDIENCE_MORE);
    L8:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        this.a.observe("DATA_AUDIENCE_COMMERCE_MORE_SHOW", this);
        this.a.observe("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", this);
        y3.f(this.a).k(ToolbarButton.COMMERCE_MORE, new ToolbarCommerceAudienceInMoreBehavior(this.h));
    }

    public final Context getContext() {
        return this.h;
    }

    public CommerceDynamicLoader(e r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2);
        this.h = r3;
    }
}
