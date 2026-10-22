package com.bytedance.bdinstall.dtrait.network;

import android.content.Context;
import android.net.Uri;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.utils.RequestIdGenerator;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.security.Sword.Sword;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DTraitNetworkService {
    private static final String HOST = "https://log.snssdk.com";
    private static final String PATH_DEVICE_DTRAIT = "/service/2/dtrait/";
    private static final String PATH_DEVICE_STATS_COLLECT = "/service/3/device_sdk/stats_collect/";

    public DTraitNetworkService() {
    }

    public static void doBindDTraitRequest(JSONObject r6, boolean r7) {
        boolean r2 = false;
        byte[] r3 = new byte[0];
        r3 = r6.toString().getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Exception -> L5
    L19:
        String r8 = Uri.parse("https://log.snssdk.com/service/2/dtrait/").buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();     // Catch: Exception -> L14
        if (DTraitConfig.getDtraitInterface() == null) goto L10;
        r2 = DTraitConfig.getDtraitInterface().encryptAndCompress();     // Catch: Exception -> L14
    L10:
        JSONObject r9 = DTraitNetWorkApi.doRequest(r8, new String(r3, RpcUtils.CHARSET_UTF8), r2, r7);     // Catch: Exception -> L14
        if (DTLog.debug() == false) goto L21;
        DTLog.i("[dt] DTraitNetworkHelper# bindDTrait request success " + r9, null);     // Catch: Exception -> L14
        return;
    L21:
        return;
    L14:
        e = move-exception;
        DTLog.e("[dt] DTraitNetworkHelper# bindDTrait network error " + e.getMessage());
        return;
    L5:
        e = move-exception;
        DTLog.e("[dt] DTraitNetworkHelper# sword encrypt error, " + e.getMessage());
        goto L19
    }

    public static JSONObject doStatsCollectRequest(Context r5, JSONObject r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        byte[] r2 = new byte[0];
        r2 = r6.toString().getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Exception -> L5
        byte[] r9 = Sword.clientPackedBase64(r2, r2.length).getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Exception -> L5
    L7:
        JSONObject r3 = null;
        String r10 = Uri.parse("https://log.snssdk.com/service/3/device_sdk/stats_collect/").buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();     // Catch: Exception -> L15
        if (DTraitConfig.getDtraitInterface() == null) goto L11;
        r1 = DTraitConfig.getDtraitInterface().encryptAndCompress();     // Catch: Exception -> L15
    L11:
        r3 = DTraitNetWorkApi.doRequest(r10, new String(r9, RpcUtils.CHARSET_UTF8), r1, r7);     // Catch: Exception -> L15
        if (DTLog.debug() == false) goto L17;
        DTLog.d("[dt] DTraitNetworkHelper# statsCollect request success " + r3);     // Catch: Exception -> L15
    L17:
        if (r3 == null) goto L19;
        return r3;
    L19:
        return new JSONObject();
    L15:
        e = move-exception;
        DTLog.e("[dt] DTraitNetworkHelper# statsCollect network error " + e.getMessage());
    L5:
        e = move-exception;
        DTLog.e("[dt] DTraitNetworkHelper# sword encrypt error, " + e.getMessage());
        r9 = r2;
        goto L7
    }
}
