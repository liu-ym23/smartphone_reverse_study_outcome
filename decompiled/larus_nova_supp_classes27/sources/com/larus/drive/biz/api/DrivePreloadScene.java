package com.larus.drive.biz.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/drive/biz/api/DrivePreloadScene;", "", "<init>", "(Ljava/lang/String;I)V", "OFFICE_SDK_READY", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrivePreloadScene extends Enum<DrivePreloadScene> {
    public static final DrivePreloadScene OFFICE_SDK_READY = null;
    public static final /* synthetic */ DrivePreloadScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DrivePreloadScene> getEntries() {
        return b;
    }

    static {
        DrivePreloadScene r0 = new DrivePreloadScene();
        OFFICE_SDK_READY = r0;
        DrivePreloadScene[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public DrivePreloadScene() {
        super("OFFICE_SDK_READY", 0);
    }

    public static DrivePreloadScene[] values() {
        return (DrivePreloadScene[]) a.clone();
    }

    public static DrivePreloadScene valueOf(String r1) {
        return (DrivePreloadScene) a.a(DrivePreloadScene.class, r1);
    }
}
