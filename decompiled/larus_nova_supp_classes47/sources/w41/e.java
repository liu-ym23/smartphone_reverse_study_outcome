package w41;

import com.bytedance.android.live.revlink.impl.settings.live.model.RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lw41/e;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends j<e> {

    @JsonAdapter(RevlinkAudioAbnormalCheckOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "diagnosis_loop_callback_time")
    int E5();

    @FieldName(name = "active_detect_abnormal_reason_enable")
    boolean I();

    @FieldName(name = "abnormal_audio_review_threshold")
    int L();

    @FieldName(name = "diagnosis_duration")
    int N6();

    @FieldName(name = "abnormal_audio_review_check_window")
    int O();

    @FieldName(name = "exclude_str_list")
    List<String> P();

    @FieldName(name = "no_volume_str_list")
    List<String> R();

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "volume_low_str_list")
    List<String> r();
}
