package w20;

import com.bytedance.android.live.browser.jsbridge.base.ChangeGiftReceiverParamModelSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(ChangeGiftReceiverParamModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lw20/v7;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v7 extends vh7.j<v7> {

    @JsonAdapter(ChangeGiftReceiverParamModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "specified_user")
    String A8();

    @FieldName(name = "is_all_mic")
    Boolean F0();

    @FieldName(name = "user_id")
    String R0();

    @FieldName(name = "is_multi_user")
    Boolean W6();

    @FieldName(name = "user_ids")
    List<String> j5();
}
