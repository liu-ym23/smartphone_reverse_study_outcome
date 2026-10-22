package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.livead.GroupPurchaseItem;
import com.bytedance.android.livehostapi.business.depend.livead.IGroupPurchaseItemCallback;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements IGroupPurchaseItemCallback {
    public final /* synthetic */ GroupPurchaseConfig a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ ToolbarMatchInterface e;
    public final /* synthetic */ Function0 f;

    public final void onFailed(Throwable r4) {
        if (r4 == null) goto L5;
        r4.printStackTrace();
    L5:
        if (r4 == null) goto L7;
        String r5 = r4.getMessage();
    L9:
        if (Intrinsics.areEqual(r5, "empty data") == true) goto L11;
        return;
    L11:
        if (this.b == true) goto L19;
        this.c.invoke("req failed");
        if (this.d == false) goto L20;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("toolbar_server_ctrl", "1");
        IHostLiveLocalLife r1 = (IHostLiveLocalLife) this.a.f.getValue();
        if (r1 == null) goto L21;
        r1.sendLog(com.bytedance.android.live.core.utils.z.d(this.a.h, null), "live_life_performance_icon_first_abnormal_show", r6);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r5 = null;
        goto L9
    }

    public final void onSuccess(GroupPurchaseItem r4) {
        this.e.setExtraDataAfterCheck(r4);
        boolean r1 = true;
        if (com.bytedance.android.live.core.utils.z.m(this.a.h, true) == false) goto L21;
        List r0 = null;
        if (r4 == null) goto L7;
        UrlModel r2 = r4.getDynamicIconUrl();
    L8:
        if (r2 == null) goto L21;
        UrlModel r5 = r4.getDynamicIconUrl();
        if (r5 == null) goto L12;
        r0 = r5.getUrlList();
    L12:
        List r3 = r0;
        if (r3 != null) goto L15;
    L18:
        if (r1 == true) goto L21;
        this.f.invoke();
        return;
    L15:
        if (r3.isEmpty() == true) goto L18;
        r1 = false;
        goto L18
    L7:
        r2 = null;
    L21:
        this.c.invoke("dynamicIconUrl is null");
    }

    public j(GroupPurchaseConfig r1, boolean r2, Function1 r3, boolean r4, ToolbarMatchInterface r5, Function0 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
