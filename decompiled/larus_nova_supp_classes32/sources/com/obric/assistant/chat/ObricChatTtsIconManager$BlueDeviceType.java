package com.obric.assistant.chat;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/chat/ObricChatTtsIconManager$BlueDeviceType;", NameKeys.UnloadStrategy_No_Strategy, "index", NameKeys.UnloadStrategy_No_Strategy, "str", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getIndex", "()I", "getStr", "()Ljava/lang/String;", "FALLBACK_SPEAKER", "HEADSET", "DORA_LITE", "COMMON", "DORA_H_FREE_CLIP2", "DORA_H_FREE_BUDS_PRO5", "WATCH", "BAND", "CARKIT", "LOUDSPEAKER", "HEADPHONES", "GLASSES", "DORA_G", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricChatTtsIconManager$BlueDeviceType extends Enum<ObricChatTtsIconManager$BlueDeviceType> {
    public static final ObricChatTtsIconManager$BlueDeviceType BAND = null;
    public static final ObricChatTtsIconManager$BlueDeviceType CARKIT = null;
    public static final ObricChatTtsIconManager$BlueDeviceType COMMON = null;
    public static final ObricChatTtsIconManager$BlueDeviceType DORA_G = null;
    public static final ObricChatTtsIconManager$BlueDeviceType DORA_H_FREE_BUDS_PRO5 = null;
    public static final ObricChatTtsIconManager$BlueDeviceType DORA_H_FREE_CLIP2 = null;
    public static final ObricChatTtsIconManager$BlueDeviceType DORA_LITE = null;
    public static final ObricChatTtsIconManager$BlueDeviceType FALLBACK_SPEAKER = null;
    public static final ObricChatTtsIconManager$BlueDeviceType GLASSES = null;
    public static final ObricChatTtsIconManager$BlueDeviceType HEADPHONES = null;
    public static final ObricChatTtsIconManager$BlueDeviceType HEADSET = null;
    public static final ObricChatTtsIconManager$BlueDeviceType LOUDSPEAKER = null;
    public static final ObricChatTtsIconManager$BlueDeviceType WATCH = null;
    public static final /* synthetic */ ObricChatTtsIconManager$BlueDeviceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int index;
    private final String str;

    public static EnumEntries<ObricChatTtsIconManager$BlueDeviceType> getEntries() {
        return b;
    }

    static {
        ObricChatTtsIconManager$BlueDeviceType r0 = new ObricChatTtsIconManager$BlueDeviceType("FALLBACK_SPEAKER", 0, -1, "not any bluetooth device , usually unknown device or something! Fallback ");
        FALLBACK_SPEAKER = r0;
        ObricChatTtsIconManager$BlueDeviceType r1 = new ObricChatTtsIconManager$BlueDeviceType("HEADSET", 1, 0, "3rd party bluetooth headset hfp");
        HEADSET = r1;
        ObricChatTtsIconManager$BlueDeviceType r2 = new ObricChatTtsIconManager$BlueDeviceType("DORA_LITE", 2, 1, "dora / ola friend / ola lite");
        DORA_LITE = r2;
        ObricChatTtsIconManager$BlueDeviceType r3 = new ObricChatTtsIconManager$BlueDeviceType("COMMON", 3, 2, "3rd party bluetooth device");
        COMMON = r3;
        ObricChatTtsIconManager$BlueDeviceType r6 = new ObricChatTtsIconManager$BlueDeviceType("DORA_H_FREE_CLIP2", 4, 3, "dora-free_clip2");
        DORA_H_FREE_CLIP2 = r6;
        ObricChatTtsIconManager$BlueDeviceType r8 = new ObricChatTtsIconManager$BlueDeviceType("DORA_H_FREE_BUDS_PRO5", 5, 4, "dora-free_buds_pro5");
        DORA_H_FREE_BUDS_PRO5 = r8;
        ObricChatTtsIconManager$BlueDeviceType r10 = new ObricChatTtsIconManager$BlueDeviceType("WATCH", 6, 5, "watch device");
        WATCH = r10;
        ObricChatTtsIconManager$BlueDeviceType r12 = new ObricChatTtsIconManager$BlueDeviceType("BAND", 7, 6, "band device");
        BAND = r12;
        ObricChatTtsIconManager$BlueDeviceType r13 = new ObricChatTtsIconManager$BlueDeviceType("CARKIT", 8, 7, "carkit / device in the car");
        CARKIT = r13;
        ObricChatTtsIconManager$BlueDeviceType r14 = new ObricChatTtsIconManager$BlueDeviceType("LOUDSPEAKER", 9, 8, "soundbox or loud speaker");
        LOUDSPEAKER = r14;
        ObricChatTtsIconManager$BlueDeviceType r11 = new ObricChatTtsIconManager$BlueDeviceType("HEADPHONES", 10, 9, "headphone");
        HEADPHONES = r11;
        ObricChatTtsIconManager$BlueDeviceType r9 = new ObricChatTtsIconManager$BlueDeviceType("GLASSES", 11, 10, "glasses");
        GLASSES = r9;
        ObricChatTtsIconManager$BlueDeviceType r7 = new ObricChatTtsIconManager$BlueDeviceType("DORA_G", 12, 11, "dora g glasses");
        DORA_G = r7;
        ObricChatTtsIconManager$BlueDeviceType[] r5 = {r0, r1, r2, r3, r6, r8, r10, r12, r13, r14, r11, r9, r7};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ObricChatTtsIconManager$BlueDeviceType[] values() {
        return (ObricChatTtsIconManager$BlueDeviceType[]) a.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getStr() {
        return this.str;
    }

    public static ObricChatTtsIconManager$BlueDeviceType valueOf(String r1) {
        return (ObricChatTtsIconManager$BlueDeviceType) a.a(ObricChatTtsIconManager$BlueDeviceType.class, r1);
    }

    public ObricChatTtsIconManager$BlueDeviceType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.index = r3;
        this.str = r4;
    }
}
