package wx9;

import com.larus.trace.tracespan.span.SpanWrapImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a extends io.opentelemetry.context.b {
    void b(JSONObject r1);

    SpanWrapImpl c();

    JSONObject getCommonParams();
}
