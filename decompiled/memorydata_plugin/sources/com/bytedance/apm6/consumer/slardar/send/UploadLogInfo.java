package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderInfo;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.header.HeaderUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.tob.IReportDataService;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.Tools;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
interface UploadLogInfo {

    public static class ExceptionLogInfo implements UploadLogInfo {
        public ExceptionLogInfo() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return CommonConsts.LOG_REPORT_TYPE_EXCEPTION;
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getExceptionUrlList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> r7) {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L15
            JSONArray r1 = new JSONArray();     // Catch: Exception -> L15
            Iterator<Long> r2 = r7.keySet().iterator();     // Catch: Exception -> L15
        L5:
            if (r2.hasNext() == false) goto L13;
            JSONArray r3 = (JSONArray) ZeusTransformUtils.preCheckCast(r7.get((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")), JSONArray.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
            if (r3 == null) goto L5;
            int r4 = 0;
        L11:
            if (r4 >= r3.length()) goto L5;
            r1.put(r3.get(r4));     // Catch: Exception -> L15
            r4 = r4 + 1;     // Catch: Exception -> L15
            goto L11
        L13:
            r0.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));     // Catch: Exception -> L15
            r0.put("data", r1);     // Catch: Exception -> L15
            return Tools.safeGetBytes(r0.toString());
        L15:
            return null;
        }
    }

    public static class MonitorLogInfo implements UploadLogInfo {
        public MonitorLogInfo() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "log";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getReportList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> r8) {
            JSONArray r7 = new JSONArray();     // Catch: Exception -> L27
            Iterator<Long> r0 = r8.keySet().iterator();     // Catch: Exception -> L27
        L5:
            if (r0.hasNext() == false) goto L12;
            Long r1 = (Long) ZeusTransformUtils.preCheckCast(r0.next(), Long.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
            HeaderInfo r4 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(r1));     // Catch: Exception -> L27
            if (r4 == null) goto L9;
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L27
            r5.put("data", r8.get(r1));     // Catch: Exception -> L27
            r5.put("header", HeaderUtils.serialize(r4));     // Catch: Exception -> L27
            r7.put(r5);     // Catch: Exception -> L27
            goto L5
        L9:
            if (ApmContext.isDebugMode() == false) goto L5;
            Logger.w(Constants.TAG, "HeaderInfo null for key " + r1);     // Catch: Exception -> L27
            goto L5
        L12:
            JSONArray r9 = DropDataMonitor.getInstance().getItems();     // Catch: Exception -> L27
            if (r9 != null) goto L15;
        L19:
            JSONObject r10 = new JSONObject();     // Catch: Exception -> L27
            r10.put(Constants.KEY_LIST, r7);     // Catch: Exception -> L27
            if (ApmContext.isDebugMode() == false) goto L22;
            Logger.d(Constants.TAG, "request:" + r10);     // Catch: Exception -> L27
        L22:
            IReportDataService r11 = (IReportDataService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IReportDataService.class), IReportDataService.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
            if (r11 == null) goto L25;
            r10 = r11.changeReportData(r10);     // Catch: Exception -> L27
        L25:
            return Tools.safeGetBytes(r10.toString());
        L15:
            if (r9.length() <= 0) goto L19;
            HeaderInfo r2 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()));     // Catch: Exception -> L27
            if (r2 == null) goto L19;
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L27
            r3.put("data", r9);     // Catch: Exception -> L27
            r3.put("header", HeaderUtils.serialize(r2));     // Catch: Exception -> L27
            r7.put(r3);     // Catch: Exception -> L27
        L27:
            return null;
        }
    }

    public static class TraceLogInfo implements UploadLogInfo {
        public TraceLogInfo() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public String getName() {
            return "trace";
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public List<String> getUrls() {
            return LogReportController.getInstance().getTraceUrlList();
        }

        @Override // com.bytedance.apm6.consumer.slardar.send.UploadLogInfo
        public byte[] serialize(HashMap<Long, JSONArray> r11) {
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L30
            JSONArray r1 = new JSONArray();     // Catch: Exception -> L30
            Iterator<Long> r2 = r11.keySet().iterator();     // Catch: Exception -> L30
        L5:
            if (r2.hasNext() == false) goto L26;
            JSONArray r3 = (JSONArray) ZeusTransformUtils.preCheckCast(r11.get((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")), JSONArray.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
            if (r3 == null) goto L5;
            int r4 = 0;
        L11:
            if (r4 >= r3.length()) goto L5;
            List<Object> r5 = BatchLogWrapUtils.stripData(r3.getJSONObject(r4));     // Catch: Exception -> L22
            if (ListUtils.isEmpty(r5) == true) goto L24;
            Iterator<Object> r6 = r5.iterator();     // Catch: Exception -> L22
        L17:
            if (r6.hasNext() == false) goto L24;
            Object r7 = r6.next();     // Catch: Exception -> L22
            r1.put(r7);     // Catch: Exception -> L22
            if (ApmContext.isDebugMode() == false) goto L17;
            Logger.d(Constants.TAG, ParameterizedMessage.ERROR_MSG_SEPARATOR + r7);     // Catch: Exception -> L22
        L24:
            r4 = r4 + 1;     // Catch: Exception -> L30
        L22:
            e = move-exception;
            Logger.e(Constants.TAG, "serialize", e);     // Catch: Exception -> L30
            goto L24
        L26:
            if (ApmContext.isDebugMode() == false) goto L28;
            Logger.d(Constants.TAG, "jsonArray:" + r1);     // Catch: Exception -> L30
        L28:
            r0.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));     // Catch: Exception -> L30
            r0.put("data", r1);     // Catch: Exception -> L30
            return Tools.safeGetBytes(r0.toString());
        L30:
            return null;
        }
    }

    String getName();

    List<String> getUrls();

    byte[] serialize(HashMap<Long, JSONArray> r1);
}
