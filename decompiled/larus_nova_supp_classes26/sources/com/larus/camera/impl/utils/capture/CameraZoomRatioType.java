package com.larus.camera.impl.utils.capture;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/camera/impl/utils/capture/CameraZoomRatioType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SINGLE_ZOOM_RATIO", "MULTI_ZOOM_RATIO", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CameraZoomRatioType extends Enum<CameraZoomRatioType> {
    public static final CameraZoomRatioType MULTI_ZOOM_RATIO = null;
    public static final CameraZoomRatioType SINGLE_ZOOM_RATIO = null;
    public static final /* synthetic */ CameraZoomRatioType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<CameraZoomRatioType> getEntries() {
        return b;
    }

    static {
        CameraZoomRatioType r0 = new CameraZoomRatioType("SINGLE_ZOOM_RATIO", 0, 1);
        SINGLE_ZOOM_RATIO = r0;
        CameraZoomRatioType r1 = new CameraZoomRatioType("MULTI_ZOOM_RATIO", 1, 2);
        MULTI_ZOOM_RATIO = r1;
        CameraZoomRatioType[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static CameraZoomRatioType[] values() {
        return (CameraZoomRatioType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static CameraZoomRatioType valueOf(String r1) {
        return (CameraZoomRatioType) a.a(CameraZoomRatioType.class, r1);
    }

    public CameraZoomRatioType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
