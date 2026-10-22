package xa1;

import com.bytedance.android.live.settings.LynxEnterEffectOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(LynxEnterEffectOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lxa1/d;", "Lvh7/j;", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends j<d> {

    @JsonAdapter(LynxEnterEffectOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "dress_config_idl_version")
    int I8();

    @FieldName(name = "pre_parse_dress_id")
    List<String> X6();

    @FieldName(name = "dress_config_idl")
    String j2();

    @FieldName(name = "definition_name")
    String u();
}
