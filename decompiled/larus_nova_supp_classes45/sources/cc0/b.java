package cc0;

import com.bytedance.android.live.ktv.common.model.bean.h;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {
    void onLocalTuningEffectsFailed();

    void onLocalTuningEffectsSuccess(List<h> r1);

    void onSyncTuningEffectsFailed();

    void onSyncTuningEffectsSuccess(List<h> r1);
}
