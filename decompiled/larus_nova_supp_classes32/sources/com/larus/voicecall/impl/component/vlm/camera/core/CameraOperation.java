package com.larus.voicecall.impl.component.vlm.camera.core;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/camera/core/CameraOperation;", NameKeys.UnloadStrategy_No_Strategy, "tag", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "SWITCH_CAMERA", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CameraOperation extends Enum<CameraOperation> {
    public static final CameraOperation SWITCH_CAMERA = null;
    public static final /* synthetic */ CameraOperation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String tag;

    public CameraOperation() {
        super("SWITCH_CAMERA", 0);
        this.tag = "SWITCH_CAMERA";
    }

    public static EnumEntries<CameraOperation> getEntries() {
        return b;
    }

    static {
        CameraOperation r0 = new CameraOperation();
        SWITCH_CAMERA = r0;
        CameraOperation[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public static CameraOperation[] values() {
        return (CameraOperation[]) a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public static CameraOperation valueOf(String r1) {
        return (CameraOperation) a.a(CameraOperation.class, r1);
    }
}
