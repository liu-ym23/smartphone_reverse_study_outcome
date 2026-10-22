package com.larus.dora.obric.device_management.setting.g.video_record;

import com.larus.dora.impl.device.settings.media.a0;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGVideoRecordSettingsFragment a;

    public m(DoraObricGVideoRecordSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        a0 r3 = (a0) r1;
        DoraObricGVideoRecordSettingsFragment r4 = this.a;
        List<DoraObricGVideoRecordSettingsFragment.VideoRecordSettingItem> r5 = DoraObricGVideoRecordSettingsFragment.k;
        r4.Z90();
        return Unit.INSTANCE;
    }
}
