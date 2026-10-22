package com.larus.voicecall.impl.component.vlm.camera.core;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/camera/core/CameraOpenScene;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "PRIMARY_START", "RECOVERY_RETRY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CameraOpenScene extends Enum<CameraOpenScene> {
    public static final CameraOpenScene PRIMARY_START = null;
    public static final CameraOpenScene RECOVERY_RETRY = null;
    public static final /* synthetic */ CameraOpenScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CameraOpenScene> getEntries() {
        return b;
    }

    static {
        CameraOpenScene r0 = new CameraOpenScene("PRIMARY_START", 0);
        PRIMARY_START = r0;
        CameraOpenScene r1 = new CameraOpenScene("RECOVERY_RETRY", 1);
        RECOVERY_RETRY = r1;
        CameraOpenScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CameraOpenScene[] values() {
        return (CameraOpenScene[]) a.clone();
    }

    public static CameraOpenScene valueOf(String r1) {
        return (CameraOpenScene) a.a(CameraOpenScene.class, r1);
    }

    public CameraOpenScene(String r1, int r2) {
        super(r1, r2);
    }
}
