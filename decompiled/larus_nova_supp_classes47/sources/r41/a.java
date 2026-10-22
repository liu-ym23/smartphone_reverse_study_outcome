package r41;

import com.bytedance.android.live.revlink.impl.settings.config.AiAssistantCellularConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(AiAssistantCellularConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr41/a;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.j<a> {

    /* JADX INFO: renamed from: r41.a$a, reason: collision with other inner class name */
    @JsonAdapter(AiAssistantCellularConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0308a {
    }

    @FieldName(name = "ai_assistant_audio")
    String c2();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "tx_quality_count")
    int m2();
}
