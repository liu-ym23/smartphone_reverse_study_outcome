package w20;

import com.bytedance.android.live.browser.jsbridge.base.LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lw20/cb;", "Lvh7/j;", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "getType$annotations", "()V", "type", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface cb extends vh7.j<cb> {

    @JsonAdapter(LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "touchable")
    Boolean I5();

    @FieldName(name = "draggable")
    Boolean U2();

    @FieldName(name = "action")
    Integer getAction();

    @FieldName(name = "channel")
    String getChannel();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "type")
    Integer getType();

    @FieldName(name = "superViewIdentifier")
    String i2();
}
