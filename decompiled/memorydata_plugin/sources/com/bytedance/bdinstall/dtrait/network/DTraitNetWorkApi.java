package com.bytedance.bdinstall.dtrait.network;

import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.model.DTraitResponse;
import com.bytedance.rpc.internal.RpcUtils;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitNetWorkApi {
    public DTraitNetWorkApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> buildHeader(final boolean r3) {
        HashMap<String, String> r0 = new HashMap();
        Pair<String, String> r4 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r3));     // Catch: Throwable -> L7
        if (r4 == null) goto L6;
        r0.put(r4.first, r4.second);     // Catch: Throwable -> L7
    L6:
        return r0;
    }

    private static HashMap<String, String> createHeader(boolean r1, boolean r2) {
        HashMap<String, String> r3 = buildHeader(r2);
        if (r1 == false) goto L5;
        String r4 = "application/octet-stream;tt-data=a";
    L6:
        r3.put(NetConst.KEY_CONTENT_TYPE, r4);
        return r3;
    L5:
        r4 = "application/json; charset=utf-8";
        goto L6
    }

    public static JSONObject doRequest(String r2, String r3, boolean r4, boolean r5) {
        HashMap<String, String> r6 = createHeader(r4, r5);
        DTraitResponse r0 = null;
        byte[] r7 = transformStrToByte(r3, r4);     // Catch: Exception -> L11
        if (r7 == null) goto L8;
        if (r4 == false) goto L8;
        r2 = r2 + "&tt_data=a";     // Catch: Exception -> L11
    L8:
        if (DTraitConfig.getDtraitNetworkConfig() == null) goto L13;
        r0 = DTraitConfig.getDtraitNetworkConfig().post(r2, r7, r6);     // Catch: Exception -> L11
        DTLog.d("ticket network client is ready. response is " + r0);     // Catch: Exception -> L11
    L13:
        if (r0 != null) goto L20;
        r0 = new DTraitResponse(r2, 200, new ArrayList(), "{}");
    L20:
        return new JSONObject(r0.getBody());
    L17:
        e = move-exception;
        DTLog.e("Register#doRegister new json error: ", e);
        return new JSONObject();
    L11:
        e = move-exception;
        DTLog.e("Register#doRegister http error = ", e);
        goto L13
    }

    private static byte[] transformStrToByte(String r5, boolean r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r3 = null;
        if (r6 == false) goto L11;
        GZIPOutputStream r4 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r4.write(r5.getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L7
        r3 = r4;
    L12:
        if (r3 == null) goto L20;
        r3.close();     // Catch: IOException -> L15
    L39:
    L20:
        byte[] r7 = r0.toByteArray();
        if (r6 == true) goto L23;
        return r7;
    L23:
        if (DTraitConfig.getDtraitInterface() != null) goto L25;
        return r7;
    L25:
        return DTraitConfig.getDtraitNetworkConfig().encrypt(r7, r7.length);
    L7:
        th = th;
        r3 = r4;
    L33:
        DTLog.e("Register#doRegister http error = ", th);     // Catch: Throwable -> L26
        if (r3 == null) goto L20;
        r3.close();     // Catch: IOException -> L15
    L26:
        th = move-exception;
        if (r3 != null) goto L35;
    L32:
        throw th;
    L35:
        r3.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        DTLog.e("Register#doRegister http error = ", e);
        goto L32
    L11:
        r0.write(r5.getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L9
    L15:
        e = move-exception;
        DTLog.e("Register#doRegister http error = ", e);
    L9:
        th = th;
        goto L33
    }
}
