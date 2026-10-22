package com.obric.assistant.state.api.multitask.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK_TALK", "TOUCH_SPEAK", "CONTINUOUS_TALK", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceCaptureScene extends Enum<VoiceCaptureScene> {
    public static final VoiceCaptureScene CLICK_TALK = null;
    public static final VoiceCaptureScene CONTINUOUS_TALK = null;
    public static final VoiceCaptureScene TOUCH_SPEAK = null;
    public static final /* synthetic */ VoiceCaptureScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<VoiceCaptureScene> getEntries() {
        return b;
    }

    static {
        VoiceCaptureScene r0 = new VoiceCaptureScene("CLICK_TALK", 0);
        CLICK_TALK = r0;
        VoiceCaptureScene r1 = new VoiceCaptureScene("TOUCH_SPEAK", 1);
        TOUCH_SPEAK = r1;
        VoiceCaptureScene r3 = new VoiceCaptureScene("CONTINUOUS_TALK", 2);
        CONTINUOUS_TALK = r3;
        VoiceCaptureScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static VoiceCaptureScene[] values() {
        return (VoiceCaptureScene[]) a.clone();
    }

    public static VoiceCaptureScene valueOf(String r1) {
        return (VoiceCaptureScene) a.a(VoiceCaptureScene.class, r1);
    }

    public VoiceCaptureScene(String r1, int r2) {
        super(r1, r2);
    }
}
