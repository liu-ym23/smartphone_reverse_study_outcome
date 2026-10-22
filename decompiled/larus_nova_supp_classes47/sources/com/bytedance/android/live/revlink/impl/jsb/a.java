package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.BattleLaunchResultModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import w20.q7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b
    public final void a(q7 r6) {
        Intrinsics.checkNotNullParameter(r6, "battleLaunchResult");
        b r0 = this.a;
        BattleLaunchResultModel r1 = new BattleLaunchResultModel();
        Integer r2 = r6.a;
        JsonObject r3 = null;
        if (r2 == null) goto L16;
        int r4 = r2.intValue();
        if (r4 != (-2)) goto L7;
        BattleLaunchResultModel.Code r5 = BattleLaunchResultModel.Code.NOT_REGISTER;
    L17:
        r1.a(r5);
        JSONObject r7 = r6.b;
        if (r7 == null) goto L23;
        String r8 = GsonProtectorUtils.toJson(l97.a.a, r7);
        if (r8 == null) goto L22;
        r3 = (JsonObject) GsonProtectorUtils.fromJson(l97.a.a, r8, TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)));
    L22:
        r1.b(r3);
    L23:
        r0.finishWithResult(r1);
        return;
    L7:
        if (r4 == (-1)) goto L14;
        if (r4 != 0) goto L10;
        r5 = BattleLaunchResultModel.Code.Failed;
        goto L17
    L10:
        if (r4 == 1) goto L12;
        r5 = BattleLaunchResultModel.Code.Failed;
        goto L17
    L12:
        r5 = BattleLaunchResultModel.Code.Success;
        goto L17
    L14:
        r5 = BattleLaunchResultModel.Code.NO_PERMISSION;
        goto L17
    L16:
        r5 = null;
        goto L17
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.b
    public final void onFailed(Throwable r2) {
        this.a.finishWithFailure(r2);
    }
}
