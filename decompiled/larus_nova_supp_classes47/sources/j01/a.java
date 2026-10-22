package j01;

import com.bytedance.android.live.revenue.platform.trace.api.IDynamicHostTraceService_TraceMetaSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.TraceService")
public interface a extends uh7.a, f80.a {

    /* JADX INFO: renamed from: j01.a$a, reason: collision with other inner class name */
    @JsonAdapter(IDynamicHostTraceService_TraceMetaSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00000\u0001j\b\u0012\u0004\u0012\u00020\u0000`\u0002¨\u0006\u0003"}, d2 = {"Lj01/a$a;", "Lvh7/j;", "Lcom/bytedance/live/kmp/core/AioModel;", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface InterfaceC0254a extends j<InterfaceC0254a> {

        /* JADX INFO: renamed from: j01.a$a$a, reason: collision with other inner class name */
        @JsonAdapter(IDynamicHostTraceService_TraceMetaSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C0255a {
        }

        @FieldName(name = "anchor_id")
        String getAnchorId();

        @FieldName(name = "business_type")
        String getBusinessType();

        @FieldName(name = "event_name")
        String getEventName();

        @FieldName(name = "index")
        Map<String, String> getIndex();

        @FieldName(name = "log_id")
        String getLogId();

        @FieldName(name = "product_id")
        String getProductId();

        @FieldName(name = "room_id")
        String getRoomId();

        @FieldName(name = "status_code")
        int getStatusCode();

        @FieldName(name = "step")
        String getStep();

        @FieldName(name = "trace_id")
        String getTraceId();

        @FieldName(name = "user_id")
        String getUserId();

        @FieldName(name = "status_message")
        String k6();
    }

    @BindsRpc(rpcName = "Monitor")
    void monitor(c r1);
}
