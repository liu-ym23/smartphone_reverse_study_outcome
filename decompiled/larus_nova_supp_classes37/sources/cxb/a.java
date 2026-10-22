package cxb;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    String getBaseTraceId();

    String getBizType();

    Map<String, Object> getCommonParams();

    Map<String, Object> getReasonParams();

    long getStartTime();
}
