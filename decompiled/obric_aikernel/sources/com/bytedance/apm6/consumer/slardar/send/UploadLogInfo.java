package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.header.HeaderInfo;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.header.HeaderUtils;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.tob.IReportDataService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.Tools;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
        public byte[] serialize(HashMap<Long, JSONArray> r10) {
            JSONObject r11 = new JSONObject();     // Catch: Exception -> L14
            JSONArray r12 = new JSONArray();     // Catch: Exception -> L14
            Iterator<Long> r13 = r10.keySet().iterator();     // Catch: Exception -> L14
        L4:
            if (r13.hasNext() == false) goto L12;
            JSONArray r14 = r10.get(r13.next());     // Catch: Exception -> L14
            if (r14 == null) goto L4;
            int r15 = 0;
        L10:
            if (r15 >= r14.length()) goto L4;
            r12.put(r14.get(r15));     // Catch: Exception -> L14
            r15 = r15 + 1;     // Catch: Exception -> L14
            goto L10
        L12:
            r11.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));     // Catch: Exception -> L14
            r11.put("data", r12);     // Catch: Exception -> L14
            return Tools.safeGetBytes(r11.toString());
        L14:
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
        public byte[] serialize(HashMap<Long, JSONArray> r10) {
            JSONArray r11 = new JSONArray();     // Catch: Exception -> L27
            Iterator<Long> r12 = r10.keySet().iterator();     // Catch: Exception -> L27
        L5:
            if (r12.hasNext() == false) goto L12;
            Long r13 = r12.next();     // Catch: Exception -> L27
            HeaderInfo r14 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(r13));     // Catch: Exception -> L27
            if (r14 == null) goto L9;
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L27
            r15.put("data", r10.get(r13));     // Catch: Exception -> L27
            r15.put("header", HeaderUtils.serialize(r14));     // Catch: Exception -> L27
            r11.put(r15);     // Catch: Exception -> L27
            goto L5
        L9:
            if (ApmBaseContext.isDebugMode() == false) goto L5;
            Logger.w(Constants.TAG, "HeaderInfo null for key " + r13);     // Catch: Exception -> L27
            goto L5
        L12:
            JSONArray r16 = DropDataMonitor.getInstance().getItems();     // Catch: Exception -> L27
            if (r16 != null) goto L15;
        L19:
            JSONObject r17 = new JSONObject();     // Catch: Exception -> L27
            r17.put(Constants.KEY_LIST, r11);     // Catch: Exception -> L27
            if (ApmBaseContext.isDebugMode() == false) goto L22;
            Logger.d(Constants.TAG, "request:" + r17);     // Catch: Exception -> L27
        L22:
            IReportDataService r18 = (IReportDataService) ServiceManager.getService(IReportDataService.class);     // Catch: Exception -> L27
            if (r18 == null) goto L25;
            r17 = r18.changeReportData(r17);     // Catch: Exception -> L27
        L25:
            return Tools.safeGetBytes(r17.toString());
        L15:
            if (r16.length() <= 0) goto L19;
            HeaderInfo r19 = HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()));     // Catch: Exception -> L27
            if (r19 == null) goto L19;
            JSONObject r20 = new JSONObject();     // Catch: Exception -> L27
            r20.put("data", r16);     // Catch: Exception -> L27
            r20.put("header", HeaderUtils.serialize(r19));     // Catch: Exception -> L27
            r11.put(r20);     // Catch: Exception -> L27
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
        public byte[] serialize(HashMap<Long, JSONArray> r10) {
            JSONObject r11 = new JSONObject();     // Catch: Exception -> L29
            JSONArray r12 = new JSONArray();     // Catch: Exception -> L29
            Iterator<Long> r13 = r10.keySet().iterator();     // Catch: Exception -> L29
        L4:
            if (r13.hasNext() == false) goto L25;
            JSONArray r14 = r10.get(r13.next());     // Catch: Exception -> L29
            if (r14 == null) goto L4;
            int r15 = 0;
        L10:
            if (r15 >= r14.length()) goto L4;
            List<Object> r16 = BatchLogWrapUtils.stripData(r14.getJSONObject(r15));     // Catch: Exception -> L21
            if (ListUtils.isEmpty(r16) == true) goto L23;
            Iterator<Object> r17 = r16.iterator();     // Catch: Exception -> L21
        L16:
            if (r17.hasNext() == false) goto L23;
            Object r18 = r17.next();     // Catch: Exception -> L21
            r12.put(r18);     // Catch: Exception -> L21
            if (ApmBaseContext.isDebugMode() == false) goto L16;
            Logger.d(Constants.TAG, ":" + r18);     // Catch: Exception -> L21
        L23:
            r15 = r15 + 1;     // Catch: Exception -> L29
        L21:
            e = move-exception;
            Logger.e(Constants.TAG, "serialize", e);     // Catch: Exception -> L29
            goto L23
        L25:
            if (ApmBaseContext.isDebugMode() == false) goto L27;
            Logger.d(Constants.TAG, "jsonArray:" + r12);     // Catch: Exception -> L29
        L27:
            r11.put("header", HeaderUtils.serialize(HeaderManager.getInstance().getHeaderInfo(String.valueOf(HeaderUtils.getUniqueHeaderId()))));     // Catch: Exception -> L29
            r11.put("data", r12);     // Catch: Exception -> L29
            return Tools.safeGetBytes(r11.toString());
        L29:
            return null;
        }
    }

    String getName();

    List<String> getUrls();

    byte[] serialize(HashMap<Long, JSONArray> r10);
}
