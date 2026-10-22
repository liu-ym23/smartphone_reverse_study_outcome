package com.bytedance.android.annie.bridge.method;

import android.app.Activity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.LogoutResultModel;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "logout")
public final class y0 extends e7.l<JsonObject, LogoutResultModel> {
    public final WeakReference<Activity> a;

    public y0(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        Activity r11 = (Activity) r10.c(Activity.class);
        if (r11 == null) goto L6;
        this.a = new WeakReference(r11);
        return;
    }

    public y0(WeakReference<Activity> r10) {
        Intrinsics.checkNotNullParameter(r10, "activityRef");
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        JsonObject r12 = (JsonObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        IUserInfoService r13 = (IUserInfoService) Annie.getService(IUserInfoService.class, r11.a());
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r1 = r12.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r14 = (String) r1.next();
        r0.put(r14, r12.get(r14).getAsString().toString());
        goto L4
    L6:
        WeakReference<Activity> r15 = this.a;
        if (r15 == null) goto L11;
        Activity r16 = r15.get();
        if (r16 == null) goto L11;
        r13.z(r16, new x0(this));
        Unit r17 = Unit.INSTANCE;
    L12:
        if (r17 != null) goto L16;
        LogoutResultModel r18 = new LogoutResultModel();
        r18.a(LogoutResultModel.Code.Failed);
        r18.b("Activity is Null");
        finishWithResult(r18);
        return;
    L16:
        return;
    L11:
        r17 = null;
        goto L12
    }
}
