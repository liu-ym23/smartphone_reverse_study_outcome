package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.ReportALogParamModel;
import com.bytedance.android.annie.bridge.method.abs.ReportALogResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "reportALog")
public final class r1 extends e7.u<ReportALogParamModel, ReportALogResultModel> {

    public static final class a {
    }

    static {
    }

    public r1() {
    }

    public final void invoke(Object r11, CallContext r12) {
        ReportALogParamModel r13 = (ReportALogParamModel) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        String r0 = r13.c();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        ReportALogResultModel r14 = new ReportALogResultModel();
        r14.a(ReportALogResultModel.Code.InvalidParam);
        r14.b("message is null or blank");
        finishWithResult(r14);
        return;
    L12:
        if (r13.b() != null) goto L14;
        ReportALogResultModel r15 = new ReportALogResultModel();
        r15.a(ReportALogResultModel.Code.InvalidParam);
        r15.b("level is not in enum");
        finishWithResult(r15);
        return;
    L14:
        String r10 = r13.c();
        Intrinsics.checkNotNull(r10);
        String r16 = r13.d();
        ReportALogParamModel.Level r17 = r13.b();
        ReportALogParamModel.a r18 = r13.a();
        if (r18 == null) goto L17;
        Integer r19 = r18.c();
        Intrinsics.checkNotNull(r19);
        int r20 = r19.intValue();
        String r21 = r18.b();
        Intrinsics.checkNotNull(r21);
        String r110 = r18.a();
        Intrinsics.checkNotNull(r110);
        String r22 = r110;
        int r23 = r20;
        String r24 = r21;
    L23:
        int r111 = com.bytedance.android.annie.util.a.a;     // Catch: IllegalArgumentException -> L20
        com.bytedance.android.annie.util.a.a(r10, r16, String.valueOf(r17), r22, r24, r23, r12.a());     // Catch: IllegalArgumentException -> L20
        ReportALogResultModel r112 = new ReportALogResultModel();     // Catch: IllegalArgumentException -> L20
        r112.a(ReportALogResultModel.Code.Success);     // Catch: IllegalArgumentException -> L20
        r112.b("Report Success !");     // Catch: IllegalArgumentException -> L20
        finishWithResult(r112);     // Catch: IllegalArgumentException -> L20
        return;
    L20:
        e = move-exception;
        b8.a r113 = b8.a.a;
        b8.a.a(new b8.b("[ReportALogMethod]", LogLevel.ERROR, e, null, 8), true);
        ReportALogResultModel r114 = new ReportALogResultModel();
        r114.a(ReportALogResultModel.Code.Failed);
        r114.b("Level is illegal!");
        finishWithResult(r114);
        return;
    L17:
        r22 = "";
        r24 = r22;
        r23 = 0;
        goto L23
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
