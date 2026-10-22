package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Response;
import io.reactivex.j;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final List<Integer> a = null;

    public a() {
    }

    static {
        SetsKt.hashSetOf(new Integer[]{Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())});
        a = CollectionsKt.listOf(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        new HashSet();
    }

    public static final void a(int r2, j r3, bka.b r4, int r5, String r6) {
        gka.b.a("CmdManager", "handleBinderCallFail, errorCode: " + r5 + ", errorMsg: " + r6);
        Response r7 = new Response.Builder().statusCode(Integer.valueOf(r5)).errorMsg(r6).build();
        int r8 = fka.a.a;
        bka.a r9 = bka.a.a;
        fka.a.a(r2, r7);
        if (r3 == null) goto L5;
        r3.onSuccess(new Pair(Integer.valueOf(r2), r7));
    L5:
        if (r4 == null) goto L8;
        r4.a(r7);
        return;
    }
}
