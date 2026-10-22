package r11;

import com.bytedance.android.live.revlink.impl.config.PkPanelUpdateStrategySerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(PkPanelUpdateStrategySerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lr11/r;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface r extends vh7.j<r> {

    @JsonAdapter(PkPanelUpdateStrategySerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "panel_count")
    int C();

    @FieldName(name = "valid_other_interval")
    long C2();

    @FieldName(name = "async_delay_time")
    long H8();

    @FieldName(name = "enable_req_opt")
    boolean R5();

    @FieldName(name = "list_update_timeout")
    long S5();

    @FieldName(name = "valid_rec_interval")
    long V7();

    @FieldName(name = "count")
    int getCount();

    @FieldName(name = "delay")
    long getDelay();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "interval")
    long getInterval();

    @FieldName(name = "open_cnt")
    int getOpenPanelCount();

    @FieldName(name = "open_cnt_overtime")
    int h5();

    @FieldName(name = "valid_act_interval")
    long m3();

    @FieldName(name = "panel_interval")
    long q();

    @FieldName(name = "async_item_count")
    int s1();

    @FieldName(name = "valid_rec_count")
    int t();

    @FieldName(name = "list_opt")
    int y2();
}
