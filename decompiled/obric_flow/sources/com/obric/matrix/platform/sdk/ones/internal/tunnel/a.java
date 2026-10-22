package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Response;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mt.i;
import org.json.JSONObject;
import td.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f11900a = null;

    static {
        SetsKt.hashSetOf(new Integer[]{Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())});
        f11900a = CollectionsKt.listOf(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        new HashSet();
    }

    public static final void a(int r5, i r10, int r11, String r12) {
        com.lynx.jsbridge.a.q("CmdManager", "handleBinderCallFail, errorCode: " + r11 + ", errorMsg: " + r12);
        Response r13 = new Response.Builder().statusCode(Integer.valueOf(r11)).errorMsg(r12).build();
        Intrinsics.checkNotNullParameter(r13, "response");
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L5
        r14.put(NotificationCompat.CATEGORY_STATUS, "status_receiver_result");     // Catch: Exception -> L5
        r14.put("cmd", r5);     // Catch: Exception -> L5
        r14.put("way", 1);     // Catch: Exception -> L5
        r14.put(Constant.PACKAGE_NAME, "");     // Catch: Exception -> L5
        r14.put(WsConstants.ERROR_CODE, r13.statusCode.intValue());     // Catch: Exception -> L5
        r14.put("error_message", r13.errorMsg);     // Catch: Exception -> L5
        d.e(r14, new JSONObject(), new JSONObject());     // Catch: Exception -> L5
    L7:
        if (r10 == null) goto L12;
        r10.onSuccess(new Pair(Integer.valueOf(r5), r13));
        return;
    L12:
        return;
    L5:
        e = move-exception;
        com.lynx.jsbridge.a.q("ReportMonitorHelper", "report exception " + Log.getStackTraceString(e));
        goto L7
    }
}
