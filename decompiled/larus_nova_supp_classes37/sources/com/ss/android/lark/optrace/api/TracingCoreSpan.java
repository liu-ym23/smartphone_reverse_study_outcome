package com.ss.android.lark.optrace.api;

import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import hyb.a;
import hyb.b;
import java.io.Serializable;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface TracingCoreSpan extends Serializable, ITracing, a {
    /* synthetic */ void addExtension(TracingExtensionEnum r1, TracingExtension r2);

    /* synthetic */ long clientDuration(String r1);

    /* synthetic */ void clientDurationEndAll();

    /* synthetic */ long clientDurationTagEnd(String r1);

    /* synthetic */ void clientDurationTagStart(String r1);

    /* synthetic */ long createTime();

    /* synthetic */ void d(String r1, Object... r2);

    /* synthetic */ void e(String r1, Object... r2);

    @Deprecated(message = "use subTrace")
    TracingCoreSpan generateSpan();

    /* synthetic */ String getRequestId();

    /* synthetic */ String getTracingID();

    /* synthetic */ void i(String r1, Object... r2);

    /* synthetic */ <T> void linkTracing(ITracing r1, T r2, b<T> r3);

    /* synthetic */ void setRequestId(String r1);

    TracingCoreSpan subTrace();

    /* synthetic */ void w(String r1, Object... r2);
}
