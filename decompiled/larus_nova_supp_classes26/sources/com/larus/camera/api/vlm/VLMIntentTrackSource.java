package com.larus.camera.api.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/camera/api/vlm/VLMIntentTrackSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MAIN_CAMERA", "EDU_CAMERA_QA", "EDU_CAMERA_HOMEWORK", "ALBUM", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VLMIntentTrackSource extends Enum<VLMIntentTrackSource> {
    public static final VLMIntentTrackSource ALBUM = null;
    public static final VLMIntentTrackSource EDU_CAMERA_HOMEWORK = null;
    public static final VLMIntentTrackSource EDU_CAMERA_QA = null;
    public static final VLMIntentTrackSource MAIN_CAMERA = null;
    public static final /* synthetic */ VLMIntentTrackSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<VLMIntentTrackSource> getEntries() {
        return b;
    }

    static {
        VLMIntentTrackSource r0 = new VLMIntentTrackSource("MAIN_CAMERA", 0, "main_camera");
        MAIN_CAMERA = r0;
        VLMIntentTrackSource r1 = new VLMIntentTrackSource("EDU_CAMERA_QA", 1, "edu_camera_qa");
        EDU_CAMERA_QA = r1;
        VLMIntentTrackSource r2 = new VLMIntentTrackSource("EDU_CAMERA_HOMEWORK", 2, "edu_camera_homework");
        EDU_CAMERA_HOMEWORK = r2;
        VLMIntentTrackSource r4 = new VLMIntentTrackSource("ALBUM", 3, "album");
        ALBUM = r4;
        VLMIntentTrackSource[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static VLMIntentTrackSource[] values() {
        return (VLMIntentTrackSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static VLMIntentTrackSource valueOf(String r1) {
        return (VLMIntentTrackSource) a.a(VLMIntentTrackSource.class, r1);
    }

    public VLMIntentTrackSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
