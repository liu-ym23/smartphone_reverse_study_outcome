package com.larus.audio.record.factory;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.record.AudioRecordType;
import java.util.Map;
import kotlin.Metadata;
import r58.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/audio/record/factory/IAudioRecorderFactory;", "", "create", "Lcom/larus/audio/audiov3/audio/record/IAudioRecorder;", "type", "Lcom/larus/audio/record/AudioRecordType;", "paramMap", "", "", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface IAudioRecorderFactory {
    c a(AudioRecordType r1, Map<String, ? extends Object> r2);
}
