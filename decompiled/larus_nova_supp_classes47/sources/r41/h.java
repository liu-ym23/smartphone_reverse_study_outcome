package r41;

import com.bytedance.android.live.revlink.impl.settings.config.PKPreciseFindPeopleConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(PKPreciseFindPeopleConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr41/h;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.j<h> {

    @JsonAdapter(PKPreciseFindPeopleConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "find_people_invite_panel_schema")
    String S6();

    @FieldName(name = "find_people_setting_panel_schema")
    String V4();

    @FieldName(name = "support_audio")
    boolean Y3();

    @FieldName(name = "find_people_invite_panel_url")
    String Y8();

    @FieldName(name = "find_people_setting_panel_url")
    String f6();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "update_pk_top_tab_padding")
    boolean n9();

    @FieldName(name = "precise_match_invite_intercept_error_toast")
    boolean v5();
}
