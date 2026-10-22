package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.GetLatestWRDSDataResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s4 extends w20.k1<w20.n9, GetLatestWRDSDataResultModel> {
    public final String a;
    public final DataCenter b;

    public s4(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        this.a = "GetLatestWRDSDataMethod";
    }

    public static String j(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof com.bytedance.android.live.base.model.message.h1) == false) goto L13;
        JSONObject r0 = new JSONObject();
        com.bytedance.android.live.base.model.message.h1 r4 = (com.bytedance.android.live.base.model.message.h1) r3;
        JsonObject r1 = r4.getExtra();
        if (r1 == null) goto L10;
        r0.put("extra", r1.toString());
    L10:
        r0.put("position", r4.getPosition());
        return r0.toString();
    L13:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r3);
    }

    public final void invoke(Object r6, CallContext r7) {
        w20.n9 r8 = (w20.n9) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r9 = r8.a();
        if (r9 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        GetLatestWRDSDataResultModel r11 = new GetLatestWRDSDataResultModel();
        r11.a(GetLatestWRDSDataResultModel.Code.Failed);
        r11.c("wrds key is empty");
        finishWithResult(r11);
        return;
    L11:
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), this.b, 0, 2);
        com.bytedance.live.datacontext.j r2 = r1.w1();
        String r3 = null;
        if (r2 == null) goto L16;
        ylc.e r4 = (ylc.e) r2.getValue();
        if (r4 == null) goto L16;
        com.ss.ugc.live.sdk.message.wrsc.data.a r5 = r4.e(r9);
    L17:
        if (r5 == null) goto L19;
        ALogger.i(this.a, "get roomDataSync, wrdsKey:" + r9 + ", wrdsVersion:" + r5.a);
        GetLatestWRDSDataResultModel.a r12 = new GetLatestWRDSDataResultModel.a();
        r12.b(r5.g);
        r12.d(String.valueOf(r5.a));
        r12.a(j(r5.e));
        Unit r13 = Unit.INSTANCE;
        GetLatestWRDSDataResultModel r14 = new GetLatestWRDSDataResultModel();
        r14.a(GetLatestWRDSDataResultModel.Code.Success);
        r14.b(r12);
        finishWithResult(r14);
        return;
    L19:
        String r15 = r8.b();
        com.bytedance.live.datacontext.j r16 = r1.getMessageManager();
        if (r16 == null) goto L22;
        vlc.d r17 = (vlc.d) r16.getValue();
    L24:
        if ((r17 instanceof xlc.a) == true) goto L26;
        r17 = null;
    L26:
        xlc.a r18 = (xlc.a) r17;
        if (r18 == null) goto L29;
        tlc.d r19 = r18.e("Webcast" + r9, r15);
    L30:
        if (r19 != null) goto L34;
        if (r18 == null) goto L33;
        r19 = r18.e(String.valueOf(r9), r15);
        goto L34
    L33:
        r19 = null;
    L34:
        ALogger.i(this.a, "get latestWrdsMessage, wrdsKey:" + r9 + ", wrdsSubKey:" + r15 + ", latestWrdsMessage:" + r19);
        if (r19 != null) goto L37;
        GetLatestWRDSDataResultModel.a r21 = new GetLatestWRDSDataResultModel.a();
        r21.b(r9);
        r21.d("0");
        r21.c(r15);
        r21.a("");
        Unit r22 = Unit.INSTANCE;
        GetLatestWRDSDataResultModel r23 = new GetLatestWRDSDataResultModel();
        r23.a(GetLatestWRDSDataResultModel.Code.Success);
        r23.b(r21);
        finishWithResult(r23);
        return;
    L37:
        GetLatestWRDSDataResultModel.a r24 = new GetLatestWRDSDataResultModel.a();
        r24.b(r19.getMessageMethod());
        boolean r25 = r19 instanceof xlc.b;
        if (r25 == true) goto L40;
        tlc.d r26 = null;
    L41:
        xlc.b r27 = (xlc.b) r26;
        if (r27 == null) goto L44;
        String r28 = String.valueOf(r27.getWRDSVersion());
    L45:
        r24.d(r28);
        if (r25 == true) goto L48;
        tlc.d r29 = null;
    L49:
        xlc.b r31 = (xlc.b) r29;
        if (r31 == null) goto L52;
        r3 = r31.getWRDSSubKey();
    L52:
        r24.c(r3);
        r24.a(j(r19));
        Unit r32 = Unit.INSTANCE;
        GetLatestWRDSDataResultModel r33 = new GetLatestWRDSDataResultModel();
        r33.a(GetLatestWRDSDataResultModel.Code.Success);
        r33.b(r24);
        finishWithResult(r33);
        return;
    L48:
        r29 = r19;
        goto L49
    L44:
        r28 = null;
        goto L45
    L40:
        r26 = r19;
        goto L41
    L29:
        r19 = null;
        goto L30
    L22:
        r17 = null;
    L16:
        r5 = null;
        goto L17
    L5:
        if (r9.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
