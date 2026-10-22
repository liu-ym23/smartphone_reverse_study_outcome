package com.ss.android.lark.optrace.api;

import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface ITracing extends Serializable {
    void addExtension(TracingExtensionEnum r1, TracingExtension r2);

    long clientDuration(String r1);

    void clientDurationEndAll();

    long clientDurationTagEnd(String r1);

    void clientDurationTagStart(String r1);

    long createTime();

    String getRequestId();

    String getTracingID();

    void setRequestId(String r1);
}
