package com.larus.trace.tracespan.span;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface b {
    String a();

    void b(JSONObject r1);

    void c(JSONObject r1);

    void cancel(boolean r1);

    b d(String r1, Object r2);

    void e(b r1);

    String f();

    void g(Integer r1, String r2);

    b getParent();

    String getTag();

    String getTraceId();

    boolean hasEnd();

    void setTag(String r1);
}
