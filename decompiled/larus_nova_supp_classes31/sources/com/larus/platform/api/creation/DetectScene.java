package com.larus.platform.api.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/platform/api/creation/DetectScene;", "", "<init>", "(Ljava/lang/String;I)V", "DIGITAL_AVTAR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum DetectScene extends Enum<DetectScene> {
    public static final DetectScene DIGITAL_AVTAR = null;
    public static final /* synthetic */ DetectScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DetectScene> getEntries() {
        return b;
    }

    static {
        DetectScene r0 = new DetectScene();
        DIGITAL_AVTAR = r0;
        DetectScene[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public DetectScene() {
        super("DIGITAL_AVTAR", 0);
    }

    public static DetectScene[] values() {
        return (DetectScene[]) a.clone();
    }

    public static DetectScene valueOf(String r1) {
        return (DetectScene) a.a(DetectScene.class, r1);
    }
}
