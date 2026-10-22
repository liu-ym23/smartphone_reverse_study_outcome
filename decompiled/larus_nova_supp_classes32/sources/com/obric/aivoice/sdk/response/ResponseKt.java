package com.obric.aivoice.sdk.response;

import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aT\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000126\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004\u001aV\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000128\u0010\u0003\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u0001H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\u0004¨\u0006\u0010"}, d2 = {"fail", "Lcom/obric/aivoice/sdk/response/Response;", "T", "block", "Lkotlin/Function2;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "errCode", NameKeys.UnloadStrategy_No_Strategy, "errInfo", NameKeys.UnloadStrategy_No_Strategy, "ok", NameKeys.UnloadStrategy_No_Strategy, "isFinish", LynxResourceModule.DATA_KEY, "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ResponseKt {
    public static final <T> Response<T> fail(Response<T> r2, Function2<? super Integer, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "block");
        if (r2.getErrorCode() != 0) goto L5;
    L10:
        return r2;
    L5:
        if (r2.getErrorCode() == 1) goto L10;
        Integer r0 = Integer.valueOf(r2.getErrorCode());
        String r1 = r2.getErrorInfo();
        if (r1 != null) goto L9;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r3.invoke(r0, r1);
        goto L10
    }

    public static final <T> Response<T> ok(Response<T> r2, Function2<? super Boolean, ? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "block");
        if (r2.getErrorCode() != 0) goto L5;
    L6:
        r3.invoke(Boolean.valueOf(r2.isFinish()), r2.getData());
    L7:
        return r2;
    L5:
        if (r2.getErrorCode() != 1) goto L7;
        goto L6
    }
}
