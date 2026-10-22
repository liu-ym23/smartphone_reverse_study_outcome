package com.lynx.debugrouter;

import com.lynx.debugrouter.base.MessageTransceiver;
import com.lynx.debugrouter.base.NativeMessageTransceiver;
import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.log.LLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DebugRouterReport {
    private static final String TAG = "DebugRouterReport";

    public DebugRouterReport() {
    }

    private static String getTransceiverType(MessageTransceiver r1) {
        if ((r1 instanceof WebSocketClient) == false) goto L7;
        return "OKHttp";
    L7:
        if ((r1 instanceof NativeMessageTransceiver) == false) goto L10;
        return "NativeMessageTransceiver";
    L10:
        return "null";
    }

    public static void reportHandleSchema(String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("schema", r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("handleSchema", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportHandleSchema:" + e.toString());
        goto L7
    }

    public static void reportInitServerOK(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put("port", r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("USBServerInitOK", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportInitServerOK:" + e.toString());
        goto L7
    }

    public static void reportNewSocketClient(String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("client", r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("new_socket_client", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportNewSocketClient:" + e.toString());
        goto L7
    }

    public static void reportNewUSBClient(String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("client", r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("new_usb_client", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportNewUSBClient:" + e.toString());
        goto L7
    }

    public static void reportOnOpen(MessageTransceiver r3) {
        JSONObject r0 = new JSONObject();
        r0.put("connect_type", getTransceiverType(r3));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("onOpen", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnOpen:" + e.toString());
        goto L7
    }

    public static void reportOnOpenWarning(MessageTransceiver r3) {
        JSONObject r0 = new JSONObject();
        r0.put("connect_type", getTransceiverType(r3));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("similar_trans_open", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnOpenWarning:" + e.toString());
        goto L7
    }

    public static void reportSendMessage(String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("msg", r4.substring(0, Math.min(512, r4.length())));     // Catch: JSONException -> L6
        DebugRouterReportServiceUtil.report("SendMessage", r0, null, null);
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void reportDurTimeError(MessageTransceiver r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("Transceiver", getTransceiverType(r2));     // Catch: JSONException -> L5
        r0.put("reason", r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("TransceiverTimeError", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportDurTimeError:" + e.toString());
        goto L7
    }

    public static void reportInValidClient(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("address", r2);     // Catch: JSONException -> L5
        r0.put("header", r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("invalid_client", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportInValidClient:" + e.toString());
        goto L7
    }

    public static void reportOnError(MessageTransceiver r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("connect_type", getTransceiverType(r2));     // Catch: JSONException -> L5
        r0.put("error_msg", r3);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("onError", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnError:" + e.toString());
        goto L7
    }

    public static void reportReceiveMessage(String r4, MessageTransceiver r5) {
        JSONObject r0 = new JSONObject();
        r0.put("msg", r4.substring(0, Math.min(512, r4.length())));     // Catch: JSONException -> L5
        r0.put("connect_type", getTransceiverType(r5));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("receive_message", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportReceiveMessage:" + e.toString());
        goto L7
    }

    public static void reportConnect(String r2, String r3, boolean r4) {
        JSONObject r0 = new JSONObject();
        r0.put(LynxEventReporter.PROP_NAME_URL, r2);     // Catch: JSONException -> L5
        r0.put("room", r3);     // Catch: JSONException -> L5
    L8:
        if (r4 == false) goto L10;
        DebugRouterReportServiceUtil.report("reconnect", r0, null, null);
        return;
    L10:
        DebugRouterReportServiceUtil.report("connect", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportConnect:" + e.toString());
        goto L8
    }

    public static void reportDurTime(MessageTransceiver r3, long r4, String r6) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r0.put("duration", r4);     // Catch: JSONException -> L5
        r1.put("Transceiver", getTransceiverType(r3));     // Catch: JSONException -> L5
        r1.put("reason", r6);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("TransceiverTime", r1, r0, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportDurTime:" + e.toString());
        goto L7
    }

    public static void reportOnClose(MessageTransceiver r2, int r3, String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("connect_type", getTransceiverType(r2));     // Catch: JSONException -> L5
        r0.put(LynxResourceModule.CODE_KEY, String.valueOf(r3));     // Catch: JSONException -> L5
        r0.put("message", r4);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("onClose", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnClose:" + e.toString());
        goto L7
    }

    public static void reportOnCloseWarning(MessageTransceiver r1, MessageTransceiver r2, ConnectionState r3) {
        JSONObject r0 = new JSONObject();
        if (r1 == r2) goto L6;
        String r4 = "different transceiver when close";
    L15:
        r0.put("connect_type", getTransceiverType(r2));     // Catch: JSONException -> L11
        r0.put("warning_msg", r4);     // Catch: JSONException -> L11
    L13:
        DebugRouterReportServiceUtil.report("OnCloseWarning", r0, null, null);
        return;
    L11:
        e = move-exception;
        LLog.e(TAG, "reportOnCloseWarning:" + e.toString());
        goto L13
    L6:
        if (r3 != ConnectionState.DISCONNECTED) goto L8;
        r4 = "ConnectionState is DISCONNECTED when close";
        goto L15
    L8:
        r4 = NameKeys.UnloadStrategy_No_Strategy;
        goto L15
    }

    public static void reportOnMessageWarning(MessageTransceiver r4, MessageTransceiver r5, String r6) {
        JSONObject r0 = new JSONObject();
        r0.put("msg", r6.substring(0, Math.min(512, r6.length())));     // Catch: JSONException -> L5
        r0.put("CurrentTransceiver", getTransceiverType(r5));     // Catch: JSONException -> L5
        r0.put("Transceiver", getTransceiverType(r4));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("OnMessageWarning", r0, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnMessageWarning:" + e.toString());
        goto L7
    }
}
