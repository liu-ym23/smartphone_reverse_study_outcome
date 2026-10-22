package com.larus.audio.autotest.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/autotest/api/AudioAutotestTarget;", "", "<init>", "(Ljava/lang/String;I)V", "Android", "Ohos", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioAutotestTarget extends Enum<AudioAutotestTarget> {
    public static final AudioAutotestTarget Android = null;
    public static final AudioAutotestTarget Ohos = null;
    public static final /* synthetic */ AudioAutotestTarget[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AudioAutotestTarget> getEntries() {
        return b;
    }

    static {
        AudioAutotestTarget r0 = new AudioAutotestTarget("Android", 0);
        Android = r0;
        AudioAutotestTarget r1 = new AudioAutotestTarget("Ohos", 1);
        Ohos = r1;
        AudioAutotestTarget[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AudioAutotestTarget[] values() {
        return (AudioAutotestTarget[]) a.clone();
    }

    public static AudioAutotestTarget valueOf(String r1) {
        return (AudioAutotestTarget) a.a(AudioAutotestTarget.class, r1);
    }

    public AudioAutotestTarget(String r1, int r2) {
        super(r1, r2);
    }
}
